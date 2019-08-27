package mod.drf.foods.block.Item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockItemPie extends ItemBlock {

	public BlockItemPie(Block block, Item.Properties property){
		super(block,property);
	}


//	  /**
//     * Called when a Block is right-clicked with this Item
//     */
//    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
//    {
//        IBlockState iblockstate = worldIn.getBlockState(pos);
//        Block block = iblockstate.getBlock();
//
////        if (block == Blocks.SNOW && ((Integer)iblockstate.getValue(BlockSnow.l)).intValue() < 1)
////        {
////            side = EnumFacing.UP;
////        }
////        else
//        if (!block.isReplaceable(iblockstate, new BlockItemUseContext(worldIn, playerIn, stack, pos, side, hitX, hitY, hitZ)))
//        {
//            pos = pos.offset(side);
//        }
//
//        if (!playerIn.canPlayerEdit(pos, side, stack))
//        {
//            return false;
//        }
//        else if (stack.getCount() == 0)
//        {
//            return false;
//        }
//        else
//        {
//        	if (worldIn.place .mayPlace(this.getBlock(), pos, false, side, (Entity)null))
//            {
//                IBlockState iblockstate1 = this.getBlock().getStateForPlacement(iblockstate, side,  worldIn.getBlockState(new BlockPos(hitX, hitY, hitZ)), worldIn, pos, new BlockPos(hitX, hitY, hitZ), EnumHand.MAIN_HAND);
//
//                if (worldIn.setBlockState(pos, iblockstate1, 3))
//                {
//                    iblockstate1 = worldIn.getBlockState(pos);
//
//                    if (iblockstate1.getBlock() == this.getBlock())
//                    {
//                        ItemBlock.setTileEntityNBT(worldIn, playerIn, pos, stack);
//                        iblockstate1.getBlock().onBlockPlacedBy(worldIn, pos, iblockstate1, playerIn, stack);
//                    }
//
//                    SoundType soundtype = this.getBlock().getSoundType();
//                    worldIn.playSound(playerIn, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
//                    stack.shrink(1);
//                    return true;
//                }
//            }
//
//            return false;
//        }
//    }
}
