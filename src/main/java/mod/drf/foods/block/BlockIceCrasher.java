package mod.drf.foods.block;

import java.util.List;
import java.util.Random;

import mod.drf.common.block.BlockHorizontalContainer;
import mod.drf.core.ModCommon;
import mod.drf.core.Mod_DiningFurniture;
import mod.drf.foods.tileentity.TileEntityIceCrasher;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockIceCrasher extends BlockHorizontalContainer {
	//public static final PropertyBool ISRUN = PropertyBool.create("isrun");

    // あたり判定
    private static final AxisAlignedBB[] colligeBox =  new AxisAlignedBB[] {
    		new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 1.0D,   1.0D, 0.875D),	// SOUTH
    		new AxisAlignedBB(0.125D, 0.0D, 0.0625D, 0.9375D, 1.0D, 1.0D),	    // WEST
    		new AxisAlignedBB(0.9375D, 0.0D, 0.9375D, 0.0D,   1.0D, 0.125D),	// NORTH
    		new AxisAlignedBB(0.875D, 0.0D, 0.9375D, 0.0625D, 1.0D, 0.0D)		// EAST
    };

    private static final AxisAlignedBB[][] colligBoxeis= {
    		//South
    		{new AxisAlignedBB(0.0625,   0.0D,    0.0625D,  0.1875D,   0.0625D, 0.875D),
        	 new AxisAlignedBB(0.75,     0.0D,    0.0625D,  0.875D,    0.0625D, 0.875D),
        	 new AxisAlignedBB(0.71875D, 0.0625D, 0.0625D,  0.84375D, 0.8125,  0.25D),
        	 new AxisAlignedBB(0.71875D, 0.0625D, 0.6875D,  0.84375D, 0.8125,  0.875D),
        	 new AxisAlignedBB(0.09375D, 0.0625D, 0.0625D,  0.21875D, 0.8125,  0.25D),
        	 new AxisAlignedBB(0.09375D, 0.0625D, 0.6875D,  0.21875D, 0.8125,  0.875D),
        	 new AxisAlignedBB(0.125D,   0.8125D, 0.1875D,  0.8125D,  0.9375D, 0.75D),
        	 new AxisAlignedBB(0.125D,   0.375D,  0.1875D,  0.8125D,  0.9375D, 0.75D),
        	 new AxisAlignedBB(0.9375D,  0.75D,   0.28125D, 1.0D,     0.8125D, 0.34375D),
        	 new AxisAlignedBB(0.875D,   0.5625D, 0.28125D, 0.9375D,  1.0D,    0.71875D)},

    		//West
    		{new AxisAlignedBB(0.125D,   0.0D,     0.0625D,   0.9375D,  0.0625D, 0.1875D),
        	 new AxisAlignedBB(0.125D,   0.0D,     0.75D,     0.9375D,  0.0625D, 0.875D),
        	 new AxisAlignedBB(0.125D,   0.0625D,  0.71875D,  0.3125D,  0.8125D, 0.84375D),
        	 new AxisAlignedBB(0.75D,    0.0625D,  0.71875D,  0.9375D,  0.8125D, 0.84375D),
        	 new AxisAlignedBB(0.125D,   0.0625D,  0.09375D,  0.3125D,  0.8125D, 0.21875D),
        	 new AxisAlignedBB(0.75D,    0.0625D,  0.09375D,  0.9375D,  0.8125D, 0.21875D),
        	 new AxisAlignedBB(0.25D,    0.8125D,  0.125D,    0.8125D,  0.9375D, 0.8125D),
        	 new AxisAlignedBB(0.25D,    0.375D,   0.125D,    0.8125D,  0.9375D, 0.8125D),
         	 new AxisAlignedBB(0.34375D, 0.75D,    0.9375D,   0.40625D, 0.8125D, 1.0D),
        	 new AxisAlignedBB(0.34375D, 0.5625D,  0.875D,    0.78125D, 1.0D,    0.9375D)},

    		//North
    		{new AxisAlignedBB(0.9375D,  0.0D,    0.9375D,  0.8125D,  0.0625D, 0.125D),
         	 new AxisAlignedBB(0.25D,    0.0D,    0.9375D,  0.125D,   0.0625D, 0.125D),
         	 new AxisAlignedBB(0.28125D, 0.0625D, 0.9375D,  0.15625D, 0.8125D, 0.75D),
          	 new AxisAlignedBB(0.28125D, 0.0625D, 0.3125D,  0.15625D, 0.8125D, 0.125D),
         	 new AxisAlignedBB(0.90625D, 0.0625D, 0.9375D,  0.78125D, 0.8125D, 0.75D),
        	 new AxisAlignedBB(0.90625D, 0.0625D, 0.3125D,  0.78125D, 0.8125D, 0.125D),
        	 new AxisAlignedBB(0.875D,   0.8125D, 0.8125D,  0.1875D,  0.9375D, 0.25D),
        	 new AxisAlignedBB(0.875D,   0.375D,  0.8125D,  0.1875D,  0.9375D, 0.25D),
        	 new AxisAlignedBB(0.0625D,  0.75D,   0.71875D, 0.0D,     0.8125D, 0.65625D),
        	 new AxisAlignedBB(0.125D,   0.5625D, 0.71875D, 0.0625D,  1.0D,    0.28125D)},

    		//East
    		{new AxisAlignedBB(0.875D,   0.00D,   0.9375D,  0.0625D,   0.0625D, 0.8125D),
             new AxisAlignedBB(0.875D,   0.0D,    0.25D,    0.0625D,   0.0625D, 0.125D),
             new AxisAlignedBB(0.875D,   0.0625D, 0.28125D, 0.125D,    0.8125D, 0.15625D),
             new AxisAlignedBB(0.25D,    0.0625D, 0.28125D, 0.0625D,   0.8125D, 0.15625D),
             new AxisAlignedBB(0.875D,   0.0625D, 0.90625D, 0.125D,    0.8125D, 0.78125D),
             new AxisAlignedBB(0.25D,    0.0625D, 0.90625D, 0.0625D,   0.8125D, 0.78125D),
             new AxisAlignedBB(0.75D,    0.8125D, 0.875D,   0.1875D,   0.9375D, 0.1875D),
             new AxisAlignedBB(0.75D,    0.375D,  0.875D,   0.1875D,   0.9375D, 0.1875D),
             new AxisAlignedBB(0.65625D, 0.75D,   0.0625D,  0.59375D,  0.8125D, 0.0D),
             new AxisAlignedBB(0.65625D, 0.5625D, 0.125D,   0.21875D,  1.0D,    0.0625D)}
    };

    protected BlockIceCrasher()
    {
        super(Material.GLASS);
		this.setHardness(1.0F);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

	@Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.INVISIBLE;
    }
	@Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

	@Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

	@Override
    public boolean isFullBlock(IBlockState state)
    {
        return false;
    }


	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityIceCrasher(this.getStateFromMeta(meta).getValue(FACING));
	}

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(BlockFoods.block_icecrasher);
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB p_185477_4_, List<AxisAlignedBB> p_185477_5_, Entity p_185477_6, boolean isActualState_)
    {
        state = this.getActualState(state, worldIn, pos);

        for(int lp = 0; lp < colligBoxeis[state.getValue(FACING).getHorizontalIndex()].length; lp++){
        	addCollisionBoxToList(pos, p_185477_4_, p_185477_5_,  colligBoxeis[state.getValue(FACING).getHorizontalIndex()][lp]);
        }
    }

    @Override
    protected AxisAlignedBB getRealBoundingBox(IBlockState state){
    	return colligeBox[state.getValue(FACING).getHorizontalIndex()];
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityIceCrasher)
            {
            	playerIn.openGui(Mod_DiningFurniture.instance, ModCommon.MOD_GUI_ID_ICECRASHER, worldIn, pos.getX(), pos.getY(), pos.getZ());
            }

            return true;
        }
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);

        if (stack.hasDisplayName())
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityIceCrasher)
            {
                ((TileEntityIceCrasher)tileentity).setCustomInventoryName(stack.getDisplayName());
            }
        }
    }

    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof TileEntityIceCrasher)
        {
            InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityIceCrasher)tileentity);
            worldIn.updateComparatorOutputLevel(pos, this);
        }
        super.breakBlock(worldIn, pos, state);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(BlockFoods.block_icecrasher);
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }

	/**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta&0x00FF);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    @Override
	public boolean hasCustomBreakingProgress(IBlockState state){
    	return true;
    }


}
