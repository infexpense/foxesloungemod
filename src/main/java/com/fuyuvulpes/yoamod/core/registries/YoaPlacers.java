package com.fuyuvulpes.yoamod.core.registries;

import com.fuyuvulpes.yoamod.game.woldgen.tree.placement.BlisswoodTrunkPlacement;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class YoaPlacers {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE,MODID);

    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<BlisswoodTrunkPlacement>> BLISSWOOD_TRUNK_PLACER =
            TRUNK_PLACERS.register("blisswood_trunk",() -> new TrunkPlacerType<>(BlisswoodTrunkPlacement.CODEC));





    public static void register(IEventBus modEventBus){
        TRUNK_PLACERS.register(modEventBus);
    }
}
