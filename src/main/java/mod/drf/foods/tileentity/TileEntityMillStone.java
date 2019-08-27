package mod.drf.foods.tileentity;

import java.util.Random;

import mod.drf.config.ConfigValue;
import mod.drf.core.ModCommon;
import mod.drf.core.Mod_DiningFurniture;
import mod.drf.foods.inventory.ContainerMillStone;
import mod.drf.foods.inventory.ICnvertInventory;
import mod.drf.network.MessageHandler;
import mod.drf.recipie.OriginalRecipie;
import mod.drf.recipie.OriginalRecipie.ORIGINAL_RECIPIES;
import mod.drf.sounds.SoundManager;
import mod.drf.util.ModUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.util.LazyOptional;

public class TileEntityMillStone extends TileEntityLockable implements ITickable, ICnvertInventory {
	public static final String REGISTER_NAME = "tileentitymillstone";
	public static final int MILL_TIME_MAX = 300;
	public static final int MILL_SIZE = 1;
	public static final int SIZE_INVENTORY = 2;
	private NonNullList<ItemStack> inventory;
	private String customName;
	private boolean isRun;
	private int millTime;
	private Random random = new Random();
	private float voluem = 0.4F;
	private float pitch = 1.0F;
	private int musecount = 0;

	private static final int[] slotsTop = new int[] {0};
	private static final int[] slotsBottom = new int[] {1};
	private static final int[] slotsSides = new int[] {0};

	public TileEntityMillStone(){
		super(Mod_DiningFurniture.RegistryEvents.MILLSTONE);
		inventory = NonNullList.<ItemStack>withSize(SIZE_INVENTORY, ItemStack.EMPTY);
		isRun = false;
		millTime = 0;
		this.canRenderBreaking();
		this.clear();
	}



	@Override
	public void read(NBTTagCompound compound)
	{
		super.read(compound);
//		NBTTagList nbttaglist = compound.getTagList("Items", 10);
//		this.inventory = new ItemStack[this.getSizeInventory()];
//		this.clear();

	    this.inventory = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
	    ItemStackHelper.loadAllItems(compound, this.inventory);
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

		this.millTime = compound.getInt("CrushTime");
		this.isRun = compound.getBoolean("isrun");

		if (compound.hasKey("CustomName"))
		{
			this.customName = compound.getString("CustomName");
		}
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound)
	{
		super.write(compound);
		compound.setInt("CrushTime", this.millTime);
		compound.setBoolean("isrun", this.isRun);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.inventory.size(); ++i)
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

	public boolean isRunning()
	{
		return isRun;
	}

