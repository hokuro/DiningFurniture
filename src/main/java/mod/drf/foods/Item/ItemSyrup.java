package mod.drf.foods.Item;

import mod.drf.config.ConfigValue.Setting_CrashedIce;
import mod.drf.core.Mod_DiningFurniture;
import mod.drf.foods.Item.ItemFoods.EnumFlapeSyrup;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSyrup extends Item {

	private String ctype;
	public ItemSyrup(String configtype){
		setCreativeTab(Mod_DiningFurniture.tabColdFood);
		setHasSubtypes(true);
		ctype = configtype;
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		String ret = Setting_CrashedIce.getFlavorName(EnumFlapeSyrup.getValue(stack.getItemDamage()));
		if (ret.isEmpty()){
			ret = I18n.translateToLocal( this.getUnlocalizedName() + "." + EnumFlapeSyrup.getValue(stack.getItemDamage()).getFlavor()+".name");
		}else{
			ret = I18n.translateToLocal(ctype)+" ("+ret + ")";
		}
		return ret;
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		String ret = Setting_CrashedIce.getFlavorName(EnumFlapeSyrup.getValue(par1ItemStack.getItemDamage()));
		if (ret.isEmpty()){
			ret = this.getUnlocalizedName() + "." + EnumFlapeSyrup.getValue(par1ItemStack.getItemDamage()).getFlavor();
		}else{
			ret = I18n.translateToLocal(ctype)+" ("+ret + ")";
		}
		return ret;
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems)
    {
    	if (this.getCreativeTab() != tab){return;}
        for (EnumFlapeSyrup syrup : EnumFlapeSyrup.values())
        {
        	if (syrup == EnumFlapeSyrup.SYRUP_NONE){continue;}
        	subItems.add(new ItemStack(this, 1, syrup.getDamage()));
        }
    }
}
