package com.fuyuvulpes.yoamod;

import com.fuyuvulpes.yoamod.core.YOACommonConfig;
import com.fuyuvulpes.yoamod.core.YoaRegistries;
import com.fuyuvulpes.yoamod.core.registries.*;
import com.fuyuvulpes.yoamod.game.client.entities.model.*;
import com.fuyuvulpes.yoamod.game.client.entities.renderers.*;
import com.fuyuvulpes.yoamod.game.client.gui.CrucibleScreen;
import com.fuyuvulpes.yoamod.game.client.gui.HammeringStationScreen;
import com.fuyuvulpes.yoamod.game.client.particle.BleedingParticle;
import com.fuyuvulpes.yoamod.mixin.access.BlockEntityTypeAccess;
import com.fuyuvulpes.yoamod.network.UpdateManaPacket;
import com.fuyuvulpes.yoamod.world.block.state.ModWoodTypes;
import com.fuyuvulpes.yoamod.world.entity.*;
import com.fuyuvulpes.yoamod.world.item.weaponry.WarFanItem;
import com.fuyuvulpes.yoamod.world.magic.mana.ManaHelper;
import com.fuyuvulpes.yoamod.world.magic.mana.ManaHelperImpl;
import com.fuyuvulpes.yoamod.world.magic.mana.ManaHudOverlay;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.SpawnPlacementRegisterEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;
import net.neoforged.neoforge.registries.NewRegistryEvent;

import java.util.Set;

import static com.fuyuvulpes.yoamod.core.registries.YoaMenus.CRUCIBLE_MENU;
import static com.fuyuvulpes.yoamod.core.registries.YoaMenus.HAMMERING_STATION_MENU;


@Mod(YOAMod.MODID)
public class YOAMod {

    public static final String MODID = "yoamod";


