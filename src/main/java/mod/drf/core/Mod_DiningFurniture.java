package mod.drf.core;

import mod.drf.common.gui.GuiOriginalWorkBench;
import mod.drf.config.ConfigValue;
import mod.drf.creative.ItemGroupColdFood;
import mod.drf.creative.ItemGroupFurniture;
import mod.drf.creative.ItemGroupPieCakes;
import mod.drf.event.LivingDeathEventHandler;
import mod.drf.foods.Item.ItemFoods;
import mod.drf.foods.block.BlockFoods;
import mod.drf.foods.entity.EntityCrashedIce;
import mod.drf.foods.entity.EntityIceCream;
import mod.drf.foods.gui.GuiFreezer;
import mod.drf.foods.gui.GuiIceCrasher;
import mod.drf.foods.gui.GuiMillStone;
import mod.drf.foods.render.RenderCrashedIce;
import mod.drf.foods.render.RenderFreezer;
import mod.drf.foods.render.RenderIceCrasher;
import mod.drf.foods.render.RenderIceCream;
import mod.drf.foods.render.RenderMillStone;
import mod.drf.foods.tileentity.TileEntityFreezer;
import mod.drf.foods.tileentity.TileEntityIceCrasher;
import mod.drf.foods.tileentity.TileEntityMillStone;
import mod.drf.foods.tileentity.TileEntitySaltPan;
import mod.drf.furniture.block.BlockFurniture;
import mod.drf.furniture.entity.EntityWoodChair;
import mod.drf.furniture.entity.EntityZabuton;
import mod.drf.furniture.item.ItemFurniture;
import mod.drf.furniture.render.EntityWoodChairRender;
import mod.drf.furniture.render.EntityZabutonRender;
import mod.drf.network.MessageHandler;
import mod.drf.recipie.CookingMenu;
import mod.drf.recipie.FurnitureMenu;
import mod.drf.sounds.SoundManager;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod( ModCommon.MOD_ID)
public class Mod_DiningFurniture {
	public static final ItemGroup tabFurniture = new ItemGroupFurniture("Furniture");
	public static final ItemGroup tabColdFood = new ItemGroupColdFood("ColdFood");
	public static final ItemGroup tabPieCakes = new ItemGroupPieCakes("PieCakes");

