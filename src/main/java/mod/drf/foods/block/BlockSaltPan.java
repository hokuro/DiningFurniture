package mod.drf.foods.block;

import java.util.List;
import java.util.Random;

import mod.drf.foods.Item.ItemFoods;
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSaltPan extends BlockContainer {

    public static final PropertyInteger LEVEL = PropertyInteger.create("level", 0, 2);
    protected static final AxisAlignedBB AABB_LEGS = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3125D, 1.0D);
    protected static final AxisAlignedBB AABB_WALL_NORTH = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.125D);
    protected static final AxisAlignedBB AABB_WALL_SOUTH = new AxisAlignedBB(0.0D, 0.0D, 0.875D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_WALL_EAST = new AxisAlignedBB(0.875D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_WALL_WEST = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.125D, 1.0D, 1.0D);

	protected BlockSaltPan() {
		super(Material.glass);
        this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL, Integer.valueOf(0)));
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntitySaltPan();
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

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    /**
     * Called When an Entity Collided with the Block
     */
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        int i = ((Integer)state.getValue(LEVEL)).intValue();
        float f = (float)pos.getY() + (6.0F + (float)(3 * i)) / 16.0F;

        if (!worldIn.isRemote && entityIn.isBurning() && i > 0 && entityIn.getEntityBoundingBox().minY <= (double)f)
        {
            entityIn.extinguish();
            this.setWaterLevel(worldIn, pos, state, i - 1);
        }
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (heldItem == null)
        {
            return true;
        }
        else
        {
            int i = ((Integer)state.getValue(LEVEL)).intValue();
            Item item = heldItem.getItem();

            if (i == 2 && (item instanceof ItemSpade)){
            	if (!worldIn.isRemote){
            		if (!playerIn.capabilities.isCreativeMode){
            			playerIn.inventory.addItemStackToInventory(new ItemStack(ItemFoods.item_salt,3));
            		}

                    playerIn.addStat(StatList.cauldronUsed);
                    this.setWaterLevel(worldIn, pos, state, 0);
            	}
            }
            else if (item == Items.water_bucket)
            {
                if (i == 0 && !worldIn.isRemote)
                {
                    if (!playerIn.capabilities.isCreativeMode)
                    {
                        playerIn.setHeldItem(hand, new ItemStack(Items.bucket));
                    }

                    playerIn.addStat(StatList.cauldronFilled);
                    this.setWaterLevel(worldIn, pos, state, 1);
                }

                return true;
            }
            else if (item == Items.bucket)
            {
                if (i == 1 && !worldIn.isRemote)
                {
                    if (!playerIn.capabilities.isCreativeMode)
                    {
                        --heldItem.stackSize;

                        if (heldItem.stackSize == 0)
                        {
                            playerIn.setHeldItem(hand, new ItemStack(Items.water_bucket));
                        }
                        else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.water_bucket)))
                        {
                            playerIn.dropPlayerItemWithRandomChoice(new ItemStack(Items.water_bucket), false);
                        }
                    }

                    playerIn.addStat(StatList.cauldronUsed);
                    this.setWaterLevel(worldIn, pos, state, 0);
                }

                return true;
            }
        }
        return false;
    }

    public void setWaterLevel(World worldIn, BlockPos pos, IBlockState state, int level)
    {
        worldIn.setBlockState(pos, state.withProperty(LEVEL, Integer.valueOf(MathHelper.clamp_int(level, 0, 3))), 2);
        worldIn.updateComparatorOutputLevel(pos, this);
    }

    /**
     * Called similar to random ticks, but only when it is raining.
     */
    public void fillWithRain(World worldIn, BlockPos pos)
    {
        if (worldIn.rand.nextInt(20) == 1)
        {
            float f = worldIn.getBiomeGenForCoords(pos).getFloatTemperature(pos);

            if (worldIn.getBiomeProvider().getTemperatureAtHeight(f, pos.getY()) >= 0.15F)
            {
                IBlockState iblockstate = worldIn.getBlockState(pos);

                if (((Integer)iblockstate.getValue(LEVEL)).intValue() == 0)
                {
                    worldIn.setBlockState(pos, iblockstate.cycleProperty(LEVEL), 2);
                }
            }
        }
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(BlockFoods.block_saltpan);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(BlockFoods.block_saltpan);
    }

    public boolean hasComparatorInputOverride(IBlockState state)
    {
        return true;
    }

    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return ((Integer)blockState.getValue(LEVEL)).intValue();
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(LEVEL, Integer.valueOf(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
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
}
