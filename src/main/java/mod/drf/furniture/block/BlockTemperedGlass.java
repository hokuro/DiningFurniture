package mod.drf.furniture.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


public class BlockTemperedGlass extends BlockBreakable {

	  public BlockTemperedGlass(Block.Properties property){
	        super(property);
	  }


	  	@Override
	    public int quantityDropped(IBlockState state, Random random)
	    {
	        return 1;
	    }

	    @OnlyIn(Dist.CLIENT)
	    @Override
	    public BlockRenderLayer getRenderLayer()
	    {
	        return BlockRenderLayer.CUTOUT;
	    }

	    @Override
	    public boolean isFullCube(IBlockState state)
	    {
	        return false;
	    }

	    @Override
	    protected boolean canSilkHarvest()
	    {
	        return true;
	    }
}
