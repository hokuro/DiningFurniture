package mod.drf.foods.block;

import mod.drf.common.block.BlockHorizontalContainer;
import mod.drf.foods.tileentity.TileEntityIceCrasher;
import mod.drf.intaractionobject.InteractionObjectIceCrasher;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BlockIceCrasher extends BlockHorizontalContainer {
	//public static final PropertyBool ISRUN = PropertyBool.create("isrun");

	protected VoxelShape bBox = Block.makeCuboidShape(0.25D,    0.25D, 0.25D,    0.75D,    0.75D, 0.75D);
	protected static final VoxelShape[][] colligBoxeis = new VoxelShape[][] {
			//South
			 {Block.makeCuboidShape(1,0,1,3,1,14),
			  Block.makeCuboidShape(12,0,1,14,1,14),
			  Block.makeCuboidShape(11.5,1,1,13.5,13,4),
			  Block.makeCuboidShape(11.5,1,11,13.5,13,14),
			  Block.makeCuboidShape(1.5,1,1,3.5,13,4),
			  Block.makeCuboidShape(1.5,1,11,3.5,13,14),
			  Block.makeCuboidShape(2,13,3,13,15,12),
			  Block.makeCuboidShape(2,6,3,13,15,12),
			  Block.makeCuboidShape(15,12,4.5,16,13,5.5),
			  Block.makeCuboidShape(14,9,4.5,15,16,11.5)},

			 //West
			 {Block.makeCuboidShape(2,0,1,15,1,3),
			  Block.makeCuboidShape(2,0,12,15,1,14),
			  Block.makeCuboidShape(2,1,11.5,5,13,13.5),
			  Block.makeCuboidShape(12,1,11.5,15,13,13.5),
			  Block.makeCuboidShape(2,1,1.5,5,13,3.5),
			  Block.makeCuboidShape(12,1,1.5,15,13,3.5),
			  Block.makeCuboidShape(4,13,2,13,15,13),
			  Block.makeCuboidShape(4,6,2,13,15,13),
			  Block.makeCuboidShape(5.5,12,15,6.5,13,16),
			  Block.makeCuboidShape(5.5,9,14,12.5,16,15)},

			 //North
			 {Block.makeCuboidShape(15,0,15,13,1,2),
			  Block.makeCuboidShape(4,0,15,2,1,2),
			  Block.makeCuboidShape(4.5,1,15,2.5,13,12),
			  Block.makeCuboidShape(4.5,1,5,2.5,13,2),
			  Block.makeCuboidShape(14.5,1,15,12.5,13,12),
			  Block.makeCuboidShape(14.5,1,5,12.5,13,2),
			  Block.makeCuboidShape(14,13,13,3,15,4),
			  Block.makeCuboidShape(14,6,13,3,15,4),
			  Block.makeCuboidShape(1,12,11.5,0,13,10.5),
			  Block.makeCuboidShape(2,9,11.5,1,16,4.5)},

			 //East
			 {Block.makeCuboidShape(14,0,15,1,1,13),
			  Block.makeCuboidShape(14,0,4,1,1,2),
			  Block.makeCuboidShape(14,1,4.5,2,13,2.5),
			  Block.makeCuboidShape(4,1,4.5,1,13,2.5),
			  Block.makeCuboidShape(14,1,14.5,2,13,12.5),
			  Block.makeCuboidShape(4,1,14.5,1,13,12.5),
			  Block.makeCuboidShape(12,13,14,3,15,3),
			  Block.makeCuboidShape(12,6,14,3,15,3),
			  Block.makeCuboidShape(10.5,12,1,9.5,13,0),
			  Block.makeCuboidShape(10.5,9,2,3.5,16,1)}
	};
    // あたり判定
    private static final AxisAlignedBB[] colligeBox =  new AxisAlignedBB[] {
    		new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 1.0D,   1.0D, 0.875D),	// SOUTH
    		new AxisAlignedBB(0.125D, 0.0D, 0.0625D, 0.9375D, 1.0D, 1.0D),	    // WEST
    		new AxisAlignedBB(0.9375D, 0.0D, 0.9375D, 0.0D,   1.0D, 0.125D),	// NORTH
    		new AxisAlignedBB(0.875D, 0.0D, 0.9375D, 0.0625D, 1.0D, 0.0D)		// EAST
    };

