package mod.drf.foods.render;

import mod.drf.core.log.ModLog;
import mod.drf.foods.model.ModelMillStone;
import mod.drf.foods.tileentity.TileEntityMillStone;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderMillStone extends TileEntitySpecialRenderer<TileEntityMillStone> {

	private static final ResourceLocation tex = new ResourceLocation("drf:textures/entity/millstone.png");

	private ModelMillStone mainModel = new ModelMillStone();
	@Override
	public void renderTileEntityAt(TileEntityMillStone te, double x, double y, double z, float partialTicks, int destroyStage) {
		renderMill((TileEntityMillStone)te,x,y,z,partialTicks,destroyStage);

	}


	public void renderMill(TileEntityMillStone te, double x, double y, double z, float partialTicks, int destroyStage) {
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
