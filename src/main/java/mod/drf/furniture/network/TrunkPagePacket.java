package mod.drf.furniture.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class TrunkPagePacket implements IMessage{

	private int page;

	public TrunkPagePacket(int next){
		page = next;
	}

	public TrunkPagePacket(){}

	public int Page(){return page;}

	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO 自動生成されたメソッド・スタブ
		page = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO 自動生成されたメソッド・スタブ
		buf.writeInt(page);
	}
}
