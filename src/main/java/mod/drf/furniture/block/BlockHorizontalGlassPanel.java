package mod.drf.furniture.block;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockHorizontalGlassPanel extends BlockPane {
	   public static final EnumProperty<SlabType> HALF =  BlockStateProperties.SLAB_TYPE;
	   protected boolean tempered;

		protected BlockHorizontalGlassPanel(Block.Properties property) {
			super(property);
	        this.setDefaultState(
	        		this.stateContainer.getBaseState()
	        		.with(NORTH, Boolean.valueOf(false))
	        		.with(EAST, Boolean.valueOf(false))
	        		.with(SOUTH, Boolean.valueOf(false))
	        		.with(WEST, Boolean.valueOf(false))
	        		.with(HALF, SlabType.BOTTOM)
	        		.with(WATERLOGGED,false));
	        tempered = false;
		}

		protected BlockHorizontalGlassPanel(Block.Properties property,boolean tmp) {
			this(property);
			tempered = tmp;
		}


		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
			super.fillStateContainer(builder);
			builder.add(HALF);
		}

	    private static final String DOWN_NORTH="down_north";
	    private static final String DOWN_SOUTH="down_south";
	    private static final String DOWN_EAST="down_east";
	    private static final String DOWN_WEST="down_west";
	    private static final String DOWN_NORTH_EAST="down_north_east";
	    private static final String DOWN_NORTH_WEST="down_north_west";
	    private static final String DOWN_NORTH_SOUTH="down_north_south";
	    private static final String DOWN_SOUTH_EAST="down_south_east";
	    private static final String DOWN_SOUTH_WEST="down_south_west";
	    private static final String DOWN_EAST_WEST="down_east_west";
	    private static final String DOWN_ALL="down_all";
	    private static final String UP_NORTH="up_north";
	    private static final String UP_SOUTH="up_south";
	    private static final String UP_EAST="up_east";
	    private static final String UP_WEST="up_west";
	    private static final String UP_NORTH_EAST="up_north_east";
	    private static final String UP_NORTH_WEST="up_north_west";
	    private static final String UP_NORTH_SOUTH="up_north_south";
	    private static final String UP_SOUTH_EAST="up_south_east";
	    private static final String UP_SOUTH_WEST="up_south_west";
	    private static final String UP_EAST_WEST="up_east_west";
	    private static final String UP_ALL="up_all";


	    private static final Map<String,Integer> direction = new HashMap<String,Integer>(){
	    	{put(DOWN_NORTH,1);}
	    	{put(DOWN_SOUTH,2);}
	    	{put(DOWN_EAST,3);}
	    	{put(DOWN_WEST,4);}
	    	{put(DOWN_NORTH_EAST,5);}
	    	{put(DOWN_NORTH_WEST,6);}
	    	{put(DOWN_NORTH_SOUTH,7);}
	    	{put(DOWN_SOUTH_EAST,8);}
	    	{put(DOWN_SOUTH_WEST,9);}
	    	{put(DOWN_EAST_WEST,10);}
	    	{put(DOWN_ALL,11);}
	    	{put(UP_NORTH,12);}
	    	{put(UP_SOUTH,13);}
	    	{put(UP_EAST,14);}
	    	{put(UP_WEST,15);}
	    	{put(UP_NORTH_EAST,16);}
	    	{put(UP_NORTH_WEST,17);}
	    	{put(UP_NORTH_SOUTH,18);}
	    	{put(UP_SOUTH_EAST,19);}
	    	{put(UP_SOUTH_WEST,20);}
	    	{put(UP_EAST_WEST,21);}
	    	{put(UP_ALL,22);}
	    };

