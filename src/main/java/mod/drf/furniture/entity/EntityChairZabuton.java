package mod.drf.furniture.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.netty.buffer.ByteBuf;
import mod.drf.furniture.item.ItemFurniture;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityChairZabuton extends Entity  implements IProjectile, IEntityAdditionalSpawnData{
	public static final String NAME="zabuton";
	private static final DataParameter<Boolean> DISPENCE = EntityDataManager.<Boolean>createKey(EntityChairZabuton.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> RIDEENTITY = EntityDataManager.<Integer>createKey(EntityChairZabuton.class, DataSerializers.VARINT);


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
	public byte color;

	protected int posIncrements;


	public EntityChairZabuton(World worldIn) {
		super(worldIn);
		this.preventEntitySpawning = true;
		setSize(0.81F,0.2F);
		health = 20;
		isDispensed = false;
		color = 0;
	}

	public EntityChairZabuton(World worldIn, byte color){
		this(worldIn);
		this.color = color;
	}

	public EntityChairZabuton(World worldIn, double x, double y, double z, byte color){
		this(worldIn,color);
		setPositionAndRotation(x,y,z,0F,0F);
		motionX = 0.0D;
		motionY = 0.0D;
		motionZ = 0.0D;
	}

	public void setThrowableHeading(double px, double py, double pz, float f, float f1){
		float f2 = MathHelper.sqrt_double(px*px+py*py+pz*pz);
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

		float f3 = MathHelper.sqrt_double(px*px+pz*pz);
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
	protected void entityInit() {
		// TODO 自動生成されたメソッド・スタブ
		this.dataWatcher.register(DISPENCE, isDispensed);
		this.dataWatcher.register(RIDEENTITY, 0);
//		dataWatcher.addObject(17,  new Byte((byte)(isDispensed ? 0x01: 0x00)));
//		dataWatcher.addObject(18,  Integer.valueOf(0));
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity par1Entity) {
		return par1Entity.getEntityBoundingBox();
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox() {
		return this.getEntityBoundingBox();
	}

	@Override
	public boolean canBePushed() {
		return true;
	}



	@Override
	protected void readEntityFromNBT(NBTTagCompound tagCompund) {
		// TODO 自動生成されたメソッド・スタブ
		color = tagCompund.getByte("Color");
		health = tagCompund.getShort("Health");
	}


	@Override
	protected void writeEntityToNBT(NBTTagCompound tagCompound) {
		// TODO 自動生成されたメソッド・スタブ
		tagCompound.setByte("Color", (byte)(color & 0x0f));
		tagCompound.setShort("Health", (byte)health);
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
		AxisAlignedBB  bbbox = getEntityBoundingBox();
		StructureBoundingBox box = new StructureBoundingBox((int)bbbox.minX, (int)bbbox.minY,(int)bbbox.minZ,(int)bbbox.maxX+1,(int)bbbox.maxY+1,(int)bbbox.maxZ+1);
		if (!worldObj.isAreaLoaded(box)) {
			return false;
		} else {
			boolean var10 = false;

			for (int x = box.minX; x < box.maxX; ++x) {
				for (int y = box.minY; y < box.maxY; ++y) {
					for (int z = box.minZ; z < box.maxZ; ++z) {
						Block blk = worldObj.getBlockState(new BlockPos(x,y,z)).getBlock();
						if (blk != null && blk.getMaterial(null) == Material.water) {
							inWater = true;
							double var16 = (double)((float)(y + 1) - BlockLiquid.getLiquidHeightPercent(blk.getMetaFromState(worldObj.getBlockState(new BlockPos(x, y, z)))));
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
		Entity entity = damagesource.getEntity();
		if(worldObj.isRemote || isDead) {
			return true;
		}
		setBeenAttacked();
		if (entity instanceof EntityPlayer) {
			// プレイヤーからの攻撃ならアイテムドロップ
			entityDropItem(new ItemStack(ItemFurniture.item_zabuton, 1, color), 0.0F);
			setDead();
		} else {
			// そのほかからなら、ダメージ、体力がなくなったら消滅
			health -= pDammage;
			if(health <= 0) {
				setDead();
			}
		}
		// エンティティが消ええた
		if (isDead) {
			// 座っているやつをどける
			for(Entity ent : this.getPassengers()){
				ent.dismountRidingEntity();	// 立ち上がらせる
				setRiddenByEntityID(null);  // 座っているエンティティのIDを設定
				//riddenByEntity.mountEntity(null);
				//setRiddenByEntityID(riddenByEntity);
			}
		}
		return true;
	}

	@Override
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

	@Override
	@ SideOnly(Side.CLIENT)
    public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_)
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
	public void onUpdate() {
		super.onUpdate();

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

		if (this.worldObj.isRemote) {
			// Client
			if (this.posIncrements > 0) {
				var6 = this.posX + (this.zabutonX - this.posX) / (double)this.posIncrements;
				var8 = this.posY + (this.zabutonY - this.posY) / (double)this.posIncrements;
				var26 = this.posZ + (this.zabutonZ - this.posZ) / (double)this.posIncrements;
				var12 = MathHelper.wrapAngleTo180_double(this.zabutonYaw - (double)this.rotationYaw);
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
				this.moveEntity(this.motionX, this.motionY, this.motionZ);

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
			this.moveEntity(this.motionX, this.motionY, this.motionZ);

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

			double var14 = MathHelper.wrapAngleTo180_double(var8 - (double)this.rotationYaw);
			if (var14 > 20.0D) {
				var14 = 20.0D;
			}
			if (var14 < -20.0D) {
				var14 = -20.0D;
			}

			this.rotationYaw = (float)((double)this.rotationYaw + var14);
			this.setRotation(this.rotationYaw, this.rotationPitch);


			// 当たり判定
			List<Entity> var16 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(0.17D, 0.0D, 0.17D));
			if (var16 != null && !var16.isEmpty()) {
				Iterator var28 = var16.iterator();
				while (var28.hasNext()) {
					Entity var18 = (Entity)var28.next();
					if (var18 != ridden && var18.canBePushed() && !(var18 instanceof EntityChairZabuton)){
				//	if (var18 != this.riddenByEntity && var18.canBePushed() && var18 instanceof EntityChairZabuton) {
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
			if (ridden.isDead) {
				// 着座対象が死んだら無人化
				ridden.dismountRidingEntity();
				//this.removePassenger(ridden);
				setRiddenByEntityID(null);
			}
			else if (inWater) {
				// ぬれた座布団はひゃぁってなる
				ridden.dismountRidingEntity();
				setRiddenByEntityID(null);
			}
		}
	}

	public void setEntityLivingAge(EntityLivingBase entity, int a)
	{
		ObfuscationReflectionHelper.setPrivateValue(EntityLivingBase.class, entity, a, "field_70708_bq","entityAge");
	}

	@Override
	public void applyEntityCollision(Entity entity) {
		// 吸着判定
		if (worldObj.isRemote) {
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
	//public boolean interactFirst(EntityPlayer entityplayer) {
	public boolean processInitialInteract(EntityPlayer entityplayer, ItemStack stack, EnumHand hand){
		// ラーイド・オン！
		if (!this.getPassengers().isEmpty()){// && (riddenByEntity instanceof EntityPlayer) && riddenByEntity != entityplayer) {
			// 誰か座ってるよ
			return true;
		}
		if (!worldObj.isRemote) {
			entityplayer.startRiding(this);
		}
		return true;
	}



	// 射出判定
	public boolean isDispensed() {
		try{
			return dataWatcher.get(DISPENCE);
		}catch(Exception ex){
			return false;
		}
	}

	public void setDispensed(boolean isDispensed) {
		this.dataWatcher.set(DISPENCE, isDispensed);
	}

	// クライアント側補正用
	public int getRiddenByEntityID() {
		int li = dataWatcher.get(RIDEENTITY);
		return li;
	}

	public Entity getRiddenByEntity() {
		return ((WorldClient)worldObj).getEntityByID(getRiddenByEntityID());
	}

	public void setRiddenByEntityID(Entity pentity) {
		dataWatcher.set(RIDEENTITY, pentity==null?0:pentity.getEntityId());
		///dataWatcher.updateObject(18, Integer.valueOf(pentity == null ? 0 : pentity.getEntityId()));
	}

	@Override
	public void writeSpawnData(ByteBuf data) {
		data.writeByte(color);
		data.writeFloat(rotationYaw);
	}
	@Override
	public void readSpawnData(ByteBuf data) {
		color = data.readByte();
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
}
