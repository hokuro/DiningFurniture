package mod.drf.foods.network;

import java.util.function.Supplier;

import mod.drf.foods.tileentity.TileEntityIceCrasher;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;

public class MessageIceCrasherUpdate{

	private int crushTime;
	private boolean isRun;
	private BlockPos pos;

	public MessageIceCrasherUpdate(){}

	public MessageIceCrasherUpdate(int crushTime, boolean isRun, BlockPos posIn){
		this.crushTime = crushTime;
		this.isRun  = isRun;
		this.pos = posIn;
	}

	public int getCrushTime(){return this.crushTime;}
	public boolean getIsRun(){return this.isRun;}
	public BlockPos getPos(){return this.pos;}


	public static void encode(MessageIceCrasherUpdate pkt, PacketBuffer buf)
	{
		buf.writeInt(pkt.crushTime);
		buf.writeBoolean(pkt.isRun);
		buf.writeInt(pkt.pos.getX());
		buf.writeInt(pkt.pos.getY());
		buf.writeInt(pkt.pos.getZ());
	}

	public static MessageIceCrasherUpdate decode(PacketBuffer buf)
	{
		int crushTime = buf.readInt();
		boolean isRun =  buf.readBoolean();
		BlockPos pos = new BlockPos(buf.readInt(),
				buf.readInt(),
				buf.readInt()
				);
		return new MessageIceCrasherUpdate(crushTime, isRun, pos);
	}

	public static class Handler
	{
		public static void handle(final MessageIceCrasherUpdate pkt, Supplier<NetworkEvent.Context> ctx)
		{
			ctx.get().enqueueWork(() -> {
				TileEntity te = Minecraft.getInstance().world.getTileEntity(pkt.getPos());
				if (te instanceof TileEntityIceCrasher){
					((TileEntityIceCrasher)te).setField(0, pkt.crushTime);
					((TileEntityIceCrasher)te).setField(1, pkt.getIsRun()?1:0);
				}
			});
			ctx.get().setPacketHandled(true);
		}
	}
}

