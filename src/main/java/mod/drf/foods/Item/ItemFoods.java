package mod.drf.foods.Item;

import java.util.HashMap;
import java.util.Map;

import mod.drf.core.ModCommon;
import mod.drf.core.Mod_DiningFurniture;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
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
	public static final String NAME_PIECEPIE = "piecepie";
//	チョコレートパイ
	public static final String NAME_PIECECHOCOPIE ="piecechocopie";
//	サラダパイ
	public static final String NAME_PIECESALADAPIE = "piecesaladapie";
//	ミートパイ
	public static final String NAME_PIECEMEETPIE = "piecemeetpie";
//	フィッシュパイ
	public static final String NAME_PIECEFISHPIE="piecefishpie";
//	かぼちゃパイ
	public static final String NAME_PIECEPUMPUKINPIE ="piecepumpukinpie";
//	ゾンビーフパイ
	public static final String NAME_PIECEZOMBIPIE="piecezmbipie";
//	アップルパイ
	public static final String NAME_PIECEAPPLEPIE="pieceapplepie";
//	烏賊墨パイ
	public static final String NAME_PIECEBLUCKPIE="piecebluckpie";
//	カラメルパイ
	public static final String NAME_PIECECALLAMELPIE="piececallamelpie";
//	卵サンド
	public static final String NAME_EGGSANDWICH="eggsandwich";
//	ポテトサラダサンド
	public static final String NAME_POTETSALADASANDWITCH="potetsandwitch";
//	ハムサンド
	public static final String NAME_HAMSANDWICH="hamsandwich";
//	ジンギスカンサンド
	public static final String NAME_MUTTONSANDWICH="muttonsandwich";
//	ステーキサンド
	public static final String NAME_STAKESANDWICH="stakesandwich";
//	てりやきサンド
	public static final String NAME_CHIKENSANDWICH="chikensandwich";
//	チョコサンド
	public static final String NAME_CHOCOSANDWICH="chocosandwich";
//	ポテトサラダ
	public static final String NAME_POTETOSALADA = "potetosalada";
//	パンプキンサラダ
	public static final String NAME_PUMPKINSALDADA = "pumpukinsalada";
//	パンプキンサラダサンド
	public static final String NAME_PUMPKINSALADASANDWICH ="pumpukinsaladasandwich";
