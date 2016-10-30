package mod.drf.foods.render;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.opengl.GL11;

import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.entity.EntityIceCream;
import mod.drf.foods.model.ModelIcecream;
import mod.drf.foods.model.ModelIcecream.EnumIcecreamLevel;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderIceCream extends Render<EntityIceCream> {

	private ModelIcecream mainmodel;
	protected static final Map<ItemFoods.EnumIceFlavor,ResourceLocation> textures = new HashMap<ItemFoods.EnumIceFlavor,ResourceLocation> (){
		{put(ItemFoods.EnumIceFlavor.ICE_APPLE,new ResourceLocation("drf:textures/entity/icecream_apple.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_BLACK,new ResourceLocation("drf:textures/entity/icecream_black.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_CARROT,new ResourceLocation("drf:textures/entity/icecream_carrot.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_CHOCO,new ResourceLocation("drf:textures/entity/icecream_choco.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_POTATO,new ResourceLocation("drf:textures/entity/icecream_potato.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_PUMPKIN,new ResourceLocation("drf:textures/entity/icecream_pumpkin.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_VANILA,new ResourceLocation("drf:textures/entity/icecream_vanila.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_MELLON,new ResourceLocation("drf:textures/entity/icecream_wmellon.png"));}
	};

	public RenderIceCream(RenderManager renderManager) {
		super(renderManager);
		shadowSize = 0.1F;
		mainmodel = new ModelIcecream();
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityIceCream entity) {
		return  textures.get(entity.getFlavor());
	}

    @Override
    public void doRender(EntityIceCream entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	doRenderIceCream(entity, x, y, z, entityYaw, partialTicks);
    }

	public void doRenderIceCream(EntityIceCream entityzabuton, double x, double y, double z, float yaw, float tic) {
		// レンダリング実装
		// レンダリング

		shadowSize = 0.2F;
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y-0.69F, (float)z);
		//GL11.glTranslatef((float)x +0.5F, (float)y-0.69F, (float)z+0.5F);
		GL11.glRotatef(180F - yaw, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		bindEntityTexture(entityzabuton);
		mainmodel.render(EnumIcecreamLevel.LEVEL4,0.0625F);
		GL11.glPopMatrix();
	}

}
