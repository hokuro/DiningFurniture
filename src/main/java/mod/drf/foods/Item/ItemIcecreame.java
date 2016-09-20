package mod.drf.foods.Item;

import net.minecraft.item.ItemFood;

public class ItemIcecreame extends ItemFood {

	public ItemIcecreame(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public static enum EnumIceCream{
		ICE_VANILA,
		ICE_CHOCO,
		ICE_PUMPKIN,
		ICE_BLUCK,
		ICE_MELLON,
		ICE_CALLOT,
		ICE_POTETO,
		ICE_APPLE
	}
}
