package mod.drf.foods.Item;

import java.util.List;

import mod.drf.foods.Item.ItemFoods.EnumFlapeSyrup;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemIceCandy extends ItemFood {

	public ItemIceCandy(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return this.getUnlocalizedName() + "." + EnumFlapeSyrup.getValue(par1ItemStack.getItemDamage()).getFlavor();
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (EnumFlapeSyrup syrup : EnumFlapeSyrup.values())
        {
        	if (syrup == EnumFlapeSyrup.SYRUP_NONE){continue;}
        	subItems.add(new ItemStack(this, 1, syrup.getDamage()));
        }
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        --stack.stackSize;

        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            EnumFlapeSyrup syrup = EnumFlapeSyrup.getValue(stack.getItemDamage());
            entityplayer.getFoodStats().addStats(new ItemFood(syrup.getFoodLevel(),syrup.getFoodSaturation(),false),stack );
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.entity_player_burp, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.func_188057_b(this));
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
}
