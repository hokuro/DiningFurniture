package mod.drf.foods.tileentity;

import mod.drf.inventory.ICnvertInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.ITickable;

public class TileEntityFlapeMaker extends TileEntityLockable implements ITickable, ICnvertInventory {

	@Override
	public int getSizeInventory() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public int getInventoryStackLimit() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
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
		// TODO 自動生成されたメソッド・スタブ
		return false;
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
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public String getName() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean hasCustomName() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String getGuiID() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void setCustomInventoryName(String displayName) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
