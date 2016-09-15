package mod.drf.core;

public final class ModCommon {
	// デバッグモードかどうか
	public static boolean isDebug = false;
	// 開発モードかどうか
	public static boolean isDeveloped = false;

	// モッドID
	public static final String MOD_ID = "drm";
	// モッド名
	public static final String MOD_NAME = "DiningFurniture";
	public static final String MOD_PACKAGE = "mod.drm";
	public static final String MOD_CLIENT_SIDE = ".client.ClientProxy";
	public static final String MOD_SERVER_SIDE = ".core.CommonProxy";
	public static final String MOD_FACTRY = ".client.config.drmFactory";
	// モッドバージョン
	public static final String MOD_VERSION = "@VERSION@";
	// コンフィグファイル名
	public static final String MOD_CONFIG_FILE = "";
	// コンフィグ
	public static final String MOD_CONFIG_LANG = "";
	// コンフィグリロード間隔
	public static final long MOD_CONFIG_RELOAD = 500L;

	// コンフィグ カテゴリー general
	public static final String MOD_CONFIG_CAT_GENELAL = "general";
	public static final String MOD_CHANEL ="Mod_Channel_DiningFurniture";


    // GUI
	public static final String MOD_TRUNK_GUI_NAME = "TrunkCase";
	public static final int MOD_TRUNK_STACKSIZE = 64;
	public static final String MOD_ASSEAT = MOD_ID;
	public static final String MOD_TRUNK_GUI_PICT= "textures/gui/TrunkGui.png";

	public static int guiID = 0;
	public static boolean isLoad = false;

	public static final int TrunkRsize = 6;
	public static final int TrunkCsize = 13;
	public static final int TRUNK_MAX_PAGE = 10;

}
