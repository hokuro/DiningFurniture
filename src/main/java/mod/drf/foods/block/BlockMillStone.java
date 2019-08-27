package mod.drf.foods.block;

import mod.drf.foods.tileentity.TileEntityMillStone;
import mod.drf.intaractionobject.IntaractionObjectMillStone;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BlockMillStone extends BlockContainer {
    // あたり判定
    //private static final AxisAlignedBB colligeBox = new AxisAlignedBB(0.125D, 0D, 0.125D, 0.875D, 0.75D, 0.875D);
    protected VoxelShape colligeBox = Block.makeCuboidShape(2D,    0D, 2D,    14D,    12D, 14D);

	protected BlockMillStone() {
        super(Block.Properties.create(Material.GRASS)
        		.hardnessAndResistance(1.0F,5.0F)
        		.sound(SoundType.STONE));
	}

	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos)
	{
	    return colligeBox;
	}


	@Override
	public TileEntity createNewTileEntity(IBlockReader world) {
		return new TileEntityMillStone();
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
	public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
        return Item.getItemFromBlock(BlockFoods.block_millstone);
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

            if (tileentity instanceof TileEntityMillStone)
            {
            	NetworkHooks.openGui((EntityPlayerMP)playerIn,
        			new IntaractionObjectMillStone(pos),
        			(buf)->{
						buf.writeInt(pos.getX());
						buf.writeInt(pos.getY());
						buf.writeInt(pos.getZ());
					});
            	//playerIn.openGui(Mod_DiningFurniture.instance, ModCommon.MOD_GUI_ID_MILLSTONE, worldIn, pos.getX(), pos.getY(), pos.getZ());
            }

            return true;
        }
    }

    @Override
    public void onReplaced(IBlockState state, World worldIn, BlockPos pos, IBlockState newState, boolean isMoving) {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof TileEntityMillStone)
        {
        	if (!((TileEntityMillStone)tileentity).isEmpty()){
        		InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityMillStone)tileentity);
        	}
            worldIn.updateComparatorOutputLevel(pos, this);
        }
        super.onReplaced(state, worldIn, pos, newState,isMoving);
    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(BlockFoods.block_millstone);
    }

    @Override
	public boolean hasCustomBreakingProgress(IBlockState state){
    	return true;
    }
}
