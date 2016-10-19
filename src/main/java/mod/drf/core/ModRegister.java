package mod.drf.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mod.drf.core.log.ModLog;
import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.Item.ItemFoods.EnumFlapeSyrup;
import mod.drf.foods.Item.ItemFoods.EnumFlowerHalb;
import mod.drf.foods.block.BlockFoods;
import mod.drf.foods.network.MessageFlapeMaker;
import mod.drf.foods.network.MessageMill;
import mod.drf.furniture.block.BlockFurniture;
import mod.drf.furniture.item.ItemFurniture;
import mod.drf.sounds.SoundManager;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood.FishType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
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

		List<String> keyList = new ArrayList<String>();
		keyList.addAll(BlockFoods.NAME_LIST);

		for (String key : keyList){
			if (ModCommon.isDebug){ModLog.log().debug("ブロック登録:"+key+"登録");};
			GameRegistry.register(blockMap.get(key),new ResourceLocation(ModCommon.MOD_ID+":"+key));
			GameRegistry.register(itemMap.get(key),new ResourceLocation(ModCommon.MOD_ID+":"+key));
			if (ModCommon.isDebug){ModLog.log().debug("ブロック登録:"+key+"登録完了");}
		}

		if ( event.getSide().isClient())
		{
			for ( String key: keyList){
				if (!resourceMap.containsKey(key)){continue;}
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
		//itemMap.putAll(ItemFurniture.itemMap());
		Map<String, ModelResourceLocation[]> resourceMap = ItemFoods.resourceMap();
		//resourceMap.putAll(ItemFurniture.resourceMap());
		List<String> keyList = new ArrayList<String>();
		keyList.addAll(ItemFoods.NMAE_LIST);

		for (String key : keyList){
			if (ModCommon.isDebug){ModLog.log().debug("register item :"+key);}
			GameRegistry.register(itemMap.get(key),new ResourceLocation(ModCommon.MOD_ID +":"+key));
		}

        //テクスチャ・モデル指定JSONファイル名の登録。
        if (event.getSide().isClient()) {
        	for (String key : keyList){
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
		//EntityRegistry.registerModEntity(EntityChairZabuton.class, EntityChairZabuton.NAME, 0, Mod_DiningFurniture.instance, 80, 3, true);

		proxy.registerTileEntity();
	}

	public static void RegisterRender(CommonProxy proxy){
		proxy.registRender();
	}

	public static void RegisterRecipe(){
		//***************************************************************************//
		// Blocks
		//***************************************************************************//
		// block_freezer
		GameRegistry.addRecipe(new ItemStack(BlockFoods.block_freezer),
				"ICI",
				"C C",
				"ICI",
				'I',Items.iron_boots,
				'C',Blocks.frosted_ice);
		// block_flapemaker
		GameRegistry.addRecipe(new ItemStack(BlockFoods.block_flapemaker),
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

		//***************************************************************************//
		// Blocks Pie
		//***************************************************************************//
		// block_callamelpie_hall
        GameRegistry.addShapelessRecipe(new ItemStack(BlockFoods.block_caramelpie_hall),
                new ItemStack(BlockFoods.block_pie_hall),
                ItemFoods.item_caramel, ItemFoods.item_caramel, ItemFoods.item_caramel
        );
		// block_cheese
        GameRegistry.addShapelessRecipe(new ItemStack(BlockFoods.block_cheese),
        		Items.milk_bucket,Items.milk_bucket,Items.milk_bucket,
        		ItemFoods.item_salt, ItemFoods.item_mold);
		// block_bluecheese
        GameRegistry.addShapelessRecipe(new ItemStack(BlockFoods.block_bluecheese),
        		Items.milk_bucket,Items.milk_bucket,Items.milk_bucket,
        		ItemFoods.item_salt, ItemFoods.item_bluemold);

		//***************************************************************************//
		// Item Material
		//***************************************************************************//
		// item_butter
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_butter,3),
        		Items.milk_bucket,
        		new ItemStack(Blocks.ice),
        		ItemFoods.item_salt);
		// item_choco
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_choco,3),
        		new ItemStack(Items.dye,1,EnumDyeColor.BROWN.getDyeDamage()),
        		Items.sugar);
		// item_whitechoco
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_whitechoco,3),
        		new ItemStack(Items.dye,1,EnumDyeColor.BROWN.getDyeDamage()),
        		Items.sugar,
        		Items.milk_bucket);
		// item_mold
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_mold,3),
				new ItemStack(Blocks.brown_mushroom));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_mold,3),
				new ItemStack(Blocks.red_mushroom));
		// item_bluemold
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_bluemold,3),
				ItemFoods.item_mold,
				new ItemStack(Items.dye,1,EnumDyeColor.BLUE.getDyeDamage()));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_bluemold,3),
				new ItemStack(Blocks.brown_mushroom),
				new ItemStack(Items.dye,1,EnumDyeColor.BLUE.getDyeDamage()));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_bluemold,3),
				new ItemStack(Blocks.red_mushroom),
				new ItemStack(Items.dye,1,EnumDyeColor.BLUE.getDyeDamage()));

		//***************************************************************************//
		// Item Desert
		//***************************************************************************//
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


		//***************************************************************************//
		// Item piece pie
		//***************************************************************************//
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
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_piececaramelpie,6),
        		new ItemStack(BlockFoods.block_caramelpie_hall));

		//***************************************************************************//
		// Item sandwich
		//***************************************************************************//
		// item_eggsandwich
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_eggsandwich,6),
				"B E",
				" E ",
				"E B",
				'B',Items.bread,
				'E',Items.egg);
		// item_potatsaladasandwitch
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_potatsaladasandwitch,3),
				"B  ",
				" P ",
				"  B",
				'B',Items.bread,
				'P',ItemFoods.item_potatosalada);
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
		// item_pumpkinsaladasandwich
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_pumpkinsaladasandwich,3),
				"B  ",
				" E ",
				"  B",
				'B',Items.bread,
				'E',ItemFoods.item_pumpkinsalada);
		// item_potatosalada
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_potatosalada,1),
        		Items.bowl,
        		Items.potato,
        		Items.carrot,
        		Items.egg,
        		Items.cooked_porkchop);
		// item_pumpkinsalada
        GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_pumpkinsalada,1),
        		Items.bowl,
        		Items.potato,
        		Items.carrot,
        		Items.egg,
        		Items.cooked_porkchop,
        		new ItemStack(Blocks.pumpkin));

		//***************************************************************************//
		// Item row pie
		//***************************************************************************//
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
		RecipeSorter.register(ModCommon.MOD_ID + ":row_meethallpie",RecipeMeetPie.class, RecipeSorter.Category.SHAPELESS,"after:minecraft:shapeless");
        GameRegistry.addRecipe(new RecipeMeetPie());
		// item_row_fishhallpie
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_fishhallpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',Items.fish,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',Items.wheat);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_fishhallpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',Items.fish,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',ItemFoods.item_flour);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_fishhallpie,1),
				"SPS",
				'S',Items.fish,
				'P',ItemFoods.item_row_hallpie);
		// item_row_pumpkinhallpie
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_pumpkinhallpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',Blocks.pumpkin,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',Items.wheat);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_pumpkinhallpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',Blocks.pumpkin,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',ItemFoods.item_flour);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_pumpkinhallpie,1),
				"SPS",
				'S',Blocks.pumpkin,
				'P',ItemFoods.item_row_hallpie);
		// item_row_zombihallpie
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_zombihallpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',Items.rotten_flesh,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',Items.wheat);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_zombihallpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',Items.rotten_flesh,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',ItemFoods.item_flour);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_zombihallpie,1),
				"SPS",
				'S',Items.rotten_flesh,
				'P',ItemFoods.item_row_hallpie);
		// item_row_applehallpie
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_applehallpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',Items.apple,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',Items.wheat);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_applehallpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',Items.apple,
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',ItemFoods.item_flour);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_applehallpie,1),
				"SPS",
				'S',Items.apple,
				'P',ItemFoods.item_row_hallpie);
		// item_row_blackpie
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_blackpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',new ItemStack(Items.dye,1,EnumDyeColor.BLACK.getDyeDamage()),
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',Items.wheat);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_blackpie,1),
				" W ",
				"SBS",
				"FFF",
				'S',new ItemStack(Items.dye,1,EnumDyeColor.BLACK.getDyeDamage()),
				'W',Items.water_bucket,
				'B',ItemFoods.item_butter,
				'F',ItemFoods.item_flour);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_blackpie,1),
				"SPS",
				'S',new ItemStack(Items.dye,1,EnumDyeColor.BLACK.getDyeDamage()),
				'P',ItemFoods.item_row_hallpie);
		// item_row_pizza
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_pizza,1),
				" C ",
				"FFF",
				'C',new ItemStack(BlockFoods.block_cheese),
				'F',Items.wheat);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_pizza,1),
				" C ",
				"FFF",
				'C',new ItemStack(BlockFoods.block_cheese),
				'F',ItemFoods.item_flour);

		//***************************************************************************//
		// Item row pizza
		//***************************************************************************//
		// item_row_meetpizza
		RecipeSorter.register(ModCommon.MOD_ID + ":row_meetpizza",RecipeMeetPizza.class, RecipeSorter.Category.SHAPELESS,"after:minecraft:shapeless");
        GameRegistry.addRecipe(new RecipeMeetPizza());
		// item_row_fishpizza
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_fishpizza,1),
				"SCS",
				"FFF",
				'S',Items.fish,
				'C',new ItemStack(BlockFoods.block_cheese),
				'F',Items.wheat);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_row_fishpizza,1),
				"SCS",
				"FFF",
				'S',Items.fish,
				'C',new ItemStack(BlockFoods.block_cheese),
				'F',ItemFoods.item_flour);

		//***************************************************************************//
		// Item ice mix
		//***************************************************************************//
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_icemix,3,0),
			" A ",
			"SME",
			" B ",
			'M',Items.milk_bucket,
			'S',Items.sugar,
			'E',Items.egg,
			'B',Items.glass_bottle);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_icemix,3,1),
				" AF",
				"SME",
				" B ",
				'F',new ItemStack(Items.dye,1,EnumDyeColor.BROWN.getDyeDamage()),
				'M',Items.milk_bucket,
				'S',Items.sugar,
				'E',Items.egg,
				'B',Items.glass_bottle);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_icemix,3,1),
				"   ",
				"SME",
				" B ",
				'F',new ItemStack(Items.dye,1,EnumDyeColor.BROWN.getDyeDamage()),
				'M',Items.milk_bucket,
				'S',ItemFoods.item_choco,
				'E',Items.egg,
				'B',Items.glass_bottle);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_icemix,3,2),
				" F ",
				"SME",
				" B ",
				'F',new ItemStack(Blocks.pumpkin),
				'M',Items.milk_bucket,
				'S',Items.sugar,
				'E',Items.egg,
				'B',Items.glass_bottle);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_icemix,3,3),
				" F ",
				"SME",
				" B ",
				'F',new ItemStack(Items.dye,1,EnumDyeColor.BLACK.getDyeDamage()),
				'M',Items.milk_bucket,
				'S',Items.sugar,
				'E',Items.egg,
				'B',Items.glass_bottle);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_icemix,3,4),
				" F ",
				"SME",
				" B ",
				'F',Items.melon,
				'M',Items.milk_bucket,
				'S',Items.sugar,
				'E',Items.egg,
				'B',Items.glass_bottle);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_icemix,3,5),
				" F ",
				"SME",
				" B ",
				'F',Items.carrot,
				'M',Items.milk_bucket,
				'S',Items.sugar,
				'E',Items.egg,
				'B',Items.glass_bottle);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_icemix,3,6),
				" F ",
				"SME",
				" B ",
				'F',Items.potato,
				'M',Items.milk_bucket,
				'S',Items.sugar,
				'E',Items.egg,
				'B',Items.glass_bottle);
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_icemix,3,7),
				" F ",
				"SME",
				" B ",
				'F',Items.apple,
				'M',Items.milk_bucket,
				'S',Items.sugar,
				'E',Items.egg,
				'B',Items.glass_bottle);

		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_icemix,3,1),
				new ItemStack(ItemFoods.item_icemix,1,0),new ItemStack(Items.dye,1,EnumDyeColor.BROWN.getDyeDamage()));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_icemix,3,2),
				new ItemStack(ItemFoods.item_icemix,1,0),new ItemStack(Blocks.pumpkin));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_icemix,3,3),
				new ItemStack(ItemFoods.item_icemix,1,0),new ItemStack(Items.dye,1,EnumDyeColor.BLACK.getDyeDamage()));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_icemix,3,4),
				new ItemStack(ItemFoods.item_icemix,1,0),Items.melon);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_icemix,3,5),
				new ItemStack(ItemFoods.item_icemix,1,0),Items.carrot);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_icemix,3,6),
				new ItemStack(ItemFoods.item_icemix,1,0),Items.potato);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_icemix,3,7),
				new ItemStack(ItemFoods.item_icemix,1,0),Items.apple);

		//***************************************************************************//
		// Item syrup
		//***************************************************************************//
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_syrup,1,1),
				"S",
				"B",
				'S',Items.sugar,
				'B',new ItemStack(Items.potionitem,1,0));
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_syrup,1,2),
				"F",
				"S",
				"B",
				'F',new ItemStack(Blocks.pumpkin),
				'S',Items.sugar,
				'B',new ItemStack(Items.potionitem,1,0));
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_syrup,1,3),
				"F",
				"S",
				"B",
				'F',new ItemStack(Blocks.cactus),
				'S',Items.sugar,
				'B',new ItemStack(Items.potionitem,1,0));
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_syrup,1,4),
				"F",
				"S",
				"B",
				'F',new ItemStack(Items.melon),
				'S',Items.sugar,
				'B',new ItemStack(Items.potionitem,1,0));
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_syrup,1,5),
				"F",
				"S",
				"B",
				'F',new ItemStack(Items.apple),
				'S',Items.sugar,
				'B',new ItemStack(Items.potionitem,1,0));

		for (EnumDyeColor color : EnumDyeColor.values()){
			GameRegistry.addRecipe(new ItemStack(ItemFoods.item_syrup,1,color.getDyeDamage()+6),
					"F",
					"S",
					"B",
					'F',new ItemStack(Items.dye,1,color.getDyeDamage()),
					'S',Items.sugar,
					'B',new ItemStack(Items.potionitem,1,0));
		}

		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_syrup,1,2),
				new ItemStack(ItemFoods.item_syrup,1,1),new ItemStack(Blocks.pumpkin));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_syrup,1,3),
				new ItemStack(ItemFoods.item_syrup,1,1),new ItemStack(Blocks.cactus));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_syrup,1,4),
				new ItemStack(ItemFoods.item_syrup,1,1),new ItemStack(Items.melon));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_syrup,1,5),
				new ItemStack(ItemFoods.item_syrup,1,1),new ItemStack(Items.apple));
		for (EnumDyeColor color : EnumDyeColor.values()){
			GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_syrup,1,color.getDyeDamage()+6),
					new ItemStack(ItemFoods.item_syrup,1,1),new ItemStack(Items.dye,1,color.getDyeDamage()));
		}

		// item_syrupmilk
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_syrupmilk,1),
				"S",
				"M",
				"B",
				'S', Items.milk_bucket,
				'M', Items.sugar,
				'B',Items.glass_bottle);

		//***************************************************************************//
		// Item flape
		//***************************************************************************//
		for (EnumFlapeSyrup syrup : EnumFlapeSyrup.values()){
			if (syrup == EnumFlapeSyrup.SYRUP_NONE){continue;}
			GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_flape,1, syrup.getDamage()),
					new ItemStack(ItemFoods.item_flape,1,0),
					new ItemStack(ItemFoods.item_syrup,1,syrup.getDamage()));
		}
		// item_milkflape
		for (EnumFlapeSyrup syrup : EnumFlapeSyrup.values()){
			GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_milkflape,1, syrup.getDamage()),
					new ItemStack(ItemFoods.item_flape,1,syrup.getDamage()),
					ItemFoods.item_syrupmilk);
			if (syrup == EnumFlapeSyrup.SYRUP_NONE){continue;}
			GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_milkflape,1, syrup.getDamage()),
					new ItemStack(ItemFoods.item_flape,1,0),
					new ItemStack(ItemFoods.item_syrup,1,syrup.getDamage()),
					ItemFoods.item_syrupmilk);
		}
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_milkflape,1,0),
				new ItemStack(ItemFoods.item_flape,1,0),
				ItemFoods.item_syrupmilk);

		//***************************************************************************//
		// Item sugar water
		//***************************************************************************//
		for (EnumFlapeSyrup syrup : EnumFlapeSyrup.values()){
			if (syrup == EnumFlapeSyrup.SYRUP_NONE){continue;}
			GameRegistry.addRecipe(new ItemStack(ItemFoods.item_sugarwater,1,syrup.getDamage()),
					"S",
					"B",
					'S', Items.stick,
					'B',new ItemStack(ItemFoods.item_syrup,1,syrup.getDamage()));
		}
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_sugarwater,1,1),
				"  T",
				" S ",
				"B  ",
				'T',Items.stick,
				'S',Items.sugar,
				'B',new ItemStack(Items.potionitem,1,0));
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_sugarwater,1,2),
				"  T",
				" SF",
				"B  ",
				'T',Items.stick,
				'F',new ItemStack(Blocks.pumpkin),
				'S',Items.sugar,
				'B',new ItemStack(Items.potionitem,1,0));
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_sugarwater,1,3),
				"  T",
				" SF",
				"B  ",
				'T',Items.stick,
				'F',new ItemStack(Blocks.cactus),
				'S',Items.sugar,
				'B',new ItemStack(Items.potionitem,1,0));
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_sugarwater,1,4),
				"  T",
				" SF",
				"B  ",
				'T',Items.stick,
				'F',new ItemStack(Items.melon),
				'S',Items.sugar,
				'B',new ItemStack(Items.potionitem,1,0));
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_sugarwater,1,5),
				"  T",
				" SF",
				"B  ",
				'T',Items.stick,
				'F',new ItemStack(Items.apple),
				'S',Items.sugar,
				'B',new ItemStack(Items.potionitem,1,0));

		for (EnumDyeColor color : EnumDyeColor.values()){
			GameRegistry.addRecipe(new ItemStack(ItemFoods.item_sugarwater,1,color.getDyeDamage()+6),
					"  T",
					" SF",
					"B  ",
					'T',Items.stick,
					'F',new ItemStack(Items.dye,1,color.getDyeDamage()),
					'S',Items.sugar,
					'B',new ItemStack(Items.potionitem,1,0));
		}

		//***************************************************************************//
		// Item noodle
		//***************************************************************************//
		// item_udon
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_udon,6),
				" W ",
				"FSF",
				" F ",
				'F',ItemFoods.item_flour,
				'S',ItemFoods.item_salt,
				'W',Items.water_bucket);
		// item_pasta
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_pasta,6),
		"FWF",
		" F ",
		'F',ItemFoods.item_flour,
		'W',Items.water_bucket);
		// item_ramen
		GameRegistry.addRecipe(new ItemStack(ItemFoods.item_ramen,6),
				"SWS",
				"FSF",
				" F ",
				'F',ItemFoods.item_flour,
				'S',ItemFoods.item_salt,
				'W',Items.water_bucket);
		// item_meetpasta
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_meetpasta,1),
				ItemFoods.item_pasta,
				ItemFoods.item_millbeef,
				ItemFoods.item_millpoke,
				Items.bowl);
		// item_fishpasta
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_fishpasta,1),
				new ItemStack(Items.fish,1,FishType.COD.getMetadata()),
				new ItemStack(Items.fish,1,FishType.SALMON.getMetadata()),
				ItemFoods.item_pasta,
				Items.bowl);
		// item_blackpasta
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_blackpasta,1),
				new ItemStack(Items.dye,1,EnumDyeColor.BLACK.getDyeDamage()),
				ItemFoods.item_pasta,
				Items.bowl);
		// item_zaruudon
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_zaruudon,1),
				ItemFoods.item_udon,
				Items.bowl);
		// item_kakeudon
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_kakeudon,1),
				ItemFoods.item_udon,
				Items.water_bucket,
				Items.bowl);
		// item_tsukimiuudon
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_tsukimiuudon,1),
				ItemFoods.item_udon,
				Items.egg,
				Items.water_bucket,
				Items.bowl);
		// item_nikuudon
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_nikuudon,1),
		ItemFoods.item_udon,
		Items.beef,
		Items.water_bucket,
		Items.bowl);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_nikuudon,1),
		ItemFoods.item_udon,
		Items.porkchop,
		Items.water_bucket,
		Items.bowl);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_nikuudon,1),
		ItemFoods.item_udon,
		Items.chicken,
		Items.water_bucket,
		Items.bowl);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_nikuudon,1),
		ItemFoods.item_udon,
		Items.mutton,
		Items.water_bucket,
		Items.bowl);
		// item_meetramen
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_meetramen,1),
		ItemFoods.item_ramen,
		Items.porkchop,
		Items.water_bucket,
		Items.bowl);
		// item_fishramen
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_fishramen,1),
		ItemFoods.item_ramen,
		new ItemStack(Items.fish,1,FishType.COD.getMetadata()),
		new ItemStack(Items.fish,1,FishType.SALMON.getMetadata()),
		Items.water_bucket,
		Items.bowl);
		// item_tsukimiramen
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_tsukimiramen,1),
		ItemFoods.item_ramen,
		Items.egg,
		Items.water_bucket,
		Items.bowl);

		//***************************************************************************//
		// Item flower tea
		//***************************************************************************//
		// item_flowerdust
		GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.PANACEA.getDamage()),
				new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.ALLIUM.getDamage()),
				new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.TULIP.getDamage()),
				new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.SUNFLOWER.getDamage()),
				new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.DANDELION.getDamage()),
				new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.ROSE.getDamage()),
				new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.POPY.getDamage()),
				new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.ORCHID.getDamage()),
				new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.LILAC.getDamage()),
				new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.AZUREBLUET.getDamage()));
		// item_teaflower
		for (EnumFlowerHalb halb : EnumFlowerHalb.values()){
			GameRegistry.addShapelessRecipe(new ItemStack(ItemFoods.item_teaflower,1,halb.getDamage()),
					new ItemStack(ItemFoods.item_dustflower,1,halb.getDamage()),
					new ItemStack(Items.potionitem,1,0));
		}

		//***************************************************************************//
		// Item Cake
		//***************************************************************************//
		// block_choco_cake
		GameRegistry.addRecipe(new ItemStack(BlockFoods.block_choco_cake,1),
				"MMM",
				"FEF",
				"WWW",
				'M',Items.milk_bucket,
				'E',Items.egg,
				'W',Items.wheat,
				'F',ItemFoods.item_choco);
		// block_apple_cake
		GameRegistry.addRecipe(new ItemStack(BlockFoods.block_apple_cake,1),
				"MMM",
				"FEF",
				"WWW",
				'M',Items.milk_bucket,
				'E',Items.egg,
				'W',Items.wheat,
				'F',Items.apple);
		// block_salada_cake
		GameRegistry.addRecipe(new ItemStack(BlockFoods.block_salada_cake,1),
				"MMM",
				"FEF",
				"WWW",
				'M',Items.milk_bucket,
				'E',Items.egg,
				'W',Items.wheat,
				'F',Items.carrot);
		// block_mellon_cake
		GameRegistry.addRecipe(new ItemStack(BlockFoods.block_mellon_cake,1),
				"MMM",
				"FEF",
				"WWW",
				'M',Items.milk_bucket,
				'E',Items.egg,
				'W',Items.wheat,
				'F',Items.melon);
		// block_pumpkin_cake
		GameRegistry.addRecipe(new ItemStack(BlockFoods.block_pumpkin_cake,1),
				"MMM",
				"FEF",
				"WWW",
				'M',Items.milk_bucket,
				'E',Items.egg,
				'W',Items.wheat,
				'F',new ItemStack(Blocks.pumpkin));
		// block_black_cake
		GameRegistry.addRecipe(new ItemStack(BlockFoods.block_black_cake,1),
				"MMM",
				"FEF",
				"WWW",
				'M',Items.milk_bucket,
				'E',Items.egg,
				'W',Items.wheat,
				'F',new ItemStack(Items.dye,1,EnumDyeColor.BLACK.getDyeDamage()));
		// block_zombi_cake
		GameRegistry.addRecipe(new ItemStack(BlockFoods.block_zombi_cake,1),
				"MMM",
				"FEF",
				"WWW",
				'M',Items.milk_bucket,
				'E',Items.egg,
				'W',Items.wheat,
				'F',Items.rotten_flesh);
		// block_reacheese_cake
		GameRegistry.addRecipe(new ItemStack(BlockFoods.block_reacheese_cake),
				"   ",
				" C ",
				"KKK",
				'C',new ItemStack(BlockFoods.block_cheese),
				'K',Items.cookie);

		// block_bakedcheese_cake
		GameRegistry.addSmelting(BlockFoods.block_reacheese_cake,new ItemStack(BlockFoods.block_bakedcheese_cake),0.2f);
		// block_pie_hall
		GameRegistry.addSmelting(ItemFoods.item_row_hallpie,new ItemStack(BlockFoods.block_pie_hall),0.2f);
		// block_chocopie_hall
		GameRegistry.addSmelting(ItemFoods.item_row_chocohallpie,new ItemStack(BlockFoods.block_chocopie_hall),0.2f);
		// block_salada_hall
		GameRegistry.addSmelting(ItemFoods.item_row_saladahallpie,new ItemStack(BlockFoods.block_salada_hall),0.2f);
		// block_meetpie_hall
		GameRegistry.addSmelting(ItemFoods.item_row_meethallpie,new ItemStack(BlockFoods.block_meetpie_hall),0.2f);
		// block_fishpie_hall
		GameRegistry.addSmelting(ItemFoods.item_row_fishhallpie,new ItemStack(BlockFoods.block_fishpie_hall),0.2f);
		// block_pumpkinpie_hall
		GameRegistry.addSmelting(ItemFoods.item_row_pumpkinhallpie,new ItemStack(BlockFoods.block_pumpkinpie_hall),0.2f);
		// block_applepie_hall
		GameRegistry.addSmelting(ItemFoods.item_row_applehallpie,new ItemStack(BlockFoods.block_applepie_hall),0.2f);
		// block_black_pie
		GameRegistry.addSmelting(ItemFoods.item_row_blackpie,new ItemStack(BlockFoods.block_black_pie),0.2f);
		// block_zombipei_hall
		GameRegistry.addSmelting(ItemFoods.item_row_zombihallpie,new ItemStack(BlockFoods.block_zombipei_hall),0.2f);
		// block_pizza
		GameRegistry.addSmelting(ItemFoods.item_row_pizza,new ItemStack(BlockFoods.block_pizza),0.2f);
		// block_meet_pizza
		GameRegistry.addSmelting(ItemFoods.item_row_meetpizza,new ItemStack(BlockFoods.block_meet_pizza),0.2f);
		// block_fish_pizza
		GameRegistry.addSmelting(ItemFoods.item_row_fishpizza,new ItemStack(BlockFoods.block_fish_pizza),0.2f);
		// item_caramel
		GameRegistry.addSmelting(Items.sugar,new ItemStack(ItemFoods.item_caramel),0.1f);


		// item_icecream ← 冷蔵庫
		// item_flape ← かき氷器
		// item_icecandy ← 冷蔵庫
		// item_flour ← 製粉器
		// item_millbeef ← 製粉器
		// item_millpoke ← 製粉器
		// item_millchikin ← 製粉器
		// item_millmutton ← 製粉器
		// item_dustflower ← 製粉器




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

	}

	public static void RegisterMessage(){
		Mod_DiningFurniture.Net_Instance.registerMessage(MessageFlapeMaker.class, MessageFlapeMaker.class, ModCommon.MESSAGE_ID_FLAPEMAKER, Side.CLIENT);
		Mod_DiningFurniture.Net_Instance.registerMessage(MessageMill.class,MessageMill.class, ModCommon.MESSAGE_ID_MILL, Side.CLIENT);
//		Mod_DiningFurniture.Net_Instance.registerMessage(TrunkMessageHandler.class, TrunkPagePacket.class, ModCommon.MESSAGE_ID_TRUNKDATA, Side.SERVER);
	}



	public static void RegisterSounds(){
		GameRegistry.register(SoundManager.sound_makeflape);
	}

}
