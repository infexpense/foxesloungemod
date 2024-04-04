package com.fuyuvulpes.yoamod.core.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class YoaTabs {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);



    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> YOA_MAIN = TABS.register("yoa_main", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.OP_BLOCKS)
            .icon(YoaItems.RUNE_CRYSTAL.get()::getDefaultInstance)
            .title(Component.translatable("itemGroup.yoa_main"))

            .displayItems((parameters, output) -> {

                output.accept(YoaBlocks.HAMMERING_STATION.get());
                output.accept(YoaBlocks.CRUCIBLE.get());

                output.accept(YoaBlocks.BLISSWOOD_LOG.get());
                output.accept(YoaBlocks.STRIPPED_BLISSWOOD_LOG.get());
                output.accept(YoaBlocks.BLISSWOOD_WOOD.get());
                output.accept(YoaBlocks.STRIPPED_BLISSWOOD_WOOD.get());
                output.accept(YoaBlocks.BLISSWOOD_LEAVES.get());
                output.accept(YoaBlocks.BLISSWOOD_SAPLING.get());
                output.accept(YoaBlocks.BLISSWOOD_PLANKS.get());

                output.accept(YoaBlocks.BLISSWOOD_STAIRS.get());
                output.accept(YoaBlocks.BLISSWOOD_SLAB.get());
                output.accept(YoaBlocks.BLISSWOOD_FENCE.get());
                output.accept(YoaBlocks.BLISSWOOD_FENCE_GATE.get());

                output.accept(YoaItems.BLISSWOOD_SIGN.get());
                output.accept(YoaItems.BLISSWOOD_HANGING_SIGN.get());

                output.accept(YoaBlocks.BLISSWOOD_BUTTON.get());
                output.accept(YoaBlocks.BLISSWOOD_PRESSURE_PLATE.get());
                output.accept(YoaBlocks.BLISSWOOD_TRAPDOOR.get());
                output.accept(YoaBlocks.BLISSWOOD_DOOR.get());

                output.accept(YoaBlocks.CREAKSTONE.get());
                output.accept(YoaBlocks.CREAKSTONE_STAIRS.get());
                output.accept(YoaBlocks.CREAKSTONE_SLAB.get());
                output.accept(YoaBlocks.CREAKSTONE_WALL.get());

                output.accept(YoaBlocks.CREAKSTONE_TILES.get());
                output.accept(YoaBlocks.CREAKSTONE_TILES_STAIRS.get());
                output.accept(YoaBlocks.CREAKSTONE_TILES_SLAB.get());
                output.accept(YoaBlocks.CREAKSTONE_TILES_WALL.get());

                output.accept(YoaBlocks.CRYSTALIC_CREAKSTONE_TILES.get());
                output.accept(YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_STAIRS.get());
                output.accept(YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_SLAB.get());
                output.accept(YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_WALL.get());

                output.accept(YoaBlocks.OVERGROWN_CREAKSTONE.get());
                output.accept(YoaBlocks.POINTED_CREAKSTONE.get());
                output.accept(YoaBlocks.CREAKSTONE_FRACTURE.get());
                output.accept(YoaBlocks.CREAKS_GATE.get());

                output.accept(YoaBlocks.RUNE_CRYSTAL_CLUSTER.get());
                output.accept(YoaBlocks.RUNE_CRYSTAL_BLOCK.get());
                output.accept(YoaItems.CRYSTALIC_SHARD.get());
                output.accept(YoaBlocks.CRYSTALIC_REMNANTS.get());

                output.accept(YoaBlocks.ETHERFRLOS.get());

                output.accept(YoaBlocks.BRASS_BLOCK.get());
                output.accept(YoaBlocks.RAW_SILVER_BLOCK.get());
                output.accept(YoaBlocks.SILVER_BLOCK.get());
                output.accept(YoaBlocks.BRONZE_BLOCK.get());
                output.accept(YoaBlocks.STEEL_BLOCK.get());
                output.accept(YoaBlocks.RAW_BISMUTH_BLOCK.get());
                output.accept(YoaBlocks.BISMUTH_BLOCK.get());
                output.accept(YoaBlocks.RAW_TITANIUM_BLOCK.get());
                output.accept(YoaBlocks.TITANIUM_BLOCK.get());
                output.accept(YoaBlocks.WITHERITE_BLOCK.get());
                output.accept(YoaBlocks.IOLITE_BLOCK.get());
                output.accept(YoaBlocks.ALEXANDRITE_BLOCK.get());
                output.accept(YoaBlocks.RAW_ADAMANTITE_BLOCK.get());
                output.accept(YoaBlocks.ADAMANTITE_BLOCK.get());


                output.accept(YoaBlocks.HAUNTED_LAMP.get());





            }).build());



    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> YOA_WORLDGEN = TABS.register("yoa_wgen", () -> CreativeModeTab.builder()
            .withTabsBefore(YOA_MAIN.getKey())
            .icon(YoaBlocks.OVERGROWN_CREAKSTONE.asItem()::getDefaultInstance)
            .title(Component.translatable("itemGroup.yoa_wgen"))
            .displayItems((parameters, output) -> {

                output.accept(YoaBlocks.BLISSWOOD_LOG.get());
                output.accept(YoaBlocks.BLISSWOOD_WOOD.get());
                output.accept(YoaBlocks.BLISSWOOD_LEAVES.get());
                output.accept(YoaBlocks.BLISSWOOD_SAPLING.get());


                output.accept(YoaBlocks.CREAKSTONE.get());

                output.accept(YoaBlocks.OVERGROWN_CREAKSTONE.get());
                output.accept(YoaBlocks.POINTED_CREAKSTONE.get());
                output.accept(YoaBlocks.CREAKSTONE_FRACTURE.get());

                output.accept(YoaBlocks.RUNE_CRYSTAL_CLUSTER.get());
                output.accept(YoaBlocks.RUNE_CRYSTAL_BLOCK.get());
                output.accept(YoaItems.CRYSTALIC_SHARD.get());
                output.accept(YoaBlocks.CRYSTALIC_REMNANTS.get());


                output.accept(YoaBlocks.ETHERFRLOS.get());

                output.accept(YoaBlocks.SILVER_ORE.get());
                output.accept(YoaBlocks.DEEPSLATE_SILVER_ORE.get());

                output.accept(YoaBlocks.CREAKSTONE_IRON_ORE.get());

                output.accept(YoaBlocks.BISMUTH_ORE.get());
                output.accept(YoaBlocks.DEEPSLATE_BISMUTH_ORE.get());

                output.accept(YoaBlocks.CREAKSTONE_DIAMOND_ORE.get());

                output.accept(YoaBlocks.TITANIUM_ORE.get());
                output.accept(YoaBlocks.DEEPSLATE_TITANIUM_ORE.get());
                output.accept(YoaBlocks.CREAKSTONE_TITANIUM_ORE.get());

                output.accept(YoaBlocks.WITHERITE_ORE.get());
                output.accept(YoaBlocks.IOLITE_ORE.get());
                output.accept(YoaBlocks.ALEXANDRITE_ORE.get());
                output.accept(YoaBlocks.ADAMANTITE_ORE.get());

                output.accept(YoaBlocks.RAW_SILVER_BLOCK.get());
                output.accept(YoaBlocks.RAW_TITANIUM_BLOCK.get());
                output.accept(YoaBlocks.RAW_ADAMANTITE_BLOCK.get());


            }).build());





    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> YOA_WEAPONS = TABS.register("yoa_weapons", () -> CreativeModeTab.builder()
            .withTabsBefore(YOA_WORLDGEN.getKey())
            .icon(YoaItems.ADAMANTITE_GREAT_AXE.get()::getDefaultInstance)
            .title(Component.translatable("itemGroup.yoa_weapons"))
            .displayItems((parameters, output) -> {

                output.accept(YoaItems.LONGBOW.get());


                output.accept(YoaItems.SILVER_BELL.get());
                output.accept(YoaItems.GOLD_BELL.get());
                output.accept(YoaItems.BRONZE_BELL.get());
                output.accept(YoaItems.IRON_BELL.get());
                output.accept(YoaItems.STEEL_BELL.get());
                output.accept(YoaItems.BISMUTH_BELL.get());
                output.accept(YoaItems.DIAMOND_BELL.get());
                output.accept(YoaItems.NETHERITE_BELL.get());
                output.accept(YoaItems.TITANIUM_BELL.get());
                output.accept(YoaItems.IOLITE_BELL.get());
                output.accept(YoaItems.ALEXANDRITE_BELL.get());
                output.accept(YoaItems.ADAMANTITE_BELL.get());
                output.accept(YoaItems.SILVER_BLOW_DART.get());
                output.accept(YoaItems.GOLD_BLOW_DART.get());
                output.accept(YoaItems.BRONZE_BLOW_DART.get());
                output.accept(YoaItems.IRON_BLOW_DART.get());
                output.accept(YoaItems.STEEL_BLOW_DART.get());
                output.accept(YoaItems.BISMUTH_BLOW_DART.get());
                output.accept(YoaItems.DIAMOND_BLOW_DART.get());
                output.accept(YoaItems.NETHERITE_BLOW_DART.get());
                output.accept(YoaItems.TITANIUM_BLOW_DART.get());
                output.accept(YoaItems.IOLITE_BLOW_DART.get());
                output.accept(YoaItems.ALEXANDRITE_BLOW_DART.get());
                output.accept(YoaItems.ADAMANTITE_BLOW_DART.get());
                output.accept(YoaItems.SILVER_BOOMERANG.get());
                output.accept(YoaItems.GOLD_BOOMERANG.get());
                output.accept(YoaItems.BRONZE_BOOMERANG.get());
                output.accept(YoaItems.IRON_BOOMERANG.get());
                output.accept(YoaItems.STEEL_BOOMERANG.get());
                output.accept(YoaItems.BISMUTH_BOOMERANG.get());
                output.accept(YoaItems.DIAMOND_BOOMERANG.get());
                output.accept(YoaItems.NETHERITE_BOOMERANG.get());
                output.accept(YoaItems.TITANIUM_BOOMERANG.get());
                output.accept(YoaItems.IOLITE_BOOMERANG.get());
                output.accept(YoaItems.ALEXANDRITE_BOOMERANG.get());
                output.accept(YoaItems.ADAMANTITE_BOOMERANG.get());
                output.accept(YoaItems.SILVER_CHAKRAM.get());
                output.accept(YoaItems.GOLD_CHAKRAM.get());
                output.accept(YoaItems.BRONZE_CHAKRAM.get());
                output.accept(YoaItems.IRON_CHAKRAM.get());
                output.accept(YoaItems.STEEL_CHAKRAM.get());
                output.accept(YoaItems.BISMUTH_CHAKRAM.get());
                output.accept(YoaItems.DIAMOND_CHAKRAM.get());
                output.accept(YoaItems.NETHERITE_CHAKRAM.get());
                output.accept(YoaItems.TITANIUM_CHAKRAM.get());
                output.accept(YoaItems.IOLITE_CHAKRAM.get());
                output.accept(YoaItems.ALEXANDRITE_CHAKRAM.get());
                output.accept(YoaItems.ADAMANTITE_CHAKRAM.get());
                output.accept(YoaItems.SILVER_CLAWS.get());
                output.accept(YoaItems.GOLD_CLAWS.get());
                output.accept(YoaItems.BRONZE_CLAWS.get());
                output.accept(YoaItems.IRON_CLAWS.get());
                output.accept(YoaItems.STEEL_CLAWS.get());
                output.accept(YoaItems.BISMUTH_CLAWS.get());
                output.accept(YoaItems.DIAMOND_CLAWS.get());
                output.accept(YoaItems.NETHERITE_CLAWS.get());
                output.accept(YoaItems.TITANIUM_CLAWS.get());
                output.accept(YoaItems.IOLITE_CLAWS.get());
                output.accept(YoaItems.ALEXANDRITE_CLAWS.get());
                output.accept(YoaItems.ADAMANTITE_CLAWS.get());
                output.accept(YoaItems.SILVER_CLAYMORE.get());
                output.accept(YoaItems.GOLD_CLAYMORE.get());
                output.accept(YoaItems.BRONZE_CLAYMORE.get());
                output.accept(YoaItems.IRON_CLAYMORE.get());
                output.accept(YoaItems.STEEL_CLAYMORE.get());
                output.accept(YoaItems.BISMUTH_CLAYMORE.get());
                output.accept(YoaItems.DIAMOND_CLAYMORE.get());
                output.accept(YoaItems.NETHERITE_CLAYMORE.get());
                output.accept(YoaItems.TITANIUM_CLAYMORE.get());
                output.accept(YoaItems.IOLITE_CLAYMORE.get());
                output.accept(YoaItems.ALEXANDRITE_CLAYMORE.get());
                output.accept(YoaItems.ADAMANTITE_CLAYMORE.get());
                output.accept(YoaItems.SILVER_DAGGER.get());
                output.accept(YoaItems.GOLD_DAGGER.get());
                output.accept(YoaItems.BRONZE_DAGGER.get());
                output.accept(YoaItems.IRON_DAGGER.get());
                output.accept(YoaItems.STEEL_DAGGER.get());
                output.accept(YoaItems.BISMUTH_DAGGER.get());
                output.accept(YoaItems.DIAMOND_DAGGER.get());
                output.accept(YoaItems.NETHERITE_DAGGER.get());
                output.accept(YoaItems.TITANIUM_DAGGER.get());
                output.accept(YoaItems.IOLITE_DAGGER.get());
                output.accept(YoaItems.ALEXANDRITE_DAGGER.get());
                output.accept(YoaItems.ADAMANTITE_DAGGER.get());
                output.accept(YoaItems.SILVER_GREAT_AXE.get());
                output.accept(YoaItems.GOLD_GREAT_AXE.get());
                output.accept(YoaItems.BRONZE_GREAT_AXE.get());
                output.accept(YoaItems.IRON_GREAT_AXE.get());
                output.accept(YoaItems.STEEL_GREAT_AXE.get());
                output.accept(YoaItems.BISMUTH_GREAT_AXE.get());
                output.accept(YoaItems.DIAMOND_GREAT_AXE.get());
                output.accept(YoaItems.NETHERITE_GREAT_AXE.get());
                output.accept(YoaItems.TITANIUM_GREAT_AXE.get());
                output.accept(YoaItems.IOLITE_GREAT_AXE.get());
                output.accept(YoaItems.ALEXANDRITE_GREAT_AXE.get());
                output.accept(YoaItems.ADAMANTITE_GREAT_AXE.get());
                output.accept(YoaItems.SILVER_HARPOON.get());
                output.accept(YoaItems.GOLD_HARPOON.get());
                output.accept(YoaItems.BRONZE_HARPOON.get());
                output.accept(YoaItems.IRON_HARPOON.get());
                output.accept(YoaItems.STEEL_HARPOON.get());
                output.accept(YoaItems.BISMUTH_HARPOON.get());
                output.accept(YoaItems.DIAMOND_HARPOON.get());
                output.accept(YoaItems.NETHERITE_HARPOON.get());
                output.accept(YoaItems.TITANIUM_HARPOON.get());
                output.accept(YoaItems.IOLITE_HARPOON.get());
                output.accept(YoaItems.ALEXANDRITE_HARPOON.get());
                output.accept(YoaItems.ADAMANTITE_HARPOON.get());
                output.accept(YoaItems.SILVER_HOLY_RIFLE.get());
                output.accept(YoaItems.GOLD_HOLY_RIFLE.get());
                output.accept(YoaItems.BRONZE_HOLY_RIFLE.get());
                output.accept(YoaItems.IRON_HOLY_RIFLE.get());
                output.accept(YoaItems.STEEL_HOLY_RIFLE.get());
                output.accept(YoaItems.BISMUTH_HOLY_RIFLE.get());
                output.accept(YoaItems.DIAMOND_HOLY_RIFLE.get());
                output.accept(YoaItems.NETHERITE_HOLY_RIFLE.get());
                output.accept(YoaItems.TITANIUM_HOLY_RIFLE.get());
                output.accept(YoaItems.IOLITE_HOLY_RIFLE.get());
                output.accept(YoaItems.ALEXANDRITE_HOLY_RIFLE.get());
                output.accept(YoaItems.ADAMANTITE_HOLY_RIFLE.get());
                output.accept(YoaItems.SILVER_KATANA.get());
                output.accept(YoaItems.GOLD_KATANA.get());
                output.accept(YoaItems.BRONZE_KATANA.get());
                output.accept(YoaItems.IRON_KATANA.get());
                output.accept(YoaItems.STEEL_KATANA.get());
                output.accept(YoaItems.BISMUTH_KATANA.get());
                output.accept(YoaItems.DIAMOND_KATANA.get());
                output.accept(YoaItems.NETHERITE_KATANA.get());
                output.accept(YoaItems.TITANIUM_KATANA.get());
                output.accept(YoaItems.IOLITE_KATANA.get());
                output.accept(YoaItems.ALEXANDRITE_KATANA.get());
                output.accept(YoaItems.ADAMANTITE_KATANA.get());
                output.accept(YoaItems.SILVER_LANCE.get());
                output.accept(YoaItems.GOLD_LANCE.get());
                output.accept(YoaItems.BRONZE_LANCE.get());
                output.accept(YoaItems.IRON_LANCE.get());
                output.accept(YoaItems.STEEL_LANCE.get());
                output.accept(YoaItems.BISMUTH_LANCE.get());
                output.accept(YoaItems.DIAMOND_LANCE.get());
                output.accept(YoaItems.NETHERITE_LANCE.get());
                output.accept(YoaItems.TITANIUM_LANCE.get());
                output.accept(YoaItems.IOLITE_LANCE.get());
                output.accept(YoaItems.ALEXANDRITE_LANCE.get());
                output.accept(YoaItems.ADAMANTITE_LANCE.get());
                output.accept(YoaItems.SILVER_LYRE.get());
                output.accept(YoaItems.GOLD_LYRE.get());
                output.accept(YoaItems.BRONZE_LYRE.get());
                output.accept(YoaItems.IRON_LYRE.get());
                output.accept(YoaItems.STEEL_LYRE.get());
                output.accept(YoaItems.BISMUTH_LYRE.get());
                output.accept(YoaItems.DIAMOND_LYRE.get());
                output.accept(YoaItems.NETHERITE_LYRE.get());
                output.accept(YoaItems.TITANIUM_LYRE.get());
                output.accept(YoaItems.IOLITE_LYRE.get());
                output.accept(YoaItems.ALEXANDRITE_LYRE.get());
                output.accept(YoaItems.ADAMANTITE_LYRE.get());
                output.accept(YoaItems.SILVER_MAGICIAN_WAND.get());
                output.accept(YoaItems.GOLD_MAGICIAN_WAND.get());
                output.accept(YoaItems.BRONZE_MAGICIAN_WAND.get());
                output.accept(YoaItems.IRON_MAGICIAN_WAND.get());
                output.accept(YoaItems.STEEL_MAGICIAN_WAND.get());
                output.accept(YoaItems.BISMUTH_MAGICIAN_WAND.get());
                output.accept(YoaItems.DIAMOND_MAGICIAN_WAND.get());
                output.accept(YoaItems.NETHERITE_MAGICIAN_WAND.get());
                output.accept(YoaItems.TITANIUM_MAGICIAN_WAND.get());
                output.accept(YoaItems.IOLITE_MAGICIAN_WAND.get());
                output.accept(YoaItems.ALEXANDRITE_MAGICIAN_WAND.get());
                output.accept(YoaItems.ADAMANTITE_MAGICIAN_WAND.get());
                output.accept(YoaItems.SILVER_RAPIER.get());
                output.accept(YoaItems.GOLD_RAPIER.get());
                output.accept(YoaItems.BRONZE_RAPIER.get());
                output.accept(YoaItems.IRON_RAPIER.get());
                output.accept(YoaItems.STEEL_RAPIER.get());
                output.accept(YoaItems.BISMUTH_RAPIER.get());
                output.accept(YoaItems.DIAMOND_RAPIER.get());
                output.accept(YoaItems.NETHERITE_RAPIER.get());
                output.accept(YoaItems.TITANIUM_RAPIER.get());
                output.accept(YoaItems.IOLITE_RAPIER.get());
                output.accept(YoaItems.ALEXANDRITE_RAPIER.get());
                output.accept(YoaItems.ADAMANTITE_RAPIER.get());
                output.accept(YoaItems.SILVER_RUNIC_AXE.get());
                output.accept(YoaItems.GOLD_RUNIC_AXE.get());
                output.accept(YoaItems.BRONZE_RUNIC_AXE.get());
                output.accept(YoaItems.IRON_RUNIC_AXE.get());
                output.accept(YoaItems.STEEL_RUNIC_AXE.get());
                output.accept(YoaItems.BISMUTH_RUNIC_AXE.get());
                output.accept(YoaItems.DIAMOND_RUNIC_AXE.get());
                output.accept(YoaItems.NETHERITE_RUNIC_AXE.get());
                output.accept(YoaItems.TITANIUM_RUNIC_AXE.get());
                output.accept(YoaItems.IOLITE_RUNIC_AXE.get());
                output.accept(YoaItems.ALEXANDRITE_RUNIC_AXE.get());
                output.accept(YoaItems.ADAMANTITE_RUNIC_AXE.get());
                output.accept(YoaItems.SILVER_RUNIC_BLADE.get());
                output.accept(YoaItems.GOLD_RUNIC_BLADE.get());
                output.accept(YoaItems.BRONZE_RUNIC_BLADE.get());
                output.accept(YoaItems.IRON_RUNIC_BLADE.get());
                output.accept(YoaItems.STEEL_RUNIC_BLADE.get());
                output.accept(YoaItems.BISMUTH_RUNIC_BLADE.get());
                output.accept(YoaItems.DIAMOND_RUNIC_BLADE.get());
                output.accept(YoaItems.NETHERITE_RUNIC_BLADE.get());
                output.accept(YoaItems.TITANIUM_RUNIC_BLADE.get());
                output.accept(YoaItems.IOLITE_RUNIC_BLADE.get());
                output.accept(YoaItems.ALEXANDRITE_RUNIC_BLADE.get());
                output.accept(YoaItems.ADAMANTITE_RUNIC_BLADE.get());
                output.accept(YoaItems.SILVER_RUNIC_BLASTER.get());
                output.accept(YoaItems.GOLD_RUNIC_BLASTER.get());
                output.accept(YoaItems.BRONZE_RUNIC_BLASTER.get());
                output.accept(YoaItems.IRON_RUNIC_BLASTER.get());
                output.accept(YoaItems.STEEL_RUNIC_BLASTER.get());
                output.accept(YoaItems.BISMUTH_RUNIC_BLASTER.get());
                output.accept(YoaItems.DIAMOND_RUNIC_BLASTER.get());
                output.accept(YoaItems.NETHERITE_RUNIC_BLASTER.get());
                output.accept(YoaItems.TITANIUM_RUNIC_BLASTER.get());
                output.accept(YoaItems.IOLITE_RUNIC_BLASTER.get());
                output.accept(YoaItems.ALEXANDRITE_RUNIC_BLASTER.get());
                output.accept(YoaItems.ADAMANTITE_RUNIC_BLASTER.get());
                output.accept(YoaItems.SILVER_SCISSORS_SWORD.get());
                output.accept(YoaItems.GOLD_SCISSORS_SWORD.get());
                output.accept(YoaItems.BRONZE_SCISSORS_SWORD.get());
                output.accept(YoaItems.IRON_SCISSORS_SWORD.get());
                output.accept(YoaItems.STEEL_SCISSORS_SWORD.get());
                output.accept(YoaItems.BISMUTH_SCISSORS_SWORD.get());
                output.accept(YoaItems.DIAMOND_SCISSORS_SWORD.get());
                output.accept(YoaItems.NETHERITE_SCISSORS_SWORD.get());
                output.accept(YoaItems.TITANIUM_SCISSORS_SWORD.get());
                output.accept(YoaItems.IOLITE_SCISSORS_SWORD.get());
                output.accept(YoaItems.ALEXANDRITE_SCISSORS_SWORD.get());
                output.accept(YoaItems.ADAMANTITE_SCISSORS_SWORD.get());
                output.accept(YoaItems.SILVER_SINGLE_SCISSORS_SWORD.get());
                output.accept(YoaItems.GOLD_SINGLE_SCISSORS_SWORD.get());
                output.accept(YoaItems.BRONZE_SINGLE_SCISSORS_SWORD.get());
                output.accept(YoaItems.IRON_SINGLE_SCISSORS_SWORD.get());
                output.accept(YoaItems.STEEL_SINGLE_SCISSORS_SWORD.get());
                output.accept(YoaItems.BISMUTH_SINGLE_SCISSORS_SWORD.get());
                output.accept(YoaItems.DIAMOND_SINGLE_SCISSORS_SWORD.get());
                output.accept(YoaItems.NETHERITE_SINGLE_SCISSORS_SWORD.get());
                output.accept(YoaItems.TITANIUM_SINGLE_SCISSORS_SWORD.get());
                output.accept(YoaItems.IOLITE_SINGLE_SCISSORS_SWORD.get());
                output.accept(YoaItems.ALEXANDRITE_SINGLE_SCISSORS_SWORD.get());
                output.accept(YoaItems.ADAMANTITE_SINGLE_SCISSORS_SWORD.get());
                output.accept(YoaItems.SILVER_SCYTHE.get());
                output.accept(YoaItems.GOLD_SCYTHE.get());
                output.accept(YoaItems.BRONZE_SCYTHE.get());
                output.accept(YoaItems.IRON_SCYTHE.get());
                output.accept(YoaItems.STEEL_SCYTHE.get());
                output.accept(YoaItems.BISMUTH_SCYTHE.get());
                output.accept(YoaItems.DIAMOND_SCYTHE.get());
                output.accept(YoaItems.NETHERITE_SCYTHE.get());
                output.accept(YoaItems.TITANIUM_SCYTHE.get());
                output.accept(YoaItems.IOLITE_SCYTHE.get());
                output.accept(YoaItems.ALEXANDRITE_SCYTHE.get());
                output.accept(YoaItems.ADAMANTITE_SCYTHE.get());
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
                output.accept(YoaItems.SILVER_SHURIKEN.get());
                output.accept(YoaItems.GOLD_SHURIKEN.get());
                output.accept(YoaItems.BRONZE_SHURIKEN.get());
                output.accept(YoaItems.IRON_SHURIKEN.get());
                output.accept(YoaItems.STEEL_SHURIKEN.get());
                output.accept(YoaItems.BISMUTH_SHURIKEN.get());
                output.accept(YoaItems.DIAMOND_SHURIKEN.get());
                output.accept(YoaItems.NETHERITE_SHURIKEN.get());
                output.accept(YoaItems.TITANIUM_SHURIKEN.get());
                output.accept(YoaItems.IOLITE_SHURIKEN.get());
                output.accept(YoaItems.ALEXANDRITE_SHURIKEN.get());
                output.accept(YoaItems.ADAMANTITE_SHURIKEN.get());
                output.accept(YoaItems.SILVER_SPELLCASTER_STAFF.get());
                output.accept(YoaItems.GOLD_SPELLCASTER_STAFF.get());
                output.accept(YoaItems.BRONZE_SPELLCASTER_STAFF.get());
                output.accept(YoaItems.IRON_SPELLCASTER_STAFF.get());
                output.accept(YoaItems.STEEL_SPELLCASTER_STAFF.get());
                output.accept(YoaItems.BISMUTH_SPELLCASTER_STAFF.get());
                output.accept(YoaItems.DIAMOND_SPELLCASTER_STAFF.get());
                output.accept(YoaItems.NETHERITE_SPELLCASTER_STAFF.get());
                output.accept(YoaItems.TITANIUM_SPELLCASTER_STAFF.get());
                output.accept(YoaItems.IOLITE_SPELLCASTER_STAFF.get());
                output.accept(YoaItems.ALEXANDRITE_SPELLCASTER_STAFF.get());
                output.accept(YoaItems.ADAMANTITE_SPELLCASTER_STAFF.get());
                output.accept(YoaItems.SILVER_TALISMAN.get());
                output.accept(YoaItems.GOLD_TALISMAN.get());
                output.accept(YoaItems.BRONZE_TALISMAN.get());
                output.accept(YoaItems.IRON_TALISMAN.get());
                output.accept(YoaItems.STEEL_TALISMAN.get());
                output.accept(YoaItems.BISMUTH_TALISMAN.get());
                output.accept(YoaItems.DIAMOND_TALISMAN.get());
                output.accept(YoaItems.NETHERITE_TALISMAN.get());
                output.accept(YoaItems.TITANIUM_TALISMAN.get());
                output.accept(YoaItems.IOLITE_TALISMAN.get());
                output.accept(YoaItems.ALEXANDRITE_TALISMAN.get());
                output.accept(YoaItems.ADAMANTITE_TALISMAN.get());
                output.accept(YoaItems.SILVER_THROWING_KNIFE.get());
                output.accept(YoaItems.GOLD_THROWING_KNIFE.get());
                output.accept(YoaItems.BRONZE_THROWING_KNIFE.get());
                output.accept(YoaItems.IRON_THROWING_KNIFE.get());
                output.accept(YoaItems.STEEL_THROWING_KNIFE.get());
                output.accept(YoaItems.BISMUTH_THROWING_KNIFE.get());
                output.accept(YoaItems.DIAMOND_THROWING_KNIFE.get());
                output.accept(YoaItems.NETHERITE_THROWING_KNIFE.get());
                output.accept(YoaItems.TITANIUM_THROWING_KNIFE.get());
                output.accept(YoaItems.IOLITE_THROWING_KNIFE.get());
                output.accept(YoaItems.ALEXANDRITE_THROWING_KNIFE.get());
                output.accept(YoaItems.ADAMANTITE_THROWING_KNIFE.get());
                output.accept(YoaItems.SILVER_TOME.get());
                output.accept(YoaItems.GOLD_TOME.get());
                output.accept(YoaItems.BRONZE_TOME.get());
                output.accept(YoaItems.IRON_TOME.get());
                output.accept(YoaItems.STEEL_TOME.get());
                output.accept(YoaItems.BISMUTH_TOME.get());
                output.accept(YoaItems.DIAMOND_TOME.get());
                output.accept(YoaItems.NETHERITE_TOME.get());
                output.accept(YoaItems.TITANIUM_TOME.get());
                output.accept(YoaItems.IOLITE_TOME.get());
                output.accept(YoaItems.ALEXANDRITE_TOME.get());
                output.accept(YoaItems.ADAMANTITE_TOME.get());
                output.accept(YoaItems.SILVER_WAR_FAN.get());
                output.accept(YoaItems.GOLD_WAR_FAN.get());
                output.accept(YoaItems.BRONZE_WAR_FAN.get());
                output.accept(YoaItems.IRON_WAR_FAN.get());
                output.accept(YoaItems.STEEL_WAR_FAN.get());
                output.accept(YoaItems.BISMUTH_WAR_FAN.get());
                output.accept(YoaItems.DIAMOND_WAR_FAN.get());
                output.accept(YoaItems.NETHERITE_WAR_FAN.get());
                output.accept(YoaItems.TITANIUM_WAR_FAN.get());
                output.accept(YoaItems.IOLITE_WAR_FAN.get());
                output.accept(YoaItems.ALEXANDRITE_WAR_FAN.get());
                output.accept(YoaItems.ADAMANTITE_WAR_FAN.get());
                output.accept(YoaItems.SILVER_WHIP_SWORD.get());
                output.accept(YoaItems.GOLD_WHIP_SWORD.get());
                output.accept(YoaItems.BRONZE_WHIP_SWORD.get());
                output.accept(YoaItems.IRON_WHIP_SWORD.get());
                output.accept(YoaItems.STEEL_WHIP_SWORD.get());
                output.accept(YoaItems.BISMUTH_WHIP_SWORD.get());
                output.accept(YoaItems.DIAMOND_WHIP_SWORD.get());
                output.accept(YoaItems.NETHERITE_WHIP_SWORD.get());
                output.accept(YoaItems.TITANIUM_WHIP_SWORD.get());
                output.accept(YoaItems.IOLITE_WHIP_SWORD.get());
                output.accept(YoaItems.ALEXANDRITE_WHIP_SWORD.get());
                output.accept(YoaItems.ADAMANTITE_WHIP_SWORD.get());            }).build());




    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> YOA_EDIBLES = TABS.register("yoa_edibles", () -> CreativeModeTab.builder()
            .withTabsBefore(YOA_WEAPONS.getKey())
            .icon(YoaItems.ETHERFRUCTUS.get()::getDefaultInstance)
            .title(Component.translatable("itemGroup.yoa_edibles"))
            .displayItems((parameters, output) -> {
                output.accept(YoaItems.ETHERFRUCTUS.get());
                output.accept(YoaItems.RAW_BIG_MEAT);
                output.accept(YoaItems.COOKED_BIG_MEAT);
                output.accept(YoaItems.SLICED_RAW_MEAT);
                output.accept(YoaItems.SLICED_COOKED_MEAT);
                output.accept(YoaItems.HAMBURGER);
            }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> YOA_MISC = TABS.register("yoa_misc", () -> CreativeModeTab.builder()
            .withTabsBefore(YOA_EDIBLES.getKey())
            .icon(YoaItems.ADAMANTITE_CHESTPLATE.get()::getDefaultInstance)
            .title(Component.translatable("itemGroup.yoa_misc"))
            .displayItems((parameters, output) -> {
                //output.accept(YoaItems.PLANE_ITEM.get());

                output.accept(YoaItems.TITANIUM_AXE.get());
                output.accept(YoaItems.TITANIUM_PICKAXE.get());
                output.accept(YoaItems.TITANIUM_HOE.get());
                output.accept(YoaItems.TITANIUM_SHOVEL.get());

                output.accept(YoaItems.IOLITE_AXE.get());
                output.accept(YoaItems.IOLITE_PICKAXE.get());
                output.accept(YoaItems.IOLITE_HOE.get());
                output.accept(YoaItems.IOLITE_SHOVEL.get());

                output.accept(YoaItems.ALEXANDRITE_AXE.get());
                output.accept(YoaItems.ALEXANDRITE_PICKAXE.get());
                output.accept(YoaItems.ALEXANDRITE_HOE.get());
                output.accept(YoaItems.ALEXANDRITE_SHOVEL.get());

                output.accept(YoaItems.ADAMANTITE_AXE.get());
                output.accept(YoaItems.ADAMANTITE_PICKAXE.get());
                output.accept(YoaItems.ADAMANTITE_HOE.get());
                output.accept(YoaItems.ADAMANTITE_SHOVEL.get());

                output.accept(YoaItems.SILVER_HELMET.get());
                output.accept(YoaItems.SILVER_CHESTPLATE.get());
                output.accept(YoaItems.SILVER_LEGGINGS.get());
                output.accept(YoaItems.SILVER_BOOTS.get());

                output.accept(YoaItems.WITHERITE_HELMET.get());
                output.accept(YoaItems.WITHERITE_CHESTPLATE.get());
                output.accept(YoaItems.WITHERITE_LEGGINGS.get());
                output.accept(YoaItems.WITHERITE_BOOTS.get());

                output.accept(YoaItems.IOLITE_HELMET.get());
                output.accept(YoaItems.IOLITE_CHESTPLATE.get());
                output.accept(YoaItems.IOLITE_LEGGINGS.get());
                output.accept(YoaItems.IOLITE_BOOTS.get());

                output.accept(YoaItems.ALEXANDRITE_HELMET.get());
                output.accept(YoaItems.ALEXANDRITE_CHESTPLATE.get());
                output.accept(YoaItems.ALEXANDRITE_LEGGINGS.get());
                output.accept(YoaItems.ALEXANDRITE_BOOTS.get());

                output.accept(YoaItems.ADAMANTITE_HELMET.get());
                output.accept(YoaItems.ADAMANTITE_CHESTPLATE.get());
                output.accept(YoaItems.ADAMANTITE_LEGGINGS.get());
                output.accept(YoaItems.ADAMANTITE_BOOTS.get());

                output.accept(YoaItems.ADAMANTITE_TEMPLATE.get());

                output.accept(YoaItems.RUNE_CRYSTAL.get());
                output.accept(YoaItems.CRYSTALIC_SHARD.get());

                output.accept(YoaItems.ANCIENT_GEMSTONE.get());
                output.accept(YoaItems.ECTOPLASM.get());
                output.accept(YoaItems.INSECT_LEG.get());
                output.accept(YoaItems.TUSK.get());


                output.accept(YoaItems.ADAMANTITE_TEMPLATE.get());
                output.accept(YoaItems.ADAMANTITE_INGOT.get());
                output.accept(YoaItems.ADAMANTITE_NUGGET.get());
                output.accept(YoaItems.RAW_ADAMANTITE.get());
                output.accept(YoaItems.ALEXANDRITE.get());
                output.accept(YoaItems.ALEXANDRITE_SHARD.get());
                output.accept(YoaItems.MOLTEN_ALEXANDRITE.get());
                output.accept(YoaItems.BISMUTH.get());
                output.accept(YoaItems.BISMUTH_SHARD.get());
                output.accept(YoaItems.RAW_BISMUTH.get());
                output.accept(YoaItems.MOLTEN_BISMUTH.get());
                output.accept(YoaItems.BRASS_INGOT.get());
                output.accept(YoaItems.BRASS_NUGGET.get());
                output.accept(YoaItems.BRONZE_INGOT.get());
                output.accept(YoaItems.BRONZE_NUGGET.get());
                output.accept(YoaItems.MOLTEN_BRONZE.get());
                output.accept(YoaItems.IOLITE.get());
                output.accept(YoaItems.IOLITE_SHARD.get());
                output.accept(YoaItems.MOLTEN_IOLITE.get());
                output.accept(YoaItems.SILVER_INGOT.get());
                output.accept(YoaItems.SILVER_NUGGET.get());
                output.accept(YoaItems.RAW_SILVER.get());
                output.accept(YoaItems.MOLTEN_SILVER.get());
                output.accept(YoaItems.STEEL_INGOT.get());
                output.accept(YoaItems.STEEL_NUGGET.get());
                output.accept(YoaItems.MOLTEN_STEEL.get());
                output.accept(YoaItems.TITANIUM_INGOT.get());
                output.accept(YoaItems.TITANIUM_NUGGET.get());
                output.accept(YoaItems.RAW_TITANIUM.get());
                output.accept(YoaItems.MOLTEN_TITANIUM.get());
                output.accept(YoaItems.WITHERITE.get());
                output.accept(YoaItems.WITHERITE_SHARD.get());
                output.accept(YoaItems.MOLTEN_IRON.get());
                output.accept(YoaItems.MOLTEN_GOLD.get());
                output.accept(YoaItems.DIAMOND_SHARD.get());
                output.accept(YoaItems.MOLTEN_DIAMOND.get());
                output.accept(YoaItems.NETHERITE_NUGGET.get());


            }).build());




    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> YOA_SPAWN_EGGS = TABS.register("yoa_spawn_eggs", () -> CreativeModeTab.builder()
            .withTabsBefore(YOA_MISC.getKey())
            .icon(YoaItems.BRAWLING_SPAWN_EGG.get()::getDefaultInstance)
            .title(Component.translatable("itemGroup.yoa_spawn_eggs"))
            .displayItems((parameters, output) -> {
                output.accept(YoaItems.BRAWLER_SPAWN_EGG.get());
                output.accept(YoaItems.BRAWLING_SPAWN_EGG.get());
                output.accept(YoaItems.BLOCKLING_SPAWN_EGG.get());
                output.accept(YoaItems.ARMED_SPIDER_SPAWN_EGG.get());
                output.accept(YoaItems.FALLEN_SAMURAI_SPAWN_EGG.get());
                output.accept(YoaItems.FENNEC_FOX_SPAWN_EGG.get());
                output.accept(YoaItems.TOUCAN_SPAWN_EGG.get());
            }).build());


    public static void register(IEventBus eventBus){
        TABS.register(eventBus);
    }

}
