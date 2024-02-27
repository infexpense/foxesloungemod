package com.fuyuvulpes.yoamod.game.server.crafting;

import com.fuyuvulpes.yoamod.core.registries.BlocksModReg;
import com.fuyuvulpes.yoamod.core.registries.RecipesModReg;
import com.fuyuvulpes.yoamod.core.registries.SerializersModReg;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class CrucibleRecipe implements Recipe<Container> {
    public final String group;
    public final Ingredient ingredientA;
    public final Ingredient ingredientB;
    public final Ingredient supportingItem;
    public final ItemStack result;
    public final float experience;
    public final int cookingTime;
    public CrucibleRecipe(String pGroup, Ingredient pIngredientA, Ingredient pIngredientB, Ingredient supportingItem, ItemStack pResult, float pExperience, int pCookingTime) {
        this.group = pGroup;
        this.ingredientA = pIngredientA;
        this.ingredientB = pIngredientB;
        this.supportingItem = supportingItem;
        this.result = pResult;
        this.experience = pExperience;
        this.cookingTime = pCookingTime;

    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return false;
    }

    @Override
    public ItemStack assemble(Container pContainer, RegistryAccess pRegistryAccess) {
        return null;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return this.result;
    }

    @Override
    public ItemStack getToastSymbol() {
        return BlocksModReg.CRUCIBLE.get().asItem().getDefaultInstance();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SerializersModReg.CRUCIBLE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipesModReg.CRUCIBLE_TYPE.get();
    }
    public interface Factory<T extends CrucibleRecipe> {
        T create(String group, Ingredient ingredient, Ingredient secondingredient, Ingredient supportitem, ItemStack result, float experience, int time);
    }
}