//	    protected static final AxisAlignedBB[] collideBoxes = new AxisAlignedBB[] {
//	    		new AxisAlignedBB(0.4375D, 0.0D, 0.4375D, 0.5625D, 0.1250D, 0.5625D),  // normal_down
//	    		new AxisAlignedBB(0.0D,    0.0D, 0.0D,    1.0D,    0.1250D, 0.5625D),  // north_down
//	    		new AxisAlignedBB(0.0D,    0.0D, 0.4375D, 1.0D,    0.1250D, 1.0D),     // south_down
//	    		new AxisAlignedBB(0.4375D, 0.0D, 0.0D,    1.0D,    0.1250D, 1.0D),     // east_down
//	    		new AxisAlignedBB(0.0D,    0.0D, 0.0D,    0.5625D, 0.1250D, 1.0D),     // west_down
//	    		new AxisAlignedBB(0.4375D, 0.0D, 0.0D,    1.0,     0.1250D, 0.5625D ), // north-east_down
//	    		new AxisAlignedBB(0.0D,    0.0D, 0.0D,    0.5625D, 0.1250D, 0.5625D),  // north-west_down
//	    		new AxisAlignedBB(0.4375D, 0.0D, 0.0D,    0.5625D, 0.1250D, 1.0D),     // north-south_down
//	    		new AxisAlignedBB(0.4375D, 0.0D, 0.4375D, 1.0D,    0.1250D, 1.0D),     // south-east_down
//	    		new AxisAlignedBB(0.0D,    0.0D, 0.4375D, 0.5625D, 0.1250D, 1.0D),     // south-west_down
//	    		new AxisAlignedBB(0.0D,    0.0D, 0.4375D, 1.0D,    0.1250D, 0.5625D),  // east-west_down
//	    		new AxisAlignedBB(0.0D,    0.0D, 0.0D,    1.0D,    0.1250D, 1.0D),     // allDirect_down
//	    		new AxisAlignedBB(0.0D,    0.8750D, 0.0D,    1.0D,    1.0D, 0.5625D),  // north_up
//	    		new AxisAlignedBB(0.0D,    0.8750D, 0.4375D, 1.0D,    1.0D, 1.0D),     // south_up
//	    		new AxisAlignedBB(0.4375D, 0.8750D, 0.0D,    1.0D,    1.0D, 1.0D),     // east_up
//	    		new AxisAlignedBB(0.0D,    0.8750D, 0.0D,    0.5625D, 1.0D, 1.0D),     // west_up
//	    		new AxisAlignedBB(0.4375D, 0.8750D, 0.0D,    1.0,     1.0D, 0.5625D ), // north-east_up
//	    		new AxisAlignedBB(0.0D,    0.8750D, 0.0D,    0.5625D, 1.0D, 0.5625D),  // north-west_up
//	    		new AxisAlignedBB(0.4375D, 0.8750D, 0.0D,    0.5625D, 1.0D, 1.0D),     // north-south_up
//	    		new AxisAlignedBB(0.4375D, 0.8750D, 0.4375D, 1.0D,    1.0D, 1.0D),     // south-east_up
//	    		new AxisAlignedBB(0.0D,    0.8750D, 0.4375D, 0.5625D, 1.0D, 1.0D),     // south-west_up
//	    		new AxisAlignedBB(0.0D,    0.8750D, 0.4375D, 1.0D,    1.0D, 0.5625D),  // east-west_up
//	    		new AxisAlignedBB(0.0D,    0.8750D, 0.0D,    1.0D,    1.0D, 1.0D)      // allDirect_up
//
//	    };
	    protected static final VoxelShape[] collideBoxes = new VoxelShape[] {
		    Block.makeCuboidShape(7D,  0D, 7D,  9D,  2D,  9D),  // normal_down
		    Block.makeCuboidShape(0D,  0D, 0D, 16D,  2D,  9D),  // north_down
		    Block.makeCuboidShape(0D,  0D, 7D, 16D,  2D, 16D),  // south_down
		    Block.makeCuboidShape(7D,  0D, 0D, 16D,  2D, 16D),  // east_down
		    Block.makeCuboidShape(0D,  0D, 0D,  9D,  2D, 16D),  // west_down
		    Block.makeCuboidShape(7D,  0D, 0D, 16D,  2D,  9D),  // north-east_down
		    Block.makeCuboidShape(0D,  0D, 0D,  9D,  2D,  9D),  // north-west_down
		    Block.makeCuboidShape(7D,  0D, 0D,  9D,  2D, 16D),  // north-south_down
		    Block.makeCuboidShape(7D,  0D, 7D, 16D,  2D, 16D),  // south-east_down
		    Block.makeCuboidShape(0D,  0D, 7D,  9D,  2D, 16D),  // south-west_down
		    Block.makeCuboidShape(0D,  0D, 7D, 16D,  2D,  9D),  // east-west_down
		    Block.makeCuboidShape(0D,  0D, 0D, 16D,  2D, 16D),  // allDirect_down
		    Block.makeCuboidShape(0D, 14D, 0D, 16D, 16D,  9D),  // north_up
		    Block.makeCuboidShape(0D, 14D, 7D, 16D, 16D, 16D),  // south_up
		    Block.makeCuboidShape(7D, 14D, 0D, 16D, 16D, 16D),  // east_up
		    Block.makeCuboidShape(0D, 14D, 0D,  9D, 16D, 16D),  // west_up
		    Block.makeCuboidShape(7D, 14D, 0D, 16D, 16D,  9D),  // north-east_up
		    Block.makeCuboidShape(0D, 14D, 0D,  9D, 16D,  9D),  // north-west_up
		    Block.makeCuboidShape(7D, 14D, 0D,  9D, 16D, 16D),  // north-south_up
		    Block.makeCuboidShape(7D, 14D, 7D, 16D, 16D, 16D),  // south-east_up
		    Block.makeCuboidShape(0D, 14D, 7D,  9D, 16D, 16D),  // south-west_up
		    Block.makeCuboidShape(0D, 14D, 7D, 16D, 16D,  9D),  // east-west_up
		    Block.makeCuboidShape(0D, 14D, 0D, 16D, 16D, 16D)   // allDirect_up
	    };

	    private IBlockState _state;
	    public boolean North(){
	    	return (Boolean)_state.get(NORTH).booleanValue();
	    }
	    public boolean South(){
	    	return (Boolean)_state.get(SOUTH).booleanValue();
	    }
	    public boolean West(){
	    	return (Boolean)_state.get(WEST).booleanValue();
	    }
	    public boolean East(){
	    	return (Boolean)_state.get(EAST).booleanValue();
	    }
	    public boolean Half(){
	    	return _state.get(HALF) == SlabType.BOTTOM;
	    }

