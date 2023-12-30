package com.fuyuvulpes.yoamod.datagen.generators.loot;

import com.fuyuvulpes.yoamod.registries.BlocksModReg;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Set;

public class ModBlockLoot extends BlockLootSubProvider {
    public ModBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(BlocksModReg.AUGMENTING_STATION.get());
        this.dropSelf(BlocksModReg.HAMMERING_STATION.get());
        this.dropSelf(BlocksModReg.MELTING_POT.get());

    }


    @Override
    protected Iterable<Block> getKnownBlocks() {

        return (Iterable<Block>) BlocksModReg.BLOCKS.getEntries().stream().map(DeferredHolder::value).toList().iterator();
    }
}
