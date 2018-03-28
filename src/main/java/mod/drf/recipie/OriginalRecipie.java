package mod.drf.recipie;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.Item.ItemFoods.EnumFlapeSyrup;
import mod.drf.foods.Item.ItemFoods.EnumFlowerHalb;
import mod.drf.foods.Item.ItemFoods.EnumIceFlavor;
import mod.drf.util.ModUtil;
import net.minecraft.block.BlockDoublePlant.EnumPlantType;
import net.minecraft.block.BlockFlower.EnumFlowerType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class OriginalRecipie {

	private Map<ItemStack, ItemStack> millingList = Maps.<ItemStack,ItemStack>newHashMap();
	private Map<ItemStack, ItemStack> crashingList = Maps.<ItemStack,ItemStack>newHashMap();
	private Map<ItemStack, ItemStack> freezingList = Maps.<ItemStack,ItemStack>newHashMap();

	private static final OriginalRecipie instance = new OriginalRecipie();

	private OriginalRecipie(){
		// Milling
		addRecipie(new ItemStack(Items.BEEF), new ItemStack(ItemFoods.item_millbeef,1), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Items.PORKCHOP), new ItemStack(ItemFoods.item_millpoke), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Items.CHICKEN), new ItemStack(ItemFoods.item_millchikin), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Items.MUTTON), new ItemStack(ItemFoods.item_millmutton), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Items.WHEAT),new ItemStack(ItemFoods.item_flour), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.DOUBLE_PLANT,1,EnumPlantType.SUNFLOWER.getMeta()), new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.SUNFLOWER.getDamage()), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.DOUBLE_PLANT,1,EnumPlantType.ROSE.getMeta()), new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.ROSE.getDamage()), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.DOUBLE_PLANT,1,EnumPlantType.PAEONIA.getMeta()), new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.PEONY.getDamage()), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.DOUBLE_PLANT,1,EnumPlantType.SYRINGA.getMeta()), new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.LILAC.getDamage()), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.RED_FLOWER,1,EnumFlowerType.ALLIUM.getMeta()), new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.ALLIUM.getDamage()), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.RED_FLOWER,1,EnumFlowerType.PINK_TULIP.getMeta()), new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.TULIP.getDamage()), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.RED_FLOWER,1,EnumFlowerType.ORANGE_TULIP.getMeta()), new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.TULIP.getDamage()), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.RED_FLOWER,1,EnumFlowerType.RED_TULIP.getMeta()), new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.TULIP.getDamage()), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.RED_FLOWER,1,EnumFlowerType.WHITE_TULIP.getMeta()), new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.TULIP.getDamage()), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.RED_FLOWER,1,EnumFlowerType.BLUE_ORCHID.getMeta()), new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.ORCHID.getDamage()), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.YELLOW_FLOWER), new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.DANDELION.getDamage()), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.RED_FLOWER,1,EnumFlowerType.HOUSTONIA.getMeta()), new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.AZUREBLUET.getDamage()), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.RED_FLOWER,1,EnumFlowerType.OXEYE_DAISY.getMeta()), new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.OXEYDAISY.getDamage()), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.RED_FLOWER,1,EnumFlowerType.POPPY.getMeta()), new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.POPY.getDamage()), ORIGINAL_RECIPIES.RECIPIE_MILLING);

		// Chasshing
		addRecipie(new ItemStack(Blocks.ICE,1,32767), new ItemStack(ItemFoods.item_crashedice,1,0), ORIGINAL_RECIPIES.RECIPIE_CRASHING);
		addRecipie(new ItemStack(Blocks.PACKED_ICE,1,32767), new ItemStack(ItemFoods.item_crashedice,1,0), ORIGINAL_RECIPIES.RECIPIE_CRASHING);

		// Freezing
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_VANILA.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_VANILA.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_BLACK.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_BLACK.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_RED.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_RED.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_GREEN.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_GREEN.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_BROWN.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_BROWN.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_BLUE.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_BLUE.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_PURPLE.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_PURPLE.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_CYAN.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_CYAN.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_SILVER.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_SILVER.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_GRAY.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_GRAY.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_PINK.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_PINK.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_LIME.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_LIME.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_YELLOW.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_YELLOW.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_LIGHT_BLUE.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_LIGHT_BLUE.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_MAGENTA.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_MAGENTA.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_ORANGE.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_ORANGE.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_WHITE.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_WHITE.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_APPLE.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_APPLE.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_CACTUS.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_CACTUS.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_PUMPKIN.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_PUMPKIN.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_POTATO.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_POTATO.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_CARROT.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_CARROT.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_MELLON.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_MELLON.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_icemix,1,EnumIceFlavor.ICE_GREENTEA.getDamage()), new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.ICE_GREENTEA.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);

		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_NONE.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_NONE.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_SUGAR.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_SUGAR.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_BLACK.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_BLACK.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_RED.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_RED.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_GREEN.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_GREEN.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_BROWN.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_BROWN.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_BLUE.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_BLUE.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_PURPLE.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_PURPLE.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_CYAN.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_CYAN.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_SILVER.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_SILVER.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_GRAY.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_GRAY.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_PINK.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_PINK.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_LIME.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_LIME.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_YELLOW.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_YELLOW.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_LIGHT_BLUE.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_LIGHT_BLUE.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_MAGENTA.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_MAGENTA.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_ORANGE.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_ORANGE.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_WHITE.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_WHITE.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_APPLE.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_APPLE.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_CACTUS.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_CACTUS.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_MELLON.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_MELLON.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_PUMPKIN.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_PUMPKIN.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.SYRUP_GREENTEA.getDamage()), new ItemStack(ItemFoods.item_icecandy,1,EnumFlapeSyrup.SYRUP_GREENTEA.getDamage()), ORIGINAL_RECIPIES.RECIPIE_FREEZING);

		addRecipie(new ItemStack(Items.WATER_BUCKET), new ItemStack(Blocks.ICE), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
	}

	public static OriginalRecipie Instance(){return instance;}

	private Map<ItemStack, ItemStack> getList(ORIGINAL_RECIPIES kind){
		switch(kind){
		case RECIPIE_CRASHING:
			return crashingList;
		case RECIPIE_FREEZING:
			return freezingList;
		case RECIPIE_MILLING:
			return millingList;
		default:
			break;

		}
		return null;
	}


	public void addRecipie(ItemStack input, ItemStack output, ORIGINAL_RECIPIES kind) throws IllegalArgumentException{

		Map<ItemStack,ItemStack> list = getList(kind);
		if (list == null) {new IllegalArgumentException();}
        if (getResultItem(list, input) != null) { net.minecraftforge.fml.common.FMLLog.info("Ignored smelting recipe with conflicting input: " + input + " = " + output); return; }
        list.put(input, output);
	}

	public boolean canConvert(ORIGINAL_RECIPIES kind, ItemStack input)throws IllegalArgumentException{
		if ( input == null) {return false;}
		Map<ItemStack,ItemStack> list = getList(kind);
		if (list == null) {new IllegalArgumentException();}

		return (getResultItem(list,input)!=null);
	}

	public ItemStack getResultItem(ORIGINAL_RECIPIES kind, ItemStack input)throws IllegalArgumentException{
		if ( input == null) {return null;}
		Map<ItemStack,ItemStack> list = getList(kind);
		if (list == null) {new IllegalArgumentException();}

		return getResultItem(list,input);
	}

    private ItemStack getResultItem(Map<ItemStack,ItemStack> list, ItemStack stack)
    {
        for (Entry<ItemStack, ItemStack> entry : list.entrySet())
        {
            if (ModUtil.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return (ItemStack)entry.getValue().copy();
            }
        }

        return null;
    }


	public static enum ORIGINAL_RECIPIES{
		RECIPIE_MILLING,
		RECIPIE_CRASHING,
		RECIPIE_FREEZING,
		RECIPIE_FREEZING_ICE
	}
}
