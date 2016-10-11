package mod.drf.foods.inventory;

import mod.drf.recipie.OriginalRecipie;
import mod.drf.recipie.OriginalRecipie.ORIGINAL_RECIPIES;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotFlapeMaker extends Slot {

	private boolean isInput;
	public SlotFlapeMaker(IInventory inventoryIn, int index, int xPosition, int yPosition, boolean isIn) {
		super(inventoryIn, index, xPosition, yPosition);
		isInput = isIn;
	}

	@Override
    public boolean isItemValid(ItemStack stack)
    {
		if (isInput){
			return OriginalRecipie.Instance().canConvert(ORIGINAL_RECIPIES.RECIPIE_CRASHING, stack);
		}else{
			return false;
		}
    }

}
