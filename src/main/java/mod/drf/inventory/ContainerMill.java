package mod.drf.inventory;

import mod.drf.foods.tileentity.TileEntityMill;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerMill extends Container {

	public ContainerMill(InventoryPlayer playerInventory, TileEntityMill tileEntityMill) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
