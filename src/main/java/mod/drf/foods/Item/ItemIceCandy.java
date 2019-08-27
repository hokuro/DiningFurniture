package mod.drf.foods.Item;

import mod.drf.core.Mod_DiningFurniture;
import mod.drf.foods.Item.ItemFoods.EnumFlapeSyrup;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemIceCandy extends ItemFood {

	private final EnumFlapeSyrup flavor;
	private final float attackDamage = 0.5F;

	public ItemIceCandy(EnumFlapeSyrup syrup) {
		this(syrup.getFoodLevel(),syrup.getFoodSaturation(),false,syrup);
		setAlwaysEdible();
	}

	public ItemIceCandy(int amount, float saturation, boolean isWolfFood, EnumFlapeSyrup syrup) {
		super(amount, saturation, isWolfFood,
				(new Item.Properties()).group(Mod_DiningFurniture.tabColdFood));
		flavor = syrup;
	}

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {

        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            EnumFlapeSyrup syrup = ((ItemIceCandy)stack.getItem()).getFlavor();
            entityplayer.getFoodStats().addStats(new ItemFood(syrup.getFoodLevel(),syrup.getFoodSaturation(),false, new Item.Properties()),stack );
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);

			if (!worldIn.isRemote){
	            if (!((EntityPlayer)entityLiving).inventory.addItemStackToInventory(new ItemStack(Items.STICK,1))){
	            	((EntityPlayer)entityLiving).dropItem(new ItemStack(Items.STICK), false);
	            }
			}
        }
        stack.shrink(1);

        return stack;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
    	EnumFlapeSyrup flavor = ((ItemIceCandy)stack.getItem()).getFlavor();
    	if (!worldIn.isRemote && flavor.getPotion() != null){
    		for (int i = 0; i < flavor.getPotion().length; i++){
    			player.addPotionEffect(flavor.getPotion()[i]);
    		}
    	}
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        // 鎮火
        target.extinguish();
        // 移動速度低下
        target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS,300,100) );
        // 火炎耐性1分
        target.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE,1200,1));

        attacker.renderBrokenItemStack(stack);
        stack.shrink(1);

        return true;
    }

    public EnumFlapeSyrup getFlavor() {
    	return flavor;
    }
}
