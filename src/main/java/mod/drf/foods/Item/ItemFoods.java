package mod.drf.foods.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mod.drf.core.Mod_DiningFurniture;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent.Register;

public class ItemFoods {
	public static final List<String> NAME_LIST = new ArrayList<String>(){
		{add(NAME_ICEFOOD_BOWL);}
		{add(NAME_CHOCO);}
		{add(NAME_WHITECHOCO);}
		{add(NAME_CARAMEL);}
		{add(NAME_PUDDING);}
		{add(NAME_PUMPKINPUDDING);}
		{add(NAME_PIECEPIE);}
		{add(NAME_PIECECHOCOPIE);}
		{add(NAME_PIECESALADAPIE);}
		{add(NAME_PIECEMEETPIE);}
		{add(NAME_PIECEFISHPIE);}
		{add(NAME_PIECEPUMPUKINPIE);}
		{add(NAME_PIECEZOMBIPIE);}
		{add(NAME_PIECEAPPLEPIE);}
		{add(NAME_PIECEblackPIE);}
		{add(NAME_PIECECARAMELPIE);}
		{add(NAME_EGGSANDWICH);}
		{add(NAME_POTATSALADASANDWITCH);}
		{add(NAME_HAMSANDWICH);}
		{add(NAME_MUTTONSANDWICH);}
		{add(NAME_STAKESANDWICH);}
		{add(NAME_CHIKENSANDWICH);}
		{add(NAME_CHOCOSANDWICH);}
		{add(NAME_POTATOSALADA);}
		{add(NAME_PUMPKINSALDADA);}
		{add(NAME_PUMPKINSALADASANDWICH);}
		{add(NAME_BUTTER);}
		{add(NAME_MOLD);}
		{add(NAME_BLUEMOLD);}
		{add(NAME_SALT);}
		{add(NAME_RENNET);}
		{add(NAME_ROW_PIE_HALL);}
		{add(NAME_ROW_CHOCOPIE_HALL);}
		{add(NAME_ROW_SALADA_HALL);}
		{add(NAME_ROW_MEETPIE_HALL);}
		{add(NAME_ROW_FISHPIE_HALL);}
		{add(NAME_ROW_PUMPKINPIE_HALL);}
		{add(NAME_ROW_APPLEPIE_HALL);}
		{add(NAME_ROW_BLACK_PIE);}
		{add(NAME_ROW_ZOMBIPEI_HALL);}
		{add(NAME_ROW_PIZZA);}
		{add(NAME_ROW_MEETPIZZA);}
		{add(NAME_ROW_FISHPIZZA);}
		{add(NAME_ICE_MIX_VANILA);}
		{add(NAME_ICE_MIX_BLACK);}
		{add(NAME_ICE_MIX_RED);}
		{add(NAME_ICE_MIX_GREEN);}
		{add(NAME_ICE_MIX_BROWN);}
		{add(NAME_ICE_MIX_BLUE);}
		{add(NAME_ICE_MIX_PURPLE);}
		{add(NAME_ICE_MIX_CYAN);}
		{add(NAME_ICE_MIX_SILVER);}
		{add(NAME_ICE_MIX_GRAY);}
		{add(NAME_ICE_MIX_PINK);}
		{add(NAME_ICE_MIX_LIME);}
		{add(NAME_ICE_MIX_YELLOW);}
		{add(NAME_ICE_MIX_LIGHT_BLUE);}
		{add(NAME_ICE_MIX_MAGENTA);}
		{add(NAME_ICE_MIX_ORANGE);}
		{add(NAME_ICE_MIX_WHITE);}
		{add(NAME_ICE_MIX_APPLE);}
		{add(NAME_ICE_MIX_CACTUS);}
		{add(NAME_ICE_MIX_PUMPKIN);}
		{add(NAME_ICE_MIX_POTATO);}
		{add(NAME_ICE_MIX_CARROT);}
		{add(NAME_ICE_MIX_MELON);}
		{add(NAME_ICE_MIX_GREENTEA);}
		{add(NAME_ICECREAM_VANILA);}
		{add(NAME_ICECREAM_BLACK);}
		{add(NAME_ICECREAM_RED);}
		{add(NAME_ICECREAM_GREEN);}
		{add(NAME_ICECREAM_BROWN);}
		{add(NAME_ICECREAM_BLUE);}
		{add(NAME_ICECREAM_PURPLE);}
		{add(NAME_ICECREAM_CYAN);}
		{add(NAME_ICECREAM_SILVER);}
		{add(NAME_ICECREAM_GRAY);}
		{add(NAME_ICECREAM_PINK);}
		{add(NAME_ICECREAM_LIME);}
		{add(NAME_ICECREAM_YELLOW);}
		{add(NAME_ICECREAM_LIGHT_BLUE);}
		{add(NAME_ICECREAM_MAGENTA);}
		{add(NAME_ICECREAM_ORANGE);}
		{add(NAME_ICECREAM_WHITE);}
		{add(NAME_ICECREAM_APPLE);}
		{add(NAME_ICECREAM_CACTUS);}
		{add(NAME_ICECREAM_PUMPKIN);}
		{add(NAME_ICECREAM_POTATO);}
		{add(NAME_ICECREAM_CARROT);}
		{add(NAME_ICECREAM_MELON);}
		{add(NAME_ICECREAM_GREENTEA);}
		{add(NAME_ICECREAM_COOKIE_VANILA);}
		{add(NAME_ICECREAM_COOKIE_BLACK);}
		{add(NAME_ICECREAM_COOKIE_RED);}
		{add(NAME_ICECREAM_COOKIE_GREEN);}
		{add(NAME_ICECREAM_COOKIE_BROWN);}
		{add(NAME_ICECREAM_COOKIE_BLUE);}
		{add(NAME_ICECREAM_COOKIE_PURPLE);}
		{add(NAME_ICECREAM_COOKIE_CYAN);}
		{add(NAME_ICECREAM_COOKIE_SILVER);}
		{add(NAME_ICECREAM_COOKIE_GRAY);}
		{add(NAME_ICECREAM_COOKIE_PINK);}
		{add(NAME_ICECREAM_COOKIE_LIME);}
		{add(NAME_ICECREAM_COOKIE_YELLOW);}
		{add(NAME_ICECREAM_COOKIE_LIGHT_BLUE);}
		{add(NAME_ICECREAM_COOKIE_MAGENTA);}
		{add(NAME_ICECREAM_COOKIE_ORANGE);}
		{add(NAME_ICECREAM_COOKIE_WHITE);}
		{add(NAME_ICECREAM_COOKIE_APPLE);}
		{add(NAME_ICECREAM_COOKIE_CACTUS);}
		{add(NAME_ICECREAM_COOKIE_PUMPKIN);}
		{add(NAME_ICECREAM_COOKIE_POTATO);}
		{add(NAME_ICECREAM_COOKIE_CARROT);}
		{add(NAME_ICECREAM_COOKIE_MELON);}
		{add(NAME_ICECREAM_COOKIE_GREENTEA);}
		{add(NAME_SYRUP_SUGAR);}
		{add(NAME_SYRUP_BLACK);}
		{add(NAME_SYRUP_RED);}
		{add(NAME_SYRUP_GREEN);}
		{add(NAME_SYRUP_BROWN);}
		{add(NAME_SYRUP_BLUE);}
		{add(NAME_SYRUP_PURPLE);}
		{add(NAME_SYRUP_CYAN);}
		{add(NAME_SYRUP_SILVER);}
		{add(NAME_SYRUP_GRAY);}
		{add(NAME_SYRUP_PINK);}
		{add(NAME_SYRUP_LIME);}
		{add(NAME_SYRUP_YELLOW);}
		{add(NAME_SYRUP_LIGHT_BLUE);}
		{add(NAME_SYRUP_MAGENTA);}
		{add(NAME_SYRUP_ORANGE);}
		{add(NAME_SYRUP_WHITE);}
		{add(NAME_SYRUP_APPLE);}
		{add(NAME_SYRUP_CACTUS);}
		{add(NAME_SYRUP_MELON);}
		{add(NAME_SYRUP_PUMPKIN);}
		{add(NAME_SYRUP_GREENTEA);}
		{add(NAME_SUGARMILK);}
		{add(NAME_SYRUP_MILK);}
		{add(NAME_CRASHEDICE_NONE);}
		{add(NAME_CRASHEDICE_SUGAR);}
		{add(NAME_CRASHEDICE_BLACK);}
		{add(NAME_CRASHEDICE_RED);}
		{add(NAME_CRASHEDICE_GREEN);}
		{add(NAME_CRASHEDICE_BROWN);}
		{add(NAME_CRASHEDICE_BLUE);}
		{add(NAME_CRASHEDICE_PURPLE);}
		{add(NAME_CRASHEDICE_CYAN);}
		{add(NAME_CRASHEDICE_SILVER);}
		{add(NAME_CRASHEDICE_GRAY);}
		{add(NAME_CRASHEDICE_PINK);}
		{add(NAME_CRASHEDICE_LIME);}
		{add(NAME_CRASHEDICE_YELLOW);}
		{add(NAME_CRASHEDICE_LIGHT_BLUE);}
		{add(NAME_CRASHEDICE_MAGENTA);}
		{add(NAME_CRASHEDICE_ORANGE);}
		{add(NAME_CRASHEDICE_WHITE);}
		{add(NAME_CRASHEDICE_APPLE);}
		{add(NAME_CRASHEDICE_CACTUS);}
		{add(NAME_CRASHEDICE_MELON);}
		{add(NAME_CRASHEDICE_PUMPKIN);}
		{add(NAME_CRASHEDICE_GREENTEA);}
		{add(NAME_CRASHEDICE_MILK_NONE);}
		{add(NAME_CRASHEDICE_MILK_SUGAR);}
		{add(NAME_CRASHEDICE_MILK_BLACK);}
		{add(NAME_CRASHEDICE_MILK_RED);}
		{add(NAME_CRASHEDICE_MILK_GREEN);}
		{add(NAME_CRASHEDICE_MILK_BROWN);}
		{add(NAME_CRASHEDICE_MILK_BLUE);}
		{add(NAME_CRASHEDICE_MILK_PURPLE);}
		{add(NAME_CRASHEDICE_MILK_CYAN);}
		{add(NAME_CRASHEDICE_MILK_SILVER);}
		{add(NAME_CRASHEDICE_MILK_GRAY);}
		{add(NAME_CRASHEDICE_MILK_PINK);}
		{add(NAME_CRASHEDICE_MILK_LIME);}
		{add(NAME_CRASHEDICE_MILK_YELLOW);}
		{add(NAME_CRASHEDICE_MILK_LIGHT_BLUE);}
		{add(NAME_CRASHEDICE_MILK_MAGENTA);}
		{add(NAME_CRASHEDICE_MILK_ORANGE);}
		{add(NAME_CRASHEDICE_MILK_WHITE);}
		{add(NAME_CRASHEDICE_MILK_APPLE);}
		{add(NAME_CRASHEDICE_MILK_CACTUS);}
		{add(NAME_CRASHEDICE_MILK_MELON);}
		{add(NAME_CRASHEDICE_MILK_PUMPKIN);}
		{add(NAME_CRASHEDICE_MILK_GREENTEA);}
		{add(NAME_SUGAR_WATER_NONE);}
		{add(NAME_SUGAR_WATER_SUGAR);}
		{add(NAME_SUGAR_WATER_BLACK);}
		{add(NAME_SUGAR_WATER_RED);}
		{add(NAME_SUGAR_WATER_GREEN);}
		{add(NAME_SUGAR_WATER_BROWN);}
		{add(NAME_SUGAR_WATER_BLUE);}
		{add(NAME_SUGAR_WATER_PURPLE);}
		{add(NAME_SUGAR_WATER_CYAN);}
		{add(NAME_SUGAR_WATER_SILVER);}
		{add(NAME_SUGAR_WATER_GRAY);}
		{add(NAME_SUGAR_WATER_PINK);}
		{add(NAME_SUGAR_WATER_LIME);}
		{add(NAME_SUGAR_WATER_YELLOW);}
		{add(NAME_SUGAR_WATER_LIGHT_BLUE);}
		{add(NAME_SUGAR_WATER_MAGENTA);}
		{add(NAME_SUGAR_WATER_ORANGE);}
		{add(NAME_SUGAR_WATER_WHITE);}
		{add(NAME_SUGAR_WATER_APPLE);}
		{add(NAME_SUGAR_WATER_CACTUS);}
		{add(NAME_SUGAR_WATER_MELON);}
		{add(NAME_SUGAR_WATER_PUMPKIN);}
		{add(NAME_SUGAR_WATER_GREENTEA);}
		{add(NAME_ICECANDY_NONE);}
		{add(NAME_ICECANDY_SUGAR);}
		{add(NAME_ICECANDY_BLACK);}
		{add(NAME_ICECANDY_RED);}
		{add(NAME_ICECANDY_GREEN);}
		{add(NAME_ICECANDY_BROWN);}
		{add(NAME_ICECANDY_BLUE);}
		{add(NAME_ICECANDY_PURPLE);}
		{add(NAME_ICECANDY_CYAN);}
		{add(NAME_ICECANDY_SILVER);}
		{add(NAME_ICECANDY_GRAY);}
		{add(NAME_ICECANDY_PINK);}
		{add(NAME_ICECANDY_LIME);}
		{add(NAME_ICECANDY_YELLOW);}
		{add(NAME_ICECANDY_LIGHT_BLUE);}
		{add(NAME_ICECANDY_MAGENTA);}
		{add(NAME_ICECANDY_ORANGE);}
		{add(NAME_ICECANDY_WHITE);}
		{add(NAME_ICECANDY_APPLE);}
		{add(NAME_ICECANDY_CACTUS);}
		{add(NAME_ICECANDY_MELON);}
		{add(NAME_ICECANDY_PUMPKIN);}
		{add(NAME_ICECANDY_GREENTEA);}
		{add(NAME_FLOUR);}
		{add(NAME_UDON);}
		{add(NAME_PASTA);}
		{add(NAME_LAMEN);}
		{add(NAME_MEET_PASTA);}
		{add(NAME_FISH_PASTA);}
		{add(NAME_BLACK_PASTA);}
		{add(NAME_ZARUUDON);}
		{add(NAME_KAKEUDON);}
		{add(NAME_TUKIMIUDON);}
		{add(NAME_NIKUUDON);}
		{add(NAME_MEETRAMEN);}
		{add(NAME_FISHRAMEN);}
		{add(NAME_EGGRAMEN);}
		{add(NAME_MEETMILL_BEEF);}
		{add(NAME_MEETMILL_POKE);}
		{add(NAME_MEETMILL_CHIKIN);}
		{add(NAME_MEETMILL_MUTTON);}
		{add(NAME_DUST_FLOWER_DANDELION);}
		{add(NAME_DUST_FLOWER_POPY);}
		{add(NAME_DUST_FLOWER_ORCHID);}
		{add(NAME_DUST_FLOWER_ALLIUM);}
		{add(NAME_DUST_FLOWER_AZUREBLUET);}
		{add(NAME_DUST_FLOWER_TULIP);}
		{add(NAME_DUST_FLOWER_OXEYDAISY);}
		{add(NAME_DUST_FLOWER_SUNFLOWER);}
		{add(NAME_DUST_FLOWER_LILAC);}
		{add(NAME_DUST_FLOWER_ROSE);};
		{add(NAME_DUST_FLOWER_PEONY);}
		{add(NAME_DUST_FLOWER_PANACEA);}
		{add(NAME_TEA_FLOWER_DANDELION);}
		{add(NAME_TEA_FLOWER_POPY);}
		{add(NAME_TEA_FLOWER_ORCHID);}
		{add(NAME_TEA_FLOWER_ALLIUM);}
		{add(NAME_TEA_FLOWER_AZUREBLUET);}
		{add(NAME_TEA_FLOWER_TULIP);}
		{add(NAME_TEA_FLOWER_OXEYDAISY);}
		{add(NAME_TEA_FLOWER_SUNFLOWER);}
		{add(NAME_TEA_FLOWER_LILAC);}
		{add(NAME_TEA_FLOWER_ROSE);}
		{add(NAME_TEA_FLOWER_PEONY);}
		{add(NAME_TEA_FLOWER_PANACEA);}
		{add(NAME_DEBUG_ITEM);}

	};

