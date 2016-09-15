package mod.drf.foods.block;

import java.util.HashMap;
import java.util.Map;

import mod.drf.core.ModCommon;
import mod.drf.foods.block.Item.BlockItemPie;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class BlockFoods {
	// 製氷機
	public static final String NAME_ICEMAKER = "icemaker";
	// 製粉機
	public static final String NAME_MILL = "mill";
	// 製塩機
	public static final String NAME_SALTMAKER = "saltmaker";
	// 茶器
	public static final String NAME_TEAUTENSIL = "teautensil";
	// パイ
	public static final String NAME_PIE_HALL = "hallpie";
	// チョコパイ
	public static final String NAME_CHOCOPIE_HALL = "chocohallpie";
	// 野菜パイ
	public static final String NAME_SALADA_HALL = "saladahallpie";
	// ミートパイ
	public static final String NAME_MEETPIE_HALL = "meethallpie";
	// 魚パイ
	public static final String NAME_FISHPIE_HALL = "fishhallpie";
	// かぼちゃパイ
	public static final String NAME_PUMPKINPIE_HALL = "pumpkinhallpie";
	// ゾンビパイ
	public static final String NAME_ZOMBIPEI_HALL = "zombihallpie";
	// リンゴパイ
	public static final String NAME_APPLEPIE_HALL = "applehallpie";
	// カラメルパイ
	public static final String NAME_CALLAMELPIE_HALL = "callamelhallpie";
	// 烏賊墨パイ
	public static final String NAME_BLACK_PIE = "blackpie";
	// チョコレートケーキ
	public static final String NAME_CHOCO_CAKE = "chococake";
	// リンゴケーキ
	public static final String NAME_APPLE_CAKE = "applecake";
	// 野菜ケーキ
	public static final String NAME_SALADA_CAKE = "saladacake";
	// スイカケーキ
	public static final String NAME_MELLON_CAKE ="melloncake";
	// かぼちゃケーキ
	public static final String NAME_PUMPKIN_CAKE ="pumpkincake";
	// チーズ
	public static final String NAME_CHEESE ="cheese";
	// レアチーズケーキ
	public static final String NAME_REACHEESE_CAKE ="reacheesecake";
	// ベイクドチーズケーキ
	public static final String NAME_BAKEDCHEESE_CAKE = "bakedcheesecake";
	// 烏賊墨ケーキ
	public static final String NAME_BLUCK_CAEK = "blackcake";
	// ゾンビケーキ
	public static final String NAME_ZOMBI_CAKE = "zombicake";
	// ピザ
	public static final String NAME_PIZZA = "pizza";
	// 肉ピザ
	public static final String NAME_MEETPIZZA ="meetpizza";
	// アンチョビピザ
	public static final String NAME_FISHPIZZA = "fishpizza";
	// ブルーチーズ
	public static final String NAME_BLUECHEESE = "bluecheese";

	private static final int EffectLevel = 1;
	private static final int EffectTime = 3600;
	// TODO: 製氷機, 製粉機, 製塩機, 茶器
	public static final Block block_pie_hall         = (new BlockPie(2,0.6f, null)).setHardness(0.5f).setUnlocalizedName(NAME_PIE_HALL).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_callamelpie_hall = (new BlockPie(4,0.6f, null)).setHardness(0.5f).setUnlocalizedName(NAME_CALLAMELPIE_HALL).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_chocopie_hall    = (new BlockPie(4,0.6f, null)).setHardness(0.5f).setUnlocalizedName(NAME_CHOCOPIE_HALL).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_salada_hall      = (new BlockPie(8, 0.6f,null)).setHardness(0.5f).setUnlocalizedName(NAME_SALADA_HALL).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_meetpie_hall     = (new BlockPie(10,0.8f,null)).setHardness(0.5f).setUnlocalizedName(NAME_MEETPIE_HALL).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_fishpie_hall     = (new BlockPie(8,0.8f,null)).setHardness(0.5f).setUnlocalizedName(NAME_FISHPIE_HALL).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_pumpkinpie_hall  = (new BlockPie(6,0.6f, null)).setHardness(0.5f).setUnlocalizedName(NAME_PUMPKINPIE_HALL).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_zombipei_hall    = (new BlockPie(2,0.1f, null)).setHardness(0.5f).setUnlocalizedName(NAME_ZOMBIPEI_HALL).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_applepie_hall    = (new BlockPie(6,0.5f, null)).setHardness(0.5f).setUnlocalizedName(NAME_APPLEPIE_HALL).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_black_pie        = (new BlockPie(2,0.6f, null)).setHardness(0.5f).setUnlocalizedName(NAME_BLACK_PIE ).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_choco_cake       = (new BlockPie(4,0.2f, new PotionEffect[]{new PotionEffect(Potion.getPotionFromResourceLocation("night_vision"),EffectLevel)})).setHardness(0.5f).setUnlocalizedName(NAME_CHOCO_CAKE).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_apple_cake       = (new BlockPie(4,0.2f, new PotionEffect[]{new PotionEffect(Potion.getPotionFromResourceLocation("regeneration"),EffectTime,EffectLevel)})).setHardness(0.5f).setUnlocalizedName(NAME_APPLE_CAKE ).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_salada_cake      = (new BlockPie(4,0.2f, new PotionEffect[]{new PotionEffect(Potion.getPotionFromResourceLocation("mining_fatigue"),EffectTime,EffectLevel)})).setHardness(0.5f).setUnlocalizedName(NAME_SALADA_CAKE ).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_mellon_cake      = (new BlockPie(4,0.2f, new PotionEffect[]{new PotionEffect(Potion.getPotionFromResourceLocation("instant_health"),EffectTime,EffectLevel)})).setHardness(0.5f).setUnlocalizedName(NAME_MELLON_CAKE ).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_pumpkin_cake     = (new BlockPie(4,0.2f, new PotionEffect[]{new PotionEffect(Potion.getPotionFromResourceLocation("invisibility"),EffectTime,EffectLevel)})).setHardness(0.5f).setUnlocalizedName(NAME_PUMPKIN_CAKE ).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_reacheese_cake   = (new BlockPie(4,0.4f, new PotionEffect[]{new PotionEffect(Potion.getPotionFromResourceLocation("jump_boost"),EffectTime,EffectLevel)})).setHardness(0.5f).setUnlocalizedName(NAME_REACHEESE_CAKE ).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_bakedcheese_cake = (new BlockPie(4,0.4f, new PotionEffect[]{new PotionEffect(Potion.getPotionFromResourceLocation("fire_resistance"),EffectTime,EffectLevel)})).setHardness(0.5f).setUnlocalizedName(NAME_BAKEDCHEESE_CAKE ).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_black_cake       = (new BlockPie(2,0.2f, new PotionEffect[]{new PotionEffect(Potion.getPotionFromResourceLocation("water_breathing"),EffectTime,EffectLevel)})).setHardness(0.5f).setUnlocalizedName(NAME_BLUCK_CAEK ).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_zombi_cake       = (new BlockPie(2,0.1f, new PotionEffect[]{new PotionEffect(Potion.getPotionFromResourceLocation("hunger"),EffectTime,EffectLevel)})).setHardness(0.5f).setUnlocalizedName(NAME_ZOMBI_CAKE ).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_pizza            = (new BlockPie(2, 0.5f, new PotionEffect[]{new PotionEffect(Potion.getPotionFromResourceLocation("resistance"),EffectTime,EffectLevel)})).setHardness(0.5f).setUnlocalizedName(NAME_PIZZA ).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_meet_pizza       = (new BlockPie(4, 0.4f,new PotionEffect[]{new PotionEffect(Potion.getPotionFromResourceLocation("strength"),EffectTime,EffectLevel)})).setHardness(0.5f).setUnlocalizedName(NAME_MEETPIZZA ).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_fish_pizza       = (new BlockPie(4, 0.4f,new PotionEffect[]{new PotionEffect(Potion.getPotionFromResourceLocation("speed"),EffectTime,EffectLevel)})).setHardness(0.5f).setUnlocalizedName(NAME_FISHPIZZA ).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_cheese           = (new BlockPie(2,0.1f, null)).setHardness(0.5f).setUnlocalizedName(NAME_CHEESE ).setCreativeTab(CreativeTabs.tabFood);
	public static final Block block_bluecheese       = (new BlockPie(2, 0.1f,new PotionEffect[]{new PotionEffect(Potion.getPotionFromResourceLocation("resistance"),EffectTime,EffectLevel)})).setHardness(0.5f).setUnlocalizedName(NAME_BLUECHEESE ).setCreativeTab(CreativeTabs.tabFood);

	public static Map<String, Block> blockMap(){
		return  (new HashMap<String, Block>(){
			{put(NAME_PIE_HALL, block_pie_hall);}
			{put(NAME_CALLAMELPIE_HALL, block_callamelpie_hall);}
			{put(NAME_CHOCOPIE_HALL, block_chocopie_hall);}
			{put(NAME_SALADA_HALL, block_salada_hall);}
			{put(NAME_MEETPIE_HALL, block_meetpie_hall);}
			{put(NAME_FISHPIE_HALL, block_fishpie_hall);}
			{put(NAME_PUMPKINPIE_HALL, block_pumpkinpie_hall);}
			{put(NAME_ZOMBIPEI_HALL, block_zombipei_hall);}
			{put(NAME_APPLEPIE_HALL, block_applepie_hall);}
			{put(NAME_BLACK_PIE, block_black_pie);}
			{put(NAME_PIZZA, block_pizza);}
			{put(NAME_MEETPIZZA, block_meet_pizza);}
			{put(NAME_FISHPIZZA, block_fish_pizza);}
			{put(NAME_CHEESE, block_cheese);}
			{put(NAME_BLUECHEESE, block_bluecheese);}
			{put(NAME_CHOCO_CAKE, block_choco_cake);}
			{put(NAME_APPLE_CAKE, block_apple_cake);}
			{put(NAME_SALADA_CAKE, block_salada_cake);}
			{put(NAME_MELLON_CAKE, block_mellon_cake);}
			{put(NAME_PUMPKIN_CAKE, block_pumpkin_cake);}
			{put(NAME_REACHEESE_CAKE, block_reacheese_cake);}
			{put(NAME_BAKEDCHEESE_CAKE, block_bakedcheese_cake);}
			{put(NAME_BLUCK_CAEK, block_black_cake);}
			{put(NAME_ZOMBI_CAKE, block_zombi_cake);}
			});
	}

	public static Map<String,Item> itemMap(){
		return (new HashMap<String, Item>(){
			{put(NAME_PIE_HALL, new BlockItemPie(block_pie_hall).setMaxStackSize(16));}
			{put(NAME_CALLAMELPIE_HALL, new BlockItemPie(block_callamelpie_hall).setMaxStackSize(16));}
			{put(NAME_CHOCOPIE_HALL, new BlockItemPie(block_chocopie_hall).setMaxStackSize(16));}
			{put(NAME_SALADA_HALL, new BlockItemPie(block_salada_hall).setMaxStackSize(16));}
			{put(NAME_MEETPIE_HALL, new BlockItemPie(block_meetpie_hall).setMaxStackSize(16));}
			{put(NAME_FISHPIE_HALL, new BlockItemPie(block_fishpie_hall).setMaxStackSize(16));}
			{put(NAME_PUMPKINPIE_HALL, new BlockItemPie(block_pumpkinpie_hall).setMaxStackSize(16));}
			{put(NAME_ZOMBIPEI_HALL, new BlockItemPie(block_zombipei_hall).setMaxStackSize(16));}
			{put(NAME_APPLEPIE_HALL, new BlockItemPie(block_applepie_hall).setMaxStackSize(16));}
			{put(NAME_BLACK_PIE, new BlockItemPie(block_black_pie).setMaxStackSize(32));}
			{put(NAME_PIZZA, new BlockItemPie(block_pizza).setMaxStackSize(32));}
			{put(NAME_MEETPIZZA, new BlockItemPie(block_meet_pizza).setMaxStackSize(32));}
			{put(NAME_FISHPIZZA, new BlockItemPie(block_fish_pizza).setMaxStackSize(32));}
			{put(NAME_CHEESE, new BlockItemPie(block_cheese).setMaxStackSize(64));}
			{put(NAME_BLUECHEESE, new BlockItemPie(block_bluecheese).setMaxStackSize(64));}
			{put(NAME_CHOCO_CAKE, new BlockItemPie(block_choco_cake).setMaxStackSize(1));}
			{put(NAME_APPLE_CAKE, new BlockItemPie(block_apple_cake).setMaxStackSize(1));}
			{put(NAME_SALADA_CAKE, new BlockItemPie(block_salada_cake).setMaxStackSize(1));}
			{put(NAME_MELLON_CAKE, new BlockItemPie(block_mellon_cake).setMaxStackSize(1));}
			{put(NAME_PUMPKIN_CAKE, new BlockItemPie(block_pumpkin_cake).setMaxStackSize(1));}
			{put(NAME_REACHEESE_CAKE, new BlockItemPie(block_reacheese_cake).setMaxStackSize(1));}
			{put(NAME_BAKEDCHEESE_CAKE, new BlockItemPie(block_bakedcheese_cake).setMaxStackSize(1));}
			{put(NAME_BLUCK_CAEK, new BlockItemPie(block_black_cake).setMaxStackSize(1));}
			{put(NAME_ZOMBI_CAKE, new BlockItemPie(block_zombi_cake).setMaxStackSize(1));}
			});
	}

	public static Map<String,ResourceLocation[]> resourceMap(){
		return (new HashMap<String,ResourceLocation[]>(){
			{put(NAME_PIE_HALL, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_PIE_HALL)});}
			{put(NAME_CALLAMELPIE_HALL, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_CALLAMELPIE_HALL)});}
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
			{put(NAME_BLUCK_CAEK, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_BLUCK_CAEK)});}
			{put(NAME_ZOMBI_CAKE, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_ZOMBI_CAKE)});}
			{put(NAME_PIZZA, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_PIZZA)});}
			{put(NAME_MEETPIZZA, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_MEETPIZZA)});}
			{put(NAME_FISHPIZZA, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_FISHPIZZA)});}
			{put(NAME_BLUECHEESE, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_BLUECHEESE)});}
			});
	}
}
