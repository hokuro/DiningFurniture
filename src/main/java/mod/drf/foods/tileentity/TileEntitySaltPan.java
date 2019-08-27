package mod.drf.foods.tileentity;

import mod.drf.core.ModCommon;
import mod.drf.core.Mod_DiningFurniture;
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
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class TileEntitySaltPan extends TileEntity implements ITickable, ICnvertInventory {
	public static final String REGISTER_NAME = "tileentitysaltpan";
	private static final int BASE_TIME = ModCommon.isDebug?200:24000;
	public static final int SIZE_INVENTORY = 1;

	private int limitTime;
	private int cntTime;
	private int level;
	private NonNullList<ItemStack> inventory;
	private String customName;

	private static final int[] slotsTop = new int[] {0};
	private static final int[] slotsBottom = new int[] {0};
	private static final int[] slotsSides = new int[] {0};

	net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.UP);
	net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.DOWN);
	net.minecraftforge.items.IItemHandler handlerSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.WEST);

	public TileEntitySaltPan(){
		super(Mod_DiningFurniture.RegistryEvents.SALTPAN);
		inventory = NonNullList.<ItemStack>withSize(SIZE_INVENTORY, ItemStack.EMPTY);
		this.level = 0;
		this.clear();
	}


	@Override
	public void read(NBTTagCompound compound)
    {
		super.read(compound);
	    this.inventory = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
	    ItemStackHelper.loadAllItems(compound, this.inventory);
//		NBTTagList nbttaglist = compound.getTagList("Items", 10);
//		this.inventory = new ItemStack[this.getSizeInventory()];
//		this.clear();
//		for (int i = 0; i < nbttaglist.tagCount(); ++i)
//		{
//			NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
//			int j = nbttagcompound.getByte("Slot");
//
//			if (j >= 0 && j < this.inventory.length)
//			{
//				this.inventory[j] = new ItemStack(nbttagcompound);
//			}
//		}

		limitTime = compound.getInt("LIMITTIME");
		cntTime = compound.getInt("CNTTIME");
		if (compound.hasKey("CustomName"))
		{
			this.customName = compound.getString("CustomName");
		}
    }

	@Override
    public NBTTagCompound write(NBTTagCompound compound)
    {
		super.write(compound);

		compound.setInt("LIMITTIME", limitTime);
		compound.setInt("CNTTIME", cntTime);

		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < SIZE_INVENTORY; ++i)
		{
			if (!this.inventory.get(i).isEmpty())
			{
				NBTTagCompound nbttagcompound = new NBTTagCompound();
				nbttagcompound.setByte("Slot", (byte)i);
				this.inventory.get(i).write(nbttagcompound);
				nbttaglist.add(nbttagcompound);
			}
		}

		compound.setTag("Items", nbttaglist);

		if (this.hasCustomName())
		{
			compound.setString("CustomName", this.customName);
		}
		return compound;
    }

	@Override
	public void tick() {
		boolean flag1 = true;
		IBlockState state = this.world.getBlockState(pos);
		if (!(state.getBlock() instanceof BlockSaltPan)){return;}
		BlockSaltPan saltPan = (BlockSaltPan)state.getBlock();
		int level = (int)state.getValues().get(BlockSaltPan.LEVEL);
        if (!this.world.isRemote)
        {
        	if (inventory.get(0).isEmpty()){
        		if ( level != EnumSaltPanLevel.EMPTY.getLevel()){
        			BlockSaltPan.setWaterLevel(this.world, pos, state, EnumSaltPanLevel.EMPTY);
        		}
        		// 空っぽの場合カウンタリセット
    			if (limitTime != 0){
    				limitTime = 0;
    				cntTime = 0;
    			}

        	}else if (!inventory.get(0).isEmpty()){
    			if (limitTime == 0){
    				// 何かが入れられた直後の場合大麻更新
    				limitTime = BASE_TIME + (ModCommon.isDebug?0:(Minecraft.getInstance().world.rand.nextInt(5)*1200));
    				cntTime = 0;
    			}
        		if (!inventory.get(0).isEmpty() && inventory.get(0).getItem() == Items.WATER_BUCKET){
    				// 水バケツの場合、インベントリの設定を水ブロックに変え、バケツを吐き出し、レベルを更新する
    				inventory.set(0,new ItemStack(Items.POTION));
    				InventoryHelper.spawnItemStack(this.world, this.pos.getX(), this.pos.getY(), this.pos.getZ(), new ItemStack(Items.BUCKET));
    				cntTime = 0;
    				flag1 = true;
            	}else if (inventory.get(0).getItem() == Items.POTION){
    				// 水が入っている場合カウントアップ
    				cntTime ++;
            	}else{
            		return;
            	}
        		if (level != EnumSaltPanLevel.FILL.getLevel()){
    				BlockSaltPan.setWaterLevel(this.world, pos, state, EnumSaltPanLevel.FILL);
        		}
        	}

    		if (limitTime != 0 && limitTime <= cntTime){
    			// 塩ができた場合、インベントリの中身を塩6つに変え、レベルを更新する
    			inventory.set(0, new ItemStack(ItemFoods.item_salt,6));
    			BlockSaltPan.setWaterLevel(this.world, this.pos, state, EnumSaltPanLevel.SATL);
    			limitTime = 0;
    			cntTime = 0;
    			flag1 = true;
    		}
        }else{
        	if (inventory.get(0).isEmpty()){
            	if (level == 0){
            		inventory.set(0, ItemStack.EMPTY);
            	}else if (level == 1){
            		inventory.set(0, new ItemStack(Items.POTION,0));
            	}else if (level == 2){
            		inventory.set(0, new ItemStack(ItemFoods.item_salt,3));
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
		if (stack.isEmpty()){
			boolean flag = stack.isItemEqual(this.inventory.get(index)) && ItemStack.areItemStackTagsEqual(stack, this.inventory.get(index));

			if (stack.getCount() > this.getInventoryStackLimit())
			{
				stack.setCount(this.getInventoryStackLimit());
			}

			if (index == 0 && !flag)
			{
				this.markDirty();
			}
		}

	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
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
		for (int i = 0; i < this.inventory.size(); ++i)
		{
			this.inventory.set(i, ItemStack.EMPTY);
		}
	}

	@Override
	public ITextComponent getName() {
		return this.hasCustomName() ? new TextComponentTranslation(this.customName) : new TextComponentTranslation("container.saltpan");
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
		if (!inventory.get(0).isEmpty()){
			return false;
		}else if (itemStackIn.getItem() == Items.WATER_BUCKET){
			return true;
		}
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		if (direction == EnumFacing.DOWN && index == 0)
		{
			Item item = stack.getItem();

			if (item == Items.BUCKET || item == ItemFoods.item_salt){
				return true;
			}
		}
		return false;
	}

	@Override
	public ITextComponent getDisplayName() {
        return getName();
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


	@Override
	public ITextComponent getCustomName() {
		// TODO 自動生成されたメソッド・スタブ
		return getName();
	}
}
