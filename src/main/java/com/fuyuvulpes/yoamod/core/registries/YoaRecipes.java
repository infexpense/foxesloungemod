package com.fuyuvulpes.yoamod.core.registries;

import com.fuyuvulpes.yoamod.game.server.crafting.CrucibleRecipe;
import com.fuyuvulpes.yoamod.game.server.crafting.HammeringStationRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class YoaRecipes {
    public static final DeferredRegister<RecipeType<?>> TYPE = DeferredRegister.create(Registries.RECIPE_TYPE, MODID);


    public static final DeferredHolder<RecipeType<?>, RecipeType<CrucibleRecipe>> CRUCIBLE_TYPE = TYPE.register("crucible",() -> new RecipeType<>() {
        @Override
        public String toString() {
            return "crucible";
        }
    });
    public static final DeferredHolder<RecipeType<?>, RecipeType<HammeringStationRecipe>> HAMMERING_STATION_TYPE = TYPE.register("hammering_station",() -> RecipeType.register("hammering_station"));

    public static void register(IEventBus eventBus){
        TYPE.register(eventBus);
    }

}