    public YOAMod(IEventBus modEventBus) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, YOACommonConfig.SPEC);
        YoaFeatures.register(modEventBus);
        YoaRecipes.register(modEventBus);
        YoaSerializers.register(modEventBus);
        YoaParticles.register(modEventBus);
        YoaEffects.register(modEventBus);
        YoaEntityTypes.register(modEventBus);
        YoaMenus.register(modEventBus);
        ManaHelper.Impl.INSTANCE = new ManaHelperImpl();
        YoaMagicAndSpells.register(modEventBus);
        YoaPlacers.register(modEventBus);
        YoaBlocks.register(modEventBus);

        YoaItems.register(modEventBus);
        YoaBlockEntities.register(modEventBus);


        YoaTabs.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

    }


    private static Material createSignMaterial(WoodType type)
    {
        ResourceLocation location = new ResourceLocation(type.name());
        return new Material(Sheets.SIGN_SHEET, new ResourceLocation(MODID, "entity/signs/" + location.getPath()));
    }

    private static Material createHangingSignMaterial(WoodType type)
    {
        ResourceLocation location = new ResourceLocation(type.name());
        return new Material(Sheets.SIGN_SHEET, new ResourceLocation(MODID, "entity/signs/hanging/" + location.getPath()));
    }

    public static void addWoodType(WoodType woodType)
    {
        Sheets.SIGN_MATERIALS.put(woodType, createSignMaterial(woodType));
        Sheets.HANGING_SIGN_MATERIALS.put(woodType, createHangingSignMaterial(woodType));
    }

    public static void setupRenderTypes(){
        RenderType transparentRenderType = RenderType.cutoutMipped();
        RenderType cutoutRenderType = RenderType.cutout();
        RenderType translucentRenderType = RenderType.translucent();

        setRenderType(YoaBlocks.BLISSWOOD_LEAVES.get(), transparentRenderType);
        setRenderType(YoaBlocks.BLISSWOOD_DOOR.get(), cutoutRenderType);
        setRenderType(YoaBlocks.BLISSWOOD_SAPLING.get(), cutoutRenderType);
        setRenderType(YoaBlocks.BLISSWOOD_TRAPDOOR.get(), cutoutRenderType);
    }

    public static void setRenderType(Block block, RenderType renderType){
        ItemBlockRenderTypes.setRenderLayer(block, renderType);
    }


    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(YOAMod::appendBlocksToBlockEntities);
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(YoaBlocks.HAMMERING_STATION);
            event.accept(YoaBlocks.CRUCIBLE);

        }


    }

    private static void appendBlocksToBlockEntities() {
        BlockEntityTypeAccess signBuilderAccess = (BlockEntityTypeAccess) BlockEntityType.SIGN;
        BlockEntityTypeAccess hangingSignBuilderAccess = (BlockEntityTypeAccess) BlockEntityType.HANGING_SIGN;
        Set<Block> signValidBlocks = new ObjectOpenHashSet<>(signBuilderAccess.yoamod_getValidBlocks());
        Set<Block> hangingSignValidBlocks = new ObjectOpenHashSet<>(hangingSignBuilderAccess.yoamod_getValidBlocks());
        signValidBlocks.add(YoaBlocks.BLISSWOOD_SIGN.get());
        signValidBlocks.add(YoaBlocks.BLISSWOOD_WALL_SIGN.get());
        hangingSignValidBlocks.add(YoaBlocks.BLISSWOOD_HANGING_SIGN.get());
        hangingSignValidBlocks.add(YoaBlocks.BLISSWOOD_WALL_HANGING_SIGN.get());
        signBuilderAccess.yoamod_setValidBlocks(signValidBlocks);
        hangingSignBuilderAccess.yoamod_setValidBlocks(hangingSignValidBlocks);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }


    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            event.enqueueWork(() ->
            {


                setupRenderTypes();
                addWoodType(ModWoodTypes.BLISSWOOD);

                ItemProperties.register(YoaItems.LONGBOW.get(),
                        new ResourceLocation(MODID, "pulling"), (stack, level, living, id) -> {
                            return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F;
                        });

                ItemProperties.register(YoaItems.LONGBOW.get(),
                        new ResourceLocation(MODID, "pull"), (stack, level, living, id) -> {
                            if (living == null) {
                                return 0.0F;
                            } else {
                                return living.getUseItem() != stack ? 0.0F : (float) (stack.getUseDuration() - living.getUseItemRemainingTicks()) / 20.0F;
                            }
                        });

                YoaItems.ITEMS.getEntries().forEach(itemDeferredHolder -> {
                    if (itemDeferredHolder.get() instanceof WarFanItem item) {
                        ItemProperties.register(item,
                                new ResourceLocation(MODID, "open"), (stack, level, living, id) -> item.isOpen(stack) ? 1.0F : 0.0F);
                    }
                });


            });


        }
        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(YoaBlockEntities.CREAKS_PORTAL.get(), CreaksPortalRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.PLANE_TYPE.get(), PlaneRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.DART.get(), DartRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.CHAKRAM.get(), ChakramRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.BOOMERANG.get(), BoomerangRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.SHURIKEN.get(), ShurikenRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.THROWING_KNIFE.get(), ThrowingKnifeRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.HARPOON.get(), HarpoonRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.BRAWLER_TYPE.get(), BrawlerRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.BRAWLING_TYPE.get(), BrawlerRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.BLOCKLING_TYPE.get(), BlocklingRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.ARMED_SPIDER_TYPE.get(), ArmedSpiderRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.FALLEN_SAMURAI.get(), FallenSamuraiRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.FENNEC_FOX_TYPE.get(), FennecFoxRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.TOUCAN_TYPE.get(), ToucanRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.OWL_TYPE.get(), OwlRenderer::new);
        }
        @SubscribeEvent
        public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(PlaneModel.LAYER_LOCATION,PlaneModel::createBodyLayer);
            event.registerLayerDefinition(DartModel.LAYER_LOCATION,DartModel::createBodyLayer);
            event.registerLayerDefinition(ChakramModel.LAYER_LOCATION,ChakramModel::createBodyLayer);
            event.registerLayerDefinition(BoomerangModel.LAYER_LOCATION,BoomerangModel::createBodyLayer);
            event.registerLayerDefinition(HarpoonModel.LAYER_LOCATION,HarpoonModel::createBodyLayer);
            event.registerLayerDefinition(ShurikenModel.LAYER_LOCATION,ShurikenModel::createBodyLayer);
            event.registerLayerDefinition(ThrowingKnifeModel.LAYER_LOCATION,ThrowingKnifeModel::createBodyLayer);
            event.registerLayerDefinition(ChakramModel.LAYER_LOCATION,ChakramModel::createBodyLayer);
            event.registerLayerDefinition(BrawlerModel.LAYER_LOCATION,BrawlerModel::createBodyLayer);
            event.registerLayerDefinition(BlocklingModel.LAYER_LOCATION, BlocklingModel::createBodyLayer);
            event.registerLayerDefinition(ArmedSpiderModel.LAYER_LOCATION, ArmedSpiderModel::createBodyLayer);
            event.registerLayerDefinition(FallenSamuraiModel.LAYER_LOCATION, FallenSamuraiModel::createBodyLayer);
            event.registerLayerDefinition(FennecFoxModel.LAYER_LOCATION, FennecFoxModel::createBodyLayer);
            event.registerLayerDefinition(ToucanModel.LAYER_LOCATION, ToucanModel::createBodyLayer);
            event.registerLayerDefinition(OwlModel.LAYER_LOCATION, OwlModel::createBodyLayer);

        }
        @SubscribeEvent
        public static void registerParticleEvent(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(YoaParticles.BLEEDING.get(), (pSprites) ->
                    (pType, pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed) ->
                            new BleedingParticle(pLevel,pX,pY,pZ,pSprites));
        }
        @SubscribeEvent
        public static void registerItemColors(RegisterColorHandlersEvent.Item event)
        {
            event.register((stack, tintIndex) -> {
                        BlockState state = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
                        BlockColors blockColors = Minecraft.getInstance().getBlockColors();
                        return blockColors.getColor(state, null, null, tintIndex);
                    },
                    YoaBlocks.BLISSWOOD_LEAVES.get()
                    );
        }
        @SubscribeEvent
        public static void registerBlockColors(RegisterColorHandlersEvent.Block event)
        {

            //Foliage Coloring
            event.register((state, world, pos, tintIndex) ->
                            world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                    YoaBlocks.BLISSWOOD_LEAVES.get()
            );
        }
        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event){
            event.registerAboveAll(makeResLoc("mana"), ManaHudOverlay.MANA_OVERLAY);
        }




    }



    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents {
        @SubscribeEvent
        public static void register(final RegisterPayloadHandlerEvent event) {
            final IPayloadRegistrar registrar = event.registrar(MODID)
                    .versioned("1.0.0")
                    .optional();

            registrar.play(UpdateManaPacket.ID,
                    UpdateManaPacket::new,
                    handler -> handler.client(UpdateManaPacket::handle));



        }

        @SubscribeEvent
        public static void registryRegisterEvent(NewRegistryEvent event){
            event.register(YoaRegistries.MAGIC);
        }

        @SubscribeEvent
        public static void entityAttributes(EntityAttributeCreationEvent event){
            event.put(YoaEntityTypes.BRAWLER_TYPE.get(), BrawlerEntity.createAttributes().build());
            event.put(YoaEntityTypes.BRAWLING_TYPE.get(), BrawlingEntity.createAttributes().build());
            event.put(YoaEntityTypes.BLOCKLING_TYPE.get(), Blockling.createAttributes().build());
            event.put(YoaEntityTypes.ARMED_SPIDER_TYPE.get(), ArmedSpider.createAttributes().build());
            event.put(YoaEntityTypes.FALLEN_SAMURAI.get(), FallenSamurai.createAttributes().build());
            event.put(YoaEntityTypes.FENNEC_FOX_TYPE.get(), FennecFox.createAttributes().build());
            event.put(YoaEntityTypes.TOUCAN_TYPE.get(), Toucan.createAttributes().build());
            event.put(YoaEntityTypes.OWL_TYPE.get(), Owl.createAttributes().build());
        }



        @SubscribeEvent
        public static void spawnPlacements(SpawnPlacementRegisterEvent event){
            event.register(YoaEntityTypes.BRAWLER_TYPE.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    BrawlerEntity::canSpawn,
                    SpawnPlacementRegisterEvent.Operation.OR);
            event.register(YoaEntityTypes.BRAWLING_TYPE.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    BrawlerEntity::canSpawn,
                    SpawnPlacementRegisterEvent.Operation.OR);
            event.register(YoaEntityTypes.ARMED_SPIDER_TYPE.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules,
                    SpawnPlacementRegisterEvent.Operation.OR);
            event.register(YoaEntityTypes.BLOCKLING_TYPE.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Blockling::canSpawn,
                    SpawnPlacementRegisterEvent.Operation.OR);
            event.register(YoaEntityTypes.FALLEN_SAMURAI.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    FallenSamurai::canSpawn,
                    SpawnPlacementRegisterEvent.Operation.OR);
            event.register(YoaEntityTypes.FENNEC_FOX_TYPE.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    FennecFox::canSpawn,
                    SpawnPlacementRegisterEvent.Operation.OR);
            event.register(YoaEntityTypes.TOUCAN_TYPE.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Toucan::canSpawn,
                    SpawnPlacementRegisterEvent.Operation.OR);
            event.register(YoaEntityTypes.OWL_TYPE.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Owl::canSpawn,
                    SpawnPlacementRegisterEvent.Operation.OR);
        }

        @SubscribeEvent
        private static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(CRUCIBLE_MENU.get(), CrucibleScreen::new);
            event.register(HAMMERING_STATION_MENU.get(), HammeringStationScreen::new);
        }
    }

    public static ResourceLocation makeTexture(String path){
        return new ResourceLocation(MODID, "textures/" + path);
    }

    public static ResourceLocation makeResLoc(String path){
        return new ResourceLocation(MODID, path);
    }

}

