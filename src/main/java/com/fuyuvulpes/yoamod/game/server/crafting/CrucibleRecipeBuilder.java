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

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class CrucibleRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final int count;
    private int time = 200;
    private final ItemStack resultStack;
    private final Ingredient key;
    private  Ingredient assist = Ingredient.EMPTY ;
    private Ingredient support =  Ingredient.EMPTY;
    @javax.annotation.Nullable
    private String group;
    private boolean showNotification = true;
    private int xp = 10;

    public CrucibleRecipeBuilder(Ingredient key, ItemLike pResult, int pCount) {
        this(key,new ItemStack(pResult, pCount));
    }


    public CrucibleRecipeBuilder(Ingredient keyItem, ItemStack result) {
        this.result = result.getItem();
        this.count = result.getCount();
        this.resultStack = result;
        this.key = keyItem;
    }

    public CrucibleRecipeBuilder setAssist(Ingredient assistItem) {
        this.assist = assistItem;
        return this;
    }

    public CrucibleRecipeBuilder setSupport(Ingredient supportItem) {
        this.support = supportItem;
        return this;
    }


    public static CrucibleRecipeBuilder of(ItemLike pIngredient,ItemLike result) {
        return of(pIngredient,result,1);

    }

    public static CrucibleRecipeBuilder of(ItemLike pIngredient,ItemLike result,int count){

        return new CrucibleRecipeBuilder(Ingredient.of(pIngredient),result,count);
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
        CrucibleRecipe crucibleRecipe = new CrucibleRecipe(
                Objects.requireNonNullElse(this.group, ""),
                this.key,
                this.assist,
                this.support,
                this.resultStack,
                this.xp,
                this.time
        );
        ResourceLocation newId = new ResourceLocation(MODID,pId.getPath() + "_crucible");
        pRecipeOutput.accept(newId, crucibleRecipe,null);
    }
}
