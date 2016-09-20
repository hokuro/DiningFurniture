package mod.drf.foods.Item;

import net.minecraft.item.Item;

public class ItemSyrup extends Item {

	public static enum EnumFlapeSyrup{
		SYRUP_NONE(0),
		SYRUP_SUGAR(1),
		SYRUP_PUMPKI(2),
		SYRUP_CACTUS(3),
		SYRUP_WMELLON(4),
		SYRUP_BLUCK(5),
		SYRUP_STRAWBERRY(6),
		SYRUP_MELON(7),
		SYRUP_CHOCOLATE(8),
		SYRUP_POTION(9),
		SYRUP_BERRY(10),
		SYRUP_BLUEHAWAII(11),
		SYRUP_COCONUT(12),
		SYRUP_MATCHER(13),
		SYRUP_PEACH(14),
		SYRUP_LIME(15),
		SYRUP_LEMON(16),
		SYRUP_SODA(17),
		SYRUP_GRAPE(18),
		SYRUP_ORANGE(19),
		SYRUP_CALUCIUM(20);

		private int index;
		private int damage;
		private EnumFlapeSyrup(int idx){
			index = idx;
			damage = idx;
		}
	}
}
