package mod.drf.foods.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mod.drf.core.ModCommon;
import mod.drf.core.Mod_DiningFurniture;
import net.minecraft.block.BlockPlanks;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemFoods {
	public static final List<String> NMAE_LIST = new ArrayList<String>(){
		{add(NAME_ICEFOOD_BOWL);}
		{add(NAME_CHOCO);}
		{add(NAME_WHITECHOCO);}
		{add(NAME_CARAMEL);}
		{add(NAME_PUDDING);}
		{add(NAME_PUMPKINPUDDING);}
		{add(NAME_PIECEPIE);}
		{add(NAME_PIECECARAMELPIE);}
		{add(NAME_PIECECHOCOPIE);}
		{add(NAME_PIECESALADAPIE);}
		{add(NAME_PIECEMEETPIE);}
		{add(NAME_PIECEFISHPIE);}
		{add(NAME_PIECEPUMPUKINPIE);}
		{add(NAME_PIECEAPPLEPIE);}
		{add(NAME_PIECEblackPIE);}
		{add(NAME_PIECEZOMBIPIE);}
		{add(NAME_POTATOSALADA);}
		{add(NAME_PUMPKINSALDADA);}
		{add(NAME_EGGSANDWICH);}
		{add(NAME_POTATSALADASANDWITCH);}
		{add(NAME_HAMSANDWICH);}
		{add(NAME_MUTTONSANDWICH);}
		{add(NAME_STAKESANDWICH);}
		{add(NAME_CHIKENSANDWICH);}
		{add(NAME_CHOCOSANDWICH);}
		{add(NAME_PUMPKINSALADASANDWICH);}
		{add(NAME_BUTTER);}
		{add(NAME_RENNET);}
		{add(NAME_SALT);}
		{add(NAME_MOLD);}
		{add(NAME_BLUEMOLD);}
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
		{add(NAME_ICE_MIX);}
		{add(NAME_ICECREAM);}
		{add(NAME_ICECREAM_COOKIE);}
		{add(NAME_SYRUP);}
		{add(NAME_SUGARMILK);}
		{add(NAME_SYRUP_MILK);}
		{add(NAME_CRASHEDICE);}
		{add(NAME_CRASHEDICE_MILK);}
		{add(NAME_SUGAR_WATER);}
		{add(NAME_ICECANDY);}
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
		{add(NAME_DUST_FLOWER);}
		{add(NAME_TEA_FLOWER);}
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
	public static final String NAME_ICE_MIX = "icemix";
	//	アイスクリーム
	public static final String NAME_ICECREAM ="icecream";;
	// クッキー入りアイス
	public static final String NAME_ICECREAM_COOKIE = "ck_icecream";
	// シロップ
	public static final String NAME_SYRUP = "syrup";
	// 砂糖入り牛乳
	public static final String NAME_SUGARMILK = "sugarmillk";
	// 練乳
	public static final String NAME_SYRUP_MILK = "condencedmilk";
	// 練乳かき氷
	public static final String NAME_CRASHEDICE="crashedice";
	// 練乳かき氷
	public static final String NAME_CRASHEDICE_MILK="mk_crashedice";
	// キャンディ液
	public static final String NAME_SUGAR_WATER="icesugarwater";
	// アイスキャンディ
	public static final String NAME_ICECANDY = "icecandy";

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
	public static final String NAME_DUST_FLOWER="flowerdust";
	// 花のお茶
	public static final String NAME_TEA_FLOWER="flowertea";

	// デバッグ用アイテム
	public static final String NAME_DEBUG_ITEM="debugitem";

	public static  Item item_icefoodbowl;
	public static  Item item_choco                 ;//= new ItemFood(1,0.1f,false).setRegistryName(NAME_CHOCO).setUnlocalizedName(NAME_CHOCO).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_whitechoco            ;//= new ItemFood(1,0.5f,false).setRegistryName(NAME_WHITECHOCO).setUnlocalizedName(NAME_WHITECHOCO).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_caramel               ;//= new ItemFood(1,0.05f,false).setRegistryName(NAME_CARAMEL).setUnlocalizedName(NAME_CARAMEL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_pudding               ;//= new ItemFood(2,0.28f,false).setRegistryName(NAME_PUDDING).setUnlocalizedName(NAME_PUDDING).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_pumpkinpudding        ;//= new ItemFood(2,1.48f,false).setRegistryName(NAME_PUMPKINPUDDING).setUnlocalizedName(NAME_PUMPKINPUDDING).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_piecepie              ;//= new ItemFood(4,0.14f,false).setRegistryName(NAME_PIECEPIE).setUnlocalizedName(NAME_PIECEPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_piecechocopie         ;//= new ItemFood(2,0.1f,false).setRegistryName(NAME_PIECECHOCOPIE).setUnlocalizedName(NAME_PIECECHOCOPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_piecesaladapie        ;//= new ItemFood(6,0.27f,false).setRegistryName(NAME_PIECESALADAPIE).setUnlocalizedName(NAME_PIECESALADAPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_piecemeetpie          ;//= new ItemFood(8,0.34f,false).setRegistryName(NAME_PIECEMEETPIE).setUnlocalizedName(NAME_PIECEMEETPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_piecefishpie          ;//= new ItemFood(8,0.2f,false).setRegistryName(NAME_PIECEFISHPIE).setUnlocalizedName(NAME_PIECEFISHPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_piecepumpukinpie      ;//= new ItemFood(6,0.23f,false).setRegistryName(NAME_PIECEPUMPUKINPIE).setUnlocalizedName(NAME_PIECEPUMPUKINPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_piecezombipie         ;//= new ItemFood(2,0.28f,false).setPotionEffect(new PotionEffect(MobEffects.HUNGER,600,0),100.0F).setRegistryName(NAME_PIECEZOMBIPIE).setUnlocalizedName(NAME_PIECEZOMBIPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_pieceapplepie         ;//= new ItemFood(4,0.19f,false).setRegistryName(NAME_PIECEAPPLEPIE).setUnlocalizedName(NAME_PIECEAPPLEPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_pieceblackpie         ;//= new ItemFood(4,0.14f,false).setRegistryName(NAME_PIECEblackPIE).setUnlocalizedName(NAME_PIECEblackPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_piececaramelpie       ;//= new ItemFood(4,0.14f,false).setRegistryName(NAME_PIECECARAMELPIE).setUnlocalizedName(NAME_PIECECARAMELPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_eggsandwich           ;//= new ItemFood(6,0.18f,false).setRegistryName(NAME_EGGSANDWICH).setUnlocalizedName(NAME_EGGSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_potatsaladasandwitch  ;//= new ItemFood(6,0.52f,false).setRegistryName(NAME_POTATSALADASANDWITCH).setUnlocalizedName(NAME_POTATSALADASANDWITCH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_hamsandwich           ;//= new ItemFood(8,0.53f,false).setRegistryName(NAME_HAMSANDWICH).setUnlocalizedName(NAME_HAMSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_muttonsandwich        ;//= new ItemFood(8,0.53f,false).setRegistryName(NAME_MUTTONSANDWICH).setUnlocalizedName(NAME_MUTTONSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_stakesandwich         ;//= new ItemFood(8,0.53f,false).setRegistryName(NAME_STAKESANDWICH).setUnlocalizedName(NAME_STAKESANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_chikensandwich        ;//= new ItemFood(8,0.35f,false).setRegistryName(NAME_CHIKENSANDWICH).setUnlocalizedName(NAME_CHIKENSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_chocosandwich         ;//= new ItemFood(4,0.25f,false).setRegistryName(NAME_CHOCOSANDWICH).setUnlocalizedName(NAME_CHOCOSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_pumpkinsaladasandwich ;//= new ItemFood(6,0.41f,false).setRegistryName(NAME_PUMPKINSALADASANDWICH).setUnlocalizedName(NAME_PUMPKINSALADASANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_potatosalada          ;//= new ItemSalada(8,1.6f,false).setRegistryName(NAME_POTATOSALADA).setUnlocalizedName(NAME_POTATOSALADA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_pumpkinsalada         ;//= new ItemSalada(8,1.11f,false).setRegistryName(NAME_PUMPKINSALDADA).setUnlocalizedName(NAME_PUMPKINSALDADA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_rennet;
	public static  Item item_butter                ;//= new Item().setRegistryName(NAME_BUTTER).setUnlocalizedName(NAME_BUTTER).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_mold                  ;//= new Item().setRegistryName(NAME_MOLD).setUnlocalizedName(NAME_MOLD).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_salt                  ;//= new Item().setRegistryName(NAME_SALT).setUnlocalizedName(NAME_SALT).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_bluemold              ;//= new Item().setRegistryName(NAME_BLUEMOLD).setUnlocalizedName(NAME_BLUEMOLD).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_row_hallpie           ;//= new Item().setRegistryName(NAME_ROW_PIE_HALL).setUnlocalizedName(NAME_ROW_PIE_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_row_chocohallpie      ;//= new Item().setRegistryName(NAME_ROW_CHOCOPIE_HALL).setUnlocalizedName(NAME_ROW_CHOCOPIE_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_row_saladahallpie     ;//= new Item().setRegistryName(NAME_ROW_SALADA_HALL).setUnlocalizedName(NAME_ROW_SALADA_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_row_meethallpie       ;//= new Item().setRegistryName(NAME_ROW_MEETPIE_HALL).setUnlocalizedName(NAME_ROW_MEETPIE_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_row_fishhallpie       ;//= new Item().setRegistryName(NAME_ROW_FISHPIE_HALL).setUnlocalizedName(NAME_ROW_FISHPIE_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_row_pumpkinhallpie    ;//= new Item().setRegistryName(NAME_ROW_PUMPKINPIE_HALL).setUnlocalizedName(NAME_ROW_PUMPKINPIE_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_row_zombihallpie      ;//= new Item().setRegistryName(NAME_ROW_ZOMBIPEI_HALL).setUnlocalizedName(NAME_ROW_ZOMBIPEI_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_row_applehallpie      ;//= new Item().setRegistryName(NAME_ROW_APPLEPIE_HALL).setUnlocalizedName(NAME_ROW_APPLEPIE_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_row_blackpie          ;//= new Item().setRegistryName(NAME_ROW_BLACK_PIE).setUnlocalizedName(NAME_ROW_BLACK_PIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_row_pizza             ;//= new Item().setRegistryName(NAME_ROW_PIZZA).setUnlocalizedName(NAME_ROW_PIZZA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_row_meetpizza         ;//= new Item().setRegistryName(NAME_ROW_MEETPIZZA).setUnlocalizedName(NAME_ROW_MEETPIZZA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_row_fishpizza         ;//= new Item().setRegistryName(NAME_ROW_FISHPIZZA).setUnlocalizedName(NAME_ROW_FISHPIZZA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);

	public static  Item item_icemix                ;//= new ItemIceCreamMix().setRegistryName(NAME_ICE_MIX).setUnlocalizedName(NAME_ICE_MIX).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
	public static  Item item_icecream              ;//= new ItemIceCream(0,0,false).setRegistryName(NAME_ICECREAM).setUnlocalizedName(NAME_ICECREAM).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
	public static  Item item_icecreamcookie;
	public static  Item item_syrup                 ;//= new ItemSyrup().setRegistryName(NAME_SYRUP).setUnlocalizedName(NAME_SYRUP).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
	public static  Item item_sugarmilk             ;//= new Item().setRegistryName(NAME_SUGARMILK).setUnlocalizedName(NAME_SUGARMILK).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static  Item item_syrupmilk             ;//= new Item().setRegistryName(NAME_SYRUP_MILK).setUnlocalizedName(NAME_SYRUP_MILK).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static  Item item_crashedice            ;//= new ItemCrashedIce(0,0,false).setPotionEffect(new PotionEffect(MobEffects.NAUSEA,100,1), 25.0F).setRegistryName(NAME_CRASHEDICE).setUnlocalizedName(NAME_CRASHEDICE).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static  Item item_milkcrashedice        ;//= new ItemCrashedIce(0,0,false).setPotionEffect(new PotionEffect(MobEffects.NAUSEA,100,1), 25.0F).setRegistryName(NAME_CRASHEDICE_MILK).setUnlocalizedName(NAME_CRASHEDICE_MILK).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static  Item item_sugarwater            ;//= new ItemSyrup().setRegistryName(NAME_SUGAR_WATER).setUnlocalizedName(NAME_SUGAR_WATER).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
	public static  Item item_icecandy              ;//= new ItemIceCandy(0,0,false).setRegistryName(NAME_ICECANDY).setUnlocalizedName(NAME_ICECANDY).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);

	public static  Item item_flour                 ;//= new Item().setRegistryName(NAME_FLOUR).setUnlocalizedName(NAME_FLOUR).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_udon                  ;//= new Item().setRegistryName(NAME_UDON).setUnlocalizedName(NAME_UDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_pasta                 ;//= new Item().setRegistryName(NAME_PASTA).setUnlocalizedName(NAME_PASTA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_ramen                 ;//= new Item().setRegistryName(NAME_LAMEN).setUnlocalizedName(NAME_LAMEN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_meetpasta             ;//= new ItemNoodle(10,1.58f,false).setRegistryName(NAME_MEET_PASTA).setUnlocalizedName(NAME_MEET_PASTA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_fishpasta             ;//= new ItemNoodle(10,0.6f,false).setRegistryName(NAME_FISH_PASTA).setUnlocalizedName(NAME_FISH_PASTA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_blackpasta            ;//= new ItemNoodle(10,0.3f,false).setRegistryName(NAME_BLACK_PASTA).setUnlocalizedName(NAME_BLACK_PASTA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_zaruudon              ;//= new ItemNoodle(10,0.3f,false).setRegistryName(NAME_ZARUUDON).setUnlocalizedName(NAME_ZARUUDON).setCreativeTab(Mod_DiningFurniture.tabFurniture);
	public static  Item item_kakeudon              ;//= new ItemNoodle(10,0.3f,false).setRegistryName(NAME_KAKEUDON).setUnlocalizedName(NAME_KAKEUDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_tsukimiuudon          ;//= new ItemNoodle(10,0.31f,false).setRegistryName(NAME_TUKIMIUDON).setUnlocalizedName(NAME_TUKIMIUDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_nikuudon              ;//= new ItemNoodle(10,0.94f,false).setRegistryName(NAME_NIKUUDON).setUnlocalizedName(NAME_NIKUUDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_meetramen             ;//= new ItemNoodle(10,0.94f,false).setRegistryName(NAME_MEETRAMEN).setUnlocalizedName(NAME_MEETRAMEN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_fishramen             ;//= new ItemNoodle(10,0.6f,false).setRegistryName(NAME_FISHRAMEN).setUnlocalizedName( NAME_FISHRAMEN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_tsukimiramen          ;//= new ItemNoodle(10,0.31f,false).setRegistryName(NAME_EGGRAMEN).setUnlocalizedName(NAME_EGGRAMEN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_millbeef              ;//= new Item().setRegistryName(NAME_MEETMILL_BEEF).setUnlocalizedName(NAME_MEETMILL_BEEF).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_millpoke              ;//= new Item().setRegistryName(NAME_MEETMILL_POKE).setUnlocalizedName(NAME_MEETMILL_POKE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_millchikin            ;//= new Item().setRegistryName(NAME_MEETMILL_CHIKIN).setUnlocalizedName(NAME_MEETMILL_CHIKIN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static  Item item_millmutton            ;//= new Item().setRegistryName(NAME_MEETMILL_MUTTON).setUnlocalizedName(NAME_MEETMILL_MUTTON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);

	public static  Item item_dustflower            ;//= new ItemFlowerDust().setRegistryName(NAME_DUST_FLOWER).setUnlocalizedName(NAME_DUST_FLOWER).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setHasSubtypes(true);
	public static  Item item_teaflower             ;//= new ItemFlowerTea().setRegistryName(NAME_TEA_FLOWER).setUnlocalizedName(NAME_TEA_FLOWER).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setHasSubtypes(true);
	public static  Item item_debug;
	public static void init(){
        item_icefoodbowl           = new Item().setRegistryName(NAME_ICEFOOD_BOWL).setUnlocalizedName(NAME_ICEFOOD_BOWL).setCreativeTab(Mod_DiningFurniture.tabColdFood);
		item_choco                 = new ItemFood(1,0.1f,false).setRegistryName(NAME_CHOCO).setUnlocalizedName(NAME_CHOCO).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_whitechoco            = new ItemFood(1,0.5f,false).setRegistryName(NAME_WHITECHOCO).setUnlocalizedName(NAME_WHITECHOCO).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_caramel               = new ItemFood(1,0.05f,false).setRegistryName(NAME_CARAMEL).setUnlocalizedName(NAME_CARAMEL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_pudding               = new ItemFood(2,0.28f,false).setRegistryName(NAME_PUDDING).setUnlocalizedName(NAME_PUDDING).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_pumpkinpudding        = new ItemFood(2,0.48f,false).setRegistryName(NAME_PUMPKINPUDDING).setUnlocalizedName(NAME_PUMPKINPUDDING).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_piecepie              = new ItemFood(2,0.2f,false).setRegistryName(NAME_PIECEPIE).setUnlocalizedName(NAME_PIECEPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_piecechocopie         = new ItemFood(4,0.2f,false).setRegistryName(NAME_PIECECHOCOPIE).setUnlocalizedName(NAME_PIECECHOCOPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_piecesaladapie        = new ItemFood(6,0.3f,false).setRegistryName(NAME_PIECESALADAPIE).setUnlocalizedName(NAME_PIECESALADAPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_piecemeetpie          = new ItemFood(8,0.4f,false).setRegistryName(NAME_PIECEMEETPIE).setUnlocalizedName(NAME_PIECEMEETPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_piecefishpie          = new ItemFood(8,0.4f,false).setRegistryName(NAME_PIECEFISHPIE).setUnlocalizedName(NAME_PIECEFISHPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_piecepumpukinpie      = new ItemFood(6,0.3f,false).setRegistryName(NAME_PIECEPUMPUKINPIE).setUnlocalizedName(NAME_PIECEPUMPUKINPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_piecezombipie         = new ItemFood(2,0.2f,false).setPotionEffect(new PotionEffect(MobEffects.HUNGER,600,0),100.0F).setRegistryName(NAME_PIECEZOMBIPIE).setUnlocalizedName(NAME_PIECEZOMBIPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_pieceapplepie         = new ItemFood(4,0.2f,false).setRegistryName(NAME_PIECEAPPLEPIE).setUnlocalizedName(NAME_PIECEAPPLEPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_pieceblackpie         = new ItemFood(4,0.2f,false).setRegistryName(NAME_PIECEblackPIE).setUnlocalizedName(NAME_PIECEblackPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_piececaramelpie       = new ItemFood(4,0.2f,false).setRegistryName(NAME_PIECECARAMELPIE).setUnlocalizedName(NAME_PIECECARAMELPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_eggsandwich           = new ItemFood(6,0.18f,false).setRegistryName(NAME_EGGSANDWICH).setUnlocalizedName(NAME_EGGSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_potatsaladasandwitch  = new ItemFood(6,0.52f,false).setRegistryName(NAME_POTATSALADASANDWITCH).setUnlocalizedName(NAME_POTATSALADASANDWITCH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_hamsandwich           = new ItemFood(8,0.53f,false).setRegistryName(NAME_HAMSANDWICH).setUnlocalizedName(NAME_HAMSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_muttonsandwich        = new ItemFood(8,0.53f,false).setRegistryName(NAME_MUTTONSANDWICH).setUnlocalizedName(NAME_MUTTONSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_stakesandwich         = new ItemFood(8,0.53f,false).setRegistryName(NAME_STAKESANDWICH).setUnlocalizedName(NAME_STAKESANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_chikensandwich        = new ItemFood(8,0.53f,false).setRegistryName(NAME_CHIKENSANDWICH).setUnlocalizedName(NAME_CHIKENSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_chocosandwich         = new ItemFood(4,0.25f,false).setRegistryName(NAME_CHOCOSANDWICH).setUnlocalizedName(NAME_CHOCOSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_pumpkinsaladasandwich = new ItemFood(6,0.41f,false).setRegistryName(NAME_PUMPKINSALADASANDWICH).setUnlocalizedName(NAME_PUMPKINSALADASANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_potatosalada          = new ItemSalada(8,1.6f,false).setMaxStackSize(1).setRegistryName(NAME_POTATOSALADA).setUnlocalizedName(NAME_POTATOSALADA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_pumpkinsalada         = new ItemSalada(8,1.11f,false).setMaxStackSize(1).setRegistryName(NAME_PUMPKINSALDADA).setUnlocalizedName(NAME_PUMPKINSALDADA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_rennet                = new Item().setRegistryName(NAME_RENNET).setUnlocalizedName(NAME_RENNET).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_butter                = new Item().setRegistryName(NAME_BUTTER).setUnlocalizedName(NAME_BUTTER).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_mold                  = new Item().setRegistryName(NAME_MOLD).setUnlocalizedName(NAME_MOLD).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_salt                  = new Item().setRegistryName(NAME_SALT).setUnlocalizedName(NAME_SALT).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_bluemold              = new Item().setRegistryName(NAME_BLUEMOLD).setUnlocalizedName(NAME_BLUEMOLD).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_row_hallpie           = new Item().setRegistryName(NAME_ROW_PIE_HALL).setUnlocalizedName(NAME_ROW_PIE_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_row_chocohallpie      = new Item().setRegistryName(NAME_ROW_CHOCOPIE_HALL).setUnlocalizedName(NAME_ROW_CHOCOPIE_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_row_saladahallpie     = new Item().setRegistryName(NAME_ROW_SALADA_HALL).setUnlocalizedName(NAME_ROW_SALADA_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_row_meethallpie       = new Item().setRegistryName(NAME_ROW_MEETPIE_HALL).setUnlocalizedName(NAME_ROW_MEETPIE_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_row_fishhallpie       = new Item().setRegistryName(NAME_ROW_FISHPIE_HALL).setUnlocalizedName(NAME_ROW_FISHPIE_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_row_pumpkinhallpie    = new Item().setRegistryName(NAME_ROW_PUMPKINPIE_HALL).setUnlocalizedName(NAME_ROW_PUMPKINPIE_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_row_zombihallpie      = new Item().setRegistryName(NAME_ROW_ZOMBIPEI_HALL).setUnlocalizedName(NAME_ROW_ZOMBIPEI_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_row_applehallpie      = new Item().setRegistryName(NAME_ROW_APPLEPIE_HALL).setUnlocalizedName(NAME_ROW_APPLEPIE_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_row_blackpie          = new Item().setRegistryName(NAME_ROW_BLACK_PIE).setUnlocalizedName(NAME_ROW_BLACK_PIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_row_pizza             = new Item().setRegistryName(NAME_ROW_PIZZA).setUnlocalizedName(NAME_ROW_PIZZA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_row_meetpizza         = new Item().setRegistryName(NAME_ROW_MEETPIZZA).setUnlocalizedName(NAME_ROW_MEETPIZZA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_row_fishpizza         = new Item().setRegistryName(NAME_ROW_FISHPIZZA).setUnlocalizedName(NAME_ROW_FISHPIZZA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);

		item_icemix                = new ItemIceCreamMix().setRegistryName(NAME_ICE_MIX).setUnlocalizedName(NAME_ICE_MIX).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
		item_icecream              = new ItemIceCream(0,0,false).setRegistryName(NAME_ICECREAM).setUnlocalizedName(NAME_ICECREAM).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
		item_icecreamcookie        = new ItemIceCream(0,0,false,true).setRegistryName(NAME_ICECREAM_COOKIE).setUnlocalizedName(NAME_ICECREAM_COOKIE);
		item_syrup                 = new ItemSyrup("syrup_config").setRegistryName(NAME_SYRUP).setUnlocalizedName(NAME_SYRUP).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
		item_sugarmilk             = new ItemBucketMilk().setRegistryName(NAME_SUGARMILK).setUnlocalizedName(NAME_SUGARMILK).setCreativeTab(Mod_DiningFurniture.tabColdFood);
		item_syrupmilk             = new Item().setRegistryName(NAME_SYRUP_MILK).setUnlocalizedName(NAME_SYRUP_MILK).setCreativeTab(Mod_DiningFurniture.tabColdFood);
		item_crashedice            = new ItemCrashedIce(0,0,false,false).setPotionEffect(new PotionEffect(MobEffects.NAUSEA,100,1), 25.0F).setRegistryName(NAME_CRASHEDICE).setUnlocalizedName(NAME_CRASHEDICE).setCreativeTab(Mod_DiningFurniture.tabColdFood);
		item_milkcrashedice        = new ItemCrashedIce(0,0,false,true).setPotionEffect(new PotionEffect(MobEffects.NAUSEA,100,1), 25.0F).setRegistryName(NAME_CRASHEDICE_MILK).setUnlocalizedName(NAME_CRASHEDICE_MILK).setCreativeTab(Mod_DiningFurniture.tabColdFood);
		item_sugarwater            = new ItemSyrup("sugarwater_config").setRegistryName(NAME_SUGAR_WATER).setUnlocalizedName(NAME_SUGAR_WATER).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
		item_icecandy              = new ItemIceCandy(0,0,false).setRegistryName(NAME_ICECANDY).setUnlocalizedName(NAME_ICECANDY).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);

		item_flour                 = new Item().setRegistryName(NAME_FLOUR).setUnlocalizedName(NAME_FLOUR).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_udon                  = new Item().setRegistryName(NAME_UDON).setUnlocalizedName(NAME_UDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_pasta                 = new Item().setRegistryName(NAME_PASTA).setUnlocalizedName(NAME_PASTA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_ramen                 = new Item().setRegistryName(NAME_LAMEN).setUnlocalizedName(NAME_LAMEN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_meetpasta             = new ItemNoodle(10,1.58f,false).setMaxStackSize(1).setRegistryName(NAME_MEET_PASTA).setUnlocalizedName(NAME_MEET_PASTA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_fishpasta             = new ItemNoodle(10,0.6f,false).setMaxStackSize(1).setRegistryName(NAME_FISH_PASTA).setUnlocalizedName(NAME_FISH_PASTA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_blackpasta            = new ItemNoodle(10,0.3f,false).setMaxStackSize(1).setRegistryName(NAME_BLACK_PASTA).setUnlocalizedName(NAME_BLACK_PASTA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_zaruudon              = new ItemNoodle(10,0.3f,false).setMaxStackSize(1).setRegistryName(NAME_ZARUUDON).setUnlocalizedName(NAME_ZARUUDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_kakeudon              = new ItemNoodle(10,0.3f,false).setMaxStackSize(1).setRegistryName(NAME_KAKEUDON).setUnlocalizedName(NAME_KAKEUDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_tsukimiuudon          = new ItemNoodle(10,0.31f,false).setMaxStackSize(1).setRegistryName(NAME_TUKIMIUDON).setUnlocalizedName(NAME_TUKIMIUDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_nikuudon              = new ItemNoodle(10,0.94f,false).setMaxStackSize(1).setRegistryName(NAME_NIKUUDON).setUnlocalizedName(NAME_NIKUUDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_meetramen             = new ItemNoodle(10,0.94f,false).setMaxStackSize(1).setRegistryName(NAME_MEETRAMEN).setUnlocalizedName(NAME_MEETRAMEN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_fishramen             = new ItemNoodle(10,0.6f,false).setMaxStackSize(1).setRegistryName(NAME_FISHRAMEN).setUnlocalizedName( NAME_FISHRAMEN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_tsukimiramen          = new ItemNoodle(10,0.31f,false).setRegistryName(NAME_EGGRAMEN).setUnlocalizedName(NAME_EGGRAMEN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_millbeef              = new Item().setRegistryName(NAME_MEETMILL_BEEF).setUnlocalizedName(NAME_MEETMILL_BEEF).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_millpoke              = new Item().setRegistryName(NAME_MEETMILL_POKE).setUnlocalizedName(NAME_MEETMILL_POKE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_millchikin            = new Item().setRegistryName(NAME_MEETMILL_CHIKIN).setUnlocalizedName(NAME_MEETMILL_CHIKIN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
		item_millmutton            = new Item().setRegistryName(NAME_MEETMILL_MUTTON).setUnlocalizedName(NAME_MEETMILL_MUTTON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);

		item_dustflower            = new ItemFlowerDust().setRegistryName(NAME_DUST_FLOWER).setUnlocalizedName(NAME_DUST_FLOWER).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setHasSubtypes(true);
		item_teaflower             = new ItemFlowerTea().setRegistryName(NAME_TEA_FLOWER).setUnlocalizedName(NAME_TEA_FLOWER).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setHasSubtypes(true);

		item_debug             = new ItemDebugFood(-20,-20,false).setRegistryName(NAME_DEBUG_ITEM).setUnlocalizedName(NAME_DEBUG_ITEM).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	}


	public static Map<String,Item> itemMap(){
		return (new HashMap<String,Item>(){
			{put(NAME_ICEFOOD_BOWL,item_icefoodbowl);}
			{put(NAME_CHOCO, item_choco);}
			{put(NAME_WHITECHOCO, item_whitechoco);}
			{put(NAME_CARAMEL, item_caramel);}
			{put(NAME_PUDDING, item_pudding);}
			{put(NAME_PUMPKINPUDDING, item_pumpkinpudding);}
			{put(NAME_PIECEPIE, item_piecepie);}
			{put(NAME_PIECECARAMELPIE, item_piececaramelpie);}
			{put(NAME_PIECECHOCOPIE, item_piecechocopie);}
			{put(NAME_PIECESALADAPIE, item_piecesaladapie);}
			{put(NAME_PIECEMEETPIE, item_piecemeetpie);}
			{put(NAME_PIECEFISHPIE, item_piecefishpie);}
			{put(NAME_PIECEPUMPUKINPIE, item_piecepumpukinpie);}
			{put(NAME_PIECEAPPLEPIE, item_pieceapplepie);}
			{put(NAME_PIECEblackPIE, item_pieceblackpie);}
			{put(NAME_PIECEZOMBIPIE, item_piecezombipie);}
			{put(NAME_POTATOSALADA, item_potatosalada);}
			{put(NAME_PUMPKINSALDADA, item_pumpkinsalada);}
			{put(NAME_EGGSANDWICH, item_eggsandwich);}
			{put(NAME_POTATSALADASANDWITCH, item_potatsaladasandwitch);}
			{put(NAME_HAMSANDWICH, item_hamsandwich);}
			{put(NAME_MUTTONSANDWICH, item_muttonsandwich);}
			{put(NAME_STAKESANDWICH, item_stakesandwich);}
			{put(NAME_CHIKENSANDWICH, item_chikensandwich);}
			{put(NAME_CHOCOSANDWICH, item_chocosandwich);}
			{put(NAME_PUMPKINSALADASANDWICH, item_pumpkinsaladasandwich);}
			{put(NAME_BUTTER, item_butter);}
			{put(NAME_RENNET, item_rennet);}
			{put(NAME_SALT, item_salt);}
			{put(NAME_MOLD, item_mold);}
			{put(NAME_BLUEMOLD, item_bluemold);}

			{put(NAME_ROW_PIE_HALL,item_row_hallpie);}
			{put(NAME_ROW_CHOCOPIE_HALL,item_row_chocohallpie);}
			{put(NAME_ROW_SALADA_HALL,item_row_saladahallpie);}
			{put(NAME_ROW_MEETPIE_HALL,item_row_meethallpie);}
			{put(NAME_ROW_FISHPIE_HALL,item_row_fishhallpie);}
			{put(NAME_ROW_PUMPKINPIE_HALL,item_row_pumpkinhallpie);}
			{put(NAME_ROW_APPLEPIE_HALL,item_row_applehallpie);}
			{put(NAME_ROW_BLACK_PIE,item_row_blackpie);}
			{put(NAME_ROW_ZOMBIPEI_HALL,item_row_zombihallpie);}
			{put(NAME_ROW_PIZZA,item_row_pizza);}
			{put(NAME_ROW_MEETPIZZA,item_row_meetpizza);}
			{put(NAME_ROW_FISHPIZZA,item_row_fishpizza);}

			{put(NAME_ICE_MIX,item_icemix);}
			{put(NAME_ICECREAM, item_icecream);}
			{put(NAME_ICECREAM_COOKIE, item_icecreamcookie);}
			{put(NAME_SYRUP,item_syrup);}
			{put(NAME_SUGARMILK,item_sugarmilk);}
			{put(NAME_SYRUP_MILK,item_syrupmilk);}
			{put(NAME_CRASHEDICE,item_crashedice);}
			{put(NAME_CRASHEDICE_MILK,item_milkcrashedice);}
			{put(NAME_SUGAR_WATER,item_sugarwater);}
			{put(NAME_ICECANDY,item_icecandy);}

			{put(NAME_FLOUR,item_flour);}
			{put(NAME_UDON,item_udon);}
			{put(NAME_PASTA,item_pasta);}
			{put(NAME_LAMEN,item_ramen);}
			{put(NAME_MEET_PASTA,item_meetpasta);}
			{put(NAME_FISH_PASTA,item_fishpasta);}
			{put(NAME_BLACK_PASTA,item_blackpasta);}
			{put(NAME_ZARUUDON,item_zaruudon);}
			{put(NAME_KAKEUDON,item_kakeudon);}
			{put(NAME_TUKIMIUDON,item_tsukimiuudon);}
			{put(NAME_NIKUUDON,item_nikuudon);}
			{put(NAME_MEETRAMEN,item_meetramen);}
			{put(NAME_FISHRAMEN,item_fishramen);}
			{put(NAME_EGGRAMEN,item_tsukimiramen);}
			{put(NAME_MEETMILL_BEEF,item_millbeef);}
			{put(NAME_MEETMILL_POKE,item_millpoke);}
			{put(NAME_MEETMILL_CHIKIN,item_millchikin);}
			{put(NAME_MEETMILL_MUTTON,item_millmutton);}

			{put(NAME_DUST_FLOWER,item_dustflower);}
			{put(NAME_TEA_FLOWER,item_teaflower);}
			{put(NAME_DEBUG_ITEM,item_debug);}
		});
	}

	public static Map<String,ModelResourceLocation[]> resourceMap(){
		return (new HashMap<String,ModelResourceLocation[]>(){
			{put(NAME_ICEFOOD_BOWL,new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICEFOOD_BOWL, "inventory")});}
			{put(NAME_CHOCO, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_CHOCO, "inventory")});}
			{put(NAME_WHITECHOCO, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_WHITECHOCO, "inventory")});}
			{put(NAME_CARAMEL, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_CARAMEL, "inventory")});}
			{put(NAME_PUDDING, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PUDDING, "inventory")});}
			{put(NAME_PUMPKINPUDDING, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PUMPKINPUDDING, "inventory")});}
			{put(NAME_PIECEPIE, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PIECEPIE, "inventory")});}
			{put(NAME_PIECECHOCOPIE, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PIECECHOCOPIE, "inventory")});}
			{put(NAME_PIECESALADAPIE, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PIECESALADAPIE, "inventory")});}
			{put(NAME_PIECEMEETPIE, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PIECEMEETPIE, "inventory")});}
			{put(NAME_PIECEFISHPIE, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PIECEFISHPIE, "inventory")});}
			{put(NAME_PIECEPUMPUKINPIE, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PIECEPUMPUKINPIE, "inventory")});}
			{put(NAME_PIECEZOMBIPIE, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PIECEZOMBIPIE, "inventory")});}
			{put(NAME_PIECEAPPLEPIE, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PIECEAPPLEPIE, "inventory")});}
			{put(NAME_PIECEblackPIE, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PIECEblackPIE, "inventory")});}
			{put(NAME_PIECECARAMELPIE, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PIECECARAMELPIE, "inventory")});}
			{put(NAME_EGGSANDWICH, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_EGGSANDWICH, "inventory")});}
			{put(NAME_POTATSALADASANDWITCH, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_POTATSALADASANDWITCH, "inventory")});}
			{put(NAME_HAMSANDWICH, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_HAMSANDWICH, "inventory")});}
			{put(NAME_MUTTONSANDWICH, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_MUTTONSANDWICH, "inventory")});}
			{put(NAME_STAKESANDWICH, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_STAKESANDWICH, "inventory")});}
			{put(NAME_CHIKENSANDWICH, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_CHIKENSANDWICH, "inventory")});}
			{put(NAME_CHOCOSANDWICH, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_CHOCOSANDWICH, "inventory")});}
			{put(NAME_PUMPKINSALADASANDWICH, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PUMPKINSALADASANDWICH, "inventory")});}
			{put(NAME_POTATOSALADA, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_POTATOSALADA, "inventory")});}
			{put(NAME_PUMPKINSALDADA, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PUMPKINSALDADA, "inventory")});}
			{put(NAME_RENNET, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_RENNET, "inventory")});}
			{put(NAME_BUTTER, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_BUTTER, "inventory")});}
			{put(NAME_SALT, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SALT, "inventory")});}
			{put(NAME_MOLD, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_MOLD, "inventory")});}
			{put(NAME_BLUEMOLD, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_BLUEMOLD, "inventory")});}
			{put(NAME_ROW_PIE_HALL, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ROW_PIE_HALL,"inventory")});}
			{put(NAME_ROW_CHOCOPIE_HALL, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ROW_CHOCOPIE_HALL, "inventory")});}
			{put(NAME_ROW_SALADA_HALL, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ROW_SALADA_HALL, "inventory")});}
			{put(NAME_ROW_MEETPIE_HALL, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ROW_MEETPIE_HALL, "inventory")});}
			{put(NAME_ROW_FISHPIE_HALL, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ROW_FISHPIE_HALL, "inventory")});}
			{put(NAME_ROW_PUMPKINPIE_HALL, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ROW_PUMPKINPIE_HALL, "inventory")});}
			{put(NAME_ROW_APPLEPIE_HALL, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ROW_APPLEPIE_HALL, "inventory")});}
			{put(NAME_ROW_BLACK_PIE, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ROW_BLACK_PIE, "inventory")});}
			{put(NAME_ROW_ZOMBIPEI_HALL, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ROW_ZOMBIPEI_HALL, "inventory")});}
			{put(NAME_ROW_PIZZA, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ROW_PIZZA, "inventory")});}
			{put(NAME_ROW_MEETPIZZA, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ROW_MEETPIZZA, "inventory")});}
			{put(NAME_ROW_FISHPIZZA, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ROW_FISHPIZZA, "inventory")});}

			{
				ModelResourceLocation[] value = new ModelResourceLocation[EnumIceFlavor.values().length];
				for (int i = 0; i < EnumIceFlavor.values.length; i++){
					value[i] = new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICE_MIX + "_" + EnumIceFlavor.values[i].getFlavor(), "inventory");
				}
				put(NAME_ICE_MIX, value);
			}

			{
				ModelResourceLocation[] value = new ModelResourceLocation[EnumIceFlavor.values().length];
				for (int i = 0; i < EnumIceFlavor.values.length; i++){
					value[i] = new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECREAM + "_" + EnumIceFlavor.values[i].getFlavor(), "inventory");
				}
				put(NAME_ICECREAM, value);
			}

			{
				ModelResourceLocation[] value = new ModelResourceLocation[EnumIceFlavor.values().length];
				for (int i = 0; i < EnumIceFlavor.values.length; i++){
					value[i] = new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECREAM_COOKIE + "_" + EnumIceFlavor.values[i].getFlavor(), "inventory");
				}
				put(NAME_ICECREAM_COOKIE, value);
			}
			{
				// かき氷
				ModelResourceLocation[]  value = new ModelResourceLocation[EnumFlapeSyrup.values.length];
				for (int i = 0; i < EnumFlapeSyrup.values.length; i++){
					value[i] = new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_CRASHEDICE + "_" + EnumFlapeSyrup.values[i] .getFlavor(), "inventory");
				}
				put(NAME_CRASHEDICE, value);
			}
			{
				ModelResourceLocation[]  value = new ModelResourceLocation[EnumFlapeSyrup.values.length];
				for (int i = 0; i < EnumFlapeSyrup.values.length; i++){
					value[i] = new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.values[i] .getFlavor(), "inventory");
				}
				put(NAME_SYRUP, value);
			}
			{
				// 練乳かき氷
				ModelResourceLocation[] value = new ModelResourceLocation[EnumFlapeSyrup.values.length];
				for (int i = 0; i < EnumFlapeSyrup.values.length; i++){
					value[i] = new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_CRASHEDICE_MILK + "_" + EnumFlapeSyrup.values[i] .getFlavor(), "inventory");
				}
				put(NAME_CRASHEDICE_MILK, value);
			}
			{
				// アイスキャンディの素
				ModelResourceLocation[] value = new ModelResourceLocation[EnumFlapeSyrup.values.length];
				for (int i = 0; i < EnumFlapeSyrup.values.length; i++){
					value[i] = new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.values[i] .getFlavor(), "inventory");
				}
				put(NAME_SUGAR_WATER, value);
			}
			{
				// アイスキャンディ
				ModelResourceLocation[] value = new ModelResourceLocation[EnumFlapeSyrup.values.length];
				for (int i = 0; i < EnumFlapeSyrup.values.length; i++){
					value[i] = new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.values[i] .getFlavor(), "inventory");
				}
				put(NAME_ICECANDY, value);
			}

			{put(NAME_SUGARMILK, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGARMILK, "inventory")});}
			{put(NAME_SYRUP_MILK, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP_MILK, "inventory")});}

			{put(NAME_FLOUR, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_FLOUR, "inventory")});}
			{put(NAME_UDON, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_UDON, "inventory")});}
			{put(NAME_PASTA, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PASTA, "inventory")});}
			{put(NAME_LAMEN, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_LAMEN, "inventory")});}
			{put(NAME_MEET_PASTA, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_MEET_PASTA, "inventory")});}
			{put(NAME_FISH_PASTA, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_FISH_PASTA, "inventory")});}
			{put(NAME_BLACK_PASTA, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_BLACK_PASTA, "inventory")});}
			{put(NAME_ZARUUDON, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_ZARUUDON, "inventory")});}
			{put(NAME_KAKEUDON, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_KAKEUDON, "inventory")});}
			{put(NAME_TUKIMIUDON, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_TUKIMIUDON, "inventory")});}
			{put(NAME_NIKUUDON, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_NIKUUDON, "inventory")});}
			{put(NAME_MEETRAMEN, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_MEETRAMEN, "inventory")});}
			{put(NAME_FISHRAMEN, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_FISHRAMEN, "inventory")});}
			{put(NAME_EGGRAMEN, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_EGGRAMEN, "inventory")});}
			{put(NAME_MEETMILL_BEEF, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_MEETMILL_BEEF, "inventory")});}
			{put(NAME_MEETMILL_POKE, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_MEETMILL_POKE, "inventory")});}
			{put(NAME_MEETMILL_CHIKIN, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_MEETMILL_CHIKIN, "inventory")});}
			{put(NAME_MEETMILL_MUTTON, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_MEETMILL_MUTTON, "inventory")});}

			{put(NAME_DUST_FLOWER,new ModelResourceLocation[]{
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_DUST_FLOWER + "_" + EnumFlowerHalb.DANDELION.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_DUST_FLOWER + "_" + EnumFlowerHalb.POPY.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_DUST_FLOWER + "_" + EnumFlowerHalb.ORCHID.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_DUST_FLOWER + "_" + EnumFlowerHalb.ALLIUM.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_DUST_FLOWER + "_" + EnumFlowerHalb.AZUREBLUET.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_DUST_FLOWER + "_" + EnumFlowerHalb.TULIP.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_DUST_FLOWER + "_" + EnumFlowerHalb.OXEYDAISY.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_DUST_FLOWER + "_" + EnumFlowerHalb.SUNFLOWER.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_DUST_FLOWER + "_" + EnumFlowerHalb.LILAC.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_DUST_FLOWER + "_" + EnumFlowerHalb.ROSE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_DUST_FLOWER + "_" + EnumFlowerHalb.PEONY.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_DUST_FLOWER + "_" + EnumFlowerHalb.PANACEA.getFlavor(), "inventory")});}

			{put(NAME_TEA_FLOWER,new ModelResourceLocation[]{
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_TEA_FLOWER + "_" + EnumFlowerHalb.DANDELION.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_TEA_FLOWER + "_" + EnumFlowerHalb.POPY.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_TEA_FLOWER + "_" + EnumFlowerHalb.ORCHID.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_TEA_FLOWER + "_" + EnumFlowerHalb.ALLIUM.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_TEA_FLOWER + "_" + EnumFlowerHalb.AZUREBLUET.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_TEA_FLOWER + "_" + EnumFlowerHalb.TULIP.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_TEA_FLOWER + "_" + EnumFlowerHalb.OXEYDAISY.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_TEA_FLOWER + "_" + EnumFlowerHalb.SUNFLOWER.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_TEA_FLOWER + "_" + EnumFlowerHalb.LILAC.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_TEA_FLOWER + "_" + EnumFlowerHalb.ROSE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_TEA_FLOWER + "_" + EnumFlowerHalb.PEONY.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_TEA_FLOWER + "_" + EnumFlowerHalb.PANACEA.getFlavor(), "inventory")});}
			{put(NAME_DEBUG_ITEM, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_DEBUG_ITEM, "inventory")});}

		});
	}

	public static enum EnumIceFlavor{
		ICE_VANILA    (0,"vanila",2,0.5F,null,new ItemStack[]{ItemStack.EMPTY}),
		ICE_BLACK     (EnumDyeColor.BLACK.getDyeDamage()+1,     EnumDyeColor.BLACK.toString(),      2,0.25F, null, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.BLACK.getDyeDamage())}),
		ICE_RED       (EnumDyeColor.RED.getDyeDamage()+1,       EnumDyeColor.RED.toString(),        2,0.25F, null, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.RED.getDyeDamage())}),
		ICE_GREEN     (EnumDyeColor.GREEN.getDyeDamage()+1,     EnumDyeColor.GREEN.toString(),      2,0.25F, null, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.GREEN.getDyeDamage())}),
		ICE_BROWN     (EnumDyeColor.BROWN.getDyeDamage()+1,     EnumDyeColor.BROWN.toString(),      2,0.25F, null, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.BROWN.getDyeDamage())}),
		ICE_BLUE      (EnumDyeColor.BLUE.getDyeDamage()+1,      EnumDyeColor.BLUE.toString(),       2,0.25F, null, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.BLUE.getDyeDamage())}),
		ICE_PURPLE    (EnumDyeColor.PURPLE.getDyeDamage()+1,    EnumDyeColor.PURPLE.toString(),     2,0.25F, null, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.PURPLE.getDyeDamage())}),
		ICE_CYAN      (EnumDyeColor.CYAN.getDyeDamage()+1,      EnumDyeColor.CYAN.toString(),       2,0.25F, null, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.CYAN.getDyeDamage())}),
		ICE_SILVER    (EnumDyeColor.SILVER.getDyeDamage()+1,    EnumDyeColor.SILVER.toString(),     2,0.25F, null, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.SILVER.getDyeDamage())}),
		ICE_GRAY      (EnumDyeColor.GRAY.getDyeDamage()+1,      EnumDyeColor.GRAY.toString(),       2,0.25F, null, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.GRAY.getDyeDamage())}),
		ICE_PINK      (EnumDyeColor.PINK.getDyeDamage()+1,      EnumDyeColor.PINK.toString(),       2,0.25F, null, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.PINK.getDyeDamage())}),
		ICE_LIME      (EnumDyeColor.LIME.getDyeDamage()+1,      EnumDyeColor.LIME.toString(),       2,0.25F, null, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.LIME.getDyeDamage())}),
		ICE_YELLOW    (EnumDyeColor.YELLOW.getDyeDamage()+1,    EnumDyeColor.YELLOW.toString(),     2,0.25F, null, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.YELLOW.getDyeDamage())}),
		ICE_LIGHT_BLUE(EnumDyeColor.LIGHT_BLUE.getDyeDamage()+1,EnumDyeColor.LIGHT_BLUE.toString(), 2,0.25F, null, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.LIGHT_BLUE.getDyeDamage())}),
		ICE_MAGENTA   (EnumDyeColor.MAGENTA.getDyeDamage()+1,   EnumDyeColor.MAGENTA.toString(),    2,0.25F, null, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.MAGENTA.getDyeDamage())}),
		ICE_ORANGE    (EnumDyeColor.ORANGE.getDyeDamage()+1,    EnumDyeColor.ORANGE.toString(),     2,0.25F, null, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.ORANGE.getDyeDamage())}),
		ICE_WHITE     (EnumDyeColor.WHITE.getDyeDamage()+1,     EnumDyeColor.WHITE.toString(),      2,0.25F, null, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.WHITE.getDyeDamage())}),
		ICE_APPLE     (EnumDyeColor.WHITE.getDyeDamage()+2,     "apple",                            2,0.25F, null, new ItemStack[]{new ItemStack(Items.APPLE,1)}),
		ICE_CACTUS    (EnumDyeColor.WHITE.getDyeDamage()+3,     "cactus",                           2,0.25F, null, new ItemStack[]{new ItemStack(Blocks.CACTUS,1)}),
		ICE_PUMPKIN   (EnumDyeColor.WHITE.getDyeDamage()+4,     "pumpkin",                          2,0.25F, null, new ItemStack[]{new ItemStack(Blocks.PUMPKIN,1)}),
		ICE_POTATO    (EnumDyeColor.WHITE.getDyeDamage()+5,     "potato",                           2,0.25F, null, new ItemStack[]{new ItemStack(Items.POTATO,1)}),
		ICE_CARROT    (EnumDyeColor.WHITE.getDyeDamage()+6,     "carrot",                           2,0.25F, null, new ItemStack[]{new ItemStack(Items.CARROT,1)}),
		ICE_MELLON    (EnumDyeColor.WHITE.getDyeDamage()+7,     "mellon",                           2,0.25F, null, new ItemStack[]{new ItemStack(Items.MELON,1), new ItemStack(Blocks.MELON_BLOCK,1)}),
		ICE_GREENTEA  (EnumDyeColor.WHITE.getDyeDamage()+8,     "greentea",                         2,0.25F, null, new ItemStack[]{
				new ItemStack(Blocks.LEAVES,1,BlockPlanks.EnumType.OAK.getMetadata()),
				new ItemStack(Blocks.LEAVES,1,BlockPlanks.EnumType.SPRUCE.getMetadata()),
				new ItemStack(Blocks.LEAVES,1,BlockPlanks.EnumType.BIRCH.getMetadata()),
				new ItemStack(Blocks.LEAVES,1,BlockPlanks.EnumType.JUNGLE.getMetadata()),
				new ItemStack(Blocks.LEAVES2,1,BlockPlanks.EnumType.ACACIA.getMetadata()-4),
				new ItemStack(Blocks.LEAVES2,1,BlockPlanks.EnumType.DARK_OAK.getMetadata()-4),});

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

		public static final EnumIceFlavor[] values = {ICE_VANILA,ICE_BLACK,ICE_RED,ICE_GREEN,ICE_BROWN,ICE_BLUE,ICE_PURPLE,ICE_CYAN,ICE_SILVER,ICE_GRAY,ICE_PINK,ICE_LIME,ICE_YELLOW,ICE_LIGHT_BLUE,ICE_MAGENTA,ICE_ORANGE,ICE_WHITE,ICE_APPLE,ICE_CACTUS,ICE_PUMPKIN,ICE_POTATO,ICE_CARROT,ICE_MELLON,ICE_GREENTEA};

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
		SYRUP_NONE      (0,                                       "none",                             1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{ItemStack.EMPTY}),
		SYRUP_SUGAR     (1,                                       "sugar",                            1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{ItemStack.EMPTY}),
		SYRUP_BLACK     (EnumDyeColor.BLACK.getDyeDamage()+2,     EnumDyeColor.BLACK.toString(),      1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.BLACK.getDyeDamage())}),
		SYRUP_RED       (EnumDyeColor.RED.getDyeDamage()+2,       EnumDyeColor.RED.toString(),        1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.RED.getDyeDamage())}),
		SYRUP_GREEN     (EnumDyeColor.GREEN.getDyeDamage()+2,     EnumDyeColor.GREEN.toString(),      1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.GREEN.getDyeDamage())}),
		SYRUP_BROWN     (EnumDyeColor.BROWN.getDyeDamage()+2,     EnumDyeColor.BROWN.toString(),      1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.BROWN.getDyeDamage())}),
		SYRUP_BLUE      (EnumDyeColor.BLUE.getDyeDamage()+2,      EnumDyeColor.BLUE.toString(),       1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.BLUE.getDyeDamage())}),
		SYRUP_PURPLE    (EnumDyeColor.PURPLE.getDyeDamage()+2,    EnumDyeColor.PURPLE.toString(),     1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.PURPLE.getDyeDamage())}),
		SYRUP_CYAN      (EnumDyeColor.CYAN.getDyeDamage()+2,      EnumDyeColor.CYAN.toString(),       1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.CYAN.getDyeDamage())}),
		SYRUP_SILVER    (EnumDyeColor.SILVER.getDyeDamage()+2,    EnumDyeColor.SILVER.toString(),     1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.SILVER.getDyeDamage())}),
		SYRUP_GRAY      (EnumDyeColor.GRAY.getDyeDamage()+2,      EnumDyeColor.GRAY.toString(),       1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.GRAY.getDyeDamage())}),
		SYRUP_PINK      (EnumDyeColor.PINK.getDyeDamage()+2,      EnumDyeColor.PINK.toString(),       1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.PINK.getDyeDamage())}),
		SYRUP_LIME      (EnumDyeColor.LIME.getDyeDamage()+2,      EnumDyeColor.LIME.toString(),       1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.LIME.getDyeDamage())}),
		SYRUP_YELLOW    (EnumDyeColor.YELLOW.getDyeDamage()+2,    EnumDyeColor.YELLOW.toString(),     1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.YELLOW.getDyeDamage())}),
		SYRUP_LIGHT_BLUE(EnumDyeColor.LIGHT_BLUE.getDyeDamage()+2,EnumDyeColor.LIGHT_BLUE.toString(), 1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.LIGHT_BLUE.getDyeDamage())}),
		SYRUP_MAGENTA   (EnumDyeColor.MAGENTA.getDyeDamage()+2,   EnumDyeColor.MAGENTA.toString(),    1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.MAGENTA.getDyeDamage())}),
		SYRUP_ORANGE    (EnumDyeColor.ORANGE.getDyeDamage()+2,    EnumDyeColor.ORANGE.toString(),     1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.ORANGE.getDyeDamage())}),
		SYRUP_WHITE     (EnumDyeColor.WHITE.getDyeDamage()+2,     EnumDyeColor.WHITE.toString(),      1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.DYE,1,EnumDyeColor.WHITE.getDyeDamage())}),
		SYRUP_APPLE     (EnumDyeColor.WHITE.getDyeDamage()+3,     "apple",                            1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.APPLE,1)}),
		SYRUP_CACTUS    (EnumDyeColor.WHITE.getDyeDamage()+4,     "cactus",                           1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Blocks.CACTUS,1)}),
		SYRUP_MELLON    (EnumDyeColor.WHITE.getDyeDamage()+5,     "wmellon",                          1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Items.MELON,1), new ItemStack(Blocks.MELON_BLOCK,1)}),
		SYRUP_PUMPKIN   (EnumDyeColor.WHITE.getDyeDamage()+6,     "pumpkin",                          1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{new ItemStack(Blocks.PUMPKIN,1)}),
		SYRUP_GREENTEA  (EnumDyeColor.WHITE.getDyeDamage()+7,     "greentea",                         1,0.0F, new PotionEffect[]{new PotionEffect(MobEffects.FIRE_RESISTANCE,600,1)}, new ItemStack[]{
				new ItemStack(Blocks.LEAVES,1,BlockPlanks.EnumType.OAK.getMetadata()),
				new ItemStack(Blocks.LEAVES,1,BlockPlanks.EnumType.SPRUCE.getMetadata()),
				new ItemStack(Blocks.LEAVES,1,BlockPlanks.EnumType.BIRCH.getMetadata()),
				new ItemStack(Blocks.LEAVES,1,BlockPlanks.EnumType.JUNGLE.getMetadata()),
				new ItemStack(Blocks.LEAVES2,1,BlockPlanks.EnumType.ACACIA.getMetadata()-4),
				new ItemStack(Blocks.LEAVES2,1,BlockPlanks.EnumType.DARK_OAK.getMetadata()-4),});
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
				SYRUP_LIGHT_BLUE,SYRUP_MAGENTA,SYRUP_ORANGE,SYRUP_WHITE,SYRUP_APPLE,SYRUP_CACTUS,SYRUP_MELLON,SYRUP_PUMPKIN,SYRUP_GREENTEA,};

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
}
