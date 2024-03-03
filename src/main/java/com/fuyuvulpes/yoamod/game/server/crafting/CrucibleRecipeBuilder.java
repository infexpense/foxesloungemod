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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class CrucibleRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final int count;
    private int time = 200;
    private final ItemStack resultStack;
    private final Ingredient key;
    private Ingredient assist = Ingredient.EMPTY;
    private Ingredient support = Ingredient.EMPTY;
    @javax.annotation.Nullable
    private String group;
    private boolean showNotification = true;
    private int xp = 10;

    public CrucibleRecipeBuilder(Ingredient key,ItemLike pResult, int pCount) {
        this(key,new ItemStack(pResult, pCount));
    }


    public CrucibleRecipeBuilder( Ingredient key, ItemStack result) {
        this.result = result.getItem();
        this.count = result.getCount();
        this.resultStack = result;
        this.key = key;
    }


    public static CrucibleRecipeBuilder of(ItemLike pIngredient, ItemLike result) {
        return of(pIngredient,result,1);
    }

    public static CrucibleRecipeBuilder of(ItemLike pIngredient, ItemLike result,int count){
        return new CrucibleRecipeBuilder(Ingredient.of(pIngredient),result,count);
    }

    public CrucibleRecipeBuilder withSecondaryItem(ItemLike item){
        this.assist = Ingredient.of(item);
        return this;
    }

    public CrucibleRecipeBuilder withSupport(ItemLike item){
        this.support = Ingredient.of(item);
        return this;
    }

    public CrucibleRecipeBuilder expReward(int experience){
        this.xp = experience;
        return this;
    }

    public CrucibleRecipeBuilder timed(int time){
        this.time = time;
        return this;
    }




    @Override
    public CrucibleRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
        return this;
    }

    @Override
    public CrucibleRecipeBuilder group(@Nullable String pGroupName) {
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
        CrucibleRecipe crucibleRecipe = new CrucibleRecipe(
                Objects.requireNonNullElse(this.group, ""),
                this.key,
                this.assist,
                this.support,
                this.resultStack,
                this.xp,
                this.time
        );
        ResourceLocation newId = new ResourceLocation(pId + "_crucible");
        pRecipeOutput.accept(newId, crucibleRecipe,advancement$builder.build(pId.withPrefix("recipes/" + "crucible" + "/")));
    }
}
