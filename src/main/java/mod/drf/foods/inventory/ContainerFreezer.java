package mod.drf.foods.inventory;

import mod.drf.foods.tileentity.TileEntityFreezer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerFreezer extends Container {

	public ContainerFreezer(InventoryPlayer playerInventory, TileEntityFreezer tileEntityFreezer) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
