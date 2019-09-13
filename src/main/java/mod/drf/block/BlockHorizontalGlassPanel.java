package mod.drf.block;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockHorizontalGlassPanel extends PaneBlock {
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
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
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

	    @Override
	    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	        return this.getShape(state, worldIn, pos, context);
	     }

	    private BlockState _state;
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

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
			return collideBoxes[getBoundingBoxIndex(state)];
		}

		private int getBoundingBoxIndex(BlockState state)
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

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			BlockState BlockState = this.getDefaultState();
			BlockState = this.isDouble() ? BlockState : (context.getFace() != Direction.DOWN && (context.getFace() == Direction.UP || (double)context.getHitVec().getY() <= 0.5D) ? BlockState.with(HALF, SlabType.BOTTOM) : BlockState.with(HALF, SlabType.TOP));
			if (context.getWorld().getBlockState(context.getPos().east()).getMaterial() != Material.AIR) {
				BlockState = BlockState.with(EAST, true);
			}
			if (context.getWorld().getBlockState(context.getPos().west()).getMaterial() != Material.AIR) {
				BlockState = BlockState.with(WEST, true);
			}
			if (context.getWorld().getBlockState(context.getPos().north()).getMaterial() != Material.AIR) {
				BlockState = BlockState.with(NORTH, true);
			}
			if (context.getWorld().getBlockState(context.getPos().south()).getMaterial() != Material.AIR) {
				BlockState = BlockState.with(SOUTH, true);
			}
			return BlockState;
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
