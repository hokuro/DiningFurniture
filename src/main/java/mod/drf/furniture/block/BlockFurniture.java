package mod.drf.furniture.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mod.drf.core.ModCommon;
import mod.drf.core.Mod_DiningFurniture;
import mod.drf.furniture.block.item.BlockItemTemperedGlass;
import mod.drf.furniture.block.item.BlockItemTemperedGlassPane;
import mod.drf.furniture.block.item.BlockItemTemperedStainedGlass;
import mod.drf.furniture.block.item.BlockItemTemperedStainedGlassPane;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

public class BlockFurniture {
	public static final List<String> NAME_LIST = new ArrayList<String>(){
		{add(NAME_DININGWORKBENCH);}
		{add(NAME_TEMPEREDGLASS);}
		{add(NAME_TEMPEREDGLASSPANEL);}
		{add(NAME_TEMPEREDSTAINEDGLASS);}
		{add(NAME_TEMPEREDSTAINEDGLASSPANEL);}
		{add(NAME_HORIZONTALGLASSPANEL);}
		{add(NAME_HORIZONTALSTAINEDGLASSPANEL);}
		{add(NAME_HORIZONTALTEMPERDGLASSPANEL);}
		{add(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL);}
	};

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

	public static final String NAME_MAGICGLASS = "magicglass";

	public static Block block_dworkbench;
	public static Block block_temperedglass;
	public static Block block_temperedglasspanel;
	public static Block block_temperedstainedglass;
	public static Block block_temperedstainedglasspanel;
	public static Block block_horizontalglasspanel;
	public static Block block_horizontalstainedglasspanel;
	public static Block block_horizontaltemperedglasspanel;
	public static Block block_horizontaltemperedstainedglasspanel;
	public static Block block_magicglass;



	public static final String NAME_UNLOCAL_DININGWORKBENCH = NAME_DININGWORKBENCH;
	public static final String NAME_UNLOCAL_TEMPEREDGLASS = NAME_TEMPEREDGLASS;
	public static final String NAME_UNLOCAL_TEMPEREDGLASSPANEL = NAME_TEMPEREDGLASSPANEL;
	public static final String NAME_UNLOCAL_TEMPEREDSTAINEDGLASS = NAME_TEMPEREDSTAINEDGLASS;
	public static final String NAME_UNLOCAL_TEMPEREDSTAINEDGLASSPANEL = NAME_TEMPEREDSTAINEDGLASSPANEL;
	public static final String NAME_UNLOCAL_HORIZONTALGLASSPANEL = NAME_HORIZONTALGLASSPANEL;
	public static final String NAME_UNLOCAL_HORIZONTALSTAINEDGLASSPANEL = NAME_HORIZONTALSTAINEDGLASSPANEL;
	public static final String NAME_UNLOCAL_HORIZONTALTEMPERDGLASSPANEL = NAME_HORIZONTALTEMPERDGLASSPANEL;
	public static final String NAME_UNLOCAL_HORIZONTALTEMPERDSTAINDGLASSPANEL = NAME_UNLOCAL_HORIZONTALTEMPERDGLASSPANEL;

	public static void init(){
		block_dworkbench = new BlockFurnitureWorkBench()
				.setRegistryName(NAME_DININGWORKBENCH)
				.setUnlocalizedName(NAME_DININGWORKBENCH)
				.setCreativeTab(Mod_DiningFurniture.tabFurniture);

		block_temperedglass = new BlockTemperedGlass(Material.GLASS)
				.setHardness(15.0F)
				.setResistance(2000.0F)
				.setRegistryName(NAME_TEMPEREDGLASS)
				.setUnlocalizedName(NAME_UNLOCAL_TEMPEREDGLASS)
				.setCreativeTab(Mod_DiningFurniture.tabFurniture);

		block_temperedglasspanel = new BlockTemperedGlassPanel(Material.GLASS)
				.setHardness(10.0F)
				.setResistance(2000.0F)
				.setUnlocalizedName(NAME_UNLOCAL_TEMPEREDGLASSPANEL)
				.setRegistryName(NAME_TEMPEREDGLASSPANEL)
				.setCreativeTab(Mod_DiningFurniture.tabFurniture);

		block_temperedstainedglass = new BlockTemperedStainedGlass()
				.setHardness(15.0F)
				.setResistance(2000.0F)
				.setUnlocalizedName(NAME_UNLOCAL_TEMPEREDSTAINEDGLASS)
				.setRegistryName(NAME_TEMPEREDSTAINEDGLASS)
				.setCreativeTab(Mod_DiningFurniture.tabFurniture);

		block_temperedstainedglasspanel = new BlockTemperedStainedGlassPanel()
				.setHardness(10.0F)
				.setResistance(2000.0F)
				.setUnlocalizedName(NAME_UNLOCAL_TEMPEREDSTAINEDGLASSPANEL)
				.setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL)
				.setCreativeTab(Mod_DiningFurniture.tabFurniture);

		block_horizontalglasspanel = new BlockHorizontalGlassPanel(Material.GLASS)
				.setHardness(0.3F)
				.setUnlocalizedName(NAME_UNLOCAL_HORIZONTALGLASSPANEL)
				.setRegistryName(NAME_HORIZONTALGLASSPANEL)
				.setCreativeTab(Mod_DiningFurniture.tabFurniture);

