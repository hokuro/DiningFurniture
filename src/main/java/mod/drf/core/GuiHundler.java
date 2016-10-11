package mod.drf.core;

import mod.drf.core.log.ModLog;
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
		if(ModCommon.isDebug){ModLog.log().debug("Gui ID :" + Integer.toString(ID));}
		switch(ID){
		case ModCommon.MOD_GUI_ID_FLAPEMAKER:
			if (ModCommon.isDebug){ModLog.log().debug("Open Container FlapeMaker");}
			TileEntity flapeMaker = world.getTileEntity(new BlockPos(x,y,z));
			if (flapeMaker instanceof TileEntityFlapeMaker){
				return ((TileEntityFlapeMaker) flapeMaker).createContainer(player.inventory, player);
			}
			break;

		case ModCommon.MOD_GUI_ID_FREEZER:
			if (ModCommon.isDebug){ModLog.log().debug("Open Container Freezer");}
			break;
		case ModCommon.MOD_GUI_ID_MILL:
			if (ModCommon.isDebug){ModLog.log().debug("Open Container Mill");}
			break;
		case ModCommon.MOD_GUI_ID_TRUNK:
			if (ModCommon.isDebug){ModLog.log().debug("Open Container Trunk");}
			break;
		case ModCommon.MOD_GUI_ID_UNLIMITANVIL:
			if (ModCommon.isDebug){ModLog.log().debug("Open Container Anvil");}
			break;
		case ModCommon.MOD_GUI_ID_ENTDELETER:
			if (ModCommon.isDebug){ModLog.log().debug("Open Container Enchant");}
			break;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
		case ModCommon.MOD_GUI_ID_FLAPEMAKER:
			TileEntity flapeMaker = world.getTileEntity(new BlockPos(x,y,z));
			if (flapeMaker instanceof TileEntityFlapeMaker){
				return new GuiFlapeMaker(player.inventory,((TileEntityFlapeMaker)flapeMaker),new BlockPos(x,y,z));
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
