package mod.drf.foods.Item;

import mod.drf.config.ConfigValue.Setting_CrashedIce;
import mod.drf.core.Mod_DiningFurniture;
import mod.drf.foods.Item.ItemFoods.EnumFlapeSyrup;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemIceCandy extends ItemFood {

	private final float attackDamage = 0.5F;

	public ItemIceCandy(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setCreativeTab(Mod_DiningFurniture.tabColdFood);
		setHasSubtypes(true);
	}


	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		String ret = Setting_CrashedIce.getFlavorName(EnumFlapeSyrup.getValue(stack.getItemDamage()));
		if (ret.isEmpty()){
			ret = I18n.translateToLocal(this.getUnlocalizedName() + "." + EnumFlapeSyrup.getValue(stack.getItemDamage()).getFlavor() + ".name");
		}else{
			ret = I18n.translateToLocal("icecandy_config")+"("+ret + ")";
		}
		return ret;
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		String ret = Setting_CrashedIce.getFlavorName(EnumFlapeSyrup.getValue(par1ItemStack.getItemDamage()));
		if (ret.isEmpty()){
			ret = this.getUnlocalizedName() + "." + EnumFlapeSyrup.getValue(par1ItemStack.getItemDamage()).getFlavor();
		}else{
			ret = I18n.translateToLocal("icecandy_config")+"("+ret + ")";
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

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        stack.shrink(1);

        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            EnumFlapeSyrup syrup = EnumFlapeSyrup.getValue(stack.getItemDamage());
            entityplayer.getFoodStats().addStats(new ItemFood(syrup.getFoodLevel(),syrup.getFoodSaturation(),false),stack );
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.getObjectUseStats(this));

			if (!worldIn.isRemote){
	            if (!((EntityPlayer)entityLiving).inventory.addItemStackToInventory(new ItemStack(Items.STICK,1))){
	            	((EntityPlayer)entityLiving).dropItem(new ItemStack(Items.STICK), false);
	            }
			}
        }

        return stack;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
    	EnumFlapeSyrup flavor = EnumFlapeSyrup.getValue(stack.getItemDamage());
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
}
