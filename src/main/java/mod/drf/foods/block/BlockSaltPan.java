package mod.drf.foods.block;

import mod.drf.foods.tileentity.TileEntitySaltPan;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockSaltPan extends BlockContainer {

    public static final IntegerProperty LEVEL = IntegerProperty.create("level", 0, 2);
    protected static final VoxelShape AABB_LEGS =  Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2, 16.0D);
    protected static final VoxelShape AABB_WALL_NORTH =  Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
    protected static final VoxelShape AABB_WALL_SOUTH =  Block.makeCuboidShape(0.0D, 0.0D, 15D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape AABB_WALL_EAST =  Block.makeCuboidShape(15D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape AABB_WALL_WEST =  Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);

	protected BlockSaltPan() {
		super(Block.Properties.create(Material.WOOD)
				.hardnessAndResistance(1.0F,5.0F)
				.sound(SoundType.WOOD));
		this.setDefaultState(this.stateContainer.getBaseState().with(LEVEL, Integer.valueOf(0)));
	}

	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos)
	{
		VoxelShape sh1 = AABB_LEGS;
		sh1 = VoxelShapes.or(sh1, AABB_WALL_NORTH);
		sh1 = VoxelShapes.or(sh1, AABB_WALL_SOUTH);
		sh1 = VoxelShapes.or(sh1, AABB_WALL_EAST);
		sh1 = VoxelShapes.or(sh1, AABB_WALL_WEST);
	    return sh1;

	}

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public void onEntityCollision(IBlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        int i = ((Integer)state.getValues().get(LEVEL)).intValue();
        float f = (float)pos.getY() + (6.0F + (float)(3 * i)) / 16.0F;

        if (!worldIn.isRemote && entityIn.isBurning() && i == EnumSaltPanLevel.FILL.getLevel() && entityIn.getBoundingBox().minY <= (double)f)
        {
            entityIn.extinguish();
            this.setWaterLevel(worldIn, pos, state, EnumSaltPanLevel.EMPTY);
        }
    }

    @Override
    public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
    	ItemStack heldItem = playerIn.getHeldItem(hand);
        if (heldItem == null)
        {
            return true;
        }
        else
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof TileEntitySaltPan)
            {
                int level = ((Integer)state.getValues().get(LEVEL)).intValue();
                Item item = heldItem.getItem();

                if ( level== 2){
                	if (item instanceof ItemSpade){
                		if (!worldIn.isRemote){
                			if (!playerIn.isCreative()){
                                	// エンティティのインベントリの中身をドロップさせる
                					InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntitySaltPan)tileentity);
                					((TileEntitySaltPan) tileentity).clear();
                                    worldIn.updateComparatorOutputLevel(pos, this);
                    				heldItem.damageItem(1, playerIn);
                			}
                		}
                        worldIn.playSound(playerIn, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                	}else if(item==Items.WATER_BUCKET){
                		return true;
                	}
                }else if (level == 1){
                	if ( item == Items.BUCKET){
                		 if (level == 1 && !worldIn.isRemote)
                         {
                             if (!playerIn.isCreative())
                             {
                            	 heldItem.shrink(1);

                                 if (heldItem.getCount() == 0)
                                 {
                                     playerIn.setHeldItem(hand, new ItemStack(Items.WATER_BUCKET));
                                 }
                                 else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET)))
                                 {
                                	 playerIn.dropItem(new ItemStack(Items.WATER_BUCKET), false);
                                 }
                             }
                             ((TileEntitySaltPan) tileentity).clear();
                         }
                		 return true;
                	}else if(item==Items.WATER_BUCKET){
                		return true;
                	}
                }else{
                	if (item == Items.WATER_BUCKET)
                    {
                        if (level == 0 && !worldIn.isRemote)
                        {
                            if (!playerIn.isCreative())
                            {
                                playerIn.setHeldItem(hand, new ItemStack(Items.BUCKET));
                            }
                            ((TileEntitySaltPan) tileentity).setInventorySlotContents(0, new ItemStack(Items.POTION));
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void setWaterLevel(World worldIn, BlockPos pos, IBlockState state, EnumSaltPanLevel level)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        IBlockState saltPan = state.with(LEVEL, Integer.valueOf(MathHelper.clamp(level.getLevel(), 0, 3)));
        worldIn.setBlockState(pos, saltPan, 2);
        worldIn.updateComparatorOutputLevel(pos, saltPan.getBlock());

        if (tileentity != null)
        {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    }

    public int getWaterLevel(World worldIn, BlockPos pos)
    {
    	return (int)worldIn.getBlockState(pos).getValues().get(LEVEL);
    }

    @Override
    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
        return Item.getItemFromBlock(BlockFoods.block_saltpan);
    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(BlockFoods.block_saltpan);
    }


	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
	   builder.add(LEVEL);
	}

    @Override
    public boolean hasComparatorInputOverride(IBlockState state)
    {
        return true;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return Container.calcRedstone(worldIn.getTileEntity(pos));
    }

    @Override
    public void onReplaced(IBlockState state, World worldIn, BlockPos pos, IBlockState newState, boolean isMoving) {
    	int level = (int)state.getValues().get(LEVEL);
    	if (level == 2){
        	TileEntity tileentity = worldIn.getTileEntity(pos);
        	if (tileentity != null && tileentity instanceof TileEntitySaltPan){
    			InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntitySaltPan)tileentity);
    			((TileEntitySaltPan) tileentity).clear();
    			worldIn.updateComparatorOutputLevel(pos, this);
        	}
    	}
        super.onReplaced(state,worldIn, pos, newState,isMoving);
    }


	@Override
	public TileEntity createNewTileEntity(IBlockReader world) {
		return new TileEntitySaltPan();
	}

	public static enum EnumSaltPanLevel{
		EMPTY(0,"empty"),
		FILL(1,"fill"),
		SATL(2,"salt");


		private static final EnumSaltPanLevel[] values = {EMPTY,FILL,SATL};
		private int index;
		private String name;
		private EnumSaltPanLevel(int level, String str){
			index = level;
			name = str;
		}

		public int getLevel(){return index;}
		public String getString(){return name;}
		public EnumSaltPanLevel getValue(int level){return values[level];}

	}
}
