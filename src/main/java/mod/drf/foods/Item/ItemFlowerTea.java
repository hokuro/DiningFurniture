package mod.drf.foods.Item;

import java.util.List;

import mod.drf.foods.Item.ItemFoods.EnumFlowerHalb;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFlowerTea extends ItemPotion {


	@Override
    public String getItemStackDisplayName(ItemStack stack)
    {
        return I18n.translateToLocal(getUnlocalizedName(stack));
    }

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return this.getUnlocalizedName() + "." + EnumFlowerHalb.getValue(par1ItemStack.getItemDamage()).getFlavor();
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (EnumFlowerHalb halb : EnumFlowerHalb.values())
        {
        	subItems.add(new ItemStack(this, 1, halb.getDamage()));
        }
    }
}
