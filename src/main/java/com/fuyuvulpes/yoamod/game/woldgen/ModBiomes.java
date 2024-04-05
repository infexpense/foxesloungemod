package com.fuyuvulpes.yoamod.game.woldgen;

import com.fuyuvulpes.yoamod.game.woldgen.features.ModBiomeFeatures;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class ModBiomes {



    public static final ResourceKey<Biome> DESOLATE_CREAKS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(MODID, "desolate_creaks"));
    public static final ResourceKey<Biome> OVERGROWN_GROTTO = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(MODID, "overgrown_grotto"));

    public static void boostrap(BootstapContext<Biome> context) {
        context.register(DESOLATE_CREAKS, desolate_creaks(context));
        context.register(OVERGROWN_GROTTO, overgrown_grotto(context));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);

    }


    private static void globalCreaksGeneration(BiomeGenerationSettings.Builder biomeBuilder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES,ModPlacedFeatures.CREAKS_GATEWAY_PLACED);

        ModBiomeFeatures.addCreakOres(biomeBuilder);

    }




    public static Biome desolate_creaks(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        ModBiomeFeatures.addCreakBaseSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalCreaksGeneration(biomeBuilder);



        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.0f)
                .temperature(0.0f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xa991c7)
                        .waterFogColor(0x4c3c59)
                        .skyColor(0x1c070a)
                        .grassColorOverride(0x4a5444)
                        .foliageColorOverride(0x4a5444)
                        .fogColor(0x1c070a)
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.ASH, 0.01025F))
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DEEP_DARK))
                        .build())
                .build();
    }


    public static Biome overgrown_grotto(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        ModBiomeFeatures.addCreakBaseSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalCreaksGeneration(biomeBuilder);
        ModBiomeFeatures.addOvergrownGrottoFeatures(biomeBuilder);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.0f)
                .temperature(0.3f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xa991c7)
                        .waterFogColor(0x4c3c59)
                        .skyColor(0x1c070a)
                        .grassColorOverride(0x576b3c)
                        .foliageColorOverride(0x576b3c)
                        .fogColor(0x1c070a)
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.SPORE_BLOSSOM_AIR, 0.00925F))
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DEEP_DARK))
                        .build())
                .build();
    }

}
