package mod.drf.foods.inventory;

import mod.drf.common.inventory.SlotInOut;
import mod.drf.recipie.OriginalRecipie;
import mod.drf.recipie.OriginalRecipie.ORIGINAL_RECIPIES;
import mod.drf.util.ModUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerFreezer extends Container {

	private final IInventory tile;
//	public int crushTime;

	public ContainerFreezer(InventoryPlayer playerInventory, IInventory tileEntityFreezer,EntityPlayer player) {
		this.tile = tileEntityFreezer;
		tileEntityFreezer.openInventory(player);
		// 冷凍スロット
		for (int i = 0; i < 3; ++i){
			for ( int j = 0; j < 9; j++){
				this.addSlotToContainer(new SlotInOut(tile, j + i * 9, 44 + j * 18, 18 + i * 18,true, ORIGINAL_RECIPIES.RECIPIE_FREEZING));
			}
		}

		// 完成品スロット
		for (int i = 3; i < 6; ++i){
			for ( int j = 0; j < 9; j++){
				this.addSlotToContainer(new SlotInOut(tile, j + i * 9, 44 + j * 18, 27 + i * 18,false, ORIGINAL_RECIPIES.RECIPIE_FREEZING));
			}
		}

		// 燃料スロット
		this.addSlotToContainer(new SlotInOut(tile,6*9, 17, 18, new ItemStack[]{new ItemStack(Blocks.ICE),new ItemStack(Blocks.PACKED_ICE)}));

		// 水スロット
		this.addSlotToContainer(new SlotInOut(tile,6*9+1, 17, 18 + 2 * 18, new ItemStack[]{new ItemStack(Items.WATER_BUCKET)}));

		// 氷スロット
		this.addSlotToContainer(new SlotInOut(tile,6*9+2, 17, 27 + 5 * 18, new ItemStack[]{new ItemStack(Items.BUCKET)}));

		// 氷スロット
		this.addSlotToContainer(new SlotInOut(tile,6*9+3, 17, 140, null));


		// プレイヤーインベントリ
		for (int i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 44 + j * 18, 140 + i * 18));
			}
		}

		// メインインベントリ
		for (int k = 0; k < 9; ++k)
		{
			this.addSlotToContainer(new Slot(playerInventory, k, 44 + k * 18, 198));
		}
	}

	public void detectAndSendChanges(){
		super.detectAndSendChanges();
//		for (int i = 0; i < this.crafters.size(); ++i){
//			ICrafting icrafting = (ICrafting)this.crafters.get(i);
//			if ( this.crushTime != this.tile.getField(0)){
//				icrafting.sendProgressBarUpdate(this, 2, this.tile.getField(0));
//			}
//		}
//		this.crushTime = this.tile.getField(0);
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.tile.isUsableByPlayer(playerIn);
	}


	public void addListener(IContainerListener listener)
	{
		super.addListener(listener);
		listener.sendAllWindowProperties(this, this.tile);
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data)
	{
		this.tile.setField(id, data);
	}

	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot)this.inventorySlots.get(index);
		// 0 ~ 26 IN
		// 27 ~ 53 OUT
		// 54      FUEL
		// 55 ~ 56 ICE
		// 57 ~ 83 INV
		// 84 ~ 92 QUIQ

		int INV_FREEZ_IN_S = 0;
		int INV_FREEZ_IN_E = 27;
		int INV_FREEZ_OT_S = 27;
		int INV_FREEZ_OT_E = 53;
		int INV_FREEZ_FU   = 54;
		int INV_FREEZ_IC_S = 55;
		int INV_FREEZ_IC_E = 56;
		int INV_FREEZ_BK   = 56;
		int INV_PLAYR_MI_S = 58;
		int INV_PLAYR_MI_E = 84;
		int INV_PLAYR_QI_S = 85;
		int INV_PLAYR_QI_E = 93;

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			// 冷蔵庫側のインベントリからプレイヤー側のインベントリへ移動
			if ((index >= INV_FREEZ_IN_S && index <= INV_FREEZ_IC_E) || index == 57 )
			{
				if (!this.mergeItemStack(itemstack1, INV_PLAYR_MI_S, INV_PLAYR_QI_E, true))
				{
					return ItemStack.EMPTY;
				}

				slot.onSlotChange(itemstack1, itemstack);
//			}
//			// 冷凍庫からプレイヤーインベントリへ移動
//			else if (index >= INV_FREEZ_IN_S && index <= INV_FREEZ_IC_E)
//			{
//					if (!this.mergeItemStack(itemstack1, INV_PLAYR_MI_S, INV_PLAYR_QI_E, false))
//					{
//						return null;
//					}
			}else{
				// 水入りバケツ
				if (ModUtil.compareItemStacks(itemstack, new ItemStack(Items.WATER_BUCKET))){
					// 製氷部屋へ移動
					if (!this.mergeItemStack(itemstack1, INV_FREEZ_IC_S, INV_FREEZ_IC_E, false))
					{
						return ItemStack.EMPTY;
					}
				}
				// 選択したいアイテムが変換可能なものならば
				else if (OriginalRecipie.Instance().canConvert(ORIGINAL_RECIPIES.RECIPIE_FREEZING, itemstack))
				{
					if (ModUtil.compareItemStacks(((Slot)this.inventorySlots.get(INV_FREEZ_IC_S)).getStack(), new ItemStack(Items.BUCKET))){
						ItemStack stack1 = ((Slot)this.inventorySlots.get(INV_FREEZ_IC_S)).getStack();
						ItemStack stack2 = ((Slot)this.inventorySlots.get(index)).getStack();
						ItemStack stack3 = stack1;
						this.inventorySlots.get(index).putStack(stack1);
						this.inventorySlots.get(INV_FREEZ_IC_S).putStack(stack2);
						((Slot)this.inventorySlots.get(INV_FREEZ_IC_S)).onSlotChanged();
						((Slot)this.inventorySlots.get(index)).onSlotChanged();

					}else{
						// 冷凍庫へ移動
						if (!this.mergeItemStack(itemstack1, INV_FREEZ_IN_S, INV_FREEZ_IN_E, false))
						{
							return ItemStack.EMPTY;
						}
					}
				}
				// 氷または氷塊
				else if (ModUtil.compareItemStacks(itemstack, new ItemStack(Blocks.ICE)) || ModUtil.compareItemStacks(itemstack, new ItemStack(Blocks.PACKED_ICE))){
					// 燃料庫へ移動
					if (!this.mergeItemStack(itemstack1, INV_FREEZ_FU, INV_FREEZ_FU+1, false))
					{
						return ItemStack.EMPTY;
					}
				}
				// バケツ
				else if(ModUtil.compareItemStacks(itemstack, new ItemStack(Items.BUCKET))){
					// 燃料庫へ移動
					if (!this.mergeItemStack(itemstack1,INV_FREEZ_BK, INV_FREEZ_BK+1, false))
					{
						return ItemStack.EMPTY;
					}
				}
				// その他
				else if (!this.mergeItemStack(itemstack1, INV_PLAYR_MI_S, INV_PLAYR_QI_E, false))
				{
					return ItemStack.EMPTY;
				}

			}
			if (itemstack1.getCount() == 0)
			{
				slot.putStack(ItemStack.EMPTY);
			}
			else
			{
				slot.onSlotChanged();
			}

			if (itemstack1.getCount() == itemstack.getCount())
			{
				return ItemStack.EMPTY;
			}

			slot.onTake(playerIn, itemstack1);
		}

		return itemstack;
	}


	@Override
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);
        this.tile.closeInventory(playerIn);
    }

}
