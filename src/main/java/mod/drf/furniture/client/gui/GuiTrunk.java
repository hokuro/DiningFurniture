package mod.drf.furniture.client.gui;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

import mod.drf.core.ModCommon;
import mod.drf.core.Mod_DiningFurniture;
import mod.drf.furniture.inventory.ContainerTrunk;
import mod.drf.furniture.network.TrunkPagePacket;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiTrunk extends GuiContainer {

	private EntityPlayer player;
	private int _page;
	private ContainerTrunk _contena;


	// GUIのリソースパス
	private static final ResourceLocation guiTex = new ResourceLocation(ModCommon.MOD_ASSEAT, ModCommon.MOD_TRUNK_GUI_PICT);
	// トランクデータ
	IInventory trunkData;

	public GuiTrunk(InventoryPlayer player, IInventory data, int page)
	{
		super(new ContainerTrunk(player, data));
        this.ySize = 222;
        this.xSize= 256;
        _contena = ((ContainerTrunk)this.inventorySlots);
        _page = page;
	}
	@Override
	public void initGui()
	{
		super.initGui();
		this.buttonList.clear();
		this.buttonList.add(new GuiButton(300, 8+(2*18)+(13*18) + 20, 126+10, 20, 20, "<-"));
		this.buttonList.add(new GuiButton(301, 8+(2*18)+(13*18) + 20, 126+20*2+20, 20, 20, "->"));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(guiTex);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

    protected void actionPerformed(GuiButton button) throws IOException
    {
    	if (button.id == 300){
    		if ( _page > 0){
    			_page--;
    		}
    		Mod_DiningFurniture.Net_Instance.sendToServer(new TrunkPagePacket(_page));
    	}else if(button.id==301){
    		if (_page < 9){
    			_page ++;
    		}
    		Mod_DiningFurniture.Net_Instance.sendToServer(new TrunkPagePacket(_page));
    	}
    }

    protected void drawGuiContainerForegroundLayer(int x, int y){
    	String s = _page + 1+"/10";
    	fontRendererObj.drawString(s, 8+(2*18)+(8*18) + 20, 126+30, 4210752);

    }

}
