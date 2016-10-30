package mod.drf.foods.Item;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemResetFood extends ItemFood {
	private int foodLevel;
	private float foodSaturation;

	public ItemResetFood(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
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
