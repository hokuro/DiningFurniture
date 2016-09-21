package mod.drf.foods.Item;

import java.util.HashMap;
import java.util.Map;

import mod.drf.core.ModCommon;
import mod.drf.core.Mod_DiningFurniture;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;

public class ItemFoods {
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
	public static final String NAME_PIECEPIE = "pie";
//	チョコレートパイ
	public static final String NAME_PIECECHOCOPIE ="piechoco";
//	サラダパイ
	public static final String NAME_PIECESALADAPIE = "piesalada";
//	ミートパイ
	public static final String NAME_PIECEMEETPIE = "piemeet";
//	フィッシュパイ
	public static final String NAME_PIECEFISHPIE="piefish";
//	かぼちゃパイ
	public static final String NAME_PIECEPUMPUKINPIE ="piepumpkin";
//	ゾンビーフパイ
	public static final String NAME_PIECEZOMBIPIE="piezombi";
//	アップルパイ
	public static final String NAME_PIECEAPPLEPIE="pieapple";
//	烏賊墨パイ
	public static final String NAME_PIECEblackPIE="pieblack";
//	カラメルパイ
	public static final String NAME_PIECECALLAMELPIE="piecallamel";
//	卵サンド
	public static final String NAME_EGGSANDWICH="sandwitchegg";
//	ポテトサラダサンド
	public static final String NAME_POTETSALADASANDWITCH="sandwitchpotato";
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
	public static final String NAME_POTETOSALADA = "potatosalada";
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
	public static final String NAME_ICECREAM ="icecream";
	// シロップ
	public static final String NAME_SYRUP = "flapesyrup";
	// 練乳
	public static final String NAME_SYRUP_MILK = "flapesyrupmilk";
	// 練乳かき氷
	public static final String NAME_FLAPE="flape";
	// 練乳かき氷
	public static final String NAME_MILKFLAPE="flapemilk";
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
	public static final String NAME_LAMEN = "lamen";
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

	// 花の粉末
	public static final String NAME_DUST_FLOWER="flowerdust";
	// 花のお茶
	public static final String NAME_TEA_FLOWER="flowertea";


