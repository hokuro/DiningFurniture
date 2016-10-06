package mod.drf.foods.tileentity;

import mod.drf.core.ModCommon;
import mod.drf.foods.block.BlockFlapeMaker;
import mod.drf.foods.inventory.ContainerFlapeMaker;
import mod.drf.foods.inventory.ICnvertInventory;
import mod.drf.recipie.OriginalRecipie;
import mod.drf.recipie.OriginalRecipie.ORIGINAL_RECIPIES;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
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
	private ItemStack[] inventory = new ItemStack[2];
	private String customName;
	private boolean isRun;
	private int crushTime;

	private static final int[] slotsTop = new int[] {0};
	private static final int[] slotsBottom = new int[] {1};
	private static final int[] slotsSides = new int[] {0};

	public TileEntityFlapeMaker(){
		isRun = false;
		crushTime = 0;
	}

	public TileEntityFlapeMaker(boolean isRun){
		this.isRun = isRun;
		crushTime = 0;
	}

	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		NBTTagList nbttaglist = compound.getTagList("Items", 10);
		this.inventory = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound.getByte("Slot");

			if (j >= 0 && j < this.inventory.length)
			{
				this.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
			}
		}

		this.crushTime = compound.getInteger("CrushTime");

		if (compound.hasKey("CustomName", 8))
		{
			this.customName = compound.getString("CustomName");
		}
	}

	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("CrushTime", this.crushTime);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.inventory.length; ++i)
		{
			if (this.inventory[i] != null)
			{
				NBTTagCompound nbttagcompound = new NBTTagCompound();
				nbttagcompound.setByte("Slot", (byte)i);
				this.inventory[i].writeToNBT(nbttagcompound);
				nbttaglist.appendTag(nbttagcompound);
			}
		}

		compound.setTag("Items", nbttaglist);

		if (this.hasCustomName())
		{
			compound.setString("CustomName", this.customName);
		}
	}

	public boolean isRunning()
	{
		return isRun;
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

		if (this.isRunning()){
			// かきかきちゅう
			if (OriginalRecipie.Instance().canConvert(ORIGINAL_RECIPIES.RECIPIE_CRASHING, inventory[0]) && canOutput()){
				crushTime++;
			}else{
				// 変換不可のアイテムまたは空っぽ
				BlockFlapeMaker.SetRun(this.worldObj, this.pos, this.worldObj.getBlockState(pos), false);
				flag1 = true;
			}
		}else{
			// とまってる
			if (OriginalRecipie.Instance().canConvert(ORIGINAL_RECIPIES.RECIPIE_CRASHING, inventory[0]) && canOutput()){
				//
				BlockFlapeMaker.SetRun(this.worldObj, this.pos, this.worldObj.getBlockState(pos), true);
				flag1 = true;
			}
		}

		if (this.crushTime > CRUSH_TIME_MAX){
			// かきごおりかんせい
			if (inventory[1] == null){
				inventory[1] = OriginalRecipie.Instance().getResultItem(ORIGINAL_RECIPIES.RECIPIE_CRASHING, inventory[0]);
				inventory[1].stackSize = CRUSH_SIZE;
			}
			inventory[0].stackSize--;
			if (inventory[0].stackSize <= 0){
				inventory[0] = null;
			}
			flag1 = true;
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
			return true;
		}

		return false;
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
		return this.inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return this.inventory[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		 return ItemStackHelper.func_188382_a(this.inventory, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.func_188383_a(this.inventory, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		boolean flag = stack != null && stack.isItemEqual(this.inventory[index]) && ItemStack.areItemStackTagsEqual(stack, this.inventory[index]);
		this.inventory[index] = stack;

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
		return OriginalRecipie.Instance().canConvert(ORIGINAL_RECIPIES.RECIPIE_CRASHING, stack);
	}

	@Override
	public int getField(int id) {
		switch (id)
		{
			case 0:
				return this.crushTime;
			case 1:
				return this.isRun?1:0;
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
			case 1:
				this.isRun = value==0?false:true;
		}
	}

	@Override
	public int getFieldCount() {
		 return 2;
	}

	@Override
	public void clear()
	{
		for (int i = 0; i < this.inventory.length; ++i)
		{
			this.inventory[i] = null;
		}
	}

	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.flapemaker";
	}

	@Override
	public boolean hasCustomName() {
		return this.customName != null && !this.customName.isEmpty();
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		 return new ContainerFlapeMaker(playerInventory, this);
	}

	@Override
	public String getGuiID() {
		return ModCommon.MOD_ID + ":" + ModCommon.MOD_GUI_FLAPEMAKER_NAME;
	}

	public void setCustomInventoryName(String displayName) {
		this.customName = displayName;
	}


	public boolean canOutput(){
		return (inventory[1] != null && inventory[1].stackSize < (this.getInventoryStackLimit()-CRUSH_SIZE));
	}

}
