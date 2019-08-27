package mod.drf.foods.Item;

import mod.drf.core.Mod_DiningFurniture;
import mod.drf.foods.Item.ItemFoods.EnumIceFlavor;
import net.minecraft.item.Item;

public class ItemIceCreamMix extends Item {

	private final EnumIceFlavor flavor;

	public ItemIceCreamMix(EnumIceFlavor flavorIn){
		super((new Item.Properties()).group(Mod_DiningFurniture.tabColdFood));
		flavor = flavorIn;
	}


    public EnumIceFlavor getFlavor() {
    	return flavor;
    }
}
