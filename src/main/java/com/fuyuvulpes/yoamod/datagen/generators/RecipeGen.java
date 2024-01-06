package com.fuyuvulpes.yoamod.datagen.generators;

import com.fuyuvulpes.yoamod.registries.BlocksModReg;
import com.fuyuvulpes.yoamod.registries.ItemsModReg;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class RecipeGen extends RecipeProvider implements IConditionBuilder {
    public RecipeGen(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.CRYSTALIC_SHARD.get(), RecipeCategory.REDSTONE, BlocksModReg.CRYSTALIC_REMNANTS.get());



        //Put It Here Dum Dum
    }
}
