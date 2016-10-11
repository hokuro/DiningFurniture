package mod.drf.sounds;

import mod.drf.core.ModCommon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class SoundManager {
	public static String SOUND_MAKEFLAPE = "block.foods.makeflape";

	public static SoundEvent sound_makeflape = new SoundEvent(new ResourceLocation(ModCommon.MOD_ID+":" + SOUND_MAKEFLAPE))
			.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":" + SOUND_MAKEFLAPE));
}
