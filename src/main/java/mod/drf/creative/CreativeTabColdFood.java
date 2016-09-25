package mod.drf.creative;

import mod.drf.foods.Item.ItemFoods;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabColdFood extends CreativeTabs {

	public CreativeTabColdFood(){
		super("ColdFood");
	}

	@Override
	public Item getTabIconItem() {
		// TODO 自動生成されたメソッド・スタブ
		return ItemFoods.item_icecream;
	}
}
