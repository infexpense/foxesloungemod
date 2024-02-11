package com.fuyuvulpes.yoamod.datagen.generators;

import com.fuyuvulpes.yoamod.registries.BlocksModReg;
import com.fuyuvulpes.yoamod.registries.TagRegistry;
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
                .add(BlocksModReg.AUGMENTING_STATION.get(),
                        BlocksModReg.HAMMERING_STATION.get(),
                        BlocksModReg.CRUCIBLE.get(),
                        BlocksModReg.CREAKSTONE.get(),
                        BlocksModReg.CREAKSTONE_STAIRS.get(),
                        BlocksModReg.CREAKSTONE_SLAB.get(),
                        BlocksModReg.CREAKSTONE_WALL.get(),
                        BlocksModReg.CREAKSTONE_TILES.get(),
                        BlocksModReg.CREAKSTONE_TILES_STAIRS.get(),
                        BlocksModReg.CREAKSTONE_TILES_SLAB.get(),
                        BlocksModReg.CREAKSTONE_TILES_WALL.get(),
                        BlocksModReg.CREAKSTONE_FRACTURE.get(),
                        BlocksModReg.OVERGROWN_CREAKSTONE.get(),
                        BlocksModReg.POINTED_CREAKSTONE.get(),
                        BlocksModReg.SILVER_ORE.get(),
                        BlocksModReg.DEEPSLATE_SILVER_ORE.get(),
                        BlocksModReg.TITANIUM_ORE.get(),
                        BlocksModReg.DEEPSLATE_TITANIUM_ORE.get(),
                        BlocksModReg.BISMUTH_ORE.get(),
                        BlocksModReg.DEEPSLATE_BISMUTH_ORE.get(),
                        BlocksModReg.WITHERITE_ORE.get(),
                        BlocksModReg.IOLITE_ORE.get(),

                        BlocksModReg.CREAKSTONE_IRON_ORE.get(),
                        BlocksModReg.CREAKSTONE_DIAMOND_ORE.get(),
                        BlocksModReg.CREAKSTONE_TITANIUM_ORE.get(),
                        BlocksModReg.CRYSTALIC_REMNANTS.get(),
                        BlocksModReg.ALEXANDRITE_ORE.get(),
                        BlocksModReg.ADAMANTITE_ORE.get(),

                        BlocksModReg.RUNE_CRYSTAL_CLUSTER.get(),
                        BlocksModReg.RUNE_CRYSTAL_BLOCK.get(),
                        BlocksModReg.CRYSTALIC_CREAKSTONE_TILES.get(),
                        BlocksModReg.CRYSTALIC_CREAKSTONE_TILES_STAIRS.get(),
                        BlocksModReg.CRYSTALIC_CREAKSTONE_TILES_SLAB.get(),
                        BlocksModReg.CRYSTALIC_CREAKSTONE_TILES_WALL.get(),

                        BlocksModReg.BRASS_BLOCK.get(),
                        BlocksModReg.SILVER_BLOCK.get(),
                        BlocksModReg.RAW_SILVER_BLOCK.get(),
                        BlocksModReg.BRONZE_BLOCK.get(),
                        BlocksModReg.STEEL_BLOCK.get(),
                        BlocksModReg.BISMUTH_BLOCK.get(),
                        BlocksModReg.RAW_BISMUTH_BLOCK.get(),
                        BlocksModReg.TITANIUM_BLOCK.get(),
                        BlocksModReg.RAW_TITANIUM_BLOCK.get(),
                        BlocksModReg.WITHERITE_BLOCK.get(),
                        BlocksModReg.IOLITE_BLOCK.get(),
                        BlocksModReg.ALEXANDRITE_BLOCK.get(),
                        BlocksModReg.ADAMANTITE_BLOCK.get(),
                        BlocksModReg.RAW_ADAMANTITE_BLOCK.get(),

                        BlocksModReg.HAUNTED_LAMP.get()
                        );


        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(BlocksModReg.AUGMENTING_STATION.get(),
                        BlocksModReg.HAMMERING_STATION.get(),
                        BlocksModReg.CRUCIBLE.get(),
                        BlocksModReg.RUNE_CRYSTAL_CLUSTER.get(),
                        BlocksModReg.RUNE_CRYSTAL_BLOCK.get(),
                        BlocksModReg.BRASS_BLOCK.get(),
                        BlocksModReg.SILVER_BLOCK.get(),
                        BlocksModReg.RAW_SILVER_BLOCK.get(),
                        BlocksModReg.BRONZE_BLOCK.get(),
                        BlocksModReg.HAUNTED_LAMP.get()
                );


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        BlocksModReg.STEEL_BLOCK.get(),
                        BlocksModReg.BISMUTH_ORE.get(),
                        BlocksModReg.DEEPSLATE_BISMUTH_ORE.get(),
                        BlocksModReg.BISMUTH_BLOCK.get(),
                        BlocksModReg.RAW_BISMUTH_BLOCK.get()

                );


        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(
                        BlocksModReg.DEEPSLATE_TITANIUM_ORE.get(),
                        BlocksModReg.TITANIUM_ORE.get(),
                        BlocksModReg.TITANIUM_BLOCK.get(),
                        BlocksModReg.RAW_TITANIUM_BLOCK.get(),
                        BlocksModReg.CRYSTALIC_REMNANTS.get(),
                        BlocksModReg.WITHERITE_ORE.get(),
                        BlocksModReg.WITHERITE_BLOCK.get(),
                        BlocksModReg.POINTED_CREAKSTONE.get()

                );


        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(
                        BlocksModReg.IOLITE_ORE.get(),
                        BlocksModReg.IOLITE_BLOCK.get()
                );

        this.tag(TagRegistry.Blocks.NEEDS_TITANIUM_TOOL)
                .add(

                        BlocksModReg.CREAKSTONE.get(),
                        BlocksModReg.CREAKSTONE_STAIRS.get(),
                        BlocksModReg.CREAKSTONE_SLAB.get(),
                        BlocksModReg.CREAKSTONE_WALL.get(),
                        BlocksModReg.CREAKSTONE_FRACTURE.get(),
                        BlocksModReg.OVERGROWN_CREAKSTONE.get(),
                        BlocksModReg.CREAKSTONE_IRON_ORE.get(),
                        BlocksModReg.CREAKSTONE_TITANIUM_ORE.get(),
                        BlocksModReg.CREAKSTONE_TILES.get(),
                        BlocksModReg.CREAKSTONE_TILES_STAIRS.get(),
                        BlocksModReg.CREAKSTONE_TILES_SLAB.get(),
                        BlocksModReg.CREAKSTONE_TILES_WALL.get(),
                        BlocksModReg.CRYSTALIC_CREAKSTONE_TILES.get(),
                        BlocksModReg.CRYSTALIC_CREAKSTONE_TILES_STAIRS.get(),
                        BlocksModReg.CRYSTALIC_CREAKSTONE_TILES_SLAB.get(),
                        BlocksModReg.CRYSTALIC_CREAKSTONE_TILES_WALL.get()
                );

        this.tag(TagRegistry.Blocks.NEEDS_IOLITE_TOOL)
                .add(
                        BlocksModReg.CREAKSTONE_DIAMOND_ORE.get(),
                        BlocksModReg.ALEXANDRITE_ORE.get(),
                        BlocksModReg.ALEXANDRITE_BLOCK.get()

                );

        this.tag(TagRegistry.Blocks.NEEDS_ALEXANDRITE_TOOL)
                .add(
                        BlocksModReg.ADAMANTITE_ORE.get(),
                        BlocksModReg.ADAMANTITE_BLOCK.get(),
                        BlocksModReg.RAW_ADAMANTITE_BLOCK.get()

                );

        this.tag(TagRegistry.Blocks.CREAK_ORE_REPLACEABLES)
                .add(
                        BlocksModReg.CREAKSTONE.get(),
                        BlocksModReg.OVERGROWN_CREAKSTONE.get()

                );

        this.tag(TagRegistry.Blocks.NETHER_ORE_REPLACEABLES)
                .add(
                        Blocks.NETHERRACK

                );

        this.tag(TagRegistry.Blocks.END_ORE_REPLACEABLES)
                .add(
                        Blocks.END_STONE

                );


        this.tag(BlockTags.BASE_STONE_OVERWORLD)
                .add(
                        BlocksModReg.CREAKSTONE.get()
                );


        this.tag(BlockTags.WALLS)
                .add(
                        BlocksModReg.CREAKSTONE_WALL.get(),
                        BlocksModReg.CREAKSTONE_TILES_WALL.get(),
                        BlocksModReg.CRYSTALIC_CREAKSTONE_TILES_WALL.get()
                );
    }



}
