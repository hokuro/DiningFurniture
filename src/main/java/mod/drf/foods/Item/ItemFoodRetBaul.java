package mod.drf.foods.Item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class ItemFoodRetBaul extends ItemFoodPieCakes {

	public ItemFoodRetBaul(int amount, float saturation, boolean isWolfFood, Item.Properties property) {
		super(amount, saturation, isWolfFood, property);
		// TODO 自動生成されたコンストラクター・スタブ
	}

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        super.onItemUseFinish(stack, worldIn, entityLiving);
        return new ItemStack(Items.BOWL);
    }
}
