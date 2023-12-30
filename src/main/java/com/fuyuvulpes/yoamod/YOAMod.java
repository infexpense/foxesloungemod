package com.fuyuvulpes.yoamod;

import com.fuyuvulpes.yoamod.client.entities.renderers.HammeringStationRenderer;
import com.fuyuvulpes.yoamod.registries.BlockEntitiesModReg;
import com.fuyuvulpes.yoamod.registries.BlocksModReg;
import com.fuyuvulpes.yoamod.registries.ItemsModReg;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


@Mod(YOAMod.MODID)
public class YOAMod
{

    public static final String MODID = "yoamod";

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> YOA_WEAPONS = CREATIVE_MODE_TABS.register("yoa_weapons", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.OP_BLOCKS)
            .icon(() -> Items.NETHERITE_SWORD.getDefaultInstance())
            .displayItems((parameters, output) -> {
                // output.accept(EXAMPLE_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());



    public YOAMod(IEventBus modEventBus)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        BlocksModReg.register(modEventBus);

        ItemsModReg.register(modEventBus);
        BlockEntitiesModReg.register(modEventBus);

        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS){
            event.accept(BlocksModReg.HAMMERING_STATION);
            event.accept(BlocksModReg.AUGMENTING_STATION);
            event.accept(BlocksModReg.MELTING_POT);

        }

        if (event.getTabKey() == YOA_WEAPONS.getKey()){
            event.accept(ItemsModReg.SILVER_BELL.get());
            event.accept(ItemsModReg.GOLD_BELL.get());
            event.accept(ItemsModReg.BRONZE_BELL.get());
            event.accept(ItemsModReg.IRON_BELL.get());
            event.accept(ItemsModReg.STEEL_BELL.get());
            event.accept(ItemsModReg.BISMUTH_BELL.get());
            event.accept(ItemsModReg.DIAMOND_BELL.get());
            event.accept(ItemsModReg.NETHERITE_BELL.get());
            event.accept(ItemsModReg.TITANIUM_BELL.get());
            event.accept(ItemsModReg.IOLITE_BELL.get());
            event.accept(ItemsModReg.ALEXANDRITE_BELL.get());
            event.accept(ItemsModReg.ADAMANTITE_BELL.get());
            event.accept(ItemsModReg.SILVER_BLOW_DART.get());
            event.accept(ItemsModReg.GOLD_BLOW_DART.get());
            event.accept(ItemsModReg.BRONZE_BLOW_DART.get());
            event.accept(ItemsModReg.IRON_BLOW_DART.get());
            event.accept(ItemsModReg.STEEL_BLOW_DART.get());
            event.accept(ItemsModReg.BISMUTH_BLOW_DART.get());
            event.accept(ItemsModReg.DIAMOND_BLOW_DART.get());
            event.accept(ItemsModReg.NETHERITE_BLOW_DART.get());
            event.accept(ItemsModReg.TITANIUM_BLOW_DART.get());
            event.accept(ItemsModReg.IOLITE_BLOW_DART.get());
            event.accept(ItemsModReg.ALEXANDRITE_BLOW_DART.get());
            event.accept(ItemsModReg.ADAMANTITE_BLOW_DART.get());
            event.accept(ItemsModReg.SILVER_BOOMERANG.get());
            event.accept(ItemsModReg.GOLD_BOOMERANG.get());
            event.accept(ItemsModReg.BRONZE_BOOMERANG.get());
            event.accept(ItemsModReg.IRON_BOOMERANG.get());
            event.accept(ItemsModReg.STEEL_BOOMERANG.get());
            event.accept(ItemsModReg.BISMUTH_BOOMERANG.get());
            event.accept(ItemsModReg.DIAMOND_BOOMERANG.get());
            event.accept(ItemsModReg.NETHERITE_BOOMERANG.get());
            event.accept(ItemsModReg.TITANIUM_BOOMERANG.get());
            event.accept(ItemsModReg.IOLITE_BOOMERANG.get());
            event.accept(ItemsModReg.ALEXANDRITE_BOOMERANG.get());
            event.accept(ItemsModReg.ADAMANTITE_BOOMERANG.get());
            event.accept(ItemsModReg.SILVER_CHAKRAM.get());
            event.accept(ItemsModReg.GOLD_CHAKRAM.get());
            event.accept(ItemsModReg.BRONZE_CHAKRAM.get());
            event.accept(ItemsModReg.IRON_CHAKRAM.get());
            event.accept(ItemsModReg.STEEL_CHAKRAM.get());
            event.accept(ItemsModReg.BISMUTH_CHAKRAM.get());
            event.accept(ItemsModReg.DIAMOND_CHAKRAM.get());
            event.accept(ItemsModReg.NETHERITE_CHAKRAM.get());
            event.accept(ItemsModReg.TITANIUM_CHAKRAM.get());
            event.accept(ItemsModReg.IOLITE_CHAKRAM.get());
            event.accept(ItemsModReg.ALEXANDRITE_CHAKRAM.get());
            event.accept(ItemsModReg.ADAMANTITE_CHAKRAM.get());
            event.accept(ItemsModReg.SILVER_CLAWS.get());
            event.accept(ItemsModReg.GOLD_CLAWS.get());
            event.accept(ItemsModReg.BRONZE_CLAWS.get());
            event.accept(ItemsModReg.IRON_CLAWS.get());
            event.accept(ItemsModReg.STEEL_CLAWS.get());
            event.accept(ItemsModReg.BISMUTH_CLAWS.get());
            event.accept(ItemsModReg.DIAMOND_CLAWS.get());
            event.accept(ItemsModReg.NETHERITE_CLAWS.get());
            event.accept(ItemsModReg.TITANIUM_CLAWS.get());
            event.accept(ItemsModReg.IOLITE_CLAWS.get());
            event.accept(ItemsModReg.ALEXANDRITE_CLAWS.get());
            event.accept(ItemsModReg.ADAMANTITE_CLAWS.get());
            event.accept(ItemsModReg.SILVER_CLAYMORE.get());
            event.accept(ItemsModReg.GOLD_CLAYMORE.get());
            event.accept(ItemsModReg.BRONZE_CLAYMORE.get());
            event.accept(ItemsModReg.IRON_CLAYMORE.get());
            event.accept(ItemsModReg.STEEL_CLAYMORE.get());
            event.accept(ItemsModReg.BISMUTH_CLAYMORE.get());
            event.accept(ItemsModReg.DIAMOND_CLAYMORE.get());
            event.accept(ItemsModReg.NETHERITE_CLAYMORE.get());
            event.accept(ItemsModReg.TITANIUM_CLAYMORE.get());
            event.accept(ItemsModReg.IOLITE_CLAYMORE.get());
            event.accept(ItemsModReg.ALEXANDRITE_CLAYMORE.get());
            event.accept(ItemsModReg.ADAMANTITE_CLAYMORE.get());
            event.accept(ItemsModReg.SILVER_DAGGER.get());
            event.accept(ItemsModReg.GOLD_DAGGER.get());
            event.accept(ItemsModReg.BRONZE_DAGGER.get());
            event.accept(ItemsModReg.IRON_DAGGER.get());
            event.accept(ItemsModReg.STEEL_DAGGER.get());
            event.accept(ItemsModReg.BISMUTH_DAGGER.get());
            event.accept(ItemsModReg.DIAMOND_DAGGER.get());
            event.accept(ItemsModReg.NETHERITE_DAGGER.get());
            event.accept(ItemsModReg.TITANIUM_DAGGER.get());
            event.accept(ItemsModReg.IOLITE_DAGGER.get());
            event.accept(ItemsModReg.ALEXANDRITE_DAGGER.get());
            event.accept(ItemsModReg.ADAMANTITE_DAGGER.get());
            event.accept(ItemsModReg.SILVER_GREAT_AXE.get());
            event.accept(ItemsModReg.GOLD_GREAT_AXE.get());
            event.accept(ItemsModReg.BRONZE_GREAT_AXE.get());
            event.accept(ItemsModReg.IRON_GREAT_AXE.get());
            event.accept(ItemsModReg.STEEL_GREAT_AXE.get());
            event.accept(ItemsModReg.BISMUTH_GREAT_AXE.get());
            event.accept(ItemsModReg.DIAMOND_GREAT_AXE.get());
            event.accept(ItemsModReg.NETHERITE_GREAT_AXE.get());
            event.accept(ItemsModReg.TITANIUM_GREAT_AXE.get());
            event.accept(ItemsModReg.IOLITE_GREAT_AXE.get());
            event.accept(ItemsModReg.ALEXANDRITE_GREAT_AXE.get());
            event.accept(ItemsModReg.ADAMANTITE_GREAT_AXE.get());
            event.accept(ItemsModReg.SILVER_HARPOON.get());
            event.accept(ItemsModReg.GOLD_HARPOON.get());
            event.accept(ItemsModReg.BRONZE_HARPOON.get());
            event.accept(ItemsModReg.IRON_HARPOON.get());
            event.accept(ItemsModReg.STEEL_HARPOON.get());
            event.accept(ItemsModReg.BISMUTH_HARPOON.get());
            event.accept(ItemsModReg.DIAMOND_HARPOON.get());
            event.accept(ItemsModReg.NETHERITE_HARPOON.get());
            event.accept(ItemsModReg.TITANIUM_HARPOON.get());
            event.accept(ItemsModReg.IOLITE_HARPOON.get());
            event.accept(ItemsModReg.ALEXANDRITE_HARPOON.get());
            event.accept(ItemsModReg.ADAMANTITE_HARPOON.get());
            event.accept(ItemsModReg.SILVER_HOLY_RIFLE.get());
            event.accept(ItemsModReg.GOLD_HOLY_RIFLE.get());
            event.accept(ItemsModReg.BRONZE_HOLY_RIFLE.get());
            event.accept(ItemsModReg.IRON_HOLY_RIFLE.get());
            event.accept(ItemsModReg.STEEL_HOLY_RIFLE.get());
            event.accept(ItemsModReg.BISMUTH_HOLY_RIFLE.get());
            event.accept(ItemsModReg.DIAMOND_HOLY_RIFLE.get());
            event.accept(ItemsModReg.NETHERITE_HOLY_RIFLE.get());
            event.accept(ItemsModReg.TITANIUM_HOLY_RIFLE.get());
            event.accept(ItemsModReg.IOLITE_HOLY_RIFLE.get());
            event.accept(ItemsModReg.ALEXANDRITE_HOLY_RIFLE.get());
            event.accept(ItemsModReg.ADAMANTITE_HOLY_RIFLE.get());
            event.accept(ItemsModReg.SILVER_KATANA.get());
            event.accept(ItemsModReg.GOLD_KATANA.get());
            event.accept(ItemsModReg.BRONZE_KATANA.get());
            event.accept(ItemsModReg.IRON_KATANA.get());
            event.accept(ItemsModReg.STEEL_KATANA.get());
            event.accept(ItemsModReg.BISMUTH_KATANA.get());
            event.accept(ItemsModReg.DIAMOND_KATANA.get());
            event.accept(ItemsModReg.NETHERITE_KATANA.get());
            event.accept(ItemsModReg.TITANIUM_KATANA.get());
            event.accept(ItemsModReg.IOLITE_KATANA.get());
            event.accept(ItemsModReg.ALEXANDRITE_KATANA.get());
            event.accept(ItemsModReg.ADAMANTITE_KATANA.get());
            event.accept(ItemsModReg.SILVER_LANCE.get());
            event.accept(ItemsModReg.GOLD_LANCE.get());
            event.accept(ItemsModReg.BRONZE_LANCE.get());
            event.accept(ItemsModReg.IRON_LANCE.get());
            event.accept(ItemsModReg.STEEL_LANCE.get());
            event.accept(ItemsModReg.BISMUTH_LANCE.get());
            event.accept(ItemsModReg.DIAMOND_LANCE.get());
            event.accept(ItemsModReg.NETHERITE_LANCE.get());
            event.accept(ItemsModReg.TITANIUM_LANCE.get());
            event.accept(ItemsModReg.IOLITE_LANCE.get());
            event.accept(ItemsModReg.ALEXANDRITE_LANCE.get());
            event.accept(ItemsModReg.ADAMANTITE_LANCE.get());
            event.accept(ItemsModReg.SILVER_LONGBOW.get());
            event.accept(ItemsModReg.GOLD_LONGBOW.get());
            event.accept(ItemsModReg.BRONZE_LONGBOW.get());
            event.accept(ItemsModReg.IRON_LONGBOW.get());
            event.accept(ItemsModReg.STEEL_LONGBOW.get());
            event.accept(ItemsModReg.BISMUTH_LONGBOW.get());
            event.accept(ItemsModReg.DIAMOND_LONGBOW.get());
            event.accept(ItemsModReg.NETHERITE_LONGBOW.get());
            event.accept(ItemsModReg.TITANIUM_LONGBOW.get());
            event.accept(ItemsModReg.IOLITE_LONGBOW.get());
            event.accept(ItemsModReg.ALEXANDRITE_LONGBOW.get());
            event.accept(ItemsModReg.ADAMANTITE_LONGBOW.get());
            event.accept(ItemsModReg.SILVER_LYRE.get());
            event.accept(ItemsModReg.GOLD_LYRE.get());
            event.accept(ItemsModReg.BRONZE_LYRE.get());
            event.accept(ItemsModReg.IRON_LYRE.get());
            event.accept(ItemsModReg.STEEL_LYRE.get());
            event.accept(ItemsModReg.BISMUTH_LYRE.get());
            event.accept(ItemsModReg.DIAMOND_LYRE.get());
            event.accept(ItemsModReg.NETHERITE_LYRE.get());
            event.accept(ItemsModReg.TITANIUM_LYRE.get());
            event.accept(ItemsModReg.IOLITE_LYRE.get());
            event.accept(ItemsModReg.ALEXANDRITE_LYRE.get());
            event.accept(ItemsModReg.ADAMANTITE_LYRE.get());
            event.accept(ItemsModReg.SILVER_MAGICIAN_WAND.get());
            event.accept(ItemsModReg.GOLD_MAGICIAN_WAND.get());
            event.accept(ItemsModReg.BRONZE_MAGICIAN_WAND.get());
            event.accept(ItemsModReg.IRON_MAGICIAN_WAND.get());
            event.accept(ItemsModReg.STEEL_MAGICIAN_WAND.get());
            event.accept(ItemsModReg.BISMUTH_MAGICIAN_WAND.get());
            event.accept(ItemsModReg.DIAMOND_MAGICIAN_WAND.get());
            event.accept(ItemsModReg.NETHERITE_MAGICIAN_WAND.get());
            event.accept(ItemsModReg.TITANIUM_MAGICIAN_WAND.get());
            event.accept(ItemsModReg.IOLITE_MAGICIAN_WAND.get());
            event.accept(ItemsModReg.ALEXANDRITE_MAGICIAN_WAND.get());
            event.accept(ItemsModReg.ADAMANTITE_MAGICIAN_WAND.get());
            event.accept(ItemsModReg.SILVER_RAPIER.get());
            event.accept(ItemsModReg.GOLD_RAPIER.get());
            event.accept(ItemsModReg.BRONZE_RAPIER.get());
            event.accept(ItemsModReg.IRON_RAPIER.get());
            event.accept(ItemsModReg.STEEL_RAPIER.get());
            event.accept(ItemsModReg.BISMUTH_RAPIER.get());
            event.accept(ItemsModReg.DIAMOND_RAPIER.get());
            event.accept(ItemsModReg.NETHERITE_RAPIER.get());
            event.accept(ItemsModReg.TITANIUM_RAPIER.get());
            event.accept(ItemsModReg.IOLITE_RAPIER.get());
            event.accept(ItemsModReg.ALEXANDRITE_RAPIER.get());
            event.accept(ItemsModReg.ADAMANTITE_RAPIER.get());
            event.accept(ItemsModReg.SILVER_RUNIC_AXE.get());
            event.accept(ItemsModReg.GOLD_RUNIC_AXE.get());
            event.accept(ItemsModReg.BRONZE_RUNIC_AXE.get());
            event.accept(ItemsModReg.IRON_RUNIC_AXE.get());
            event.accept(ItemsModReg.STEEL_RUNIC_AXE.get());
            event.accept(ItemsModReg.BISMUTH_RUNIC_AXE.get());
            event.accept(ItemsModReg.DIAMOND_RUNIC_AXE.get());
            event.accept(ItemsModReg.NETHERITE_RUNIC_AXE.get());
            event.accept(ItemsModReg.TITANIUM_RUNIC_AXE.get());
            event.accept(ItemsModReg.IOLITE_RUNIC_AXE.get());
            event.accept(ItemsModReg.ALEXANDRITE_RUNIC_AXE.get());
            event.accept(ItemsModReg.ADAMANTITE_RUNIC_AXE.get());
            event.accept(ItemsModReg.SILVER_RUNIC_BLADE.get());
            event.accept(ItemsModReg.GOLD_RUNIC_BLADE.get());
            event.accept(ItemsModReg.BRONZE_RUNIC_BLADE.get());
            event.accept(ItemsModReg.IRON_RUNIC_BLADE.get());
            event.accept(ItemsModReg.STEEL_RUNIC_BLADE.get());
            event.accept(ItemsModReg.BISMUTH_RUNIC_BLADE.get());
            event.accept(ItemsModReg.DIAMOND_RUNIC_BLADE.get());
            event.accept(ItemsModReg.NETHERITE_RUNIC_BLADE.get());
            event.accept(ItemsModReg.TITANIUM_RUNIC_BLADE.get());
            event.accept(ItemsModReg.IOLITE_RUNIC_BLADE.get());
            event.accept(ItemsModReg.ALEXANDRITE_RUNIC_BLADE.get());
            event.accept(ItemsModReg.ADAMANTITE_RUNIC_BLADE.get());
            event.accept(ItemsModReg.SILVER_RUNIC_BLASTER.get());
            event.accept(ItemsModReg.GOLD_RUNIC_BLASTER.get());
            event.accept(ItemsModReg.BRONZE_RUNIC_BLASTER.get());
            event.accept(ItemsModReg.IRON_RUNIC_BLASTER.get());
            event.accept(ItemsModReg.STEEL_RUNIC_BLASTER.get());
            event.accept(ItemsModReg.BISMUTH_RUNIC_BLASTER.get());
            event.accept(ItemsModReg.DIAMOND_RUNIC_BLASTER.get());
            event.accept(ItemsModReg.NETHERITE_RUNIC_BLASTER.get());
            event.accept(ItemsModReg.TITANIUM_RUNIC_BLASTER.get());
            event.accept(ItemsModReg.IOLITE_RUNIC_BLASTER.get());
            event.accept(ItemsModReg.ALEXANDRITE_RUNIC_BLASTER.get());
            event.accept(ItemsModReg.ADAMANTITE_RUNIC_BLASTER.get());
            event.accept(ItemsModReg.SILVER_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.GOLD_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.BRONZE_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.IRON_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.STEEL_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.BISMUTH_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.DIAMOND_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.NETHERITE_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.TITANIUM_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.IOLITE_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.ALEXANDRITE_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.ADAMANTITE_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.SILVER_SINGLE_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.GOLD_SINGLE_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.BRONZE_SINGLE_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.IRON_SINGLE_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.STEEL_SINGLE_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.BISMUTH_SINGLE_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.DIAMOND_SINGLE_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.NETHERITE_SINGLE_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.TITANIUM_SINGLE_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.IOLITE_SINGLE_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.ALEXANDRITE_SINGLE_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.ADAMANTITE_SINGLE_SCISSORS_SWORD.get());
            event.accept(ItemsModReg.SILVER_SCYTHE.get());
            event.accept(ItemsModReg.GOLD_SCYTHE.get());
            event.accept(ItemsModReg.BRONZE_SCYTHE.get());
            event.accept(ItemsModReg.IRON_SCYTHE.get());
            event.accept(ItemsModReg.STEEL_SCYTHE.get());
            event.accept(ItemsModReg.BISMUTH_SCYTHE.get());
            event.accept(ItemsModReg.DIAMOND_SCYTHE.get());
            event.accept(ItemsModReg.NETHERITE_SCYTHE.get());
            event.accept(ItemsModReg.TITANIUM_SCYTHE.get());
            event.accept(ItemsModReg.IOLITE_SCYTHE.get());
            event.accept(ItemsModReg.ALEXANDRITE_SCYTHE.get());
            event.accept(ItemsModReg.ADAMANTITE_SCYTHE.get());
            event.accept(ItemsModReg.SILVER_SHOTGUN_SHIELD.get());
            event.accept(ItemsModReg.GOLD_SHOTGUN_SHIELD.get());
            event.accept(ItemsModReg.BRONZE_SHOTGUN_SHIELD.get());
            event.accept(ItemsModReg.IRON_SHOTGUN_SHIELD.get());
            event.accept(ItemsModReg.STEEL_SHOTGUN_SHIELD.get());
            event.accept(ItemsModReg.BISMUTH_SHOTGUN_SHIELD.get());
            event.accept(ItemsModReg.DIAMOND_SHOTGUN_SHIELD.get());
            event.accept(ItemsModReg.NETHERITE_SHOTGUN_SHIELD.get());
            event.accept(ItemsModReg.TITANIUM_SHOTGUN_SHIELD.get());
            event.accept(ItemsModReg.IOLITE_SHOTGUN_SHIELD.get());
            event.accept(ItemsModReg.ALEXANDRITE_SHOTGUN_SHIELD.get());
            event.accept(ItemsModReg.ADAMANTITE_SHOTGUN_SHIELD.get());
            event.accept(ItemsModReg.SILVER_SHURIKEN.get());
            event.accept(ItemsModReg.GOLD_SHURIKEN.get());
            event.accept(ItemsModReg.BRONZE_SHURIKEN.get());
            event.accept(ItemsModReg.IRON_SHURIKEN.get());
            event.accept(ItemsModReg.STEEL_SHURIKEN.get());
            event.accept(ItemsModReg.BISMUTH_SHURIKEN.get());
            event.accept(ItemsModReg.DIAMOND_SHURIKEN.get());
            event.accept(ItemsModReg.NETHERITE_SHURIKEN.get());
            event.accept(ItemsModReg.TITANIUM_SHURIKEN.get());
            event.accept(ItemsModReg.IOLITE_SHURIKEN.get());
            event.accept(ItemsModReg.ALEXANDRITE_SHURIKEN.get());
            event.accept(ItemsModReg.ADAMANTITE_SHURIKEN.get());
            event.accept(ItemsModReg.SILVER_SPELLCASTER_STAFF.get());
            event.accept(ItemsModReg.GOLD_SPELLCASTER_STAFF.get());
            event.accept(ItemsModReg.BRONZE_SPELLCASTER_STAFF.get());
            event.accept(ItemsModReg.IRON_SPELLCASTER_STAFF.get());
            event.accept(ItemsModReg.STEEL_SPELLCASTER_STAFF.get());
            event.accept(ItemsModReg.BISMUTH_SPELLCASTER_STAFF.get());
            event.accept(ItemsModReg.DIAMOND_SPELLCASTER_STAFF.get());
            event.accept(ItemsModReg.NETHERITE_SPELLCASTER_STAFF.get());
            event.accept(ItemsModReg.TITANIUM_SPELLCASTER_STAFF.get());
            event.accept(ItemsModReg.IOLITE_SPELLCASTER_STAFF.get());
            event.accept(ItemsModReg.ALEXANDRITE_SPELLCASTER_STAFF.get());
            event.accept(ItemsModReg.ADAMANTITE_SPELLCASTER_STAFF.get());
            event.accept(ItemsModReg.SILVER_TALISMAN.get());
            event.accept(ItemsModReg.GOLD_TALISMAN.get());
            event.accept(ItemsModReg.BRONZE_TALISMAN.get());
            event.accept(ItemsModReg.IRON_TALISMAN.get());
            event.accept(ItemsModReg.STEEL_TALISMAN.get());
            event.accept(ItemsModReg.BISMUTH_TALISMAN.get());
            event.accept(ItemsModReg.DIAMOND_TALISMAN.get());
            event.accept(ItemsModReg.NETHERITE_TALISMAN.get());
            event.accept(ItemsModReg.TITANIUM_TALISMAN.get());
            event.accept(ItemsModReg.IOLITE_TALISMAN.get());
            event.accept(ItemsModReg.ALEXANDRITE_TALISMAN.get());
            event.accept(ItemsModReg.ADAMANTITE_TALISMAN.get());
            event.accept(ItemsModReg.SILVER_THROWING_KNIFE.get());
            event.accept(ItemsModReg.GOLD_THROWING_KNIFE.get());
            event.accept(ItemsModReg.BRONZE_THROWING_KNIFE.get());
            event.accept(ItemsModReg.IRON_THROWING_KNIFE.get());
            event.accept(ItemsModReg.STEEL_THROWING_KNIFE.get());
            event.accept(ItemsModReg.BISMUTH_THROWING_KNIFE.get());
            event.accept(ItemsModReg.DIAMOND_THROWING_KNIFE.get());
            event.accept(ItemsModReg.NETHERITE_THROWING_KNIFE.get());
            event.accept(ItemsModReg.TITANIUM_THROWING_KNIFE.get());
            event.accept(ItemsModReg.IOLITE_THROWING_KNIFE.get());
            event.accept(ItemsModReg.ALEXANDRITE_THROWING_KNIFE.get());
            event.accept(ItemsModReg.ADAMANTITE_THROWING_KNIFE.get());
            event.accept(ItemsModReg.SILVER_TOME.get());
            event.accept(ItemsModReg.GOLD_TOME.get());
            event.accept(ItemsModReg.BRONZE_TOME.get());
            event.accept(ItemsModReg.IRON_TOME.get());
            event.accept(ItemsModReg.STEEL_TOME.get());
            event.accept(ItemsModReg.BISMUTH_TOME.get());
            event.accept(ItemsModReg.DIAMOND_TOME.get());
            event.accept(ItemsModReg.NETHERITE_TOME.get());
            event.accept(ItemsModReg.TITANIUM_TOME.get());
            event.accept(ItemsModReg.IOLITE_TOME.get());
            event.accept(ItemsModReg.ALEXANDRITE_TOME.get());
            event.accept(ItemsModReg.ADAMANTITE_TOME.get());
            event.accept(ItemsModReg.SILVER_WAR_FAN.get());
            event.accept(ItemsModReg.GOLD_WAR_FAN.get());
            event.accept(ItemsModReg.BRONZE_WAR_FAN.get());
            event.accept(ItemsModReg.IRON_WAR_FAN.get());
            event.accept(ItemsModReg.STEEL_WAR_FAN.get());
            event.accept(ItemsModReg.BISMUTH_WAR_FAN.get());
            event.accept(ItemsModReg.DIAMOND_WAR_FAN.get());
            event.accept(ItemsModReg.NETHERITE_WAR_FAN.get());
            event.accept(ItemsModReg.TITANIUM_WAR_FAN.get());
            event.accept(ItemsModReg.IOLITE_WAR_FAN.get());
            event.accept(ItemsModReg.ALEXANDRITE_WAR_FAN.get());
            event.accept(ItemsModReg.ADAMANTITE_WAR_FAN.get());
            event.accept(ItemsModReg.SILVER_WHIP_SWORD.get());
            event.accept(ItemsModReg.GOLD_WHIP_SWORD.get());
            event.accept(ItemsModReg.BRONZE_WHIP_SWORD.get());
            event.accept(ItemsModReg.IRON_WHIP_SWORD.get());
            event.accept(ItemsModReg.STEEL_WHIP_SWORD.get());
            event.accept(ItemsModReg.BISMUTH_WHIP_SWORD.get());
            event.accept(ItemsModReg.DIAMOND_WHIP_SWORD.get());
            event.accept(ItemsModReg.NETHERITE_WHIP_SWORD.get());
            event.accept(ItemsModReg.TITANIUM_WHIP_SWORD.get());
            event.accept(ItemsModReg.IOLITE_WHIP_SWORD.get());
            event.accept(ItemsModReg.ALEXANDRITE_WHIP_SWORD.get());
            event.accept(ItemsModReg.ADAMANTITE_WHIP_SWORD.get());


        }
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }


    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event){
            event.registerBlockEntityRenderer(BlockEntitiesModReg.HAMMERING_STATION.get(), HammeringStationRenderer::new);
        }


        @SubscribeEvent
        public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){
        }
    }
}
