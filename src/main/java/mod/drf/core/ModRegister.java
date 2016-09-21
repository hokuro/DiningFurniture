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
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.oredict.RecipeSorter;

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
		// block_freezer
		GameRegistry.addRecipe(new ItemStack(BlockFoods.block_freezer),
				"III",
				"IFI",
				"I I",
				'I',Items.iron_ingot,
				'F',Items.flint);
		// block_mill
		GameRegistry.addRecipe(new ItemStack(BlockFoods.block_mill),
				"SSS",
				"FFF",
				"SSS",
				'S',Blocks.stone,
				'F',Items.flint);
		// block_saltpan
		GameRegistry.addRecipe(new ItemStack(BlockFoods.block_saltpan),
				"W W",
				"W W",
				"WWW",
				'W',Blocks.planks);
		// block_callamelpie_hall
        GameRegistry.addShapelessRecipe(new ItemStack(BlockFoods.block_callamelpie_hall),
                new ItemStack(BlockFoods.block_pie_hall),
                ItemFoods.item_caramel, ItemFoods.item_caramel, ItemFoods.item_caramel
        );
		// item_butter
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_butter,3),
        		Items.milk_bucket,
        		new ItemStack(Blocks.ice),
        		ItemFoods.item_salt);
		// block_cheese
        GameRegistry.addShapelessRecipe(new ItemStack(BlockFoods.block_cheese),
        		Items.milk_bucket,Items.milk_bucket,Items.milk_bucket,
        		ItemFoods.item_salt, ItemFoods.item_mold);
		// block_bluecheese
        GameRegistry.addShapelessRecipe(new ItemStack(BlockFoods.block_bluecheese),
        		Items.milk_bucket,Items.milk_bucket,Items.milk_bucket,
        		ItemFoods.item_salt, ItemFoods.item_bluemold);

		// block_reacheese_cake
		GameRegistry.addRecipe(new ItemStack(BlockFoods.block_reacheese_cake),
				"   ",
				" C ",
				"KKK",
				'C',new ItemStack(BlockFoods.block_cheese),
				'K',Items.cookie);
		// item_choco
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_choco,3),
        		new ItemStack(Blocks.cocoa),
        		Items.sugar);
		// item_whitechoco
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_whitechoco,3),
        		new ItemStack(Blocks.cocoa),
        		Items.sugar,
        		Items.milk_bucket);
		// item_pudding
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_pudding,3),
				" S ",
				" M ",
				"EEE",
				'S',Items.sugar,
				'E',Items.egg,
				'M',Items.milk_bucket);
		// item_pumpkinpudding
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_pumpkinpudding,3),
				" S ",
				"PM ",
				"EEE",
				'P',new ItemStack(Blocks.pumpkin),
				'S',Items.sugar,
				'E',Items.egg,
				'M',Items.milk_bucket);
		// item_piecepie
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_piecepie,6),
        		new ItemStack(BlockFoods.block_pie_hall));
		// item_piecechocopie
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_piecechocopie,6),
        		new ItemStack(BlockFoods.block_chocopie_hall));
		// item_piecesaladapie
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_piecesaladapie,6),
        		new ItemStack(BlockFoods.block_salada_hall));
		// item_piecemeetpie
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_piecemeetpie,6),
        		new ItemStack(BlockFoods.block_meetpie_hall));
		// item_piecefishpie
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_piecefishpie,6),
        		new ItemStack(BlockFoods.block_fishpie_hall));
		// item_piecepumpukinpie
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_piecepumpukinpie,6),
        		new ItemStack(BlockFoods.block_pumpkinpie_hall));
		// item_piecezombipie
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_piecezombipie,6),
        		new ItemStack(BlockFoods.block_zombipei_hall));
		// item_pieceapplepie
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_pieceapplepie,6),
        		new ItemStack(BlockFoods.block_applepie_hall));
		// item_pieceblackpie
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_pieceblackpie,6),
        		new ItemStack(BlockFoods.block_black_pie));
		// item_piececallamelpie
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_piececallamelpie,6),
        		new ItemStack(BlockFoods.block_callamelpie_hall));
		// item_eggsandwich
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_eggsandwich,6),
				"B E",
				" E ",
				"E B",
				'B',Items.bread,
				'E',Items.egg);
		// item_potetsaladasandwitch
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_potetsaladasandwitch,3),
				"B  ",
				" P ",
				"  B",
				'B',Items.bread,
				'P',ItemFoods.item_potetosalada);
		// item_hamsandwich
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_hamsandwich,6),
				"B M",
				" M ",
				"M B",
				'B',Items.bread,
				'M',Items.cooked_porkchop);
		// item_muttonsandwich
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_muttonsandwich,6),
				"B E",
				" E ",
				"E B",
				'B',Items.bread,
				'E',Items.cooked_mutton);
		// item_stakesandwich
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_stakesandwich,6),
				"B E",
				" E ",
				"E B",
				'B',Items.bread,
				'E',Items.cooked_beef);
		// item_chikensandwich
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_chikensandwich,6),
				"B E",
				" E ",
				"E B",
				'B',Items.bread,
				'E',Items.cooked_chicken);
		// item_chocosandwich
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_chocosandwich,6),
				"B E",
				" E ",
				"E B",
				'B',Items.bread,
				'E',ItemFoods.item_choco);
		// item_potetosalada
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_potetosalada,1),
        		Items.bowl,
        		Items.potato,
        		Items.carrot,
        		Items.egg,
        		Items.cooked_porkchop);
		// item_pumpkinsalada
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_potetosalada,1),
        		Items.bowl,
        		Items.potato,
        		Items.carrot,
        		Items.egg,
        		Items.cooked_porkchop,
        		new ItemStack(Blocks.pumpkin));
		// item_pumpkinsaladasandwich
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_pumpkinsaladasandwich,3),
				"B  ",
				" E ",
				"  B",
				'B',Items.bread,
				'E',ItemFoods.item_pumpkinsalada);
		// item_mold
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_mold,3),
				new ItemStack(Blocks.brown_mushroom));
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_mold,3),
				new ItemStack(Blocks.red_mushroom));
		// item_bluemold
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_bluemold,3),
				ItemFoods.item_bluemold,
				new ItemStack(Items.dye,1,EnumDyeColor.BLUE.getDyeDamage()));
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_bluemold,3),
				new ItemStack(Blocks.brown_mushroom),
				new ItemStack(Items.dye,1,EnumDyeColor.BLUE.getDyeDamage()));
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_bluemold,3),
				new ItemStack(Blocks.red_mushroom),
				new ItemStack(Items.dye,1,EnumDyeColor.BLUE.getDyeDamage()));
		// item_row_hallpie
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_hallpie,1),
				" W ",
				" B ",
				"FFF",
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',Items.wheat);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_hallpie,1),
				" W ",
				" B ",
				"FFF",
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',ItemFoods.item_flour);

		// item_row_chocohallpie
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_chocohallpie,1),
				" W ",
				"CBC",
				"FFF",
				'C',ItemFoods.item_choco,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',Items.wheat);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_chocohallpie,1),
				" W ",
				"CBC",
				"FFF",
				'C',ItemFoods.item_choco,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',ItemFoods.item_flour);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_chocohallpie,1),
				"CPC",
				'C',ItemFoods.item_choco,
				'P',ItemFoods.item_row_hallpie);
		// item_row_saladahallpie
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				" W ",
				"PBC",
				"FFF",
				'P',Items.potato,
				'C',Items.carrot,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',Items.wheat);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				" W ",
				"PBC",
				"FFF",
				'P',Items.potato,
				'C',Items.carrot,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',ItemFoods.item_flour);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				"CSP",
				'P',Items.potato,
				'C',Items.carrot,
				'S',ItemFoods.item_row_hallpie);
		// item_row_meethallpie
		RecipeSorter.register(ModCommon.MOD_ID + ":row_meethallpie",RecipeMeetPie.class, RecipeSorter.Category.SHAPED,"after:minecraft:shaped");
        GameRegistry.addRecipe(new RecipeMeetPie());
		// item_row_fishhallpie
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',Items.fish,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',Items.wheat);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',Items.fish,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',ItemFoods.item_flour);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				"SPS",
				'S',Items.fish,
				'P',ItemFoods.item_row_hallpie);
		// item_row_pumpkinhallpie
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',Blocks.pumpkin,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',Items.wheat);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',Blocks.pumpkin,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',ItemFoods.item_flour);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				"SPS",
				'S',Blocks.pumpkin,
				'P',ItemFoods.item_row_hallpie);
		// item_row_zombihallpie
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',Items.rotten_flesh,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',Items.wheat);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',Items.rotten_flesh,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',ItemFoods.item_flour);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				"SPS",
				'S',Items.rotten_flesh,
				'P',ItemFoods.item_row_hallpie);
		// item_row_applehallpie
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',Items.apple,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',Items.wheat);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',Items.apple,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',ItemFoods.item_flour);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				"SPS",
				'S',Items.apple,
				'P',ItemFoods.item_row_hallpie);
		// item_row_blackpie
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',new ItemStack(Items.dye,1,EnumDyeColor.BLACK.getDyeDamage()),
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',Items.wheat);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',new ItemStack(Items.dye,1,EnumDyeColor.BLACK.getDyeDamage()),
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',ItemFoods.item_flour);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				"SPS",
				'S',new ItemStack(Items.dye,1,EnumDyeColor.BLACK.getDyeDamage()),
				'P',ItemFoods.item_row_hallpie);
		// item_row_pizza
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				" C ",
				"FFF",
				'C',new ItemStack(BlockFoods.block_cheese),
				'F',Items.wheat);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				" C ",
				"FFF",
				'C',new ItemStack(BlockFoods.block_cheese),
				'F',ItemFoods.item_flour);
		// item_row_meetpizza
		RecipeSorter.register(ModCommon.MOD_ID + ":row_meetpizza",RecipeMeetPizza.class, RecipeSorter.Category.SHAPED,"after:minecraft:shaped");
        GameRegistry.addRecipe(new RecipeMeetPizza());
		// item_row_fishpizza
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				"SCS",
				"FFF",
				'S',Items.fish,
				'C',new ItemStack(BlockFoods.block_cheese),
				'F',Items.wheat);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				"SCS",
				"FFF",
				'S',Items.fish,
				'C',new ItemStack(BlockFoods.block_cheese),
				'F',ItemFoods.item_flour);
		// item_icemix
		// item_icecream
		// item_syrup
		// item_syrupmilk
		// item_flape
		// item_milkflape
		// item_sugarwater
		// item_icecandy
		// item_flour
		// item_udon
		// item_pasta
		// item_ramen
		// item_meetpasta
		// item_fishpasta
		// item_blackpasta
		// item_zaruudon
		// item_kakeudon
		// item_tsukimiuudon
		// item_nikuudon
		// item_meetramen
		// item_fishramen
		// item_tsukimiramen
		// item_dustflower
		// item_teaflower


		// block_pie_hall
		// block_chocopie_hall
		// block_salada_hall
		// block_meetpie_hall
		// block_fishpie_hall
		// block_pumpkinpie_hall
		// block_applepie_hall
		// block_black_pie
		// block_zombipei_hall
		// block_choco_cake
		// block_apple_cake
		// block_salada_cake
		// block_mellon_cake
		// block_pumpkin_cake
		// block_bakedcheese_cake
		// block_black_cake
		// block_zombi_cake
		// block_pizza
		// block_meet_pizza
		// block_fish_pizza
		// item_caramel





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
//			GameRegistry.addRecipe(new ItemStack(BlockCore.getBlock(BlockCore.NAME_black_CAEK),1,0),
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
