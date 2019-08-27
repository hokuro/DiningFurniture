package mod.drf.foods.block;

import mod.drf.intaractionobject.IntaractionObjectCookingWorkBench;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BlockCookingWorkBench extends BlockHorizontal {

	protected BlockCookingWorkBench(){
		super(Properties.create(Material.WOOD)
				.sound(SoundType.WOOD)
				.hardnessAndResistance(2.5F,0.0F));
		this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, EnumFacing.NORTH));
	}

	@Override
    public IBlockState rotate(IBlockState state, Rotation rot)
    {
        return state.with(HORIZONTAL_FACING, rot.rotate((EnumFacing)state.get(HORIZONTAL_FACING)));
    }

	@Override
	public IBlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }


	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
	   builder.add(HORIZONTAL_FACING);
	}

	@Override
	public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote)
        {
        	NetworkHooks.openGui((EntityPlayerMP)playerIn,
        			new IntaractionObjectCookingWorkBench(pos),
        			(buf)->{
						buf.writeInt(pos.getX());
						buf.writeInt(pos.getY());
						buf.writeInt(pos.getZ());
					});
        	return true;
        }
        return true;
    }




}
