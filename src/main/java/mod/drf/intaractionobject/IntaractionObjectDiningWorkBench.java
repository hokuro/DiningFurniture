package mod.drf.intaractionobject;

import mod.drf.common.inventory.ContainerOriginalWorkBench;
import mod.drf.core.ModCommon;
import mod.drf.furniture.block.BlockFurnitureWorkBench;
import mod.drf.recipie.FurnitureMenu;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IInteractionObject;

public class IntaractionObjectDiningWorkBench implements IInteractionObject {

	private BlockPos entPos;

	public IntaractionObjectDiningWorkBench(BlockPos blockPos) {
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
		IBlockState bk = playerIn.world.getBlockState(entPos);
		if (bk.getBlock() instanceof BlockFurnitureWorkBench){
			return new ContainerOriginalWorkBench(playerIn.inventory, playerIn.world, entPos, FurnitureMenu.getInstance());
		}
		return null;
	}

	@Override
	public String getGuiID() {
		// TODO 自動生成されたメソッド・スタブ
		return ModCommon.MOD_ID + ":" + ModCommon.MOD_GUI_ID_DWORKBENCH;
	}
}