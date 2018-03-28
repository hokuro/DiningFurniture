package mod.drf.foods.Item;

import mod.drf.config.ConfigValue.Setting_IceCream;
import mod.drf.core.Mod_DiningFurniture;
import mod.drf.foods.Item.ItemFoods.EnumIceFlavor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemIceCreamMix extends Item {

	public ItemIceCreamMix(){
		setCreativeTab(Mod_DiningFurniture.tabColdFood);
		setHasSubtypes(true);
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		String ret = Setting_IceCream.getFlavorName(EnumIceFlavor.getValue(stack.getItemDamage()));
		if (ret.isEmpty()){
			ret = I18n.translateToLocal(this.getUnlocalizedName() + "." + EnumIceFlavor.getValue(stack.getItemDamage()).getFlavor()+".name");
		}else{
			ret = I18n.translateToLocal("icemix_config")+"("+ret + ")";
		}
		return ret;
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		String ret = Setting_IceCream.getFlavorName(EnumIceFlavor.getValue(par1ItemStack.getItemDamage()));
		if (ret.isEmpty()){
			ret = this.getUnlocalizedName() + "." + EnumIceFlavor.getValue(par1ItemStack.getItemDamage()).getFlavor();
		}else{
			ret = I18n.translateToLocal("icemix_config")+"("+ret + ")";
		}
		return ret;
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems( CreativeTabs tab, NonNullList<ItemStack> subItems)
    {
    	if (this.getCreativeTab() != tab){return;}
        for (EnumIceFlavor flavor : EnumIceFlavor.values())
        {
        	subItems.add(new ItemStack(this, 1, flavor.getDamage()));
        }
    }
}
