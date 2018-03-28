package mod.drf.foods.gui;

import mod.drf.foods.inventory.ContainerIceCrasher;
import mod.drf.foods.tileentity.TileEntityIceCrasher;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GuiIceCrasher extends GuiContainer {
    private static final ResourceLocation tex = new ResourceLocation("drf:textures/gui/container/icecrasher.png");
    private final InventoryPlayer playerInventory;
    private final IInventory tileFlapeMaker;


    public GuiIceCrasher(World worldIn, EntityPlayer player, BlockPos pos, IInventory inv)
    {
        super(new ContainerIceCrasher(player.inventory, inv));
        this.playerInventory = player.inventory;
        this.tileFlapeMaker = inv;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = this.tileFlapeMaker.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(tex);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

        int l = this.getCrushProgressScaled(16);
        this.drawTexturedModalRect(i + 54, j + 35, 176, 0, 19, l);


        l = this.getCrushProgressScaled(23);
        this.drawTexturedModalRect(i + 78, j + 35, 176, 17, l, 17);
	}

    private int getCrushProgressScaled(int pixels)
    {
        int i = this.tileFlapeMaker.getField(0);
        return i == 0?0:i * pixels / TileEntityIceCrasher.CRUSH_TIME_MAX;
    }
}