//    private static final AxisAlignedBB[][] colligBoxeis= {
//    		//South
//    		{new AxisAlignedBB(0.0625,   0.0D,    0.0625D,  0.1875D,   0.0625D, 0.875D),
//        	 new AxisAlignedBB(0.75,     0.0D,    0.0625D,  0.875D,    0.0625D, 0.875D),
//        	 new AxisAlignedBB(0.71875D, 0.0625D, 0.0625D,  0.84375D, 0.8125,  0.25D),
//        	 new AxisAlignedBB(0.71875D, 0.0625D, 0.6875D,  0.84375D, 0.8125,  0.875D),
//        	 new AxisAlignedBB(0.09375D, 0.0625D, 0.0625D,  0.21875D, 0.8125,  0.25D),
//        	 new AxisAlignedBB(0.09375D, 0.0625D, 0.6875D,  0.21875D, 0.8125,  0.875D),
//        	 new AxisAlignedBB(0.125D,   0.8125D, 0.1875D,  0.8125D,  0.9375D, 0.75D),
//        	 new AxisAlignedBB(0.125D,   0.375D,  0.1875D,  0.8125D,  0.9375D, 0.75D),
//        	 new AxisAlignedBB(0.9375D,  0.75D,   0.28125D, 1.0D,     0.8125D, 0.34375D),
//        	 new AxisAlignedBB(0.875D,   0.5625D, 0.28125D, 0.9375D,  1.0D,    0.71875D)},
//
//    		//West
//    		{new AxisAlignedBB(0.125D,   0.0D,     0.0625D,   0.9375D,  0.0625D, 0.1875D),
//        	 new AxisAlignedBB(0.125D,   0.0D,     0.75D,     0.9375D,  0.0625D, 0.875D),
//        	 new AxisAlignedBB(0.125D,   0.0625D,  0.71875D,  0.3125D,  0.8125D, 0.84375D),
//        	 new AxisAlignedBB(0.75D,    0.0625D,  0.71875D,  0.9375D,  0.8125D, 0.84375D),
//        	 new AxisAlignedBB(0.125D,   0.0625D,  0.09375D,  0.3125D,  0.8125D, 0.21875D),
//        	 new AxisAlignedBB(0.75D,    0.0625D,  0.09375D,  0.9375D,  0.8125D, 0.21875D),
//        	 new AxisAlignedBB(0.25D,    0.8125D,  0.125D,    0.8125D,  0.9375D, 0.8125D),
//        	 new AxisAlignedBB(0.25D,    0.375D,   0.125D,    0.8125D,  0.9375D, 0.8125D),
//         	 new AxisAlignedBB(0.34375D, 0.75D,    0.9375D,   0.40625D, 0.8125D, 1.0D),
//        	 new AxisAlignedBB(0.34375D, 0.5625D,  0.875D,    0.78125D, 1.0D,    0.9375D)},
//
//    		//North
//    		{new AxisAlignedBB(0.9375D,  0.0D,    0.9375D,  0.8125D,  0.0625D, 0.125D),
//         	 new AxisAlignedBB(0.25D,    0.0D,    0.9375D,  0.125D,   0.0625D, 0.125D),
//         	 new AxisAlignedBB(0.28125D, 0.0625D, 0.9375D,  0.15625D, 0.8125D, 0.75D),
//          	 new AxisAlignedBB(0.28125D, 0.0625D, 0.3125D,  0.15625D, 0.8125D, 0.125D),
//         	 new AxisAlignedBB(0.90625D, 0.0625D, 0.9375D,  0.78125D, 0.8125D, 0.75D),
//        	 new AxisAlignedBB(0.90625D, 0.0625D, 0.3125D,  0.78125D, 0.8125D, 0.125D),
//        	 new AxisAlignedBB(0.875D,   0.8125D, 0.8125D,  0.1875D,  0.9375D, 0.25D),
//        	 new AxisAlignedBB(0.875D,   0.375D,  0.8125D,  0.1875D,  0.9375D, 0.25D),
//        	 new AxisAlignedBB(0.0625D,  0.75D,   0.71875D, 0.0D,     0.8125D, 0.65625D),
//        	 new AxisAlignedBB(0.125D,   0.5625D, 0.71875D, 0.0625D,  1.0D,    0.28125D)},
//
//    		//East
//    		{new AxisAlignedBB(0.875D,   0.00D,   0.9375D,  0.0625D,   0.0625D, 0.8125D),
//             new AxisAlignedBB(0.875D,   0.0D,    0.25D,    0.0625D,   0.0625D, 0.125D),
//             new AxisAlignedBB(0.875D,   0.0625D, 0.28125D, 0.125D,    0.8125D, 0.15625D),
//             new AxisAlignedBB(0.25D,    0.0625D, 0.28125D, 0.0625D,   0.8125D, 0.15625D),
//             new AxisAlignedBB(0.875D,   0.0625D, 0.90625D, 0.125D,    0.8125D, 0.78125D),
//             new AxisAlignedBB(0.25D,    0.0625D, 0.90625D, 0.0625D,   0.8125D, 0.78125D),
//             new AxisAlignedBB(0.75D,    0.8125D, 0.875D,   0.1875D,   0.9375D, 0.1875D),
//             new AxisAlignedBB(0.75D,    0.375D,  0.875D,   0.1875D,   0.9375D, 0.1875D),
//             new AxisAlignedBB(0.65625D, 0.75D,   0.0625D,  0.59375D,  0.8125D, 0.0D),
//             new AxisAlignedBB(0.65625D, 0.5625D, 0.125D,   0.21875D,  1.0D,    0.0625D)}
//    };

    protected BlockIceCrasher()
    {
        super(Block.Properties.create(Material.GRASS)
        		.hardnessAndResistance(1.0F,99.0F)
        		.sound(SoundType.METAL));
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, EnumFacing.NORTH));
    }

	@Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.INVISIBLE;
    }

	@Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

	@Override
	public TileEntity createNewTileEntity(IBlockReader world) {
		return createTileEntity(null,world);
	}
	@Override
	public TileEntity createTileEntity(IBlockState state, IBlockReader world) {
		return new TileEntityIceCrasher();
	}


    @Override
    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
        return Item.getItemFromBlock(BlockFoods.block_icecrasher);
    }

