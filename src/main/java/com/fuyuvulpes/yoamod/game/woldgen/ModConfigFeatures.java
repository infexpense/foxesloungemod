package com.fuyuvulpes.yoamod.game.woldgen;

import com.fuyuvulpes.yoamod.core.registries.BlocksModReg;
import com.fuyuvulpes.yoamod.core.registries.TagRegistry;
import com.fuyuvulpes.yoamod.core.registries.FeatureModRegistry;
import com.fuyuvulpes.yoamod.game.woldgen.features.configuration.CreakstoneClusterConfiguration;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ClampedNormalFloat;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class ModConfigFeatures {



    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_ORE_KEY = registerKey("silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BISMUTH_ORE_KEY = registerKey("bismuth_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TITANIUM_ORE_KEY = registerKey("titanium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WITHERITE_ORE_KEY = registerKey("witherite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> IOLITE_ORE_KEY = registerKey("iolite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALEXANDRITE_ORE_KEY = registerKey("alexandrite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ADAMANTITE_ORE_KEY = registerKey("adamantite_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> IRON_CREAK_KEY = registerKey("iron_creaks");
    public static final ResourceKey<ConfiguredFeature<?,?>> DIAMOND_CREAK_KEY = registerKey("diamond_creaks");
    public static final ResourceKey<ConfiguredFeature<?,?>> TITANIUM_CREAK_KEY = registerKey("titanium_creaks");
    public static final ResourceKey<ConfiguredFeature<?,?>> CREAKS_FRACTURE_KEY = registerKey("creaks_fracture");
    public static final ResourceKey<ConfiguredFeature<?,?>> CREAKS_CRYSTAL_KEY = registerKey("creaks_crystal");

    public static final ResourceKey<ConfiguredFeature<?,?>> RUNE_GEODE = registerKey("rune_geode");

    public static final ResourceKey<ConfiguredFeature<?,?>> CREAKSTONE_CLUSTER = registerKey("creakstone_cluster");
    public static final ResourceKey<ConfiguredFeature<?,?>> RUNE_CLUSTER_RANDOM = registerKey("rune_cluster_random");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplacables = new TagMatchTest(TagRegistry.Blocks.NETHER_ORE_REPLACEABLES);
        RuleTest endReplaceables = new TagMatchTest(TagRegistry.Blocks.END_ORE_REPLACEABLES);
        RuleTest creakReplaceables = new TagMatchTest(TagRegistry.Blocks.CREAK_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> SilverOres = List.of(OreConfiguration.target(stoneReplaceable,
                        BlocksModReg.SILVER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlocksModReg.DEEPSLATE_SILVER_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> TitaniumOres = List.of(OreConfiguration.target(stoneReplaceable,
                        BlocksModReg.TITANIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlocksModReg.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> BismuthOres = List.of(OreConfiguration.target(stoneReplaceable,
                        BlocksModReg.BISMUTH_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlocksModReg.DEEPSLATE_BISMUTH_ORE.get().defaultBlockState()));

        register(context, SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(SilverOres, 12));

        register(context, BISMUTH_ORE_KEY, Feature.ORE, new OreConfiguration(BismuthOres , 8));


        register(context, TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(TitaniumOres, 5));

        register(context, WITHERITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                BlocksModReg.WITHERITE_ORE.get().defaultBlockState(), 5));

        register(context, IOLITE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                BlocksModReg.IOLITE_ORE.get().defaultBlockState(), 4));


        //CREAKS
        register(context, CREAKS_FRACTURE_KEY, Feature.ORE, new OreConfiguration(creakReplaceables,
                BlocksModReg.CREAKSTONE_FRACTURE.get().defaultBlockState(), 3));
        register(context, CREAKS_CRYSTAL_KEY, Feature.ORE, new OreConfiguration(creakReplaceables,
                BlocksModReg.CRYSTALIC_REMNANTS.get().defaultBlockState(), 40));


        register(context, IRON_CREAK_KEY, Feature.ORE, new OreConfiguration(creakReplaceables,
                BlocksModReg.CREAKSTONE_IRON_ORE.get().defaultBlockState(), 15));

        register(context, DIAMOND_CREAK_KEY, Feature.ORE, new OreConfiguration(creakReplaceables,
                BlocksModReg.CREAKSTONE_DIAMOND_ORE.get().defaultBlockState(), 9));


        register(context, TITANIUM_CREAK_KEY, Feature.ORE, new OreConfiguration(creakReplaceables,
                BlocksModReg.CREAKSTONE_TITANIUM_ORE.get().defaultBlockState(), 7));

        register(context, ALEXANDRITE_ORE_KEY, Feature.ORE, new OreConfiguration(creakReplaceables,
                BlocksModReg.ALEXANDRITE_ORE.get().defaultBlockState(), 5));

        register(context, ADAMANTITE_ORE_KEY, Feature.ORE, new OreConfiguration(creakReplaceables,
                BlocksModReg.ADAMANTITE_ORE.get().defaultBlockState(), 3));

        register(context,RUNE_GEODE, Feature.GEODE, new GeodeConfiguration(
                new GeodeBlockSettings(
                        BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(BlocksModReg.RUNE_CRYSTAL_BLOCK.get()),
                        BlockStateProvider.simple(BlocksModReg.RUNE_CRYSTAL_BLOCK.get()),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.OBSIDIAN),
                        List.of(
                                BlocksModReg.RUNE_CRYSTAL_CLUSTER.get().defaultBlockState()
                        ),
                        BlockTags.FEATURES_CANNOT_REPLACE,
                        BlockTags.GEODE_INVALID_BLOCKS
                ),
                new GeodeLayerSettings(1.7, 2.2, 3.2, 4.2),
                new GeodeCrackSettings(0.95, 2.0, 2),
                0.35,
                0.083,
                true,
                UniformInt.of(4, 10),
                UniformInt.of(2, 5),
                UniformInt.of(1, 3),
                -36,
                26,
                0.02,
                1
        ));

        register(context, RUNE_CLUSTER_RANDOM, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(
                        BlockStateProvider.simple(BlocksModReg.RUNE_CRYSTAL_CLUSTER.get())),
                List.of(
                        Blocks.STONE,
                        Blocks.DEEPSLATE,
                        Blocks.ANDESITE,
                        Blocks.DIORITE,
                        Blocks.GRANITE,
                        BlocksModReg.CREAKSTONE.get())));



        register(context,CREAKSTONE_CLUSTER, FeatureModRegistry.CREAKSTONE_CLUSTER, new CreakstoneClusterConfiguration(
                9,
                UniformInt.of(1, 8),
                UniformInt.of(2, 12),
                1,
                2,
                UniformInt.of(0, 4),
                UniformFloat.of(0.0F, 0.7F),
                ClampedNormalFloat.of(0.1F, 0.3F, 0.1F, 0.7F),
                0.1F,
                3,
                8
        ));
    }





    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
