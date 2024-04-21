package com.fuyuvulpes.yoamod.core.registries;

import com.fuyuvulpes.yoamod.world.entity.*;
import com.fuyuvulpes.yoamod.world.entity.projectile.*;
import com.fuyuvulpes.yoamod.world.entity.PeafowlEntity;
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

    public static final DeferredHolder<EntityType<?>,EntityType<FennecFoxEntity>> FENNEC_FOX_TYPE = ENTITY.register("fennec_fox",
            () -> EntityType.Builder.<FennecFoxEntity>of(FennecFoxEntity::new, MobCategory.CREATURE)
                    .sized(0.8F,0.7F)
                    .build(new ResourceLocation(MODID,"fennec_fox").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<ToucanEntity>> TOUCAN_TYPE = ENTITY.register("toucan",
            () -> EntityType.Builder.<ToucanEntity>of(ToucanEntity::new, MobCategory.CREATURE)
                    .sized(0.4F,0.5F)
                    .build(new ResourceLocation(MODID,"toucan").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<OwlEntity>> OWL_TYPE = ENTITY.register("owl",
            () -> EntityType.Builder.<OwlEntity>of(OwlEntity::new, MobCategory.CREATURE)
                    .sized(0.6F,0.8F)
                    .build(new ResourceLocation(MODID,"owl").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<PeafowlEntity>> PEAFOWL_TYPE = ENTITY.register("peafowl",
            () -> EntityType.Builder.<PeafowlEntity>of(PeafowlEntity::new, MobCategory.CREATURE)
                    .sized(0.8F,0.8F)
                    .build(new ResourceLocation(MODID,"peafowl").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<YukiOnnaEntity>> YUKI_ONNA_TYPE = ENTITY.register("yuki_onna",
            () -> EntityType.Builder.<YukiOnnaEntity>of(YukiOnnaEntity::new, MobCategory.MONSTER)
                    .sized(0.6F,2.0F)
                    .build(new ResourceLocation(MODID,"yuki_onna").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<BeetleEntity>> BEETLE_TYPE = ENTITY.register("beetle",
            () -> EntityType.Builder.<BeetleEntity>of(BeetleEntity::new, MobCategory.CREATURE)
                    .sized(0.4F,0.2F)
                    .build(new ResourceLocation(MODID,"beetle").toString()));



    public static final DeferredHolder<EntityType<?>,EntityType<DartProjectile>> DART = ENTITY.register("dart",
            () -> EntityType.Builder.<DartProjectile>of(DartProjectile::new, MobCategory.MISC).sized(0.5F, 0.5F)
                    .clientTrackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(MODID,"dart").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<ChakramEntity>> CHAKRAM = ENTITY.register("chakram",
            () -> EntityType.Builder.<ChakramEntity>of(ChakramEntity::new, MobCategory.MISC).sized(1.0F, 0.3F)
                    .clientTrackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(MODID,"chakram").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<BoomerangEntity>> BOOMERANG = ENTITY.register("boomerang",
            () -> EntityType.Builder.<BoomerangEntity>of(BoomerangEntity::new, MobCategory.MISC).sized(0.6F, 0.2F)
                    .clientTrackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(MODID,"boomerang").toString()));


    public static final DeferredHolder<EntityType<?>,EntityType<HarpoonEntity>> HARPOON = ENTITY.register("harpoon",
            () -> EntityType.Builder.<HarpoonEntity>of(HarpoonEntity::new, MobCategory.MISC).sized(0.3F, 0.3F)
                    .clientTrackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(MODID,"harpoon").toString()));


    public static final DeferredHolder<EntityType<?>,EntityType<ThrowingKnifeEntity>> THROWING_KNIFE = ENTITY.register("throwing_knife",
            () -> EntityType.Builder.<ThrowingKnifeEntity>of(ThrowingKnifeEntity::new, MobCategory.MISC).sized(0.3F, 0.2F)
                    .clientTrackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(MODID,"throwing_knife").toString()));


    public static final DeferredHolder<EntityType<?>,EntityType<ShurikenEntity>> SHURIKEN = ENTITY.register("shuriken",
            () -> EntityType.Builder.<ShurikenEntity>of(ShurikenEntity::new, MobCategory.MISC).sized(0.1F, 0.1F)
                    .clientTrackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(MODID,"shuriken").toString()));



    public static void register(IEventBus eventBus){
        ENTITY.register(eventBus);
    }




}