	@Override
	public void tick()
	{
		boolean flag = this.isRun;
		boolean flag1 = false;
		if (!this.world.isRemote){
			if (this.isRun){
				// かきかきちゅう
				if (canOutput()){
					millTime++;
				}else{
					// 変換不可のアイテムまたは空っぽ
					this.isRun = false;
					flag1 = true;
				}
			}else{
				// とまってる
				if (canOutput()){
					this.isRun=true;
					flag1 = true;
				}
			}
			if (this.millTime > MILL_TIME_MAX){
				// かんせい
				if (this.inventory.get(1).isEmpty()){
					this.inventory.set(1,OriginalRecipie.Instance().getResultItem(ORIGINAL_RECIPIES.RECIPIE_MILLING, this.inventory.get(0)));
					this.inventory.get(1).setCount( MILL_SIZE);
				}else{
					this.inventory.get(1).grow(MILL_SIZE);
				}
				this.inventory.get(0).shrink(1);
				if (this.inventory.get(0).getCount() <= 0){
					this.inventory.set(0, ItemStack.EMPTY);
				}
				this.millTime = 0;
				flag1 = true;
			}

			if (flag != this.isRun ){
				MessageHandler.Send_MessageMillStoneUpdate(millTime, isRun, pos);
				//Mod_DiningFurniture.Net_Instance.sendToAll(new MessageMillStoneUpdate(this.millTime,this.isRun,this.pos));
			}
		}else{
			if (this.isRun ){
				this.millTime++;
	            if (ConfigValue.mill.SoundOn() &&(musecount > 30 + random.nextInt(30)))
	            {
	            	world.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundManager.sound_mill, SoundCategory.BLOCKS, this.voluem + random.nextFloat() * 0.07F, this.pitch, false);
	            	musecount = 0;
	            }else{
	            	musecount++;
	            }
			}else{
				this.millTime = 0;
				musecount = 0;
			}
			if (this.millTime > MILL_TIME_MAX){
				this.millTime = 0;
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

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
	{
		return this.isItemValidForSlot(index, itemStackIn);
	}

	@Override
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
	public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, net.minecraft.util.EnumFacing facing)
	{
		if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			if (facing == EnumFacing.DOWN)
				return (LazyOptional<T>) handlerBottom;
			else if (facing == EnumFacing.UP)
				return (LazyOptional<T>) handlerTop;
			else
				return (LazyOptional<T>) handlerSide;
		return super.getCapability(capability, facing);
	}

	@Override
	public int getSizeInventory() {
		return SIZE_INVENTORY;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return this.inventory.get(index);
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
		this.inventory.set(index, stack);
		if (!stack.isEmpty()){
			boolean flag = stack.isItemEqual(this.inventory.get(index)) && ItemStack.areItemStackTagsEqual(stack, this.inventory.get(index));

			if (stack.getCount() > this.getInventoryStackLimit())
			{
				stack.setCount(this.getInventoryStackLimit());
			}
		}else{
			this.millTime = 0;
			this.markDirty();
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		return true;

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
		return OriginalRecipie.Instance().canConvert(ORIGINAL_RECIPIES.RECIPIE_MILLING, stack);
	}

	@Override
	public int getField(int id) {
		switch (id)
		{
			case 0:
				return this.millTime;
			case 1:
				return this.isRun?1:0;
			case 3:
				return inventory.get(1).isEmpty()?0:inventory.get(1).getCount();
			default:
				return 0;
		}
	}

	@Override
	public void setField(int id, int value) {
		switch (id)
		{
			case 0:
				this.millTime = value;
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
		for (int i = 0; i < this.inventory.size(); ++i)
		{
			this.inventory.set(i,ItemStack.EMPTY);
		}
	}

	@Override
	public ITextComponent getName() {
		return this.hasCustomName() ? new TextComponentTranslation(this.customName) : new TextComponentTranslation("container.millstone");
	}

	@Override
	public boolean hasCustomName() {
		return this.customName != null && !this.customName.isEmpty();
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		 return new ContainerMillStone(playerInventory, this);
	}

	@Override
	public String getGuiID() {
		return ModCommon.MOD_ID + ":" + ModCommon.MOD_GUI_MILLSTONE_NAME;
	}

	public void setCustomInventoryName(String displayName) {
		this.customName = displayName;
	}

	public boolean canOutput(){
		return OriginalRecipie.Instance().canConvert(ORIGINAL_RECIPIES.RECIPIE_MILLING, this.inventory.get(0)) &&
				(inventory.get(1).isEmpty() || ((!inventory.get(1).isEmpty()) && inventory.get(1).getCount() <= (this.getInventoryStackLimit()-MILL_SIZE))) &&
				(inventory.get(1).isEmpty() || ((!inventory.get(1).isEmpty()) && ModUtil.compareItemStacks(inventory.get(1), OriginalRecipie.Instance().getResultItem(ORIGINAL_RECIPIES.RECIPIE_MILLING, this.inventory.get(0)))));
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket()
    {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        return new SPacketUpdateTileEntity(this.pos, 1,  this.write(nbtTagCompound));
    }

	@Override
    public void onDataPacket(net.minecraft.network.NetworkManager net, net.minecraft.network.play.server.SPacketUpdateTileEntity pkt)
    {
		this.read(pkt.getNbtCompound());
    }

	@Override
    public boolean canRenderBreaking()
    {
        return true;
    }

	@Override
	public boolean isEmpty() {
		boolean ret = true;
		for(ItemStack st : this.inventory){
			if (!st.isEmpty()){
				ret = false;
				break;
			}
		}
		return ret;
	}

	@Override
    public NBTTagCompound getUpdateTag()
    {
        NBTTagCompound cp = super.getUpdateTag();
        return this.write(cp);
    }

	@Override
    public void handleUpdateTag(NBTTagCompound tag)
    {
		super.handleUpdateTag(tag);
		this.read(tag);
    }



	@Override
	public ITextComponent getCustomName() {
		// TODO 自動生成されたメソッド・スタブ
		return this.getName();
	}
}
