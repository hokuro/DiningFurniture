package mod.drf.foods.gui;

import mod.drf.foods.inventory.ContainerMill;
import mod.drf.foods.tileentity.TileEntityMill;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class GuiMill extends GuiContainer {
	  private static final ResourceLocation texture = new ResourceLocation("drf:textures/gui/container/mill.png");
	    private final InventoryPlayer playerInventory;
	    private IInventory tileMill;
	    private BlockPos pos;


	    public GuiMill(InventoryPlayer player, IInventory flapeMaker, BlockPos pos)
	    {
	        super(new ContainerMill(player, flapeMaker));
	        this.playerInventory = player;
	        this.tileMill = flapeMaker;
	        this.pos = pos;
	    }

	    @Override
	    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	    {
	        String s = this.tileMill.getDisplayName().getUnformattedText();
	        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
	        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
	    }

		@Override
		protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
	        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.getTextureManager().bindTexture(texture);
	        int i = (this.width - this.xSize) / 2;
	        int j = (this.height - this.ySize) / 2;
	        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

	        int l = this.getCrushProgressScaled(16);
	        this.drawTexturedModalRect(i + 77, j + 35, 176, 0, 20, l);
		}

	    private int getCrushProgressScaled(int pixels)
	    {
	        int i = this.tileMill.getField(0);
		    return i == 0?0:i * pixels / TileEntityMill.MILL_TIME_MAX;
	    }
}
