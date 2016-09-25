package mod.drf.core;

import java.util.ArrayList;
import java.util.List;

import mod.drf.foods.Item.ItemFoods;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class RecipeMeetPie implements IRecipe {

	private static final List<Item> recipeMeet = new ArrayList<Item>(){
		{add(Items.beef);}
		{add(Items.porkchop);}
		{add(Items.mutton);}
		{add(Items.chicken);}};
	private static final List<Item> recipeBase = new ArrayList<Item>(){{add(Items.wheat);}{add(ItemFoods.item_flour);}};
	private static final boolean[] shapeCheckR1 = {true,true,true, false,false,false, false,false,false};
	private static final boolean[] shapeCheckR2 = {false,false,false, true,true,true, false,false,false};
	private static final boolean[] shapeCheckR3 = {false,false,false, false,false,false, true,true,true};
	private static final boolean[] shapeCheckR4 = {false,true,false,true,true,true, true,true,true};

	private static final ItemStack outitem = new ItemStack(ItemFoods.item_row_meethallpie);

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
        boolean ret=false;
        if (inv.getSizeInventory() > 8){
        	   if (invShapeCheck(inv,shapeCheckR1)){
               	if (recipeMeet.contains(inv.getStackInSlot(0).getItem()) &&
               			recipeMeet.contains(inv.getStackInSlot(2).getItem()) &&
               			ItemFoods.item_row_hallpie == inv.getStackInSlot(1).getItem()){
               		ret = true;
               	}
               }else if (invShapeCheck(inv,shapeCheckR2)){
               	if (recipeMeet.contains(inv.getStackInSlot(3).getItem()) &&
               			recipeMeet.contains(inv.getStackInSlot(5).getItem()) &&
               			ItemFoods.item_row_hallpie == inv.getStackInSlot(4).getItem()){
               		ret = true;
               	}
               }else if (invShapeCheck(inv,shapeCheckR3)){
               	if (recipeMeet.contains(inv.getStackInSlot(6).getItem()) &&
               			recipeMeet.contains(inv.getStackInSlot(8).getItem()) &&
               			ItemFoods.item_row_hallpie == inv.getStackInSlot(7).getItem()){
               		ret = true;
               	}
               }else if (invShapeCheck(inv,shapeCheckR4)){
               	if (
               	Items.water_bucket == inv.getStackInSlot(1).getItem() &&
                   ItemFoods.item_butter == inv.getStackInSlot(4).getItem() &&
               	recipeMeet.contains(inv.getStackInSlot(3).getItem()) &&
               	recipeMeet.contains(inv.getStackInSlot(5).getItem()) &&
               	((Items.wheat == inv.getStackInSlot(6).getItem() &&
               	Items.wheat == inv.getStackInSlot(7).getItem() &&
               	Items.wheat == inv.getStackInSlot(8).getItem()) ||
               	(ItemFoods.item_flour == inv.getStackInSlot(6).getItem() &&
               	ItemFoods.item_flour == inv.getStackInSlot(7).getItem() &&
               	ItemFoods.item_flour == inv.getStackInSlot(8).getItem()))){
               		ret = true;
               	}
               }else{
               	ret = false;
               }
        }
        return ret;

	}

	private boolean invShapeCheck(InventoryCrafting inv, boolean[] checkArray){
		for ( int h = 0; h < inv.getHeight(); h++){
			for (int w = 0; w < inv.getWidth(); w++){
				if (checkArray[h*3+w]){
					if(inv.getStackInSlot(h*3+w) == null){
						return false;
					}
				}else{
					if(inv.getStackInSlot(h*3+w) != null){
						return false;
					}
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
