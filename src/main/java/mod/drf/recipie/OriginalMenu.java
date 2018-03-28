package mod.drf.recipie;

import java.util.List;

import mod.drf.util.ModUtil;
import mod.drf.util.ModUtil.CompaierLevel;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public abstract class OriginalMenu implements IOriginalMenu {
	protected final ItemStack resultItem;
	protected final ItemStack[] ingItem;

	protected OriginalMenu(){
		this(ItemStack.EMPTY,new ItemStack[]{ItemStack.EMPTY});
	}

	public OriginalMenu(ItemStack result,ItemStack[] ings){
		resultItem = result.copy();
		ingItem = ings.clone();
	}

	public int getIgetIngreadientCount(){
		return ingItem.length;
	}


	public ItemStack getResultItem(){
		return resultItem.copy();
	}

	public ItemStack getIngredient(int index){
		if (index < ingItem.length){
			return ingItem[index].copy();
		}
		return ItemStack.EMPTY;
	}

	@Override
	public OriginalMenuKind getKind() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<OriginalMenu> getMenu() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public boolean checkServe(ItemStack[] ings){
		boolean check = false;
		for (ItemStack stack1 : ingItem){
			if (stack1.isEmpty()){continue;}
			check = false;
			for (ItemStack stack2: ings){
				if (stack2.isEmpty()){continue;}
				if (ModUtil.compareItemStacks(stack1, stack2, CompaierLevel.LEVEL_EQUAL_META)&&
						stack1.getCount() <= stack2.getCount()){
					check = true;
					break;
				}
			}
			if (!check){break;}
		}
		return check;
	}

	public boolean checkServe(IInventory inv){
		ItemStack[] ings = new ItemStack[inv.getSizeInventory()];
		ItemStack add;
		for (int i = 0; i < inv.getSizeInventory(); i++){
			ings[i] = inv.getStackInSlot(i);
		}
		return checkServe(ings);
	}

	public static enum OriginalMenuKind{
		COOKING(10),
		DINING(9);

		private int length;

		private OriginalMenuKind(int len){
			this.length = len;
		}

		public int getLength(){
			return this.length;
		}
	}
}
