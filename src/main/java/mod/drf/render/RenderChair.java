package mod.drf.render;

import org.lwjgl.opengl.GL11;

import mod.drf.entity.EntityChair;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class RenderChair  extends EntityRenderer<EntityChair>{

    public RenderChair(EntityRendererManager renderManagerIn)
    {
        super(renderManagerIn);
		shadowSize = 0.5F;
    }

    @Override
    public void doRender(EntityChair entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
		doRenderZabuton(entity, x, y, z, entityYaw, partialTicks);
    }

	public void doRenderZabuton(EntityChair entityzabuton, double x, double y, double z, float yaw, float tic) {
		// レンダリング実装
		// レンダリング
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glRotatef(180F - yaw, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(-1F, -1F, 1.0F);
		bindEntityTexture(entityzabuton);
		entityzabuton.renderChairModel();
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityChair entity) {
		return entity.getEntityTexture(entity);
	}
}
