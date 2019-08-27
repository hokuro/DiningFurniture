package mod.drf.foods.Item;

import mod.drf.config.ConfigValue;
import mod.drf.core.ModCommon;
import mod.drf.core.Mod_DiningFurniture;
import mod.drf.foods.Item.ItemFoods.EnumFlapeSyrup;
import mod.drf.foods.entity.EntityCrashedIce;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceFluidMode;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemCrashedIce extends ItemResetFood {
	//private static final PotionEffect confu = new PotionEffect(MobEffects.NAUSEA,600,1);
	private final EnumFlapeSyrup flavor;
	private final boolean isMillk;

	public ItemCrashedIce(EnumFlapeSyrup syrup) {
		this(syrup,false);
	}

	public ItemCrashedIce(EnumFlapeSyrup syrup, boolean millk) {
		this(syrup.getFoodLevel(),syrup.getFoodSaturation(),false,syrup,millk);
	}

	public ItemCrashedIce(int amount, float saturation, boolean isWolfFood, EnumFlapeSyrup flavorIn, boolean millkIn) {
		super(amount, saturation, isWolfFood,
				(new Item.Properties()).group(Mod_DiningFurniture.tabColdFood));
		setPotionEffect(new PotionEffect(MobEffects.NAUSEA,100,1), 25.0F);
		flavor = flavorIn;
		isMillk = millkIn;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
		ItemStack itemstack = player.getHeldItem(hand);
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
		Vec3d vec3d1 =  vec3.add((double)f7*range, (double)f8*range, (double)f9*range);
		RayTraceResult movingbjectposition = world.rayTraceBlocks(vec3, vec3d1, RayTraceFluidMode.ALWAYS);

		if (movingbjectposition == null){
			// 置くブロックがないのでそのまま食べる
	        if (player.canEat(ConfigValue.crashedice.CanEatAllways()) || ModCommon.isDeveloped)
	        {
	            player.setActiveHand(hand);
	            return new ActionResult(EnumActionResult.SUCCESS, itemstack);
	        }
	        else
	        {
	            return new ActionResult(EnumActionResult.FAIL, itemstack);
	        }
		}else if (movingbjectposition.type == RayTraceResult.Type.BLOCK){
			// アイスを置く
			BlockPos blockpos = movingbjectposition.getBlockPos();
			if (world.isAirBlock(blockpos.add(0,1,0))){
				if (!world.isRemote){
					try{
						EntityCrashedIce ice = new EntityCrashedIce(world, blockpos.add(0,1,0), flavor,isMillk);
						ice.rotationYaw = (MathHelper.floor((double)((player.rotationYaw*4F)/360F)+2.5D)&3)*90;
						world.spawnEntity(ice);
					}catch(Exception e){
					}
				}
				if(!player.isCreative()){
					itemstack.shrink(1);;
				}
			}
		}
		return new ActionResult(EnumActionResult.SUCCESS,itemstack);
	}

	@Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        stack.shrink(1);

        if (entityLiving instanceof EntityPlayer)
        {
        	onEat(stack, worldIn, (EntityPlayer)entityLiving);
        	if (!worldIn.isRemote){
                if (!((EntityPlayer)entityLiving).inventory.addItemStackToInventory(new ItemStack(ItemFoods.item_icefoodbowl,1))){
                	((EntityPlayer)entityLiving).dropItem(new ItemStack(ItemFoods.item_icefoodbowl), false);
                }
        	}
        }

        return stack;
    }

	public static void onEat(ItemStack stack, World worldIn, EntityPlayer player){
		if (stack.getItem() instanceof ItemCrashedIce){
			// 空腹の回復
	    	EnumFlapeSyrup flavor = ((ItemCrashedIce)stack.getItem()).getFlavor();
	    	// フレーバーごとの回復量を設定
	    	ItemCrashedIce eat = (ItemCrashedIce)stack.getItem();
	    	eat.setHealAmount(flavor.getFoodLevel());
	    	eat.setSaturation(flavor.getFoodSaturation());

	    	// 咀嚼
	        EntityPlayer entityplayer = (EntityPlayer)player;
	        entityplayer.getFoodStats().addStats(eat, stack);
	        worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);

	        // 鎮火
	        entityplayer.extinguish();
	        if (eat.isMillk){
	        	// 練乳掛けの場合、ポーション効果を解除
	        	entityplayer.func_195061_cb();
	        }

	        // ポーション効果を付与
	    	PotionEffect[] potion = flavor.getPotion();
	    	if (potion!=null){
	    		for (PotionEffect effect:potion){
	    			entityplayer.addPotionEffect(effect);
	    		}
	    	}
	    	// かき氷での頭痛
	        if (worldIn.rand.nextFloat() < 80.0F)
	        {
	            player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA,600,1));
	        }
		}
	}

    public EnumFlapeSyrup getFlavor() {
    	return flavor;
    }
}