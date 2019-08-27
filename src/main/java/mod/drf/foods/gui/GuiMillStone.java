package mod.drf.foods.gui;

import mod.drf.foods.inventory.ContainerMillStone;
import mod.drf.foods.tileentity.TileEntityMillStone;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GuiMillStone extends GuiContainer {
	  private static final ResourceLocation texture = new ResourceLocation("drf:textures/gui/container/millstone.png");
	    private final InventoryPlayer playerInventory;
	    private final IInventory tileMill;


	    public GuiMillStone(World worldIn, EntityPlayer player, BlockPos pos, IInventory inv)
	    {
	        super(new ContainerMillStone(player.inventory, inv));
	        this.playerInventory = player.inventory;
	        this.tileMill = inv;
	    }

	    @Override
	    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	    {
	        String s = this.tileMill.getDisplayName().getFormattedText();
	        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
	        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8, this.ySize - 96 + 2, 4210752);
	    }

		@Override
		protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
	        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
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
		    return i == 0?0:i * pixels / TileEntityMillStone.MILL_TIME_MAX;
	    }
}
