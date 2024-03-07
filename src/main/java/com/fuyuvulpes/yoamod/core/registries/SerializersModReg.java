package com.fuyuvulpes.yoamod.core.registries;

import com.fuyuvulpes.yoamod.game.server.crafting.CrucibleRecipe;
import com.fuyuvulpes.yoamod.game.server.crafting.HammeringStationRecipe;
import com.fuyuvulpes.yoamod.world.item.crafting.CrucibleSerializer;
import com.fuyuvulpes.yoamod.world.item.crafting.HammeringStationSerializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class SerializersModReg {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZER = DeferredRegister.create(Registries.RECIPE_SERIALIZER,MODID);


    public static final DeferredHolder<RecipeSerializer<?>,RecipeSerializer<CrucibleRecipe>> CRUCIBLE_SERIALIZER =
            SERIALIZER.register("crucible",() -> new CrucibleSerializer<>(CrucibleRecipe::new));
    public static final DeferredHolder<RecipeSerializer<?>,RecipeSerializer<HammeringStationRecipe>> HAMMERING_STATION_SERIALIZER =
            SERIALIZER.register("hammering_station",() -> new HammeringStationSerializer<>(HammeringStationRecipe::new));


    public static void register(IEventBus eventBus){
        SERIALIZER.register(eventBus);
    }

}
