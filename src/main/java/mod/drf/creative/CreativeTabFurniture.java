package mod.drf.creative;

import mod.drf.furniture.item.ItemFurniture;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabFurniture extends CreativeTabs {

	public CreativeTabFurniture(String label){
		super(label);
	}

	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel(){
		return "Furniture";
	}

	@Override
	public Item getTabIconItem() {
		return ItemFurniture.item_zabuton;
	}

	@SideOnly(Side.CLIENT)
	public int getIconItemDamage(){
		return 8;
	}


}
