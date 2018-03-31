package mod.drf.furniture.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mod.drf.core.ModCommon;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ItemFurniture {

	public static final String NAME_ZABUTON = "zabuton";
	public static final String NAME_WOODCHAIR ="woodchair";
	private static final String NAME_TRUNK = "trunk";

	public static final List<String> NAME_LIST = new ArrayList<String>(){
		{add(NAME_ZABUTON);}
		{add(NAME_WOODCHAIR);}
	};

	public static Item item_zabuton;
	public static Item item_woodchair;
	public static Item item_trunk;// = new ItemTrunk().setUnlocalizedName(NAME_TRUNK).setMaxStackSize(1).setCreativeTab(Mod_DiningFurniture.tabFurniture);

	public static void init(){
		item_zabuton = new ItemZabuton().setRegistryName(NAME_ZABUTON).setUnlocalizedName(NAME_ZABUTON);
		item_woodchair = new ItemWoodChair().setRegistryName(NAME_WOODCHAIR).setUnlocalizedName(NAME_WOODCHAIR);
	}

	public static Map<String,Item> itemMap(){
		return (new HashMap<String,Item>(){
			{put(NAME_ZABUTON, item_zabuton);}
			{put(NAME_WOODCHAIR, item_woodchair);}
		});
	}

	public static Map<String,ModelResourceLocation[]> resourceMap(){
		return (new HashMap<String,ModelResourceLocation[]>(){
			{put(NAME_ZABUTON,
					new ModelResourceLocation[]{
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemZabuton.NAME+"_WHITE", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemZabuton.NAME+"_ORANGE", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemZabuton.NAME+"_MAGENTA", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemZabuton.NAME+"_LIGHT_BLUE", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemZabuton.NAME+"_YELLOW", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemZabuton.NAME+"_LIME", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemZabuton.NAME+"_PINK", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemZabuton.NAME+"_GRAY", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemZabuton.NAME+"_SILVER", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemZabuton.NAME+"_CYAN", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemZabuton.NAME+"_PURPLE", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemZabuton.NAME+"_BLUE", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemZabuton.NAME+"_BROWN", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemZabuton.NAME+"_GREEN", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemZabuton.NAME+"_RED", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+ItemZabuton.NAME+"_BLACK", "inventory")
							});}
			{put(NAME_WOODCHAIR,
					new ModelResourceLocation[]{
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_WOODCHAIR+"_ork", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_WOODCHAIR+"_birch", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_WOODCHAIR+"_spruce", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_WOODCHAIR+"_jungl", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_WOODCHAIR+"_acacia", "inventory"),
							new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_WOODCHAIR+"_ork2", "inventory")
							});}
			//{put(NAME_TRUNK,new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":"+NAME_TRUNK, "inventory")});}
			});
	}
}

