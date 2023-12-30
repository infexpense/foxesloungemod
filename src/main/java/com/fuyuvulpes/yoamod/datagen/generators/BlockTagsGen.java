package com.fuyuvulpes.yoamod.datagen.generators;

import com.fuyuvulpes.yoamod.registries.BlocksModReg;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
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
                        BlocksModReg.MELTING_POT.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(BlocksModReg.AUGMENTING_STATION.get(),
                        BlocksModReg.HAMMERING_STATION.get(),
                        BlocksModReg.MELTING_POT.get());
    }
}
