package mod.drf.common.inventory;

import mod.drf.recipie.OriginalRecipie;
import mod.drf.recipie.OriginalRecipie.ORIGINAL_RECIPIES;
import mod.drf.util.ModUtil;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotInOut extends Slot {

	private boolean isInput;
	private ORIGINAL_RECIPIES kind;
	private ItemStack[] allowItems;

	public SlotInOut(IInventory inventoryIn, int index, int xPosition, int yPosition, ItemStack[] stacks) {
		super(inventoryIn, index, xPosition, yPosition);
		allowItems = stacks;
		kind = null;
	}

	public SlotInOut(IInventory inventoryIn, int index, int xPosition, int yPosition, boolean isIn) {
		super(inventoryIn, index, xPosition, yPosition);
		isInput = isIn;
		allowItems = null;
	}

	public SlotInOut(IInventory inventoryIn, int index, int xPosition, int yPosition, boolean isIn,ORIGINAL_RECIPIES recipie) {
		super(inventoryIn, index, xPosition, yPosition);
		isInput = isIn;
		kind = recipie;
		allowItems = null;
	}

	@Override
    public boolean isItemValid(ItemStack stack)
    {
		if(allowItems == null){
			if (isInput){
				return OriginalRecipie.Instance().canConvert(kind, stack);
			}else{
				return false;
			}
		}else{
			boolean ret = false;
			for(ItemStack st : allowItems){
				if( ModUtil.compareItemStacks(stack, st)){
					ret = true;
					break;
				}
			}
			return ret;
		}
    }

	public void addArrowItem(ItemStack[] stack){
		allowItems = stack.clone();
	}

	public void CleanArrowItem(){
		allowItems = null;
	}

}