	public static final Item item_choco                 = new ItemFood(2,0.1f,false).setUnlocalizedName(NAME_CHOCO).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_whitechoco            = new ItemFood(2,0.1f,false).setUnlocalizedName(NAME_WHITECHOCO).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_caramel               = new ItemFood(2,0.1f,false).setUnlocalizedName(NAME_CARAMEL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_pudding               = new ItemFood(2,0.2f,false).setUnlocalizedName(NAME_PUDDING).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_pumpkinpudding        = new ItemFood(2,0.3f,false).setUnlocalizedName(NAME_PUMPKINPUDDING).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_piecepie              = new ItemFood(2,0.5f,false).setUnlocalizedName(NAME_PIECEPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_piecechocopie         = new ItemFood(4,0.6f,false).setUnlocalizedName(NAME_PIECECHOCOPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_piecesaladapie        = new ItemFood(4,0.6f,false).setUnlocalizedName(NAME_PIECESALADAPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_piecemeetpie          = new ItemFood(8,0.8f,false).setUnlocalizedName(NAME_PIECEMEETPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_piecefishpie          = new ItemFood(8,0.8f,false).setUnlocalizedName(NAME_PIECEFISHPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_piecepumpukinpie      = new ItemFood(4,0.6f,false).setUnlocalizedName(NAME_PIECEPUMPUKINPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_piecezombipie         = new ItemFood(2,0.1f,false).setPotionEffect(new PotionEffect(MobEffects.hunger,600,0),100.0F).setUnlocalizedName(NAME_PIECEZOMBIPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_pieceapplepie         = new ItemFood(4,0.5f,false).setUnlocalizedName(NAME_PIECEAPPLEPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_pieceblackpie         = new ItemFood(4,0.2f,false).setUnlocalizedName(NAME_PIECEblackPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_piececallamelpie      = new ItemFood(4,0.5f,false).setUnlocalizedName(NAME_PIECECALLAMELPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_eggsandwich           = new ItemFood(6,0.6f,false).setUnlocalizedName(NAME_EGGSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_potetsaladasandwitch  = new ItemFood(6,0.6f,false).setUnlocalizedName(NAME_POTETSALADASANDWITCH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_hamsandwich           = new ItemFood(8,0.6f,false).setUnlocalizedName(NAME_HAMSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_muttonsandwich        = new ItemFood(8,0.7f,false).setUnlocalizedName(NAME_MUTTONSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_stakesandwich         = new ItemFood(8,0.8f,false).setUnlocalizedName(NAME_STAKESANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_chikensandwich        = new ItemFood(8,0.7f,false).setUnlocalizedName(NAME_CHIKENSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_chocosandwich         = new ItemFood(4,0.5f,false).setUnlocalizedName(NAME_CHOCOSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_potetosalada          = new ItemFood(4,0.4f,false).setUnlocalizedName(NAME_POTETOSALADA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_pumpkinsalada         = new ItemFood(4,0.4f,false).setUnlocalizedName(NAME_PUMPKINSALDADA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_pumpkinsaladasandwich = new ItemFood(6,0.6f,false).setUnlocalizedName(NAME_PUMPKINSALADASANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_butter                = new Item().setUnlocalizedName(NAME_BUTTER).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_mold                  = new Item().setUnlocalizedName(NAME_MOLD).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_salt                  = new Item().setUnlocalizedName(NAME_SALT).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_bluemold              = new Item().setUnlocalizedName(NAME_BLUEMOLD).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_row_hallpie           = new Item().setUnlocalizedName(NAME_ROW_PIE_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_row_chocohallpie      = new Item().setUnlocalizedName(NAME_ROW_CHOCOPIE_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_row_saladahallpie     = new Item().setUnlocalizedName(NAME_ROW_SALADA_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_row_meethallpie       = new Item().setUnlocalizedName(NAME_ROW_MEETPIE_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_row_fishhallpie       = new Item().setUnlocalizedName(NAME_ROW_FISHPIE_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_row_pumpkinhallpie    = new Item().setUnlocalizedName(NAME_ROW_PUMPKINPIE_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_row_zombihallpie      = new Item().setUnlocalizedName(NAME_ROW_ZOMBIPEI_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_row_applehallpie      = new Item().setUnlocalizedName(NAME_ROW_APPLEPIE_HALL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_row_blackpie          = new Item().setUnlocalizedName(NAME_ROW_BLACK_PIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_row_pizza             = new Item().setUnlocalizedName(NAME_ROW_PIZZA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_row_meetpizza         = new Item().setUnlocalizedName(NAME_ROW_MEETPIZZA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_row_fishpizza         = new Item().setUnlocalizedName(NAME_ROW_FISHPIZZA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);

	public static final Item item_icemix                = new Item().setUnlocalizedName(NAME_ICE_MIX).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
	public static final Item item_icecream              = new ItemIcecreame(2,0.2f,false).setUnlocalizedName(NAME_ICECREAM).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
	public static final Item item_syrup                 = new Item().setUnlocalizedName(NAME_SYRUP).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
	public static final Item item_syrupmilk             = new Item().setUnlocalizedName(NAME_SYRUP_MILK).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_flape                 = new ItemFlap(1,0.1f,false).setPotionEffect(new PotionEffect(MobEffects.confusion,100,1), 25.0F).setUnlocalizedName(NAME_FLAPE).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_milkflape             = new ItemFlap(1,0.2f,false).setPotionEffect(new PotionEffect(MobEffects.confusion,100,1), 25.0F).setUnlocalizedName(NAME_MILKFLAPE).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_sugarwater            = new Item().setUnlocalizedName(NAME_SUGAR_WATER).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
	public static final Item item_icecandy              = new ItemFood(0,0.1f,false).setUnlocalizedName(NAME_ICECANDY).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);

	public static final Item item_flour                 = new Item().setUnlocalizedName(NAME_FLOUR).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_udon                  = new Item().setUnlocalizedName(NAME_UDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_pasta                 = new Item().setUnlocalizedName(NAME_PASTA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_ramen                 = new Item().setUnlocalizedName(NAME_LAMEN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_meetpasta             = new ItemFood(0,0.1f,false).setUnlocalizedName(NAME_MEET_PASTA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_fishpasta             = new ItemFood(0,0.1f,false).setUnlocalizedName(NAME_FISH_PASTA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_blackpasta            = new ItemFood(0,0.1f,false).setUnlocalizedName(NAME_BLACK_PASTA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_zaruudon              = new ItemFood(0,0.1f,false).setUnlocalizedName(NAME_ZARUUDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_kakeudon              = new ItemFood(0,0.1f,false).setUnlocalizedName(NAME_KAKEUDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_tsukimiuudon          = new ItemFood(0,0.1f,false).setUnlocalizedName(NAME_TUKIMIUDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_nikuudon              = new ItemFood(0,0.1f,false).setUnlocalizedName(NAME_NIKUUDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_meetramen             = new ItemFood(0,0.1f,false).setUnlocalizedName(NAME_MEETRAMEN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_fishramen             = new ItemFood(0,0.1f,false).setUnlocalizedName( NAME_FISHRAMEN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_tsukimiramen          = new ItemFood(0,0.1f,false).setUnlocalizedName(NAME_EGGRAMEN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);

	public static final Item item_dustflower            = new Item().setUnlocalizedName(NAME_DUST_FLOWER).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setHasSubtypes(true);
	public static final Item item_teaflower             = new Item().setUnlocalizedName(NAME_TEA_FLOWER).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setHasSubtypes(true);

	public static Map<String,Item> itemMap(){
		return (new HashMap<String,Item>(){
			{put(NAME_CHOCO, item_choco);}
			{put(NAME_WHITECHOCO, item_whitechoco);}
			{put(NAME_CARAMEL, item_caramel);}
			{put(NAME_PUDDING, item_pudding);}
			{put(NAME_PUMPKINPUDDING, item_pumpkinpudding);}
			{put(NAME_PIECEPIE, item_piecepie);}
			{put(NAME_PIECECALLAMELPIE, item_piececallamelpie);}
			{put(NAME_PIECECHOCOPIE, item_piecechocopie);}
			{put(NAME_PIECESALADAPIE, item_piecesaladapie);}
			{put(NAME_PIECEMEETPIE, item_piecemeetpie);}
			{put(NAME_PIECEFISHPIE, item_piecefishpie);}
			{put(NAME_PIECEPUMPUKINPIE, item_piecepumpukinpie);}
			{put(NAME_PIECEAPPLEPIE, item_pieceapplepie);}
			{put(NAME_PIECEblackPIE, item_pieceblackpie);}
			{put(NAME_PIECEZOMBIPIE, item_piecezombipie);}
			{put(NAME_POTETOSALADA, item_potetosalada);}
			{put(NAME_PUMPKINSALDADA, item_pumpkinsalada);}
			{put(NAME_EGGSANDWICH, item_eggsandwich);}
			{put(NAME_POTETSALADASANDWITCH, item_potetsaladasandwitch);}
			{put(NAME_HAMSANDWICH, item_hamsandwich);}
			{put(NAME_MUTTONSANDWICH, item_muttonsandwich);}
			{put(NAME_STAKESANDWICH, item_stakesandwich);}
			{put(NAME_CHIKENSANDWICH, item_chikensandwich);}
			{put(NAME_CHOCOSANDWICH, item_chocosandwich);}
			{put(NAME_PUMPKINSALADASANDWICH, item_pumpkinsaladasandwich);}
			{put(NAME_BUTTER, item_butter);}
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
			{put(NAME_SYRUP,item_syrup);}
			{put(NAME_SYRUP_MILK,item_syrupmilk);}
			{put(NAME_FLAPE,item_flape);}
			{put(NAME_MILKFLAPE,item_milkflape);}
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

			{put(NAME_DUST_FLOWER,item_dustflower);}
			{put(NAME_TEA_FLOWER,item_teaflower);}
		});
	}

	public static Map<String,ModelResourceLocation[]> resourceMap(){
		return (new HashMap<String,ModelResourceLocation[]>(){
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
			{put(NAME_PIECECALLAMELPIE, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PIECECALLAMELPIE, "inventory")});}
			{put(NAME_EGGSANDWICH, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_EGGSANDWICH, "inventory")});}
			{put(NAME_POTETSALADASANDWITCH, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_POTETSALADASANDWITCH, "inventory")});}
			{put(NAME_HAMSANDWICH, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_HAMSANDWICH, "inventory")});}
			{put(NAME_MUTTONSANDWICH, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_MUTTONSANDWICH, "inventory")});}
			{put(NAME_STAKESANDWICH, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_STAKESANDWICH, "inventory")});}
			{put(NAME_CHIKENSANDWICH, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_CHIKENSANDWICH, "inventory")});}
			{put(NAME_CHOCOSANDWICH, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_CHOCOSANDWICH, "inventory")});}
			{put(NAME_POTETOSALADA, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PUMPKINSALDADA, "inventory")});}
			{put(NAME_PUMPKINSALDADA,new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PUMPKINSALDADA, "inventory")});}
			{put(NAME_PUMPKINSALADASANDWICH, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PUMPKINSALADASANDWICH, "inventory")});}
			{put(NAME_BUTTER, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_BUTTER, "inventory")});}
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


			{put(NAME_ICE_MIX,new ModelResourceLocation[]{
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICE_MIX + "_" + EnumIceFlavor.ICE_VANILA.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICE_MIX + "_" + EnumIceFlavor.ICE_CHOCO.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICE_MIX + "_" + EnumIceFlavor.ICE_PUMPKIN.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICE_MIX + "_" + EnumIceFlavor.ICE_black.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICE_MIX + "_" + EnumIceFlavor.ICE_MELLON.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICE_MIX + "_" + EnumIceFlavor.ICE_CALLOT.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICE_MIX + "_" + EnumIceFlavor.ICE_POTATO.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICE_MIX + "_" + EnumIceFlavor.ICE_APPLE.getFlavor(), "inventory")});}
			{put(NAME_ICECREAM, new ModelResourceLocation[]{
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECREAM + "_" + EnumIceFlavor.ICE_VANILA.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECREAM + "_" + EnumIceFlavor.ICE_CHOCO.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECREAM + "_" + EnumIceFlavor.ICE_PUMPKIN.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECREAM + "_" + EnumIceFlavor.ICE_black.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECREAM + "_" + EnumIceFlavor.ICE_MELLON.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECREAM + "_" + EnumIceFlavor.ICE_CALLOT.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECREAM + "_" + EnumIceFlavor.ICE_POTATO.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECREAM + "_" + EnumIceFlavor.ICE_APPLE.getFlavor(), "inventory")});}

			{put(NAME_SYRUP,new ModelResourceLocation[]{
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_NONE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_SUGAR.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_PUMPKIN.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_CACTUS.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_WMELLON.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_black.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_STRAWBERRY.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_MELON.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_CHOCOLATE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_POTION.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_BERRY.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_BLUEHAWAII.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_COCONUT.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_MATCHER.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_PEACH.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_LIME.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_LEMON.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_SODA.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_GRAPE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_ORANGE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_CALUCIUM.getFlavor(), "inventory")});}
			{put(NAME_SYRUP_MILK, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP_MILK, "inventory")});}

			{put(NAME_FLAPE,new ModelResourceLocation[]{
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_NONE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_SUGAR.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_PUMPKIN.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_CACTUS.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_WMELLON.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_black.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_STRAWBERRY.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_MELON.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_CHOCOLATE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_POTION.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_BERRY.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_BLUEHAWAII.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_COCONUT.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_MATCHER.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_PEACH.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_LIME.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_LEMON.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_SODA.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_GRAPE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_ORANGE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_CALUCIUM.getFlavor(), "inventory")});}
			{put(NAME_MILKFLAPE,new ModelResourceLocation[]{
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_NONE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_SUGAR.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_PUMPKIN.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_CACTUS.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_WMELLON.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_black.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_STRAWBERRY.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_MELON.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_CHOCOLATE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_POTION.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_BERRY.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_BLUEHAWAII.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_COCONUT.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_MATCHER.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_PEACH.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_LIME.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_LEMON.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_SODA.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_GRAPE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_ORANGE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_CALUCIUM.getFlavor(), "inventory")});}
			{put(NAME_SUGAR_WATER,new ModelResourceLocation[]{
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_NONE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_SUGAR.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_PUMPKIN.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_CACTUS.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_WMELLON.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_black.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_STRAWBERRY.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_MELON.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_CHOCOLATE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_POTION.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_BERRY.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_BLUEHAWAII.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_COCONUT.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_MATCHER.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_PEACH.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_LIME.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_LEMON.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_SODA.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_GRAPE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_ORANGE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_CALUCIUM.getFlavor(), "inventory")});}
			{put(NAME_ICECANDY,new ModelResourceLocation[]{
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_NONE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_SUGAR.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_PUMPKIN.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_CACTUS.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_WMELLON.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_black.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_STRAWBERRY.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_MELON.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_CHOCOLATE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_POTION.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_BERRY.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_BLUEHAWAII.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_COCONUT.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_MATCHER.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_PEACH.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_LIME.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_LEMON.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_SODA.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_GRAPE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_ORANGE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_CALUCIUM.getFlavor(), "inventory")});}

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
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_DUST_FLOWER + "_" + EnumFlowerHalb.PEONY.getFlavor(), "inventory")});}

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
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_TEA_FLOWER + "_" + EnumFlowerHalb.PEONY.getFlavor(), "inventory")});}
		});
	}

	public static enum EnumIceFlavor{
		ICE_VANILA(0,"vanila"),
		ICE_CHOCO(1,"choco"),
		ICE_PUMPKIN(2,"pumpkin"),
		ICE_black(3,"black"),
		ICE_MELLON(4,"mellon"),
		ICE_CALLOT(5,"callot"),
		ICE_POTATO(6,"potato"),
		ICE_APPLE(7,"apple");

		private int index;
		private int damage;
		private String fravor;
		private EnumIceFlavor(int idx, String name){
			index = idx;
			damage = idx;
			fravor = name;
		}

		private static final EnumIceFlavor[] values = {ICE_VANILA,ICE_CHOCO,ICE_PUMPKIN,ICE_black,ICE_MELLON,ICE_CALLOT,ICE_POTATO,ICE_APPLE};

		public int getIndex(){return this.index;}
		public int getDamage(){return this.damage;}
		public String getFlavor(){return this.fravor;}
		public EnumIceFlavor getValue(int index){return values[index];}
	}

	public static enum EnumFlapeSyrup{
		SYRUP_NONE(0,""),
		SYRUP_SUGAR(1,"sugar"),
		SYRUP_PUMPKIN(2,"pumpkin"),
		SYRUP_CACTUS(3,"cactus"),
		SYRUP_WMELLON(4,"wmellon"),
		SYRUP_black(5,"black"),
		SYRUP_STRAWBERRY(6,"strawberry"),
		SYRUP_MELON(7,"melon"),
		SYRUP_CHOCOLATE(8,"choco"),
		SYRUP_POTION(9,"potion"),
		SYRUP_BERRY(10,"berry"),
		SYRUP_BLUEHAWAII(11,"bluehawaii"),
		SYRUP_COCONUT(12,"coconut"),
		SYRUP_MATCHER(13,"matcher"),
		SYRUP_PEACH(14,"peach"),
		SYRUP_LIME(15,"lime"),
		SYRUP_LEMON(16,"lemon"),
		SYRUP_SODA(17,"soda"),
		SYRUP_GRAPE(18,"grape"),
		SYRUP_ORANGE(19,"orange"),
		SYRUP_CALUCIUM(20,"calucium");

		private int index;
		private int damage;
		private String flavor;
		private EnumFlapeSyrup(int idx,String name){
			index = idx;
			damage = idx;
			flavor = name;
		}

		private static final EnumFlapeSyrup[] values = {SYRUP_NONE,SYRUP_SUGAR,SYRUP_PUMPKIN,
														SYRUP_CACTUS,SYRUP_WMELLON,SYRUP_black,SYRUP_STRAWBERRY,
														SYRUP_MELON,SYRUP_CHOCOLATE,SYRUP_POTION,SYRUP_BERRY,SYRUP_BLUEHAWAII,
														SYRUP_COCONUT,SYRUP_MATCHER,SYRUP_PEACH,SYRUP_LIME,SYRUP_LEMON,SYRUP_SODA,SYRUP_GRAPE,
														SYRUP_ORANGE,SYRUP_CALUCIUM};

		public int getIndex(){return this.index;}
		public int getDamage(){return this.damage;}
		public String getFlavor(){return this.flavor;}
		public EnumFlapeSyrup getValue(int index){return values[index];}
	}

	public static enum EnumFlowerHalb{
		DANDELION(0,0,"dandelion"),
		POPY(1,1,"popy"),
		ORCHID(2,2,"orchid"),
		ALLIUM(3,3,"allium"),
		AZUREBLUET(4,4,"azurebluet"),
		TULIP(5,5,"tulip"),
		OXEYDAISY(6,6,"oxeydaisy"),
		SUNFLOWER(7,7,"sunflower"),
		LILAC(8,8,"lilac"),
		ROSE(9,9,"rose"),
		PEONY(10,10,"peony");

		private int index;
		private int damage;
		private String flavor;
		private EnumFlowerHalb(int idx, int dmg, String flv){
			this.index = idx;
			this.damage = dmg;
			this.flavor = flv;
		}

		private static final EnumFlowerHalb[] values = {DANDELION,POPY,ORCHID,ALLIUM,AZUREBLUET,TULIP,OXEYDAISY,SUNFLOWER,LILAC,ROSE,PEONY};

		public int getIndex(){return this.index;}
		public int getDamage(){return this.damage;}
		public String getFlavor(){return this.flavor;}
		public EnumFlowerHalb getValue(int index){return values[index];}
	}
}
