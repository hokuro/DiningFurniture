package mod.drf.recipie;

import mod.drf.block.BlockCore;
import mod.drf.item.ItemCore;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class FurnitureMenu extends OriginalMenu {
	private static final OriginalMenuKind kind = OriginalMenuKind.DINING;
	private static FurnitureMenu instance;

	protected FurnitureMenu(){
    	instance = null;
    }

	public FurnitureMenu(ItemStack result, ItemStack[] ings) {
		super(result, ings);
	}


    public static FurnitureMenu getInstance(){
        if(instance == null){
        	instance = new FurnitureMenu();
        }
        return instance;
    }

	@Override
	public OriginalMenuKind getKind(){
		return kind;
	}

	@Override
	public void makeMenu() {

		// 強化ガラス
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempglass,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));

		// ステンドグラス1
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_white,1),
				new ItemStack[]{
						new ItemStack(Blocks.WHITE_STAINED_GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_orange,1),
				new ItemStack[]{
						new ItemStack(Blocks.ORANGE_STAINED_GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_magenta,1),
				new ItemStack[]{
						new ItemStack(Blocks.MAGENTA_STAINED_GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_light_blue,1),
				new ItemStack[]{
						new ItemStack(Blocks.LIGHT_BLUE_STAINED_GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_yellow,1),
				new ItemStack[]{
						new ItemStack(Blocks.YELLOW_STAINED_GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_lime,1),
				new ItemStack[]{
						new ItemStack(Blocks.LIME_STAINED_GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_pink,1),
				new ItemStack[]{
						new ItemStack(Blocks.PINK_STAINED_GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_gray,1),
				new ItemStack[]{
						new ItemStack(Blocks.GRAY_STAINED_GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_light_gray,1),
				new ItemStack[]{
						new ItemStack(Blocks.LIGHT_GRAY_STAINED_GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_cyan,1),
				new ItemStack[]{
						new ItemStack(Blocks.CYAN_STAINED_GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_purple,1),
				new ItemStack[]{
						new ItemStack(Blocks.PURPLE_STAINED_GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_blue,1),
				new ItemStack[]{
						new ItemStack(Blocks.BLUE_STAINED_GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_brown,1),
				new ItemStack[]{
						new ItemStack(Blocks.BROWN_STAINED_GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_green,1),
				new ItemStack[]{
						new ItemStack(Blocks.GREEN_STAINED_GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_red,1),
				new ItemStack[]{
						new ItemStack(Blocks.RED_STAINED_GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_black,1),
				new ItemStack[]{
						new ItemStack(Blocks.BLACK_STAINED_GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));

		// ステンドグラス2
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_white,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1),
						new ItemStack(Items.WHITE_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_orange,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1),
						new ItemStack(Items.ORANGE_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_magenta,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1),
						new ItemStack(Items.MAGENTA_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_light_blue,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1),
						new ItemStack(Items.LIGHT_BLUE_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_yellow,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1),
						new ItemStack(Items.YELLOW_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_lime,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1),
						new ItemStack(Items.LIME_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_pink,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1),
						new ItemStack(Items.PINK_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_gray,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1),
						new ItemStack(Items.GRAY_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_light_gray,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1),
						new ItemStack(Items.LIGHT_GRAY_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_cyan,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1),
						new ItemStack(Items.CYAN_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_purple,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1),
						new ItemStack(Items.PURPLE_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_blue,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1),
						new ItemStack(Items.BLUE_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_brown,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1),
						new ItemStack(Items.BROWN_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_green,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1),
						new ItemStack(Items.GREEN_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_red,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1),
						new ItemStack(Items.RED_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_black,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1),
						new ItemStack(Items.BLACK_DYE,1)
				}));

		// 強化ガラスパネル
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempglass_panel,8),
				new ItemStack[]{
						new ItemStack(BlockCore.block_tempglass,3)
				}));


		// 強化色付きガラスパネル
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_panel_white,8),
				new ItemStack[]{
				new ItemStack(BlockCore.block_tempstainedglass_white,3)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_panel_orange,8),
				new ItemStack[]{
				new ItemStack(BlockCore.block_tempstainedglass_orange,3)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_panel_magenta,8),
				new ItemStack[]{
				new ItemStack(BlockCore.block_tempstainedglass_magenta,3)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_panel_light_blue,8),
				new ItemStack[]{
				new ItemStack(BlockCore.block_tempstainedglass_light_blue,3)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_panel_yellow,8),
				new ItemStack[]{
				new ItemStack(BlockCore.block_tempstainedglass_yellow,3)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_panel_lime,8),
				new ItemStack[]{
				new ItemStack(BlockCore.block_tempstainedglass_lime,3)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_panel_pink,8),
				new ItemStack[]{
				new ItemStack(BlockCore.block_tempstainedglass_pink,3)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_panel_gray,8),
				new ItemStack[]{
				new ItemStack(BlockCore.block_tempstainedglass_gray,3)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_panel_light_gray,8),
				new ItemStack[]{
				new ItemStack(BlockCore.block_tempstainedglass_light_gray,3)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_panel_cyan,8),
				new ItemStack[]{
				new ItemStack(BlockCore.block_tempstainedglass_cyan,3)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_panel_purple,8),
				new ItemStack[]{
				new ItemStack(BlockCore.block_tempstainedglass_purple,3)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_panel_blue,8),
				new ItemStack[]{
				new ItemStack(BlockCore.block_tempstainedglass_blue,3)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_panel_brown,8),
				new ItemStack[]{
				new ItemStack(BlockCore.block_tempstainedglass_brown,3)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_panel_green,8),
				new ItemStack[]{
				new ItemStack(BlockCore.block_tempstainedglass_green,3)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_panel_red,8),
				new ItemStack[]{
				new ItemStack(BlockCore.block_tempstainedglass_red,3)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_tempstainedglass_panel_black,8),
				new ItemStack[]{
				new ItemStack(BlockCore.block_tempstainedglass_black,3)
		}));

		// 水平ガラスパネル
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalglass_panel,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR)
				}));

		// 強化水平ガラスパネル
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_htempglass_panel,4),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS_PANE,8),
						new ItemStack(Blocks.IRON_TRAPDOOR,4),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));

		// 水平色付きガラスパネル1
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_white,1),
				new ItemStack[]{
						new ItemStack(Blocks.WHITE_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_orange,1),
				new ItemStack[]{
						new ItemStack(Blocks.ORANGE_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_magenta,1),
				new ItemStack[]{
						new ItemStack(Blocks.MAGENTA_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_light_blue,1),
				new ItemStack[]{
						new ItemStack(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_yellow,1),
				new ItemStack[]{
						new ItemStack(Blocks.YELLOW_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_lime,1),
				new ItemStack[]{
						new ItemStack(Blocks.LIME_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_pink,1),
				new ItemStack[]{
						new ItemStack(Blocks.PINK_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_gray,1),
				new ItemStack[]{
						new ItemStack(Blocks.GRAY_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_light_gray,1),
				new ItemStack[]{
						new ItemStack(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_cyan,1),
				new ItemStack[]{
						new ItemStack(Blocks.CYAN_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_purple,1),
				new ItemStack[]{
						new ItemStack(Blocks.PURPLE_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_blue,1),
				new ItemStack[]{
						new ItemStack(Blocks.BLUE_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_brown,1),
				new ItemStack[]{
						new ItemStack(Blocks.BROWN_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_green,1),
				new ItemStack[]{
						new ItemStack(Blocks.GREEN_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_red,1),
				new ItemStack[]{
						new ItemStack(Blocks.RED_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_black,1),
				new ItemStack[]{
						new ItemStack(Blocks.BLACK_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1)
				}));

		// 水平色付きガラスパネル2
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_white,1),
				new ItemStack[]{
						new ItemStack(BlockCore.block_horizontalglass_panel,8),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Items.WHITE_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_orange,1),
				new ItemStack[]{
						new ItemStack(BlockCore.block_horizontalglass_panel,8),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Items.ORANGE_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_magenta,1),
				new ItemStack[]{
						new ItemStack(BlockCore.block_horizontalglass_panel,8),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Items.MAGENTA_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_light_blue,1),
				new ItemStack[]{
						new ItemStack(BlockCore.block_horizontalglass_panel,8),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Items.LIGHT_BLUE_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_yellow,1),
				new ItemStack[]{
						new ItemStack(BlockCore.block_horizontalglass_panel,8),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Items.YELLOW_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_lime,1),
				new ItemStack[]{
						new ItemStack(BlockCore.block_horizontalglass_panel,8),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Items.LIME_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_pink,1),
				new ItemStack[]{
						new ItemStack(BlockCore.block_horizontalglass_panel,8),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Items.PINK_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_gray,1),
				new ItemStack[]{
						new ItemStack(BlockCore.block_horizontalglass_panel,8),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Items.GRAY_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_light_gray,1),
				new ItemStack[]{
						new ItemStack(BlockCore.block_horizontalglass_panel,8),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Items.LIGHT_GRAY_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_cyan,1),
				new ItemStack[]{
						new ItemStack(BlockCore.block_horizontalglass_panel,8),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Items.CYAN_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_purple,1),
				new ItemStack[]{
						new ItemStack(BlockCore.block_horizontalglass_panel,8),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Items.PURPLE_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_blue,1),
				new ItemStack[]{
						new ItemStack(BlockCore.block_horizontalglass_panel,8),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Items.BLUE_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_brown,1),
				new ItemStack[]{
						new ItemStack(BlockCore.block_horizontalglass_panel,8),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Items.BROWN_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_green,1),
				new ItemStack[]{
						new ItemStack(BlockCore.block_horizontalglass_panel,8),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Items.GREEN_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_red,1),
				new ItemStack[]{
						new ItemStack(BlockCore.block_horizontalglass_panel,8),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Items.RED_DYE,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_horizontalstaindglass_panel_black,1),
				new ItemStack[]{
						new ItemStack(BlockCore.block_horizontalglass_panel,8),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Items.BLACK_DYE,1)
				}));

		// 強化水平色付きガラスパネル
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_htempstainedglass_panel_white,1),
				new ItemStack[]{
						new ItemStack(Blocks.WHITE_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_htempstainedglass_panel_orange,1),
				new ItemStack[]{
						new ItemStack(Blocks.ORANGE_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_htempstainedglass_panel_magenta,1),
				new ItemStack[]{
						new ItemStack(Blocks.MAGENTA_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_htempstainedglass_panel_light_blue,1),
				new ItemStack[]{
						new ItemStack(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_htempstainedglass_panel_yellow,1),
				new ItemStack[]{
						new ItemStack(Blocks.YELLOW_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_htempstainedglass_panel_lime,1),
				new ItemStack[]{
						new ItemStack(Blocks.LIME_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_htempstainedglass_panel_pink,1),
				new ItemStack[]{
						new ItemStack(Blocks.PINK_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_htempstainedglass_panel_gray,1),
				new ItemStack[]{
						new ItemStack(Blocks.GRAY_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_htempstainedglass_panel_light_gray,1),
				new ItemStack[]{
						new ItemStack(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_htempstainedglass_panel_cyan,1),
				new ItemStack[]{
						new ItemStack(Blocks.CYAN_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_htempstainedglass_panel_purple,1),
				new ItemStack[]{
						new ItemStack(Blocks.PURPLE_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_htempstainedglass_panel_blue,1),
				new ItemStack[]{
						new ItemStack(Blocks.BLUE_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_htempstainedglass_panel_brown,1),
				new ItemStack[]{
						new ItemStack(Blocks.BROWN_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_htempstainedglass_panel_green,1),
				new ItemStack[]{
						new ItemStack(Blocks.GREEN_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_htempstainedglass_panel_red,1),
				new ItemStack[]{
						new ItemStack(Blocks.RED_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(BlockCore.block_htempstainedglass_panel_black,1),
				new ItemStack[]{
						new ItemStack(Blocks.BLACK_STAINED_GLASS_PANE,1),
						new ItemStack(Blocks.IRON_TRAPDOOR,1),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));


		// 各種羊毛+糸  座布団
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack[]{
				new ItemStack(Blocks.WHITE_WOOL,1),
				new ItemStack(Items.STRING,4),
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_orange,1),
				new ItemStack[]{
				new ItemStack(Blocks.ORANGE_WOOL,1),
				new ItemStack(Items.STRING,4),
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_magenta,1),
				new ItemStack[]{
				new ItemStack(Blocks.MAGENTA_WOOL,1),
				new ItemStack(Items.STRING,4),
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_light_blue,1),
				new ItemStack[]{
				new ItemStack(Blocks.LIGHT_BLUE_WOOL,1),
				new ItemStack(Items.STRING,4),
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_yellow,1),
				new ItemStack[]{
				new ItemStack(Blocks.YELLOW_WOOL,1),
				new ItemStack(Items.STRING,4),
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_lime,1),
				new ItemStack[]{
				new ItemStack(Blocks.LIME_WOOL,1),
				new ItemStack(Items.STRING,4),
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_pink,1),
				new ItemStack[]{
				new ItemStack(Blocks.PINK_WOOL,1),
				new ItemStack(Items.STRING,4),
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_gray,1),
				new ItemStack[]{
				new ItemStack(Blocks.GRAY_WOOL,1),
				new ItemStack(Items.STRING,4),
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_silver,1),
				new ItemStack[]{
				new ItemStack(Blocks.LIGHT_GRAY_WOOL,1),
				new ItemStack(Items.STRING,4),
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_cyan,1),
				new ItemStack[]{
				new ItemStack(Blocks.CYAN_WOOL,1),
				new ItemStack(Items.STRING,4),
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_purple,1),
				new ItemStack[]{
				new ItemStack(Blocks.PURPLE_WOOL,1),
				new ItemStack(Items.STRING,4),
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_blue,1),
				new ItemStack[]{
				new ItemStack(Blocks.BLUE_WOOL,1),
				new ItemStack(Items.STRING,4),
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_brown,1),
				new ItemStack[]{
				new ItemStack(Blocks.BROWN_WOOL,1),
				new ItemStack(Items.STRING,4),
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_green,1),
				new ItemStack[]{
				new ItemStack(Blocks.GREEN_WOOL,1),
				new ItemStack(Items.STRING,4),
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_red,1),
				new ItemStack[]{
				new ItemStack(Blocks.RED_WOOL,1),
				new ItemStack(Items.STRING,4),
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_black,1),
				new ItemStack[]{
				new ItemStack(Blocks.BLACK_WOOL,1),
				new ItemStack(Items.STRING,4),
		}));

		// 白羊毛+糸+染料 色付き座布団
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack[]{
				new ItemStack(Blocks.WHITE_WOOL,1),
				new ItemStack(Items.STRING,4),
				new ItemStack(Items.WHITE_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_orange,1),
				new ItemStack[]{
				new ItemStack(Blocks.WHITE_WOOL,1),
				new ItemStack(Items.STRING,4),
				new ItemStack(Items.ORANGE_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_magenta,1),
				new ItemStack[]{
				new ItemStack(Blocks.WHITE_WOOL,1),
				new ItemStack(Items.STRING,4),
				new ItemStack(Items.MAGENTA_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_light_blue,1),
				new ItemStack[]{
				new ItemStack(Blocks.WHITE_WOOL,1),
				new ItemStack(Items.STRING,4),
				new ItemStack(Items.LIGHT_BLUE_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_yellow,1),
				new ItemStack[]{
				new ItemStack(Blocks.WHITE_WOOL,1),
				new ItemStack(Items.STRING,4),
				new ItemStack(Items.YELLOW_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_lime,1),
				new ItemStack[]{
				new ItemStack(Blocks.WHITE_WOOL,1),
				new ItemStack(Items.STRING,4),
				new ItemStack(Items.LIME_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_pink,1),
				new ItemStack[]{
				new ItemStack(Blocks.WHITE_WOOL,1),
				new ItemStack(Items.STRING,4),
				new ItemStack(Items.PINK_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_gray,1),
				new ItemStack[]{
				new ItemStack(Blocks.WHITE_WOOL,1),
				new ItemStack(Items.STRING,4),
				new ItemStack(Items.GRAY_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_silver,1),
				new ItemStack[]{
				new ItemStack(Blocks.WHITE_WOOL,1),
				new ItemStack(Items.STRING,4),
				new ItemStack(Items.LIGHT_GRAY_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_cyan,1),
				new ItemStack[]{
				new ItemStack(Blocks.WHITE_WOOL,1),
				new ItemStack(Items.STRING,4),
				new ItemStack(Items.CYAN_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_purple,1),
				new ItemStack[]{
				new ItemStack(Blocks.WHITE_WOOL,1),
				new ItemStack(Items.STRING,4),
				new ItemStack(Items.PURPLE_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_blue,1),
				new ItemStack[]{
				new ItemStack(Blocks.WHITE_WOOL,1),
				new ItemStack(Items.STRING,4),
				new ItemStack(Items.BLUE_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_brown,1),
				new ItemStack[]{
				new ItemStack(Blocks.WHITE_WOOL,1),
				new ItemStack(Items.STRING,4),
				new ItemStack(Items.BROWN_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_green,1),
				new ItemStack[]{
				new ItemStack(Blocks.WHITE_WOOL,1),
				new ItemStack(Items.STRING,4),
				new ItemStack(Items.GREEN_DYE,1)

		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_red,1),
				new ItemStack[]{
				new ItemStack(Blocks.WHITE_WOOL,1),
				new ItemStack(Items.STRING,4),
				new ItemStack(Items.RED_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_black,1),
				new ItemStack[]{
				new ItemStack(Blocks.WHITE_WOOL,1),
				new ItemStack(Items.STRING,4),
				new ItemStack(Items.BLACK_DYE,1)
		}));


		// 白座布団+染料 色付き座布団
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack[]{
				new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack(Items.WHITE_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_orange,1),
				new ItemStack[]{
				new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack(Items.ORANGE_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_magenta,1),
				new ItemStack[]{
				new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack(Items.MAGENTA_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_light_blue,1),
				new ItemStack[]{
				new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack(Items.LIGHT_BLUE_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_yellow,1),
				new ItemStack[]{
				new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack(Items.YELLOW_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_lime,1),
				new ItemStack[]{
				new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack(Items.LIME_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_pink,1),
				new ItemStack[]{
				new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack(Items.PINK_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_gray,1),
				new ItemStack[]{
				new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack(Items.GRAY_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_silver,1),
				new ItemStack[]{
				new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack(Items.LIGHT_GRAY_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_cyan,1),
				new ItemStack[]{
				new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack(Items.CYAN_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_purple,1),
				new ItemStack[]{
				new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack(Items.PURPLE_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_blue,1),
				new ItemStack[]{
				new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack(Items.BLUE_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_brown,1),
				new ItemStack[]{
				new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack(Items.BROWN_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_green,1),
				new ItemStack[]{
				new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack(Items.GREEN_DYE,1)

		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_red,1),
				new ItemStack[]{
				new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack(Items.RED_DYE,1)
		}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_zabuton_black,1),
				new ItemStack[]{
				new ItemStack(ItemCore.item_zabuton_white,1),
				new ItemStack(Items.INK_SAC,1)
		}));

		// woodChair
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_chair_oak,1),
				new ItemStack[]{
						new ItemStack(Blocks.OAK_PLANKS,3)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_chair_spruce,1),
				new ItemStack[]{
						new ItemStack(Blocks.SPRUCE_PLANKS,3)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_chair_birch,1),
				new ItemStack[]{
						new ItemStack(Blocks.BIRCH_PLANKS,3)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_chair_jungle,1),
				new ItemStack[]{
						new ItemStack(Blocks.JUNGLE_PLANKS,3)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_chair_acacia,1),
				new ItemStack[]{
						new ItemStack(Blocks.ACACIA_PLANKS,3)
				}));
		registerMenu(new FurnitureMenu(new ItemStack(ItemCore.item_chair_dark_oak,1),
				new ItemStack[]{
						new ItemStack(Blocks.DARK_OAK_PLANKS,3)
				}));
	}
}
