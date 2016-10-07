package mod.drf.foods.render;

import mod.drf.foods.tileentity.TileEntityFlapeMaker;
import mod.drf.model.ModelFlape;
import mod.drf.model.ModelFlape.EnumFlapeLevel;
import mod.drf.model.ModelFlapeMaker;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderFlapeMaker extends TileEntitySpecialRenderer<TileEntityFlapeMaker> {
	private static final ResourceLocation tex = new ResourceLocation("drf:textures/entity/flapemaker.png");
	private static final ResourceLocation tex_flape = new ResourceLocation("der:textures/entity/flape_none.png");

	private ModelFlapeMaker mainModel = new ModelFlapeMaker();
	private ModelFlape subModel = new ModelFlape();

	@Override
	public void renderTileEntityAt(TileEntityFlapeMaker te, double x, double y, double z, float partialTicks, int destroyStage) {
		renderFlapeMaker((TileEntityFlapeMaker)te,x,y,z,partialTicks,destroyStage);

	}


	public void renderFlapeMaker(TileEntityFlapeMaker te, double x, double y, double z, float partialTicks, int destroyStage) {
		double sx,sy,sz = 0.0D;
		double tx,ty,tz = 0.0D;
		sx = sy = sz = 0.03125D;
		tx = ty = tz = 0.5D;

		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x + 0.5F , (float) y + 0.5F, (float) z + 0.5F);
		GlStateManager.scale(0.625D,0.625D,0.625D);
		GlStateManager.enableCull();
		GlStateManager.enableRescaleNormal();
		this.bindTexture(tex);
		this.mainModel.render(te,0F,0F,0F,0F,0F,1F);
		GlStateManager.popMatrix();

		if (TileEntityFlapeMaker.isRunning(te)){
			GlStateManager.pushMatrix();
			GlStateManager.translate((float) x + 0.5F , (float) y + 0.5F, (float) z + 0.5F);
			GlStateManager.scale(0.0125D,0.0125D,0.0125D);
			GlStateManager.enableCull();
			GlStateManager.enableRescaleNormal();
			this.bindTexture(tex_flape);
			this.subModel.render(EnumFlapeLevel.getValue(TileEntityFlapeMaker.CRUSH_TIME_MAX, te.getField(0)), 0, EnumFlapeLevel.RotationY(TileEntityFlapeMaker.CRUSH_TIME_MAX, te.getField(0)), 0, 0.0125F);
			GlStateManager.popMatrix();
		}
	}
}
