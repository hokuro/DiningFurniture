package mod.drf.foods.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mod.drf.core.ModCommon;
import mod.drf.core.Mod_DiningFurniture;
import mod.drf.foods.block.Item.BlockItemPie;
import net.minecraft.block.Block;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

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
	public static final String NAME_MELLON_CAKE ="cakewmellon";
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

	public static  Block block_cookingworkbench;// = new BlockCookingWorkBench().setRegistryName(NAME_COOKINGWORKBENCH).setUnlocalizedName(NAME_COOKINGWORKBENCH);
	public static  Block block_freezer;//          = new BlockFreezer().setCreativeTab(Mod_DiningFurniture.tabFurniture).setRegistryName(NAME_FREEZER).setUnlocalizedName(NAME_FREEZER);
	public static  Block block_icecrasher;//       = new BlockIceCrasher().setCreativeTab(Mod_DiningFurniture.tabFurniture).setRegistryName(NAME_ICECRASHER).setUnlocalizedName(NAME_ICECRASHER);
	public static  Block block_millstone;//        = new BlockMillStone().setCreativeTab(Mod_DiningFurniture.tabFurniture).setRegistryName(NAME_MILLSTONE).setUnlocalizedName(NAME_MILLSTONE);
	public static  Block block_saltpan;//          = new BlockSaltPan().setCreativeTab(Mod_DiningFurniture.tabFurniture).setRegistryName(NAME_SALTPAN).setUnlocalizedName(NAME_SALTPAN);


	public static  Block block_pie_hall;//         = new BlockPie(2,0.2F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_PIE_HALL).setUnlocalizedName(NAME_PIE_HALL);
	public static  Block block_caramelpie_hall;//  = new BlockPie(4,0.2F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_CARAMELPIE_HALL).setUnlocalizedName(NAME_CARAMELPIE_HALL);
	public static  Block block_chocopie_hall;//    = new BlockPie(4,0.2F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_CHOCOPIE_HALL).setUnlocalizedName(NAME_CHOCOPIE_HALL);
	public static  Block block_salada_hall;//      = new BlockPie(6,0.3F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_SALADA_HALL).setUnlocalizedName(NAME_SALADA_HALL);
	public static  Block block_meetpie_hall;//     = new BlockPie(8,0.4F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_MEETPIE_HALL).setUnlocalizedName(NAME_MEETPIE_HALL);
	public static  Block block_fishpie_hall;//     = new BlockPie(8,0.4F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_FISHPIE_HALL).setUnlocalizedName(NAME_FISHPIE_HALL);
	public static  Block block_pumpkinpie_hall;//  = new BlockPie(6,0.3F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_PUMPKINPIE_HALL).setUnlocalizedName(NAME_PUMPKINPIE_HALL);
	public static  Block block_applepie_hall;//    = new BlockPie(4,0.2F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_APPLEPIE_HALL).setUnlocalizedName(NAME_APPLEPIE_HALL);
	public static  Block block_black_pie;//        = new BlockPie(4,0.2F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_BLACK_PIE).setUnlocalizedName(NAME_BLACK_PIE);
	public static  Block block_zombipei_hall;//    = new BlockPie(2,0.1F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.HUNGER, 600, 0)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_ZOMBIPEI_HALL).setUnlocalizedName(NAME_ZOMBIPEI_HALL);

	public static  Block block_choco_cake;//       = new BlockPie(4,0.2F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.NIGHT_VISION,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_CHOCO_CAKE).setUnlocalizedName(NAME_CHOCO_CAKE);
	public static  Block block_apple_cake;//       = new BlockPie(4,0.2F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.REGENERATION,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_APPLE_CAKE).setUnlocalizedName(NAME_APPLE_CAKE );
	public static  Block block_salada_cake;//      = new BlockPie(4,0.2F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.HASTE,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_SALADA_CAKE).setUnlocalizedName(NAME_SALADA_CAKE );
	public static  Block block_mellon_cake;//      = new BlockPie(4,0.2F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.INSTANT_HEALTH,0,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_MELLON_CAKE).setUnlocalizedName(NAME_MELLON_CAKE);
	public static  Block block_pumpkin_cake;//     = new BlockPie(4,0.2F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.INVISIBILITY,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_PUMPKIN_CAKE).setUnlocalizedName(NAME_PUMPKIN_CAKE);
	public static  Block block_reacheese_cake;//   = new BlockPie(4,0.4F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.JUMP_BOOST,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_REACHEESE_CAKE).setUnlocalizedName(NAME_REACHEESE_CAKE);
	public static  Block block_bakedcheese_cake;// = new BlockPie(4,0.4F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_BAKEDCHEESE_CAKE).setUnlocalizedName(NAME_BAKEDCHEESE_CAKE);
	public static  Block block_black_cake;//       = new BlockPie(2,0.2F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.WATER_BREATHING,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_BLACK_CAEK).setUnlocalizedName(NAME_BLACK_CAEK);
	public static  Block block_zombi_cake;//       = new BlockPie(2,0.1F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.HUNGER, 600, 0)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_ZOMBI_CAKE).setUnlocalizedName(NAME_ZOMBI_CAKE);

	public static  Block block_pizza;//            = new BlockPie(2,0.5F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.REGENERATION,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_PIZZA).setUnlocalizedName(NAME_PIZZA);
	public static  Block block_meet_pizza;//       = new BlockPie(4,0.4F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.STRENGTH,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_MEETPIZZA).setUnlocalizedName(NAME_MEETPIZZA);
	public static  Block block_fish_pizza;//       = new BlockPie(4,0.4F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.SPEED,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_FISHPIZZA).setUnlocalizedName(NAME_FISHPIZZA);

	public static  Block block_cheese;//           = new BlockPie(2,0.1F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_CHEESE).setUnlocalizedName(NAME_CHEESE);
	public static  Block block_bluecheese;//       = new BlockPie(2,0.1F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.REGENERATION,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_BLUECHEESE).setUnlocalizedName(NAME_BLUECHEESE);

	public static void init(){

		 block_cookingworkbench = new BlockCookingWorkBench().setRegistryName(NAME_COOKINGWORKBENCH).setUnlocalizedName(NAME_COOKINGWORKBENCH);
		 block_freezer          = new BlockFreezer().setCreativeTab(Mod_DiningFurniture.tabFurniture).setRegistryName(NAME_FREEZER).setUnlocalizedName(NAME_FREEZER);
		 block_icecrasher       = new BlockIceCrasher().setCreativeTab(Mod_DiningFurniture.tabFurniture).setRegistryName(NAME_ICECRASHER).setUnlocalizedName(NAME_ICECRASHER);
		 block_millstone        = new BlockMillStone().setCreativeTab(Mod_DiningFurniture.tabFurniture).setRegistryName(NAME_MILLSTONE).setUnlocalizedName(NAME_MILLSTONE);
		 block_saltpan          = new BlockSaltPan().setCreativeTab(Mod_DiningFurniture.tabFurniture).setRegistryName(NAME_SALTPAN).setUnlocalizedName(NAME_SALTPAN);


		 block_pie_hall         = new BlockPie(2,0.2F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_PIE_HALL).setUnlocalizedName(NAME_PIE_HALL);
		 block_caramelpie_hall  = new BlockPie(4,0.2F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_CARAMELPIE_HALL).setUnlocalizedName(NAME_CARAMELPIE_HALL);
		 block_chocopie_hall    = new BlockPie(4,0.2F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_CHOCOPIE_HALL).setUnlocalizedName(NAME_CHOCOPIE_HALL);
		 block_salada_hall      = new BlockPie(6,0.3F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_SALADA_HALL).setUnlocalizedName(NAME_SALADA_HALL);
		 block_meetpie_hall     = new BlockPie(8,0.4F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_MEETPIE_HALL).setUnlocalizedName(NAME_MEETPIE_HALL);
		 block_fishpie_hall     = new BlockPie(8,0.4F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_FISHPIE_HALL).setUnlocalizedName(NAME_FISHPIE_HALL);
		 block_pumpkinpie_hall  = new BlockPie(6,0.3F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_PUMPKINPIE_HALL).setUnlocalizedName(NAME_PUMPKINPIE_HALL);
		 block_applepie_hall    = new BlockPie(4,0.2F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_APPLEPIE_HALL).setUnlocalizedName(NAME_APPLEPIE_HALL);
		 block_black_pie        = new BlockPie(4,0.2F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_BLACK_PIE).setUnlocalizedName(NAME_BLACK_PIE);
		 block_zombipei_hall    = new BlockPie(2,0.1F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.HUNGER, 600, 0)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_ZOMBIPEI_HALL).setUnlocalizedName(NAME_ZOMBIPEI_HALL);

		 block_choco_cake       = new BlockPie(4,0.2F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.NIGHT_VISION,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_CHOCO_CAKE).setUnlocalizedName(NAME_CHOCO_CAKE);
		 block_apple_cake       = new BlockPie(4,0.2F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.REGENERATION,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_APPLE_CAKE).setUnlocalizedName(NAME_APPLE_CAKE );
		 block_salada_cake      = new BlockPie(4,0.2F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.HASTE,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_SALADA_CAKE).setUnlocalizedName(NAME_SALADA_CAKE );
		 block_mellon_cake      = new BlockPie(4,0.2F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.INSTANT_HEALTH,EffectLevel, 0)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_MELLON_CAKE).setUnlocalizedName(NAME_MELLON_CAKE);
		 block_pumpkin_cake     = new BlockPie(4,0.2F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.INVISIBILITY,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_PUMPKIN_CAKE).setUnlocalizedName(NAME_PUMPKIN_CAKE);
		 block_reacheese_cake   = new BlockPie(4,0.4F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.JUMP_BOOST,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_REACHEESE_CAKE).setUnlocalizedName(NAME_REACHEESE_CAKE);
		 block_bakedcheese_cake = new BlockPie(4,0.4F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_BAKEDCHEESE_CAKE).setUnlocalizedName(NAME_BAKEDCHEESE_CAKE);
		 block_black_cake       = new BlockPie(2,0.2F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.WATER_BREATHING,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_BLACK_CAEK).setUnlocalizedName(NAME_BLACK_CAEK);
		 block_zombi_cake       = new BlockPie(2,0.1F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.HUNGER, 600, 0)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_ZOMBI_CAKE).setUnlocalizedName(NAME_ZOMBI_CAKE);

		 block_pizza            = new BlockPie(2,0.5F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.REGENERATION,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_PIZZA).setUnlocalizedName(NAME_PIZZA);
		 block_meet_pizza       = new BlockPie(4,0.4F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.STRENGTH,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_MEETPIZZA).setUnlocalizedName(NAME_MEETPIZZA);
		 block_fish_pizza       = new BlockPie(4,0.4F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.SPEED,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_FISHPIZZA).setUnlocalizedName(NAME_FISHPIZZA);

		 block_cheese           = new BlockPie(2,0.1F).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_CHEESE).setUnlocalizedName(NAME_CHEESE);
		 block_bluecheese       = new BlockPie(2,0.1F).setPotionEffect(new PotionEffect[]{new PotionEffect(MobEffects.REGENERATION,EffectTime,EffectLevel)}).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setRegistryName(NAME_BLUECHEESE).setUnlocalizedName(NAME_BLUECHEESE);

	}
	public static Map<String, Block> blockMap(){
		return  (new HashMap<String, Block>(){
			{put(NAME_COOKINGWORKBENCH, block_cookingworkbench);}
			{put(NAME_FREEZER, block_freezer);}
			{put(NAME_ICECRASHER,block_icecrasher);}
			{put(NAME_MILLSTONE, block_millstone);}
			{put(NAME_SALTPAN, block_saltpan);}
			{put(NAME_PIE_HALL, block_pie_hall);}
			{put(NAME_CARAMELPIE_HALL, block_caramelpie_hall);}
			{put(NAME_CHOCOPIE_HALL, block_chocopie_hall);}
			{put(NAME_SALADA_HALL, block_salada_hall);}
			{put(NAME_MEETPIE_HALL, block_meetpie_hall);}
			{put(NAME_FISHPIE_HALL, block_fishpie_hall);}
			{put(NAME_PUMPKINPIE_HALL, block_pumpkinpie_hall);}
			{put(NAME_APPLEPIE_HALL, block_applepie_hall);}
			{put(NAME_BLACK_PIE, block_black_pie);}
			{put(NAME_ZOMBIPEI_HALL, block_zombipei_hall);}
			{put(NAME_CHOCO_CAKE, block_choco_cake);}
			{put(NAME_APPLE_CAKE, block_apple_cake);}
			{put(NAME_SALADA_CAKE, block_salada_cake);}
			{put(NAME_MELLON_CAKE, block_mellon_cake);}
			{put(NAME_PUMPKIN_CAKE, block_pumpkin_cake);}
			{put(NAME_REACHEESE_CAKE, block_reacheese_cake);}
			{put(NAME_BAKEDCHEESE_CAKE, block_bakedcheese_cake);}
			{put(NAME_BLACK_CAEK, block_black_cake);}
			{put(NAME_ZOMBI_CAKE, block_zombi_cake);}
			{put(NAME_PIZZA, block_pizza);}
			{put(NAME_MEETPIZZA, block_meet_pizza);}
			{put(NAME_FISHPIZZA, block_fish_pizza);}
			{put(NAME_CHEESE, block_cheese);}
			{put(NAME_BLUECHEESE, block_bluecheese);}
			});
	}

	public static Map<String,Item> itemMap(){
		return (new HashMap<String, Item>(){
			{put(NAME_COOKINGWORKBENCH, (new ItemBlock(block_cookingworkbench).setRegistryName(NAME_COOKINGWORKBENCH)));}
			{put(NAME_FREEZER, (new ItemBlock(block_freezer)).setRegistryName(NAME_FREEZER));}
			{put(NAME_ICECRASHER,(new ItemBlock(block_icecrasher)).setRegistryName(NAME_ICECRASHER));}
			{put(NAME_MILLSTONE, (new ItemBlock(block_millstone)).setRegistryName(NAME_MILLSTONE));}
			{put(NAME_SALTPAN, (new ItemBlock(block_saltpan)).setRegistryName(NAME_SALTPAN));}
			{put(NAME_PIE_HALL, (new BlockItemPie(block_pie_hall).setMaxStackSize(16)).setRegistryName(NAME_PIE_HALL));}
			{put(NAME_CARAMELPIE_HALL, (new BlockItemPie(block_caramelpie_hall).setMaxStackSize(16)).setRegistryName(NAME_CARAMELPIE_HALL));}
			{put(NAME_CHOCOPIE_HALL, (new BlockItemPie(block_chocopie_hall).setMaxStackSize(16)).setRegistryName(NAME_CHOCOPIE_HALL));}
			{put(NAME_SALADA_HALL, (new BlockItemPie(block_salada_hall).setMaxStackSize(16)).setRegistryName(NAME_SALADA_HALL));}
			{put(NAME_MEETPIE_HALL, (new BlockItemPie(block_meetpie_hall).setMaxStackSize(16)).setRegistryName(NAME_MEETPIE_HALL));}
			{put(NAME_FISHPIE_HALL, (new BlockItemPie(block_fishpie_hall).setMaxStackSize(16)).setRegistryName(NAME_FISHPIE_HALL));}
			{put(NAME_PUMPKINPIE_HALL, (new BlockItemPie(block_pumpkinpie_hall).setMaxStackSize(16)).setRegistryName(NAME_PUMPKINPIE_HALL));}
			{put(NAME_ZOMBIPEI_HALL, (new BlockItemPie(block_zombipei_hall).setMaxStackSize(16)).setRegistryName(NAME_ZOMBIPEI_HALL));}
			{put(NAME_APPLEPIE_HALL, (new BlockItemPie(block_applepie_hall).setMaxStackSize(16)).setRegistryName(NAME_APPLEPIE_HALL));}
			{put(NAME_BLACK_PIE, (new BlockItemPie(block_black_pie).setMaxStackSize(16)).setRegistryName(NAME_BLACK_PIE));}
			{put(NAME_PIZZA, (new BlockItemPie(block_pizza).setMaxStackSize(32)).setRegistryName(NAME_PIZZA));}
			{put(NAME_MEETPIZZA, (new BlockItemPie(block_meet_pizza).setMaxStackSize(32)).setRegistryName(NAME_MEETPIZZA));}
			{put(NAME_FISHPIZZA, (new BlockItemPie(block_fish_pizza).setMaxStackSize(32)).setRegistryName(NAME_FISHPIZZA));}
			{put(NAME_CHEESE, (new BlockItemPie(block_cheese).setMaxStackSize(64)).setRegistryName(NAME_CHEESE));}
			{put(NAME_BLUECHEESE, (new BlockItemPie(block_bluecheese).setMaxStackSize(64)).setRegistryName(NAME_BLUECHEESE));}
			{put(NAME_CHOCO_CAKE, (new BlockItemPie(block_choco_cake).setMaxStackSize(1)).setRegistryName(NAME_CHOCO_CAKE));}
			{put(NAME_APPLE_CAKE, (new BlockItemPie(block_apple_cake).setMaxStackSize(1)).setRegistryName(NAME_APPLE_CAKE));}
			{put(NAME_SALADA_CAKE, (new BlockItemPie(block_salada_cake).setMaxStackSize(1)).setRegistryName(NAME_SALADA_CAKE));}
			{put(NAME_MELLON_CAKE, (new BlockItemPie(block_mellon_cake).setMaxStackSize(1)).setRegistryName(NAME_MELLON_CAKE));}
			{put(NAME_PUMPKIN_CAKE, (new BlockItemPie(block_pumpkin_cake).setMaxStackSize(1)).setRegistryName(NAME_PUMPKIN_CAKE));}
			{put(NAME_REACHEESE_CAKE, (new BlockItemPie(block_reacheese_cake).setMaxStackSize(1)).setRegistryName(NAME_REACHEESE_CAKE));}
			{put(NAME_BAKEDCHEESE_CAKE, (new BlockItemPie(block_bakedcheese_cake).setMaxStackSize(1)).setRegistryName(NAME_BAKEDCHEESE_CAKE));}
			{put(NAME_BLACK_CAEK, (new BlockItemPie(block_black_cake).setMaxStackSize(1)).setRegistryName(NAME_BLACK_CAEK));}
			{put(NAME_ZOMBI_CAKE, (new BlockItemPie(block_zombi_cake).setMaxStackSize(1)).setRegistryName(NAME_ZOMBI_CAKE));}
			});
	}

	public static Map<String,ResourceLocation[]> resourceMap(){
		return (new HashMap<String,ResourceLocation[]>(){
			{put(NAME_COOKINGWORKBENCH, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_COOKINGWORKBENCH)});}
			{put(NAME_FREEZER, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_FREEZER)});}
			{put(NAME_ICECRASHER, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_ICECRASHER)});}
			{put(NAME_MILLSTONE, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_MILLSTONE)});}
			{put(NAME_SALTPAN, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_SALTPAN)});}
			{put(NAME_PIE_HALL, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_PIE_HALL)});}
			{put(NAME_CARAMELPIE_HALL, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_CARAMELPIE_HALL)});}
			{put(NAME_CHOCOPIE_HALL, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_CHOCOPIE_HALL)});}
			{put(NAME_SALADA_HALL, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_SALADA_HALL)});}
			{put(NAME_MEETPIE_HALL, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_MEETPIE_HALL)});}
			{put(NAME_FISHPIE_HALL, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_FISHPIE_HALL)});}
			{put(NAME_PUMPKINPIE_HALL, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_PUMPKINPIE_HALL)});}
			{put(NAME_ZOMBIPEI_HALL, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_ZOMBIPEI_HALL)});}
			{put(NAME_APPLEPIE_HALL, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_APPLEPIE_HALL)});}
			{put(NAME_BLACK_PIE,  new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_BLACK_PIE)});}
			{put(NAME_CHOCO_CAKE, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_CHOCO_CAKE)});}
			{put(NAME_APPLE_CAKE, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_APPLE_CAKE)});}
			{put(NAME_SALADA_CAKE, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_SALADA_CAKE)});}
			{put(NAME_MELLON_CAKE, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_MELLON_CAKE)});}
			{put(NAME_PUMPKIN_CAKE, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_PUMPKIN_CAKE)});}
			{put(NAME_CHEESE, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_CHEESE)});}
			{put(NAME_REACHEESE_CAKE, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_REACHEESE_CAKE)});}
			{put(NAME_BAKEDCHEESE_CAKE, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_BAKEDCHEESE_CAKE)});}
			{put(NAME_BLACK_CAEK, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_BLACK_CAEK)});}
			{put(NAME_ZOMBI_CAKE, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_ZOMBI_CAKE)});}
			{put(NAME_PIZZA, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_PIZZA)});}
			{put(NAME_MEETPIZZA, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_MEETPIZZA)});}
			{put(NAME_FISHPIZZA, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_FISHPIZZA)});}
			{put(NAME_BLUECHEESE, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_BLUECHEESE)});}
			});
	}
}
