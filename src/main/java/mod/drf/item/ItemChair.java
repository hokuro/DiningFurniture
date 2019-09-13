package mod.drf.item;

import java.util.function.Predicate;

import mod.drf.entity.EntityChair;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public abstract class ItemChair  extends Item{
	private static final Predicate<Entity> field_219989_a = EntityPredicates.NOT_SPECTATING.and(Entity::canBeCollidedWith);
	public ItemChair(Item.Properties property){
		super(property);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand){
		ItemStack itemstack = player.getHeldItem(hand);
		RayTraceResult raytraceresult = rayTrace(world, player, RayTraceContext.FluidMode.ANY);
		if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
			// アイスを置く
			BlockPos blockpos = new BlockPos(raytraceresult.getHitVec().x,raytraceresult.getHitVec().y,raytraceresult.getHitVec().z);
			if (world.isAirBlock(blockpos.add(0,1,0))){
				if (!world.isRemote){
					try{
						EntityChair chair = this.getEntityChair(world, player, blockpos, itemstack);
						chair.rotationYaw = (MathHelper.floor((double)((player.rotationYaw*4F)/360F)+2.5D)&3)*90;
						world.addEntity(chair);
					}catch(Exception e){
					}
				}
				if(!player.isCreative()){
					itemstack.shrink(1);
				}
			}
			return new ActionResult<ItemStack>(ActionResultType.SUCCESS,itemstack);
		}
		return new ActionResult<ItemStack>(ActionResultType.PASS,itemstack);
	}

	public abstract EntityChair getEntityChair(World world, PlayerEntity player, BlockPos blockpos, ItemStack stack);
	public abstract String getChairName();
}
