package com.fuyuvulpes.yoamod.core.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class ModKeys {

    public static final ResourceKey<DamageType> BLEEDING = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(MODID, "bleeding"));

}
