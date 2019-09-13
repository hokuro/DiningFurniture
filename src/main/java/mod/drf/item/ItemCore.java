package mod.drf.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mod.drf.core.Mod_DiningFurniture;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;

public class ItemCore {

	public static final String NAME_ZABUTON_WHITE = "zabuton_white";
	public static final String NAME_ZABUTON_ORANGE = "zabuton_orange";
	public static final String NAME_ZABUTON_MAGENTA = "zabuton_magenta";
	public static final String NAME_ZABUTON_LIGHT_BLUE = "zabuton_light_blue";
	public static final String NAME_ZABUTON_YELLOW = "zabuton_yellow";
	public static final String NAME_ZABUTON_LIME = "zabuton_lime";
	public static final String NAME_ZABUTON_PINK = "zabuton_pink";
	public static final String NAME_ZABUTON_GRAY = "zabuton_gray";
	public static final String NAME_ZABUTON_SILVER = "zabuton_silver";
	public static final String NAME_ZABUTON_CYAN = "zabuton_cyan";
	public static final String NAME_ZABUTON_PURPLE = "zabuton_purple";
	public static final String NAME_ZABUTON_BLUE = "zabuton_blue";
	public static final String NAME_ZABUTON_BROWN = "zabuton_brown";
	public static final String NAME_ZABUTON_GREEN = "zabuton_green";
	public static final String NAME_ZABUTON_RED = "zabuton_red";
	public static final String NAME_ZABUTON_BLACK = "zabuton_black";

	public static final String NAME_CHAIR_OAK = "woodchair_oak";
	public static final String NAME_CHAIR_SPRUCE = "woodchair_spruce";
	public static final String NAME_CHAIR_BIRCH = "woodchair_birch";
	public static final String NAME_CHAIR_JUNGLE = "woodchair_jungle";
	public static final String NAME_CHAIR_ACACIA = "woodchair_acacia";
	public static final String NAME_CHAIR_DARK_OAK = "woodchair_darkoak";


	public static final List<String> NAME_LIST = new ArrayList<String>(){
		{add(NAME_ZABUTON_WHITE);}
		{add(NAME_ZABUTON_ORANGE);}
		{add(NAME_ZABUTON_MAGENTA);}
		{add(NAME_ZABUTON_LIGHT_BLUE);}
		{add(NAME_ZABUTON_YELLOW);}
		{add(NAME_ZABUTON_LIME);}
		{add(NAME_ZABUTON_PINK);}
		{add(NAME_ZABUTON_GRAY);}
		{add(NAME_ZABUTON_SILVER);}
		{add(NAME_ZABUTON_CYAN);}
		{add(NAME_ZABUTON_PURPLE);}
		{add(NAME_ZABUTON_BLUE);}
		{add(NAME_ZABUTON_BROWN);}
		{add(NAME_ZABUTON_GREEN);}
		{add(NAME_ZABUTON_RED);}
		{add(NAME_ZABUTON_BLACK);}
		{add(NAME_CHAIR_OAK);}
		{add(NAME_CHAIR_SPRUCE);}
		{add(NAME_CHAIR_BIRCH);}
		{add(NAME_CHAIR_JUNGLE);}
		{add(NAME_CHAIR_ACACIA);}
		{add(NAME_CHAIR_DARK_OAK);}
	};

	public static Item item_zabuton_white = new ItemZabuton(NAME_ZABUTON_WHITE, DyeColor.WHITE, new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_ZABUTON_WHITE);
	public static Item item_zabuton_orange = new ItemZabuton(NAME_ZABUTON_ORANGE,DyeColor.ORANGE,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_ZABUTON_ORANGE);
	public static Item item_zabuton_magenta = new ItemZabuton(NAME_ZABUTON_MAGENTA,DyeColor.MAGENTA,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_ZABUTON_MAGENTA);
	public static Item item_zabuton_light_blue = new ItemZabuton(NAME_ZABUTON_LIGHT_BLUE,DyeColor.LIGHT_BLUE,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_ZABUTON_LIGHT_BLUE);
	public static Item item_zabuton_yellow = new ItemZabuton(NAME_ZABUTON_YELLOW,DyeColor.YELLOW,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_ZABUTON_YELLOW);
	public static Item item_zabuton_lime = new ItemZabuton(NAME_ZABUTON_LIME,DyeColor.LIME,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_ZABUTON_LIME);
	public static Item item_zabuton_pink = new ItemZabuton(NAME_ZABUTON_PINK,DyeColor.PINK,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_ZABUTON_PINK);
	public static Item item_zabuton_gray = new ItemZabuton(NAME_ZABUTON_GRAY,DyeColor.GRAY,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_ZABUTON_GRAY);
	public static Item item_zabuton_silver = new ItemZabuton(NAME_ZABUTON_SILVER,DyeColor.LIGHT_GRAY,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_ZABUTON_SILVER);
	public static Item item_zabuton_cyan = new ItemZabuton(NAME_ZABUTON_CYAN,DyeColor.CYAN,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_ZABUTON_CYAN);
	public static Item item_zabuton_purple = new ItemZabuton(NAME_ZABUTON_PURPLE,DyeColor.PURPLE,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_ZABUTON_PURPLE);
	public static Item item_zabuton_blue = new ItemZabuton(NAME_ZABUTON_BLUE,DyeColor.BLUE,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_ZABUTON_BLUE);
	public static Item item_zabuton_brown = new ItemZabuton(NAME_ZABUTON_BROWN,DyeColor.BROWN,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_ZABUTON_BROWN);
	public static Item item_zabuton_green = new ItemZabuton(NAME_ZABUTON_GREEN,DyeColor.GREEN,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_ZABUTON_GREEN);
	public static Item item_zabuton_red = new ItemZabuton(NAME_ZABUTON_RED,DyeColor.RED,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_ZABUTON_RED);
	public static Item item_zabuton_black = new ItemZabuton(NAME_ZABUTON_BLACK,DyeColor.BLACK,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_ZABUTON_BLACK);

