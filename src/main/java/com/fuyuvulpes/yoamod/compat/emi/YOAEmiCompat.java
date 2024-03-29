package com.fuyuvulpes.yoamod.compat.emi;

import com.fuyuvulpes.yoamod.core.registries.YoaBlocks;
import com.fuyuvulpes.yoamod.core.registries.YoaRecipes;
import com.fuyuvulpes.yoamod.game.server.crafting.CrucibleRecipe;
import com.fuyuvulpes.yoamod.game.server.crafting.HammeringStationRecipe;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;


@EmiEntrypoint
public class YOAEmiCompat implements EmiPlugin {

    public static final YoaEmiRecipeCat HAMMERING_STATION = new YoaEmiRecipeCat("hammering_station", YoaBlocks.HAMMERING_STATION);
    public static final YoaEmiRecipeCat CRUCIBLE = new YoaEmiRecipeCat("crucible", YoaBlocks.CRUCIBLE);
    @Override
    public void register(EmiRegistry registry) {
        registry.addCategory(HAMMERING_STATION);
        registry.addCategory(CRUCIBLE);

        registry.addWorkstation(HAMMERING_STATION, EmiStack.of(YoaBlocks.HAMMERING_STATION));
        registry.addWorkstation(CRUCIBLE, EmiStack.of(YoaBlocks.CRUCIBLE));

        RecipeManager rm = registry.getRecipeManager();

        for (RecipeHolder<HammeringStationRecipe> recipe : rm.getAllRecipesFor(YoaRecipes.HAMMERING_STATION_TYPE.get())) {
            registry.addRecipe(new EmiHammeringStation<>(recipe));
        }
        for (RecipeHolder<CrucibleRecipe> recipe : rm.getAllRecipesFor(YoaRecipes.CRUCIBLE_TYPE.get())) {
            registry.addRecipe(new EmiCrucible<>(recipe));
        }
    }
}
