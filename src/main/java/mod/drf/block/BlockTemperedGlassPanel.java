package mod.drf.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.state.StateContainer;

public class BlockTemperedGlassPanel extends PaneBlock {
	/**
	 * コンストラクタ
	 * @param materialIn マテリアル
	 */
	public BlockTemperedGlassPanel(Block.Properties property){
		super(property);
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
	}
}
