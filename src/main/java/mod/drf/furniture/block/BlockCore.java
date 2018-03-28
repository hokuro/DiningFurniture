package mod.drf.furniture.block;

import java.util.HashMap;
import java.util.Map;

import mod.drf.core.ModCommon;
import mod.drf.core.log.ModLog;
import mod.drf.furniture.block.item.BlockItemTemperedGlass;
import mod.drf.furniture.block.item.BlockItemTemperedGlassPane;
import mod.drf.furniture.block.item.BlockItemTemperedStainedGlass;
import mod.drf.furniture.block.item.BlockItemTemperedStainedGlassPane;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockCore {

	// ############作業台#######################Workbench
	// 加工台
	public static final String NAME_DININGWORKBENCH = "dworkbench";

	// ############ガラス系#######################
	// 強化ガラス
	public static final String NAME_TEMPEREDGLASS = "tempglass";
	// 強化ガラスパネル
	public static final String NAME_TEMPEREDGLASSPANEL = "tempglass_panel";
	// 強化色付きガラス
	public static final String NAME_TEMPEREDSTAINEDGLASS = "tempstainedglass";
	// 強化色付きガラスパネル
	public static final String NAME_TEMPEREDSTAINEDGLASSPANEL = "tempstainedglass_panel";
	// 水平ガラスパネル
	public static final String NAME_HORIZONTALGLASSPANEL = "horizontalglass_panel";
	// 水平色付きガラスパネル
	public static final String NAME_HORIZONTALSTAINEDGLASSPANEL = "horizontalstaindglass_panel";
	// 水平強化ガラスパネル
	public static final String NAME_HORIZONTALTEMPERDGLASSPANEL = "htempglass_panel";
	// 水平強化色付きガラスパネル
	public static final String NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL = "htempstainedglass_panel";



	public static final String NAME_UNLOCAL_DININGWORKBENCH = NAME_DININGWORKBENCH;
	public static final String NAME_UNLOCAL_TEMPEREDGLASS = NAME_TEMPEREDGLASS;
	public static final String NAME_UNLOCAL_TEMPEREDGLASSPANEL = NAME_TEMPEREDGLASSPANEL;
	public static final String NAME_UNLOCAL_TEMPEREDSTAINEDGLASS = NAME_TEMPEREDSTAINEDGLASS;
	public static final String NAME_UNLOCAL_TEMPEREDSTAINEDGLASSPANEL = NAME_TEMPEREDSTAINEDGLASSPANEL;
	public static final String NAME_UNLOCAL_HORIZONTALGLASSPANEL = NAME_HORIZONTALGLASSPANEL;
	public static final String NAME_UNLOCAL_HORIZONTALSTAINEDGLASSPANEL = NAME_HORIZONTALSTAINEDGLASSPANEL;
	public static final String NAME_UNLOCAL_HORIZONTALTEMPERDGLASSPANEL = NAME_HORIZONTALTEMPERDGLASSPANEL;
	public static final String NAME_UNLOCAL_HORIZONTALTEMPERDSTAINDGLASSPANEL = NAME_UNLOCAL_HORIZONTALTEMPERDGLASSPANEL;

	private static Map<String,Block> blocks = null;
	private static Map<String,Item> blkitems = null;
	private static Map<String,ResourceLocation[]> resource = null;


	public static void registerBlocks(){
		ModLog.log().debug("start initBlocks");
		blocks = new HashMap<String,Block>();
		blkitems = new HashMap<String,Item>();
		resource = new HashMap<String,ResourceLocation[]>();

		// 加工台
		ModLog.log().debug("作業台生成");
		blocks.put(NAME_DININGWORKBENCH, (new BlockDiningWorkBench())
				.setRegistryName(NAME_DININGWORKBENCH)
				.setUnlocalizedName(NAME_UNLOCAL_DININGWORKBENCH));

		// ガラス
		ModLog.log().debug("ガラスブロック生成");
		blocks.put(NAME_TEMPEREDGLASS,(new BlockTemperedGlass(Material.GLASS)
				.setHardness(15.0F)
				.setResistance(2000.0F)
				.setRegistryName(NAME_TEMPEREDGLASS)
				.setUnlocalizedName(NAME_UNLOCAL_TEMPEREDGLASS)));
		blkitems.put(NAME_TEMPEREDGLASS, new BlockItemTemperedGlass(blocks.get(NAME_TEMPEREDGLASS)).setRegistryName(NAME_TEMPEREDGLASS));
		resource.put(NAME_TEMPEREDGLASS, new ResourceLocation[]{blocks.get(NAME_TEMPEREDGLASS).getRegistryName()});
		ModLog.log().debug("ガラスブロック生成完了");

		// ガラスパネル
		ModLog.log().debug("ガラスパネルブロック生成");
		blocks.put(NAME_TEMPEREDGLASSPANEL,(new BlockTemperedGlassPanel(Material.GLASS)
						.setHardness(10.0F)
						.setResistance(2000.0F)
						.setUnlocalizedName(NAME_UNLOCAL_TEMPEREDGLASSPANEL)
						.setRegistryName(NAME_TEMPEREDGLASSPANEL)));
		blkitems.put(NAME_TEMPEREDGLASSPANEL, new BlockItemTemperedGlassPane(blocks.get(NAME_TEMPEREDGLASSPANEL)).setRegistryName(NAME_TEMPEREDGLASSPANEL));
		resource.put(NAME_TEMPEREDGLASSPANEL, new ResourceLocation[]{blocks.get(NAME_TEMPEREDGLASSPANEL).getRegistryName()});
		ModLog.log().debug("ガラスパネルブロック生成完了");



		// ステンドグラス
		ModLog.log().debug("ステンドグラスブロック生成");
		blocks.put(NAME_TEMPEREDSTAINEDGLASS,(new BlockTemperedStainedGlass()
						.setHardness(15.0F)
						.setResistance(2000.0F)
						.setUnlocalizedName(NAME_UNLOCAL_TEMPEREDSTAINEDGLASS)
						.setRegistryName(NAME_TEMPEREDSTAINEDGLASS)));
		blkitems.put(NAME_TEMPEREDSTAINEDGLASS, new BlockItemTemperedStainedGlass(blocks.get(NAME_TEMPEREDSTAINEDGLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS));
		resource.put(NAME_TEMPEREDSTAINEDGLASS, new ResourceLocation[]{
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASS+"_"+EnumDyeColor.WHITE),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASS+"_"+EnumDyeColor.ORANGE),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASS+"_"+EnumDyeColor.MAGENTA),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASS+"_"+EnumDyeColor.LIGHT_BLUE),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASS+"_"+EnumDyeColor.YELLOW),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASS+"_"+EnumDyeColor.LIME),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASS+"_"+EnumDyeColor.PINK),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASS+"_"+EnumDyeColor.GRAY),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASS+"_"+EnumDyeColor.SILVER),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASS+"_"+EnumDyeColor.CYAN),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASS+"_"+EnumDyeColor.PURPLE),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASS+"_"+EnumDyeColor.BLUE),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASS+"_"+EnumDyeColor.BROWN),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASS+"_"+EnumDyeColor.GREEN),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASS+"_"+EnumDyeColor.RED),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASS+"_"+EnumDyeColor.BLACK)
				});
		ModLog.log().debug("ガラスパネルブロック生成完了");

		// ステンドガラスパネル

		ModLog.log().debug("ステンドグラスパネル生成");
		blocks.put(NAME_TEMPEREDSTAINEDGLASSPANEL,(new BlockTemperedStainedGlassPanel()
						.setHardness(10.0F)
						.setResistance(2000.0F)
						.setUnlocalizedName(NAME_UNLOCAL_TEMPEREDSTAINEDGLASSPANEL)
						.setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL)));
		blkitems.put(NAME_TEMPEREDSTAINEDGLASSPANEL, new BlockItemTemperedStainedGlassPane(blocks.get(NAME_TEMPEREDSTAINEDGLASSPANEL)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL));
		resource.put(NAME_TEMPEREDSTAINEDGLASSPANEL, new ResourceLocation[]{
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASSPANEL+"_"+EnumDyeColor.WHITE),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASSPANEL+"_"+EnumDyeColor.ORANGE),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASSPANEL+"_"+EnumDyeColor.MAGENTA),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASSPANEL+"_"+EnumDyeColor.LIGHT_BLUE),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASSPANEL+"_"+EnumDyeColor.YELLOW),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASSPANEL+"_"+EnumDyeColor.LIME),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASSPANEL+"_"+EnumDyeColor.PINK),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASSPANEL+"_"+EnumDyeColor.GRAY),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASSPANEL+"_"+EnumDyeColor.SILVER),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASSPANEL+"_"+EnumDyeColor.CYAN),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASSPANEL+"_"+EnumDyeColor.PURPLE),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASSPANEL+"_"+EnumDyeColor.BLUE),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASSPANEL+"_"+EnumDyeColor.BROWN),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASSPANEL+"_"+EnumDyeColor.GREEN),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASSPANEL+"_"+EnumDyeColor.RED),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDSTAINEDGLASSPANEL+"_"+EnumDyeColor.BLACK)
				});
		ModLog.log().debug("ステンドグラスパネル生成完了");

		// 天井ガラスパネル
		ModLog.log().debug("平行ガラスパネル生成");
		blocks.put(NAME_HORIZONTALGLASSPANEL, (new BlockHorizontalGlassPanel(Material.GLASS)
				.setHardness(0.3F)
				.setUnlocalizedName(NAME_UNLOCAL_HORIZONTALGLASSPANEL)
				.setRegistryName(NAME_HORIZONTALGLASSPANEL)));
		blkitems.put(NAME_HORIZONTALGLASSPANEL, new BlockItemTemperedGlassPane(blocks.get(NAME_HORIZONTALGLASSPANEL)).setRegistryName(NAME_HORIZONTALGLASSPANEL));
		resource.put(NAME_HORIZONTALGLASSPANEL, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALGLASSPANEL)});
		ModLog.log().debug("平行ガラスパネル生成完了");


		// 天井ステンドガラスパネル

		ModLog.log().debug("天井ステンドグラスパネル生成");
		blocks.put(NAME_HORIZONTALSTAINEDGLASSPANEL,(new BlockHorizontalStaindGlassPanel()
						.setHardness(0.3F)
						.setUnlocalizedName(NAME_UNLOCAL_HORIZONTALSTAINEDGLASSPANEL)
						.setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL)));
		blkitems.put(NAME_HORIZONTALSTAINEDGLASSPANEL, new BlockItemTemperedStainedGlassPane(blocks.get(NAME_HORIZONTALSTAINEDGLASSPANEL)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL));
		resource.put(NAME_HORIZONTALSTAINEDGLASSPANEL, new ResourceLocation[]{
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALSTAINEDGLASSPANEL+"_"+EnumDyeColor.WHITE),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALSTAINEDGLASSPANEL+"_"+EnumDyeColor.ORANGE),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALSTAINEDGLASSPANEL+"_"+EnumDyeColor.MAGENTA),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALSTAINEDGLASSPANEL+"_"+EnumDyeColor.LIGHT_BLUE),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALSTAINEDGLASSPANEL+"_"+EnumDyeColor.YELLOW),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALSTAINEDGLASSPANEL+"_"+EnumDyeColor.LIME),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALSTAINEDGLASSPANEL+"_"+EnumDyeColor.PINK),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALSTAINEDGLASSPANEL+"_"+EnumDyeColor.GRAY),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALSTAINEDGLASSPANEL+"_"+EnumDyeColor.SILVER),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALSTAINEDGLASSPANEL+"_"+EnumDyeColor.CYAN),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALSTAINEDGLASSPANEL+"_"+EnumDyeColor.PURPLE),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALSTAINEDGLASSPANEL+"_"+EnumDyeColor.BLUE),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALSTAINEDGLASSPANEL+"_"+EnumDyeColor.BROWN),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALSTAINEDGLASSPANEL+"_"+EnumDyeColor.GREEN),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALSTAINEDGLASSPANEL+"_"+EnumDyeColor.RED),
				new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALSTAINEDGLASSPANEL+"_"+EnumDyeColor.BLACK)
				});
		ModLog.log().debug("天井ステンドグラスパネル生成完了");

		// 天井強化ガラスパネル
		ModLog.log().debug("天井強化パネル生成");
		blocks.put(NAME_HORIZONTALGLASSPANEL, (new BlockHorizontalGlassPanel(Material.GLASS)
				.setHardness(10.0F)
				.setResistance(2000.0F)
				.setUnlocalizedName(NAME_UNLOCAL_HORIZONTALGLASSPANEL)
				.setRegistryName(NAME_HORIZONTALTEMPERDGLASSPANEL)));
		blkitems.put(NAME_HORIZONTALTEMPERDGLASSPANEL, new BlockItemTemperedGlassPane(blocks.get(NAME_HORIZONTALTEMPERDGLASSPANEL)).setRegistryName(NAME_HORIZONTALTEMPERDGLASSPANEL));
		resource.put(NAME_HORIZONTALTEMPERDGLASSPANEL, new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALTEMPERDGLASSPANEL)});
		ModLog.log().debug("天井強化パネル生成完了");

		// 天井強化ステンドガラスパネル
		ModLog.log().debug("天井強化ステンドグラスパネル生成");
		blocks.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL,(new BlockHorizontalStaindGlassPanel()
				.setHardness(10.0F)
				.setResistance(2000.0F)
				.setUnlocalizedName(NAME_UNLOCAL_HORIZONTALTEMPERDSTAINDGLASSPANEL)
				.setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL)));
		blkitems.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL, new BlockItemTemperedStainedGlassPane(blocks.get(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL));
		resource.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL, new ResourceLocation[]{
		new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL+"_"+EnumDyeColor.WHITE),
		new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL+"_"+EnumDyeColor.ORANGE),
		new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL+"_"+EnumDyeColor.MAGENTA),
		new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL+"_"+EnumDyeColor.LIGHT_BLUE),
		new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL+"_"+EnumDyeColor.YELLOW),
		new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL+"_"+EnumDyeColor.LIME),
		new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL+"_"+EnumDyeColor.PINK),
		new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL+"_"+EnumDyeColor.GRAY),
		new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL+"_"+EnumDyeColor.SILVER),
		new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL+"_"+EnumDyeColor.CYAN),
		new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL+"_"+EnumDyeColor.PURPLE),
		new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL+"_"+EnumDyeColor.BLUE),
		new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL+"_"+EnumDyeColor.BROWN),
		new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL+"_"+EnumDyeColor.GREEN),
		new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL+"_"+EnumDyeColor.RED),
		new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL+"_"+EnumDyeColor.BLACK)
		});
		ModLog.log().debug("天井強化ステンドグラスパネル生成完了");

		for (final String key : blocks.keySet()){
			ModLog.log().debug("ブロック登録:"+key+"登録");
			ForgeRegistries.BLOCKS.register(blocks.get(key));
			ForgeRegistries.ITEMS.register(blkitems.get(key));
			ModLog.log().debug("ブロック登録:"+key+"登録完了");
		}
		ModLog.log().debug("end initBlocks");
	}




}
