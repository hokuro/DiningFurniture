package mod.drf.furniture.entity;

import java.util.HashMap;
import java.util.Map;

import mod.drf.core.MoreChair;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityCore{
	public static final EntityCore instance = new EntityCore();

	private Map<String, Class<? extends Entity>> entList;

	private EntityCore(){
		entList = new HashMap<String,Class<?extends Entity>>();
		entList.put(EntityChairZabuton.NAME,EntityChairZabuton.class);
	}

	public void registerModEntity(){
		for (String key : entList.keySet()){
			EntityRegistry.registerModEntity(entList.get(key), key, 0, MoreChair.instance, 80, 3, true);
		}
	}
}
