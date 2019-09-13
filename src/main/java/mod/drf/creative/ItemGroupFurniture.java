package mod.drf.creative;

import mod.drf.item.ItemCore;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemGroupFurniture extends ItemGroup{

	public ItemGroupFurniture(String name){
		super(name);
	}


	@Override
	@OnlyIn(Dist.CLIENT)
	public String getTabLabel() {
		return "Furniture";
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemCore.item_zabuton_black);
	}
}
