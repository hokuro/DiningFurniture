package mod.drf.util;

import net.minecraft.item.ItemStack;

public class ModUtil {


	public static boolean compareItemStacks(ItemStack stack1, ItemStack stack2){
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
}
