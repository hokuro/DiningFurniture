package mod.drf.core;

import java.util.Map;

import mod.drf.core.log.ModLog;
import mod.drf.event.LivingDeathEventHandler;
import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.Item.ItemFoods.EnumFlapeSyrup;
import mod.drf.foods.Item.ItemFoods.EnumFlowerHalb;
import mod.drf.foods.Item.ItemFoods.EnumIceFlavor;
import mod.drf.foods.block.BlockFoods;
import mod.drf.foods.entity.EntityCrashedIce;
import mod.drf.foods.entity.EntityIceCream;
import mod.drf.foods.network.MessageFreezer;
import mod.drf.foods.network.MessageIceCrasherUpdate;
import mod.drf.foods.network.MessageMillStoneUpdate;
import mod.drf.foods.network.MessageSelectMenu;
import mod.drf.foods.network.MessageToServe;
import mod.drf.furniture.block.BlockFurniture;
import mod.drf.furniture.entity.EntityWoodChair;
import mod.drf.furniture.entity.EntityZabuton;
import mod.drf.furniture.item.ItemFurniture;
import mod.drf.sounds.SoundManager;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class ModRegister {

	public static void RegisterBlock(FMLPreInitializationEvent event){
		BlockFoods.init();
		Map<String,Block> foodBlocks = BlockFoods.blockMap();
		Map<String,Item> foodItemBlocks = BlockFoods.itemMap();

		for(String key : BlockFoods.NAME_LIST){
			ModLog.log().debug("ブロック登録:"+key);
			ForgeRegistries.BLOCKS.register(foodBlocks.get(key));
			ForgeRegistries.ITEMS.register(foodItemBlocks.get(key));
		}

		BlockFurniture.init();
		Map<String,Block> furBlocks = BlockFurniture.blockMap();
		Map<String,Item> furItemBlocks = BlockFurniture.itemMap();
		for (String key: BlockFurniture.NAME_LIST){
			ModLog.log().debug("ブロック登録:"+key);
			ForgeRegistries.BLOCKS.register(furBlocks.get(key));
			ForgeRegistries.ITEMS.register(furItemBlocks.get(key));
		}

		if (event.getSide().isClient()){
			Map<String,ResourceLocation[]> foodResources = BlockFoods.resourceMap();
			for (String key : BlockFoods.NAME_LIST){
				Item witem = foodItemBlocks.get(key);
				ResourceLocation[] wresource = foodResources.get(key);
				if (wresource.length > 1){
					ModelLoader.registerItemVariants(witem, wresource);
				}
				for (int i = 0; i < wresource.length; i++){
					ModelLoader.setCustomModelResourceLocation(witem, i,
							new ModelResourceLocation(wresource[i], "inventory"));
				}
			}

			Map<String,ResourceLocation[]> furResources = BlockFurniture.resourceMap();
			for (String key : BlockFurniture.NAME_LIST){
				Item witem = furItemBlocks.get(key);
				ResourceLocation[] wresource = furResources.get(key);
				if (wresource.length > 1){
					ModelLoader.registerItemVariants(witem, wresource);
				}
				for (int i = 0; i < wresource.length; i++){
					ModelLoader.setCustomModelResourceLocation(witem, i,
							new ModelResourceLocation(wresource[i], "inventory"));
				}
			}
		}
	}

	public static void RegisterItem(FMLPreInitializationEvent event){
		ItemFoods.init();
		Map<String,Item> foodMap = ItemFoods.itemMap();

		for (String key : ItemFoods.NMAE_LIST){
			if (ModCommon.isDebug){ModLog.log().debug("register item :"+key);}
			ForgeRegistries.ITEMS.register(foodMap.get(key));
		}

		ItemFurniture.init();
		Map<String,Item> furMap = ItemFurniture.itemMap();
		for (String key : ItemFurniture.NAME_LIST){
			if (ModCommon.isDebug){ModLog.log().debug("register item :"+key);}
			ForgeRegistries.ITEMS.register(furMap.get(key));
		}

        //テクスチャ・モデル指定JSONファイル名の登録。
        if (event.getSide().isClient()) {
        	Map<String, ModelResourceLocation[]> foodResource = ItemFoods.resourceMap();
        	for (String key : ItemFoods.NMAE_LIST){
        		//1IDで複数モデルを登録するなら、上のメソッドで登録した登録名を指定する。
        		int cnt = 0;
        		for (ModelResourceLocation rc : foodResource.get(key)){
        			ModelLoader.setCustomModelResourceLocation(foodMap.get(key), cnt, rc);
        			cnt++;
        		}
        	}

        	Map<String, ModelResourceLocation[]> furResource = ItemFurniture.resourceMap();
        	for (String key : ItemFurniture.NAME_LIST){
        		//1IDで複数モデルを登録するなら、上のメソッドで登録した登録名を指定する。
        		int cnt = 0;
        		for (ModelResourceLocation rc : furResource.get(key)){
        			ModelLoader.setCustomModelResourceLocation(furMap.get(key), cnt, rc);
        			cnt++;
        		}
        	}
        }
	}

	public static void RegisterEntity(CommonProxy proxy){
		EntityRegistry.registerModEntity(new ResourceLocation(ModCommon.MOD_ID, EntityIceCream.NAME),  EntityIceCream.class,EntityIceCream.NAME, ModCommon.ENTITY_ID_ICECREAM, Mod_DiningFurniture.instance, 80, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation(ModCommon.MOD_ID, EntityCrashedIce.NAME), EntityCrashedIce.class,EntityCrashedIce.NAME, ModCommon.ENTITY_ID_CRAHSEDICE, Mod_DiningFurniture.instance, 80, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation(ModCommon.MOD_ID, EntityWoodChair.NAME),EntityWoodChair.class, EntityWoodChair.NAME, ModCommon.ENTITY_ID_WOODCHAIR, Mod_DiningFurniture.instance, 80, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(ModCommon.MOD_ID, EntityZabuton.NAME),EntityZabuton.class, EntityZabuton.NAME, ModCommon.ENTITY_ID_ZABUTON, Mod_DiningFurniture.instance, 80, 3, true);

		proxy.registerTileEntity();
	}

	public static void RegisterRender(CommonProxy proxy){
		proxy.registRender();
	}

	public static boolean flag = true;
	public static void RegisterRecipe(){
		if (flag){return;}
		// 調理台
		GameRegistry.addShapedRecipe(new ResourceLocation(ModCommon.MOD_ID + ":" + BlockFoods.NAME_COOKINGWORKBENCH),
				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
				new ItemStack(BlockFoods.block_cookingworkbench,1),
				"WBH",
				"IGI",
				'W',new ItemStack(Blocks.PLANKS),
				'B',new ItemStack(Items.BUCKET),
				'H',new ItemStack(Items.FLINT_AND_STEEL),
				'I',new ItemStack(Items.IRON_INGOT),
				'G',new ItemStack(Blocks.IRON_BLOCK));

		// 冷凍庫
		GameRegistry.addShapedRecipe(new ResourceLocation(ModCommon.MOD_ID + ":" + BlockFoods.NAME_FREEZER),
				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
				new ItemStack(BlockFoods.block_cookingworkbench,1),
				"ID",
				"IG",
				'D',new ItemStack(Items.IRON_DOOR),
				'I',new ItemStack(Items.IRON_INGOT),
				'G',new ItemStack(Blocks.IRON_BLOCK));

		// かき氷機
		GameRegistry.addShapedRecipe(new ResourceLocation(ModCommon.MOD_ID + ":" + BlockFoods.NAME_ICECRASHER),
				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
				new ItemStack(BlockFoods.block_cookingworkbench,1),
				"III",
				"IYI",
				"I I",
				'Y',new ItemStack(Items.FLINT),
				'I',new ItemStack(Items.IRON_INGOT));

		// 石臼
		GameRegistry.addShapedRecipe(new ResourceLocation(ModCommon.MOD_ID + ":" + BlockFoods.NAME_MILLSTONE),
				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
				new ItemStack(BlockFoods.block_cookingworkbench,1),
				"SS",
				"YY",
				"SS",
				'S',new ItemStack(Blocks.STONE),
				'Y',new ItemStack(Items.FLINT));

		// 塩田
		GameRegistry.addShapedRecipe(new ResourceLocation(ModCommon.MOD_ID + ":" + BlockFoods.NAME_SALTPAN),
				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
				new ItemStack(BlockFoods.block_cookingworkbench,1),
				"W W",
				"WWW",
				'W',new ItemStack(Blocks.PLANKS));


		// 砂糖入り牛乳
		GameRegistry.addShapelessRecipe(new ResourceLocation(ModCommon.MOD_ID + ":" + ItemFoods.NAME_SUGARMILK),
				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
				new ItemStack(ItemFoods.item_sugarmilk,1),
				Ingredient.fromItem(Items.MILK_BUCKET),
				Ingredient.fromItem(Items.SUGAR));
		// シロップかき氷
		for (int i = 1; i < EnumFlapeSyrup.values().length; i++){
			GameRegistry.addShapelessRecipe(new ResourceLocation(ModCommon.MOD_ID + ":" + ItemFoods.NAME_CRASHEDICE + "_" + EnumFlapeSyrup.getValue(i).toString()),
					new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
					new ItemStack(ItemFoods.item_crashedice,1,EnumFlapeSyrup.getValue(i).getDamage()),
					Ingredient.fromStacks(new ItemStack(ItemFoods.item_crashedice,1,0)),
					Ingredient.fromStacks(new ItemStack(ItemFoods.item_syrup,1,EnumFlapeSyrup.getValue(i).getDamage())));
		}

		// 練乳かき氷
		GameRegistry.addShapelessRecipe(new ResourceLocation(ModCommon.MOD_ID + ":" + ItemFoods.NAME_CRASHEDICE_MILK),
				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
				new ItemStack(ItemFoods.item_milkcrashedice,1,0),
				Ingredient.fromStacks(new ItemStack(ItemFoods.item_crashedice,1,0)),
				Ingredient.fromItem(ItemFoods.item_syrupmilk));

		// シロップ練乳かき氷
		for (int i = 1; i < EnumFlapeSyrup.values().length; i++){
			GameRegistry.addShapelessRecipe(new ResourceLocation(ModCommon.MOD_ID + ":" + ItemFoods.NAME_CRASHEDICE_MILK + "_" + EnumFlapeSyrup.getValue(i).toString()),
					new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
					new ItemStack(ItemFoods.item_milkcrashedice,1,EnumFlapeSyrup.getValue(i).getDamage()),
					Ingredient.fromStacks(new ItemStack(ItemFoods.item_milkcrashedice,1,0)),
					Ingredient.fromStacks(new ItemStack(ItemFoods.item_syrup,1,EnumFlapeSyrup.getValue(i).getDamage())));
		}
		for (int i = 1; i < EnumFlapeSyrup.values().length; i++){
			GameRegistry.addShapelessRecipe(new ResourceLocation(ModCommon.MOD_ID + ":" + ItemFoods.NAME_CRASHEDICE_MILK + "_" + EnumFlapeSyrup.getValue(i).toString() + "2"),
					new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
					new ItemStack(ItemFoods.item_milkcrashedice,1,EnumFlapeSyrup.getValue(i).getDamage()),
					Ingredient.fromStacks(new ItemStack(ItemFoods.item_crashedice,1,EnumFlapeSyrup.getValue(i).getDamage())),
					Ingredient.fromStacks(new ItemStack(ItemFoods.item_syrupmilk,1,0)));
		}

//		// パイ
//		GameRegistry.addShapelessRecipe(new ResourceLocation(ModCommon.MOD_ID + ":" + ItemFoods.NAME_PIECEPIE),
//				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
//				new ItemStack(ItemFoods.item_piecepie,7),
//				Ingredient.fromStacks(new ItemStack(BlockFoods.block_pie_hall)));
//		// キャラメルパイ
//		GameRegistry.addShapelessRecipe(new ResourceLocation(ModCommon.MOD_ID + ":" + ItemFoods.NAME_PIECECARAMELPIE),
//				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
//				new ItemStack(ItemFoods.item_piececaramelpie,7),
//				Ingredient.fromStacks(new ItemStack(BlockFoods.block_caramelpie_hall)));
//		// チョコパイ
//		GameRegistry.addShapelessRecipe(new ResourceLocation(ModCommon.MOD_ID + ":" + ItemFoods.NAME_PIECECHOCOPIE),
//				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
//				new ItemStack(ItemFoods.item_row_chocohallpie,7),
//				Ingredient.fromStacks(new ItemStack(BlockFoods.block_chocopie_hall)));
//		// 野菜パイ
//		GameRegistry.addShapelessRecipe(new ResourceLocation(ModCommon.MOD_ID + ":"  + ItemFoods.NAME_PIECESALADAPIE),
//				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
//				new ItemStack(ItemFoods.item_piecesaladapie,7),
//				Ingredient.fromStacks(new ItemStack(BlockFoods.block_salada_hall)));
//		// ミートパイ
//		GameRegistry.addShapelessRecipe(new ResourceLocation(ModCommon.MOD_ID + ":"  + ItemFoods.NAME_PIECEMEETPIE),
//				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
//				new ItemStack(ItemFoods.item_row_meethallpie,7),
//				Ingredient.fromStacks(new ItemStack(BlockFoods.block_meetpie_hall)));
//		// ふぃしゅぱい
//		GameRegistry.addShapelessRecipe(new ResourceLocation(ModCommon.MOD_ID + ":"  + ItemFoods.NAME_PIECEFISHPIE),
//				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
//				new ItemStack(ItemFoods.item_row_fishhallpie,7),
//				Ingredient.fromStacks(new ItemStack(BlockFoods.block_fishpie_hall)));
//		// かぼちゃパイ
//		GameRegistry.addShapelessRecipe(new ResourceLocation(ModCommon.MOD_ID + ":"  + ItemFoods.NAME_PIECEPUMPUKINPIE),
//				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
//				new ItemStack(ItemFoods.item_row_pumpkinhallpie,7),
//				Ingredient.fromStacks(new ItemStack(BlockFoods.block_pumpkinpie_hall)));
//		// リンゴパイ
//		GameRegistry.addShapelessRecipe(new ResourceLocation(ModCommon.MOD_ID + ":"  + ItemFoods.NAME_PIECEAPPLEPIE),
//				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
//				new ItemStack(ItemFoods.item_pieceapplepie,7),
//				Ingredient.fromStacks(new ItemStack(BlockFoods.block_applepie_hall)));
//		// イカ墨パイ
//		GameRegistry.addShapelessRecipe(new ResourceLocation(ModCommon.MOD_ID + ":"  + ItemFoods.NAME_PIECEblackPIE),
//				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
//				new ItemStack(ItemFoods.item_row_blackpie,7),
//				Ingredient.fromStacks(new ItemStack(BlockFoods.block_applepie_hall)));
//		// 腐ったパイ
//		GameRegistry.addShapelessRecipe(new ResourceLocation(ModCommon.MOD_ID + ":" + ItemFoods.NAME_PIECEZOMBIPIE),
//				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
//				new ItemStack(ItemFoods.item_piecezombipie,7),
//				Ingredient.fromStacks(new ItemStack(BlockFoods.block_zombipei_hall)));
		// 万能薬
		GameRegistry.addShapedRecipe(new ResourceLocation(ModCommon.MOD_ID + ":" + ItemFoods.NAME_DUST_FLOWER + "_" + EnumFlowerHalb.PANACEA.toString()),
				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
				new ItemStack(ItemFoods.item_dustflower,1, EnumFlowerHalb.PANACEA.getDamage()),
				"ABC",
				"DEF",
				"GHI",
				'A',new ItemStack(ItemFoods.item_dustflower,9, EnumFlowerHalb.OXEYDAISY.getDamage()),
				'B',new ItemStack(ItemFoods.item_dustflower,9, EnumFlowerHalb.AZUREBLUET.getDamage()),
				'C',new ItemStack(ItemFoods.item_dustflower,9, EnumFlowerHalb.TULIP.getDamage()),
				'D',new ItemStack(ItemFoods.item_dustflower,9, EnumFlowerHalb.DANDELION.getDamage()),
				'E',new ItemStack(ItemFoods.item_dustflower,9, EnumFlowerHalb.SUNFLOWER.getDamage()),
				'F',new ItemStack(ItemFoods.item_dustflower,9, EnumFlowerHalb.ORCHID.getDamage()),
				'G',new ItemStack(ItemFoods.item_dustflower,9, EnumFlowerHalb.LILAC.getDamage()),
				'H',new ItemStack(ItemFoods.item_dustflower,9, EnumFlowerHalb.ALLIUM.getDamage()),
				'I',new ItemStack(ItemFoods.item_dustflower,9, EnumFlowerHalb.ROSE.getDamage()));

		// クッキー入りアイス
		for (int i = 0; i < EnumIceFlavor.values().length; i++){
			GameRegistry.addShapelessRecipe(new ResourceLocation(ModCommon.MOD_ID + ":" + ItemFoods.NAME_ICECREAM_COOKIE + "_"+EnumIceFlavor.getValue(i).toString()),
					new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
					new ItemStack(ItemFoods.item_icecreamcookie,1,EnumIceFlavor.getValue(i).getDamage()),
					Ingredient.fromStacks(new ItemStack(ItemFoods.item_icecream,1,EnumIceFlavor.getValue(i).getDamage())),
					Ingredient.fromStacks(new ItemStack(Items.COOKIE,1)));
		}

		// 作業台2
		GameRegistry.addShapedRecipe(new ResourceLocation(ModCommon.MOD_ID + ":" + BlockFurniture.NAME_DININGWORKBENCH),
				new ResourceLocation(ModCommon.MOD_ID + ":" + "Dining"),
				new ItemStack(BlockFurniture.block_dworkbench,1),
				"WWW",
				"IGI",
				'W',new ItemStack(Blocks.PLANKS),
				'I',new ItemStack(Items.IRON_INGOT),
				'G',new ItemStack(Blocks.IRON_BLOCK));




		// コンデンスミルク
		GameRegistry.addSmelting(ItemFoods.item_sugarmilk,new ItemStack(ItemFoods.item_syrupmilk),0.0f);
		// カラメル
		GameRegistry.addSmelting(Items.SUGAR,new ItemStack(ItemFoods.item_caramel),0.0f);
		// パイ
		GameRegistry.addSmelting(ItemFoods.item_row_hallpie,new ItemStack(BlockFoods.block_pie_hall),0.1f);
		// ミートパイ
		GameRegistry.addSmelting(ItemFoods.item_row_meethallpie,new ItemStack(BlockFoods.block_meetpie_hall),0.1f);
		// フィッシュパイ
		GameRegistry.addSmelting(ItemFoods.item_row_fishhallpie,new ItemStack(BlockFoods.block_fishpie_hall),0.1f);
		// かぼちゃパイ
		GameRegistry.addSmelting(ItemFoods.item_row_pumpkinhallpie,new ItemStack(BlockFoods.block_pumpkinpie_hall),0.1f);
		// 野菜パイ
		GameRegistry.addSmelting(ItemFoods.item_row_saladahallpie,new ItemStack(BlockFoods.block_salada_hall),0.1f);
		// リンゴパイ
		GameRegistry.addSmelting(ItemFoods.item_row_applehallpie,new ItemStack(BlockFoods.block_applepie_hall),0.1f);
		// チョコパイ
		GameRegistry.addSmelting(ItemFoods.item_row_chocohallpie,new ItemStack(BlockFoods.block_chocopie_hall),0.1f);
		// イカ墨パイ
		GameRegistry.addSmelting(ItemFoods.item_row_blackpie,new ItemStack(BlockFoods.block_black_pie),0.1f);
		// 腐ったパイ
		GameRegistry.addSmelting(ItemFoods.item_row_zombihallpie,new ItemStack(BlockFoods.block_zombipei_hall),0.1f);
		// ピザ
		GameRegistry.addSmelting(ItemFoods.item_row_pizza,new ItemStack(BlockFoods.block_pizza),0.1f);
		// 肉ピザ
		GameRegistry.addSmelting(ItemFoods.item_row_meetpizza,new ItemStack(BlockFoods.block_meet_pizza),0.1f);
		// 魚ピザ
		GameRegistry.addSmelting(ItemFoods.item_row_fishpizza,new ItemStack(BlockFoods.block_fish_pizza),0.1f);
		// チーズケーキ
		GameRegistry.addSmelting(BlockFoods.block_reacheese_cake,new ItemStack(BlockFoods.block_bakedcheese_cake),0.1f);


	}

	public static void RegisterMessage(){
		Mod_DiningFurniture.Net_Instance.registerMessage(MessageIceCrasherUpdate.class, MessageIceCrasherUpdate.class, ModCommon.MESSAGE_ID_ICECRASHER_UPDATE, Side.CLIENT);
		Mod_DiningFurniture.Net_Instance.registerMessage(MessageMillStoneUpdate.class,MessageMillStoneUpdate.class, ModCommon.MESSAGE_ID_MILLSTONE_UPDATE, Side.CLIENT);
//		Mod_DiningFurniture.Net_Instance.registerMessage(TrunkMessageHandler.class, TrunkPagePacket.class, ModCommon.MESSAGE_ID_TRUNKDATA, Side.SERVER);
		Mod_DiningFurniture.Net_Instance.registerMessage(MessageFreezer.class, MessageFreezer.class, ModCommon.MESSAGE_ID_FREEZER, Side.CLIENT);
		Mod_DiningFurniture.Net_Instance.registerMessage(MessageSelectMenu.class,MessageSelectMenu.class, ModCommon.MESSAGE_ID_SELECTMENU, Side.SERVER);
		Mod_DiningFurniture.Net_Instance.registerMessage(MessageToServe.class, MessageToServe.class, ModCommon.MESSAGE_ID_TOSERVE, Side.SERVER);
	}

	public static void RegisterEvent(){
		MinecraftForge.EVENT_BUS.register(new LivingDeathEventHandler());
	}



	public static void RegisterSounds(){
		ForgeRegistries.SOUND_EVENTS.register(SoundManager.sound_makeflape);
		ForgeRegistries.SOUND_EVENTS.register(SoundManager.sound_mill);
	}

}
