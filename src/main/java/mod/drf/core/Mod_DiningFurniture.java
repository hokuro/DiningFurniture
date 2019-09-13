package mod.drf.core;

import mod.drf.block.BlockCore;
import mod.drf.config.ConfigValue;
import mod.drf.creative.ItemGroupFurniture;
import mod.drf.entity.EntityWoodChair;
import mod.drf.entity.EntityZabuton;
import mod.drf.gui.GuiFurnitureWorkBench;
import mod.drf.inventory.ContainerFurnitureWorkBench;
import mod.drf.item.ItemCore;
import mod.drf.network.MessageHandler;
import mod.drf.render.EntityWoodChairRender;
import mod.drf.render.EntityZabutonRender;
import mod.drf.render.RenderWoodTable;
import mod.drf.tileentity.TileEntityWoodTable;
import net.minecraft.block.Block;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;

@Mod( ModCommon.MOD_ID)
public class Mod_DiningFurniture {
	public static final ItemGroup tabFurniture = new ItemGroupFurniture("Furniture");
    public Mod_DiningFurniture() {
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(ContainerType.class, this::onContainerRegistry);

        // コンフィグ読み込み
    	ModLoadingContext.get().
        registerConfig(
        		net.minecraftforge.fml.config.ModConfig.Type.COMMON,
        		ConfigValue.spec);

    	BlockCore.init();
    	ItemCore.init();

    	// メッセージ登録
    	MessageHandler.register();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    	registRender();
    	guiHandler();

    }

	@OnlyIn(Dist.CLIENT)
	public void registRender(){
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodChair.class, EntityWoodChairRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityZabuton.class, EntityZabutonRender::new);

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodTable.class, new RenderWoodTable());
	}

	@ObjectHolder(ModCommon.MOD_ID + ":" + ModCommon.MOD_GUI_ID_DWORKBENCH)
	public static ContainerType<ContainerFurnitureWorkBench> CONTAINER_FURNITUREWORKBENCH;

	@OnlyIn(Dist.CLIENT)
	public void guiHandler(){
		ScreenManager.registerFactory(CONTAINER_FURNITUREWORKBENCH, GuiFurnitureWorkBench::new);
	}

	public void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
		event.getRegistry().register(IForgeContainerType.create((wid, playerInv, extraData)->{
			return new ContainerFurnitureWorkBench(wid, playerInv);
		}).setRegistryName(ModCommon.MOD_GUI_DWORKBENCH_NAME));
	}

	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

		@SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
        	BlockCore.register(blockRegistryEvent);
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
        	BlockCore.registerItem(itemRegistryEvent);
            ItemCore.register(itemRegistryEvent);
        }

        public static EntityType<EntityWoodChair> WOODCHAIR;
        public static EntityType<EntityZabuton> ZABUTON;

        @SubscribeEvent
        public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> etRegistryEvent){
        	WOODCHAIR = EntityType.Builder.<EntityWoodChair>create(EntityWoodChair::new,EntityClassification.MISC)
        			.setTrackingRange(80).setUpdateInterval(5).setShouldReceiveVelocityUpdates(true).size(1.0F,1.8F)
        			.setCustomClientFactory(EntityWoodChair::new).build(ModCommon.MOD_ID + ":" + EntityWoodChair.NAME);
        	WOODCHAIR.setRegistryName(new ResourceLocation(ModCommon.MOD_ID,EntityWoodChair.NAME));

        	ZABUTON = EntityType.Builder.<EntityZabuton>create(EntityZabuton::new, EntityClassification.MISC)
        			.setTrackingRange(80).setUpdateInterval(5).setShouldReceiveVelocityUpdates(true).size(0.81F,0.2F)
        			.setCustomClientFactory(EntityZabuton::new).build(ModCommon.MOD_ID + ":" + EntityZabuton.NAME);
        	ZABUTON.setRegistryName(new ResourceLocation(ModCommon.MOD_ID,EntityZabuton.NAME));
        	etRegistryEvent.getRegistry().registerAll(ZABUTON, WOODCHAIR);
        }


        public static TileEntityType<?> WOODTABLE;
        @SubscribeEvent
        public static void onTERegistyr(final RegistryEvent.Register<TileEntityType<?>> teRegistryEvent){
        	WOODTABLE = TileEntityType.Builder.create(TileEntityWoodTable::new,
        			BlockCore.block_woodtable_acacia,
        			BlockCore.block_woodtable_birch,
        			BlockCore.block_woodtable_darkoak,
        			BlockCore.block_woodtable_jungle,
        			BlockCore.block_woodtable_oak,
        			BlockCore.block_woodtable_spruce).build(null);
        	WOODTABLE.setRegistryName(ModCommon.MOD_ID, TileEntityWoodTable.REGISTER_NAME);
        	teRegistryEvent.getRegistry().register(WOODTABLE);
        }
    }
}
