package mod.drf.creative;

import mod.drf.foods.Item.ItemFoods;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabColdFood extends CreativeTabs {

	public CreativeTabColdFood(){
		super("ColldFood");
	}

	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel(){
		return "ColldFood";
	}

	@Override
	public ItemStack getTabIconItem() {
		return ItemFoods.item_icecream.getDefaultInstance();
	}
}
