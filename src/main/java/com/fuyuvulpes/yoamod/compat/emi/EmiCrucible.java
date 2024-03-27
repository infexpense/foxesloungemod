package com.fuyuvulpes.yoamod.compat.emi;

import com.fuyuvulpes.yoamod.game.server.crafting.CrucibleRecipe;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.stream.Collectors;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class EmiCrucible<T extends CrucibleRecipe> extends YoaEmiRecipes<T> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(MODID, "textures/gui/crucible.png");

    private final List<EmiIngredient> inputs;
    private final List<EmiStack> outputs;


    public EmiCrucible(RecipeHolder<T> recipe) {
        super(YOAEmiCompat.CRUCIBLE, recipe, 176, 166);
        this.inputs = recipe.value().getIngredients().stream().map(EmiIngredient::of).collect(Collectors.toList());
        this.outputs = List.of(EmiStack.of(recipe.value().result));
    }


    @Override
    public List<EmiIngredient> getInputs() {
        return this.inputs;
    }

    @Override
    public List<EmiStack> getOutputs() {
        return this.outputs;
    }

    @Override
    public void addWidgets(WidgetHolder holder) {
        int x = 176;
        int y = 166;
        holder.addTexture(TEXTURE, 0, 0, x, y, 0, 0);
        holder.addSlot(this.getInputs().get(0), 22, 18).large(true).drawBack(false);
        holder.addSlot(this.getInputs().get(1), 40, 18).large(true).drawBack(false);
        holder.addSlot(this.getInputs().get(2), 31, 40).large(true).drawBack(false);
        holder.addSlot(EmiIngredient.of(Ingredient.of(Items.LAVA_BUCKET)), 79, 50).large(true).drawBack(false);
        if (this.outputs != EmiStack.of(Blocks.AIR)) {
            holder.addSlot(this.getOutputs().get(0), 127, 18).large(true).drawBack(false);
        }
    }

}
