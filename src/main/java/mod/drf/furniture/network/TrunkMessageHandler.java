package mod.drf.furniture.network;

import mod.drf.core.Mod_DiningFurniture;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class TrunkMessageHandler implements IMessageHandler<TrunkPagePacket,IMessage>{
	public TrunkMessageHandler(){}

	public IMessage onMessage(TrunkPagePacket packet, MessageContext context){
		context.getServerHandler().player.openGui(Mod_DiningFurniture.instance, packet.Page(), context.getServerHandler().player.world, 0, 0, 0);
		return null;
	}
}