package mod.drf.core;

public final class ModCommon {
	//===========================================================//
	// デバッグ関連
	public static boolean isDebug = true;                              // デバッグモードか?
	public static boolean isDeveloped = false;                         // 開発モードか?


	//===========================================================//
	// Modding設定
	public static final String MOD_ID = "drf";                           // Mod ID
	public static final String MOD_NAME = "DiningFurniture";             // 名称
	public static final String MOD_PACKAGE = "mod.drf";                  // ルートパッケージ
	public static final String MOD_CLIENT_SIDE = ".client.ClientProxy";  // クライアントプロキシパッケージ
	public static final String MOD_SERVER_SIDE = ".core.CommonProxy";    // サーバプロキシパッケージ
	public static final String MOD_FACTRY = ".client.config.drmFactory"; // ファクトリパッケージ
	public static final String MOD_VERSION = "@VERSION@";                // バージョン
	public static final String MOD_CHANEL ="Mod_Channel_DiningFurniture";// ネットワークチャンネル

	//===========================================================//
    // GUI ID
	public static final int MOD_GUI_ID_ICECRASHER = 1;
	public static final int MOD_GUI_ID_MILLSTONE = 2;
	public static final int MOD_GUI_ID_FREEZER = 3;
	public static final int MOD_GUI_ID_TRUNK = 104;
	public static final int MOD_GUI_ID_UNLIMITANVIL = 102;
	public static final int MOD_GUI_ID_ENTDELETER = 103;


	// GUI NAME
	public static final String MOD_GUI_ICECRASHER_NAME = ModCommon.MOD_ID + ":IceCrassher";
	public static final String MOD_GUI_MILLSTONE_NAME = ModCommon.MOD_ID + ":MillStone";
	public static final String MOD_GUI_FREEZER_NAME = ModCommon.MOD_ID + ":Freezer";
	public static final String MOD_GUI_SALTPAN_NAME = ModCommon.MOD_ID + ":SaltPan";




	public static final String MOD_TRUNK_GUI_NAME = "TrunkCase";
	public static final int MOD_TRUNK_STACKSIZE = 64;
	public static final String MOD_ASSEAT = MOD_ID;
	public static final String MOD_TRUNK_GUI_PICT= "textures/gui/TrunkGui.png";


	public static final int TrunkRsize = 6;
	public static final int TrunkCsize = 13;
	public static final int TRUNK_MAX_PAGE = 10;


	//===========================================================//
	// MessagID
	public static final int MESSAGE_ID_TRUNKDATA = 0;
	public static final int MESSAGE_ID_ICECRASHER_UPDATE = 1;
	public static final int MESSAGE_ID_FREEZER = 2;
	public static final int MESSAGE_ID_MILLSTONE_UPDATE = 3;



}
