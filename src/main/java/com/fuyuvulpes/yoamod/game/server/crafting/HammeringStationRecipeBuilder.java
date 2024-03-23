package com.fuyuvulpes.yoamod.game.server.crafting;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class HammeringStationRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final int count;
    private final ItemStack resultStack;
    private final Ingredient ingA;
    private Ingredient ingB = Ingredient.EMPTY;
    private Ingredient ingC = Ingredient.EMPTY;
    private Ingredient ingD = Ingredient.EMPTY;
    @javax.annotation.Nullable
    private String group;
    private boolean showNotification = true;

    public HammeringStationRecipeBuilder(Ingredient ingA, ItemLike pResult, int pCount) {
        this(ingA, new ItemStack(pResult, pCount));
    }

    public HammeringStationRecipeBuilder(Ingredient ingA, ItemStack result) {
        this.result = result.getItem();
        this.count = result.getCount();
        this.resultStack = result;
        this.ingA = ingA;
    }
    public HammeringStationRecipeBuilder setIngB(ItemLike item){
        this.ingB = Ingredient.of(item);
        return this;
    }

    public HammeringStationRecipeBuilder setIngC(ItemLike item){
        this.ingC = Ingredient.of(item);
        return this;
    }

    public HammeringStationRecipeBuilder setIngD(ItemLike item){
        this.ingD = Ingredient.of(item);
        return this;
    }

    public static HammeringStationRecipeBuilder of(ItemLike ingA, ItemLike result) {
        return of(ingA,result,1);
    }

    public static HammeringStationRecipeBuilder of(ItemLike ingA, ItemLike result, int count){
        return new HammeringStationRecipeBuilder(Ingredient.of(ingA),result,count);
    }


    @Override
    public RecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    @Override
    public Item getResult() {
        return this.result;

    }

    @Override
    public void save(RecipeOutput pRecipeOutput, ResourceLocation pId) {
        Advancement.Builder advancement$builder = pRecipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pId))
                .rewards(AdvancementRewards.Builder.recipe(pId))
                .requirements(AdvancementRequirements.Strategy.OR);
        HammeringStationRecipe hammeringStationRecipe = new HammeringStationRecipe(
                Objects.requireNonNullElse(this.group, "hammering_station_group"),
                ingA,
                ingB,
                ingC,
                ingD,
                resultStack
        );
        ResourceLocation newId = new ResourceLocation(pId + "_hammering_station");
        pRecipeOutput.accept(newId, hammeringStationRecipe,advancement$builder.build(pId.withPrefix("recipes/" + "hammering_station" + "/")));
    }
}

