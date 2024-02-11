package com.fuyuvulpes.yoamod.datagen.generators;

import com.fuyuvulpes.yoamod.game.woldgen.ModBiomes;
import com.fuyuvulpes.yoamod.registries.TagRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class BiomeTagsGen extends BiomeTagsProvider {


    public BiomeTagsGen(PackOutput p_255800_, CompletableFuture<HolderLookup.Provider> p_256205_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_255800_, p_256205_, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(Tags.Biomes.IS_SPOOKY).addTag(
                TagRegistry.Biomes.IS_THE_CREAK
        );


        this.tag(BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS).add(

        ).addTag(
                TagRegistry.Biomes.IS_THE_CREAK

                );
    }
}
