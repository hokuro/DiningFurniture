package mod.drf.foods.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mod.drf.core.ModCommon;
import mod.drf.core.Mod_DiningFurniture;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;

public class ItemFoods {
	public static final List<String> NMAE_LIST = new ArrayList<String>(){
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
		{add(NAME_SYRUP);}
		{add(NAME_SYRUP_MILK);}
		{add(NAME_FLAPE);}
		{add(NAME_MILKFLAPE);}
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
	};


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


	public static final Item item_choco                 = new ItemFood(1,0.1f,false).setUnlocalizedName(NAME_CHOCO).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_whitechoco            = new ItemFood(1,0.5f,false).setUnlocalizedName(NAME_WHITECHOCO).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_caramel               = new ItemFood(1,0.05f,false).setUnlocalizedName(NAME_CARAMEL).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_pudding               = new ItemFood(2,0.28f,false).setUnlocalizedName(NAME_PUDDING).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_pumpkinpudding        = new ItemFood(2,1.48f,false).setUnlocalizedName(NAME_PUMPKINPUDDING).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_piecepie              = new ItemFood(4,0.14f,false).setUnlocalizedName(NAME_PIECEPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_piecechocopie         = new ItemFood(2,0.1f,false).setUnlocalizedName(NAME_PIECECHOCOPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_piecesaladapie        = new ItemFood(6,0.27f,false).setUnlocalizedName(NAME_PIECESALADAPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_piecemeetpie          = new ItemFood(8,0.34f,false).setUnlocalizedName(NAME_PIECEMEETPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_piecefishpie          = new ItemFood(8,0.2f,false).setUnlocalizedName(NAME_PIECEFISHPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_piecepumpukinpie      = new ItemFood(6,0.23f,false).setUnlocalizedName(NAME_PIECEPUMPUKINPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_piecezombipie         = new ItemFood(2,0.28f,false).setPotionEffect(new PotionEffect(MobEffects.hunger,600,0),100.0F).setUnlocalizedName(NAME_PIECEZOMBIPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_pieceapplepie         = new ItemFood(4,0.19f,false).setUnlocalizedName(NAME_PIECEAPPLEPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_pieceblackpie         = new ItemFood(4,0.14f,false).setUnlocalizedName(NAME_PIECEblackPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_piececaramelpie       = new ItemFood(4,0.14f,false).setUnlocalizedName(NAME_PIECECARAMELPIE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_eggsandwich           = new ItemFood(6,0.18f,false).setUnlocalizedName(NAME_EGGSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_potatsaladasandwitch  = new ItemFood(6,0.52f,false).setUnlocalizedName(NAME_POTATSALADASANDWITCH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_hamsandwich           = new ItemFood(8,0.53f,false).setUnlocalizedName(NAME_HAMSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_muttonsandwich        = new ItemFood(8,0.53f,false).setUnlocalizedName(NAME_MUTTONSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_stakesandwich         = new ItemFood(8,0.53f,false).setUnlocalizedName(NAME_STAKESANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_chikensandwich        = new ItemFood(8,0.35f,false).setUnlocalizedName(NAME_CHIKENSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_chocosandwich         = new ItemFood(4,0.25f,false).setUnlocalizedName(NAME_CHOCOSANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_pumpkinsaladasandwich = new ItemFood(6,0.41f,false).setUnlocalizedName(NAME_PUMPKINSALADASANDWICH).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_potatosalada          = new ItemSalada(8,1.6f,false).setUnlocalizedName(NAME_POTATOSALADA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_pumpkinsalada         = new ItemSalada(8,1.11f,false).setUnlocalizedName(NAME_PUMPKINSALDADA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
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

	public static final Item item_icemix                = new ItemIceCreamMix().setUnlocalizedName(NAME_ICE_MIX).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
	public static final Item item_icecream              = new ItemIceCream(0,0,false).setUnlocalizedName(NAME_ICECREAM).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
	public static final Item item_syrup                 = new ItemSyrup().setUnlocalizedName(NAME_SYRUP).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
	public static final Item item_syrupmilk             = new Item().setUnlocalizedName(NAME_SYRUP_MILK).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_flape                 = new ItemFlap(0,0,false).setPotionEffect(new PotionEffect(MobEffects.confusion,100,1), 25.0F).setUnlocalizedName(NAME_FLAPE).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_milkflape             = new ItemFlap(0,0,false).setPotionEffect(new PotionEffect(MobEffects.confusion,100,1), 25.0F).setUnlocalizedName(NAME_MILKFLAPE).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_sugarwater            = new ItemSyrup().setUnlocalizedName(NAME_SUGAR_WATER).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
	public static final Item item_icecandy              = new ItemIceCandy(0,0,false).setUnlocalizedName(NAME_ICECANDY).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);

	public static final Item item_flour                 = new Item().setUnlocalizedName(NAME_FLOUR).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_udon                  = new Item().setUnlocalizedName(NAME_UDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_pasta                 = new Item().setUnlocalizedName(NAME_PASTA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_ramen                 = new Item().setUnlocalizedName(NAME_LAMEN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_meetpasta             = new ItemNoodle(10,1.58f,false).setUnlocalizedName(NAME_MEET_PASTA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_fishpasta             = new ItemNoodle(10,0.6f,false).setUnlocalizedName(NAME_FISH_PASTA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_blackpasta            = new ItemNoodle(10,0.3f,false).setUnlocalizedName(NAME_BLACK_PASTA).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_zaruudon              = new ItemNoodle(10,0.3f,false).setUnlocalizedName(NAME_ZARUUDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_kakeudon              = new ItemNoodle(10,0.3f,false).setUnlocalizedName(NAME_KAKEUDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_tsukimiuudon          = new ItemNoodle(10,0.31f,false).setUnlocalizedName(NAME_TUKIMIUDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_nikuudon              = new ItemNoodle(10,0.94f,false).setUnlocalizedName(NAME_NIKUUDON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_meetramen             = new ItemNoodle(10,0.94f,false).setUnlocalizedName(NAME_MEETRAMEN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_fishramen             = new ItemNoodle(10,0.6f,false).setUnlocalizedName( NAME_FISHRAMEN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_tsukimiramen          = new ItemNoodle(10,0.31f,false).setUnlocalizedName(NAME_EGGRAMEN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_millbeef              = new Item().setUnlocalizedName(NAME_MEETMILL_BEEF).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_millpoke              = new Item().setUnlocalizedName(NAME_MEETMILL_POKE).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_millchikin            = new Item().setUnlocalizedName(NAME_MEETMILL_CHIKIN).setCreativeTab(Mod_DiningFurniture.tabPieCakes);
	public static final Item item_millmutton            = new Item().setUnlocalizedName(NAME_MEETMILL_MUTTON).setCreativeTab(Mod_DiningFurniture.tabPieCakes);

	public static final Item item_dustflower            = new ItemFlowerDust().setUnlocalizedName(NAME_DUST_FLOWER).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setHasSubtypes(true);
	public static final Item item_teaflower             = new ItemFlowerTea().setUnlocalizedName(NAME_TEA_FLOWER).setCreativeTab(Mod_DiningFurniture.tabPieCakes).setHasSubtypes(true);

	public static Map<String,Item> itemMap(){
		return (new HashMap<String,Item>(){
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
			{put(NAME_MEETMILL_BEEF,item_millbeef);}
			{put(NAME_MEETMILL_POKE,item_millpoke);}
			{put(NAME_MEETMILL_CHIKIN,item_millchikin);}
			{put(NAME_MEETMILL_MUTTON,item_millmutton);}

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
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_APPLE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_BLACK.getFlavor(), "inventory"),
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
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_APPLE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_BLACK.getFlavor(), "inventory"),
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
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_APPLE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_BLACK.getFlavor(), "inventory"),
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
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_APPLE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_BLACK.getFlavor(), "inventory"),
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
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_APPLE.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_BLACK.getFlavor(), "inventory"),
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
		ICE_VANILA(0,"vanila",2,0.5F),
		ICE_CHOCO(1,"choco",2,0.8F),
		ICE_PUMPKIN(2,"pumpkin",2,0.8F),
		ICE_black(3,"black",2,0.8F),
		ICE_MELLON(4,"mellon",2,0.8F),
		ICE_CALLOT(5,"carrot",2,0.8F),
		ICE_POTATO(6,"potato",2,0.8F),
		ICE_APPLE(7,"apple",2,0.8F);

		private int index;
		private int damage;
		private String fravor;
		private int foodLevel;
		private float foodSaturation;
		private EnumIceFlavor(int idx, String name, int healamount, float saturation){
			index = idx;
			damage = idx;
			fravor = name;
			foodLevel = healamount;
			foodSaturation = saturation;
		}

		private static final EnumIceFlavor[] values = {ICE_VANILA,ICE_CHOCO,ICE_PUMPKIN,ICE_black,ICE_MELLON,ICE_CALLOT,ICE_POTATO,ICE_APPLE};

		public int getIndex(){return this.index;}
		public int getDamage(){return this.damage;}
		public String getFlavor(){return this.fravor;}
		public static EnumIceFlavor getValue(int index){return values[index];}
	}

	public static enum EnumFlapeSyrup{
		SYRUP_NONE(0,"none",1,0.1F,new PotionEffect[]{null}),
		SYRUP_SUGAR(1,"sugar",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,600,1)}),
		SYRUP_PUMPKIN(2,"pumpkin",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,600,1)}),
		SYRUP_CACTUS(3,"cactus",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,600,2)}),
		SYRUP_WMELLON(4,"wmellon",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,600,2),
															new PotionEffect(MobEffects.heal,0,1)}),
		SYRUP_APPLE(5,"apple",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,600,1),
														new PotionEffect(MobEffects.regeneration,200,1)}),
		SYRUP_BLACK(6,"black",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,600,1),
															new PotionEffect(MobEffects.blindness,200,1)}),
		SYRUP_STRAWBERRY(7,"strawberry",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,600,1)}),
		SYRUP_MELON(8,"mellon",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,600,1)}),
		SYRUP_CHOCOLATE(9,"choco",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,600,1)}),
		SYRUP_POTION(10,"potion",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.wither,600,5)}),
		SYRUP_BERRY(11,"berry",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,600,1)}),
		SYRUP_BLUEHAWAII(12,"bluehawaii",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,1800,5)}),
		SYRUP_COCONUT(13,"coconut",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,600,1)}),
		SYRUP_MATCHER(14,"matcher",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,600,1)}),
		SYRUP_PEACH(15,"peach",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,600,1)}),
		SYRUP_LIME(16,"lime",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,600,1)}),
		SYRUP_LEMON(17,"lemon",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,600,1)}),
		SYRUP_SODA(18,"soda",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,1200,3)}),
		SYRUP_GRAPE(19,"grape",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,600,1)}),
		SYRUP_ORANGE(20,"orange",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.fireResistance,600,1)}),
		SYRUP_CALUCIUM(21,"calucium",1,0.2F, new PotionEffect[]{new PotionEffect(MobEffects.regeneration,1200,3)});

		private int index;
		private int damage;
		private String flavor;
		private int foodLevel;
		private float foodSaturation;
		private PotionEffect[] potion;
		private EnumFlapeSyrup(int idx,String name, int healamount, float saturation, PotionEffect[] effects){
			index = idx;
			damage = idx;
			flavor = name;
			foodLevel = healamount;
			foodSaturation = saturation;
			potion = effects;
		}

		private static final EnumFlapeSyrup[] values = {SYRUP_NONE,SYRUP_SUGAR,SYRUP_PUMPKIN,
														SYRUP_CACTUS,SYRUP_WMELLON,SYRUP_APPLE,SYRUP_BLACK,SYRUP_STRAWBERRY,
														SYRUP_MELON,SYRUP_CHOCOLATE,SYRUP_POTION,SYRUP_BERRY,SYRUP_BLUEHAWAII,
														SYRUP_COCONUT,SYRUP_MATCHER,SYRUP_PEACH,SYRUP_LIME,SYRUP_LEMON,SYRUP_SODA,SYRUP_GRAPE,
														SYRUP_ORANGE,SYRUP_CALUCIUM};

		public int getIndex(){return this.index;}
		public int getDamage(){return this.damage;}
		public String getFlavor(){return this.flavor;}
		public static EnumFlapeSyrup getValue(int index){return values[index];}
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
		public static EnumFlowerHalb getValue(int index){return values[index];}
	}
}
