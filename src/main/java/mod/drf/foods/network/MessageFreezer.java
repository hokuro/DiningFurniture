package mod.drf.foods.network;

import java.util.function.Supplier;

import mod.drf.foods.tileentity.TileEntityFreezer;
import mod.drf.util.ModUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;

public class MessageFreezer{

	private int[] freezTimer;
	private int   iceTimer;
	private int tankCnt;
	private int fuelTimer;
	private boolean infinitFuel;
	private BlockPos pos;


	public MessageFreezer(){
		freezTimer = new int[27];
		iceTimer = 0;
		tankCnt = 0;
		fuelTimer = 0;
		infinitFuel = false;
	}

	public MessageFreezer(int[] ftimer, int fetimer, int itimer, int tcnt, boolean infinit,BlockPos posIn){
		freezTimer = new int[27];
		for (int i = 0; i < 27; i ++){
			freezTimer[i] = ftimer[i];
		}
		iceTimer = itimer;
		fuelTimer = fetimer;
		tankCnt = tcnt;
		infinitFuel = infinit;
		pos = posIn;
	}

	public int getTankCnt(){return this.tankCnt;}
	public int getFuelTimer(){return this.fuelTimer;}
	public int getIceTimer(){return this.iceTimer;}
	public boolean getInfinitFuel(){return this.infinitFuel;}
	public BlockPos getPos(){return this.pos;}
	public int getFreezeTime(int idx){return freezTimer[idx];}


	public static void encode(MessageFreezer pkt, PacketBuffer buf)
	{
		for ( int i = 0; i < 27; i++){
			buf.writeInt(pkt.freezTimer[i]);
		}
		buf.writeInt(pkt.iceTimer);
		buf.writeInt(pkt.fuelTimer);
		buf.writeInt(pkt.tankCnt);
		buf.writeBoolean(pkt.infinitFuel);
		buf.writeInt(pkt.pos.getX());
		buf.writeInt(pkt.pos.getY());
		buf.writeInt(pkt.pos.getZ());
	}

	public static MessageFreezer decode(PacketBuffer buf)
	{
		int[] freezTimer = new int[27];
		for (int i = 0; i < 27; i++){
			freezTimer[i] = buf.readInt();
		}
		int iceTimer = buf.readInt();
		int fuelTimer = buf.readInt();
		int tankCnt = buf.readInt();
		boolean infinitFuel = buf.readBoolean();
		BlockPos pos = new BlockPos(buf.readInt(),
				buf.readInt(),
				buf.readInt()
				);
		return new MessageFreezer(freezTimer, fuelTimer, iceTimer, tankCnt, infinitFuel, pos);
	}

	public static class Handler
	{
		public static void handle(final MessageFreezer pkt, Supplier<NetworkEvent.Context> ctx)
		{
			ctx.get().enqueueWork(() -> {
				TileEntity te = Minecraft.getInstance().world.getTileEntity(pkt.getPos());
				if (te instanceof TileEntityFreezer){
					((TileEntityFreezer)te).setField(TileEntityFreezer.FLDIDX_TNKCNT, pkt.getTankCnt());
					((TileEntityFreezer)te).setField(TileEntityFreezer.FLDIDX_ICE, pkt.getIceTimer());
					((TileEntityFreezer)te).setField(TileEntityFreezer.FLDIDX_FUEL, pkt.getFuelTimer());
					((TileEntityFreezer)te).setField(TileEntityFreezer.FLDIDX_INFT, ModUtil.BooleanToInteger(pkt.getInfinitFuel()));
					for (int i = 0; i < 27; i++){
						((TileEntityFreezer)te).setField(TileEntityFreezer.FLDIDX_FLZ+i, pkt.getFreezeTime(i));
					}
				}
			});
			ctx.get().setPacketHandled(true);
		}
	}

}
