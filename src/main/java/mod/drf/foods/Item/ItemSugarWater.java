package mod.drf.foods.Item;

import mod.drf.core.Mod_DiningFurniture;
import mod.drf.foods.Item.ItemFoods.EnumFlapeSyrup;
import net.minecraft.item.Item;

public class ItemSugarWater extends Item{
	private EnumFlapeSyrup flavor;

	public ItemSugarWater(EnumFlapeSyrup flavorIn){
		super((new Item.Properties()).group(Mod_DiningFurniture.tabColdFood));
		flavor = flavorIn;
	}

	public EnumFlapeSyrup getFlavor() {
		return flavor;
	}
}
