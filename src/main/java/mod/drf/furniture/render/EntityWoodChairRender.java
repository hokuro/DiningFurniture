package mod.drf.furniture.render;

import org.lwjgl.opengl.GL11;

import mod.drf.furniture.entity.EntityWoodChair;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class EntityWoodChairRender extends Render<EntityWoodChair>{
    public EntityWoodChairRender(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
		shadowSize = 0.5F;
    }
    public float c =0;
    @Override
    public void doRender(EntityWoodChair entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
		doRenderZabuton(entity, x, y, z, entityYaw, partialTicks);
    }

	public void doRenderZabuton(EntityWoodChair entityzabuton, double x, double y, double z, float yaw, float tic) {
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
	protected ResourceLocation getEntityTexture(EntityWoodChair entity) {
		return entity.getEntityTexture(entity);
	}

}
