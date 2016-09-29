package mod.drf.foods.tileentity;

import mod.drf.core.ModCommon;
import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.Item.ItemIceCreamMix;
import mod.drf.inventory.ContainerFreezer;
import mod.drf.inventory.ICnvertInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
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

public class TileEntityFreezer extends TileEntityLockable implements IInventory, ICnvertInventory {
	private static final int FREEZING_TIME_MAX=6000;
	private static final int WATER_MAX = 64;
	private ItemStack[] iceHolder = new ItemStack[21];
	private int[] freezingTimer = new int[19];
	private int waterCont = 0;
	private String freezerCustomName;

	private static final int[] slotsTop = new int[] {0};
	private static final int[] slotsBottom = new int[] {1};
	private static final int[] slotsSides = new int[] {1};

	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		NBTTagList nbttaglist = compound.getTagList("Items", 10);
		this.iceHolder = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound.getByte("Slot");

			if (j >= 0 && j < this.iceHolder.length)
			{
				this.iceHolder[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
			}
		}

		for (int i = 0; i < freezingTimer.length; i++){
			this.freezingTimer[i] = compound.getInteger("FreezeTime"+Integer.toString(i));
		}

		waterCont = compound.getInteger("WaterCount");

		if (compound.hasKey("CustomName", 8))
		{
			this.freezerCustomName = compound.getString("CustomName");
		}
	}

	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);

		compound.setInteger("WaterCount", waterCont);
		for (int i = 0; i < freezingTimer.length; i++){
			compound.setInteger("FreezeTime"+Integer.toString(i),this.freezingTimer[i]);
		}

		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.iceHolder.length; ++i)
		{
			if (this.iceHolder[i] != null)
			{
				NBTTagCompound nbttagcompound = new NBTTagCompound();
				nbttagcompound.setByte("Slot", (byte)i);
				this.iceHolder[i].writeToNBT(nbttagcompound);
				nbttaglist.appendTag(nbttagcompound);
			}
		}

		compound.setTag("Items", nbttaglist);

		if (this.hasCustomName())
		{
			compound.setString("CustomName", this.freezerCustomName);
		}
	}


	public void update()
	{
		boolean flag1 = false;
		// 水貯水
		if (iceHolder[0] != null && ((iceHolder[0].getItem() == Items.water_bucket))){
			if (waterCont < WATER_MAX){
				// 貯水量を+1
				waterCont++;
				// 水バケツをバケツに変更
				iceHolder[0] = new ItemStack(Items.bucket,1);
			}
		}
		// 水引き出し
		if(iceHolder[1] != null && ((iceHolder[1].getItem() == Items.bucket))){
			if (waterCont > 0){
				// 貯水量を-1
				waterCont--;
				// バケツを水バケツに変更
				iceHolder[1] = new ItemStack(Items.water_bucket,1);
			}
		}
		// 水の冷凍カウントを増減
		if (waterCont <= 0 ||
				(iceHolder[2]!=null && iceHolder[2].stackSize >= WATER_MAX)){
			// 水が空か、氷がいっぱいの場合、カウント停止
			freezingTimer[0]=0;
		}else if (freezingTimer[0] >= FREEZING_TIME_MAX){
			// 冷凍カウントが最大になった
			// 水が一つ減って
			waterCont--;
			// 氷が一つできる
			if (iceHolder[2] == null){
				iceHolder[2] = new ItemStack(Blocks.ice,1);
			}else{
				iceHolder[2].stackSize++;
			}
			// タイマーが0になる
			freezingTimer[0] = 0;
		}else{
			// 大麻増加
			freezingTimer[0]++;
		}
		for (int i=3; i < iceHolder.length; i++){
			if (!canFreezeing(iceHolder[i])){
				// 冷凍不可能なアイテムならタイマー解除
				freezingTimer[i-2] = 0;
			}else if(freezingTimer[i-2] >= FREEZING_TIME_MAX){
				// 出来上がり
			}else{
				// 大麻増加
				freezingTimer[i-2]++;
			}

		}

		if (flag1)
		{
			this.markDirty();
		}
	}


	@Override
	public String getName() {
		return this.hasCustomName() ? this.freezerCustomName : "container.freezer";
	}

	@Override
	public boolean hasCustomName() {
		return this.freezerCustomName != null && !this.freezerCustomName.isEmpty();
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		 return new ContainerFreezer(playerInventory, this);
	}

	@Override
	public String getGuiID() {
		return ModCommon.MOD_ID + ":" + ModCommon.MOD_GUI_FREEZER_NAME;
	}

	@Override
	public int getSizeInventory() {
		return this.iceHolder.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return this.iceHolder[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		 return ItemStackHelper.func_188382_a(this.iceHolder, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.func_188383_a(this.iceHolder, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		boolean flag = stack != null && stack.isItemEqual(this.iceHolder[index]) && ItemStack.areItemStackTagsEqual(stack, this.iceHolder[index]);
		this.iceHolder[index] = stack;

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
		return 1;
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
		if (index == 0)
		{
			return (stack.getItem()==Items.water_bucket);
		}else if(index==1){
			return (stack.getItem()==Items.bucket);
		}else if(index==2){
			return false;
		}
		return canFreezeing(stack);
	}

	@Override
	public int getField(int id) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public int getFieldCount() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < this.iceHolder.length; ++i)
		{
			this.iceHolder[i] = null;
		}
	}

	public void setCustomInventoryName(String displayName) {
		this.freezerCustomName = displayName;

	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return side == EnumFacing.DOWN ? slotsBottom : (side == EnumFacing.UP ? slotsTop : slotsSides);
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return this.isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
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


	private boolean canFreezeing(ItemStack stack){
		Item item = stack.getItem();

		if ((stack != null) &&
			((item instanceof ItemIceCreamMix) ||
			 (item == ItemFoods.item_sugarwater))){
			return true;
		}
		return false;
	}

}
