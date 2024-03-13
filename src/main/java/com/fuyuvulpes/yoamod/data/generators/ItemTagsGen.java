package com.fuyuvulpes.yoamod.data.generators;

import com.fuyuvulpes.yoamod.core.registries.YoaItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class ItemTagsGen extends ItemTagsProvider {


    public ItemTagsGen(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(
                        YoaItems.SILVER_HELMET.get(),
                        YoaItems.SILVER_CHESTPLATE.get(),
                        YoaItems.SILVER_LEGGINGS.get(),
                        YoaItems.SILVER_BOOTS.get(),

                        YoaItems.WITHERITE_HELMET.get(),
                        YoaItems.WITHERITE_CHESTPLATE.get(),
                        YoaItems.WITHERITE_LEGGINGS.get(),
                        YoaItems.WITHERITE_BOOTS.get(),

                        YoaItems.IOLITE_HELMET.get(),
                        YoaItems.IOLITE_CHESTPLATE.get(),
                        YoaItems.IOLITE_LEGGINGS.get(),
                        YoaItems.IOLITE_BOOTS.get(),

                        YoaItems.ALEXANDRITE_HELMET.get(),
                        YoaItems.ALEXANDRITE_CHESTPLATE.get(),
                        YoaItems.ALEXANDRITE_LEGGINGS.get(),
                        YoaItems.ALEXANDRITE_BOOTS.get(),

                        YoaItems.ADAMANTITE_HELMET.get(),
                        YoaItems.ADAMANTITE_CHESTPLATE.get(),
                        YoaItems.ADAMANTITE_LEGGINGS.get(),
                        YoaItems.ADAMANTITE_BOOTS.get());

    }
}
