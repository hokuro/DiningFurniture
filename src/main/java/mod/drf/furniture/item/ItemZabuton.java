package mod.drf.furniture.item;

import mod.drf.furniture.entity.EntityChair;
import mod.drf.furniture.entity.EntityZabuton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemZabuton extends ItemChair {
	public final String name;
	public final EnumDyeColor color;

	public ItemZabuton(String n, EnumDyeColor col, Item.Properties property){
		super(property);
		name = n;
		color = col;
	}

	@Override
	public EntityChair getEntityChair(World world, EntityPlayer player, BlockPos blockpos, ItemStack itemstack) {
		EntityChair zabuton = new EntityZabuton(
				world, blockpos.getX()+0.5F, blockpos.getY()+1.0F,blockpos.getZ()+0.5F,
				itemstack,
				color);

		if (player != null){
			// 方向ぎめはここに入れる
			zabuton.rotationYaw = (MathHelper
					.floor((double) ((player.rotationYaw * 4F) / 360F) + 2.50D) & 3) * 90;
		}
		return zabuton;
	}

	@Override
	public String getChairName() {
		return name;
	}

	public EnumDyeColor getColor() {
		return color;
	}
}
