package mod.drf.creative;

import mod.drf.foods.block.BlockFoods;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabPieCakes extends CreativeTabs {

	public CreativeTabPieCakes(){
		super("Piecakes");
	}

	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel(){
		return "Piecakes";
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(BlockFoods.block_pie_hall);
	}
}
