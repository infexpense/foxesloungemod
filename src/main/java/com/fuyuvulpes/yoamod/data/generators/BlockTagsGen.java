package com.fuyuvulpes.yoamod.data.generators;

import com.fuyuvulpes.yoamod.core.registries.YoaBlocks;
import com.fuyuvulpes.yoamod.core.registries.YoaTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class BlockTagsGen extends BlockTagsProvider {
    public BlockTagsGen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        YoaBlocks.HAMMERING_STATION.get(),
                        YoaBlocks.CRUCIBLE.get(),
                        YoaBlocks.CREAKSTONE.get(),
                        YoaBlocks.CREAKSTONE_STAIRS.get(),
                        YoaBlocks.CREAKSTONE_SLAB.get(),
                        YoaBlocks.CREAKSTONE_WALL.get(),
                        YoaBlocks.CREAKSTONE_TILES.get(),
                        YoaBlocks.CREAKSTONE_TILES_STAIRS.get(),
                        YoaBlocks.CREAKSTONE_TILES_SLAB.get(),
                        YoaBlocks.CREAKSTONE_TILES_WALL.get(),
                        YoaBlocks.CREAKSTONE_FRACTURE.get(),
                        YoaBlocks.OVERGROWN_CREAKSTONE.get(),
                        YoaBlocks.POINTED_CREAKSTONE.get(),
                        YoaBlocks.SILVER_ORE.get(),
                        YoaBlocks.DEEPSLATE_SILVER_ORE.get(),
                        YoaBlocks.TITANIUM_ORE.get(),
                        YoaBlocks.DEEPSLATE_TITANIUM_ORE.get(),
                        YoaBlocks.BISMUTH_ORE.get(),
                        YoaBlocks.DEEPSLATE_BISMUTH_ORE.get(),
                        YoaBlocks.WITHERITE_ORE.get(),
                        YoaBlocks.IOLITE_ORE.get(),

                        YoaBlocks.CREAKSTONE_IRON_ORE.get(),
                        YoaBlocks.CREAKSTONE_DIAMOND_ORE.get(),
                        YoaBlocks.CREAKSTONE_TITANIUM_ORE.get(),
                        YoaBlocks.CRYSTALIC_REMNANTS.get(),
                        YoaBlocks.ALEXANDRITE_ORE.get(),
                        YoaBlocks.ADAMANTITE_ORE.get(),

                        YoaBlocks.RUNE_CRYSTAL_CLUSTER.get(),
                        YoaBlocks.RUNE_CRYSTAL_BLOCK.get(),
                        YoaBlocks.CRYSTALIC_CREAKSTONE_TILES.get(),
                        YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_STAIRS.get(),
                        YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_SLAB.get(),
                        YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_WALL.get(),

                        YoaBlocks.BRASS_BLOCK.get(),
                        YoaBlocks.SILVER_BLOCK.get(),
                        YoaBlocks.RAW_SILVER_BLOCK.get(),
                        YoaBlocks.BRONZE_BLOCK.get(),
                        YoaBlocks.STEEL_BLOCK.get(),
                        YoaBlocks.BISMUTH_BLOCK.get(),
                        YoaBlocks.RAW_BISMUTH_BLOCK.get(),
                        YoaBlocks.TITANIUM_BLOCK.get(),
                        YoaBlocks.RAW_TITANIUM_BLOCK.get(),
                        YoaBlocks.WITHERITE_BLOCK.get(),
                        YoaBlocks.IOLITE_BLOCK.get(),
                        YoaBlocks.ALEXANDRITE_BLOCK.get(),
                        YoaBlocks.ADAMANTITE_BLOCK.get(),
                        YoaBlocks.RAW_ADAMANTITE_BLOCK.get(),

                        YoaBlocks.HAUNTED_LAMP.get()
                        );


        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(
                        YoaBlocks.HAMMERING_STATION.get(),
                        YoaBlocks.CRUCIBLE.get(),
                        YoaBlocks.RUNE_CRYSTAL_CLUSTER.get(),
                        YoaBlocks.RUNE_CRYSTAL_BLOCK.get(),
                        YoaBlocks.BRASS_BLOCK.get(),
                        YoaBlocks.SILVER_BLOCK.get(),
                        YoaBlocks.RAW_SILVER_BLOCK.get(),
                        YoaBlocks.BRONZE_BLOCK.get(),
                        YoaBlocks.HAUNTED_LAMP.get()
                );


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        YoaBlocks.STEEL_BLOCK.get(),
                        YoaBlocks.BISMUTH_ORE.get(),
                        YoaBlocks.DEEPSLATE_BISMUTH_ORE.get(),
                        YoaBlocks.BISMUTH_BLOCK.get(),
                        YoaBlocks.RAW_BISMUTH_BLOCK.get()

                );


        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(
                        YoaBlocks.DEEPSLATE_TITANIUM_ORE.get(),
                        YoaBlocks.TITANIUM_ORE.get(),
                        YoaBlocks.TITANIUM_BLOCK.get(),
                        YoaBlocks.RAW_TITANIUM_BLOCK.get(),
                        YoaBlocks.CRYSTALIC_REMNANTS.get(),
                        YoaBlocks.WITHERITE_ORE.get(),
                        YoaBlocks.WITHERITE_BLOCK.get(),
                        YoaBlocks.POINTED_CREAKSTONE.get()

                );


        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(
                        YoaBlocks.IOLITE_ORE.get(),
                        YoaBlocks.IOLITE_BLOCK.get()
                );

        this.tag(YoaTags.Blocks.NEEDS_TITANIUM_TOOL)
                .add(

                        YoaBlocks.CREAKSTONE.get(),
                        YoaBlocks.CREAKSTONE_STAIRS.get(),
                        YoaBlocks.CREAKSTONE_SLAB.get(),
                        YoaBlocks.CREAKSTONE_WALL.get(),
                        YoaBlocks.CREAKSTONE_FRACTURE.get(),
                        YoaBlocks.OVERGROWN_CREAKSTONE.get(),
                        YoaBlocks.CREAKSTONE_IRON_ORE.get(),
                        YoaBlocks.CREAKSTONE_TITANIUM_ORE.get(),
                        YoaBlocks.CREAKSTONE_TILES.get(),
                        YoaBlocks.CREAKSTONE_TILES_STAIRS.get(),
                        YoaBlocks.CREAKSTONE_TILES_SLAB.get(),
                        YoaBlocks.CREAKSTONE_TILES_WALL.get(),
                        YoaBlocks.CRYSTALIC_CREAKSTONE_TILES.get(),
                        YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_STAIRS.get(),
                        YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_SLAB.get(),
                        YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_WALL.get()
                );

        this.tag(YoaTags.Blocks.NEEDS_IOLITE_TOOL)
                .add(
                        YoaBlocks.CREAKSTONE_DIAMOND_ORE.get(),
                        YoaBlocks.ALEXANDRITE_ORE.get(),
                        YoaBlocks.ALEXANDRITE_BLOCK.get()

                );

        this.tag(YoaTags.Blocks.NEEDS_ALEXANDRITE_TOOL)
                .add(
                        YoaBlocks.ADAMANTITE_ORE.get(),
                        YoaBlocks.ADAMANTITE_BLOCK.get(),
                        YoaBlocks.RAW_ADAMANTITE_BLOCK.get()

                );

        this.tag(YoaTags.Blocks.CREAK_ORE_REPLACEABLES)
                .add(
                        YoaBlocks.CREAKSTONE.get(),
                        YoaBlocks.OVERGROWN_CREAKSTONE.get()

                );

        this.tag(YoaTags.Blocks.NETHER_ORE_REPLACEABLES)
                .add(
                        Blocks.NETHERRACK

                );

        this.tag(YoaTags.Blocks.END_ORE_REPLACEABLES)
                .add(
                        Blocks.END_STONE

                );


        this.tag(BlockTags.BASE_STONE_OVERWORLD)
                .add(
                        YoaBlocks.CREAKSTONE.get()
                );


        this.tag(BlockTags.WALLS)
                .add(
                        YoaBlocks.CREAKSTONE_WALL.get(),
                        YoaBlocks.CREAKSTONE_TILES_WALL.get(),
                        YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_WALL.get()
                );


        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(
                        YoaBlocks.BLISSWOOD_LOG.get(),
                        YoaBlocks.STRIPPED_BLISSWOOD_LOG.get()

                );

        this.tag(BlockTags.WOODEN_STAIRS)
                .add(
                        YoaBlocks.BLISSWOOD_STAIRS.get()
                );

        this.tag(BlockTags.WOODEN_FENCES)
                .add(
                        YoaBlocks.BLISSWOOD_FENCE.get()
                );
        this.tag(BlockTags.FENCE_GATES)
                .add(
                        YoaBlocks.BLISSWOOD_FENCE_GATE.get()
                );

        this.tag(BlockTags.WOODEN_SLABS)
                .add(
                        YoaBlocks.BLISSWOOD_SLAB.get()

                );

        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(
                        YoaBlocks.BLISSWOOD_BUTTON.get()

                );


        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(
                        YoaBlocks.BLISSWOOD_PRESSURE_PLATE.get()

                );


        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(
                        YoaBlocks.BLISSWOOD_TRAPDOOR.get()

                );


        this.tag(BlockTags.WOODEN_DOORS)
                .add(
                        YoaBlocks.BLISSWOOD_DOOR.get()

                );


        this.tag(BlockTags.WALL_SIGNS)
                .add(
                        YoaBlocks.BLISSWOOD_WALL_SIGN.get()

                );


        this.tag(BlockTags.SIGNS)
                .add(
                        YoaBlocks.BLISSWOOD_SIGN.get()

                );


        this.tag(BlockTags.WALL_HANGING_SIGNS)
                .add(
                        YoaBlocks.BLISSWOOD_WALL_HANGING_SIGN.get()

                );


        this.tag(BlockTags.CEILING_HANGING_SIGNS)
                .add(
                        YoaBlocks.BLISSWOOD_HANGING_SIGN.get()

                );


        this.tag(BlockTags.SAPLINGS)
                .add(
                        YoaBlocks.BLISSWOOD_SAPLING.get()

                );


        this.tag(BlockTags.LEAVES)
                .add(
                        YoaBlocks.BLISSWOOD_LEAVES.get()

                );

    }





}
