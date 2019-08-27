package mod.drf.furniture.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mod.drf.core.Mod_DiningFurniture;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent.Register;

public class BlockFurniture {
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
	public static final String NAME_MAGICGLASS = "magicglass";


	public static Block block_dworkbench = new BlockFurnitureWorkBench().setRegistryName(NAME_DININGWORKBENCH);

	public static Block block_tempglass = new BlockTemperedGlass(Block.Properties.create(Material.GLASS).hardnessAndResistance(5.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDGLASS);

	public static Block block_tempglass_panel = new BlockTemperedGlassPanel(Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDGLASSPANEL);

	public static Block block_tempstainedglass_white = new BlockTemperedStainedGlass(EnumDyeColor.WHITE, Block.Properties.create(Material.GLASS).hardnessAndResistance(5.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_WHITE);
	public static Block block_tempstainedglass_orange = new BlockTemperedStainedGlass(EnumDyeColor.ORANGE, Block.Properties.create(Material.GLASS).hardnessAndResistance(5.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_ORANGE);
	public static Block block_tempstainedglass_magenta = new BlockTemperedStainedGlass(EnumDyeColor.MAGENTA, Block.Properties.create(Material.GLASS).hardnessAndResistance(5.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_MAGENTA);
	public static Block block_tempstainedglass_light_blue = new BlockTemperedStainedGlass(EnumDyeColor.LIGHT_BLUE, Block.Properties.create(Material.GLASS).hardnessAndResistance(5.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_LIGHT_BLUE);
	public static Block block_tempstainedglass_yellow = new BlockTemperedStainedGlass(EnumDyeColor.YELLOW, Block.Properties.create(Material.GLASS).hardnessAndResistance(5.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_YELLOW);
	public static Block block_tempstainedglass_lime = new BlockTemperedStainedGlass(EnumDyeColor.LIME, Block.Properties.create(Material.GLASS).hardnessAndResistance(5.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_LIME);
	public static Block block_tempstainedglass_pink = new BlockTemperedStainedGlass(EnumDyeColor.PINK, Block.Properties.create(Material.GLASS).hardnessAndResistance(5.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_PINK);
	public static Block block_tempstainedglass_gray = new BlockTemperedStainedGlass(EnumDyeColor.GRAY, Block.Properties.create(Material.GLASS).hardnessAndResistance(5.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_GRAY);
	public static Block block_tempstainedglass_light_gray = new BlockTemperedStainedGlass(EnumDyeColor.LIGHT_GRAY, Block.Properties.create(Material.GLASS).hardnessAndResistance(5.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_LIGHT_GRAY);
	public static Block block_tempstainedglass_cyan = new BlockTemperedStainedGlass(EnumDyeColor.CYAN, Block.Properties.create(Material.GLASS).hardnessAndResistance(5.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_CYAN);
	public static Block block_tempstainedglass_purple = new BlockTemperedStainedGlass(EnumDyeColor.PURPLE, Block.Properties.create(Material.GLASS).hardnessAndResistance(5.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_PURPLE);
	public static Block block_tempstainedglass_blue = new BlockTemperedStainedGlass(EnumDyeColor.BLUE, Block.Properties.create(Material.GLASS).hardnessAndResistance(5.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_BLUE);
	public static Block block_tempstainedglass_brown = new BlockTemperedStainedGlass(EnumDyeColor.BROWN, Block.Properties.create(Material.GLASS).hardnessAndResistance(5.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_BROWN);
	public static Block block_tempstainedglass_green = new BlockTemperedStainedGlass(EnumDyeColor.GREEN, Block.Properties.create(Material.GLASS).hardnessAndResistance(5.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_GREEN);
	public static Block block_tempstainedglass_red = new BlockTemperedStainedGlass(EnumDyeColor.RED, Block.Properties.create(Material.GLASS).hardnessAndResistance(5.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_RED);
	public static Block block_tempstainedglass_black = new BlockTemperedStainedGlass(EnumDyeColor.BLACK, Block.Properties.create(Material.GLASS).hardnessAndResistance(5.0F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_BLACK);

	public static Block block_tempstainedglass_panel_white = new BlockTemperedStainedGlassPanel(EnumDyeColor.WHITE, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_WHITE);
	public static Block block_tempstainedglass_panel_orange = new BlockTemperedStainedGlassPanel(EnumDyeColor.ORANGE, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_ORANGE);
	public static Block block_tempstainedglass_panel_magenta = new BlockTemperedStainedGlassPanel(EnumDyeColor.MAGENTA, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_MAGENTA);
	public static Block block_tempstainedglass_panel_light_blue = new BlockTemperedStainedGlassPanel(EnumDyeColor.LIGHT_BLUE, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_LIGHT_BLUE);
	public static Block block_tempstainedglass_panel_yellow = new BlockTemperedStainedGlassPanel(EnumDyeColor.YELLOW, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_YELLOW);
	public static Block block_tempstainedglass_panel_lime = new BlockTemperedStainedGlassPanel(EnumDyeColor.LIME, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_LIME);
	public static Block block_tempstainedglass_panel_pink = new BlockTemperedStainedGlassPanel(EnumDyeColor.PINK, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_PINK);
	public static Block block_tempstainedglass_panel_gray = new BlockTemperedStainedGlassPanel(EnumDyeColor.GRAY, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_GRAY);
	public static Block block_tempstainedglass_panel_light_gray = new BlockTemperedStainedGlassPanel(EnumDyeColor.LIGHT_GRAY, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_LIGHT_GRAY);
	public static Block block_tempstainedglass_panel_cyan = new BlockTemperedStainedGlassPanel(EnumDyeColor.CYAN, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_CYAN);
	public static Block block_tempstainedglass_panel_purple = new BlockTemperedStainedGlassPanel(EnumDyeColor.PURPLE, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_PURPLE);
	public static Block block_tempstainedglass_panel_blue = new BlockTemperedStainedGlassPanel(EnumDyeColor.BLUE, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_BLUE);
	public static Block block_tempstainedglass_panel_brown = new BlockTemperedStainedGlassPanel(EnumDyeColor.BROWN, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_BROWN);
	public static Block block_tempstainedglass_panel_green = new BlockTemperedStainedGlassPanel(EnumDyeColor.GREEN, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_GREEN);
	public static Block block_tempstainedglass_panel_red = new BlockTemperedStainedGlassPanel(EnumDyeColor.RED, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_RED);
	public static Block block_tempstainedglass_panel_black = new BlockTemperedStainedGlassPanel(EnumDyeColor.BLACK, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_BLACK);

	public static Block block_horizontalglass_panel = new BlockHorizontalGlassPanel(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALGLASSPANEL);

	public static Block block_horizontalstaindglass_panel_white = new BlockHorizontalStaindGlassPanel(EnumDyeColor.WHITE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_WHITE);
	public static Block block_horizontalstaindglass_panel_orange = new BlockHorizontalStaindGlassPanel(EnumDyeColor.ORANGE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_ORANGE);
	public static Block block_horizontalstaindglass_panel_magenta = new BlockHorizontalStaindGlassPanel(EnumDyeColor.MAGENTA, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_MAGENTA);
	public static Block block_horizontalstaindglass_panel_light_blue = new BlockHorizontalStaindGlassPanel(EnumDyeColor.LIGHT_BLUE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_LIGHT_BLUE);
	public static Block block_horizontalstaindglass_panel_yellow = new BlockHorizontalStaindGlassPanel(EnumDyeColor.YELLOW, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_YELLOW);
	public static Block block_horizontalstaindglass_panel_lime = new BlockHorizontalStaindGlassPanel(EnumDyeColor.LIME, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_LIME);
	public static Block block_horizontalstaindglass_panel_pink = new BlockHorizontalStaindGlassPanel(EnumDyeColor.PINK, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_PINK);
	public static Block block_horizontalstaindglass_panel_gray = new BlockHorizontalStaindGlassPanel(EnumDyeColor.GRAY, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_GRAY);
	public static Block block_horizontalstaindglass_panel_light_gray = new BlockHorizontalStaindGlassPanel(EnumDyeColor.LIGHT_GRAY, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_LIGHT_GRAY);
	public static Block block_horizontalstaindglass_panel_cyan = new BlockHorizontalStaindGlassPanel(EnumDyeColor.CYAN, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_CYAN);
	public static Block block_horizontalstaindglass_panel_purple = new BlockHorizontalStaindGlassPanel(EnumDyeColor.PURPLE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_PURPLE);
	public static Block block_horizontalstaindglass_panel_blue = new BlockHorizontalStaindGlassPanel(EnumDyeColor.BLUE, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_BLUE);
	public static Block block_horizontalstaindglass_panel_brown = new BlockHorizontalStaindGlassPanel(EnumDyeColor.BROWN, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_BROWN);
	public static Block block_horizontalstaindglass_panel_green = new BlockHorizontalStaindGlassPanel(EnumDyeColor.GREEN, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_GREEN);
	public static Block block_horizontalstaindglass_panel_red = new BlockHorizontalStaindGlassPanel(EnumDyeColor.RED, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_RED);
	public static Block block_horizontalstaindglass_panel_black = new BlockHorizontalStaindGlassPanel(EnumDyeColor.BLACK, Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_BLACK);

	public static Block block_htempglass_panel = new BlockHorizontalGlassPanel(Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDGLASSPANEL);

	public static Block block_htempstainedglass_panel_white = new BlockHorizontalStaindGlassPanel(EnumDyeColor.WHITE, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_WHITE);
	public static Block block_htempstainedglass_panel_orange = new BlockHorizontalStaindGlassPanel(EnumDyeColor.ORANGE, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_ORANGE);
	public static Block block_htempstainedglass_panel_magenta = new BlockHorizontalStaindGlassPanel(EnumDyeColor.MAGENTA, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_MAGENTA);
	public static Block block_htempstainedglass_panel_light_blue = new BlockHorizontalStaindGlassPanel(EnumDyeColor.LIGHT_BLUE, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIGHT_BLUE);
	public static Block block_htempstainedglass_panel_yellow = new BlockHorizontalStaindGlassPanel(EnumDyeColor.YELLOW, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_YELLOW);
	public static Block block_htempstainedglass_panel_lime = new BlockHorizontalStaindGlassPanel(EnumDyeColor.LIME, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIME);
	public static Block block_htempstainedglass_panel_pink = new BlockHorizontalStaindGlassPanel(EnumDyeColor.PINK, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_PINK);
	public static Block block_htempstainedglass_panel_gray = new BlockHorizontalStaindGlassPanel(EnumDyeColor.GRAY, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_GRAY);
	public static Block block_htempstainedglass_panel_light_gray = new BlockHorizontalStaindGlassPanel(EnumDyeColor.LIGHT_GRAY, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIGHT_GRAY);
	public static Block block_htempstainedglass_panel_cyan = new BlockHorizontalStaindGlassPanel(EnumDyeColor.CYAN, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_CYAN);
	public static Block block_htempstainedglass_panel_purple = new BlockHorizontalStaindGlassPanel(EnumDyeColor.PURPLE, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_PURPLE);
	public static Block block_htempstainedglass_panel_blue = new BlockHorizontalStaindGlassPanel(EnumDyeColor.BLUE, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BLUE);
	public static Block block_htempstainedglass_panel_brown = new BlockHorizontalStaindGlassPanel(EnumDyeColor.BROWN, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BROWN);
	public static Block block_htempstainedglass_panel_green = new BlockHorizontalStaindGlassPanel(EnumDyeColor.GREEN, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_GREEN);
	public static Block block_htempstainedglass_panel_red = new BlockHorizontalStaindGlassPanel(EnumDyeColor.RED, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_RED);
	public static Block block_htempstainedglass_panel_black = new BlockHorizontalStaindGlassPanel(EnumDyeColor.BLACK, Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BLACK);

	public static Block block_magicglass = new BlockMagicGlass(Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5F,2000.0F).sound(SoundType.GLASS)).setRegistryName(NAME_MAGICGLASS);


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
		blockMap.put(NAME_MAGICGLASS,block_magicglass);


		itemMap = new HashMap<String, Item>();
		itemMap.put(NAME_DININGWORKBENCH, new ItemBlock(block_dworkbench, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_DININGWORKBENCH));
		itemMap.put(NAME_TEMPEREDGLASS, new ItemBlock(block_tempglass, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDGLASS));
		itemMap.put(NAME_TEMPEREDGLASSPANEL, new ItemBlock(block_tempglass_panel, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDGLASSPANEL));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_WHITE, new ItemBlock(block_tempstainedglass_white, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_WHITE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_ORANGE, new ItemBlock(block_tempstainedglass_orange, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_ORANGE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_MAGENTA, new ItemBlock(block_tempstainedglass_magenta, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_MAGENTA));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_LIGHT_BLUE, new ItemBlock(block_tempstainedglass_light_blue, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_LIGHT_BLUE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_YELLOW, new ItemBlock(block_tempstainedglass_yellow, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_YELLOW));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_LIME, new ItemBlock(block_tempstainedglass_lime, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_LIME));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_PINK, new ItemBlock(block_tempstainedglass_pink, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_PINK));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_GRAY, new ItemBlock(block_tempstainedglass_gray, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_GRAY));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_LIGHT_GRAY, new ItemBlock(block_tempstainedglass_light_gray, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_LIGHT_GRAY));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_CYAN, new ItemBlock(block_tempstainedglass_cyan, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_CYAN));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_PURPLE, new ItemBlock(block_tempstainedglass_purple, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_PURPLE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_BLUE, new ItemBlock(block_tempstainedglass_blue, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_BLUE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_BROWN, new ItemBlock(block_tempstainedglass_brown, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_BROWN));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_GREEN, new ItemBlock(block_tempstainedglass_green, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_GREEN));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_RED, new ItemBlock(block_tempstainedglass_red, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_RED));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASS_BLACK, new ItemBlock(block_tempstainedglass_black, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASS_BLACK));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_WHITE, new ItemBlock(block_tempstainedglass_panel_white, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_WHITE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_ORANGE, new ItemBlock(block_tempstainedglass_panel_orange, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_ORANGE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_MAGENTA, new ItemBlock(block_tempstainedglass_panel_magenta, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_MAGENTA));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_LIGHT_BLUE, new ItemBlock(block_tempstainedglass_panel_light_blue, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_LIGHT_BLUE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_YELLOW, new ItemBlock(block_tempstainedglass_panel_yellow, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_YELLOW));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_LIME, new ItemBlock(block_tempstainedglass_panel_lime, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_LIME));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_PINK, new ItemBlock(block_tempstainedglass_panel_pink, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_PINK));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_GRAY, new ItemBlock(block_tempstainedglass_panel_gray, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_GRAY));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_LIGHT_GRAY, new ItemBlock(block_tempstainedglass_panel_light_gray, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_LIGHT_GRAY));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_CYAN, new ItemBlock(block_tempstainedglass_panel_cyan, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_CYAN));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_PURPLE, new ItemBlock(block_tempstainedglass_panel_purple, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_PURPLE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_BLUE, new ItemBlock(block_tempstainedglass_panel_blue, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_BLUE));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_BROWN, new ItemBlock(block_tempstainedglass_panel_brown, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_BROWN));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_GREEN, new ItemBlock(block_tempstainedglass_panel_green, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_GREEN));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_RED, new ItemBlock(block_tempstainedglass_panel_red, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_RED));
		itemMap.put(NAME_TEMPEREDSTAINEDGLASSPANEL_BLACK, new ItemBlock(block_tempstainedglass_panel_black, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_TEMPEREDSTAINEDGLASSPANEL_BLACK));
		itemMap.put(NAME_HORIZONTALGLASSPANEL, new ItemBlock(block_horizontalglass_panel, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALGLASSPANEL));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_WHITE, new ItemBlock(block_horizontalstaindglass_panel_white, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_WHITE));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_ORANGE, new ItemBlock(block_horizontalstaindglass_panel_orange, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_ORANGE));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_MAGENTA, new ItemBlock(block_horizontalstaindglass_panel_magenta, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_MAGENTA));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_LIGHT_BLUE, new ItemBlock(block_horizontalstaindglass_panel_light_blue, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_LIGHT_BLUE));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_YELLOW, new ItemBlock(block_horizontalstaindglass_panel_yellow, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_YELLOW));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_LIME, new ItemBlock(block_horizontalstaindglass_panel_lime, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_LIME));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_PINK, new ItemBlock(block_horizontalstaindglass_panel_pink, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_PINK));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_GRAY, new ItemBlock(block_horizontalstaindglass_panel_gray, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_GRAY));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_LIGHT_GRAY, new ItemBlock(block_horizontalstaindglass_panel_light_gray, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_LIGHT_GRAY));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_CYAN, new ItemBlock(block_horizontalstaindglass_panel_cyan, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_CYAN));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_PURPLE, new ItemBlock(block_horizontalstaindglass_panel_purple, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_PURPLE));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_BLUE, new ItemBlock(block_horizontalstaindglass_panel_blue, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_BLUE));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_BROWN, new ItemBlock(block_horizontalstaindglass_panel_brown, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_BROWN));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_GREEN, new ItemBlock(block_horizontalstaindglass_panel_green, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_GREEN));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_RED, new ItemBlock(block_horizontalstaindglass_panel_red, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_RED));
		itemMap.put(NAME_HORIZONTALSTAINEDGLASSPANEL_BLACK, new ItemBlock(block_horizontalstaindglass_panel_black, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALSTAINEDGLASSPANEL_BLACK));
		itemMap.put(NAME_HORIZONTALTEMPERDGLASSPANEL, new ItemBlock(block_htempglass_panel, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDGLASSPANEL));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_WHITE, new ItemBlock(block_htempstainedglass_panel_white, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_WHITE));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_ORANGE, new ItemBlock(block_htempstainedglass_panel_orange, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_ORANGE));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_MAGENTA, new ItemBlock(block_htempstainedglass_panel_magenta, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_MAGENTA));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIGHT_BLUE, new ItemBlock(block_htempstainedglass_panel_light_blue, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIGHT_BLUE));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_YELLOW, new ItemBlock(block_htempstainedglass_panel_yellow, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_YELLOW));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIME, new ItemBlock(block_htempstainedglass_panel_lime, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIME));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_PINK, new ItemBlock(block_htempstainedglass_panel_pink, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_PINK));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_GRAY, new ItemBlock(block_htempstainedglass_panel_gray, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_GRAY));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIGHT_GRAY, new ItemBlock(block_htempstainedglass_panel_light_gray, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_LIGHT_GRAY));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_CYAN, new ItemBlock(block_htempstainedglass_panel_cyan, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_CYAN));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_PURPLE, new ItemBlock(block_htempstainedglass_panel_purple, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_PURPLE));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BLUE, new ItemBlock(block_htempstainedglass_panel_blue, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BLUE));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BROWN, new ItemBlock(block_htempstainedglass_panel_brown, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BROWN));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_GREEN, new ItemBlock(block_htempstainedglass_panel_green, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_GREEN));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_RED, new ItemBlock(block_htempstainedglass_panel_red, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_RED));
		itemMap.put(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BLACK, new ItemBlock(block_htempstainedglass_panel_black, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_HORIZONTALTEMPERDSTAINDGLASSPANEL_BLACK));
		itemMap.put(NAME_MAGICGLASS, new ItemBlock(block_magicglass, new Item.Properties().group(Mod_DiningFurniture.tabFurniture)).setRegistryName(NAME_MAGICGLASS));
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

