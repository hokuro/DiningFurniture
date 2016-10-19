package mod.drf.foods.render;

import mod.drf.foods.model.ModelMill;
import mod.drf.foods.tileentity.TileEntityMill;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderMill extends TileEntitySpecialRenderer<TileEntityMill> {

	private static final ResourceLocation tex = new ResourceLocation("drf:textures/entity/mill.png");

	private ModelBase mainModel = new ModelMill();
	@Override
	public void renderTileEntityAt(TileEntityMill te, double x, double y, double z, float partialTicks, int destroyStage) {
		renderMill((TileEntityMill)te,x,y,z,partialTicks,destroyStage);

	}


	public void renderMill(TileEntityMill te, double x, double y, double z, float partialTicks, int destroyStage) {
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x + 0.5F , (float) y + 1.0F, (float) z + 0.5F);
		GlStateManager.scale(0.625D,0.625D,0.625D);
		GlStateManager.rotate(180,0F,0F,1F);
		GlStateManager.enableCull();
		GlStateManager.enableRescaleNormal();
		this.bindTexture(tex);
		float rotate = te.getField(0)/
		this.mainModel.render(1.0F);
		GlStateManager.popMatrix();
	}

}
