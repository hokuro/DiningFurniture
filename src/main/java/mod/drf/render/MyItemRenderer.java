package mod.drf.render;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MyItemRenderer extends ItemRenderer{
	private final net.minecraft.client.renderer.ItemRenderer itemRenderer2;

	public MyItemRenderer(EntityRendererManager renderManagerIn, net.minecraft.client.renderer.ItemRenderer p_i46167_2_) {
		super(renderManagerIn, p_i46167_2_);
		itemRenderer2 = p_i46167_2_;
		this.shadowSize = 0.15F;
		this.shadowOpaque = 0.75F;
	}

	public void doRender(ItemEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
	//	super.doRender(entity, x, y, z, entityYaw, partialTicks);
		ItemStack itemstack = entity.getItem();

		boolean flag = false;
		if (this.bindEntityTexture(entity)) {
			this.renderManager.textureManager.getTexture(this.getEntityTexture(entity)).setBlurMipmap(false, false);
			flag = true;
		}

		GlStateManager.enableRescaleNormal();
		GlStateManager.alphaFunc(516, 0.1F);
		GlStateManager.enableBlend();
		RenderHelper.enableStandardItemLighting();
		GlStateManager.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager.pushMatrix();
		IBakedModel ibakedmodel = this.itemRenderer2.getItemModelWithOverrides(itemstack, entity.world, (LivingEntity)null);
		int j = this.transformModelCount(entity, x, y, z, partialTicks, ibakedmodel);
		boolean flag1 = ibakedmodel.isGui3d();
		if (!flag1) {
			float f3 = -0.0F * (float)(1 - 1) * 0.5F;
			float f4 = -0.0F * (float)(1 - 1) * 0.5F;
			float f5 = -0.09375F * (float)(1 - 1) * 0.5F;
			GlStateManager.translatef(f3, f4, f5);
		}

		if (this.renderOutlines) {
			GlStateManager.enableColorMaterial();
			GlStateManager.setupSolidRenderingTextureCombine(this.getTeamColor(entity));
		}

		      for(int k = 0; k < j; ++k) {
		         if (flag1) {
		            GlStateManager.pushMatrix();
//		            if (k > 0) {
//		               float f7 = (1 - 1.0F) * 0.15F;
//		               float f9 = (1 - 1.0F) * 0.15F;
//		               float f6 = (1 - 1.0F) * 0.15F;
//		               GlStateManager.translatef(shouldSpreadItems() ? f7 : 0, shouldSpreadItems() ? f9 : 0, f6);
//		            }

		            IBakedModel transformedModel = net.minecraftforge.client.ForgeHooksClient.handleCameraTransforms(ibakedmodel, ItemCameraTransforms.TransformType.GROUND, false);
		            this.itemRenderer2.renderItem(itemstack, transformedModel);
		            GlStateManager.popMatrix();
		         } else {
		            GlStateManager.pushMatrix();
//		            if (k > 0) {
//		               float f8 = (1 - 1.0F) * 0.15F * 0.5F;
//		               float f10 = (1 - 1.0F) * 0.15F * 0.5F;
//		               GlStateManager.translatef(f8, f10, 0.0F);
//		            }

		            IBakedModel transformedModel = net.minecraftforge.client.ForgeHooksClient.handleCameraTransforms(ibakedmodel, ItemCameraTransforms.TransformType.GROUND, false);
		            this.itemRenderer2.renderItem(itemstack, transformedModel);
		            GlStateManager.popMatrix();
		            GlStateManager.translatef(0.0F, 0.0F, 0.09375F);
		         }
		      }

		if (this.renderOutlines) {
			GlStateManager.tearDownSolidRenderingTextureCombine();
			GlStateManager.disableColorMaterial();
		}

		GlStateManager.popMatrix();
		GlStateManager.disableRescaleNormal();
		GlStateManager.disableBlend();
		this.bindEntityTexture(entity);
		if (flag) {
			this.renderManager.textureManager.getTexture(this.getEntityTexture(entity)).restoreLastBlurMipmap();
		}
		if (!this.renderOutlines) {
			this.renderName(entity, x, y, z);
		}
	}

	private int transformModelCount(ItemEntity itemIn, double p_177077_2_, double p_177077_4_, double p_177077_6_, float p_177077_8_, IBakedModel p_177077_9_) {
		ItemStack itemstack = itemIn.getItem();
		Item item = itemstack.getItem();
		if (item == null) {
			return 1;
		} else {
			boolean flag = p_177077_9_.isGui3d();
			GlStateManager.translatef((float)p_177077_2_, (float)p_177077_4_ + 0.1F, (float)p_177077_6_);
			if (flag || this.renderManager.options != null) {
				float f3 = (((float)itemIn.getAge() + p_177077_8_) / 20.0F) * (180F / (float)Math.PI);
				GlStateManager.rotatef(f3, 0.0F, 1.0F, 0.0F);
			}
			GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			return 1;
		}
	}
}
