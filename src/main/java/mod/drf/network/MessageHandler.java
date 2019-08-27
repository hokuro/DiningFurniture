package mod.drf.network;

import mod.drf.core.ModCommon;
import mod.drf.foods.network.MessageFreezer;
import mod.drf.foods.network.MessageIceCrasherUpdate;
import mod.drf.foods.network.MessageMillStoneUpdate;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
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


		Handler.registerMessage(disc++, MessageIceCrasherUpdate.class, MessageIceCrasherUpdate::encode, MessageIceCrasherUpdate::decode, MessageIceCrasherUpdate.Handler::handle);
		Handler.registerMessage(disc++, MessageMillStoneUpdate.class, MessageMillStoneUpdate::encode, MessageMillStoneUpdate::decode, MessageMillStoneUpdate.Handler::handle);
		Handler.registerMessage(disc++, MessageFreezer.class, MessageFreezer::encode, MessageFreezer::decode, MessageFreezer.Handler::handle);

	}

	public static void Send_MessageToServer(){
		Handler.sendToServer(new MessageToServe());
	}

	public static void Send_MessageSelectMenu(float scroll, int selectslot) {
		Handler.sendToServer(new MessageSelectMenu(scroll,selectslot));
	}

	public static void Send_MessageFreezer(int[] timerCnt, int timerFule, int timerIce, int tankCnt, boolean isInfinit,
			BlockPos pos) {
		try {
			Handler.sendToServer(new MessageFreezer(timerCnt, timerFule, timerIce, tankCnt, isInfinit, pos));
		}catch(Throwable e){

		}
	}

	public static void Send_MessageIceCrasherUpdate(int crushTime, boolean isRun, BlockPos pos) {
		try {
			Handler.sendToServer(new MessageIceCrasherUpdate(crushTime, isRun, pos));
		}catch(Throwable e){

		}

	}

	public static void Send_MessageMillStoneUpdate(int millTime, boolean isRun, BlockPos pos) {
		try {
			Handler.sendToServer(new MessageMillStoneUpdate(millTime, isRun, pos));
		//Handler.sendTo(new MessageMillStoneUpdate(millTime, isRun, pos), Minecraft.getInstance().getConnection().getNetworkManager(), NetworkDirection.PLAY_TO_CLIENT);
		}catch(Throwable e){

		}
	}


}
