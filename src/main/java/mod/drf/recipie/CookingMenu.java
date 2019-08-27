package mod.drf.recipie;

import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.Item.ItemFoods.EnumFlapeSyrup;
import mod.drf.foods.Item.ItemFoods.EnumIceFlavor;
import mod.drf.foods.block.BlockFoods;
import mod.drf.util.ModUtil;
import mod.drf.util.ModUtil.CompaierLevel;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
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
				if (ModUtil.compareItemStacks(ings[OriginalMenuKind.COOKING.getLength()-1], item, CompaierLevel.LEVEL_EQUAL_ITEM)&&
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
    public void makeMenu(){
		// パイ
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_row_hallpie,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,1),
						new ItemStack(Items.EGG,1)
				}));
		// チョコパイ
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_row_chocohallpie,1),
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
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_row_saladahallpie,1),
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
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_row_meethallpie,1),
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
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_row_fishhallpie,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,1),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(Items.COD,1),
						new ItemStack(Items.TROPICAL_FISH,1),
						new ItemStack(Items.PUFFERFISH,1),
						new ItemStack(Items.SALMON,1),
				}));
		// かぼちゃパイ
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_row_pumpkinhallpie,1),
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
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_row_applehallpie,1),
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
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_row_blackpie,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,1),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(Items.INK_SAC,1)
				}));
		// 腐ったパイ
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_row_zombihallpie,1),
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
		registerMenu(new CookingMenu(new ItemStack(BlockFoods.block_caramelpie_hall,1),
				new ItemStack[]{
						new ItemStack(BlockFoods.block_pie_hall,1)
				},
				new ItemStack[]{new ItemStack(ItemFoods.item_caramel,1)}));

		// チョコケーキ
		registerMenu(new CookingMenu(new ItemStack(BlockFoods.block_choco_cake,1),
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
		registerMenu(new CookingMenu(new ItemStack(BlockFoods.block_apple_cake,1),
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
		registerMenu(new CookingMenu(new ItemStack(BlockFoods.block_salada_cake,1),
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
		registerMenu(new CookingMenu(new ItemStack(BlockFoods.block_mellon_cake,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,2),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(Items.MELON_SLICE,1)
				}));

		// パンプキンケーキ
		registerMenu(new CookingMenu(new ItemStack(BlockFoods.block_pumpkin_cake,1),
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
		registerMenu(new CookingMenu(new ItemStack(BlockFoods.block_reacheese_cake,1),
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
		registerMenu(new CookingMenu(new ItemStack(BlockFoods.block_black_cake,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_butter,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(Items.SUGAR,2),
						new ItemStack(Items.EGG,1)
				},
				new ItemStack[]{
						new ItemStack(Items.INK_SAC,1)
				}));

		// 腐ったケーキ
		registerMenu(new CookingMenu(new ItemStack(BlockFoods.block_zombi_cake,1),
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
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_row_pizza,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(BlockFoods.block_cheese,1)
				},
				new ItemStack[]{
						ItemStack.EMPTY
				}));

		// 肉ピザ
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_row_meetpizza,1),
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
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_row_fishpizza,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(BlockFoods.block_cheese,1)
				},
				new ItemStack[]{
						new ItemStack(Items.COD,1),
						new ItemStack(Items.TROPICAL_FISH,1),
						new ItemStack(Items.PUFFERFISH,1),
						new ItemStack(Items.SALMON,1),
				}));

		// チーズ
		registerMenu(new CookingMenu(new ItemStack(BlockFoods.block_cheese,1),
				new ItemStack[]{
						new ItemStack(Items.MILK_BUCKET,1),
						new ItemStack(ItemFoods.item_rennet,1)
				},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_mold,1)
				}));

		// ブルーチーズ
		registerMenu(new CookingMenu(new ItemStack(BlockFoods.block_bluecheese,1),
				new ItemStack[]{
						new ItemStack(Items.MILK_BUCKET,1),
						new ItemStack(ItemFoods.item_rennet,1)
				},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_bluemold,1)
				}));




		// アイスクリームの素
		for (int i = 0; i < EnumIceFlavor.values.length; i++){
			registerMenu(new CookingMenu(new ItemStack(ItemFoods.icemixList[i],1),
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
			registerMenu(new CookingMenu(new ItemStack(ItemFoods.syrupList[i-1],1),
					new ItemStack[]{
							PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION,1), PotionType.getPotionTypeForName("water")),
							new ItemStack(Items.SUGAR,2)
					},
					EnumFlapeSyrup.getValue(i).getBaseItem()
					));
		}

		// シロップかけかき氷
		for (int i = 1; i < EnumFlapeSyrup.values.length; i++){
			registerMenu(new CookingMenu(new ItemStack(ItemFoods.flapelist[i],1),
					new ItemStack[]{
							new ItemStack(ItemFoods.item_crashedice_none,1),
							new ItemStack(ItemFoods.syrupList[i-1],1)
					}
					));
		}
		// 練乳掛けかき氷
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_crashedice_milk_none,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_crashedice_none,1),
						new ItemStack(ItemFoods.item_syrupmilk,1)
				}));

		// 練乳シロップかき氷(シロップ→練乳)
		for (int i = 0; i < EnumFlapeSyrup.values.length; i++){
			registerMenu(new CookingMenu(new ItemStack(ItemFoods.mkflapelist[i],1),
					new ItemStack[]{
							new ItemStack(ItemFoods.flapelist[i],1),
							new ItemStack(ItemFoods.item_syrupmilk,1)
					}
					));
		}


		// 練乳シロップかき氷(練乳→シロップ)
		for (int i = 1; i < EnumFlapeSyrup.values.length; i++){
			registerMenu(new CookingMenu(new ItemStack(ItemFoods.mkflapelist[i],1),
					new ItemStack[]{
							new ItemStack(ItemFoods.item_crashedice_milk_none,1),
							new ItemStack(ItemFoods.syrupList[i-1],1)
					}
					));
		}


		// 練乳シロップかき氷(練乳かき氷+シロップ)
		for (int i = 1; i < EnumFlapeSyrup.values.length; i++){
			registerMenu(new CookingMenu(new ItemStack(ItemFoods.mkflapelist[i],1),
					new ItemStack[]{
							new ItemStack(ItemFoods.item_crashedice_none,1),
							new ItemStack(ItemFoods.item_syrupmilk,1),
							new ItemStack(ItemFoods.syrupList[i-1],1)
					}
					));
		}



		// アイスキャンディの素
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.sugarwaterList[0],1),
				new ItemStack[]{
						PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION,1), PotionType.getPotionTypeForName("water")),
						new ItemStack(Items.STICK,1)
				},
				EnumFlapeSyrup.getValue(0).getBaseItem()
				));
		for (int i = 1; i < EnumFlapeSyrup.values.length; i++){
			registerMenu(new CookingMenu(new ItemStack(ItemFoods.sugarwaterList[i],1),
					new ItemStack[]{
							PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION,1), PotionType.getPotionTypeForName("water")),
							new ItemStack(Items.SUGAR,2),
							new ItemStack(Items.STICK,1)
					},
					EnumFlapeSyrup.getValue(i).getBaseItem()
					));
		}

		// チョコ
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_choco,1),
				new ItemStack[]{
						new ItemStack(Items.COCOA_BEANS,3),
						new ItemStack(Items.SUGAR,1)
						},
				new ItemStack[]{
						ItemStack.EMPTY
				}));
		// ホワイトチョコ
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_whitechoco,1),
				new ItemStack[]{
						new ItemStack(Items.COCOA_BEANS,3),
						new ItemStack(Items.SUGAR,1)
						},
				new ItemStack[]{
						new ItemStack(Items.MILK_BUCKET,1)
				}));
		// プリン
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_pudding,4),
				new ItemStack[]{
						new ItemStack(Items.EGG,3),
						new ItemStack(Items.SUGAR,2),
						new ItemStack(Items.MILK_BUCKET,1),
						},
				new ItemStack[]{
						ItemStack.EMPTY
				}));
		// かぼちゃプリン
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_pumpkinpudding,4),
				new ItemStack[]{
						new ItemStack(Items.EGG,3),
						new ItemStack(Items.SUGAR,2),
						new ItemStack(Items.MILK_BUCKET,1),
						},
				new ItemStack[]{
						new ItemStack(Blocks.PUMPKIN,1)
				}));
		// ポテトサラダ
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_potatosalada,1),
				new ItemStack[]{
						new ItemStack(Items.POTATO,3),
						new ItemStack(Items.CARROT,1),
						new ItemStack(Items.COOKED_PORKCHOP,1),
						},
				new ItemStack[]{
						ItemStack.EMPTY
				}));
		// カボチャサラダ
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_pumpkinsalada,1),
				new ItemStack[]{
						new ItemStack(Blocks.PUMPKIN,1),
						new ItemStack(Items.CARROT,1),
						new ItemStack(Items.COOKED_PORKCHOP,1),
						},
				new ItemStack[]{
						ItemStack.EMPTY
				}));
		// たまごサンド
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_eggsandwich,3),
				new ItemStack[]{
						new ItemStack(Items.BREAD,2),
						new ItemStack(ItemFoods.item_butter,1),
						},
				new ItemStack[]{
						new ItemStack(Items.EGG,1),
				}));
		// ポテトサラダサンド
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_potatsaladasandwitch,3),
				new ItemStack[]{
						new ItemStack(Items.BREAD,2),
						new ItemStack(ItemFoods.item_butter,1),
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_potatosalada,1),
				}));
		// ハムサンド
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_hamsandwich,3),
				new ItemStack[]{
						new ItemStack(Items.BREAD,2),
						new ItemStack(ItemFoods.item_butter,1),
						},
				new ItemStack[]{
						new ItemStack(Items.COOKED_PORKCHOP,1),
				}));
		// ジンギスカンサンド
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_muttonsandwich,3),
				new ItemStack[]{
						new ItemStack(Items.BREAD,2),
						new ItemStack(ItemFoods.item_butter,1),
						},
				new ItemStack[]{
						new ItemStack(Items.COOKED_MUTTON,1),
				}));
		// ステーキサンド
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_stakesandwich,3),
				new ItemStack[]{
						new ItemStack(Items.BREAD,2),
						new ItemStack(ItemFoods.item_butter,1),
						},
				new ItemStack[]{
						new ItemStack(Items.COOKED_BEEF,1),
				}));
		// 照り焼きサンド
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_chikensandwich,3),
				new ItemStack[]{
						new ItemStack(Items.BREAD,2),
						new ItemStack(ItemFoods.item_butter,1),
						},
				new ItemStack[]{
						new ItemStack(Items.COOKED_CHICKEN,1),
				}));
		// チョコサンド
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_chocosandwich,3),
				new ItemStack[]{
						new ItemStack(Items.BREAD,2),
						new ItemStack(ItemFoods.item_butter,1),
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_choco,1),
				}));
		// カボチャサンド
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_pumpkinsaladasandwich,3),
				new ItemStack[]{
						new ItemStack(Items.BREAD,2),
						new ItemStack(ItemFoods.item_butter,1),
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_pumpkinsalada,1),
				}));
		// バター
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_butter,3),
				new ItemStack[]{
						new ItemStack(Items.MILK_BUCKET,1),
						new ItemStack(ItemFoods.item_salt,1),
						},
				new ItemStack[]{
						ItemStack.EMPTY
				}));
		// 白カビ
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_mold,4),
				new ItemStack[]{
						new ItemStack(Items.ROTTEN_FLESH,1)
						},
				new ItemStack[]{
						new ItemStack(Items.BONE_MEAL,1)
				}));

		// アオカビ
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_bluemold,4),
				new ItemStack[]{
						new ItemStack(Items.ROTTEN_FLESH,1)
						},
				new ItemStack[]{
						new ItemStack(Items.LAPIS_LAZULI,1)
				}));

		// うどん
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_udon,4),
				new ItemStack[]{
						new ItemStack(Items.WATER_BUCKET,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(ItemFoods.item_salt,1)
						},
				new ItemStack[]{
						ItemStack.EMPTY
				}));

		// パスタ
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_pasta,4),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(ItemFoods.item_salt,1)
						},
				new ItemStack[]{
						ItemStack.EMPTY
				}));
		// ラーメン
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_ramen,4),
				new ItemStack[]{
						new ItemStack(Items.WATER_BUCKET,1),
						new ItemStack(ItemFoods.item_flour,3),
						new ItemStack(ItemFoods.item_salt,1)
						},
				new ItemStack[]{
						new ItemStack(Items.EGG,1)
				}));
		// ミートパスタ
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_meetpasta,1),
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
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_fishpasta,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_pasta,1),
						new ItemStack(Items.BOWL,1)
						},
				new ItemStack[]{
						new ItemStack(Items.COD,1),
						new ItemStack(Items.TROPICAL_FISH,1),
						new ItemStack(Items.PUFFERFISH,1),
						new ItemStack(Items.SALMON,1),
				}));
		// イカ墨パスタ
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_blackpasta,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_pasta,1),
						new ItemStack(Items.BOWL,1)
						},
				new ItemStack[]{
						new ItemStack(Items.INK_SAC,1)
				}));
		// ざるうどん
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_zaruudon,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_udon,1),
						new ItemStack(Items.BOWL,1)
						},
				new ItemStack[]{
						ItemStack.EMPTY
				}));
		// かけうどん
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_kakeudon,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_udon,1),
						new ItemStack(Items.BOWL,1),
						new ItemStack(Items.WATER_BUCKET,1)
						},
				new ItemStack[]{
						ItemStack.EMPTY
				}));
		// 月見うどん
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_tsukimiuudon,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_udon,1),
						new ItemStack(Items.BOWL,1),
						new ItemStack(Items.WATER_BUCKET,1)
						},
				new ItemStack[]{
						new ItemStack(Items.EGG,1)
				}));
		// 肉うどん
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_nikuudon,1),
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
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_meetramen,1),
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
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_fishramen,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_ramen,1),
						new ItemStack(Items.BOWL,1),
						new ItemStack(Items.WATER_BUCKET,1)
						},
				new ItemStack[]{
						new ItemStack(Items.COD,1),
						new ItemStack(Items.TROPICAL_FISH,1),
						new ItemStack(Items.PUFFERFISH,1),
						new ItemStack(Items.SALMON,1),
				}));
		// 月見ラーメン
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_tsukimiramen,1),
				new ItemStack[]{
						new ItemStack(ItemFoods.item_ramen,1),
						new ItemStack(Items.BOWL,1),
						new ItemStack(Items.WATER_BUCKET,1)
						},
				new ItemStack[]{
						new ItemStack(Items.EGG,1)
				}));


		// お茶
		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_flowertea_dandelion,1),
				new ItemStack[]{
						PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION,1), PotionType.getPotionTypeForName("water")),
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flowerdust_dandelion,1)
				}));

		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_flowertea_popy,1),
				new ItemStack[]{
						PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION,1), PotionType.getPotionTypeForName("water")),
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flowerdust_popy,1)
				}));

		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_flowertea_orchid,1),
				new ItemStack[]{
						PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION,1), PotionType.getPotionTypeForName("water")),
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flowerdust_orchid,1)
				}));

		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_flowertea_allium,1),
				new ItemStack[]{
						PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION,1), PotionType.getPotionTypeForName("water")),
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flowerdust_allium,1)
				}));

		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_flowertea_azurebluet,1),
				new ItemStack[]{
						PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION,1), PotionType.getPotionTypeForName("water")),
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flowerdust_azurebluet,1)
				}));

		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_flowertea_tulip,1),
				new ItemStack[]{
						PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION,1), PotionType.getPotionTypeForName("water")),
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flowerdust_tulip,1)
				}));

		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_flowertea_oxeydaisy,1),
				new ItemStack[]{
						PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION,1), PotionType.getPotionTypeForName("water")),
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flowerdust_oxeydaisy,1)
				}));

		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_flowertea_sunflower,1),
				new ItemStack[]{
						PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION,1), PotionType.getPotionTypeForName("water")),
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flowerdust_sunflower,1)
				}));

		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_flowertea_lilac,1),
				new ItemStack[]{
						PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION,1), PotionType.getPotionTypeForName("water")),
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flowerdust_lilac,1)
				}));

		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_flowertea_rose,1),
				new ItemStack[]{
						PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION,1), PotionType.getPotionTypeForName("water")),
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flowerdust_rose,1)
				}));

		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_flowertea_peony,1),
				new ItemStack[]{
						PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION,1), PotionType.getPotionTypeForName("water")),
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flowerdust_peony,1)
				}));

		registerMenu(new CookingMenu(new ItemStack(ItemFoods.item_flowertea_panacea,1),
				new ItemStack[]{
						PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION,1), PotionType.getPotionTypeForName("water")),
						},
				new ItemStack[]{
						new ItemStack(ItemFoods.item_flowerdust_panacea,1)
				}));
    }
}
