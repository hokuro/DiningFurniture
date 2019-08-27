package mod.drf.intaractionobject;

import mod.drf.core.ModCommon;
import mod.drf.foods.inventory.ContainerIceCrasher;
import mod.drf.foods.tileentity.TileEntityIceCrasher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IInteractionObject;

public class InteractionObjectIceCrasher implements IInteractionObject {

	private BlockPos entPos;

	public InteractionObjectIceCrasher(BlockPos blockPos) {
		// TODO 自動生成されたコンストラクター・スタブ
		entPos = blockPos;
	}

	@Override
	public ITextComponent getName() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean hasCustomName() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public ITextComponent getCustomName() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		TileEntity ent = playerIn.world.getTileEntity(entPos);
		if (ent instanceof TileEntityIceCrasher){
			return new ContainerIceCrasher(playerIn.inventory, (IInventory)ent);
		}
		return null;
	}

	@Override
	public String getGuiID() {
		// TODO 自動生成されたメソッド・スタブ
		return ModCommon.MOD_ID + ":" + ModCommon.MOD_GUI_ID_ICECRASHER;
	}
}