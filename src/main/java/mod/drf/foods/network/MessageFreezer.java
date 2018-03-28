package mod.drf.foods.network;

import io.netty.buffer.ByteBuf;
import mod.drf.foods.tileentity.TileEntityFreezer;
import mod.drf.util.ModUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageFreezer implements IMessage, IMessageHandler<MessageFreezer,IMessage>{

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


	@Override
	public IMessage onMessage(MessageFreezer message, MessageContext ctx) {
		TileEntity te = Minecraft.getMinecraft().world.getTileEntity(message.getPos());
		if (te instanceof TileEntityFreezer){
			((TileEntityFreezer)te).setField(TileEntityFreezer.FLDIDX_TNKCNT, message.getTankCnt());
			((TileEntityFreezer)te).setField(TileEntityFreezer.FLDIDX_ICE, message.getIceTimer());
			((TileEntityFreezer)te).setField(TileEntityFreezer.FLDIDX_FUEL, message.getFuelTimer());
			((TileEntityFreezer)te).setField(TileEntityFreezer.FLDIDX_INFT, ModUtil.BooleanToInteger(message.getInfinitFuel()));
			for (int i = 0; i < 27; i++){
				((TileEntityFreezer)te).setField(TileEntityFreezer.FLDIDX_FLZ+i, message.getFreezeTime(i));
			}
		}
		return null;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		freezTimer = new int[27];
		for (int i = 0; i < 27; i++){
			freezTimer[i] = buf.readInt();
		}
		iceTimer = buf.readInt();
		fuelTimer = buf.readInt();
		tankCnt = buf.readInt();
		infinitFuel = buf.readBoolean();
		pos = new BlockPos(buf.readInt(),
				buf.readInt(),
				buf.readInt()
				);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		for ( int i = 0; i < 27; i++){
			buf.writeInt(freezTimer[i]);
		}
		buf.writeInt(iceTimer);
		buf.writeInt(fuelTimer);
		buf.writeInt(tankCnt);
		buf.writeBoolean(infinitFuel);
		buf.writeInt(pos.getX());
		buf.writeInt(pos.getY());
		buf.writeInt(pos.getZ());
	}
}
