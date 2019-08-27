package mod.drf.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigValue {
	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final Setting_IceCream icecream = new Setting_IceCream(BUILDER);
	public static final Setting_CrashedIce crashedice = new Setting_CrashedIce(BUILDER);
	public static final Setting_Mill mill = new Setting_Mill(BUILDER);
	public static final Setting_PieCake piecake = new Setting_PieCake(BUILDER);
	public static final ForgeConfigSpec spec = BUILDER.build();

	public static class Setting_IceCream{
		public final ForgeConfigSpec.ConfigValue<Boolean> canEatAllways;
		public final ForgeConfigSpec.ConfigValue<Integer> melltingTime;
		public final ForgeConfigSpec.ConfigValue<Boolean> melltingFlag;
		public Setting_IceCream(ForgeConfigSpec.Builder builder){
			builder.push("Setting_IceCream");
			canEatAllways = builder.comment("onfig.comment.icecaneatallways").define("CanEatAllways", true);
			melltingTime = builder.comment("config.comment.melltingtime").define("MelltingTime", 2400);
			melltingFlag = builder.comment("config.comment.melltingflag").define("MelltingFlag", true);
			builder.pop();
		}

		public boolean CanEatAllways(){return this.canEatAllways.get();}
		public int MelltingTime(){return this.melltingTime.get();}
		public boolean MelltingFlag(){return this.melltingFlag.get();}
	}

	public static class Setting_CrashedIce{

		public final ForgeConfigSpec.ConfigValue<Boolean> canEatAllways;
		public final ForgeConfigSpec.ConfigValue<Integer> melltingTime;
		public final ForgeConfigSpec.ConfigValue<Boolean> melltingFlag;
		public final ForgeConfigSpec.ConfigValue<Boolean> soundOn;

		public Setting_CrashedIce(ForgeConfigSpec.Builder builder){
			builder.push("Setting_CrashedIce");
			canEatAllways = builder.comment("onfig.comment.crashediceeatallway").define("CanEatAllways", true);
			melltingTime = builder.comment("config.comment.melltingtime").define("MelltingTime", 2400);
			melltingFlag = builder.comment("config.comment.melltingflag").define("MelltingFlag", true);
			soundOn = builder.comment("onfig.comment.soundon").define("Sound_On", true);
			builder.pop();
		}

		public boolean CanEatAllways(){return this.canEatAllways.get();}
		public int MelltingTime(){return this.melltingTime.get();}
		public boolean MelltingFlag(){return this.melltingFlag.get();}
		public boolean SoundOn(){return this.soundOn.get();}
	}

	public static class Setting_Mill{
		public final ForgeConfigSpec.ConfigValue<Boolean> soundOn;

		public Setting_Mill(ForgeConfigSpec.Builder builder){
			builder.push("Setting_Mill");
			soundOn = builder.comment("onfig.comment.soundon").define("Sound_On", true);
			builder.pop();
		}

		public boolean SoundOn(){return this.soundOn.get();}
	}


	public static class Setting_PieCake{
		public final ForgeConfigSpec.ConfigValue<Boolean> canEatAllways;
		public Setting_PieCake(ForgeConfigSpec.Builder builder){
			builder.push("Setting_IceCream");
			canEatAllways = builder.comment("onfig.comment.icecaneatallways").define("CanEatAllways", true);
			builder.pop();
		}

		public boolean CanEatAllways(){return this.canEatAllways.get();}
	}
}
