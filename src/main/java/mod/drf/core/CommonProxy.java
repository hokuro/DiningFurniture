package mod.drf.core;

import mod.drf.foods.tileentity.TileEntityFreezer;
import mod.drf.foods.tileentity.TileEntityIceCrasher;
import mod.drf.foods.tileentity.TileEntityMillStone;
import mod.drf.foods.tileentity.TileEntitySaltPan;
import mod.drf.furniture.client.gui.GuiTrunk;
import mod.drf.furniture.inventory.ContainerTrunk;
import mod.drf.furniture.inventory.InventoryTrunk;
import mod.drf.furniture.item.ItemTrunk;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler {

	public EntityPlayer getEntityPlayerInstance() {return null;}
	
	public void registerTileEntity(){
		GameRegistry.registerTileEntity(TileEntitySaltPan.class, TileEntitySaltPan.REGISTER_NAME);
		GameRegistry.registerTileEntity(TileEntityIceCrasher.class,TileEntityIceCrasher.REGISTER_NAME);
		GameRegistry.registerTileEntity(TileEntityFreezer.class, TileEntityFreezer.REGISTER_NAME);
		GameRegistry.registerTileEntity(TileEntityMillStone.class, TileEntityMillStone.REGISTER_NAME);
	}

	public void registRender(){
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
				   InventoryTrunk inventorybag = new InventoryTrunk(item, world,ID);
				   return new ContainerTrunk(player.inventory, inventorybag);
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
				   InventoryTrunk inventorybag = new InventoryTrunk(heldItem, world,ID);
				   return new GuiTrunk(player.inventory, inventorybag, ID );
			   }
		   }
	       return null;
//	     }
//	     return null;
	   }
}
