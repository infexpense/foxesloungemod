package com.fuyuvulpes.yoamod.registries;

import com.fuyuvulpes.yoamod.game.server.crafting.CrucibleRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class RecipesModReg {
    public static final DeferredRegister<RecipeType<?>> TYPE = DeferredRegister.create(Registries.RECIPE_TYPE, MODID);

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZER = DeferredRegister.create(Registries.RECIPE_SERIALIZER, MODID);



    public static final DeferredHolder<RecipeType<?>, RecipeType<CrucibleRecipe>> CRUCIBLE_TYPE = TYPE.register("crucible_type",() -> RecipeType.register("crucible"));
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> CRUCIBLE_SERIALIZER = SERIALIZER.register("crucible_serial", () -> RecipeSerializer.register("crucible", new SimpleCookingSerializer<>(CrucibleRecipe::new, 200)));

    public static void register(IEventBus eventBus){
        TYPE.register(eventBus);
        SERIALIZER.register(eventBus);
    }

}
