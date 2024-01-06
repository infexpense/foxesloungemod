package com.fuyuvulpes.yoamod.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class CreativeTabRegistry {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);



    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> YOA_MAIN = TABS.register("yoa_main", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.OP_BLOCKS)
            .icon(BlocksModReg.HAMMERING_STATION.asItem()::getDefaultInstance)
            .title(Component.translatable("itemGroup.yoa_main"))

            .displayItems((parameters, output) -> {

                BlocksModReg.BLOCKS.getEntries().forEach(blockDeferredHolder -> {
                    output.accept(blockDeferredHolder.get());
                });


                output.accept(ItemsModReg.ADAMANTITE_INGOT.get());
                output.accept(ItemsModReg.ADAMANTITE_NUGGET.get());
                output.accept(ItemsModReg.RAW_ADAMANTITE.get());
                output.accept(ItemsModReg.ALEXANDRITE.get());
                output.accept(ItemsModReg.ALEXANDRITE_SHARD.get());
                output.accept(ItemsModReg.BISMUTH.get());
                output.accept(ItemsModReg.BISMUTH_SHARD.get());
                output.accept(ItemsModReg.RAW_BISMUTH.get());
                output.accept(ItemsModReg.BRASS_INGOT.get());
                output.accept(ItemsModReg.BRASS_NUGGET.get());
                output.accept(ItemsModReg.BRONZE_INGOT.get());
                output.accept(ItemsModReg.BRONZE_NUGGET.get());
                output.accept(ItemsModReg.IOLITE.get());
                output.accept(ItemsModReg.IOLITE_SHARD.get());
                output.accept(ItemsModReg.SILVER_INGOT.get());
                output.accept(ItemsModReg.SILVER_NUGGET.get());
                output.accept(ItemsModReg.RAW_SILVER.get());
                output.accept(ItemsModReg.STEEL_INGOT.get());
                output.accept(ItemsModReg.STEEL_NUGGET.get());
                output.accept(ItemsModReg.TITANIUM_INGOT.get());
                output.accept(ItemsModReg.TITANIUM_NUGGET.get());
                output.accept(ItemsModReg.RAW_TITANIUM.get());
                output.accept(ItemsModReg.WITHERITE.get());
                output.accept(ItemsModReg.WITHERITE_SHARD.get());
                output.accept(ItemsModReg.DIAMOND_SHARD.get());
                output.accept(ItemsModReg.NETHERITE_NUGGET.get());


            }).build());



    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> YOA_WORLDGEN = TABS.register("yoa_wgen", () -> CreativeModeTab.builder()
            .withTabsBefore(YOA_MAIN.getKey())
            .icon(BlocksModReg.IOLITE_ORE.asItem()::getDefaultInstance)
            .title(Component.translatable("itemGroup.yoa_wgen"))
            .displayItems((parameters, output) -> {

                output.accept(BlocksModReg.CREAKSTONE);
                output.accept(BlocksModReg.CREAKSTONE_FRACTURE);
                output.accept(BlocksModReg.OVERGROWN_CREAKSTONE);
                output.accept(BlocksModReg.CRYSTALIC_REMNANTS);
                output.accept(BlocksModReg.POINTED_CREAKSTONE);


                output.accept(BlocksModReg.CREAKSTONE_IRON_ORE);
                output.accept(BlocksModReg.CREAKSTONE_DIAMOND_ORE);
                output.accept(BlocksModReg.SILVER_ORE);
                output.accept(BlocksModReg.DEEPSLATE_SILVER_ORE);
                output.accept(BlocksModReg.TITANIUM_ORE);
                output.accept(BlocksModReg.DEEPSLATE_TITANIUM_ORE);
                output.accept(BlocksModReg.CREAKSTONE_TITANIUM_ORE);
                output.accept(BlocksModReg.BISMUTH_ORE);
                output.accept(BlocksModReg.DEEPSLATE_BISMUTH_ORE);
                output.accept(BlocksModReg.WITHERITE_ORE);
                output.accept(BlocksModReg.IOLITE_ORE);
                output.accept(BlocksModReg.ALEXANDRITE_ORE);
                output.accept(BlocksModReg.ADAMANTITE_ORE);

            }).build());


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> YOA_GEAR = TABS.register("yoa_tools_gear", () -> CreativeModeTab.builder()
            .withTabsBefore(YOA_WORLDGEN.getKey())
            .icon(ItemsModReg.TITANIUM_PICKAXE.get()::getDefaultInstance)
            .title(Component.translatable("itemGroup.yoa_tools_gear"))
            .displayItems((parameters, output) -> {

                output.accept(ItemsModReg.TITANIUM_AXE.get());
                output.accept(ItemsModReg.TITANIUM_PICKAXE.get());
                output.accept(ItemsModReg.TITANIUM_HOE.get());
                output.accept(ItemsModReg.TITANIUM_SHOVEL.get());

                output.accept(ItemsModReg.IOLITE_AXE.get());
                output.accept(ItemsModReg.IOLITE_PICKAXE.get());
                output.accept(ItemsModReg.IOLITE_HOE.get());
                output.accept(ItemsModReg.IOLITE_SHOVEL.get());

                output.accept(ItemsModReg.ALEXANDRITE_AXE.get());
                output.accept(ItemsModReg.ALEXANDRITE_PICKAXE.get());
                output.accept(ItemsModReg.ALEXANDRITE_HOE.get());
                output.accept(ItemsModReg.ALEXANDRITE_SHOVEL.get());

                output.accept(ItemsModReg.ADAMANTITE_AXE.get());
                output.accept(ItemsModReg.ADAMANTITE_PICKAXE.get());
                output.accept(ItemsModReg.ADAMANTITE_HOE.get());
                output.accept(ItemsModReg.ADAMANTITE_SHOVEL.get());
            }).build());





    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> YOA_WEAPONS = TABS.register("yoa_weapons", () -> CreativeModeTab.builder()
            .withTabsBefore(YOA_GEAR.getKey())
            .icon(ItemsModReg.ADAMANTITE_GREAT_AXE.get()::getDefaultInstance)
            .title(Component.translatable("itemGroup.yoa_weapons"))
            .displayItems((parameters, output) -> {

                output.accept(ItemsModReg.LONGBOW.get());


                output.accept(ItemsModReg.SILVER_BELL.get());
                output.accept(ItemsModReg.GOLD_BELL.get());
                output.accept(ItemsModReg.BRONZE_BELL.get());
                output.accept(ItemsModReg.IRON_BELL.get());
                output.accept(ItemsModReg.STEEL_BELL.get());
                output.accept(ItemsModReg.BISMUTH_BELL.get());
                output.accept(ItemsModReg.DIAMOND_BELL.get());
                output.accept(ItemsModReg.NETHERITE_BELL.get());
                output.accept(ItemsModReg.TITANIUM_BELL.get());
                output.accept(ItemsModReg.IOLITE_BELL.get());
                output.accept(ItemsModReg.ALEXANDRITE_BELL.get());
                output.accept(ItemsModReg.ADAMANTITE_BELL.get());
                output.accept(ItemsModReg.SILVER_BLOW_DART.get());
                output.accept(ItemsModReg.GOLD_BLOW_DART.get());
                output.accept(ItemsModReg.BRONZE_BLOW_DART.get());
                output.accept(ItemsModReg.IRON_BLOW_DART.get());
                output.accept(ItemsModReg.STEEL_BLOW_DART.get());
                output.accept(ItemsModReg.BISMUTH_BLOW_DART.get());
                output.accept(ItemsModReg.DIAMOND_BLOW_DART.get());
                output.accept(ItemsModReg.NETHERITE_BLOW_DART.get());
                output.accept(ItemsModReg.TITANIUM_BLOW_DART.get());
                output.accept(ItemsModReg.IOLITE_BLOW_DART.get());
                output.accept(ItemsModReg.ALEXANDRITE_BLOW_DART.get());
                output.accept(ItemsModReg.ADAMANTITE_BLOW_DART.get());
                output.accept(ItemsModReg.SILVER_BOOMERANG.get());
                output.accept(ItemsModReg.GOLD_BOOMERANG.get());
                output.accept(ItemsModReg.BRONZE_BOOMERANG.get());
                output.accept(ItemsModReg.IRON_BOOMERANG.get());
                output.accept(ItemsModReg.STEEL_BOOMERANG.get());
                output.accept(ItemsModReg.BISMUTH_BOOMERANG.get());
                output.accept(ItemsModReg.DIAMOND_BOOMERANG.get());
                output.accept(ItemsModReg.NETHERITE_BOOMERANG.get());
                output.accept(ItemsModReg.TITANIUM_BOOMERANG.get());
                output.accept(ItemsModReg.IOLITE_BOOMERANG.get());
                output.accept(ItemsModReg.ALEXANDRITE_BOOMERANG.get());
                output.accept(ItemsModReg.ADAMANTITE_BOOMERANG.get());
                output.accept(ItemsModReg.SILVER_CHAKRAM.get());
                output.accept(ItemsModReg.GOLD_CHAKRAM.get());
                output.accept(ItemsModReg.BRONZE_CHAKRAM.get());
                output.accept(ItemsModReg.IRON_CHAKRAM.get());
                output.accept(ItemsModReg.STEEL_CHAKRAM.get());
                output.accept(ItemsModReg.BISMUTH_CHAKRAM.get());
                output.accept(ItemsModReg.DIAMOND_CHAKRAM.get());
                output.accept(ItemsModReg.NETHERITE_CHAKRAM.get());
                output.accept(ItemsModReg.TITANIUM_CHAKRAM.get());
                output.accept(ItemsModReg.IOLITE_CHAKRAM.get());
                output.accept(ItemsModReg.ALEXANDRITE_CHAKRAM.get());
                output.accept(ItemsModReg.ADAMANTITE_CHAKRAM.get());
                output.accept(ItemsModReg.SILVER_CLAWS.get());
                output.accept(ItemsModReg.GOLD_CLAWS.get());
                output.accept(ItemsModReg.BRONZE_CLAWS.get());
                output.accept(ItemsModReg.IRON_CLAWS.get());
                output.accept(ItemsModReg.STEEL_CLAWS.get());
                output.accept(ItemsModReg.BISMUTH_CLAWS.get());
                output.accept(ItemsModReg.DIAMOND_CLAWS.get());
                output.accept(ItemsModReg.NETHERITE_CLAWS.get());
                output.accept(ItemsModReg.TITANIUM_CLAWS.get());
                output.accept(ItemsModReg.IOLITE_CLAWS.get());
                output.accept(ItemsModReg.ALEXANDRITE_CLAWS.get());
                output.accept(ItemsModReg.ADAMANTITE_CLAWS.get());
                output.accept(ItemsModReg.SILVER_CLAYMORE.get());
                output.accept(ItemsModReg.GOLD_CLAYMORE.get());
                output.accept(ItemsModReg.BRONZE_CLAYMORE.get());
                output.accept(ItemsModReg.IRON_CLAYMORE.get());
                output.accept(ItemsModReg.STEEL_CLAYMORE.get());
                output.accept(ItemsModReg.BISMUTH_CLAYMORE.get());
                output.accept(ItemsModReg.DIAMOND_CLAYMORE.get());
                output.accept(ItemsModReg.NETHERITE_CLAYMORE.get());
                output.accept(ItemsModReg.TITANIUM_CLAYMORE.get());
                output.accept(ItemsModReg.IOLITE_CLAYMORE.get());
                output.accept(ItemsModReg.ALEXANDRITE_CLAYMORE.get());
                output.accept(ItemsModReg.ADAMANTITE_CLAYMORE.get());
                output.accept(ItemsModReg.SILVER_DAGGER.get());
                output.accept(ItemsModReg.GOLD_DAGGER.get());
                output.accept(ItemsModReg.BRONZE_DAGGER.get());
                output.accept(ItemsModReg.IRON_DAGGER.get());
                output.accept(ItemsModReg.STEEL_DAGGER.get());
                output.accept(ItemsModReg.BISMUTH_DAGGER.get());
                output.accept(ItemsModReg.DIAMOND_DAGGER.get());
                output.accept(ItemsModReg.NETHERITE_DAGGER.get());
                output.accept(ItemsModReg.TITANIUM_DAGGER.get());
                output.accept(ItemsModReg.IOLITE_DAGGER.get());
                output.accept(ItemsModReg.ALEXANDRITE_DAGGER.get());
                output.accept(ItemsModReg.ADAMANTITE_DAGGER.get());
                output.accept(ItemsModReg.SILVER_GREAT_AXE.get());
                output.accept(ItemsModReg.GOLD_GREAT_AXE.get());
                output.accept(ItemsModReg.BRONZE_GREAT_AXE.get());
                output.accept(ItemsModReg.IRON_GREAT_AXE.get());
                output.accept(ItemsModReg.STEEL_GREAT_AXE.get());
                output.accept(ItemsModReg.BISMUTH_GREAT_AXE.get());
                output.accept(ItemsModReg.DIAMOND_GREAT_AXE.get());
                output.accept(ItemsModReg.NETHERITE_GREAT_AXE.get());
                output.accept(ItemsModReg.TITANIUM_GREAT_AXE.get());
                output.accept(ItemsModReg.IOLITE_GREAT_AXE.get());
                output.accept(ItemsModReg.ALEXANDRITE_GREAT_AXE.get());
                output.accept(ItemsModReg.ADAMANTITE_GREAT_AXE.get());
                output.accept(ItemsModReg.SILVER_HARPOON.get());
                output.accept(ItemsModReg.GOLD_HARPOON.get());
                output.accept(ItemsModReg.BRONZE_HARPOON.get());
                output.accept(ItemsModReg.IRON_HARPOON.get());
                output.accept(ItemsModReg.STEEL_HARPOON.get());
                output.accept(ItemsModReg.BISMUTH_HARPOON.get());
                output.accept(ItemsModReg.DIAMOND_HARPOON.get());
                output.accept(ItemsModReg.NETHERITE_HARPOON.get());
                output.accept(ItemsModReg.TITANIUM_HARPOON.get());
                output.accept(ItemsModReg.IOLITE_HARPOON.get());
                output.accept(ItemsModReg.ALEXANDRITE_HARPOON.get());
                output.accept(ItemsModReg.ADAMANTITE_HARPOON.get());
                output.accept(ItemsModReg.SILVER_HOLY_RIFLE.get());
                output.accept(ItemsModReg.GOLD_HOLY_RIFLE.get());
                output.accept(ItemsModReg.BRONZE_HOLY_RIFLE.get());
                output.accept(ItemsModReg.IRON_HOLY_RIFLE.get());
                output.accept(ItemsModReg.STEEL_HOLY_RIFLE.get());
                output.accept(ItemsModReg.BISMUTH_HOLY_RIFLE.get());
                output.accept(ItemsModReg.DIAMOND_HOLY_RIFLE.get());
                output.accept(ItemsModReg.NETHERITE_HOLY_RIFLE.get());
                output.accept(ItemsModReg.TITANIUM_HOLY_RIFLE.get());
                output.accept(ItemsModReg.IOLITE_HOLY_RIFLE.get());
                output.accept(ItemsModReg.ALEXANDRITE_HOLY_RIFLE.get());
                output.accept(ItemsModReg.ADAMANTITE_HOLY_RIFLE.get());
                output.accept(ItemsModReg.SILVER_KATANA.get());
                output.accept(ItemsModReg.GOLD_KATANA.get());
                output.accept(ItemsModReg.BRONZE_KATANA.get());
                output.accept(ItemsModReg.IRON_KATANA.get());
                output.accept(ItemsModReg.STEEL_KATANA.get());
                output.accept(ItemsModReg.BISMUTH_KATANA.get());
                output.accept(ItemsModReg.DIAMOND_KATANA.get());
                output.accept(ItemsModReg.NETHERITE_KATANA.get());
                output.accept(ItemsModReg.TITANIUM_KATANA.get());
                output.accept(ItemsModReg.IOLITE_KATANA.get());
                output.accept(ItemsModReg.ALEXANDRITE_KATANA.get());
                output.accept(ItemsModReg.ADAMANTITE_KATANA.get());
                output.accept(ItemsModReg.SILVER_LANCE.get());
                output.accept(ItemsModReg.GOLD_LANCE.get());
                output.accept(ItemsModReg.BRONZE_LANCE.get());
                output.accept(ItemsModReg.IRON_LANCE.get());
                output.accept(ItemsModReg.STEEL_LANCE.get());
                output.accept(ItemsModReg.BISMUTH_LANCE.get());
                output.accept(ItemsModReg.DIAMOND_LANCE.get());
                output.accept(ItemsModReg.NETHERITE_LANCE.get());
                output.accept(ItemsModReg.TITANIUM_LANCE.get());
                output.accept(ItemsModReg.IOLITE_LANCE.get());
                output.accept(ItemsModReg.ALEXANDRITE_LANCE.get());
                output.accept(ItemsModReg.ADAMANTITE_LANCE.get());
                output.accept(ItemsModReg.SILVER_LYRE.get());
                output.accept(ItemsModReg.GOLD_LYRE.get());
                output.accept(ItemsModReg.BRONZE_LYRE.get());
                output.accept(ItemsModReg.IRON_LYRE.get());
                output.accept(ItemsModReg.STEEL_LYRE.get());
                output.accept(ItemsModReg.BISMUTH_LYRE.get());
                output.accept(ItemsModReg.DIAMOND_LYRE.get());
                output.accept(ItemsModReg.NETHERITE_LYRE.get());
                output.accept(ItemsModReg.TITANIUM_LYRE.get());
                output.accept(ItemsModReg.IOLITE_LYRE.get());
                output.accept(ItemsModReg.ALEXANDRITE_LYRE.get());
                output.accept(ItemsModReg.ADAMANTITE_LYRE.get());
                output.accept(ItemsModReg.SILVER_MAGICIAN_WAND.get());
                output.accept(ItemsModReg.GOLD_MAGICIAN_WAND.get());
                output.accept(ItemsModReg.BRONZE_MAGICIAN_WAND.get());
                output.accept(ItemsModReg.IRON_MAGICIAN_WAND.get());
                output.accept(ItemsModReg.STEEL_MAGICIAN_WAND.get());
                output.accept(ItemsModReg.BISMUTH_MAGICIAN_WAND.get());
                output.accept(ItemsModReg.DIAMOND_MAGICIAN_WAND.get());
                output.accept(ItemsModReg.NETHERITE_MAGICIAN_WAND.get());
                output.accept(ItemsModReg.TITANIUM_MAGICIAN_WAND.get());
                output.accept(ItemsModReg.IOLITE_MAGICIAN_WAND.get());
                output.accept(ItemsModReg.ALEXANDRITE_MAGICIAN_WAND.get());
                output.accept(ItemsModReg.ADAMANTITE_MAGICIAN_WAND.get());
                output.accept(ItemsModReg.SILVER_RAPIER.get());
                output.accept(ItemsModReg.GOLD_RAPIER.get());
                output.accept(ItemsModReg.BRONZE_RAPIER.get());
                output.accept(ItemsModReg.IRON_RAPIER.get());
                output.accept(ItemsModReg.STEEL_RAPIER.get());
                output.accept(ItemsModReg.BISMUTH_RAPIER.get());
                output.accept(ItemsModReg.DIAMOND_RAPIER.get());
                output.accept(ItemsModReg.NETHERITE_RAPIER.get());
                output.accept(ItemsModReg.TITANIUM_RAPIER.get());
                output.accept(ItemsModReg.IOLITE_RAPIER.get());
                output.accept(ItemsModReg.ALEXANDRITE_RAPIER.get());
                output.accept(ItemsModReg.ADAMANTITE_RAPIER.get());
                output.accept(ItemsModReg.SILVER_RUNIC_AXE.get());
                output.accept(ItemsModReg.GOLD_RUNIC_AXE.get());
                output.accept(ItemsModReg.BRONZE_RUNIC_AXE.get());
                output.accept(ItemsModReg.IRON_RUNIC_AXE.get());
                output.accept(ItemsModReg.STEEL_RUNIC_AXE.get());
                output.accept(ItemsModReg.BISMUTH_RUNIC_AXE.get());
                output.accept(ItemsModReg.DIAMOND_RUNIC_AXE.get());
                output.accept(ItemsModReg.NETHERITE_RUNIC_AXE.get());
                output.accept(ItemsModReg.TITANIUM_RUNIC_AXE.get());
                output.accept(ItemsModReg.IOLITE_RUNIC_AXE.get());
                output.accept(ItemsModReg.ALEXANDRITE_RUNIC_AXE.get());
                output.accept(ItemsModReg.ADAMANTITE_RUNIC_AXE.get());
                output.accept(ItemsModReg.SILVER_RUNIC_BLADE.get());
                output.accept(ItemsModReg.GOLD_RUNIC_BLADE.get());
                output.accept(ItemsModReg.BRONZE_RUNIC_BLADE.get());
                output.accept(ItemsModReg.IRON_RUNIC_BLADE.get());
                output.accept(ItemsModReg.STEEL_RUNIC_BLADE.get());
                output.accept(ItemsModReg.BISMUTH_RUNIC_BLADE.get());
                output.accept(ItemsModReg.DIAMOND_RUNIC_BLADE.get());
                output.accept(ItemsModReg.NETHERITE_RUNIC_BLADE.get());
                output.accept(ItemsModReg.TITANIUM_RUNIC_BLADE.get());
                output.accept(ItemsModReg.IOLITE_RUNIC_BLADE.get());
                output.accept(ItemsModReg.ALEXANDRITE_RUNIC_BLADE.get());
                output.accept(ItemsModReg.ADAMANTITE_RUNIC_BLADE.get());
                output.accept(ItemsModReg.SILVER_RUNIC_BLASTER.get());
                output.accept(ItemsModReg.GOLD_RUNIC_BLASTER.get());
                output.accept(ItemsModReg.BRONZE_RUNIC_BLASTER.get());
                output.accept(ItemsModReg.IRON_RUNIC_BLASTER.get());
                output.accept(ItemsModReg.STEEL_RUNIC_BLASTER.get());
                output.accept(ItemsModReg.BISMUTH_RUNIC_BLASTER.get());
                output.accept(ItemsModReg.DIAMOND_RUNIC_BLASTER.get());
                output.accept(ItemsModReg.NETHERITE_RUNIC_BLASTER.get());
                output.accept(ItemsModReg.TITANIUM_RUNIC_BLASTER.get());
                output.accept(ItemsModReg.IOLITE_RUNIC_BLASTER.get());
                output.accept(ItemsModReg.ALEXANDRITE_RUNIC_BLASTER.get());
                output.accept(ItemsModReg.ADAMANTITE_RUNIC_BLASTER.get());
                output.accept(ItemsModReg.SILVER_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.GOLD_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.BRONZE_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.IRON_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.STEEL_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.BISMUTH_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.DIAMOND_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.NETHERITE_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.TITANIUM_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.IOLITE_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.ALEXANDRITE_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.ADAMANTITE_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.SILVER_SINGLE_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.GOLD_SINGLE_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.BRONZE_SINGLE_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.IRON_SINGLE_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.STEEL_SINGLE_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.BISMUTH_SINGLE_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.DIAMOND_SINGLE_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.NETHERITE_SINGLE_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.TITANIUM_SINGLE_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.IOLITE_SINGLE_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.ALEXANDRITE_SINGLE_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.ADAMANTITE_SINGLE_SCISSORS_SWORD.get());
                output.accept(ItemsModReg.SILVER_SCYTHE.get());
                output.accept(ItemsModReg.GOLD_SCYTHE.get());
                output.accept(ItemsModReg.BRONZE_SCYTHE.get());
                output.accept(ItemsModReg.IRON_SCYTHE.get());
                output.accept(ItemsModReg.STEEL_SCYTHE.get());
                output.accept(ItemsModReg.BISMUTH_SCYTHE.get());
                output.accept(ItemsModReg.DIAMOND_SCYTHE.get());
                output.accept(ItemsModReg.NETHERITE_SCYTHE.get());
                output.accept(ItemsModReg.TITANIUM_SCYTHE.get());
                output.accept(ItemsModReg.IOLITE_SCYTHE.get());
                output.accept(ItemsModReg.ALEXANDRITE_SCYTHE.get());
                output.accept(ItemsModReg.ADAMANTITE_SCYTHE.get());
                /*
                output.accept(ItemsModReg.SILVER_SHOTGUN_SHIELD.get());
                output.accept(ItemsModReg.GOLD_SHOTGUN_SHIELD.get());
                output.accept(ItemsModReg.BRONZE_SHOTGUN_SHIELD.get());
                output.accept(ItemsModReg.IRON_SHOTGUN_SHIELD.get());
                output.accept(ItemsModReg.STEEL_SHOTGUN_SHIELD.get());
                output.accept(ItemsModReg.BISMUTH_SHOTGUN_SHIELD.get());
                output.accept(ItemsModReg.DIAMOND_SHOTGUN_SHIELD.get());
                output.accept(ItemsModReg.NETHERITE_SHOTGUN_SHIELD.get());
                output.accept(ItemsModReg.TITANIUM_SHOTGUN_SHIELD.get());
                output.accept(ItemsModReg.IOLITE_SHOTGUN_SHIELD.get());
                output.accept(ItemsModReg.ALEXANDRITE_SHOTGUN_SHIELD.get());
                output.accept(ItemsModReg.ADAMANTITE_SHOTGUN_SHIELD.get());
                */
                output.accept(ItemsModReg.SILVER_SHURIKEN.get());
                output.accept(ItemsModReg.GOLD_SHURIKEN.get());
                output.accept(ItemsModReg.BRONZE_SHURIKEN.get());
                output.accept(ItemsModReg.IRON_SHURIKEN.get());
                output.accept(ItemsModReg.STEEL_SHURIKEN.get());
                output.accept(ItemsModReg.BISMUTH_SHURIKEN.get());
                output.accept(ItemsModReg.DIAMOND_SHURIKEN.get());
                output.accept(ItemsModReg.NETHERITE_SHURIKEN.get());
                output.accept(ItemsModReg.TITANIUM_SHURIKEN.get());
                output.accept(ItemsModReg.IOLITE_SHURIKEN.get());
                output.accept(ItemsModReg.ALEXANDRITE_SHURIKEN.get());
                output.accept(ItemsModReg.ADAMANTITE_SHURIKEN.get());
                output.accept(ItemsModReg.SILVER_SPELLCASTER_STAFF.get());
                output.accept(ItemsModReg.GOLD_SPELLCASTER_STAFF.get());
                output.accept(ItemsModReg.BRONZE_SPELLCASTER_STAFF.get());
                output.accept(ItemsModReg.IRON_SPELLCASTER_STAFF.get());
                output.accept(ItemsModReg.STEEL_SPELLCASTER_STAFF.get());
                output.accept(ItemsModReg.BISMUTH_SPELLCASTER_STAFF.get());
                output.accept(ItemsModReg.DIAMOND_SPELLCASTER_STAFF.get());
                output.accept(ItemsModReg.NETHERITE_SPELLCASTER_STAFF.get());
                output.accept(ItemsModReg.TITANIUM_SPELLCASTER_STAFF.get());
                output.accept(ItemsModReg.IOLITE_SPELLCASTER_STAFF.get());
                output.accept(ItemsModReg.ALEXANDRITE_SPELLCASTER_STAFF.get());
                output.accept(ItemsModReg.ADAMANTITE_SPELLCASTER_STAFF.get());
                output.accept(ItemsModReg.SILVER_TALISMAN.get());
                output.accept(ItemsModReg.GOLD_TALISMAN.get());
                output.accept(ItemsModReg.BRONZE_TALISMAN.get());
                output.accept(ItemsModReg.IRON_TALISMAN.get());
                output.accept(ItemsModReg.STEEL_TALISMAN.get());
                output.accept(ItemsModReg.BISMUTH_TALISMAN.get());
                output.accept(ItemsModReg.DIAMOND_TALISMAN.get());
                output.accept(ItemsModReg.NETHERITE_TALISMAN.get());
                output.accept(ItemsModReg.TITANIUM_TALISMAN.get());
                output.accept(ItemsModReg.IOLITE_TALISMAN.get());
                output.accept(ItemsModReg.ALEXANDRITE_TALISMAN.get());
                output.accept(ItemsModReg.ADAMANTITE_TALISMAN.get());
                output.accept(ItemsModReg.SILVER_THROWING_KNIFE.get());
                output.accept(ItemsModReg.GOLD_THROWING_KNIFE.get());
                output.accept(ItemsModReg.BRONZE_THROWING_KNIFE.get());
                output.accept(ItemsModReg.IRON_THROWING_KNIFE.get());
                output.accept(ItemsModReg.STEEL_THROWING_KNIFE.get());
                output.accept(ItemsModReg.BISMUTH_THROWING_KNIFE.get());
                output.accept(ItemsModReg.DIAMOND_THROWING_KNIFE.get());
                output.accept(ItemsModReg.NETHERITE_THROWING_KNIFE.get());
                output.accept(ItemsModReg.TITANIUM_THROWING_KNIFE.get());
                output.accept(ItemsModReg.IOLITE_THROWING_KNIFE.get());
                output.accept(ItemsModReg.ALEXANDRITE_THROWING_KNIFE.get());
                output.accept(ItemsModReg.ADAMANTITE_THROWING_KNIFE.get());
                output.accept(ItemsModReg.SILVER_TOME.get());
                output.accept(ItemsModReg.GOLD_TOME.get());
                output.accept(ItemsModReg.BRONZE_TOME.get());
                output.accept(ItemsModReg.IRON_TOME.get());
                output.accept(ItemsModReg.STEEL_TOME.get());
                output.accept(ItemsModReg.BISMUTH_TOME.get());
                output.accept(ItemsModReg.DIAMOND_TOME.get());
                output.accept(ItemsModReg.NETHERITE_TOME.get());
                output.accept(ItemsModReg.TITANIUM_TOME.get());
                output.accept(ItemsModReg.IOLITE_TOME.get());
                output.accept(ItemsModReg.ALEXANDRITE_TOME.get());
                output.accept(ItemsModReg.ADAMANTITE_TOME.get());
                output.accept(ItemsModReg.SILVER_WAR_FAN.get());
                output.accept(ItemsModReg.GOLD_WAR_FAN.get());
                output.accept(ItemsModReg.BRONZE_WAR_FAN.get());
                output.accept(ItemsModReg.IRON_WAR_FAN.get());
                output.accept(ItemsModReg.STEEL_WAR_FAN.get());
                output.accept(ItemsModReg.BISMUTH_WAR_FAN.get());
                output.accept(ItemsModReg.DIAMOND_WAR_FAN.get());
                output.accept(ItemsModReg.NETHERITE_WAR_FAN.get());
                output.accept(ItemsModReg.TITANIUM_WAR_FAN.get());
                output.accept(ItemsModReg.IOLITE_WAR_FAN.get());
                output.accept(ItemsModReg.ALEXANDRITE_WAR_FAN.get());
                output.accept(ItemsModReg.ADAMANTITE_WAR_FAN.get());
                output.accept(ItemsModReg.SILVER_WHIP_SWORD.get());
                output.accept(ItemsModReg.GOLD_WHIP_SWORD.get());
                output.accept(ItemsModReg.BRONZE_WHIP_SWORD.get());
                output.accept(ItemsModReg.IRON_WHIP_SWORD.get());
                output.accept(ItemsModReg.STEEL_WHIP_SWORD.get());
                output.accept(ItemsModReg.BISMUTH_WHIP_SWORD.get());
                output.accept(ItemsModReg.DIAMOND_WHIP_SWORD.get());
                output.accept(ItemsModReg.NETHERITE_WHIP_SWORD.get());
                output.accept(ItemsModReg.TITANIUM_WHIP_SWORD.get());
                output.accept(ItemsModReg.IOLITE_WHIP_SWORD.get());
                output.accept(ItemsModReg.ALEXANDRITE_WHIP_SWORD.get());
                output.accept(ItemsModReg.ADAMANTITE_WHIP_SWORD.get());            }).build());




    public static void register(IEventBus eventBus){
        TABS.register(eventBus);
    }

}
