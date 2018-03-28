package mod.drf.furniture.block;

import mod.drf.core.Mod_DiningFurniture;
import net.minecraft.block.BlockBeacon;
import net.minecraft.block.BlockPane;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTemperedStainedGlassPanel extends BlockPane {
	  public static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.<EnumDyeColor>create("color", EnumDyeColor.class);

	    public BlockTemperedStainedGlassPanel()
	    {
	        super(Material.GLASS, true);
	        this.setDefaultState(this.blockState.getBaseState().withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false)).withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)).withProperty(COLOR, EnumDyeColor.WHITE));
	        this.setCreativeTab(Mod_DiningFurniture.tabFurniture);
	        this.setSoundType(SoundType.GLASS);
	    }

	    /**
	     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
	     * returns the metadata of the dropped item based on the old metadata of the block.
	     */
	    public int damageDropped(IBlockState state)
	    {
	        return ((EnumDyeColor)state.getValue(COLOR)).getMetadata();
	    }

	    /**
	     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	     */
	    @Override
	    @SideOnly(Side.CLIENT)
	    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	    {
	        for (int i = 0; i < EnumDyeColor.values().length; ++i)
	        {
	        	items.add(new ItemStack(this,1,i));
	        }
	    }

	    /**
	     * Get the MapColor for this Block and the given BlockState
	     */
	    public MapColor getMapColor(IBlockState state)
	    {
	        return MapColor.getBlockColor((EnumDyeColor)state.getValue(COLOR));
	    }

	    @SideOnly(Side.CLIENT)
	    public BlockRenderLayer getBlockLayer()
	    {
	        return BlockRenderLayer.TRANSLUCENT;
	    }

	    /**
	     * Convert the given metadata into a BlockState for this Block
	     */
	    public IBlockState getStateFromMeta(int meta)
	    {
	        return this.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(meta));
	    }

	    /**
	     * Convert the BlockState into the correct metadata value
	     */
	    public int getMetaFromState(IBlockState state)
	    {
	        return ((EnumDyeColor)state.getValue(COLOR)).getMetadata();
	    }

	    protected BlockStateContainer createBlockState()
	    {
	        return new BlockStateContainer(this, new IProperty[] {NORTH, EAST, WEST, SOUTH, COLOR});
	    }

	    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	    {
	        if (!worldIn.isRemote)
	        {
	            BlockBeacon.updateColorAsync(worldIn, pos);
	        }
	    }

	    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	    {
	        if (!worldIn.isRemote)
	        {
	            BlockBeacon.updateColorAsync(worldIn, pos);
	        }
	    }
}
