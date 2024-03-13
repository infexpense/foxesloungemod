package com.fuyuvulpes.yoamod.data.generators.loot;

import com.fuyuvulpes.yoamod.core.registries.YoaBlocks;
import com.fuyuvulpes.yoamod.core.registries.YoaItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.Holder;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLoot extends BlockLootSubProvider {
    public ModBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.dropSelf(YoaBlocks.BLISSWOOD_PLANKS.get());
        this.dropSelf(YoaBlocks.BLISSWOOD_SAPLING.get());
        this.dropSelf(YoaBlocks.BLISSWOOD_LOG.get());
        this.dropSelf(YoaBlocks.STRIPPED_BLISSWOOD_LOG.get());
        this.dropSelf(YoaBlocks.BLISSWOOD_WOOD.get());
        this.dropSelf(YoaBlocks.STRIPPED_BLISSWOOD_WOOD.get());
        this.dropSelf(YoaBlocks.BLISSWOOD_SIGN.get());
        this.dropSelf(YoaBlocks.BLISSWOOD_HANGING_SIGN.get());
        this.dropSelf(YoaBlocks.BLISSWOOD_PRESSURE_PLATE.get());
        this.dropSelf(YoaBlocks.BLISSWOOD_TRAPDOOR.get());
        this.dropSelf(YoaBlocks.BLISSWOOD_STAIRS.get());
        this.dropSelf(YoaBlocks.BLISSWOOD_BUTTON.get());
        this.dropSelf(YoaBlocks.BLISSWOOD_FENCE_GATE.get());
        this.dropSelf(YoaBlocks.BLISSWOOD_FENCE.get());
        this.dropPottedContents(YoaBlocks.POTTED_BLISSWOOD_SAPLING.get());
        this.add(YoaBlocks.BLISSWOOD_SLAB.get(), this::createSlabItemTable);
        this.add(YoaBlocks.BLISSWOOD_DOOR.get(), this::createDoorTable);
        this.add(YoaBlocks.BLISSWOOD_LEAVES.get(), block -> this.createLeavesDrops(block, YoaBlocks.BLISSWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));




        this.dropSelf(YoaBlocks.HAMMERING_STATION.get());
        this.dropSelf(YoaBlocks.CRUCIBLE.get());
        this.dropSelf(YoaBlocks.POINTED_CREAKSTONE.get());
        this.add(YoaBlocks.CRYSTALIC_REMNANTS.get(), block -> {
            return createSilkTouchDispatchTable(
                    block,
                    this.applyExplosionDecay(
                            block,
                            LootItem.lootTableItem(YoaItems.CRYSTALIC_SHARD)
                                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 8.0F)))
                                    .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                                    .apply(LimitCount.limitCount(IntRange.range(1, 12)))
                    )
            );
        });

        this.dropSelf(YoaBlocks.CREAKSTONE.get());
        this.dropSelf(YoaBlocks.CREAKSTONE_STAIRS.get());
        this.add(YoaBlocks.CREAKSTONE_SLAB.get(), block -> createSlabItemTable(YoaBlocks.CREAKSTONE_SLAB.get()));
        this.dropSelf(YoaBlocks.CREAKSTONE_WALL.get());
        this.dropSelf(YoaBlocks.CREAKSTONE_TILES.get());
        this.dropSelf(YoaBlocks.CREAKSTONE_TILES_STAIRS.get());
        this.add(YoaBlocks.CREAKSTONE_TILES_SLAB.get(), block -> createSlabItemTable(YoaBlocks.CREAKSTONE_SLAB.get()));
        this.dropSelf(YoaBlocks.CREAKSTONE_TILES_WALL.get());
        this.add(YoaBlocks.OVERGROWN_CREAKSTONE.get(), block -> this.createSingleItemTableWithSilkTouch(block, YoaBlocks.CREAKSTONE.get()));
        this.add(YoaBlocks.CREAKSTONE_IRON_ORE.get(), block -> this.createOreDrop(block, Items.RAW_IRON));
        this.add(YoaBlocks.CREAKSTONE_DIAMOND_ORE.get(), block -> this.createOreDrop(block, Items.DIAMOND));
        this.dropSelf(YoaBlocks.RUNE_CRYSTAL_BLOCK.get());
        this.dropSelf(YoaBlocks.CRYSTALIC_CREAKSTONE_TILES.get());
        this.dropSelf(YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_STAIRS.get());
        this.add(YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_SLAB.get(), block -> createSlabItemTable(YoaBlocks.CREAKSTONE_SLAB.get()));
        this.dropSelf(YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_WALL.get());

        this.add(YoaBlocks.RUNE_CRYSTAL_CLUSTER.get(), block -> createSilkTouchDispatchTable(
                block,
                (LootItem.lootTableItem(YoaItems.RUNE_CRYSTAL.get())
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.CLUSTER_MAX_HARVESTABLES))))
                        .otherwise(
                                this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(YoaItems.RUNE_CRYSTAL.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F)))
                                )
                        )
        ));

        this.add(YoaBlocks.SILVER_ORE.get(), block -> this.createOreDrop(block, YoaItems.RAW_SILVER.get()));
        this.add(YoaBlocks.DEEPSLATE_SILVER_ORE.get(), block -> this.createOreDrop(block, YoaItems.RAW_SILVER.get()));
        this.add(YoaBlocks.TITANIUM_ORE.get(), block -> this.createOreDrop(block, YoaItems.RAW_TITANIUM.get()));
        this.add(YoaBlocks.DEEPSLATE_TITANIUM_ORE.get(), block -> this.createOreDrop(block, YoaItems.RAW_TITANIUM.get()));
        this.add(YoaBlocks.CREAKSTONE_TITANIUM_ORE.get(), block -> this.createOreDrop(block, YoaItems.RAW_TITANIUM.get()));
        this.add(YoaBlocks.BISMUTH_ORE.get(), block -> this.createOreDrop(block, YoaItems.RAW_BISMUTH.get()));
        this.add(YoaBlocks.DEEPSLATE_BISMUTH_ORE.get(), block -> this.createOreDrop(block, YoaItems.RAW_BISMUTH.get()));
        this.add(YoaBlocks.WITHERITE_ORE.get(), block -> this.createOreDrop(block, YoaItems.WITHERITE.get()));
        this.add(YoaBlocks.IOLITE_ORE.get(), block -> this.createOreDrop(block, YoaItems.IOLITE.get()));
        this.add(YoaBlocks.ALEXANDRITE_ORE.get(), block -> this.createOreDrop(block, YoaItems.ALEXANDRITE.get()));
        this.add(YoaBlocks.ADAMANTITE_ORE.get(), block -> this.createOreDrop(block, YoaItems.RAW_ADAMANTITE.get()));

        this.dropSelf(YoaBlocks.BRASS_BLOCK.get());
        this.dropSelf(YoaBlocks.SILVER_BLOCK.get());
        this.dropSelf(YoaBlocks.RAW_SILVER_BLOCK.get());
        this.dropSelf(YoaBlocks.BRONZE_BLOCK.get());
        this.dropSelf(YoaBlocks.STEEL_BLOCK.get());
        this.dropSelf(YoaBlocks.BISMUTH_BLOCK.get());
        this.dropSelf(YoaBlocks.RAW_BISMUTH_BLOCK.get());
        this.dropSelf(YoaBlocks.TITANIUM_BLOCK.get());
        this.dropSelf(YoaBlocks.RAW_TITANIUM_BLOCK.get());
        this.dropSelf(YoaBlocks.WITHERITE_BLOCK.get());
        this.dropSelf(YoaBlocks.IOLITE_BLOCK.get());
        this.dropSelf(YoaBlocks.ALEXANDRITE_BLOCK.get());
        this.dropSelf(YoaBlocks.ADAMANTITE_BLOCK.get());
        this.dropSelf(YoaBlocks.RAW_ADAMANTITE_BLOCK.get());

        this.dropSelf(YoaBlocks.HAUNTED_LAMP.get());
        this.add(YoaBlocks.ETHERFRLOS.get(), LootTable.lootTable());

    }




    protected void dropPottedContents(Block pFlowerPot) {
        this.add(pFlowerPot, p_304146_ -> this.createPotFlowerItemTable(((FlowerPotBlock)p_304146_).getPotted()));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {

        return YoaBlocks.BLOCKS.getEntries().stream().map(Holder::value).collect(Collectors.toList());
    }

}
