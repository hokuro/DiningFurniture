package mod.drf.foods.Item;

import java.util.HashMap;
import java.util.Map;

import mod.drf.core.ModCommon;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

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
//	アイスクリーム
	public static final String NAME_ICECREAM ="icecream";
//	バター
	public static final String NAME_BUTTER = "butter";
// チョコアイス
	public static final String NAME_CHOCOICECREAM ="chocoicecream";
// かぼちゃアイス
	public static final String NAME_PUMPKINICECREAM ="pumpukinicecream";
// イカスミアイス
	public static final String NAME_SQUIDICECREAM ="squidicecream";
// スイカアイス
	public static final String NAME_WMELLONICECREAM ="wmellonicecream";
// ニンジンアイス
	public static final String NAME_CALLOTICECREAM ="calloticecream";
// ジャガイモアイス
	public static final String NAME_POTETOICECREAM ="potetoicecream";
	// リンゴアイス
	public static final String NAME_APPLEICECREAM ="appleicecream";
	// カビ
	public static final String NAME_MOLD = "modl";
	// 青カビ
	public static final String NAME_BLUEMOLD = "bluemold";
	//	プリン
	public static final String NAME_ROW_PUDDING = "row_pudding";
	//	かぼちゃプリン
	public static final String NAME_ROW_PUMPKINPUDDING = "row_pumpukinpudding";
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
	// ゾンビパイ
	public static final String NAME_ROW_ZOMBIPEI_HALL = "row_zombihallpie";
	// リンゴパイ
	public static final String NAME_ROW_APPLEPIE_HALL = "row_applehallpie";
	// 烏賊墨パイ
	public static final String NAME_ROW_BLACK_PIE = "row_blackpie";
	// ピザ
	public static final String NAME_ROW_PIZZA = "row_pizza";
	// 肉ピザ
	public static final String NAME_ROW_MEETPIZZA ="row_meetpizza";
	// アンチョビピザ
	public static final String NAME_ROW_FISHPIZZA = "row_fishpizza";

	// TODO: かき氷,小麦粉,麺類,塩,シロップ, 湯呑, 薬茶, 茶, 漢方薬, 生のパイ


	public static final Item item_choco = new ItemFood(2,0.1f,false).setUnlocalizedName(NAME_CHOCO);
	public static final Item item_whitechoco = new ItemFood(2,0.2f,false).setUnlocalizedName(NAME_WHITECHOCO);
	public static final Item item_caramel = new ItemFood(2,0.1f,false).setUnlocalizedName(NAME_CARAMEL);
	public static final Item item_pudding = new ItemFood(2,0.2f,false).setUnlocalizedName(NAME_PUDDING);
	public static final Item item_pumpkinpudding = new ItemFood(2,0.3f,false).setUnlocalizedName(NAME_PUMPKINPUDDING);
	public static final Item item_piecepie = new ItemFood(2,0.5f,false).setUnlocalizedName(NAME_PIECEPIE);
	public static final Item item_piecechocopie = new ItemFood(4,0.6f,false).setUnlocalizedName(NAME_PIECECHOCOPIE);
	public static final Item item_piecesaladapie = new ItemFood(4,0.6f,false).setUnlocalizedName(NAME_PIECESALADAPIE);
	public static final Item item_piecemeetpie = new ItemFood(8,0.8f,false).setUnlocalizedName(NAME_PIECEMEETPIE);
	public static final Item item_piecefishpie = new ItemFood(8,0.8f,false).setUnlocalizedName(NAME_PIECEFISHPIE);
	public static final Item item_piecepumpukinpie = new ItemFood(4,0.6f,false).setUnlocalizedName(NAME_PIECEPUMPUKINPIE);
	public static final Item item_piecezombipie = new ItemFood(2,0.1f,false).setUnlocalizedName(NAME_PIECEZOMBIPIE);
	public static final Item item_pieceapplepie = new ItemFood(4,0.5f,false).setUnlocalizedName(NAME_PIECEAPPLEPIE);
	public static final Item item_piecebluckpie = new ItemFood(4,0.2f,false).setUnlocalizedName(NAME_PIECEBLUCKPIE);
	public static final Item item_piececallamelpie = new ItemFood(4,0.5f,false).setUnlocalizedName(NAME_PIECECALLAMELPIE);
	public static final Item item_eggsandwich = new ItemFood(6,0.6f,false).setUnlocalizedName(NAME_EGGSANDWICH);
	public static final Item item_potetsaladasandwitch = new ItemFood(6,0.6f,false).setUnlocalizedName(NAME_POTETSALADASANDWITCH);
	public static final Item item_hamsandwich = new ItemFood(8,0.6f,false).setUnlocalizedName(NAME_HAMSANDWICH);
	public static final Item item_muttonsandwich = new ItemFood(8,0.7f,false).setUnlocalizedName(NAME_MUTTONSANDWICH);
	public static final Item item_stakesandwich = new ItemFood(8,0.8f,false).setUnlocalizedName(NAME_STAKESANDWICH);
	public static final Item item_chikensandwich = new ItemFood(8,0.7f,false).setUnlocalizedName(NAME_CHIKENSANDWICH);
	public static final Item item_chocosandwich = new ItemFood(4,0.5f,false).setUnlocalizedName(NAME_CHOCOSANDWICH);
	public static final Item item_potetosalada = new ItemFood(4,0.4f,false).setUnlocalizedName(NAME_POTETOSALADA);
	public static final Item item_pumpkinsalada = new ItemFood(4,0.4f,false).setUnlocalizedName(NAME_PUMPKINSALDADA);
	public static final Item item_pumpkinsaladasandwich = new ItemFood(6,0.6f,false).setUnlocalizedName(NAME_PUMPKINSALADASANDWICH);
	public static final Item item_icecream = new ItemFood(2,0.2f,false).setUnlocalizedName(NAME_ICECREAM);
	public static final Item item_chocoicecream = new ItemFood(2,0.4f,false).setUnlocalizedName(NAME_CHOCOICECREAM);
	public static final Item item_pumpkinicecream = new ItemFood(2,0.6f,false).setUnlocalizedName(NAME_PUMPKINICECREAM);
	public static final Item item_squidicecream = new ItemFood(2,0.2f,false).setUnlocalizedName(NAME_SQUIDICECREAM);
	public static final Item item_wmellonicecream = new ItemFood(2,0.6f,false).setUnlocalizedName(NAME_WMELLONICECREAM);
	public static final Item item_calloteicecream = new ItemFood(2,0.6f,false).setUnlocalizedName(NAME_CALLOTICECREAM);
	public static final Item item_potetoicecream = new ItemFood(2,0.6f,false).setUnlocalizedName(NAME_POTETOICECREAM);
	public static final Item item_appleicecream = new ItemFood(2,0.5f,false).setUnlocalizedName(NAME_APPLEICECREAM);
	public static final Item item_butter = new Item().setUnlocalizedName(NAME_BUTTER).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_mold = new Item().setUnlocalizedName(NAME_MOLD).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_bluemold = new Item().setUnlocalizedName(NAME_BLUEMOLD).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_pudding = new Item().setUnlocalizedName(NAME_ROW_PUDDING).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_pumpukinpudding = new Item().setUnlocalizedName(NAME_ROW_PUMPKINPUDDING).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_hallpie = new Item().setUnlocalizedName(NAME_ROW_PIE_HALL).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_chocohallpie = new Item().setUnlocalizedName(NAME_ROW_CHOCOPIE_HALL).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_saladahallpie = new Item().setUnlocalizedName(NAME_ROW_SALADA_HALL).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_meethallpie = new Item().setUnlocalizedName(NAME_ROW_MEETPIE_HALL).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_fishhallpie = new Item().setUnlocalizedName(NAME_ROW_FISHPIE_HALL).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_pumpkinhallpie = new Item().setUnlocalizedName(NAME_ROW_PUMPKINPIE_HALL).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_zombihallpie = new Item().setUnlocalizedName(NAME_ROW_ZOMBIPEI_HALL).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_applehallpie = new Item().setUnlocalizedName(NAME_ROW_APPLEPIE_HALL).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_blackpie = new Item().setUnlocalizedName(NAME_ROW_BLACK_PIE).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_pizza = new Item().setUnlocalizedName(NAME_ROW_PIZZA).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_meetpizza = new Item().setUnlocalizedName(NAME_ROW_MEETPIZZA).setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item item_row_fishpizza = new Item().setUnlocalizedName(NAME_ROW_FISHPIZZA).setCreativeTab(CreativeTabs.tabMaterials);

	private static final Map<String,Item> items = new HashMap<String,Item>();
	private static final Map<String,ModelResourceLocation[]> resource = new HashMap<String,ModelResourceLocation[]>();

	public static Map<String,Item> itemMap(){
		return (new HashMap<String,Item>(){
			{put(NAME_CHOCO, item_choco);}
			{put(NAME_WHITECHOCO, item_whitechoco);}
			{put(NAME_CARAMEL, item_caramel);}
			{put(NAME_PUDDING, item_pudding);}
			{put(NAME_PUMPKINPUDDING, item_pumpkinpudding);}
			{put(NAME_PIECEPIE, item_piecepie);}
			{put(NAME_PIECECHOCOPIE, item_piecechocopie);}
			{put(NAME_PIECESALADAPIE, item_piecesaladapie);}
			{put(NAME_PIECEMEETPIE, item_piecemeetpie);}
			{put(NAME_PIECEFISHPIE, item_piecefishpie);}
			{put(NAME_PIECEPUMPUKINPIE, item_piecepumpukinpie);}
			{put(NAME_PIECEZOMBIPIE, item_piecezombipie);}
			{put(NAME_PIECEAPPLEPIE, item_pieceapplepie);}
			{put(NAME_PIECEBLUCKPIE, item_piecebluckpie);}
			{put(NAME_PIECECALLAMELPIE, item_piececallamelpie);}
			{put(NAME_EGGSANDWICH, item_eggsandwich);}
			{put(NAME_POTETSALADASANDWITCH, item_potetsaladasandwitch);}
			{put(NAME_HAMSANDWICH, item_hamsandwich);}
			{put(NAME_MUTTONSANDWICH, item_muttonsandwich);}
			{put(NAME_STAKESANDWICH, item_stakesandwich);}
			{put(NAME_CHIKENSANDWICH, item_chikensandwich);}
			{put(NAME_CHOCOSANDWICH, item_chocosandwich);}
			{put(NAME_POTETOSALADA, item_potetosalada);}
			{put(NAME_PUMPKINSALDADA, item_pumpkinsalada);}
			{put(NAME_PUMPKINSALADASANDWICH, item_pumpkinsaladasandwich);}
			{put(NAME_ICECREAM, item_icecream);}
			{put(NAME_CHOCOICECREAM, item_chocoicecream);}
			{put(NAME_PUMPKINICECREAM, item_pumpkinicecream);}
			{put(NAME_SQUIDICECREAM, item_squidicecream);}
			{put(NAME_WMELLONICECREAM, item_wmellonicecream);}
			{put(NAME_CALLOTICECREAM, item_calloteicecream);}
			{put(NAME_POTETOICECREAM, item_potetoicecream);}
			{put(NAME_APPLEICECREAM, item_appleicecream);}
			{put(NAME_BUTTER, item_butter);}
			{put(NAME_MOLD, item_mold);}
			{put(NAME_BLUEMOLD, item_bluemold);}
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
			{put(NAME_ICECREAM, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_ICECREAM, "inventory")});}
			{put(NAME_CHOCOICECREAM, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_CHOCOICECREAM, "inventory")});}
			{put(NAME_PUMPKINICECREAM, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PUMPKINICECREAM, "inventory")});}
			{put(NAME_SQUIDICECREAM, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_SQUIDICECREAM, "inventory")});}
			{put(NAME_WMELLONICECREAM, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_WMELLONICECREAM, "inventory")});}
			{put(NAME_CALLOTICECREAM,new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_CALLOTICECREAM, "inventory")});}
			{put(NAME_POTETOICECREAM, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_POTETOICECREAM, "inventory")});}
			{put(NAME_APPLEICECREAM, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_APPLEICECREAM, "inventory")});}
			{put(NAME_BUTTER, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_BUTTER, "inventory")});}
			{put(NAME_MOLD, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_MOLD, "inventory")});}
			{put(NAME_BLUEMOLD, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_BLUEMOLD, "inventory")});}
		});
	}
}
