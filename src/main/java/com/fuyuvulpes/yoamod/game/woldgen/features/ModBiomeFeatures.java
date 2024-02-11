package com.fuyuvulpes.yoamod.game.woldgen.features;

import com.fuyuvulpes.yoamod.game.woldgen.ModPlacedFeatures;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomeFeatures {
    public static void addCreakOres(BiomeGenerationSettings.Builder biomeBuilder) {

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.RUNE_GEODE_CREAK_PLACED);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.CREAKSTONE_CLUSTER_PLACED);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CREAKS_FRACTURE_PLACED);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CREAKS_CRYSTAL_KEY_PLACED);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.IRON_CREAK_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DIAMOND_CREAK_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.TITANIUM_CREAK_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ALEXANDRITE_ORE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ADAMANTITE_ORE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.RUNE_CLUSTER_PLACED);
    }

    public static void addCreakBaseSpawns(MobSpawnSettings.Builder spawnBuilder) {
        BiomeDefaultFeatures.caveSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 50, 2, 6));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 50, 3, 5));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 20, 1, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PHANTOM, 60, 1, 8));
    }
        public static void addOvergrownGrottoFeatures(BiomeGenerationSettings.Builder biomeBuilder){

    }
}
