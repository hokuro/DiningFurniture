package mod.drf.tileentity;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;

public abstract class TileEntityTable extends TileEntity implements ISidedInventory {

	public static final int SIZE_INVENTORY = 1;
	protected NonNullList<ItemStack> inventory;

	protected static final int[] slotsTop = new int[] {0};
	protected static final int[] slotsBottom = new int[] {0};
	protected static final int[] slotsSides = new int[] {0};

	protected net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, Direction.UP);
	protected net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, Direction.DOWN);
	protected net.minecraftforge.items.IItemHandler handlerSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, Direction.WEST);

	public TileEntityTable(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
		inventory = NonNullList.<ItemStack>withSize(SIZE_INVENTORY, ItemStack.EMPTY);
	}


	@Override
	public void read(CompoundNBT compound)
    {
		super.read(compound);
	    this.inventory = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
	    ItemStackHelper.loadAllItems(compound, this.inventory);
    }

	@Override
    public CompoundNBT write(CompoundNBT compound)
    {
		super.write(compound);
		ItemStackHelper.saveAllItems(compound, this.inventory);
		return compound;
    }

	@Override
	public int getSizeInventory() {
		return SIZE_INVENTORY;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		if (this.inventory.get(index).isEmpty()){
			return ItemStack.EMPTY;
		}
		return inventory.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		 return ItemStackHelper.getAndSplit(inventory, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(inventory, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		this.inventory.set(index,stack);
		this.markDirty();
	}

	public void markDirty() {
		super.markDirty();
		this.getWorld().notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), 3);
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
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
		for (int i = 0; i < this.inventory.size(); ++i)
		{
			this.inventory.set(i, ItemStack.EMPTY);
		}
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		return side == Direction.DOWN ? slotsBottom : (side == Direction.UP ? slotsTop : slotsSides);
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, Direction direction) {
		if (index == 0 && inventory.get(index).isEmpty() && itemStackIn.getCount() == 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
		if (direction == Direction.DOWN && index == 0) {
			if (!stack.isEmpty()){
				return true;
			}
		}
		return false;
	}

	@Override
    public boolean canRenderBreaking()
    {
       return false;
    }

	@Override
	public boolean isEmpty() {
		 boolean ret = true;
	        for(ItemStack st : this.inventory){
	        	if(!st.isEmpty()){
	        		ret = false;
	        		break;
	        	}
	        }
	        return ret;
	}

	net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[] handlers =
			net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

	@Override
	public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, net.minecraft.util.Direction facing)
	{
		if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			if (facing == Direction.DOWN)
				return handlers[1].cast();
			else if (facing == Direction.UP)
				return handlers[0].cast();
			else
				return handlers[2].cast();
		return super.getCapability(capability, facing);
	}

	@Override
	public SUpdateTileEntityPacket getUpdatePacket()
    {
        CompoundNBT CompoundNBT = new CompoundNBT();
        return new SUpdateTileEntityPacket(this.pos, 1,  getUpdateTag());
    }

	@Override
    public void onDataPacket(net.minecraft.network.NetworkManager net, SUpdateTileEntityPacket pkt)
    {
		this.read(pkt.getNbtCompound());
    }

	@Override
	public CompoundNBT getUpdateTag() {
		return this.write(new CompoundNBT());
	}


	public void setItem(ItemStack stack) {
		this.setInventorySlotContents(0, new ItemStack(stack.getItem(),1));
	}

	public ItemStack exchangeItem(ItemStack stack) {
		ItemStack ret = this.getStackInSlot(0).copy();
		this.setInventorySlotContents(0, stack);
		return ret;
	}

	public ItemStack getItem() {
		ItemStack ret = this.getStackInSlot(0).copy();
		this.clear();
		return ret;
	}

	public boolean canEat(boolean ignore) {
		Item item = this.getStackInSlot(0).getItem();
		if (item.isFood()) {
			return (item.getFood().canEatWhenFull() || ignore);
		}
		return false;
	}


	public ItemEntity getItemEntity() {
		ItemEntity ret = new ItemEntity(this.world, this.pos.getX(), this.pos.getY(), this.pos.getZ(), this.getStackInSlot(0));
		return ret;
	}


}