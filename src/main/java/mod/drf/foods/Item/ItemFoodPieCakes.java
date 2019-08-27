package mod.drf.foods.Item;

import mod.drf.config.ConfigValue;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemFoodPieCakes extends ItemFood {

	public ItemFoodPieCakes(int healAmountIn, float saturation, boolean meat, Properties builder) {
		super(healAmountIn, saturation, meat, builder);

	}


	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if (playerIn.canEat(ConfigValue.piecake.CanEatAllways())) {
			playerIn.setActiveHand(handIn);
			return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
		} else {
			return new ActionResult<>(EnumActionResult.FAIL, itemstack);
		}
	}
}
