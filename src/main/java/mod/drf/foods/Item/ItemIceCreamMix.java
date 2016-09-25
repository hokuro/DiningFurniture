package mod.drf.foods.Item;

import java.util.List;

import mod.drf.foods.Item.ItemFoods.EnumIceFlavor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemIceCreamMix extends Item {

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return this.getUnlocalizedName() + "." + EnumIceFlavor.getValue(par1ItemStack.getItemDamage()).getFlavor();
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (EnumIceFlavor flavor : EnumIceFlavor.values())
        {
        	subItems.add(new ItemStack(this, 1, flavor.getDamage()));
        }
    }
}
