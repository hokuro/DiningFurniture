package mod.drf.foods.block;

import java.util.List;
import java.util.Random;

import mod.drf.foods.tileentity.TileEntitySaltPan;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
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
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSaltPan extends BlockContainer {

    public static final PropertyInteger LEVEL = PropertyInteger.create("level", 0, 2);
    protected static final AxisAlignedBB AABB_LEGS = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125, 1.0D);
    protected static final AxisAlignedBB AABB_WALL_NORTH = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.0625D);
    protected static final AxisAlignedBB AABB_WALL_SOUTH = new AxisAlignedBB(0.0D, 0.0D, 0.9375D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_WALL_EAST = new AxisAlignedBB(0.9375D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_WALL_WEST = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0625D, 1.0D, 1.0D);

	protected BlockSaltPan() {
		super(Material.GLASS);
		this.setHardness(1.0F);
        this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL, Integer.valueOf(0)));
	}

    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB p_185477_4_, List<AxisAlignedBB> p_185477_5_, Entity p_185477_6_)
    {
        addCollisionBoxToList(pos, p_185477_4_, p_185477_5_, AABB_LEGS);
        addCollisionBoxToList(pos, p_185477_4_, p_185477_5_, AABB_WALL_WEST);
        addCollisionBoxToList(pos, p_185477_4_, p_185477_5_, AABB_WALL_NORTH);
        addCollisionBoxToList(pos, p_185477_4_, p_185477_5_, AABB_WALL_EAST);
        addCollisionBoxToList(pos, p_185477_4_, p_185477_5_, AABB_WALL_SOUTH);
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return FULL_BLOCK_AABB;
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        int i = ((Integer)state.getValue(LEVEL)).intValue();
        float f = (float)pos.getY() + (6.0F + (float)(3 * i)) / 16.0F;

        if (!worldIn.isRemote && entityIn.isBurning() && i == EnumSaltPanLevel.FILL.getLevel() && entityIn.getEntityBoundingBox().minY <= (double)f)
        {
            entityIn.extinguish();
            this.setWaterLevel(worldIn, pos, state, EnumSaltPanLevel.EMPTY);
        }
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
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
                int level = ((Integer)state.getValue(LEVEL)).intValue();
                Item item = heldItem.getItem();

                if ( level== 2){
                	if (item instanceof ItemSpade){
                		if (!worldIn.isRemote){
                			if (!playerIn.capabilities.isCreativeMode){
                                	// エンティティのインベントリの中身をドロップさせる
                					InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntitySaltPan)tileentity);
                					((TileEntitySaltPan) tileentity).clear();
                                    worldIn.updateComparatorOutputLevel(pos, this);
                    				heldItem.damageItem(1, playerIn);
                			}
                		}
                        worldIn.playSound(playerIn, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        playerIn.addStat(StatList.CAULDRON_USED);
                	}else if(item==Items.WATER_BUCKET){
                		return true;
                	}
                }else if (level == 1){
                	if ( item == Items.BUCKET){
                		 if (level == 1 && !worldIn.isRemote)
                         {
                             if (!playerIn.capabilities.isCreativeMode)
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
                            if (!playerIn.capabilities.isCreativeMode)
                            {
                                playerIn.setHeldItem(hand, new ItemStack(Items.BUCKET));
                            }
                            ((TileEntitySaltPan) tileentity).setInventorySlotContents(0, new ItemStack(Items.POTIONITEM));
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
        IBlockState saltPan = state.withProperty(LEVEL, Integer.valueOf(MathHelper.clamp(level.getLevel(), 0, 3)));
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
    	return worldIn.getBlockState(pos).getValue(LEVEL);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(BlockFoods.block_saltpan);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(BlockFoods.block_saltpan);
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(LEVEL, Integer.valueOf(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(LEVEL)).intValue();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {LEVEL});
    }

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return true;
    }

    public boolean hasComparatorInputOverride(IBlockState state)
    {
        return true;
    }

    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return Container.calcRedstone(worldIn.getTileEntity(pos));
    }

    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
    	int level = state.getValue(LEVEL);
    	if (level == 2){
        	TileEntity tileentity = worldIn.getTileEntity(pos);
        	if (tileentity != null && tileentity instanceof TileEntitySaltPan){
    			InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntitySaltPan)tileentity);
    			((TileEntitySaltPan) tileentity).clear();
    			worldIn.updateComparatorOutputLevel(pos, this);
        	}
    	}
        super.breakBlock(worldIn, pos, state);
    }


	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
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
