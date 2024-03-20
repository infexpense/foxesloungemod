package com.fuyuvulpes.yoamod;

import com.fuyuvulpes.yoamod.core.ModRegistries;
import com.fuyuvulpes.yoamod.core.YOAModCommonConfig;
import com.fuyuvulpes.yoamod.game.client.entities.model.PlaneModel;
import com.fuyuvulpes.yoamod.game.client.entities.renderers.*;
import com.fuyuvulpes.yoamod.game.client.particle.BleedingParticle;
import com.fuyuvulpes.yoamod.game.client.screens.CrucibleScreen;
import com.fuyuvulpes.yoamod.game.client.screens.HammeringStationScreen;
import com.fuyuvulpes.yoamod.mixin.access.BlockEntityTypeAccess;
import com.fuyuvulpes.yoamod.world.block.state.ModWoodTypes;
import com.fuyuvulpes.yoamod.world.entity.ArmedSpider;
import com.fuyuvulpes.yoamod.world.entity.Blockling;
import com.fuyuvulpes.yoamod.world.entity.BrawlerEntity;
import com.fuyuvulpes.yoamod.world.entity.BrawlingEntity;
import com.fuyuvulpes.yoamod.world.item.weaponry.WarFanItem;
import com.fuyuvulpes.yoamod.game.client.entities.model.ArmedSpiderModel;
import com.fuyuvulpes.yoamod.game.client.entities.model.BlocklingModel;
import com.fuyuvulpes.yoamod.game.client.entities.model.BrawlerModel;
import com.fuyuvulpes.yoamod.core.registries.*;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
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
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.SpawnPlacementRegisterEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
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
        YoaFeatures.register(modEventBus);
        YoaRecipes.register(modEventBus);
        YoaSerializers.register(modEventBus);
        YoaParticles.register(modEventBus);
        YoaEffects.register(modEventBus);
        YoaEntityTypes.register(modEventBus);
        YoaMenus.register(modEventBus);
        YoaMagicAndSpells.register(modEventBus);
        YoaPlacers.register(modEventBus);
        YoaBlocks.register(modEventBus);

        YoaItems.register(modEventBus);
        YoaBlockEntities.register(modEventBus);


        YoaTabs.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, YOAModCommonConfig.SPEC);
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
            event.registerBlockEntityRenderer(YoaBlockEntities.HAMMERING_STATION.get(), HammeringStationRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.PLANE_TYPE.get(), PlaneRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.BRAWLER_TYPE.get(), BrawlerRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.BRAWLING_TYPE.get(), BrawlerRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.BLOCKLING_TYPE.get(), BlocklingRenderer::new);
            event.registerEntityRenderer(YoaEntityTypes.ARMED_SPIDER_TYPE.get(), ArmedSpiderRenderer::new);
        }


        @SubscribeEvent
        public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(PlaneModel.LAYER_LOCATION,PlaneModel::createBodyLayer);
            event.registerLayerDefinition(BrawlerModel.LAYER_LOCATION,BrawlerModel::createBodyLayer);
            event.registerLayerDefinition(BlocklingModel.LAYER_LOCATION, BlocklingModel::createBodyLayer);
            event.registerLayerDefinition(ArmedSpiderModel.LAYER_LOCATION, ArmedSpiderModel::createBodyLayer);

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






    }


    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents {


        @SubscribeEvent
        public static void registryRegisterEvent(NewRegistryEvent event){
            event.register(ModRegistries.MAGIC);
        }

        @SubscribeEvent
        public static void entityAttributes(EntityAttributeCreationEvent event){
            event.put(YoaEntityTypes.BRAWLER_TYPE.get(), BrawlerEntity.createAttributes().build());
            event.put(YoaEntityTypes.BRAWLING_TYPE.get(), BrawlingEntity.createAttributes().build());
            event.put(YoaEntityTypes.BLOCKLING_TYPE.get(), Blockling.createAttributes().build());
            event.put(YoaEntityTypes.ARMED_SPIDER_TYPE.get(), ArmedSpider.createAttributes().build());
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
        }

        @SubscribeEvent
        private static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(CRUCIBLE_MENU.get(), CrucibleScreen::new);
            event.register(HAMMERING_STATION_MENU.get(), HammeringStationScreen::new);
        }
    }
}

