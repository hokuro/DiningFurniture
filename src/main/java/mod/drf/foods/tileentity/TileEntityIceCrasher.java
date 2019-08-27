package mod.drf.foods.tileentity;

import java.util.Random;

import mod.drf.config.ConfigValue;
import mod.drf.core.ModCommon;
import mod.drf.core.Mod_DiningFurniture;
import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.inventory.ContainerIceCrasher;
import mod.drf.foods.inventory.ICnvertInventory;
import mod.drf.network.MessageHandler;
import mod.drf.recipie.OriginalRecipie;
import mod.drf.recipie.OriginalRecipie.ORIGINAL_RECIPIES;
import mod.drf.sounds.SoundManager;
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

public class TileEntityIceCrasher extends TileEntityLockable implements ITickable, ICnvertInventory {
	public static final String REGISTER_NAME = "tileentityicecrasher";
	public static final int CRUSH_TIME_MAX = 300;
	public static final int CRUSH_SIZE = 4;
	public static final int SIZE_INVENTORY = 3;

	private static final int S_IN1 = 0;
	private static final int S_IN2 = 1;
	private static final int S_OT1 = 2;

	private Random random = new Random();
	private NonNullList<ItemStack> inventory;
	private String customName;
	private boolean isRun;
	private int crushTime;
	private EnumFacing facing;
	private int sound_count = 0;
	private int sound_count_max = 20;
	private int sound_count_rand = 30;

	private static final int[] slotsTop = new int[] {0,1};
	private static final int[] slotsBottom = new int[] {2};
	private static final int[] slotsSides = new int[] {0,1};

	public TileEntityIceCrasher(){
		super(Mod_DiningFurniture.RegistryEvents.ICECRASHER);
		inventory = NonNullList.<ItemStack>withSize(SIZE_INVENTORY, ItemStack.EMPTY);
		isRun = false;
		crushTime = 0;
		this.clear();
	}

	@Override
	public void read(NBTTagCompound compound)
	{
		super.read(compound);
		//NBTTagList nbttaglist = compound.getTagList("Items", 10);
		//this.inventory = new ItemStack[this.getSizeInventory()];

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

		this.crushTime = compound.getInt("CrushTime");
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
		compound.setInt("CrushTime", this.crushTime);
		compound.setBoolean("isrun", this.isRun);

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

	public boolean isRunning()
	{
		return isRun;
	}

	public boolean isSetIce(){
		return (!inventory.get(S_IN1).isEmpty());
	}

	public boolean isSetBowl(){
		return (!inventory.get(S_IN2).isEmpty());
	}

//	public EnumFacing face(){
//		return this.facing;
//	}


	@Override
	public void tick()
	{
		boolean flag = this.isRun;
		boolean flag1 = false;
		if (!this.world.isRemote){
			if (this.isRun){
				// かきかきちゅう
				if (canOutput()){
					crushTime++;
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
			if (this.crushTime > CRUSH_TIME_MAX){
				// かきごおりかんせい
				if (this.inventory.get(S_OT1).isEmpty()){
					this.inventory.set(S_OT1,OriginalRecipie.Instance().getResultItem(ORIGINAL_RECIPIES.RECIPIE_CRASHING, this.inventory.get(S_IN1)));
					this.inventory.get(S_OT1).setCount(CRUSH_SIZE);
				}else{
					this.inventory.get(S_OT1).grow(CRUSH_SIZE);
				}

				if (!this.inventory.get(S_IN1).isEmpty()){
					this.inventory.get(S_IN1).shrink(1);
					if (this.inventory.get(S_IN1).getCount() <= 0){
						this.inventory.set(S_IN1, ItemStack.EMPTY);
					}
				}

				if (!this.inventory.get(S_IN2).isEmpty()){
					this.inventory.get(S_IN2).shrink(CRUSH_SIZE);
					if(this.inventory.get(S_IN2).getCount() <= 0){
						this.inventory.set(S_IN2, ItemStack.EMPTY);
					}
				}
				this.crushTime = 0;
				flag1 = true;
			}

			if (flag != this.isRun){
				MessageHandler.Send_MessageIceCrasherUpdate(crushTime, isRun, pos);
				//Mod_DiningFurniture.Net_Instance.sendToAll(new MessageIceCrasherUpdate(this.crushTime,this.isRun,this.pos));
			}
		}else{
			if (this.isRun && canOutput()){
				this.crushTime++;
	            if (ConfigValue.crashedice.SoundOn() &&(sound_count >= sound_count_max + random.nextInt(sound_count_rand)))
	            {
	            	world.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundManager.sound_makeflape, SoundCategory.BLOCKS, 0.4F + random.nextFloat()*0.3F, 1.0F, false);
	            	sound_count = 0;
	            }else{
	            	sound_count++;
	            }
			}else{
				this.crushTime = 0;
			}
			if (this.crushTime > CRUSH_TIME_MAX){
				this.crushTime = 0;
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
	@Override
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
	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
	{
		if (direction == EnumFacing.DOWN && index == 2)
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
		if (this.inventory.get(index).isEmpty()){
			return ItemStack.EMPTY;
		}
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

			if (!flag)
			{
				this.crushTime = 0;
				this.markDirty();
			}
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
		switch(index){
		case S_IN1:
			return OriginalRecipie.Instance().canConvert(ORIGINAL_RECIPIES.RECIPIE_CRASHING, stack);
		case S_IN2:
			return (stack.getItem()==ItemFoods.item_icefoodbowl);
		default:
			return false;
		}
	}

	@Override
	public int getField(int id) {
		switch (id)
		{
			case 0:
				return this.crushTime;
			case 1:
				return this.isRun?1:0;
			case 3:
				return inventory.get(S_OT1).isEmpty()?0:inventory.get(S_OT1).getCount();
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
				break;
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
		return this.hasCustomName() ? new TextComponentTranslation(this.customName) : new TextComponentTranslation("container.icecrasher");
	}

	@Override
	public boolean hasCustomName() {
		return this.customName != null && !this.customName.isEmpty();
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		 return new ContainerIceCrasher(playerInventory, this);
	}

	@Override
	public String getGuiID() {
		return ModCommon.MOD_ID + ":" + ModCommon.MOD_GUI_ICECRASHER_NAME;
	}

	public void setCustomInventoryName(String displayName) {
		this.customName = displayName;
	}

	public boolean canOutput(){
		// 氷が入っているか確認
		boolean inIce = OriginalRecipie.Instance().canConvert(ORIGINAL_RECIPIES.RECIPIE_CRASHING, this.inventory.get(S_IN1));
		// ボウルが入っているか確認
		boolean inBowl = (!inventory.get(S_IN2).isEmpty() && (inventory.get(S_IN2).getItem()==ItemFoods.item_icefoodbowl && inventory.get(S_IN2).getCount() >=4));
		// 出力側の数を確認
		boolean outIce = inventory.get(S_OT1).isEmpty() || (!inventory.get(S_OT1).isEmpty() && inventory.get(S_OT1).getCount() <= (this.getInventoryStackLimit()-CRUSH_SIZE));

		return inIce && inBowl && outIce;
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket()
    {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        return new SPacketUpdateTileEntity(this.pos, 1, this.write(nbtTagCompound));
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
		for (ItemStack st: this.inventory){
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
		return this.getName();
	}
}
