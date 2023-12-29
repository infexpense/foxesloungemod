package com.fuyuvulpes.yoamod.registries;

import com.fuyuvulpes.yoamod.core.items.BaseModWeapon;
import com.fuyuvulpes.yoamod.core.items.WeaponStats;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class ItemsModReg {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);


    public static final DeferredItem<BaseModWeapon> BASE_WEAPON = ITEMS.register(WeaponStats.PLACEHOLDER.name(), () -> new BaseModWeapon(Tiers.IRON,WeaponStats.PLACEHOLDER.attackDmg(),WeaponStats.PLACEHOLDER.attackSpeed(), WeaponStats.PLACEHOLDER.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> BASE_WEAPON2 = ITEMS.register(WeaponStats.PLACEHOLDER.name(), () -> new BaseModWeapon(Tiers.WOOD,WeaponStats.PLACEHOLDER.attackDmg(),WeaponStats.PLACEHOLDER.attackSpeed(), WeaponStats.PLACEHOLDER.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> BASE_WEAPON3 = ITEMS.register(WeaponStats.PLACEHOLDER.name(), () -> new BaseModWeapon(Tiers.WOOD,WeaponStats.PLACEHOLDER.attackDmg(),WeaponStats.PLACEHOLDER.attackSpeed(), WeaponStats.PLACEHOLDER.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> BASE_WEAPON4 = ITEMS.register(WeaponStats.PLACEHOLDER.name(), () -> new BaseModWeapon(Tiers.WOOD,WeaponStats.PLACEHOLDER.attackDmg(),WeaponStats.PLACEHOLDER.attackSpeed(), WeaponStats.PLACEHOLDER.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> BASE_WEAPON5 = ITEMS.register(WeaponStats.PLACEHOLDER.name(), () -> new BaseModWeapon(Tiers.WOOD,WeaponStats.PLACEHOLDER.attackDmg(),WeaponStats.PLACEHOLDER.attackSpeed(), WeaponStats.PLACEHOLDER.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> BASE_WEAPON6 = ITEMS.register(WeaponStats.PLACEHOLDER.name(), () -> new BaseModWeapon(Tiers.WOOD,WeaponStats.PLACEHOLDER.attackDmg(),WeaponStats.PLACEHOLDER.attackSpeed(), WeaponStats.PLACEHOLDER.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> BASE_WEAPON7 = ITEMS.register(WeaponStats.PLACEHOLDER.name(), () -> new BaseModWeapon(Tiers.WOOD,WeaponStats.PLACEHOLDER.attackDmg(),WeaponStats.PLACEHOLDER.attackSpeed(), WeaponStats.PLACEHOLDER.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> BASE_WEAPON8 = ITEMS.register(WeaponStats.PLACEHOLDER.name(), () -> new BaseModWeapon(Tiers.WOOD,WeaponStats.PLACEHOLDER.attackDmg(),WeaponStats.PLACEHOLDER.attackSpeed(), WeaponStats.PLACEHOLDER.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> BASE_WEAPON9 = ITEMS.register(WeaponStats.PLACEHOLDER.name(), () -> new BaseModWeapon(Tiers.WOOD,WeaponStats.PLACEHOLDER.attackDmg(),WeaponStats.PLACEHOLDER.attackSpeed(), WeaponStats.PLACEHOLDER.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> BASE_WEAPON10 = ITEMS.register(WeaponStats.PLACEHOLDER.name(), () -> new BaseModWeapon(Tiers.WOOD,WeaponStats.PLACEHOLDER.attackDmg(),WeaponStats.PLACEHOLDER.attackSpeed(), WeaponStats.PLACEHOLDER.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> BASE_WEAPON11 = ITEMS.register(WeaponStats.PLACEHOLDER.name(), () -> new BaseModWeapon(Tiers.WOOD,WeaponStats.PLACEHOLDER.attackDmg(),WeaponStats.PLACEHOLDER.attackSpeed(), WeaponStats.PLACEHOLDER.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> BASE_WEAPON12 = ITEMS.register(WeaponStats.PLACEHOLDER.name(), () -> new BaseModWeapon(Tiers.WOOD,WeaponStats.PLACEHOLDER.attackDmg(),WeaponStats.PLACEHOLDER.attackSpeed(), WeaponStats.PLACEHOLDER.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> BASE_WEAPON13 = ITEMS.register(WeaponStats.PLACEHOLDER.name(), () -> new BaseModWeapon(Tiers.WOOD,WeaponStats.PLACEHOLDER.attackDmg(),WeaponStats.PLACEHOLDER.attackSpeed(), WeaponStats.PLACEHOLDER.range(), new Item.Properties()));




    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEat().nutrition(1).saturationMod(2f).build()));




    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
