package mod.drf.core;

import mod.drf.foods.gui.GuiFlapeMaker;
import mod.drf.foods.tileentity.TileEntityFlapeMaker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHundler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
		case ModCommon.MOD_GUI_ID_FLAPEMAKER:
			TileEntity flapeMaker = world.getTileEntity(new BlockPos(x,y,z));
			if (flapeMaker instanceof TileEntityFlapeMaker){
				return new GuiFlapeMaker(player.inventory,((TileEntityFlapeMaker)flapeMaker));
			}
			break;

		case ModCommon.MOD_GUI_ID_FREEZER:
			break;
		case ModCommon.MOD_GUI_ID_MILL:
			break;
		case ModCommon.MOD_GUI_ID_TRUNK:
			break;
		case ModCommon.MOD_GUI_ID_UNLIMITANVIL:
			break;
		case ModCommon.MOD_GUI_ID_ENTDELETER:
			break;
		}
		return null;
	}

}
