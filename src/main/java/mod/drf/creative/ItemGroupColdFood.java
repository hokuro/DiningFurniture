package mod.drf.creative;

import mod.drf.foods.Item.ItemFoods;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemGroupColdFood extends ItemGroup {

	public ItemGroupColdFood(String name){
		super(name);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public String getTabLabel() {
		return "ColdFood";
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemFoods.item_icecream_vanila);
	}
}
