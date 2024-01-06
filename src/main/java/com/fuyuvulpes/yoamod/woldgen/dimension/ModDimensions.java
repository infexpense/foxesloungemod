package com.fuyuvulpes.yoamod.woldgen.dimension;

import com.fuyuvulpes.yoamod.woldgen.NoiseRegistry;
import com.fuyuvulpes.yoamod.woldgen.biome.ModBiomes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import java.util.List;
import java.util.OptionalLong;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class ModDimensions {
    public static final ResourceKey<LevelStem> DIMKEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(MODID, "yoadim"));
    public static final ResourceKey<Level> LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(MODID, "yoadim"));
    public static final ResourceKey<DimensionType> DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(MODID, "yoadim_type"));


    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime
                true, // hasSkylight
                true, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                false, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY
                384, // height
                384, // logicalHeight
                BlockTags.INFINIBURN_END, // infiniburn
                BuiltinDimensionTypes.END_EFFECTS, // effectsLocation
                0.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 5)));
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(ModBiomes.DESOLATE_CREAKS)),
                noiseGenSettings.getOrThrow(NoiseRegistry.CREAKS));

        NoiseBasedChunkGenerator noiseBasedChunkGenerator;
        noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(Pair.of(
                                        Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.DESOLATE_CREAKS)),
                                Pair.of(
                                        Climate.parameters(0.1F, 0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.DESOLATE_CREAKS)),
                                Pair.of(
                                        Climate.parameters(0.3F, 0.6F, 0.1F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.OVERGROWN_GROTTO)),
                                Pair.of(
                                        Climate.parameters(0.4F, 0.3F, 0.2F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.OVERGROWN_GROTTO))

                        ))),
                noiseGenSettings.getOrThrow(NoiseRegistry.CREAKS));

        LevelStem stem = new LevelStem(dimTypes.getOrThrow(ModDimensions.DIM_TYPE), noiseBasedChunkGenerator);

        context.register(DIMKEY, stem);
    }


}
