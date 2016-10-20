package mod.drf.foods.inventory;

import mod.drf.recipie.OriginalRecipie;
import mod.drf.recipie.OriginalRecipie.ORIGINAL_RECIPIES;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerMillStone extends Container {
	private final IInventory tile;
	public int millTime;

	public ContainerMillStone(InventoryPlayer playerInventory, IInventory tileEntityMill) {
		this.tile = tileEntityMill;
		this.addSlotToContainer(new SlotInOut(tile, 0, 80, 17,true, ORIGINAL_RECIPIES.RECIPIE_MILLING));
		this.addSlotToContainer(new SlotInOut(tile, 1, 80, 53,false, ORIGINAL_RECIPIES.RECIPIE_MILLING));


		for (int i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int k = 0; k < 9; ++k)
		{
			this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
		}
	}

	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		for (int i = 0; i < this.crafters.size(); ++i){
			ICrafting icrafting = (ICrafting)this.crafters.get(i);
			if ( this.millTime != this.tile.getField(0)){
				icrafting.sendProgressBarUpdate(this, 2, this.tile.getField(0));
			}
		}
		this.millTime = this.tile.getField(0);
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.tile.isUseableByPlayer(playerIn);
	}


	public void onCraftGuiOpened(ICrafting listener)
	{
		super.onCraftGuiOpened(listener);
		listener.sendAllWindowProperties(this, this.tile);
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data)
	{
		this.tile.setField(id, data);
	}

	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (index == 1)
			{
				if (!this.mergeItemStack(itemstack1, 2, 38, true))
				{
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			}
			else if (index != 0)
			{
				if (OriginalRecipie.Instance().canConvert(ORIGINAL_RECIPIES.RECIPIE_MILLING, itemstack))
				{
					if (!this.mergeItemStack(itemstack1, 0, 1, false))
					{
						return null;
					}
				}
				else if (index >= 2 && index < 29)
				{
					if (!this.mergeItemStack(itemstack1, 29, 38, false))
					{
						return null;
					}
				}
				else if (index >= 29 && index < 38 && !this.mergeItemStack(itemstack1, 2, 29, false))
				{
					return null;
				}
			}
			else if (!this.mergeItemStack(itemstack1, 3, 39, false))
			{
				return null;
			}

			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack)null);
			}
			else
			{
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}

			slot.onPickupFromSlot(playerIn, itemstack1);
		}

		return itemstack;
	}

}
