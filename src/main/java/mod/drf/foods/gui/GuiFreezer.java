package mod.drf.foods.gui;

import mod.drf.foods.inventory.ContainerFlapeMaker;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class GuiFreezer  extends GuiContainer {
    private static final ResourceLocation freezerGuiTexture = new ResourceLocation("drf:textures/gui/container/freezer.png");
    private final InventoryPlayer playerInventory;
    private IInventory tileFreezer;
    private BlockPos pos;


    public GuiFreezer(InventoryPlayer player, IInventory freezer, BlockPos pos)
    {
        super(new ContainerFlapeMaker(player, freezer));
        this.playerInventory = player;
        this.tileFreezer = freezer;
        this.pos = pos;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = this.tileFreezer.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(freezerGuiTexture);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
	}
}
