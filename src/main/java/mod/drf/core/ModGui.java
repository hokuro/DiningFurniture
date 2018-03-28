package mod.drf.core;

import mod.drf.core.log.ModLog;
import mod.drf.foods.block.BlockCookingWorkBench;
import mod.drf.foods.gui.GuiFreezer;
import mod.drf.foods.gui.GuiIceCrasher;
import mod.drf.foods.gui.GuiMillStone;
import mod.drf.foods.gui.GuiOriginalWorkBench;
import mod.drf.foods.inventory.ContainerOriginalWorkBench;
import mod.drf.foods.tileentity.TileEntityFreezer;
import mod.drf.foods.tileentity.TileEntityIceCrasher;
import mod.drf.foods.tileentity.TileEntityMillStone;
import mod.drf.recipie.CookingMenu;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGui implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ModCommon.isDebug){ModLog.log().debug("Gui ID :" + Integer.toString(ID));}
		TileEntity te;
		IBlockState bk;
		switch(ID){
		case ModCommon.MOD_GUI_ID_ICECRASHER:
			if (ModCommon.isDebug){ModLog.log().debug("Open Container IceCrasher");}
			te = world.getTileEntity(new BlockPos(x,y,z));
			if (te instanceof TileEntityIceCrasher){
				return ((TileEntityIceCrasher) te).createContainer(player.inventory, player);
			}
			break;

		case ModCommon.MOD_GUI_ID_FREEZER:
			if (ModCommon.isDebug){ModLog.log().debug("Open Container Freezer");}
			te = world.getTileEntity(new BlockPos(x,y,z));
			if (te instanceof TileEntityFreezer){
				return ((TileEntityFreezer) te).createContainer(player.inventory, player);
			}
			break;

		case ModCommon.MOD_GUI_ID_MILLSTONE:
			if (ModCommon.isDebug){ModLog.log().debug("Open Container MillStone");}
			te = world.getTileEntity(new BlockPos(x,y,z));
			if (te instanceof TileEntityMillStone){
				return ((TileEntityMillStone) te).createContainer(player.inventory, player);
			}
			break;
		case ModCommon.MOD_GUI_ID_CWORKBENCH:
			if(ModCommon.isDebug){ModLog.log().debug("Open Gui Cooking Workbench");}
			bk = world.getBlockState(new BlockPos(x,y,z));
			if (bk.getBlock() instanceof BlockCookingWorkBench){
				return new ContainerOriginalWorkBench(player.inventory, world, new BlockPos(x,y,z), CookingMenu.getInstance());
			}
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
		TileEntity te;
		IBlockState bk;
		switch(ID){
		case ModCommon.MOD_GUI_ID_ICECRASHER:
			if (ModCommon.isDebug){ModLog.log().debug("Open Gui IceCrasher");}
			te = world.getTileEntity(new BlockPos(x,y,z));
			if (te instanceof TileEntityIceCrasher){
				return new GuiIceCrasher(world, player, new BlockPos(x,y,z), (TileEntityIceCrasher)te);
			}
			break;

		case ModCommon.MOD_GUI_ID_FREEZER:
			if (ModCommon.isDebug){ModLog.log().debug("Open Gui Freezer");}
			te = world.getTileEntity(new BlockPos(x,y,z));
			if (te instanceof TileEntityFreezer){
				return new GuiFreezer(world, player, new BlockPos(x,y,z), (TileEntityFreezer)te);
			}
			break;

		case ModCommon.MOD_GUI_ID_MILLSTONE:
			if (ModCommon.isDebug){ModLog.log().debug("Open Gui MillStone");}
			te = world.getTileEntity(new BlockPos(x,y,z));
			if (te instanceof TileEntityMillStone){
				return new GuiMillStone(world, player, new BlockPos(x,y,z), (TileEntityMillStone)te);
			}
			break;
		case ModCommon.MOD_GUI_ID_CWORKBENCH:
			if(ModCommon.isDebug){ModLog.log().debug("Open Gui Cooking Workbench");}
			bk = world.getBlockState(new BlockPos(x,y,z));
			if (bk.getBlock() instanceof BlockCookingWorkBench){
				return new GuiOriginalWorkBench(player,world, new BlockPos(x,y,z),CookingMenu.getInstance());
			}
		case ModCommon.MOD_GUI_ID_TRUNK:
			if (ModCommon.isDebug){ModLog.log().debug("Open Gui Trunk");}
			break;
		case ModCommon.MOD_GUI_ID_UNLIMITANVIL:
			if (ModCommon.isDebug){ModLog.log().debug("Open Gui UnlimitAnvil");}
			break;
		case ModCommon.MOD_GUI_ID_ENTDELETER:
			if (ModCommon.isDebug){ModLog.log().debug("Open Gui EnchantDeleter");}
			break;
		}
		return null;
	}

}
