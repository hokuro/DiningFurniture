package mod.drf.foods.Item;

import mod.drf.foods.Item.ItemFoods.EnumFlowerHalb;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFlowerDust extends Item {


	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return this.getUnlocalizedName() + "." + EnumFlowerHalb.getValue(par1ItemStack.getItemDamage()).getFlavor();
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems( CreativeTabs tab, NonNullList<ItemStack> subItems)
    {
    	if ( this.getCreativeTab() != tab){return;}
        for (EnumFlowerHalb halb : EnumFlowerHalb.values())
        {
        	subItems.add(new ItemStack(this, 1, halb.getDamage()));
        }
    }
}
