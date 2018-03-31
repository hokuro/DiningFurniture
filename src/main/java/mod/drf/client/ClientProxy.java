package mod.drf.client;

import mod.drf.core.CommonProxy;
import mod.drf.foods.entity.EntityCrashedIce;
import mod.drf.foods.entity.EntityIceCream;
import mod.drf.foods.render.RenderCrashedIce;
import mod.drf.foods.render.RenderFreezer;
import mod.drf.foods.render.RenderIceCrasher;
import mod.drf.foods.render.RenderIceCream;
import mod.drf.foods.render.RenderMillStone;
import mod.drf.foods.tileentity.TileEntityFreezer;
import mod.drf.foods.tileentity.TileEntityIceCrasher;
import mod.drf.foods.tileentity.TileEntityMillStone;
import mod.drf.foods.tileentity.TileEntitySaltPan;
import mod.drf.furniture.entity.EntityChair;
import mod.drf.furniture.item.ItemFurniture;
import mod.drf.furniture.item.ItemZabuton;
import mod.drf.furniture.render.RenderChair;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy{
    @Override
    public EntityPlayer getEntityPlayerInstance() {
        return Minecraft.getMinecraft().player;
    }


	@SideOnly(Side.CLIENT)
	public void registerTileEntity(){
		GameRegistry.registerTileEntity(TileEntitySaltPan.class, TileEntitySaltPan.REGISTER_NAME);
		ClientRegistry.registerTileEntity(TileEntityIceCrasher.class, TileEntityIceCrasher.REGISTER_NAME,new RenderIceCrasher());
		ClientRegistry.registerTileEntity(TileEntityFreezer.class, TileEntityFreezer.REGISTER_NAME,new RenderFreezer());
		ClientRegistry.registerTileEntity(TileEntityMillStone.class, TileEntityMillStone.REGISTER_NAME,new RenderMillStone());
	}


	@SideOnly(Side.CLIENT)
	public void registRender(){
		RenderingRegistry.registerEntityRenderingHandler(EntityIceCream.class, new IRenderFactory<EntityIceCream>() {
			@Override
			public Render<? super EntityIceCream> createRenderFor(RenderManager manager){
				return new RenderIceCream(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntityCrashedIce.class, new IRenderFactory<EntityCrashedIce>() {
			@Override
			public Render<? super EntityCrashedIce> createRenderFor(RenderManager manager){
				return new RenderCrashedIce(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityChair.class,  new IRenderFactory<EntityChair>() {
			@Override
			public Render<? super EntityChair> createRenderFor(RenderManager manager) {
				return new RenderChair(manager);
			}
		});


//		RenderingRegistry.registerEntityRenderingHandler(EntityZabuton.class,  new IRenderFactory<EntityZabuton>() {
//			@Override
//			public Render<? super EntityZabuton> createRenderFor(RenderManager manager) {
//				return new EntityZabutonRender(manager);
//			}
//		});
//
//		RenderingRegistry.registerEntityRenderingHandler(EntityWoodChair.class,  new IRenderFactory<EntityWoodChair>() {
//			@Override
//			public Render<? super EntityWoodChair> createRenderFor(RenderManager manager) {
//				return new EntityWoodChairRender(manager);
//			}
//		});

//		RenderingRegistry.registerEntityRenderingHandler(EntityChairZabuton.class,  new IRenderFactory<EntityChairZabuton>() {
//			@Override
//			public Render<? super EntityChairZabuton> createRenderFor(RenderManager manager) {
//				return new EntityChairZabutonRender(manager);
//			}
//		});
//		RenderManager manager = Minecraft.getMinecraft().getRenderManager();
//		net.minecraftforge.fml.client.registry.RenderingRegistry.loadEntityRenderers(manager, manager.entityRenderMap);
	}

	@SideOnly(Side.CLIENT)
	public void registerColorMap(){
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new IItemColor()
        {
			@Override
			public int colorMultiplier(ItemStack stack, int tintIndex) {
				return ((ItemZabuton)ItemFurniture.item_zabuton).getColorFromItemStack(stack,tintIndex);
			}
        }, new Item[] {ItemFurniture.item_zabuton});
	}
}
