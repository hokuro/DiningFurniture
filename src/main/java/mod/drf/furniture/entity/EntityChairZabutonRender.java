package mod.drf.furniture.entity;

import org.lwjgl.opengl.GL11;

import mod.drf.furniture.model.ModelZabuton;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class EntityChairZabutonRender extends Render<EntityChairZabuton>{
	protected ModelZabuton mainmodel;
	protected ResourceLocation[] textures = new ResourceLocation[] {
			new ResourceLocation("chairs:textures/entity/zabuton_f.png"),
			new ResourceLocation("chairs:textures/entity/zabuton_e.png"),
			new ResourceLocation("chairs:textures/entity/zabuton_d.png"),
			new ResourceLocation("chairs:textures/entity/zabuton_c.png"),
			new ResourceLocation("chairs:textures/entity/zabuton_b.png"),
			new ResourceLocation("chairs:textures/entity/zabuton_a.png"),
			new ResourceLocation("chairs:textures/entity/zabuton_9.png"),
			new ResourceLocation("chairs:textures/entity/zabuton_8.png"),
			new ResourceLocation("chairs:textures/entity/zabuton_7.png"),
			new ResourceLocation("chairs:textures/entity/zabuton_6.png"),
			new ResourceLocation("chairs:textures/entity/zabuton_5.png"),
			new ResourceLocation("chairs:textures/entity/zabuton_4.png"),
			new ResourceLocation("chairs:textures/entity/zabuton_3.png"),
			new ResourceLocation("chairs:textures/entity/zabuton_2.png"),
			new ResourceLocation("chairs:textures/entity/zabuton_1.png"),
			new ResourceLocation("chairs:textures/entity/zabuton_0.png")
	};

    public EntityChairZabutonRender(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
		shadowSize = 0.5F;
		mainmodel = new ModelZabuton();
    }

    @Override
    public void doRender(EntityChairZabuton entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
		doRenderZabuton(entity, x, y, z, entityYaw, partialTicks);
    }

	public void doRenderZabuton(EntityChairZabuton entityzabuton, double x, double y, double z, float yaw, float tic) {
		// レンダリング実装
		// レンダリング
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glRotatef(180F - yaw, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(-1F, -1F, 1.0F);
		bindEntityTexture(entityzabuton);
		mainmodel.render(0.0625F);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityChairZabuton entity) {
		if(entity.color >= 0 && entity.color < 16){
			return textures[entity.color];
		}else{
			return textures[0];
		}
	}
}