	// アイスの器
	public static final String NAME_ICEFOOD_BOWL = "icefoodbowl";

//	チョコレート
	public static final String NAME_CHOCO = "chocolate";
//	ホワイトチョコレート
	public static final String NAME_WHITECHOCO ="whitechocolate";
//	キャラメル
	public static final String NAME_CARAMEL = "caramel";
//	プリン
	public static final String NAME_PUDDING = "pudding";
//	かぼちゃプリン
	public static final String NAME_PUMPKINPUDDING = "pumpukinpudding";
//	パイ
	public static final String NAME_PIECEPIE = "piecepie";
//	チョコレートパイ
	public static final String NAME_PIECECHOCOPIE ="piecepiechoco";
//	サラダパイ
	public static final String NAME_PIECESALADAPIE = "piecepiesalada";
//	ミートパイ
	public static final String NAME_PIECEMEETPIE = "piecepiemeet";
//	フィッシュパイ
	public static final String NAME_PIECEFISHPIE="piecepiefish";
//	かぼちゃパイ
	public static final String NAME_PIECEPUMPUKINPIE ="piecepiepumpkin";
//	ゾンビーフパイ
	public static final String NAME_PIECEZOMBIPIE="piecepiezombi";
//	アップルパイ
	public static final String NAME_PIECEAPPLEPIE="piecepieapple";
//	烏賊墨パイ
	public static final String NAME_PIECEblackPIE="piecepieblack";
//	カラメルパイ
	public static final String NAME_PIECECARAMELPIE="piecepiecaramel";
//	卵サンド
	public static final String NAME_EGGSANDWICH="sandwitchegg";
//	ポテトサラダサンド
	public static final String NAME_POTATSALADASANDWITCH="sandwitchpotato";
//	ハムサンド
	public static final String NAME_HAMSANDWICH="sandwitchhum";
//	ジンギスカンサンド
	public static final String NAME_MUTTONSANDWICH="sandwitchmutton";
//	ステーキサンド
	public static final String NAME_STAKESANDWICH="sandwitchstake";
//	てりやきサンド
	public static final String NAME_CHIKENSANDWICH="sandwitchchikin";
//	チョコサンド
	public static final String NAME_CHOCOSANDWICH="sandwitchchoco";
//	ポテトサラダ
	public static final String NAME_POTATOSALADA = "potatosalada";
//	パンプキンサラダ
	public static final String NAME_PUMPKINSALDADA = "pumpukinsalada";
//	パンプキンサラダサンド
	public static final String NAME_PUMPKINSALADASANDWICH ="sandwitchpumpkin";
//	バター
	public static final String NAME_BUTTER = "butter";
	// カビ
	public static final String NAME_MOLD = "modl";
	// 青カビ
	public static final String NAME_BLUEMOLD = "bluemold";
	// 塩
	public static final String NAME_SALT = "salt";
	// レンネット
	public static final String NAME_RENNET = "rennet";

	// パイ
	public static final String NAME_ROW_PIE_HALL = "row_piehall";
	// チョコパイ
	public static final String NAME_ROW_CHOCOPIE_HALL = "row_piehallchoco";
	// 野菜パイ
	public static final String NAME_ROW_SALADA_HALL = "row_piehallsalada";
	// ミートパイ
	public static final String NAME_ROW_MEETPIE_HALL = "row_piehallmeet";
	// 魚パイ
	public static final String NAME_ROW_FISHPIE_HALL = "row_piehallfish";
	// かぼちゃパイ
	public static final String NAME_ROW_PUMPKINPIE_HALL = "row_piehallpumpkin";
	// リンゴパイ
	public static final String NAME_ROW_APPLEPIE_HALL = "row_piehallapple";
	// 烏賊墨パイ
	public static final String NAME_ROW_BLACK_PIE = "row_piehallblack";
	// ゾンビパイ
	public static final String NAME_ROW_ZOMBIPEI_HALL = "row_piehallzombi";
	// ピザ
	public static final String NAME_ROW_PIZZA = "row_pizza";
	// 肉ピザ
	public static final String NAME_ROW_MEETPIZZA ="row_pizzameet";
	// アンチョビピザ
	public static final String NAME_ROW_FISHPIZZA = "row_pizafish";


	// アイスクリーム液
	public static final String NAME_ICE_MIX_VANILA = "icemix_vanila";
	public static final String NAME_ICE_MIX_BLACK = "icemix_black";
	public static final String NAME_ICE_MIX_RED = "icemix_red";
	public static final String NAME_ICE_MIX_GREEN = "icemix_green";
	public static final String NAME_ICE_MIX_BROWN = "icemix_brown";
	public static final String NAME_ICE_MIX_BLUE = "icemix_blue";
	public static final String NAME_ICE_MIX_PURPLE = "icemix_purple";
	public static final String NAME_ICE_MIX_CYAN = "icemix_cyan";
	public static final String NAME_ICE_MIX_SILVER = "icemix_silver";
	public static final String NAME_ICE_MIX_GRAY = "icemix_gray";
	public static final String NAME_ICE_MIX_PINK = "icemix_pink";
	public static final String NAME_ICE_MIX_LIME = "icemix_lime";
	public static final String NAME_ICE_MIX_YELLOW = "icemix_yellow";
	public static final String NAME_ICE_MIX_LIGHT_BLUE = "icemix_light_blue";
	public static final String NAME_ICE_MIX_MAGENTA = "icemix_magenta";
	public static final String NAME_ICE_MIX_ORANGE = "icemix_orange";
	public static final String NAME_ICE_MIX_WHITE = "icemix_white";
	public static final String NAME_ICE_MIX_APPLE = "icemix_apple";
	public static final String NAME_ICE_MIX_CACTUS = "icemix_cactus";
	public static final String NAME_ICE_MIX_PUMPKIN = "icemix_pumpkin";
	public static final String NAME_ICE_MIX_POTATO = "icemix_potato";
	public static final String NAME_ICE_MIX_CARROT = "icemix_carrot";
	public static final String NAME_ICE_MIX_MELON = "icemix_melon";
	public static final String NAME_ICE_MIX_GREENTEA = "icemix_greentea";

	//	アイスクリーム
	public static final String NAME_ICECREAM_VANILA ="icecream_vanila";
	public static final String NAME_ICECREAM_BLACK ="icecream_black";
	public static final String NAME_ICECREAM_RED ="icecream_red";
	public static final String NAME_ICECREAM_GREEN ="icecream_green";
	public static final String NAME_ICECREAM_BROWN ="icecream_brown";
	public static final String NAME_ICECREAM_BLUE ="icecream_blue";
	public static final String NAME_ICECREAM_PURPLE ="icecream_purple";
	public static final String NAME_ICECREAM_CYAN ="icecream_cyan";
	public static final String NAME_ICECREAM_SILVER ="icecream_silver";
	public static final String NAME_ICECREAM_GRAY ="icecream_gray";
	public static final String NAME_ICECREAM_PINK ="icecream_pink";
	public static final String NAME_ICECREAM_LIME ="icecream_lime";
	public static final String NAME_ICECREAM_YELLOW ="icecream_yellow";
	public static final String NAME_ICECREAM_LIGHT_BLUE ="icecream_light_blue";
	public static final String NAME_ICECREAM_MAGENTA ="icecream_magenta";
	public static final String NAME_ICECREAM_ORANGE ="icecream_orange";
	public static final String NAME_ICECREAM_WHITE ="icecream_white";
	public static final String NAME_ICECREAM_APPLE ="icecream_apple";
	public static final String NAME_ICECREAM_CACTUS ="icecream_cactus";
	public static final String NAME_ICECREAM_PUMPKIN ="icecream_pumpkin";
	public static final String NAME_ICECREAM_POTATO ="icecream_potato";
	public static final String NAME_ICECREAM_CARROT ="icecream_carrot";
	public static final String NAME_ICECREAM_MELON ="icecream_melon";
	public static final String NAME_ICECREAM_GREENTEA ="icecream_greentea";

	// クッキー入りアイス
	public static final String NAME_ICECREAM_COOKIE_VANILA = "ck_icecream_vanila";
	public static final String NAME_ICECREAM_COOKIE_BLACK ="ck_icecream_black";
	public static final String NAME_ICECREAM_COOKIE_RED ="ck_icecream_red";
	public static final String NAME_ICECREAM_COOKIE_GREEN ="ck_icecream_green";
	public static final String NAME_ICECREAM_COOKIE_BROWN ="ck_icecream_brown";
	public static final String NAME_ICECREAM_COOKIE_BLUE ="ck_icecream_blue";
	public static final String NAME_ICECREAM_COOKIE_PURPLE ="ck_icecream_purple";
	public static final String NAME_ICECREAM_COOKIE_CYAN ="ck_icecream_cyan";
	public static final String NAME_ICECREAM_COOKIE_SILVER ="ck_icecream_silver";
	public static final String NAME_ICECREAM_COOKIE_GRAY ="ck_icecream_gray";
	public static final String NAME_ICECREAM_COOKIE_PINK ="ck_icecream_pink";
	public static final String NAME_ICECREAM_COOKIE_LIME ="ck_icecream_lime";
	public static final String NAME_ICECREAM_COOKIE_YELLOW ="ck_icecream_yellow";
	public static final String NAME_ICECREAM_COOKIE_LIGHT_BLUE ="ck_icecream_light_blue";
	public static final String NAME_ICECREAM_COOKIE_MAGENTA ="ck_icecream_magenta";
	public static final String NAME_ICECREAM_COOKIE_ORANGE ="ck_icecream_orange";
	public static final String NAME_ICECREAM_COOKIE_WHITE ="ck_icecream_white";
	public static final String NAME_ICECREAM_COOKIE_APPLE ="ck_icecream_apple";
	public static final String NAME_ICECREAM_COOKIE_CACTUS ="ck_icecream_cactus";
	public static final String NAME_ICECREAM_COOKIE_PUMPKIN ="ck_icecream_pumpkin";
	public static final String NAME_ICECREAM_COOKIE_POTATO ="ck_icecream_potato";
	public static final String NAME_ICECREAM_COOKIE_CARROT ="ck_icecream_carrot";
	public static final String NAME_ICECREAM_COOKIE_MELON ="ck_icecream_melon";
	public static final String NAME_ICECREAM_COOKIE_GREENTEA ="ck_icecream_greentea";


	// シロップ
	public static final String NAME_SYRUP_SUGAR = "syrup_sugar";
	public static final String NAME_SYRUP_BLACK = "syrup_black";
	public static final String NAME_SYRUP_RED = "syrup_red";
	public static final String NAME_SYRUP_GREEN = "syrup_green";
	public static final String NAME_SYRUP_BROWN = "syrup_brown";
	public static final String NAME_SYRUP_BLUE = "syrup_blue";
	public static final String NAME_SYRUP_PURPLE = "syrup_purple";
	public static final String NAME_SYRUP_CYAN = "syrup_cyan";
	public static final String NAME_SYRUP_SILVER = "syrup_silver";
	public static final String NAME_SYRUP_GRAY = "syrup_gray";
	public static final String NAME_SYRUP_PINK = "syrup_pink";
	public static final String NAME_SYRUP_LIME = "syrup_lime";
	public static final String NAME_SYRUP_YELLOW = "syrup_yellow";
	public static final String NAME_SYRUP_LIGHT_BLUE = "syrup_light_blue";
	public static final String NAME_SYRUP_MAGENTA = "syrup_magenta";
	public static final String NAME_SYRUP_ORANGE = "syrup_orange";
	public static final String NAME_SYRUP_WHITE = "syrup_white";
	public static final String NAME_SYRUP_APPLE = "syrup_apple";
	public static final String NAME_SYRUP_CACTUS = "syrup_cactus";
	public static final String NAME_SYRUP_MELON = "syrup_melon";
	public static final String NAME_SYRUP_PUMPKIN = "syrup_pumpkin";
	public static final String NAME_SYRUP_GREENTEA = "syrup_greentea";

	// 砂糖入り牛乳
	public static final String NAME_SUGARMILK = "sugarmillk";
	// 練乳
	public static final String NAME_SYRUP_MILK = "condencedmilk";
	// 練乳かき氷
	public static final String NAME_CRASHEDICE_NONE = "crashedice_none";
	public static final String NAME_CRASHEDICE_SUGAR = "crashedice_sugar";
	public static final String NAME_CRASHEDICE_BLACK = "crashedice_black";
	public static final String NAME_CRASHEDICE_RED = "crashedice_red";
	public static final String NAME_CRASHEDICE_GREEN = "crashedice_green";
	public static final String NAME_CRASHEDICE_BROWN = "crashedice_brown";
	public static final String NAME_CRASHEDICE_BLUE = "crashedice_blue";
	public static final String NAME_CRASHEDICE_PURPLE = "crashedice_purple";
	public static final String NAME_CRASHEDICE_CYAN = "crashedice_cyan";
	public static final String NAME_CRASHEDICE_SILVER = "crashedice_silver";
	public static final String NAME_CRASHEDICE_GRAY = "crashedice_gray";
	public static final String NAME_CRASHEDICE_PINK = "crashedice_pink";
	public static final String NAME_CRASHEDICE_LIME = "crashedice_lime";
	public static final String NAME_CRASHEDICE_YELLOW = "crashedice_yellow";
	public static final String NAME_CRASHEDICE_LIGHT_BLUE = "crashedice_light_blue";
	public static final String NAME_CRASHEDICE_MAGENTA = "crashedice_magenta";
	public static final String NAME_CRASHEDICE_ORANGE = "crashedice_orange";
	public static final String NAME_CRASHEDICE_WHITE = "crashedice_white";
	public static final String NAME_CRASHEDICE_APPLE = "crashedice_apple";
	public static final String NAME_CRASHEDICE_CACTUS = "crashedice_cactus";
	public static final String NAME_CRASHEDICE_MELON = "crashedice_melon";
	public static final String NAME_CRASHEDICE_PUMPKIN = "crashedice_pumpkin";
	public static final String NAME_CRASHEDICE_GREENTEA = "crashedice_greentea";

	// 練乳かき氷
	public static final String NAME_CRASHEDICE_MILK_NONE = "mk_crashedice_none";
	public static final String NAME_CRASHEDICE_MILK_SUGAR = "mk_crashedice_sugar";
	public static final String NAME_CRASHEDICE_MILK_BLACK = "mk_crashedice_black";
	public static final String NAME_CRASHEDICE_MILK_RED = "mk_crashedice_red";
	public static final String NAME_CRASHEDICE_MILK_GREEN = "mk_crashedice_green";
	public static final String NAME_CRASHEDICE_MILK_BROWN = "mk_crashedice_brown";
	public static final String NAME_CRASHEDICE_MILK_BLUE = "mk_crashedice_blue";
	public static final String NAME_CRASHEDICE_MILK_PURPLE = "mk_crashedice_purple";
	public static final String NAME_CRASHEDICE_MILK_CYAN = "mk_crashedice_cyan";
	public static final String NAME_CRASHEDICE_MILK_SILVER = "mk_crashedice_silver";
	public static final String NAME_CRASHEDICE_MILK_GRAY = "mk_crashedice_gray";
	public static final String NAME_CRASHEDICE_MILK_PINK = "mk_crashedice_pink";
	public static final String NAME_CRASHEDICE_MILK_LIME = "mk_crashedice_lime";
	public static final String NAME_CRASHEDICE_MILK_YELLOW = "mk_crashedice_yellow";
	public static final String NAME_CRASHEDICE_MILK_LIGHT_BLUE = "mk_crashedice_light_blue";
	public static final String NAME_CRASHEDICE_MILK_MAGENTA = "mk_crashedice_magenta";
	public static final String NAME_CRASHEDICE_MILK_ORANGE = "mk_crashedice_orange";
	public static final String NAME_CRASHEDICE_MILK_WHITE = "mk_crashedice_white";
	public static final String NAME_CRASHEDICE_MILK_APPLE = "mk_crashedice_apple";
	public static final String NAME_CRASHEDICE_MILK_CACTUS = "mk_crashedice_cactus";
	public static final String NAME_CRASHEDICE_MILK_MELON = "mk_crashedice_melon";
	public static final String NAME_CRASHEDICE_MILK_PUMPKIN = "mk_crashedice_pumpkin";
	public static final String NAME_CRASHEDICE_MILK_GREENTEA = "mk_crashedice_greentea";

