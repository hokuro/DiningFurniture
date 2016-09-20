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
	// チョコアイス液
	public static final String NAME_ICE_CHOCO_MIX="chocoicemix";
	// かぼちゃアイス液
	public static final String NAME_ICE_PUMPKIN_MIX="pumpkinicemix";
	// イカスミアイス液
	public static final String NAEM_ICE_BLUCK_MIX="bluckicemix";
	// スイカアイス液
	public static final String NAME_ICE_MELLON_MIX="mellonicemix";
	// ニンジンアイス液
	public static final String NAME_ICE_CALLOT_MIX="calloticemix";
	// ジャガイモアイス液
	public static final String NAME_ICE_POTETO_MIX="potetoicemix";
	// リンゴアイス液
	public static final String NAME_ICE_APPLE_MIX="appleicemix";
	//	アイスクリーム
	public static final String NAME_ICECREAM ="icecream";
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



	// カルシウムシロップ
	public static final String NAME_SYRUP_CALCIUM="syrupwhite";
	// オレンジシロップ
	public static final String NAME_SYRUP_ORANGE="syruporange";
	// 山葡萄シロップ
	public static final String NAME_SYRUP_GRAPE="syrupmagenta";
	// ソーダシロップ
	public static final String NAME_SYRUP_SODA="syruplightblue";
	// レモンシロップ
	public static final String NAME_SYRUP_LEMON="syrupyellow";
	// ライムシロップ
	public static final String NAME_SYRUP_LIME="syruplime";
	// ピーチシロップ
	public static final String NAME_SYRUP_PEACH="syruppink";
	// マッチャシロップ
	public static final String NAME_SYRUP_MATCHER="syrupgray";
	// ココナッツシロップ
	public static final String NAME_SYRUP_COCONUT="syrupsilver";
	// フルーハワイシロップ
	public static final String NAME_SYRUP_BLUEHAWAII="syrupcyan";
	// ベリーシロップ
	public static final String NAME_SYRUP_BERRY="syruppurple";
	// ポーションシロップ
	public static final String NAME_SYRUP_POTION="syrupblue";
	// チョコシロップ
	public static final String NAME_SYRUP_CHOCOLATE="syrupbrown";
	// メロンシロップ
	public static final String NAME_SYRUP_MELON="syrupgreen";
	// イチゴシロップ
	public static final String NAME_SYRUP_STRAWBERRY="syrupred";
	// イカスミシロップ
	public static final String NAME_SYRUP_SQUIDINK="syrupblack";
	// スイカシロップ
	public static final String NAME_SYRUP_WATERMELON="syrupwmellon";
	// サボテンシロップ
	public static final String NAME_SYRUP_CACTUS="syrupcactus";
	// カボチャシロップ
	public static final String NAME_SYRUP_PUMPKIN="syruppumpkin";
	// シロップ
	public static final String NAME_SYRUP_SUGAR="syrupbase";
	// 練乳
	public static final String NAME_SYRUP_MILK = "syrupmilk";

	// カルシウムかき氷
	public static final String NAME_FLAPE_CALCIUM="flapewhite";
	// オレンジかき氷
	public static final String NAME_FLAPE_ORANGE="flapeorange";
	// 山葡萄かき氷
	public static final String NAME_FLAPE_GRAPE="flapemagenta";
	// ソーダかき氷
	public static final String NAME_FLAPE_SODA="flapelightblue";
	// レモンかき氷
	public static final String NAME_FLAPE_LEMON="flapeyellow";
	// ライムかき氷
	public static final String NAME_FLAPE_LIME="flapelime";
	// ピーチかき氷
	public static final String NAME_FLAPE_PEACH="flapepink";
	// マッチャかき氷
	public static final String NAME_FLAPE_MATCHER="flapegray";
	// ココナッツかき氷
	public static final String NAME_FLAPE_COCONUT="flapesilver";
	// フルーハワイかき氷
	public static final String NAME_FLAPE_BLUEHAWAII="flapecyan";
	// ベリーかき氷
	public static final String NAME_FLAPE_BERRY="flapepurple";
	// ポーションかき氷
	public static final String NAME_FLAPE_POTION="flapeblue";
	// チョコかき氷
	public static final String NAME_FLAPE_CHOCOLATE="flapebrown";
	// メロンかき氷
	public static final String NAME_FLAPE_MELON="flapegreen";
	// イチゴかき氷
	public static final String NAME_FLAPE_STRAWBERRY="flapered";
	// イカスミかき氷
	public static final String NAME_FLAPE_SQUIDINK="flapeblack";
	// スイカかき氷
	public static final String NAME_FLAPE_WATERMELON="flapewmellon";
	// サボテンかき氷
	public static final String NAME_FLAPE_CACTUS="flapecactus";
	// カボチャかき氷
	public static final String NAME_FLAPE_PUMPKIN="flapepumpkin";
	// しずれかき氷
	public static final String NAME_FLAPE_SUGAR="flapebase";
	// かき氷
	public static final String NAME_FLAPE = "flape";
	// 練乳 カルシウムかき氷
	public static final String NAME_MILKFLAPE_CALCIUM="milkflapewhite";
	// 練乳 オレンジかき氷
	public static final String NAME_MILKFLAPE_ORANGE="milkflapeorange";
	// 練乳 山葡萄かき氷
	public static final String NAME_MILKFLAPE_GRAPE="milkflapemagenta";
	// 練乳 ソーダかき氷
	public static final String NAME_MILKFLAPE_SODA="milkflapelightblue";
	// 練乳 レモンかき氷
	public static final String NAME_MILKFLAPE_LEMON="milkflapeyellow";
	// 練乳 ライムかき氷
	public static final String NAME_MILKFLAPE_LIME="milkflapelime";
	// 練乳 ピーチかき氷
	public static final String NAME_MILKFLAPE_PEACH="milkflapepink";
	// 練乳 マッチャかき氷
	public static final String NAME_MILKFLAPE_MATCHER="milkflapegray";
	// 練乳 ココナッツかき氷
	public static final String NAME_MILKFLAPE_COCONUT="milkflapesilver";
	// 練乳 フルーハワイかき氷
	public static final String NAME_MILKFLAPE_BLUEHAWAII="milkflapecyan";
	// 練乳 ベリーかき氷
	public static final String NAME_MILKFLAPE_BERRY="milkflapepurple";
	// 練乳 ポーションかき氷
	public static final String NAME_MILKFLAPE_POTION="milkflapeblue";
	// 練乳 チョコかき氷
	public static final String NAME_MILKFLAPE_CHOCOLATE="milkflapebrown";
	// 練乳 メロンかき氷
	public static final String NAME_MILKFLAPE_MELON="milkflapegreen";
	// 練乳 イチゴかき氷
	public static final String NAME_MILKFLAPE_STRAWBERRY="milkflapered";
	// 練乳 イカスミかき氷
	public static final String NAME_MILKFLAPE_SQUIDINK="milkflapeblack";
	// 練乳 スイカかき氷
	public static final String NAME_MILKFLAPE_WATERMELON="milkflapewmellon";
	// 練乳 サボテンかき氷
	public static final String NAME_MILKFLAPE_CACTUS="milkflapecactus";
	// 練乳 カボチャかき氷
	public static final String NAME_MILKFLAPE_PUMPKIN="milkflapepumpkin";
	// 練乳 しずれかき氷
	public static final String NAME_MILKFLAPE_SUGAR="milkflapebase";
	// 練乳かき氷
	public static final String NAME_MILKFLAPE="milkflape";


	// キャンディ液カルシウム
	public static final String NAME_CANDYSYRUP_CALCIUM="candysyrupwhite";
	// キャンディ液オレンジ
	public static final String NAME_CANDYSYRUP_ORANGE="candysyruporange";
	// キャンディ液山葡萄
	public static final String NAME_CANDYSYRUP_GRAPE="candysyrupmagenta";
	// キャンディ液ソーダ
	public static final String NAME_CANDYSYRUP_SODA="candysyruplightblue";
	// キャンディ液レモン
	public static final String NAME_CANDYSYRUP_LEMON="candysyrupyellow";
	// キャンディ液ライム
	public static final String NAME_CANDYSYRUP_LIME="candysyruplime";
	// キャンディ液ピーチ
	public static final String NAME_CANDYSYRUP_PEACH="candysyruppink";
	// キャンディ液マッチャ
	public static final String NAME_CANDYSYRUP_MATCHER="candysyrupgray";
	// キャンディ液ココナッツ
	public static final String NAME_CANDYSYRUP_COCONUT="candysyrupsilver";
	// キャンディ液フルーハワイ
	public static final String NAME_CANDYSYRUP_BLUEHAWAII="candysyrupcyan";
	// キャンディ液ベリー
	public static final String NAME_CANDYSYRUP_BERRY="candysyruppurple";
	// キャンディ液ポーション
	public static final String NAME_CANDYSYRUP_POTION="candysyrupblue";
	// キャンディ液チョコ
	public static final String NAME_CANDYSYRUP_CHOCOLATE="candysyrupbrown";
	// キャンディ液メロン
	public static final String NAME_CANDYSYRUP_MELON="candysyrupgreen";
	// キャンディ液イチゴ
	public static final String NAME_CANDYSYRUP_STRAWBERRY="candysyrupred";
	// キャンディ液イカスミ
	public static final String NAME_CANDYSYRUP_SQUIDINK="candysyrupblack";
	// キャンディ液スイカ
	public static final String NAME_CANDYSYRUP_WATERMELON="candysyrupwmellon";
	// キャンディ液サボテン
	public static final String NAME_CANDYSYRUP_CACTUS="candysyrupcactus";
	// キャンディ液カボチャ
	public static final String NAME_CANDYSYRUP_PUMPKIN="candysyruppumpkin";
	// キャンディ液
	public static final String NAME_CANDYSYRUP_SUGAR="candysyrupbase";
	// キャンディ液カルシウム
	public static final String NAME_ICECANDY_CALCIUM="icecandywhite";
	// キャンディ液オレンジ
	public static final String NAME_ICECANDY_ORANGE="icecandyorange";
	// キャンディ液山葡萄
	public static final String NAME_ICECANDY_GRAPE="icecandymagenta";
	// キャンディ液ソーダ
	public static final String NAME_ICECANDY_SODA="icecandylightblue";
	// キャンディ液レモン
	public static final String NAME_ICECANDY_LEMON="icecandyyellow";
	// キャンディ液ライム
	public static final String NAME_ICECANDY_LIME="icecandylime";
	// キャンディ液ピーチ
	public static final String NAME_ICECANDY_PEACH="icecandypink";
	// キャンディ液マッチャ
	public static final String NAME_ICECANDY_MATCHER="icecandygray";
	// キャンディ液ココナッツ
	public static final String NAME_ICECANDY_COCONUT="icecandysilver";
	// キャンディ液フルーハワイ
	public static final String NAME_ICECANDY_BLUEHAWAII="icecandycyan";
	// キャンディ液ベリー
	public static final String NAME_ICECANDY_BERRY="icecandypurple";
	// キャンディ液ポーション
	public static final String NAME_ICECANDY_POTION="icecandyblue";
	// キャンディ液チョコ
	public static final String NAME_ICECANDY_CHOCOLATE="icecandybrown";
	// キャンディ液メロン
	public static final String NAME_ICECANDY_MELON="icecandygreen";
	// キャンディ液イチゴ
	public static final String NAME_ICECANDY_STRAWBERRY="icecandyred";
	// キャンディ液イカスミ
	public static final String NAME_ICECANDY_SQUIDINK="icecandyblack";
	// キャンディ液スイカ
	public static final String NAME_ICECANDY_WATERMELON="icecandywmellon";
	// キャンディ液サボテン
	public static final String NAME_ICECANDY_CACTUS="icecandycactus";
	// キャンディ液カボチャ
	public static final String NAME_ICECANDY_PUMPKIN="icecandypumpkin";
	// キャンディ液
	public static final String NAME_ICECANDY_SUGAR="icecandybase";


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


	public static final Item item_icemix                = new Item().setUnlocalizedName(NAME_ICE_MIX).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_chocoicemix           = new Item().setUnlocalizedName(NAME_ICE_CHOCO_MIX).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_pumpkinicemix         = new Item().setUnlocalizedName(NAME_ICE_PUMPKIN_MIX).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_bluckicemix           = new Item().setUnlocalizedName(NAEM_ICE_BLUCK_MIX).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_mellonicemix          = new Item().setUnlocalizedName(NAME_ICE_MELLON_MIX).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_calloticemix          = new Item().setUnlocalizedName(NAME_ICE_CALLOT_MIX).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_potetoicemix          = new Item().setUnlocalizedName(NAME_ICE_POTETO_MIX).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_appleicemix           = new Item().setUnlocalizedName(NAME_ICE_APPLE_MIX).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_icecream              = new ItemIcecreame(2,0.2f,false).setUnlocalizedName(NAME_ICECREAM).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_chocoicecream         = new ItemIcecreame(2,0.2f,false).setUnlocalizedName(NAME_CHOCOICECREAM).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_pumpkinicecream       = new ItemIcecreame(2,0.2f,false).setUnlocalizedName(NAME_PUMPKINICECREAM).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_squidicecream         = new ItemIcecreame(2,0.2f,false).setUnlocalizedName(NAME_SQUIDICECREAM).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_wmellonicecream       = new ItemIcecreame(2,0.2f,false).setUnlocalizedName(NAME_WMELLONICECREAM).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_calloteicecream       = new ItemIcecreame(2,0.2f,false).setUnlocalizedName(NAME_CALLOTICECREAM).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_potetoicecream        = new ItemIcecreame(2,0.2f,false).setUnlocalizedName(NAME_POTETOICECREAM).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_appleicecream         = new ItemIcecreame(2,0.2f,false).setUnlocalizedName(NAME_APPLEICECREAM).setCreativeTab(Mod_DiningFurniture.tabColdFood);

	public static final Item item_syrup_suger           = new ItemSyrup().setUnlocalizedName(NAME_SYRUP_SUGAR).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_flape                 = new ItemFlap(1,0.1f,false).setPotionEffect(new PotionEffect(MobEffects.confusion,100,1), 25.0F).setUnlocalizedName(NAME_FLAPE).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_milkflape             = new ItemFlap(1,0.2f,false).setPotionEffect(new PotionEffect(MobEffects.confusion,100,1), 25.0F).setUnlocalizedName(NAME_MILKFLAPE).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_candysyrup            = new ItemCandySyrup().setUnlocalizedName(NAME_CANDYSYRUP_SUGAR).setCreativeTab(Mod_DiningFurniture.tabColdFood);
	public static final Item item_icecandy              = new ItemIceCandy(0,0.1f,false).setUnlocalizedName(NAME_ICECANDY_SUGAR).setCreativeTab(Mod_DiningFurniture.tabColdFood);
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
			{put(NAME_ICE_CHOCO_MIX,item_chocoicemix);}
			{put(NAME_ICE_PUMPKIN_MIX,item_pumpkinicemix);}
			{put(NAEM_ICE_BLUCK_MIX,item_bluckicemix);}
			{put(NAME_ICE_MELLON_MIX,item_mellonicemix);}
			{put(NAME_ICE_CALLOT_MIX,item_calloticemix);}
			{put(NAME_ICE_POTETO_MIX,item_potetoicemix);}
			{put(NAME_ICE_APPLE_MIX,item_appleicemix);}
			{put(NAME_ICECREAM, item_icecream);}
			{put(NAME_CHOCOICECREAM, item_chocoicecream);}
			{put(NAME_PUMPKINICECREAM, item_pumpkinicecream);}
			{put(NAME_SQUIDICECREAM, item_squidicecream);}
			{put(NAME_WMELLONICECREAM, item_wmellonicecream);}
			{put(NAME_CALLOTICECREAM, item_calloteicecream);}
			{put(NAME_POTETOICECREAM, item_potetoicecream);}
			{put(NAME_APPLEICECREAM, item_appleicecream);}
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




			{put(NAME_ICE_MIX, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_ICECREAM, "inventory")});}
			{put(NAME_ICE_CHOCO_MIX, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_ICE_CHOCO_MIX, "inventory")});}
			{put(NAME_ICE_PUMPKIN_MIX, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_ICE_PUMPKIN_MIX, "inventory")});}
			{put(NAEM_ICE_BLUCK_MIX, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAEM_ICE_BLUCK_MIX, "inventory")});}
			{put(NAME_ICE_MELLON_MIX, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_ICE_MELLON_MIX, "inventory")});}
			{put(NAME_ICE_CALLOT_MIX, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_ICE_CALLOT_MIX, "inventory")});}
			{put(NAME_ICE_POTETO_MIX, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_ICE_POTETO_MIX, "inventory")});}
			{put(NAME_ICE_APPLE_MIX, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_ICE_APPLE_MIX, "inventory")});}
			{put(NAME_ICECREAM, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_ICECREAM, "inventory")});}
			{put(NAME_CHOCOICECREAM, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_CHOCOICECREAM, "inventory")});}
			{put(NAME_PUMPKINICECREAM, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_PUMPKINICECREAM, "inventory")});}
			{put(NAME_SQUIDICECREAM, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_SQUIDICECREAM, "inventory")});}
			{put(NAME_WMELLONICECREAM, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_WMELLONICECREAM, "inventory")});}
			{put(NAME_CALLOTICECREAM,new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_CALLOTICECREAM, "inventory")});}
			{put(NAME_POTETOICECREAM, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_POTETOICECREAM, "inventory")});}
			{put(NAME_APPLEICECREAM, new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_APPLEICECREAM, "inventory")});}
		});
	}
}
