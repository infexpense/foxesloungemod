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
    public RecipeGen(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.CRYSTALIC_SHARD.get(), RecipeCategory.MISC, BlocksModReg.CRYSTALIC_REMNANTS.get());
        twoByTwoPacker(output,RecipeCategory.MISC,BlocksModReg.RUNE_CRYSTAL_BLOCK.get(),ItemsModReg.RUNE_CRYSTAL.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.ADAMANTITE_NUGGET.get(), RecipeCategory.MISC, ItemsModReg.ADAMANTITE_INGOT.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.ALEXANDRITE_SHARD.get(), RecipeCategory.MISC, ItemsModReg.ALEXANDRITE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.BISMUTH_SHARD.get(), RecipeCategory.MISC, ItemsModReg.BISMUTH.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.BRONZE_NUGGET.get(), RecipeCategory.MISC, ItemsModReg.BRONZE_INGOT.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.DIAMOND_SHARD.get(), RecipeCategory.MISC, Items.DIAMOND);
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.IOLITE_SHARD.get(), RecipeCategory.MISC, ItemsModReg.IOLITE.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.NETHERITE_NUGGET.get(), RecipeCategory.MISC, Items.NETHERITE_INGOT);
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.SILVER_NUGGET.get(), RecipeCategory.MISC, ItemsModReg.SILVER_INGOT.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.STEEL_NUGGET.get(), RecipeCategory.MISC, ItemsModReg.STEEL_INGOT.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.TITANIUM_NUGGET.get(), RecipeCategory.MISC, ItemsModReg.TITANIUM_INGOT.get());
        nineBlockStorageRecipes(output, RecipeCategory.MISC, ItemsModReg.WITHERITE_SHARD.get(), RecipeCategory.MISC, ItemsModReg.WITHERITE.get());



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
