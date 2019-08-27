package mod.drf.furniture.block;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockMagicGlass extends Block {

	public BlockMagicGlass(Block.Properties property) {
		super(property);
		// TODO 自動生成されたコンストラクター・スタブ
	}

    @Override
    public boolean canEntitySpawn(IBlockState state, Entity entityIn)
    {
        return false;
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

//    /**
//     * Used to determine ambient occlusion and culling when rebuilding chunks for render
//     */
//    public boolean isOpaqueCube(IBlockState state)
//    {
//        return false;
//    }
}
