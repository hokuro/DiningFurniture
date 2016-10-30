package mod.drf.config;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigValue {
	private static final ModConfig config = new ModConfig();

	public static class General{
		@ConfigProperty(comment="config.comment.icecaneatallways")
		public static boolean IceCreamCanEatAllways = false;
		@ConfigProperty(comment="config.comment.icecaneatallways")
		public static boolean CrashedIceCanEatAllways = false;

		@ConfigProperty(comment="Maximum farmland 1-5000")
		public static int MaxFarmland = 1000;
		@ConfigProperty(comment="Maximum Distance 1-100")
		public static int MaxDistance = 30;
		@ConfigProperty(comment="right click possible [true/false]")
		public static boolean RightClick = true;
		@ConfigProperty(comment="enable item ids")
		public static String TargetItemIds = "";

	}

	public static void init(FMLPreInitializationEvent event){
		config.init(new Class<?>[]{General.class}, event);
	}
}
