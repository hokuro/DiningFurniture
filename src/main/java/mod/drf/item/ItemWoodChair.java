package mod.drf.item;


import mod.drf.entity.EntityChair;
import mod.drf.entity.EntityWoodChair;
import mod.drf.item.ItemCore.EnumWoodType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemWoodChair extends ItemChair {
	public final String name;
	public final EnumWoodType woodType;

	public ItemWoodChair(String n, EnumWoodType tp, Item.Properties property){
		super(property);
		name = n;
		woodType = tp;
	}

	@Override
	public EntityChair getEntityChair(World world, PlayerEntity player, BlockPos blockpos, ItemStack itemstack) {
		EntityChair chiar = new EntityWoodChair(
				world, blockpos.getX()+0.5F, blockpos.getY()+1.0F,blockpos.getZ()+0.5F,
				itemstack,
				woodType);

		if (player != null){
			// 方向ぎめはここに入れる
			chiar.rotationYaw = (MathHelper
					.floor((double) ((player.rotationYaw * 4F) / 360F) + 2.50D) & 3) * 90;
		}
		return chiar;
	}

	@Override
	public String getChairName() {
		return name;
	}

	public EnumWoodType getWoodType() {
		return woodType;
	}

}
