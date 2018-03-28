package mod.drf.furniture.block;

import java.util.Random;

import mod.drf.core.Mod_DiningFurniture;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BlockTemperedGlass extends BlockBreakable {

	  public BlockTemperedGlass(Material materialIn){
	        super(materialIn, true);
	        this.setCreativeTab(Mod_DiningFurniture.tabFurniture);
	  }

	  public BlockTemperedGlass(Material materialIn, boolean ignoreSimilarity)
	    {
	        super(materialIn, ignoreSimilarity);
	        this.setCreativeTab(Mod_DiningFurniture.tabFurniture);
	    }

	    /**
	     * Returns the quantity of items to drop on block destruction.
	     */
	    public int quantityDropped(Random random)
	    {
	        return 1;
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

	    protected boolean canSilkHarvest()
	    {
	        return true;
	    }
}