	// キャンディ液
	public static final String NAME_SUGAR_WATER_NONE = "icesugarwater_none";
	public static final String NAME_SUGAR_WATER_SUGAR = "icesugarwater_sugar";
	public static final String NAME_SUGAR_WATER_BLACK = "icesugarwater_black";
	public static final String NAME_SUGAR_WATER_RED = "icesugarwater_red";
	public static final String NAME_SUGAR_WATER_GREEN = "icesugarwater_green";
	public static final String NAME_SUGAR_WATER_BROWN = "icesugarwater_brown";
	public static final String NAME_SUGAR_WATER_BLUE = "icesugarwater_blue";
	public static final String NAME_SUGAR_WATER_PURPLE = "icesugarwater_purple";
	public static final String NAME_SUGAR_WATER_CYAN = "icesugarwater_cyan";
	public static final String NAME_SUGAR_WATER_SILVER = "icesugarwater_silver";
	public static final String NAME_SUGAR_WATER_GRAY = "icesugarwater_gray";
	public static final String NAME_SUGAR_WATER_PINK = "icesugarwater_pink";
	public static final String NAME_SUGAR_WATER_LIME = "icesugarwater_lime";
	public static final String NAME_SUGAR_WATER_YELLOW = "icesugarwater_yellow";
	public static final String NAME_SUGAR_WATER_LIGHT_BLUE = "icesugarwater_light_blue";
	public static final String NAME_SUGAR_WATER_MAGENTA = "icesugarwater_magenta";
	public static final String NAME_SUGAR_WATER_ORANGE = "icesugarwater_orange";
	public static final String NAME_SUGAR_WATER_WHITE = "icesugarwater_white";
	public static final String NAME_SUGAR_WATER_APPLE = "icesugarwater_apple";
	public static final String NAME_SUGAR_WATER_CACTUS = "icesugarwater_cactus";
	public static final String NAME_SUGAR_WATER_MELON = "icesugarwater_melon";
	public static final String NAME_SUGAR_WATER_PUMPKIN = "icesugarwater_pumpkin";
	public static final String NAME_SUGAR_WATER_GREENTEA = "icesugarwater_greentea";

	// アイスキャンディ
	public static final String NAME_ICECANDY_NONE = "icecandy_none";
	public static final String NAME_ICECANDY_SUGAR = "icecandy_sugar";
	public static final String NAME_ICECANDY_BLACK = "icecandy_black";
	public static final String NAME_ICECANDY_RED = "icecandy_red";
	public static final String NAME_ICECANDY_GREEN = "icecandy_green";
	public static final String NAME_ICECANDY_BROWN = "icecandy_brown";
	public static final String NAME_ICECANDY_BLUE = "icecandy_blue";
	public static final String NAME_ICECANDY_PURPLE = "icecandy_purple";
	public static final String NAME_ICECANDY_CYAN = "icecandy_cyan";
	public static final String NAME_ICECANDY_SILVER = "icecandy_silver";
	public static final String NAME_ICECANDY_GRAY = "icecandy_gray";
	public static final String NAME_ICECANDY_PINK = "icecandy_pink";
	public static final String NAME_ICECANDY_LIME = "icecandy_lime";
	public static final String NAME_ICECANDY_YELLOW = "icecandy_yellow";
	public static final String NAME_ICECANDY_LIGHT_BLUE = "icecandy_light_blue";
	public static final String NAME_ICECANDY_MAGENTA = "icecandy_magenta";
	public static final String NAME_ICECANDY_ORANGE = "icecandy_orange";
	public static final String NAME_ICECANDY_WHITE = "icecandy_white";
	public static final String NAME_ICECANDY_APPLE = "icecandy_apple";
	public static final String NAME_ICECANDY_CACTUS = "icecandy_cactus";
	public static final String NAME_ICECANDY_MELON = "icecandy_melon";
	public static final String NAME_ICECANDY_PUMPKIN = "icecandy_pumpkin";
	public static final String NAME_ICECANDY_GREENTEA = "icecandy_greentea";


	// 小麦粉
	public static final String NAME_FLOUR = "flour";
	// うどん
	public static final String NAME_UDON = "udon";
	// パスタ
	public static final String NAME_PASTA = "pasta";
	// ラーメン
	public static final String NAME_LAMEN = "ramen";
	// ミートスパ
	public static final String NAME_MEET_PASTA = "pastameet";
	// シーフードスパ
	public static final String NAME_FISH_PASTA = "pastafish";
	// イカスミスパ
	public static final String NAME_BLACK_PASTA = "pastablack";
	// ざるうどん
	public static final String NAME_ZARUUDON = "udonzaru";
	// かけうどん
	public static final String NAME_KAKEUDON = "udonkake";
	// 月見うどん
	public static final String NAME_TUKIMIUDON ="udontukimi";
	// 肉うどん
	public static final String NAME_NIKUUDON = "udonniku";
	// チャーシューメン
	public static final String NAME_MEETRAMEN = "ramenmeet";
	// シーフードラーメン
	public static final String NAME_FISHRAMEN = "ramenfish";
	// 月見ラーメン
	public static final String NAME_EGGRAMEN = "ramenegg";
	// 牛ひき肉
	public static final String NAME_MEETMILL_BEEF = "meetmillbeef";
	// 豚ひき肉
	public static final String NAME_MEETMILL_POKE = "meetmillpoke";
	// 鶏ひき肉
	public static final String NAME_MEETMILL_CHIKIN = "meetmillchikin";
	// 羊ひき肉
	public static final String NAME_MEETMILL_MUTTON = "meetmillmutton";

	// 花の粉末
	public static final String NAME_DUST_FLOWER_DANDELION="flowerdust_dandelion";
	public static final String NAME_DUST_FLOWER_POPY="flowerdust_popy";
	public static final String NAME_DUST_FLOWER_ORCHID="flowerdust_orchid";
	public static final String NAME_DUST_FLOWER_ALLIUM="flowerdust_allium";
	public static final String NAME_DUST_FLOWER_AZUREBLUET="flowerdust_azurebluet";
	public static final String NAME_DUST_FLOWER_TULIP="flowerdust_tulip";
	public static final String NAME_DUST_FLOWER_OXEYDAISY="flowerdust_oxeydaisy";
	public static final String NAME_DUST_FLOWER_SUNFLOWER="flowerdust_sunflower";
	public static final String NAME_DUST_FLOWER_LILAC="flowerdust_lilac";
	public static final String NAME_DUST_FLOWER_ROSE="flowerdust_rose";
	public static final String NAME_DUST_FLOWER_PEONY="flowerdust_peony";
	public static final String NAME_DUST_FLOWER_PANACEA="flowerdust_panacea";
	// 花のお茶
	public static final String NAME_TEA_FLOWER_DANDELION="flowertea_dandelion";
	public static final String NAME_TEA_FLOWER_POPY="flowertea_popy";
	public static final String NAME_TEA_FLOWER_ORCHID="flowertea_orchid";
	public static final String NAME_TEA_FLOWER_ALLIUM="flowertea_allium";
	public static final String NAME_TEA_FLOWER_AZUREBLUET="flowertea_azurebluet";
	public static final String NAME_TEA_FLOWER_TULIP="flowertea_tulip";
	public static final String NAME_TEA_FLOWER_OXEYDAISY="flowertea_oxeydaisy";
	public static final String NAME_TEA_FLOWER_SUNFLOWER="flowertea_sunflower";
	public static final String NAME_TEA_FLOWER_LILAC="flowertea_lilac";
	public static final String NAME_TEA_FLOWER_ROSE="flowertea_rose";
	public static final String NAME_TEA_FLOWER_PEONY="flowertea_peony";
	public static final String NAME_TEA_FLOWER_PANACEA="flowertea_panacea";

	// デバッグ用アイテム
	public static final String NAME_DEBUG_ITEM="debugitem";

