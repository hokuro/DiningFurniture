package mod.drf.foods.Item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemResetFood extends ItemFood {
	private int foodLevel;
	private float foodSaturation;

	public ItemResetFood(int amount, float saturation, boolean isWolfFood, Item.Properties builder) {
		super(amount, saturation, isWolfFood, builder);
		foodLevel = amount;
		foodSaturation = saturation;
	}

	@Override
    public int getHealAmount(ItemStack stack)
    {
        return this.foodLevel;
    }

	@Override
    public float getSaturationModifier(ItemStack stack)
    {
        return this.foodSaturation;
    }

	public void setHealAmount(int value){
		this.foodLevel = value;
	}

	public void setSaturation(float saturation){
		this.foodSaturation = saturation;
	}
}
