package mod.drf.recipie;

import mod.drf.furniture.block.BlockFurniture;
import mod.drf.furniture.item.ItemFurniture;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;

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
		registerMenu(new FurnitureMenu(new ItemStack(BlockFurniture.block_temperedglass,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS,2),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));

		// 強化色付きガラス
		for (int i = 0; i < EnumDyeColor.values().length; i++){
			registerMenu(new FurnitureMenu(new ItemStack(BlockFurniture.block_temperedstainedglass,1, EnumDyeColor.values()[i].getDyeDamage()),
					new ItemStack[]{
							new ItemStack(Blocks.STAINED_GLASS,2,EnumDyeColor.values()[i].getDyeDamage()),
							new ItemStack(Blocks.OBSIDIAN,1)
					}));
			registerMenu(new FurnitureMenu(new ItemStack(BlockFurniture.block_temperedstainedglass,1, EnumDyeColor.values()[i].getDyeDamage()),
					new ItemStack[]{
							new ItemStack(Blocks.GLASS,2,0),
							new ItemStack(Blocks.OBSIDIAN,1),
							new ItemStack(Items.DYE,1,EnumDyeColor.values()[i].getMetadata())
					}));
		}

		// 強化ガラスパネル
		registerMenu(new FurnitureMenu(new ItemStack(BlockFurniture.block_temperedglasspanel,8),
				new ItemStack[]{
						new ItemStack(BlockFurniture.block_temperedglass,3)
				}));

		// 強化色付きガラスパネル
		for (int i = 0; i < EnumDyeColor.values().length; i++){
			registerMenu(new FurnitureMenu(new ItemStack(BlockFurniture.block_temperedstainedglasspanel,8, EnumDyeColor.BLACK.values()[i].getDyeDamage()),
					new ItemStack[]{
							new ItemStack(BlockFurniture.block_temperedstainedglass,3,EnumDyeColor.values()[i].getDyeDamage())
					}));
		}

		// 水平ガラスパネル
		registerMenu(new FurnitureMenu(new ItemStack(BlockFurniture.block_horizontalglasspanel,1),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS_PANE,1),
						new ItemStack(Blocks.TRAPDOOR)
				}));

		// 強化水平ガラスパネル
		registerMenu(new FurnitureMenu(new ItemStack(BlockFurniture.block_horizontaltemperedglasspanel,4),
				new ItemStack[]{
						new ItemStack(Blocks.GLASS_PANE,8),
						new ItemStack(Blocks.TRAPDOOR,4),
						new ItemStack(Blocks.OBSIDIAN,1)
				}));

		// 水平色付きガラスパネル
		for (int i = 0; i < EnumDyeColor.values().length; i++){
			registerMenu(new FurnitureMenu(new ItemStack(BlockFurniture.block_horizontalstainedglasspanel,1, EnumDyeColor.values()[i].getDyeDamage()),
					new ItemStack[]{
							new ItemStack(Blocks.STAINED_GLASS_PANE,1,EnumDyeColor.values()[i].getDyeDamage()),
							new ItemStack(Blocks.TRAPDOOR,1)
					}));

			registerMenu(new FurnitureMenu(new ItemStack(BlockFurniture.block_horizontalstainedglasspanel,8, EnumDyeColor.values()[i].getDyeDamage()),
					new ItemStack[]{
							new ItemStack(BlockFurniture.block_horizontalglasspanel,8),
							new ItemStack(Blocks.TRAPDOOR,1),
							new ItemStack(Items.DYE,1,EnumDyeColor.values()[i].getMetadata())
					}));
		}

		// 強化水平色付きガラスパネル
		for (int i = 0; i < EnumDyeColor.values().length; i++){
			registerMenu(new FurnitureMenu(new ItemStack(BlockFurniture.block_horizontaltemperedstainedglasspanel,4, EnumDyeColor.values()[i].getDyeDamage()),
					new ItemStack[]{
							new ItemStack(Blocks.STAINED_GLASS_PANE,8,EnumDyeColor.values()[i].getDyeDamage()),
							new ItemStack(Blocks.TRAPDOOR,4),
							new ItemStack(Blocks.OBSIDIAN,1)
					}));
		}

		// 各種羊毛+糸  座布団
		for (int i = 0; i < EnumDyeColor.values().length; i++){
			registerMenu(new FurnitureMenu(new ItemStack(ItemFurniture.item_zabuton,1,EnumDyeColor.values()[i].getDyeDamage()),
					new ItemStack[]{
							new ItemStack(Blocks.WOOL,1,EnumDyeColor.values()[i].getMetadata()),
							new ItemStack(Items.STRING,4),
					}));
		}

		// 白羊毛+糸+染料 色付き座布団
		for (int i = 1; i < EnumDyeColor.values().length; i++){
			registerMenu(new FurnitureMenu(new ItemStack(ItemFurniture.item_zabuton,1,EnumDyeColor.values()[i].getDyeDamage()),
					new ItemStack[]{
							new ItemStack(Blocks.WOOL,1,EnumDyeColor.WHITE.getMetadata()),
							new ItemStack(Items.STRING,4),
							new ItemStack(Items.DYE,1,EnumDyeColor.values()[i].getDyeDamage())
					}));
		}

		// 白座布団+染料 色付き座布団
		for (int i = 1; i < EnumDyeColor.values().length; i++){
			registerMenu(new FurnitureMenu(new ItemStack(ItemFurniture.item_zabuton,1,EnumDyeColor.values()[i].getDyeDamage()),
					new ItemStack[]{
							new ItemStack(ItemFurniture.item_zabuton,1,EnumDyeColor.WHITE.getDyeDamage()),
							new ItemStack(Items.DYE,1,EnumDyeColor.values()[i].getDyeDamage())
					}));
		}

		// woodChair
		for(int i = 0; i < BlockPlanks.EnumType.values().length; i++){
			registerMenu(new FurnitureMenu(new ItemStack(ItemFurniture.item_woodchair,1,BlockPlanks.EnumType.values()[i].getMetadata()),
					new ItemStack[]{
							new ItemStack(Blocks.PLANKS,3,BlockPlanks.EnumType.values()[i].getMetadata())
					}));
		}
	}
}
