package mod.drf.foods.render;

import mod.drf.foods.model.ModelFreezer;
import mod.drf.foods.tileentity.TileEntityFreezer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderFreezer extends TileEntitySpecialRenderer<TileEntityFreezer> {
	private static final ResourceLocation tex = new ResourceLocation("drf:textures/entity/freezer.png");

	private ModelFreezer mainModel = new ModelFreezer();

	@Override
	public void renderTileEntityAt(TileEntityFreezer te, double x, double y, double z, float partialTicks, int destroyStage) {
		renderFreezer(te,x,y,z,partialTicks,destroyStage);
	}

	public void renderFreezer(TileEntityFreezer te, double x, double y, double z, float partialTicks, int destroyStage) {
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x + 0.5F , (float) y + 1.13F, (float) z + 0.5F);
		GlStateManager.scale(0.0625,0.0625,0.0625D);
		GlStateManager.rotate(180,0F,0F,1F);
		int idx = te.getFace().getHorizontalIndex();
		GlStateManager.rotate(90F * (idx+2),0F,1F,0F);
		GlStateManager.enableCull();
		GlStateManager.enableRescaleNormal();
		this.bindTexture(tex);

		float rotate = 0.0F;
		this.mainModel.render(1.0F, rotate);
		GlStateManager.popMatrix();
	}

}
