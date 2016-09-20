package mod.drf.furniture.block;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class BlockFurniture {
	public static Map<String, Block> blockMap(){
		return  (new HashMap<String, Block>());
	}

	public static Map<String,Item> itemMap(){
		return (new HashMap<String, Item>());
	}

	public static Map<String,ResourceLocation[]> resourceMap(){
		return (new HashMap<String,ResourceLocation[]>());
	}
}

