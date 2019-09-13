package mod.drf.block;

import mod.drf.item.ItemCore.EnumWoodType;
import mod.drf.tileentity.TileEntityWoodTable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockWoodTable extends ContainerBlock {
	private EnumWoodType woodType;
	protected VoxelShape colligeBox = Block.makeCuboidShape(0D,    1D, 0D,    16D,    16D, 16D);

	public BlockWoodTable(EnumWoodType wood, Block.Properties property) {
		super(property);
		woodType = wood;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	    return colligeBox;
	}


	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new TileEntityWoodTable(woodType);
	}

    @Override
    @Deprecated
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
    	ItemStack heldItem = playerIn.getHeldItem(hand);
		if (!worldIn.isRemote){
			// woodtableなら続行
	    	TileEntity ent = worldIn.getTileEntity(pos);
	    	if (!(ent instanceof TileEntityWoodTable)) {
	    		return false;
	    	}
	    	TileEntityWoodTable table = (TileEntityWoodTable)ent;
	    	if (!heldItem.isEmpty()) {
	    		if (table.isEmpty()) {
	    			//i空っぽなら手持ちのアイテムを入れる
	    			table.setItem(heldItem);
	    			playerIn.getHeldItem(hand).shrink(1);
	    		}else {
	    			//i既に何か入っているなら手持ちのアイテムと交換する
	    			ItemStack putItem = new ItemStack(heldItem.getItem(),1);
	    			heldItem.shrink(1);
	    			ItemStack exItem = table.exchangeItem(putItem);
	    			playerIn.dropItem(exItem, false);
	    		}
	    	}else{
	    		if (!table.isEmpty()) {
		    		if (playerIn.isSneaking()) {
		    			//iスニーク中かつ設置されているものが食べ物なら食べる
		    			if (table.canEat(playerIn.canEat(false))) {
		    				ItemStack eat = table.getItem();
		    				eat.getItem().onItemUseFinish(eat, worldIn, playerIn);
		    			}
		    		}else {
		    			//i空手ならアイテムを取り出す
		    			ItemStack exItem = table.getItem();
		    			playerIn.dropItem(exItem,false);
		    		}
	    		}
	    	}
		}
        return true;
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
    	TileEntity tileentity = worldIn.getTileEntity(pos);
    	if (tileentity != null && tileentity instanceof TileEntityWoodTable){
			InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileentity);
			((TileEntityWoodTable) tileentity).clear();
			worldIn.updateComparatorOutputLevel(pos, this);
    	}
        super.onReplaced(state,worldIn, pos, newState,isMoving);
    }

	public EnumWoodType getWoodType() {
		return woodType;
	}

}
