package com.fuyuvulpes.yoamod.compat.emi;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public abstract class YoaEmiRecipes<T extends Recipe<?>> implements EmiRecipe {
    //Most of this is copied from Twilight Forest mod to make it easier on me

    private final EmiRecipeCategory category;
    private final RecipeHolder<T> recipe;
    private final ResourceLocation id;
    private final int width;
    private final int height;


    public YoaEmiRecipes(YoaEmiRecipeCat category, RecipeHolder<T> recipe, int width, int height) {
        this.category = category;
        this.recipe = recipe;
        this.width = width;
        this.height = height;

        ResourceLocation recipeId = recipe.id();
        String path = String.format("emi/%s/%s/%s", category.name, recipeId.getNamespace(), recipeId.getPath());
        this.id = new ResourceLocation(MODID,path);

    }

    @Override
    public EmiRecipeCategory getCategory() {
        return this.category;
    }

    @Override
    public @Nullable ResourceLocation getId() {
        return this.id;
    }

    @Override
    public int getDisplayWidth() {
        return this.width;
    }

    @Override
    public int getDisplayHeight() {
        return this.height;
    }

}
