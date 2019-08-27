package mod.drf.intaractionobject;

import mod.drf.common.inventory.ContainerOriginalWorkBench;
import mod.drf.core.ModCommon;
import mod.drf.foods.block.BlockCookingWorkBench;
import mod.drf.recipie.CookingMenu;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IInteractionObject;

public class IntaractionObjectCookingWorkBench implements IInteractionObject {

	private BlockPos entPos;

	public IntaractionObjectCookingWorkBench(BlockPos blockPos) {
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
		if (bk.getBlock() instanceof BlockCookingWorkBench){
			return new ContainerOriginalWorkBench(playerIn.inventory, playerIn.world, entPos, CookingMenu.getInstance());
		}
		return null;
	}

	@Override
	public String getGuiID() {
		// TODO 自動生成されたメソッド・スタブ
		return ModCommon.MOD_ID + ":" + ModCommon.MOD_GUI_ID_CWORKBENCH;
	}
}