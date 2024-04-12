package com.fuyuvulpes.yoamod.data.generators;

import com.fuyuvulpes.yoamod.YOAMod;
import com.fuyuvulpes.yoamod.core.registries.YoaItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class ItemModelGen extends ItemModelProvider {

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ItemModelGen(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        spawnEggItem(YoaItems.BRAWLER_SPAWN_EGG);
        spawnEggItem(YoaItems.BRAWLING_SPAWN_EGG);
        spawnEggItem(YoaItems.BLOCKLING_SPAWN_EGG);
        spawnEggItem(YoaItems.ARMED_SPIDER_SPAWN_EGG);
        spawnEggItem(YoaItems.FALLEN_SAMURAI_SPAWN_EGG);
        spawnEggItem(YoaItems.FENNEC_FOX_SPAWN_EGG);
        spawnEggItem(YoaItems.TOUCAN_SPAWN_EGG);
        spawnEggItem(YoaItems.OWL_SPAWN_EGG);
        spawnEggItem(YoaItems.PEAFOWL_SPAWN_EGG);

        simpleItem(YoaItems.ETHERFRUCTUS);

        simpleItem(YoaItems.ANCIENT_GEMSTONE);
        simpleItem(YoaItems.RAW_BIG_MEAT);
        simpleItem(YoaItems.COOKED_BIG_MEAT);
        simpleItem(YoaItems.SLICED_RAW_MEAT);
        simpleItem(YoaItems.SLICED_COOKED_MEAT);
        simpleItem(YoaItems.HAMBURGER);
        simpleItem(YoaItems.ECTOPLASM);
        simpleItem(YoaItems.INSECT_LEG);
        simpleItem(YoaItems.TUSK);

        simpleItem(YoaItems.PLANE_ITEM);
        simpleItem(YoaItems.CRYSTALIC_SHARD);
        simpleItem(YoaItems.RUNE_CRYSTAL);
        simpleItem(YoaItems.ADAMANTITE_TEMPLATE);

        simpleItem(YoaItems.ADAMANTITE_INGOT);
        simpleItem(YoaItems.ADAMANTITE_NUGGET);
        simpleItem(YoaItems.RAW_ADAMANTITE);
        simpleItem(YoaItems.ALEXANDRITE);
        simpleItem(YoaItems.ALEXANDRITE_SHARD);
        simpleItem(YoaItems.MOLTEN_ALEXANDRITE);
        simpleItem(YoaItems.BISMUTH);
        simpleItem(YoaItems.BISMUTH_SHARD);
        simpleItem(YoaItems.RAW_BISMUTH);
        simpleItem(YoaItems.MOLTEN_BISMUTH);
        simpleItem(YoaItems.BRASS_INGOT);
        simpleItem(YoaItems.BRASS_NUGGET);
        simpleItem(YoaItems.BRONZE_INGOT);
        simpleItem(YoaItems.BRONZE_NUGGET);
        simpleItem(YoaItems.MOLTEN_BRONZE);
        simpleItem(YoaItems.IOLITE);
        simpleItem(YoaItems.IOLITE_SHARD);
        simpleItem(YoaItems.MOLTEN_IOLITE);
        simpleItem(YoaItems.SILVER_INGOT);
        simpleItem(YoaItems.SILVER_NUGGET);
        simpleItem(YoaItems.RAW_SILVER);
        simpleItem(YoaItems.MOLTEN_SILVER);
        simpleItem(YoaItems.STEEL_INGOT);
        simpleItem(YoaItems.STEEL_NUGGET);
        simpleItem(YoaItems.MOLTEN_STEEL);
        simpleItem(YoaItems.TITANIUM_INGOT);
        simpleItem(YoaItems.TITANIUM_NUGGET);
        simpleItem(YoaItems.RAW_TITANIUM);
        simpleItem(YoaItems.MOLTEN_TITANIUM);
        simpleItem(YoaItems.WITHERITE);
        simpleItem(YoaItems.WITHERITE_SHARD);
        simpleItem(YoaItems.MOLTEN_IRON);
        simpleItem(YoaItems.MOLTEN_GOLD);
        simpleItem(YoaItems.DIAMOND_SHARD);
        simpleItem(YoaItems.MOLTEN_DIAMOND);
        simpleItem(YoaItems.NETHERITE_NUGGET);

        handheldItem(YoaItems.TITANIUM_AXE);
        handheldItem(YoaItems.TITANIUM_PICKAXE);
        handheldItem(YoaItems.TITANIUM_HOE);
        handheldItem(YoaItems.TITANIUM_SHOVEL);

        handheldItem(YoaItems.IOLITE_AXE);
        handheldItem(YoaItems.IOLITE_PICKAXE);
        handheldItem(YoaItems.IOLITE_HOE);
        handheldItem(YoaItems.IOLITE_SHOVEL);

        handheldItem(YoaItems.ALEXANDRITE_AXE);
        handheldItem(YoaItems.ALEXANDRITE_PICKAXE);
        handheldItem(YoaItems.ALEXANDRITE_HOE);
        handheldItem(YoaItems.ALEXANDRITE_SHOVEL);

        handheldItem(YoaItems.ADAMANTITE_AXE);
        handheldItem(YoaItems.ADAMANTITE_PICKAXE);
        handheldItem(YoaItems.ADAMANTITE_HOE);
        handheldItem(YoaItems.ADAMANTITE_SHOVEL);

        simpleItem(YoaItems.SILVER_HELMET);
        simpleItem(YoaItems.SILVER_CHESTPLATE);
        simpleItem(YoaItems.SILVER_LEGGINGS);
        simpleItem(YoaItems.SILVER_BOOTS);

        simpleItem(YoaItems.WITHERITE_HELMET);
        simpleItem(YoaItems.WITHERITE_CHESTPLATE);
        simpleItem(YoaItems.WITHERITE_LEGGINGS);
        simpleItem(YoaItems.WITHERITE_BOOTS);

        simpleItem(YoaItems.IOLITE_HELMET);
        simpleItem(YoaItems.IOLITE_CHESTPLATE);
        simpleItem(YoaItems.IOLITE_LEGGINGS);
        simpleItem(YoaItems.IOLITE_BOOTS);

        simpleItem(YoaItems.ALEXANDRITE_HELMET);
        simpleItem(YoaItems.ALEXANDRITE_CHESTPLATE);
        simpleItem(YoaItems.ALEXANDRITE_LEGGINGS);
        simpleItem(YoaItems.ALEXANDRITE_BOOTS);

        simpleItem(YoaItems.ADAMANTITE_HELMET);
        simpleItem(YoaItems.ADAMANTITE_CHESTPLATE);
        simpleItem(YoaItems.ADAMANTITE_LEGGINGS);
        simpleItem(YoaItems.ADAMANTITE_BOOTS);

        //Bows
        //simpleItem(ItemsModReg.LONGBOW);

        //WEAPONS
        simpleItem(YoaItems.SILVER_BELL);
        simpleItem(YoaItems.SILVER_BLOW_DART);
        handheldItem(YoaItems.SILVER_BOOMERANG);
        handheldItem(YoaItems.SILVER_CHAKRAM);
        handheldItem(YoaItems.SILVER_CLAWS);
        handheldBigItem(YoaItems.SILVER_CLAYMORE);
        handheldItem(YoaItems.SILVER_DAGGER);
        handheldBigItem(YoaItems.SILVER_GREAT_AXE);
        handheldBigItem(YoaItems.SILVER_HARPOON);
        simpleItem(YoaItems.SILVER_HOLY_RIFLE);
        handheldItem(YoaItems.SILVER_KATANA);
        handheldBigItem(YoaItems.SILVER_LANCE);
        handheldItem(YoaItems.SILVER_LYRE);
        simpleItem(YoaItems.SILVER_MAGICIAN_WAND);
        handheldItem(YoaItems.SILVER_RAPIER);
        handheldBigItem(YoaItems.SILVER_RUNIC_AXE);
        handheldItem(YoaItems.SILVER_RUNIC_BLADE);
        handheldBigItem(YoaItems.SILVER_RUNIC_BLASTER);
        handheldBigItem(YoaItems.SILVER_SCISSORS_SWORD);
        handheldBigItem(YoaItems.SILVER_SINGLE_SCISSORS_SWORD);
        handheldBigItem(YoaItems.SILVER_SCYTHE);
        //simpleItem(ItemsModReg.SILVER_SHOTGUN_SHIELD);
        simpleItem(YoaItems.SILVER_SHURIKEN);
        handheldBigItem(YoaItems.SILVER_SPELLCASTER_STAFF);
        simpleItem(YoaItems.SILVER_TALISMAN);
        handheldItem(YoaItems.SILVER_THROWING_KNIFE);
        handheldItem(YoaItems.SILVER_TOME);
        warFanItem(YoaItems.SILVER_WAR_FAN);
        handheldBigItem(YoaItems.SILVER_WHIP_SWORD);

        simpleItem(YoaItems.GOLD_BELL);
        simpleItem(YoaItems.GOLD_BLOW_DART);
        handheldItem(YoaItems.GOLD_BOOMERANG);
        handheldItem(YoaItems.GOLD_CHAKRAM);
        handheldItem(YoaItems.GOLD_CLAWS);
        handheldBigItem(YoaItems.GOLD_CLAYMORE);
        handheldItem(YoaItems.GOLD_DAGGER);
        handheldBigItem(YoaItems.GOLD_GREAT_AXE);
        handheldBigItem(YoaItems.GOLD_HARPOON);
        simpleItem(YoaItems.GOLD_HOLY_RIFLE);
        handheldItem(YoaItems.GOLD_KATANA);
        handheldBigItem(YoaItems.GOLD_LANCE);
        handheldItem(YoaItems.GOLD_LYRE);
        simpleItem(YoaItems.GOLD_MAGICIAN_WAND);
        handheldItem(YoaItems.GOLD_RAPIER);
        handheldBigItem(YoaItems.GOLD_RUNIC_AXE);
        handheldItem(YoaItems.GOLD_RUNIC_BLADE);
        handheldBigItem(YoaItems.GOLD_RUNIC_BLASTER);
        handheldBigItem(YoaItems.GOLD_SCISSORS_SWORD);
        handheldBigItem(YoaItems.GOLD_SINGLE_SCISSORS_SWORD);
        handheldBigItem(YoaItems.GOLD_SCYTHE);
        //simpleItem(ItemsModReg.GOLD_SHOTGUN_SHIELD);
        simpleItem(YoaItems.GOLD_SHURIKEN);
        handheldBigItem(YoaItems.GOLD_SPELLCASTER_STAFF);
        simpleItem(YoaItems.GOLD_TALISMAN);
        handheldItem(YoaItems.GOLD_THROWING_KNIFE);
        handheldItem(YoaItems.GOLD_TOME);
        warFanItem(YoaItems.GOLD_WAR_FAN);
        handheldBigItem(YoaItems.GOLD_WHIP_SWORD);

        simpleItem(YoaItems.BRONZE_BELL);
        simpleItem(YoaItems.BRONZE_BLOW_DART);
        handheldItem(YoaItems.BRONZE_BOOMERANG);
        handheldItem(YoaItems.BRONZE_CHAKRAM);
        handheldItem(YoaItems.BRONZE_CLAWS);
        handheldBigItem(YoaItems.BRONZE_CLAYMORE);
        handheldItem(YoaItems.BRONZE_DAGGER);
        handheldBigItem(YoaItems.BRONZE_GREAT_AXE);
        handheldBigItem(YoaItems.BRONZE_HARPOON);
        simpleItem(YoaItems.BRONZE_HOLY_RIFLE);
        handheldItem(YoaItems.BRONZE_KATANA);
        handheldBigItem(YoaItems.BRONZE_LANCE);
        handheldItem(YoaItems.BRONZE_LYRE);
        simpleItem(YoaItems.BRONZE_MAGICIAN_WAND);
        handheldItem(YoaItems.BRONZE_RAPIER);
        handheldBigItem(YoaItems.BRONZE_RUNIC_AXE);
        handheldItem(YoaItems.BRONZE_RUNIC_BLADE);
        handheldBigItem(YoaItems.BRONZE_RUNIC_BLASTER);
        handheldBigItem(YoaItems.BRONZE_SCISSORS_SWORD);
        handheldBigItem(YoaItems.BRONZE_SINGLE_SCISSORS_SWORD);
        handheldBigItem(YoaItems.BRONZE_SCYTHE);
        //simpleItem(ItemsModReg.BRONZE_SHOTGUN_SHIELD);
        simpleItem(YoaItems.BRONZE_SHURIKEN);
        handheldBigItem(YoaItems.BRONZE_SPELLCASTER_STAFF);
        simpleItem(YoaItems.BRONZE_TALISMAN);
        handheldItem(YoaItems.BRONZE_THROWING_KNIFE);
        handheldItem(YoaItems.BRONZE_TOME);
        warFanItem(YoaItems.BRONZE_WAR_FAN);
        handheldBigItem(YoaItems.BRONZE_WHIP_SWORD);

        simpleItem(YoaItems.IRON_BELL);
        simpleItem(YoaItems.IRON_BLOW_DART);
        handheldItem(YoaItems.IRON_BOOMERANG);
        handheldItem(YoaItems.IRON_CHAKRAM);
        handheldItem(YoaItems.IRON_CLAWS);
        handheldBigItem(YoaItems.IRON_CLAYMORE);
        handheldItem(YoaItems.IRON_DAGGER);
        handheldBigItem(YoaItems.IRON_GREAT_AXE);
        handheldBigItem(YoaItems.IRON_HARPOON);
        simpleItem(YoaItems.IRON_HOLY_RIFLE);
        handheldItem(YoaItems.IRON_KATANA);
        handheldBigItem(YoaItems.IRON_LANCE);
        handheldItem(YoaItems.IRON_LYRE);
        simpleItem(YoaItems.IRON_MAGICIAN_WAND);
        handheldItem(YoaItems.IRON_RAPIER);
        handheldBigItem(YoaItems.IRON_RUNIC_AXE);
        handheldItem(YoaItems.IRON_RUNIC_BLADE);
        handheldBigItem(YoaItems.IRON_RUNIC_BLASTER);
        handheldBigItem(YoaItems.IRON_SCISSORS_SWORD);
        handheldBigItem(YoaItems.IRON_SINGLE_SCISSORS_SWORD);
        handheldBigItem(YoaItems.IRON_SCYTHE);
        //simpleItem(ItemsModReg.IRON_SHOTGUN_SHIELD);
        simpleItem(YoaItems.IRON_SHURIKEN);
        handheldBigItem(YoaItems.IRON_SPELLCASTER_STAFF);
        simpleItem(YoaItems.IRON_TALISMAN);
        handheldItem(YoaItems.IRON_THROWING_KNIFE);
        handheldItem(YoaItems.IRON_TOME);
        warFanItem(YoaItems.IRON_WAR_FAN);
        handheldBigItem(YoaItems.IRON_WHIP_SWORD);

        simpleItem(YoaItems.STEEL_BELL);
        simpleItem(YoaItems.STEEL_BLOW_DART);
        handheldItem(YoaItems.STEEL_BOOMERANG);
        handheldItem(YoaItems.STEEL_CHAKRAM);
        handheldItem(YoaItems.STEEL_CLAWS);
        handheldBigItem(YoaItems.STEEL_CLAYMORE);
        handheldItem(YoaItems.STEEL_DAGGER);
        handheldBigItem(YoaItems.STEEL_GREAT_AXE);
        handheldBigItem(YoaItems.STEEL_HARPOON);
        simpleItem(YoaItems.STEEL_HOLY_RIFLE);
        handheldItem(YoaItems.STEEL_KATANA);
        handheldBigItem(YoaItems.STEEL_LANCE);
        handheldItem(YoaItems.STEEL_LYRE);
        simpleItem(YoaItems.STEEL_MAGICIAN_WAND);
        handheldItem(YoaItems.STEEL_RAPIER);
        handheldBigItem(YoaItems.STEEL_RUNIC_AXE);
        handheldItem(YoaItems.STEEL_RUNIC_BLADE);
        handheldBigItem(YoaItems.STEEL_RUNIC_BLASTER);
        handheldBigItem(YoaItems.STEEL_SCISSORS_SWORD);
        handheldBigItem(YoaItems.STEEL_SINGLE_SCISSORS_SWORD);
        handheldBigItem(YoaItems.STEEL_SCYTHE);
        //simpleItem(ItemsModReg.STEEL_SHOTGUN_SHIELD);
        simpleItem(YoaItems.STEEL_SHURIKEN);
        handheldBigItem(YoaItems.STEEL_SPELLCASTER_STAFF);
        simpleItem(YoaItems.STEEL_TALISMAN);
        handheldItem(YoaItems.STEEL_THROWING_KNIFE);
        handheldItem(YoaItems.STEEL_TOME);
        warFanItem(YoaItems.STEEL_WAR_FAN);
        handheldBigItem(YoaItems.STEEL_WHIP_SWORD);

        simpleItem(YoaItems.BISMUTH_BELL);
        simpleItem(YoaItems.BISMUTH_BLOW_DART);
        handheldItem(YoaItems.BISMUTH_BOOMERANG);
        handheldItem(YoaItems.BISMUTH_CHAKRAM);
        handheldItem(YoaItems.BISMUTH_CLAWS);
        handheldBigItem(YoaItems.BISMUTH_CLAYMORE);
        handheldItem(YoaItems.BISMUTH_DAGGER);
        handheldBigItem(YoaItems.BISMUTH_GREAT_AXE);
        handheldBigItem(YoaItems.BISMUTH_HARPOON);
        simpleItem(YoaItems.BISMUTH_HOLY_RIFLE);
        handheldItem(YoaItems.BISMUTH_KATANA);
        handheldBigItem(YoaItems.BISMUTH_LANCE);
        handheldItem(YoaItems.BISMUTH_LYRE);
        simpleItem(YoaItems.BISMUTH_MAGICIAN_WAND);
        handheldItem(YoaItems.BISMUTH_RAPIER);
        handheldBigItem(YoaItems.BISMUTH_RUNIC_AXE);
        handheldItem(YoaItems.BISMUTH_RUNIC_BLADE);
        handheldBigItem(YoaItems.BISMUTH_RUNIC_BLASTER);
        handheldBigItem(YoaItems.BISMUTH_SCISSORS_SWORD);
        handheldBigItem(YoaItems.BISMUTH_SINGLE_SCISSORS_SWORD);
        handheldBigItem(YoaItems.BISMUTH_SCYTHE);
        //simpleItem(ItemsModReg.BISMUTH_SHOTGUN_SHIELD);
        simpleItem(YoaItems.BISMUTH_SHURIKEN);
        handheldBigItem(YoaItems.BISMUTH_SPELLCASTER_STAFF);
        simpleItem(YoaItems.BISMUTH_TALISMAN);
        handheldItem(YoaItems.BISMUTH_THROWING_KNIFE);
        handheldItem(YoaItems.BISMUTH_TOME);
        warFanItem(YoaItems.BISMUTH_WAR_FAN);
        handheldBigItem(YoaItems.BISMUTH_WHIP_SWORD);

        simpleItem(YoaItems.DIAMOND_BELL);
        simpleItem(YoaItems.DIAMOND_BLOW_DART);
        handheldItem(YoaItems.DIAMOND_BOOMERANG);
        handheldItem(YoaItems.DIAMOND_CHAKRAM);
        handheldItem(YoaItems.DIAMOND_CLAWS);
        handheldBigItem(YoaItems.DIAMOND_CLAYMORE);
        handheldItem(YoaItems.DIAMOND_DAGGER);
        handheldBigItem(YoaItems.DIAMOND_GREAT_AXE);
        handheldBigItem(YoaItems.DIAMOND_HARPOON);
        simpleItem(YoaItems.DIAMOND_HOLY_RIFLE);
        handheldItem(YoaItems.DIAMOND_KATANA);
        handheldBigItem(YoaItems.DIAMOND_LANCE);
        handheldItem(YoaItems.DIAMOND_LYRE);
        simpleItem(YoaItems.DIAMOND_MAGICIAN_WAND);
        handheldItem(YoaItems.DIAMOND_RAPIER);
        handheldBigItem(YoaItems.DIAMOND_RUNIC_AXE);
        handheldItem(YoaItems.DIAMOND_RUNIC_BLADE);
        handheldBigItem(YoaItems.DIAMOND_RUNIC_BLASTER);
        handheldBigItem(YoaItems.DIAMOND_SCISSORS_SWORD);
        handheldBigItem(YoaItems.DIAMOND_SINGLE_SCISSORS_SWORD);
        handheldBigItem(YoaItems.DIAMOND_SCYTHE);
        //simpleItem(ItemsModReg.DIAMOND_SHOTGUN_SHIELD);
        simpleItem(YoaItems.DIAMOND_SHURIKEN);
        handheldBigItem(YoaItems.DIAMOND_SPELLCASTER_STAFF);
        simpleItem(YoaItems.DIAMOND_TALISMAN);
        handheldItem(YoaItems.DIAMOND_THROWING_KNIFE);
        handheldItem(YoaItems.DIAMOND_TOME);
        warFanItem(YoaItems.DIAMOND_WAR_FAN);
        handheldBigItem(YoaItems.DIAMOND_WHIP_SWORD);

        simpleItem(YoaItems.NETHERITE_BELL);
        simpleItem(YoaItems.NETHERITE_BLOW_DART);
        handheldItem(YoaItems.NETHERITE_BOOMERANG);
        handheldItem(YoaItems.NETHERITE_CHAKRAM);
        handheldItem(YoaItems.NETHERITE_CLAWS);
        handheldBigItem(YoaItems.NETHERITE_CLAYMORE);
        handheldItem(YoaItems.NETHERITE_DAGGER);
        handheldBigItem(YoaItems.NETHERITE_GREAT_AXE);
        handheldBigItem(YoaItems.NETHERITE_HARPOON);
        simpleItem(YoaItems.NETHERITE_HOLY_RIFLE);
        handheldItem(YoaItems.NETHERITE_KATANA);
        handheldBigItem(YoaItems.NETHERITE_LANCE);
        handheldItem(YoaItems.NETHERITE_LYRE);
        simpleItem(YoaItems.NETHERITE_MAGICIAN_WAND);
        handheldItem(YoaItems.NETHERITE_RAPIER);
        handheldBigItem(YoaItems.NETHERITE_RUNIC_AXE);
        handheldItem(YoaItems.NETHERITE_RUNIC_BLADE);
        handheldBigItem(YoaItems.NETHERITE_RUNIC_BLASTER);
        handheldBigItem(YoaItems.NETHERITE_SCISSORS_SWORD);
        handheldBigItem(YoaItems.NETHERITE_SINGLE_SCISSORS_SWORD);
        handheldBigItem(YoaItems.NETHERITE_SCYTHE);
        //simpleItem(ItemsModReg.NETHERITE_SHOTGUN_SHIELD);
        simpleItem(YoaItems.NETHERITE_SHURIKEN);
        handheldBigItem(YoaItems.NETHERITE_SPELLCASTER_STAFF);
        simpleItem(YoaItems.NETHERITE_TALISMAN);
        handheldItem(YoaItems.NETHERITE_THROWING_KNIFE);
        handheldItem(YoaItems.NETHERITE_TOME);
        warFanItem(YoaItems.NETHERITE_WAR_FAN);
        handheldBigItem(YoaItems.NETHERITE_WHIP_SWORD);

        simpleItem(YoaItems.TITANIUM_BELL);
        simpleItem(YoaItems.TITANIUM_BLOW_DART);
        handheldItem(YoaItems.TITANIUM_BOOMERANG);
        handheldItem(YoaItems.TITANIUM_CHAKRAM);
        handheldItem(YoaItems.TITANIUM_CLAWS);
        handheldBigItem(YoaItems.TITANIUM_CLAYMORE);
        handheldItem(YoaItems.TITANIUM_DAGGER);
        handheldBigItem(YoaItems.TITANIUM_GREAT_AXE);
        handheldBigItem(YoaItems.TITANIUM_HARPOON);
        simpleItem(YoaItems.TITANIUM_HOLY_RIFLE);
        handheldItem(YoaItems.TITANIUM_KATANA);
        handheldBigItem(YoaItems.TITANIUM_LANCE);
        handheldItem(YoaItems.TITANIUM_LYRE);
        simpleItem(YoaItems.TITANIUM_MAGICIAN_WAND);
        handheldItem(YoaItems.TITANIUM_RAPIER);
        handheldBigItem(YoaItems.TITANIUM_RUNIC_AXE);
        handheldItem(YoaItems.TITANIUM_RUNIC_BLADE);
        handheldBigItem(YoaItems.TITANIUM_RUNIC_BLASTER);
        handheldBigItem(YoaItems.TITANIUM_SCISSORS_SWORD);
        handheldBigItem(YoaItems.TITANIUM_SINGLE_SCISSORS_SWORD);
        handheldBigItem(YoaItems.TITANIUM_SCYTHE);
        //simpleItem(ItemsModReg.TITANIUM_SHOTGUN_SHIELD);
        simpleItem(YoaItems.TITANIUM_SHURIKEN);
        handheldBigItem(YoaItems.TITANIUM_SPELLCASTER_STAFF);
        simpleItem(YoaItems.TITANIUM_TALISMAN);
        handheldItem(YoaItems.TITANIUM_THROWING_KNIFE);
        handheldItem(YoaItems.TITANIUM_TOME);
        warFanItem(YoaItems.TITANIUM_WAR_FAN);
        handheldBigItem(YoaItems.TITANIUM_WHIP_SWORD);

        simpleItem(YoaItems.IOLITE_BELL);
        simpleItem(YoaItems.IOLITE_BLOW_DART);
        handheldItem(YoaItems.IOLITE_BOOMERANG);
        handheldItem(YoaItems.IOLITE_CHAKRAM);
        handheldItem(YoaItems.IOLITE_CLAWS);
        handheldBigItem(YoaItems.IOLITE_CLAYMORE);
        handheldItem(YoaItems.IOLITE_DAGGER);
        handheldBigItem(YoaItems.IOLITE_GREAT_AXE);
        handheldBigItem(YoaItems.IOLITE_HARPOON);
        simpleItem(YoaItems.IOLITE_HOLY_RIFLE);
        handheldItem(YoaItems.IOLITE_KATANA);
        handheldBigItem(YoaItems.IOLITE_LANCE);
        handheldItem(YoaItems.IOLITE_LYRE);
        simpleItem(YoaItems.IOLITE_MAGICIAN_WAND);
        handheldItem(YoaItems.IOLITE_RAPIER);
        handheldBigItem(YoaItems.IOLITE_RUNIC_AXE);
        handheldItem(YoaItems.IOLITE_RUNIC_BLADE);
        handheldBigItem(YoaItems.IOLITE_RUNIC_BLASTER);
        handheldBigItem(YoaItems.IOLITE_SCISSORS_SWORD);
        handheldBigItem(YoaItems.IOLITE_SINGLE_SCISSORS_SWORD);
        handheldBigItem(YoaItems.IOLITE_SCYTHE);
        //simpleItem(ItemsModReg.IOLITE_SHOTGUN_SHIELD);
        simpleItem(YoaItems.IOLITE_SHURIKEN);
        handheldBigItem(YoaItems.IOLITE_SPELLCASTER_STAFF);
        simpleItem(YoaItems.IOLITE_TALISMAN);
        handheldItem(YoaItems.IOLITE_THROWING_KNIFE);
        handheldItem(YoaItems.IOLITE_TOME);
        warFanItem(YoaItems.IOLITE_WAR_FAN);
        handheldBigItem(YoaItems.IOLITE_WHIP_SWORD);

        simpleItem(YoaItems.ALEXANDRITE_BELL);
        simpleItem(YoaItems.ALEXANDRITE_BLOW_DART);
        handheldItem(YoaItems.ALEXANDRITE_BOOMERANG);
        handheldItem(YoaItems.ALEXANDRITE_CHAKRAM);
        handheldItem(YoaItems.ALEXANDRITE_CLAWS);
        handheldBigItem(YoaItems.ALEXANDRITE_CLAYMORE);
        handheldItem(YoaItems.ALEXANDRITE_DAGGER);
        handheldBigItem(YoaItems.ALEXANDRITE_GREAT_AXE);
        handheldBigItem(YoaItems.ALEXANDRITE_HARPOON);
        simpleItem(YoaItems.ALEXANDRITE_HOLY_RIFLE);
        handheldItem(YoaItems.ALEXANDRITE_KATANA);
        handheldBigItem(YoaItems.ALEXANDRITE_LANCE);
        handheldItem(YoaItems.ALEXANDRITE_LYRE);
        simpleItem(YoaItems.ALEXANDRITE_MAGICIAN_WAND);
        handheldItem(YoaItems.ALEXANDRITE_RAPIER);
        handheldBigItem(YoaItems.ALEXANDRITE_RUNIC_AXE);
        handheldItem(YoaItems.ALEXANDRITE_RUNIC_BLADE);
        handheldBigItem(YoaItems.ALEXANDRITE_RUNIC_BLASTER);
        handheldBigItem(YoaItems.ALEXANDRITE_SCISSORS_SWORD);
        handheldBigItem(YoaItems.ALEXANDRITE_SINGLE_SCISSORS_SWORD);
        handheldBigItem(YoaItems.ALEXANDRITE_SCYTHE);
        //simpleItem(ItemsModReg.ALEXANDRITE_SHOTGUN_SHIELD);
        simpleItem(YoaItems.ALEXANDRITE_SHURIKEN);
        handheldBigItem(YoaItems.ALEXANDRITE_SPELLCASTER_STAFF);
        simpleItem(YoaItems.ALEXANDRITE_TALISMAN);
        handheldItem(YoaItems.ALEXANDRITE_THROWING_KNIFE);
        handheldItem(YoaItems.ALEXANDRITE_TOME);
        warFanItem(YoaItems.ALEXANDRITE_WAR_FAN);
        handheldBigItem(YoaItems.ALEXANDRITE_WHIP_SWORD);

        simpleItem(YoaItems.ADAMANTITE_BELL);
        simpleItem(YoaItems.ADAMANTITE_BLOW_DART);
        handheldItem(YoaItems.ADAMANTITE_BOOMERANG);
        handheldItem(YoaItems.ADAMANTITE_CHAKRAM);
        handheldItem(YoaItems.ADAMANTITE_CLAWS);
        handheldBigItem(YoaItems.ADAMANTITE_CLAYMORE);
        handheldItem(YoaItems.ADAMANTITE_DAGGER);
        handheldBigItem(YoaItems.ADAMANTITE_GREAT_AXE);
        handheldBigItem(YoaItems.ADAMANTITE_HARPOON);
        simpleItem(YoaItems.ADAMANTITE_HOLY_RIFLE);
        handheldItem(YoaItems.ADAMANTITE_KATANA);
        handheldBigItem(YoaItems.ADAMANTITE_LANCE);
        handheldItem(YoaItems.ADAMANTITE_LYRE);
        simpleItem(YoaItems.ADAMANTITE_MAGICIAN_WAND);
        handheldItem(YoaItems.ADAMANTITE_RAPIER);
        handheldBigItem(YoaItems.ADAMANTITE_RUNIC_AXE);
        handheldItem(YoaItems.ADAMANTITE_RUNIC_BLADE);
        handheldBigItem(YoaItems.ADAMANTITE_RUNIC_BLASTER);
        handheldBigItem(YoaItems.ADAMANTITE_SCISSORS_SWORD);
        handheldBigItem(YoaItems.ADAMANTITE_SINGLE_SCISSORS_SWORD);
        handheldBigItem(YoaItems.ADAMANTITE_SCYTHE);
        //simpleItem(ItemsModReg.ADAMANTITE_SHOTGUN_SHIELD);
        simpleItem(YoaItems.ADAMANTITE_SHURIKEN);
        handheldBigItem(YoaItems.ADAMANTITE_SPELLCASTER_STAFF);
        simpleItem(YoaItems.ADAMANTITE_TALISMAN);
        handheldItem(YoaItems.ADAMANTITE_THROWING_KNIFE);
        handheldItem(YoaItems.ADAMANTITE_TOME);
        warFanItem(YoaItems.ADAMANTITE_WAR_FAN);
        handheldBigItem(YoaItems.ADAMANTITE_WHIP_SWORD);


    }

    private void trimmedArmorItem(DeferredItem<?> itemRegistryObject) {
        final String MODID = YOAMod.MODID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            for (Map.Entry<ResourceKey<TrimMaterial>, Float> entry : trimMaterials.entrySet()) {
                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                Float value = entry.getValue();
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MODID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MODID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MODID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            }
        }
    }


    private ItemModelBuilder simpleItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MODID,"item/" + item.getId().getPath()));
    }


    private ItemModelBuilder spawnEggItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/template_spawn_egg"));
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldBigItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation(MODID,"item/handheld_big")).texture("layer0",
                new ResourceLocation(MODID,"item/" + item.getId().getPath()));
    }




    private ItemModelBuilder warFanItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(MODID,"item/" + item.getId().getPath()))
                .override().predicate(new ResourceLocation(MODID, "open"),1.0F)
                .model(openWarFan(item)).end();
    }


    private ItemModelBuilder openWarFan(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath() + "_open",
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(MODID,"item/" + item.getId().getPath() + "_open"));
    }

    private ItemModelBuilder simpleBlockItem(DeferredBlock<?> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MODID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder wallItem(DeferredBlock<?> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("block/generated")).texture("layer0",
                new ResourceLocation(MODID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder slabItem(DeferredBlock<?> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("block/generated")).texture("layer0",
                new ResourceLocation(MODID,"block/" + item.getId().getPath()));
    }


}
