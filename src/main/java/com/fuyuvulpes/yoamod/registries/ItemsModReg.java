package com.fuyuvulpes.yoamod.registries;

import com.fuyuvulpes.yoamod.core.ModToolTiers;
import com.fuyuvulpes.yoamod.core.items.ModArmorMats;
import com.fuyuvulpes.yoamod.core.items.WeaponItem;
import com.fuyuvulpes.yoamod.core.items.WeaponStats;
import com.fuyuvulpes.yoamod.custom.item.ModSmithingTemplateItem;
import com.fuyuvulpes.yoamod.custom.item.weaponry.LongBow;
import com.fuyuvulpes.yoamod.custom.item.weaponry.RapierItem;
import com.fuyuvulpes.yoamod.custom.item.weaponry.WarFanItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class ItemsModReg {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);


    public static final DeferredItem<Item> CRYSTALIC_SHARD = ITEMS.registerSimpleItem("crystalic_shard", new Item.Properties());
    public static final DeferredItem<Item> RUNE_CRYSTAL = ITEMS.registerSimpleItem("rune_crystal", new Item.Properties());



    public static final DeferredItem<Item> ADAMANTITE_INGOT = ITEMS.registerSimpleItem("adamantite_ingot", new Item.Properties());
    public static final DeferredItem<Item> ADAMANTITE_NUGGET = ITEMS.registerSimpleItem("adamantite_nugget", new Item.Properties());
    public static final DeferredItem<Item> RAW_ADAMANTITE = ITEMS.registerSimpleItem("raw_adamantite", new Item.Properties());
    public static final DeferredItem<Item> ADAMANTITE_TEMPLATE = ITEMS.register("adamantite_upgrade_smithing_template", ModSmithingTemplateItem::createAdamantiteUpgradeTemplate);


    public static final DeferredItem<Item> ALEXANDRITE = ITEMS.registerSimpleItem("alexandrite", new Item.Properties());
    public static final DeferredItem<Item> ALEXANDRITE_SHARD = ITEMS.registerSimpleItem("alexandrite_shard", new Item.Properties());
    public static final DeferredItem<Item> MOLTEN_ALEXANDRITE = ITEMS.registerSimpleItem("molten_alexandrite", new Item.Properties());


    public static final DeferredItem<Item> BISMUTH = ITEMS.registerSimpleItem("bismuth", new Item.Properties());
    public static final DeferredItem<Item> BISMUTH_SHARD = ITEMS.registerSimpleItem("bismuth_shard", new Item.Properties());
    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.registerSimpleItem("raw_bismuth", new Item.Properties());
    public static final DeferredItem<Item> MOLTEN_BISMUTH = ITEMS.registerSimpleItem("molten_bismuth", new Item.Properties());


    public static final DeferredItem<Item> BRASS_INGOT = ITEMS.registerSimpleItem("brass_ingot", new Item.Properties());
    public static final DeferredItem<Item> BRASS_NUGGET = ITEMS.registerSimpleItem("brass_nugget", new Item.Properties());


    public static final DeferredItem<Item> BRONZE_INGOT = ITEMS.registerSimpleItem("bronze_ingot", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_NUGGET = ITEMS.registerSimpleItem("bronze_nugget", new Item.Properties());
    public static final DeferredItem<Item> MOLTEN_BRONZE = ITEMS.registerSimpleItem("molten_bronze", new Item.Properties());


    public static final DeferredItem<Item> IOLITE = ITEMS.registerSimpleItem("iolite", new Item.Properties());
    public static final DeferredItem<Item> IOLITE_SHARD = ITEMS.registerSimpleItem("iolite_shard", new Item.Properties());
    public static final DeferredItem<Item> MOLTEN_IOLITE = ITEMS.registerSimpleItem("molten_iolite", new Item.Properties());


    public static final DeferredItem<Item> SILVER_INGOT = ITEMS.registerSimpleItem("silver_ingot", new Item.Properties());
    public static final DeferredItem<Item> SILVER_NUGGET = ITEMS.registerSimpleItem("silver_nugget", new Item.Properties());
    public static final DeferredItem<Item> RAW_SILVER = ITEMS.registerSimpleItem("raw_silver", new Item.Properties());
    public static final DeferredItem<Item> MOLTEN_SILVER = ITEMS.registerSimpleItem("molten_silver", new Item.Properties());


    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.registerSimpleItem("steel_ingot", new Item.Properties());
    public static final DeferredItem<Item> STEEL_NUGGET = ITEMS.registerSimpleItem("steel_nugget", new Item.Properties());
    public static final DeferredItem<Item> MOLTEN_STEEL = ITEMS.registerSimpleItem("molten_steel", new Item.Properties());


    public static final DeferredItem<Item> TITANIUM_INGOT = ITEMS.registerSimpleItem("titanium_ingot", new Item.Properties());
    public static final DeferredItem<Item> TITANIUM_NUGGET = ITEMS.registerSimpleItem("titanium_nugget", new Item.Properties());
    public static final DeferredItem<Item> RAW_TITANIUM = ITEMS.registerSimpleItem("raw_titanium", new Item.Properties());
    public static final DeferredItem<Item> MOLTEN_TITANIUM = ITEMS.registerSimpleItem("molten_titanium", new Item.Properties());


    public static final DeferredItem<Item> WITHERITE = ITEMS.registerSimpleItem("witherite", new Item.Properties());
    public static final DeferredItem<Item> WITHERITE_SHARD = ITEMS.registerSimpleItem("witherite_shard", new Item.Properties());

    public static final DeferredItem<Item> MOLTEN_IRON = ITEMS.registerSimpleItem("molten_iron", new Item.Properties());

    public static final DeferredItem<Item> MOLTEN_GOLD = ITEMS.registerSimpleItem("molten_gold", new Item.Properties());

    public static final DeferredItem<Item> DIAMOND_SHARD = ITEMS.registerSimpleItem("diamond_shard", new Item.Properties());
    public static final DeferredItem<Item> MOLTEN_DIAMOND = ITEMS.registerSimpleItem("molten_diamond", new Item.Properties());
    public static final DeferredItem<Item> NETHERITE_NUGGET = ITEMS.registerSimpleItem("netherite_nugget", new Item.Properties().fireResistant());

    public static final DeferredItem<PickaxeItem> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe", () -> new PickaxeItem(ModToolTiers.TITANIUM,1, -2.8F, new Item.Properties()));
    public static final DeferredItem<AxeItem> TITANIUM_AXE = ITEMS.register("titanium_axe", () -> new AxeItem(ModToolTiers.TITANIUM,5.0F, -3.0F, new Item.Properties()));
    public static final DeferredItem<HoeItem> TITANIUM_HOE = ITEMS.register("titanium_hoe", () -> new HoeItem(ModToolTiers.TITANIUM,-3, 0.0F, new Item.Properties()));
    public static final DeferredItem<ShovelItem> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel", () -> new ShovelItem(ModToolTiers.TITANIUM,1.5F, -3.0F, new Item.Properties()));


    public static final DeferredItem<PickaxeItem> IOLITE_PICKAXE = ITEMS.register("iolite_pickaxe", () -> new PickaxeItem(ModToolTiers.IOLITE,1, -2.8F, new Item.Properties()));
    public static final DeferredItem<AxeItem> IOLITE_AXE = ITEMS.register("iolite_axe", () -> new AxeItem(ModToolTiers.IOLITE,5.0F, -3.0F, new Item.Properties()));
    public static final DeferredItem<HoeItem> IOLITE_HOE = ITEMS.register("iolite_hoe", () -> new HoeItem(ModToolTiers.IOLITE,-3, 0.0F, new Item.Properties()));
    public static final DeferredItem<ShovelItem> IOLITE_SHOVEL = ITEMS.register("iolite_shovel", () -> new ShovelItem(ModToolTiers.IOLITE,1.5F, -3.0F, new Item.Properties()));


    public static final DeferredItem<PickaxeItem> ALEXANDRITE_PICKAXE = ITEMS.register("alexandrite_pickaxe", () -> new PickaxeItem(ModToolTiers.ALEXANDRITE,1, -2.8F, new Item.Properties()));
    public static final DeferredItem<AxeItem> ALEXANDRITE_AXE = ITEMS.register("alexandrite_axe", () -> new AxeItem(ModToolTiers.ALEXANDRITE,5.0F, -3.0F, new Item.Properties()));
    public static final DeferredItem<HoeItem> ALEXANDRITE_HOE = ITEMS.register("alexandrite_hoe", () -> new HoeItem(ModToolTiers.ALEXANDRITE,-3, 0.0F, new Item.Properties()));
    public static final DeferredItem<ShovelItem> ALEXANDRITE_SHOVEL = ITEMS.register("alexandrite_shovel", () -> new ShovelItem(ModToolTiers.ALEXANDRITE,1.5F, -3.0F, new Item.Properties()));


    public static final DeferredItem<PickaxeItem> ADAMANTITE_PICKAXE = ITEMS.register("adamantite_pickaxe", () -> new PickaxeItem(ModToolTiers.ADAMANTITE,1, -2.8F, new Item.Properties()));
    public static final DeferredItem<AxeItem> ADAMANTITE_AXE = ITEMS.register("adamantite_axe", () -> new AxeItem(ModToolTiers.ADAMANTITE,5.0F, -3.0F, new Item.Properties()));
    public static final DeferredItem<HoeItem> ADAMANTITE_HOE = ITEMS.register("adamantite_hoe", () -> new HoeItem(ModToolTiers.ADAMANTITE,-3, 0.0F, new Item.Properties()));
    public static final DeferredItem<ShovelItem> ADAMANTITE_SHOVEL = ITEMS.register("adamantite_shovel", () -> new ShovelItem(ModToolTiers.ADAMANTITE,1.5F, -3.0F, new Item.Properties()));

    public static final DeferredItem<ArmorItem> ADAMANTITE_HELMET = ITEMS.register("adamantite_helmet", () -> new ArmorItem(ModArmorMats.ADAMANTITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<ArmorItem> ADAMANTITE_CHESTPLATE = ITEMS.register("adamantite_chestplate", () -> new ArmorItem(ModArmorMats.ADAMANTITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<ArmorItem> ADAMANTITE_LEGGINGS = ITEMS.register("adamantite_leggings", () -> new ArmorItem(ModArmorMats.ADAMANTITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<ArmorItem> ADAMANTITE_BOOTS = ITEMS.register("adamantite_boots", () -> new ArmorItem(ModArmorMats.ADAMANTITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<ArmorItem> ALEXANDRITE_HELMET = ITEMS.register("alexandrite_helmet", () -> new ArmorItem(ModArmorMats.ALEXANDRITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<ArmorItem> ALEXANDRITE_CHESTPLATE = ITEMS.register("alexandrite_chestplate", () -> new ArmorItem(ModArmorMats.ALEXANDRITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<ArmorItem> ALEXANDRITE_LEGGINGS = ITEMS.register("alexandrite_leggings", () -> new ArmorItem(ModArmorMats.ALEXANDRITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<ArmorItem> ALEXANDRITE_BOOTS = ITEMS.register("alexandrite_boots", () -> new ArmorItem(ModArmorMats.ALEXANDRITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<ArmorItem> IOLITE_HELMET = ITEMS.register("iolite_helmet", () -> new ArmorItem(ModArmorMats.IOLITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<ArmorItem> IOLITE_CHESTPLATE = ITEMS.register("iolite_chestplate", () -> new ArmorItem(ModArmorMats.IOLITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<ArmorItem> IOLITE_LEGGINGS = ITEMS.register("iolite_leggings", () -> new ArmorItem(ModArmorMats.IOLITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<ArmorItem> IOLITE_BOOTS = ITEMS.register("iolite_boots", () -> new ArmorItem(ModArmorMats.IOLITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<ArmorItem> SILVER_HELMET = ITEMS.register("silver_helmet", () -> new ArmorItem(ModArmorMats.SILVER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<ArmorItem> SILVER_CHESTPLATE = ITEMS.register("silver_chestplate", () -> new ArmorItem(ModArmorMats.SILVER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<ArmorItem> SILVER_LEGGINGS = ITEMS.register("silver_leggings", () -> new ArmorItem(ModArmorMats.SILVER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<ArmorItem> SILVER_BOOTS = ITEMS.register("silver_boots", () -> new ArmorItem(ModArmorMats.SILVER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<ArmorItem> WITHERITE_HELMET = ITEMS.register("witherite_helmet", () -> new ArmorItem(ModArmorMats.WITHERITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<ArmorItem> WITHERITE_CHESTPLATE = ITEMS.register("witherite_chestplate", () -> new ArmorItem(ModArmorMats.WITHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<ArmorItem> WITHERITE_LEGGINGS = ITEMS.register("witherite_leggings", () -> new ArmorItem(ModArmorMats.WITHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<ArmorItem> WITHERITE_BOOTS = ITEMS.register("witherite_boots", () -> new ArmorItem(ModArmorMats.WITHERITE, ArmorItem.Type.BOOTS, new Item.Properties()));







    //WEAPONS


    //BELL
    public static final DeferredItem<WeaponItem> BRONZE_BELL = ITEMS.register("bronze_" + WeaponStats.BELL.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.BELL, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_BELL = ITEMS.register("gold_" + WeaponStats.BELL.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.BELL, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_BELL = ITEMS.register("silver_" + WeaponStats.BELL.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.BELL, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_BELL = ITEMS.register("iron_" + WeaponStats.BELL.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.BELL, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_BELL = ITEMS.register("steel_" + WeaponStats.BELL.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.BELL, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_BELL = ITEMS.register("bismuth_" + WeaponStats.BELL.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.BELL, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_BELL = ITEMS.register("diamond_" + WeaponStats.BELL.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.BELL, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_BELL = ITEMS.register("netherite_" + WeaponStats.BELL.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.BELL, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_BELL = ITEMS.register("titanium_" + WeaponStats.BELL.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.BELL, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_BELL = ITEMS.register("iolite_" + WeaponStats.BELL.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.BELL, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_BELL = ITEMS.register("alexandrite_" + WeaponStats.BELL.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.BELL, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_BELL = ITEMS.register("adamantite_" + WeaponStats.BELL.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.BELL, new Item.Properties()));


    //BLOW_DART
    public static final DeferredItem<WeaponItem> BRONZE_BLOW_DART = ITEMS.register("bronze_" + WeaponStats.BLOW_DART.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.BLOW_DART, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_BLOW_DART = ITEMS.register("gold_" + WeaponStats.BLOW_DART.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.BLOW_DART, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_BLOW_DART = ITEMS.register("silver_" + WeaponStats.BLOW_DART.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.BLOW_DART, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_BLOW_DART = ITEMS.register("iron_" + WeaponStats.BLOW_DART.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.BLOW_DART, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_BLOW_DART = ITEMS.register("steel_" + WeaponStats.BLOW_DART.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.BLOW_DART, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_BLOW_DART = ITEMS.register("bismuth_" + WeaponStats.BLOW_DART.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.BLOW_DART, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_BLOW_DART = ITEMS.register("diamond_" + WeaponStats.BLOW_DART.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.BLOW_DART, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_BLOW_DART = ITEMS.register("netherite_" + WeaponStats.BLOW_DART.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.BLOW_DART, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_BLOW_DART = ITEMS.register("titanium_" + WeaponStats.BLOW_DART.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.BLOW_DART, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_BLOW_DART = ITEMS.register("iolite_" + WeaponStats.BLOW_DART.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.BLOW_DART, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_BLOW_DART = ITEMS.register("alexandrite_" + WeaponStats.BLOW_DART.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.BLOW_DART, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_BLOW_DART = ITEMS.register("adamantite_" + WeaponStats.BLOW_DART.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.BLOW_DART, new Item.Properties()));


    //BOOMERANG
    public static final DeferredItem<WeaponItem> BRONZE_BOOMERANG = ITEMS.register("bronze_" + WeaponStats.BOOMERANG.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.BOOMERANG, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_BOOMERANG = ITEMS.register("gold_" + WeaponStats.BOOMERANG.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.BOOMERANG, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_BOOMERANG = ITEMS.register("silver_" + WeaponStats.BOOMERANG.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.BOOMERANG, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_BOOMERANG = ITEMS.register("iron_" + WeaponStats.BOOMERANG.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.BOOMERANG, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_BOOMERANG = ITEMS.register("steel_" + WeaponStats.BOOMERANG.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.BOOMERANG, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_BOOMERANG = ITEMS.register("bismuth_" + WeaponStats.BOOMERANG.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.BOOMERANG, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_BOOMERANG = ITEMS.register("diamond_" + WeaponStats.BOOMERANG.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.BOOMERANG, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_BOOMERANG = ITEMS.register("netherite_" + WeaponStats.BOOMERANG.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.BOOMERANG, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_BOOMERANG = ITEMS.register("titanium_" + WeaponStats.BOOMERANG.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.BOOMERANG, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_BOOMERANG = ITEMS.register("iolite_" + WeaponStats.BOOMERANG.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.BOOMERANG, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_BOOMERANG = ITEMS.register("alexandrite_" + WeaponStats.BOOMERANG.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.BOOMERANG, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_BOOMERANG = ITEMS.register("adamantite_" + WeaponStats.BOOMERANG.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.BOOMERANG, new Item.Properties()));


    //CHAKRAM
    public static final DeferredItem<WeaponItem> BRONZE_CHAKRAM = ITEMS.register("bronze_" + WeaponStats.CHAKRAM.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.CHAKRAM, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_CHAKRAM = ITEMS.register("gold_" + WeaponStats.CHAKRAM.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.CHAKRAM, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_CHAKRAM = ITEMS.register("silver_" + WeaponStats.CHAKRAM.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.CHAKRAM, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_CHAKRAM = ITEMS.register("iron_" + WeaponStats.CHAKRAM.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.CHAKRAM, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_CHAKRAM = ITEMS.register("steel_" + WeaponStats.CHAKRAM.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.CHAKRAM, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_CHAKRAM = ITEMS.register("bismuth_" + WeaponStats.CHAKRAM.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.CHAKRAM, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_CHAKRAM = ITEMS.register("diamond_" + WeaponStats.CHAKRAM.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.CHAKRAM, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_CHAKRAM = ITEMS.register("netherite_" + WeaponStats.CHAKRAM.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.CHAKRAM, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_CHAKRAM = ITEMS.register("titanium_" + WeaponStats.CHAKRAM.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.CHAKRAM, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_CHAKRAM = ITEMS.register("iolite_" + WeaponStats.CHAKRAM.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.CHAKRAM, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_CHAKRAM = ITEMS.register("alexandrite_" + WeaponStats.CHAKRAM.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.CHAKRAM, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_CHAKRAM = ITEMS.register("adamantite_" + WeaponStats.CHAKRAM.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.CHAKRAM, new Item.Properties()));


    //CLAWS
    public static final DeferredItem<WeaponItem> BRONZE_CLAWS = ITEMS.register("bronze_" + WeaponStats.CLAWS.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.CLAWS, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_CLAWS = ITEMS.register("gold_" + WeaponStats.CLAWS.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.CLAWS, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_CLAWS = ITEMS.register("silver_" + WeaponStats.CLAWS.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.CLAWS, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_CLAWS = ITEMS.register("iron_" + WeaponStats.CLAWS.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.CLAWS, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_CLAWS = ITEMS.register("steel_" + WeaponStats.CLAWS.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.CLAWS, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_CLAWS = ITEMS.register("bismuth_" + WeaponStats.CLAWS.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.CLAWS, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_CLAWS = ITEMS.register("diamond_" + WeaponStats.CLAWS.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.CLAWS, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_CLAWS = ITEMS.register("netherite_" + WeaponStats.CLAWS.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.CLAWS, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_CLAWS = ITEMS.register("titanium_" + WeaponStats.CLAWS.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.CLAWS, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_CLAWS = ITEMS.register("iolite_" + WeaponStats.CLAWS.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.CLAWS, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_CLAWS = ITEMS.register("alexandrite_" + WeaponStats.CLAWS.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.CLAWS, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_CLAWS = ITEMS.register("adamantite_" + WeaponStats.CLAWS.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.CLAWS, new Item.Properties()));


    //CLAYMORE
    public static final DeferredItem<WeaponItem> BRONZE_CLAYMORE = ITEMS.register("bronze_" + WeaponStats.CLAYMORE.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.CLAYMORE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_CLAYMORE = ITEMS.register("gold_" + WeaponStats.CLAYMORE.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.CLAYMORE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_CLAYMORE = ITEMS.register("silver_" + WeaponStats.CLAYMORE.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.CLAYMORE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_CLAYMORE = ITEMS.register("iron_" + WeaponStats.CLAYMORE.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.CLAYMORE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_CLAYMORE = ITEMS.register("steel_" + WeaponStats.CLAYMORE.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.CLAYMORE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_CLAYMORE = ITEMS.register("bismuth_" + WeaponStats.CLAYMORE.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.CLAYMORE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_CLAYMORE = ITEMS.register("diamond_" + WeaponStats.CLAYMORE.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.CLAYMORE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_CLAYMORE = ITEMS.register("netherite_" + WeaponStats.CLAYMORE.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.CLAYMORE, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_CLAYMORE = ITEMS.register("titanium_" + WeaponStats.CLAYMORE.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.CLAYMORE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_CLAYMORE = ITEMS.register("iolite_" + WeaponStats.CLAYMORE.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.CLAYMORE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_CLAYMORE = ITEMS.register("alexandrite_" + WeaponStats.CLAYMORE.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.CLAYMORE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_CLAYMORE = ITEMS.register("adamantite_" + WeaponStats.CLAYMORE.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.CLAYMORE, new Item.Properties()));


    //DAGGER
    public static final DeferredItem<WeaponItem> BRONZE_DAGGER = ITEMS.register("bronze_" + WeaponStats.DAGGER.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.DAGGER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_DAGGER = ITEMS.register("gold_" + WeaponStats.DAGGER.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.DAGGER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_DAGGER = ITEMS.register("silver_" + WeaponStats.DAGGER.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.DAGGER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_DAGGER = ITEMS.register("iron_" + WeaponStats.DAGGER.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.DAGGER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_DAGGER = ITEMS.register("steel_" + WeaponStats.DAGGER.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.DAGGER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_DAGGER = ITEMS.register("bismuth_" + WeaponStats.DAGGER.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.DAGGER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_DAGGER = ITEMS.register("diamond_" + WeaponStats.DAGGER.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.DAGGER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_DAGGER = ITEMS.register("netherite_" + WeaponStats.DAGGER.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.DAGGER, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_DAGGER = ITEMS.register("titanium_" + WeaponStats.DAGGER.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.DAGGER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_DAGGER = ITEMS.register("iolite_" + WeaponStats.DAGGER.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.DAGGER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_DAGGER = ITEMS.register("alexandrite_" + WeaponStats.DAGGER.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.DAGGER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_DAGGER = ITEMS.register("adamantite_" + WeaponStats.DAGGER.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.DAGGER, new Item.Properties()));


    //GREAT_AXE
    public static final DeferredItem<WeaponItem> BRONZE_GREAT_AXE = ITEMS.register("bronze_" + WeaponStats.GREAT_AXE.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.GREAT_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_GREAT_AXE = ITEMS.register("gold_" + WeaponStats.GREAT_AXE.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.GREAT_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_GREAT_AXE = ITEMS.register("silver_" + WeaponStats.GREAT_AXE.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.GREAT_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_GREAT_AXE = ITEMS.register("iron_" + WeaponStats.GREAT_AXE.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.GREAT_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_GREAT_AXE = ITEMS.register("steel_" + WeaponStats.GREAT_AXE.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.GREAT_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_GREAT_AXE = ITEMS.register("bismuth_" + WeaponStats.GREAT_AXE.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.GREAT_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_GREAT_AXE = ITEMS.register("diamond_" + WeaponStats.GREAT_AXE.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.GREAT_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_GREAT_AXE = ITEMS.register("netherite_" + WeaponStats.GREAT_AXE.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.GREAT_AXE, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_GREAT_AXE = ITEMS.register("titanium_" + WeaponStats.GREAT_AXE.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.GREAT_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_GREAT_AXE = ITEMS.register("iolite_" + WeaponStats.GREAT_AXE.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.GREAT_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_GREAT_AXE = ITEMS.register("alexandrite_" + WeaponStats.GREAT_AXE.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.GREAT_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_GREAT_AXE = ITEMS.register("adamantite_" + WeaponStats.GREAT_AXE.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.GREAT_AXE, new Item.Properties()));


    //HARPOON
    public static final DeferredItem<WeaponItem> BRONZE_HARPOON = ITEMS.register("bronze_" + WeaponStats.HARPOON.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.HARPOON, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_HARPOON = ITEMS.register("gold_" + WeaponStats.HARPOON.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.HARPOON, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_HARPOON = ITEMS.register("silver_" + WeaponStats.HARPOON.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.HARPOON, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_HARPOON = ITEMS.register("iron_" + WeaponStats.HARPOON.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.HARPOON, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_HARPOON = ITEMS.register("steel_" + WeaponStats.HARPOON.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.HARPOON, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_HARPOON = ITEMS.register("bismuth_" + WeaponStats.HARPOON.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.HARPOON, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_HARPOON = ITEMS.register("diamond_" + WeaponStats.HARPOON.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.HARPOON, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_HARPOON = ITEMS.register("netherite_" + WeaponStats.HARPOON.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.HARPOON, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_HARPOON = ITEMS.register("titanium_" + WeaponStats.HARPOON.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.HARPOON, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_HARPOON = ITEMS.register("iolite_" + WeaponStats.HARPOON.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.HARPOON, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_HARPOON = ITEMS.register("alexandrite_" + WeaponStats.HARPOON.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.HARPOON, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_HARPOON = ITEMS.register("adamantite_" + WeaponStats.HARPOON.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.HARPOON, new Item.Properties()));


    //HOLY_RIFLE
    public static final DeferredItem<WeaponItem> BRONZE_HOLY_RIFLE = ITEMS.register("bronze_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.HOLY_RIFLE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_HOLY_RIFLE = ITEMS.register("gold_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.HOLY_RIFLE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_HOLY_RIFLE = ITEMS.register("silver_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.HOLY_RIFLE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_HOLY_RIFLE = ITEMS.register("iron_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.HOLY_RIFLE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_HOLY_RIFLE = ITEMS.register("steel_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.HOLY_RIFLE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_HOLY_RIFLE = ITEMS.register("bismuth_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.HOLY_RIFLE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_HOLY_RIFLE = ITEMS.register("diamond_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.HOLY_RIFLE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_HOLY_RIFLE = ITEMS.register("netherite_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.HOLY_RIFLE, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_HOLY_RIFLE = ITEMS.register("titanium_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.HOLY_RIFLE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_HOLY_RIFLE = ITEMS.register("iolite_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.HOLY_RIFLE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_HOLY_RIFLE = ITEMS.register("alexandrite_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.HOLY_RIFLE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_HOLY_RIFLE = ITEMS.register("adamantite_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.HOLY_RIFLE, new Item.Properties()));


    //KATANA
    public static final DeferredItem<WeaponItem> BRONZE_KATANA = ITEMS.register("bronze_" + WeaponStats.KATANA.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.KATANA, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_KATANA = ITEMS.register("gold_" + WeaponStats.KATANA.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.KATANA, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_KATANA = ITEMS.register("silver_" + WeaponStats.KATANA.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.KATANA, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_KATANA = ITEMS.register("iron_" + WeaponStats.KATANA.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.KATANA, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_KATANA = ITEMS.register("steel_" + WeaponStats.KATANA.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.KATANA, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_KATANA = ITEMS.register("bismuth_" + WeaponStats.KATANA.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.KATANA, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_KATANA = ITEMS.register("diamond_" + WeaponStats.KATANA.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.KATANA, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_KATANA = ITEMS.register("netherite_" + WeaponStats.KATANA.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.KATANA, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_KATANA = ITEMS.register("titanium_" + WeaponStats.KATANA.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.KATANA, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_KATANA = ITEMS.register("iolite_" + WeaponStats.KATANA.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.KATANA, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_KATANA = ITEMS.register("alexandrite_" + WeaponStats.KATANA.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.KATANA, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_KATANA = ITEMS.register("adamantite_" + WeaponStats.KATANA.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.KATANA, new Item.Properties()));


    //LANCE
    public static final DeferredItem<WeaponItem> BRONZE_LANCE = ITEMS.register("bronze_" + WeaponStats.LANCE.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.LANCE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_LANCE = ITEMS.register("gold_" + WeaponStats.LANCE.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.LANCE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_LANCE = ITEMS.register("silver_" + WeaponStats.LANCE.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.LANCE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_LANCE = ITEMS.register("iron_" + WeaponStats.LANCE.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.LANCE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_LANCE = ITEMS.register("steel_" + WeaponStats.LANCE.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.LANCE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_LANCE = ITEMS.register("bismuth_" + WeaponStats.LANCE.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.LANCE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_LANCE = ITEMS.register("diamond_" + WeaponStats.LANCE.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.LANCE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_LANCE = ITEMS.register("netherite_" + WeaponStats.LANCE.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.LANCE, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_LANCE = ITEMS.register("titanium_" + WeaponStats.LANCE.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.LANCE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_LANCE = ITEMS.register("iolite_" + WeaponStats.LANCE.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.LANCE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_LANCE = ITEMS.register("alexandrite_" + WeaponStats.LANCE.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.LANCE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_LANCE = ITEMS.register("adamantite_" + WeaponStats.LANCE.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.LANCE, new Item.Properties()));


    //Bows and Crossbows
    public static final DeferredItem<LongBow> LONGBOW = ITEMS.register(WeaponStats.LONGBOW.weaponId(), () -> new LongBow(new Item.Properties()));


    //LYRE
    public static final DeferredItem<WeaponItem> BRONZE_LYRE = ITEMS.register("bronze_" + WeaponStats.LYRE.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.LYRE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_LYRE = ITEMS.register("gold_" + WeaponStats.LYRE.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.LYRE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_LYRE = ITEMS.register("silver_" + WeaponStats.LYRE.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.LYRE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_LYRE = ITEMS.register("iron_" + WeaponStats.LYRE.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.LYRE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_LYRE = ITEMS.register("steel_" + WeaponStats.LYRE.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.LYRE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_LYRE = ITEMS.register("bismuth_" + WeaponStats.LYRE.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.LYRE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_LYRE = ITEMS.register("diamond_" + WeaponStats.LYRE.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.LYRE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_LYRE = ITEMS.register("netherite_" + WeaponStats.LYRE.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.LYRE, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_LYRE = ITEMS.register("titanium_" + WeaponStats.LYRE.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.LYRE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_LYRE = ITEMS.register("iolite_" + WeaponStats.LYRE.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.LYRE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_LYRE = ITEMS.register("alexandrite_" + WeaponStats.LYRE.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.LYRE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_LYRE = ITEMS.register("adamantite_" + WeaponStats.LYRE.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.LYRE, new Item.Properties()));


    //MAGICIAN_WAND
    public static final DeferredItem<WeaponItem> BRONZE_MAGICIAN_WAND = ITEMS.register("bronze_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.MAGICIAN_WAND, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_MAGICIAN_WAND = ITEMS.register("gold_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.MAGICIAN_WAND, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_MAGICIAN_WAND = ITEMS.register("silver_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.MAGICIAN_WAND, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_MAGICIAN_WAND = ITEMS.register("iron_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.MAGICIAN_WAND, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_MAGICIAN_WAND = ITEMS.register("steel_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.MAGICIAN_WAND, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_MAGICIAN_WAND = ITEMS.register("bismuth_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.MAGICIAN_WAND, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_MAGICIAN_WAND = ITEMS.register("diamond_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.MAGICIAN_WAND, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_MAGICIAN_WAND = ITEMS.register("netherite_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.MAGICIAN_WAND, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_MAGICIAN_WAND = ITEMS.register("titanium_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.MAGICIAN_WAND, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_MAGICIAN_WAND = ITEMS.register("iolite_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.MAGICIAN_WAND, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_MAGICIAN_WAND = ITEMS.register("alexandrite_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.MAGICIAN_WAND, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_MAGICIAN_WAND = ITEMS.register("adamantite_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.MAGICIAN_WAND, new Item.Properties()));


    //RAPIER
    public static final DeferredItem<WeaponItem> BRONZE_RAPIER = ITEMS.register("bronze_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_RAPIER = ITEMS.register("gold_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_RAPIER = ITEMS.register("silver_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_RAPIER = ITEMS.register("iron_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_RAPIER = ITEMS.register("steel_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_RAPIER = ITEMS.register("bismuth_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_RAPIER = ITEMS.register("diamond_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_RAPIER = ITEMS.register("netherite_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_RAPIER = ITEMS.register("titanium_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_RAPIER = ITEMS.register("iolite_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_RAPIER = ITEMS.register("alexandrite_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_RAPIER = ITEMS.register("adamantite_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //RUNIC_AXE
    public static final DeferredItem<WeaponItem> BRONZE_RUNIC_AXE = ITEMS.register("bronze_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.RUNIC_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_RUNIC_AXE = ITEMS.register("gold_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.RUNIC_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_RUNIC_AXE = ITEMS.register("silver_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.RUNIC_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_RUNIC_AXE = ITEMS.register("iron_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.RUNIC_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_RUNIC_AXE = ITEMS.register("steel_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.RUNIC_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_RUNIC_AXE = ITEMS.register("bismuth_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.RUNIC_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_RUNIC_AXE = ITEMS.register("diamond_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.RUNIC_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_RUNIC_AXE = ITEMS.register("netherite_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.RUNIC_AXE, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_RUNIC_AXE = ITEMS.register("titanium_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.RUNIC_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_RUNIC_AXE = ITEMS.register("iolite_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.RUNIC_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_RUNIC_AXE = ITEMS.register("alexandrite_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.RUNIC_AXE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_RUNIC_AXE = ITEMS.register("adamantite_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.RUNIC_AXE, new Item.Properties()));


    //RUNIC_BLADE
    public static final DeferredItem<WeaponItem> BRONZE_RUNIC_BLADE = ITEMS.register("bronze_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.RUNIC_BLADE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_RUNIC_BLADE = ITEMS.register("gold_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.RUNIC_BLADE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_RUNIC_BLADE = ITEMS.register("silver_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.RUNIC_BLADE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_RUNIC_BLADE = ITEMS.register("iron_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.RUNIC_BLADE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_RUNIC_BLADE = ITEMS.register("steel_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.RUNIC_BLADE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_RUNIC_BLADE = ITEMS.register("bismuth_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.RUNIC_BLADE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_RUNIC_BLADE = ITEMS.register("diamond_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.RUNIC_BLADE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_RUNIC_BLADE = ITEMS.register("netherite_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.RUNIC_BLADE, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_RUNIC_BLADE = ITEMS.register("titanium_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.RUNIC_BLADE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_RUNIC_BLADE = ITEMS.register("iolite_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.RUNIC_BLADE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_RUNIC_BLADE = ITEMS.register("alexandrite_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.RUNIC_BLADE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_RUNIC_BLADE = ITEMS.register("adamantite_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.RUNIC_BLADE, new Item.Properties()));


    //RUNIC_BLASTER
    public static final DeferredItem<WeaponItem> BRONZE_RUNIC_BLASTER = ITEMS.register("bronze_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.RUNIC_BLASTER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_RUNIC_BLASTER = ITEMS.register("gold_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.RUNIC_BLASTER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_RUNIC_BLASTER = ITEMS.register("silver_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.RUNIC_BLASTER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_RUNIC_BLASTER = ITEMS.register("iron_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.RUNIC_BLASTER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_RUNIC_BLASTER = ITEMS.register("steel_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.RUNIC_BLASTER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_RUNIC_BLASTER = ITEMS.register("bismuth_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.RUNIC_BLASTER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_RUNIC_BLASTER = ITEMS.register("diamond_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.RUNIC_BLASTER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_RUNIC_BLASTER = ITEMS.register("netherite_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.RUNIC_BLASTER, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_RUNIC_BLASTER = ITEMS.register("titanium_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.RUNIC_BLASTER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_RUNIC_BLASTER = ITEMS.register("iolite_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.RUNIC_BLASTER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_RUNIC_BLASTER = ITEMS.register("alexandrite_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.RUNIC_BLASTER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_RUNIC_BLASTER = ITEMS.register("adamantite_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.RUNIC_BLASTER, new Item.Properties()));


    //SCISSORS_COMBINED
    public static final DeferredItem<WeaponItem> BRONZE_SCISSORS_SWORD = ITEMS.register("bronze_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_SCISSORS_SWORD = ITEMS.register("gold_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_SCISSORS_SWORD = ITEMS.register("silver_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_SCISSORS_SWORD = ITEMS.register("iron_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_SCISSORS_SWORD = ITEMS.register("steel_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_SCISSORS_SWORD = ITEMS.register("bismuth_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_SCISSORS_SWORD = ITEMS.register("diamond_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_SCISSORS_SWORD = ITEMS.register("netherite_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.SCISSORS_SWORD, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_SCISSORS_SWORD = ITEMS.register("titanium_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_SCISSORS_SWORD = ITEMS.register("iolite_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_SCISSORS_SWORD = ITEMS.register("alexandrite_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_SCISSORS_SWORD = ITEMS.register("adamantite_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.SCISSORS_SWORD, new Item.Properties()));

    //SCISSORS_SEPARATE
    public static final DeferredItem<WeaponItem> BRONZE_SINGLE_SCISSORS_SWORD = ITEMS.register("bronze_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.SINGLE_SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_SINGLE_SCISSORS_SWORD = ITEMS.register("gold_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.SINGLE_SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_SINGLE_SCISSORS_SWORD = ITEMS.register("silver_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.SINGLE_SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_SINGLE_SCISSORS_SWORD = ITEMS.register("iron_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.SINGLE_SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_SINGLE_SCISSORS_SWORD = ITEMS.register("steel_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.SINGLE_SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_SINGLE_SCISSORS_SWORD = ITEMS.register("bismuth_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.SINGLE_SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_SINGLE_SCISSORS_SWORD = ITEMS.register("diamond_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.SINGLE_SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_SINGLE_SCISSORS_SWORD = ITEMS.register("netherite_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.SINGLE_SCISSORS_SWORD, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_SINGLE_SCISSORS_SWORD = ITEMS.register("titanium_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.SINGLE_SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_SINGLE_SCISSORS_SWORD = ITEMS.register("iolite_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.SINGLE_SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_SINGLE_SCISSORS_SWORD = ITEMS.register("alexandrite_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.SINGLE_SCISSORS_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_SINGLE_SCISSORS_SWORD = ITEMS.register("adamantite_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.SINGLE_SCISSORS_SWORD, new Item.Properties()));


    //SCYTHE
    public static final DeferredItem<WeaponItem> BRONZE_SCYTHE = ITEMS.register("bronze_" + WeaponStats.SCYTHE.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.SCYTHE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_SCYTHE = ITEMS.register("gold_" + WeaponStats.SCYTHE.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.SCYTHE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_SCYTHE = ITEMS.register("silver_" + WeaponStats.SCYTHE.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.SCYTHE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_SCYTHE = ITEMS.register("iron_" + WeaponStats.SCYTHE.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.SCYTHE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_SCYTHE = ITEMS.register("steel_" + WeaponStats.SCYTHE.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.SCYTHE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_SCYTHE = ITEMS.register("bismuth_" + WeaponStats.SCYTHE.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.SCYTHE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_SCYTHE = ITEMS.register("diamond_" + WeaponStats.SCYTHE.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.SCYTHE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_SCYTHE = ITEMS.register("netherite_" + WeaponStats.SCYTHE.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.SCYTHE, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_SCYTHE = ITEMS.register("titanium_" + WeaponStats.SCYTHE.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.SCYTHE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_SCYTHE = ITEMS.register("iolite_" + WeaponStats.SCYTHE.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.SCYTHE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_SCYTHE = ITEMS.register("alexandrite_" + WeaponStats.SCYTHE.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.SCYTHE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_SCYTHE = ITEMS.register("adamantite_" + WeaponStats.SCYTHE.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.SCYTHE, new Item.Properties()));

/*
    //SHOTGUN_SHIELD
    public static final DeferredItem<BaseModWeapon> BRONZE_SHOTGUN_SHIELD = ITEMS.register("bronze_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new BaseModWeapon(ModToolTiers.BRONZE,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> GOLD_SHOTGUN_SHIELD = ITEMS.register("gold_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new BaseModWeapon(Tiers.GOLD,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> SILVER_SHOTGUN_SHIELD = ITEMS.register("silver_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new BaseModWeapon(ModToolTiers.SILVER,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> IRON_SHOTGUN_SHIELD = ITEMS.register("iron_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new BaseModWeapon(Tiers.IRON,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> STEEL_SHOTGUN_SHIELD = ITEMS.register("steel_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new BaseModWeapon(ModToolTiers.STEEL,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> BISMUTH_SHOTGUN_SHIELD = ITEMS.register("bismuth_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new BaseModWeapon(ModToolTiers.BISMUTH,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> DIAMOND_SHOTGUN_SHIELD = ITEMS.register("diamond_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new BaseModWeapon(Tiers.DIAMOND,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> NETHERITE_SHOTGUN_SHIELD = ITEMS.register("netherite_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new BaseModWeapon(Tiers.NETHERITE,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties().fireResistant()));
    public static final DeferredItem<BaseModWeapon> TITANIUM_SHOTGUN_SHIELD = ITEMS.register("titanium_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new BaseModWeapon(ModToolTiers.TITANIUM,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> IOLITE_SHOTGUN_SHIELD = ITEMS.register("iolite_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new BaseModWeapon(ModToolTiers.IOLITE,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> ALEXANDRITE_SHOTGUN_SHIELD = ITEMS.register("alexandrite_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new BaseModWeapon(ModToolTiers.ALEXANDRITE,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<BaseModWeapon> ADAMANTITE_SHOTGUN_SHIELD = ITEMS.register("adamantite_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new BaseModWeapon(ModToolTiers.ADAMANTITE,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
*/

    //SHURIKEN
    public static final DeferredItem<WeaponItem> BRONZE_SHURIKEN = ITEMS.register("bronze_" + WeaponStats.SHURIKEN.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.SHURIKEN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_SHURIKEN = ITEMS.register("gold_" + WeaponStats.SHURIKEN.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.SHURIKEN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_SHURIKEN = ITEMS.register("silver_" + WeaponStats.SHURIKEN.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.SHURIKEN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_SHURIKEN = ITEMS.register("iron_" + WeaponStats.SHURIKEN.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.SHURIKEN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_SHURIKEN = ITEMS.register("steel_" + WeaponStats.SHURIKEN.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.SHURIKEN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_SHURIKEN = ITEMS.register("bismuth_" + WeaponStats.SHURIKEN.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.SHURIKEN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_SHURIKEN = ITEMS.register("diamond_" + WeaponStats.SHURIKEN.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.SHURIKEN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_SHURIKEN = ITEMS.register("netherite_" + WeaponStats.SHURIKEN.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.SHURIKEN, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_SHURIKEN = ITEMS.register("titanium_" + WeaponStats.SHURIKEN.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.SHURIKEN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_SHURIKEN = ITEMS.register("iolite_" + WeaponStats.SHURIKEN.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.SHURIKEN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_SHURIKEN = ITEMS.register("alexandrite_" + WeaponStats.SHURIKEN.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.SHURIKEN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_SHURIKEN = ITEMS.register("adamantite_" + WeaponStats.SHURIKEN.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.SHURIKEN, new Item.Properties()));


    //SPELLCASTER_STAFF
    public static final DeferredItem<WeaponItem> BRONZE_SPELLCASTER_STAFF = ITEMS.register("bronze_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.SPELLCASTER_STAFF, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_SPELLCASTER_STAFF = ITEMS.register("gold_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.SPELLCASTER_STAFF, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_SPELLCASTER_STAFF = ITEMS.register("silver_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.SPELLCASTER_STAFF, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_SPELLCASTER_STAFF = ITEMS.register("iron_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.SPELLCASTER_STAFF, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_SPELLCASTER_STAFF = ITEMS.register("steel_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.SPELLCASTER_STAFF, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_SPELLCASTER_STAFF = ITEMS.register("bismuth_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.SPELLCASTER_STAFF, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_SPELLCASTER_STAFF = ITEMS.register("diamond_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.SPELLCASTER_STAFF, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_SPELLCASTER_STAFF = ITEMS.register("netherite_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.SPELLCASTER_STAFF, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_SPELLCASTER_STAFF = ITEMS.register("titanium_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.SPELLCASTER_STAFF, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_SPELLCASTER_STAFF = ITEMS.register("iolite_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.SPELLCASTER_STAFF, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_SPELLCASTER_STAFF = ITEMS.register("alexandrite_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.SPELLCASTER_STAFF, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_SPELLCASTER_STAFF = ITEMS.register("adamantite_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.SPELLCASTER_STAFF, new Item.Properties()));


    //TALISMAN
    public static final DeferredItem<WeaponItem> BRONZE_TALISMAN = ITEMS.register("bronze_" + WeaponStats.TALISMAN.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.TALISMAN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_TALISMAN = ITEMS.register("gold_" + WeaponStats.TALISMAN.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.TALISMAN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_TALISMAN = ITEMS.register("silver_" + WeaponStats.TALISMAN.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.TALISMAN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_TALISMAN = ITEMS.register("iron_" + WeaponStats.TALISMAN.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.TALISMAN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_TALISMAN = ITEMS.register("steel_" + WeaponStats.TALISMAN.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.TALISMAN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_TALISMAN = ITEMS.register("bismuth_" + WeaponStats.TALISMAN.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.TALISMAN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_TALISMAN = ITEMS.register("diamond_" + WeaponStats.TALISMAN.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.TALISMAN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_TALISMAN = ITEMS.register("netherite_" + WeaponStats.TALISMAN.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.TALISMAN, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_TALISMAN = ITEMS.register("titanium_" + WeaponStats.TALISMAN.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.TALISMAN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_TALISMAN = ITEMS.register("iolite_" + WeaponStats.TALISMAN.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.TALISMAN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_TALISMAN = ITEMS.register("alexandrite_" + WeaponStats.TALISMAN.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.TALISMAN, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_TALISMAN = ITEMS.register("adamantite_" + WeaponStats.TALISMAN.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.TALISMAN, new Item.Properties()));


    //THROWING_KNIFE
    public static final DeferredItem<WeaponItem> BRONZE_THROWING_KNIFE = ITEMS.register("bronze_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.THROWING_KNIFE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_THROWING_KNIFE = ITEMS.register("gold_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.THROWING_KNIFE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_THROWING_KNIFE = ITEMS.register("silver_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.THROWING_KNIFE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_THROWING_KNIFE = ITEMS.register("iron_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.THROWING_KNIFE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_THROWING_KNIFE = ITEMS.register("steel_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.THROWING_KNIFE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_THROWING_KNIFE = ITEMS.register("bismuth_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.THROWING_KNIFE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_THROWING_KNIFE = ITEMS.register("diamond_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.THROWING_KNIFE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_THROWING_KNIFE = ITEMS.register("netherite_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.THROWING_KNIFE, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_THROWING_KNIFE = ITEMS.register("titanium_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.THROWING_KNIFE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_THROWING_KNIFE = ITEMS.register("iolite_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.THROWING_KNIFE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_THROWING_KNIFE = ITEMS.register("alexandrite_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.THROWING_KNIFE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_THROWING_KNIFE = ITEMS.register("adamantite_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.THROWING_KNIFE, new Item.Properties()));


    //TOME
    public static final DeferredItem<WeaponItem> BRONZE_TOME = ITEMS.register("bronze_" + WeaponStats.TOME.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.TOME, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_TOME = ITEMS.register("gold_" + WeaponStats.TOME.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.TOME, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_TOME = ITEMS.register("silver_" + WeaponStats.TOME.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.TOME, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_TOME = ITEMS.register("iron_" + WeaponStats.TOME.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.TOME, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_TOME = ITEMS.register("steel_" + WeaponStats.TOME.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.TOME, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_TOME = ITEMS.register("bismuth_" + WeaponStats.TOME.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.TOME, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_TOME = ITEMS.register("diamond_" + WeaponStats.TOME.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.TOME, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_TOME = ITEMS.register("netherite_" + WeaponStats.TOME.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.TOME, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_TOME = ITEMS.register("titanium_" + WeaponStats.TOME.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.TOME, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_TOME = ITEMS.register("iolite_" + WeaponStats.TOME.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.TOME, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_TOME = ITEMS.register("alexandrite_" + WeaponStats.TOME.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.TOME, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_TOME = ITEMS.register("adamantite_" + WeaponStats.TOME.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.TOME, new Item.Properties()));


    //WAR_FAN
    public static final DeferredItem<WeaponItem> BRONZE_WAR_FAN = ITEMS.register("bronze_" + WeaponStats.WAR_FAN.weaponId(), () -> new WarFanItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_WAR_FAN = ITEMS.register("gold_" + WeaponStats.WAR_FAN.weaponId(), () -> new WarFanItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_WAR_FAN = ITEMS.register("silver_" + WeaponStats.WAR_FAN.weaponId(), () -> new WarFanItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_WAR_FAN = ITEMS.register("iron_" + WeaponStats.WAR_FAN.weaponId(), () -> new WarFanItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_WAR_FAN = ITEMS.register("steel_" + WeaponStats.WAR_FAN.weaponId(), () -> new WarFanItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_WAR_FAN = ITEMS.register("bismuth_" + WeaponStats.WAR_FAN.weaponId(), () -> new WarFanItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_WAR_FAN = ITEMS.register("diamond_" + WeaponStats.WAR_FAN.weaponId(), () -> new WarFanItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_WAR_FAN = ITEMS.register("netherite_" + WeaponStats.WAR_FAN.weaponId(), () -> new WarFanItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_WAR_FAN = ITEMS.register("titanium_" + WeaponStats.WAR_FAN.weaponId(), () -> new WarFanItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_WAR_FAN = ITEMS.register("iolite_" + WeaponStats.WAR_FAN.weaponId(), () -> new WarFanItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_WAR_FAN = ITEMS.register("alexandrite_" + WeaponStats.WAR_FAN.weaponId(), () -> new WarFanItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_WAR_FAN = ITEMS.register("adamantite_" + WeaponStats.WAR_FAN.weaponId(), () -> new WarFanItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //WHIP_SWORD
    public static final DeferredItem<WeaponItem> BRONZE_WHIP_SWORD = ITEMS.register("bronze_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.BRONZE,WeaponStats.WHIP_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> GOLD_WHIP_SWORD = ITEMS.register("gold_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WeaponItem(Tiers.GOLD,WeaponStats.WHIP_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> SILVER_WHIP_SWORD = ITEMS.register("silver_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.SILVER,WeaponStats.WHIP_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IRON_WHIP_SWORD = ITEMS.register("iron_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WeaponItem(Tiers.IRON,WeaponStats.WHIP_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> STEEL_WHIP_SWORD = ITEMS.register("steel_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.STEEL,WeaponStats.WHIP_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> BISMUTH_WHIP_SWORD = ITEMS.register("bismuth_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.BISMUTH,WeaponStats.WHIP_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> DIAMOND_WHIP_SWORD = ITEMS.register("diamond_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WeaponItem(Tiers.DIAMOND,WeaponStats.WHIP_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> NETHERITE_WHIP_SWORD = ITEMS.register("netherite_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WeaponItem(Tiers.NETHERITE,WeaponStats.WHIP_SWORD, new Item.Properties().fireResistant()));
    public static final DeferredItem<WeaponItem> TITANIUM_WHIP_SWORD = ITEMS.register("titanium_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.TITANIUM,WeaponStats.WHIP_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> IOLITE_WHIP_SWORD = ITEMS.register("iolite_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.IOLITE,WeaponStats.WHIP_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ALEXANDRITE_WHIP_SWORD = ITEMS.register("alexandrite_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.ALEXANDRITE,WeaponStats.WHIP_SWORD, new Item.Properties()));
    public static final DeferredItem<WeaponItem> ADAMANTITE_WHIP_SWORD = ITEMS.register("adamantite_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WeaponItem(ModToolTiers.ADAMANTITE,WeaponStats.WHIP_SWORD, new Item.Properties()));












    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEat().nutrition(1).saturationMod(2f).build()));




    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
