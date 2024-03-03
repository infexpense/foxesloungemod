package com.fuyuvulpes.yoamod.data.generators;

import com.fuyuvulpes.yoamod.core.registries.ItemsModReg;
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
                        ItemsModReg.SILVER_HELMET.get(),
                        ItemsModReg.SILVER_CHESTPLATE.get(),
                        ItemsModReg.SILVER_LEGGINGS.get(),
                        ItemsModReg.SILVER_BOOTS.get(),

                        ItemsModReg.WITHERITE_HELMET.get(),
                        ItemsModReg.WITHERITE_CHESTPLATE.get(),
                        ItemsModReg.WITHERITE_LEGGINGS.get(),
                        ItemsModReg.WITHERITE_BOOTS.get(),

                        ItemsModReg.IOLITE_HELMET.get(),
                        ItemsModReg.IOLITE_CHESTPLATE.get(),
                        ItemsModReg.IOLITE_LEGGINGS.get(),
                        ItemsModReg.IOLITE_BOOTS.get(),

                        ItemsModReg.ALEXANDRITE_HELMET.get(),
                        ItemsModReg.ALEXANDRITE_CHESTPLATE.get(),
                        ItemsModReg.ALEXANDRITE_LEGGINGS.get(),
                        ItemsModReg.ALEXANDRITE_BOOTS.get(),

                        ItemsModReg.ADAMANTITE_HELMET.get(),
                        ItemsModReg.ADAMANTITE_CHESTPLATE.get(),
                        ItemsModReg.ADAMANTITE_LEGGINGS.get(),
                        ItemsModReg.ADAMANTITE_BOOTS.get());

    }
}
