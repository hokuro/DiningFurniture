package mod.drf.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IBeaconBeamColorProvider;
import net.minecraft.block.PaneBlock;
import net.minecraft.item.DyeColor;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockTemperedStainedGlassPanel extends PaneBlock  implements IBeaconBeamColorProvider{
	  private final DyeColor color;

	  public BlockTemperedStainedGlassPanel(DyeColor col, Block.Properties property){
		  super(property);
		  color = col;
		  this.setDefaultState(this.stateContainer.getBaseState().with(NORTH, Boolean.valueOf(false)).with(EAST, Boolean.valueOf(false)).with(SOUTH, Boolean.valueOf(false)).with(WEST, Boolean.valueOf(false)));
	  }

	  @OnlyIn(Dist.CLIENT)
	  @Override
	  public BlockRenderLayer getRenderLayer(){
		  return BlockRenderLayer.TRANSLUCENT;
	  }

	  @Override
	  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		  super.fillStateContainer(builder);
	  }

	@Override
	public DyeColor getColor() {
		return color;
	}
}
