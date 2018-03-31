package mod.drf.furniture.block;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import mod.drf.core.Mod_DiningFurniture;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSlab.EnumBlockHalf;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockHorizontalGlassPanel extends BlockPane {
	   public static final PropertyEnum<BlockSlab.EnumBlockHalf> HALF = PropertyEnum.<BlockSlab.EnumBlockHalf>create("half", BlockSlab.EnumBlockHalf.class);
	   protected boolean tempered;

		protected BlockHorizontalGlassPanel(Material materialIn) {
			super(materialIn,true);
	        this.fullBlock = this.isDouble();
	        this.setDefaultState(
	        		this.blockState.getBaseState()
	        		.withProperty(NORTH, Boolean.valueOf(false))
	        		.withProperty(EAST, Boolean.valueOf(false))
	        		.withProperty(SOUTH, Boolean.valueOf(false))
	        		.withProperty(WEST, Boolean.valueOf(false)));
	        this.setSoundType(SoundType.GLASS);
	        this.setCreativeTab(Mod_DiningFurniture.tabFurniture);
	        tempered = false;
		}

		protected BlockHorizontalGlassPanel(Material materialIn,boolean tmp) {
			this(materialIn);
			tempered = tmp;
		}


		@Override
	    protected BlockStateContainer createBlockState()
	    {
	        return new BlockStateContainer(this, new IProperty[] {NORTH, EAST, WEST, SOUTH, HALF});
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

	    protected static final AxisAlignedBB[] collideBoxes = new AxisAlignedBB[] {
	    		new AxisAlignedBB(0.4375D, 0.0D, 0.4375D, 0.5625D, 0.1250D, 0.5625D),  // normal_down
	    		new AxisAlignedBB(0.0D,    0.0D, 0.0D,    1.0D,    0.1250D, 0.5625D),  // north_down
	    		new AxisAlignedBB(0.0D,    0.0D, 0.4375D, 1.0D,    0.1250D, 1.0D),     // south_down
	    		new AxisAlignedBB(0.4375D, 0.0D, 0.0D,    1.0D,    0.1250D, 1.0D),     // east_down
	    		new AxisAlignedBB(0.0D,    0.0D, 0.0D,    0.5625D, 0.1250D, 1.0D),     // west_down
	    		new AxisAlignedBB(0.4375D, 0.0D, 0.0D,    1.0,     0.1250D, 0.5625D ), // north-east_down
	    		new AxisAlignedBB(0.0D,    0.0D, 0.0D,    0.5625D, 0.1250D, 0.5625D),  // north-west_down
	    		new AxisAlignedBB(0.4375D, 0.0D, 0.0D,    0.5625D, 0.1250D, 1.0D),     // north-south_down
	    		new AxisAlignedBB(0.4375D, 0.0D, 0.4375D, 1.0D,    0.1250D, 1.0D),     // south-east_down
	    		new AxisAlignedBB(0.0D,    0.0D, 0.4375D, 0.5625D, 0.1250D, 1.0D),     // south-west_down
	    		new AxisAlignedBB(0.0D,    0.0D, 0.4375D, 1.0D,    0.1250D, 0.5625D),  // east-west_down
	    		new AxisAlignedBB(0.0D,    0.0D, 0.0D,    1.0D,    0.1250D, 1.0D),     // allDirect_down
	    		new AxisAlignedBB(0.0D,    0.8750D, 0.0D,    1.0D,    1.0D, 0.5625D),  // north_up
	    		new AxisAlignedBB(0.0D,    0.8750D, 0.4375D, 1.0D,    1.0D, 1.0D),     // south_up
	    		new AxisAlignedBB(0.4375D, 0.8750D, 0.0D,    1.0D,    1.0D, 1.0D),     // east_up
	    		new AxisAlignedBB(0.0D,    0.8750D, 0.0D,    0.5625D, 1.0D, 1.0D),     // west_up
	    		new AxisAlignedBB(0.4375D, 0.8750D, 0.0D,    1.0,     1.0D, 0.5625D ), // north-east_up
	    		new AxisAlignedBB(0.0D,    0.8750D, 0.0D,    0.5625D, 1.0D, 0.5625D),  // north-west_up
	    		new AxisAlignedBB(0.4375D, 0.8750D, 0.0D,    0.5625D, 1.0D, 1.0D),     // north-south_up
	    		new AxisAlignedBB(0.4375D, 0.8750D, 0.4375D, 1.0D,    1.0D, 1.0D),     // south-east_up
	    		new AxisAlignedBB(0.0D,    0.8750D, 0.4375D, 0.5625D, 1.0D, 1.0D),     // south-west_up
	    		new AxisAlignedBB(0.0D,    0.8750D, 0.4375D, 1.0D,    1.0D, 0.5625D),  // east-west_up
	    		new AxisAlignedBB(0.0D,    0.8750D, 0.0D,    1.0D,    1.0D, 1.0D)      // allDirect_up

	    };

	    private IBlockState _state;
	    public boolean North(){
	    	return (Boolean)_state.getValue(NORTH).booleanValue();
	    }
	    public boolean South(){
	    	return (Boolean)_state.getValue(SOUTH).booleanValue();
	    }
	    public boolean West(){
	    	return (Boolean)_state.getValue(WEST).booleanValue();
	    }
	    public boolean East(){
	    	return (Boolean)_state.getValue(EAST).booleanValue();
	    }
	    public boolean Half(){
	    	return _state.getValue(HALF) == EnumBlockHalf.BOTTOM;
	    }

	    @Override
	    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB p_185477_4_, List<AxisAlignedBB> p_185477_5_, Entity p_185477_6_, boolean isActualState)
	    {
	        addCollisionBoxToList(pos, p_185477_4_, p_185477_5_, collideBoxes[getBoundingBoxIndex(state)]);
	    }

	    @Override
	    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	    {
	        state = this.getActualState(state, source, pos);
	        return collideBoxes[getBoundingBoxIndex(state)];
	    }

	    @Override
	    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	    {
	        return state.withProperty(NORTH, canPaneConnectTo(worldIn, pos, EnumFacing.NORTH, state.getValue(HALF)))
	                .withProperty(SOUTH, canPaneConnectTo(worldIn, pos, EnumFacing.SOUTH, state.getValue(HALF)))
	                .withProperty(WEST, canPaneConnectTo(worldIn, pos, EnumFacing.WEST, state.getValue(HALF)))
	                .withProperty(EAST, canPaneConnectTo(worldIn, pos, EnumFacing.EAST, state.getValue(HALF)))
	                .withProperty(HALF, canPaneConnectToVertical(worldIn, pos, state));
	    }

	    public boolean canPaneConnectTo(IBlockAccess world, BlockPos pos, EnumFacing dir, BlockSlab.EnumBlockHalf half)
	    {
	        BlockPos other = pos.offset(dir);
	        IBlockState state = world.getBlockState(other);
	        if ((state.getBlock().canBeConnectedTo(world, other, dir.getOpposite()) || attachesTo(world, state, other, dir.getOpposite()))){
	        	return !state.getProperties().containsKey(HALF) || (state.getProperties().containsKey(HALF) && state.getValue(HALF) == half);
	        }
	        return false;
	    }

	    private EnumBlockHalf canPaneConnectToVertical(IBlockAccess world, BlockPos pos, IBlockState state) {
	        return state.getValue(HALF);
		}

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
		public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	    {
	        IBlockState iblockstate = this.getStateFromMeta(meta);
	        return this.isDouble() ? iblockstate : (facing != EnumFacing.DOWN && (facing == EnumFacing.UP || (double)hitY <= 0.5D) ? iblockstate : iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.TOP));
	    }


		@Override
	    public IBlockState getStateFromMeta(int meta)
	    {
	        IBlockState iblockstate = this.getDefaultState();
	        iblockstate = iblockstate.withProperty(HALF, (meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
	        return iblockstate;
	    }

		@Override
	    public int quantityDropped(Random random)
	    {
	    	if (this.tempered){
	    		return 1;
	    	}else{
	    		return 0;
	    	}
	    }


		@Override
	    public int getMetaFromState(IBlockState state)
	    {
	        int i = 0;
	        if (state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP)
	        {
	            i |= 8;
	        }
	        return i;
	    }

	    public boolean isDouble()
	    {
	        return false;
	    }
}
