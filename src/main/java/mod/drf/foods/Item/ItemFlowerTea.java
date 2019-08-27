package mod.drf.foods.Item;

import mod.drf.foods.Item.ItemFoods.EnumFlowerHalb;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ItemFlowerTea extends ItemPotion {

	private EnumFlowerHalb kind;

	public ItemFlowerTea(EnumFlowerHalb kindin, Item.Properties property) {
		super(property);
		kind = kindin;
	}

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (entityLiving instanceof EntityPlayer && !((EntityPlayer)entityLiving).isCreative())
        {
        	stack.shrink(1);
        }

        if (!worldIn.isRemote)
        {
        	EnumFlowerHalb halb = ((ItemFlowerTea)stack.getItem()).getKind();
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
        return stack.getCount() <= 0 ? new ItemStack(Items.GLASS_BOTTLE) : stack;
    }

    public EnumFlowerHalb getKind() {
    	return kind;
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.isInGroup(group)) {
           items.add(new ItemStack(this));
        }

     }

    @Override
    public String getTranslationKey(ItemStack stack) {
        return this.getTranslationKey();
     }


}
