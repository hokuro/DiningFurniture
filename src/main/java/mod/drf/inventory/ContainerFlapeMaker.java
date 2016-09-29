package mod.drf.inventory;

import mod.drf.foods.tileentity.TileEntityFlapeMaker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerFlapeMaker extends Container {

	public ContainerFlapeMaker(InventoryPlayer playerInventory, TileEntityFlapeMaker tileEntityFlapeMaker) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
