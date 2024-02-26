package com.fuyuvulpes.yoamod.core.registries;

import com.fuyuvulpes.yoamod.game.client.screens.CrucibleMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.LoomMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryBuilder;
import net.neoforged.neoforge.registries.RegistryManager;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class MenusModReg {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<CrucibleMenu>> CRUCIBLE_MENU = MENUS.register("crucible_menu", () -> new CrucibleMenu());



    public static void register(IEventBus eventBus){
        MENUS.register(eventBus);
    }


}
