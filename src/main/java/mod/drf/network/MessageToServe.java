package mod.drf.network;

import java.util.function.Supplier;

import mod.drf.common.inventory.ContainerOriginalWorkBench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class MessageToServe{
	public MessageToServe(){}

	public static void encode(MessageToServe pkt, PacketBuffer buf)
	{
	}

	public static MessageToServe decode(PacketBuffer buf)
	{
		return new MessageToServe();
	}

	public static class Handler
	{
		public static void handle(final MessageToServe pkt, Supplier<NetworkEvent.Context> ctx)
		{
			ctx.get().enqueueWork(() -> {
				EntityPlayer plyaer = ctx.get().getSender();
				if (plyaer.openContainer instanceof ContainerOriginalWorkBench){
					((ContainerOriginalWorkBench)plyaer.openContainer).toServe();
				}
			});
			ctx.get().setPacketHandled(true);
		}
	}
}
