package com.fuyuvulpes.yoamod.compat.jei;

import com.fuyuvulpes.yoamod.core.registries.YoaBlocks;
import com.fuyuvulpes.yoamod.game.server.crafting.CrucibleRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class CrucibleJEI implements IRecipeCategory<CrucibleRecipe> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(MODID,"textures/gui/container/crucible.png");
    public static final RecipeType<CrucibleRecipe> RECIPE_TYPE = RecipeType.create(MODID,"crucible", CrucibleRecipe.class);

    public final IDrawable background;
    public final IDrawable icon;

    public CrucibleJEI(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE,0,0,176,166);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK,new ItemStack(YoaBlocks.CRUCIBLE.get()));

    }

    @Override
    public RecipeType<CrucibleRecipe> getRecipeType() {
        return RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.yoamod.crucible");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public boolean isHandled(CrucibleRecipe recipe) {
        return true;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CrucibleRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT,22,18).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT,40,18).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT,31,40).addIngredients(recipe.getIngredients().get(2));

        builder.addSlot(RecipeIngredientRole.OUTPUT,127,18).addItemStack(recipe.getResultItem(null));

    }
}
