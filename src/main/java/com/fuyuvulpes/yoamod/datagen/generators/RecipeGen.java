package com.fuyuvulpes.yoamod.datagen.generators;

import com.fuyuvulpes.yoamod.registries.BlocksModReg;
import com.fuyuvulpes.yoamod.registries.ItemsModReg;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class RecipeGen extends RecipeProvider implements IConditionBuilder {
    public RecipeGen(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.CRYSTALIC_SHARD.get(), RecipeCategory.MISC, BlocksModReg.CRYSTALIC_REMNANTS.get());
        twoByTwoPacker(output,RecipeCategory.MISC,BlocksModReg.RUNE_CRYSTAL_BLOCK.get(),ItemsModReg.RUNE_CRYSTAL.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.ADAMANTITE_NUGGET.get(), RecipeCategory.MISC, ItemsModReg.ADAMANTITE_INGOT.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.ALEXANDRITE_SHARD.get(), RecipeCategory.MISC, ItemsModReg.ALEXANDRITE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.BISMUTH_SHARD.get(), RecipeCategory.MISC, ItemsModReg.BISMUTH.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.BRONZE_NUGGET.get(), RecipeCategory.MISC, ItemsModReg.BRONZE_INGOT.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.DIAMOND_SHARD.get(), RecipeCategory.MISC, Items.DIAMOND);
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.IOLITE_SHARD.get(), RecipeCategory.MISC, ItemsModReg.IOLITE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.NETHERITE_NUGGET.get(), RecipeCategory.MISC, Items.NETHERITE_INGOT);
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.SILVER_NUGGET.get(), RecipeCategory.MISC, ItemsModReg.SILVER_INGOT.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.STEEL_NUGGET.get(), RecipeCategory.MISC, ItemsModReg.STEEL_INGOT.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.TITANIUM_NUGGET.get(), RecipeCategory.MISC, ItemsModReg.TITANIUM_INGOT.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.WITHERITE_SHARD.get(), RecipeCategory.MISC, ItemsModReg.WITHERITE.get());





        //Put It Here Dum Dum
    }

}
