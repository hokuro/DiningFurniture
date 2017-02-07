package mod.drf.foods.entity;

import java.util.Iterator;
import java.util.List;

import io.netty.buffer.ByteBuf;
import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.Item.ItemFoods.EnumIceFlavor;
import mod.drf.foods.Item.ItemIceCream;
import mod.drf.furniture.entity.EntityChairZabuton;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.stats.StatList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityIceCream extends Entity implements IEntityAdditionalSpawnData, IProjectile {

	public static final String NAME = "EntityIceCream";
	public static final int LIMIT_TIME = 12000;

	private static final DataParameter<Boolean> DISPENCE = EntityDataManager.<Boolean>createKey(EntityChairZabuton.class, DataSerializers.BOOLEAN);
	private int flavor;
	private int timelimit;
	private ItemStack ice;
	public boolean isDispensed;

	protected double velX;
	protected double velY;
	protected double velZ;

	protected double zabutonX;
	protected double zabutonY;
	protected double zabutonZ;


	protected double zabutonYaw;
	protected double zabutonPitch;

	public byte color;

	protected int posIncrements;

	public EntityIceCream(World worldIn) {
		super(worldIn);
		this.preventEntitySpawning = true;
		setSize(0.81F,0.2F);

		timelimit = LIMIT_TIME;
		flavor = 0;
		isDispensed = false;
	}

	public EntityIceCream(World world, BlockPos blockpos, int itemDamage) {
		this(world);
		flavor = itemDamage;
		setPositionAndRotation(blockpos.getX()+0.5f,blockpos.getY(),blockpos.getZ()+0.5f,0F,0F);
		motionX = 0.0D;
		motionY = 0.0D;
		motionZ = 0.0D;
		ice = new ItemStack(ItemFoods.item_icecream,1,flavor);
	}

	public EnumIceFlavor getFlavor(){
		return EnumIceFlavor.getValue(flavor);
	}

	public int countdown(){
		return timelimit;
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
	public void writeSpawnData(ByteBuf data) {
		data.writeInt(flavor);
		data.writeInt(timelimit);
		data.writeFloat(rotationYaw);
	}
	@Override
	public void readSpawnData(ByteBuf data) {
		flavor = data.readInt();
		timelimit = data.readInt();
		setRotation(data.readFloat(), 0.0F);
	}

	@Override
	protected void entityInit() {
		this.dataWatcher.register(DISPENCE, isDispensed);
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
    protected void setSize(float width, float height)
    {
		super.setSize(width/2, height/2);
    }

	@Override
	public boolean handleWaterMovement() {
		// 独自の水没判定
		AxisAlignedBB  bbbox = getEntityBoundingBox();
		StructureBoundingBox box = new StructureBoundingBox((int)bbbox.minX, (int)bbbox.minY,(int)bbbox.minZ,(int)bbbox.maxX+1,(int)bbbox.maxY+1,(int)bbbox.maxZ+1);
		if (!worldObj.isAreaLoaded(box)) {
			return false;
		} else {
			boolean ret = false;

			for (int x = box.minX; x < box.maxX; ++x) {
				for (int y = box.minY; y < box.maxY; ++y) {
					for (int z = box.minZ; z < box.maxZ; ++z) {
						Block blk = worldObj.getBlockState(new BlockPos(x,y,z)).getBlock();
						if (blk != null && blk.getMaterial(null) == Material.water) {
							inWater = true;
							double var16 = (double)((float)(y + 1) - BlockLiquid.getLiquidHeightPercent(blk.getMetaFromState(worldObj.getBlockState(new BlockPos(x, y, z)))));
							if ((double)box.maxY >= var16) {
								ret = true;
							}
						} else {
							inWater = false;
						}
					}
				}
			}
			return ret;
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
			dropItem();
			setDead();
		} else {
//			// そのほかからなら、ダメージ、体力がなくなったら消滅
//			health -= pDammage;
//			if(health <= 0) {
//				setDead();
//			}
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
		if (timelimit > 0){
			boolean flagMelt = true;
			BlockPos pos = new BlockPos(this.posX,this.posY,this.posZ);
			for ( int x = -1; x <= 1 && flagMelt; x++){
				for (int y = -1; y <= 1 && flagMelt; y++){
					for ( int z = -1; z <= 1 && flagMelt; z++){
						IBlockState state =  this.worldObj.getBlockState(pos.add(x,y,z));
						if ( state.getMaterial() == Material.ice || state.getBlock() == Blocks.packed_ice || state.getBlock() == Blocks.frosted_ice){
							flagMelt = false;
						}
					}
				}
			}
			if (flagMelt){
				BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(pos);
				int dec = 2;
				float temp = biome.getTemperature();
				if (temp > 0.9){
					dec = 4;
				}else if(temp > 0 && temp < 0.4){
					dec = 1;
				}else if (temp <= 0){
					dec = 0;
				}
				timelimit -=dec;
			}
		}

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
			//List<Entity> var16 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(0.17D, 0.0D, 0.17D));
			List<Entity> var16 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(0.0D, 1.0D, 0.0D));
			if (var16 != null && !var16.isEmpty()) {
				Iterator var28 = var16.iterator();
				while (var28.hasNext()) {
					Entity var18 = (Entity)var28.next();
					if (var18.canBePushed() && !(var18 instanceof EntityChairZabuton)){
						this.applyEntityCollision(var18);
					}
				}
			}
			if (inWater){
				// 水にぬれるとアイテム化
				dropItem();
				this.setDead();
			}
		}

	}

	public void setEntityLivingAge(EntityLivingBase entity, int a)
	{
		ObfuscationReflectionHelper.setPrivateValue(EntityLivingBase.class, entity, a, "field_70708_bq","entityAge");
	}

	@Override
	public boolean processInitialInteract(EntityPlayer entityplayer, ItemStack stack, EnumHand hand){
		if (!this.worldObj.isRemote){
			onEat(entityplayer);
		}
		return true;
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tagCompund) {
		flavor = tagCompund.getByte("Flavor");
		timelimit = tagCompund.getShort("Limit");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tagCompound) {
		tagCompound.setInteger("Flavor",flavor);
		tagCompound.setInteger("Limit",timelimit);
	}


	private void onEat(EntityPlayer entityplayer){
		if (entityplayer != null){
			if (ice == null){
				ice = new ItemStack(ItemFoods.item_icecream,1,flavor);
			}

			EnumIceFlavor flv = EnumIceFlavor.getValue(flavor);
			ItemIceCream iIce = (ItemIceCream)ice.getItem();
			iIce.setHealAmount(flv.getFoodLevel());
			iIce.setSaturation(flv.getFoodSaturation());

            entityplayer.getFoodStats().addStats(iIce, ice);
            this.worldObj.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.entity_player_burp, SoundCategory.PLAYERS, 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
            entityplayer.addStat(StatList.func_188057_b(iIce));
            timelimit = 0;
            dropItem();
            this.setDead();
		}
	}

	private void dropItem(){
		if (timelimit > 0){
			entityDropItem(new ItemStack(ItemFoods.item_icecream, 1, flavor), 0.0F);
		}else{
			entityDropItem(new ItemStack(Items.glass_bottle,1),0.0F);
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////
	// Dispenser

	@Override
	public void setThrowableHeading(double x, double y, double z, float velocity, float inaccuracy) {
		float f2 = MathHelper.sqrt_double(x*x+y*y+z*z);
		y /= f2;
		x /= f2;
		z /= f2;

		x += rand.nextGaussian() * 0.0074999998323619366D * (double)inaccuracy;
		y += rand.nextGaussian() * 0.0074999998323619366D * (double)inaccuracy;
		z += rand.nextGaussian() * 0.0074999998323619366D * (double)inaccuracy;

		x *= velocity;
		y *= velocity;
		z *= velocity;

		motionX = x;
		motionY = y;
		motionZ = z;

		float f3 = MathHelper.sqrt_double(x*x+z*z);
		prevRotationYaw = rotationYaw = (float)((Math.atan2(x, z) * 180D) / 3.1415927410125732D);
		prevRotationPitch = rotationPitch = (float)((Math.atan2(y, f3) * 180D) / 3.1415927410125732D);
		setDispensed(true);
	}

	public void setDispensed(boolean isDispensed) {
		this.dataWatcher.set(DISPENCE, isDispensed);
	}

	// 射出判定
	public boolean isDispensed() {
		try{
			return dataWatcher.get(DISPENCE);
		}catch(Exception ex){
			return false;
		}
	}
}
