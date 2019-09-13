package mod.drf.inventory;

import java.util.ArrayList;
import java.util.List;

import mod.drf.core.Mod_DiningFurniture;
import mod.drf.network.MessageSelectMenu;
import mod.drf.recipie.FurnitureMenu;
import mod.drf.recipie.OriginalMenu;
import mod.drf.util.ModUtil;
import mod.drf.util.ModUtil.CompaierLevel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ContainerFurnitureWorkBench extends Container {

	private InventoryOriginalWorkBenchIngredients invIng;
	private InventoryOriginalWorkBenchResult invResult;
	private InventoryOriginalMenu invMenu;

	private  OriginalMenu menu;
	private PlayerInventory plInv;

	private int idxIngredientsEnd;
	private int idxResultEnd;
	private int idxMenuStart;
	private int idxMenuEnd;
	private int idxPlyaerInvStart;
	private int selectMenu;

	public ContainerFurnitureWorkBench(int wid, PlayerInventory playerInv) {
		super(Mod_DiningFurniture.CONTAINER_FURNITUREWORKBENCH,wid);
		menu = FurnitureMenu.getInstance();
		plInv = playerInv;

		invIng = new InventoryOriginalWorkBenchIngredients(this, menu.getKind().getLength());
		invResult = new InventoryOriginalWorkBenchResult(this);
		invMenu = new InventoryOriginalMenu(this, menu.getMenouCount());

		int slotIdx = 0;
		// 材料スロット
		for (int i = 0; i < 9; i++){
			this.addSlot(new SlotInOut(invIng, i, 8 + i * 18, 38, false));
		}
		slotIdx = 9;
		idxIngredientsEnd = slotIdx;

		// 完成品スロット
		this.addSlot(new SlotInOut(invResult,0, 152, 59,false));
		idxResultEnd = slotIdx;

		// メニューインベントリ
		idxMenuStart = slotIdx + 1;
		idxMenuEnd = idxMenuStart + invMenu.ROW*invMenu.COL;
		for (int k = 0; k < invMenu.ROW; k++){
			for (int l = 0; l < invMenu.COL; l++){
				this.addSlot(new SlotInOut(invMenu, l + k*invMenu.COL, 177 + l * 18, 16 + k * 18,false));
			}
		}

		idxPlyaerInvStart = idxMenuEnd;
		// プレイヤーインベントリ
        for (int k = 0; k < 3; ++k)
        {
            for (int i1 = 0; i1 < 9; ++i1)
            {
                this.addSlot(new Slot(playerInv, i1 + k * 9 + 9, 8 + i1 * 18, 106 + k * 18));
            }
        }

        for (int l = 0; l < 9; ++l)
        {
            this.addSlot(new Slot(playerInv, l, 8 + l * 18, 164));
        }

        // メニューセット
        this.invMenu.setMenu(menu.getMenuResults());
        this.selectMenu = -1;
	}

	public void setArrowIngredients(List<List<ItemStack>> ings){
		for (int i = 0; i < menu.getKind().getLength(); i++){
			((SlotInOut)this.inventorySlots.get(i)).CleanArrowItem();
			((SlotInOut)this.inventorySlots.get(i)).addArrowItem(ings.get(i).toArray(new ItemStack[ings.get(i).size()]));

		}
	}

	public int getMenuStart(){
		return idxMenuStart;
	}

	public IInventory getIngredients(){
		return this.invIng;
	}

	public IInventory getResult(){
		return this.invResult;
	}

	public IInventory getMenu(){
		return this.invMenu;
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
	}

	@Override
    public void onContainerClosed(PlayerEntity playerIn)
    {
        super.onContainerClosed(playerIn);

        if (!this.plInv.player.world.isRemote)
        {
            this.clearContainer(playerIn, this.plInv.player.world, this.invIng);
        }
    }


	@Override
	  public ItemStack transferStackInSlot(PlayerEntity playerIn, int index)
	  {
	        ItemStack itemstack = ItemStack.EMPTY;
	        Slot slot = this.inventorySlots.get(index);

	        if (slot != null && slot.getHasStack())
	        {
	            ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();

	            // 材料インベントリからプレイヤーへ
	            if (index < this.idxIngredientsEnd){
	                itemstack1.getItem().onCreated(itemstack1, this.plInv.player.world, playerIn);

	                if (!this.mergeItemStack(itemstack1, this.idxPlyaerInvStart, this.idxPlyaerInvStart+36, false))
	                {
	                    return ItemStack.EMPTY;
	                }
	            }else if(index < this.idxResultEnd+1){
	            	// 完成品インベントリからプレイヤーへ
	                itemstack1.getItem().onCreated(itemstack1, plInv.player.world, playerIn);

	                if (!this.mergeItemStack(itemstack1, this.idxPlyaerInvStart, this.idxPlyaerInvStart+36, false))
	                {
	                    return ItemStack.EMPTY;
	                }
	            }else if (this.idxPlyaerInvStart < index && index < this.idxPlyaerInvStart+36){
		            // プレイヤーインベントリから材料インベントリへ
	                itemstack1.getItem().onCreated(itemstack1, this.plInv.player.world, playerIn);

	                if (!this.mergeItemStack(itemstack1, 0, this.idxIngredientsEnd, false))
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

	public void setSelectMenu(MessageSelectMenu mess) {
		// メニューをスクロール
		invMenu.scrollTo(mess.getScrollIdx());

			// 選択されたメニューの番号を計算
		selectMenu = mess.getSelectIdx() + invMenu.getField(InventoryOriginalMenu.FIELD_SCROLL) * InventoryOriginalMenu.COL;

		List<OriginalMenu> m = menu.getMenuInfo(selectMenu);
		// 出来上がりをセット
		invResult.setInventorySlotContents(0, m.get(0).getResultItem());

		// スロットの設定
		// 許可リスト
		List<List<ItemStack>> arrow = new ArrayList<List<ItemStack>>();
		for (int i = 0; i < menu.getKind().getLength(); i++){
			arrow.add(new ArrayList<ItemStack>());
		}

		// 材料を取得
		for (OriginalMenu mitem : m){
			for (int i = 0; i < mitem.getIgetIngreadientCount(); i++){
				arrow.get(i).add(mitem.getIngredient(i));
			}
		}
		this.setArrowIngredients(arrow);
	}

	public void toServe(){
		try{
			if (selectMenu < 0 && selectMenu >= menu.getMenouCount()){return;}
			List<OriginalMenu> m = menu.getMenuInfo(selectMenu);
			for (OriginalMenu mItem : m){
				if (mItem.checkServe(this.invIng)){
					// 作成に必要なアイテムを減らす
					for (int i = 0;i < mItem.getIgetIngreadientCount(); i++){
						ItemStack ingItem = mItem.getIngredient(i);
						for (int j = 0; j < this.invIng.getSizeInventory(); j++){
							ItemStack item = this.invIng.getStackInSlot(j);
							if (ModUtil.compareItemStacks(item, ingItem, CompaierLevel.LEVEL_EQUAL_ITEM)){
								if (item.getItem() == Items.WATER_BUCKET || item.getItem() == Items.MILK_BUCKET){
									// 中身入りバケツの場合中身だけ使用する
									item = new ItemStack(Items.BUCKET,1);
								}else{
									item.shrink(ingItem.getCount());
									if (item.getCount() <= 0){
										item = ItemStack.EMPTY;
									}
								}
								this.invIng.setInventorySlotContents(j, item);
							}
						}
					}

					ItemStack result = mItem.getResultItem().copy();
					// 出来上がりをプレイヤーインベントリに移す
			        if (!plInv.player.isAlive() || plInv.player instanceof ServerPlayerEntity && ((ServerPlayerEntity)plInv.player).hasDisconnected())
			        {
			        	plInv.player.dropItem(result, false);
			        }
			        else
			        {
			        	plInv.player.inventory.placeItemBackInInventory(plInv.player.world, result);
			        }
			        break;
				}
			}
		}catch(ArrayIndexOutOfBoundsException aobex){

		}
	}
}
