package com.fuyuvulpes.yoamod.core.registries;

import com.fuyuvulpes.yoamod.YOAMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public class NoiseRegistry {
    public static final ResourceKey<NoiseGeneratorSettings> CREAKS = ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation(YOAMod.MODID,"creaks"));

}
