package mod.drf.recipie;

import java.util.ArrayList;
import java.util.List;

import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.Item.ItemFoods.EnumFlapeSyrup;
import mod.drf.foods.Item.ItemFoods.EnumFlowerHalb;
import mod.drf.foods.Item.ItemFoods.EnumIceFlavor;
import mod.drf.foods.block.BlockFoods;
import mod.drf.util.ModUtil;
import mod.drf.util.ModUtil.CompaierLevel;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemFishFood.FishType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;

public class CookingMenu extends OriginalMenu {
	private static final OriginalMenuKind kind = OriginalMenuKind.COOKING;
	private static CookingMenu instance;
	private boolean isTopping = false;
	private ItemStack[] topping;

	protected CookingMenu(){
    	instance = null;
    }

	public CookingMenu(ItemStack result, ItemStack[] ings) {
		super(result, ings);
		isTopping = false;
		topping = new ItemStack[0];
	}

	public CookingMenu(ItemStack result, ItemStack[] ings, ItemStack[] add ) {
		super(result, ings);
		isTopping = true;
		topping = add.clone();
	}

    public static CookingMenu getInstance(){
        if(instance == null){
        	instance = new CookingMenu();
        }
        return instance;
    }

	@Override
	public OriginalMenuKind getKind(){
		return kind;
	}

	@Override
	public boolean checkServe(ItemStack[] ings){

		ItemStack[] ing = new ItemStack[OriginalMenuKind.COOKING.getLength()-1];
		for (int i = 0; i < OriginalMenuKind.COOKING.getLength()-1; i++){
			ing[i] = ings[i];
		}

		boolean check = false;
		check = super.checkServe(ings);

		if (check && this.isTopping){
			check = false;
			for (ItemStack item : topping){
				if (ModUtil.compareItemStacks(ings[OriginalMenuKind.COOKING.getLength()-1], item, CompaierLevel.LEVEL_EQUAL_META)&&
						ings[OriginalMenuKind.COOKING.getLength()-1].getCount() >= item.getCount()){
					check = true;
					break;
				}
			}
		}
		return check;
	}

	@Override
	public boolean checkServe(IInventory inv){
		ItemStack[] ings = new ItemStack[OriginalMenuKind.COOKING.getLength()];
		ItemStack add;
		for (int i = 0; i < OriginalMenuKind.COOKING.getLength(); i++){
			ings[i] = inv.getStackInSlot(i);
		}
		return checkServe(ings);
	}

	public boolean isTopping(){
		return this.isTopping;
	}

	public int getToppingCount(){
		return this.topping.length;
	}

	public ItemStack[] getToppings(){
		return this.topping.clone();
	}

	public ItemStack getTopping(int index){
		if (index < topping.length){
			return topping[index];
		}
		return ItemStack.EMPTY;
	}

