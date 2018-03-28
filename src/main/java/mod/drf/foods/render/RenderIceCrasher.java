package mod.drf.foods.render;

import mod.drf.foods.model.ModelCrashedIce;
import mod.drf.foods.model.ModelCrashedIce.EnumCrashedIceLevel;
import mod.drf.foods.model.ModelIceCrasher;
import mod.drf.foods.tileentity.TileEntityIceCrasher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderIceCrasher extends TileEntitySpecialRenderer<TileEntityIceCrasher> {
	private static final ResourceLocation tex = new ResourceLocation("drf:textures/entity/icecrasher.png");
	private static final ResourceLocation tex_flape = new ResourceLocation("drf:textures/entity/crashedice_none.png");

	private ModelIceCrasher mainModel = new ModelIceCrasher();
	private ModelCrashedIce subModel = new ModelCrashedIce();

	@Override
	public void render(TileEntityIceCrasher te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		renderFlapeMaker((TileEntityIceCrasher)te,x,y,z,partialTicks,destroyStage);

	}


	public void renderFlapeMaker(TileEntityIceCrasher te, double x, double y, double z, float partialTicks, int destroyStage) {
		double sx,sy,sz = 0.0D;
		double tx,ty,tz = 0.0D;
		sx = sy = sz = 0.03125D;
		tx = ty = tz = 0.5D;

        if (destroyStage >= 0)
        {
            this.bindTexture(DESTROY_STAGES[destroyStage]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(5.0F, 4.0F, 1.0F);
            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        }else{
    		this.bindTexture(tex);
        }

		GlStateManager.pushMatrix();
		GlStateManager.enableBlend();
		GlStateManager.translate((float) x + 0.5F , (float) y + 1.0F, (float) z + 0.5F);
		GlStateManager.scale(0.0625D,0.0625D,0.0625D);
		GlStateManager.rotate(180,0F,0F,1F);
		int idx = te.face().getHorizontalIndex();
		GlStateManager.rotate(90F * (idx+2),0F,1F,0F);
		GlStateManager.enableCull();
		GlStateManager.enableRescaleNormal();
		this.mainModel.render(te, EnumCrashedIceLevel.LV4_FULL, 1.0F);
		GlStateManager.disableBlend();
		GlStateManager.popMatrix();



		if (te.isRunning() || te.getField(3)!=0){
			GlStateManager.pushMatrix();
			GlStateManager.enableBlend();
			GlStateManager.translate((float) x + 0.5F , (float) y-0.42F, (float) z + 0.5F);
			GlStateManager.scale(1.5D,1.5D,1.5D);
			GlStateManager.rotate(0,0F,0F,1F);
			GlStateManager.enableCull();
			GlStateManager.enableRescaleNormal();
			this.bindTexture(tex_flape);
			if(te.isRunning()){
				this.subModel.render(EnumCrashedIceLevel.getValue(TileEntityIceCrasher.CRUSH_TIME_MAX, te.getField(0)), 0, 0, 0, 0.0125F);
			}else{
				this.subModel.render(EnumCrashedIceLevel.LV4_FULL, 0, 0, 0, 0.0125F);
			}
			GlStateManager.disableBlend();
			GlStateManager.popMatrix();
		}
        if (destroyStage >= 0)
        {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
	}
}
