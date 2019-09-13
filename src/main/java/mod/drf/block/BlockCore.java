package mod.drf.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mod.drf.core.Mod_DiningFurniture;
import mod.drf.item.ItemCore.EnumWoodType;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;

public class BlockCore {
	public static final List<String> NAME_LIST = new ArrayList<String>(){
		{add(NAME_DININGWORKBENCH);}
		{add(NAME_TEMPEREDGLASS);}
		{add(NAME_TEMPEREDGLASSPANEL);}
		{add(NAME_TEMPEREDSTAINEDGLASS_WHITE);}
		{add(NAME_TEMPEREDSTAINEDGLASS_ORANGE);}
		{add(NAME_TEMPEREDSTAINEDGLASS_MAGENTA);}
		{add(NAME_TEMPEREDSTAINEDGLASS_LIGHT_BLUE);}
		{add(NAME_TEMPEREDSTAINEDGLASS_YELLOW);}
		{add(NAME_TEMPEREDSTAINEDGLASS_LIME);}
		{add(NAME_TEMPEREDSTAINEDGLASS_PINK);}
		{add(NAME_TEMPEREDSTAINEDGLASS_GRAY);}
		{add(NAME_TEMPEREDSTAINEDGLASS_LIGHT_GRAY);}
		{add(NAME_TEMPEREDSTAINEDGLASS_CYAN);}
		{add(NAME_TEMPEREDSTAINEDGLASS_PURPLE);}
		{add(NAME_TEMPEREDSTAINEDGLASS_BLUE);}
		{add(NAME_TEMPEREDSTAINEDGLASS_BROWN);}
		{add(NAME_TEMPEREDSTAINEDGLASS_GREEN);}
		{add(NAME_TEMPEREDSTAINEDGLASS_RED);}
		{add(NAME_TEMPEREDSTAINEDGLASS_BLACK);}
		{add(NAME_TEMPEREDSTAINEDGLASSPANEL_WHITE);}
		{add(NAME_TEMPEREDSTAINEDGLASSPANEL_ORANGE);}
		{add(NAME_TEMPEREDSTAINEDGLASSPANEL_MAGENTA);}
		{add(NAME_TEMPEREDSTAINEDGLASSPANEL_LIGHT_BLUE);}
		{add(NAME_TEMPEREDSTAINEDGLASSPANEL_YELLOW);}
		{add(NAME_TEMPEREDSTAINEDGLASSPANEL_LIME);}
		{add(NAME_TEMPEREDSTAINEDGLASSPANEL_PINK);}
		{add(NAME_TEMPEREDSTAINEDGLASSPANEL_GRAY);}
		{add(NAME_TEMPEREDSTAINEDGLASSPANEL_LIGHT_GRAY);}
		{add(NAME_TEMPEREDSTAINEDGLASSPANEL_CYAN);}
		{add(NAME_TEMPEREDSTAINEDGLASSPANEL_PURPLE);}
		{add(NAME_TEMPEREDSTAINEDGLASSPANEL_BLUE);}
		{add(NAME_TEMPEREDSTAINEDGLASSPANEL_BROWN);}
		{add(NAME_TEMPEREDSTAINEDGLASSPANEL_GREEN);}
		{add(NAME_TEMPEREDSTAINEDGLASSPANEL_RED);}
		{add(NAME_TEMPEREDSTAINEDGLASSPANEL_BLACK);}
		{add(NAME_HORIZONTALGLASSPANEL);}
		{add(NAME_HORIZONTALSTAINEDGLASSPANEL_WHITE);}
		{add(NAME_HORIZONTALSTAINEDGLASSPANEL_ORANGE);}
		{add(NAME_HORIZONTALSTAINEDGLASSPANEL_MAGENTA);}
		{add(NAME_HORIZONTALSTAINEDGLASSPANEL_LIGHT_BLUE);}
		{add(NAME_HORIZONTALSTAINEDGLASSPANEL_YELLOW);}
		{add(NAME_HORIZONTALSTAINEDGLASSPANEL_LIME);}
		{add(NAME_HORIZONTALSTAINEDGLASSPANEL_PINK);}
		{add(NAME_HORIZONTALSTAINEDGLASSPANEL_GRAY);}
		{add(NAME_HORIZONTALSTAINEDGLASSPANEL_LIGHT_GRAY);}
		{add(NAME_HORIZONTALSTAINEDGLASSPANEL_CYAN);}
		{add(NAME_HORIZONTALSTAINEDGLASSPANEL_PURPLE);}
		{add(NAME_HORIZONTALSTAINEDGLASSPANEL_BLUE);}
		{add(NAME_HORIZONTALSTAINEDGLASSPANEL_BROWN);}
		{add(NAME_HORIZONTALSTAINEDGLASSPANEL_GREEN);}
		{add(NAME_HORIZONTALSTAINEDGLASSPANEL_RED);}
		{add(NAME_HORIZONTALSTAINEDGLASSPANEL_BLACK);}
		{add(NAME_HORIZONTALTEMPERDGLASSPANEL);}
		{add(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_WHITE);}
		{add(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_ORANGE);}
		{add(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_MAGENTA);}
		{add(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIGHT_BLUE);}
		{add(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_YELLOW);}
		{add(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIME);}
		{add(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_PINK);}
		{add(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_GRAY);}
		{add(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIGHT_GRAY);}
		{add(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_CYAN);}
		{add(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_PURPLE);}
		{add(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BLUE);}
		{add(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BROWN);}
		{add(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_GREEN);}
		{add(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_RED);}
		{add(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BLACK);}
		{add(NAME_WOODTABLE_ACACIA);}
		{add(NAME_WOODTABLE_BIRCH);}
		{add(NAME_WOODTABLE_DARKOAK);}
		{add(NAME_WOODTABLE_JUNGLE);}
		{add(NAME_WOODTABLE_OAK);}
		{add(NAME_WOODTABLE_SPRUCE);}
		{add(NAME_MAGICGLASS);}
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
	public static final String NAME_TEMPEREDSTAINEDGLASS_WHITE = "tempstainedglass_white";
	public static final String NAME_TEMPEREDSTAINEDGLASS_ORANGE = "tempstainedglass_orange";
	public static final String NAME_TEMPEREDSTAINEDGLASS_MAGENTA = "tempstainedglass_magenta";
	public static final String NAME_TEMPEREDSTAINEDGLASS_LIGHT_BLUE = "tempstainedglass_light_blue";
	public static final String NAME_TEMPEREDSTAINEDGLASS_YELLOW = "tempstainedglass_yellow";
	public static final String NAME_TEMPEREDSTAINEDGLASS_LIME = "tempstainedglass_lime";
	public static final String NAME_TEMPEREDSTAINEDGLASS_PINK = "tempstainedglass_pink";
	public static final String NAME_TEMPEREDSTAINEDGLASS_GRAY = "tempstainedglass_gray";
	public static final String NAME_TEMPEREDSTAINEDGLASS_LIGHT_GRAY = "tempstainedglass_silver";
	public static final String NAME_TEMPEREDSTAINEDGLASS_CYAN = "tempstainedglass_cyan";
	public static final String NAME_TEMPEREDSTAINEDGLASS_PURPLE = "tempstainedglass_purple";
	public static final String NAME_TEMPEREDSTAINEDGLASS_BLUE = "tempstainedglass_blue";
	public static final String NAME_TEMPEREDSTAINEDGLASS_BROWN = "tempstainedglass_brown";
	public static final String NAME_TEMPEREDSTAINEDGLASS_GREEN = "tempstainedglass_green";
	public static final String NAME_TEMPEREDSTAINEDGLASS_RED = "tempstainedglass_red";
	public static final String NAME_TEMPEREDSTAINEDGLASS_BLACK = "tempstainedglass_black";

	// 強化色付きガラスパネル
	public static final String NAME_TEMPEREDSTAINEDGLASSPANEL_WHITE = "tempstainedglass_panel_white";
	public static final String NAME_TEMPEREDSTAINEDGLASSPANEL_ORANGE = "tempstainedglass_panel_orange";
	public static final String NAME_TEMPEREDSTAINEDGLASSPANEL_MAGENTA = "tempstainedglass_panel_magenta";
	public static final String NAME_TEMPEREDSTAINEDGLASSPANEL_LIGHT_BLUE = "tempstainedglass_panel_light_blue";
	public static final String NAME_TEMPEREDSTAINEDGLASSPANEL_YELLOW = "tempstainedglass_panel_yellow";
	public static final String NAME_TEMPEREDSTAINEDGLASSPANEL_LIME = "tempstainedglass_panel_lime";
	public static final String NAME_TEMPEREDSTAINEDGLASSPANEL_PINK = "tempstainedglass_panel_pink";
	public static final String NAME_TEMPEREDSTAINEDGLASSPANEL_GRAY = "tempstainedglass_panel_gray";
	public static final String NAME_TEMPEREDSTAINEDGLASSPANEL_LIGHT_GRAY = "tempstainedglass_panel_silver";
	public static final String NAME_TEMPEREDSTAINEDGLASSPANEL_CYAN = "tempstainedglass_panel_cyan";
	public static final String NAME_TEMPEREDSTAINEDGLASSPANEL_PURPLE = "tempstainedglass_panel_purple";
	public static final String NAME_TEMPEREDSTAINEDGLASSPANEL_BLUE = "tempstainedglass_panel_blue";
	public static final String NAME_TEMPEREDSTAINEDGLASSPANEL_BROWN = "tempstainedglass_panel_brown";
	public static final String NAME_TEMPEREDSTAINEDGLASSPANEL_GREEN = "tempstainedglass_panel_green";
	public static final String NAME_TEMPEREDSTAINEDGLASSPANEL_RED = "tempstainedglass_panel_red";
	public static final String NAME_TEMPEREDSTAINEDGLASSPANEL_BLACK = "tempstainedglass_panel_black";

	// 水平ガラスパネル
	public static final String NAME_HORIZONTALGLASSPANEL = "horizontalglass_panel";
	// 水平色付きガラスパネル
	public static final String NAME_HORIZONTALSTAINEDGLASSPANEL_WHITE = "horizontalstaindglass_panel_white";
	public static final String NAME_HORIZONTALSTAINEDGLASSPANEL_ORANGE = "horizontalstaindglass_panel_orange";
	public static final String NAME_HORIZONTALSTAINEDGLASSPANEL_MAGENTA = "horizontalstaindglass_panel_magenta";
	public static final String NAME_HORIZONTALSTAINEDGLASSPANEL_LIGHT_BLUE = "horizontalstaindglass_panel_light_blue";
	public static final String NAME_HORIZONTALSTAINEDGLASSPANEL_YELLOW = "horizontalstaindglass_panel_yellow";
	public static final String NAME_HORIZONTALSTAINEDGLASSPANEL_LIME = "horizontalstaindglass_panel_lime";
	public static final String NAME_HORIZONTALSTAINEDGLASSPANEL_PINK = "horizontalstaindglass_panel_pink";
	public static final String NAME_HORIZONTALSTAINEDGLASSPANEL_GRAY = "horizontalstaindglass_panel_gray";
	public static final String NAME_HORIZONTALSTAINEDGLASSPANEL_LIGHT_GRAY = "horizontalstaindglass_panel_silver";
	public static final String NAME_HORIZONTALSTAINEDGLASSPANEL_CYAN = "horizontalstaindglass_panel_cyan";
	public static final String NAME_HORIZONTALSTAINEDGLASSPANEL_PURPLE = "horizontalstaindglass_panel_purple";
	public static final String NAME_HORIZONTALSTAINEDGLASSPANEL_BLUE = "horizontalstaindglass_panel_blue";
	public static final String NAME_HORIZONTALSTAINEDGLASSPANEL_BROWN = "horizontalstaindglass_panel_brown";
	public static final String NAME_HORIZONTALSTAINEDGLASSPANEL_GREEN = "horizontalstaindglass_panel_green";
	public static final String NAME_HORIZONTALSTAINEDGLASSPANEL_RED = "horizontalstaindglass_panel_red";
	public static final String NAME_HORIZONTALSTAINEDGLASSPANEL_BLACK = "horizontalstaindglass_panel_black";

	// 水平強化ガラスパネル
	public static final String NAME_HORIZONTALTEMPERDGLASSPANEL = "htempglass_panel";
	// 水平強化色付きガラスパネル
	public static final String NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_WHITE = "htempstainedglass_panel_white";
	public static final String NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_ORANGE = "htempstainedglass_panel_orange";
	public static final String NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_MAGENTA = "htempstainedglass_panel_magenta";
	public static final String NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIGHT_BLUE = "htempstainedglass_panel_light_blue";
	public static final String NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_YELLOW = "htempstainedglass_panel_yellow";
	public static final String NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIME = "htempstainedglass_panel_lime";
	public static final String NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_PINK = "htempstainedglass_panel_pink";
	public static final String NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_GRAY = "htempstainedglass_panel_gray";
	public static final String NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIGHT_GRAY = "htempstainedglass_panel_silver";
	public static final String NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_CYAN = "htempstainedglass_panel_cyan";
	public static final String NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_PURPLE = "htempstainedglass_panel_purple";
	public static final String NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BLUE = "htempstainedglass_panel_blue";
	public static final String NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BROWN = "htempstainedglass_panel_brown";
	public static final String NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_GREEN = "htempstainedglass_panel_green";
	public static final String NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_RED = "htempstainedglass_panel_red";
	public static final String NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BLACK = "htempstainedglass_panel_black";
	public static final String NAME_WOODTABLE_ACACIA = "woodtable_acacia";
	public static final String NAME_WOODTABLE_BIRCH = "woodtable_birch";
	public static final String NAME_WOODTABLE_DARKOAK = "woodtable_dark_oak";
	public static final String NAME_WOODTABLE_JUNGLE = "woodtable_jungle";
	public static final String NAME_WOODTABLE_OAK = "woodtable_oak";
	public static final String NAME_WOODTABLE_SPRUCE = "woodtable_spruce";

	public static final String NAME_MAGICGLASS = "magicglass";


	public static Block block_dworkbench = new BlockFurnitureWorkBench().setRegistryName(NAME_DININGWORKBENCH);

	public static Block block_tempglass = new BlockTemperedGlass(Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDGLASS);

	public static Block block_tempglass_panel = new BlockTemperedGlassPanel(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDGLASSPANEL);

	public static Block block_tempstainedglass_white = new BlockTemperedStainedGlass(DyeColor.WHITE, Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_WHITE);
	public static Block block_tempstainedglass_orange = new BlockTemperedStainedGlass(DyeColor.ORANGE, Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_ORANGE);
	public static Block block_tempstainedglass_magenta = new BlockTemperedStainedGlass(DyeColor.MAGENTA, Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_MAGENTA);
	public static Block block_tempstainedglass_light_blue = new BlockTemperedStainedGlass(DyeColor.LIGHT_BLUE, Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_LIGHT_BLUE);
	public static Block block_tempstainedglass_yellow = new BlockTemperedStainedGlass(DyeColor.YELLOW, Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_YELLOW);
	public static Block block_tempstainedglass_lime = new BlockTemperedStainedGlass(DyeColor.LIME, Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_LIME);
	public static Block block_tempstainedglass_pink = new BlockTemperedStainedGlass(DyeColor.PINK, Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_PINK);
	public static Block block_tempstainedglass_gray = new BlockTemperedStainedGlass(DyeColor.GRAY, Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_GRAY);
	public static Block block_tempstainedglass_light_gray = new BlockTemperedStainedGlass(DyeColor.LIGHT_GRAY, Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_LIGHT_GRAY);
	public static Block block_tempstainedglass_cyan = new BlockTemperedStainedGlass(DyeColor.CYAN, Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_CYAN);
	public static Block block_tempstainedglass_purple = new BlockTemperedStainedGlass(DyeColor.PURPLE, Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_PURPLE);
	public static Block block_tempstainedglass_blue = new BlockTemperedStainedGlass(DyeColor.BLUE, Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_BLUE);
	public static Block block_tempstainedglass_brown = new BlockTemperedStainedGlass(DyeColor.BROWN, Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_BROWN);
	public static Block block_tempstainedglass_green = new BlockTemperedStainedGlass(DyeColor.GREEN, Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_GREEN);
	public static Block block_tempstainedglass_red = new BlockTemperedStainedGlass(DyeColor.RED, Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_RED);
	public static Block block_tempstainedglass_black = new BlockTemperedStainedGlass(DyeColor.BLACK, Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_BLACK);

	public static Block block_tempstainedglass_panel_white = new BlockTemperedStainedGlassPanel(DyeColor.WHITE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_WHITE);
	public static Block block_tempstainedglass_panel_orange = new BlockTemperedStainedGlassPanel(DyeColor.ORANGE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_ORANGE);
	public static Block block_tempstainedglass_panel_magenta = new BlockTemperedStainedGlassPanel(DyeColor.MAGENTA, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_MAGENTA);
	public static Block block_tempstainedglass_panel_light_blue = new BlockTemperedStainedGlassPanel(DyeColor.LIGHT_BLUE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_LIGHT_BLUE);
	public static Block block_tempstainedglass_panel_yellow = new BlockTemperedStainedGlassPanel(DyeColor.YELLOW, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_YELLOW);
	public static Block block_tempstainedglass_panel_lime = new BlockTemperedStainedGlassPanel(DyeColor.LIME, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_LIME);
	public static Block block_tempstainedglass_panel_pink = new BlockTemperedStainedGlassPanel(DyeColor.PINK, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_PINK);
	public static Block block_tempstainedglass_panel_gray = new BlockTemperedStainedGlassPanel(DyeColor.GRAY, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_GRAY);
	public static Block block_tempstainedglass_panel_light_gray = new BlockTemperedStainedGlassPanel(DyeColor.LIGHT_GRAY, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_LIGHT_GRAY);
	public static Block block_tempstainedglass_panel_cyan = new BlockTemperedStainedGlassPanel(DyeColor.CYAN, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_CYAN);
	public static Block block_tempstainedglass_panel_purple = new BlockTemperedStainedGlassPanel(DyeColor.PURPLE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_PURPLE);
	public static Block block_tempstainedglass_panel_blue = new BlockTemperedStainedGlassPanel(DyeColor.BLUE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_BLUE);
	public static Block block_tempstainedglass_panel_brown = new BlockTemperedStainedGlassPanel(DyeColor.BROWN, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_BROWN);
	public static Block block_tempstainedglass_panel_green = new BlockTemperedStainedGlassPanel(DyeColor.GREEN, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_GREEN);
	public static Block block_tempstainedglass_panel_red = new BlockTemperedStainedGlassPanel(DyeColor.RED, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_RED);
	public static Block block_tempstainedglass_panel_black = new BlockTemperedStainedGlassPanel(DyeColor.BLACK, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_BLACK);

	public static Block block_horizontalglass_panel = new BlockHorizontalGlassPanel(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALGLASSPANEL);

	public static Block block_horizontalstaindglass_panel_white = new BlockHorizontalStaindGlassPanel(DyeColor.WHITE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_WHITE);
	public static Block block_horizontalstaindglass_panel_orange = new BlockHorizontalStaindGlassPanel(DyeColor.ORANGE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_ORANGE);
	public static Block block_horizontalstaindglass_panel_magenta = new BlockHorizontalStaindGlassPanel(DyeColor.MAGENTA, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_MAGENTA);
	public static Block block_horizontalstaindglass_panel_light_blue = new BlockHorizontalStaindGlassPanel(DyeColor.LIGHT_BLUE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_LIGHT_BLUE);
	public static Block block_horizontalstaindglass_panel_yellow = new BlockHorizontalStaindGlassPanel(DyeColor.YELLOW, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_YELLOW);
	public static Block block_horizontalstaindglass_panel_lime = new BlockHorizontalStaindGlassPanel(DyeColor.LIME, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_LIME);
	public static Block block_horizontalstaindglass_panel_pink = new BlockHorizontalStaindGlassPanel(DyeColor.PINK, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_PINK);
	public static Block block_horizontalstaindglass_panel_gray = new BlockHorizontalStaindGlassPanel(DyeColor.GRAY, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_GRAY);
	public static Block block_horizontalstaindglass_panel_light_gray = new BlockHorizontalStaindGlassPanel(DyeColor.LIGHT_GRAY, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_LIGHT_GRAY);
	public static Block block_horizontalstaindglass_panel_cyan = new BlockHorizontalStaindGlassPanel(DyeColor.CYAN, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_CYAN);
	public static Block block_horizontalstaindglass_panel_purple = new BlockHorizontalStaindGlassPanel(DyeColor.PURPLE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_PURPLE);
	public static Block block_horizontalstaindglass_panel_blue = new BlockHorizontalStaindGlassPanel(DyeColor.BLUE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_BLUE);
	public static Block block_horizontalstaindglass_panel_brown = new BlockHorizontalStaindGlassPanel(DyeColor.BROWN, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_BROWN);
	public static Block block_horizontalstaindglass_panel_green = new BlockHorizontalStaindGlassPanel(DyeColor.GREEN, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_GREEN);
	public static Block block_horizontalstaindglass_panel_red = new BlockHorizontalStaindGlassPanel(DyeColor.RED, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_RED);
	public static Block block_horizontalstaindglass_panel_black = new BlockHorizontalStaindGlassPanel(DyeColor.BLACK, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_BLACK);

	public static Block block_htempglass_panel = new BlockHorizontalGlassPanel(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDGLASSPANEL);

	public static Block block_htempstainedglass_panel_white = new BlockHorizontalStaindGlassPanel(DyeColor.WHITE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_WHITE);
	public static Block block_htempstainedglass_panel_orange = new BlockHorizontalStaindGlassPanel(DyeColor.ORANGE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_ORANGE);
	public static Block block_htempstainedglass_panel_magenta = new BlockHorizontalStaindGlassPanel(DyeColor.MAGENTA, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_MAGENTA);
	public static Block block_htempstainedglass_panel_light_blue = new BlockHorizontalStaindGlassPanel(DyeColor.LIGHT_BLUE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIGHT_BLUE);
	public static Block block_htempstainedglass_panel_yellow = new BlockHorizontalStaindGlassPanel(DyeColor.YELLOW, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_YELLOW);
	public static Block block_htempstainedglass_panel_lime = new BlockHorizontalStaindGlassPanel(DyeColor.LIME, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIME);
	public static Block block_htempstainedglass_panel_pink = new BlockHorizontalStaindGlassPanel(DyeColor.PINK, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_PINK);
	public static Block block_htempstainedglass_panel_gray = new BlockHorizontalStaindGlassPanel(DyeColor.GRAY, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_GRAY);
	public static Block block_htempstainedglass_panel_light_gray = new BlockHorizontalStaindGlassPanel(DyeColor.LIGHT_GRAY, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIGHT_GRAY);
	public static Block block_htempstainedglass_panel_cyan = new BlockHorizontalStaindGlassPanel(DyeColor.CYAN, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_CYAN);
	public static Block block_htempstainedglass_panel_purple = new BlockHorizontalStaindGlassPanel(DyeColor.PURPLE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_PURPLE);
	public static Block block_htempstainedglass_panel_blue = new BlockHorizontalStaindGlassPanel(DyeColor.BLUE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BLUE);
	public static Block block_htempstainedglass_panel_brown = new BlockHorizontalStaindGlassPanel(DyeColor.BROWN, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BROWN);
	public static Block block_htempstainedglass_panel_green = new BlockHorizontalStaindGlassPanel(DyeColor.GREEN, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_GREEN);
	public static Block block_htempstainedglass_panel_red = new BlockHorizontalStaindGlassPanel(DyeColor.RED, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_RED);
	public static Block block_htempstainedglass_panel_black = new BlockHorizontalStaindGlassPanel(DyeColor.BLACK, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BLACK);
	public static Block block_woodtable_acacia = new BlockWoodTable(EnumWoodType.ACACIA_WOOD, Block.Properties.create(Material.WOOD).hardnessAndResistance(0.3F).sound(SoundType.WOOD)).setRegistryName(NAME_WOODTABLE_ACACIA);
	public static Block block_woodtable_birch = new BlockWoodTable(EnumWoodType.BIRCH_WOOD, Block.Properties.create(Material.WOOD).hardnessAndResistance(0.3F).sound(SoundType.WOOD)).setRegistryName(NAME_WOODTABLE_BIRCH);
	public static Block block_woodtable_darkoak = new BlockWoodTable(EnumWoodType.DARK_OAK_WOOD, Block.Properties.create(Material.WOOD).hardnessAndResistance(0.3F).sound(SoundType.WOOD)).setRegistryName(NAME_WOODTABLE_DARKOAK);
	public static Block block_woodtable_jungle = new BlockWoodTable(EnumWoodType.JUNGLE_WOOD, Block.Properties.create(Material.WOOD).hardnessAndResistance(0.3F).sound(SoundType.WOOD)).setRegistryName(NAME_WOODTABLE_JUNGLE);
	public static Block block_woodtable_oak = new BlockWoodTable(EnumWoodType.DARK_OAK_WOOD, Block.Properties.create(Material.WOOD).hardnessAndResistance(0.3F).sound(SoundType.WOOD)).setRegistryName(NAME_WOODTABLE_OAK);
	public static Block block_woodtable_spruce = new BlockWoodTable(EnumWoodType.SPRUCE_WOOD, Block.Properties.create(Material.WOOD).hardnessAndResistance(0.3F).sound(SoundType.WOOD)).setRegistryName(NAME_WOODTABLE_SPRUCE);


	public static Block block_magicglass = new BlockMagicGlass(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_MAGICGLASS);


	public static Map<String,Block> blockMap;
	public static Map<String,Item> itemMap;
	public static void init(){
		blockMap = new HashMap<String, Block>();
		blockMap.put(NAME_DININGWORKBENCH,block_dworkbench);
		blockMap.put(NAME_TEMPEREDGLASS,block_tempglass);
		blockMap.put(NAME_TEMPEREDGLASSPANEL,block_tempglass_panel);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASS_WHITE,block_tempstainedglass_white);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASS_ORANGE,block_tempstainedglass_orange);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASS_MAGENTA,block_tempstainedglass_magenta);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASS_LIGHT_BLUE,block_tempstainedglass_light_blue);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASS_YELLOW,block_tempstainedglass_yellow);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASS_LIME,block_tempstainedglass_lime);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASS_PINK,block_tempstainedglass_pink);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASS_GRAY,block_tempstainedglass_gray);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASS_LIGHT_GRAY,block_tempstainedglass_light_gray);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASS_CYAN,block_tempstainedglass_cyan);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASS_PURPLE,block_tempstainedglass_purple);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASS_BLUE,block_tempstainedglass_blue);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASS_BROWN,block_tempstainedglass_brown);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASS_GREEN,block_tempstainedglass_green);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASS_RED,block_tempstainedglass_red);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASS_BLACK,block_tempstainedglass_black);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_WHITE,block_tempstainedglass_panel_white);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_ORANGE,block_tempstainedglass_panel_orange);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_MAGENTA,block_tempstainedglass_panel_magenta);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_LIGHT_BLUE,block_tempstainedglass_panel_light_blue);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_YELLOW,block_tempstainedglass_panel_yellow);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_LIME,block_tempstainedglass_panel_lime);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_PINK,block_tempstainedglass_panel_pink);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_GRAY,block_tempstainedglass_panel_gray);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_LIGHT_GRAY,block_tempstainedglass_panel_light_gray);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_CYAN,block_tempstainedglass_panel_cyan);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_PURPLE,block_tempstainedglass_panel_purple);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_BLUE,block_tempstainedglass_panel_blue);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_BROWN,block_tempstainedglass_panel_brown);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_GREEN,block_tempstainedglass_panel_green);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_RED,block_tempstainedglass_panel_red);
		blockMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_BLACK,block_tempstainedglass_panel_black);
		blockMap.put(NAME_HORIZONTALGLASSPANEL,block_horizontalglass_panel);
		blockMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_WHITE,block_horizontalstaindglass_panel_white);
		blockMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_ORANGE,block_horizontalstaindglass_panel_orange);
		blockMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_MAGENTA,block_horizontalstaindglass_panel_magenta);
		blockMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_LIGHT_BLUE,block_horizontalstaindglass_panel_light_blue);
		blockMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_YELLOW,block_horizontalstaindglass_panel_yellow);
		blockMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_LIME,block_horizontalstaindglass_panel_lime);
		blockMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_PINK,block_horizontalstaindglass_panel_pink);
		blockMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_GRAY,block_horizontalstaindglass_panel_gray);
		blockMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_LIGHT_GRAY,block_horizontalstaindglass_panel_light_gray);
		blockMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_CYAN,block_horizontalstaindglass_panel_cyan);
		blockMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_PURPLE,block_horizontalstaindglass_panel_purple);
		blockMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_BLUE,block_horizontalstaindglass_panel_blue);
		blockMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_BROWN,block_horizontalstaindglass_panel_brown);
		blockMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_GREEN,block_horizontalstaindglass_panel_green);
		blockMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_RED,block_horizontalstaindglass_panel_red);
		blockMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_BLACK,block_horizontalstaindglass_panel_black);
		blockMap.put(NAME_HORIZONTALTEMPERDGLASSPANEL,block_htempglass_panel);
		blockMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_WHITE,block_htempstainedglass_panel_white);
		blockMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_ORANGE,block_htempstainedglass_panel_orange);
		blockMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_MAGENTA,block_htempstainedglass_panel_magenta);
		blockMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIGHT_BLUE,block_htempstainedglass_panel_light_blue);
		blockMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_YELLOW,block_htempstainedglass_panel_yellow);
		blockMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIME,block_htempstainedglass_panel_lime);
		blockMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_PINK,block_htempstainedglass_panel_pink);
		blockMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_GRAY,block_htempstainedglass_panel_gray);
		blockMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIGHT_GRAY,block_htempstainedglass_panel_light_gray);
		blockMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_CYAN,block_htempstainedglass_panel_cyan);
		blockMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_PURPLE,block_htempstainedglass_panel_purple);
		blockMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BLUE,block_htempstainedglass_panel_blue);
		blockMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BROWN,block_htempstainedglass_panel_brown);
		blockMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_GREEN,block_htempstainedglass_panel_green);
		blockMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_RED,block_htempstainedglass_panel_red);
		blockMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BLACK,block_htempstainedglass_panel_black);
		blockMap.put(NAME_WOODTABLE_ACACIA,block_woodtable_acacia);
		blockMap.put(NAME_WOODTABLE_BIRCH,block_woodtable_birch);
		blockMap.put(NAME_WOODTABLE_DARKOAK,block_woodtable_darkoak);
		blockMap.put(NAME_WOODTABLE_JUNGLE,block_woodtable_jungle);
		blockMap.put(NAME_WOODTABLE_OAK,block_woodtable_oak);
		blockMap.put(NAME_WOODTABLE_SPRUCE,block_woodtable_spruce);
		blockMap.put(NAME_MAGICGLASS,block_magicglass);


		itemMap = new HashMap<String, Item>();
		itemMap.put(NAME_DININGWORKBENCH, new BlockItem(block_dworkbench, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_DININGWORKBENCH));
		itemMap.put(NAME_TEMPEREDGLASS, new BlockItem(block_tempglass, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDGLASS));
		itemMap.put(NAME_TEMPEREDGLASSPANEL, new BlockItem(block_tempglass_panel, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDGLASSPANEL));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_WHITE, new BlockItem(block_tempstainedglass_white, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_WHITE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_ORANGE, new BlockItem(block_tempstainedglass_orange, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_ORANGE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_MAGENTA, new BlockItem(block_tempstainedglass_magenta, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_MAGENTA));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_LIGHT_BLUE, new BlockItem(block_tempstainedglass_light_blue, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_LIGHT_BLUE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_YELLOW, new BlockItem(block_tempstainedglass_yellow, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_YELLOW));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_LIME, new BlockItem(block_tempstainedglass_lime, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_LIME));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_PINK, new BlockItem(block_tempstainedglass_pink, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_PINK));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_GRAY, new BlockItem(block_tempstainedglass_gray, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_GRAY));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_LIGHT_GRAY, new BlockItem(block_tempstainedglass_light_gray, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_LIGHT_GRAY));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_CYAN, new BlockItem(block_tempstainedglass_cyan, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_CYAN));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_PURPLE, new BlockItem(block_tempstainedglass_purple, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_PURPLE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_BLUE, new BlockItem(block_tempstainedglass_blue, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_BLUE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_BROWN, new BlockItem(block_tempstainedglass_brown, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_BROWN));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_GREEN, new BlockItem(block_tempstainedglass_green, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_GREEN));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_RED, new BlockItem(block_tempstainedglass_red, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_RED));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_BLACK, new BlockItem(block_tempstainedglass_black, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_BLACK));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_WHITE, new BlockItem(block_tempstainedglass_panel_white, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_WHITE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_ORANGE, new BlockItem(block_tempstainedglass_panel_orange, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_ORANGE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_MAGENTA, new BlockItem(block_tempstainedglass_panel_magenta, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_MAGENTA));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_LIGHT_BLUE, new BlockItem(block_tempstainedglass_panel_light_blue, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_LIGHT_BLUE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_YELLOW, new BlockItem(block_tempstainedglass_panel_yellow, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_YELLOW));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_LIME, new BlockItem(block_tempstainedglass_panel_lime, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_LIME));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_PINK, new BlockItem(block_tempstainedglass_panel_pink, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_PINK));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_GRAY, new BlockItem(block_tempstainedglass_panel_gray, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_GRAY));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_LIGHT_GRAY, new BlockItem(block_tempstainedglass_panel_light_gray, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_LIGHT_GRAY));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_CYAN, new BlockItem(block_tempstainedglass_panel_cyan, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_CYAN));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_PURPLE, new BlockItem(block_tempstainedglass_panel_purple, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_PURPLE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_BLUE, new BlockItem(block_tempstainedglass_panel_blue, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_BLUE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_BROWN, new BlockItem(block_tempstainedglass_panel_brown, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_BROWN));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_GREEN, new BlockItem(block_tempstainedglass_panel_green, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_GREEN));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_RED, new BlockItem(block_tempstainedglass_panel_red, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_RED));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_BLACK, new BlockItem(block_tempstainedglass_panel_black, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_BLACK));
		itemMap.put(NAME_HORIZONTALGLASSPANEL, new BlockItem(block_horizontalglass_panel, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALGLASSPANEL));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_WHITE, new BlockItem(block_horizontalstaindglass_panel_white, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_WHITE));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_ORANGE, new BlockItem(block_horizontalstaindglass_panel_orange, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_ORANGE));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_MAGENTA, new BlockItem(block_horizontalstaindglass_panel_magenta, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_MAGENTA));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_LIGHT_BLUE, new BlockItem(block_horizontalstaindglass_panel_light_blue, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_LIGHT_BLUE));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_YELLOW, new BlockItem(block_horizontalstaindglass_panel_yellow, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_YELLOW));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_LIME, new BlockItem(block_horizontalstaindglass_panel_lime, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_LIME));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_PINK, new BlockItem(block_horizontalstaindglass_panel_pink, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_PINK));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_GRAY, new BlockItem(block_horizontalstaindglass_panel_gray, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_GRAY));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_LIGHT_GRAY, new BlockItem(block_horizontalstaindglass_panel_light_gray, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_LIGHT_GRAY));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_CYAN, new BlockItem(block_horizontalstaindglass_panel_cyan, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_CYAN));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_PURPLE, new BlockItem(block_horizontalstaindglass_panel_purple, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_PURPLE));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_BLUE, new BlockItem(block_horizontalstaindglass_panel_blue, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_BLUE));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_BROWN, new BlockItem(block_horizontalstaindglass_panel_brown, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_BROWN));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_GREEN, new BlockItem(block_horizontalstaindglass_panel_green, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_GREEN));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_RED, new BlockItem(block_horizontalstaindglass_panel_red, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_RED));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_BLACK, new BlockItem(block_horizontalstaindglass_panel_black, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_BLACK));
		itemMap.put(NAME_HORIZONTALTEMPERDGLASSPANEL, new BlockItem(block_htempglass_panel, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDGLASSPANEL));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_WHITE, new BlockItem(block_htempstainedglass_panel_white, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_WHITE));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_ORANGE, new BlockItem(block_htempstainedglass_panel_orange, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_ORANGE));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_MAGENTA, new BlockItem(block_htempstainedglass_panel_magenta, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_MAGENTA));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIGHT_BLUE, new BlockItem(block_htempstainedglass_panel_light_blue, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIGHT_BLUE));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_YELLOW, new BlockItem(block_htempstainedglass_panel_yellow, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_YELLOW));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIME, new BlockItem(block_htempstainedglass_panel_lime, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIME));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_PINK, new BlockItem(block_htempstainedglass_panel_pink, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_PINK));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_GRAY, new BlockItem(block_htempstainedglass_panel_gray, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_GRAY));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIGHT_GRAY, new BlockItem(block_htempstainedglass_panel_light_gray, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIGHT_GRAY));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_CYAN, new BlockItem(block_htempstainedglass_panel_cyan, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_CYAN));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_PURPLE, new BlockItem(block_htempstainedglass_panel_purple, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_PURPLE));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BLUE, new BlockItem(block_htempstainedglass_panel_blue, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BLUE));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BROWN, new BlockItem(block_htempstainedglass_panel_brown, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BROWN));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_GREEN, new BlockItem(block_htempstainedglass_panel_green, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_GREEN));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_RED, new BlockItem(block_htempstainedglass_panel_red, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_RED));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BLACK, new BlockItem(block_htempstainedglass_panel_black, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BLACK));
		itemMap.put(NAME_WOODTABLE_ACACIA, new BlockItem(block_woodtable_acacia, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_WOODTABLE_ACACIA));
		itemMap.put(NAME_WOODTABLE_BIRCH, new BlockItem(block_woodtable_birch, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_WOODTABLE_BIRCH));
		itemMap.put(NAME_WOODTABLE_DARKOAK, new BlockItem(block_woodtable_darkoak, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_WOODTABLE_DARKOAK));
		itemMap.put(NAME_WOODTABLE_JUNGLE, new BlockItem(block_woodtable_jungle, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_WOODTABLE_JUNGLE));
		itemMap.put(NAME_WOODTABLE_OAK, new BlockItem(block_woodtable_oak, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_WOODTABLE_OAK));
		itemMap.put(NAME_WOODTABLE_SPRUCE, new BlockItem(block_woodtable_spruce, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_WOODTABLE_SPRUCE));
		itemMap.put(NAME_MAGICGLASS, new BlockItem(block_magicglass, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_MAGICGLASS));
	}


	public static void register(Register<Block> event) {
		for(String key : NAME_LIST) {
			if (blockMap.containsKey(key)) {
				event.getRegistry().register(blockMap.get(key));
			}
		}
	}

	public static void registerItem(Register<Item> event) {
		for(String key : NAME_LIST) {
			if (itemMap.containsKey(key)) {
				event.getRegistry().register(itemMap.get(key));
			}
		}
	}
}

