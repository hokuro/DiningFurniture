package mod.drf.furniture.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBeacon;
import net.minecraft.block.BlockPane;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockTemperedStainedGlassPanel extends BlockPane {
	  private final EnumDyeColor color;

	    public BlockTemperedStainedGlassPanel(EnumDyeColor col, Block.Properties property)
	    {
	        super(property);
	        color = col;
	        this.setDefaultState(this.stateContainer.getBaseState().with(NORTH, Boolean.valueOf(false)).with(EAST, Boolean.valueOf(false)).with(SOUTH, Boolean.valueOf(false)).with(WEST, Boolean.valueOf(false)));
	    }


	    @OnlyIn(Dist.CLIENT)
	    @Override
	    public BlockRenderLayer getRenderLayer()
	    {
	        return BlockRenderLayer.TRANSLUCENT;
	    }


		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
			super.fillStateContainer(builder);
		}


	    @Override
	    public void onBlockAdded(IBlockState state, World worldIn, BlockPos pos, IBlockState oldState) {
	        if (!worldIn.isRemote)
	        {
	            BlockBeacon.updateColorAsync(worldIn, pos);
	        }
	    }

	    @Override
	    public void onReplaced(IBlockState state, World worldIn, BlockPos pos, IBlockState newState, boolean isMoving) {
	        if (state.getBlock() != newState.getBlock()) {
	           if (!worldIn.isRemote) {
	              BlockBeacon.updateColorAsync(worldIn, pos);
	           }

	        }
	     }
}
