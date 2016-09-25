package mod.drf.creative;

import mod.drf.foods.block.BlockFoods;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabPieCakes extends CreativeTabs {

	public CreativeTabPieCakes(){
		super("PieCakes");
	}

	@Override
	public Item getTabIconItem() {
		return  Item.getItemFromBlock(BlockFoods.block_pie_hall);
	}
}
