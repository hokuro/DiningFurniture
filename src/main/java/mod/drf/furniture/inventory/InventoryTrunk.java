package mod.drf.furniture.inventory;

import mod.drf.core.ModCommon;
import mod.drf.furniture.item.ItemTrunk;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class InventoryTrunk implements IInventory{
		//トランクデータ
		private SavedDataTrunk data;
		private int page;

		// コンストラクタ
		public InventoryTrunk(ItemStack hdbag, World world, int next)
		{
			// トランク内のデータを取得
			data = ItemTrunk.getTrunkData(hdbag, world);
			page = next;
		}

		public int Page(){return page;}

		@Override
		public String getName() {
			// TODO 自動生成されたメソッド・スタブ
			return  ModCommon.MOD_TRUNK_GUI_NAME;
		}

		@Override
		public int getSizeInventory() {
			// TODO 自動生成されたメソッド・スタブ
			return this.data.items.length;
		}

		@Override
		public ItemStack getStackInSlot(int index) {
			// TODO 自動生成されたメソッド・スタブ
			return this.data.items[index+(page*ModCommon.TrunkCsize*ModCommon.TrunkRsize)];
		}

		@Override
		public ItemStack decrStackSize(int index, int count) {
			// TODO 自動生成されたメソッド・スタブ
			int idx = index +(page*ModCommon.TrunkCsize*ModCommon.TrunkRsize);
			if (this.data.items[idx] != null)
			{
				if (this.data.items[idx].stackSize <= count)
				{
					ItemStack item = this.data.items[idx];
					this.data.items[idx] = null;
					markDirty();
					return item;
				}
				ItemStack item = this.data.items[idx].splitStack(count);
				if (this.data.items[idx].stackSize == 0)
				{
					this.data.items[idx] = null;
				}
                this.markDirty();
				return item;
			}
			return null;
		}

		@Override
		public void setInventorySlotContents(int index, ItemStack stack) {
			// TODO 自動生成されたメソッド・スタブ
			this.data.items[index+(page*ModCommon.TrunkCsize*ModCommon.TrunkRsize)] = stack;
		}

		@Override
		public int getInventoryStackLimit() {
			// TODO 自動生成されたメソッド・スタブ
			return ModCommon.MOD_TRUNK_STACKSIZE;
		}

		@Override
		public void markDirty() {
			// TODO 自動生成されたメソッド・スタブ
			data.upDate = true;
		}

		@Override
		public void closeInventory(EntityPlayer player) {
			// TODO 自動生成されたメソッド・スタブ
			this.markDirty();
		}

		@Override
		public boolean isItemValidForSlot(int index, ItemStack stack) {
			// TODO 自動生成されたメソッド・スタブ
			 return !(stack.getItem() instanceof ItemTrunk);
		}

		@Override
		public int getField(int id) {
			// TODO 自動生成されたメソッド・スタブ
			return 0;
		}

		@Override
		public int getFieldCount() {
			// TODO 自動生成されたメソッド・スタブ
			return 0;
		}


		@Override
		public boolean hasCustomName() {
			// TODO 自動生成されたメソッド・スタブ
			return false;
		}

		@Override
		public ITextComponent getDisplayName() {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}

		@Override
		public void openInventory(EntityPlayer player) {
			// TODO 自動生成されたメソッド・スタブ
		}

		@Override
		public boolean isUseableByPlayer(EntityPlayer player) {
			// TODO 自動生成されたメソッド・スタブ
			return true;
		}

		@Override
		public ItemStack removeStackFromSlot(int index) {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}

		@Override
		public void setField(int id, int value) {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void clear() {
			// TODO 自動生成されたメソッド・スタブ

		}

}
