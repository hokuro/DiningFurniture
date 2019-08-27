package mod.drf.recipie;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import mod.drf.foods.Item.ItemFoods;
import mod.drf.util.ModUtil;
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
		addRecipie(new ItemStack(Blocks.SUNFLOWER,1), new ItemStack(ItemFoods.item_flowerdust_sunflower,1), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.ROSE_BUSH,1), new ItemStack(ItemFoods.item_flowerdust_rose,1), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.PEONY,1), new ItemStack(ItemFoods.item_flowerdust_peony,1), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.LILAC,1), new ItemStack(ItemFoods.item_flowerdust_lilac,1), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.ALLIUM,1), new ItemStack(ItemFoods.item_flowerdust_allium,1), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.PINK_TULIP,1), new ItemStack(ItemFoods.item_flowerdust_tulip,1), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.ORANGE_TULIP,1), new ItemStack(ItemFoods.item_flowerdust_tulip,1), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.RED_TULIP,1), new ItemStack(ItemFoods.item_flowerdust_tulip,1), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.WHITE_TULIP,1), new ItemStack(ItemFoods.item_flowerdust_tulip,1), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.BLUE_ORCHID,1), new ItemStack(ItemFoods.item_flowerdust_orchid,1), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.DANDELION), new ItemStack(ItemFoods.item_flowerdust_dandelion,1), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.AZURE_BLUET,1), new ItemStack(ItemFoods.item_flowerdust_azurebluet,1), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.OXEYE_DAISY,1), new ItemStack(ItemFoods.item_flowerdust_oxeydaisy,1), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		addRecipie(new ItemStack(Blocks.POPPY,1), new ItemStack(ItemFoods.item_flowerdust_popy,1), ORIGINAL_RECIPIES.RECIPIE_MILLING);
		// Chasshing
		addRecipie(new ItemStack(Blocks.ICE,1), new ItemStack(ItemFoods.item_crashedice_none,1), ORIGINAL_RECIPIES.RECIPIE_CRASHING);
		addRecipie(new ItemStack(Blocks.PACKED_ICE,1), new ItemStack(ItemFoods.item_crashedice_none,1), ORIGINAL_RECIPIES.RECIPIE_CRASHING);
		addRecipie(new ItemStack(Blocks.BLUE_ICE,1), new ItemStack(ItemFoods.item_crashedice_none,1), ORIGINAL_RECIPIES.RECIPIE_CRASHING);

		// Freezing
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_vanila,1), new ItemStack(ItemFoods.item_icecream_vanila,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_black,1), new ItemStack(ItemFoods.item_icecream_black,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_red,1), new ItemStack(ItemFoods.item_icecream_red,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_green,1), new ItemStack(ItemFoods.item_icecream_green,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_brown,1), new ItemStack(ItemFoods.item_icecream_brown,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_blue,1), new ItemStack(ItemFoods.item_icecream_blue,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_purple,1), new ItemStack(ItemFoods.item_icecream_purple,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_cyan,1), new ItemStack(ItemFoods.item_icecream_cyan,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_silver,1), new ItemStack(ItemFoods.item_icecream_silver,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_gray,1), new ItemStack(ItemFoods.item_icecream_gray,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_pink,1), new ItemStack(ItemFoods.item_icecream_pink,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_lime,1), new ItemStack(ItemFoods.item_icecream_lime,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_yellow,1), new ItemStack(ItemFoods.item_icecream_yellow,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_light_blue,1), new ItemStack(ItemFoods.item_icecream_light_blue,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_magenta,1), new ItemStack(ItemFoods.item_icecream_magenta,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_orange,1), new ItemStack(ItemFoods.item_icecream_orange,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_white,1), new ItemStack(ItemFoods.item_icecream_white,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_apple,1), new ItemStack(ItemFoods.item_icecream_apple,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_cactus,1), new ItemStack(ItemFoods.item_icecream_cactus,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_pumpkin,1), new ItemStack(ItemFoods.item_icecream_pumpkin,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_potato,1), new ItemStack(ItemFoods.item_icecream_potato,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_carrot,1), new ItemStack(ItemFoods.item_icecream_carrot,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_melon,1), new ItemStack(ItemFoods.item_icecream_melon,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_ice_mix_greentea,1), new ItemStack(ItemFoods.item_icecream_greentea,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);


		addRecipie(new ItemStack(ItemFoods.item_sugar_water_none,1), new ItemStack(ItemFoods.item_icecandy_none,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_sugar,1), new ItemStack(ItemFoods.item_icecandy_sugar,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_black,1), new ItemStack(ItemFoods.item_icecandy_black,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_red,1), new ItemStack(ItemFoods.item_icecandy_red,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_green,1), new ItemStack(ItemFoods.item_icecandy_green,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_brown,1), new ItemStack(ItemFoods.item_icecandy_brown,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_blue,1), new ItemStack(ItemFoods.item_icecandy_blue,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_purple,1), new ItemStack(ItemFoods.item_icecandy_purple,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_cyan,1), new ItemStack(ItemFoods.item_icecandy_cyan,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_silver,1), new ItemStack(ItemFoods.item_icecandy_silver,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_gray,1), new ItemStack(ItemFoods.item_icecandy_gray,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_pink,1), new ItemStack(ItemFoods.item_icecandy_pink,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_lime,1), new ItemStack(ItemFoods.item_icecandy_lime,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_yellow,1), new ItemStack(ItemFoods.item_icecandy_yellow,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_light_blue,1), new ItemStack(ItemFoods.item_icecandy_light_blue,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_magenta,1), new ItemStack(ItemFoods.item_icecandy_magenta,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_orange,1), new ItemStack(ItemFoods.item_icecandy_orange,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_white,1), new ItemStack(ItemFoods.item_icecandy_white,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_apple,1), new ItemStack(ItemFoods.item_icecandy_apple,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_cactus,1), new ItemStack(ItemFoods.item_icecandy_cactus,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_melon,1), new ItemStack(ItemFoods.item_icecandy_melon,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_pumpkin,1), new ItemStack(ItemFoods.item_icecandy_pumpkin,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);
		addRecipie(new ItemStack(ItemFoods.item_sugar_water_greentea,1), new ItemStack(ItemFoods.item_icecandy_greentea,1), ORIGINAL_RECIPIES.RECIPIE_FREEZING);

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
