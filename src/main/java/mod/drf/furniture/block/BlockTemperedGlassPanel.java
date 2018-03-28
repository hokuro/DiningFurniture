package mod.drf.furniture.block;

import mod.drf.core.Mod_DiningFurniture;
import net.minecraft.block.BlockPane;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockTemperedGlassPanel extends BlockPane {
	/**
	 * コンストラクタ
	 * @param materialIn マテリアル
	 */
	public BlockTemperedGlassPanel(Material materialIn){
		super(materialIn,true);
        this.setSoundType(SoundType.GLASS);
        this.setCreativeTab(Mod_DiningFurniture.tabFurniture);
	}
}
