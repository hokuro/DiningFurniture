package mod.drf.core;

import mod.drf.furniture.container.TrunkContainer;
import mod.drf.furniture.container.TrunkInventory;
import mod.drf.furniture.gui.GuiTrunk;
import mod.drf.furniture.item.ItemTrunk;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {
	public void registerChairRender(){
	}

	public void registerColorMap(){}


	   public void registerClientInfo() {}

	   public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	   {
//	     if (ID == ModCommon.guiID)
//	     {

		   //ItemStack heldItem = player.getHeldItemMainhand();
		   for (ItemStack item : player.getHeldEquipment()){
			   if (item != null && item.getItem() instanceof ItemTrunk)
			   {
				   TrunkInventory inventorybag = new TrunkInventory(item, world,ID);
				   return new TrunkContainer(player.inventory, inventorybag);
			   }
		   }
		   return null;
//	     }
//	     return null;
	   }

	   public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	   {
//	     if (ID == ModCommon.guiID)
//	     {
	       //ItemStack heldItem = player.getCurrentEquippedItem();

		   for (ItemStack heldItem : player.getHeldEquipment()){
			   if ((heldItem != null) && ((heldItem.getItem() instanceof ItemTrunk)))
			   {
				   TrunkInventory inventorybag = new TrunkInventory(heldItem, world,ID);
				   return new GuiTrunk(player.inventory, inventorybag, ID );
			   }
		   }
	       return null;
//	     }
//	     return null;
	   }
}
