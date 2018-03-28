package mod.drf.foods.network;

import io.netty.buffer.ByteBuf;
import mod.drf.foods.tileentity.TileEntityIceCrasher;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageIceCrasherUpdate implements IMessage, IMessageHandler<MessageIceCrasherUpdate,IMessage>{

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

	@Override
	public IMessage onMessage(MessageIceCrasherUpdate message, MessageContext ctx) {
		TileEntity te = Minecraft.getMinecraft().world.getTileEntity(message.getPos());
		if (te instanceof TileEntityIceCrasher){
			((TileEntityIceCrasher)te).setField(0, message.crushTime);
			((TileEntityIceCrasher)te).setField(1, message.getIsRun()?1:0);
		}
		return null;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.crushTime = buf.readInt();
		this.isRun =  buf.readBoolean();
		pos = new BlockPos(buf.readInt(),
				buf.readInt(),
				buf.readInt()
				);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.crushTime);
		buf.writeBoolean(this.isRun);
		buf.writeInt(pos.getX());
		buf.writeInt(pos.getY());
		buf.writeInt(pos.getZ());
	}
}

