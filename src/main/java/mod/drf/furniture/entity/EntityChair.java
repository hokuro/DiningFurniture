package mod.drf.furniture.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowingFluid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public abstract class  EntityChair extends Entity  implements IProjectile, IEntityAdditionalSpawnData{
	private static final DataParameter<Boolean> DISPENCE = EntityDataManager.<Boolean>createKey(EntityZabuton.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> RIDEENTITY = EntityDataManager.<Integer>createKey(EntityZabuton.class, DataSerializers.VARINT);
    private ItemStack entityItem;

	protected double zabutonX;
	protected double zabutonY;
	protected double zabutonZ;

	protected double zabutonYaw;
	protected double zabutonPitch;

	protected double velX;
	protected double velY;
	protected double velZ;
	protected int health;

	public boolean isDispensed;
	protected int posIncrements;

	public EntityChair(EntityType<?> etype, World worldIn){
		super(etype, worldIn);
		this.preventEntitySpawning = true;
		setSize(0.81F,0.2F);
		health = 20;
		isDispensed = false;
		entityItem = ItemStack.EMPTY;
	}

	public EntityChair(EntityType<?> etype, World worldIn, ItemStack item) {
		this(etype, worldIn);
		entityItem = item.copy();
		entityItem.setCount(1);
	}

	public EntityChair(EntityType<?> etype, World worldIn, double x, double y, double z, ItemStack item){
		this(etype, worldIn, item);
		setPositionAndRotation(x,y,z,0F,0F);
		motionX = 0.0D;
		motionY = 0.0D;
		motionZ = 0.0D;
	}

	public void shoot(double px, double py, double pz, float f, float f1){
		float f2 = MathHelper.sqrt(px*px+py*py+pz*pz);
		py /= f2;
		px /= f2;
		pz /= f2;

		px += rand.nextGaussian() * 0.0074999998323619366D * (double)f1;
		py += rand.nextGaussian() * 0.0074999998323619366D * (double)f1;
		pz += rand.nextGaussian() * 0.0074999998323619366D * (double)f1;

		px *= f;
		py *= f;
		pz *= f;

		motionX = px;
		motionY = py;
		motionZ = pz;

		float f3 = MathHelper.sqrt(px*px+pz*pz);
		prevRotationYaw = rotationYaw = (float)((Math.atan2(px, pz) * 180D) / 3.1415927410125732D);
		prevRotationPitch = rotationPitch = (float)((Math.atan2(py, f3) * 180D) / 3.1415927410125732D);
		setDispensed(true);
	}

	@Override
	protected boolean canTriggerWalking(){
		return false;
	}

	@Override
	public double getYOffset(){
		return 0.0F;
	}


	@Override
	protected void registerData() {
		this.dataManager.register(DISPENCE, isDispensed);
		this.dataManager.register(RIDEENTITY, 0);
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity par1Entity) {
		return par1Entity.getBoundingBox();
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox() {
		return this.getBoundingBox();
	}

	@Override
	public boolean canBePushed() {
		return true;
	}


	@Override
	protected void readAdditional(NBTTagCompound tagCompund) {
		health = tagCompund.getShort("Health");

		if (tagCompund.getBoolean("hasItem")){
			entityItem = ItemStack.read(tagCompund);
		}
	}


	@Override
	protected void writeAdditional(NBTTagCompound tagCompound) {
		tagCompound.setShort("Health", (byte)health);
		if (!entityItem.isEmpty()){
			tagCompound.setBoolean("hasItem", true);
			entityItem.write(tagCompound);
		}
	}

	@Override
	public double getMountedYOffset() {
		for (Entity et : this.getPassengers()){
			if (et instanceof EntitySpider) {
				return (double)height * 0.0D - 0.1D;
			}
			if (	et instanceof EntityZombie ||
					et instanceof EntityEnderman) {
				return (double)height * 0.0D - 0.4D;
			}
		}

		return (double)height * 0.0D + 0.1D;
	}

	@Override
	public boolean handleWaterMovement() {
		// 独自の水没判定
		AxisAlignedBB  bbbox = this.getBoundingBox();
		MutableBoundingBox box = new MutableBoundingBox((int)bbbox.minX, (int)bbbox.minY,(int)bbbox.minZ,(int)bbbox.maxX+1,(int)bbbox.maxY+1,(int)bbbox.maxZ+1);
		if (!world.isAreaLoaded(box)) {
			return false;
		} else {
			boolean var10 = false;

			for (int x = box.minX; x < box.maxX; ++x) {
				for (int y = box.minY; y < box.maxY; ++y) {
					for (int z = box.minZ; z < box.maxZ; ++z) {
						IBlockState state = world.getBlockState(new BlockPos(x,y,z));
						Block blk = state.getBlock();
						if (blk != null && blk.getMaterial(null) == Material.WATER) {
							inWater = true;
							int level = (int)state.getValues().get(BlockFlowingFluid.LEVEL);
							if (level < 8) {level = 0;}
							double var16 = (double)((float)(y + 1) - (level+1)/9.0F);
							if ((double)box.maxY >= var16) {
								var10 = true;
							}
						} else {
							inWater = false;
						}
					}
				}
			}
			return var10;
		}
	}

	@Override
	public boolean attackEntityFrom(DamageSource damagesource, float pDammage) {
		// 攻撃したもの
		Entity entity = damagesource.getTrueSource();
		if(world.isRemote || !isAlive()) {
			return true;
		}
		markVelocityChanged();
		if (entity instanceof EntityPlayer) {
			// プレイヤーからの攻撃ならアイテムドロップ
			entityDropItem(entityItem.copy(), 0.0F);
			remove();
		} else {
			// そのほかからなら、ダメージ、体力がなくなったら消滅
			health -= pDammage;
			if(health <= 0) {
				remove();
			}
		}
		// エンティティが消ええた
		if (!isAlive()) {
			// 座っているやつをどける
			for(Entity ent : this.getPassengers()){
				ent.stopRiding();	// 立ち上がらせる
				setRiddenByEntityID(null);  // 座っているエンティティのIDを設定
			}
		}
		return true;
	}

	@Override
	public boolean canBeCollidedWith() {
		return isAlive();
	}

	@Override
	@OnlyIn(Dist.CLIENT)
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_)
     {
		this.setPosition(x, y, z);
		this.setRotation(yaw, pitch);
	}

	@Override
	public void setVelocity(double d, double d1, double d2) {
		velX = motionX = d;
		velY = motionY = d1;
		velZ = motionZ = d2;
	}

	@Override
	public void tick() {
		super.tick();

		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		// ボートの判定のコピー
		// ボートは直接サーバーと位置情報を同期させているわけではなく、予測位置計算系に値を渡している。
		// 因みにボートの座標同期間隔は結構長めなので動きが変。


		double var6;
		double var8;
		double var12;
		double var26;
		double var24 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
		// 座ってるモブを取り出す
		Entity ridden = this.riddenentity();

		if (this.world.isRemote) {
			// Client
			if (this.posIncrements > 0) {
				var6 = this.posX + (this.zabutonX - this.posX) / (double)this.posIncrements;
				var8 = this.posY + (this.zabutonY - this.posY) / (double)this.posIncrements;
				var26 = this.posZ + (this.zabutonZ - this.posZ) / (double)this.posIncrements;
				var12 = MathHelper.wrapDegrees(this.zabutonYaw - (double)this.rotationYaw);
				this.rotationYaw = (float)((double)this.rotationYaw + var12 / (double)this.posIncrements);
				this.rotationPitch = (float)((double)this.rotationPitch + (this.zabutonPitch - (double)this.rotationPitch) / (double)this.posIncrements);
				--this.posIncrements;
				this.setPosition(var6, var8, var26);
				this.setRotation(this.rotationYaw, this.rotationPitch);
			} else {
				motionY -= 0.08D;
				if (this.onGround) {
					this.motionX *= 0.5D;
					this.motionY *= 0.5D;
					this.motionZ *= 0.5D;
					setDispensed(false);
				}
				this.move(MoverType.PLAYER, this.motionX, this.motionY, this.motionZ);

				this.motionX *= 0.9900000095367432D;
				this.motionY *= 0.949999988079071D;
				this.motionZ *= 0.9900000095367432D;
			}
		} else {
			// Server
			// 落下
			motionY -= 0.08D;

			// 搭乗者によるベクトル操作
			if (ridden != null && ridden instanceof EntityPlayer) {
				this.motionX += ridden.motionX * 0.2D;
				this.motionZ += ridden.motionZ * 0.2D;
			}

			// 最高速度判定
			Double lmaxspeed = isDispensed() ? 10.0D : 0.35D;
			var6 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
			if (var6 > lmaxspeed) {
				var8 = lmaxspeed / var6;
				this.motionX *= var8;
				this.motionZ *= var8;
				var6 = lmaxspeed;
			}
			if (this.onGround) {
				this.motionX *= 0.5D;
				this.motionY *= 0.5D;
				this.motionZ *= 0.5D;
				setDispensed(false);
				// setVelocityの呼ばれる回数が少なくて変な動きをするので対策
//                this.velocityChanged = true;
			}
			this.move(MoverType.PLAYER, this.motionX, this.motionY, this.motionZ);

			this.motionX *= 0.9900000095367432D;
			this.motionY *= 0.949999988079071D;
			this.motionZ *= 0.9900000095367432D;

			// ヘッディング
			this.rotationPitch = 0.0F;
			var8 = (double)this.rotationYaw;
			var26 = this.prevPosX - this.posX;
			var12 = this.prevPosZ - this.posZ;

			if (var26 * var26 + var12 * var12 > 0.001D) {
				var8 = (double)((float)(Math.atan2(var12, var26) * 180.0D / Math.PI));
			}

			double var14 = MathHelper.wrapDegrees(var8 - (double)this.rotationYaw);
			if (var14 > 20.0D) {
				var14 = 20.0D;
			}
			if (var14 < -20.0D) {
				var14 = -20.0D;
			}

			this.rotationYaw = (float)((double)this.rotationYaw + var14);
			this.setRotation(this.rotationYaw, this.rotationPitch);


			// 当たり判定

			List<Entity> var16 = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getBoundingBox().expand(0.5D, 0.5D, 0.5D).expand(-0.5D, -0.5D, -0.5D));
			if (var16 != null && !var16.isEmpty()) {
				Iterator var28 = var16.iterator();
				while (var28.hasNext()) {
					Entity var18 = (Entity)var28.next();
					if (var18 != ridden && var18.canBePushed() && !(var18 instanceof EntityChair)){
						this.applyEntityCollision(var18);
					}
				}
			}
		}
		if (ridden != null) {
			if (ridden instanceof EntityMob) {
				// 座ってる間は消滅させない
				setEntityLivingAge((EntityLivingBase)ridden, 0);
			}
			if (!ridden.isAlive()) {
				// 着座対象が死んだら無人化
				ridden.stopRiding();
				setRiddenByEntityID(null);
			}
			else if (inWater) {
				// ぬれた座布団はひゃぁってなる
				ridden.stopRiding();
				setRiddenByEntityID(null);
			}
		}
	}

	public void setEntityLivingAge(EntityLivingBase entity, int a)
	{
		entity.deathTime = 0;
		//ObfuscationReflectionHelper.getPrivateValue(EntityLivingBase.class, entity, a, "field_70708_bq","entityAge");
	}

	@Override
	public void applyEntityCollision(Entity entity) {
		// 吸着判定
		if (world.isRemote) {
			return;
		}
		Entity ridden = riddenentity();
		// すでにすわってる？
		if (ridden == entity) {
			return;
		}
		if ((entity instanceof EntityLiving) && !(entity instanceof EntityPlayer) && ridden == null && entity.getPassengers().isEmpty()) {
			entity.startRiding(this);
			setRiddenByEntityID(entity);
		}
		super.applyEntityCollision(entity);
	}

	@Override
	public Entity getLowestRidingEntity(){
		//EntityVillager x;
		return null;
	}

	@Override
	public boolean processInitialInteract(EntityPlayer entityplayer, EnumHand hand){
		// ラーイド・オン！
		if (!this.getPassengers().isEmpty()){
			// 誰か座ってるよ
			return true;
		}
		if (!world.isRemote) {
			entityplayer.startRiding(this);
		}
		return true;
	}

	// 射出判定
	public boolean isDispensed() {
		try{
			return dataManager.get(DISPENCE);
		}catch(Exception ex){
			return false;
		}
	}

	public void setDispensed(boolean isDispensed) {
		this.dataManager.set(DISPENCE, isDispensed);
	}

	// クライアント側補正用
	public int getRiddenByEntityID() {
		int li = dataManager.get(RIDEENTITY);
		return li;
	}

	public Entity getRiddenByEntity() {
		return ((WorldClient)world).getEntityByID(getRiddenByEntityID());
	}

	public void setRiddenByEntityID(Entity pentity) {
		dataManager.set(RIDEENTITY, pentity==null?0:pentity.getEntityId());
	}

	@Override
	public void writeSpawnData(PacketBuffer data) {
		data.writeFloat(rotationYaw);
	}
	@Override
	public void readSpawnData(PacketBuffer data) {
		setRotation(data.readFloat(), 0.0F);
	}

	public Entity riddenentity(){
		List<Entity> ret = new ArrayList<Entity>();
		for (Entity ent : this.getPassengers()){
			ret.add(ent);
		}
		if (ret.isEmpty()){return null;}

		// 座布団に座れるのは一人だけなので、先頭の実を返す。
		return ret.get(0);
	}

	public void setParameter(int hp, float size_x, float size_y){
		health = hp;
		setSize(size_x, size_y);
	}

	public abstract ResourceLocation getEntityTexture(EntityChair chair);
	public abstract void renderChairModel();
}
