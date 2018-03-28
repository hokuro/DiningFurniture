package mod.drf.furniture.block.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class BlockItemTemperedGlassPane extends ItemBlock {
    public BlockItemTemperedGlassPane(Block block) {
        super(block);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }

    //ItemStackのdamage値からmetadataの値を返す。
    @Override
    public int getMetadata(int damage) {
        return damage;
    }
}
