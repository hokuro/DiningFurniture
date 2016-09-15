package mod.drf.core;

import mod.drf.creative.CreativeTabFurniture;
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

@Mod(modid = ModCommon.MOD_ID, name = ModCommon.MOD_NAME, version = ModCommon.MOD_VERSION)
public class Mod_DiningFurniture {
	@Mod.Instance(ModCommon.MOD_ID)
	public static Mod_DiningFurniture instance;
	@SidedProxy(clientSide = ModCommon.MOD_PACKAGE + ModCommon.MOD_CLIENT_SIDE, serverSide = ModCommon.MOD_PACKAGE + ModCommon.MOD_SERVER_SIDE)
	public static CommonProxy proxy;
	public static final SimpleNetworkWrapper Net_Instance = NetworkRegistry.INSTANCE.newSimpleChannel(ModCommon.MOD_CHANEL);


	public static final CreativeTabs tabsChairs = new CreativeTabFurniture(ModCommon.MOD_NAME);

	@EventHandler
	public void construct(FMLConstructionEvent event) {
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModRegister.RegisterBlock(event);
		ModRegister.RegisterItem(event);
		ModRegister.RegisterEntity(proxy);
		ModRegister.RegisterRender(proxy);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		ModRegister.RegisterRecipe();
        ModRegister.RegisterMessage();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
        proxy.registerClientInfo();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		proxy.registerColorMap();
	}


}
