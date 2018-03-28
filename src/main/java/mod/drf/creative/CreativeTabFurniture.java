package mod.drf.creative;

import mod.drf.furniture.item.ItemFurniture;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabFurniture extends CreativeTabs{

	public CreativeTabFurniture(){
		super("Furniture");
	}

	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel(){
		return "Furniture";
	}

	@Override
	public ItemStack getTabIconItem() {
		return ItemFurniture.item_zabuton.getDefaultInstance();
	}
}
