package com.fuyuvulpes.yoamod.registries;

import com.fuyuvulpes.yoamod.core.ModToolTiers;
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


    public static final DeferredItem<BaseModWeapon> BRONZE_BELL = ITEMS.register("bronze_" + WeaponStats.BELL.name(), () -> new BaseModWeapon(ModToolTiers.BRONZE,WeaponStats.BELL.attackDmg(),WeaponStats.BELL.attackSpeed(), WeaponStats.BELL.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> GOLD_BELL = ITEMS.register("gold_" + WeaponStats.BELL.name(), () -> new BaseModWeapon(Tiers.GOLD,WeaponStats.BELL.attackDmg(),WeaponStats.BELL.attackSpeed(), WeaponStats.BELL.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> SILVER_BELL = ITEMS.register("silver_" + WeaponStats.BELL.name(), () -> new BaseModWeapon(ModToolTiers.SILVER,WeaponStats.BELL.attackDmg(),WeaponStats.BELL.attackSpeed(), WeaponStats.BELL.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> IRON_BELL = ITEMS.register("iron_" + WeaponStats.BELL.name(), () -> new BaseModWeapon(Tiers.IRON,WeaponStats.BELL.attackDmg(),WeaponStats.BELL.attackSpeed(), WeaponStats.BELL.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> STEEL_BELL = ITEMS.register("steel_" + WeaponStats.BELL.name(), () -> new BaseModWeapon(ModToolTiers.STEEL,WeaponStats.BELL.attackDmg(),WeaponStats.BELL.attackSpeed(), WeaponStats.BELL.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> BISMUTH_BELL = ITEMS.register("bismuth_" + WeaponStats.BELL.name(), () -> new BaseModWeapon(ModToolTiers.BISMUTH,WeaponStats.BELL.attackDmg(),WeaponStats.BELL.attackSpeed(), WeaponStats.BELL.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> DIAMOND_BELL = ITEMS.register("diamond_" + WeaponStats.BELL.name(), () -> new BaseModWeapon(Tiers.DIAMOND,WeaponStats.BELL.attackDmg(),WeaponStats.BELL.attackSpeed(), WeaponStats.BELL.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> NETHERITE_BELL = ITEMS.register("netherite_" + WeaponStats.BELL.name(), () -> new BaseModWeapon(Tiers.NETHERITE,WeaponStats.BELL.attackDmg(),WeaponStats.BELL.attackSpeed(), WeaponStats.BELL.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> TITANIUM_BELL = ITEMS.register("titanium_" + WeaponStats.BELL.name(), () -> new BaseModWeapon(ModToolTiers.TITANIUM,WeaponStats.BELL.attackDmg(),WeaponStats.BELL.attackSpeed(), WeaponStats.BELL.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> IOLITE_BELL = ITEMS.register("iolite_" + WeaponStats.BELL.name(), () -> new BaseModWeapon(ModToolTiers.IOLITE,WeaponStats.BELL.attackDmg(),WeaponStats.BELL.attackSpeed(), WeaponStats.BELL.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> ALEXANDRITE_BELL = ITEMS.register("alexandrite_" + WeaponStats.BELL.name(), () -> new BaseModWeapon(ModToolTiers.ALEXANDRITE,WeaponStats.BELL.attackDmg(),WeaponStats.BELL.attackSpeed(), WeaponStats.BELL.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> ADAMANTITE_BELL = ITEMS.register("adamantite_" + WeaponStats.BELL.name(), () -> new BaseModWeapon(ModToolTiers.ADAMANTITE,WeaponStats.BELL.attackDmg(),WeaponStats.BELL.attackSpeed(), WeaponStats.BELL.range(), new Item.Properties()));




    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEat().nutrition(1).saturationMod(2f).build()));




    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