	public static Item item_chair_oak = new ItemWoodChair(NAME_CHAIR_OAK,EnumWoodType.OAK_WOOD,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_CHAIR_OAK);
	public static Item item_chair_spruce = new ItemWoodChair(NAME_CHAIR_SPRUCE,EnumWoodType.SPRUCE_WOOD,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_CHAIR_SPRUCE);
	public static Item item_chair_birch = new ItemWoodChair(NAME_CHAIR_BIRCH,EnumWoodType.BIRCH_WOOD,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_CHAIR_BIRCH);
	public static Item item_chair_jungle = new ItemWoodChair(NAME_CHAIR_JUNGLE,EnumWoodType.JUNGLE_WOOD,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_CHAIR_JUNGLE);
	public static Item item_chair_acacia = new ItemWoodChair(NAME_CHAIR_ACACIA,EnumWoodType.ACACIA_WOOD,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_CHAIR_ACACIA);
	public static Item item_chair_dark_oak = new ItemWoodChair(NAME_CHAIR_DARK_OAK,EnumWoodType.DARK_OAK_WOOD,new Item.Properties().group(Mod_DiningFurniture.tabFurniture).maxStackSize(16)).setRegistryName(NAME_CHAIR_DARK_OAK);

	public static Map<String,Item> itemMap;
	public static void init(){
		itemMap = new HashMap<String,Item>();
		itemMap.put(NAME_ZABUTON_WHITE,item_zabuton_white);
		itemMap.put(NAME_ZABUTON_ORANGE,item_zabuton_orange);
		itemMap.put(NAME_ZABUTON_MAGENTA,item_zabuton_magenta);
		itemMap.put(NAME_ZABUTON_LIGHT_BLUE,item_zabuton_light_blue);
		itemMap.put(NAME_ZABUTON_YELLOW,item_zabuton_yellow);
		itemMap.put(NAME_ZABUTON_LIME,item_zabuton_lime);
		itemMap.put(NAME_ZABUTON_PINK,item_zabuton_pink);
		itemMap.put(NAME_ZABUTON_GRAY,item_zabuton_gray);
		itemMap.put(NAME_ZABUTON_SILVER,item_zabuton_silver);
		itemMap.put(NAME_ZABUTON_CYAN,item_zabuton_cyan);
		itemMap.put(NAME_ZABUTON_PURPLE,item_zabuton_purple);
		itemMap.put(NAME_ZABUTON_BLUE,item_zabuton_blue);
		itemMap.put(NAME_ZABUTON_BROWN,item_zabuton_brown);
		itemMap.put(NAME_ZABUTON_GREEN,item_zabuton_green);
		itemMap.put(NAME_ZABUTON_RED,item_zabuton_red);
		itemMap.put(NAME_ZABUTON_BLACK,item_zabuton_black);
		itemMap.put(NAME_CHAIR_OAK,item_chair_oak);
		itemMap.put(NAME_CHAIR_SPRUCE,item_chair_spruce);
		itemMap.put(NAME_CHAIR_BIRCH,item_chair_birch);
		itemMap.put(NAME_CHAIR_JUNGLE,item_chair_jungle);
		itemMap.put(NAME_CHAIR_ACACIA,item_chair_acacia);
		itemMap.put(NAME_CHAIR_DARK_OAK,item_chair_dark_oak);

	}

	public static void register(Register<Item> event) {
		for(String key : NAME_LIST) {
			if (itemMap.containsKey(key)) {
				event.getRegistry().register(itemMap.get(key));
			}
		}
	}


	public static enum EnumWoodType{
        OAK_WOOD(0,"oak"),
        SPRUCE_WOOD(1,"spruce"),
        BIRCH_WOOD(2,"birch"),
        JUNGLE_WOOD(3,"jungle"),
        ACACIA_WOOD(4,"acacia"),
        DARK_OAK_WOOD(5,"darkoak");

        private int index;
        private String name;
        public static final EnumWoodType[] VALUES = new EnumWoodType[] {
                OAK_WOOD,
                SPRUCE_WOOD,
                BIRCH_WOOD,
                JUNGLE_WOOD,
                ACACIA_WOOD,
                DARK_OAK_WOOD
        };

        private EnumWoodType(int idx, String na) {
        	index = idx;
        	name = na;
        }

        public int getIndex() {return index;}
        public String getName() {return name;}

		public static EnumWoodType getType(int int1) {
			if (int1 < 0 || int1 >= VALUES.length) {
				int1 = 0;
			}
			return VALUES[int1];
		}
	}
}

