package com.fuyuvulpes.yoamod.datagen.generators;

import com.fuyuvulpes.yoamod.YOAMod;
import com.fuyuvulpes.yoamod.core.registries.ItemsModReg;
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
        spawnEggItem(ItemsModReg.BRAWLER_SPAWN_EGG);
        spawnEggItem(ItemsModReg.BLOCKLING_SPAWN_EGG);
        spawnEggItem(ItemsModReg.ARMED_SPIDER_SPAWN_EGG);

        simpleItem(ItemsModReg.PLANE_ITEM);
        simpleItem(ItemsModReg.CRYSTALIC_SHARD);
        simpleItem(ItemsModReg.RUNE_CRYSTAL);
        simpleItem(ItemsModReg.ADAMANTITE_TEMPLATE);
        simpleItem(ItemsModReg.RETURN_TALISMAN);

        simpleItem(ItemsModReg.ADAMANTITE_INGOT);
        simpleItem(ItemsModReg.ADAMANTITE_NUGGET);
        simpleItem(ItemsModReg.RAW_ADAMANTITE);
        simpleItem(ItemsModReg.ALEXANDRITE);
        simpleItem(ItemsModReg.ALEXANDRITE_SHARD);
        simpleItem(ItemsModReg.MOLTEN_ALEXANDRITE);
        simpleItem(ItemsModReg.BISMUTH);
        simpleItem(ItemsModReg.BISMUTH_SHARD);
        simpleItem(ItemsModReg.RAW_BISMUTH);
        simpleItem(ItemsModReg.MOLTEN_BISMUTH);
        simpleItem(ItemsModReg.BRASS_INGOT);
        simpleItem(ItemsModReg.BRASS_NUGGET);
        simpleItem(ItemsModReg.BRONZE_INGOT);
        simpleItem(ItemsModReg.BRONZE_NUGGET);
        simpleItem(ItemsModReg.MOLTEN_BRONZE);
        simpleItem(ItemsModReg.IOLITE);
        simpleItem(ItemsModReg.IOLITE_SHARD);
        simpleItem(ItemsModReg.MOLTEN_IOLITE);
        simpleItem(ItemsModReg.SILVER_INGOT);
        simpleItem(ItemsModReg.SILVER_NUGGET);
        simpleItem(ItemsModReg.RAW_SILVER);
        simpleItem(ItemsModReg.MOLTEN_SILVER);
        simpleItem(ItemsModReg.STEEL_INGOT);
        simpleItem(ItemsModReg.STEEL_NUGGET);
        simpleItem(ItemsModReg.MOLTEN_STEEL);
        simpleItem(ItemsModReg.TITANIUM_INGOT);
        simpleItem(ItemsModReg.TITANIUM_NUGGET);
        simpleItem(ItemsModReg.RAW_TITANIUM);
        simpleItem(ItemsModReg.MOLTEN_TITANIUM);
        simpleItem(ItemsModReg.WITHERITE);
        simpleItem(ItemsModReg.WITHERITE_SHARD);
        simpleItem(ItemsModReg.MOLTEN_IRON);
        simpleItem(ItemsModReg.MOLTEN_GOLD);
        simpleItem(ItemsModReg.DIAMOND_SHARD);
        simpleItem(ItemsModReg.MOLTEN_DIAMOND);
        simpleItem(ItemsModReg.NETHERITE_NUGGET);

        handheldItem(ItemsModReg.TITANIUM_AXE);
        handheldItem(ItemsModReg.TITANIUM_PICKAXE);
        handheldItem(ItemsModReg.TITANIUM_HOE);
        handheldItem(ItemsModReg.TITANIUM_SHOVEL);

        handheldItem(ItemsModReg.IOLITE_AXE);
        handheldItem(ItemsModReg.IOLITE_PICKAXE);
        handheldItem(ItemsModReg.IOLITE_HOE);
        handheldItem(ItemsModReg.IOLITE_SHOVEL);

        handheldItem(ItemsModReg.ALEXANDRITE_AXE);
        handheldItem(ItemsModReg.ALEXANDRITE_PICKAXE);
        handheldItem(ItemsModReg.ALEXANDRITE_HOE);
        handheldItem(ItemsModReg.ALEXANDRITE_SHOVEL);

        handheldItem(ItemsModReg.ADAMANTITE_AXE);
        handheldItem(ItemsModReg.ADAMANTITE_PICKAXE);
        handheldItem(ItemsModReg.ADAMANTITE_HOE);
        handheldItem(ItemsModReg.ADAMANTITE_SHOVEL);

        simpleItem(ItemsModReg.SILVER_HELMET);
        simpleItem(ItemsModReg.SILVER_CHESTPLATE);
        simpleItem(ItemsModReg.SILVER_LEGGINGS);
        simpleItem(ItemsModReg.SILVER_BOOTS);

        simpleItem(ItemsModReg.WITHERITE_HELMET);
        simpleItem(ItemsModReg.WITHERITE_CHESTPLATE);
        simpleItem(ItemsModReg.WITHERITE_LEGGINGS);
        simpleItem(ItemsModReg.WITHERITE_BOOTS);

        simpleItem(ItemsModReg.IOLITE_HELMET);
        simpleItem(ItemsModReg.IOLITE_CHESTPLATE);
        simpleItem(ItemsModReg.IOLITE_LEGGINGS);
        simpleItem(ItemsModReg.IOLITE_BOOTS);

        simpleItem(ItemsModReg.ALEXANDRITE_HELMET);
        simpleItem(ItemsModReg.ALEXANDRITE_CHESTPLATE);
        simpleItem(ItemsModReg.ALEXANDRITE_LEGGINGS);
        simpleItem(ItemsModReg.ALEXANDRITE_BOOTS);

        simpleItem(ItemsModReg.ADAMANTITE_HELMET);
        simpleItem(ItemsModReg.ADAMANTITE_CHESTPLATE);
        simpleItem(ItemsModReg.ADAMANTITE_LEGGINGS);
        simpleItem(ItemsModReg.ADAMANTITE_BOOTS);

        //Bows
        //simpleItem(ItemsModReg.LONGBOW);

        //WEAPONS
        simpleItem(ItemsModReg.SILVER_BELL);
        simpleItem(ItemsModReg.SILVER_BLOW_DART);
        handheldItem(ItemsModReg.SILVER_BOOMERANG);
        handheldItem(ItemsModReg.SILVER_CHAKRAM);
        handheldItem(ItemsModReg.SILVER_CLAWS);
        handheldBigItem(ItemsModReg.SILVER_CLAYMORE);
        handheldItem(ItemsModReg.SILVER_DAGGER);
        handheldBigItem(ItemsModReg.SILVER_GREAT_AXE);
        handheldBigItem(ItemsModReg.SILVER_HARPOON);
        simpleItem(ItemsModReg.SILVER_HOLY_RIFLE);
        handheldItem(ItemsModReg.SILVER_KATANA);
        handheldBigItem(ItemsModReg.SILVER_LANCE);
        handheldItem(ItemsModReg.SILVER_LYRE);
        simpleItem(ItemsModReg.SILVER_MAGICIAN_WAND);
        handheldItem(ItemsModReg.SILVER_RAPIER);
        handheldBigItem(ItemsModReg.SILVER_RUNIC_AXE);
        handheldItem(ItemsModReg.SILVER_RUNIC_BLADE);
        handheldBigItem(ItemsModReg.SILVER_RUNIC_BLASTER);
        handheldBigItem(ItemsModReg.SILVER_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.SILVER_SINGLE_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.SILVER_SCYTHE);
        //simpleItem(ItemsModReg.SILVER_SHOTGUN_SHIELD);
        simpleItem(ItemsModReg.SILVER_SHURIKEN);
        handheldBigItem(ItemsModReg.SILVER_SPELLCASTER_STAFF);
        simpleItem(ItemsModReg.SILVER_TALISMAN);
        handheldItem(ItemsModReg.SILVER_THROWING_KNIFE);
        handheldItem(ItemsModReg.SILVER_TOME);
        warFanItem(ItemsModReg.SILVER_WAR_FAN);
        handheldBigItem(ItemsModReg.SILVER_WHIP_SWORD);

        simpleItem(ItemsModReg.GOLD_BELL);
        simpleItem(ItemsModReg.GOLD_BLOW_DART);
        handheldItem(ItemsModReg.GOLD_BOOMERANG);
        handheldItem(ItemsModReg.GOLD_CHAKRAM);
        handheldItem(ItemsModReg.GOLD_CLAWS);
        handheldBigItem(ItemsModReg.GOLD_CLAYMORE);
        handheldItem(ItemsModReg.GOLD_DAGGER);
        handheldBigItem(ItemsModReg.GOLD_GREAT_AXE);
        handheldBigItem(ItemsModReg.GOLD_HARPOON);
        simpleItem(ItemsModReg.GOLD_HOLY_RIFLE);
        handheldItem(ItemsModReg.GOLD_KATANA);
        handheldBigItem(ItemsModReg.GOLD_LANCE);
        handheldItem(ItemsModReg.GOLD_LYRE);
        simpleItem(ItemsModReg.GOLD_MAGICIAN_WAND);
        handheldItem(ItemsModReg.GOLD_RAPIER);
        handheldBigItem(ItemsModReg.GOLD_RUNIC_AXE);
        handheldItem(ItemsModReg.GOLD_RUNIC_BLADE);
        handheldBigItem(ItemsModReg.GOLD_RUNIC_BLASTER);
        handheldBigItem(ItemsModReg.GOLD_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.GOLD_SINGLE_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.GOLD_SCYTHE);
        //simpleItem(ItemsModReg.GOLD_SHOTGUN_SHIELD);
        simpleItem(ItemsModReg.GOLD_SHURIKEN);
        handheldBigItem(ItemsModReg.GOLD_SPELLCASTER_STAFF);
        simpleItem(ItemsModReg.GOLD_TALISMAN);
        handheldItem(ItemsModReg.GOLD_THROWING_KNIFE);
        handheldItem(ItemsModReg.GOLD_TOME);
        warFanItem(ItemsModReg.GOLD_WAR_FAN);
        handheldBigItem(ItemsModReg.GOLD_WHIP_SWORD);

        simpleItem(ItemsModReg.BRONZE_BELL);
        simpleItem(ItemsModReg.BRONZE_BLOW_DART);
        handheldItem(ItemsModReg.BRONZE_BOOMERANG);
        handheldItem(ItemsModReg.BRONZE_CHAKRAM);
        handheldItem(ItemsModReg.BRONZE_CLAWS);
        handheldBigItem(ItemsModReg.BRONZE_CLAYMORE);
        handheldItem(ItemsModReg.BRONZE_DAGGER);
        handheldBigItem(ItemsModReg.BRONZE_GREAT_AXE);
        handheldBigItem(ItemsModReg.BRONZE_HARPOON);
        simpleItem(ItemsModReg.BRONZE_HOLY_RIFLE);
        handheldItem(ItemsModReg.BRONZE_KATANA);
        handheldBigItem(ItemsModReg.BRONZE_LANCE);
        handheldItem(ItemsModReg.BRONZE_LYRE);
        simpleItem(ItemsModReg.BRONZE_MAGICIAN_WAND);
        handheldItem(ItemsModReg.BRONZE_RAPIER);
        handheldBigItem(ItemsModReg.BRONZE_RUNIC_AXE);
        handheldItem(ItemsModReg.BRONZE_RUNIC_BLADE);
        handheldBigItem(ItemsModReg.BRONZE_RUNIC_BLASTER);
        handheldBigItem(ItemsModReg.BRONZE_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.BRONZE_SINGLE_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.BRONZE_SCYTHE);
        //simpleItem(ItemsModReg.BRONZE_SHOTGUN_SHIELD);
        simpleItem(ItemsModReg.BRONZE_SHURIKEN);
        handheldBigItem(ItemsModReg.BRONZE_SPELLCASTER_STAFF);
        simpleItem(ItemsModReg.BRONZE_TALISMAN);
        handheldItem(ItemsModReg.BRONZE_THROWING_KNIFE);
        handheldItem(ItemsModReg.BRONZE_TOME);
        warFanItem(ItemsModReg.BRONZE_WAR_FAN);
        handheldBigItem(ItemsModReg.BRONZE_WHIP_SWORD);

        simpleItem(ItemsModReg.IRON_BELL);
        simpleItem(ItemsModReg.IRON_BLOW_DART);
        handheldItem(ItemsModReg.IRON_BOOMERANG);
        handheldItem(ItemsModReg.IRON_CHAKRAM);
        handheldItem(ItemsModReg.IRON_CLAWS);
        handheldBigItem(ItemsModReg.IRON_CLAYMORE);
        handheldItem(ItemsModReg.IRON_DAGGER);
        handheldBigItem(ItemsModReg.IRON_GREAT_AXE);
        handheldBigItem(ItemsModReg.IRON_HARPOON);
        simpleItem(ItemsModReg.IRON_HOLY_RIFLE);
        handheldItem(ItemsModReg.IRON_KATANA);
        handheldBigItem(ItemsModReg.IRON_LANCE);
        handheldItem(ItemsModReg.IRON_LYRE);
        simpleItem(ItemsModReg.IRON_MAGICIAN_WAND);
        handheldItem(ItemsModReg.IRON_RAPIER);
        handheldBigItem(ItemsModReg.IRON_RUNIC_AXE);
        handheldItem(ItemsModReg.IRON_RUNIC_BLADE);
        handheldBigItem(ItemsModReg.IRON_RUNIC_BLASTER);
        handheldBigItem(ItemsModReg.IRON_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.IRON_SINGLE_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.IRON_SCYTHE);
        //simpleItem(ItemsModReg.IRON_SHOTGUN_SHIELD);
        simpleItem(ItemsModReg.IRON_SHURIKEN);
        handheldBigItem(ItemsModReg.IRON_SPELLCASTER_STAFF);
        simpleItem(ItemsModReg.IRON_TALISMAN);
        handheldItem(ItemsModReg.IRON_THROWING_KNIFE);
        handheldItem(ItemsModReg.IRON_TOME);
        warFanItem(ItemsModReg.IRON_WAR_FAN);
        handheldBigItem(ItemsModReg.IRON_WHIP_SWORD);

        simpleItem(ItemsModReg.STEEL_BELL);
        simpleItem(ItemsModReg.STEEL_BLOW_DART);
        handheldItem(ItemsModReg.STEEL_BOOMERANG);
        handheldItem(ItemsModReg.STEEL_CHAKRAM);
        handheldItem(ItemsModReg.STEEL_CLAWS);
        handheldBigItem(ItemsModReg.STEEL_CLAYMORE);
        handheldItem(ItemsModReg.STEEL_DAGGER);
        handheldBigItem(ItemsModReg.STEEL_GREAT_AXE);
        handheldBigItem(ItemsModReg.STEEL_HARPOON);
        simpleItem(ItemsModReg.STEEL_HOLY_RIFLE);
        handheldItem(ItemsModReg.STEEL_KATANA);
        handheldBigItem(ItemsModReg.STEEL_LANCE);
        handheldItem(ItemsModReg.STEEL_LYRE);
        simpleItem(ItemsModReg.STEEL_MAGICIAN_WAND);
        handheldItem(ItemsModReg.STEEL_RAPIER);
        handheldBigItem(ItemsModReg.STEEL_RUNIC_AXE);
        handheldItem(ItemsModReg.STEEL_RUNIC_BLADE);
        handheldBigItem(ItemsModReg.STEEL_RUNIC_BLASTER);
        handheldBigItem(ItemsModReg.STEEL_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.STEEL_SINGLE_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.STEEL_SCYTHE);
        //simpleItem(ItemsModReg.STEEL_SHOTGUN_SHIELD);
        simpleItem(ItemsModReg.STEEL_SHURIKEN);
        handheldBigItem(ItemsModReg.STEEL_SPELLCASTER_STAFF);
        simpleItem(ItemsModReg.STEEL_TALISMAN);
        handheldItem(ItemsModReg.STEEL_THROWING_KNIFE);
        handheldItem(ItemsModReg.STEEL_TOME);
        warFanItem(ItemsModReg.STEEL_WAR_FAN);
        handheldBigItem(ItemsModReg.STEEL_WHIP_SWORD);

        simpleItem(ItemsModReg.BISMUTH_BELL);
        simpleItem(ItemsModReg.BISMUTH_BLOW_DART);
        handheldItem(ItemsModReg.BISMUTH_BOOMERANG);
        handheldItem(ItemsModReg.BISMUTH_CHAKRAM);
        handheldItem(ItemsModReg.BISMUTH_CLAWS);
        handheldBigItem(ItemsModReg.BISMUTH_CLAYMORE);
        handheldItem(ItemsModReg.BISMUTH_DAGGER);
        handheldBigItem(ItemsModReg.BISMUTH_GREAT_AXE);
        handheldBigItem(ItemsModReg.BISMUTH_HARPOON);
        simpleItem(ItemsModReg.BISMUTH_HOLY_RIFLE);
        handheldItem(ItemsModReg.BISMUTH_KATANA);
        handheldBigItem(ItemsModReg.BISMUTH_LANCE);
        handheldItem(ItemsModReg.BISMUTH_LYRE);
        simpleItem(ItemsModReg.BISMUTH_MAGICIAN_WAND);
        handheldItem(ItemsModReg.BISMUTH_RAPIER);
        handheldBigItem(ItemsModReg.BISMUTH_RUNIC_AXE);
        handheldItem(ItemsModReg.BISMUTH_RUNIC_BLADE);
        handheldBigItem(ItemsModReg.BISMUTH_RUNIC_BLASTER);
        handheldBigItem(ItemsModReg.BISMUTH_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.BISMUTH_SINGLE_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.BISMUTH_SCYTHE);
        //simpleItem(ItemsModReg.BISMUTH_SHOTGUN_SHIELD);
        simpleItem(ItemsModReg.BISMUTH_SHURIKEN);
        handheldBigItem(ItemsModReg.BISMUTH_SPELLCASTER_STAFF);
        simpleItem(ItemsModReg.BISMUTH_TALISMAN);
        handheldItem(ItemsModReg.BISMUTH_THROWING_KNIFE);
        handheldItem(ItemsModReg.BISMUTH_TOME);
        warFanItem(ItemsModReg.BISMUTH_WAR_FAN);
        handheldBigItem(ItemsModReg.BISMUTH_WHIP_SWORD);

        simpleItem(ItemsModReg.DIAMOND_BELL);
        simpleItem(ItemsModReg.DIAMOND_BLOW_DART);
        handheldItem(ItemsModReg.DIAMOND_BOOMERANG);
        handheldItem(ItemsModReg.DIAMOND_CHAKRAM);
        handheldItem(ItemsModReg.DIAMOND_CLAWS);
        handheldBigItem(ItemsModReg.DIAMOND_CLAYMORE);
        handheldItem(ItemsModReg.DIAMOND_DAGGER);
        handheldBigItem(ItemsModReg.DIAMOND_GREAT_AXE);
        handheldBigItem(ItemsModReg.DIAMOND_HARPOON);
        simpleItem(ItemsModReg.DIAMOND_HOLY_RIFLE);
        handheldItem(ItemsModReg.DIAMOND_KATANA);
        handheldBigItem(ItemsModReg.DIAMOND_LANCE);
        handheldItem(ItemsModReg.DIAMOND_LYRE);
        simpleItem(ItemsModReg.DIAMOND_MAGICIAN_WAND);
        handheldItem(ItemsModReg.DIAMOND_RAPIER);
        handheldBigItem(ItemsModReg.DIAMOND_RUNIC_AXE);
        handheldItem(ItemsModReg.DIAMOND_RUNIC_BLADE);
        handheldBigItem(ItemsModReg.DIAMOND_RUNIC_BLASTER);
        handheldBigItem(ItemsModReg.DIAMOND_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.DIAMOND_SINGLE_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.DIAMOND_SCYTHE);
        //simpleItem(ItemsModReg.DIAMOND_SHOTGUN_SHIELD);
        simpleItem(ItemsModReg.DIAMOND_SHURIKEN);
        handheldBigItem(ItemsModReg.DIAMOND_SPELLCASTER_STAFF);
        simpleItem(ItemsModReg.DIAMOND_TALISMAN);
        handheldItem(ItemsModReg.DIAMOND_THROWING_KNIFE);
        handheldItem(ItemsModReg.DIAMOND_TOME);
        warFanItem(ItemsModReg.DIAMOND_WAR_FAN);
        handheldBigItem(ItemsModReg.DIAMOND_WHIP_SWORD);

        simpleItem(ItemsModReg.NETHERITE_BELL);
        simpleItem(ItemsModReg.NETHERITE_BLOW_DART);
        handheldItem(ItemsModReg.NETHERITE_BOOMERANG);
        handheldItem(ItemsModReg.NETHERITE_CHAKRAM);
        handheldItem(ItemsModReg.NETHERITE_CLAWS);
        handheldBigItem(ItemsModReg.NETHERITE_CLAYMORE);
        handheldItem(ItemsModReg.NETHERITE_DAGGER);
        handheldBigItem(ItemsModReg.NETHERITE_GREAT_AXE);
        handheldBigItem(ItemsModReg.NETHERITE_HARPOON);
        simpleItem(ItemsModReg.NETHERITE_HOLY_RIFLE);
        handheldItem(ItemsModReg.NETHERITE_KATANA);
        handheldBigItem(ItemsModReg.NETHERITE_LANCE);
        handheldItem(ItemsModReg.NETHERITE_LYRE);
        simpleItem(ItemsModReg.NETHERITE_MAGICIAN_WAND);
        handheldItem(ItemsModReg.NETHERITE_RAPIER);
        handheldBigItem(ItemsModReg.NETHERITE_RUNIC_AXE);
        handheldItem(ItemsModReg.NETHERITE_RUNIC_BLADE);
        handheldBigItem(ItemsModReg.NETHERITE_RUNIC_BLASTER);
        handheldBigItem(ItemsModReg.NETHERITE_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.NETHERITE_SINGLE_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.NETHERITE_SCYTHE);
        //simpleItem(ItemsModReg.NETHERITE_SHOTGUN_SHIELD);
        simpleItem(ItemsModReg.NETHERITE_SHURIKEN);
        handheldBigItem(ItemsModReg.NETHERITE_SPELLCASTER_STAFF);
        simpleItem(ItemsModReg.NETHERITE_TALISMAN);
        handheldItem(ItemsModReg.NETHERITE_THROWING_KNIFE);
        handheldItem(ItemsModReg.NETHERITE_TOME);
        warFanItem(ItemsModReg.NETHERITE_WAR_FAN);
        handheldBigItem(ItemsModReg.NETHERITE_WHIP_SWORD);

        simpleItem(ItemsModReg.TITANIUM_BELL);
        simpleItem(ItemsModReg.TITANIUM_BLOW_DART);
        handheldItem(ItemsModReg.TITANIUM_BOOMERANG);
        handheldItem(ItemsModReg.TITANIUM_CHAKRAM);
        handheldItem(ItemsModReg.TITANIUM_CLAWS);
        handheldBigItem(ItemsModReg.TITANIUM_CLAYMORE);
        handheldItem(ItemsModReg.TITANIUM_DAGGER);
        handheldBigItem(ItemsModReg.TITANIUM_GREAT_AXE);
        handheldBigItem(ItemsModReg.TITANIUM_HARPOON);
        simpleItem(ItemsModReg.TITANIUM_HOLY_RIFLE);
        handheldItem(ItemsModReg.TITANIUM_KATANA);
        handheldBigItem(ItemsModReg.TITANIUM_LANCE);
        handheldItem(ItemsModReg.TITANIUM_LYRE);
        simpleItem(ItemsModReg.TITANIUM_MAGICIAN_WAND);
        handheldItem(ItemsModReg.TITANIUM_RAPIER);
        handheldBigItem(ItemsModReg.TITANIUM_RUNIC_AXE);
        handheldItem(ItemsModReg.TITANIUM_RUNIC_BLADE);
        handheldBigItem(ItemsModReg.TITANIUM_RUNIC_BLASTER);
        handheldBigItem(ItemsModReg.TITANIUM_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.TITANIUM_SINGLE_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.TITANIUM_SCYTHE);
        //simpleItem(ItemsModReg.TITANIUM_SHOTGUN_SHIELD);
        simpleItem(ItemsModReg.TITANIUM_SHURIKEN);
        handheldBigItem(ItemsModReg.TITANIUM_SPELLCASTER_STAFF);
        simpleItem(ItemsModReg.TITANIUM_TALISMAN);
        handheldItem(ItemsModReg.TITANIUM_THROWING_KNIFE);
        handheldItem(ItemsModReg.TITANIUM_TOME);
        warFanItem(ItemsModReg.TITANIUM_WAR_FAN);
        handheldBigItem(ItemsModReg.TITANIUM_WHIP_SWORD);

        simpleItem(ItemsModReg.IOLITE_BELL);
        simpleItem(ItemsModReg.IOLITE_BLOW_DART);
        handheldItem(ItemsModReg.IOLITE_BOOMERANG);
        handheldItem(ItemsModReg.IOLITE_CHAKRAM);
        handheldItem(ItemsModReg.IOLITE_CLAWS);
        handheldBigItem(ItemsModReg.IOLITE_CLAYMORE);
        handheldItem(ItemsModReg.IOLITE_DAGGER);
        handheldBigItem(ItemsModReg.IOLITE_GREAT_AXE);
        handheldBigItem(ItemsModReg.IOLITE_HARPOON);
        simpleItem(ItemsModReg.IOLITE_HOLY_RIFLE);
        handheldItem(ItemsModReg.IOLITE_KATANA);
        handheldBigItem(ItemsModReg.IOLITE_LANCE);
        handheldItem(ItemsModReg.IOLITE_LYRE);
        simpleItem(ItemsModReg.IOLITE_MAGICIAN_WAND);
        handheldItem(ItemsModReg.IOLITE_RAPIER);
        handheldBigItem(ItemsModReg.IOLITE_RUNIC_AXE);
        handheldItem(ItemsModReg.IOLITE_RUNIC_BLADE);
        handheldBigItem(ItemsModReg.IOLITE_RUNIC_BLASTER);
        handheldBigItem(ItemsModReg.IOLITE_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.IOLITE_SINGLE_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.IOLITE_SCYTHE);
        //simpleItem(ItemsModReg.IOLITE_SHOTGUN_SHIELD);
        simpleItem(ItemsModReg.IOLITE_SHURIKEN);
        handheldBigItem(ItemsModReg.IOLITE_SPELLCASTER_STAFF);
        simpleItem(ItemsModReg.IOLITE_TALISMAN);
        handheldItem(ItemsModReg.IOLITE_THROWING_KNIFE);
        handheldItem(ItemsModReg.IOLITE_TOME);
        warFanItem(ItemsModReg.IOLITE_WAR_FAN);
        handheldBigItem(ItemsModReg.IOLITE_WHIP_SWORD);

        simpleItem(ItemsModReg.ALEXANDRITE_BELL);
        simpleItem(ItemsModReg.ALEXANDRITE_BLOW_DART);
        handheldItem(ItemsModReg.ALEXANDRITE_BOOMERANG);
        handheldItem(ItemsModReg.ALEXANDRITE_CHAKRAM);
        handheldItem(ItemsModReg.ALEXANDRITE_CLAWS);
        handheldBigItem(ItemsModReg.ALEXANDRITE_CLAYMORE);
        handheldItem(ItemsModReg.ALEXANDRITE_DAGGER);
        handheldBigItem(ItemsModReg.ALEXANDRITE_GREAT_AXE);
        handheldBigItem(ItemsModReg.ALEXANDRITE_HARPOON);
        simpleItem(ItemsModReg.ALEXANDRITE_HOLY_RIFLE);
        handheldItem(ItemsModReg.ALEXANDRITE_KATANA);
        handheldBigItem(ItemsModReg.ALEXANDRITE_LANCE);
        handheldItem(ItemsModReg.ALEXANDRITE_LYRE);
        simpleItem(ItemsModReg.ALEXANDRITE_MAGICIAN_WAND);
        handheldItem(ItemsModReg.ALEXANDRITE_RAPIER);
        handheldBigItem(ItemsModReg.ALEXANDRITE_RUNIC_AXE);
        handheldItem(ItemsModReg.ALEXANDRITE_RUNIC_BLADE);
        handheldBigItem(ItemsModReg.ALEXANDRITE_RUNIC_BLASTER);
        handheldBigItem(ItemsModReg.ALEXANDRITE_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.ALEXANDRITE_SINGLE_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.ALEXANDRITE_SCYTHE);
        //simpleItem(ItemsModReg.ALEXANDRITE_SHOTGUN_SHIELD);
        simpleItem(ItemsModReg.ALEXANDRITE_SHURIKEN);
        handheldBigItem(ItemsModReg.ALEXANDRITE_SPELLCASTER_STAFF);
        simpleItem(ItemsModReg.ALEXANDRITE_TALISMAN);
        handheldItem(ItemsModReg.ALEXANDRITE_THROWING_KNIFE);
        handheldItem(ItemsModReg.ALEXANDRITE_TOME);
        warFanItem(ItemsModReg.ALEXANDRITE_WAR_FAN);
        handheldBigItem(ItemsModReg.ALEXANDRITE_WHIP_SWORD);

        simpleItem(ItemsModReg.ADAMANTITE_BELL);
        simpleItem(ItemsModReg.ADAMANTITE_BLOW_DART);
        handheldItem(ItemsModReg.ADAMANTITE_BOOMERANG);
        handheldItem(ItemsModReg.ADAMANTITE_CHAKRAM);
        handheldItem(ItemsModReg.ADAMANTITE_CLAWS);
        handheldBigItem(ItemsModReg.ADAMANTITE_CLAYMORE);
        handheldItem(ItemsModReg.ADAMANTITE_DAGGER);
        handheldBigItem(ItemsModReg.ADAMANTITE_GREAT_AXE);
        handheldBigItem(ItemsModReg.ADAMANTITE_HARPOON);
        simpleItem(ItemsModReg.ADAMANTITE_HOLY_RIFLE);
        handheldItem(ItemsModReg.ADAMANTITE_KATANA);
        handheldBigItem(ItemsModReg.ADAMANTITE_LANCE);
        handheldItem(ItemsModReg.ADAMANTITE_LYRE);
        simpleItem(ItemsModReg.ADAMANTITE_MAGICIAN_WAND);
        handheldItem(ItemsModReg.ADAMANTITE_RAPIER);
        handheldBigItem(ItemsModReg.ADAMANTITE_RUNIC_AXE);
        handheldItem(ItemsModReg.ADAMANTITE_RUNIC_BLADE);
        handheldBigItem(ItemsModReg.ADAMANTITE_RUNIC_BLASTER);
        handheldBigItem(ItemsModReg.ADAMANTITE_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.ADAMANTITE_SINGLE_SCISSORS_SWORD);
        handheldBigItem(ItemsModReg.ADAMANTITE_SCYTHE);
        //simpleItem(ItemsModReg.ADAMANTITE_SHOTGUN_SHIELD);
        simpleItem(ItemsModReg.ADAMANTITE_SHURIKEN);
        handheldBigItem(ItemsModReg.ADAMANTITE_SPELLCASTER_STAFF);
        simpleItem(ItemsModReg.ADAMANTITE_TALISMAN);
        handheldItem(ItemsModReg.ADAMANTITE_THROWING_KNIFE);
        handheldItem(ItemsModReg.ADAMANTITE_TOME);
        warFanItem(ItemsModReg.ADAMANTITE_WAR_FAN);
        handheldBigItem(ItemsModReg.ADAMANTITE_WHIP_SWORD);



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
