package com.fuyuvulpes.yoamod.game.server.crafting;

import com.fuyuvulpes.yoamod.core.registries.YoaBlocks;
import com.fuyuvulpes.yoamod.core.registries.YoaRecipes;
import com.fuyuvulpes.yoamod.core.registries.YoaSerializers;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class HammeringStationRecipe implements Recipe<Container> {
    public final String group;
    public final Ingredient ingA;
    public final Ingredient ingB;
    public final Ingredient ingC;
    public final Ingredient ingD;
    public final ItemStack result;

    public HammeringStationRecipe(String pGroup, Ingredient pIngA, Ingredient pIngB, Ingredient pIngC, Ingredient pIngD, ItemStack pResult) {
        this.group = pGroup;
        this.ingA = pIngA;
        this.ingB = pIngB;
        this.ingC = pIngC;
        this.ingD = pIngD;
        this.result = pResult;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {

        boolean conA = this.ingA.test(pContainer.getItem(0));
        boolean conB = this.ingB == null || this.ingB.test(pContainer.getItem(1));
        boolean conC = this.ingC == null || this.ingC.test(pContainer.getItem(2));
        boolean conD = this.ingD == null || this.ingD.test(pContainer.getItem(3));
        return conA && conB && conC && conD;
    }

    @Override
    public ItemStack assemble(Container pContainer, RegistryAccess pRegistryAccess) {
        return this.result.copy();
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
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(ingA,ingB,ingC,ingD);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String getGroup() {
        return Recipe.super.getGroup();
    }

    @Override
    public ItemStack getToastSymbol() {
        return YoaBlocks.HAMMERING_STATION.get().asItem().getDefaultInstance();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return YoaSerializers.HAMMERING_STATION_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return YoaRecipes.HAMMERING_STATION_TYPE.get();
    }

    public interface Factory<T extends HammeringStationRecipe> {
        T create(String group, Ingredient ingA, Ingredient ingB, Ingredient ingC, Ingredient ingD, ItemStack result);
    }
}
