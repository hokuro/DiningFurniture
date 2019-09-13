package mod.drf.render;

import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;

import mod.drf.model.ModeWoodlTable;
import mod.drf.tileentity.TileEntityWoodTable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.util.ResourceLocation;

public class RenderWoodTable extends TileEntityRenderer<TileEntityWoodTable> {

	private static final ResourceLocation tex1 = new ResourceLocation("drf:textures/entity/woodtable_acacia.png");
	private static final ResourceLocation tex2 = new ResourceLocation("drf:textures/entity/woodtable_birch.png");
	private static final ResourceLocation tex3 = new ResourceLocation("drf:textures/entity/woodtable_darkoak.png");
	private static final ResourceLocation tex4 = new ResourceLocation("drf:textures/entity/woodtable_jungle.png");
	private static final ResourceLocation tex5 = new ResourceLocation("drf:textures/entity/woodtable_oak.png");
	private static final ResourceLocation tex6 = new ResourceLocation("drf:textures/entity/woodtable_spruce.png");

	private ModeWoodlTable mainModel = new ModeWoodlTable();
	private MyItemRenderer itemRender;

	public RenderWoodTable() {
		super();
		itemRender = new MyItemRenderer(Minecraft.getInstance().getRenderManager(), Minecraft.getInstance().getItemRenderer());
	}

	@Override
	public void render(TileEntityWoodTable te, double x, double y, double z, float partialTicks, int destroyStage) {
		dorender((TileEntityWoodTable)te,x,y,z,partialTicks,destroyStage);
	}

	public void dorender(TileEntityWoodTable te, double x, double y, double z, float partialTicks, int destroyStage) {

        if (destroyStage >= 0)
        {
            this.bindTexture(DESTROY_STAGES[destroyStage]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scalef(5.0F, 4.0F, 1.0F);
            GlStateManager.translatef(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        }else{
        	this.bindTexture(setTexture(te));
        }

		GlStateManager.pushMatrix();
		GlStateManager.enableBlend();
		GlStateManager.translatef((float) x + 0.5F , (float) y + 1.0F, (float) z + 0.5F);
		GlStateManager.scaled(0.0625D,0.0625D,0.0625D);
		GlStateManager.rotatef(180,0F,0F,1F);
		GlStateManager.enableCull();
		GlStateManager.enableRescaleNormal();
		GlStateManager.disableLighting();
		GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, 15 * 16, 15 * 16);
		this.mainModel.render(1.0F);
		GlStateManager.enableLighting();
		GlStateManager.disableBlend();
		GlStateManager.popMatrix();


		if (!te.isEmpty()) {
			ItemEntity itement = te.getItemEntity();
			itemRender.doRender(itement, x + 0.5, y + 1.0, z + 0.5, partialTicks, partialTicks);
		}


        if (destroyStage >= 0)
        {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
	}


	private ResourceLocation setTexture(TileEntityWoodTable te) {
		ResourceLocation ret;
		switch(te.getWoodType()) {
		case ACACIA_WOOD:
			ret = tex1;
			break;
		case BIRCH_WOOD:
			ret = tex2;
			break;
		case DARK_OAK_WOOD:
			ret = tex3;
			break;
		case JUNGLE_WOOD:
			ret = tex4;
			break;
		case OAK_WOOD:
			ret = tex5;
			break;
		case SPRUCE_WOOD:
			ret = tex6;
			break;
		default:
			ret = tex5;
			break;
		}
		return ret;
	}
}
