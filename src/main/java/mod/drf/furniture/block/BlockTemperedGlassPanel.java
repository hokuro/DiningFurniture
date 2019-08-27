package mod.drf.furniture.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.state.IBlockState;
import net.minecraft.state.StateContainer;

public class BlockTemperedGlassPanel extends BlockPane {
	/**
	 * コンストラクタ
	 * @param materialIn マテリアル
	 */
	public BlockTemperedGlassPanel(Block.Properties property){
		super(property);
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
		super.fillStateContainer(builder);
	}
}
