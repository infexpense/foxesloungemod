package com.fuyuvulpes.yoamod.core.registries;

import com.fuyuvulpes.yoamod.world.entity.*;
import com.fuyuvulpes.yoamod.world.entity.vehicle.PlaneEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class YoaEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY = DeferredRegister.create(Registries.ENTITY_TYPE, MODID);

    public static final DeferredHolder<EntityType<?>,EntityType<PlaneEntity>> PLANE_TYPE = ENTITY.register("plane",
            () -> EntityType.Builder.<PlaneEntity>of(PlaneEntity::new, MobCategory.MISC)
                    .sized(2.0f,2.7F).clientTrackingRange(8)
                    .build(new ResourceLocation(MODID,"plane").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<BrawlerEntity>> BRAWLER_TYPE = ENTITY.register("brawler",
            () -> EntityType.Builder.<BrawlerEntity>of(BrawlerEntity::new, MobCategory.MONSTER)
                    .sized(4.0f,4.5F)
                    .build(new ResourceLocation(MODID,"brawler").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<FallenSamurai>> FALLEN_SAMURAI = ENTITY.register("fallen_samurai",
            () -> EntityType.Builder.<FallenSamurai>of(FallenSamurai::new, MobCategory.MONSTER)
                    .sized(0.8f,2.2F)
                    .build(new ResourceLocation(MODID,"fallen_samurai").toString()));
    public static final DeferredHolder<EntityType<?>,EntityType<BrawlingEntity>> BRAWLING_TYPE = ENTITY.register("brawling",
            () -> EntityType.Builder.<BrawlingEntity>of(BrawlingEntity::new, MobCategory.MONSTER)
                    .sized(1.2f,1.5F)
                    .build(new ResourceLocation(MODID,"brawling").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Blockling>> BLOCKLING_TYPE = ENTITY.register("blockling",
            () -> EntityType.Builder.<Blockling>of(Blockling::new, MobCategory.CREATURE)
                    .sized(0.8F,0.8F)
                    .build(new ResourceLocation(MODID,"blockling").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<ArmedSpider>> ARMED_SPIDER_TYPE = ENTITY.register("armed_spider",
            () -> EntityType.Builder.<ArmedSpider>of(ArmedSpider::new, MobCategory.MONSTER)
                    .sized(2.0F,1.7F)
                    .build(new ResourceLocation(MODID,"armed_spider").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<FennecFox>> FENNEC_FOX_TYPE = ENTITY.register("fennec_fox",
            () -> EntityType.Builder.<FennecFox>of(FennecFox::new, MobCategory.CREATURE)
                    .sized(1.0F,0.6F)
                    .build(new ResourceLocation(MODID,"fennec_fox").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Toucan>> TOUCAN_TYPE = ENTITY.register("toucan",
            () -> EntityType.Builder.<Toucan>of(Toucan::new, MobCategory.CREATURE)
                    .sized(0.2F,0.4F)
                    .build(new ResourceLocation(MODID,"toucan").toString()));





    public static void register(IEventBus eventBus){
        ENTITY.register(eventBus);
    }




}
