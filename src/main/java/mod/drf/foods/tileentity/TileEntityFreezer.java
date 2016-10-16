package mod.drf.foods.tileentity;

import mod.drf.core.ModCommon;
import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.Item.ItemIceCreamMix;
import mod.drf.foods.inventory.ContainerFreezer;
import mod.drf.foods.inventory.ICnvertInventory;
import mod.drf.recipie.OriginalRecipie;
import mod.drf.recipie.OriginalRecipie.ORIGINAL_RECIPIES;
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
	private ItemStack[] inventory = new ItemStack[54];
	private int[] freezingTimer = new int[27];
	private String freezerCustomName;
	private boolean isOpen;

	private static final int[] slotsTop = new int[]    { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
	private static final int[] slotsBottom = new int[] {27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53};
	private static final int[] slotsSides = new int[] {27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53};

	public TileEntityFreezer(){
		super();
		isOpen = false;
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

		for (int i = 0; i < freezingTimer.length; i++){
			this.freezingTimer[i] = compound.getInteger("FreezeTime"+Integer.toString(i));
		}
		if (compound.hasKey("CustomName", 8))
		{
			this.freezerCustomName = compound.getString("CustomName");
		}
	}

	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);

		for (int i = 0; i < freezingTimer.length; i++){
			compound.setInteger("FreezeTime"+Integer.toString(i),this.freezingTimer[i]);
		}

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
			compound.setString("CustomName", this.freezerCustomName);
		}
	}


	public void update()
	{
		boolean flag1 = false;
		// 水貯水
		if (inventory[0] != null && ((inventory[0].getItem() == Items.water_bucket))){
			if (waterCont < WATER_MAX){
				// 貯水量を+1
				waterCont++;
				// 水バケツをバケツに変更
				inventory[0] = new ItemStack(Items.bucket,1);
			}
		}
		// 水引き出し
		if(inventory[1] != null && ((inventory[1].getItem() == Items.bucket))){
			if (waterCont > 0){
				// 貯水量を-1
				waterCont--;
				// バケツを水バケツに変更
				inventory[1] = new ItemStack(Items.water_bucket,1);
			}
		}
		// 水の冷凍カウントを増減
		if (waterCont <= 0 ||
				(inventory[2]!=null && inventory[2].stackSize >= WATER_MAX)){
			// 水が空か、氷がいっぱいの場合、カウント停止
			freezingTimer[0]=0;
		}else if (freezingTimer[0] >= FREEZING_TIME_MAX){
			// 冷凍カウントが最大になった
			// 水が一つ減って
			waterCont--;
			// 氷が一つできる
			if (inventory[2] == null){
				inventory[2] = new ItemStack(Blocks.ice,1);
			}else{
				inventory[2].stackSize++;
			}
			// タイマーが0になる
			freezingTimer[0] = 0;
		}else{
			// 大麻増加
			freezingTimer[0]++;
		}
		for (int i=3; i < inventory.length; i++){
			if (!canFreezeing(inventory[i])){
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
		if (index < 27){
			return OriginalRecipie.Instance().canConvert(ORIGINAL_RECIPIES.RECIPIE_FREEZING, stack);
		}
		return false;
	}

	@Override
	public int getField(int id) {
		switch(id){
		case 0:
			return isOpen?1:0;
		}
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		switch(id){
		case 0:
			isOpen = value==0?false:true;
		}
	}

	@Override
	public int getFieldCount() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < this.inventory.length; ++i)
		{
			this.inventory[i] = null;
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
		if (direction == EnumFacing.DOWN && index > 26)
		{
			Item item = stack.getItem();
			return true;
		}

		return false;
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
