package mod.drf.client;

import mod.drf.core.CommonProxy;
import mod.drf.foods.render.RenderFlapeMaker;
import mod.drf.foods.tileentity.TileEntityFlapeMaker;
import mod.drf.foods.tileentity.TileEntitySaltPan;
import mod.drf.furniture.entity.EntityChairZabuton;
import mod.drf.furniture.item.ItemChairZabuton;
import mod.drf.furniture.item.ItemFurniture;
import mod.drf.furniture.render.EntityChairZabutonRender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy{

	@SideOnly(Side.CLIENT)
	public void registerTileEntity(){
		GameRegistry.registerTileEntity(TileEntitySaltPan.class, "TileEntitySaltPan");
		TileEntitySpecialRenderer renderFlape =  new RenderFlapeMaker();
		ClientRegistry.registerTileEntity(TileEntityFlapeMaker.class, "TileEntityFlapeMaker",renderFlape);
	}


	@SideOnly(Side.CLIENT)
	public void registRender(){
		RenderingRegistry.registerEntityRenderingHandler(EntityChairZabuton.class,  new IRenderFactory<EntityChairZabuton>() {
			@Override
			public Render<? super EntityChairZabuton> createRenderFor(RenderManager manager) {
				return new EntityChairZabutonRender(manager);
			}
		});
		RenderManager manager = Minecraft.getMinecraft().getRenderManager();
		net.minecraftforge.fml.client.registry.RenderingRegistry.loadEntityRenderers(manager, manager.entityRenderMap);
	}

	@SideOnly(Side.CLIENT)
	public void registerColorMap(){
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new IItemColor()
        {
            public int getColorFromItemstack(ItemStack stack, int tintIndex)
            {
                return ((ItemChairZabuton)ItemFurniture.item_zabuton).getColorFromItemStack(stack,tintIndex);
            }
        }, new Item[] {ItemFurniture.item_zabuton});
	}
}
