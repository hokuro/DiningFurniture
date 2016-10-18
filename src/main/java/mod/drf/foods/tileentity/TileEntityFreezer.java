package mod.drf.foods.tileentity;

import mod.drf.core.ModCommon;
import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.Item.ItemIceCreamMix;
import mod.drf.foods.inventory.ContainerFreezer;
import mod.drf.foods.inventory.ICnvertInventory;
import mod.drf.recipie.OriginalRecipie;
import mod.drf.recipie.OriginalRecipie.ORIGINAL_RECIPIES;
import mod.drf.util.ModUtil;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;

public class TileEntityFreezer extends TileEntityLockable implements ITickable, ICnvertInventory {
	private static final int FREEZING_TIME_MAX=6000;
	private ItemStack[] inventory = new ItemStack[54];
	private int[] freezingTimer = new int[27];
	private String freezerCustomName;
	private boolean isOpen;
	private EnumFacing facing;
	private int numPlayersUsing;
	private int ticksSinceSync;
	public float prevLidAngle;
	public float lidAngle;
	private static final ItemStack return_potion = new ItemStack(Items.glass_bottle,1);
	private static final ItemStack return_buket = new ItemStack(Items.bucket,1);


	private static final int[] slotsTop = new int[]    { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
	private static final int[] slotsBottom = new int[] {27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53};
	private static final int[] slotsSides = new int[] {27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53};

	public TileEntityFreezer(){
		super();
		isOpen = false;
	}

	public TileEntityFreezer(EnumFacing meta){
		this();
		this.facing = meta;
	}

	public EnumFacing getFace(){
		return this.facing;
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


        ++this.ticksSinceSync;

        if (!this.worldObj.isRemote && this.numPlayersUsing != 0 && (this.ticksSinceSync + pos.getX() + pos.getY() + pos.getZ()) % 200 == 0)
        {
            int i = this.pos.getX();
            int j = this.pos.getY();
            int k = this.pos.getZ();
            this.numPlayersUsing = 0;
            float f = 5.0F;

            for (EntityPlayer entityplayer : this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB((double)((float)i - f), (double)((float)j - f), (double)((float)k - f), (double)((float)(i + 1) + f), (double)((float)(j + 1) + f), (double)((float)(k + 1) + f))))
            {
                if (entityplayer.openContainer instanceof ContainerChest)
                {
                    IInventory iinventory = ((ContainerChest)entityplayer.openContainer).getLowerChestInventory();

                    if (iinventory == this || iinventory instanceof InventoryLargeChest && ((InventoryLargeChest)iinventory).isPartOfLargeChest(this))
                    {
                        ++this.numPlayersUsing;
                    }
                }
            }
        }

		if (!this.worldObj.isRemote){
			for (int i = 0; i < freezingTimer.length; i++){
				// アイテムが入っていれば冷凍カウントアップ
				if (inventory[i] != null){
					freezingTimer[i]++;
				}else{
					freezingTimer[i] = 0;
				}

				// 冷凍完了
				if (freezingTimer[i] >= FREEZING_TIME_MAX){
					// 完成品
					ItemStack result = OriginalRecipie.Instance().getResultItem(ORIGINAL_RECIPIES.RECIPIE_FREEZING, inventory[i]);
					// 副産物
					ItemStack subResult = null;
					if (result.getItem() == ItemFoods.item_icecandy){
						subResult = return_potion;
					}else if (result.getItem() == Item.getItemFromBlock(Blocks.ice)){
						subResult = return_buket;
					}

					// 完成品と副産物を入れるスロットを探す
					int mi = -1;
					int si = -1;
					for (int j = freezingTimer.length; j < inventory.length; j++){
						if (ModUtil.compareItemStacks(inventory[j], result)){
							if ((mi < 0 || (mi >= 0&& inventory[mi] == null)) && inventory[j].stackSize < result.getMaxStackSize()){
								mi = j;
							}
						}else if (inventory[j] == null && mi < 0){
							mi = j;
						}else if (subResult != null){
							if ((si < 0 || (si >= 0&& inventory[si] == null)) && inventory[j].stackSize < result.getMaxStackSize()){
								if (si < 0 && inventory[j].stackSize < subResult.getMaxStackSize()){
									si = j;
								}
							}else if (subResult != null && (inventory[j] == null && si < 0)){
								si = j;
							}
						}
					}

					if (mi >= 0 && (subResult == null || (subResult!=null && si >=0))){
						// 完成品のアウトプット
						if (inventory[mi] == null){
							inventory[mi] = result;
							inventory[mi].stackSize = 1;
						}else{
							inventory[mi].stackSize++;
						}

						// 副産物があればアウトプット
						if (subResult != null){
							if (inventory[si] == null){
								inventory[si] = subResult.copy();
								inventory[si].stackSize = 1;
							}else{
								inventory[si].stackSize++;
							}
						}

						// ソースを減量
						inventory[i].stackSize--;
						if (inventory[i].stackSize <= 0){
							inventory[i] = null;
						}

						// タイマーを巻き戻す
						freezingTimer[i] = 0;

						flag1 = true;
					}else{
						// 出力する場所が足りない場合、タイマカウントを止める
						freezingTimer[i] = FREEZING_TIME_MAX;
					}
				}
			}
		}
		if (flag1)
		{
			this.markDirty();
		}

		this.prevLidAngle = this.lidAngle;
		float f1 = 0.1F;

		if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F)
		{
			double d1 = (double)pos.getX() + 0.5D;
			double d2 = (double)pos.getY() + 0.5D;

			this.worldObj.playSound((EntityPlayer)null, d1, (double)pos.getY() + 0.5D, d2, SoundEvents.block_chest_open, SoundCategory.BLOCKS, 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
			}

			if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F)
			{
				float f2 = this.lidAngle;

				if (this.numPlayersUsing > 0)
				{
					this.lidAngle += f1;
				}
				else
				{
					this.lidAngle -= f1;
				}

				if (this.lidAngle > 1.0F)
				{
					this.lidAngle = 1.0F;
				}

				float f3 = 0.5F;

				if (this.lidAngle < f3 && f2 >= f3)
				{
					double d3 = (double)pos.getX() + 0.5D;
					double d0 = (double)pos.getZ() + 0.5D;

					this.worldObj.playSound((EntityPlayer)null, d3, (double)pos.getY() + 0.5D, d0, SoundEvents.block_chest_close, SoundCategory.BLOCKS, 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
				}

				if (this.lidAngle < 0.0F)
				{
					this.lidAngle = 0.0F;
				}
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
		 return new ContainerFreezer(playerInventory, this, playerIn);
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

		if (index < this.freezingTimer.length && !flag)
		{
			this.freezingTimer[index] = 0;
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
    public void openInventory(EntityPlayer player)
    {
        if (!player.isSpectator())
        {
            if (this.numPlayersUsing < 0)
            {
                this.numPlayersUsing = 0;
            }

            ++this.numPlayersUsing;
            this.worldObj.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
            this.worldObj.notifyNeighborsOfStateChange(this.pos, this.getBlockType());
            this.worldObj.notifyNeighborsOfStateChange(this.pos.down(), this.getBlockType());
        }
    }

	@Override
    public void closeInventory(EntityPlayer player)
    {
        if (!player.isSpectator() && this.getBlockType() instanceof BlockChest)
        {
            --this.numPlayersUsing;
            this.worldObj.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
            this.worldObj.notifyNeighborsOfStateChange(this.pos, this.getBlockType());
            this.worldObj.notifyNeighborsOfStateChange(this.pos.down(), this.getBlockType());
        }
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
