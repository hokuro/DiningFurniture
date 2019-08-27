package mod.drf.recipie;

import java.util.ArrayList;
import java.util.HashMap;
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

	public boolean checkServe(ItemStack[] ings){
		boolean check = false;
		for (ItemStack stack1 : ingItem){
			if (stack1.isEmpty()){continue;}
			check = false;
			for (ItemStack stack2: ings){
				if (stack2.isEmpty()){continue;}
				if (ModUtil.compareItemStacks(stack1, stack2, CompaierLevel.LEVEL_EQUAL_ITEM)&&
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



	protected final List<String> order = new ArrayList<String>();
	protected final HashMap<String,ArrayList<OriginalMenu>> register = new HashMap<String,ArrayList<OriginalMenu>>();

	public void registerMenu(final OriginalMenu menu){
		ItemStack result = menu.getResultItem().copy();
		String key = result.getItem().getRegistryName().toString();
		if (key != null) {
			if (!register.containsKey(key)){
				register.put(key, new ArrayList<OriginalMenu>(){{add(menu);}});
				order.add(key);
			}else{
				register.get(key).add(menu);
			}
		}else {
			System.console().printf("Error");
		}
	}

	public List<ItemStack> getMenuResults(){
		if (order.size() == 0){makeMenu();}
		List<ItemStack> ret = new ArrayList<ItemStack>();
		for (String key : order){
			try {
			ret.add(register.get(key).get(0).resultItem.copy());
			ret.get(ret.size()-1).setCount(1);
			}catch(Throwable e) {
				System.console().printf("Error");
			}
		}
		return ret;
	}

	public int getMenouCount(){
		if (order.size() == 0){makeMenu();}
		return order.size();
	}

	public List<OriginalMenu> getMenuInfo(int index){
		if (order.size() == 0){makeMenu();}
		if (index >= 0 && index < order.size()){
			String key = order.get(index);
			return register.get(key);
		}
		return null;
	}

	public int getRecipiCount(int index){
		if (order.size() == 0){makeMenu();}
		if (index >= 0 && index < order.size()){
			String key = order.get(index);
			return register.get(key).size();
		}
		return 0;
	}

	public abstract void makeMenu();
}
