package mod.drf.foods.inventory;

import mod.drf.common.inventory.SlotInOut;
import mod.drf.foods.Item.ItemFoods;
import mod.drf.recipie.OriginalRecipie;
import mod.drf.recipie.OriginalRecipie.ORIGINAL_RECIPIES;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ContainerIceCrasher extends Container {
	private final IInventory tile;
	public int crushTime;

	public ContainerIceCrasher(InventoryPlayer playerInventory, IInventory tileEntityFlapeMaker) {
		this.tile = tileEntityFlapeMaker;
		this.addSlot(new SlotInOut(tile, 0, 56, 17,true, ORIGINAL_RECIPIES.RECIPIE_CRASHING));
		this.addSlot(new SlotInOut(tile, 1, 56, 53,new ItemStack[]{new ItemStack(ItemFoods.item_icefoodbowl)}));
        this.addSlot(new SlotInOut(tile, 2, 116, 35,false, ORIGINAL_RECIPIES.RECIPIE_CRASHING));



		for (int i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int k = 0; k < 9; ++k)
		{
			this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
		}
	}

	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		for (int i = 0; i < this.listeners.size(); ++i){
			IContainerListener icrafting = (IContainerListener)this.listeners.get(i);
			if ( this.crushTime != this.tile.getField(0)){
				icrafting.sendWindowProperty(this, 2, this.tile.getField(0));
			}
		}
		this.crushTime = this.tile.getField(0);
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.tile.isUsableByPlayer(playerIn);
	}


	public void addListener(IContainerListener listener)
	{
		super.addListener(listener);
		listener.sendAllWindowProperties(this, this.tile);
	}

	@OnlyIn(Dist.CLIENT)
	public void updateProgressBar(int id, int data)
	{
		this.tile.setField(id, data);
	}

	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index != 1 && index != 0)
            {
                if (OriginalRecipie.Instance().canConvert(ORIGINAL_RECIPIES.RECIPIE_CRASHING, itemstack))
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if ((itemstack.getItem() == ItemFoods.item_icefoodbowl))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 3 && index < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.getCount() == 0)
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount())
            {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
	}
}
