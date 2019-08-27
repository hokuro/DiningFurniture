package mod.drf.foods.render;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.opengl.GL11;

import mod.drf.config.ConfigValue;
import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.entity.EntityIceCream;
import mod.drf.foods.model.ModelIcecream;
import mod.drf.foods.model.ModelIcecream.EnumIcecreamLevel;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderIceCream extends Render<EntityIceCream> {

	private ModelIcecream mainmodel;
	protected static final Map<ItemFoods.EnumIceFlavor,ResourceLocation> textures = new HashMap<ItemFoods.EnumIceFlavor,ResourceLocation> (){
		{put(ItemFoods.EnumIceFlavor.ICE_VANILA ,new ResourceLocation("drf:textures/entity/icecream_vanila.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_BLACK ,new ResourceLocation("drf:textures/entity/icecream_black.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_RED ,new ResourceLocation("drf:textures/entity/icecream_red.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_GREEN ,new ResourceLocation("drf:textures/entity/icecream_green.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_BROWN ,new ResourceLocation("drf:textures/entity/icecream_brown.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_BLUE ,new ResourceLocation("drf:textures/entity/icecream_blue.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_PURPLE ,new ResourceLocation("drf:textures/entity/icecream_purple.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_CYAN ,new ResourceLocation("drf:textures/entity/icecream_cyan.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_SILVER ,new ResourceLocation("drf:textures/entity/icecream_silver.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_GRAY ,new ResourceLocation("drf:textures/entity/icecream_gray.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_PINK ,new ResourceLocation("drf:textures/entity/icecream_pink.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_LIME ,new ResourceLocation("drf:textures/entity/icecream_lime.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_YELLOW ,new ResourceLocation("drf:textures/entity/icecream_yellow.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_LIGHT_BLUE ,new ResourceLocation("drf:textures/entity/icecream_light_blue.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_MAGENTA ,new ResourceLocation("drf:textures/entity/icecream_magenta.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_ORANGE ,new ResourceLocation("drf:textures/entity/icecream_orange.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_WHITE ,new ResourceLocation("drf:textures/entity/icecream_white.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_APPLE ,new ResourceLocation("drf:textures/entity/icecream_apple.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_CACTUS ,new ResourceLocation("drf:textures/entity/icecream_cactus.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_PUMPKIN ,new ResourceLocation("drf:textures/entity/icecream_pumpkin.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_POTATO ,new ResourceLocation("drf:textures/entity/icecream_potato.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_CARROT ,new ResourceLocation("drf:textures/entity/icecream_callot.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_MELON ,new ResourceLocation("drf:textures/entity/icecream_mellon.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_GREENTEA ,new ResourceLocation("drf:textures/entity/icecream_greentea.png"));}

	};

	protected static final Map<ItemFoods.EnumIceFlavor,ResourceLocation> textures_cookei = new HashMap<ItemFoods.EnumIceFlavor,ResourceLocation> (){
		{put(ItemFoods.EnumIceFlavor.ICE_VANILA ,new ResourceLocation("drf:textures/entity/icecream_cookie_vanila.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_BLACK ,new ResourceLocation("drf:textures/entity/icecream_cookie_black.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_RED ,new ResourceLocation("drf:textures/entity/icecream_cookie_red.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_GREEN ,new ResourceLocation("drf:textures/entity/icecream_cookie_green.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_BROWN ,new ResourceLocation("drf:textures/entity/icecream_cookie_brown.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_BLUE ,new ResourceLocation("drf:textures/entity/icecream_cookie_blue.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_PURPLE ,new ResourceLocation("drf:textures/entity/icecream_cookie_purple.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_CYAN ,new ResourceLocation("drf:textures/entity/icecream_cookie_cyan.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_SILVER ,new ResourceLocation("drf:textures/entity/icecream_cookie_silver.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_GRAY ,new ResourceLocation("drf:textures/entity/icecream_cookie_gray.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_PINK ,new ResourceLocation("drf:textures/entity/icecream_cookie_pink.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_LIME ,new ResourceLocation("drf:textures/entity/icecream_cookie_lime.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_YELLOW ,new ResourceLocation("drf:textures/entity/icecream_cookie_yellow.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_LIGHT_BLUE ,new ResourceLocation("drf:textures/entity/icecream_cookie_light_blue.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_MAGENTA ,new ResourceLocation("drf:textures/entity/icecream_cookie_magenta.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_ORANGE ,new ResourceLocation("drf:textures/entity/icecream_cookie_orange.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_WHITE ,new ResourceLocation("drf:textures/entity/icecream_cookie_white.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_APPLE ,new ResourceLocation("drf:textures/entity/icecream_cookie_apple.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_CACTUS ,new ResourceLocation("drf:textures/entity/icecream_cookie_cactus.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_PUMPKIN ,new ResourceLocation("drf:textures/entity/icecream_cookie_pumpkin.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_POTATO ,new ResourceLocation("drf:textures/entity/icecream_cookie_potato.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_CARROT ,new ResourceLocation("drf:textures/entity/icecream_cookie_callot.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_MELON ,new ResourceLocation("drf:textures/entity/icecream_cookie_mellon.png"));}
		{put(ItemFoods.EnumIceFlavor.ICE_GREENTEA ,new ResourceLocation("drf:textures/entity/icecream_cookie_greentea.png"));}

	};

	public RenderIceCream(RenderManager renderManager) {
		super(renderManager);
		shadowSize = 0.1F;
		mainmodel = new ModelIcecream();
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityIceCream entity) {
		if (entity.isInCookie()){
			return textures_cookei.get(entity.getFlavor());
		}
		return  textures.get(entity.getFlavor());
	}

    @Override
    public void doRender(EntityIceCream entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	doRenderIceCream(entity, x, y, z, entityYaw, partialTicks);
    }

	public void doRenderIceCream(EntityIceCream icecream, double x, double y, double z, float yaw, float tic) {
		// レンダリング実装
		// レンダリング

		shadowSize = 0.2F;
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y-0.69F, (float)z);
		GL11.glRotatef(180F - yaw, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		GlStateManager.enableBlend();
		bindEntityTexture(icecream);

		int limit = ConfigValue.icecream.MelltingTime()/(EnumIcecreamLevel.getLevelCnt());
		int level = (int) Math.ceil((double)icecream.countdown()/limit);

		mainmodel.render(EnumIcecreamLevel.getLevel(level),0.0625F);
		GlStateManager.disableBlend();
		GL11.glPopMatrix();
	}

}
