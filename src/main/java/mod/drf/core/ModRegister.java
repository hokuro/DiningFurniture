package mod.drf.core;

import java.util.Map;

import mod.drf.core.log.ModLog;
import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.block.BlockFoods;
import mod.drf.furniture.block.BlockFurniture;
import mod.drf.furniture.entity.EntityChairZabuton;
import mod.drf.furniture.item.ItemFurniture;
import mod.drf.furniture.network.TrunkMessageHandler;
import mod.drf.furniture.network.TrunkPagePacket;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class ModRegister {

	public static void RegisterBlock(FMLPreInitializationEvent event){

		Map<String,Block> blockMap = BlockFoods.blockMap();
		blockMap.putAll(BlockFurniture.blockMap());
		Map<String,Item> itemMap = BlockFoods.itemMap();
		itemMap.putAll(BlockFurniture.itemMap());
		Map<String, ResourceLocation[]> resourceMap = BlockFoods.resourceMap();
		resourceMap.putAll(BlockFurniture.resourceMap());

		for (String key : blockMap.keySet()){
			if (ModCommon.isDebug){ModLog.log().debug("ブロック登録:"+key+"登録");};
			GameRegistry.register(blockMap.get(key),new ResourceLocation(ModCommon.MOD_ID+":"+key));
			GameRegistry.register(itemMap.get(key),new ResourceLocation(ModCommon.MOD_ID+":"+key));
			if (ModCommon.isDebug){ModLog.log().debug("ブロック登録:"+key+"登録完了");}
		}

		if ( event.getSide().isClient())
		{
			for ( String key: resourceMap.keySet()){
				if (ModCommon.isDebug){ModLog.log().debug("モデル登録:"+ key+"登録");}
				Item witem = Item.getItemFromBlock(blockMap.get(key));
				ResourceLocation[] wresource = resourceMap.get(key);
				if (wresource.length > 1){
					ModelLoader.registerItemVariants(witem, wresource);
				}
				for (int i = 0; i < wresource.length; i++){
					ModelLoader.setCustomModelResourceLocation(witem, i,
							new ModelResourceLocation(wresource[i], "inventory"));
					if (ModCommon.isDebug){ModLog.log().debug("モデル登録:リソース:"+ wresource[i]);}
				}
				if (ModCommon.isDebug){ModLog.log().debug("モデル登録:"+ key+"登録完了");}
			}
		};
	}

	public static void RegisterItem(FMLPreInitializationEvent event){
		Map<String,Item> itemMap = ItemFoods.itemMap();
		itemMap.putAll(ItemFurniture.itemMap());
		Map<String, ModelResourceLocation[]> resourceMap = ItemFoods.resourceMap();
		resourceMap.putAll(ItemFurniture.resourceMap());

		for (String key : itemMap.keySet()){
			GameRegistry.register(itemMap.get(key),new ResourceLocation(key));
		}

        //テクスチャ・モデル指定JSONファイル名の登録。
        if (event.getSide().isClient()) {
        	for (String key : resourceMap.keySet()){
        		//1IDで複数モデルを登録するなら、上のメソッドで登録した登録名を指定する。
        		int cnt = 0;
        		for (ModelResourceLocation rc : resourceMap.get(key)){
        			ModelLoader.setCustomModelResourceLocation(itemMap.get(key), cnt, rc);
        			cnt++;
        		}
        	}
        }
	}

	public static void RegisterEntity(CommonProxy proxy){
		EntityRegistry.registerModEntity(EntityChairZabuton.class, EntityChairZabuton.NAME, 0, Mod_DiningFurniture.instance, 80, 3, true);
	}

	public static void RegisterRender(CommonProxy proxy){
		proxy.registRender();
	}

	public static void RegisterRecipe(){

		// 座布団(羊毛+糸→座布団)
		for (int i = 0; i < 16; i++) {
			GameRegistry.addRecipe(new ItemStack(ItemFurniture.item_zabuton, 1, 15 - i),
					"s ", "##",
					Character.valueOf('s'), Items.string,
					Character.valueOf('#'), new ItemStack(Blocks.wool, 1, i));
		}

		// 座布団(座布団+染料→座布団)
		for (int n = 0; n <= 16; n++) {
			for (int m = 0; m <= 16; m++) {
				if (n != m) {
					GameRegistry.addShapelessRecipe(
							new ItemStack(ItemFurniture.item_zabuton, 1, m),
							new Object[] {
							new ItemStack(ItemFurniture.item_zabuton, 1, n),
							new ItemStack(Items.dye, 1, m) });
				}
			}
		}

		// トランク(鉄インゴット+皮→トランク)
		GameRegistry.addRecipe(new ItemStack(ItemFurniture.item_trunk),
				"000",
				"010",
				"000",
				'0',new ItemStack(Items.iron_ingot),
				'1',new ItemStack(Items.leather));


//			// パイ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_PIE_HALL),1,0),
//					" a "," b ","ccc",
//					'a',Items.water_bucket,
//					'b',ItemCore.getItem(ItemCore.NAME_BUTTER),
//					'c',Items.wheat);
//			// チョコパイ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_CHOCOPIE_HALL),1,0),
//					" a ","dbd","ccc",
//					'a',Items.water_bucket,
//					'b',ItemCore.getItem(ItemCore.NAME_BUTTER),
//					'c',Items.wheat,
//					'd',new ItemStack(Blocks.cocoa));
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_CHOCOPIE_HALL),1,0),
//					" a "," b ","ccc",
//					'a',Items.water_bucket,
//					'b',ItemCore.getItem(ItemCore.NAME_BUTTER),
//					'c',Items.wheat,
//					'd',ItemCore.getItem(ItemCore.NAME_CHOCO));
//			// 野菜パイ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_SALADA_HALL),1,0),
//					" a ","dbd","ccc",
//					'a',Items.water_bucket,
//					'b',ItemCore.getItem(ItemCore.NAME_BUTTER),
//					'c',Items.wheat,
//					'd',Items.carrot);
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_SALADA_HALL),1,0),
//					" a ","dbd","ccc",
//					'a',Items.water_bucket,
//					'b',ItemCore.getItem(ItemCore.NAME_BUTTER),
//					'c',Items.wheat,
//					'd',Items.potato);
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_SALADA_HALL),1,0),
//					" a ","ebd","ccc",
//					'a',Items.water_bucket,
//					'b',ItemCore.getItem(ItemCore.NAME_BUTTER),
//					'c',Items.wheat,
//					'd',Items.potato,
//					'e',Items.carrot);
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_SALADA_HALL),1,0),
//					" a ","ebd","ccc",
//					'a',Items.water_bucket,
//					'b',ItemCore.getItem(ItemCore.NAME_BUTTER),
//					'c',Items.wheat,
//					'd',Items.carrot,
//					'e',Items.potato);
//			// ミートパイ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_MEETPIE_HALL),1,0),
//					" a ","dbd","ccc",
//					'a',Items.water_bucket,
//					'b',ItemCore.getItem(ItemCore.NAME_BUTTER),
//					'c',Items.beef);
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_MEETPIE_HALL),1,0),
//					" a ","dbd","ccc",
//					'a',Items.water_bucket,
//					'b',ItemCore.getItem(ItemCore.NAME_BUTTER),
//					'c',Items.wheat,
//					'd',Items.chicken);
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_MEETPIE_HALL),1,0),
//					" a ","dbd","ccc",
//					'a',Items.water_bucket,
//					'b',ItemCore.getItem(ItemCore.NAME_BUTTER),
//					'c',Items.wheat,
//					'd',Items.mutton);
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_MEETPIE_HALL),1,0),
//					" a ","dbd","ccc",
//					'a',Items.water_bucket,
//					'b',ItemCore.getItem(ItemCore.NAME_BUTTER),
//					'c',Items.wheat,
//					'd',Items.porkchop);
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_MEETPIE_HALL),1,0),
//					" a ","dbd","ccc",
//					'a',Items.water_bucket,
//					'b',ItemCore.getItem(ItemCore.NAME_BUTTER),
//					'c',Items.wheat,
//					'd',Items.rabbit);
//			// フィッシュパイ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_FISHPIE_HALL),1,0),
//					" a ","dbd","ccc",
//					'a',Items.water_bucket,
//					'b',ItemCore.getItem(ItemCore.NAME_BUTTER),
//					'c',Items.wheat,
//					'd',Items.fish);
//			// かぼちゃパイ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_PUMPKINPIE_HALL),1,0),
//					" a ","dbd","ccc",
//					'a',Items.water_bucket,
//					'b',ItemCore.getItem(ItemCore.NAME_BUTTER),
//					'c',Items.wheat,
//					'd',new ItemStack(Blocks.pumpkin));
//			// リンゴパイ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_APPLEPIE_HALL),1,0),
//					" a ","dbd","ccc",
//					'a',Items.water_bucket,
//					'b',ItemCore.getItem(ItemCore.NAME_BUTTER),
//					'c',Items.wheat,
//					'd',Items.apple);
//			// カラメルパイ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_CALLAMELPIE_HALL),1,0),
//					" a ","dbd","ccc",
//					'a',Items.water_bucket,
//					'b',ItemCore.getItem(ItemCore.NAME_BUTTER),
//					'c',Items.wheat,
//					'd',ItemCore.getItem(ItemCore.NAME_CARAMEL));
//			// 烏賊墨パイ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_BLACK_PIE),1,0),
//					" a ","dbd","ccc",
//					'a',Items.water_bucket,
//					'b',ItemCore.getItem(ItemCore.NAME_BUTTER),
//					'c',Items.wheat,
//					'd',new ItemStack(Items.dye,1,0));
//
//			// チョコレートケーキ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_CHOCO_CAKE),1,0),
//					"aaa","bcb","efe",
//					'a',Items.milk_bucket,
//					'b',Items.sugar,
//					'c',Items.egg,
//					'e',Items.wheat,
//					'f',new ItemStack(Blocks.cocoa));
//			// リンゴケーキ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_APPLE_CAKE),1,0),
//					"aaa","bcb","efe",
//					'a',Items.milk_bucket,
//					'b',Items.sugar,
//					'c',Items.egg,
//					'e',Items.wheat,
//					'f',Items.apple);
//			// 野菜ケーキ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.LOCALISNAME_SALADA_CAKE),1,0),
//					"aaa","bcb","efe",
//					'a',Items.milk_bucket,
//					'b',Items.sugar,
//					'c',Items.egg,
//					'e',Items.wheat,
//					'f',Items.carrot);
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.LOCALISNAME_SALADA_CAKE),1,0),
//					"aaa","bcb","efe",
//					'a',Items.milk_bucket,
//					'b',Items.sugar,
//					'c',Items.egg,
//					'e',Items.wheat,
//					'f',Items.potato);
//			// スイカケーキ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_MELLON_CAKE),1,0),
//					"aaa","bcb","efe",
//					'a',Items.milk_bucket,
//					'b',Items.sugar,
//					'c',Items.egg,
//					'e',Items.wheat,
//					'f',Items.melon);
//			// かぼちゃケーキ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_PUMPKIN_CAKE),1,0),
//					"aaa","bcb","efe",
//					'a',Items.milk_bucket,
//					'b',Items.sugar,
//					'c',Items.egg,
//					'e',Items.wheat,
//					'f',new ItemStack(Blocks.pumpkin));
//			// チーズケーキ
////			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.LOCALISNAME_BAKEDCHEESE_CAKE),1,0),
////					"aaa","bcb","efe",
////					'a',Items.milk_bucket,
////					'b',Items.sugar,
////					'c',Items.egg,
////					'e',Items.wheat,
////					'f',new ItemStack(BlockCore.getBlock(BlockCore.NAME_CHEESE)));
//			GameRegistry.addSmelting(BlockCore.getBlock(BlockCore.NAME_REACHEESE_CAKE),
//					new ItemStack(BlockCore.getBlock(BlockCore.NAME_BAKEDCHEESE_CAKE)), 1600);
//			// レアチーズケーキ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.LOCALISNAME_REACHEESE_CAKE),1,0),
//					"aaa","bcb","efe",
//					'a',Items.milk_bucket,
//					'b',Items.sugar,
//					'c',Items.egg,
//					'e',Items.wheat,
//					'f',new ItemStack(BlockCore.getBlock(BlockCore.NAME_CHEESE)));
//			// 烏賊墨ケーキ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_BLUCK_CAEK),1,0),
//					"aaa","bcb","efe",
//					'a',Items.milk_bucket,
//					'b',Items.sugar,
//					'c',Items.egg,
//					'e',Items.wheat,
//					'f',new ItemStack(Items.dye,1,0));
//			// ピザ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_PIZZA),1,0),
//					"ccc","aaa",
//					'c',new ItemStack(BlockCore.getBlock(BlockCore.NAME_CHEESE)),
//					'a',Items.wheat);
//			// ミートピザ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_PIZZA),1,0),
//					" b ","ccc","aaa",
//					'c',new ItemStack(BlockCore.getBlock(BlockCore.NAME_CHEESE)),
//					'a',Items.wheat,
//					'b',Items.beef);
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_PIZZA),1,0),
//					" b ","ccc","aaa",
//					'c',new ItemStack(BlockCore.getBlock(BlockCore.NAME_CHEESE)),
//					'a',Items.wheat,
//					'b',Items.porkchop);
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_PIZZA),1,0),
//					" b ","ccc","aaa",
//					'c',new ItemStack(BlockCore.getBlock(BlockCore.NAME_CHEESE)),
//					'a',Items.wheat,
//					'b',Items.chicken);
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_PIZZA),1,0),
//					" b ","ccc","aaa",
//					'c',new ItemStack(BlockCore.getBlock(BlockCore.NAME_CHEESE)),
//					'a',Items.wheat,
//					'b',Items.mutton);
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_PIZZA),1,0),
//					" b ","ccc","aaa",
//					'c',new ItemStack(BlockCore.getBlock(BlockCore.NAME_CHEESE)),
//					'a',Items.wheat,
//					'b',Items.rabbit);
//			// アンチョビピザ
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_FISHPIZZA),1,0),
//					" b ","ccc","aaa",
//					'c',new ItemStack(BlockCore.getBlock(BlockCore.NAME_CHEESE)),
//					'a',Items.wheat,
//					'b',Items.fish);
//			// チーズ
//	        GameRegistry.addShapelessRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_CHEESE)),
//	                Items.milk_bucket,ItemCore.getItem(ItemCore.NAME_MOLD));
//
//			// ブルーチーズ
//	        GameRegistry.addShapelessRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_BLUECHEESE)),
//	                Items.milk_bucket,ItemCore.getItem(ItemCore.NAME_BLUEMOLD));
//
//	        // チョコレート
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_CHOCO),3,0),
//	        		Blocks.cocoa,Items.sugar);
//	        // ホワイトチョコレート
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_CHOCO),3,0),
//	        		Blocks.cocoa,Items.sugar, Items.milk_bucket);
//	        // キャラメル
//	        GameRegistry.addSmelting(Items.sugar, new ItemStack(ItemCore.getItem(ItemCore.NAME_CARAMEL), 3,0),200);
//	        // プリン
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PUDDING),4,0),
//			Items.milk_bucket,
//			Items.egg,
//			Items.egg,
//			Items.sugar,
//			ItemCore.getItem(ItemCore.NAME_CARAMEL));
//	        // かぼちゃプリン
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PUDDING),4,0),
//			Items.milk_bucket,
//			Items.egg,
//			Items.egg,
//			Items.sugar,
//			Blocks.pumpkin,
//			ItemCore.getItem(ItemCore.NAME_CARAMEL));
//	        // パイ
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PIECEPIE),3,0),
//	        		Items.wheat, Items.sugar);
//	        // チョコレートパイ
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PIECECHOCOPIE),3,0),
//	        		Items.wheat, Items.sugar, ItemCore.getItem(ItemCore.NAME_CHOCO));
//	        // サラダパイ
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PIECESALADAPIE),3,0),
//	        		Items.wheat, Items.sugar, Items.potato);
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PIECECHOCOPIE),3,0),
//	        		Items.wheat, Items.sugar, Items.carrot);
//	        // ミートパイ
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PIECEMEETPIE),3,0),
//	        		Items.wheat, Items.sugar, Items.porkchop);
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PIECEMEETPIE),3,0),
//	        		Items.wheat, Items.sugar, Items.beef);
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PIECEMEETPIE),3,0),
//	        		Items.wheat, Items.sugar, Items.chicken);
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PIECEMEETPIE),3,0),
//	        		Items.wheat, Items.sugar, Items.mutton);
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PIECEMEETPIE),3,0),
//	        		Items.wheat, Items.sugar, Items.rabbit);
//	        // フィッシュパイ
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PIECEMEETPIE),3,0),
//	        		Items.wheat, Items.sugar, Items.fish);
//	        // かぼちゃパイ
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PIECEMEETPIE),3,0),
//	        		Items.wheat, Items.sugar, Blocks.pumpkin);
//	        // アップルパイ
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PIECEMEETPIE),3,0),
//	        		Items.wheat, Items.sugar, Items.apple);
//	        // 烏賊墨パイ
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PIECEMEETPIE),3,0),
//	        		Items.wheat, Items.sugar, new ItemStack(Items.dye,1,0));
//	        // カラメルパイ
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PIECEMEETPIE),3,0),
//	        		Items.wheat, Items.sugar, ItemCore.getItem(ItemCore.NAME_CARAMEL));
//	        // 卵サンド
//	        GameRegistry.addRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_EGGSANDWICH),3,0),
//	        		"a b",
//	        		" b ",
//	        		"b a",
//	        		'a',Items.bread,
//	        		'b',Items.egg);
//	        // ポテトサラダサンド
//	        GameRegistry.addRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_EGGSANDWICH),3,0),
//	        		"a b",
//	        		" b ",
//	        		"b a",
//	        		'a',Items.bread,
//	        		'b',ItemCore.getItem(ItemCore.NAME_POTETOSALADA));
//	        // ハムサンド
//	        GameRegistry.addRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_HAMSANDWICH),3,0),
//	        		"a b",
//	        		" b ",
//	        		"b a",
//	        		'a',Items.bread,
//	        		'b',Items.cooked_porkchop);
//	        // ジンギスカンサンド
//	        GameRegistry.addRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_MUTTONSANDWICH),3,0),
//	        		"a b",
//	        		" b ",
//	        		"b a",
//	        		'a',Items.bread,
//	        		'b',Items.cooked_mutton);
//	        // ステーキサンド
//	        GameRegistry.addRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_STAKESANDWICH),3,0),
//	        		"a b",
//	        		" b ",
//	        		"b a",
//	        		'a',Items.bread,
//	        		'b',Items.cooked_beef);
//	        // てりやきサンド
//	        GameRegistry.addRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_CHIKENSANDWICH),3,0),
//	        		"a b",
//	        		" b ",
//	        		"b a",
//	        		'a',Items.bread,
//	        		'b',Items.cooked_chicken);
//	        // チョコサンド
//	        GameRegistry.addRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_CHOCOSANDWICH),3,0),
//	        		"a b",
//	        		" b ",
//	        		"b a",
//	        		'a',Items.bread,
//	        		'b',ItemCore.getItem(ItemCore.NAME_CHOCO));
//	        // パンプキンサラダサンド
//	        GameRegistry.addRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PUMPKINSALADASANDWICH),3,0),
//	        		"a b",
//	        		" b ",
//	        		"b a",
//	        		'a',Items.bread,
//	        		'b',ItemCore.getItem(ItemCore.NAME_PUMPKINSALDADA));
//	        // アイスクリーム
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_ICECREAM),3,0),
//	        		Items.milk_bucket, Items.sugar,Blocks.ice);
//	        // チョコアイス
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_CHOCO),3,0),
//	        		Items.milk_bucket, Items.sugar,Blocks.ice,ItemCore.getItem(ItemCore.NAME_CHOCO));
//	        // かぼちゃアイス
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PUMPKINICECREAM),3,0),
//	        		Items.milk_bucket, Items.sugar,Blocks.ice,Blocks.pumpkin);
//	        // 烏賊墨アイス
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_SQUIDICECREAM),3,0),
//	        		Items.milk_bucket, Items.sugar,Blocks.ice,new ItemStack(Items.dye,1,0));
//	        // スイカアイス
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_WMELLONICECREAM),3,0),
//	        		Items.milk_bucket, Items.sugar,Blocks.ice,Items.melon);
//	        // ジャガイモアイス
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_POTETOICECREAM),3,0),
//	        		Items.milk_bucket, Items.sugar,Blocks.ice,Items.potato);
//	        // リンゴアイス
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_APPLEICECREAM),3,0),
//	        		Items.milk_bucket, Items.sugar,Blocks.ice,Items.apple);
//	        // ポテトサラダ
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_POTETOSALADA),3,0),
//	        		Items.carrot, Items.potato);
//	        // 人参アイス
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_CALLOTICECREAM),3,0),
//	        		Items.carrot, Items.carrot);
//	        // パンプキンサラダ
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_PUMPKINSALDADA),3,0),
//	        		Blocks.pumpkin, Items.carrot, Items.potato);
//	        // バター
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_BUTTER),3,0),
//	        		Items.milk_bucket);
//	        // カビ
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_MOLD),3,0),
//	        		Blocks.red_mushroom);
//	        // 青カビ
//	        GameRegistry.addShapelessRecipe(new ItemStack(ItemCore.getItem(ItemCore.NAME_BLUEMOLD),3,0),
//	                Items.rotten_flesh);
	}

	public static void RegisterMessage(){
		Mod_DiningFurniture.Net_Instance.registerMessage(TrunkMessageHandler.class, TrunkPagePacket.class, ModCommon.MESSAGE_ID_TRUNKDATA, Side.SERVER);
	}
}
