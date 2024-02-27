package com.fuyuvulpes.yoamod;

import com.fuyuvulpes.yoamod.core.YOAModCommonConfig;
import com.fuyuvulpes.yoamod.game.client.entities.model.PlaneModel;
import com.fuyuvulpes.yoamod.game.client.entities.renderers.*;
import com.fuyuvulpes.yoamod.game.client.particle.BleedingParticle;
import com.fuyuvulpes.yoamod.game.client.screens.CrucibleScreen;
import com.fuyuvulpes.yoamod.world.entity.ArmedSpider;
import com.fuyuvulpes.yoamod.world.entity.Blockling;
import com.fuyuvulpes.yoamod.world.entity.BrawlerEntity;
import com.fuyuvulpes.yoamod.world.item.weaponry.WarFanItem;
import com.fuyuvulpes.yoamod.game.client.entities.model.ArmedSpiderModel;
import com.fuyuvulpes.yoamod.game.client.entities.model.BlocklingModel;
import com.fuyuvulpes.yoamod.game.client.entities.model.BrawlerModel;
import com.fuyuvulpes.yoamod.core.registries.*;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.CreativeModeTabs;
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
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.SpawnPlacementRegisterEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import static com.fuyuvulpes.yoamod.core.registries.MenusModReg.CRUCIBLE_MENU;


@Mod(YOAMod.MODID)
public class YOAMod {

    public static final String MODID = "yoamod";


    public YOAMod(IEventBus modEventBus) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        FeatureModRegistry.register(modEventBus);
        RecipesModReg.register(modEventBus);
        ParticleModReg.register(modEventBus);
        ModEffects.register(modEventBus);
        EntityTypeModReg.register(modEventBus);
        MenusModReg.register(modEventBus);
        //MagicSpellsRegistry.register(modEventBus);

        BlocksModReg.register(modEventBus);

        ItemsModReg.register(modEventBus);
        BlockEntitiesModReg.register(modEventBus);


        CreativeTabRegistry.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, YOAModCommonConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(BlocksModReg.HAMMERING_STATION);
            event.accept(BlocksModReg.AUGMENTING_STATION);
            event.accept(BlocksModReg.CRUCIBLE);

        }


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
                ItemProperties.register(ItemsModReg.LONGBOW.get(),
                        new ResourceLocation(MODID, "pulling"), (stack, level, living, id) -> {
                            return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F;
                        });

                ItemProperties.register(ItemsModReg.LONGBOW.get(),
                        new ResourceLocation(MODID, "pull"), (stack, level, living, id) -> {
                            if (living == null) {
                                return 0.0F;
                            } else {
                                return living.getUseItem() != stack ? 0.0F : (float) (stack.getUseDuration() - living.getUseItemRemainingTicks()) / 20.0F;
                            }
                        });

                ItemsModReg.ITEMS.getEntries().forEach(itemDeferredHolder -> {
                    if (itemDeferredHolder.get() instanceof WarFanItem item) {
                        ItemProperties.register(item,
                                new ResourceLocation(MODID, "open"), (stack, level, living, id) -> item.isOpen(stack) ? 1.0F : 0.0F);
                    }
                });


            });


        }


        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(BlockEntitiesModReg.HAMMERING_STATION.get(), HammeringStationRenderer::new);
            event.registerEntityRenderer(EntityTypeModReg.PLANE_TYPE.get(), PlaneRenderer::new);
            event.registerEntityRenderer(EntityTypeModReg.BRAWLER_TYPE.get(), BrawlerRenderer::new);
            event.registerEntityRenderer(EntityTypeModReg.BLOCKLING_TYPE.get(), BlocklingRenderer::new);
            event.registerEntityRenderer(EntityTypeModReg.ARMED_SPIDER_TYPE.get(), ArmedSpiderRenderer::new);
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
            event.registerSpriteSet(ParticleModReg.BLEEDING.get(), (pSprites) ->
                    (pType, pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed) ->
                            new BleedingParticle(pLevel,pX,pY,pZ,pSprites));
        }


    }


    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents {


        @SubscribeEvent
        public static void entityAttributes(EntityAttributeCreationEvent event){
            event.put(EntityTypeModReg.BRAWLER_TYPE.get(), BrawlerEntity.createAttributes().build());
            event.put(EntityTypeModReg.BLOCKLING_TYPE.get(), Blockling.createAttributes().build());
            event.put(EntityTypeModReg.ARMED_SPIDER_TYPE.get(), ArmedSpider.createAttributes().build());
        }



        @SubscribeEvent
        public static void spawnPlacements(SpawnPlacementRegisterEvent event){
            event.register(EntityTypeModReg.BRAWLER_TYPE.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    BrawlerEntity::canSpawn,
                    SpawnPlacementRegisterEvent.Operation.OR);
            event.register(EntityTypeModReg.ARMED_SPIDER_TYPE.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules,
                    SpawnPlacementRegisterEvent.Operation.OR);
            event.register(EntityTypeModReg.BLOCKLING_TYPE.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Blockling::canSpawn,
                    SpawnPlacementRegisterEvent.Operation.OR);
        }

        @SubscribeEvent
        private static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(CRUCIBLE_MENU.get(), CrucibleScreen::new);


    }
}
}

