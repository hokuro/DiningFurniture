package mod.drf.core;

import basashi.trunk.recipi.RecipiCore;
import mod.drf.creative.CreativeTabFurniture;
import mod.drf.furniture.entity.EntityCore;
import mod.drf.furniture.item.ItemFurniture;
import mod.drf.furniture.network.TrunkMessageHandler;
import mod.drf.furniture.network.TrunkPagePacket;
import mod.drf.furniture.recipe.RecipeCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = ModCommon.MOD_ID, name = ModCommon.MOD_NAME, version = ModCommon.MOD_VERSION)
public class MoreChair {
	@Mod.Instance(ModCommon.MOD_ID)
	public static MoreChair instance;
	@SidedProxy(clientSide = ModCommon.MOD_PACKAGE + ModCommon.MOD_CLIENT_SIDE, serverSide = ModCommon.MOD_PACKAGE + ModCommon.MOD_SERVER_SIDE)
	public static CommonProxy proxy;
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(ModCommon.MOD_CHANEL);


	public static final CreativeTabs tabsChairs = new CreativeTabFurniture(ModCommon.MOD_NAME);

	@EventHandler
	public void construct(FMLConstructionEvent event) {
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ItemFurniture.registerItem(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		//INSTANCE.register(this)
		RecipeCore.registerRecipise();
		EntityCore.instance.registerModEntity();
		proxy.registerChairRender();

		// パケット、ハンドラー登録
		INSTANCE.registerMessage(TrunkMessageHandler.class, TrunkPagePacket.class, 0, Side.SERVER);
		// プロキシの登録
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
        proxy.registerClientInfo();

		RecipiCore.registRecipies();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		proxy.registerColorMap();
	}
}