//	    @Override
//	    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB p_185477_4_, List<AxisAlignedBB> p_185477_5_, Entity p_185477_6_, boolean isActualState)
//	    {
//	        addCollisionBoxToList(pos, p_185477_4_, p_185477_5_, collideBoxes[getBoundingBoxIndex(state)]);
//	    }


		@Override
		public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos)
		{
			return collideBoxes[getBoundingBoxIndex(state)];
//			VoxelShape sh1 = field_185730_f[0];
//			VoxelShape sh2 = Block.makeCuboidShape(0, 0, 0, 0, 0, 0);
//		    if (this.shouldConnectTo(worldIn.getBlockState(pos.add(0,1,0)))){
//		    	// UP
//		    	sh1 = VoxelShapes.or(sh1,field_185730_f[2]);
//		    }
//		    if (this.shouldConnectTo(worldIn.getBlockState(pos.add(0,-1,0)))){
//		    	// DOWN
//		    	sh1 = VoxelShapes.or(sh1,field_185730_f[1]);
//		    }
//		    if (this.shouldConnectTo(worldIn.getBlockState(pos.add(0,0,1)))){
//		    	// NORTH
//		    	sh1 =VoxelShapes.or(sh1,field_185730_f[3]);
//		    }
//		    if (this.shouldConnectTo(worldIn.getBlockState(pos.add(0,0,-1)))){
//		    	// SOUTH
//		    	sh1 = VoxelShapes.or(sh1,field_185730_f[4]);
//		    }
//		    if (this.shouldConnectTo(worldIn.getBlockState(pos.add(-1,0,0)))){
//		    	// WEST
//		    	sh1 = VoxelShapes.or(sh1,field_185730_f[5]);
//		    }
//		    if (this.shouldConnectTo(worldIn.getBlockState(pos.add(1,0,0)))){
//		    	// EASHT
//		    	sh2 = VoxelShapes.or(sh1,field_185730_f[6]);
//		    }
//		    return sh1;

		}

//	    @Override
//	    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
//	    {
//	        return state.with(NORTH, canPaneConnectTo(worldIn, pos, EnumFacing.NORTH, state.get(HALF)))
//	                .with(SOUTH, canPaneConnectTo(worldIn, pos, EnumFacing.SOUTH, state.get(HALF)))
//	                .with(WEST, canPaneConnectTo(worldIn, pos, EnumFacing.WEST, state.get(HALF)))
//	                .with(EAST, canPaneConnectTo(worldIn, pos, EnumFacing.EAST, state.get(HALF)))
//	                .with(HALF, canPaneConnectToVertical(worldIn, pos, state));
//	    }

//	    public boolean canPaneConnectTo(IBlockAccess world, BlockPos pos, EnumFacing dir, BlockSlab.EnumBlockHalf half)
//	    {
//	        BlockPos other = pos.offset(dir);
//	        IBlockState state = world.getBlockState(other);
//	        if ((state.getBlock().canBeConnectedTo(world, other, dir.getOpposite()) || attachesTo(world, state, other, dir.getOpposite()))){
//	        	return !state.getProperties().containsKey(HALF) || (state.getProperties().containsKey(HALF) && state.getValue(HALF) == half);
//	        }
//	        return false;
//	    }