//	バター
	public static final String NAME_BUTTER = "butter";
	// カビ
	public static final String NAME_MOLD = "modl";
	// 青カビ
	public static final String NAME_BLUEMOLD = "bluemold";
	// パイ
	public static final String NAME_ROW_PIE_HALL = "row_hallpie";
	// チョコパイ
	public static final String NAME_ROW_CHOCOPIE_HALL = "row_chocohallpie";
	// 野菜パイ
	public static final String NAME_ROW_SALADA_HALL = "row_saladahallpie";
	// ミートパイ
	public static final String NAME_ROW_MEETPIE_HALL = "row_meethallpie";
	// 魚パイ
	public static final String NAME_ROW_FISHPIE_HALL = "row_fishhallpie";
	// かぼちゃパイ
	public static final String NAME_ROW_PUMPKINPIE_HALL = "row_pumpkinhallpie";
	// リンゴパイ
	public static final String NAME_ROW_APPLEPIE_HALL = "row_applehallpie";
	// 烏賊墨パイ
	public static final String NAME_ROW_BLACK_PIE = "row_blackpie";
	// ゾンビパイ
	public static final String NAME_ROW_ZOMBIPEI_HALL = "row_zombihallpie";
	// ピザ
	public static final String NAME_ROW_PIZZA = "row_pizza";
	// 肉ピザ
	public static final String NAME_ROW_MEETPIZZA ="row_meetpizza";
	// アンチョビピザ
	public static final String NAME_ROW_FISHPIZZA = "row_fishpizza";


	// アイスクリーム液
	public static final String NAME_ICE_MIX = "icemix";
	//	アイスクリーム
	public static final String NAME_ICECREAM ="icecream";
	// シロップ
	public static final String NAME_SYRUP = "syrup";
	// 練乳
	public static final String NAME_SYRUP_MILK = "condensemilk";
	// 練乳かき氷
	public static final String NAME_FLAPE="flape";
	// 練乳かき氷
	public static final String NAME_MILKFLAPE="milkflape";
	// キャンディ液
	public static final String NAME_SUGAR_WATER="sugarwater";
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
	public static final String NAME_MEET_PASTA = "meetpasta";
	// シーフードスパ
	public static final String NAME_FISH_PASTA = "fishpasta";
	// イカスミスパ
	public static final String NAME_BLUCK_PASTA = "bluckpasta";
	// ざるうどん
	public static final String NAME_ZARUUDON = "zaruudon";
	// かけうどん
	public static final String NAME_KAKEUDON = "kakeudon";
	// 月見うどん
	public static final String NAME_TUKIMIUDON ="tukimiudon";
	// 肉うどん
	public static final String NAME_NIKUUDON = "nikuudon";
	// チャーシューメン
	public static final String NAME_MEETRAMEN = "meetramen";
	// シーフードラーメン
	public static final String NAME_FISHRAMEN = "fishramen";
	// 月見ラーメン
	public static final String NAME_EGGRAMEN = "eggramen";


	// タンポポの粉末
	public static final String NAME_DUST_DANDELION="dust_dandelion";
	// ポピーの粉末
	public static final String NAME_DUST_POPPY="dust_poppy";
	// ヒスイランの粉末
	public static final String NAME_DUST_BLUE_ORCHID="dust_blue orchid";
	// レンゲソウの粉末
	public static final String NAME_DUST_ALLIUM="dust_allium";
	// ヒナソウの粉末
	public static final String NAME_DUST_AZURE_BLUET="dust_azure bluet";
	// チューリップの粉末
	public static final String NAME_DUST_TULIPS="dust_tulips";
	// フランスギクの粉末
	public static final String NAME_DUST_OXEYE_DAISY="dust_oxeye daisy";
	// ひまわりの粉末
	public static final String NAME_DUST_SUNFLOWER="dust_sunflower";
	// ライラックの粉末
	public static final String NAME_DUST_LILAC="dust_lilac";
	// バラの粉末
	public static final String NAME_DUST_ROSE_BUSH="dust_rose bush";
	// ボタンの粉末
	public static final String NAME_DUST_PEONY="dust_peony";
	// タンポポのお茶
	public static final String NAME_TEA_DANDELION="tea_dandelion";
	// ポピーのお茶
	public static final String NAME_TEA_POPPY="tea_poppy";
	// ヒスイランのお茶
	public static final String NAME_TEA_BLUE_ORCHID="tea_blue orchid";
	// レンゲソウのお茶
	public static final String NAME_TEA_ALLIUM="tea_allium";
	// ヒナソウのお茶
	public static final String NAME_TEA_AZURE_BLUET="tea_azure bluet";
	// チューリップのお茶
	public static final String NAME_TEA_TULIPS="tea_tulips";
	// フランスギクのお茶
	public static final String NAME_TEA_OXEYE_DAISY="tea_oxeye daisy";
	// ひまわりのお茶
	public static final String NAME_TEA_SUNFLOWER="tea_sunflower";
	// ライラックのお茶
	public static final String NAME_TEA_LILAC ="tea_lilac";
	// バラのお茶
	public static final String NAME_TEA_ROSE_BUSH="tea_rose bush";
	// ボタンのお茶
	public static final String NAME_TEA_PEONY="tea_peony";


	public static final Item item_choco                 = new ItemFood(2,0.1f,false).setUnlocalizedName(NAME_CHOCO);
	public static final Item item_whitechoco            = new ItemFood(2,0.1f,false).setUnlocalizedName(NAME_WHITECHOCO);
	public static final Item item_caramel               = new ItemFood(2,0.1f,false).setUnlocalizedName(NAME_CARAMEL);
	public static final Item item_pudding               = new ItemFood(2,0.2f,false).setUnlocalizedName(NAME_PUDDING);
	public static final Item item_pumpkinpudding        = new ItemFood(2,0.3f,false).setUnlocalizedName(NAME_PUMPKINPUDDING);
	public static final Item item_piecepie              = new ItemFood(2,0.5f,false).setUnlocalizedName(NAME_PIECEPIE);
	public static final Item item_piecechocopie         = new ItemFood(4,0.6f,false).setUnlocalizedName(NAME_PIECECHOCOPIE);
	public static final Item item_piecesaladapie        = new ItemFood(4,0.6f,false).setUnlocalizedName(NAME_PIECESALADAPIE);
	public static final Item item_piecemeetpie          = new ItemFood(8,0.8f,false).setUnlocalizedName(NAME_PIECEMEETPIE);
	public static final Item item_piecefishpie          = new ItemFood(8,0.8f,false).setUnlocalizedName(NAME_PIECEFISHPIE);
	public static final Item item_piecepumpukinpie      = new ItemFood(4,0.6f,false).setUnlocalizedName(NAME_PIECEPUMPUKINPIE);
	public static final Item item_piecezombipie         = new ItemFood(2,0.1f,false).setPotionEffect(new PotionEffect(MobEffects.hunger,600,0),100.0F).setUnlocalizedName(NAME_PIECEZOMBIPIE);
	public static final Item item_pieceapplepie         = new ItemFood(4,0.5f,false).setUnlocalizedName(NAME_PIECEAPPLEPIE);
	public static final Item item_piecebluckpie         = new ItemFood(4,0.2f,false).setUnlocalizedName(NAME_PIECEBLUCKPIE);
	public static final Item item_piececallamelpie      = new ItemFood(4,0.5f,false).setUnlocalizedName(NAME_PIECECALLAMELPIE);
	public static final Item item_eggsandwich           = new ItemFood(6,0.6f,false).setUnlocalizedName(NAME_EGGSANDWICH);
	public static final Item item_potetsaladasandwitch  = new ItemFood(6,0.6f,false).setUnlocalizedName(NAME_POTETSALADASANDWITCH);
	public static final Item item_hamsandwich           = new ItemFood(8,0.6f,false).setUnlocalizedName(NAME_HAMSANDWICH);
	public static final Item item_muttonsandwich        = new ItemFood(8,0.7f,false).setUnlocalizedName(NAME_MUTTONSANDWICH);
	public static final Item item_stakesandwich         = new ItemFood(8,0.8f,false).setUnlocalizedName(NAME_STAKESANDWICH);
	public static final Item item_chikensandwich        = new ItemFood(8,0.7f,false).setUnlocalizedName(NAME_CHIKENSANDWICH);
	public static final Item item_chocosandwich         = new ItemFood(4,0.5f,false).setUnlocalizedName(NAME_CHOCOSANDWICH);
	public static final Item item_potetosalada          = new ItemFood(4,0.4f,false).setUnlocalizedName(NAME_POTETOSALADA);
	public static final Item item_pumpkinsalada         = new ItemFood(4,0.4f,false).setUnlocalizedName(NAME_PUMPKINSALDADA);
	public static final Item item_pumpkinsaladasandwich = new ItemFood(6,0.6f,false).setUnlocalizedName(NAME_PUMPKINSALADASANDWICH);
	public static final Item item_butter                = new Item().setUnlocalizedName(NAME_BUTTER).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_mold                  = new Item().setUnlocalizedName(NAME_MOLD).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_bluemold              = new Item().setUnlocalizedName(NAME_BLUEMOLD).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_hallpie           = new Item().setUnlocalizedName(NAME_ROW_PIE_HALL).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_chocohallpie      = new Item().setUnlocalizedName(NAME_ROW_CHOCOPIE_HALL).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_saladahallpie     = new Item().setUnlocalizedName(NAME_ROW_SALADA_HALL).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_meethallpie       = new Item().setUnlocalizedName(NAME_ROW_MEETPIE_HALL).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_fishhallpie       = new Item().setUnlocalizedName(NAME_ROW_FISHPIE_HALL).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_pumpkinhallpie    = new Item().setUnlocalizedName(NAME_ROW_PUMPKINPIE_HALL).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_zombihallpie      = new Item().setUnlocalizedName(NAME_ROW_ZOMBIPEI_HALL).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_applehallpie      = new Item().setUnlocalizedName(NAME_ROW_APPLEPIE_HALL).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_blackpie          = new Item().setUnlocalizedName(NAME_ROW_BLACK_PIE).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_pizza             = new Item().setUnlocalizedName(NAME_ROW_PIZZA).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_meetpizza         = new Item().setUnlocalizedName(NAME_ROW_MEETPIZZA).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_fishpizza         = new Item().setUnlocalizedName(NAME_ROW_FISHPIZZA).setCreativeTab(CreativeTabs.tabMaterials);

	public static final Item item_icemix                = new Item().setUnlocalizedName(NAME_ICE_MIX).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
	public static final Item item_icecream              = new ItemIcecreame(2,0.2f,false).setUnlocalizedName(NAME_ICECREAM).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
	public static final Item item_syrup                 = new Item().setUnlocalizedName(NAME_SYRUP).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
	public static final Item item_syrupmilk             = new Item().setUnlocalizedName(NAME_SYRUP_MILK).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_flape                 = new ItemFlap(1,0.1f,false).setPotionEffect(new PotionEffect(MobEffects.confusion,100,1), 25.0F).setUnlocalizedName(NAME_FLAPE).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_milkflape             = new ItemFlap(1,0.2f,false).setPotionEffect(new PotionEffect(MobEffects.confusion,100,1), 25.0F).setUnlocalizedName(NAME_MILKFLAPE).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_sugarwater            = new Item().setUnlocalizedName(NAME_SUGAR_WATER).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);
	public static final Item item_icecandy              = new ItemFood(0,0.1f,false).setUnlocalizedName(NAME_ICECANDY).setCreativeTab(Mod_DiningFurniture.tabColdFood).setHasSubtypes(true);


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
			{put(NAME_PIECEBLUCKPIE, item_piecebluckpie);}
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
			{put(NAME_PIECEBLUCKPIE, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PIECEBLUCKPIE, "inventory")});}
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
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICE_MIX + "_" + EnumIceFlavor.ICE_BLUCK.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICE_MIX + "_" + EnumIceFlavor.ICE_MELLON.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICE_MIX + "_" + EnumIceFlavor.ICE_CALLOT.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICE_MIX + "_" + EnumIceFlavor.ICE_POTATO.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICE_MIX + "_" + EnumIceFlavor.ICE_APPLE.getFlavor(), "inventory")});}
			{put(NAME_ICECREAM, new ModelResourceLocation[]{
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECREAM + "_" + EnumIceFlavor.ICE_VANILA.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECREAM + "_" + EnumIceFlavor.ICE_CHOCO.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECREAM + "_" + EnumIceFlavor.ICE_PUMPKIN.getFlavor(), "inventory"),
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECREAM + "_" + EnumIceFlavor.ICE_BLUCK.getFlavor(), "inventory"),
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
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SYRUP + "_" + EnumFlapeSyrup.SYRUP_BLUCK.getFlavor(), "inventory"),
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
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_FLAPE + "_" + EnumFlapeSyrup.SYRUP_BLUCK.getFlavor(), "inventory"),
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
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_MILKFLAPE + "_" + EnumFlapeSyrup.SYRUP_BLUCK.getFlavor(), "inventory"),
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
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_SUGAR_WATER + "_" + EnumFlapeSyrup.SYRUP_BLUCK.getFlavor(), "inventory"),
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
					new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_ICECANDY + "_" + EnumFlapeSyrup.SYRUP_BLUCK.getFlavor(), "inventory"),
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
		});
	}

	public static enum EnumIceFlavor{
		ICE_VANILA(0,"vanila"),
		ICE_CHOCO(1,"choco"),
		ICE_PUMPKIN(2,"pumpkin"),
		ICE_BLUCK(3,"bluck"),
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

		private static final EnumIceFlavor[] values = {ICE_VANILA,ICE_CHOCO,ICE_PUMPKIN,ICE_BLUCK,ICE_MELLON,ICE_CALLOT,ICE_POTATO,ICE_APPLE};

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
		SYRUP_BLUCK(5,"bluck"),
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
														SYRUP_CACTUS,SYRUP_WMELLON,SYRUP_BLUCK,SYRUP_STRAWBERRY,
														SYRUP_MELON,SYRUP_CHOCOLATE,SYRUP_POTION,SYRUP_BERRY,SYRUP_BLUEHAWAII,
														SYRUP_COCONUT,SYRUP_MATCHER,SYRUP_PEACH,SYRUP_LIME,SYRUP_LEMON,SYRUP_SODA,SYRUP_GRAPE,
														SYRUP_ORANGE,SYRUP_CALUCIUM};

		public int getIndex(){return this.index;}
		public int getDamage(){return this.damage;}
		public String getFlavor(){return this.flavor;}
		public EnumFlapeSyrup getValue(int index){return values[index];}
	}
}
