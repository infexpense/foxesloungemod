package com.fuyuvulpes.yoamod.data.generators;

import com.fuyuvulpes.yoamod.core.registries.YoaBlocks;
import com.fuyuvulpes.yoamod.core.registries.YoaItems;
import com.fuyuvulpes.yoamod.game.server.crafting.CrucibleRecipeBuilder;
import com.fuyuvulpes.yoamod.game.server.crafting.HammeringStationRecipeBuilder;
import com.google.common.collect.ImmutableList;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
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