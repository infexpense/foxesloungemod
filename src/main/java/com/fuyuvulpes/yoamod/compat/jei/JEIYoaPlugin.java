package com.fuyuvulpes.yoamod.compat.jei;


import com.fuyuvulpes.yoamod.core.registries.YoaBlocks;
import com.fuyuvulpes.yoamod.game.client.screens.CrucibleScreen;
import com.fuyuvulpes.yoamod.game.client.screens.HammeringStationScreen;
import com.fuyuvulpes.yoamod.game.server.crafting.CrucibleRecipe;
import com.fuyuvulpes.yoamod.game.server.crafting.HammeringStationRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

@JeiPlugin
public class JEIYoaPlugin implements IModPlugin {


    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(MODID,"jei");
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(YoaBlocks.CRUCIBLE.get()), CrucibleJEI.RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(YoaBlocks.HAMMERING_STATION.get()), HammeringStationJEI.RECIPE_TYPE);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {

        registration.addRecipeCategories(new HammeringStationJEI(registration.getJeiHelpers().getGuiHelper()),
                new CrucibleJEI(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {

        RecipeManager manager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<RecipeHolder<HammeringStationRecipe>> hammeringStationRecipes = new ArrayList<>(manager.getAllRecipesFor(HammeringStationRecipe.Type.INSTANCE));
        List<RecipeHolder<CrucibleRecipe>> crucibleRecipes = new ArrayList<>(manager.getAllRecipesFor(CrucibleRecipe.Type.INSTANCE));

        registration.addRecipes(HammeringStationJEI.RECIPE_TYPE, hammeringStationRecipes.stream().map(RecipeHolder::value).toList());
        registration.addRecipes(CrucibleJEI.RECIPE_TYPE, crucibleRecipes.stream().map(RecipeHolder::value).toList());

    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(HammeringStationScreen.class, 13, 46, 25, 25,
                HammeringStationJEI.RECIPE_TYPE);
        registration.addRecipeClickArea(CrucibleScreen.class, 61, 23, 64, 9,
                CrucibleJEI.RECIPE_TYPE);
    }

    @Override
    public void registerModInfo(IModInfoRegistration registration) {
        registration.addModAliases(MODID, "yoa");
    }
}
