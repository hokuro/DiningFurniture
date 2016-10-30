package mod.drf.foods.entity;

import io.netty.buffer.ByteBuf;
import mod.drf.foods.Item.ItemFoods.EnumIceFlavor;
import mod.drf.furniture.entity.EntityChairZabuton;
import mod.drf.furniture.item.ItemFurniture;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityIceCream extends Entity implements IEntityAdditionalSpawnData, IProjectile {

	public static final String NAME = "EntityIceCream";
	public static final int LIMIT_TIME = 1200;

	private static final DataParameter<Boolean> DISPENCE = EntityDataManager.<Boolean>createKey(EntityChairZabuton.class, DataSerializers.BOOLEAN);
	private int flavor;
	private int timelimit;
	public boolean isDispensed;

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
		setPositionAndRotation(blockpos.getX(),blockpos.getY(),blockpos.getZ(),0F,0F);
		motionX = 0.0D;
		motionY = 0.0D;
		motionZ = 0.0D;
	}


	public EnumIceFlavor getFlavor(){
		return EnumIceFlavor.getValue(flavor);
	}

	public int countdown(){
		return timelimit;
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
			entityDropItem(new ItemStack(ItemFurniture.item_zabuton, 1, flavor), 0.0F);
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
	protected void readEntityFromNBT(NBTTagCompound tagCompund) {
		flavor = tagCompund.getByte("Flavor");
		timelimit = tagCompund.getShort("Limit");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tagCompound) {
		tagCompound.setInteger("Flavor",flavor);
		tagCompound.setInteger("Limit",timelimit);
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
