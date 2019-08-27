package mod.drf.foods.gui;

import java.util.ArrayList;
import java.util.List;

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
        this.xSize = 211;
        this.ySize = 222;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = this.tileFreezer.getDisplayName().getFormattedText();
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);

        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        if ((mouseX > (x + 22) && mouseX < (x + 22 + 7)) &&
        		(mouseY > (y + 73) && mouseY < (y + 73 + 42))){
        	drawToolTip(tileFreezer,mouseX-x,mouseY);
        }
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks){
    	super.render(mouseX, mouseY, partialTicks);


    	GlStateManager.pushMatrix();
    	GlStateManager.disableDepthTest();
        GlStateManager.color4f(5.0F, 5.0F, 5.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(tex);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;


        // タンク容量
        TileEntityFreezer tile = ((TileEntityFreezer)this.tileFreezer);
        int tankCnt = tile.getTankCnt();
        int iceTimer = tile.getIcingTime();
        int fuel = tile.getFuel();
        boolean infinit = tile.IsInfinitFuel();

        // 冷凍室バー
		for (int i = 0; i < 3; ++i){
			for ( int j = 0; j < 9; j++){
				this.drawTexturedModalRect(x + 44 + j * 18, y + 18 + i * 18, 212, 0, 18, 18);
				int par = tile.getFreezingTime(j+i*9) * 18 / TileEntityFreezer.FREEZING_TIME_MAX;
				this.drawTexturedModalRect(x + 44 + j * 18, y + 18 + i * 18, 212, 18, par, 18);
			}
		}

		// 燃料バー
		this.drawTexturedModalRect(x + 17, y + 18, 212, 0, 18, 18);
		int par = tile.IsInfinitFuel()?18:18 * tile.getFuel()/TileEntityFreezer.FREEZING_FULE_TIME;
		this.drawTexturedModalRect(x + 17, y + 18, 212, 18, par, 18);

		// 製氷室バー
		this.drawTexturedModalRect(x + 17, y + 44 + 18 * 4, 212, 0, 18, 18);
		this.drawTexturedModalRect(x + 17, y + 44 + 18 * 4, 212, 18, 18 * tile.getIcingTime()/TileEntityFreezer.FREEZING_TIME_MAX, 18);

		// タンク
		this.drawTexturedModalRect(x + 22, y + 73, 212, 37, 7, (int)(42 * (1.0D-((double)tile.getTankCnt()/TileEntityFreezer.TANK_MAX))));
    	GlStateManager.enableDepthTest();
    	GlStateManager.popMatrix();
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(tex);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
	}

    protected void drawToolTip(IInventory te, int x, int y)
    {
    	if (te instanceof TileEntityFreezer){
            int tankCnt = ((TileEntityFreezer)te).getTankCnt();

            List<String> list = new ArrayList<String>();
            list.add(Integer.toString(tankCnt) + "/" + Integer.toString(TileEntityFreezer.TANK_MAX));
            this.drawHoveringText(list, x, y, this.mc.fontRenderer);
    	}
    }
}
