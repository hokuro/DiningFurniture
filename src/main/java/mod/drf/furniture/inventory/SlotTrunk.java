package mod.drf.furniture.inventory;

import mod.drf.furniture.item.ItemTrunk;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotTrunk extends Slot {

	public SlotTrunk(IInventory  inventoryIn, int index, int xPosition, int yPosition){
		super(inventoryIn,index,xPosition,yPosition);
	}

	public boolean isItemValid(ItemStack itemstack)
	{
		// トランクを入れられないようにする
		return !(itemstack.getItem() instanceof ItemTrunk);
	}
}
