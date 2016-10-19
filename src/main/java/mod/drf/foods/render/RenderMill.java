package mod.drf.foods.render;

import mod.drf.core.log.ModLog;
import mod.drf.foods.model.ModelMill;
import mod.drf.foods.tileentity.TileEntityMill;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderMill extends TileEntitySpecialRenderer<TileEntityMill> {

	private static final ResourceLocation tex = new ResourceLocation("drf:textures/entity/mill.png");

	private ModelMill mainModel = new ModelMill();
	@Override
	public void renderTileEntityAt(TileEntityMill te, double x, double y, double z, float partialTicks, int destroyStage) {
		renderMill((TileEntityMill)te,x,y,z,partialTicks,destroyStage);

	}


	public void renderMill(TileEntityMill te, double x, double y, double z, float partialTicks, int destroyStage) {
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
		GlStateManager.translate((float) x + 0.5F , (float) y + 1.5F, (float) z + 0.5F);
		GlStateManager.scale(0.0625D,0.0625D,0.0625D);
		GlStateManager.rotate(180,0F,0F,1F);
		GlStateManager.enableCull();
		GlStateManager.enableRescaleNormal();
		float rotate = (float)(4*Math.PI*(((float)te.getField(0)/(float)te.MILL_TIME_MAX)));
		this.mainModel.render(1.0F,rotate);
		GlStateManager.popMatrix();
        if (destroyStage >= 0)
        {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
	}

}
