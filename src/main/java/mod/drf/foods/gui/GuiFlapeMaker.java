package mod.drf.foods.gui;

import mod.drf.foods.inventory.ContainerFlapeMaker;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiFlapeMaker extends GuiContainer {
    private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("drf:textures/gui/container/flapemaker.png");
    private final InventoryPlayer playerInventory;
    private IInventory tileFlapeMaker;


    public GuiFlapeMaker(InventoryPlayer player, IInventory flapeMaker)
    {
        super(new ContainerFlapeMaker(player, flapeMaker));
        this.playerInventory = player;
        this.tileFlapeMaker = flapeMaker;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = this.tileFlapeMaker.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

        int l = this.getCrushProgressScaled(24);
        this.drawTexturedModalRect(i + 79, j + 34, 176, 14, l + 1, 16);
	}

    private int getCrushProgressScaled(int pixels)
    {
        int i = this.tileFlapeMaker.getField(2);
        int j = this.tileFlapeMaker.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }
}
