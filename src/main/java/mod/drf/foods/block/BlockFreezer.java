package mod.drf.foods.block;

import mod.drf.common.block.BlockHorizontalContainer;
import mod.drf.foods.tileentity.TileEntityFreezer;
import mod.drf.intaractionobject.IntaractionObjectFreezer;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
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
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BlockFreezer extends BlockHorizontalContainer {

    private static boolean keepInventory;
    private static final AxisAlignedBB[] colligeBox =  new AxisAlignedBB[] {
    		new AxisAlignedBB(0D, 0D, 0D, 0D, 0D, 0D), // 不使用
    		new AxisAlignedBB(0D, 0D, 0D, 0D, 0D, 0D), // 不使用
    		new AxisAlignedBB(0.9375D, 0D, 0.0625D, 0.0625D, 1D, 1D),	// NORTH
    		new AxisAlignedBB(0.0625D, 0D, 1D, 0.9375, 1D, 0.0625D),	// SOUTH
    		new AxisAlignedBB(0.0D, 0D, 0.0625D, 0.9375D, 1D, 0.9375D),	// WEST
    		new AxisAlignedBB(1D, 0D, 0.0625D, 0.0625D, 1D, 0.9375D)	// EAST
    };

    protected static final VoxelShape[] colligBoxeis = new VoxelShape[]{
	    Block.makeCuboidShape(0,0,0,0,0,0), // 不使用
	    Block.makeCuboidShape(0,0,0,0,0,0), // 不使用
	    Block.makeCuboidShape(15,0,0,1,16,15),// NORTH
	    Block.makeCuboidShape(1,0,16,15,16,1),// SOUTH
	    Block.makeCuboidShape(0,0,1,15,16,15),// WEST
	    Block.makeCuboidShape(16,0,1,1,16,15)// EAST
	};

	protected BlockFreezer() {
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
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		// TODO 自動生成されたメソッド・スタブ
		return createTileEntity(null,worldIn);
	}


	@Override
	public TileEntity createTileEntity(IBlockState state, IBlockReader world) {
		return new TileEntityFreezer();
	}

    @Override
    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
        return Item.getItemFromBlock(BlockFoods.block_freezer);
    }

    @Override
	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos){
    	int idx = ((EnumFacing)state.getValues().get(FACING)).getIndex();
	    return colligBoxeis[idx];
	}

    @Override
    protected AxisAlignedBB getRealBoundingBox(IBlockState state){
    	int idx = ((EnumFacing)state.getValues().get(FACING)).getIndex();
    	if (idx >= 2 &&  6 > idx){
            return colligeBox[idx];
    	}
    	return colligeBox[2];
    }

    @Override
    public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
        	ItemStack stack = playerIn.getHeldItem(hand);
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof TileEntityFreezer)
            {
                if (stack.getItem() == Items.WATER_BUCKET){
                    if (((TileEntityFreezer) tileentity).InjectionTank()){
                    	if (!playerIn.isCreative()){
                    		playerIn.setHeldItem(hand, new ItemStack(Items.BUCKET,1));
                    	}
                    	playerIn.sendStatusMessage(new TextComponentString(((TileEntityFreezer) tileentity).getField(TileEntityFreezer.FLDIDX_TNKCNT)+"/" + TileEntityFreezer.TANK_MAX),false);
                    }else{
                    	playerIn.sendStatusMessage(new TextComponentString("water tank is max"),false);
                    }
                }else{
                	NetworkHooks.openGui((EntityPlayerMP)playerIn,
                			new IntaractionObjectFreezer(pos),
                			(buf)->{
        						buf.writeInt(pos.getX());
        						buf.writeInt(pos.getY());
        						buf.writeInt(pos.getZ());
        					});
                	//playerIn.openGui(Mod_DiningFurniture.instance, ModCommon.MOD_GUI_ID_FREEZER, worldIn, pos.getX(),pos.getY(),pos.getZ());
                }
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

            if (tileentity instanceof TileEntityFreezer)
            {
                ((TileEntityFreezer)tileentity).setCustomInventoryName(stack.getDisplayName().getFormattedText());
            }
        }
    }

    @Override
    public void onReplaced(IBlockState state, World worldIn, BlockPos pos, IBlockState newState, boolean isMoving) {
        if (!keepInventory)
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityFreezer)
            {
                InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityFreezer)tileentity);
                worldIn.updateComparatorOutputLevel(pos, this);
            }
        }

        super.onReplaced(state,worldIn, pos, newState,isMoving);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(BlockFoods.block_freezer);
    }

    @Override
	public boolean hasCustomBreakingProgress(IBlockState state){
    	return true;
    }



}
