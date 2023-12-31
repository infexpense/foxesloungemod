package com.fuyuvulpes.yoamod;

import com.fuyuvulpes.yoamod.client.entities.renderers.HammeringStationRenderer;
import com.fuyuvulpes.yoamod.registries.BlockEntitiesModReg;
import com.fuyuvulpes.yoamod.registries.BlocksModReg;
import com.fuyuvulpes.yoamod.registries.CreativeTabRegistry;
import com.fuyuvulpes.yoamod.registries.ItemsModReg;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


@Mod(YOAMod.MODID)
public class YOAMod
{

    public static final String MODID = "yoamod";




    public YOAMod(IEventBus modEventBus)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        BlocksModReg.register(modEventBus);

        ItemsModReg.register(modEventBus);
        BlockEntitiesModReg.register(modEventBus);

        CreativeTabRegistry.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS){
            event.accept(BlocksModReg.HAMMERING_STATION);
            event.accept(BlocksModReg.AUGMENTING_STATION);
            event.accept(BlocksModReg.MELTING_POT);

        }


    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }


    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event){
            event.registerBlockEntityRenderer(BlockEntitiesModReg.HAMMERING_STATION.get(), HammeringStationRenderer::new);
        }


        @SubscribeEvent
        public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){
        }
    }
}
