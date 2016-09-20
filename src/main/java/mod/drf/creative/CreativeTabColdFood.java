package mod.drf.creative;

import mod.drf.foods.Item.ItemFoods;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabColdFood extends CreativeTabs {

	public CreativeTabColdFood(String label){
		super(label);
	}

	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel(){
		return "ColdFood";
	}

	@Override
	public Item getTabIconItem() {
		return ItemFoods.item_icecream;
	}

	@SideOnly(Side.CLIENT)
	public int getIconItemDamage(){
		return 8;
	}
}