	@Override
	public List<OriginalMenu> getMenu(){
		List<OriginalMenu> menus = new ArrayList<OriginalMenu>();

		// パイ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_row_hallpie,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,1),
						new ItemStack(Items.EGG,1)
				}));
		// チョコパイ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_row_chocohallpie,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,1),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_choco,1)
				}));
		// サラダパイ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_row_saladahallpie,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,1),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(Items.POTATO,1),
						new ItemStack(Items.CARROT,1),
						new ItemStack(Items.BEETROOT,1)
				}));
		// ミートパイ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_row_meethallpie,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,1),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(Items.BEEF,1),
						new ItemStack(Items.CHICKEN,1),
						new ItemStack(Items.PORKCHOP,1),
						new ItemStack(Items.MUTTON,1),
						new ItemStack(Items.RABBIT,1),
				}));
		// スタゲイジーパイ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_row_fishhallpie,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,1),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(Items.FISH,1,FishType.COD.getMetadata()),
						new ItemStack(Items.FISH,1,FishType.CLOWNFISH.getMetadata()),
						new ItemStack(Items.FISH,1,FishType.PUFFERFISH.getMetadata()),
						new ItemStack(Items.FISH,1,FishType.SALMON.getMetadata()),
				}));
		// かぼちゃパイ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_row_pumpkinhallpie,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,1),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(Blocks.PUMPKIN,1)
				}));
		// リンゴパイ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_row_applehallpie,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,1),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(Items.APPLE,1)
				}));
		// イカ墨パイ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_row_blackpie,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,1),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(Items.DYE,1, EnumDyeColor.BLACK.getDyeDamage())
				}));
		// 腐ったパイ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_row_zombihallpie,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,1),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(Items.ROTTEN_FLESH,1)
				}));

		// キャラメルパイ
		menus.add(new CookingMenu(new ItemStack(BlockFoods.block_caramelpie_hall,1),
				new ItemStack[]{
						new ItemStack(BlockFoods.block_pie_hall,1)
				},
				new ItemStack[]{new ItemStack(ItemFoods.item_caramel,1,0)}));

		// チョコケーキ
		menus.add(new CookingMenu(new ItemStack(BlockFoods.block_choco_cake,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,2),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_choco,1)
				}));

		// リンゴケーキ
		menus.add(new CookingMenu(new ItemStack(BlockFoods.block_apple_cake,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,2),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(Items.APPLE,1)
				}));

		// 野菜ケーキ
		menus.add(new CookingMenu(new ItemStack(BlockFoods.block_salada_cake,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,2),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(Items.POTATO,1),
						new ItemStack(Items.CARROT,1),
						new ItemStack(Items.BEETROOT,1)
				}));

		// スイカケーキ
		menus.add(new CookingMenu(new ItemStack(BlockFoods.block_mellon_cake,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,2),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(Items.MELON,1)
				}));

		// パンプキンケーキ
		menus.add(new CookingMenu(new ItemStack(BlockFoods.block_pumpkin_cake,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,2),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(Blocks.PUMPKIN,1)
				}));

		// レアチーズケーキ
		menus.add(new CookingMenu(new ItemStack(BlockFoods.block_reacheese_cake,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,2),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(BlockFoods.block_cheese,1)
				}));

		// イカ墨ケーキ
		menus.add(new CookingMenu(new ItemStack(BlockFoods.block_black_cake,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,2),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(Items.DYE,1, EnumDyeColor.BLACK.getDyeDamage())
				}));

		// 腐ったケーキ
		menus.add(new CookingMenu(new ItemStack(BlockFoods.block_zombi_cake,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,2),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(Items.ROTTEN_FLESH,1)
				}));

		// ピザ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_row_pizza,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(BlockFoods.block_cheese,1)
				},
				new ItemStack[]{
						ItemStack.EMPTY
				}));

		// 肉ピザ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_row_meetpizza,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(BlockFoods.block_cheese,1)
				},
				new ItemStack[]{
						new ItemStack(Items.BEEF,1),
						new ItemStack(Items.CHICKEN,1),
						new ItemStack(Items.PORKCHOP,1),
						new ItemStack(Items.MUTTON,1),
						new ItemStack(Items.RABBIT,1),
				}));

		// アンチョビピザ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_row_fishpizza,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(BlockFoods.block_cheese,1)
				},
				new ItemStack[]{
						new ItemStack(Items.FISH,1,FishType.COD.getMetadata()),
						new ItemStack(Items.FISH,1,FishType.CLOWNFISH.getMetadata()),
						new ItemStack(Items.FISH,1,FishType.PUFFERFISH.getMetadata()),
						new ItemStack(Items.FISH,1,FishType.SALMON.getMetadata()),
				}));

		// チーズ
		menus.add(new CookingMenu(new ItemStack(BlockFoods.block_cheese,1),
				new ItemStack[]{
						new ItemStack(Items.MILK_BUCKET,1),
						new ItemStack(ItemFoods.item_rennet,1)
				},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_mold,1)
				}));

		// ブルーチーズ
		menus.add(new CookingMenu(new ItemStack(BlockFoods.block_bluecheese,1),
				new ItemStack[]{
						new ItemStack(Items.MILK_BUCKET,1),
						new ItemStack(ItemFoods.item_rennet,1)
				},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_bluemold,1)
				}));




		// アイスクリームの素
		for (int i = 0; i < EnumIceFlavor.values.length; i++){
			menus.add(new CookingMenu(new ItemStack(ItemFoods.item_icemix,1, EnumIceFlavor.getValue(i).getDamage()),
					new ItemStack[]{
							new ItemStack(Items.EGG,3),
							new ItemStack(Items.MILK_BUCKET,1),
							new ItemStack(Items.SUGAR,2),
							new ItemStack(Items.GLASS_BOTTLE,1)
					},
					EnumIceFlavor.getValue(i).getBaseItem()
					));
		}
		// シロップ
		for (int i = 1; i < EnumFlapeSyrup.values.length; i++){
			menus.add(new CookingMenu(new ItemStack(ItemFoods.item_syrup,1,EnumFlapeSyrup.getValue(i).getDamage()),
					new ItemStack[]{
							PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM,1,0), PotionType.getPotionTypeForName("water")),
							new ItemStack(Items.SUGAR,2)
					},
					EnumFlapeSyrup.getValue(i).getBaseItem()
					));
		}

		// シロップかけかき氷
		for (int i = 1; i < EnumFlapeSyrup.values.length; i++){
			menus.add(new CookingMenu(new ItemStack(ItemFoods.item_crashedice,1,EnumFlapeSyrup.getValue(i).getDamage()),
					new ItemStack[]{
							new ItemStack(ItemFoods.item_crashedice,1,0),
							new ItemStack(ItemFoods.item_syrup,1,EnumFlapeSyrup.getValue(i).getDamage())
					}
					));
		}
		// 練乳掛けかき氷
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_milkcrashedice,1,0),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_crashedice,1,0),
						new ItemStack(ItemFoods.item_syrupmilk,1)
				}));

		// 練乳シロップかき氷
		for (int i = 1; i < EnumFlapeSyrup.values.length; i++){
			menus.add(new CookingMenu(new ItemStack(ItemFoods.item_milkcrashedice,1,EnumFlapeSyrup.getValue(i).getDamage()),
					new ItemStack[]{
							new ItemStack(ItemFoods.item_crashedice,1,0),
							new ItemStack(ItemFoods.item_syrupmilk,1),
							new ItemStack(ItemFoods.item_syrup,1,EnumFlapeSyrup.getValue(i).getDamage())
					}
					));
		}

		// アイスキャンディの素
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_sugarwater,1,0),
					new ItemStack[]{
							PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM,1,0), PotionType.getPotionTypeForName("water")),
							new ItemStack(Items.SUGAR,2),
							new ItemStack(Items.STICK,1)
					},
					new ItemStack[]{
							new ItemStack(Items.MILK_BUCKET,1)
					}
					));
		for (int i = 1; i < EnumFlapeSyrup.values.length; i++){
			menus.add(new CookingMenu(new ItemStack(ItemFoods.item_sugarwater,1,EnumFlapeSyrup.getValue(i).getDamage()),
					new ItemStack[]{
							PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM,1,0), PotionType.getPotionTypeForName("water")),
							new ItemStack(Items.SUGAR,2),
							new ItemStack(Items.STICK,1)
					},
					EnumFlapeSyrup.getValue(i).getBaseItem()
					));
		}

		// チョコ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_choco,1),
				new ItemStack[]{
						new ItemStack(Items.DYE,3,EnumDyeColor.BROWN.getDyeDamage()),
						new ItemStack(Items.SUGAR,1)
						},
				new ItemStack[]{
						ItemStack.EMPTY
				}));
		// ホワイトチョコ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_whitechoco,1),
				new ItemStack[]{
						new ItemStack(Items.DYE,3,EnumDyeColor.BROWN.getDyeDamage()),
						new ItemStack(Items.SUGAR,1)
						},
				new ItemStack[]{
						new ItemStack(Items.MILK_BUCKET,1)
				}));
		// プリン
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_pudding,4),
				new ItemStack[]{
						new ItemStack(Items.EGG,3),
						new ItemStack(Items.SUGAR,2),
						new ItemStack(Items.MILK_BUCKET,1),
						},
				new ItemStack[]{
						ItemStack.EMPTY
				}));
		// かぼちゃプリン
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_pumpkinpudding,4),
				new ItemStack[]{
						new ItemStack(Items.EGG,3),
						new ItemStack(Items.SUGAR,2),
						new ItemStack(Items.MILK_BUCKET,1),
						},
				new ItemStack[]{
						new ItemStack(Blocks.PUMPKIN,1)
				}));
		// ポテトサラダ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_potatosalada,1),
				new ItemStack[]{
						new ItemStack(Items.POTATO,3),
						new ItemStack(Items.CARROT,1),
						new ItemStack(Items.COOKED_PORKCHOP,1),
						},
				new ItemStack[]{
						ItemStack.EMPTY
				}));
		// カボチャサラダ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_pumpkinsalada,1),
				new ItemStack[]{
						new ItemStack(Blocks.PUMPKIN,1),
						new ItemStack(Items.CARROT,1),
						new ItemStack(Items.COOKED_PORKCHOP,1),
						},
				new ItemStack[]{
						ItemStack.EMPTY
				}));
		// たまごサンド
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_eggsandwich,3),
				new ItemStack[]{
						new ItemStack(Items.BREAD,2),
						new ItemStack(ItemFoods.item_butter,1),
						},
				new ItemStack[]{
						new ItemStack(Items.EGG,1),
				}));
		// ポテトサラダサンド
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_potatsaladasandwitch,3),
				new ItemStack[]{
						new ItemStack(Items.BREAD,2),
						new ItemStack(ItemFoods.item_butter,1),
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_potatosalada,1),
				}));
		// ハムサンド
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_hamsandwich,3),
				new ItemStack[]{
						new ItemStack(Items.BREAD,2),
						new ItemStack(ItemFoods.item_butter,1),
						},
				new ItemStack[]{
						new ItemStack(Items.COOKED_PORKCHOP,1),
				}));
		// ジンギスカンサンド
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_muttonsandwich,3),
				new ItemStack[]{
						new ItemStack(Items.BREAD,2),
						new ItemStack(ItemFoods.item_butter,1),
						},
				new ItemStack[]{
						new ItemStack(Items.COOKED_MUTTON,1),
				}));
		// ステーキサンド
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_stakesandwich,3),
				new ItemStack[]{
						new ItemStack(Items.BREAD,2),
						new ItemStack(ItemFoods.item_butter,1),
						},
				new ItemStack[]{
						new ItemStack(Items.COOKED_BEEF,1),
				}));
		// 照り焼きサンド
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_chikensandwich,3),
				new ItemStack[]{
						new ItemStack(Items.BREAD,2),
						new ItemStack(ItemFoods.item_butter,1),
						},
				new ItemStack[]{
						new ItemStack(Items.COOKED_CHICKEN,1),
				}));
		// チョコサンド
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_chocosandwich,3),
				new ItemStack[]{
						new ItemStack(Items.BREAD,2),
						new ItemStack(ItemFoods.item_butter,1),
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_choco,1),
				}));
		// カボチャサンド
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_pumpkinsaladasandwich,3),
				new ItemStack[]{
						new ItemStack(Items.BREAD,2),
						new ItemStack(ItemFoods.item_butter,1),
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_pumpkinsalada,1),
				}));
		// バター
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_butter,3),
				new ItemStack[]{
						new ItemStack(Items.MILK_BUCKET,1),
						new ItemStack(ItemFoods.item_salt,1),
						},
				new ItemStack[]{
						ItemStack.EMPTY
				}));
		// 白カビ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_mold,4),
				new ItemStack[]{
						new ItemStack(Items.ROTTEN_FLESH,1)
						},
				new ItemStack[]{
						new ItemStack(Items.DYE,1,EnumDyeColor.WHITE.getDyeDamage())
				}));

		// アオカビ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_bluemold,4),
				new ItemStack[]{
						new ItemStack(Items.ROTTEN_FLESH,1)
						},
				new ItemStack[]{
						new ItemStack(Items.DYE,1,EnumDyeColor.BLUE.getDyeDamage())
				}));

		// うどん
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_udon,4),
				new ItemStack[]{
						new ItemStack(Items.WATER_BUCKET,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(ItemFoods.item_salt,1)
						},
				new ItemStack[]{
						ItemStack.EMPTY
				}));

		// パスタ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_pasta,4),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(ItemFoods.item_salt,1)
						},
				new ItemStack[]{
						ItemStack.EMPTY
				}));
		// ラーメン
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_ramen,4),
				new ItemStack[]{
						new ItemStack(Items.WATER_BUCKET,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(ItemFoods.item_salt,1)
						},
				new ItemStack[]{
						new ItemStack(Items.EGG,1)
				}));
		// ミートパスタ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_meetpasta,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_pasta,1),
						new ItemStack(Items.BOWL,1)
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_millbeef,1),
						new ItemStack(ItemFoods.item_millpoke,1),
						new ItemStack(ItemFoods.item_millmutton,1),
						new ItemStack(ItemFoods.item_millchikin,1)
				}));
		// フィッシュパスタ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_fishpasta,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_pasta,1),
						new ItemStack(Items.BOWL,1)
						},
				new ItemStack[]{
						new ItemStack(Items.FISH,1, FishType.CLOWNFISH.getMetadata()),
						new ItemStack(Items.FISH,1, FishType.COD.getMetadata()),
						new ItemStack(Items.FISH,1, FishType.SALMON.getMetadata()),
						new ItemStack(Items.FISH,1, FishType.PUFFERFISH.getMetadata())
				}));
		// イカ墨パスタ
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_blackpasta,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_pasta,1),
						new ItemStack(Items.BOWL,1)
						},
				new ItemStack[]{
						new ItemStack(Items.DYE,1,EnumDyeColor.BLACK.getDyeDamage())
				}));
		// ざるうどん
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_zaruudon,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_udon,1),
						new ItemStack(Items.BOWL,1)
						},
				new ItemStack[]{
						ItemStack.EMPTY
				}));
		// かけうどん
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_kakeudon,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_udon,1),
						new ItemStack(Items.BOWL,1),
						new ItemStack(Items.WATER_BUCKET,1)
						},
				new ItemStack[]{
						ItemStack.EMPTY
				}));
		// 月見うどん
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_tsukimiuudon,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_udon,1),
						new ItemStack(Items.BOWL,1),
						new ItemStack(Items.WATER_BUCKET,1)
						},
				new ItemStack[]{
						new ItemStack(Items.EGG,1)
				}));
		// 肉うどん
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_nikuudon,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_udon,1),
						new ItemStack(Items.BOWL,1),
						new ItemStack(Items.WATER_BUCKET,1)
						},
				new ItemStack[]{
						new ItemStack(Items.BEEF,1),
						new ItemStack(Items.PORKCHOP,1),
						new ItemStack(Items.MUSHROOM_STEW,1),
						new ItemStack(Items.CHEST_MINECART,1),
						new ItemStack(ItemFoods.item_millbeef,1),
						new ItemStack(ItemFoods.item_millpoke,1),
						new ItemStack(ItemFoods.item_millmutton,1),
						new ItemStack(ItemFoods.item_millchikin,1)
				}));
		// チャーシュー麺
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_meetramen,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_ramen,1),
						new ItemStack(Items.BOWL,1),
						new ItemStack(Items.WATER_BUCKET,1)
						},
				new ItemStack[]{
						new ItemStack(Items.BEEF,1),
						new ItemStack(Items.PORKCHOP,1),
						new ItemStack(Items.MUSHROOM_STEW,1),
						new ItemStack(Items.CHEST_MINECART,1),
						new ItemStack(ItemFoods.item_millbeef,1),
						new ItemStack(ItemFoods.item_millpoke,1),
						new ItemStack(ItemFoods.item_millmutton,1),
						new ItemStack(ItemFoods.item_millchikin,1)
				}));
		// 魚介ラーメン
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_fishramen,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_ramen,1),
						new ItemStack(Items.BOWL,1),
						new ItemStack(Items.WATER_BUCKET,1)
						},
				new ItemStack[]{
						new ItemStack(Items.FISH,1, FishType.CLOWNFISH.getMetadata()),
						new ItemStack(Items.FISH,1, FishType.COD.getMetadata()),
						new ItemStack(Items.FISH,1, FishType.SALMON.getMetadata()),
						new ItemStack(Items.FISH,1, FishType.PUFFERFISH.getMetadata())
				}));
		// 月見ラーメン
		menus.add(new CookingMenu(new ItemStack(ItemFoods.item_tsukimiramen,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_ramen,1),
						new ItemStack(Items.BOWL,1),
						new ItemStack(Items.WATER_BUCKET,1)
						},
				new ItemStack[]{
						new ItemStack(Items.EGG,1)
				}));


		// お茶
		for (int i = 0; i < EnumFlowerHalb.values.length; i++){
			menus.add(new CookingMenu(new ItemStack(ItemFoods.item_teaflower,1,EnumFlowerHalb.getValue(i).getDamage()),
					new ItemStack[]{
							PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM,1,0), PotionType.getPotionTypeForName("water")),
							},
					new ItemStack[]{
							new ItemStack(ItemFoods.item_dustflower,1,EnumFlowerHalb.getValue(i).getDamage())
					}));
		}
		return menus;
	}
}
