package mod.drf.sounds;

import mod.drf.core.ModCommon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;

public class SoundManager {
	public static String SOUND_MAKEFLAPE = "block.foods.makeflape";
	public static String SOUND_MILL = "block.foods.millstone";

	public static SoundEvent sound_makeflape = new SoundEvent(new ResourceLocation(ModCommon.MOD_ID+":" + SOUND_MAKEFLAPE))
			.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":" + SOUND_MAKEFLAPE));
	public static SoundEvent sound_mill = new SoundEvent(new ResourceLocation(ModCommon.MOD_ID+":" + SOUND_MILL))
			.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":" + SOUND_MILL));


	public static void RegisterSounds(final RegistryEvent.Register<SoundEvent> event){
		event.getRegistry().register(sound_makeflape);
		event.getRegistry().register(sound_mill);
	}
}
