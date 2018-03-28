	package mod.drf.foods.render;

	import java.util.HashMap;
import java.util.Map;

import org.lwjgl.opengl.GL11;

import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.entity.EntityCrashedIce;
import mod.drf.foods.entity.EntityIceCream;
import mod.drf.foods.model.ModelCrashedIce;
import mod.drf.foods.model.ModelCrashedIce.EnumCrashedIceLevel;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCrashedIce extends Render<EntityCrashedIce> {
	private ModelCrashedIce mainmodel;
	protected static final Map<ItemFoods.EnumFlapeSyrup,ResourceLocation> textures = new HashMap<ItemFoods.EnumFlapeSyrup,ResourceLocation> (){
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_NONE,new ResourceLocation("drf:textures/entity/crashedice_none.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_SUGAR,new ResourceLocation("drf:textures/entity/crashedice_sugar.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_BLACK,new ResourceLocation("drf:textures/entity/crashedice_black.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_RED,new ResourceLocation("drf:textures/entity/crashedice_red.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_GREEN,new ResourceLocation("drf:textures/entity/crashedice_green.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_BROWN,new ResourceLocation("drf:textures/entity/crashedice_brown.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_BLUE,new ResourceLocation("drf:textures/entity/crashedice_blue.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_PURPLE,new ResourceLocation("drf:textures/entity/crashedice_purple.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_CYAN,new ResourceLocation("drf:textures/entity/crashedice_cyan.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_SILVER,new ResourceLocation("drf:textures/entity/crashedice_silver.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_GRAY,new ResourceLocation("drf:textures/entity/crashedice_gray.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_PINK,new ResourceLocation("drf:textures/entity/crashedice_pink.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_LIME,new ResourceLocation("drf:textures/entity/crashedice_lime.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_YELLOW,new ResourceLocation("drf:textures/entity/crashedice_yellow.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_LIGHT_BLUE,new ResourceLocation("drf:textures/entity/crashedice_light_blue.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_MAGENTA,new ResourceLocation("drf:textures/entity/crashedice_magenta.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_ORANGE,new ResourceLocation("drf:textures/entity/crashedice_orange.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_WHITE,new ResourceLocation("drf:textures/entity/crashedice_white.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_APPLE,new ResourceLocation("drf:textures/entity/crashedice_apple.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_CACTUS,new ResourceLocation("drf:textures/entity/crashedice_cactus.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_MELLON,new ResourceLocation("drf:textures/entity/crashedice_mellon.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_PUMPKIN,new ResourceLocation("drf:textures/entity/crashedice_pumpkin.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_GREENTEA,new ResourceLocation("drf:textures/entity/crashedice_greentea.png"));}
	};

	protected static final Map<ItemFoods.EnumFlapeSyrup,ResourceLocation> textures_millk = new HashMap<ItemFoods.EnumFlapeSyrup,ResourceLocation> (){
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_NONE,new ResourceLocation("drf:textures/entity/crashedice_millk_none.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_SUGAR,new ResourceLocation("drf:textures/entity/crashedice_millk_sugar.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_BLACK,new ResourceLocation("drf:textures/entity/crashedice_millk_black.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_RED,new ResourceLocation("drf:textures/entity/crashedice_millk_red.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_GREEN,new ResourceLocation("drf:textures/entity/crashedice_millk_green.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_BROWN,new ResourceLocation("drf:textures/entity/crashedice_millk_brown.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_BLUE,new ResourceLocation("drf:textures/entity/crashedice_millk_blue.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_PURPLE,new ResourceLocation("drf:textures/entity/crashedice_millk_purple.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_CYAN,new ResourceLocation("drf:textures/entity/crashedice_millk_cyan.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_SILVER,new ResourceLocation("drf:textures/entity/crashedice_millk_silver.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_GRAY,new ResourceLocation("drf:textures/entity/crashedice_millk_gray.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_PINK,new ResourceLocation("drf:textures/entity/crashedice_millk_pink.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_LIME,new ResourceLocation("drf:textures/entity/crashedice_millk_lime.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_YELLOW,new ResourceLocation("drf:textures/entity/crashedice_millk_yellow.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_LIGHT_BLUE,new ResourceLocation("drf:textures/entity/crashedice_millk_light_blue.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_MAGENTA,new ResourceLocation("drf:textures/entity/crashedice_millk_magenta.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_ORANGE,new ResourceLocation("drf:textures/entity/crashedice_millk_orange.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_WHITE,new ResourceLocation("drf:textures/entity/crashedice_millk_white.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_APPLE,new ResourceLocation("drf:textures/entity/crashedice_millk_apple.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_CACTUS,new ResourceLocation("drf:textures/entity/crashedice_millk_cactus.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_MELLON,new ResourceLocation("drf:textures/entity/crashedice_millk_mellon.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_PUMPKIN,new ResourceLocation("drf:textures/entity/crashedice_millk_pumpkin.png"));}
		{put(ItemFoods.EnumFlapeSyrup.SYRUP_GREENTEA,new ResourceLocation("drf:textures/entity/crashedice_millk_greentea.png"));}
	};

	public RenderCrashedIce(RenderManager renderManager) {
		super(renderManager);
		shadowSize = 0.1F;
		mainmodel = new ModelCrashedIce();
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCrashedIce entity) {
		if (entity.isMillk()){
			return textures_millk.get(entity.getFlavor());
		}else{
			return  textures.get(entity.getFlavor());
		}
	}

    @Override
    public void doRender(EntityCrashedIce entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	doRenderIceCream(entity, x, y, z, entityYaw, partialTicks);
    }

	public void doRenderIceCream(EntityCrashedIce icecream, double x, double y, double z, float yaw, float tic) {
		// レンダリング実装
		// レンダリング

		shadowSize = 0.2F;
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y-0.69F, (float)z);
		GL11.glRotatef(180F - yaw, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		GlStateManager.enableBlend();
		bindEntityTexture(icecream);

		int limit = EntityIceCream.LIMIT_TIME/(EnumCrashedIceLevel.getLevelCnt()-1);
		int level = (int) Math.ceil((double)icecream.countdown()/limit);

		mainmodel.render(EnumCrashedIceLevel.getLevel(level),0,0,0,0.0625F);
		GlStateManager.disableBlend();
		GL11.glPopMatrix();
	}
}
