package mod.drf.furniture.inventory;

import mod.drf.core.ModCommon;
import mod.drf.furniture.item.ItemTrunk;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


//@invtweaks.api.container.ChestContainer
public class ContainerTrunk extends Container {

	  IInventory TrunkInv;

	  public ContainerTrunk(InventoryPlayer player, IInventory inv)
	  {
	    this.TrunkInv = inv;
	    inv.openInventory(player.player);
	    for (int i = 0; i < ModCommon.TrunkRsize; i++) {
	      for (int j = 0; j < ModCommon.TrunkCsize; j++) {
	    	  addSlotToContainer(new SlotTrunk(inv, j + i * ModCommon.TrunkCsize, 8 + j * 18, 14 + i * 18));
	      }
	    }
	    bindPlayerInventory(player);
	  }

	  protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
	      for (int j = 0; j < 9; j++) {
	    	  addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + 18 * 2 + j * 18, 126 + i * 18));
	      }
	    }
	    for (int i = 0; i < 9; i++) {
	    	addSlotToContainer(new Slot(inventoryPlayer, i, 8 + 18 * 2 + i * 18, 184));
	    }
	  }

	  public boolean canInteractWith(EntityPlayer entityplayer) {
	    //ItemStack item = entityplayer.getCurrentEquippedItem();
	    ItemStack mitem = entityplayer.getHeldItemMainhand();
	    ItemStack oitem = entityplayer.getHeldItemOffhand();
	    return (((mitem != null) && (mitem.getItem() instanceof ItemTrunk)) ||
	    		 ((oitem != null) && (oitem.getItem() instanceof ItemTrunk)));
	  }

	  public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int index) {
	    ItemStack itemstack = null;
	    Slot slot = (Slot)this.inventorySlots.get(index);

	    if ((slot != null) && (slot.getHasStack()))
	    {
	      ItemStack itemstack1 = slot.getStack();
	      itemstack = itemstack1.copy();

	      if (index < this.TrunkInv.getSizeInventory())
	      {
	        if (!mergeItemStack(itemstack1, this.TrunkInv.getSizeInventory(), this.inventorySlots.size(), true))
	        {
	          return null;
	        }
	      } else {
	        if ((itemstack1.getItem() instanceof ItemTrunk))
	          return null;
	        if (!mergeItemStack(itemstack1, 0, this.TrunkInv.getSizeInventory(), false))
	        {
	          return null;
	        }
	      }
	      if (itemstack1.getCount() == 0)
	      {
	        slot.putStack(null);
	      }
	      else
	      {
	        slot.onSlotChanged();
	      }
	    }

	    return itemstack;
	  }
}
