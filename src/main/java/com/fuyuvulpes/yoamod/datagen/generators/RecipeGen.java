package com.fuyuvulpes.yoamod.datagen.generators;

import com.fuyuvulpes.yoamod.core.registries.BlocksModReg;
import com.fuyuvulpes.yoamod.core.registries.ItemsModReg;
import com.google.common.collect.ImmutableList;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

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

        makeStoneSetRecipe(output, BlocksModReg.CREAKSTONE.get(), BlocksModReg.CREAKSTONE_STAIRS.get(), BlocksModReg.CREAKSTONE_SLAB, BlocksModReg.CREAKSTONE_WALL);
        makeStoneSetRecipe(output, BlocksModReg.CREAKSTONE_TILES.get(), BlocksModReg.CREAKSTONE_TILES_STAIRS.get(), BlocksModReg.CREAKSTONE_TILES_SLAB, BlocksModReg.CREAKSTONE_TILES_WALL);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlocksModReg.CRYSTALIC_CREAKSTONE_TILES, 4).define('#', BlocksModReg.CREAKSTONE_TILES).define('X', ItemsModReg.CRYSTALIC_SHARD).
                pattern("#X").
                pattern("X#").unlockedBy("has_crystalic_shard", has(ItemsModReg.CRYSTALIC_SHARD)).save(output);
        makeStoneSetRecipe(output, BlocksModReg.CRYSTALIC_CREAKSTONE_TILES.get(), BlocksModReg.CRYSTALIC_CREAKSTONE_TILES_STAIRS.get(), BlocksModReg.CRYSTALIC_CREAKSTONE_TILES_SLAB, BlocksModReg.CRYSTALIC_CREAKSTONE_TILES_WALL);
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, ItemsModReg.ADAMANTITE_NUGGET.get(), RecipeCategory.MISC, ItemsModReg.ADAMANTITE_INGOT, "adamantite_ingot_from_nuggets", "adamantite_ingot");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, ItemsModReg.ADAMANTITE_INGOT, RecipeCategory.MISC, BlocksModReg.ADAMANTITE_BLOCK, "adamantite_ingot_from_adamantite_block", "adamantite_ingot");
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, ItemsModReg.ALEXANDRITE_SHARD.get(), RecipeCategory.MISC, ItemsModReg.ALEXANDRITE, "alexandrite_from_shards", "alexandrite");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, ItemsModReg.ALEXANDRITE, RecipeCategory.MISC, BlocksModReg.ALEXANDRITE_BLOCK, "alexandrite_from_adamantite_block", "alexandrite");
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, ItemsModReg.BISMUTH_SHARD.get(), RecipeCategory.MISC, ItemsModReg.BISMUTH, "bismuth_from_shards", "bismuth");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, ItemsModReg.BISMUTH, RecipeCategory.MISC, BlocksModReg.BISMUTH_BLOCK, "bismuth_from_bismuth_block", "bismuth");
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, ItemsModReg.BRONZE_NUGGET.get(), RecipeCategory.MISC, ItemsModReg.BRONZE_INGOT, "bronze_ingot_from_nuggets", "bronze_ingot");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, ItemsModReg.BRONZE_INGOT, RecipeCategory.MISC, BlocksModReg.BRONZE_BLOCK, "bronze_ingot_from_bronze_block", "bronze_ingot");
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.DIAMOND_SHARD.get(), RecipeCategory.MISC, Items.DIAMOND);
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, ItemsModReg.IOLITE_SHARD.get(), RecipeCategory.MISC, ItemsModReg.IOLITE, "iolite_from_shards", "iolite");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, ItemsModReg.IOLITE, RecipeCategory.MISC, BlocksModReg.IOLITE_BLOCK, "iolite_ingot_from_iolite_block", "iolite");
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.NETHERITE_NUGGET.get(), RecipeCategory.MISC, Items.NETHERITE_INGOT);
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, ItemsModReg.SILVER_NUGGET.get(), RecipeCategory.MISC, ItemsModReg.SILVER_INGOT, "silver_ingot_from_nuggets", "silver_ingot");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, ItemsModReg.SILVER_INGOT, RecipeCategory.MISC, BlocksModReg.SILVER_BLOCK, "silver_ingot_from_silver_block", "silver_ingot");
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, ItemsModReg.STEEL_NUGGET.get(), RecipeCategory.MISC, ItemsModReg.STEEL_INGOT, "steel_ingot_from_nuggets", "steel_ingot");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, ItemsModReg.STEEL_INGOT, RecipeCategory.MISC, BlocksModReg.STEEL_BLOCK, "steel_ingot_from_steel_block", "steel_ingot");
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, ItemsModReg.TITANIUM_NUGGET.get(), RecipeCategory.MISC, ItemsModReg.TITANIUM_INGOT, "titanium_ingot_from_nuggets", "titanium_ingot");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, ItemsModReg.TITANIUM_INGOT, RecipeCategory.MISC, BlocksModReg.TITANIUM_BLOCK, "titaniume_ingot_from_titanium_block", "titanium_ingot");
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, ItemsModReg.WITHERITE_SHARD.get(), RecipeCategory.MISC, ItemsModReg.WITHERITE, "witherite_from_shards", "witherite_ingot");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, ItemsModReg.WITHERITE, RecipeCategory.MISC, BlocksModReg.WITHERITE_BLOCK, "witherite_from_witherite_block", "witherite_ingot");
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.BRASS_INGOT.get(), RecipeCategory.MISC, BlocksModReg.BRASS_BLOCK.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.RAW_SILVER.get(), RecipeCategory.MISC, BlocksModReg.RAW_SILVER_BLOCK.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.RAW_BISMUTH.get(), RecipeCategory.MISC, BlocksModReg.RAW_BISMUTH_BLOCK.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.RAW_TITANIUM.get(), RecipeCategory.MISC, BlocksModReg.RAW_TITANIUM_BLOCK.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.RAW_ADAMANTITE.get(), RecipeCategory.MISC, BlocksModReg.RAW_ADAMANTITE_BLOCK.get());


        stonecutterResultFromBase(output, RecipeCategory.MISC, BlocksModReg.CREAKSTONE_STAIRS, BlocksModReg.CREAKSTONE);
        stonecutterResultFromBase(output, RecipeCategory.MISC, BlocksModReg.CREAKSTONE_SLAB, BlocksModReg.CREAKSTONE, 2);
        stonecutterResultFromBase(output, RecipeCategory.MISC, BlocksModReg.CREAKSTONE_WALL, BlocksModReg.CREAKSTONE);
        stonecutterResultFromBase(output, RecipeCategory.MISC, BlocksModReg.CREAKSTONE_TILES, BlocksModReg.CREAKSTONE);
        stonecutterResultFromBase(output, RecipeCategory.MISC, BlocksModReg.CREAKSTONE_TILES_STAIRS, BlocksModReg.CREAKSTONE);
        stonecutterResultFromBase(output, RecipeCategory.MISC, BlocksModReg.CREAKSTONE_TILES_SLAB, BlocksModReg.CREAKSTONE, 2);
        stonecutterResultFromBase(output, RecipeCategory.MISC, BlocksModReg.CREAKSTONE_TILES_WALL, BlocksModReg.CREAKSTONE);
        stonecutterResultFromBase(output, RecipeCategory.MISC, BlocksModReg.CREAKSTONE_TILES_STAIRS, BlocksModReg.CREAKSTONE_TILES);
        stonecutterResultFromBase(output, RecipeCategory.MISC, BlocksModReg.CREAKSTONE_TILES_SLAB, BlocksModReg.CREAKSTONE_TILES, 2);
        stonecutterResultFromBase(output, RecipeCategory.MISC, BlocksModReg.CREAKSTONE_TILES_WALL, BlocksModReg.CREAKSTONE_TILES);
        stonecutterResultFromBase(output, RecipeCategory.MISC, BlocksModReg.CRYSTALIC_CREAKSTONE_TILES_STAIRS, BlocksModReg.CRYSTALIC_CREAKSTONE_TILES);
        stonecutterResultFromBase(output, RecipeCategory.MISC, BlocksModReg.CRYSTALIC_CREAKSTONE_TILES_SLAB, BlocksModReg.CRYSTALIC_CREAKSTONE_TILES, 2);
        stonecutterResultFromBase(output, RecipeCategory.MISC, BlocksModReg.CRYSTALIC_CREAKSTONE_TILES_WALL, BlocksModReg.CRYSTALIC_CREAKSTONE_TILES);

        oreSmelting(output, IRON_SMELTABLES, RecipeCategory.MISC, Items.IRON_INGOT, 0.7F, 200, "iron_ingot");
        oreSmelting(output, DIAMOND_SMELTABLES, RecipeCategory.MISC, Items.DIAMOND, 1.0F, 200, "diamond");
        oreSmelting(output, SILVER_SMELTABLES, RecipeCategory.MISC, ItemsModReg.SILVER_INGOT, 1.0F, 200, "silver_ingot");
        oreSmelting(output, BISMUTH_SMELTABLES, RecipeCategory.MISC, ItemsModReg.BISMUTH, 1.0F, 200, "bismuth_ingot");
        oreSmelting(output, TITANIUM_SMELTABLES, RecipeCategory.MISC, ItemsModReg.TITANIUM_INGOT, 0.7F, 200, "titanium_ingot");
        oreSmelting(output, WITHERITE_SMELTABLES, RecipeCategory.MISC, ItemsModReg.WITHERITE, 1.0F, 200, "witherite");
        oreSmelting(output, IOLITE_SMELTABLES, RecipeCategory.MISC, ItemsModReg.IOLITE, 1.0F, 200, "iolite");
        oreSmelting(output, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ItemsModReg.ALEXANDRITE, 2.0F, 200, "alexandrite");
        oreSmelting(output, ADAMANTITE_SMELTABLES, RecipeCategory.MISC, ItemsModReg.ADAMANTITE_INGOT, 10.0F, 500, "adamantite_ingot");

        oreBlasting(output, IRON_SMELTABLES, RecipeCategory.MISC, Items.IRON_INGOT, 0.7F, 100, "iron_ingot");
        oreBlasting(output, DIAMOND_SMELTABLES, RecipeCategory.MISC, Items.DIAMOND, 1.0F, 100, "diamond");
        oreBlasting(output, SILVER_SMELTABLES, RecipeCategory.MISC, ItemsModReg.SILVER_INGOT, 1.0F, 100, "silver_ingot");
        oreBlasting(output, BISMUTH_SMELTABLES, RecipeCategory.MISC, ItemsModReg.BISMUTH, 1.0F, 100, "bismuth_ingot");
        oreBlasting(output, TITANIUM_SMELTABLES, RecipeCategory.MISC, ItemsModReg.TITANIUM_INGOT, 0.7F, 100, "titanium_ingot");
        oreBlasting(output, WITHERITE_SMELTABLES, RecipeCategory.MISC, ItemsModReg.WITHERITE, 1.0F, 100, "witherite");
        oreBlasting(output, IOLITE_SMELTABLES, RecipeCategory.MISC, ItemsModReg.IOLITE, 1.0F, 100, "iolite");
        oreBlasting(output, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ItemsModReg.ALEXANDRITE, 2.0F, 100, "alexandrite");
        oreBlasting(output, ADAMANTITE_SMELTABLES, RecipeCategory.MISC, ItemsModReg.ADAMANTITE_INGOT, 10.0F, 250, "adamantite_ingot");


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsModReg.ALEXANDRITE_AXE).define('#', Items.STICK).define('X', ItemsModReg.ALEXANDRITE).
                pattern("XX").
                pattern("X#").
                pattern(" #").unlockedBy("has_alexandrite", has(ItemsModReg.ALEXANDRITE)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsModReg.ALEXANDRITE_HOE).define('#', Items.STICK).define('X', ItemsModReg.ALEXANDRITE).
                pattern("XX").
                pattern(" #").
                pattern(" #").unlockedBy("has_alexandrite", has(ItemsModReg.ALEXANDRITE)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsModReg.ALEXANDRITE_PICKAXE).define('#', Items.STICK).define('X', ItemsModReg.ALEXANDRITE).
                pattern("XXX").
                pattern(" # ").
                pattern(" # ").unlockedBy("has_alexandrite", has(ItemsModReg.ALEXANDRITE)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsModReg.ALEXANDRITE_SHOVEL).define('#', Items.STICK).define('X', ItemsModReg.ALEXANDRITE).
                pattern("X").
                pattern("#").
                pattern("#").unlockedBy("has_alexandrite", has(ItemsModReg.ALEXANDRITE)).save(output);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsModReg.IOLITE_AXE).define('#', Items.STICK).define('X', ItemsModReg.IOLITE).
                pattern("XX").
                pattern("X#").
                pattern(" #").unlockedBy("has_iolite", has(ItemsModReg.IOLITE)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsModReg.IOLITE_HOE).define('#', Items.STICK).define('X', ItemsModReg.IOLITE).
                pattern("XX").
                pattern(" #").
                pattern(" #").unlockedBy("has_iolite", has(ItemsModReg.IOLITE)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsModReg.IOLITE_PICKAXE).define('#', Items.STICK).define('X', ItemsModReg.IOLITE).
                pattern("XXX").
                pattern(" # ").
                pattern(" # ").unlockedBy("has_iolite", has(ItemsModReg.IOLITE)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsModReg.IOLITE_SHOVEL).define('#', Items.STICK).define('X', ItemsModReg.IOLITE).
                pattern("X").
                pattern("#").
                pattern("#").unlockedBy("has_iolite", has(ItemsModReg.IOLITE)).save(output);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsModReg.TITANIUM_AXE).define('#', Items.STICK).define('X', ItemsModReg.TITANIUM_INGOT).
                pattern("XX").
                pattern("X#").
                pattern(" #").unlockedBy("has_titanium_ingot", has(ItemsModReg.TITANIUM_INGOT)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsModReg.TITANIUM_HOE).define('#', Items.STICK).define('X', ItemsModReg.TITANIUM_INGOT).
                pattern("XX").
                pattern(" #").
                pattern(" #").unlockedBy("has_titanium_ingot", has(ItemsModReg.TITANIUM_INGOT)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsModReg.TITANIUM_PICKAXE).define('#', Items.STICK).define('X', ItemsModReg.TITANIUM_INGOT).
                pattern("XXX").
                pattern(" # ").
                pattern(" # ").unlockedBy("has_titanium_ingot", has(ItemsModReg.TITANIUM_INGOT)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsModReg.TITANIUM_SHOVEL).define('#', Items.STICK).define('X', ItemsModReg.TITANIUM_INGOT).
                pattern("X").
                pattern("#").
                pattern("#").unlockedBy("has_titanium_ingot", has(ItemsModReg.TITANIUM_INGOT)).save(output);

        makeArmorRecipe(output, ItemsModReg.SILVER_INGOT.get(), ItemsModReg.SILVER_HELMET.get(), ItemsModReg.SILVER_CHESTPLATE, ItemsModReg.SILVER_LEGGINGS, ItemsModReg.SILVER_BOOTS);
        makeArmorRecipe(output, ItemsModReg.WITHERITE.get(), ItemsModReg.WITHERITE_HELMET.get(), ItemsModReg.WITHERITE_CHESTPLATE, ItemsModReg.WITHERITE_LEGGINGS, ItemsModReg.WITHERITE_BOOTS);
        makeArmorRecipe(output, ItemsModReg.IOLITE.get(), ItemsModReg.IOLITE_HELMET.get(), ItemsModReg.IOLITE_CHESTPLATE, ItemsModReg.IOLITE_LEGGINGS, ItemsModReg.IOLITE_BOOTS);
        makeArmorRecipe(output, ItemsModReg.ALEXANDRITE.get(), ItemsModReg.ALEXANDRITE_HELMET.get(), ItemsModReg.ALEXANDRITE_CHESTPLATE, ItemsModReg.ALEXANDRITE_LEGGINGS, ItemsModReg.ALEXANDRITE_BOOTS);


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
        IRON_SMELTABLES = ImmutableList.of(BlocksModReg.CREAKSTONE_IRON_ORE);
        DIAMOND_SMELTABLES = ImmutableList.of(BlocksModReg.CREAKSTONE_DIAMOND_ORE);
        SILVER_SMELTABLES = ImmutableList.of(BlocksModReg.SILVER_ORE, BlocksModReg.DEEPSLATE_SILVER_ORE, ItemsModReg.RAW_SILVER);
        BISMUTH_SMELTABLES = ImmutableList.of(BlocksModReg.BISMUTH_ORE, BlocksModReg.DEEPSLATE_BISMUTH_ORE, ItemsModReg.RAW_BISMUTH);
        TITANIUM_SMELTABLES = ImmutableList.of(Items.COPPER_ORE, Items.DEEPSLATE_COPPER_ORE, Items.RAW_COPPER);
        WITHERITE_SMELTABLES = ImmutableList.of(BlocksModReg.WITHERITE_ORE);
        IOLITE_SMELTABLES = ImmutableList.of(BlocksModReg.IOLITE_ORE);
        ALEXANDRITE_SMELTABLES = ImmutableList.of(BlocksModReg.ALEXANDRITE_ORE);
        ADAMANTITE_SMELTABLES = ImmutableList.of(BlocksModReg.ADAMANTITE_ORE, ItemsModReg.ADAMANTITE_INGOT);
    }
}
