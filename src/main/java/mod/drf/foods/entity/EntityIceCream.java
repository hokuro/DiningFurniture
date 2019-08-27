package mod.drf.foods.entity;

import java.util.Iterator;
import java.util.List;

import mod.drf.config.ConfigValue;
import mod.drf.core.Mod_DiningFurniture;
import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.Item.ItemFoods.EnumIceFlavor;
import mod.drf.foods.Item.ItemIceCream;
import mod.drf.util.ModUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowingFluid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityIceCream extends Entity implements IEntityAdditionalSpawnData, IProjectile {

	public static final String NAME = "entityicecream";
	public static final int LIMIT_TIME = 12000;

	private static final DataParameter<Boolean> DISPENCE = EntityDataManager.<Boolean>createKey(EntityIceCream.class, DataSerializers.BOOLEAN);
	private EnumIceFlavor flavor;
	private boolean inCookie;
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
		super(Mod_DiningFurniture.RegistryEvents.ICECREAM, worldIn);
		this.preventEntitySpawning = true;
		setSize(0.81F,0.2F);

		timelimit = ConfigValue.icecream.MelltingTime();
		flavor = EnumIceFlavor.ICE_VANILA;
		isDispensed = false;
	}

	public EntityIceCream(World world, BlockPos blockpos, EnumIceFlavor itemDamage, boolean cookie) {
		this(world);
		flavor = itemDamage;
		inCookie = cookie;
		setPositionAndRotation(blockpos.getX()+0.5f,blockpos.getY(),blockpos.getZ()+0.5f,0F,0F);
		motionX = 0.0D;
		motionY = 0.0D;
		motionZ = 0.0D;
		ice = ItemFoods.getIceCream(flavor, inCookie);
	}

	public EnumIceFlavor getFlavor(){
		return flavor;
	}

	public boolean isInCookie(){
		return this.inCookie;
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
	public void writeSpawnData(PacketBuffer data) {
		data.writeInt(flavor.getDamage());
		data.writeInt(timelimit);
		data.writeFloat(rotationYaw);
		data.writeBoolean(inCookie);
	}

	@Override
	public void readSpawnData(PacketBuffer data) {
		flavor = EnumIceFlavor.getValue(data.readInt());
		timelimit = data.readInt();
		setRotation(data.readFloat(), 0.0F);
		inCookie = data.readBoolean();
	}

	@Override
	protected void registerData() {
		this.dataManager.register(DISPENCE, isDispensed);
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
    protected void setSize(float width, float height)
    {
		super.setSize(width/2, height/2);
    }

	@Override
	public boolean handleWaterMovement() {
		// 独自の水没判定
		AxisAlignedBB  bbbox = this.getBoundingBox();
		MutableBoundingBox box = new MutableBoundingBox((int)bbbox.minX, (int)bbbox.minY,(int)bbbox.minZ,(int)bbbox.maxX+1,(int)bbbox.maxY+1,(int)bbbox.maxZ+1);
		if (!this.world.isAreaLoaded(box)) {
			return false;
		} else {
			boolean ret = false;

			for (int x = box.minX; x < box.maxX; ++x) {
				for (int y = box.minY; y < box.maxY; ++y) {
					for (int z = box.minZ; z < box.maxZ; ++z) {
						IBlockState state =  this.world.getBlockState(new BlockPos(x,y,z));
						Block blk = state.getBlock();
						if (blk != null && blk.getMaterial(null) == Material.WATER) {
							inWater = true;
							int level = (int)state.getValues().get(BlockFlowingFluid.LEVEL);
							if (level < 8) {level = 0;}
							double var16 = (double)((float)(y + 1) - (level+1)/9.0F);
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
		Entity entity = damagesource.getTrueSource();
		if(this.world.isRemote || !this.isAlive()) {
			return true;
		}
		markVelocityChanged();
		if (entity instanceof EntityPlayer) {
			// プレイヤーからの攻撃ならアイテムドロップ
			dropItem();
			remove();
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
		return this.isAlive();
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
		if (timelimit > 0){
			boolean flagMelt = ConfigValue.icecream.MelltingFlag();
			BlockPos pos = new BlockPos(this.posX,this.posY,this.posZ);
			for ( int x = -1; x <= 1 && flagMelt; x++){
				for (int y = -1; y <= 1 && flagMelt; y++){
					for ( int z = -1; z <= 1 && flagMelt; z++){
						IBlockState state =  this.world.getBlockState(pos.add(x,y,z));
						if ( state.getMaterial() == Material.ICE || state.getBlock() == Blocks.PACKED_ICE || state.getBlock() == Blocks.FROSTED_ICE || state.getBlock() == Blocks.BLUE_ICE){
							flagMelt = false;
						}
					}
				}
			}
			if (flagMelt){
				Biome biome = this.world.getBiome(pos);
				int dec = 2;
				float temp = biome.getTemperature(pos);
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
			this.move(MoverType.PLAYER,this.motionX, this.motionY, this.motionZ);

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
			//List<Entity> var16 = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(0.17D, 0.0D, 0.17D));
			List<Entity> var16 = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getBoundingBox().expand(0.0D, 1.0D, 0.0D));
			if (var16 != null && !var16.isEmpty()) {
				Iterator var28 = var16.iterator();
				while (var28.hasNext()) {
					Entity var18 = (Entity)var28.next();
					if (var18.canBePushed() && !(var18 instanceof EntityIceCream)){
						this.applyEntityCollision(var18);
					}
				}
			}
			if (inWater){
				// 水にぬれるとアイテム化
				dropItem();
				this.remove();
			}
		}

	}

//	public void setEntityLivingAge(EntityLivingBase entity, int a)
//	{
//		ObfuscationReflectionHelper.setPrivateValue(EntityLivingBase.class, entity, a, "field_70708_bq","entityAge");
//	}

	@Override
	public boolean processInitialInteract(EntityPlayer entityplayer,  EnumHand hand){
		if (this.timelimit > 0){
			if (ModUtil.compareItemStacks(entityplayer.getHeldItem(hand), new ItemStack(Items.COOKIE))
					&& !inCookie){
				if (!this.world.isRemote){
					entityplayer.getHeldItem(hand).shrink(1);;
					if (entityplayer.getHeldItem(hand).getCount() <= 0){
						entityplayer.setHeldItem(hand, ItemStack.EMPTY);
					}
				}
				inCookie = true;
			}else if (hand == EnumHand.MAIN_HAND){
				if (entityplayer.canEat(ConfigValue.icecream.CanEatAllways())){
					if (!this.world.isRemote){
						ItemIceCream.onEat(ItemFoods.getIceCream(flavor, this.inCookie), this.world, entityplayer);
					}
					this.timelimit = 0;
				}else{
					if (!this.world.isRemote){
						entityplayer.sendStatusMessage(new TextComponentString("Not hungry"),false);
					}
				}
			}
		}else{
			if (!this.world.isRemote){
				if (hand == EnumHand.MAIN_HAND){
					dropItem();
					remove();
				}
			}
		}
		return true;
	}

	@Override
	protected void readAdditional(NBTTagCompound tagCompund) {
		flavor = EnumIceFlavor.getValue(tagCompund.getInt("Flavor"));
		timelimit = tagCompund.getShort("Limit");
		inCookie = tagCompund.getBoolean("InCookie");
	}

	@Override
	protected void writeAdditional(NBTTagCompound tagCompound) {
		tagCompound.setInt("Flavor",flavor.getDamage());
		tagCompound.setInt("Limit",timelimit);
		tagCompound.setBoolean("InCookie", inCookie);
	}

	private void dropItem(){
		if (timelimit > 0){
			entityDropItem(ItemFoods.getIceCream(flavor, this.inCookie),0.0F);
		}else{
			entityDropItem(new ItemStack(Items.GLASS_BOTTLE,1),0.0F);
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////
	// Dispenser
	public void setDispensed(boolean isDispensed) {
		this.dataManager.set(DISPENCE, isDispensed);
	}

	// 射出判定
	public boolean isDispensed() {
		try{
			return dataManager.get(DISPENCE);
		}catch(Exception ex){
			return false;
		}
	}

	@Override
	public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
		float f2 = MathHelper.sqrt(x*x+y*y+z*z);
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

		float f3 = MathHelper.sqrt(x*x+z*z);
		prevRotationYaw = rotationYaw = (float)((Math.atan2(x, z) * 180D) / 3.1415927410125732D);
		prevRotationPitch = rotationPitch = (float)((Math.atan2(y, f3) * 180D) / 3.1415927410125732D);
		setDispensed(true);
	}
}
