package mod.drf.foods.entity;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityCrashedIce extends Entity implements IEntityAdditionalSpawnData {

	public static final String NAME = "EntityCrashedIce";

	public EntityCrashedIce(World worldIn) {
		super(worldIn);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public EntityCrashedIce(World world, BlockPos blockpos, int itemDamage) {
		this(world);
	}

	@Override
	public void writeSpawnData(ByteBuf buffer) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void readSpawnData(ByteBuf additionalData) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	protected void entityInit() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tagCompund) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tagCompound) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
