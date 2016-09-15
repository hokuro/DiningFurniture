package mod.drf.furniture.network;

import mod.drf.core.Mod_DiningFurniture;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class TrunkMessageHandler implements IMessageHandler<TrunkPagePacket,IMessage>{
	public TrunkMessageHandler(){}

	public IMessage onMessage(TrunkPagePacket packet, MessageContext context){
		context.getServerHandler().playerEntity.openGui(Mod_DiningFurniture.instance, packet.Page(), context.getServerHandler().playerEntity.worldObj, 0, 0, 0);
		return null;
	}
}