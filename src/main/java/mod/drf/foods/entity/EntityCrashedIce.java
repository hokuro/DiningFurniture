package mod.drf.foods.entity;

import java.util.Iterator;
import java.util.List;

import io.netty.buffer.ByteBuf;
import mod.drf.config.ConfigValue;
import mod.drf.foods.Item.ItemCrashedIce;
import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.Item.ItemFoods.EnumFlapeSyrup;
import mod.drf.util.ModUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityCrashedIce extends Entity implements IEntityAdditionalSpawnData, IProjectile {

	public static final String NAME = "EntityCrashedIce";
	public static final int LIMIT_TIME = 12000;

	private static final DataParameter<Boolean> DISPENCE = EntityDataManager.<Boolean>createKey(EntityCrashedIce.class, DataSerializers.BOOLEAN);
	private int flavor;
	private boolean isMillk;
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

	public EntityCrashedIce(World worldIn) {
		super(worldIn);
		this.preventEntitySpawning = true;
		setSize(0.81F,0.2F);

		timelimit = ConfigValue.Setting_CrashedIce.melltingTime;
		flavor = 0;
		isDispensed = false;
	}

	public EntityCrashedIce(World world, BlockPos blockpos, int itemDamage, boolean millk) {
		this(world);
		flavor = itemDamage;
		isMillk = millk;
		setPositionAndRotation(blockpos.getX()+0.5f,blockpos.getY(),blockpos.getZ()+0.5f,0F,0F);
		motionX = 0.0D;
		motionY = 0.0D;
		motionZ = 0.0D;
		ice = new ItemStack(ItemFoods.item_crashedice,1,flavor);
	}

	public EnumFlapeSyrup getFlavor(){
		return EnumFlapeSyrup.getValue(flavor);
	}

	public boolean isMillk() {
		return isMillk;
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
		data.writeBoolean(isMillk);
	}
	@Override
	public void readSpawnData(ByteBuf data) {
		flavor = data.readInt();
		timelimit = data.readInt();
		setRotation(data.readFloat(), 0.0F);
		isMillk = data.readBoolean();
	}

	@Override
	protected void entityInit() {
		this.dataManager.register(DISPENCE, isDispensed);
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
	public void move(MoverType type, double x, double y, double z){
	}

	@Override
	public boolean canBePushed() {
		return true;
	}

	@Override
    protected void setSize(float width, float height)
    {
		super.setSize(width, height);
    }

	@Override
	public boolean handleWaterMovement() {
		// 独自の水没判定
		AxisAlignedBB  bbbox = getEntityBoundingBox();
		StructureBoundingBox box = new StructureBoundingBox((int)bbbox.minX, (int)bbbox.minY,(int)bbbox.minZ,(int)bbbox.maxX+1,(int)bbbox.maxY+1,(int)bbbox.maxZ+1);
		if (!world.isAreaLoaded(box)) {
			return false;
		} else {
			boolean ret = false;

			for (int x = box.minX; x < box.maxX; ++x) {
				for (int y = box.minY; y < box.maxY; ++y) {
					for (int z = box.minZ; z < box.maxZ; ++z) {
						Block blk = world.getBlockState(new BlockPos(x,y,z)).getBlock();
						if (blk != null && blk.getMaterial(null) == Material.WATER) {
							inWater = true;
							double var16 = (double)((float)(y + 1) - BlockLiquid.getLiquidHeightPercent(blk.getMetaFromState(world.getBlockState(new BlockPos(x, y, z)))));
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
		if(world.isRemote || isDead) {
			return true;
		}
		markVelocityChanged();
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
			boolean flagMelt = ConfigValue.Setting_CrashedIce.melltingFlag;
			BlockPos pos = new BlockPos(this.posX,this.posY,this.posZ);

			// 周囲に氷があるか確認
			for ( int x = -1; x <= 1 && flagMelt; x++){
				for (int y = -1; y <= 1 && flagMelt; y++){
					for ( int z = -1; z <= 1 && flagMelt; z++){
						IBlockState state =  this.world.getBlockState(pos.add(x,y,z));
						if ( state.getMaterial() == Material.ICE || state.getBlock() == Blocks.PACKED_ICE || state.getBlock() == Blocks.FROSTED_ICE){
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
				// 移動
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
			List<Entity> var16 = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(0.0D, 1.0D, 0.0D));
			if (var16 != null && !var16.isEmpty()) {
				Iterator var28 = var16.iterator();
				while (var28.hasNext()) {
					Entity var18 = (Entity)var28.next();
					if (var18.canBePushed() && !(var18 instanceof EntityCrashedIce)){
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
	public boolean processInitialInteract(EntityPlayer entityplayer, EnumHand hand){

		if (timelimit > 0){
			// 練乳を持っている場合
			if (ModUtil.compareItemStacks(entityplayer.getHeldItem(hand), new ItemStack(ItemFoods.item_syrupmilk)) && !isMillk ){
				// 練乳を所持しており、かき氷事態に練乳がかかっていない場合
				// 練乳かき氷に変える
				this.isMillk = true;
				if (!this.world.isRemote){
					entityplayer.getHeldItem(hand).shrink(1);;
					if (entityplayer.getHeldItem(hand).getCount() <= 0){
						entityplayer.setHeldItem(hand, null);
					}
		            if (!entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.BUCKET,1))){
		            	entityplayer.dropItem(new ItemStack(Items.BUCKET), false);
		            }
				}
				// シロップを持っている場合
			}else if (ModUtil.compareItemStacks(entityplayer.getHeldItem(hand), new ItemStack(ItemFoods.item_syrup,1,32767)) && this.flavor == 0){
				// ただのかき氷にシロップを持って接触した場合
				// 持っているシロップをかける
				this.flavor = entityplayer.getHeldItem(hand).getItemDamage();
				if (!this.world.isRemote){
					entityplayer.getHeldItem(hand).shrink(1);;
					if (entityplayer.getHeldItem(hand).getCount() <= 0){
						entityplayer.setHeldItem(hand, null);
					}
					if (!entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE,1))){
			            	entityplayer.dropItem(new ItemStack(Items.GLASS_BOTTLE), false);
			        }
				}
			}else{
				if (hand == EnumHand.MAIN_HAND){
					if (entityplayer.canEat(ConfigValue.Setting_CrashedIce.CrashedIceCanEatAllways)){
						if (!this.world.isRemote){
							if (this.isMillk){
								ItemCrashedIce.onEat(new ItemStack(ItemFoods.item_crashedice,1,this.flavor), this.world, entityplayer);
							}else{
								ItemCrashedIce.onEat(new ItemStack(ItemFoods.item_milkcrashedice,1,this.flavor), this.world, entityplayer);
							}
						}
			            timelimit = 0;
					}else{
						if (!this.world.isRemote){
							entityplayer.sendStatusMessage(new TextComponentString("Not hungry"),false);
						}
					}
				}
			}
		}else{
			if (!this.world.isRemote){
				if (hand == EnumHand.MAIN_HAND){
					// 完全に溶けている場合、秋ガラスを回収する
					dropItem();
					setDead();
				}
			}
		}

		return true;
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tagCompund) {
		flavor = tagCompund.getByte("Flavor");
		timelimit = tagCompund.getShort("Limit");
		isMillk = tagCompund.getBoolean("IsMillk");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tagCompound) {
		tagCompound.setInteger("Flavor",flavor);
		tagCompound.setInteger("Limit",timelimit);
		tagCompound.setBoolean("IsMillk", isMillk);
	}

	private void dropItem(){
		if (timelimit > 0){
			if (!isMillk){
				entityDropItem(new ItemStack(ItemFoods.item_crashedice, 1, flavor), 0.0F);
			}else{
				entityDropItem(new ItemStack(ItemFoods.item_milkcrashedice, 1, flavor), 0.0F);
			}
		}else{
			entityDropItem(new ItemStack(ItemFoods.item_icefoodbowl, 1),0.0F);
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////
	// Dispenser

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

	public void setDispensed(boolean isDispensed) {
		this.dataManager.set(DISPENCE, isDispensed);
	}

	// 射出判定
	public boolean isDispensed() {
		try{
			return this.dataManager.get(DISPENCE);
		}catch(Exception ex){
			return false;
		}
	}
}
