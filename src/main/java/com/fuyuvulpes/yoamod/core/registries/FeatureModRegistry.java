package com.fuyuvulpes.yoamod.core.registries;

import com.fuyuvulpes.yoamod.game.woldgen.features.configuration.CreakstoneClusterConfiguration;
import com.fuyuvulpes.yoamod.game.woldgen.features.feature.CreakstoneClusterFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class FeatureModRegistry {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, MODID);


    public static final Feature<CreakstoneClusterConfiguration> CREAKSTONE_CLUSTER = register(
            "creakstone_cluster_feature", new CreakstoneClusterFeature(CreakstoneClusterConfiguration.CODEC)
    );






    private static <C extends FeatureConfiguration, F extends Feature<C>> F register(String key, F value){
        FEATURES.register(key, ()-> value);
        return value;
    }


    public static void register(IEventBus eventBus){
        FEATURES.register(eventBus);
    }
}
