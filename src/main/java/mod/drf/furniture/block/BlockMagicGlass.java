package mod.drf.furniture.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMagicGlass extends Block {

	public BlockMagicGlass(Material materialIn) {
		super(materialIn);
		// TODO 自動生成されたコンストラクター・スタブ
	}

    @Deprecated
    public boolean canEntitySpawn(IBlockState state, Entity entityIn)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

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
