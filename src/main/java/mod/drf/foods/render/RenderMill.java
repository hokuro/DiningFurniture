package mod.drf.foods.render;

import mod.drf.foods.tileentity.TileEntityMill;
import mod.drf.model.ModelFlape;
import mod.drf.model.ModelFlapeMaker;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderMill extends TileEntitySpecialRenderer<TileEntityMill> {

	private static final ResourceLocation tex = new ResourceLocation("drf:textures/entity/flapemaker.png");
	private static final ResourceLocation tex_flape = new ResourceLocation("der:textures/entity/flape_none.png");

	private ModelBase mainModel = new ModelFlapeMaker();
	private ModelBase subModel = new ModelFlape();

	@Override
	public void renderTileEntityAt(TileEntityMill te, double x, double y, double z, float partialTicks, int destroyStage) {
		renderMill((TileEntityMill)te,x,y,z,partialTicks,destroyStage);

	}


	public void renderMill(TileEntityMill te, double x, double y, double z, float partialTicks, int destroyStage) {
		double sx,sy,sz = 0.0D;
		double tx,ty,tz = 0.0D;
		sx = sy = sz = 0.03125D;
		tx = ty = tz = 0.5D;

//		GlStateManager.pushMatrix();
//		GlStateManager.translate((float) x + 0.5F , (float) y + 0.5F, (float) z + 0.5F);
//		GlStateManager.scale(0.03125D, 0.03125D, 0.03125D);
//		GlStateManager.enableCull();
//		GlStateManager.enableRescaleNormal();
//		this.bindTexture(tex);
//		this.mainmodel.render(1.0F);
//		GlStateManager.popMatrix();
//
//
//		if (((BlockFuse)ModRegisterBlock.block_Fuse).shouldConnectTo(te.getWorld().getBlockState(te.getPos().add(1,0,0)))){
//			GlStateManager.pushMatrix();
//			GlStateManager.translate((float) x + 0.875D , (float) y + 0.5, (float) z + 0.5);
//			GlStateManager.scale(0.015625D, 0.03125D, 0.03125D);
//			GlStateManager.enableCull();
//			GlStateManager.enableRescaleNormal();
//			this.bindTexture(tex);
//			this.mainmodel.render(1.0F);
//			GlStateManager.popMatrix();
//		}
//		if (((BlockFuse)ModRegisterBlock.block_Fuse).shouldConnectTo(te.getWorld().getBlockState(te.getPos().add(-1,0,0)))){
//			GlStateManager.pushMatrix();
//			GlStateManager.translate((float) x + 0.125D , (float) y + 0.5, (float) z + 0.5);
//			GlStateManager.scale(0.015625D, 0.03125D, 0.03125D);
//			GlStateManager.enableCull();
//			GlStateManager.enableRescaleNormal();
//			this.bindTexture(tex);
//			this.mainmodel.render(1.0F);
//			GlStateManager.popMatrix();
//		}
//
//		if (((BlockFuse)ModRegisterBlock.block_Fuse).shouldConnectTo(te.getWorld().getBlockState(te.getPos().add(0,1,0)))){
//			GlStateManager.pushMatrix();
//			GlStateManager.translate((float) x + 0.5D , (float) y + 0.875D, (float) z + 0.5);
//			GlStateManager.scale(0.03125D, 0.015625D, 0.03125D);
//			GlStateManager.enableCull();
//			GlStateManager.enableRescaleNormal();
//			this.bindTexture(tex);
//			this.mainmodel.render(1.0F);
//			GlStateManager.popMatrix();
//		}
//		if (((BlockFuse)ModRegisterBlock.block_Fuse).shouldConnectTo(te.getWorld().getBlockState(te.getPos().add(0,-1,0)))){
//			GlStateManager.pushMatrix();
//			GlStateManager.translate((float) x + 0.5D , (float) y + 0.125D, (float) z + 0.5);
//			GlStateManager.scale(0.03125D, 0.015625D, 0.03125D);
//			GlStateManager.enableCull();
//			GlStateManager.enableRescaleNormal();
//			this.bindTexture(tex);
//			this.mainmodel.render(1.0F);
//			GlStateManager.popMatrix();
//		}
//
//		if (((BlockFuse)ModRegisterBlock.block_Fuse).shouldConnectTo(te.getWorld().getBlockState(te.getPos().add(0,0,1)))){
//			GlStateManager.pushMatrix();
//			GlStateManager.translate((float) x + 0.5D , (float) y + 0.5D, (float) z + 0.875D);
//			GlStateManager.scale(0.03125D, 0.03125D, 0.015625D);
//			GlStateManager.enableCull();
//			GlStateManager.enableRescaleNormal();
//			this.bindTexture(tex);
//			this.mainmodel.render(1.0F);
//			GlStateManager.popMatrix();
//		}
//		if (((BlockFuse)ModRegisterBlock.block_Fuse).shouldConnectTo(te.getWorld().getBlockState(te.getPos().add(0,0,-1)))){
//			GlStateManager.pushMatrix();
//			GlStateManager.translate((float) x + 0.5D , (float) y + 0.5D, (float) z + 0.125D);
//			GlStateManager.scale(0.03125D, 0.03125D, 0.015625D);
//			GlStateManager.enableCull();
//			GlStateManager.enableRescaleNormal();
//			this.bindTexture(tex);
//			this.mainmodel.render(1.0F);
//			GlStateManager.popMatrix();
//		}
	}

}
