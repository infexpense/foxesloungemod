package com.fuyuvulpes.yoamod.data.generators;

import com.fuyuvulpes.yoamod.core.registries.YoaBlocks;
import com.fuyuvulpes.yoamod.core.registries.YoaItems;
import com.fuyuvulpes.yoamod.game.server.crafting.CrucibleRecipeBuilder;
import com.fuyuvulpes.yoamod.game.server.crafting.HammeringStationRecipeBuilder;
import com.google.common.collect.ImmutableList;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.crafting.IngredientType;

public class RecipeGen extends RecipeProvider implements IConditionBuilder {
    public static final ImmutableList<ItemLike> IRON_SMELTABLES;
    public static final ImmutableList<ItemLike> DIAMOND_SMELTABLES;
    public static final ImmutableList<ItemLike> SILVER_SMELTABLES;
    public static final ImmutableList<ItemLike> BISMUTH_SMELTABLES;
    public static final ImmutableList<ItemLike> TITANIUM_SMELTABLES;
    public static final ImmutableList<ItemLike> IOLITE_SMELTABLES;
    public static final ImmutableList<ItemLike> WITHERITE_SMELTABLES;
    public static final ImmutableList<ItemLike> ALEXANDRITE_SMELTABLES;
    public static final ImmutableList<ItemLike> ADAMANTITE_SMELTABLES;

