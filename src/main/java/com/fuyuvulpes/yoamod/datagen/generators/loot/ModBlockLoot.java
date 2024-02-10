package com.fuyuvulpes.yoamod.datagen.generators.loot;

import com.fuyuvulpes.yoamod.registries.BlocksModReg;
import com.fuyuvulpes.yoamod.registries.ItemsModReg;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.Holder;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.IntRange;
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
        this.dropSelf(BlocksModReg.AUGMENTING_STATION.get());
        this.dropSelf(BlocksModReg.HAMMERING_STATION.get());
        this.dropSelf(BlocksModReg.CRUCIBLE.get());
        this.dropSelf(BlocksModReg.POINTED_CREAKSTONE.get());
        this.add(BlocksModReg.CRYSTALIC_REMNANTS.get(), block -> {
            return createSilkTouchDispatchTable(
                    block,
                    this.applyExplosionDecay(
                            block,
                            LootItem.lootTableItem(ItemsModReg.CRYSTALIC_SHARD)
                                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 8.0F)))
                                    .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                                    .apply(LimitCount.limitCount(IntRange.range(1, 12)))
                    )
            );
        });

        this.dropSelf(BlocksModReg.CREAKSTONE.get());
        this.dropSelf(BlocksModReg.CREAKSTONE_STAIRS.get());
        this.add(BlocksModReg.CREAKSTONE_SLAB.get(), block -> createSlabItemTable(BlocksModReg.CREAKSTONE_SLAB.get()));
        this.dropSelf(BlocksModReg.CREAKSTONE_WALL.get());
        this.add(BlocksModReg.OVERGROWN_CREAKSTONE.get(), block -> this.createSingleItemTableWithSilkTouch(block, BlocksModReg.CREAKSTONE.get()));
        this.add(BlocksModReg.CREAKSTONE_IRON_ORE.get(), block -> this.createOreDrop(block, Items.RAW_IRON));
        this.add(BlocksModReg.CREAKSTONE_DIAMOND_ORE.get(), block -> this.createOreDrop(block, Items.DIAMOND));
        this.dropSelf(BlocksModReg.RUNE_CRYSTAL_BLOCK.get());

        this.add(BlocksModReg.RUNE_CRYSTAL_CLUSTER.get(), block -> createSilkTouchDispatchTable(
                block,
                (LootItem.lootTableItem(ItemsModReg.RUNE_CRYSTAL.get())
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.CLUSTER_MAX_HARVESTABLES))))
                        .otherwise(
                                this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(ItemsModReg.RUNE_CRYSTAL.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F)))
                                )
                        )
        ));

        this.add(BlocksModReg.SILVER_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.RAW_SILVER.get()));
        this.add(BlocksModReg.DEEPSLATE_SILVER_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.RAW_SILVER.get()));
        this.add(BlocksModReg.TITANIUM_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.RAW_TITANIUM.get()));
        this.add(BlocksModReg.DEEPSLATE_TITANIUM_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.RAW_TITANIUM.get()));
        this.add(BlocksModReg.CREAKSTONE_TITANIUM_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.RAW_TITANIUM.get()));
        this.add(BlocksModReg.BISMUTH_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.RAW_BISMUTH.get()));
        this.add(BlocksModReg.DEEPSLATE_BISMUTH_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.RAW_BISMUTH.get()));
        this.add(BlocksModReg.WITHERITE_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.WITHERITE.get()));
        this.add(BlocksModReg.IOLITE_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.IOLITE.get()));
        this.add(BlocksModReg.ALEXANDRITE_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.ALEXANDRITE.get()));
        this.add(BlocksModReg.ADAMANTITE_ORE.get(), block -> this.createOreDrop(block, ItemsModReg.RAW_ADAMANTITE.get()));

        this.dropSelf(BlocksModReg.BRASS_BLOCK.get());
        this.dropSelf(BlocksModReg.SILVER_BLOCK.get());
        this.dropSelf(BlocksModReg.RAW_SILVER_BLOCK.get());
        this.dropSelf(BlocksModReg.BRONZE_BLOCK.get());
        this.dropSelf(BlocksModReg.STEEL_BLOCK.get());
        this.dropSelf(BlocksModReg.BISMUTH_BLOCK.get());
        this.dropSelf(BlocksModReg.RAW_BISMUTH_BLOCK.get());
        this.dropSelf(BlocksModReg.TITANIUM_BLOCK.get());
        this.dropSelf(BlocksModReg.RAW_TITANIUM_BLOCK.get());
        this.dropSelf(BlocksModReg.WITHERITE_BLOCK.get());
        this.dropSelf(BlocksModReg.IOLITE_BLOCK.get());
        this.dropSelf(BlocksModReg.ALEXANDRITE_BLOCK.get());
        this.dropSelf(BlocksModReg.ADAMANTITE_BLOCK.get());
        this.dropSelf(BlocksModReg.RAW_ADAMANTITE_BLOCK.get());

    }


    @Override
    protected Iterable<Block> getKnownBlocks() {

        return BlocksModReg.BLOCKS.getEntries().stream().map(Holder::value).collect(Collectors.toList());
    }
}
