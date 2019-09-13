package mod.drf.block;

import net.minecraft.block.Block;
import net.minecraft.block.BreakableBlock;
import net.minecraft.block.IBeaconBeamColorProvider;
import net.minecraft.item.DyeColor;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockTemperedStainedGlass extends BreakableBlock implements IBeaconBeamColorProvider{
	private DyeColor color;

	public BlockTemperedStainedGlass(DyeColor col, Block.Properties property){
		super(property);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public BlockRenderLayer getRenderLayer(){
        return BlockRenderLayer.TRANSLUCENT;
    }

	@Override
	public DyeColor getColor() {
		return color;
	}
}
