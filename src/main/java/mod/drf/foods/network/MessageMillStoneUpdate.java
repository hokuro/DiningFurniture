package mod.drf.foods.network;

import java.util.function.Supplier;

import mod.drf.foods.tileentity.TileEntityMillStone;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;

public class MessageMillStoneUpdate{

	private int crushTime;
	private boolean isRun;
	private BlockPos pos;

	public MessageMillStoneUpdate(){}

	public MessageMillStoneUpdate(int crushTime, boolean isRun, BlockPos posIn){
		this.crushTime = crushTime;
		this.isRun  = isRun;
		this.pos = posIn;
	}

	public int getCrushTime(){return this.crushTime;}
	public boolean getIsRun(){return this.isRun;}
	public BlockPos getPos(){return this.pos;}


	public static void encode(MessageMillStoneUpdate pkt, PacketBuffer buf)
	{
		buf.writeInt(pkt.crushTime);
		buf.writeBoolean(pkt.isRun);
		buf.writeInt(pkt.pos.getX());
		buf.writeInt(pkt.pos.getY());
		buf.writeInt(pkt.pos.getZ());
	}

	public static MessageMillStoneUpdate decode(PacketBuffer buf)
	{
		int crushTime = buf.readInt();
		boolean isRun =  buf.readBoolean();
		BlockPos pos = new BlockPos(buf.readInt(),
				buf.readInt(),
				buf.readInt()
				);
		return new MessageMillStoneUpdate(crushTime, isRun, pos);
	}

	public static class Handler
	{
		public static void handle(final MessageMillStoneUpdate pkt, Supplier<NetworkEvent.Context> ctx)
		{
			ctx.get().enqueueWork(() -> {
				TileEntity te = Minecraft.getInstance().world.getTileEntity(pkt.getPos());
				if (te instanceof TileEntityMillStone){
					((TileEntityMillStone)te).setField(0, pkt.crushTime);
					((TileEntityMillStone)te).setField(1, pkt.getIsRun()?1:0);
				}
			});
			ctx.get().setPacketHandled(true);
		}
	}

}
