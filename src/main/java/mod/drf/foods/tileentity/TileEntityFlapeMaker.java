package mod.drf.foods.tileentity;

import mod.drf.core.ModCommon;
import mod.drf.foods.Item.ItemFoods;
import mod.drf.inventory.ICnvertInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityFlapeMaker extends TileEntityLockable implements ITickable, ICnvertInventory {
	private static final int CRUSH_TIME_MAX = 100;
	private static final int CRUSH_SIZE = 4;
	private ItemStack[] flapeItemStack = new ItemStack[2];
	private String makercustomname;

	private static final int[] slotsTop = new int[] {0};
	private static final int[] slotsBottom = new int[] {1};
	private static final int[] slotsSides = new int[] {1};
	private int crushTime;

	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		NBTTagList nbttaglist = compound.getTagList("Items", 10);
		this.flapeItemStack = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound.getByte("Slot");

			if (j >= 0 && j < this.flapeItemStack.length)
			{
				this.flapeItemStack[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
			}
		}

		this.crushTime = compound.getInteger("BurnTime");

		if (compound.hasKey("CustomName", 8))
		{
			this.makercustomname = compound.getString("CustomName");
		}
	}

	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("BurnTime", this.crushTime);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.flapeItemStack.length; ++i)
		{
			if (this.flapeItemStack[i] != null)
			{
				NBTTagCompound nbttagcompound = new NBTTagCompound();
				nbttagcompound.setByte("Slot", (byte)i);
				this.flapeItemStack[i].writeToNBT(nbttagcompound);
				nbttaglist.appendTag(nbttagcompound);
			}
		}

		compound.setTag("Items", nbttaglist);

		if (this.hasCustomName())
		{
			compound.setString("CustomName", this.makercustomname);
		}
	}

	public boolean isRunning()
	{
		return this.crushTime > 0;
	}

	@SideOnly(Side.CLIENT)
	public static boolean isRunning(IInventory p_174903_0_)
	{
		return p_174903_0_.getField(0) > 0;
	}

	public void update()
	{
		boolean flag = this.isRunning();
		boolean flag1 = false;

		if (this.isRunning())
		{
			--this.crushTime;
		}

		if (!this.worldObj.isRemote)
		{
			if (flag){
				if (this.flapeItemStack[1] != null && this.flapeItemStack[1].stackSize >= (this.getInventoryStackLimit()-CRUSH_SIZE)){
					// 完成物がたまりすぎているので停止
					this.crushTime = -1;
				}
				if (this.flapeItemStack[0] != null){
					// 氷がないので停止
					this.crushTime = -1;
				}
			}else{
				if (this.flapeItemStack[0] != null && this.flapeItemStack[1].stackSize >= (this.getInventoryStackLimit()-CRUSH_SIZE)){
					// クラッシュ開始
					this.crushTime = CRUSH_TIME_MAX;
				}else if (this.flapeItemStack[0] != null  && this.crushTime == 0){
					// 動作を停止
					this.crushTime = -1;
					// 氷の数を減らし、0ならインベントリから削除
					this.flapeItemStack[0].stackSize --;
					if (this.flapeItemStack[0].stackSize <= 0){
						this.flapeItemStack[0] = null;
					}
					// 完成品をインベントリに排出
					if (flapeItemStack[1] == null){
						flapeItemStack[1] = new ItemStack(ItemFoods.item_flape,CRUSH_SIZE);
					}else{
						flapeItemStack[1].stackSize += CRUSH_SIZE;
					}
				}
			}
		}

		if (flag1)
		{
			this.markDirty();
		}
	}

	public int[] getSlotsForFace(EnumFacing side)
	{
		return side == EnumFacing.DOWN ? slotsBottom : (side == EnumFacing.UP ? slotsTop : slotsSides);
	}

	/**
	 * Returns true if automation can insert the given item in the given slot from the given side.
	 *
	 * @param index The slot index to test insertion into
	 * @param itemStackIn The item to test insertion of
	 * @param direction The direction to test insertion from
	 */
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
	{
		return this.isItemValidForSlot(index, itemStackIn);
	}

	/**
	 * Returns true if automation can extract the given item in the given slot from the given side.
	 *
	 * @param index The slot index to test extraction from
	 * @param stack The item to try to extract
	 * @param direction The direction to extract from
	 */
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
	{
		if (direction == EnumFacing.DOWN && index == 1)
		{
			Item item = stack.getItem();

			if (item != Items.water_bucket && item != Items.bucket)
			{
				return false;
			}
		}

		return true;
	}

	net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.UP);
	net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.DOWN);
	net.minecraftforge.items.IItemHandler handlerSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.WEST);

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, net.minecraft.util.EnumFacing facing)
	{
		if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			if (facing == EnumFacing.DOWN)
				return (T) handlerBottom;
			else if (facing == EnumFacing.UP)
				return (T) handlerTop;
			else
				return (T) handlerSide;
		return super.getCapability(capability, facing);
	}





	@Override
	public int getSizeInventory() {
		return this.flapeItemStack.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return this.flapeItemStack[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		 return ItemStackHelper.func_188382_a(this.flapeItemStack, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.func_188383_a(this.flapeItemStack, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		boolean flag = stack != null && stack.isItemEqual(this.flapeItemStack[index]) && ItemStack.areItemStackTagsEqual(stack, this.flapeItemStack[index]);
		this.flapeItemStack[index] = stack;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
		{
			stack.stackSize = this.getInventoryStackLimit();
		}

		if (index == 0 && !flag)
		{
			this.markDirty();
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;

	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if (index == 1)
		{
			return false;
		}
		return ((stack.getItem() == Item.getItemFromBlock(Blocks.ice)) || (stack.getItem() == Item.getItemFromBlock(Blocks.frosted_ice)));
	}

	@Override
	public int getField(int id) {
		switch (id)
		{
			case 0:
				return this.crushTime;
			default:
				return 0;
		}
	}

	@Override
	public void setField(int id, int value) {
		switch (id)
		{
			case 0:
				this.crushTime = value;
				break;
		}
	}

	@Override
	public int getFieldCount() {
		 return 4;
	}

	@Override
	public void clear()
	{
		for (int i = 0; i < this.flapeItemStack.length; ++i)
		{
			this.flapeItemStack[i] = null;
		}
	}

	@Override
	public String getName() {
		return this.hasCustomName() ? this.makercustomname : "container.flapemaker";
	}

	@Override
	public boolean hasCustomName() {
		return this.makercustomname != null && !this.makercustomname.isEmpty();
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		 return new ContainerFurnace(playerInventory, this);
	}

	@Override
	public String getGuiID() {
		return ModCommon.MOD_ID + ":" + ModCommon.MOD_GUI_FLAPEMAKER_NAME;
	}

	public void setCustomInventoryName(String displayName) {
		this.makercustomname = displayName;
	}

}
