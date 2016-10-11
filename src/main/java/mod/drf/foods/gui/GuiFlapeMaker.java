package mod.drf.foods.gui;

import mod.drf.foods.inventory.ContainerFlapeMaker;
import mod.drf.foods.tileentity.TileEntityFlapeMaker;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class GuiFlapeMaker extends GuiContainer {
    private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("drf:textures/gui/container/flapemaker.png");
    private final InventoryPlayer playerInventory;
    private IInventory tileFlapeMaker;
    private BlockPos pos;


    public GuiFlapeMaker(InventoryPlayer player, IInventory flapeMaker, BlockPos pos)
    {
        super(new ContainerFlapeMaker(player, flapeMaker));
        this.playerInventory = player;
        this.tileFlapeMaker = flapeMaker;
        this.pos = pos;
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

        int l = this.getCrushProgressScaled(16);
        this.drawTexturedModalRect(i + 77, j + 35, 176, 0, 19, l);
	}

    private int getCrushProgressScaled(int pixels)
    {
        int i = this.tileFlapeMaker.getField(0);
		//if (ModCommon.isDebug){if(ModUtil.CheckCounter("GuiFlapeMakerUpdate",40,true)){ModLog.log().debug("GuiFlapeMaker client crush time :" + Integer.toString(i));}}
        return i == 0?0:i * pixels / TileEntityFlapeMaker.CRUSH_TIME_MAX;
    }
}
