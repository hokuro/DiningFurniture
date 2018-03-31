package mod.drf.foods.network;

import io.netty.buffer.ByteBuf;
import mod.drf.common.inventory.ContainerOriginalWorkBench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageToServe implements IMessage, IMessageHandler<MessageToServe,IMessage>{
	public MessageToServe(){}

	@Override
	public IMessage onMessage(MessageToServe packet, MessageContext context){
		EntityPlayer plyaer = context.getServerHandler().player;
		if (plyaer.openContainer instanceof ContainerOriginalWorkBench){
			((ContainerOriginalWorkBench)plyaer.openContainer).toServe();
		}
		return null;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
	}

	@Override
	public void toBytes(ByteBuf buf) {
	}
}
