package com.fuyuvulpes.yoamod.core.registries;

import com.fuyuvulpes.yoamod.world.food.YoaFoods;
import com.fuyuvulpes.yoamod.world.item.*;
import com.fuyuvulpes.yoamod.world.item.weaponry.*;
import com.fuyuvulpes.yoamod.world.magic.mana.IMana;
import com.fuyuvulpes.yoamod.world.magic.mana.ManaHandler;
import com.fuyuvulpes.yoamod.world.magic.mana.ManaHelper;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class YoaItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);



    public static final DeferredItem<Item> PLANE_ITEM = ITEMS.register("plane_item", () -> new PlaneItem(new Item.Properties().stacksTo(1)));

    public static  final DeferredItem<Item> ANCIENT_GEMSTONE = ITEMS.registerSimpleItem("ancient_gemstone");
    public static  final DeferredItem<Item> RAW_BIG_MEAT = ITEMS.registerSimpleItem("raw_big_meat", new Item.Properties()
            .food(YoaFoods.BIG_MEAT));
    public static  final DeferredItem<Item> COOKED_BIG_MEAT = ITEMS.registerSimpleItem("cooked_big_meat", new Item.Properties()
            .food(YoaFoods.COOKED_BIG_MEAT));
    public static  final DeferredItem<Item> SLICED_RAW_MEAT = ITEMS.registerSimpleItem("sliced_raw_meat", new Item.Properties()
            .food(YoaFoods.SLICED_MEAT));
    public static  final DeferredItem<Item> SLICED_COOKED_MEAT = ITEMS.registerSimpleItem("sliced_cooked_meat", new Item.Properties()
            .food(YoaFoods.SLICED_COOKED_MEAT));
    public static  final DeferredItem<Item> HAMBURGER = ITEMS.registerSimpleItem("hamburger", new Item.Properties()
            .food(YoaFoods.HAMBURGER));
    public static  final DeferredItem<Item> ECTOPLASM = ITEMS.registerSimpleItem("ectoplasm");
    public static  final DeferredItem<Item> INSECT_LEG = ITEMS.registerSimpleItem("insect_leg");
    public static  final DeferredItem<Item> TUSK = ITEMS.registerSimpleItem("tusk");
    public static final DeferredItem<Item> BLISSWOOD_SIGN = ITEMS.register(
            "blisswood_sign", () -> new SignItem(new Item.Properties().stacksTo(16), YoaBlocks.BLISSWOOD_SIGN.get(), YoaBlocks.BLISSWOOD_WALL_SIGN.get()));

    public static final DeferredItem<Item> BLISSWOOD_HANGING_SIGN = ITEMS.register(
            "blisswood_hanging_sign", () ->  new HangingSignItem(YoaBlocks.BLISSWOOD_HANGING_SIGN.get(), YoaBlocks.BLISSWOOD_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16))
    );


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
    public static final DeferredItem<BellItem> BRONZE_BELL = ITEMS.register("bronze_" + WeaponStats.BELL.weaponId(), () -> new BellItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<BellItem> GOLD_BELL = ITEMS.register("gold_" + WeaponStats.BELL.weaponId(), () -> new BellItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<BellItem> SILVER_BELL = ITEMS.register("silver_" + WeaponStats.BELL.weaponId(), () -> new BellItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<BellItem> IRON_BELL = ITEMS.register("iron_" + WeaponStats.BELL.weaponId(), () -> new BellItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<BellItem> STEEL_BELL = ITEMS.register("steel_" + WeaponStats.BELL.weaponId(), () -> new BellItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<BellItem> BISMUTH_BELL = ITEMS.register("bismuth_" + WeaponStats.BELL.weaponId(), () -> new BellItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<BellItem> DIAMOND_BELL = ITEMS.register("diamond_" + WeaponStats.BELL.weaponId(), () -> new BellItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<BellItem> NETHERITE_BELL = ITEMS.register("netherite_" + WeaponStats.BELL.weaponId(), () -> new BellItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<BellItem> TITANIUM_BELL = ITEMS.register("titanium_" + WeaponStats.BELL.weaponId(), () -> new BellItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<BellItem> IOLITE_BELL = ITEMS.register("iolite_" + WeaponStats.BELL.weaponId(), () -> new BellItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<BellItem> ALEXANDRITE_BELL = ITEMS.register("alexandrite_" + WeaponStats.BELL.weaponId(), () -> new BellItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<BellItem> ADAMANTITE_BELL = ITEMS.register("adamantite_" + WeaponStats.BELL.weaponId(), () -> new BellItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //BLOW_DART
    public static final DeferredItem<BlowDartItem> BRONZE_BLOW_DART = ITEMS.register("bronze_" + WeaponStats.BLOW_DART.weaponId(), () -> new BlowDartItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<BlowDartItem> GOLD_BLOW_DART = ITEMS.register("gold_" + WeaponStats.BLOW_DART.weaponId(), () -> new BlowDartItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<BlowDartItem> SILVER_BLOW_DART = ITEMS.register("silver_" + WeaponStats.BLOW_DART.weaponId(), () -> new BlowDartItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<BlowDartItem> IRON_BLOW_DART = ITEMS.register("iron_" + WeaponStats.BLOW_DART.weaponId(), () -> new BlowDartItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<BlowDartItem> STEEL_BLOW_DART = ITEMS.register("steel_" + WeaponStats.BLOW_DART.weaponId(), () -> new BlowDartItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<BlowDartItem> BISMUTH_BLOW_DART = ITEMS.register("bismuth_" + WeaponStats.BLOW_DART.weaponId(), () -> new BlowDartItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<BlowDartItem> DIAMOND_BLOW_DART = ITEMS.register("diamond_" + WeaponStats.BLOW_DART.weaponId(), () -> new BlowDartItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<BlowDartItem> NETHERITE_BLOW_DART = ITEMS.register("netherite_" + WeaponStats.BLOW_DART.weaponId(), () -> new BlowDartItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<BlowDartItem> TITANIUM_BLOW_DART = ITEMS.register("titanium_" + WeaponStats.BLOW_DART.weaponId(), () -> new BlowDartItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<BlowDartItem> IOLITE_BLOW_DART = ITEMS.register("iolite_" + WeaponStats.BLOW_DART.weaponId(), () -> new BlowDartItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<BlowDartItem> ALEXANDRITE_BLOW_DART = ITEMS.register("alexandrite_" + WeaponStats.BLOW_DART.weaponId(), () -> new BlowDartItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<BlowDartItem> ADAMANTITE_BLOW_DART = ITEMS.register("adamantite_" + WeaponStats.BLOW_DART.weaponId(), () -> new BlowDartItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //BOOMERANG
    public static final DeferredItem<BoomerangItem> BRONZE_BOOMERANG = ITEMS.register("bronze_" + WeaponStats.BOOMERANG.weaponId(), () -> new BoomerangItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<BoomerangItem> GOLD_BOOMERANG = ITEMS.register("gold_" + WeaponStats.BOOMERANG.weaponId(), () -> new BoomerangItem(Tiers.GOLD,new Item.Properties()));
    public static final DeferredItem<BoomerangItem> SILVER_BOOMERANG = ITEMS.register("silver_" + WeaponStats.BOOMERANG.weaponId(), () -> new BoomerangItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<BoomerangItem> IRON_BOOMERANG = ITEMS.register("iron_" + WeaponStats.BOOMERANG.weaponId(), () -> new BoomerangItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<BoomerangItem> STEEL_BOOMERANG = ITEMS.register("steel_" + WeaponStats.BOOMERANG.weaponId(), () -> new BoomerangItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<BoomerangItem> BISMUTH_BOOMERANG = ITEMS.register("bismuth_" + WeaponStats.BOOMERANG.weaponId(), () -> new BoomerangItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<BoomerangItem> DIAMOND_BOOMERANG = ITEMS.register("diamond_" + WeaponStats.BOOMERANG.weaponId(), () -> new BoomerangItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<BoomerangItem> NETHERITE_BOOMERANG = ITEMS.register("netherite_" + WeaponStats.BOOMERANG.weaponId(), () -> new BoomerangItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<BoomerangItem> TITANIUM_BOOMERANG = ITEMS.register("titanium_" + WeaponStats.BOOMERANG.weaponId(), () -> new BoomerangItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<BoomerangItem> IOLITE_BOOMERANG = ITEMS.register("iolite_" + WeaponStats.BOOMERANG.weaponId(), () -> new BoomerangItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<BoomerangItem> ALEXANDRITE_BOOMERANG = ITEMS.register("alexandrite_" + WeaponStats.BOOMERANG.weaponId(), () -> new BoomerangItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<BoomerangItem> ADAMANTITE_BOOMERANG = ITEMS.register("adamantite_" + WeaponStats.BOOMERANG.weaponId(), () -> new BoomerangItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //CHAKRAM
    public static final DeferredItem<ChakramItem> BRONZE_CHAKRAM = ITEMS.register("bronze_" + WeaponStats.CHAKRAM.weaponId(), () -> new ChakramItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<ChakramItem> GOLD_CHAKRAM = ITEMS.register("gold_" + WeaponStats.CHAKRAM.weaponId(), () -> new ChakramItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<ChakramItem> SILVER_CHAKRAM = ITEMS.register("silver_" + WeaponStats.CHAKRAM.weaponId(), () -> new ChakramItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<ChakramItem> IRON_CHAKRAM = ITEMS.register("iron_" + WeaponStats.CHAKRAM.weaponId(), () -> new ChakramItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<ChakramItem> STEEL_CHAKRAM = ITEMS.register("steel_" + WeaponStats.CHAKRAM.weaponId(), () -> new ChakramItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<ChakramItem> BISMUTH_CHAKRAM = ITEMS.register("bismuth_" + WeaponStats.CHAKRAM.weaponId(), () -> new ChakramItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<ChakramItem> DIAMOND_CHAKRAM = ITEMS.register("diamond_" + WeaponStats.CHAKRAM.weaponId(), () -> new ChakramItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<ChakramItem> NETHERITE_CHAKRAM = ITEMS.register("netherite_" + WeaponStats.CHAKRAM.weaponId(), () -> new ChakramItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<ChakramItem> TITANIUM_CHAKRAM = ITEMS.register("titanium_" + WeaponStats.CHAKRAM.weaponId(), () -> new ChakramItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<ChakramItem> IOLITE_CHAKRAM = ITEMS.register("iolite_" + WeaponStats.CHAKRAM.weaponId(), () -> new ChakramItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<ChakramItem> ALEXANDRITE_CHAKRAM = ITEMS.register("alexandrite_" + WeaponStats.CHAKRAM.weaponId(), () -> new ChakramItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<ChakramItem> ADAMANTITE_CHAKRAM = ITEMS.register("adamantite_" + WeaponStats.CHAKRAM.weaponId(), () -> new ChakramItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //CLAWS
    public static final DeferredItem<ClawsItem> BRONZE_CLAWS = ITEMS.register("bronze_" + WeaponStats.CLAWS.weaponId(), () -> new ClawsItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<ClawsItem> GOLD_CLAWS = ITEMS.register("gold_" + WeaponStats.CLAWS.weaponId(), () -> new ClawsItem(Tiers.GOLD,new Item.Properties()));
    public static final DeferredItem<ClawsItem> SILVER_CLAWS = ITEMS.register("silver_" + WeaponStats.CLAWS.weaponId(), () -> new ClawsItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<ClawsItem> IRON_CLAWS = ITEMS.register("iron_" + WeaponStats.CLAWS.weaponId(), () -> new ClawsItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<ClawsItem> STEEL_CLAWS = ITEMS.register("steel_" + WeaponStats.CLAWS.weaponId(), () -> new ClawsItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<ClawsItem> BISMUTH_CLAWS = ITEMS.register("bismuth_" + WeaponStats.CLAWS.weaponId(), () -> new ClawsItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<ClawsItem> DIAMOND_CLAWS = ITEMS.register("diamond_" + WeaponStats.CLAWS.weaponId(), () -> new ClawsItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<ClawsItem> NETHERITE_CLAWS = ITEMS.register("netherite_" + WeaponStats.CLAWS.weaponId(), () -> new ClawsItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<ClawsItem> TITANIUM_CLAWS = ITEMS.register("titanium_" + WeaponStats.CLAWS.weaponId(), () -> new ClawsItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<ClawsItem> IOLITE_CLAWS = ITEMS.register("iolite_" + WeaponStats.CLAWS.weaponId(), () -> new ClawsItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<ClawsItem> ALEXANDRITE_CLAWS = ITEMS.register("alexandrite_" + WeaponStats.CLAWS.weaponId(), () -> new ClawsItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<ClawsItem> ADAMANTITE_CLAWS = ITEMS.register("adamantite_" + WeaponStats.CLAWS.weaponId(), () -> new ClawsItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //CLAYMORE
    public static final DeferredItem<ClaymoreItem> BRONZE_CLAYMORE = ITEMS.register("bronze_" + WeaponStats.CLAYMORE.weaponId(), () -> new ClaymoreItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<ClaymoreItem> GOLD_CLAYMORE = ITEMS.register("gold_" + WeaponStats.CLAYMORE.weaponId(), () -> new ClaymoreItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<ClaymoreItem> SILVER_CLAYMORE = ITEMS.register("silver_" + WeaponStats.CLAYMORE.weaponId(), () -> new ClaymoreItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<ClaymoreItem> IRON_CLAYMORE = ITEMS.register("iron_" + WeaponStats.CLAYMORE.weaponId(), () -> new ClaymoreItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<ClaymoreItem> STEEL_CLAYMORE = ITEMS.register("steel_" + WeaponStats.CLAYMORE.weaponId(), () -> new ClaymoreItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<ClaymoreItem> BISMUTH_CLAYMORE = ITEMS.register("bismuth_" + WeaponStats.CLAYMORE.weaponId(), () -> new ClaymoreItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<ClaymoreItem> DIAMOND_CLAYMORE = ITEMS.register("diamond_" + WeaponStats.CLAYMORE.weaponId(), () -> new ClaymoreItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<ClaymoreItem> NETHERITE_CLAYMORE = ITEMS.register("netherite_" + WeaponStats.CLAYMORE.weaponId(), () -> new ClaymoreItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<ClaymoreItem> TITANIUM_CLAYMORE = ITEMS.register("titanium_" + WeaponStats.CLAYMORE.weaponId(), () -> new ClaymoreItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<ClaymoreItem> IOLITE_CLAYMORE = ITEMS.register("iolite_" + WeaponStats.CLAYMORE.weaponId(), () -> new ClaymoreItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<ClaymoreItem> ALEXANDRITE_CLAYMORE = ITEMS.register("alexandrite_" + WeaponStats.CLAYMORE.weaponId(), () -> new ClaymoreItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<ClaymoreItem> ADAMANTITE_CLAYMORE = ITEMS.register("adamantite_" + WeaponStats.CLAYMORE.weaponId(), () -> new ClaymoreItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //DAGGER
    public static final DeferredItem<DaggerItem> BRONZE_DAGGER = ITEMS.register("bronze_" + WeaponStats.DAGGER.weaponId(), () -> new DaggerItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<DaggerItem> GOLD_DAGGER = ITEMS.register("gold_" + WeaponStats.DAGGER.weaponId(), () -> new DaggerItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<DaggerItem> SILVER_DAGGER = ITEMS.register("silver_" + WeaponStats.DAGGER.weaponId(), () -> new DaggerItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<DaggerItem> IRON_DAGGER = ITEMS.register("iron_" + WeaponStats.DAGGER.weaponId(), () -> new DaggerItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<DaggerItem> STEEL_DAGGER = ITEMS.register("steel_" + WeaponStats.DAGGER.weaponId(), () -> new DaggerItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<DaggerItem> BISMUTH_DAGGER = ITEMS.register("bismuth_" + WeaponStats.DAGGER.weaponId(), () -> new DaggerItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<DaggerItem> DIAMOND_DAGGER = ITEMS.register("diamond_" + WeaponStats.DAGGER.weaponId(), () -> new DaggerItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<DaggerItem> NETHERITE_DAGGER = ITEMS.register("netherite_" + WeaponStats.DAGGER.weaponId(), () -> new DaggerItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<DaggerItem> TITANIUM_DAGGER = ITEMS.register("titanium_" + WeaponStats.DAGGER.weaponId(), () -> new DaggerItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<DaggerItem> IOLITE_DAGGER = ITEMS.register("iolite_" + WeaponStats.DAGGER.weaponId(), () -> new DaggerItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<DaggerItem> ALEXANDRITE_DAGGER = ITEMS.register("alexandrite_" + WeaponStats.DAGGER.weaponId(), () -> new DaggerItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<DaggerItem> ADAMANTITE_DAGGER = ITEMS.register("adamantite_" + WeaponStats.DAGGER.weaponId(), () -> new DaggerItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //GREAT_AXE
    public static final DeferredItem<GreatAxeItem> BRONZE_GREAT_AXE = ITEMS.register("bronze_" + WeaponStats.GREAT_AXE.weaponId(), () -> new GreatAxeItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<GreatAxeItem> GOLD_GREAT_AXE = ITEMS.register("gold_" + WeaponStats.GREAT_AXE.weaponId(), () -> new GreatAxeItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<GreatAxeItem> SILVER_GREAT_AXE = ITEMS.register("silver_" + WeaponStats.GREAT_AXE.weaponId(), () -> new GreatAxeItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<GreatAxeItem> IRON_GREAT_AXE = ITEMS.register("iron_" + WeaponStats.GREAT_AXE.weaponId(), () -> new GreatAxeItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<GreatAxeItem> STEEL_GREAT_AXE = ITEMS.register("steel_" + WeaponStats.GREAT_AXE.weaponId(), () -> new GreatAxeItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<GreatAxeItem> BISMUTH_GREAT_AXE = ITEMS.register("bismuth_" + WeaponStats.GREAT_AXE.weaponId(), () -> new GreatAxeItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<GreatAxeItem> DIAMOND_GREAT_AXE = ITEMS.register("diamond_" + WeaponStats.GREAT_AXE.weaponId(), () -> new GreatAxeItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<GreatAxeItem> NETHERITE_GREAT_AXE = ITEMS.register("netherite_" + WeaponStats.GREAT_AXE.weaponId(), () -> new GreatAxeItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<GreatAxeItem> TITANIUM_GREAT_AXE = ITEMS.register("titanium_" + WeaponStats.GREAT_AXE.weaponId(), () -> new GreatAxeItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<GreatAxeItem> IOLITE_GREAT_AXE = ITEMS.register("iolite_" + WeaponStats.GREAT_AXE.weaponId(), () -> new GreatAxeItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<GreatAxeItem> ALEXANDRITE_GREAT_AXE = ITEMS.register("alexandrite_" + WeaponStats.GREAT_AXE.weaponId(), () -> new GreatAxeItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<GreatAxeItem> ADAMANTITE_GREAT_AXE = ITEMS.register("adamantite_" + WeaponStats.GREAT_AXE.weaponId(), () -> new GreatAxeItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //HARPOON
    public static final DeferredItem<HarpoonItem> BRONZE_HARPOON = ITEMS.register("bronze_" + WeaponStats.HARPOON.weaponId(), () -> new HarpoonItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<HarpoonItem> GOLD_HARPOON = ITEMS.register("gold_" + WeaponStats.HARPOON.weaponId(), () -> new HarpoonItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<HarpoonItem> SILVER_HARPOON = ITEMS.register("silver_" + WeaponStats.HARPOON.weaponId(), () -> new HarpoonItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<HarpoonItem> IRON_HARPOON = ITEMS.register("iron_" + WeaponStats.HARPOON.weaponId(), () -> new HarpoonItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<HarpoonItem> STEEL_HARPOON = ITEMS.register("steel_" + WeaponStats.HARPOON.weaponId(), () -> new HarpoonItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<HarpoonItem> BISMUTH_HARPOON = ITEMS.register("bismuth_" + WeaponStats.HARPOON.weaponId(), () -> new HarpoonItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<HarpoonItem> DIAMOND_HARPOON = ITEMS.register("diamond_" + WeaponStats.HARPOON.weaponId(), () -> new HarpoonItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<HarpoonItem> NETHERITE_HARPOON = ITEMS.register("netherite_" + WeaponStats.HARPOON.weaponId(), () -> new HarpoonItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<HarpoonItem> TITANIUM_HARPOON = ITEMS.register("titanium_" + WeaponStats.HARPOON.weaponId(), () -> new HarpoonItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<HarpoonItem> IOLITE_HARPOON = ITEMS.register("iolite_" + WeaponStats.HARPOON.weaponId(), () -> new HarpoonItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<HarpoonItem> ALEXANDRITE_HARPOON = ITEMS.register("alexandrite_" + WeaponStats.HARPOON.weaponId(), () -> new HarpoonItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<HarpoonItem> ADAMANTITE_HARPOON = ITEMS.register("adamantite_" + WeaponStats.HARPOON.weaponId(), () -> new HarpoonItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //HOLY_RIFLE
    public static final DeferredItem<HolyRifleItem> BRONZE_HOLY_RIFLE = ITEMS.register("bronze_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new HolyRifleItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<HolyRifleItem> GOLD_HOLY_RIFLE = ITEMS.register("gold_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new HolyRifleItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<HolyRifleItem> SILVER_HOLY_RIFLE = ITEMS.register("silver_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new HolyRifleItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<HolyRifleItem> IRON_HOLY_RIFLE = ITEMS.register("iron_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new HolyRifleItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<HolyRifleItem> STEEL_HOLY_RIFLE = ITEMS.register("steel_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new HolyRifleItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<HolyRifleItem> BISMUTH_HOLY_RIFLE = ITEMS.register("bismuth_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new HolyRifleItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<HolyRifleItem> DIAMOND_HOLY_RIFLE = ITEMS.register("diamond_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new HolyRifleItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<HolyRifleItem> NETHERITE_HOLY_RIFLE = ITEMS.register("netherite_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new HolyRifleItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<HolyRifleItem> TITANIUM_HOLY_RIFLE = ITEMS.register("titanium_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new HolyRifleItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<HolyRifleItem> IOLITE_HOLY_RIFLE = ITEMS.register("iolite_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new HolyRifleItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<HolyRifleItem> ALEXANDRITE_HOLY_RIFLE = ITEMS.register("alexandrite_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new HolyRifleItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<HolyRifleItem> ADAMANTITE_HOLY_RIFLE = ITEMS.register("adamantite_" + WeaponStats.HOLY_RIFLE.weaponId(), () -> new HolyRifleItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //KATANA
    public static final DeferredItem<KatanaItem> BRONZE_KATANA = ITEMS.register("bronze_" + WeaponStats.KATANA.weaponId(), () -> new KatanaItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<KatanaItem> GOLD_KATANA = ITEMS.register("gold_" + WeaponStats.KATANA.weaponId(), () -> new KatanaItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<KatanaItem> SILVER_KATANA = ITEMS.register("silver_" + WeaponStats.KATANA.weaponId(), () -> new KatanaItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<KatanaItem> IRON_KATANA = ITEMS.register("iron_" + WeaponStats.KATANA.weaponId(), () -> new KatanaItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<KatanaItem> STEEL_KATANA = ITEMS.register("steel_" + WeaponStats.KATANA.weaponId(), () -> new KatanaItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<KatanaItem> BISMUTH_KATANA = ITEMS.register("bismuth_" + WeaponStats.KATANA.weaponId(), () -> new KatanaItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<KatanaItem> DIAMOND_KATANA = ITEMS.register("diamond_" + WeaponStats.KATANA.weaponId(), () -> new KatanaItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<KatanaItem> NETHERITE_KATANA = ITEMS.register("netherite_" + WeaponStats.KATANA.weaponId(), () -> new KatanaItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<KatanaItem> TITANIUM_KATANA = ITEMS.register("titanium_" + WeaponStats.KATANA.weaponId(), () -> new KatanaItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<KatanaItem> IOLITE_KATANA = ITEMS.register("iolite_" + WeaponStats.KATANA.weaponId(), () -> new KatanaItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<KatanaItem> ALEXANDRITE_KATANA = ITEMS.register("alexandrite_" + WeaponStats.KATANA.weaponId(), () -> new KatanaItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<KatanaItem> ADAMANTITE_KATANA = ITEMS.register("adamantite_" + WeaponStats.KATANA.weaponId(), () -> new KatanaItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //LANCE
    public static final DeferredItem<LanceItem> BRONZE_LANCE = ITEMS.register("bronze_" + WeaponStats.LANCE.weaponId(), () -> new LanceItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<LanceItem> GOLD_LANCE = ITEMS.register("gold_" + WeaponStats.LANCE.weaponId(), () -> new LanceItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<LanceItem> SILVER_LANCE = ITEMS.register("silver_" + WeaponStats.LANCE.weaponId(), () -> new LanceItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<LanceItem> IRON_LANCE = ITEMS.register("iron_" + WeaponStats.LANCE.weaponId(), () -> new LanceItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<LanceItem> STEEL_LANCE = ITEMS.register("steel_" + WeaponStats.LANCE.weaponId(), () -> new LanceItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<LanceItem> BISMUTH_LANCE = ITEMS.register("bismuth_" + WeaponStats.LANCE.weaponId(), () -> new LanceItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<LanceItem> DIAMOND_LANCE = ITEMS.register("diamond_" + WeaponStats.LANCE.weaponId(), () -> new LanceItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<LanceItem> NETHERITE_LANCE = ITEMS.register("netherite_" + WeaponStats.LANCE.weaponId(), () -> new LanceItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<LanceItem> TITANIUM_LANCE = ITEMS.register("titanium_" + WeaponStats.LANCE.weaponId(), () -> new LanceItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<LanceItem> IOLITE_LANCE = ITEMS.register("iolite_" + WeaponStats.LANCE.weaponId(), () -> new LanceItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<LanceItem> ALEXANDRITE_LANCE = ITEMS.register("alexandrite_" + WeaponStats.LANCE.weaponId(), () -> new LanceItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<LanceItem> ADAMANTITE_LANCE = ITEMS.register("adamantite_" + WeaponStats.LANCE.weaponId(), () -> new LanceItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //Bows and Crossbows
    public static final DeferredItem<LongbowItem> LONGBOW = ITEMS.register(WeaponStats.LONGBOW.weaponId(), () -> new LongbowItem(new Item.Properties()));


    //LYRE
    public static final DeferredItem<LyreItem> BRONZE_LYRE = ITEMS.register("bronze_" + WeaponStats.LYRE.weaponId(), () -> new LyreItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<LyreItem> GOLD_LYRE = ITEMS.register("gold_" + WeaponStats.LYRE.weaponId(), () -> new LyreItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<LyreItem> SILVER_LYRE = ITEMS.register("silver_" + WeaponStats.LYRE.weaponId(), () -> new LyreItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<LyreItem> IRON_LYRE = ITEMS.register("iron_" + WeaponStats.LYRE.weaponId(), () -> new LyreItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<LyreItem> STEEL_LYRE = ITEMS.register("steel_" + WeaponStats.LYRE.weaponId(), () -> new LyreItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<LyreItem> BISMUTH_LYRE = ITEMS.register("bismuth_" + WeaponStats.LYRE.weaponId(), () -> new LyreItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<LyreItem> DIAMOND_LYRE = ITEMS.register("diamond_" + WeaponStats.LYRE.weaponId(), () -> new LyreItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<LyreItem> NETHERITE_LYRE = ITEMS.register("netherite_" + WeaponStats.LYRE.weaponId(), () -> new LyreItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<LyreItem> TITANIUM_LYRE = ITEMS.register("titanium_" + WeaponStats.LYRE.weaponId(), () -> new LyreItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<LyreItem> IOLITE_LYRE = ITEMS.register("iolite_" + WeaponStats.LYRE.weaponId(), () -> new LyreItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<LyreItem> ALEXANDRITE_LYRE = ITEMS.register("alexandrite_" + WeaponStats.LYRE.weaponId(), () -> new LyreItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<LyreItem> ADAMANTITE_LYRE = ITEMS.register("adamantite_" + WeaponStats.LYRE.weaponId(), () -> new LyreItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //MAGICIAN_WAND
    public static final DeferredItem<MagicianWandItem> BRONZE_MAGICIAN_WAND = ITEMS.register("bronze_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new MagicianWandItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<MagicianWandItem> GOLD_MAGICIAN_WAND = ITEMS.register("gold_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new MagicianWandItem(Tiers.GOLD,new Item.Properties()));
    public static final DeferredItem<MagicianWandItem> SILVER_MAGICIAN_WAND = ITEMS.register("silver_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new MagicianWandItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<MagicianWandItem> IRON_MAGICIAN_WAND = ITEMS.register("iron_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new MagicianWandItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<MagicianWandItem> STEEL_MAGICIAN_WAND = ITEMS.register("steel_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new MagicianWandItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<MagicianWandItem> BISMUTH_MAGICIAN_WAND = ITEMS.register("bismuth_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new MagicianWandItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<MagicianWandItem> DIAMOND_MAGICIAN_WAND = ITEMS.register("diamond_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new MagicianWandItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<MagicianWandItem> NETHERITE_MAGICIAN_WAND = ITEMS.register("netherite_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new MagicianWandItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<MagicianWandItem> TITANIUM_MAGICIAN_WAND = ITEMS.register("titanium_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new MagicianWandItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<MagicianWandItem> IOLITE_MAGICIAN_WAND = ITEMS.register("iolite_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new MagicianWandItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<MagicianWandItem> ALEXANDRITE_MAGICIAN_WAND = ITEMS.register("alexandrite_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new MagicianWandItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<MagicianWandItem> ADAMANTITE_MAGICIAN_WAND = ITEMS.register("adamantite_" + WeaponStats.MAGICIAN_WAND.weaponId(), () -> new MagicianWandItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //RAPIER
    public static final DeferredItem<RapierItem> BRONZE_RAPIER = ITEMS.register("bronze_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<RapierItem> GOLD_RAPIER = ITEMS.register("gold_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<RapierItem> SILVER_RAPIER = ITEMS.register("silver_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<RapierItem> IRON_RAPIER = ITEMS.register("iron_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<RapierItem> STEEL_RAPIER = ITEMS.register("steel_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<RapierItem> BISMUTH_RAPIER = ITEMS.register("bismuth_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<RapierItem> DIAMOND_RAPIER = ITEMS.register("diamond_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<RapierItem> NETHERITE_RAPIER = ITEMS.register("netherite_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<RapierItem> TITANIUM_RAPIER = ITEMS.register("titanium_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<RapierItem> IOLITE_RAPIER = ITEMS.register("iolite_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<RapierItem> ALEXANDRITE_RAPIER = ITEMS.register("alexandrite_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<RapierItem> ADAMANTITE_RAPIER = ITEMS.register("adamantite_" + WeaponStats.RAPIER.weaponId(), () -> new RapierItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //RUNIC_AXE
    public static final DeferredItem<RunicAxeItem> BRONZE_RUNIC_AXE = ITEMS.register("bronze_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new RunicAxeItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<RunicAxeItem> GOLD_RUNIC_AXE = ITEMS.register("gold_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new RunicAxeItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<RunicAxeItem> SILVER_RUNIC_AXE = ITEMS.register("silver_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new RunicAxeItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<RunicAxeItem> IRON_RUNIC_AXE = ITEMS.register("iron_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new RunicAxeItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<RunicAxeItem> STEEL_RUNIC_AXE = ITEMS.register("steel_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new RunicAxeItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<RunicAxeItem> BISMUTH_RUNIC_AXE = ITEMS.register("bismuth_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new RunicAxeItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<RunicAxeItem> DIAMOND_RUNIC_AXE = ITEMS.register("diamond_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new RunicAxeItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<RunicAxeItem> NETHERITE_RUNIC_AXE = ITEMS.register("netherite_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new RunicAxeItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<RunicAxeItem> TITANIUM_RUNIC_AXE = ITEMS.register("titanium_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new RunicAxeItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<RunicAxeItem> IOLITE_RUNIC_AXE = ITEMS.register("iolite_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new RunicAxeItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<RunicAxeItem> ALEXANDRITE_RUNIC_AXE = ITEMS.register("alexandrite_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new RunicAxeItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<RunicAxeItem> ADAMANTITE_RUNIC_AXE = ITEMS.register("adamantite_" + WeaponStats.RUNIC_AXE.weaponId(), () -> new RunicAxeItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //RUNIC_BLADE
    public static final DeferredItem<RunicBladeItem> BRONZE_RUNIC_BLADE = ITEMS.register("bronze_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new RunicBladeItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<RunicBladeItem> GOLD_RUNIC_BLADE = ITEMS.register("gold_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new RunicBladeItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<RunicBladeItem> SILVER_RUNIC_BLADE = ITEMS.register("silver_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new RunicBladeItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<RunicBladeItem> IRON_RUNIC_BLADE = ITEMS.register("iron_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new RunicBladeItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<RunicBladeItem> STEEL_RUNIC_BLADE = ITEMS.register("steel_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new RunicBladeItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<RunicBladeItem> BISMUTH_RUNIC_BLADE = ITEMS.register("bismuth_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new RunicBladeItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<RunicBladeItem> DIAMOND_RUNIC_BLADE = ITEMS.register("diamond_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new RunicBladeItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<RunicBladeItem> NETHERITE_RUNIC_BLADE = ITEMS.register("netherite_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new RunicBladeItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<RunicBladeItem> TITANIUM_RUNIC_BLADE = ITEMS.register("titanium_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new RunicBladeItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<RunicBladeItem> IOLITE_RUNIC_BLADE = ITEMS.register("iolite_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new RunicBladeItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<RunicBladeItem> ALEXANDRITE_RUNIC_BLADE = ITEMS.register("alexandrite_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new RunicBladeItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<RunicBladeItem> ADAMANTITE_RUNIC_BLADE = ITEMS.register("adamantite_" + WeaponStats.RUNIC_BLADE.weaponId(), () -> new RunicBladeItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //RUNIC_BLASTER
    public static final DeferredItem<RunicBlasterItem> BRONZE_RUNIC_BLASTER = ITEMS.register("bronze_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new RunicBlasterItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<RunicBlasterItem> GOLD_RUNIC_BLASTER = ITEMS.register("gold_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new RunicBlasterItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<RunicBlasterItem> SILVER_RUNIC_BLASTER = ITEMS.register("silver_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new RunicBlasterItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<RunicBlasterItem> IRON_RUNIC_BLASTER = ITEMS.register("iron_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new RunicBlasterItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<RunicBlasterItem> STEEL_RUNIC_BLASTER = ITEMS.register("steel_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new RunicBlasterItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<RunicBlasterItem> BISMUTH_RUNIC_BLASTER = ITEMS.register("bismuth_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new RunicBlasterItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<RunicBlasterItem> DIAMOND_RUNIC_BLASTER = ITEMS.register("diamond_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new RunicBlasterItem(Tiers.DIAMOND,new Item.Properties()));
    public static final DeferredItem<RunicBlasterItem> NETHERITE_RUNIC_BLASTER = ITEMS.register("netherite_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new RunicBlasterItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<RunicBlasterItem> TITANIUM_RUNIC_BLASTER = ITEMS.register("titanium_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new RunicBlasterItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<RunicBlasterItem> IOLITE_RUNIC_BLASTER = ITEMS.register("iolite_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new RunicBlasterItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<RunicBlasterItem> ALEXANDRITE_RUNIC_BLASTER = ITEMS.register("alexandrite_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new RunicBlasterItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<RunicBlasterItem> ADAMANTITE_RUNIC_BLASTER = ITEMS.register("adamantite_" + WeaponStats.RUNIC_BLASTER.weaponId(), () -> new RunicBlasterItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //SCISSORS_SEPARATE
    public static final DeferredItem<SingleScissorSwordItem> BRONZE_SINGLE_SCISSORS_SWORD = ITEMS.register("bronze_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new SingleScissorSwordItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<SingleScissorSwordItem> GOLD_SINGLE_SCISSORS_SWORD = ITEMS.register("gold_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new SingleScissorSwordItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<SingleScissorSwordItem> SILVER_SINGLE_SCISSORS_SWORD = ITEMS.register("silver_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new SingleScissorSwordItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<SingleScissorSwordItem> IRON_SINGLE_SCISSORS_SWORD = ITEMS.register("iron_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new SingleScissorSwordItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<SingleScissorSwordItem> STEEL_SINGLE_SCISSORS_SWORD = ITEMS.register("steel_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new SingleScissorSwordItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<SingleScissorSwordItem> BISMUTH_SINGLE_SCISSORS_SWORD = ITEMS.register("bismuth_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new SingleScissorSwordItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<SingleScissorSwordItem> DIAMOND_SINGLE_SCISSORS_SWORD = ITEMS.register("diamond_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new SingleScissorSwordItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<SingleScissorSwordItem> NETHERITE_SINGLE_SCISSORS_SWORD = ITEMS.register("netherite_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new SingleScissorSwordItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<SingleScissorSwordItem> TITANIUM_SINGLE_SCISSORS_SWORD = ITEMS.register("titanium_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new SingleScissorSwordItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<SingleScissorSwordItem> IOLITE_SINGLE_SCISSORS_SWORD = ITEMS.register("iolite_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new SingleScissorSwordItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<SingleScissorSwordItem> ALEXANDRITE_SINGLE_SCISSORS_SWORD = ITEMS.register("alexandrite_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new SingleScissorSwordItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<SingleScissorSwordItem> ADAMANTITE_SINGLE_SCISSORS_SWORD = ITEMS.register("adamantite_" + WeaponStats.SINGLE_SCISSORS_SWORD.weaponId(), () -> new SingleScissorSwordItem(ModToolTiers.ADAMANTITE, new Item.Properties()));

    //SCISSORS_COMBINED
    public static final DeferredItem<ScissorsSwordItem> BRONZE_SCISSORS_SWORD = ITEMS.register("bronze_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new ScissorsSwordItem(YoaItems.BRONZE_SINGLE_SCISSORS_SWORD.toStack(), ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<ScissorsSwordItem> GOLD_SCISSORS_SWORD = ITEMS.register("gold_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new ScissorsSwordItem(YoaItems.GOLD_SINGLE_SCISSORS_SWORD.toStack(), Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<ScissorsSwordItem> SILVER_SCISSORS_SWORD = ITEMS.register("silver_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new ScissorsSwordItem(YoaItems.SILVER_SINGLE_SCISSORS_SWORD.toStack(), ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<ScissorsSwordItem> IRON_SCISSORS_SWORD = ITEMS.register("iron_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new ScissorsSwordItem(YoaItems.IRON_SINGLE_SCISSORS_SWORD.toStack(), Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<ScissorsSwordItem> STEEL_SCISSORS_SWORD = ITEMS.register("steel_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new ScissorsSwordItem(YoaItems.STEEL_SINGLE_SCISSORS_SWORD.toStack(), ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<ScissorsSwordItem> BISMUTH_SCISSORS_SWORD = ITEMS.register("bismuth_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new ScissorsSwordItem(YoaItems.BISMUTH_SINGLE_SCISSORS_SWORD.toStack(), ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<ScissorsSwordItem> DIAMOND_SCISSORS_SWORD = ITEMS.register("diamond_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new ScissorsSwordItem(YoaItems.DIAMOND_SINGLE_SCISSORS_SWORD.toStack(), Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<ScissorsSwordItem> NETHERITE_SCISSORS_SWORD = ITEMS.register("netherite_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new ScissorsSwordItem(YoaItems.NETHERITE_SINGLE_SCISSORS_SWORD.toStack(), Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<ScissorsSwordItem> TITANIUM_SCISSORS_SWORD = ITEMS.register("titanium_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new ScissorsSwordItem(YoaItems.TITANIUM_SINGLE_SCISSORS_SWORD.toStack(), ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<ScissorsSwordItem> IOLITE_SCISSORS_SWORD = ITEMS.register("iolite_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new ScissorsSwordItem(YoaItems.IOLITE_SINGLE_SCISSORS_SWORD.toStack(), ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<ScissorsSwordItem> ALEXANDRITE_SCISSORS_SWORD = ITEMS.register("alexandrite_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new ScissorsSwordItem(YoaItems.ALEXANDRITE_SINGLE_SCISSORS_SWORD.toStack(), ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<ScissorsSwordItem> ADAMANTITE_SCISSORS_SWORD = ITEMS.register("adamantite_" + WeaponStats.SCISSORS_SWORD.weaponId(), () -> new ScissorsSwordItem(YoaItems.ADAMANTITE_SINGLE_SCISSORS_SWORD.toStack(), ModToolTiers.ADAMANTITE, new Item.Properties()));

    //SCYTHE
    public static final DeferredItem<ScytheItem> BRONZE_SCYTHE = ITEMS.register("bronze_" + WeaponStats.SCYTHE.weaponId(), () -> new ScytheItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<ScytheItem> GOLD_SCYTHE = ITEMS.register("gold_" + WeaponStats.SCYTHE.weaponId(), () -> new ScytheItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<ScytheItem> SILVER_SCYTHE = ITEMS.register("silver_" + WeaponStats.SCYTHE.weaponId(), () -> new ScytheItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<ScytheItem> IRON_SCYTHE = ITEMS.register("iron_" + WeaponStats.SCYTHE.weaponId(), () -> new ScytheItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<ScytheItem> STEEL_SCYTHE = ITEMS.register("steel_" + WeaponStats.SCYTHE.weaponId(), () -> new ScytheItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<ScytheItem> BISMUTH_SCYTHE = ITEMS.register("bismuth_" + WeaponStats.SCYTHE.weaponId(), () -> new ScytheItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<ScytheItem> DIAMOND_SCYTHE = ITEMS.register("diamond_" + WeaponStats.SCYTHE.weaponId(), () -> new ScytheItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<ScytheItem> NETHERITE_SCYTHE = ITEMS.register("netherite_" + WeaponStats.SCYTHE.weaponId(), () -> new ScytheItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<ScytheItem> TITANIUM_SCYTHE = ITEMS.register("titanium_" + WeaponStats.SCYTHE.weaponId(), () -> new ScytheItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<ScytheItem> IOLITE_SCYTHE = ITEMS.register("iolite_" + WeaponStats.SCYTHE.weaponId(), () -> new ScytheItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<ScytheItem> ALEXANDRITE_SCYTHE = ITEMS.register("alexandrite_" + WeaponStats.SCYTHE.weaponId(), () -> new ScytheItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<ScytheItem> ADAMANTITE_SCYTHE = ITEMS.register("adamantite_" + WeaponStats.SCYTHE.weaponId(), () -> new ScytheItem(ModToolTiers.ADAMANTITE, new Item.Properties()));

/*
    //SHOTGUN_SHIELD
    public static final DeferredItem<ShotgunShieldWeapon> BRONZE_SHOTGUN_SHIELD = ITEMS.register("bronze_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new ShotgunShieldWeapon(ModToolTiers.BRONZE,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<ShotgunShieldWeapon> GOLD_SHOTGUN_SHIELD = ITEMS.register("gold_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new ShotgunShieldWeapon(Tiers.GOLD,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<ShotgunShieldWeapon> SILVER_SHOTGUN_SHIELD = ITEMS.register("silver_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new ShotgunShieldWeapon(ModToolTiers.SILVER,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<ShotgunShieldWeapon> IRON_SHOTGUN_SHIELD = ITEMS.register("iron_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new ShotgunShieldWeapon(Tiers.IRON,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<ShotgunShieldWeapon> STEEL_SHOTGUN_SHIELD = ITEMS.register("steel_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new ShotgunShieldWeapon(ModToolTiers.STEEL,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<ShotgunShieldWeapon> BISMUTH_SHOTGUN_SHIELD = ITEMS.register("bismuth_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new ShotgunShieldWeapon(ModToolTiers.BISMUTH,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<ShotgunShieldWeapon> DIAMOND_SHOTGUN_SHIELD = ITEMS.register("diamond_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new ShotgunShieldWeapon(Tiers.DIAMOND,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<ShotgunShieldWeapon> NETHERITE_SHOTGUN_SHIELD = ITEMS.register("netherite_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new ShotgunShieldWeapon(Tiers.NETHERITE,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties().fireResistant()));
    public static final DeferredItem<ShotgunShieldWeapon> TITANIUM_SHOTGUN_SHIELD = ITEMS.register("titanium_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new ShotgunShieldWeapon(ModToolTiers.TITANIUM,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<ShotgunShieldWeapon> IOLITE_SHOTGUN_SHIELD = ITEMS.register("iolite_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new ShotgunShieldWeapon(ModToolTiers.IOLITE,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<ShotgunShieldWeapon> ALEXANDRITE_SHOTGUN_SHIELD = ITEMS.register("alexandrite_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new ShotgunShieldWeapon(ModToolTiers.ALEXANDRITE,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
    public static final DeferredItem<ShotgunShieldWeapon> ADAMANTITE_SHOTGUN_SHIELD = ITEMS.register("adamantite_" + WeaponStats.SHOTGUN_SHIELD.weaponId(), () -> new ShotgunShieldWeapon(ModToolTiers.ADAMANTITE,WeaponStats.SHOTGUN_SHIELD.attackDmg(),WeaponStats.SHOTGUN_SHIELD.attackSpeed(), WeaponStats.SHOTGUN_SHIELD.range(), new Item.Properties()));
*/

    //SHURIKEN
    public static final DeferredItem<ShurikenItem> BRONZE_SHURIKEN = ITEMS.register("bronze_" + WeaponStats.SHURIKEN.weaponId(), () -> new ShurikenItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<ShurikenItem> GOLD_SHURIKEN = ITEMS.register("gold_" + WeaponStats.SHURIKEN.weaponId(), () -> new ShurikenItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<ShurikenItem> SILVER_SHURIKEN = ITEMS.register("silver_" + WeaponStats.SHURIKEN.weaponId(), () -> new ShurikenItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<ShurikenItem> IRON_SHURIKEN = ITEMS.register("iron_" + WeaponStats.SHURIKEN.weaponId(), () -> new ShurikenItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<ShurikenItem> STEEL_SHURIKEN = ITEMS.register("steel_" + WeaponStats.SHURIKEN.weaponId(), () -> new ShurikenItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<ShurikenItem> BISMUTH_SHURIKEN = ITEMS.register("bismuth_" + WeaponStats.SHURIKEN.weaponId(), () -> new ShurikenItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<ShurikenItem> DIAMOND_SHURIKEN = ITEMS.register("diamond_" + WeaponStats.SHURIKEN.weaponId(), () -> new ShurikenItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<ShurikenItem> NETHERITE_SHURIKEN = ITEMS.register("netherite_" + WeaponStats.SHURIKEN.weaponId(), () -> new ShurikenItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<ShurikenItem> TITANIUM_SHURIKEN = ITEMS.register("titanium_" + WeaponStats.SHURIKEN.weaponId(), () -> new ShurikenItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<ShurikenItem> IOLITE_SHURIKEN = ITEMS.register("iolite_" + WeaponStats.SHURIKEN.weaponId(), () -> new ShurikenItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<ShurikenItem> ALEXANDRITE_SHURIKEN = ITEMS.register("alexandrite_" + WeaponStats.SHURIKEN.weaponId(), () -> new ShurikenItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<ShurikenItem> ADAMANTITE_SHURIKEN = ITEMS.register("adamantite_" + WeaponStats.SHURIKEN.weaponId(), () -> new ShurikenItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //SPELLCASTER_STAFF
    public static final DeferredItem<SpellcasterStaffItem> BRONZE_SPELLCASTER_STAFF = ITEMS.register("bronze_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new SpellcasterStaffItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<SpellcasterStaffItem> GOLD_SPELLCASTER_STAFF = ITEMS.register("gold_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new SpellcasterStaffItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<SpellcasterStaffItem> SILVER_SPELLCASTER_STAFF = ITEMS.register("silver_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new SpellcasterStaffItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<SpellcasterStaffItem> IRON_SPELLCASTER_STAFF = ITEMS.register("iron_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new SpellcasterStaffItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<SpellcasterStaffItem> STEEL_SPELLCASTER_STAFF = ITEMS.register("steel_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new SpellcasterStaffItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<SpellcasterStaffItem> BISMUTH_SPELLCASTER_STAFF = ITEMS.register("bismuth_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new SpellcasterStaffItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<SpellcasterStaffItem> DIAMOND_SPELLCASTER_STAFF = ITEMS.register("diamond_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new SpellcasterStaffItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<SpellcasterStaffItem> NETHERITE_SPELLCASTER_STAFF = ITEMS.register("netherite_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new SpellcasterStaffItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<SpellcasterStaffItem> TITANIUM_SPELLCASTER_STAFF = ITEMS.register("titanium_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new SpellcasterStaffItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<SpellcasterStaffItem> IOLITE_SPELLCASTER_STAFF = ITEMS.register("iolite_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new SpellcasterStaffItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<SpellcasterStaffItem> ALEXANDRITE_SPELLCASTER_STAFF = ITEMS.register("alexandrite_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new SpellcasterStaffItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<SpellcasterStaffItem> ADAMANTITE_SPELLCASTER_STAFF = ITEMS.register("adamantite_" + WeaponStats.SPELLCASTER_STAFF.weaponId(), () -> new SpellcasterStaffItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //TALISMAN
    public static final DeferredItem<TalismanItem> BRONZE_TALISMAN = ITEMS.register("bronze_" + WeaponStats.TALISMAN.weaponId(), () -> new TalismanItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<TalismanItem> GOLD_TALISMAN = ITEMS.register("gold_" + WeaponStats.TALISMAN.weaponId(), () -> new TalismanItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<TalismanItem> SILVER_TALISMAN = ITEMS.register("silver_" + WeaponStats.TALISMAN.weaponId(), () -> new TalismanItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<TalismanItem> IRON_TALISMAN = ITEMS.register("iron_" + WeaponStats.TALISMAN.weaponId(), () -> new TalismanItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<TalismanItem> STEEL_TALISMAN = ITEMS.register("steel_" + WeaponStats.TALISMAN.weaponId(), () -> new TalismanItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<TalismanItem> BISMUTH_TALISMAN = ITEMS.register("bismuth_" + WeaponStats.TALISMAN.weaponId(), () -> new TalismanItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<TalismanItem> DIAMOND_TALISMAN = ITEMS.register("diamond_" + WeaponStats.TALISMAN.weaponId(), () -> new TalismanItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<TalismanItem> NETHERITE_TALISMAN = ITEMS.register("netherite_" + WeaponStats.TALISMAN.weaponId(), () -> new TalismanItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<TalismanItem> TITANIUM_TALISMAN = ITEMS.register("titanium_" + WeaponStats.TALISMAN.weaponId(), () -> new TalismanItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<TalismanItem> IOLITE_TALISMAN = ITEMS.register("iolite_" + WeaponStats.TALISMAN.weaponId(), () -> new TalismanItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<TalismanItem> ALEXANDRITE_TALISMAN = ITEMS.register("alexandrite_" + WeaponStats.TALISMAN.weaponId(), () -> new TalismanItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<TalismanItem> ADAMANTITE_TALISMAN = ITEMS.register("adamantite_" + WeaponStats.TALISMAN.weaponId(), () -> new TalismanItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //THROWING_KNIFE
    public static final DeferredItem<ThrowingKnifeItem> BRONZE_THROWING_KNIFE = ITEMS.register("bronze_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new ThrowingKnifeItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<ThrowingKnifeItem> GOLD_THROWING_KNIFE = ITEMS.register("gold_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new ThrowingKnifeItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<ThrowingKnifeItem> SILVER_THROWING_KNIFE = ITEMS.register("silver_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new ThrowingKnifeItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<ThrowingKnifeItem> IRON_THROWING_KNIFE = ITEMS.register("iron_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new ThrowingKnifeItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<ThrowingKnifeItem> STEEL_THROWING_KNIFE = ITEMS.register("steel_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new ThrowingKnifeItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<ThrowingKnifeItem> BISMUTH_THROWING_KNIFE = ITEMS.register("bismuth_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new ThrowingKnifeItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<ThrowingKnifeItem> DIAMOND_THROWING_KNIFE = ITEMS.register("diamond_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new ThrowingKnifeItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<ThrowingKnifeItem> NETHERITE_THROWING_KNIFE = ITEMS.register("netherite_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new ThrowingKnifeItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<ThrowingKnifeItem> TITANIUM_THROWING_KNIFE = ITEMS.register("titanium_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new ThrowingKnifeItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<ThrowingKnifeItem> IOLITE_THROWING_KNIFE = ITEMS.register("iolite_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new ThrowingKnifeItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<ThrowingKnifeItem> ALEXANDRITE_THROWING_KNIFE = ITEMS.register("alexandrite_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new ThrowingKnifeItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<ThrowingKnifeItem> ADAMANTITE_THROWING_KNIFE = ITEMS.register("adamantite_" + WeaponStats.THROWING_KNIFE.weaponId(), () -> new ThrowingKnifeItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //TOME
    public static final DeferredItem<TomeItem> BRONZE_TOME = ITEMS.register("bronze_" + WeaponStats.TOME.weaponId(), () -> new TomeItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<TomeItem> GOLD_TOME = ITEMS.register("gold_" + WeaponStats.TOME.weaponId(), () -> new TomeItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<TomeItem> SILVER_TOME = ITEMS.register("silver_" + WeaponStats.TOME.weaponId(), () -> new TomeItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<TomeItem> IRON_TOME = ITEMS.register("iron_" + WeaponStats.TOME.weaponId(), () -> new TomeItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<TomeItem> STEEL_TOME = ITEMS.register("steel_" + WeaponStats.TOME.weaponId(), () -> new TomeItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<TomeItem> BISMUTH_TOME = ITEMS.register("bismuth_" + WeaponStats.TOME.weaponId(), () -> new TomeItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<TomeItem> DIAMOND_TOME = ITEMS.register("diamond_" + WeaponStats.TOME.weaponId(), () -> new TomeItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<TomeItem> NETHERITE_TOME = ITEMS.register("netherite_" + WeaponStats.TOME.weaponId(), () -> new TomeItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<TomeItem> TITANIUM_TOME = ITEMS.register("titanium_" + WeaponStats.TOME.weaponId(), () -> new TomeItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<TomeItem> IOLITE_TOME = ITEMS.register("iolite_" + WeaponStats.TOME.weaponId(), () -> new TomeItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<TomeItem> ALEXANDRITE_TOME = ITEMS.register("alexandrite_" + WeaponStats.TOME.weaponId(), () -> new TomeItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<TomeItem> ADAMANTITE_TOME = ITEMS.register("adamantite_" + WeaponStats.TOME.weaponId(), () -> new TomeItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


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
    public static final DeferredItem<WhipSwordItem> BRONZE_WHIP_SWORD = ITEMS.register("bronze_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WhipSwordItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final DeferredItem<WhipSwordItem> GOLD_WHIP_SWORD = ITEMS.register("gold_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WhipSwordItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<WhipSwordItem> SILVER_WHIP_SWORD = ITEMS.register("silver_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WhipSwordItem(ModToolTiers.SILVER, new Item.Properties()));
    public static final DeferredItem<WhipSwordItem> IRON_WHIP_SWORD = ITEMS.register("iron_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WhipSwordItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<WhipSwordItem> STEEL_WHIP_SWORD = ITEMS.register("steel_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WhipSwordItem(ModToolTiers.STEEL, new Item.Properties()));
    public static final DeferredItem<WhipSwordItem> BISMUTH_WHIP_SWORD = ITEMS.register("bismuth_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WhipSwordItem(ModToolTiers.BISMUTH, new Item.Properties()));
    public static final DeferredItem<WhipSwordItem> DIAMOND_WHIP_SWORD = ITEMS.register("diamond_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WhipSwordItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<WhipSwordItem> NETHERITE_WHIP_SWORD = ITEMS.register("netherite_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WhipSwordItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<WhipSwordItem> TITANIUM_WHIP_SWORD = ITEMS.register("titanium_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WhipSwordItem(ModToolTiers.TITANIUM, new Item.Properties()));
    public static final DeferredItem<WhipSwordItem> IOLITE_WHIP_SWORD = ITEMS.register("iolite_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WhipSwordItem(ModToolTiers.IOLITE, new Item.Properties()));
    public static final DeferredItem<WhipSwordItem> ALEXANDRITE_WHIP_SWORD = ITEMS.register("alexandrite_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WhipSwordItem(ModToolTiers.ALEXANDRITE, new Item.Properties()));
    public static final DeferredItem<WhipSwordItem> ADAMANTITE_WHIP_SWORD = ITEMS.register("adamantite_" + WeaponStats.WHIP_SWORD.weaponId(), () -> new WhipSwordItem(ModToolTiers.ADAMANTITE, new Item.Properties()));


    //EDIBLES

    public static final DeferredItem<Item> ETHERFRUCTUS = ITEMS.register("etherfructus", () -> new Item(new Item.Properties().food(YoaFoods.ETHERFRUCTUS)){
        @Override
        public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
            if (pLivingEntity instanceof Player player){
                IMana iMana = ManaHelper.getManaData(player);
                iMana.addMana(8);
            }
            return super.finishUsingItem(pStack, pLevel, pLivingEntity);
        }
    });


    //SPAWN EGGS
    public static final DeferredItem<Item> BRAWLER_SPAWN_EGG =  ITEMS.register("brawler_spawn_egg",
            () -> new DeferredSpawnEggItem(YoaEntityTypes.BRAWLER_TYPE::get,0x2E3236,0x2F3840,new Item.Properties()));

    public static final DeferredItem<Item> BRAWLING_SPAWN_EGG =  ITEMS.register("brawling_spawn_egg",
            () -> new DeferredSpawnEggItem(YoaEntityTypes.BRAWLING_TYPE::get,0x2F3250,0x79717B,new Item.Properties()));

    public static final DeferredItem<Item> BLOCKLING_SPAWN_EGG =  ITEMS.register("blockling_spawn_egg",
            () -> new DeferredSpawnEggItem(YoaEntityTypes.BLOCKLING_TYPE::get,0x71A35F,0x71BFA7,new Item.Properties()));

    public static final DeferredItem<Item> ARMED_SPIDER_SPAWN_EGG =  ITEMS.register("armed_spider_spawn_egg",
            () -> new DeferredSpawnEggItem(YoaEntityTypes.ARMED_SPIDER_TYPE::get,0x908554,0xDBDF9C,new Item.Properties()));

    public static final DeferredItem<Item> FALLEN_SAMURAI_SPAWN_EGG =  ITEMS.register("fallen_samurai_spawn_egg",
            () -> new DeferredSpawnEggItem(YoaEntityTypes.FALLEN_SAMURAI::get,0x65706E,0x74606E,new Item.Properties()));

    public static final DeferredItem<Item> FENNEC_FOX_SPAWN_EGG =  ITEMS.register("fennec_fox_spawn_egg",
            () -> new DeferredSpawnEggItem(YoaEntityTypes.FENNEC_FOX_TYPE::get,0xe3d5bd,0x564a3e,new Item.Properties()));





    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
