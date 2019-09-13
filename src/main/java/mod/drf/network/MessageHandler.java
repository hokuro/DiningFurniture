package mod.drf.network;

import mod.drf.core.ModCommon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class MessageHandler {
	private static final String PROTOCOL_VERSION = Integer.toString(1);
	private static final SimpleChannel Handler = NetworkRegistry.ChannelBuilder
			.named(new ResourceLocation(ModCommon.MOD_ID,ModCommon.MOD_CHANEL))
			.clientAcceptedVersions(PROTOCOL_VERSION::equals)
			.serverAcceptedVersions(PROTOCOL_VERSION::equals)
			.networkProtocolVersion(() -> PROTOCOL_VERSION)
			.simpleChannel();

	public static void register()
	{
		int disc = 0;

		Handler.registerMessage(disc++, MessageToServe.class, MessageToServe::encode, MessageToServe::decode, MessageToServe.Handler::handle);
		Handler.registerMessage(disc++, MessageSelectMenu.class, MessageSelectMenu::encode, MessageSelectMenu::decode, MessageSelectMenu.Handler::handle);
	}

	public static void Send_MessageToServer(){
		Handler.sendToServer(new MessageToServe());
	}

	public static void Send_MessageSelectMenu(float scroll, int selectslot) {
		Handler.sendToServer(new MessageSelectMenu(scroll,selectslot));
	}
}
