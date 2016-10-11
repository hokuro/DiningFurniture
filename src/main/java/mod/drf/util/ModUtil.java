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

	public static boolean compareItemStacks(ItemStack stack1, ItemStack stack2){
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
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
}
