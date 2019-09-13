package mod.drf.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IBeaconBeamColorProvider;
import net.minecraft.item.DyeColor;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockHorizontalStaindGlassPanel extends BlockHorizontalGlassPanel implements IBeaconBeamColorProvider{
	private final DyeColor color;

    public BlockHorizontalStaindGlassPanel(DyeColor col, Block.Properties property)
    {
        super(property);
        color = col;
    }

	protected BlockHorizontalStaindGlassPanel(DyeColor col, Block.Properties property, boolean tmp) {
		this(col, property);
		tempered = tmp;
	}

    @OnlyIn(Dist.CLIENT)
    @Override
    public BlockRenderLayer getRenderLayer() {
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
