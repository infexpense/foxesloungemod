package com.fuyuvulpes.yoamod.compat.jei;

import com.fuyuvulpes.yoamod.core.registries.YoaBlocks;
import com.fuyuvulpes.yoamod.game.server.crafting.HammeringStationRecipe;
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

public class HammeringStationJEI implements IRecipeCategory<HammeringStationRecipe> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(MODID,"textures/gui/container/hammering_station.png");
    public static final RecipeType<HammeringStationRecipe> RECIPE_TYPE = RecipeType.create(MODID,"hammering_station",HammeringStationRecipe.class);

    public final IDrawable background;
    public final IDrawable icon;

    public HammeringStationJEI(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE,0,0,176,166);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK,new ItemStack(YoaBlocks.HAMMERING_STATION.get()));
    }

    @Override
    public RecipeType<HammeringStationRecipe> getRecipeType() {
        return RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.yoamod.hammering_station");
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
    public boolean isHandled(HammeringStationRecipe recipe) {
        return true;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, HammeringStationRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT,7,7).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT,27,7).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT,7,27).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT,7,27).addIngredients(recipe.getIngredients().get(3));

        builder.addSlot(RecipeIngredientRole.RENDER_ONLY,141,54).addItemStack(recipe.getResultItem(null));

        builder.addSlot(RecipeIngredientRole.OUTPUT,141,54).addItemStack(recipe.getResultItem(null));

    }
}
