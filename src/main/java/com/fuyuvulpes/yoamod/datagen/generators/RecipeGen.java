package com.fuyuvulpes.yoamod.datagen.generators;

import com.fuyuvulpes.yoamod.registries.BlocksModReg;
import com.fuyuvulpes.yoamod.registries.ItemsModReg;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class RecipeGen extends RecipeProvider implements IConditionBuilder {
    public RecipeGen(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.CRYSTALIC_SHARD.get(), RecipeCategory.MISC, BlocksModReg.CRYSTALIC_REMNANTS.get());
        twoByTwoPacker(output,RecipeCategory.MISC,BlocksModReg.RUNE_CRYSTAL_BLOCK.get(),ItemsModReg.RUNE_CRYSTAL.get());
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
                pattern(" # " ).
                pattern(" # " ).unlockedBy("has_titanium_ingot", has(ItemsModReg.TITANIUM_INGOT)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsModReg.TITANIUM_SHOVEL).define('#', Items.STICK).define('X', ItemsModReg.TITANIUM_INGOT).
                pattern("X").
                pattern("#").
                pattern("#").unlockedBy("has_titanium_ingot", has(ItemsModReg.TITANIUM_INGOT)).save(output);

        makeArmorRecipe(output, ItemsModReg.SILVER_INGOT.get(), ItemsModReg.SILVER_HELMET.get(), ItemsModReg.SILVER_CHESTPLATE, ItemsModReg.SILVER_LEGGINGS, ItemsModReg.SILVER_BOOTS);
        makeArmorRecipe(output, ItemsModReg.WITHERITE.get(), ItemsModReg.WITHERITE_HELMET.get(), ItemsModReg.WITHERITE_CHESTPLATE, ItemsModReg.WITHERITE_LEGGINGS, ItemsModReg.WITHERITE_BOOTS);
        makeArmorRecipe(output, ItemsModReg.IOLITE.get(), ItemsModReg.IOLITE_HELMET.get(), ItemsModReg.IOLITE_CHESTPLATE, ItemsModReg.IOLITE_LEGGINGS, ItemsModReg.IOLITE_BOOTS);
        makeArmorRecipe(output, ItemsModReg.ALEXANDRITE.get(), ItemsModReg.ALEXANDRITE_HELMET.get(), ItemsModReg.ALEXANDRITE_CHESTPLATE , ItemsModReg.ALEXANDRITE_LEGGINGS, ItemsModReg.ALEXANDRITE_BOOTS);





    }



    public static void makeArmorRecipe(RecipeOutput output, ItemLike material, ItemLike helmet, ItemLike chestplate, ItemLike leggings, ItemLike boots){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT,helmet).define('#',material)
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_material",has(material)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT,chestplate).define('#',material)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_material",has(material)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT,leggings).define('#',material)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_material",has(material)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT,boots).define('#',material)
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_material",has(material)).save(output);
    }


}
