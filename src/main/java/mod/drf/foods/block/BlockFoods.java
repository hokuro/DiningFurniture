package mod.drf.foods.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mod.drf.core.Mod_DiningFurniture;
import mod.drf.foods.block.Item.BlockItemPie;
import net.minecraft.block.Block;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent.Register;

public class BlockFoods {

	public static final List<String> NAME_LIST = new ArrayList<String>(){
		{add(NAME_COOKINGWORKBENCH);}
		{add(NAME_FREEZER);}
		{add(NAME_ICECRASHER);}
		{add(NAME_MILLSTONE);}
		{add(NAME_SALTPAN);}
		{add(NAME_PIE_HALL);}
		{add(NAME_CARAMELPIE_HALL);}
		{add(NAME_CHOCOPIE_HALL);}
		{add(NAME_SALADA_HALL);}
		{add(NAME_MEETPIE_HALL);}
		{add(NAME_FISHPIE_HALL);}
		{add(NAME_PUMPKINPIE_HALL);}
		{add(NAME_APPLEPIE_HALL);}
		{add(NAME_BLACK_PIE);}
		{add(NAME_ZOMBIPEI_HALL);}
		{add(NAME_CHOCO_CAKE);}
		{add(NAME_APPLE_CAKE);}
		{add(NAME_SALADA_CAKE);}
		{add(NAME_MELLON_CAKE);}
		{add(NAME_PUMPKIN_CAKE);}
		{add(NAME_REACHEESE_CAKE);}
		{add(NAME_BAKEDCHEESE_CAKE);}
		{add(NAME_BLACK_CAEK);}
		{add(NAME_ZOMBI_CAKE);}
		{add(NAME_PIZZA);}
		{add(NAME_MEETPIZZA);}
		{add(NAME_FISHPIZZA);}
		{add(NAME_CHEESE);}
		{add(NAME_BLUECHEESE);}
	};
	// ############作業台#######################Workbench
	// 料理台
	public static final String NAME_COOKINGWORKBENCH = "cworkbench";

	//#############################################################################################
	// Block Machine
	// 製氷機
	public static final String NAME_FREEZER = "freezer";
	// かき氷器
	public static final String NAME_ICECRASHER = "icecrasher";
	// 製粉機
	public static final String NAME_MILLSTONE = "millstone";
	// 製塩機
	public static final String NAME_SALTPAN = "saltpan";

	//#############################################################################################
	// Block Pie
	// パイ
	public static final String NAME_PIE_HALL = "piehall";
	// チョコパイ
	public static final String NAME_CHOCOPIE_HALL = "piehallchoco";
	// 野菜パイ
	public static final String NAME_SALADA_HALL = "piehallsalada";
	// ミートパイ
	public static final String NAME_MEETPIE_HALL = "piehallmeet";
	// 魚パイ
	public static final String NAME_FISHPIE_HALL = "piehallfish";
	// かぼちゃパイ
	public static final String NAME_PUMPKINPIE_HALL = "piehallpumpkin";
	// ゾンビパイ
	public static final String NAME_ZOMBIPEI_HALL = "piehallzombi";
	// リンゴパイ
	public static final String NAME_APPLEPIE_HALL = "piehallapple";
	// カラメルパイ
	public static final String NAME_CARAMELPIE_HALL = "piehallcaramel";
	// 烏賊墨パイ
	public static final String NAME_BLACK_PIE = "piehallblack";

	//#############################################################################################
	// Block Cake
	// チョコレートケーキ
	public static final String NAME_CHOCO_CAKE = "cakechoco";
	// リンゴケーキ
	public static final String NAME_APPLE_CAKE = "cakeapple";
	// 野菜ケーキ
	public static final String NAME_SALADA_CAKE = "cakesalada";
	// スイカケーキ
	public static final String NAME_MELLON_CAKE ="cakemelon";
	// かぼちゃケーキ
	public static final String NAME_PUMPKIN_CAKE ="cakepumpkin";
	// レアチーズケーキ
	public static final String NAME_REACHEESE_CAKE ="cakereacheese";
	// ベイクドチーズケーキ
	public static final String NAME_BAKEDCHEESE_CAKE = "cakebakedcheese";
	// 烏賊墨ケーキ
	public static final String NAME_BLACK_CAEK = "cakeblack";
	// ゾンビケーキ
	public static final String NAME_ZOMBI_CAKE = "cakezombi";
	// ピザ
	public static final String NAME_PIZZA = "pizza";
	// 肉ピザ
	public static final String NAME_MEETPIZZA ="pizzameet";
	// アンチョビピザ
	public static final String NAME_FISHPIZZA = "pizzafish";
	//#############################################################################################
	// Block Cheese
	// チーズ
	public static final String NAME_CHEESE ="cheese";
	// ブルーチーズ
	public static final String NAME_BLUECHEESE = "cheeseblue";

