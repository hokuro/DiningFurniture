package mod.drf.foods.render;

import mod.drf.foods.model.ModelFlape;
import mod.drf.foods.model.ModelFlapeMaker;
import mod.drf.foods.model.ModelFlape.EnumFlapeLevel;
import mod.drf.foods.tileentity.TileEntityFlapeMaker;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderFlapeMaker extends TileEntitySpecialRenderer<TileEntityFlapeMaker> {
	private static final ResourceLocation tex = new ResourceLocation("drf:textures/entity/flapemaker.png");
	private static final ResourceLocation tex_flape = new ResourceLocation("drf:textures/entity/flape_none.png");

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
		GlStateManager.translate((float) x + 0.5F , (float) y + 1.0F, (float) z + 0.5F);
		GlStateManager.scale(0.625D,0.625D,0.625D);
		GlStateManager.rotate(180,0F,0F,1F);
		int idx = te.face().getHorizontalIndex();
		GlStateManager.rotate(90F * (idx+2),0F,1F,0F);
		GlStateManager.enableCull();
		GlStateManager.enableRescaleNormal();
		this.bindTexture(tex);
		this.mainModel.render(te,0F,0F,0F,0F,0F,0.1F);
		GlStateManager.popMatrix();

		if (te.isRunning()){
			GlStateManager.pushMatrix();
			GlStateManager.enableBlend();
			GlStateManager.translate((float) x + 0.5F , (float) y + 0.63F, (float) z + 0.5F);

			GlStateManager.scale(2.1D,2.1D,2.1D);
			GlStateManager.rotate(180,0F,0F,1F);
			GlStateManager.enableCull();
			GlStateManager.enableRescaleNormal();
			this.bindTexture(tex_flape);
			this.subModel.render(EnumFlapeLevel.getValue(TileEntityFlapeMaker.CRUSH_TIME_MAX, te.getField(0)), 0, EnumFlapeLevel.RotationY(TileEntityFlapeMaker.CRUSH_TIME_MAX, te.getField(0)), 0, 0.0125F);
			GlStateManager.disableBlend();
			GlStateManager.popMatrix();
		}else if (te.getField(3)!=0){
			GlStateManager.pushMatrix();
			GlStateManager.enableBlend();
			GlStateManager.translate((float) x + 0.5F , (float) y + 0.63F, (float) z + 0.5F);
			GlStateManager.scale(2.1D,2.1D,2.1D);
			GlStateManager.rotate(180,0F,0F,1F);
			GlStateManager.enableCull();
			GlStateManager.enableRescaleNormal();
			this.bindTexture(tex_flape);
			this.subModel.render(EnumFlapeLevel.LEVEL4, 0, 0, 0, 0.0125F);
			GlStateManager.disableBlend();
			GlStateManager.popMatrix();
		}
	}
}