		block_horizontalstainedglasspanel = new BlockHorizontalStaindGlassPanel()
				.setHardness(0.3F)
				.setUnlocalizedName(NAME_UNLOCAL_HORIZONTALSTAINEDGLASSPANEL)
				.setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL)
				.setCreativeTab(Mod_DiningFurniture.tabFurniture);

		block_horizontaltemperedglasspanel = new BlockHorizontalGlassPanel(Material.GLASS,true)
				.setHardness(10.0F)
				.setResistance(2000.0F)
				.setUnlocalizedName(NAME_HORIZONTALTEMPERDGLASSPANEL)
				.setRegistryName(NAME_HORIZONTALTEMPERDGLASSPANEL)
				.setCreativeTab(Mod_DiningFurniture.tabFurniture);

		block_horizontaltemperedstainedglasspanel = new BlockHorizontalStaindGlassPanel(true)
				.setHardness(10.0F)
				.setResistance(2000.0F)
				.setUnlocalizedName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL)
				.setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL)
				.setCreativeTab(Mod_DiningFurniture.tabFurniture);

		block_magicglass = new BlockMagicGlass(Material.GROUND)
				.setHardness(10.0F)
				.setResistance(2000.0F)
				.setUnlocalizedName(NAME_MAGICGLASS)
				.setRegistryName(NAME_MAGICGLASS)
				.setCreativeTab(Mod_DiningFurniture.tabFurniture);
	}

	public static Map<String,Block> blockMap(){
		return  (new HashMap<String, Block>(){
			{put(NAME_DININGWORKBENCH,block_dworkbench);}
			{put(NAME_TEMPEREDGLASS,block_temperedglass);}
			{put(NAME_TEMPEREDGLASSPANEL,block_temperedglasspanel);}
			{put(NAME_TEMPEREDSTAINEDGLASS,block_temperedstainedglass);}
			{put(NAME_TEMPEREDSTAINEDGLASSPANEL,block_temperedstainedglasspanel);}
			{put(NAME_HORIZONTALGLASSPANEL,block_horizontalglasspanel);}
			{put(NAME_HORIZONTALSTAINEDGLASSPANEL,block_horizontalstainedglasspanel);}
			{put(NAME_HORIZONTALTEMPERDGLASSPANEL,block_horizontaltemperedglasspanel);}
			{put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL,block_horizontaltemperedstainedglasspanel);}
			{put(NAME_MAGICGLASS,block_magicglass);}
		});
	}

	public static Map<String,Item> itemMap(){
		return (new HashMap<String, Item>(){
			{put(NAME_DININGWORKBENCH, new ItemBlock(block_dworkbench).setRegistryName(NAME_DININGWORKBENCH));}
			{put(NAME_TEMPEREDGLASS,new BlockItemTemperedGlass(block_temperedglass).setRegistryName(NAME_TEMPEREDGLASS));}
			{put(NAME_TEMPEREDGLASSPANEL,new BlockItemTemperedGlassPane(block_temperedglasspanel).setRegistryName(NAME_TEMPEREDGLASSPANEL));}
			{put(NAME_TEMPEREDSTAINEDGLASS,new BlockItemTemperedStainedGlass(block_temperedstainedglass).setRegistryName(NAME_TEMPEREDSTAINEDGLASS));}
			{put(NAME_TEMPEREDSTAINEDGLASSPANEL,new BlockItemTemperedStainedGlassPane(block_temperedstainedglasspanel).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL));}
			{put(NAME_HORIZONTALGLASSPANEL,new BlockItemTemperedGlassPane(block_horizontalglasspanel).setRegistryName(NAME_HORIZONTALGLASSPANEL));}
			{put(NAME_HORIZONTALSTAINEDGLASSPANEL,new BlockItemTemperedStainedGlassPane(block_horizontalstainedglasspanel).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL));}
			{put(NAME_HORIZONTALTEMPERDGLASSPANEL,new BlockItemTemperedGlassPane(block_horizontaltemperedglasspanel).setRegistryName(NAME_HORIZONTALTEMPERDGLASSPANEL));}
			{put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL,new BlockItemTemperedStainedGlassPane(block_horizontaltemperedstainedglasspanel).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL));}
			{put(NAME_MAGICGLASS,new ItemBlock(block_magicglass).setRegistryName(NAME_MAGICGLASS));}
			});
	}

	public static Map<String,ResourceLocation[]> resourceMap(){
		return (new HashMap<String,ResourceLocation[]>(){
			{put(NAME_DININGWORKBENCH,new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_DININGWORKBENCH)});}
			{put(NAME_TEMPEREDGLASS,new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDGLASS)});}
			{put(NAME_TEMPEREDGLASSPANEL,new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_TEMPEREDGLASSPANEL)});}
			{put(NAME_TEMPEREDSTAINEDGLASS,new ResourceLocation[]{
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
					});}
			{put(NAME_TEMPEREDSTAINEDGLASSPANEL,new ResourceLocation[]{
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
					});}
			{put(NAME_HORIZONTALGLASSPANEL,new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALGLASSPANEL)});}
			{put(NAME_HORIZONTALSTAINEDGLASSPANEL,new ResourceLocation[]{
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
					});}
			{put(NAME_HORIZONTALTEMPERDGLASSPANEL,new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_HORIZONTALGLASSPANEL)});}
			{put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL,new ResourceLocation[]{
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
					});}
			{put(NAME_MAGICGLASS,new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID+":"+NAME_MAGICGLASS)});}
			});
	}
}

