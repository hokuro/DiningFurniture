package mod.drf.foods.inventory;

import mod.drf.recipie.OriginalRecipie;
import mod.drf.recipie.OriginalRecipie.ORIGINAL_RECIPIES;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotInOut extends Slot {

	private boolean isInput;
	private ORIGINAL_RECIPIES kind;
	public SlotInOut(IInventory inventoryIn, int index, int xPosition, int yPosition, boolean isIn,ORIGINAL_RECIPIES recipie) {
		super(inventoryIn, index, xPosition, yPosition);
		isInput = isIn;
		kind = recipie;
	}

	@Override
    public boolean isItemValid(ItemStack stack)
    {
		if (isInput){
			return OriginalRecipie.Instance().canConvert(kind, stack);
		}else{
			return false;
		}
    }

}
