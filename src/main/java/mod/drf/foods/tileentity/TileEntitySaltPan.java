package mod.drf.foods.tileentity;

import mod.drf.core.ModCommon;
import mod.drf.core.log.ModLog;
import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.block.BlockSaltPan;
import mod.drf.foods.block.BlockSaltPan.EnumSaltPanLevel;
import mod.drf.foods.inventory.ICnvertInventory;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class TileEntitySaltPan extends TileEntity implements ITickable, ICnvertInventory {
	private static final int BASE_TIME = ModCommon.isDebug?200:24000;

	private int limitTime;
	private int cntTime;
	private int level;
	private ItemStack[] inventory = new ItemStack[1];
	private String customName;

	private static final int[] slotsTop = new int[] {0};
	private static final int[] slotsBottom = new int[] {0};
	private static final int[] slotsSides = new int[] {0};

	net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.UP);
	net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.DOWN);
	net.minecraftforge.items.IItemHandler handlerSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.WEST);

	public TileEntitySaltPan(int level, ItemStack[] inventory){
		this.level = level;
		this.inventory = inventory;
	}

    public TileEntitySaltPan() {
		// TODO 自動生成されたコンストラクター・スタブ
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

		limitTime = compound.getInteger("LIMITTIME");
		cntTime = compound.getInteger("CNTTIME");
		if (compound.hasKey("CustomName", 8))
		{
			this.customName = compound.getString("CustomName");
		}
    }

    public void writeToNBT(NBTTagCompound compound)
    {
		super.writeToNBT(compound);

		compound.setInteger("LIMITTIME", limitTime);
		compound.setInteger("CNTTIME", cntTime);

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

	@Override
	public void update() {
		boolean flag1 = true;
		IBlockState state = this.worldObj.getBlockState(pos);
		if (!(state.getBlock() instanceof BlockSaltPan)){return;}
		BlockSaltPan saltPan = (BlockSaltPan)state.getBlock();
		int level = state.getValue(BlockSaltPan.LEVEL);
        if (!this.worldObj.isRemote)
        {
        	if (inventory[0] == null){
        		if ( level != EnumSaltPanLevel.EMPTY.getLevel()){
        			BlockSaltPan.setWaterLevel(this.worldObj, pos, state, EnumSaltPanLevel.EMPTY);
        		}
        		// 空っぽの場合カウンタリセット
    			if (limitTime != 0){
    				limitTime = 0;
    				cntTime = 0;
    				if (ModCommon.isDebug){ModLog.log().debug("SaltPan ReSet Counter limit"+limitTime);}
    				if (ModCommon.isDebug){ModLog.log().debug("SaltPan ReSet Counter count"+cntTime);}
    			}

        	}else if (inventory[0] != null){
    			if (limitTime == 0){
    				// 何かが入れられた直後の場合大麻更新
    				limitTime = BASE_TIME + (ModCommon.isDebug?0:(Minecraft.getMinecraft().theWorld.rand.nextInt(5)*1200));
    				cntTime = 0;
    				if (ModCommon.isDebug){ModLog.log().debug("SaltPan Set Counter limit"+limitTime);}
    				if (ModCommon.isDebug){ModLog.log().debug("SaltPan Set Counter count"+cntTime);}
    			}
        		if (inventory[0] != null && inventory[0].getItem() == Items.water_bucket){
        			if (ModCommon.isDebug){ModLog.log().debug("SaltPan item in waterBukets");}
    				// 水バケツの場合、インベントリの設定を水ブロックに変え、バケツを吐き出し、レベルを更新する
    				inventory[0] = new ItemStack(Items.potionitem);
    				InventoryHelper.spawnItemStack(this.worldObj, this.pos.getX(), this.pos.getY(), this.pos.getZ(), new ItemStack(Items.bucket));
    				cntTime = 0;
    				flag1 = true;
            	}else if (inventory[0].getItem() == Items.potionitem){
    				// 水が入っている場合カウントアップ
    				cntTime ++;
    				if (ModCommon.isDebug){
    					if (cntTime%200 == 0){
    						ModLog.log().debug("SaltPan Counter limit"+limitTime);
    						ModLog.log().debug("SaltPan Counter count"+cntTime);
    					}
    				}
            	}else{
            		return;
            	}
        		if (level != EnumSaltPanLevel.FILL.getLevel()){
    				BlockSaltPan.setWaterLevel(this.worldObj, pos, state, EnumSaltPanLevel.FILL);
        		}
        	}

    		if (limitTime != 0 && limitTime <= cntTime){
    			// 塩ができた場合、インベントリの中身を塩6つに変え、レベルを更新する
    			inventory[0] = new ItemStack(ItemFoods.item_salt,6);
    			BlockSaltPan.setWaterLevel(this.worldObj, this.pos, state, EnumSaltPanLevel.SATL);
    			if (ModCommon.isDebug){ModLog.log().debug("SaltPan BlockState :"+EnumSaltPanLevel.SATL.name());}
    			limitTime = 0;
    			cntTime = 0;
    			flag1 = true;
    		}
        }else{
        	if (inventory[0] == null){
            	if (level == 0){
            		inventory[0] = null;
            	}else if (level == 1){
            		inventory[0] = new ItemStack(Items.potionitem,0);
            	}else if (level == 2){
            		inventory[0] = new ItemStack(ItemFoods.item_salt,3);
            	}
        	}
        }

		if (flag1)
		{
			this.markDirty();
		}
	}

	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return inventory[index];
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
	}

	@Override
	public void closeInventory(EntityPlayer player) {
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return true;
	}

	@Override
	public int getField(int id) {
		int ret = 0;
		switch(id){
		case 0:
			ret = limitTime;
			break;
		case 1:
			ret = cntTime;
			break;
		}
		return ret;
	}

	@Override
	public void setField(int id, int value) {
		switch(id){
		case 0:
			limitTime = value;
			break;
		case 1:
			cntTime = value;
			break;
		}
	}

	@Override
	public int getFieldCount() {
		return 2;
	}

	@Override
	public void clear() {
		for (int i = 0; i < this.inventory.length; ++i)
		{
			this.inventory[i] = null;
		}
	}

	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.freezer";
	}

	@Override
	public boolean hasCustomName() {
		return this.customName != null && !this.customName.isEmpty();
	}

	public void setCustomInventoryName(String displayName) {
		this.customName = displayName;

	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return side == EnumFacing.DOWN ? slotsBottom : (side == EnumFacing.UP ? slotsTop : slotsSides);
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		if (inventory[0] != null){
			return false;
		}else if (itemStackIn.getItem() == Items.water_bucket){
			return true;
		}
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		if (direction == EnumFacing.DOWN && index == 0)
		{
			Item item = stack.getItem();

			if (item == Items.bucket || item == ItemFoods.item_salt){
				return true;
			}
		}
		return false;
	}

	@Override
	public ITextComponent getDisplayName() {
        return (ITextComponent)(this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]));
	}
}
