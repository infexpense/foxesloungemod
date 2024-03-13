package com.fuyuvulpes.yoamod.core.registries;

import com.fuyuvulpes.yoamod.game.client.screens.CrucibleMenu;
import com.fuyuvulpes.yoamod.game.client.screens.HammeringStationMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class YoaMenus {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(BuiltInRegistries.MENU, MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<CrucibleMenu>> CRUCIBLE_MENU = registerMenu("crucible_menu", CrucibleMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<HammeringStationMenu>> HAMMERING_STATION_MENU = registerMenu("hammering_station_menu", HammeringStationMenu::new);



    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenu(String pKey, MenuType.MenuSupplier<T> pFactory) {
        return MENUS.register(pKey,()  -> new MenuType<>(pFactory, FeatureFlags.VANILLA_SET));
    }

    private static <T extends AbstractContainerMenu>DeferredHolder<MenuType<?>, MenuType<T>> registerMenu(String pKey, MenuType.MenuSupplier<T> pFactory, FeatureFlag... pRequiredFeatures) {
        return MENUS.register(pKey,()  ->  new MenuType<>(pFactory, FeatureFlags.REGISTRY.subset(pRequiredFeatures)));
    }

    public static void register(IEventBus eventBus){
        MENUS.register(eventBus);
    }


}
