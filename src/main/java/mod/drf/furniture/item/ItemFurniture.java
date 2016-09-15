package mod.drf.furniture.item;

import java.util.HashMap;
import java.util.Map;

import mod.drf.core.ModCommon;
import mod.drf.core.Mod_DiningFurniture;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ItemFurniture {

	private static final String NAME_ZABUTON = "zabuton";
	private static final String NAME_TRUNK = "trunk";

	public static final Item item_zabuton = new ItemChairZabuton();
	public static final Item item_trunk = new ItemTrunk().setUnlocalizedName(NAME_TRUNK).setMaxStackSize(1).setCreativeTab(Mod_DiningFurniture.tabsChairs);

	public static Map<String,Item> itemMap(){
		return (new HashMap<String,Item>(){
			{put(NAME_ZABUTON, item_zabuton);}
			{put(NAME_TRUNK, item_trunk);}
		});
	}

	public static Map<String,ModelResourceLocation[]> resourceMap(){
		return (new HashMap<String,ModelResourceLocation[]>(){
			{put(NAME_ZABUTON,
					new ModelResourceLocation[]{
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemChairZabuton.NAME+"_WHITE", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemChairZabuton.NAME+"_ORANGE", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemChairZabuton.NAME+"_MAGENTA", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemChairZabuton.NAME+"_LIGHT_BLUE", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemChairZabuton.NAME+"_YELLOW", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemChairZabuton.NAME+"_LIME", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemChairZabuton.NAME+"_PINK", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemChairZabuton.NAME+"_GRAY", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemChairZabuton.NAME+"_SILVER", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemChairZabuton.NAME+"_CYAN", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemChairZabuton.NAME+"_PURPLE", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemChairZabuton.NAME+"_BLUE", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemChairZabuton.NAME+"_BROWN", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemChairZabuton.NAME+"_GREEN", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemChairZabuton.NAME+"_RED", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemChairZabuton.NAME+"_BLACK", "inventory")
							});}
			{put(NAME_TRUNK,new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_TRUNK, "inventory")});}
			});
	}
}

