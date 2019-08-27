package mod.drf.core;

public final class ModCommon {
	//===========================================================//
	// デバッグ関連
	public static boolean isDebug = false;                              // デバッグモードか?
	public static boolean isDeveloped = false;                         // 開発モードか?


	//===========================================================//
	// Modding設定
	public static final String MOD_ID = "drf";                           // Mod ID
	public static final String MOD_NAME = "diningfurniture";             // 名称
	public static final String MOD_PACKAGE = "mod.drf";                  // ルートパッケージ
	public static final String MOD_CLIENT_SIDE = ".client.ClientProxy";  // クライアントプロキシパッケージ
	public static final String MOD_SERVER_SIDE = ".core.CommonProxy";    // サーバプロキシパッケージ
	public static final String MOD_FACTRY = ".client.config.drmFactory"; // ファクトリパッケージ
	public static final String MOD_VERSION = "1.12.0";                // バージョン
	public static final String MOD_CHANEL ="mod_channel_diningfurniture";// ネットワークチャンネル
    // 前に読み込まれるべき前提MODをバージョン込みで指定
    public static final String MOD_DEPENDENCIES = "required-after:Forge@[1.9-12.16.0.1853,)";
    // 起動出来るMinecraft本体のバージョン。記法はMavenのVersion Range Specificationを検索すること。
    public static final String MOD_ACCEPTED_MC_VERSIONS = "[1.12]";


	//===========================================================//
    // GUI ID
	public static final String MOD_GUI_ID_ICECRASHER = "icecrasher";
	public static final String MOD_GUI_ID_MILLSTONE = "millstone";
	public static final String MOD_GUI_ID_FREEZER = "freezer";
	public static final String MOD_GUI_ID_CWORKBENCH = "cworkbench";
	public static final String MOD_GUI_ID_DWORKBENCH = "dworkbench";


	// GUI NAME
	public static final String MOD_GUI_ICECRASHER_NAME = ModCommon.MOD_ID + ":IceCrassher";
	public static final String MOD_GUI_MILLSTONE_NAME = ModCommon.MOD_ID + ":MillStone";
	public static final String MOD_GUI_FREEZER_NAME = ModCommon.MOD_ID + ":Freezer";
	public static final String MOD_GUI_SALTPAN_NAME = ModCommon.MOD_ID + ":SaltPan";
	public static final String MOD_GUI_CWORKBENCH_NAME = ModCommon.MOD_ID +":cworkbench";
	public static final String MOD_GUI_DWORKBENCH_NAME = ModCommon.MOD_ID +":dworkbench";

}
