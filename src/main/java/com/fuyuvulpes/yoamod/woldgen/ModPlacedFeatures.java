package com.fuyuvulpes.yoamod.woldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class ModPlacedFeatures {


    public static final ResourceKey<PlacedFeature> SILVER_ORE_PLACED_KEY = registerKey("silver_ore_placed");
    public static final ResourceKey<PlacedFeature> BISMUTH_ORE_PLACED_KEY = registerKey("bismuth_ore_placed");
    public static final ResourceKey<PlacedFeature> TITANIUM_ORE_PLACED_KEY = registerKey("titanium_ore_placed");
    public static final ResourceKey<PlacedFeature> WITHERITE_ORE_PLACED_KEY = registerKey("witherite_ore_placed");
    public static final ResourceKey<PlacedFeature> IOLITE_ORE_PLACED_KEY = registerKey("iolite_ore_placed");
    public static final ResourceKey<PlacedFeature> ALEXANDRITE_ORE_PLACED_KEY = registerKey("alexandrite_ore_placed");
    public static final ResourceKey<PlacedFeature> ADAMANTITE_ORE_PLACED_KEY = registerKey("adamantite_ore_placed");
    public static final ResourceKey<PlacedFeature>  IRON_CREAK_PLACED_KEY = registerKey("iron_creaks_placed");
    public static final ResourceKey<PlacedFeature>  DIAMOND_CREAK_PLACED_KEY = registerKey("diamond_creaks_placed");
    public static final ResourceKey<PlacedFeature>  TITANIUM_CREAK_PLACED_KEY = registerKey("titanium_creaks_placed");
    public static final ResourceKey<PlacedFeature> CREAKS_FRACTURE_PLACED = registerKey("creaks_fracture_placed");
    public static final ResourceKey<PlacedFeature> CREAKS_CRYSTAL_KEY_PLACED = registerKey("creaks_crystal_placed");


    public static final ResourceKey<PlacedFeature> CREAKSTONE_CLUSTER_PLACED = registerKey("creakstone_cluster_placed");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfigFeatures.SILVER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(320))));


        register(context, BISMUTH_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfigFeatures.BISMUTH_ORE_KEY),
                ModOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-52), VerticalAnchor.absolute(24))));


        register(context, TITANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfigFeatures.TITANIUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-92), VerticalAnchor.absolute(-16))));


        register(context, WITHERITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfigFeatures.WITHERITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(8,
                        PlacementUtils.RANGE_10_10));


        register(context, IOLITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfigFeatures.IOLITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(4,
                        PlacementUtils.RANGE_10_10));

        //THE CREAKS

        register(context, CREAKS_FRACTURE_PLACED, configuredFeatures.getOrThrow(ModConfigFeatures.CREAKS_FRACTURE_KEY),
                ModOrePlacement.commonOrePlacement(34,
                        PlacementUtils.RANGE_10_10));

        register(context, CREAKS_CRYSTAL_KEY_PLACED, configuredFeatures.getOrThrow(ModConfigFeatures.CREAKS_CRYSTAL_KEY),
                ModOrePlacement.commonOrePlacement(1,
                        PlacementUtils.RANGE_10_10));


        register(context, IRON_CREAK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfigFeatures.IRON_CREAK_KEY),
                ModOrePlacement.commonOrePlacement(14,
                        PlacementUtils.RANGE_10_10));

        register(context, DIAMOND_CREAK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfigFeatures.DIAMOND_CREAK_KEY),
                ModOrePlacement.commonOrePlacement(10,
                        PlacementUtils.RANGE_10_10));

        register(context, TITANIUM_CREAK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfigFeatures.TITANIUM_CREAK_KEY),
                ModOrePlacement.commonOrePlacement(8,
                        PlacementUtils.RANGE_10_10));


        register(context, ALEXANDRITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfigFeatures.ALEXANDRITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-52), VerticalAnchor.belowTop(40))));


        register(context, ADAMANTITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfigFeatures.ADAMANTITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.BOTTOM, VerticalAnchor.absolute(80))));



        register(context,CREAKSTONE_CLUSTER_PLACED, configuredFeatures.getOrThrow(ModConfigFeatures.CREAKSTONE_CLUSTER),
                CountPlacement.of(UniformInt.of(12, 46)),
                InSquarePlacement.spread(),PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT
        );


    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers) {
        context.register(key, new PlacedFeature(configuration, List.of(modifiers)));
    }

}
