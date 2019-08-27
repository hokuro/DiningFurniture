package mod.drf.furniture.item;

import mod.drf.furniture.entity.EntityChair;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class ItemChair  extends Item{
	public ItemChair(Item.Properties property){
		super(property);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
		ItemStack itemstack = player.getHeldItem(hand);
		float f = 1.0F;
		float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
		float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
		double d0 = player.prevPosX + (player.posX - player.prevPosX) * (double) f;
		double d1 = (player.prevPosY + (player.posY - player.prevPosY) * (double) f + 1.6200000000000001D) - (double) player.getYOffset();
		double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double) f;
		Vec3d vec3 = new Vec3d(d0, d1, d2);
		float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
		float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
		float f5 = -MathHelper.cos(-f1 * 0.01745329F);
		float f6 = MathHelper.sin(-f1 * 0.01745329F);
		float f7 = f4 * f5;
		float f8 = f6;
		float f9 = f3 * f5;
		double d3 = 5D;
		Vec3d vec3d1 = vec3.add((double) f7 * d3, (double) f8 * d3, (double) f9 * d3);
		RayTraceResult movingobjectposition = world.rayTraceBlocks(vec3, vec3d1);

		if (movingobjectposition == null) {
			return new ActionResult(EnumActionResult.SUCCESS, itemstack);
		}

		if (movingobjectposition.type == RayTraceResult.Type.BLOCK) {
			BlockPos blockpos = movingobjectposition.getBlockPos();
			if (world.isAirBlock(blockpos.add(0, 1, 0))) {
				if (!world.isRemote) {
					try {
						EntityChair chair = this.getEntityChair(world, player, blockpos, itemstack);
						world.spawnEntity(chair);
					} catch (Exception e) {
						System.console().printf("error");
					}

				}
				if (!player.isCreative()) {
					itemstack.shrink(1);;
				}
			}
		}
		return new ActionResult(EnumActionResult.SUCCESS, itemstack);
	}

	public abstract EntityChair getEntityChair(World world, EntityPlayer player, BlockPos blockpos, ItemStack stack);

	public abstract String getChairName();
}