    public RecipeGen(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        yoaCookRecipes(output, "smoking", RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, 100);
        yoaCookRecipes(output, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, 600);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(YoaItems.RAW_BIG_MEAT), RecipeCategory.FOOD, YoaItems.COOKED_BIG_MEAT, 0.35F, 200)
                .unlockedBy("has_meat", has(YoaItems.RAW_BIG_MEAT))
                .save(output,"big_meat_cooking");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(YoaItems.SLICED_RAW_MEAT), RecipeCategory.FOOD, YoaItems.SLICED_COOKED_MEAT, 0.35F, 200)
                .unlockedBy("has_meat_slice", has(YoaItems.SLICED_RAW_MEAT))
                .save(output,"sliced_meat_cooking");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,YoaItems.SLICED_RAW_MEAT,3).requires(YoaItems.RAW_BIG_MEAT)
                .unlockedBy("has_raw_meat",has(YoaItems.RAW_BIG_MEAT))
                .save(output,"sliced_raw_meat_from_cutting");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,YoaItems.SLICED_COOKED_MEAT,3).requires(YoaItems.COOKED_BIG_MEAT)
                .unlockedBy("has_meat",has(YoaItems.COOKED_BIG_MEAT))
                .save(output,"sliced_meat_from_cutting");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,YoaItems.RUNE_CRYSTAL,8).requires(YoaItems.ANCIENT_GEMSTONE)
                .unlockedBy("has_gemstone",has(YoaItems.ANCIENT_GEMSTONE))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,Items.BONE_MEAL,6).requires(YoaItems.TUSK)
                .unlockedBy("has_tusk",has(YoaItems.TUSK)).save(output,"bone_meal_from_tusk");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,YoaItems.HAMBURGER)
                .define('M',YoaItems.SLICED_COOKED_MEAT).define('B',Items.BREAD).define('P',Items.POTATO)
                .define('C', Items.CARROT)
                .pattern(" B ")
                .pattern("PMC")
                .pattern(" B ")
                .unlockedBy("has_meat",has(YoaItems.COOKED_BIG_MEAT))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, YoaBlocks.CRUCIBLE.get())
                .define('I', Items.IRON_INGOT).define('B', Items.BUCKET).define('C', ItemTags.STONE_TOOL_MATERIALS)
                .pattern("I B")
                .pattern("IIC")
                .pattern("CCC")
                .unlockedBy("has_stone",has(Tags.Items.COBBLESTONE))
                .save(output);


        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, YoaBlocks.HAMMERING_STATION.get())
                .define('I', Items.IRON_INGOT).define('P', ItemTags.PLANKS).define('C', ItemTags.STONE_TOOL_MATERIALS)
                .pattern("II")
                .pattern("PC")
                .unlockedBy("has_stone",has(Tags.Items.COBBLESTONE))
                .save(output);

        makeStoneSetRecipe(output, YoaBlocks.CREAKSTONE.get(), YoaBlocks.CREAKSTONE_STAIRS.get(), YoaBlocks.CREAKSTONE_SLAB, YoaBlocks.CREAKSTONE_WALL);
        makeStoneSetRecipe(output, YoaBlocks.CREAKSTONE_TILES.get(), YoaBlocks.CREAKSTONE_TILES_STAIRS.get(), YoaBlocks.CREAKSTONE_TILES_SLAB, YoaBlocks.CREAKSTONE_TILES_WALL);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, YoaBlocks.CRYSTALIC_CREAKSTONE_TILES, 4).define('#', YoaBlocks.CREAKSTONE_TILES).define('X', YoaItems.CRYSTALIC_SHARD).
                pattern("#X").
                pattern("X#").unlockedBy("has_crystalic_shard", has(YoaItems.CRYSTALIC_SHARD)).save(output);
        makeStoneSetRecipe(output, YoaBlocks.CRYSTALIC_CREAKSTONE_TILES.get(), YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_STAIRS.get(), YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_SLAB, YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_WALL);
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, YoaItems.ADAMANTITE_NUGGET.get(), RecipeCategory.MISC, YoaItems.ADAMANTITE_INGOT, "adamantite_ingot_from_nuggets", "adamantite_ingot");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, YoaItems.ADAMANTITE_INGOT, RecipeCategory.MISC, YoaBlocks.ADAMANTITE_BLOCK, "adamantite_ingot_from_adamantite_block", "adamantite_ingot");
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, YoaItems.ALEXANDRITE_SHARD.get(), RecipeCategory.MISC, YoaItems.ALEXANDRITE, "alexandrite_from_shards", "alexandrite");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, YoaItems.ALEXANDRITE, RecipeCategory.MISC, YoaBlocks.ALEXANDRITE_BLOCK, "alexandrite_from_adamantite_block", "alexandrite");
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, YoaItems.BISMUTH_SHARD.get(), RecipeCategory.MISC, YoaItems.BISMUTH, "bismuth_from_shards", "bismuth");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, YoaItems.BISMUTH, RecipeCategory.MISC, YoaBlocks.BISMUTH_BLOCK, "bismuth_from_bismuth_block", "bismuth");
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, YoaItems.BRONZE_NUGGET.get(), RecipeCategory.MISC, YoaItems.BRONZE_INGOT, "bronze_ingot_from_nuggets", "bronze_ingot");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, YoaItems.BRONZE_INGOT, RecipeCategory.MISC, YoaBlocks.BRONZE_BLOCK, "bronze_ingot_from_bronze_block", "bronze_ingot");
        nineBlockStorageRecipes(output, RecipeCategory.MISC, YoaItems.DIAMOND_SHARD.get(), RecipeCategory.MISC, Items.DIAMOND);
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, YoaItems.IOLITE_SHARD.get(), RecipeCategory.MISC, YoaItems.IOLITE, "iolite_from_shards", "iolite");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, YoaItems.IOLITE, RecipeCategory.MISC, YoaBlocks.IOLITE_BLOCK, "iolite_ingot_from_iolite_block", "iolite");
        nineBlockStorageRecipes(output, RecipeCategory.MISC, YoaItems.NETHERITE_NUGGET.get(), RecipeCategory.MISC, Items.NETHERITE_INGOT);
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, YoaItems.SILVER_NUGGET.get(), RecipeCategory.MISC, YoaItems.SILVER_INGOT, "silver_ingot_from_nuggets", "silver_ingot");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, YoaItems.SILVER_INGOT, RecipeCategory.MISC, YoaBlocks.SILVER_BLOCK, "silver_ingot_from_silver_block", "silver_ingot");
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, YoaItems.STEEL_NUGGET.get(), RecipeCategory.MISC, YoaItems.STEEL_INGOT, "steel_ingot_from_nuggets", "steel_ingot");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, YoaItems.STEEL_INGOT, RecipeCategory.MISC, YoaBlocks.STEEL_BLOCK, "steel_ingot_from_steel_block", "steel_ingot");
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, YoaItems.TITANIUM_NUGGET.get(), RecipeCategory.MISC, YoaItems.TITANIUM_INGOT, "titanium_ingot_from_nuggets", "titanium_ingot");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, YoaItems.TITANIUM_INGOT, RecipeCategory.MISC, YoaBlocks.TITANIUM_BLOCK, "titaniume_ingot_from_titanium_block", "titanium_ingot");
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, YoaItems.WITHERITE_SHARD.get(), RecipeCategory.MISC, YoaItems.WITHERITE, "witherite_from_shards", "witherite_ingot");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, YoaItems.WITHERITE, RecipeCategory.MISC, YoaBlocks.WITHERITE_BLOCK, "witherite_from_witherite_block", "witherite_ingot");
        nineBlockStorageRecipes(output, RecipeCategory.MISC, YoaItems.BRASS_INGOT.get(), RecipeCategory.MISC, YoaBlocks.BRASS_BLOCK.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, YoaItems.RAW_SILVER.get(), RecipeCategory.MISC, YoaBlocks.RAW_SILVER_BLOCK.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, YoaItems.RAW_BISMUTH.get(), RecipeCategory.MISC, YoaBlocks.RAW_BISMUTH_BLOCK.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, YoaItems.RAW_TITANIUM.get(), RecipeCategory.MISC, YoaBlocks.RAW_TITANIUM_BLOCK.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, YoaItems.RAW_ADAMANTITE.get(), RecipeCategory.MISC, YoaBlocks.RAW_ADAMANTITE_BLOCK.get());


        stonecutterResultFromBase(output, RecipeCategory.MISC, YoaBlocks.CREAKSTONE_STAIRS, YoaBlocks.CREAKSTONE);
        stonecutterResultFromBase(output, RecipeCategory.MISC, YoaBlocks.CREAKSTONE_SLAB, YoaBlocks.CREAKSTONE, 2);
        stonecutterResultFromBase(output, RecipeCategory.MISC, YoaBlocks.CREAKSTONE_WALL, YoaBlocks.CREAKSTONE);
        stonecutterResultFromBase(output, RecipeCategory.MISC, YoaBlocks.CREAKSTONE_TILES, YoaBlocks.CREAKSTONE);
        stonecutterResultFromBase(output, RecipeCategory.MISC, YoaBlocks.CREAKSTONE_TILES_STAIRS, YoaBlocks.CREAKSTONE);
        stonecutterResultFromBase(output, RecipeCategory.MISC, YoaBlocks.CREAKSTONE_TILES_SLAB, YoaBlocks.CREAKSTONE, 2);
        stonecutterResultFromBase(output, RecipeCategory.MISC, YoaBlocks.CREAKSTONE_TILES_WALL, YoaBlocks.CREAKSTONE);
        stonecutterResultFromBase(output, RecipeCategory.MISC, YoaBlocks.CREAKSTONE_TILES_STAIRS, YoaBlocks.CREAKSTONE_TILES);
        stonecutterResultFromBase(output, RecipeCategory.MISC, YoaBlocks.CREAKSTONE_TILES_SLAB, YoaBlocks.CREAKSTONE_TILES, 2);
        stonecutterResultFromBase(output, RecipeCategory.MISC, YoaBlocks.CREAKSTONE_TILES_WALL, YoaBlocks.CREAKSTONE_TILES);
        stonecutterResultFromBase(output, RecipeCategory.MISC, YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_STAIRS, YoaBlocks.CRYSTALIC_CREAKSTONE_TILES);
        stonecutterResultFromBase(output, RecipeCategory.MISC, YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_SLAB, YoaBlocks.CRYSTALIC_CREAKSTONE_TILES, 2);
        stonecutterResultFromBase(output, RecipeCategory.MISC, YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_WALL, YoaBlocks.CRYSTALIC_CREAKSTONE_TILES);

        HammeringStationRecipeBuilder.of(Items.STICK,Items.STICK,1).setIngB(Items.STICK).setIngC(Items.STICK).setIngD(Items.STICK).save(output, "superstick");

        CrucibleRecipeBuilder.of(Items.COPPER_INGOT,YoaItems.MOLTEN_BRONZE,1).setAssist(Ingredient.of(YoaItems.SILVER_INGOT)).setSupport(Ingredient.of(Items.BUCKET)).timed(10).save(output, "molten_bronze");
        CrucibleRecipeBuilder.of(YoaItems.BRONZE_INGOT,YoaItems.MOLTEN_BRONZE,1).setSupport(Ingredient.of(Items.BUCKET)).timed(10).save(output, "molten_bronze2");
        CrucibleRecipeBuilder.of(YoaItems.SILVER_INGOT,YoaItems.MOLTEN_SILVER,1).setSupport(Ingredient.of(Items.BUCKET)).timed(10).save(output, "molten_silver");
        CrucibleRecipeBuilder.of(Items.GOLD_INGOT,YoaItems.MOLTEN_GOLD,1).setSupport(Ingredient.of(Items.BUCKET)).timed(10).save(output, "molten_gold");
        CrucibleRecipeBuilder.of(Items.IRON_INGOT,YoaItems.MOLTEN_IRON,1).setSupport(Ingredient.of(Items.BUCKET)).timed(10).save(output, "molten_iron");
        CrucibleRecipeBuilder.of(Items.COAL,YoaItems.MOLTEN_STEEL,1).setAssist(Ingredient.of(Items.IRON_INGOT)).setSupport(Ingredient.of(Items.BUCKET)).timed(10).save(output, "molten_steel");
        CrucibleRecipeBuilder.of(YoaItems.STEEL_INGOT,YoaItems.MOLTEN_STEEL,1).setSupport(Ingredient.of(Items.BUCKET)).timed(10).save(output, "molten_steel2");
        CrucibleRecipeBuilder.of(YoaItems.TITANIUM_INGOT,YoaItems.MOLTEN_TITANIUM,1).setSupport(Ingredient.of(Items.BUCKET)).timed(10).save(output, "molten_titanium");
        CrucibleRecipeBuilder.of(Items.DIAMOND,YoaItems.MOLTEN_DIAMOND,1).setSupport(Ingredient.of(Items.BUCKET)).timed(10).save(output, "molten_diamond");
        CrucibleRecipeBuilder.of(YoaItems.IOLITE,YoaItems.MOLTEN_IOLITE,1).setSupport(Ingredient.of(Items.BUCKET)).timed(10).save(output, "molten_iolite");
        CrucibleRecipeBuilder.of(YoaItems.ALEXANDRITE,YoaItems.MOLTEN_ALEXANDRITE,1).setSupport(Ingredient.of(Items.BUCKET)).timed(10).save(output, "molten_alexandrite");

        oreSmelting(output, IRON_SMELTABLES, RecipeCategory.MISC, Items.IRON_INGOT, 0.7F, 200, "iron_ingot");
        oreSmelting(output, DIAMOND_SMELTABLES, RecipeCategory.MISC, Items.DIAMOND, 1.0F, 200, "diamond");
        oreSmelting(output, SILVER_SMELTABLES, RecipeCategory.MISC, YoaItems.SILVER_INGOT, 1.0F, 200, "silver_ingot");
        oreSmelting(output, BISMUTH_SMELTABLES, RecipeCategory.MISC, YoaItems.BISMUTH, 1.0F, 200, "bismuth_ingot");
        oreSmelting(output, TITANIUM_SMELTABLES, RecipeCategory.MISC, YoaItems.TITANIUM_INGOT, 0.7F, 200, "titanium_ingot");
        oreSmelting(output, WITHERITE_SMELTABLES, RecipeCategory.MISC, YoaItems.WITHERITE, 1.0F, 200, "witherite");
        oreSmelting(output, IOLITE_SMELTABLES, RecipeCategory.MISC, YoaItems.IOLITE, 1.0F, 200, "iolite");
        oreSmelting(output, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, YoaItems.ALEXANDRITE, 2.0F, 200, "alexandrite");
        oreSmelting(output, ADAMANTITE_SMELTABLES, RecipeCategory.MISC, YoaItems.ADAMANTITE_INGOT, 10.0F, 500, "adamantite_ingot");

        oreBlasting(output, IRON_SMELTABLES, RecipeCategory.MISC, Items.IRON_INGOT, 0.7F, 100, "iron_ingot");
        oreBlasting(output, DIAMOND_SMELTABLES, RecipeCategory.MISC, Items.DIAMOND, 1.0F, 100, "diamond");
        oreBlasting(output, SILVER_SMELTABLES, RecipeCategory.MISC, YoaItems.SILVER_INGOT, 1.0F, 100, "silver_ingot");
        oreBlasting(output, BISMUTH_SMELTABLES, RecipeCategory.MISC, YoaItems.BISMUTH, 1.0F, 100, "bismuth_ingot");
        oreBlasting(output, TITANIUM_SMELTABLES, RecipeCategory.MISC, YoaItems.TITANIUM_INGOT, 0.7F, 100, "titanium_ingot");
        oreBlasting(output, WITHERITE_SMELTABLES, RecipeCategory.MISC, YoaItems.WITHERITE, 1.0F, 100, "witherite");
        oreBlasting(output, IOLITE_SMELTABLES, RecipeCategory.MISC, YoaItems.IOLITE, 1.0F, 100, "iolite");
        oreBlasting(output, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, YoaItems.ALEXANDRITE, 2.0F, 100, "alexandrite");
        oreBlasting(output, ADAMANTITE_SMELTABLES, RecipeCategory.MISC, YoaItems.ADAMANTITE_INGOT, 10.0F, 250, "adamantite_ingot");

        makeHammerWeapons(output, "bronze" ,YoaItems.MOLTEN_BRONZE, YoaItems.BRONZE_INGOT, YoaItems.BRONZE_BELL, YoaItems.BRONZE_BLOW_DART, YoaItems.BRONZE_BOOMERANG, YoaItems.BRONZE_CHAKRAM, YoaItems.BRONZE_CLAWS, YoaItems.BRONZE_CLAYMORE, YoaItems.BRONZE_DAGGER, YoaItems.BRONZE_GREAT_AXE, YoaItems.BRONZE_HARPOON, YoaItems.BRONZE_HOLY_RIFLE, YoaItems.BRONZE_KATANA, YoaItems.BRONZE_LANCE, YoaItems.BRONZE_LYRE, YoaItems.BRONZE_MAGICIAN_WAND, YoaItems.BRONZE_RAPIER, YoaItems.BRONZE_RUNIC_AXE, YoaItems.BRONZE_RUNIC_BLADE, YoaItems.BRONZE_RUNIC_BLASTER, YoaItems.BRONZE_SCISSORS_SWORD, YoaItems.BRONZE_SCYTHE, YoaItems.BRONZE_SHURIKEN, YoaItems.BRONZE_SPELLCASTER_STAFF, YoaItems.BRONZE_TALISMAN, YoaItems.BRONZE_THROWING_KNIFE, YoaItems.BRONZE_TOME, YoaItems.BRONZE_WAR_FAN, YoaItems.BRONZE_WHIP_SWORD);
        makeHammerWeapons(output, "silver", YoaItems.MOLTEN_SILVER, YoaItems.SILVER_INGOT, YoaItems.SILVER_BELL, YoaItems.SILVER_BLOW_DART, YoaItems.SILVER_BOOMERANG, YoaItems.SILVER_CHAKRAM, YoaItems.SILVER_CLAWS, YoaItems.SILVER_CLAYMORE, YoaItems.SILVER_DAGGER, YoaItems.SILVER_GREAT_AXE, YoaItems.SILVER_HARPOON, YoaItems.SILVER_HOLY_RIFLE, YoaItems.SILVER_KATANA, YoaItems.SILVER_LANCE, YoaItems.SILVER_LYRE, YoaItems.SILVER_MAGICIAN_WAND, YoaItems.SILVER_RAPIER, YoaItems.SILVER_RUNIC_AXE, YoaItems.SILVER_RUNIC_BLADE, YoaItems.SILVER_RUNIC_BLASTER, YoaItems.SILVER_SCISSORS_SWORD, YoaItems.SILVER_SCYTHE, YoaItems.SILVER_SHURIKEN, YoaItems.SILVER_SPELLCASTER_STAFF, YoaItems.SILVER_TALISMAN, YoaItems.SILVER_THROWING_KNIFE, YoaItems.SILVER_TOME, YoaItems.SILVER_WAR_FAN, YoaItems.SILVER_WHIP_SWORD);
        makeHammerWeapons(output, "gold", YoaItems.MOLTEN_GOLD, Items.GOLD_INGOT, YoaItems.GOLD_BELL, YoaItems.GOLD_BLOW_DART, YoaItems.GOLD_BOOMERANG, YoaItems.GOLD_CHAKRAM, YoaItems.GOLD_CLAWS, YoaItems.GOLD_CLAYMORE, YoaItems.GOLD_DAGGER, YoaItems.GOLD_GREAT_AXE, YoaItems.GOLD_HARPOON, YoaItems.GOLD_HOLY_RIFLE, YoaItems.GOLD_KATANA, YoaItems.GOLD_LANCE, YoaItems.GOLD_LYRE, YoaItems.GOLD_MAGICIAN_WAND, YoaItems.GOLD_RAPIER, YoaItems.GOLD_RUNIC_AXE, YoaItems.GOLD_RUNIC_BLADE, YoaItems.GOLD_RUNIC_BLASTER, YoaItems.GOLD_SCISSORS_SWORD, YoaItems.GOLD_SCYTHE, YoaItems.GOLD_SHURIKEN, YoaItems.GOLD_SPELLCASTER_STAFF, YoaItems.GOLD_TALISMAN, YoaItems.GOLD_THROWING_KNIFE, YoaItems.GOLD_TOME, YoaItems.GOLD_WAR_FAN, YoaItems.GOLD_WHIP_SWORD);
        makeHammerWeapons(output, "iron", YoaItems.MOLTEN_IRON, Items.IRON_INGOT, YoaItems.IRON_BELL, YoaItems.IRON_BLOW_DART, YoaItems.IRON_BOOMERANG, YoaItems.IRON_CHAKRAM, YoaItems.IRON_CLAWS, YoaItems.IRON_CLAYMORE, YoaItems.IRON_DAGGER, YoaItems.IRON_GREAT_AXE, YoaItems.IRON_HARPOON, YoaItems.IRON_HOLY_RIFLE, YoaItems.IRON_KATANA, YoaItems.IRON_LANCE, YoaItems.IRON_LYRE, YoaItems.IRON_MAGICIAN_WAND, YoaItems.IRON_RAPIER, YoaItems.IRON_RUNIC_AXE, YoaItems.IRON_RUNIC_BLADE, YoaItems.IRON_RUNIC_BLASTER, YoaItems.IRON_SCISSORS_SWORD, YoaItems.IRON_SCYTHE, YoaItems.IRON_SHURIKEN, YoaItems.IRON_SPELLCASTER_STAFF, YoaItems.IRON_TALISMAN, YoaItems.IRON_THROWING_KNIFE, YoaItems.IRON_TOME, YoaItems.IRON_WAR_FAN, YoaItems.IRON_WHIP_SWORD);
        makeHammerWeapons(output, "steel", YoaItems.MOLTEN_STEEL, YoaItems.STEEL_INGOT, YoaItems.STEEL_BELL, YoaItems.STEEL_BLOW_DART, YoaItems.STEEL_BOOMERANG, YoaItems.STEEL_CHAKRAM, YoaItems.STEEL_CLAWS, YoaItems.STEEL_CLAYMORE, YoaItems.STEEL_DAGGER, YoaItems.STEEL_GREAT_AXE, YoaItems.STEEL_HARPOON, YoaItems.STEEL_HOLY_RIFLE, YoaItems.STEEL_KATANA, YoaItems.STEEL_LANCE, YoaItems.STEEL_LYRE, YoaItems.STEEL_MAGICIAN_WAND, YoaItems.STEEL_RAPIER, YoaItems.STEEL_RUNIC_AXE, YoaItems.STEEL_RUNIC_BLADE, YoaItems.STEEL_RUNIC_BLASTER, YoaItems.STEEL_SCISSORS_SWORD, YoaItems.STEEL_SCYTHE, YoaItems.STEEL_SHURIKEN, YoaItems.STEEL_SPELLCASTER_STAFF, YoaItems.STEEL_TALISMAN, YoaItems.STEEL_THROWING_KNIFE, YoaItems.STEEL_TOME, YoaItems.STEEL_WAR_FAN, YoaItems.STEEL_WHIP_SWORD);
        makeHammerWeapons(output, "bismuth", YoaItems.MOLTEN_BISMUTH, YoaItems.BISMUTH, YoaItems.BISMUTH_BELL, YoaItems.BISMUTH_BLOW_DART, YoaItems.BISMUTH_BOOMERANG, YoaItems.BISMUTH_CHAKRAM, YoaItems.BISMUTH_CLAWS, YoaItems.BISMUTH_CLAYMORE, YoaItems.BISMUTH_DAGGER, YoaItems.BISMUTH_GREAT_AXE, YoaItems.BISMUTH_HARPOON, YoaItems.BISMUTH_HOLY_RIFLE, YoaItems.BISMUTH_KATANA, YoaItems.BISMUTH_LANCE, YoaItems.BISMUTH_LYRE, YoaItems.BISMUTH_MAGICIAN_WAND, YoaItems.BISMUTH_RAPIER, YoaItems.BISMUTH_RUNIC_AXE, YoaItems.BISMUTH_RUNIC_BLADE, YoaItems.BISMUTH_RUNIC_BLASTER, YoaItems.BISMUTH_SCISSORS_SWORD, YoaItems.BISMUTH_SCYTHE, YoaItems.BISMUTH_SHURIKEN, YoaItems.BISMUTH_SPELLCASTER_STAFF, YoaItems.BISMUTH_TALISMAN, YoaItems.BISMUTH_THROWING_KNIFE, YoaItems.BISMUTH_TOME, YoaItems.BISMUTH_WAR_FAN, YoaItems.BISMUTH_WHIP_SWORD);
        makeHammerWeapons(output, "titanium", YoaItems.MOLTEN_TITANIUM, YoaItems.TITANIUM_INGOT, YoaItems.TITANIUM_BELL, YoaItems.TITANIUM_BLOW_DART, YoaItems.TITANIUM_BOOMERANG, YoaItems.TITANIUM_CHAKRAM, YoaItems.TITANIUM_CLAWS, YoaItems.TITANIUM_CLAYMORE, YoaItems.TITANIUM_DAGGER, YoaItems.TITANIUM_GREAT_AXE, YoaItems.TITANIUM_HARPOON, YoaItems.TITANIUM_HOLY_RIFLE, YoaItems.TITANIUM_KATANA, YoaItems.TITANIUM_LANCE, YoaItems.TITANIUM_LYRE, YoaItems.TITANIUM_MAGICIAN_WAND, YoaItems.TITANIUM_RAPIER, YoaItems.TITANIUM_RUNIC_AXE, YoaItems.TITANIUM_RUNIC_BLADE, YoaItems.TITANIUM_RUNIC_BLASTER, YoaItems.TITANIUM_SCISSORS_SWORD, YoaItems.TITANIUM_SCYTHE, YoaItems.TITANIUM_SHURIKEN, YoaItems.TITANIUM_SPELLCASTER_STAFF, YoaItems.TITANIUM_TALISMAN, YoaItems.TITANIUM_THROWING_KNIFE, YoaItems.TITANIUM_TOME, YoaItems.TITANIUM_WAR_FAN, YoaItems.TITANIUM_WHIP_SWORD);
        makeHammerWeapons(output, "diamond", YoaItems.MOLTEN_DIAMOND, Items.DIAMOND, YoaItems.DIAMOND_BELL, YoaItems.DIAMOND_BLOW_DART, YoaItems.DIAMOND_BOOMERANG, YoaItems.DIAMOND_CHAKRAM, YoaItems.DIAMOND_CLAWS, YoaItems.DIAMOND_CLAYMORE, YoaItems.DIAMOND_DAGGER, YoaItems.DIAMOND_GREAT_AXE, YoaItems.DIAMOND_HARPOON, YoaItems.DIAMOND_HOLY_RIFLE, YoaItems.DIAMOND_KATANA, YoaItems.DIAMOND_LANCE, YoaItems.DIAMOND_LYRE, YoaItems.DIAMOND_MAGICIAN_WAND, YoaItems.DIAMOND_RAPIER, YoaItems.DIAMOND_RUNIC_AXE, YoaItems.DIAMOND_RUNIC_BLADE, YoaItems.DIAMOND_RUNIC_BLASTER, YoaItems.DIAMOND_SCISSORS_SWORD, YoaItems.DIAMOND_SCYTHE, YoaItems.DIAMOND_SHURIKEN, YoaItems.DIAMOND_SPELLCASTER_STAFF, YoaItems.DIAMOND_TALISMAN, YoaItems.DIAMOND_THROWING_KNIFE, YoaItems.DIAMOND_TOME, YoaItems.DIAMOND_WAR_FAN, YoaItems.DIAMOND_WHIP_SWORD);
        makeHammerWeapons(output, "iolite", YoaItems.MOLTEN_IOLITE, YoaItems.IOLITE, YoaItems.IOLITE_BELL, YoaItems.IOLITE_BLOW_DART, YoaItems.IOLITE_BOOMERANG, YoaItems.IOLITE_CHAKRAM, YoaItems.IOLITE_CLAWS, YoaItems.IOLITE_CLAYMORE, YoaItems.IOLITE_DAGGER, YoaItems.IOLITE_GREAT_AXE, YoaItems.IOLITE_HARPOON, YoaItems.IOLITE_HOLY_RIFLE, YoaItems.IOLITE_KATANA, YoaItems.IOLITE_LANCE, YoaItems.IOLITE_LYRE, YoaItems.IOLITE_MAGICIAN_WAND, YoaItems.IOLITE_RAPIER, YoaItems.IOLITE_RUNIC_AXE, YoaItems.IOLITE_RUNIC_BLADE, YoaItems.IOLITE_RUNIC_BLASTER, YoaItems.IOLITE_SCISSORS_SWORD, YoaItems.IOLITE_SCYTHE, YoaItems.IOLITE_SHURIKEN, YoaItems.IOLITE_SPELLCASTER_STAFF, YoaItems.IOLITE_TALISMAN, YoaItems.IOLITE_THROWING_KNIFE, YoaItems.IOLITE_TOME, YoaItems.IOLITE_WAR_FAN, YoaItems.IOLITE_WHIP_SWORD);
        makeHammerWeapons(output, "alexandrite", YoaItems.MOLTEN_ALEXANDRITE, YoaItems.ALEXANDRITE, YoaItems.ALEXANDRITE_BELL, YoaItems.ALEXANDRITE_BLOW_DART, YoaItems.ALEXANDRITE_BOOMERANG, YoaItems.ALEXANDRITE_CHAKRAM, YoaItems.ALEXANDRITE_CLAWS, YoaItems.ALEXANDRITE_CLAYMORE, YoaItems.ALEXANDRITE_DAGGER, YoaItems.ALEXANDRITE_GREAT_AXE, YoaItems.ALEXANDRITE_HARPOON, YoaItems.ALEXANDRITE_HOLY_RIFLE, YoaItems.ALEXANDRITE_KATANA, YoaItems.ALEXANDRITE_LANCE, YoaItems.ALEXANDRITE_LYRE, YoaItems.ALEXANDRITE_MAGICIAN_WAND, YoaItems.ALEXANDRITE_RAPIER, YoaItems.ALEXANDRITE_RUNIC_AXE, YoaItems.ALEXANDRITE_RUNIC_BLADE, YoaItems.ALEXANDRITE_RUNIC_BLASTER, YoaItems.ALEXANDRITE_SCISSORS_SWORD, YoaItems.ALEXANDRITE_SCYTHE, YoaItems.ALEXANDRITE_SHURIKEN, YoaItems.ALEXANDRITE_SPELLCASTER_STAFF, YoaItems.ALEXANDRITE_TALISMAN, YoaItems.ALEXANDRITE_THROWING_KNIFE, YoaItems.ALEXANDRITE_TOME, YoaItems.ALEXANDRITE_WAR_FAN, YoaItems.ALEXANDRITE_WHIP_SWORD);

        netheriteSmithing(output, YoaItems.DIAMOND_BELL.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_BELL.get());
        netheriteSmithing(output, YoaItems.DIAMOND_BLOW_DART.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_BLOW_DART.get());
        netheriteSmithing(output, YoaItems.DIAMOND_BOOMERANG.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_BOOMERANG.get());
        netheriteSmithing(output, YoaItems.DIAMOND_CHAKRAM.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_CHAKRAM.get());
        netheriteSmithing(output, YoaItems.DIAMOND_CLAYMORE.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_CLAYMORE.get());
        netheriteSmithing(output, YoaItems.DIAMOND_DAGGER.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_DAGGER.get());
        netheriteSmithing(output, YoaItems.DIAMOND_GREAT_AXE.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_GREAT_AXE.get());
        netheriteSmithing(output, YoaItems.DIAMOND_HARPOON.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_HARPOON.get());
        netheriteSmithing(output, YoaItems.DIAMOND_HOLY_RIFLE.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_HOLY_RIFLE.get());
        netheriteSmithing(output, YoaItems.DIAMOND_KATANA.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_KATANA.get());
        netheriteSmithing(output, YoaItems.DIAMOND_LANCE.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_LANCE.get());
        netheriteSmithing(output, YoaItems.DIAMOND_LYRE.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_LYRE.get());
        netheriteSmithing(output, YoaItems.DIAMOND_MAGICIAN_WAND.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_MAGICIAN_WAND.get());
        netheriteSmithing(output, YoaItems.DIAMOND_RAPIER.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_RAPIER.get());
        netheriteSmithing(output, YoaItems.DIAMOND_RUNIC_AXE.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_RUNIC_AXE.get());
        netheriteSmithing(output, YoaItems.DIAMOND_RUNIC_BLADE.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_RUNIC_BLADE.get());
        netheriteSmithing(output, YoaItems.DIAMOND_RUNIC_BLASTER.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_RUNIC_BLASTER.get());
        netheriteSmithing(output, YoaItems.DIAMOND_SCISSORS_SWORD.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_SCISSORS_SWORD.get());
        netheriteSmithing(output, YoaItems.DIAMOND_SCYTHE.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_SCYTHE.get());
        netheriteSmithing(output, YoaItems.DIAMOND_SHURIKEN.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_SHURIKEN.get());
        netheriteSmithing(output, YoaItems.DIAMOND_SPELLCASTER_STAFF.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_SPELLCASTER_STAFF.get());
        netheriteSmithing(output, YoaItems.DIAMOND_TALISMAN.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_TALISMAN.get());
        netheriteSmithing(output, YoaItems.DIAMOND_THROWING_KNIFE.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_THROWING_KNIFE.get());
        netheriteSmithing(output, YoaItems.DIAMOND_TOME.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_TOME.get());
        netheriteSmithing(output, YoaItems.DIAMOND_WAR_FAN.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_WAR_FAN.get());
        netheriteSmithing(output, YoaItems.DIAMOND_WHIP_SWORD.get(), RecipeCategory.COMBAT, YoaItems.NETHERITE_WHIP_SWORD.get());

        adamantiteSmithing(output, YoaItems.ALEXANDRITE_BELL.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_BELL.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_BLOW_DART.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_BLOW_DART.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_BOOMERANG.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_BOOMERANG.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_CHAKRAM.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_CHAKRAM.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_CLAYMORE.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_CLAYMORE.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_DAGGER.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_DAGGER.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_GREAT_AXE.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_GREAT_AXE.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_HARPOON.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_HARPOON.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_HOLY_RIFLE.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_HOLY_RIFLE.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_KATANA.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_KATANA.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_LANCE.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_LANCE.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_LYRE.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_LYRE.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_MAGICIAN_WAND.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_MAGICIAN_WAND.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_RAPIER.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_RAPIER.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_RUNIC_AXE.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_RUNIC_AXE.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_RUNIC_BLADE.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_RUNIC_BLADE.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_RUNIC_BLASTER.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_RUNIC_BLASTER.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_SCISSORS_SWORD.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_SCISSORS_SWORD.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_SCYTHE.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_SCYTHE.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_SHURIKEN.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_SHURIKEN.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_SPELLCASTER_STAFF.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_SPELLCASTER_STAFF.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_TALISMAN.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_TALISMAN.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_THROWING_KNIFE.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_THROWING_KNIFE.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_TOME.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_TOME.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_WAR_FAN.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_WAR_FAN.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_WHIP_SWORD.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_WHIP_SWORD.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_HELMET.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_HELMET.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_CHESTPLATE.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_CHESTPLATE.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_LEGGINGS.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_LEGGINGS.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_BOOTS.get(), RecipeCategory.COMBAT, YoaItems.ADAMANTITE_BOOTS.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_SHOVEL.get(), RecipeCategory.TOOLS, YoaItems.ADAMANTITE_SHOVEL.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_HOE.get(), RecipeCategory.TOOLS, YoaItems.ADAMANTITE_HOE.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_PICKAXE.get(), RecipeCategory.TOOLS, YoaItems.ADAMANTITE_PICKAXE.get());
        adamantiteSmithing(output, YoaItems.ALEXANDRITE_AXE.get(), RecipeCategory.TOOLS, YoaItems.ADAMANTITE_AXE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, YoaItems.ALEXANDRITE_AXE).define('#', Items.STICK).define('X', YoaItems.ALEXANDRITE).
                pattern("XX").
                pattern("X#").
                pattern(" #").unlockedBy("has_alexandrite", has(YoaItems.ALEXANDRITE)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, YoaItems.ALEXANDRITE_HOE).define('#', Items.STICK).define('X', YoaItems.ALEXANDRITE).
                pattern("XX").
                pattern(" #").
                pattern(" #").unlockedBy("has_alexandrite", has(YoaItems.ALEXANDRITE)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, YoaItems.ALEXANDRITE_PICKAXE).define('#', Items.STICK).define('X', YoaItems.ALEXANDRITE).
                pattern("XXX").
                pattern(" # ").
                pattern(" # ").unlockedBy("has_alexandrite", has(YoaItems.ALEXANDRITE)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, YoaItems.ALEXANDRITE_SHOVEL).define('#', Items.STICK).define('X', YoaItems.ALEXANDRITE).
                pattern("X").
                pattern("#").
                pattern("#").unlockedBy("has_alexandrite", has(YoaItems.ALEXANDRITE)).save(output);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, YoaItems.IOLITE_AXE).define('#', Items.STICK).define('X', YoaItems.IOLITE).
                pattern("XX").
                pattern("X#").
                pattern(" #").unlockedBy("has_iolite", has(YoaItems.IOLITE)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, YoaItems.IOLITE_HOE).define('#', Items.STICK).define('X', YoaItems.IOLITE).
                pattern("XX").
                pattern(" #").
                pattern(" #").unlockedBy("has_iolite", has(YoaItems.IOLITE)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, YoaItems.IOLITE_PICKAXE).define('#', Items.STICK).define('X', YoaItems.IOLITE).
                pattern("XXX").
                pattern(" # ").
                pattern(" # ").unlockedBy("has_iolite", has(YoaItems.IOLITE)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, YoaItems.IOLITE_SHOVEL).define('#', Items.STICK).define('X', YoaItems.IOLITE).
                pattern("X").
                pattern("#").
                pattern("#").unlockedBy("has_iolite", has(YoaItems.IOLITE)).save(output);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, YoaItems.TITANIUM_AXE).define('#', Items.STICK).define('X', YoaItems.TITANIUM_INGOT).
                pattern("XX").
                pattern("X#").
                pattern(" #").unlockedBy("has_titanium_ingot", has(YoaItems.TITANIUM_INGOT)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, YoaItems.TITANIUM_HOE).define('#', Items.STICK).define('X', YoaItems.TITANIUM_INGOT).
                pattern("XX").
                pattern(" #").
                pattern(" #").unlockedBy("has_titanium_ingot", has(YoaItems.TITANIUM_INGOT)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, YoaItems.TITANIUM_PICKAXE).define('#', Items.STICK).define('X', YoaItems.TITANIUM_INGOT).
                pattern("XXX").
                pattern(" # ").
                pattern(" # ").unlockedBy("has_titanium_ingot", has(YoaItems.TITANIUM_INGOT)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, YoaItems.TITANIUM_SHOVEL).define('#', Items.STICK).define('X', YoaItems.TITANIUM_INGOT).
                pattern("X").
                pattern("#").
                pattern("#").unlockedBy("has_titanium_ingot", has(YoaItems.TITANIUM_INGOT)).save(output);

        makeArmorRecipe(output, YoaItems.SILVER_INGOT.get(), YoaItems.SILVER_HELMET.get(), YoaItems.SILVER_CHESTPLATE, YoaItems.SILVER_LEGGINGS, YoaItems.SILVER_BOOTS);
        makeArmorRecipe(output, YoaItems.WITHERITE.get(), YoaItems.WITHERITE_HELMET.get(), YoaItems.WITHERITE_CHESTPLATE, YoaItems.WITHERITE_LEGGINGS, YoaItems.WITHERITE_BOOTS);
        makeArmorRecipe(output, YoaItems.IOLITE.get(), YoaItems.IOLITE_HELMET.get(), YoaItems.IOLITE_CHESTPLATE, YoaItems.IOLITE_LEGGINGS, YoaItems.IOLITE_BOOTS);
        makeArmorRecipe(output, YoaItems.ALEXANDRITE.get(), YoaItems.ALEXANDRITE_HELMET.get(), YoaItems.ALEXANDRITE_CHESTPLATE, YoaItems.ALEXANDRITE_LEGGINGS, YoaItems.ALEXANDRITE_BOOTS);


    }
    public static void makeHammerWeapons(RecipeOutput output, String pre, ItemLike molten, ItemLike item, ItemLike bell, ItemLike blow, ItemLike boom, ItemLike cha, ItemLike claw, ItemLike clay, ItemLike dag, ItemLike gAxe, ItemLike harp, ItemLike rifle, ItemLike kata, ItemLike lance, ItemLike lyre, ItemLike wand, ItemLike rap, ItemLike rAxe, ItemLike rBlad, ItemLike rBlas, ItemLike sciss, ItemLike scy, ItemLike shur, ItemLike staff, ItemLike tali, ItemLike knife, ItemLike tome, ItemLike fan, ItemLike whip) {
        ItemLike stick = Items.STICK;
        ItemLike string = Items.STRING;
        ItemLike crystal = YoaItems.RUNE_CRYSTAL;
        HammeringStationRecipeBuilder.of(molten,rAxe).setIngB(molten).setIngC(stick).setIngD(crystal).save(output, pre+"_runic_axe");
        HammeringStationRecipeBuilder.of(molten,rBlas).setIngB(molten).setIngC(stick).setIngD(crystal).save(output, pre+"_runic_blaster");
        HammeringStationRecipeBuilder.of(molten,rBlad).setIngB(molten).setIngC(stick).setIngD(crystal).save(output, pre +"runic_blade");
        HammeringStationRecipeBuilder.of(molten,wand).setIngB(stick).setIngC(stick).setIngD(crystal).save(output, pre + "_magician_wand");
        HammeringStationRecipeBuilder.of(molten,staff).setIngB(stick).setIngC(stick).setIngD(crystal).save(output, pre + "_spellcaster_staff");
        HammeringStationRecipeBuilder.of(molten,bell).setIngB(string).setIngD(crystal).save(output, pre + "_bell");
        HammeringStationRecipeBuilder.of(molten,lyre).setIngB(string).setIngD(crystal).save(output, pre+"_lyre");
        HammeringStationRecipeBuilder.of(molten,tali).setIngB(string).setIngD(crystal).save(output, pre+"_talisman");
        HammeringStationRecipeBuilder.of(molten,tome).setIngB(Items.BOOK).setIngD(crystal).save(output, pre+"_tome");
        HammeringStationRecipeBuilder.of(molten,gAxe).setIngB(stick).setIngC(stick).setIngD(molten).save(output, pre+"_great_axe");
        HammeringStationRecipeBuilder.of(molten,scy).setIngB(stick).setIngC(stick).setIngD(molten).save(output, pre+"_scythe");
        HammeringStationRecipeBuilder.of(molten,cha).setIngC(stick).setIngD(molten).save(output, pre+"_charkram");
        HammeringStationRecipeBuilder.of(molten,clay).setIngC(stick).setIngD(molten).save(output, pre+"_claymore");
        HammeringStationRecipeBuilder.of(molten,kata).setIngC(stick).setIngD(molten).save(output, pre+"_katana");
        HammeringStationRecipeBuilder.of(molten,sciss).setIngC(stick).setIngD(molten).save(output, pre+"_scissor_sword");
        HammeringStationRecipeBuilder.of(molten,whip).setIngB(Items.CHAIN).setIngC(stick).setIngD(molten).save(output, pre+"_whip_sword");
        HammeringStationRecipeBuilder.of(molten,harp).setIngB(stick).setIngC(stick).save(output, pre+"_harpoon");
        HammeringStationRecipeBuilder.of(molten,lance).setIngB(stick).setIngC(stick).save(output, pre+"_lance");
        HammeringStationRecipeBuilder.of(molten,dag).setIngC(stick).save(output, pre+"_dagger");
        HammeringStationRecipeBuilder.of(molten,rifle).setIngC(stick).save(output, pre+"_holy_rifle");
        HammeringStationRecipeBuilder.of(molten,rap).setIngC(stick).save(output, pre+"_rapier");
        HammeringStationRecipeBuilder.of(molten,knife).setIngC(stick).save(output, pre+"_throwing_knife");
        HammeringStationRecipeBuilder.of(molten,fan).setIngB(Items.PAPER).setIngC(stick).setIngD(Items.PAPER).save(output, pre+"_war_fan");
        HammeringStationRecipeBuilder.of(molten,blow).setIngB(string).save(output, pre+"_blowdart");
        HammeringStationRecipeBuilder.of(molten,boom).setIngB(string).save(output, pre+"_boomerang");
        HammeringStationRecipeBuilder.of(molten,claw).setIngB(string).save(output, pre+"_claws");
        HammeringStationRecipeBuilder.of(molten,shur).setIngB(string).save(output, pre+"_shuriken");
        HammeringStationRecipeBuilder.of(molten,item).save(output, pre+"_revert");
}

    protected static void adamantiteSmithing(RecipeOutput pRecipeOutput, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(new ItemLike[]{YoaItems.ADAMANTITE_TEMPLATE}), Ingredient.of(new ItemLike[]{pIngredientItem}), Ingredient.of(new ItemLike[]{YoaItems.ADAMANTITE_INGOT}), pCategory, pResultItem).unlocks("has_adamantite_ingot", has((ItemLike)YoaItems.ADAMANTITE_INGOT)).save(pRecipeOutput, getItemName(pResultItem) + "_smithing");
    }


    public static void makeArmorRecipe(RecipeOutput output, ItemLike material, ItemLike helmet, ItemLike chestplate, ItemLike leggings, ItemLike boots) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmet).define('#', material)
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_material", has(material)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, chestplate).define('#', material)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_material", has(material)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, leggings).define('#', material)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_material", has(material)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, boots).define('#', material)
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_material", has(material)).save(output);
    }

    public static void makeStoneSetRecipe(RecipeOutput output, ItemLike material, ItemLike stair, ItemLike slab, ItemLike wall) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, stair, 4).define('#', material)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy("has_material", has(material)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, slab, 6).define('#', material)
                .pattern("###")
                .unlockedBy("has_material", has(material)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, wall, 6).define('#', material)
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_material", has(material)).save(output);

    }
    protected static <T extends AbstractCookingRecipe> void yoaCookRecipes(
            RecipeOutput pRecipeOutput, String pCookingMethod, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> pRecipeFactory, int pCookingTime
    ) {
        simpleCookingRecipe(pRecipeOutput, pCookingMethod, pCookingSerializer, pRecipeFactory, pCookingTime, YoaItems.RAW_BIG_MEAT, YoaItems.COOKED_BIG_MEAT, 0.35F);
        simpleCookingRecipe(pRecipeOutput, pCookingMethod, pCookingSerializer, pRecipeFactory, pCookingTime, YoaItems.SLICED_RAW_MEAT, YoaItems.SLICED_COOKED_MEAT, 0.35F);
    }


    static {
        IRON_SMELTABLES = ImmutableList.of(YoaBlocks.CREAKSTONE_IRON_ORE);
        DIAMOND_SMELTABLES = ImmutableList.of(YoaBlocks.CREAKSTONE_DIAMOND_ORE);
        SILVER_SMELTABLES = ImmutableList.of(YoaBlocks.SILVER_ORE, YoaBlocks.DEEPSLATE_SILVER_ORE, YoaItems.RAW_SILVER);
        BISMUTH_SMELTABLES = ImmutableList.of(YoaBlocks.BISMUTH_ORE, YoaBlocks.DEEPSLATE_BISMUTH_ORE, YoaItems.RAW_BISMUTH);
        TITANIUM_SMELTABLES = ImmutableList.of(Items.COPPER_ORE, Items.DEEPSLATE_COPPER_ORE, Items.RAW_COPPER);
        WITHERITE_SMELTABLES = ImmutableList.of(YoaBlocks.WITHERITE_ORE);
        IOLITE_SMELTABLES = ImmutableList.of(YoaBlocks.IOLITE_ORE);
        ALEXANDRITE_SMELTABLES = ImmutableList.of(YoaBlocks.ALEXANDRITE_ORE);
        ADAMANTITE_SMELTABLES = ImmutableList.of(YoaBlocks.ADAMANTITE_ORE, YoaItems.ADAMANTITE_INGOT);
    }
}