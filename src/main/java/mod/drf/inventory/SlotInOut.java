package mod.drf.inventory;

import mod.drf.util.ModUtil;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class SlotInOut extends Slot {

	private boolean isInput;
	private ItemStack[] allowItems;



	public SlotInOut(IInventory inventoryIn, int index, int xPosition, int yPosition, boolean isIn) {
		super(inventoryIn, index, xPosition, yPosition);
		isInput = isIn;
		allowItems = null;
	}


	@Override
    public boolean isItemValid(ItemStack stack)
    {
		if(allowItems == null){
			return false;
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
