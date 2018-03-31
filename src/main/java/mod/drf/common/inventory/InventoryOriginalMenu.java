package mod.drf.common.inventory;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class InventoryOriginalMenu implements IInventory{

	public static final int COL = 3;
	public static final int ROW = 9;
	public static final int FIELD_SCROLL = 0;

	private final NonNullList<ItemStack> inventory;
	private final NonNullList<ItemStack> inventory_view;
	private final Container eventHandler;

	private int scIdx =0;

    public InventoryOriginalMenu(Container eventHandlerIn, int length)
    {
	    this.inventory = NonNullList.<ItemStack>withSize(length, ItemStack.EMPTY);
	    this.inventory_view = NonNullList.<ItemStack>withSize(COL*ROW,ItemStack.EMPTY);
	    eventHandler = eventHandlerIn;
    }

    public void setMenu(List<ItemStack> menus){
    	for (int i = 0; i < menus.size(); i++){
    		inventory.set(i, menus.get(i));
    		if (i < COL*ROW){
    			inventory_view.set(i, menus.get(i));
    		}
    	}
    }

	public int menuCount(){
		return inventory.size();
	}

	public boolean needScroll(){
		return ((COL * ROW)<inventory.size());
	}

	public int getScIndex(){
		return scIdx;
	}

    public void scrollTo(float pos)
    {
        int i = (this.inventory.size() + COL - 1) / COL - ROW;
        int j = (int)((double)(pos * (float)i) + 0.5D);

        if (j < 0)
        {
            j = 0;
        }

        scIdx = j;
        for (int k = 0; k < ROW; ++k)
        {
            for (int l = 0; l < COL; ++l)
            {
                int i1 = l + (k + j) * COL;

                if (i1 >= 0 && i1 < this.inventory.size())
                {
                	this.setInventorySlotContents(l + k * COL, this.inventory.get(i1));
                }
                else
                {
                	this.setInventorySlotContents(l + k * COL, ItemStack.EMPTY);
                }
            }
        }
    }

	@Override
	public String getName() {
		return "container.originalworkbench.menu";
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
    public ITextComponent getDisplayName()
    {
        return (ITextComponent)(this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]));
    }

	@Override
	public int getSizeInventory() {
		return this.inventory.size();
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
		if (index < inventory_view.size()){
			return inventory_view.get(index);
		}else if (index < inventory.size()){
			return inventory.get(index);
		}
		return ItemStack.EMPTY;
    }

	@Override
    public ItemStack decrStackSize(int index, int count)
    {
        //ItemStack itemstack = ItemStackHelper.getAndSplit(this.inventory, index, count);

//        if (!itemstack.isEmpty())
//        {
//            this.eventHandler.onCraftMatrixChanged(this);
//        }

        return ItemStack.EMPTY;
    }

	@Override
    public ItemStack removeStackFromSlot(int index)
    {
        return ItemStack.EMPTY;
    }

	@Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        this.inventory_view.set(index, stack);
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
	public boolean isUsableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) {
	}

	@Override
	public void closeInventory(EntityPlayer player) {
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return false;
	}

	@Override
	public int getField(int id) {
		int ret =0;
		switch(id){
		case 0:
			ret =this.scIdx;
			break;
		}
		return ret;
	}

	@Override
	public void setField(int id, int value) {
		switch(id){
		case 0:
			this.scIdx = value;
			break;
		}
	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {
		this.inventory.clear();
	}

}
