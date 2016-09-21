package mod.drf.creative;

import mod.drf.foods.block.BlockFoods;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabPieCakes extends CreativeTabs {

	public CreativeTabPieCakes(){
		super("PieCakes");
	}

	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel(){
		return "PieCakes";
	}

	@Override
	public Item getTabIconItem() {
		return  new ItemStack(BlockFoods.block_pie_hall).getItem();
	}

	@SideOnly(Side.CLIENT)
	public int getIconItemDamage(){
		return 8;
	}
}