//	    private EnumBlockHalf canPaneConnectToVertical(IBlockAccess world, BlockPos pos, IBlockState state) {
//	        return state.getValue(HALF);
//		}

		private int getBoundingBoxIndex(IBlockState state)
	    {
	        _state = state;
	        int i = 0;
	        if (Half()){
	            if (North() && South() && !East() && !West()){
	            	i = direction.get(DOWN_NORTH_SOUTH);
	            }else if (North() && !South() && East() && !West()){
	            	i = direction.get(DOWN_NORTH_EAST);
	            }else if (North() && !South() && !East() && West()){
	            	i = direction.get(DOWN_NORTH_WEST);
	            }else if (!North() && South() && East() && !West()){
	            	i = direction.get(DOWN_SOUTH_EAST);
	            }else if (!North() && South() && !East() && West()){
	            	i = direction.get(DOWN_SOUTH_WEST);
	            }else if (!North() && !South() && East() && West()){
	            	i = direction.get(DOWN_EAST_WEST);
	            }else if ((West() && !East())){
	            	i = direction.get(DOWN_WEST);
	            }else if (East() && !West()){
	            	i = direction.get(DOWN_EAST);
	            }else if (South() && !North()){
	            	i = direction.get(DOWN_SOUTH);
	            }else if (North() && !South()){
	            	i = direction.get(DOWN_NORTH);
	            }else{
	            	i = direction.get(DOWN_ALL);
	            }
	        }else{
	            if (North() && South() && !East() && !West()){
	            	i = direction.get(UP_NORTH_SOUTH);
	            }else if (North() && !South() && East() && !West()){
	            	i = direction.get(UP_NORTH_EAST);
	            }else if (North() && !South() && !East() && West()){
	            	i = direction.get(UP_NORTH_WEST);
	            }else if (!North() && South() && East() && !West()){
	            	i = direction.get(UP_SOUTH_EAST);
	            }else if (!North() && South() && !East() && West()){
	            	i = direction.get(UP_SOUTH_WEST);
	            }else if (!North() && !South() && East() && West()){
	            	i = direction.get(UP_EAST_WEST);
	            }else if ((West() && !East())){
	            	i = direction.get(UP_WEST);
	            }else if (East() && !West()){
	            	i = direction.get(UP_EAST);
	            }else if (South() && !North()){
	            	i = direction.get(UP_SOUTH);
	            }else if (North() && !South()){
	            	i = direction.get(UP_NORTH);
	            }else{
	            	i = direction.get(UP_ALL);
	            }
	        }
	        return i;
	    }

	    /**
	     * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
	     * IBlockstate
	     */
		@Override
		public IBlockState getStateForPlacement(BlockItemUseContext context) {
			IBlockState iblockstate = this.getDefaultState();
			iblockstate = this.isDouble() ? iblockstate : (context.getFace() != EnumFacing.DOWN && (context.getFace() == EnumFacing.UP || (double)context.getHitY() <= 0.5D) ? iblockstate.with(HALF, SlabType.BOTTOM) : iblockstate.with(HALF, SlabType.TOP));
			if (context.getWorld().getBlockState(context.getPos().east()).getMaterial() != Material.AIR) {
				iblockstate = iblockstate.with(EAST, true);
			}
			if (context.getWorld().getBlockState(context.getPos().west()).getMaterial() != Material.AIR) {
				iblockstate = iblockstate.with(WEST, true);
			}
			if (context.getWorld().getBlockState(context.getPos().north()).getMaterial() != Material.AIR) {
				iblockstate = iblockstate.with(NORTH, true);
			}
			if (context.getWorld().getBlockState(context.getPos().south()).getMaterial() != Material.AIR) {
				iblockstate = iblockstate.with(SOUTH, true);
			}
			return iblockstate;
		}

		@Override
	    public int quantityDropped(IBlockState state,Random random)
	    {
	    	if (this.tempered){
	    		return 1;
	    	}else{
	    		return 0;
	    	}
	    }

	    public boolean isDouble()
	    {
	        return false;
	    }


	    @OnlyIn(Dist.CLIENT)
	    @Override
	    public BlockRenderLayer getRenderLayer()
	    {
	        return BlockRenderLayer.TRANSLUCENT;
	    }

}
