package mod.drf.furniture.dispenser;

import mod.drf.furniture.entity.EntityChairZabuton;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BehaviorZabutonDispense extends BehaviorProjectileDispense
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
		return new EntityChairZabuton(worldIn, position.getX(), position.getY(), position.getZ(), (byte)fitemstack.getItemDamage());
	}
}