//    @Override
//    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB p_185477_4_, List<AxisAlignedBB> p_185477_5_, Entity p_185477_6, boolean isActualState_)
//    {
//        state = this.getActualState(state, worldIn, pos);
//
//        for(int lp = 0; lp < colligBoxeis[state.getValue(FACING).getHorizontalIndex()].length; lp++){
//        	addCollisionBoxToList(pos, p_185477_4_, p_185477_5_,  colligBoxeis[state.getValue(FACING).getHorizontalIndex()][lp]);
//        }
//    }

    @Override
	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos){
    	VoxelShape sh = Block.makeCuboidShape(0,0,0,0,0,0);
    	int idx = ((EnumFacing)state.getValues().get(FACING)).getHorizontalIndex();
        for(int lp = 0; lp < colligBoxeis[idx].length; lp++){
        	sh = VoxelShapes.or(sh, colligBoxeis[idx][lp]);
        }
	    return sh;
	}

    @Override
    protected AxisAlignedBB getRealBoundingBox(IBlockState state){
    	return colligeBox[((EnumFacing)state.getValues().get(FACING)).getHorizontalIndex()];
    }

    @Override
    public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityIceCrasher)
            {
            	NetworkHooks.openGui((EntityPlayerMP)playerIn,
        			new InteractionObjectIceCrasher(pos),
        			(buf)->{
						buf.writeInt(pos.getX());
						buf.writeInt(pos.getY());
						buf.writeInt(pos.getZ());
					});
            	//playerIn.openGui(Mod_DiningFurniture.instance, ModCommon.MOD_GUI_ID_ICECRASHER, worldIn, pos.getX(), pos.getY(), pos.getZ());
            }

            return true;
        }
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.with(FACING, placer.getHorizontalFacing().getOpposite()), 2);

        if (stack.hasDisplayName())
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityIceCrasher)
            {
                ((TileEntityIceCrasher)tileentity).setCustomInventoryName(stack.getDisplayName().getFormattedText());
            }
        }
    }

    @Override
    public void onReplaced(IBlockState state, World worldIn, BlockPos pos, IBlockState newState, boolean isMoving) {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof TileEntityIceCrasher)
        {
            InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityIceCrasher)tileentity);
            worldIn.updateComparatorOutputLevel(pos, this);
        }
        super.onReplaced(state,worldIn, pos, newState, isMoving);
    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(BlockFoods.block_icecrasher);
    }

    @Override
	public boolean hasCustomBreakingProgress(IBlockState state){
    	return true;
    }


}
