package mod.drf.creative;

import mod.drf.foods.block.BlockFoods;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemGroupPieCakes extends ItemGroup {

	public ItemGroupPieCakes(String name){
		super(name);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public String getTabLabel() {
		return "PieCakes";
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(BlockFoods.block_pie_hall);
	}
}
