package mod.drf.foods.Item;

import mod.drf.foods.Item.ItemFoods.EnumFlowerHalb;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
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
    public void getSubItems( CreativeTabs tab, NonNullList<ItemStack> subItems)
    {
    	if ( this.getCreativeTab() != tab){return;}
        for (EnumFlowerHalb halb : EnumFlowerHalb.values())
        {
        	subItems.add(new ItemStack(this, 1, halb.getDamage()));
        }
    }



    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (entityLiving instanceof EntityPlayer && !((EntityPlayer)entityLiving).capabilities.isCreativeMode)
        {
        	stack.shrink(1);
        }

        if (!worldIn.isRemote)
        {
        	EnumFlowerHalb halb = EnumFlowerHalb.getValue(stack.getItemDamage());
        	if (halb == EnumFlowerHalb.PEONY){entityLiving.extinguish();}
        	else{
            	Potion[] effect = halb.getPotion();
            	if (effect != null){
            		if (halb.isClean()){
                		for (int i = 0; i < effect.length; i++){
            				entityLiving.removePotionEffect(effect[i]);
                		}
            		}else{
            			for (int i = 0; i < effect.length; i++){
            				entityLiving.addPotionEffect(new PotionEffect(effect[i],20*10,1));
            			}
            		}
            	}
        	}
        }

        if (entityLiving instanceof EntityPlayer)
        {
            ((EntityPlayer)entityLiving).addStat(StatList.getObjectUseStats(this));
        }

        return stack.getCount() <= 0 ? new ItemStack(Items.GLASS_BOTTLE) : stack;
    }
}
