package com.fuyuvulpes.yoamod.datagen.generators.loot;

import com.fuyuvulpes.yoamod.registries.BlocksModReg;
import com.fuyuvulpes.yoamod.registries.ItemsModReg;
import net.minecraft.core.Holder;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLoot extends BlockLootSubProvider {
    public ModBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(BlocksModReg.AUGMENTING_STATION.get());
        this.dropSelf(BlocksModReg.HAMMERING_STATION.get());
        this.dropSelf(BlocksModReg.MELTING_POT.get());

        this.dropSelf(BlocksModReg.CREAKSTONE.get());
        this.add(BlocksModReg.OVERGROWN_CREAKSTONE.get(), block -> this.createSingleItemTableWithSilkTouch(block, BlocksModReg.CREAKSTONE.get()));

        this.add(BlocksModReg.SILVER_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.RAW_SILVER.get()));
        this.add(BlocksModReg.DEEPSLATE_SILVER_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.RAW_SILVER.get()));
        this.add(BlocksModReg.TITANIUM_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.RAW_TITANIUM.get()));
        this.add(BlocksModReg.DEEPSLATE_TITANIUM_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.RAW_TITANIUM.get()));
        this.add(BlocksModReg.BISMUTH_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.RAW_BISMUTH.get()));
        this.add(BlocksModReg.DEEPSLATE_BISMUTH_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.RAW_BISMUTH.get()));
        this.add(BlocksModReg.WITHERITE_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.WITHERITE.get()));
        this.add(BlocksModReg.IOLITE_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.IOLITE.get()));
        this.add(BlocksModReg.ALEXANDRITE_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.ALEXANDRITE.get()));
        this.add(BlocksModReg.ADAMANTITE_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.RAW_ADAMANTITE.get()));

    }


    @Override
    protected Iterable<Block> getKnownBlocks() {

        return BlocksModReg.BLOCKS.getEntries().stream().map(Holder::value).collect(Collectors.toList());
    }
}
