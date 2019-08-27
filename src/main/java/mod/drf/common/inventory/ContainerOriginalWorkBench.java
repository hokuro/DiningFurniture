package mod.drf.common.inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.Item.ItemSyrup;
import mod.drf.network.MessageSelectMenu;
import mod.drf.recipie.CookingMenu;
import mod.drf.recipie.OriginalMenu;
import mod.drf.recipie.OriginalMenu.OriginalMenuKind;
import mod.drf.util.ModUtil;
import mod.drf.util.ModUtil.CompaierLevel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ContainerOriginalWorkBench extends Container {

	private InventoryOriginalWorkBenchIngredients invIng;
	private InventoryOriginalWorkBenchResult invResult;
	private InventoryOriginalMenu invMenu;

	private final World world;
	private final BlockPos pos;
	private final EntityPlayer player;
	private final OriginalMenu menu;

	private int idxIngredientsEnd;
	private int idxResultEnd;
	private int idxMenuStart;
	private int idxMenuEnd;
	private int idxPlyaerInvStart;

	private int selectMenu;
	public ContainerOriginalWorkBench(InventoryPlayer playerIn, World worldIn, BlockPos posIn, OriginalMenu menuIn){
		world = worldIn;
		pos = posIn;
		player = playerIn.player;
		menu = menuIn;

		invIng = new InventoryOriginalWorkBenchIngredients(this, menuIn.getKind().getLength());
		invResult = new InventoryOriginalWorkBenchResult(this);
		invMenu = new InventoryOriginalMenu(this, menuIn.getMenouCount());

		int slotIdx = 0;
		// 材料スロット
		for (int i = 0; i < 9; i++){
			this.addSlot(new SlotInOut(invIng, i, 8 + i * 18, 38, false));
		}
		slotIdx = 9;
		if (menu.getKind() == OriginalMenu.OriginalMenuKind.COOKING){
			// トッピングスロット
			this.addSlot(new SlotInOut(invIng,slotIdx, 116, 59, false));
			slotIdx++;
		}
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
                this.addSlot(new Slot(playerIn, i1 + k * 9 + 9, 8 + i1 * 18, 106 + k * 18));
            }
        }

        for (int l = 0; l < 9; ++l)
        {
            this.addSlot(new Slot(playerIn, l, 8 + l * 18, 164));
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
	public boolean canInteractWith(EntityPlayer playerIn) {
        return true;//playerIn.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	}

	@Override
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);

        if (!this.world.isRemote)
        {
            this.clearContainer(playerIn, this.world, this.invIng);
        }
    }


	@Override
	  public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	  {
	        ItemStack itemstack = ItemStack.EMPTY;
	        Slot slot = this.inventorySlots.get(index);

	        if (slot != null && slot.getHasStack())
	        {
	            ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();

	            // 材料インベントリからプレイヤーへ
	            if (index < this.idxIngredientsEnd){
	                itemstack1.getItem().onCreated(itemstack1, this.world, playerIn);

	                if (!this.mergeItemStack(itemstack1, this.idxPlyaerInvStart, this.idxPlyaerInvStart+36, false))
	                {
	                    return ItemStack.EMPTY;
	                }
	            }else if(index < this.idxResultEnd+1){
	            	// 完成品インベントリからプレイヤーへ
	                itemstack1.getItem().onCreated(itemstack1, this.world, playerIn);

	                if (!this.mergeItemStack(itemstack1, this.idxPlyaerInvStart, this.idxPlyaerInvStart+36, false))
	                {
	                    return ItemStack.EMPTY;
	                }
	            }else if (this.idxPlyaerInvStart < index && index < this.idxPlyaerInvStart+36){
		            // プレイヤーインベントリから材料インベントリへ
	                itemstack1.getItem().onCreated(itemstack1, this.world, playerIn);

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
			arrow.add(new ArrayList());
		}

		// 材料を取得
		for (OriginalMenu mitem : m){
			for (int i = 0; i < mitem.getIgetIngreadientCount(); i++){
				arrow.get(i).add(mitem.getIngredient(i));
			}

			if (menu.getKind() == OriginalMenuKind.COOKING){
				if (((CookingMenu)mitem).isTopping()){
					CookingMenu cm = ((CookingMenu)mitem);
					arrow.get(menu.getKind().getLength()-1).addAll(Arrays.asList(cm.getToppings()));
				}else{
				}
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
									 if (item.getItem() instanceof ItemSyrup){
											// 出来上がりをプレイヤーインベントリに移す
									        if (!player.isAlive() || player instanceof EntityPlayerMP && ((EntityPlayerMP)player).hasDisconnected())
									        {
									        	player.dropItem(new ItemStack(Items.GLASS_BOTTLE,ingItem.getCount()), false);
									        }
									        else
									        {
									        	player.inventory.placeItemBackInInventory(world, new ItemStack(Items.GLASS_BOTTLE,ingItem.getCount()));
									        }
									 }else if (item.getItem() == ItemFoods.item_syrupmilk){
											// 出来上がりをプレイヤーインベントリに移す
									        if (!player.isAlive() || player instanceof EntityPlayerMP && ((EntityPlayerMP)player).hasDisconnected())
									        {
									        	player.dropItem(new ItemStack(Items.BUCKET,ingItem.getCount()), false);
									        }
									        else
									        {
									        	player.inventory.placeItemBackInInventory(world, new ItemStack(Items.BUCKET,ingItem.getCount()));
									        }
									 }
									item.shrink(ingItem.getCount());
									if (item.getCount() <= 0){
										item = ItemStack.EMPTY;
									}
								}
								this.invIng.setInventorySlotContents(j, item);
							}
						}
					}

					if (mItem.getKind() == OriginalMenuKind.COOKING){
						// cookingの場合トッピングも減らす
						ItemStack item = this.invIng.getStackInSlot(OriginalMenuKind.COOKING.getLength()-1);
						if (ModUtil.containItemStack(item, ((CookingMenu)mItem).getToppings(),CompaierLevel.LEVEL_EQUAL_ITEM)){
							if (item.getItem() == Items.WATER_BUCKET || item.getItem() == Items.MILK_BUCKET){
								// 中身入りバケツの場合中身だけ使用する
								item = new ItemStack(Items.BUCKET,1);
							}else{
								 if (item.getItem() instanceof ItemSyrup){
								        if (!player.isAlive() || player instanceof EntityPlayerMP && ((EntityPlayerMP)player).hasDisconnected())
								        {
								        	player.dropItem(new ItemStack(Items.GLASS_BOTTLE,1), false);
								        }
								        else
								        {
								        	player.inventory.placeItemBackInInventory(world, new ItemStack(Items.GLASS_BOTTLE,1));
								        }
								 }else if (item.getItem() == ItemFoods.item_syrupmilk){
								        if (!player.isAlive() || player instanceof EntityPlayerMP && ((EntityPlayerMP)player).hasDisconnected())
								        {
								        	player.dropItem(new ItemStack(Items.BUCKET,1), false);
								        }
								        else
								        {
								        	player.inventory.placeItemBackInInventory(world, new ItemStack(Items.BUCKET,1));
								        }
								 }
								item.shrink(1);
								if (item.getCount() <= 0){
									item = ItemStack.EMPTY;
								}
							}
							this.invIng.setInventorySlotContents(OriginalMenuKind.COOKING.getLength()-1, item);
						}
					}


					// 出来上がりをプレイヤーインベントリに移す
			        if (!player.isAlive() || player instanceof EntityPlayerMP && ((EntityPlayerMP)player).hasDisconnected())
			        {
			        	player.dropItem(mItem.getResultItem().copy(), false);
			        }
			        else
			        {
			        	player.inventory.placeItemBackInInventory(world, mItem.getResultItem().copy());
			        }
			        break;
				}
			}
		}catch(ArrayIndexOutOfBoundsException aobex){

		}
	}
}