    public Mod_DiningFurniture() {
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // コンフィグ読み込み
    	ModLoadingContext.get().
        registerConfig(
        		net.minecraftforge.fml.config.ModConfig.Type.COMMON,
        		ConfigValue.spec);

    	BlockFoods.init();
    	ItemFoods.init();
    	BlockFurniture.init();
    	ItemFurniture.init();

    	// メッセージ登録
    	MessageHandler.register();

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new LivingDeathEventHandler());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    	registRender();
    	guiHandler();

    }

	@OnlyIn(Dist.CLIENT)
	public void registRender(){
		RenderingRegistry.registerEntityRenderingHandler(EntityIceCream.class, RenderIceCream::new);

		RenderingRegistry.registerEntityRenderingHandler(EntityCrashedIce.class, RenderCrashedIce::new);


		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFreezer.class, new RenderFreezer());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMillStone.class, new RenderMillStone());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIceCrasher.class, new RenderIceCrasher());



		RenderingRegistry.registerEntityRenderingHandler(EntityWoodChair.class, EntityWoodChairRender::new);

		RenderingRegistry.registerEntityRenderingHandler(EntityZabuton.class, EntityZabutonRender::new);


	}

	@OnlyIn(Dist.CLIENT)
	public void guiHandler(){
        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.GUIFACTORY, () -> (openContainer) -> {
    		ResourceLocation location = openContainer.getId();
    		EntityPlayer player = Minecraft.getInstance().player;
    		World world = Minecraft.getInstance().world;

    		if (location.toString().equals(ModCommon.MOD_ID + ":" + ModCommon.MOD_GUI_ID_CWORKBENCH)){
    			int x = openContainer.getAdditionalData().readInt();
        		int y = openContainer.getAdditionalData().readInt();
        		int z = openContainer.getAdditionalData().readInt();
    			return new GuiOriginalWorkBench(player,world, new BlockPos(x,y,z),CookingMenu.getInstance());

    		}else if (location.toString().equals(ModCommon.MOD_ID + ":" + ModCommon.MOD_GUI_ID_DWORKBENCH)){
    			int x = openContainer.getAdditionalData().readInt();
        		int y = openContainer.getAdditionalData().readInt();
        		int z = openContainer.getAdditionalData().readInt();
    			return new GuiOriginalWorkBench(player,world, new BlockPos(x,y,z),FurnitureMenu.getInstance());

    		}else if (location.toString().equals(ModCommon.MOD_ID + ":" +ModCommon.MOD_GUI_ID_ICECRASHER)){
    			int x = openContainer.getAdditionalData().readInt();
        		int y = openContainer.getAdditionalData().readInt();
        		int z = openContainer.getAdditionalData().readInt();
        		TileEntity te = world.getTileEntity(new BlockPos(x,y,z));
    			return new GuiIceCrasher(world, player, new BlockPos(x,y,z), (TileEntityIceCrasher)te);

    		}else if (location.toString().equals(ModCommon.MOD_ID + ":" +ModCommon.MOD_GUI_ID_FREEZER)){
    			int x = openContainer.getAdditionalData().readInt();
        		int y = openContainer.getAdditionalData().readInt();
        		int z = openContainer.getAdditionalData().readInt();
        		TileEntity te = world.getTileEntity(new BlockPos(x,y,z));
    			return new GuiFreezer(world, player, new BlockPos(x,y,z), (TileEntityFreezer)te);

    		}else if (location.toString().equals(ModCommon.MOD_ID + ":" +ModCommon.MOD_GUI_ID_MILLSTONE)){
    			int x = openContainer.getAdditionalData().readInt();
        		int y = openContainer.getAdditionalData().readInt();
        		int z = openContainer.getAdditionalData().readInt();
        		TileEntity te = world.getTileEntity(new BlockPos(x,y,z));
    			return new GuiMillStone(world, player, new BlockPos(x,y,z), (TileEntityMillStone)te);

    		}
    		return null;
        });
	}

	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
        	BlockFoods.register(blockRegistryEvent);
        	BlockFurniture.register(blockRegistryEvent);
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            BlockFoods.registerItem(itemRegistryEvent);
            BlockFurniture.registerItem(itemRegistryEvent);
            ItemFoods.register(itemRegistryEvent);
            ItemFurniture.register(itemRegistryEvent);
        }


        public static EntityType<EntityIceCream> ICECREAM;
        public static EntityType<EntityCrashedIce> CRASHEDICE;
        public static EntityType<EntityWoodChair> WOODCHAIR;
        public static EntityType<EntityZabuton> ZABUTON;

        @SubscribeEvent
        public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> etRegistryEvent){
        	ICECREAM = EntityType.Builder.create(EntityIceCream.class, EntityIceCream::new).tracker(80, 5, true).build(ModCommon.MOD_ID + ":" + EntityIceCream.NAME);
        	ICECREAM.setRegistryName(new ResourceLocation(ModCommon.MOD_ID,EntityIceCream.NAME));

        	CRASHEDICE = EntityType.Builder.create(EntityCrashedIce.class, EntityCrashedIce::new).tracker(80, 5, true).build(ModCommon.MOD_ID + ":" + EntityCrashedIce.NAME);
        	CRASHEDICE.setRegistryName(new ResourceLocation(ModCommon.MOD_ID,EntityCrashedIce.NAME));

        	WOODCHAIR = EntityType.Builder.create(EntityWoodChair.class, EntityWoodChair::new).tracker(80, 3, true).build(ModCommon.MOD_ID + ":" + EntityWoodChair.NAME);
        	WOODCHAIR.setRegistryName(new ResourceLocation(ModCommon.MOD_ID,EntityWoodChair.NAME));

        	ZABUTON = EntityType.Builder.create(EntityZabuton.class, EntityZabuton::new).tracker(80, 3, true).build(ModCommon.MOD_ID + ":" + EntityZabuton.NAME);
        	ZABUTON.setRegistryName(new ResourceLocation(ModCommon.MOD_ID,EntityZabuton.NAME));
        	etRegistryEvent.getRegistry().registerAll(ICECREAM, CRASHEDICE, ZABUTON, WOODCHAIR);
        }


    	public static TileEntityType<?> SALTPAN;
    	public static TileEntityType<?> ICECRASHER;
    	public static TileEntityType<?> FREEZER;
    	public static TileEntityType<?> MILLSTONE;
        @SubscribeEvent
        public static void onTERegistyr(final RegistryEvent.Register<TileEntityType<?>> teRegistryEvent){
        	SALTPAN = TileEntityType.Builder.create(TileEntitySaltPan::new).build(null);
        	SALTPAN.setRegistryName(ModCommon.MOD_ID, TileEntitySaltPan.REGISTER_NAME);
        	teRegistryEvent.getRegistry().register(SALTPAN);

        	ICECRASHER = TileEntityType.Builder.create(TileEntityIceCrasher::new).build(null);
        	ICECRASHER.setRegistryName(ModCommon.MOD_ID, TileEntityIceCrasher.REGISTER_NAME);
        	teRegistryEvent.getRegistry().register(ICECRASHER);

        	FREEZER = TileEntityType.Builder.create(TileEntityFreezer::new).build(null);
        	FREEZER.setRegistryName(ModCommon.MOD_ID, TileEntityFreezer.REGISTER_NAME);
        	teRegistryEvent.getRegistry().register(FREEZER);

        	MILLSTONE = TileEntityType.Builder.create(TileEntityMillStone::new).build(null);
        	MILLSTONE.setRegistryName(ModCommon.MOD_ID, TileEntityMillStone.REGISTER_NAME);
        	teRegistryEvent.getRegistry().register(MILLSTONE);

        }

        @SubscribeEvent
        public static void onSoundRegistyr(final RegistryEvent.Register<SoundEvent> teRegistryEvent){
        	teRegistryEvent.getRegistry().register(SoundManager.sound_makeflape);
        	teRegistryEvent.getRegistry().register(SoundManager.sound_mill);
        }
    }
}