	public static Item item_icefoodbowl            = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_ICEFOOD_BOWL);
	public static Item item_choco                 = new ItemFoodPieCakes(1,0.1f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_CHOCO);
	public static Item item_whitechoco            = new ItemFoodPieCakes(1,0.5f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_WHITECHOCO);
	public static Item item_caramel               = new ItemFoodPieCakes(1,0.05f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_CARAMEL);
	public static Item item_pudding               = new ItemFoodPieCakes(2,0.28f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_PUDDING);
	public static Item item_pumpkinpudding        = new ItemFoodPieCakes(2,0.48f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_PUMPKINPUDDING);
	public static Item item_piecepie              = new ItemFoodPieCakes(2,0.2f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_PIECEPIE);
	public static Item item_piecechocopie         = new ItemFoodPieCakes(4,0.2f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_PIECECHOCOPIE);
	public static Item item_piecesaladapie        = new ItemFoodPieCakes(6,0.3f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_PIECESALADAPIE);
	public static Item item_piecemeetpie          = new ItemFoodPieCakes(8,0.4f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_PIECEMEETPIE);
	public static Item item_piecefishpie          = new ItemFoodPieCakes(8,0.4f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_PIECEFISHPIE);
	public static Item item_piecepumpukinpie      = new ItemFoodPieCakes(6,0.3f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_PIECEPUMPUKINPIE);
	public static Item item_piecezombipie         = new ItemFoodPieCakes(2,0.2f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setPotionEffect(new PotionEffect(MobEffects.HUNGER,600,0),100.0F).setRegistryName(NAME_PIECEZOMBIPIE);
	public static Item item_pieceapplepie         = new ItemFoodPieCakes(4,0.2f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_PIECEAPPLEPIE);
	public static Item item_pieceblackpie         = new ItemFoodPieCakes(4,0.2f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_PIECEblackPIE);
	public static Item item_piececaramelpie       = new ItemFoodPieCakes(4,0.2f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_PIECECARAMELPIE);
	public static Item item_eggsandwich           = new ItemFoodPieCakes(6,0.18f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_EGGSANDWICH);
	public static Item item_potatsaladasandwitch  = new ItemFoodPieCakes(6,0.52f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_POTATSALADASANDWITCH);
	public static Item item_hamsandwich           = new ItemFoodPieCakes(8,0.53f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_HAMSANDWICH);
	public static Item item_muttonsandwich        = new ItemFoodPieCakes(8,0.53f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_MUTTONSANDWICH);
	public static Item item_stakesandwich         = new ItemFoodPieCakes(8,0.53f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_STAKESANDWICH);
	public static Item item_chikensandwich        = new ItemFoodPieCakes(8,0.53f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_CHIKENSANDWICH);
	public static Item item_chocosandwich         = new ItemFoodPieCakes(4,0.25f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_CHOCOSANDWICH);
	public static Item item_pumpkinsaladasandwich = new ItemFoodPieCakes(6,0.41f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_PUMPKINSALADASANDWICH);
	public static Item item_potatosalada          = new ItemSalada(8,1.6f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1)).setRegistryName(NAME_POTATOSALADA);
	public static Item item_pumpkinsalada         = new ItemSalada(8,1.11f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1)).setRegistryName(NAME_PUMPKINSALDADA);
	public static Item item_rennet                = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_RENNET);
	public static Item item_butter                = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_BUTTER);
	public static Item item_mold                  = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_MOLD);
	public static Item item_salt                  = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_SALT);
	public static Item item_bluemold              = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_BLUEMOLD);
	public static Item item_row_hallpie           = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_ROW_PIE_HALL);
	public static Item item_row_chocohallpie      = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_ROW_CHOCOPIE_HALL);
	public static Item item_row_saladahallpie     = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_ROW_SALADA_HALL);
	public static Item item_row_meethallpie       = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_ROW_MEETPIE_HALL);
	public static Item item_row_fishhallpie       = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_ROW_FISHPIE_HALL);
	public static Item item_row_pumpkinhallpie    = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_ROW_PUMPKINPIE_HALL);
	public static Item item_row_zombihallpie      = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_ROW_ZOMBIPEI_HALL);
	public static Item item_row_applehallpie      = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_ROW_APPLEPIE_HALL);
	public static Item item_row_blackpie          = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_ROW_BLACK_PIE);
	public static Item item_row_pizza             = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_ROW_PIZZA);
	public static Item item_row_meetpizza         = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_ROW_MEETPIZZA);
	public static Item item_row_fishpizza         = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_ROW_FISHPIZZA);

	public static Item item_sugarmilk             = new ItemBucketMilk(new Item.Properties().group(Mod_DiningFurniture.tabColdFood)).setRegistryName(NAME_SUGARMILK);
	public static Item item_syrupmilk             = new Item(new Item.Properties().group(Mod_DiningFurniture.tabColdFood)).setRegistryName(NAME_SYRUP_MILK);
	public static Item item_ice_mix_vanila        = new ItemIceCreamMix(EnumIceFlavor.ICE_VANILA).setRegistryName(NAME_ICE_MIX_VANILA);
	public static Item item_ice_mix_black         = new ItemIceCreamMix(EnumIceFlavor.ICE_BLACK).setRegistryName(NAME_ICE_MIX_BLACK);
	public static Item item_ice_mix_red           = new ItemIceCreamMix(EnumIceFlavor.ICE_RED).setRegistryName(NAME_ICE_MIX_RED);
	public static Item item_ice_mix_green         = new ItemIceCreamMix(EnumIceFlavor.ICE_GREEN).setRegistryName(NAME_ICE_MIX_GREEN);
	public static Item item_ice_mix_brown         = new ItemIceCreamMix(EnumIceFlavor.ICE_BROWN).setRegistryName(NAME_ICE_MIX_BROWN);
	public static Item item_ice_mix_blue          = new ItemIceCreamMix(EnumIceFlavor.ICE_BLUE).setRegistryName(NAME_ICE_MIX_BLUE);
	public static Item item_ice_mix_purple        = new ItemIceCreamMix(EnumIceFlavor.ICE_PURPLE).setRegistryName(NAME_ICE_MIX_PURPLE);
	public static Item item_ice_mix_cyan          = new ItemIceCreamMix(EnumIceFlavor.ICE_CYAN).setRegistryName(NAME_ICE_MIX_CYAN);
	public static Item item_ice_mix_silver        = new ItemIceCreamMix(EnumIceFlavor.ICE_SILVER).setRegistryName(NAME_ICE_MIX_SILVER);
	public static Item item_ice_mix_gray          = new ItemIceCreamMix(EnumIceFlavor.ICE_GRAY).setRegistryName(NAME_ICE_MIX_GRAY);
	public static Item item_ice_mix_pink          = new ItemIceCreamMix(EnumIceFlavor.ICE_PINK).setRegistryName(NAME_ICE_MIX_PINK);
	public static Item item_ice_mix_lime          = new ItemIceCreamMix(EnumIceFlavor.ICE_LIME).setRegistryName(NAME_ICE_MIX_LIME);
	public static Item item_ice_mix_yellow        = new ItemIceCreamMix(EnumIceFlavor.ICE_YELLOW).setRegistryName(NAME_ICE_MIX_YELLOW);
	public static Item item_ice_mix_light_blue    = new ItemIceCreamMix(EnumIceFlavor.ICE_LIGHT_BLUE).setRegistryName(NAME_ICE_MIX_LIGHT_BLUE);
	public static Item item_ice_mix_magenta       = new ItemIceCreamMix(EnumIceFlavor.ICE_MAGENTA).setRegistryName(NAME_ICE_MIX_MAGENTA);
	public static Item item_ice_mix_orange        = new ItemIceCreamMix(EnumIceFlavor.ICE_ORANGE).setRegistryName(NAME_ICE_MIX_ORANGE);
	public static Item item_ice_mix_white         = new ItemIceCreamMix(EnumIceFlavor.ICE_WHITE).setRegistryName(NAME_ICE_MIX_WHITE);
	public static Item item_ice_mix_apple         = new ItemIceCreamMix(EnumIceFlavor.ICE_APPLE).setRegistryName(NAME_ICE_MIX_APPLE);
	public static Item item_ice_mix_cactus        = new ItemIceCreamMix(EnumIceFlavor.ICE_CACTUS).setRegistryName(NAME_ICE_MIX_CACTUS);
	public static Item item_ice_mix_pumpkin       = new ItemIceCreamMix(EnumIceFlavor.ICE_PUMPKIN).setRegistryName(NAME_ICE_MIX_PUMPKIN);
	public static Item item_ice_mix_potato        = new ItemIceCreamMix(EnumIceFlavor.ICE_POTATO).setRegistryName(NAME_ICE_MIX_POTATO);
	public static Item item_ice_mix_carrot        = new ItemIceCreamMix(EnumIceFlavor.ICE_CARROT).setRegistryName(NAME_ICE_MIX_CARROT);
	public static Item item_ice_mix_melon         = new ItemIceCreamMix(EnumIceFlavor.ICE_MELON).setRegistryName(NAME_ICE_MIX_MELON);
	public static Item item_ice_mix_greentea      = new ItemIceCreamMix(EnumIceFlavor.ICE_GREENTEA).setRegistryName(NAME_ICE_MIX_GREENTEA);

	public static Item item_icecream_vanila       = new ItemIceCream(EnumIceFlavor.ICE_VANILA).setRegistryName(NAME_ICECREAM_VANILA);
	public static Item item_icecream_black        = new ItemIceCream(EnumIceFlavor.ICE_BLACK).setRegistryName(NAME_ICECREAM_BLACK);
	public static Item item_icecream_red          = new ItemIceCream(EnumIceFlavor.ICE_RED).setRegistryName(NAME_ICECREAM_RED);
	public static Item item_icecream_green        = new ItemIceCream(EnumIceFlavor.ICE_GREEN).setRegistryName(NAME_ICECREAM_GREEN);
	public static Item item_icecream_brown        = new ItemIceCream(EnumIceFlavor.ICE_BROWN).setRegistryName(NAME_ICECREAM_BROWN);
	public static Item item_icecream_blue         = new ItemIceCream(EnumIceFlavor.ICE_BLUE).setRegistryName(NAME_ICECREAM_BLUE);
	public static Item item_icecream_purple       = new ItemIceCream(EnumIceFlavor.ICE_PURPLE).setRegistryName(NAME_ICECREAM_PURPLE);
	public static Item item_icecream_cyan         = new ItemIceCream(EnumIceFlavor.ICE_CYAN).setRegistryName(NAME_ICECREAM_CYAN);
	public static Item item_icecream_silver       = new ItemIceCream(EnumIceFlavor.ICE_SILVER).setRegistryName(NAME_ICECREAM_SILVER);
	public static Item item_icecream_gray         = new ItemIceCream(EnumIceFlavor.ICE_GRAY).setRegistryName(NAME_ICECREAM_GRAY);
	public static Item item_icecream_pink         = new ItemIceCream(EnumIceFlavor.ICE_PINK).setRegistryName(NAME_ICECREAM_PINK);
	public static Item item_icecream_lime         = new ItemIceCream(EnumIceFlavor.ICE_LIME).setRegistryName(NAME_ICECREAM_LIME);
	public static Item item_icecream_yellow       = new ItemIceCream(EnumIceFlavor.ICE_YELLOW).setRegistryName(NAME_ICECREAM_YELLOW);
	public static Item item_icecream_light_blue   = new ItemIceCream(EnumIceFlavor.ICE_LIGHT_BLUE).setRegistryName(NAME_ICECREAM_LIGHT_BLUE);
	public static Item item_icecream_magenta      = new ItemIceCream(EnumIceFlavor.ICE_MAGENTA).setRegistryName(NAME_ICECREAM_MAGENTA);
	public static Item item_icecream_orange       = new ItemIceCream(EnumIceFlavor.ICE_ORANGE).setRegistryName(NAME_ICECREAM_ORANGE);
	public static Item item_icecream_white        = new ItemIceCream(EnumIceFlavor.ICE_WHITE).setRegistryName(NAME_ICECREAM_WHITE);
	public static Item item_icecream_apple        = new ItemIceCream(EnumIceFlavor.ICE_APPLE).setRegistryName(NAME_ICECREAM_APPLE);
	public static Item item_icecream_cactus       = new ItemIceCream(EnumIceFlavor.ICE_CACTUS).setRegistryName(NAME_ICECREAM_CACTUS);
	public static Item item_icecream_pumpkin      = new ItemIceCream(EnumIceFlavor.ICE_PUMPKIN).setRegistryName(NAME_ICECREAM_PUMPKIN);
	public static Item item_icecream_potato       = new ItemIceCream(EnumIceFlavor.ICE_POTATO).setRegistryName(NAME_ICECREAM_POTATO);
	public static Item item_icecream_carrot       = new ItemIceCream(EnumIceFlavor.ICE_CARROT).setRegistryName(NAME_ICECREAM_CARROT);
	public static Item item_icecream_melon        = new ItemIceCream(EnumIceFlavor.ICE_MELON).setRegistryName(NAME_ICECREAM_MELON);
	public static Item item_icecream_greentea     = new ItemIceCream(EnumIceFlavor.ICE_GREENTEA).setRegistryName(NAME_ICECREAM_GREENTEA);

	public static Item item_icecream_cookie_vanila     = new ItemIceCream(EnumIceFlavor.ICE_VANILA, true).setRegistryName(NAME_ICECREAM_COOKIE_VANILA);
	public static Item item_icecream_cookie_black      = new ItemIceCream(EnumIceFlavor.ICE_BLACK, true).setRegistryName(NAME_ICECREAM_COOKIE_BLACK);
	public static Item item_icecream_cookie_red        = new ItemIceCream(EnumIceFlavor.ICE_RED, true).setRegistryName(NAME_ICECREAM_COOKIE_RED);
	public static Item item_icecream_cookie_green      = new ItemIceCream(EnumIceFlavor.ICE_GREEN, true).setRegistryName(NAME_ICECREAM_COOKIE_GREEN);
	public static Item item_icecream_cookie_brown      = new ItemIceCream(EnumIceFlavor.ICE_BROWN, true).setRegistryName(NAME_ICECREAM_COOKIE_BROWN);
	public static Item item_icecream_cookie_blue       = new ItemIceCream(EnumIceFlavor.ICE_BLUE, true).setRegistryName(NAME_ICECREAM_COOKIE_BLUE);
	public static Item item_icecream_cookie_purple     = new ItemIceCream(EnumIceFlavor.ICE_PURPLE, true).setRegistryName(NAME_ICECREAM_COOKIE_PURPLE);
	public static Item item_icecream_cookie_cyan       = new ItemIceCream(EnumIceFlavor.ICE_CYAN, true).setRegistryName(NAME_ICECREAM_COOKIE_CYAN);
	public static Item item_icecream_cookie_silver     = new ItemIceCream(EnumIceFlavor.ICE_SILVER, true).setRegistryName(NAME_ICECREAM_COOKIE_SILVER);
	public static Item item_icecream_cookie_gray       = new ItemIceCream(EnumIceFlavor.ICE_GRAY, true).setRegistryName(NAME_ICECREAM_COOKIE_GRAY);
	public static Item item_icecream_cookie_pink       = new ItemIceCream(EnumIceFlavor.ICE_PINK, true).setRegistryName(NAME_ICECREAM_COOKIE_PINK);
	public static Item item_icecream_cookie_lime       = new ItemIceCream(EnumIceFlavor.ICE_LIME, true).setRegistryName(NAME_ICECREAM_COOKIE_LIME);
	public static Item item_icecream_cookie_yellow     = new ItemIceCream(EnumIceFlavor.ICE_YELLOW, true).setRegistryName(NAME_ICECREAM_COOKIE_YELLOW);
	public static Item item_icecream_cookie_light_blue = new ItemIceCream(EnumIceFlavor.ICE_LIGHT_BLUE, true).setRegistryName(NAME_ICECREAM_COOKIE_LIGHT_BLUE);
	public static Item item_icecream_cookie_magenta    = new ItemIceCream(EnumIceFlavor.ICE_MAGENTA, true).setRegistryName(NAME_ICECREAM_COOKIE_MAGENTA);
	public static Item item_icecream_cookie_orange     = new ItemIceCream(EnumIceFlavor.ICE_ORANGE, true).setRegistryName(NAME_ICECREAM_COOKIE_ORANGE);
	public static Item item_icecream_cookie_white      = new ItemIceCream(EnumIceFlavor.ICE_WHITE, true).setRegistryName(NAME_ICECREAM_COOKIE_WHITE);
	public static Item item_icecream_cookie_apple      = new ItemIceCream(EnumIceFlavor.ICE_APPLE, true).setRegistryName(NAME_ICECREAM_COOKIE_APPLE);
	public static Item item_icecream_cookie_cactus     = new ItemIceCream(EnumIceFlavor.ICE_CACTUS, true).setRegistryName(NAME_ICECREAM_COOKIE_CACTUS);
	public static Item item_icecream_cookie_pumpkin    = new ItemIceCream(EnumIceFlavor.ICE_PUMPKIN, true).setRegistryName(NAME_ICECREAM_COOKIE_PUMPKIN);
	public static Item item_icecream_cookie_potato     = new ItemIceCream(EnumIceFlavor.ICE_POTATO, true).setRegistryName(NAME_ICECREAM_COOKIE_POTATO);
	public static Item item_icecream_cookie_carrot     = new ItemIceCream(EnumIceFlavor.ICE_CARROT, true).setRegistryName(NAME_ICECREAM_COOKIE_CARROT);
	public static Item item_icecream_cookie_melon      = new ItemIceCream(EnumIceFlavor.ICE_MELON, true).setRegistryName(NAME_ICECREAM_COOKIE_MELON);
	public static Item item_icecream_cookie_greentea   = new ItemIceCream(EnumIceFlavor.ICE_GREENTEA, true).setRegistryName(NAME_ICECREAM_COOKIE_GREENTEA);

	public static Item item_syrup_sugar                = new ItemSyrup(EnumFlapeSyrup.SYRUP_SUGAR).setRegistryName(NAME_SYRUP_SUGAR);
	public static Item item_syrup_black                = new ItemSyrup(EnumFlapeSyrup.SYRUP_BLACK).setRegistryName(NAME_SYRUP_BLACK);
	public static Item item_syrup_red                  = new ItemSyrup(EnumFlapeSyrup.SYRUP_RED).setRegistryName(NAME_SYRUP_RED);
	public static Item item_syrup_green                = new ItemSyrup(EnumFlapeSyrup.SYRUP_GREEN).setRegistryName(NAME_SYRUP_GREEN);
	public static Item item_syrup_brown                = new ItemSyrup(EnumFlapeSyrup.SYRUP_BROWN).setRegistryName(NAME_SYRUP_BROWN);
	public static Item item_syrup_blue                 = new ItemSyrup(EnumFlapeSyrup.SYRUP_BLUE).setRegistryName(NAME_SYRUP_BLUE);
	public static Item item_syrup_purple               = new ItemSyrup(EnumFlapeSyrup.SYRUP_PURPLE).setRegistryName(NAME_SYRUP_PURPLE);
	public static Item item_syrup_cyan                 = new ItemSyrup(EnumFlapeSyrup.SYRUP_CYAN).setRegistryName(NAME_SYRUP_CYAN);
	public static Item item_syrup_silver               = new ItemSyrup(EnumFlapeSyrup.SYRUP_SILVER).setRegistryName(NAME_SYRUP_SILVER);
	public static Item item_syrup_gray                 = new ItemSyrup(EnumFlapeSyrup.SYRUP_GRAY).setRegistryName(NAME_SYRUP_GRAY);
	public static Item item_syrup_pink                 = new ItemSyrup(EnumFlapeSyrup.SYRUP_PINK).setRegistryName(NAME_SYRUP_PINK);
	public static Item item_syrup_lime                 = new ItemSyrup(EnumFlapeSyrup.SYRUP_LIME).setRegistryName(NAME_SYRUP_LIME);
	public static Item item_syrup_yellow               = new ItemSyrup(EnumFlapeSyrup.SYRUP_YELLOW).setRegistryName(NAME_SYRUP_YELLOW);
	public static Item item_syrup_light_blue           = new ItemSyrup(EnumFlapeSyrup.SYRUP_LIGHT_BLUE).setRegistryName(NAME_SYRUP_LIGHT_BLUE);
	public static Item item_syrup_magenta              = new ItemSyrup(EnumFlapeSyrup.SYRUP_MAGENTA).setRegistryName(NAME_SYRUP_MAGENTA);
	public static Item item_syrup_orange               = new ItemSyrup(EnumFlapeSyrup.SYRUP_ORANGE).setRegistryName(NAME_SYRUP_ORANGE);
	public static Item item_syrup_white                = new ItemSyrup(EnumFlapeSyrup.SYRUP_WHITE).setRegistryName(NAME_SYRUP_WHITE);
	public static Item item_syrup_apple                = new ItemSyrup(EnumFlapeSyrup.SYRUP_APPLE).setRegistryName(NAME_SYRUP_APPLE);
	public static Item item_syrup_cactus               = new ItemSyrup(EnumFlapeSyrup.SYRUP_CACTUS).setRegistryName(NAME_SYRUP_CACTUS);
	public static Item item_syrup_melon                = new ItemSyrup(EnumFlapeSyrup.SYRUP_MELON).setRegistryName(NAME_SYRUP_MELON);
	public static Item item_syrup_pumpkin              = new ItemSyrup(EnumFlapeSyrup.SYRUP_PUMPKIN).setRegistryName(NAME_SYRUP_PUMPKIN);
	public static Item item_syrup_greentea             = new ItemSyrup(EnumFlapeSyrup.SYRUP_GREENTEA).setRegistryName(NAME_SYRUP_GREENTEA);

	public static Item item_crashedice_none                = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_NONE).setRegistryName(NAME_CRASHEDICE_NONE);
	public static Item item_crashedice_sugar               = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_SUGAR).setRegistryName(NAME_CRASHEDICE_SUGAR);
	public static Item item_crashedice_black               = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_BLACK).setRegistryName(NAME_CRASHEDICE_BLACK);
	public static Item item_crashedice_red                 = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_RED).setRegistryName(NAME_CRASHEDICE_RED);
	public static Item item_crashedice_green               = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_GREEN).setRegistryName(NAME_CRASHEDICE_GREEN);
	public static Item item_crashedice_brown               = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_BROWN).setRegistryName(NAME_CRASHEDICE_BROWN);
	public static Item item_crashedice_blue                = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_BLUE).setRegistryName(NAME_CRASHEDICE_BLUE);
	public static Item item_crashedice_purple              = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_PURPLE).setRegistryName(NAME_CRASHEDICE_PURPLE);
	public static Item item_crashedice_cyan                = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_CYAN).setRegistryName(NAME_CRASHEDICE_CYAN);
	public static Item item_crashedice_silver              = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_SILVER).setRegistryName(NAME_CRASHEDICE_SILVER);
	public static Item item_crashedice_gray                = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_GRAY).setRegistryName(NAME_CRASHEDICE_GRAY);
	public static Item item_crashedice_pink                = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_PINK).setRegistryName(NAME_CRASHEDICE_PINK);
	public static Item item_crashedice_lime                = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_LIME).setRegistryName(NAME_CRASHEDICE_LIME);
	public static Item item_crashedice_yellow              = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_YELLOW).setRegistryName(NAME_CRASHEDICE_YELLOW);
	public static Item item_crashedice_light_blue          = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_LIGHT_BLUE).setRegistryName(NAME_CRASHEDICE_LIGHT_BLUE);
	public static Item item_crashedice_magenta             = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_MAGENTA).setRegistryName(NAME_CRASHEDICE_MAGENTA);
	public static Item item_crashedice_orange              = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_ORANGE).setRegistryName(NAME_CRASHEDICE_ORANGE);
	public static Item item_crashedice_white               = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_WHITE).setRegistryName(NAME_CRASHEDICE_WHITE);
	public static Item item_crashedice_apple               = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_APPLE).setRegistryName(NAME_CRASHEDICE_APPLE);
	public static Item item_crashedice_cactus              = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_CACTUS).setRegistryName(NAME_CRASHEDICE_CACTUS);
	public static Item item_crashedice_melon               = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_MELON).setRegistryName(NAME_CRASHEDICE_MELON);
	public static Item item_crashedice_pumpkin             = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_PUMPKIN).setRegistryName(NAME_CRASHEDICE_PUMPKIN);
	public static Item item_crashedice_greentea            = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_GREENTEA).setRegistryName(NAME_CRASHEDICE_GREENTEA);

	public static Item item_crashedice_milk_none                = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_NONE, true).setRegistryName(NAME_CRASHEDICE_MILK_NONE);
	public static Item item_crashedice_milk_sugar               = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_SUGAR, true).setRegistryName(NAME_CRASHEDICE_MILK_SUGAR);
	public static Item item_crashedice_milk_black               = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_BLACK, true).setRegistryName(NAME_CRASHEDICE_MILK_BLACK);
	public static Item item_crashedice_milk_red                 = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_RED, true).setRegistryName(NAME_CRASHEDICE_MILK_RED);
	public static Item item_crashedice_milk_green               = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_GREEN, true).setRegistryName(NAME_CRASHEDICE_MILK_GREEN);
	public static Item item_crashedice_milk_brown               = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_BROWN, true).setRegistryName(NAME_CRASHEDICE_MILK_BROWN);
	public static Item item_crashedice_milk_blue                = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_BLUE, true).setRegistryName(NAME_CRASHEDICE_MILK_BLUE);
	public static Item item_crashedice_milk_purple              = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_PURPLE, true).setRegistryName(NAME_CRASHEDICE_MILK_PURPLE);
	public static Item item_crashedice_milk_cyan                = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_CYAN, true).setRegistryName(NAME_CRASHEDICE_MILK_CYAN);
	public static Item item_crashedice_milk_silver              = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_SILVER, true).setRegistryName(NAME_CRASHEDICE_MILK_SILVER);
	public static Item item_crashedice_milk_gray                = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_GRAY, true).setRegistryName(NAME_CRASHEDICE_MILK_GRAY);
	public static Item item_crashedice_milk_pink                = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_PINK, true).setRegistryName(NAME_CRASHEDICE_MILK_PINK);
	public static Item item_crashedice_milk_lime                = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_LIME, true).setRegistryName(NAME_CRASHEDICE_MILK_LIME);
	public static Item item_crashedice_milk_yellow              = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_YELLOW, true).setRegistryName(NAME_CRASHEDICE_MILK_YELLOW);
	public static Item item_crashedice_milk_light_blue          = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_LIGHT_BLUE, true).setRegistryName(NAME_CRASHEDICE_MILK_LIGHT_BLUE);
	public static Item item_crashedice_milk_magenta             = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_MAGENTA, true).setRegistryName(NAME_CRASHEDICE_MILK_MAGENTA);
	public static Item item_crashedice_milk_orange              = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_ORANGE, true).setRegistryName(NAME_CRASHEDICE_MILK_ORANGE);
	public static Item item_crashedice_milk_white               = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_WHITE, true).setRegistryName(NAME_CRASHEDICE_MILK_WHITE);
	public static Item item_crashedice_milk_apple               = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_APPLE, true).setRegistryName(NAME_CRASHEDICE_MILK_APPLE);
	public static Item item_crashedice_milk_cactus              = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_CACTUS, true).setRegistryName(NAME_CRASHEDICE_MILK_CACTUS);
	public static Item item_crashedice_milk_melon               = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_MELON, true).setRegistryName(NAME_CRASHEDICE_MILK_MELON);
	public static Item item_crashedice_milk_pumpkin             = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_PUMPKIN, true).setRegistryName(NAME_CRASHEDICE_MILK_PUMPKIN);
	public static Item item_crashedice_milk_greentea            = new ItemCrashedIce(EnumFlapeSyrup.SYRUP_GREENTEA, true).setRegistryName(NAME_CRASHEDICE_MILK_GREENTEA);

	public static Item item_sugar_water_none                = new ItemSugarWater(EnumFlapeSyrup.SYRUP_NONE).setRegistryName(NAME_SUGAR_WATER_NONE);
	public static Item item_sugar_water_sugar               = new ItemSugarWater(EnumFlapeSyrup.SYRUP_SUGAR).setRegistryName(NAME_SUGAR_WATER_SUGAR);
	public static Item item_sugar_water_black               = new ItemSugarWater(EnumFlapeSyrup.SYRUP_BLACK).setRegistryName(NAME_SUGAR_WATER_BLACK);
	public static Item item_sugar_water_red                 = new ItemSugarWater(EnumFlapeSyrup.SYRUP_RED).setRegistryName(NAME_SUGAR_WATER_RED);
	public static Item item_sugar_water_green               = new ItemSugarWater(EnumFlapeSyrup.SYRUP_GREEN).setRegistryName(NAME_SUGAR_WATER_GREEN);
	public static Item item_sugar_water_brown               = new ItemSugarWater(EnumFlapeSyrup.SYRUP_BROWN).setRegistryName(NAME_SUGAR_WATER_BROWN);
	public static Item item_sugar_water_blue                = new ItemSugarWater(EnumFlapeSyrup.SYRUP_BLUE).setRegistryName(NAME_SUGAR_WATER_BLUE);
	public static Item item_sugar_water_purple              = new ItemSugarWater(EnumFlapeSyrup.SYRUP_PURPLE).setRegistryName(NAME_SUGAR_WATER_PURPLE);
	public static Item item_sugar_water_cyan                = new ItemSugarWater(EnumFlapeSyrup.SYRUP_CYAN).setRegistryName(NAME_SUGAR_WATER_CYAN);
	public static Item item_sugar_water_silver              = new ItemSugarWater(EnumFlapeSyrup.SYRUP_SILVER).setRegistryName(NAME_SUGAR_WATER_SILVER);
	public static Item item_sugar_water_gray                = new ItemSugarWater(EnumFlapeSyrup.SYRUP_GRAY).setRegistryName(NAME_SUGAR_WATER_GRAY);
	public static Item item_sugar_water_pink                = new ItemSugarWater(EnumFlapeSyrup.SYRUP_PINK).setRegistryName(NAME_SUGAR_WATER_PINK);
	public static Item item_sugar_water_lime                = new ItemSugarWater(EnumFlapeSyrup.SYRUP_LIME).setRegistryName(NAME_SUGAR_WATER_LIME);
	public static Item item_sugar_water_yellow              = new ItemSugarWater(EnumFlapeSyrup.SYRUP_YELLOW).setRegistryName(NAME_SUGAR_WATER_YELLOW);
	public static Item item_sugar_water_light_blue          = new ItemSugarWater(EnumFlapeSyrup.SYRUP_LIGHT_BLUE).setRegistryName(NAME_SUGAR_WATER_LIGHT_BLUE);
	public static Item item_sugar_water_magenta             = new ItemSugarWater(EnumFlapeSyrup.SYRUP_MAGENTA).setRegistryName(NAME_SUGAR_WATER_MAGENTA);
	public static Item item_sugar_water_orange              = new ItemSugarWater(EnumFlapeSyrup.SYRUP_ORANGE).setRegistryName(NAME_SUGAR_WATER_ORANGE);
	public static Item item_sugar_water_white               = new ItemSugarWater(EnumFlapeSyrup.SYRUP_WHITE).setRegistryName(NAME_SUGAR_WATER_WHITE);
	public static Item item_sugar_water_apple               = new ItemSugarWater(EnumFlapeSyrup.SYRUP_APPLE).setRegistryName(NAME_SUGAR_WATER_APPLE);
	public static Item item_sugar_water_cactus              = new ItemSugarWater(EnumFlapeSyrup.SYRUP_CACTUS).setRegistryName(NAME_SUGAR_WATER_CACTUS);
	public static Item item_sugar_water_melon               = new ItemSugarWater(EnumFlapeSyrup.SYRUP_MELON).setRegistryName(NAME_SUGAR_WATER_MELON);
	public static Item item_sugar_water_pumpkin             = new ItemSugarWater(EnumFlapeSyrup.SYRUP_PUMPKIN).setRegistryName(NAME_SUGAR_WATER_PUMPKIN);
	public static Item item_sugar_water_greentea            = new ItemSugarWater(EnumFlapeSyrup.SYRUP_GREENTEA).setRegistryName(NAME_SUGAR_WATER_GREENTEA);

	public static Item item_icecandy_none                = new ItemIceCandy(EnumFlapeSyrup.SYRUP_NONE).setRegistryName(NAME_ICECANDY_NONE);
	public static Item item_icecandy_sugar               = new ItemIceCandy(EnumFlapeSyrup.SYRUP_SUGAR).setRegistryName(NAME_ICECANDY_SUGAR);
	public static Item item_icecandy_black               = new ItemIceCandy(EnumFlapeSyrup.SYRUP_BLACK).setRegistryName(NAME_ICECANDY_BLACK);
	public static Item item_icecandy_red                 = new ItemIceCandy(EnumFlapeSyrup.SYRUP_RED).setRegistryName(NAME_ICECANDY_RED);
	public static Item item_icecandy_green               = new ItemIceCandy(EnumFlapeSyrup.SYRUP_GREEN).setRegistryName(NAME_ICECANDY_GREEN);
	public static Item item_icecandy_brown               = new ItemIceCandy(EnumFlapeSyrup.SYRUP_BROWN).setRegistryName(NAME_ICECANDY_BROWN);
	public static Item item_icecandy_blue                = new ItemIceCandy(EnumFlapeSyrup.SYRUP_BLUE).setRegistryName(NAME_ICECANDY_BLUE);
	public static Item item_icecandy_purple              = new ItemIceCandy(EnumFlapeSyrup.SYRUP_PURPLE).setRegistryName(NAME_ICECANDY_PURPLE);
	public static Item item_icecandy_cyan                = new ItemIceCandy(EnumFlapeSyrup.SYRUP_CYAN).setRegistryName(NAME_ICECANDY_CYAN);
	public static Item item_icecandy_silver              = new ItemIceCandy(EnumFlapeSyrup.SYRUP_SILVER).setRegistryName(NAME_ICECANDY_SILVER);
	public static Item item_icecandy_gray                = new ItemIceCandy(EnumFlapeSyrup.SYRUP_GRAY).setRegistryName(NAME_ICECANDY_GRAY);
	public static Item item_icecandy_pink                = new ItemIceCandy(EnumFlapeSyrup.SYRUP_PINK).setRegistryName(NAME_ICECANDY_PINK);
	public static Item item_icecandy_lime                = new ItemIceCandy(EnumFlapeSyrup.SYRUP_LIME).setRegistryName(NAME_ICECANDY_LIME);
	public static Item item_icecandy_yellow              = new ItemIceCandy(EnumFlapeSyrup.SYRUP_YELLOW).setRegistryName(NAME_ICECANDY_YELLOW);
	public static Item item_icecandy_light_blue          = new ItemIceCandy(EnumFlapeSyrup.SYRUP_LIGHT_BLUE).setRegistryName(NAME_ICECANDY_LIGHT_BLUE);
	public static Item item_icecandy_magenta             = new ItemIceCandy(EnumFlapeSyrup.SYRUP_MAGENTA).setRegistryName(NAME_ICECANDY_MAGENTA);
	public static Item item_icecandy_orange              = new ItemIceCandy(EnumFlapeSyrup.SYRUP_ORANGE).setRegistryName(NAME_ICECANDY_ORANGE);
	public static Item item_icecandy_white               = new ItemIceCandy(EnumFlapeSyrup.SYRUP_WHITE).setRegistryName(NAME_ICECANDY_WHITE);
	public static Item item_icecandy_apple               = new ItemIceCandy(EnumFlapeSyrup.SYRUP_APPLE).setRegistryName(NAME_ICECANDY_APPLE);
	public static Item item_icecandy_cactus              = new ItemIceCandy(EnumFlapeSyrup.SYRUP_CACTUS).setRegistryName(NAME_ICECANDY_CACTUS);
	public static Item item_icecandy_melon               = new ItemIceCandy(EnumFlapeSyrup.SYRUP_MELON).setRegistryName(NAME_ICECANDY_MELON);
	public static Item item_icecandy_pumpkin             = new ItemIceCandy(EnumFlapeSyrup.SYRUP_PUMPKIN).setRegistryName(NAME_ICECANDY_PUMPKIN);
	public static Item item_icecandy_greentea            = new ItemIceCandy(EnumFlapeSyrup.SYRUP_GREENTEA).setRegistryName(NAME_ICECANDY_GREENTEA);

	public static Item item_flour                 = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_FLOUR);
	public static Item item_udon                  = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_UDON);
	public static Item item_pasta                 = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_PASTA);
	public static Item item_ramen                 = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_LAMEN);
	public static Item item_meetpasta             = new ItemNoodle(10,1.58f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1)).setRegistryName(NAME_MEET_PASTA);
	public static Item item_fishpasta             = new ItemNoodle(10,0.6f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1)).setRegistryName(NAME_FISH_PASTA);
	public static Item item_blackpasta            = new ItemNoodle(10,0.3f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1)).setRegistryName(NAME_BLACK_PASTA);
	public static Item item_zaruudon              = new ItemNoodle(10,0.3f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1)).setRegistryName(NAME_ZARUUDON);
	public static Item item_kakeudon              = new ItemNoodle(10,0.3f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1)).setRegistryName(NAME_KAKEUDON);
	public static Item item_tsukimiuudon          = new ItemNoodle(10,0.31f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1)).setRegistryName(NAME_TUKIMIUDON);
	public static Item item_nikuudon              = new ItemNoodle(10,0.94f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1)).setRegistryName(NAME_NIKUUDON);
	public static Item item_meetramen             = new ItemNoodle(10,0.94f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1)).setRegistryName(NAME_MEETRAMEN);
	public static Item item_fishramen             = new ItemNoodle(10,0.6f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes).maxStackSize(1)).setRegistryName(NAME_FISHRAMEN);
	public static Item item_tsukimiramen          = new ItemNoodle(10,0.31f,false, new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_EGGRAMEN);
	public static Item item_millbeef              = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_MEETMILL_BEEF);
	public static Item item_millpoke              = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_MEETMILL_POKE);
	public static Item item_millchikin            = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_MEETMILL_CHIKIN);
	public static Item item_millmutton            = new Item(new Item.Properties().group(Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_MEETMILL_MUTTON);

	public static Item item_flowerdust_dandelion       = new ItemFlowerDust(EnumFlowerHalb.DANDELION, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_DUST_FLOWER_DANDELION);
	public static Item item_flowerdust_popy            = new ItemFlowerDust(EnumFlowerHalb.POPY, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_DUST_FLOWER_POPY);
	public static Item item_flowerdust_orchid          = new ItemFlowerDust(EnumFlowerHalb.ORCHID, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_DUST_FLOWER_ORCHID);
	public static Item item_flowerdust_allium          = new ItemFlowerDust(EnumFlowerHalb.ALLIUM, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_DUST_FLOWER_ALLIUM);
	public static Item item_flowerdust_azurebluet      = new ItemFlowerDust(EnumFlowerHalb.AZUREBLUET, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_DUST_FLOWER_AZUREBLUET);
	public static Item item_flowerdust_tulip           = new ItemFlowerDust(EnumFlowerHalb.TULIP, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_DUST_FLOWER_TULIP);
	public static Item item_flowerdust_oxeydaisy       = new ItemFlowerDust(EnumFlowerHalb.OXEYDAISY, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_DUST_FLOWER_OXEYDAISY);
	public static Item item_flowerdust_sunflower       = new ItemFlowerDust(EnumFlowerHalb.SUNFLOWER, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_DUST_FLOWER_SUNFLOWER);
	public static Item item_flowerdust_lilac           = new ItemFlowerDust(EnumFlowerHalb.LILAC, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_DUST_FLOWER_LILAC);
	public static Item item_flowerdust_rose            = new ItemFlowerDust(EnumFlowerHalb.ROSE, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_DUST_FLOWER_ROSE);
	public static Item item_flowerdust_peony           = new ItemFlowerDust(EnumFlowerHalb.PEONY, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_DUST_FLOWER_PEONY);
	public static Item item_flowerdust_panacea         = new ItemFlowerDust(EnumFlowerHalb.PANACEA, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_DUST_FLOWER_PANACEA);

	public static Item item_flowertea_dandelion        = new ItemFlowerTea(EnumFlowerHalb.DANDELION, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_TEA_FLOWER_DANDELION);
	public static Item item_flowertea_popy             = new ItemFlowerTea(EnumFlowerHalb.POPY, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_TEA_FLOWER_POPY);
	public static Item item_flowertea_orchid           = new ItemFlowerTea(EnumFlowerHalb.ORCHID, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_TEA_FLOWER_ORCHID);
	public static Item item_flowertea_allium           = new ItemFlowerTea(EnumFlowerHalb.ALLIUM, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_TEA_FLOWER_ALLIUM);
	public static Item item_flowertea_azurebluet       = new ItemFlowerTea(EnumFlowerHalb.AZUREBLUET, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_TEA_FLOWER_AZUREBLUET);
	public static Item item_flowertea_tulip            = new ItemFlowerTea(EnumFlowerHalb.TULIP, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_TEA_FLOWER_TULIP);
	public static Item item_flowertea_oxeydaisy        = new ItemFlowerTea(EnumFlowerHalb.OXEYDAISY, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_TEA_FLOWER_OXEYDAISY);
	public static Item item_flowertea_sunflower        = new ItemFlowerTea(EnumFlowerHalb.SUNFLOWER, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_TEA_FLOWER_SUNFLOWER);
	public static Item item_flowertea_lilac            = new ItemFlowerTea(EnumFlowerHalb.LILAC, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_TEA_FLOWER_LILAC);
	public static Item item_flowertea_rose             = new ItemFlowerTea(EnumFlowerHalb.ROSE, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_TEA_FLOWER_ROSE);
	public static Item item_flowertea_peony            = new ItemFlowerTea(EnumFlowerHalb.PEONY, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_TEA_FLOWER_PEONY);
	public static Item item_flowertea_panacea          = new ItemFlowerTea(EnumFlowerHalb.PANACEA, new Item.Properties().group( Mod_DiningFurniture.tabPieCakes)).setRegistryName(NAME_TEA_FLOWER_PANACEA);

	public static Item item_debug                      = new ItemDebugFood(-20,-20,false).setRegistryName(NAME_DEBUG_ITEM);


	public static Map<String,Item> itemMap;
	public static void init(){
        itemMap = new HashMap<String,Item>();
        itemMap.put(NAME_ICEFOOD_BOWL,item_icefoodbowl);
        itemMap.put(NAME_CHOCO,item_choco);
        itemMap.put(NAME_WHITECHOCO,item_whitechoco);
        itemMap.put(NAME_CARAMEL,item_caramel);
        itemMap.put(NAME_PUDDING,item_pudding);
        itemMap.put(NAME_PUMPKINPUDDING,item_pumpkinpudding);
        itemMap.put(NAME_PIECEPIE,item_piecepie);
        itemMap.put(NAME_PIECECHOCOPIE,item_piecechocopie);
        itemMap.put(NAME_PIECESALADAPIE,item_piecesaladapie);
        itemMap.put(NAME_PIECEMEETPIE,item_piecemeetpie);
        itemMap.put(NAME_PIECEFISHPIE,item_piecefishpie);
        itemMap.put(NAME_PIECEPUMPUKINPIE,item_piecepumpukinpie);
        itemMap.put(NAME_PIECEZOMBIPIE,item_piecezombipie);
        itemMap.put(NAME_PIECEAPPLEPIE,item_pieceapplepie);
        itemMap.put(NAME_PIECEblackPIE,item_pieceblackpie);
        itemMap.put(NAME_PIECECARAMELPIE,item_piececaramelpie);
        itemMap.put(NAME_EGGSANDWICH,item_eggsandwich);
        itemMap.put(NAME_POTATSALADASANDWITCH,item_potatsaladasandwitch);
        itemMap.put(NAME_HAMSANDWICH,item_hamsandwich);
        itemMap.put(NAME_MUTTONSANDWICH,item_muttonsandwich);
        itemMap.put(NAME_STAKESANDWICH,item_stakesandwich);
        itemMap.put(NAME_CHIKENSANDWICH,item_chikensandwich);
        itemMap.put(NAME_CHOCOSANDWICH,item_chocosandwich);
        itemMap.put(NAME_PUMPKINSALADASANDWICH,item_pumpkinsaladasandwich);
        itemMap.put(NAME_POTATOSALADA,item_potatosalada);
        itemMap.put(NAME_PUMPKINSALDADA,item_pumpkinsalada);
        itemMap.put(NAME_RENNET,item_rennet);
        itemMap.put(NAME_BUTTER,item_butter);
        itemMap.put(NAME_MOLD,item_mold);
        itemMap.put(NAME_SALT,item_salt);
        itemMap.put(NAME_BLUEMOLD,item_bluemold);
        itemMap.put(NAME_ROW_PIE_HALL,item_row_hallpie);
        itemMap.put(NAME_ROW_CHOCOPIE_HALL,item_row_chocohallpie);
        itemMap.put(NAME_ROW_SALADA_HALL,item_row_saladahallpie);
        itemMap.put(NAME_ROW_MEETPIE_HALL,item_row_meethallpie);
        itemMap.put(NAME_ROW_FISHPIE_HALL,item_row_fishhallpie);
        itemMap.put(NAME_ROW_PUMPKINPIE_HALL,item_row_pumpkinhallpie);
        itemMap.put(NAME_ROW_ZOMBIPEI_HALL,item_row_zombihallpie);
        itemMap.put(NAME_ROW_APPLEPIE_HALL,item_row_applehallpie);
        itemMap.put(NAME_ROW_BLACK_PIE,item_row_blackpie);
        itemMap.put(NAME_ROW_PIZZA,item_row_pizza);
        itemMap.put(NAME_ROW_MEETPIZZA,item_row_meetpizza);
        itemMap.put(NAME_ROW_FISHPIZZA,item_row_fishpizza);

        itemMap.put(NAME_SUGARMILK,item_sugarmilk);
        itemMap.put(NAME_SYRUP_MILK,item_syrupmilk);
        itemMap.put(NAME_ICE_MIX_VANILA,item_ice_mix_vanila);
        itemMap.put(NAME_ICE_MIX_BLACK,item_ice_mix_black);
        itemMap.put(NAME_ICE_MIX_RED,item_ice_mix_red);
        itemMap.put(NAME_ICE_MIX_GREEN,item_ice_mix_green);
        itemMap.put(NAME_ICE_MIX_BROWN,item_ice_mix_brown);
        itemMap.put(NAME_ICE_MIX_BLUE,item_ice_mix_blue);
        itemMap.put(NAME_ICE_MIX_PURPLE,item_ice_mix_purple);
        itemMap.put(NAME_ICE_MIX_CYAN,item_ice_mix_cyan);
        itemMap.put(NAME_ICE_MIX_SILVER,item_ice_mix_silver);
        itemMap.put(NAME_ICE_MIX_GRAY,item_ice_mix_gray);
        itemMap.put(NAME_ICE_MIX_PINK,item_ice_mix_pink);
        itemMap.put(NAME_ICE_MIX_LIME,item_ice_mix_lime);
        itemMap.put(NAME_ICE_MIX_YELLOW,item_ice_mix_yellow);
        itemMap.put(NAME_ICE_MIX_LIGHT_BLUE,item_ice_mix_light_blue);
        itemMap.put(NAME_ICE_MIX_MAGENTA,item_ice_mix_magenta);
        itemMap.put(NAME_ICE_MIX_ORANGE,item_ice_mix_orange);
        itemMap.put(NAME_ICE_MIX_WHITE,item_ice_mix_white);
        itemMap.put(NAME_ICE_MIX_APPLE,item_ice_mix_apple);
        itemMap.put(NAME_ICE_MIX_CACTUS,item_ice_mix_cactus);
        itemMap.put(NAME_ICE_MIX_PUMPKIN,item_ice_mix_pumpkin);
        itemMap.put(NAME_ICE_MIX_POTATO,item_ice_mix_potato);
        itemMap.put(NAME_ICE_MIX_CARROT,item_ice_mix_carrot);
        itemMap.put(NAME_ICE_MIX_MELON,item_ice_mix_melon);
        itemMap.put(NAME_ICE_MIX_GREENTEA,item_ice_mix_greentea);

        itemMap.put(NAME_ICECREAM_VANILA,item_icecream_vanila);
        itemMap.put(NAME_ICECREAM_BLACK,item_icecream_black);
        itemMap.put(NAME_ICECREAM_RED,item_icecream_red);
        itemMap.put(NAME_ICECREAM_GREEN,item_icecream_green);
        itemMap.put(NAME_ICECREAM_BROWN,item_icecream_brown);
        itemMap.put(NAME_ICECREAM_BLUE,item_icecream_blue);
        itemMap.put(NAME_ICECREAM_PURPLE,item_icecream_purple);
        itemMap.put(NAME_ICECREAM_CYAN,item_icecream_cyan);
        itemMap.put(NAME_ICECREAM_SILVER,item_icecream_silver);
        itemMap.put(NAME_ICECREAM_GRAY,item_icecream_gray);
        itemMap.put(NAME_ICECREAM_PINK,item_icecream_pink);
        itemMap.put(NAME_ICECREAM_LIME,item_icecream_lime);
        itemMap.put(NAME_ICECREAM_YELLOW,item_icecream_yellow);
        itemMap.put(NAME_ICECREAM_LIGHT_BLUE,item_icecream_light_blue);
        itemMap.put(NAME_ICECREAM_MAGENTA,item_icecream_magenta);
        itemMap.put(NAME_ICECREAM_ORANGE,item_icecream_orange);
        itemMap.put(NAME_ICECREAM_WHITE,item_icecream_white);
        itemMap.put(NAME_ICECREAM_APPLE,item_icecream_apple);
        itemMap.put(NAME_ICECREAM_CACTUS,item_icecream_cactus);
        itemMap.put(NAME_ICECREAM_PUMPKIN,item_icecream_pumpkin);
        itemMap.put(NAME_ICECREAM_POTATO,item_icecream_potato);
        itemMap.put(NAME_ICECREAM_CARROT,item_icecream_carrot);
        itemMap.put(NAME_ICECREAM_MELON,item_icecream_melon);
        itemMap.put(NAME_ICECREAM_GREENTEA,item_icecream_greentea);

        itemMap.put(NAME_ICECREAM_COOKIE_VANILA,item_icecream_cookie_vanila);
        itemMap.put(NAME_ICECREAM_COOKIE_BLACK,item_icecream_cookie_black);
        itemMap.put(NAME_ICECREAM_COOKIE_RED,item_icecream_cookie_red);
        itemMap.put(NAME_ICECREAM_COOKIE_GREEN,item_icecream_cookie_green);
        itemMap.put(NAME_ICECREAM_COOKIE_BROWN,item_icecream_cookie_brown);
        itemMap.put(NAME_ICECREAM_COOKIE_BLUE,item_icecream_cookie_blue);
        itemMap.put(NAME_ICECREAM_COOKIE_PURPLE,item_icecream_cookie_purple);
        itemMap.put(NAME_ICECREAM_COOKIE_CYAN,item_icecream_cookie_cyan);
        itemMap.put(NAME_ICECREAM_COOKIE_SILVER,item_icecream_cookie_silver);
        itemMap.put(NAME_ICECREAM_COOKIE_GRAY,item_icecream_cookie_gray);
        itemMap.put(NAME_ICECREAM_COOKIE_PINK,item_icecream_cookie_pink);
        itemMap.put(NAME_ICECREAM_COOKIE_LIME,item_icecream_cookie_lime);
        itemMap.put(NAME_ICECREAM_COOKIE_YELLOW,item_icecream_cookie_yellow);
        itemMap.put(NAME_ICECREAM_COOKIE_LIGHT_BLUE,item_icecream_cookie_light_blue);
        itemMap.put(NAME_ICECREAM_COOKIE_MAGENTA,item_icecream_cookie_magenta);
        itemMap.put(NAME_ICECREAM_COOKIE_ORANGE,item_icecream_cookie_orange);
        itemMap.put(NAME_ICECREAM_COOKIE_WHITE,item_icecream_cookie_white);
        itemMap.put(NAME_ICECREAM_COOKIE_APPLE,item_icecream_cookie_apple);
        itemMap.put(NAME_ICECREAM_COOKIE_CACTUS,item_icecream_cookie_cactus);
        itemMap.put(NAME_ICECREAM_COOKIE_PUMPKIN,item_icecream_cookie_pumpkin);
        itemMap.put(NAME_ICECREAM_COOKIE_POTATO,item_icecream_cookie_potato);
        itemMap.put(NAME_ICECREAM_COOKIE_CARROT,item_icecream_cookie_carrot);
        itemMap.put(NAME_ICECREAM_COOKIE_MELON,item_icecream_cookie_melon);
        itemMap.put(NAME_ICECREAM_COOKIE_GREENTEA,item_icecream_cookie_greentea);

        itemMap.put(NAME_SYRUP_SUGAR,item_syrup_sugar);
        itemMap.put(NAME_SYRUP_BLACK,item_syrup_black);
        itemMap.put(NAME_SYRUP_RED,item_syrup_red);
        itemMap.put(NAME_SYRUP_GREEN,item_syrup_green);
        itemMap.put(NAME_SYRUP_BROWN,item_syrup_brown);
        itemMap.put(NAME_SYRUP_BLUE,item_syrup_blue);
        itemMap.put(NAME_SYRUP_PURPLE,item_syrup_purple);
        itemMap.put(NAME_SYRUP_CYAN,item_syrup_cyan);
        itemMap.put(NAME_SYRUP_SILVER,item_syrup_silver);
        itemMap.put(NAME_SYRUP_GRAY,item_syrup_gray);
        itemMap.put(NAME_SYRUP_PINK,item_syrup_pink);
        itemMap.put(NAME_SYRUP_LIME,item_syrup_lime);
        itemMap.put(NAME_SYRUP_YELLOW,item_syrup_yellow);
        itemMap.put(NAME_SYRUP_LIGHT_BLUE,item_syrup_light_blue);
        itemMap.put(NAME_SYRUP_MAGENTA,item_syrup_magenta);
        itemMap.put(NAME_SYRUP_ORANGE,item_syrup_orange);
        itemMap.put(NAME_SYRUP_WHITE,item_syrup_white);
        itemMap.put(NAME_SYRUP_APPLE,item_syrup_apple);
        itemMap.put(NAME_SYRUP_CACTUS,item_syrup_cactus);
        itemMap.put(NAME_SYRUP_MELON,item_syrup_melon);
        itemMap.put(NAME_SYRUP_PUMPKIN,item_syrup_pumpkin);
        itemMap.put(NAME_SYRUP_GREENTEA,item_syrup_greentea);

        itemMap.put(NAME_CRASHEDICE_NONE,item_crashedice_none);
        itemMap.put(NAME_CRASHEDICE_SUGAR,item_crashedice_sugar);
        itemMap.put(NAME_CRASHEDICE_BLACK,item_crashedice_black);
        itemMap.put(NAME_CRASHEDICE_RED,item_crashedice_red);
        itemMap.put(NAME_CRASHEDICE_GREEN,item_crashedice_green);
        itemMap.put(NAME_CRASHEDICE_BROWN,item_crashedice_brown);
        itemMap.put(NAME_CRASHEDICE_BLUE,item_crashedice_blue);
        itemMap.put(NAME_CRASHEDICE_PURPLE,item_crashedice_purple);
        itemMap.put(NAME_CRASHEDICE_CYAN,item_crashedice_cyan);
        itemMap.put(NAME_CRASHEDICE_SILVER,item_crashedice_silver);
        itemMap.put(NAME_CRASHEDICE_GRAY,item_crashedice_gray);
        itemMap.put(NAME_CRASHEDICE_PINK,item_crashedice_pink);
        itemMap.put(NAME_CRASHEDICE_LIME,item_crashedice_lime);
        itemMap.put(NAME_CRASHEDICE_YELLOW,item_crashedice_yellow);
        itemMap.put(NAME_CRASHEDICE_LIGHT_BLUE,item_crashedice_light_blue);
        itemMap.put(NAME_CRASHEDICE_MAGENTA,item_crashedice_magenta);
        itemMap.put(NAME_CRASHEDICE_ORANGE,item_crashedice_orange);
        itemMap.put(NAME_CRASHEDICE_WHITE,item_crashedice_white);
        itemMap.put(NAME_CRASHEDICE_APPLE,item_crashedice_apple);
        itemMap.put(NAME_CRASHEDICE_CACTUS,item_crashedice_cactus);
        itemMap.put(NAME_CRASHEDICE_MELON,item_crashedice_melon);
        itemMap.put(NAME_CRASHEDICE_PUMPKIN,item_crashedice_pumpkin);
        itemMap.put(NAME_CRASHEDICE_GREENTEA,item_crashedice_greentea);

        itemMap.put(NAME_CRASHEDICE_MILK_NONE,item_crashedice_milk_none);
        itemMap.put(NAME_CRASHEDICE_MILK_SUGAR,item_crashedice_milk_sugar);
        itemMap.put(NAME_CRASHEDICE_MILK_BLACK,item_crashedice_milk_black);
        itemMap.put(NAME_CRASHEDICE_MILK_RED,item_crashedice_milk_red);
        itemMap.put(NAME_CRASHEDICE_MILK_GREEN,item_crashedice_milk_green);
        itemMap.put(NAME_CRASHEDICE_MILK_BROWN,item_crashedice_milk_brown);
        itemMap.put(NAME_CRASHEDICE_MILK_BLUE,item_crashedice_milk_blue);
        itemMap.put(NAME_CRASHEDICE_MILK_PURPLE,item_crashedice_milk_purple);
        itemMap.put(NAME_CRASHEDICE_MILK_CYAN,item_crashedice_milk_cyan);
        itemMap.put(NAME_CRASHEDICE_MILK_SILVER,item_crashedice_milk_silver);
        itemMap.put(NAME_CRASHEDICE_MILK_GRAY,item_crashedice_milk_gray);
        itemMap.put(NAME_CRASHEDICE_MILK_PINK,item_crashedice_milk_pink);
        itemMap.put(NAME_CRASHEDICE_MILK_LIME,item_crashedice_milk_lime);
        itemMap.put(NAME_CRASHEDICE_MILK_YELLOW,item_crashedice_milk_yellow);
        itemMap.put(NAME_CRASHEDICE_MILK_LIGHT_BLUE,item_crashedice_milk_light_blue);
        itemMap.put(NAME_CRASHEDICE_MILK_MAGENTA,item_crashedice_milk_magenta);
        itemMap.put(NAME_CRASHEDICE_MILK_ORANGE,item_crashedice_milk_orange);
        itemMap.put(NAME_CRASHEDICE_MILK_WHITE,item_crashedice_milk_white);
        itemMap.put(NAME_CRASHEDICE_MILK_APPLE,item_crashedice_milk_apple);
        itemMap.put(NAME_CRASHEDICE_MILK_CACTUS,item_crashedice_milk_cactus);
        itemMap.put(NAME_CRASHEDICE_MILK_MELON,item_crashedice_milk_melon);
        itemMap.put(NAME_CRASHEDICE_MILK_PUMPKIN,item_crashedice_milk_pumpkin);
        itemMap.put(NAME_CRASHEDICE_MILK_GREENTEA,item_crashedice_milk_greentea);

        itemMap.put(NAME_SUGAR_WATER_NONE,item_sugar_water_none);
        itemMap.put(NAME_SUGAR_WATER_SUGAR,item_sugar_water_sugar);
        itemMap.put(NAME_SUGAR_WATER_BLACK,item_sugar_water_black);
        itemMap.put(NAME_SUGAR_WATER_RED,item_sugar_water_red);
        itemMap.put(NAME_SUGAR_WATER_GREEN,item_sugar_water_green);
        itemMap.put(NAME_SUGAR_WATER_BROWN,item_sugar_water_brown);
        itemMap.put(NAME_SUGAR_WATER_BLUE,item_sugar_water_blue);
        itemMap.put(NAME_SUGAR_WATER_PURPLE,item_sugar_water_purple);
        itemMap.put(NAME_SUGAR_WATER_CYAN,item_sugar_water_cyan);
        itemMap.put(NAME_SUGAR_WATER_SILVER,item_sugar_water_silver);
        itemMap.put(NAME_SUGAR_WATER_GRAY,item_sugar_water_gray);
        itemMap.put(NAME_SUGAR_WATER_PINK,item_sugar_water_pink);
        itemMap.put(NAME_SUGAR_WATER_LIME,item_sugar_water_lime);
        itemMap.put(NAME_SUGAR_WATER_YELLOW,item_sugar_water_yellow);
        itemMap.put(NAME_SUGAR_WATER_LIGHT_BLUE,item_sugar_water_light_blue);
        itemMap.put(NAME_SUGAR_WATER_MAGENTA,item_sugar_water_magenta);
        itemMap.put(NAME_SUGAR_WATER_ORANGE,item_sugar_water_orange);
        itemMap.put(NAME_SUGAR_WATER_WHITE,item_sugar_water_white);
        itemMap.put(NAME_SUGAR_WATER_APPLE,item_sugar_water_apple);
        itemMap.put(NAME_SUGAR_WATER_CACTUS,item_sugar_water_cactus);
        itemMap.put(NAME_SUGAR_WATER_MELON,item_sugar_water_melon);
        itemMap.put(NAME_SUGAR_WATER_PUMPKIN,item_sugar_water_pumpkin);
        itemMap.put(NAME_SUGAR_WATER_GREENTEA,item_sugar_water_greentea);

        itemMap.put(NAME_ICECANDY_NONE,item_icecandy_none);
        itemMap.put(NAME_ICECANDY_SUGAR,item_icecandy_sugar);
        itemMap.put(NAME_ICECANDY_BLACK,item_icecandy_black);
        itemMap.put(NAME_ICECANDY_RED,item_icecandy_red);
        itemMap.put(NAME_ICECANDY_GREEN,item_icecandy_green);
        itemMap.put(NAME_ICECANDY_BROWN,item_icecandy_brown);
        itemMap.put(NAME_ICECANDY_BLUE,item_icecandy_blue);
        itemMap.put(NAME_ICECANDY_PURPLE,item_icecandy_purple);
        itemMap.put(NAME_ICECANDY_CYAN,item_icecandy_cyan);
        itemMap.put(NAME_ICECANDY_SILVER,item_icecandy_silver);
        itemMap.put(NAME_ICECANDY_GRAY,item_icecandy_gray);
        itemMap.put(NAME_ICECANDY_PINK,item_icecandy_pink);
        itemMap.put(NAME_ICECANDY_LIME,item_icecandy_lime);
        itemMap.put(NAME_ICECANDY_YELLOW,item_icecandy_yellow);
        itemMap.put(NAME_ICECANDY_LIGHT_BLUE,item_icecandy_light_blue);
        itemMap.put(NAME_ICECANDY_MAGENTA,item_icecandy_magenta);
        itemMap.put(NAME_ICECANDY_ORANGE,item_icecandy_orange);
        itemMap.put(NAME_ICECANDY_WHITE,item_icecandy_white);
        itemMap.put(NAME_ICECANDY_APPLE,item_icecandy_apple);
        itemMap.put(NAME_ICECANDY_CACTUS,item_icecandy_cactus);
        itemMap.put(NAME_ICECANDY_MELON,item_icecandy_melon);
        itemMap.put(NAME_ICECANDY_PUMPKIN,item_icecandy_pumpkin);
        itemMap.put(NAME_ICECANDY_GREENTEA,item_icecandy_greentea);

        itemMap.put(NAME_FLOUR,item_flour);
        itemMap.put(NAME_UDON,item_udon);
        itemMap.put(NAME_PASTA,item_pasta);
        itemMap.put(NAME_LAMEN,item_ramen);
        itemMap.put(NAME_MEET_PASTA,item_meetpasta);
        itemMap.put(NAME_FISH_PASTA,item_fishpasta);
        itemMap.put(NAME_BLACK_PASTA,item_blackpasta);
        itemMap.put(NAME_ZARUUDON,item_zaruudon);
        itemMap.put(NAME_KAKEUDON,item_kakeudon);
        itemMap.put(NAME_TUKIMIUDON,item_tsukimiuudon);
        itemMap.put(NAME_NIKUUDON,item_nikuudon);
        itemMap.put(NAME_MEETRAMEN,item_meetramen);
        itemMap.put(NAME_FISHRAMEN,item_fishramen);
        itemMap.put(NAME_EGGRAMEN,item_tsukimiramen);
        itemMap.put(NAME_MEETMILL_BEEF,item_millbeef);
        itemMap.put(NAME_MEETMILL_POKE,item_millpoke);
        itemMap.put(NAME_MEETMILL_CHIKIN,item_millchikin);
        itemMap.put(NAME_MEETMILL_MUTTON,item_millmutton);

        itemMap.put(NAME_DUST_FLOWER_DANDELION,item_flowerdust_dandelion);
        itemMap.put(NAME_DUST_FLOWER_POPY,item_flowerdust_popy);
        itemMap.put(NAME_DUST_FLOWER_ORCHID,item_flowerdust_orchid);
        itemMap.put(NAME_DUST_FLOWER_ALLIUM,item_flowerdust_allium);
        itemMap.put(NAME_DUST_FLOWER_AZUREBLUET,item_flowerdust_azurebluet);
        itemMap.put(NAME_DUST_FLOWER_TULIP,item_flowerdust_tulip);
        itemMap.put(NAME_DUST_FLOWER_OXEYDAISY,item_flowerdust_oxeydaisy);
        itemMap.put(NAME_DUST_FLOWER_SUNFLOWER,item_flowerdust_sunflower);
        itemMap.put(NAME_DUST_FLOWER_LILAC,item_flowerdust_lilac);
        itemMap.put(NAME_DUST_FLOWER_ROSE,item_flowerdust_rose);
        itemMap.put(NAME_DUST_FLOWER_PEONY,item_flowerdust_peony);
        itemMap.put(NAME_DUST_FLOWER_PANACEA,item_flowerdust_panacea);

        itemMap.put(NAME_TEA_FLOWER_DANDELION,item_flowertea_dandelion);
        itemMap.put(NAME_TEA_FLOWER_POPY,item_flowertea_popy);
        itemMap.put(NAME_TEA_FLOWER_ORCHID,item_flowertea_orchid);
        itemMap.put(NAME_TEA_FLOWER_ALLIUM,item_flowertea_allium);
        itemMap.put(NAME_TEA_FLOWER_AZUREBLUET,item_flowertea_azurebluet);
        itemMap.put(NAME_TEA_FLOWER_TULIP,item_flowertea_tulip);
        itemMap.put(NAME_TEA_FLOWER_OXEYDAISY,item_flowertea_oxeydaisy);
        itemMap.put(NAME_TEA_FLOWER_SUNFLOWER,item_flowertea_sunflower);
        itemMap.put(NAME_TEA_FLOWER_LILAC,item_flowertea_lilac);
        itemMap.put(NAME_TEA_FLOWER_ROSE,item_flowertea_rose);
        itemMap.put(NAME_TEA_FLOWER_PEONY,item_flowertea_peony);
        itemMap.put(NAME_TEA_FLOWER_PANACEA,item_flowertea_panacea);

        itemMap.put(NAME_DEBUG_ITEM,item_debug);

	}




	public static enum EnumIceFlavor{
		ICE_VANILA    (0,     "vanila",2,0.5F,null,new ItemStack[]{ItemStack.EMPTY}),
		ICE_BLACK     (1,     EnumDyeColor.BLACK.toString(),      2,0.25F, null, new ItemStack[]{new ItemStack(Items.INK_SAC,1)}),
		ICE_RED       (2,     EnumDyeColor.RED.toString(),        2,0.25F, null, new ItemStack[]{new ItemStack(Items.ROSE_RED,1)}),
		ICE_GREEN     (3,     EnumDyeColor.GREEN.toString(),      2,0.25F, null, new ItemStack[]{new ItemStack(Items.CACTUS_GREEN,1)}),
		ICE_BROWN     (4,     EnumDyeColor.BROWN.toString(),      2,0.25F, null, new ItemStack[]{new ItemStack(Items.COCOA_BEANS,1)}),
		ICE_BLUE      (5,     EnumDyeColor.BLUE.toString(),       2,0.25F, null, new ItemStack[]{new ItemStack(Items.LAPIS_LAZULI,1)}),
		ICE_PURPLE    (6,     EnumDyeColor.PURPLE.toString(),     2,0.25F, null, new ItemStack[]{new ItemStack(Items.PURPLE_DYE,1)}),
		ICE_CYAN      (7,     EnumDyeColor.CYAN.toString(),       2,0.25F, null, new ItemStack[]{new ItemStack(Items.CYAN_DYE,1)}),
		ICE_SILVER    (8,     EnumDyeColor.LIGHT_GRAY.toString(), 2,0.25F, null, new ItemStack[]{new ItemStack(Items.LIGHT_GRAY_DYE,1)}),
		ICE_GRAY      (9,     EnumDyeColor.GRAY.toString(),       2,0.25F, null, new ItemStack[]{new ItemStack(Items.GRAY_DYE,1)}),
		ICE_PINK      (10,    EnumDyeColor.PINK.toString(),       2,0.25F, null, new ItemStack[]{new ItemStack(Items.PINK_DYE,1)}),
		ICE_LIME      (11,    EnumDyeColor.LIME.toString(),       2,0.25F, null, new ItemStack[]{new ItemStack(Items.LIME_DYE,1)}),
		ICE_YELLOW    (12,    EnumDyeColor.YELLOW.toString(),     2,0.25F, null, new ItemStack[]{new ItemStack(Items.DANDELION_YELLOW,1)}),
		ICE_LIGHT_BLUE(13,    EnumDyeColor.LIGHT_BLUE.toString(), 2,0.25F, null, new ItemStack[]{new ItemStack(Items.LIGHT_BLUE_DYE,1)}),
		ICE_MAGENTA   (14,    EnumDyeColor.MAGENTA.toString(),    2,0.25F, null, new ItemStack[]{new ItemStack(Items.MAGENTA_DYE,1)}),
		ICE_ORANGE    (15,    EnumDyeColor.ORANGE.toString(),     2,0.25F, null, new ItemStack[]{new ItemStack(Items.ORANGE_DYE,1)}),
		ICE_WHITE     (16,    EnumDyeColor.WHITE.toString(),      2,0.25F, null, new ItemStack[]{new ItemStack(Items.BONE_MEAL,1)}),
		ICE_APPLE     (17,    "apple",                            2,0.25F, null, new ItemStack[]{new ItemStack(Items.APPLE,1)}),
		ICE_CACTUS    (18,    "cactus",                           2,0.25F, null, new ItemStack[]{new ItemStack(Blocks.CACTUS,1)}),
		ICE_PUMPKIN   (19,    "pumpkin",                          2,0.25F, null, new ItemStack[]{new ItemStack(Blocks.PUMPKIN,1)}),
		ICE_POTATO    (20,    "potato",                           2,0.25F, null, new ItemStack[]{new ItemStack(Items.POTATO,1)}),
		ICE_CARROT    (21,    "carrot",                           2,0.25F, null, new ItemStack[]{new ItemStack(Items.CARROT,1)}),
		ICE_MELON    (22,    "melon",                           2,0.25F, null, new ItemStack[]{new ItemStack(Items.MELON_SLICE,1), new ItemStack(Blocks.MELON,1)}),
		ICE_GREENTEA  (23,    "greentea",                         2,0.25F, null, new ItemStack[]{
				new ItemStack(Blocks.ACACIA_LEAVES,1),
				new ItemStack(Blocks.BIRCH_LEAVES,1),
				new ItemStack(Blocks.DARK_OAK_LEAVES),
				new ItemStack(Blocks.JUNGLE_LEAVES,1),
				new ItemStack(Blocks.OAK_LEAVES,1),
				new ItemStack(Blocks.SPRUCE_LEAVES,1),});

		private int index;
		private int damage;
		private String fravor;
		private int foodLevel;
		private float foodSaturation;
		private PotionEffect[] potion;
		private ItemStack[] baseItem;
		private EnumIceFlavor(int idx, String name, int healamount, float saturation, PotionEffect[] effects, ItemStack[] item){
			index = idx;
			damage = idx;
			fravor = name;
			foodLevel = healamount;
			foodSaturation = saturation;
			potion = effects;
			baseItem = item;
		}

		public static final EnumIceFlavor[] values = {ICE_VANILA,ICE_BLACK,ICE_RED,ICE_GREEN,ICE_BROWN,ICE_BLUE,ICE_PURPLE,ICE_CYAN,ICE_SILVER,ICE_GRAY,ICE_PINK,ICE_LIME,ICE_YELLOW,ICE_LIGHT_BLUE,ICE_MAGENTA,ICE_ORANGE,ICE_WHITE,ICE_APPLE,ICE_CACTUS,ICE_PUMPKIN,ICE_POTATO,ICE_CARROT,ICE_MELON,ICE_GREENTEA};

		public int getIndex(){return this.index;}
		public int getDamage(){return this.damage;}
		public String getFlavor(){return this.fravor;}
		public PotionEffect[] getPotion(){return potion;}
		public ItemStack[] getBaseItem(){return this.baseItem;}
		public static EnumIceFlavor getValue(int index){return values[index];}

		public int getFoodLevel(){return foodLevel;}
		public float getFoodSaturation(){return foodSaturation;}
	}

	public static enum EnumFlapeSyrup{
		SYRUP_NONE      (0,     "none",                             1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{ItemStack.EMPTY}),
		SYRUP_SUGAR     (1,     "sugar",                            1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{ItemStack.EMPTY}),
		SYRUP_BLACK     (2,     EnumDyeColor.BLACK.toString(),      1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.INK_SAC,1)}),
		SYRUP_RED       (3,     EnumDyeColor.RED.toString(),        1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.ROSE_RED,1)}),
		SYRUP_GREEN     (4,     EnumDyeColor.GREEN.toString(),      1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.CACTUS_GREEN,1)}),
		SYRUP_BROWN     (5,     EnumDyeColor.BROWN.toString(),      1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.COCOA_BEANS,1)}),
		SYRUP_BLUE      (6,     EnumDyeColor.BLUE.toString(),       1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.LAPIS_LAZULI,1)}),
		SYRUP_PURPLE    (7,     EnumDyeColor.PURPLE.toString(),     1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.PURPLE_DYE,1)}),
		SYRUP_CYAN      (8,     EnumDyeColor.CYAN.toString(),       1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.CYAN_DYE,1)}),
		SYRUP_SILVER    (9,     EnumDyeColor.LIGHT_GRAY.toString(), 1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.LIGHT_GRAY_DYE,1)}),
		SYRUP_GRAY      (10,    EnumDyeColor.GRAY.toString(),       1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.GRAY_DYE,1)}),
		SYRUP_PINK      (11,    EnumDyeColor.PINK.toString(),       1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.PINK_DYE,1)}),
		SYRUP_LIME      (12,    EnumDyeColor.LIME.toString(),       1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.LIME_DYE,1)}),
		SYRUP_YELLOW    (13,    EnumDyeColor.YELLOW.toString(),     1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.DANDELION_YELLOW,1)}),
		SYRUP_LIGHT_BLUE(14,    EnumDyeColor.LIGHT_BLUE.toString(), 1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.LIGHT_BLUE_DYE,1)}),
		SYRUP_MAGENTA   (15,    EnumDyeColor.MAGENTA.toString(),    1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.MAGENTA_DYE,1)}),
		SYRUP_ORANGE    (16,    EnumDyeColor.ORANGE.toString(),     1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.ORANGE_DYE,1)}),
		SYRUP_WHITE     (17,    EnumDyeColor.WHITE.toString(),      1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.BONE_MEAL,1)}),
		SYRUP_APPLE     (18,    "apple",                            1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.APPLE,1)}),
		SYRUP_CACTUS    (19,    "cactus",                           1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Blocks.CACTUS,1)}),
		SYRUP_MELON     (20,    "melon",                            1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.MELON_SLICE,1), new ItemStack(Blocks.MELON,1)}),
		SYRUP_PUMPKIN   (21,    "pumpkin",                          1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Blocks.PUMPKIN,1)}),
		SYRUP_GREENTEA  (22,    "greentea",                         1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{
				new ItemStack(Blocks.ACACIA_LEAVES,1),
				new ItemStack(Blocks.BIRCH_LEAVES,1),
				new ItemStack(Blocks.DARK_OAK_LEAVES),
				new ItemStack(Blocks.JUNGLE_LEAVES,1),
				new ItemStack(Blocks.OAK_LEAVES,1),
				new ItemStack(Blocks.SPRUCE_LEAVES,1),});
		private int index;
		private int damage;
		private String flavor;
		private int foodLevel;
		private float foodSaturation;
		private PotionEffect[] potion;
		private ItemStack[] baseItem;
		private EnumFlapeSyrup(int idx,String name, int healamount, float saturation, PotionEffect[] effects, ItemStack[] item){
			index = idx;
			damage = idx;
			flavor = name;
			foodLevel = healamount;
			foodSaturation = saturation;
			potion = effects;
			baseItem = item;
		}

		public static final EnumFlapeSyrup[] values = {SYRUP_NONE,SYRUP_SUGAR,SYRUP_BLACK,SYRUP_RED,SYRUP_GREEN,
				SYRUP_BROWN,SYRUP_BLUE,SYRUP_PURPLE,SYRUP_CYAN,SYRUP_SILVER,SYRUP_GRAY,SYRUP_PINK,SYRUP_LIME,SYRUP_YELLOW,
				SYRUP_LIGHT_BLUE,SYRUP_MAGENTA,SYRUP_ORANGE,SYRUP_WHITE,SYRUP_APPLE,SYRUP_CACTUS,SYRUP_MELON,SYRUP_PUMPKIN,SYRUP_GREENTEA,};

		public int getIndex(){return this.index;}
		public int getDamage(){return this.damage;}
		public String getFlavor(){return this.flavor;}
		public int getFoodLevel(){return foodLevel;}
		public float getFoodSaturation(){return foodSaturation;}
		public PotionEffect[] getPotion(){return potion;}
		public ItemStack[] getBaseItem(){return baseItem;}
		public static EnumFlapeSyrup getValue(int index){return values[index];}
	}

	public static enum EnumFlowerHalb{
		DANDELION(0,0,"dandelion",new Potion[]{MobEffects.UNLUCK}),
		POPY(1,1,"popy",new Potion[]{MobEffects.NAUSEA}),
		ORCHID(2,2,"orchid",new Potion[]{MobEffects.POISON},false),
		ALLIUM(3,3,"allium",new Potion[]{MobEffects.POISON}),
		AZUREBLUET(4,4,"azurebluet",new Potion[]{MobEffects.WITHER}),
		TULIP(5,5,"tulip",new Potion[]{MobEffects.SLOWNESS}),
		OXEYDAISY(6,6,"oxeydaisy",new Potion[]{MobEffects.HUNGER}),
		SUNFLOWER(7,7,"sunflower",new Potion[]{MobEffects.BLINDNESS}),
		LILAC(8,8,"lilac",new Potion[]{MobEffects.MINING_FATIGUE}),
		ROSE(9,9,"rose",new Potion[]{MobEffects.WEAKNESS}),
		PEONY(10,10,"peony",new Potion[]{null}),
		PANACEA(11,11,"panacea",new Potion[]{MobEffects.BLINDNESS,MobEffects.NAUSEA,MobEffects.MINING_FATIGUE,
				MobEffects.HUNGER,MobEffects.SLOWNESS,MobEffects.UNLUCK,MobEffects.WEAKNESS,MobEffects.WITHER});

		private int index;
		private int damage;
		private String flavor;
		private Potion[] effect;
		private boolean isClean;

		private EnumFlowerHalb(int idx, int dmg, String flv, Potion[] effect){
			this.index = idx;
			this.damage = dmg;
			this.flavor = flv;
			this.effect = effect;
			this.isClean = true;
		}

		private EnumFlowerHalb(int idx, int dmg, String flv, Potion[] effect,boolean clean){
			this.index = idx;
			this.damage = dmg;
			this.flavor = flv;
			this.effect = effect;
			this.isClean = clean;
		}

		public static final EnumFlowerHalb[] values = {DANDELION,POPY,ORCHID,ALLIUM,AZUREBLUET,TULIP,OXEYDAISY,SUNFLOWER,LILAC,ROSE,PEONY,PANACEA};

		public int getIndex(){return this.index;}
		public int getDamage(){return this.damage;}
		public String getFlavor(){return this.flavor;}
		public Potion[] getPotion(){return effect;}
		public boolean isClean(){return isClean;}
		public static EnumFlowerHalb getValue(int index){return values[index];}
	}


	public static Item[] flapelist = {
			item_crashedice_none,
			item_crashedice_sugar,
			item_crashedice_black,
			item_crashedice_red,
			item_crashedice_green,
			item_crashedice_brown,
			item_crashedice_blue,
			item_crashedice_purple,
			item_crashedice_cyan,
			item_crashedice_silver,
			item_crashedice_gray,
			item_crashedice_pink,
			item_crashedice_lime,
			item_crashedice_yellow,
			item_crashedice_light_blue,
			item_crashedice_magenta,
			item_crashedice_orange,
			item_crashedice_white,
			item_crashedice_apple,
			item_crashedice_cactus,
			item_crashedice_melon,
			item_crashedice_pumpkin,
			item_crashedice_greentea
		};

		public static Item[] mkflapelist = {
			item_crashedice_milk_none,
			item_crashedice_milk_sugar,
			item_crashedice_milk_black,
			item_crashedice_milk_red,
			item_crashedice_milk_green,
			item_crashedice_milk_brown,
			item_crashedice_milk_blue,
			item_crashedice_milk_purple,
			item_crashedice_milk_cyan,
			item_crashedice_milk_silver,
			item_crashedice_milk_gray,
			item_crashedice_milk_pink,
			item_crashedice_milk_lime,
			item_crashedice_milk_yellow,
			item_crashedice_milk_light_blue,
			item_crashedice_milk_magenta,
			item_crashedice_milk_orange,
			item_crashedice_milk_white,
			item_crashedice_milk_apple,
			item_crashedice_milk_cactus,
			item_crashedice_milk_melon,
			item_crashedice_milk_pumpkin,
			item_crashedice_milk_greentea
		};

	public static ItemStack getCrachedIce(EnumFlapeSyrup flavor, boolean milk) {
		ItemStack stack;
		if (milk) {
			if (flavor.getDamage() < mkflapelist.length) {
				stack = new ItemStack(mkflapelist[flavor.getDamage()]);
			}else {
				stack = new ItemStack(mkflapelist[0]);
			}
		}else {
			if (flavor.getDamage() < flapelist.length) {
				stack = new ItemStack(flapelist[flavor.getDamage()]);
			}else {
				stack = new ItemStack(flapelist[0]);
			}
		}
		return stack;
	}


	public static Item[] icecreamlist = {
		item_icecream_vanila,
		item_icecream_black,
		item_icecream_red,
		item_icecream_green,
		item_icecream_brown,
		item_icecream_blue,
		item_icecream_purple,
		item_icecream_cyan,
		item_icecream_silver,
		item_icecream_gray,
		item_icecream_pink,
		item_icecream_lime,
		item_icecream_yellow,
		item_icecream_light_blue,
		item_icecream_magenta,
		item_icecream_orange,
		item_icecream_white,
		item_icecream_apple,
		item_icecream_cactus,
		item_icecream_pumpkin,
		item_icecream_potato,
		item_icecream_carrot,
		item_icecream_melon,
		item_icecream_greentea
	};

	public static Item[] ckicecreamlist = {
		item_icecream_cookie_vanila,
		item_icecream_cookie_black,
		item_icecream_cookie_red,
		item_icecream_cookie_green,
		item_icecream_cookie_brown,
		item_icecream_cookie_blue,
		item_icecream_cookie_purple,
		item_icecream_cookie_cyan,
		item_icecream_cookie_silver,
		item_icecream_cookie_gray,
		item_icecream_cookie_pink,
		item_icecream_cookie_lime,
		item_icecream_cookie_yellow,
		item_icecream_cookie_light_blue,
		item_icecream_cookie_magenta,
		item_icecream_cookie_orange,
		item_icecream_cookie_white,
		item_icecream_cookie_apple,
		item_icecream_cookie_cactus,
		item_icecream_cookie_pumpkin,
		item_icecream_cookie_potato,
		item_icecream_cookie_carrot,
		item_icecream_cookie_melon,
		item_icecream_cookie_greentea
	};

	public static ItemStack getIceCream(EnumIceFlavor flavor, boolean cookie) {
		ItemStack stack;
		if (cookie) {
			if (flavor.getDamage() < ckicecreamlist.length) {
				stack = new ItemStack(ckicecreamlist[flavor.getDamage()]);
			}else {
				stack = new ItemStack(ckicecreamlist[0]);
			}
		}else {
			if (flavor.getDamage() < icecreamlist.length) {
				stack = new ItemStack(icecreamlist[flavor.getDamage()]);
			}else {
				stack = new ItemStack(icecreamlist[0]);
			}
		}
		return stack;
	}

	public static void register(Register<Item> event) {
		for(String key : NAME_LIST) {
			if (itemMap.containsKey(key)) {
				event.getRegistry().register(itemMap.get(key));
			}
		}
	}

	public static Item[] icemixList = new Item[] {
			item_ice_mix_vanila,
			item_ice_mix_black,
			item_ice_mix_red,
			item_ice_mix_green,
			item_ice_mix_brown,
			item_ice_mix_blue,
			item_ice_mix_purple,
			item_ice_mix_cyan,
			item_ice_mix_silver,
			item_ice_mix_gray,
			item_ice_mix_pink,
			item_ice_mix_lime,
			item_ice_mix_yellow,
			item_ice_mix_light_blue,
			item_ice_mix_magenta,
			item_ice_mix_orange,
			item_ice_mix_white,
			item_ice_mix_apple,
			item_ice_mix_cactus,
			item_ice_mix_pumpkin,
			item_ice_mix_potato,
			item_ice_mix_carrot,
			item_ice_mix_melon,
			item_ice_mix_greentea
	};

	public static Item[] syrupList = new Item[] {
		item_syrup_sugar,
		item_syrup_black,
		item_syrup_red,
		item_syrup_green,
		item_syrup_brown,
		item_syrup_blue,
		item_syrup_purple,
		item_syrup_cyan,
		item_syrup_silver,
		item_syrup_gray,
		item_syrup_pink,
		item_syrup_lime,
		item_syrup_yellow,
		item_syrup_light_blue,
		item_syrup_magenta,
		item_syrup_orange,
		item_syrup_white,
		item_syrup_apple,
		item_syrup_cactus,
		item_syrup_melon,
		item_syrup_pumpkin,
		item_syrup_greentea,
	};

	public static Item[] sugarwaterList = new Item[] {
		item_sugar_water_none,
		item_sugar_water_sugar,
		item_sugar_water_black,
		item_sugar_water_red,
		item_sugar_water_green,
		item_sugar_water_brown,
		item_sugar_water_blue,
		item_sugar_water_purple,
		item_sugar_water_cyan,
		item_sugar_water_silver,
		item_sugar_water_gray,
		item_sugar_water_pink,
		item_sugar_water_lime,
		item_sugar_water_yellow,
		item_sugar_water_light_blue,
		item_sugar_water_magenta,
		item_sugar_water_orange,
		item_sugar_water_white,
		item_sugar_water_apple,
		item_sugar_water_cactus,
		item_sugar_water_melon,
		item_sugar_water_pumpkin,
		item_sugar_water_greentea,
	};

	public static Item[] icecandyList = new Item[] {
		item_icecandy_none,
		item_icecandy_sugar,
		item_icecandy_black,
		item_icecandy_red,
		item_icecandy_green,
		item_icecandy_brown,
		item_icecandy_blue,
		item_icecandy_purple,
		item_icecandy_cyan,
		item_icecandy_silver,
		item_icecandy_gray,
		item_icecandy_pink,
		item_icecandy_lime,
		item_icecandy_yellow,
		item_icecandy_light_blue,
		item_icecandy_magenta,
		item_icecandy_orange,
		item_icecandy_white,
		item_icecandy_apple,
		item_icecandy_cactus,
		item_icecandy_melon,
		item_icecandy_pumpkin,
		item_icecandy_greentea,
	};

}
