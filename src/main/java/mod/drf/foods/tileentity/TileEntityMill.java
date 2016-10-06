package mod.drf.foods.tileentity;

import mod.drf.core.ModCommon;
import mod.drf.foods.inventory.ContainerMill;
import mod.drf.foods.inventory.ICnvertInventory;
import mod.drf.recipie.OriginalRecipie;
import mod.drf.recipie.OriginalRecipie.ORIGINAL_RECIPIES;
import mod.drf.util.ModUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityMill extends TileEntityLockable implements ICnvertInventory, IInventory {
	private static final int CRUSH_TIME_MAX = 400;
	private static final int CRUSH_SIZE = 1;
	private ItemStack[] millItemStack = new ItemStack[2];
	private String millCustomName;

	private static final int[] slotsTop = new int[] {0};
	private static final int[] slotsBottom = new int[] {1};
	private static final int[] slotsSides = new int[] {1};
	private int millingTime;

	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		NBTTagList nbttaglist = compound.getTagList("Items", 10);
		this.millItemStack = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound.getByte("Slot");

			if (j >= 0 && j < this.millItemStack.length)
			{
				this.millItemStack[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
			}
		}

		this.millingTime = compound.getInteger("BurnTime");

		if (compound.hasKey("CustomName", 8))
		{
			this.millCustomName = compound.getString("CustomName");
		}
	}

	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("BurnTime", this.millingTime);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.millItemStack.length; ++i)
		{
			if (this.millItemStack[i] != null)
			{
				NBTTagCompound nbttagcompound = new NBTTagCompound();
				nbttagcompound.setByte("Slot", (byte)i);
				this.millItemStack[i].writeToNBT(nbttagcompound);
				nbttaglist.appendTag(nbttagcompound);
			}
		}

		compound.setTag("Items", nbttaglist);

		if (this.hasCustomName())
		{
			compound.setString("CustomName", this.millCustomName);
		}
	}

	public boolean isRunning()
	{
		return this.millingTime > 0;
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
			--this.millingTime;
		}

		if (!this.worldObj.isRemote)
		{
			if (flag){
				if (this.millItemStack[0] == null){
					// 対象アイテムがないので停止
					this.millingTime = -1;
				}
				if (this.millItemStack[1] != null && this.millItemStack[1].stackSize >= (this.getInventoryStackLimit()-CRUSH_SIZE)){
					// 完成物がたまりすぎているので停止
					this.millingTime = -1;
				}
			}else{
				if (this.millItemStack[0] != null){
					if (this.millItemStack[1] != null){
						if (this.millItemStack[1].stackSize >= (this.getInventoryStackLimit()-CRUSH_SIZE) ||
								!ModUtil.compareItemStacks(millItemStack[1], this.resultMilling(this.millItemStack[0]))){
							return;
						}
					}
					this.millingTime = CRUSH_TIME_MAX;
				}else if (this.millItemStack[0] != null  && this.millingTime == 0){
					// 動作を停止
					this.millingTime = -1;

					// 完成品をインベントリに排出
					if (millItemStack[1] == null){
						millItemStack[1] = this.resultMilling(millItemStack[0]);
					}else{
						millItemStack[1].stackSize += CRUSH_SIZE;
					}

					// アイテムの数を減らし、0ならインベントリから削除
					this.millItemStack[0].stackSize --;
					if (this.millItemStack[0].stackSize <= 0){
						this.millItemStack[0] = null;
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
		return this.millItemStack.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return this.millItemStack[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		 return ItemStackHelper.func_188382_a(this.millItemStack, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.func_188383_a(this.millItemStack, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		boolean flag = stack != null && stack.isItemEqual(this.millItemStack[index]) && ItemStack.areItemStackTagsEqual(stack, this.millItemStack[index]);
		this.millItemStack[index] = stack;

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
		return canMilling(stack);
	}

	@Override
	public int getField(int id) {
		switch (id)
		{
			case 0:
				return this.millingTime;
			default:
				return 0;
		}
	}

	@Override
	public void setField(int id, int value) {
		switch (id)
		{
			case 0:
				this.millingTime = value;
				break;
		}
	}

	@Override
	public int getFieldCount() {
		 return 1;
	}

	@Override
	public void clear()
	{
		for (int i = 0; i < this.millItemStack.length; ++i)
		{
			this.millItemStack[i] = null;
		}
	}

	@Override
	public String getName() {
		return this.hasCustomName() ? this.millCustomName : "container.mill";
	}

	@Override
	public boolean hasCustomName() {
		return this.millCustomName != null && !this.millCustomName.isEmpty();
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		 return new ContainerMill(playerInventory, this);
	}

	@Override
	public String getGuiID() {
		return ModCommon.MOD_ID + ":" + ModCommon.MOD_GUI_MILL_NAME;
	}

	public void setCustomInventoryName(String displayName) {
		this.millCustomName = displayName;
	}

	private boolean canMilling(ItemStack stack){
		return OriginalRecipie.Instance().canConvert(ORIGINAL_RECIPIES.RECIPIE_MILLING, stack);
	}

	private ItemStack resultMilling(ItemStack stack){
		return OriginalRecipie.Instance().getResultItem(ORIGINAL_RECIPIES.RECIPIE_MILLING, stack);
	}
}
