package mod.drf.config;

import mod.drf.foods.Item.ItemFoods.EnumFlapeSyrup;
import mod.drf.foods.Item.ItemFoods.EnumIceFlavor;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigValue {
	private static final ModConfig config = new ModConfig();

	public static class General{
	}

	public static void init(FMLPreInitializationEvent event){
		config.init(new Class<?>[]{General.class,Setting_IceCream.class,Setting_CrashedIce.class,Setting_Mill.class}, event);
	}



	public static class Setting_IceCream{
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.icecaneatallways")
		public static boolean IceCreamCanEatAllways = false;
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.nameoficeflavor")
		public static String FlavorBlack="";
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.nameoficeflavor")
		public static String FlavorRed="";
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.nameoficeflavor")
		public static String FlavorGreen="";
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.nameoficeflavor")
		public static String FlavorBrown="";
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.nameoficeflavor")
		public static String FlavorBlue="";
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.nameoficeflavor")
		public static String FlavorPurple="";
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.nameoficeflavor")
		public static String FlavorCyan="";
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.nameoficeflavor")
		public static String FlavorSilver="";
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.nameoficeflavor")
		public static String FlavorGray="";
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.nameoficeflavor")
		public static String FlavorPink="";
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.nameoficeflavor")
		public static String FlavorLime="";
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.nameoficeflavor")
		public static String FlavorYellow="";
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.nameoficeflavor")
		public static String FlavorLightBlue="";
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.nameoficeflavor")
		public static String FlavorMagenta="";
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.nameoficeflavor")
		public static String FlavorOrange="";
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.nameoficeflavor")
		public static String FlavorWhite="";
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.melltingtime")
		public static int melltingTime=2400;
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.melltingflag")
		public static boolean melltingFlag = true;

		public static String getFlavorName(EnumIceFlavor flavor){
			String ret = "";
			switch(flavor){
			case ICE_BLACK:
				ret = FlavorBlack;
				break;
			case ICE_BLUE:
				ret = FlavorBlue;
				break;
			case ICE_BROWN:
				ret = FlavorBrown;
				break;
			case ICE_CYAN:
				ret = FlavorCyan;
				break;
			case ICE_GRAY:
				ret = FlavorGray;
				break;
			case ICE_GREEN:
				ret = FlavorGreen;
				break;
			case ICE_LIGHT_BLUE:
				ret = FlavorLightBlue;
				break;
			case ICE_LIME:
				ret = FlavorLime;
				break;
			case ICE_MAGENTA:
				ret = FlavorMagenta;
				break;
			case ICE_ORANGE:
				ret = FlavorOrange;
				break;
			case ICE_PINK:
				ret = FlavorPink;
				break;
			case ICE_PURPLE:
				ret = FlavorPurple;
				break;
			case ICE_RED:
				ret = FlavorRed;
				break;
			case ICE_SILVER:
				ret = FlavorSilver;
				break;
			case ICE_WHITE:
				ret = FlavorWhite;
				break;
			case ICE_YELLOW:
				ret = FlavorYellow;
				break;
			default:
				break;
			}
			return ret;
		}
	}

	public static class Setting_CrashedIce{
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.crashediceeatallway")
		public static boolean CrashedIceCanEatAllways = false;
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.nameofsyrupflavor")
		public static String FlavorBlack="";
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.nameofsyrupflavor")
		public static String FlavorRed="";
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.nameofsyrupflavor")
		public static String FlavorGreen="";
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.nameofsyrupflavor")
		public static String FlavorBrown="";
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.nameofsyrupflavor")
		public static String FlavorBlue="";
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.nameofsyrupflavor")
		public static String FlavorPurple="";
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.nameofsyrupflavor")
		public static String FlavorCyan="";
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.nameofsyrupflavor")
		public static String FlavorSilver="";
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.nameofsyrupflavor")
		public static String FlavorGray="";
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.nameofsyrupflavor")
		public static String FlavorPink="";
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.nameofsyrupflavor")
		public static String FlavorLime="";
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.nameofsyrupflavor")
		public static String FlavorYellow="";
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.nameofsyrupflavor")
		public static String FlavorLightBlue="";
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.nameofsyrupflavor")
		public static String FlavorMagenta="";
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.nameofsyrupflavor")
		public static String FlavorOrange="";
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.nameofsyrupflavor")
		public static String FlavorWhite="";
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.melltingtime")
		public static int melltingTime=2400;
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.melltingflag")
		public static boolean melltingFlag = true;
		@ConfigProperty(category="Setting_CrashedIce", comment="config.comment.soundon")
		public static boolean sound_on = true;

		public static String getFlavorName(EnumFlapeSyrup flavor){
			String ret = "";
			switch(flavor){
			case SYRUP_BLACK:
				ret = FlavorBlack;
				break;
			case SYRUP_BLUE:
				ret = FlavorBlue;
				break;
			case SYRUP_BROWN:
				ret = FlavorBrown;
				break;
			case SYRUP_CYAN:
				ret = FlavorCyan;
				break;
			case SYRUP_GRAY:
				ret = FlavorGray;
				break;
			case SYRUP_GREEN:
				ret = FlavorGreen;
				break;
			case SYRUP_LIGHT_BLUE:
				ret = FlavorLightBlue;
				break;
			case SYRUP_LIME:
				ret = FlavorLime;
				break;
			case SYRUP_MAGENTA:
				ret = FlavorMagenta;
				break;
			case SYRUP_ORANGE:
				ret = FlavorOrange;
				break;
			case SYRUP_PINK:
				ret = FlavorPink;
				break;
			case SYRUP_PURPLE:
				ret = FlavorPurple;
				break;
			case SYRUP_RED:
				ret = FlavorRed;
				break;
			case SYRUP_SILVER:
				ret = FlavorSilver;
				break;
			case SYRUP_WHITE:
				ret = FlavorWhite;
				break;
			case SYRUP_YELLOW:
				ret = FlavorYellow;
				break;
			default:
				break;
			}
			return ret;
		}
	}

	public static class Setting_Mill{
		@ConfigProperty(category="Setting_IceCream", comment="config.comment.soundon")
		public static boolean sound_on = true;
	}
}
