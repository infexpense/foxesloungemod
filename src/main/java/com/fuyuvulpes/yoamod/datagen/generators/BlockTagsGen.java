package com.fuyuvulpes.yoamod.datagen.generators;

import com.fuyuvulpes.yoamod.registries.BlocksModReg;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
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
                        BlocksModReg.MELTING_POT.get(),
                        (BlocksModReg.CREAKSTONE.get()),
                        (BlocksModReg.CREAKSTONE_FRACTURE.get()),
                        (BlocksModReg.OVERGROWN_CREAKSTONE.get()),
                        (BlocksModReg.SILVER_ORE.get()),
                        (BlocksModReg.DEEPSLATE_SILVER_ORE.get()),
                        (BlocksModReg.TITANIUM_ORE.get()),
                        (BlocksModReg.DEEPSLATE_TITANIUM_ORE.get()),
                        (BlocksModReg.BISMUTH_ORE.get()),
                        (BlocksModReg.DEEPSLATE_BISMUTH_ORE.get()),
                        (BlocksModReg.WITHERITE_ORE.get()),
                        (BlocksModReg.IOLITE_ORE.get()),
                        (BlocksModReg.ALEXANDRITE_ORE.get()),
                        (BlocksModReg.ADAMANTITE_ORE.get())
                        );


        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(BlocksModReg.AUGMENTING_STATION.get(),
                        BlocksModReg.HAMMERING_STATION.get(),
                        BlocksModReg.MELTING_POT.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        (BlocksModReg.TITANIUM_ORE.get()),
                        (BlocksModReg.DEEPSLATE_TITANIUM_ORE.get()),
                        (BlocksModReg.BISMUTH_ORE.get()),
                        (BlocksModReg.DEEPSLATE_BISMUTH_ORE.get())

                );


        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(
                        (BlocksModReg.WITHERITE_ORE.get()),
                        (BlocksModReg.IOLITE_ORE.get()),
                        (BlocksModReg.CREAKSTONE.get()),
                        (BlocksModReg.CREAKSTONE_FRACTURE.get()),
                        (BlocksModReg.OVERGROWN_CREAKSTONE.get())
                );


        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(

                        (BlocksModReg.ALEXANDRITE_ORE.get()),
                        (BlocksModReg.ADAMANTITE_ORE.get())
                );

    }



}
