package mod.drf.foods.Item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemDebugFood extends ItemResetFood {
	public ItemDebugFood(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood, (new Item.Properties()));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
		ItemStack itemstack = player.getHeldItem(hand);
        player.setActiveHand(hand);
        return new ActionResult(EnumActionResult.SUCCESS, itemstack);
	}
}
