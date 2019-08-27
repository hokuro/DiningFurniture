package mod.drf.furniture.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBeacon;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockHorizontalStaindGlassPanel extends BlockHorizontalGlassPanel {
	private final EnumDyeColor color;

    public BlockHorizontalStaindGlassPanel(EnumDyeColor col, Block.Properties property)
    {
        super(property);
        color = col;
    }

	protected BlockHorizontalStaindGlassPanel(EnumDyeColor col, Block.Properties property, boolean tmp) {
		this(col, property);
		tempered = tmp;
	}



    @OnlyIn(Dist.CLIENT)
    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }


	@Override
    public int quantityDropped(IBlockState state, Random random)
    {
    	if (this.tempered){
    		return 1;
    	}else{
    		return 0;
    	}
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
    public void onReplaced(IBlockState state, World worldIn, BlockPos pos, IBlockState newState, boolean isMoving)
    {
        if (!worldIn.isRemote)
        {
            BlockBeacon.updateColorAsync(worldIn, pos);
        }
    }
}
