package com.fuyuvulpes.yoamod.game.server.crafting;

import com.fuyuvulpes.yoamod.core.registries.BlocksModReg;
import com.fuyuvulpes.yoamod.core.registries.RecipesModReg;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

public class CrucibleRecipe extends AbstractCookingRecipe {
    public CrucibleRecipe(String pGroup, CookingBookCategory pCategory, Ingredient pIngredient, ItemStack pResult, float pExperience, int pCookingTime) {
        super(RecipesModReg.CRUCIBLE_TYPE.get(), pGroup, pCategory, pIngredient, pResult, pExperience, pCookingTime);
    }

    @Override
    public ItemStack getToastSymbol() {
        return BlocksModReg.CRUCIBLE.get().asItem().getDefaultInstance();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipesModReg.CRUCIBLE_SERIALIZER.get();
    }
}
