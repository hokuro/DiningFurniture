package mod.drf.core;

import java.util.ArrayList;
import java.util.List;

import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.block.BlockFoods;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class RecipeMeetPizza implements IRecipe {

	private static final List<Item> recipeMeet = new ArrayList<Item>(){
		{add(Items.beef);}
		{add(Items.porkchop);}
		{add(Items.mutton);}
		{add(Items.chicken);}};
	private static final List<Item> recipeBase = new ArrayList<Item>(){{add(Items.wheat);}{add(ItemFoods.item_flour);}};
	private static final boolean[] shapeCheckR1 = {true,true,true, true,true,true, false,false,false};
	private static final boolean[] shapeCheckR2 = {false,false,false, true,true,true, true,true,true};
	private static final ItemStack outitem = new ItemStack(ItemFoods.item_row_meetpizza);

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
        boolean ret=false;
        int h = -1;
        if (invShapeCheck(inv,shapeCheckR1)){
        	h = 0;
        }else if (invShapeCheck(inv,shapeCheckR2)){
        	h = 1;
        }
        if (h >= 0){
        	if (
        	recipeMeet.contains(inv.getStackInRowAndColumn(h,0)) &&
        	recipeMeet.contains(inv.getStackInRowAndColumn(h,2)) &&
        	(new ItemStack(BlockFoods.block_cheese).getItem()) == inv.getStackInRowAndColumn(h, 1).getItem()  &&
        	((Items.wheat == inv.getStackInRowAndColumn(h+1,0).getItem() &&
        	Items.wheat == inv.getStackInRowAndColumn(h+1,1).getItem() &&
        	Items.wheat == inv.getStackInRowAndColumn(h+1,2).getItem()) ||
        	(ItemFoods.item_flour == inv.getStackInRowAndColumn(h+1,0).getItem() &&
        	ItemFoods.item_flour == inv.getStackInRowAndColumn(h+1,1).getItem() &&
        	ItemFoods.item_flour == inv.getStackInRowAndColumn(h+1,2).getItem()))){
        		ret = true;
        	}
        }else{
        	ret = false;
        }
        return ret;

	}

	private boolean invShapeCheck(InventoryCrafting inv, boolean[] checkArray){
		for ( int h = 0; h < inv.getHeight(); h++){
			for (int w = 0; w < inv.getWidth(); w++){
				if (checkArray[h*3+w] && inv.getStackInRowAndColumn(h,w) == null){
					return false;
				}else if (checkArray[h*3+w] && inv.getStackInRowAndColumn(h, w) != null){
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
        return outitem;
	}

	@Override
	public int getRecipeSize() {
		return 10;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return outitem;
	}

	@Override
	public ItemStack[] getRemainingItems(InventoryCrafting inv) {
        ItemStack[] aitemstack = new ItemStack[inv.getSizeInventory()];

        for (int i = 0; i < aitemstack.length; ++i)
        {
            ItemStack itemstack = inv.getStackInSlot(i);
            aitemstack[i] = net.minecraftforge.common.ForgeHooks.getContainerItem(itemstack);
        }

        return aitemstack;
	}

}
