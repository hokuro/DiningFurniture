package mod.drf.network;

import java.util.function.Supplier;

import mod.drf.inventory.ContainerFurnitureWorkBench;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class MessageSelectMenu{
	private float scrollIdx;
	private int selectIdx;

	public MessageSelectMenu(){}

	public MessageSelectMenu(float scridx, int selidx){
		this.scrollIdx = scridx;
		this.selectIdx = selidx;
	}

	public float getScrollIdx(){return this.scrollIdx;}
	public int getSelectIdx(){return this.selectIdx;}

	public static void encode(MessageSelectMenu pkt, PacketBuffer buf)
	{
		buf.writeFloat(pkt.scrollIdx);
		buf.writeInt(pkt.selectIdx);
	}

	public static MessageSelectMenu decode(PacketBuffer buf)
	{
		return new MessageSelectMenu(buf.readFloat(),buf.readInt());
	}

	public static class Handler
	{
		public static void handle(final MessageSelectMenu pkt, Supplier<NetworkEvent.Context> ctx)
		{
			ctx.get().enqueueWork(() -> {
				PlayerEntity plyaer = ctx.get().getSender();
				if (plyaer.openContainer instanceof ContainerFurnitureWorkBench){
					((ContainerFurnitureWorkBench)plyaer.openContainer).setSelectMenu(pkt);
				}
			});
			ctx.get().setPacketHandled(true);
		}
	}
}