	private static final int EffectLevel = 1;
	private static final int EffectTime = 1600;

	public static  Block block_cookingworkbench = new BlockCookingWorkBench().setRegistryName(NAME_COOKINGWORKBENCH);
	public static  Block block_freezer          = new BlockFreezer().setRegistryName(NAME_FREEZER);
	public static  Block block_icecrasher       = new BlockIceCrasher().setRegistryName(NAME_ICECRASHER);
	public static  Block block_millstone        = new BlockMillStone().setRegistryName(NAME_MILLSTONE);
	public static  Block block_saltpan          = new BlockSaltPan().setRegistryName(NAME_SALTPAN);

	public static  Block block_pie_hall         = new BlockPie(2,0.2F).setRegistryName(NAME_PIE_HALL);
	public static  Block block_caramelpie_hall  = new BlockPie(4,0.2F).setRegistryName(NAME_CARAMELPIE_HALL);
	public static  Block block_chocopie_hall    = new BlockPie(4,0.2F).setRegistryName(NAME_CHOCOPIE_HALL);
	public static  Block block_salada_hall      = new BlockPie(6,0.3F).setRegistryName(NAME_SALADA_HALL);
	public static  Block block_meetpie_hall     = new BlockPie(8,0.4F).setRegistryName(NAME_MEETPIE_HALL);
	public static  Block block_fishpie_hall     = new BlockPie(8,0.4F).setRegistryName(NAME_FISHPIE_HALL);
	public static  Block block_pumpkinpie_hall  = new BlockPie(6,0.3F).setRegistryName(NAME_PUMPKINPIE_HALL);
	public static  Block block_applepie_hall    = new BlockPie(4,0.2F).setRegistryName(NAME_APPLEPIE_HALL);
	public static  Block block_black_pie        = new BlockPie(4,0.2F).setRegistryName(NAME_BLACK_PIE);
	public static  Block block_zombipei_hall    = new BlockPie(2,0.1F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.HUNGER, 600, 0)}).setRegistryName(NAME_ZOMBIPEI_HALL);

	public static  Block block_choco_cake       = new BlockPie(4,0.2F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.NIGHT_VISION,EffectTime,EffectLevel)}).setRegistryName(NAME_CHOCO_CAKE);
	public static  Block block_apple_cake       = new BlockPie(4,0.2F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.REGENERATION,EffectTime,EffectLevel)}).setRegistryName(NAME_APPLE_CAKE);
	public static  Block block_salada_cake      = new BlockPie(4,0.2F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.HASTE,EffectTime,EffectLevel)}).setRegistryName(NAME_SALADA_CAKE);
	public static  Block block_mellon_cake      = new BlockPie(4,0.2F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.INSTANT_HEALTH,EffectLevel, 0)}).setRegistryName(NAME_MELLON_CAKE);
	public static  Block block_pumpkin_cake     = new BlockPie(4,0.2F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.INVISIBILITY,EffectTime,EffectLevel)}).setRegistryName(NAME_PUMPKIN_CAKE);
	public static  Block block_reacheese_cake   = new BlockPie(4,0.4F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.JUMP_BOOST,EffectTime,EffectLevel)}).setRegistryName(NAME_REACHEESE_CAKE);
	public static  Block block_bakedcheese_cake = new BlockPie(4,0.4F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,EffectTime,EffectLevel)}).setRegistryName(NAME_BAKEDCHEESE_CAKE);
	public static  Block block_black_cake       = new BlockPie(2,0.2F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.WATER_BREATHING,EffectTime,EffectLevel)}).setRegistryName(NAME_BLACK_CAEK);
	public static  Block block_zombi_cake       = new BlockPie(2,0.1F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.HUNGER, 600, 0)}).setRegistryName(NAME_ZOMBI_CAKE);

	public static  Block block_pizza            = new BlockPie(2,0.5F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.REGENERATION,EffectTime,EffectLevel)}).setRegistryName(NAME_PIZZA);
	public static  Block block_meet_pizza       = new BlockPie(4,0.4F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.STRENGTH,EffectTime,EffectLevel)}).setRegistryName(NAME_MEETPIZZA);
	public static  Block block_fish_pizza       = new BlockPie(4,0.4F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.SPEED,EffectTime,EffectLevel)}).setRegistryName(NAME_FISHPIZZA);

	public static  Block block_cheese           = new BlockPie(2,0.1F).setRegistryName(NAME_CHEESE);
	public static  Block block_bluecheese       = new BlockPie(2,0.1F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.REGENERATION,EffectTime,EffectLevel)}).setRegistryName(NAME_BLUECHEESE);

	public static Map<String, Block> blockMap;
	public static Map<String,Item> itemMap;

	public static void init(){
		blockMap = new HashMap<String, Block>();
		blockMap.put(NAME_COOKINGWORKBENCH, block_cookingworkbench);
		blockMap.put(NAME_FREEZER, block_freezer);
		blockMap.put(NAME_ICECRASHER,block_icecrasher);
		blockMap.put(NAME_MILLSTONE, block_millstone);
		blockMap.put(NAME_SALTPAN, block_saltpan);
		blockMap.put(NAME_PIE_HALL, block_pie_hall);
		blockMap.put(NAME_CARAMELPIE_HALL, block_caramelpie_hall);
		blockMap.put(NAME_CHOCOPIE_HALL, block_chocopie_hall);
		blockMap.put(NAME_SALADA_HALL, block_salada_hall);
		blockMap.put(NAME_MEETPIE_HALL, block_meetpie_hall);
		blockMap.put(NAME_FISHPIE_HALL, block_fishpie_hall);
		blockMap.put(NAME_PUMPKINPIE_HALL, block_pumpkinpie_hall);
		blockMap.put(NAME_APPLEPIE_HALL, block_applepie_hall);
		blockMap.put(NAME_BLACK_PIE, block_black_pie);
		blockMap.put(NAME_ZOMBIPEI_HALL, block_zombipei_hall);
		blockMap.put(NAME_CHOCO_CAKE, block_choco_cake);
		blockMap.put(NAME_APPLE_CAKE, block_apple_cake);
		blockMap.put(NAME_SALADA_CAKE, block_salada_cake);
		blockMap.put(NAME_MELLON_CAKE, block_mellon_cake);
		blockMap.put(NAME_PUMPKIN_CAKE, block_pumpkin_cake);
		blockMap.put(NAME_REACHEESE_CAKE, block_reacheese_cake);
		blockMap.put(NAME_BAKEDCHEESE_CAKE, block_bakedcheese_cake);
		blockMap.put(NAME_BLACK_CAEK, block_black_cake);
		blockMap.put(NAME_ZOMBI_CAKE, block_zombi_cake);
		blockMap.put(NAME_PIZZA, block_pizza);
		blockMap.put(NAME_MEETPIZZA, block_meet_pizza);
		blockMap.put(NAME_FISHPIZZA, block_fish_pizza);
		blockMap.put(NAME_CHEESE, block_cheese);
		blockMap.put(NAME_BLUECHEESE, block_bluecheese);

		itemMap = new HashMap<String, Item>();
		itemMap.put(NAME_COOKINGWORKBENCH, (new ItemBlock(block_cookingworkbench,(new Item.Properties()).group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_COOKINGWORKBENCH)));
		itemMap.put(NAME_FREEZER, (new ItemBlock(block_freezer,(new Item.Properties()).group(Mod_DiningFurniture.tabFurniture))).setRegistryName(NAME_FREEZER));
		itemMap.put(NAME_ICECRASHER,(new ItemBlock(block_icecrasher,(new Item.Properties()).group(Mod_DiningFurniture.tabFurniture))).setRegistryName(NAME_ICECRASHER));
		itemMap.put(NAME_MILLSTONE, (new ItemBlock(block_millstone,(new Item.Properties()).group(Mod_DiningFurniture.tabFurniture))).setRegistryName(NAME_MILLSTONE));
		itemMap.put(NAME_SALTPAN, (new ItemBlock(block_saltpan,(new Item.Properties()).group(Mod_DiningFurniture.tabFurniture))).setRegistryName(NAME_SALTPAN));
		itemMap.put(NAME_PIE_HALL, (new BlockItemPie(block_pie_hall,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(16))).setRegistryName(NAME_PIE_HALL));
		itemMap.put(NAME_CARAMELPIE_HALL, (new BlockItemPie(block_caramelpie_hall,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(16))).setRegistryName(NAME_CARAMELPIE_HALL));
		itemMap.put(NAME_CHOCOPIE_HALL, (new BlockItemPie(block_chocopie_hall,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(16))).setRegistryName(NAME_CHOCOPIE_HALL));
		itemMap.put(NAME_SALADA_HALL, (new BlockItemPie(block_salada_hall,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(16))).setRegistryName(NAME_SALADA_HALL));
		itemMap.put(NAME_MEETPIE_HALL, (new BlockItemPie(block_meetpie_hall,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(16))).setRegistryName(NAME_MEETPIE_HALL));
		itemMap.put(NAME_FISHPIE_HALL, (new BlockItemPie(block_fishpie_hall,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(16))).setRegistryName(NAME_FISHPIE_HALL));
		itemMap.put(NAME_PUMPKINPIE_HALL, (new BlockItemPie(block_pumpkinpie_hall,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(16))).setRegistryName(NAME_PUMPKINPIE_HALL));
		itemMap.put(NAME_ZOMBIPEI_HALL, (new BlockItemPie(block_zombipei_hall,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(16))).setRegistryName(NAME_ZOMBIPEI_HALL));
		itemMap.put(NAME_APPLEPIE_HALL, (new BlockItemPie(block_applepie_hall,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(16))).setRegistryName(NAME_APPLEPIE_HALL));
		itemMap.put(NAME_BLACK_PIE, (new BlockItemPie(block_black_pie,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(16))).setRegistryName(NAME_BLACK_PIE));
		itemMap.put(NAME_PIZZA, (new BlockItemPie(block_pizza,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(32))).setRegistryName(NAME_PIZZA));
		itemMap.put(NAME_MEETPIZZA, (new BlockItemPie(block_meet_pizza,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(32))).setRegistryName(NAME_MEETPIZZA));
		itemMap.put(NAME_FISHPIZZA, (new BlockItemPie(block_fish_pizza,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(32))).setRegistryName(NAME_FISHPIZZA));
		itemMap.put(NAME_CHEESE, (new BlockItemPie(block_cheese,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(64))).setRegistryName(NAME_CHEESE));
		itemMap.put(NAME_BLUECHEESE, (new BlockItemPie(block_bluecheese,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(64))).setRegistryName(NAME_BLUECHEESE));
		itemMap.put(NAME_CHOCO_CAKE, (new BlockItemPie(block_choco_cake,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1))).setRegistryName(NAME_CHOCO_CAKE));
		itemMap.put(NAME_APPLE_CAKE, (new BlockItemPie(block_apple_cake,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1))).setRegistryName(NAME_APPLE_CAKE));
		itemMap.put(NAME_SALADA_CAKE, (new BlockItemPie(block_salada_cake,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1))).setRegistryName(NAME_SALADA_CAKE));
		itemMap.put(NAME_MELLON_CAKE, (new BlockItemPie(block_mellon_cake,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1))).setRegistryName(NAME_MELLON_CAKE));
		itemMap.put(NAME_PUMPKIN_CAKE, (new BlockItemPie(block_pumpkin_cake,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1))).setRegistryName(NAME_PUMPKIN_CAKE));
		itemMap.put(NAME_REACHEESE_CAKE, (new BlockItemPie(block_reacheese_cake,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1))).setRegistryName(NAME_REACHEESE_CAKE));
		itemMap.put(NAME_BAKEDCHEESE_CAKE, (new BlockItemPie(block_bakedcheese_cake,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1))).setRegistryName(NAME_BAKEDCHEESE_CAKE));
		itemMap.put(NAME_BLACK_CAEK, (new BlockItemPie(block_black_cake,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1))).setRegistryName(NAME_BLACK_CAEK));
		itemMap.put(NAME_ZOMBI_CAKE, (new BlockItemPie(block_zombi_cake,(new Item.Properties()).group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1))).setRegistryName(NAME_ZOMBI_CAKE));
	}

	public static void register(Register<Block> event) {
		for(String key : NAME_LIST) {
			if (blockMap.containsKey(key)) {
				event.getRegistry().register(blockMap.get(key));
			}
		}
	}

	public static void registerItem(Register<Item> event) {
		for(String key : NAME_LIST) {
			if (itemMap.containsKey(key)) {
				event.getRegistry().register(itemMap.get(key));
			}
		}
	}
}
