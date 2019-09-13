package mod.drf.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class InventoryOriginalWorkBenchResult implements IInventory{
	private final Container eventHandler;
	private final NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(1, ItemStack.EMPTY);

    public InventoryOriginalWorkBenchResult(Container eventHandlerIn)
    {
    	this.eventHandler = eventHandlerIn;
    }

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public boolean isEmpty() {
        for (ItemStack itemstack : this.inventory)
        {
            if (!itemstack.isEmpty())
            {
                return false;
            }
        }

        return true;
    }

	@Override
    public ItemStack getStackInSlot(int index)
    {
        return  this.inventory.get(0);
    }

	@Override
    public ItemStack decrStackSize(int index, int count)
    {
		return ItemStackHelper.getAndRemove(this.inventory, 0);
    }

	@Override
    public ItemStack removeStackFromSlot(int index)
    {
        return ItemStackHelper.getAndRemove(this.inventory, 0);
    }

	@Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        this.inventory.set(0, stack);
        //this.eventHandler.onCraftMatrixChanged(this);
    }

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void markDirty() {

	}

	@Override
	public boolean isUsableByPlayer(PlayerEntity player) {
		return true;
	}

	@Override
	public void openInventory(PlayerEntity player) {
	}

	@Override
	public void closeInventory(PlayerEntity player) {
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return true;
	}
	@Override
	public void clear() {
		this.inventory.clear();
	}
}
