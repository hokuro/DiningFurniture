package mod.drf.furniture.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBeacon;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockTemperedStainedGlass extends BlockBreakable {
	private EnumDyeColor color;

	public BlockTemperedStainedGlass(EnumDyeColor col, Block.Properties property){
		super(property);
    }



    @OnlyIn(Dist.CLIENT)
    @Override
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }


    @Override
    public int quantityDropped(IBlockState state, Random random)
    {
        return 1;
    }

    @Override
    protected boolean canSilkHarvest()
    {
        return true;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
    	return false;
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
