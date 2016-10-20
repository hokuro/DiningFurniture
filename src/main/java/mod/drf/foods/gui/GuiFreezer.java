package mod.drf.foods.gui;

import mod.drf.foods.inventory.ContainerFreezer;
import mod.drf.foods.tileentity.TileEntityFreezer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GuiFreezer  extends GuiContainer {
    private static final ResourceLocation tex = new ResourceLocation("drf:textures/gui/container/freezer.png");
    private final IInventory tileFreezer;

    public GuiFreezer(World worldIn, EntityPlayer player, BlockPos pos, IInventory inv)
    {
        super(new ContainerFreezer(player.inventory, inv, player));
        this.tileFreezer = inv;
        int i = 222;
        int j = i - 108;
        this.ySize = j + 6 * 18;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = this.tileFreezer.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){
    	super.drawScreen(mouseX, mouseY, partialTicks);

    	GlStateManager.pushMatrix();
        GlStateManager.color(1.0F, 2.0F, 1.0F, 1.0F);
    	GlStateManager.disableDepth();
        this.mc.getTextureManager().bindTexture(tex);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
		for (int i = 0; i < 3; ++i){
			for ( int j = 0; j < 9; j++){
				this.drawTexturedModalRect(x+ 8 + j * 18,y + 18 + i * 18, 177, 0, 18, 18);
				int par = ((TileEntityFreezer)this.tileFreezer).getFreezingTime(j+i*9) * 18 / TileEntityFreezer.FREEZING_TIME_MAX;
				this.drawTexturedModalRect(x+ 8 + j * 18,y + 18 + i * 18,177, 18, par, 18);
			}
		}
    	GlStateManager.enableDepth();
    	GlStateManager.popMatrix();
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(tex);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
	}
}
