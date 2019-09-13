package mod.drf.dispenser;

import mod.drf.item.ItemChair;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BehaviorZabutonDispense extends ProjectileDispenseBehavior
{
	protected ItemStack fitemstack;

	@Override
	public ItemStack dispenseStack(IBlockSource par1iBlockSource, ItemStack par2ItemStack) {
		// 色を識別するためにItemStackを確保
		fitemstack = par2ItemStack;
		return super.dispenseStack(par1iBlockSource, par2ItemStack);
	}

	@Override
	protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stack) {
		if ( stack.getItem() instanceof ItemChair){
			return (((ItemChair)stack.getItem()).getEntityChair(worldIn, null, new BlockPos(position.getX(),position.getY(),position.getZ()),stack));
		}
		return null;
	}
}