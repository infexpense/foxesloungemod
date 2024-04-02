package com.fuyuvulpes.yoamod.core;

import com.fuyuvulpes.yoamod.world.magic.Magic;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.RegistryBuilder;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class YoaRegistries {

    public static final Registry<Magic> MAGIC = new RegistryBuilder<>(Keys.MAGIC).create();;


    public static final class Keys {
        public static final ResourceKey<Registry<Magic>> MAGIC = key("magic");

        private static <T> ResourceKey<Registry<T>> key(String name) {
            return ResourceKey.createRegistryKey(new ResourceLocation(MODID, name));
        }
    }
}
