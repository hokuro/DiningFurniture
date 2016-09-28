package mod.drf.foods.block;

import java.util.List;
import java.util.Random;

import mod.drf.foods.Item.ItemFoods;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSaltPan extends Block {

    public static final PropertyInteger LEVEL = PropertyInteger.create("level", 0, 3);
    protected static final AxisAlignedBB AABB_LEGS = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3125D, 1.0D);
    protected static final AxisAlignedBB AABB_WALL_NORTH = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.0625D);
    protected static final AxisAlignedBB AABB_WALL_SOUTH = new AxisAlignedBB(0.0D, 0.0D, 0.9375D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_WALL_EAST = new AxisAlignedBB(0.9375D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_WALL_WEST = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0625D, 1.0D, 1.0D);

	protected BlockSaltPan() {
		super(Material.glass);
        this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL, Integer.valueOf(0)));
	}


    public int tickRate(World worldIn)
    {
        return 300;
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (state.getValue(LEVEL)==1){
        	worldIn.setBlockState(pos, state.withProperty(LEVEL, Integer.valueOf(2)));
        }
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

            if ( i== 2){
            	if (item instanceof ItemSpade){
            		if (!worldIn.isRemote){
            			if (!playerIn.capabilities.isCreativeMode){
            				playerIn.inventory.addItemStackToInventory(new ItemStack(ItemFoods.item_salt,6));
            				heldItem.damageItem(1, playerIn);
            			}
            		}
                    worldIn.playSound(playerIn, pos, SoundEvents.item_shovel_flatten, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    playerIn.addStat(StatList.cauldronUsed);
                    this.setWaterLevel(worldIn, pos, state, 0);
            	}
            }else if (i == 1){
            	if ( item == Items.bucket){
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
            	}
            }else{
            	if (item == Items.water_bucket)
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
            }
        }
        return false;
    }

    public void setWaterLevel(World worldIn, BlockPos pos, IBlockState state, int level)
    {
        worldIn.setBlockState(pos, state.withProperty(LEVEL, Integer.valueOf(MathHelper.clamp_int(level, 0, 3))), 2);
        worldIn.updateComparatorOutputLevel(pos, this);
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
}
