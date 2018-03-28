package mod.drf.furniture.block.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class BlockItemTemperedGlass extends ItemBlock {
    public BlockItemTemperedGlass(Block block) {
        super(block);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    //ItemStackのdamage値からmetadataの値を返す。
    @Override
    public int getMetadata(int damage) {
        return damage;
    }
}
