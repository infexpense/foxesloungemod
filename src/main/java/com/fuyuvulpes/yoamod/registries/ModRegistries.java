package com.fuyuvulpes.yoamod.registries;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.RegistryBuilder;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class ModRegistries {

    //public static final Registry<BlocklingTypes> BLOCKLING_TYPES = new RegistryBuilder<>(Keys.BLOCKLING_TYPES).create();;


    public static final class Keys {
        //public static final ResourceKey<Registry<BlocklingTypes>> BLOCKLING_TYPES = key("blockling_types");

        private static <T> ResourceKey<Registry<T>> key(String name) {
            return ResourceKey.createRegistryKey(new ResourceLocation(MODID, name));
        }
    }
}
