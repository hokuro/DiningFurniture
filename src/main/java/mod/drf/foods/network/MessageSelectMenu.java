package mod.drf.foods.network;

import io.netty.buffer.ByteBuf;
import mod.drf.foods.inventory.ContainerOriginalWorkBench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageSelectMenu implements IMessage, IMessageHandler<MessageSelectMenu,IMessage>{
	private float scrollIdx;
	private int selectIdx;

	public MessageSelectMenu(){}

	public MessageSelectMenu(float scridx, int selidx){
		this.scrollIdx = scridx;
		this.selectIdx = selidx;
	}

	public float getScrollIdx(){return this.scrollIdx;}
	public int getSelectIdx(){return this.selectIdx;}


	@Override
	public IMessage onMessage(MessageSelectMenu packet, MessageContext context){
		EntityPlayer plyaer = context.getServerHandler().player;
		if (plyaer.openContainer instanceof ContainerOriginalWorkBench){
			((ContainerOriginalWorkBench)plyaer.openContainer).setSelectMenu(packet);
		}
		return null;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.scrollIdx = buf.readFloat();
		this.selectIdx =  buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeFloat(this.scrollIdx);
		buf.writeInt(this.selectIdx);
	}
}
