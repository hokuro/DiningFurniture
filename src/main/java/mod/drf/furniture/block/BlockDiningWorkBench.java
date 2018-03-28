package mod.drf.furniture.block;

import mod.drf.core.Mod_DiningFurniture;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockDiningWorkBench extends Block {
	protected BlockDiningWorkBench(){
		super(Material.WOOD);
		this.setCreativeTab(Mod_DiningFurniture.tabFurniture);
		this.setSoundType(SoundType.WOOD);
		this.setHardness(2.5F);
		this.setUnlocalizedName(BlockCore.NAME_UNLOCAL_DININGWORKBENCH);
	}
}
