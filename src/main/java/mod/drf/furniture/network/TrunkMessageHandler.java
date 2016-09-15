package mod.drf.furniture.network;

import basashi.trunk.core.Trunk;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class TrunkMessageHandler implements IMessageHandler<TrunkPagePacket,IMessage>{
	public TrunkMessageHandler(){}

	public IMessage onMessage(TrunkPagePacket packet, MessageContext context){
		context.getServerHandler().playerEntity.openGui(Trunk.instance, packet.Page(), context.getServerHandler().playerEntity.worldObj, 0, 0, 0);
		return null;
	}
}