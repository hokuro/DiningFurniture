package mod.drf.foods.render;

import mod.drf.core.log.ModLog;
import mod.drf.foods.model.ModelFreezer;
import mod.drf.foods.tileentity.TileEntityFreezer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderFreezer extends TileEntitySpecialRenderer<TileEntityFreezer> {
	private static final ResourceLocation tex = new ResourceLocation("drf:textures/entity/freezer.png");

	private ModelFreezer mainModel = new ModelFreezer();

	@Override
	public void render(TileEntityFreezer te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		renderFreezer(te,x,y,z,partialTicks,destroyStage);
	}

	public void renderFreezer(TileEntityFreezer te, double x, double y, double z, float partialTicks, int destroyStage) {
        if (destroyStage >= 0)
        {
            this.bindTexture(DESTROY_STAGES[destroyStage]);
            ModLog.log().debug(Integer.toString(destroyStage));
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(5.0F, 4.0F, 1.0F);
            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        }else{
    		this.bindTexture(tex);
        }
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x + 0.5F , (float) y + 1.13F, (float) z + 0.5F);
		GlStateManager.scale(0.0625,0.0625,0.0625D);
		GlStateManager.rotate(180,0F,0F,1F);
		int idx = te.getFace().getHorizontalIndex();
		GlStateManager.rotate(90F * (idx+2),0F,1F,0F);
		GlStateManager.enableCull();
		GlStateManager.enableRescaleNormal();
		float rotate = te.prevLidAngle + (te.lidAngle - te.prevLidAngle) * partialTicks;
		rotate = (rotate * ((float)Math.PI / 2F));
		this.mainModel.render(1.0F, rotate);
		GlStateManager.popMatrix();
        if (destroyStage >= 0)
        {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
	}

}
