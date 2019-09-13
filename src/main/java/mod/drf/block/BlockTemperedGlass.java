package mod.drf.block;

import net.minecraft.block.Block;
import net.minecraft.block.BreakableBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


public class BlockTemperedGlass extends BreakableBlock {

	  public BlockTemperedGlass(Block.Properties property){
	        super(property);
	  }

	  @OnlyIn(Dist.CLIENT)
	  @Override
	  public BlockRenderLayer getRenderLayer(){
		  return BlockRenderLayer.CUTOUT;
	  }
}
