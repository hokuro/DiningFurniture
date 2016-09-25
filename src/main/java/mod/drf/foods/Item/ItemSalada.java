package mod.drf.foods.Item;

import net.minecraft.init.Items;

public class ItemSalada extends ItemFoodRetBaul {

	public ItemSalada(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setContainerItem(Items.bowl);
	}

}
