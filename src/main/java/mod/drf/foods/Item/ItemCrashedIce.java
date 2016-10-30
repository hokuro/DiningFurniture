package mod.drf.foods.Item;

import java.util.List;

import mod.drf.config.ConfigValue;
import mod.drf.core.ModCommon;
import mod.drf.core.log.ModLog;
import mod.drf.foods.Item.ItemFoods.EnumFlapeSyrup;
import mod.drf.foods.entity.EntityCrashedIce;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCrashedIce extends ItemResetFood {
	public ItemCrashedIce(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setHasSubtypes(true);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemstack, World world, EntityPlayer player, EnumHand hand){
		float f = 1.0F;
		float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
		float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
		double d0 = player.prevPosX + (player.posX - player.prevPosX) * (double) f;
		double d1 = (player.prevPosY + (player.posY-player.prevPosY) * (double)f+1.6200000000000001D) - (double) player.getYOffset();
		double d2 = player.prevPosZ + (player.posZ -player.prevPosZ) * (double)f;
		Vec3d vec3 = new Vec3d(d0,d1,d2);
		float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
		float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
		float f5 = -MathHelper.cos(-f1 * 0.01745329F);
		float f6 = MathHelper.sin(-f1 * 0.01745329F);
		float f7 = f4 * f5;
		float f8 = f6;
		float f9 = f3 * f5;
		double range = 5D;
		Vec3d vec3d1 =  vec3.addVector((double)f7*range, (double)f8*range, (double)f9*range);
		RayTraceResult movingbjectposition = world.rayTraceBlocks(vec3, vec3d1,true);

		if (movingbjectposition == null){
			// 置くブロックがないのでそのまま食べる
	        if (player.canEat(ConfigValue.General.CrashedIceCanEatAllways) || ModCommon.isDeveloped)
	        {
	            player.setActiveHand(hand);
	            return new ActionResult(EnumActionResult.SUCCESS, itemstack);
	        }
	        else
	        {
	            return new ActionResult(EnumActionResult.FAIL, itemstack);
	        }
		}

		if (movingbjectposition.typeOfHit == RayTraceResult.Type.BLOCK){
			// アイスを置く
			BlockPos blockpos = movingbjectposition.getBlockPos();
			if (world.isAirBlock(blockpos.add(0,1,0))){
				if (!world.isRemote){
					try{
						EntityCrashedIce ice = new EntityCrashedIce(world, blockpos, itemstack.getItemDamage());
						ice.rotationYaw = (MathHelper.floor_double((double)((player.rotationYaw*4F)/360F)+2.5D)&3)*90;
						world.spawnEntityInWorld(ice);
					}catch(Exception e){
						ModLog.log().error(e.getMessage());
					}
				}
				if(!player.capabilities.isCreativeMode){
					itemstack.stackSize--;
				}
			}
		}
		return new ActionResult(EnumActionResult.SUCCESS,itemstack);
	}

	@Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        --stack.stackSize;

        if (entityLiving instanceof EntityPlayer)
        {
        	EnumFlapeSyrup flavor = ItemFoods.EnumFlapeSyrup.getValue(stack.getItemDamage());
            this.setHealAmount(flavor.getFoodLevel());
            this.setSaturation(flavor.getFoodSaturation());
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            entityplayer.getFoodStats().addStats(this, stack);
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.entity_player_burp, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.func_188057_b(this));
        }

        return stack;
    }

    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
    	EnumFlapeSyrup flavor = ItemFoods.EnumFlapeSyrup.getValue(stack.getItemDamage());
    	PotionEffect[] potion = flavor.getPotion();
    	if (potion!=null){
    		for (PotionEffect effect:potion){
    			player.addPotionEffect(effect);
    		}
    	}
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
        	subItems.add(new ItemStack(this, 1, syrup.getDamage()));
        }
    }
}
