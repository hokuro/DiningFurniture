package mod.drf.foods.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMill extends BlockContainer {

	protected BlockMill() {
		super(Material.rock);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }


}
