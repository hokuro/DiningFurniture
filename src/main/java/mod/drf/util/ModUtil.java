package mod.drf.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mod.drf.core.ModCommon;
import net.minecraft.item.ItemStack;

public class ModUtil {
	private static final Map<String,Integer> debugCounterIndex = ModCommon.isDebug?new HashMap<String,Integer>():null;
	private static final List<Integer> debugCounter = ModCommon.isDebug?new ArrayList():null;

	public static enum CompaierLevel{
		LEVEL_EQUAL_ITEM,
		LEVEL_EQUAL_COUNT,
		LEVEL_EQUAL_ALL
	};

	public static boolean compareItemStacks(ItemStack stack1, ItemStack stack2 ){
		if (stack1 == null){return false;}
		if (stack2 == null){return false;}
		if (stack1.isEmpty()){return false;}
		if (stack2.isEmpty()){return false;}
		return (stack2.getItem() == stack1.getItem());
	}

	public static boolean compareItemStacks(ItemStack stack1, ItemStack stack2, CompaierLevel level){
		if (stack1 == null){return false;}
		if (stack2 == null){return false;}
		if (stack1.isEmpty()){return false;}
		if (stack2.isEmpty()){return false;}

		boolean ret = false;
		switch(level){
		case LEVEL_EQUAL_ALL:
			ret = ((stack1.getItem() == stack2.getItem()) &&
					stack1.getCount() == stack2.getCount());
			break;
		case LEVEL_EQUAL_COUNT:
			ret = ((stack1.getItem() == stack2.getItem()) &&
					stack1.getCount() == stack2.getCount());
			break;
		case LEVEL_EQUAL_ITEM:
			ret = ((stack1.getItem() == stack2.getItem()));
			break;
		default:
			break;
		}

		return ret;
	}


	public static boolean containItemStack(ItemStack checkItem, ItemStack[] itemArray, CompaierLevel level) {
		boolean ret = false;
		for (ItemStack item: itemArray){
			if (compareItemStacks(checkItem, item,level)){
				ret = true;
				break;
			}
		}
		return ret;
	}

	public static boolean CheckCounter(String key, int limit){
		return CheckCounter(key,limit,false);
	}

	public static boolean CheckCounter(String key, int limit, boolean isNext){
		int count;
		if (isNext){
			count = getNextDebugCounter(key);
		}else{
			count = getDebugCounter(key);
		}
		if ((count%limit)==0){
			return true;
		}
		return false;
	}

	public static int getNextDebugCounter(String key){
		int ret = 0;
		if (debugCounterIndex.containsKey(key)){
			int idx = debugCounterIndex.get(key);
			debugCounter.set(idx, debugCounter.get(idx)+1);
			ret = debugCounter.get(idx);
		}else{
			debugCounterIndex.put(key,debugCounter.size());
			debugCounter.add(0);
		}
		return ret;
	}

	public static int getDebugCounter(String key){
		int ret = 0;
		if (debugCounterIndex.containsKey(key)){
			ret = debugCounter.get(debugCounterIndex.get(key));
		}else{
			debugCounterIndex.put(key,debugCounter.size());
			debugCounter.add(0);
		}
		return ret;
	}

	public static void clearDebugCounter(String key){
		if (debugCounterIndex.containsKey(key)){
			debugCounter.set(debugCounterIndex.get(key), 0);
		}
	}

	public static void clearDebugCounter(String key, int start){
		if (debugCounterIndex.containsKey(key)){
			debugCounter.set(debugCounterIndex.get(key), start);
		}
	}

	public static int BooleanToInteger(boolean value){
		return value?1:0;
	}

	public static boolean IntegerToBoolean(int value){
		return value==0?false:true;
	}

}
