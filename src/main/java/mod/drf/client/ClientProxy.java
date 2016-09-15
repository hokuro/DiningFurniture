package mod.drf.client;

import mod.drf.core.CommonProxy;
import mod.drf.furniture.entity.EntityChairZabuton;
import mod.drf.furniture.entity.EntityChairZabutonRender;
import mod.drf.furniture.item.ItemChairZabuton;
import mod.drf.furniture.item.ItemFurniture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy{

	@SideOnly(Side.CLIENT)
	public void registerChairRender(){
		//RenderingRegistry.registerEntityRenderingHandler(EntityChairZabuton.class, new EntityChairZabutonRender(Minecraft.getMinecraft().getRenderManager()));
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
                return ((ItemChairZabuton)ItemFurniture.getItem(ItemChairZabuton.NAME)).getColorFromItemStack(stack,tintIndex);
            }
        }, new Item[] {ItemFurniture.getItem(ItemChairZabuton.NAME)});
	}
}
