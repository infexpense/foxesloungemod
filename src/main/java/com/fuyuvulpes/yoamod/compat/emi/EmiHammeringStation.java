package com.fuyuvulpes.yoamod.compat.emi;

import com.fuyuvulpes.yoamod.game.server.crafting.HammeringStationRecipe;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class EmiHammeringStation<T extends HammeringStationRecipe> extends YoaEmiRecipes<T> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(MODID, "textures/gui/container/hammering_station.png");

    private final List<EmiIngredient> inputs;
    private final EmiStack outputs;

    public EmiHammeringStation(RecipeHolder<T> recipe) {
        super(YOAEmiCompat.HAMMERING_STATION, recipe, 176, 166);
        this.inputs = Stream.of(recipe.value().getIngA(),recipe.value().getIngB(),recipe.value().getIngC(),recipe.value().getIngD()).map(EmiIngredient::of).toList();

        this.outputs = EmiStack.of(recipe.value().result);
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return this.inputs;
    }

    @Override
    public List<EmiStack> getOutputs() {
        return List.of(this.outputs);
    }

    @Override
    public void addWidgets(WidgetHolder holder) {
        int x = 176;
        int y = 166;
        holder.addTexture(TEXTURE, 0, 0, x, y, 0, 0);
        if (this.getInputs().get(0) != EmiIngredient.of(Ingredient.of(Blocks.AIR)) && !this.getInputs().get(0).isEmpty()) {

            holder.addSlot(this.getInputs().get(0), 7, 7).large(false).drawBack(false);
        }
        if (this.getInputs().size() >= 2 && this.getInputs().get(1) != EmiIngredient.of(Ingredient.of(Blocks.AIR)) && !this.getInputs().get(1).isEmpty()) {

            holder.addSlot(this.getInputs().get(1), 27, 7).large(false).drawBack(false);
        }

        if (this.getInputs().size() >= 3 && this.getInputs().get(2) != EmiIngredient.of(Ingredient.of(Blocks.AIR)) && !this.getInputs().get(2).isEmpty()) {

            holder.addSlot(this.getInputs().get(2), 7, 27).large(false).drawBack(false);
        }
        if (this.getInputs().size() >= 4 && this.getInputs().get(3) != EmiIngredient.of(Ingredient.of(Blocks.AIR)) && !this.getInputs().get(3).isEmpty()) {

            holder.addSlot(this.getInputs().get(3), 27, 27).large(false).drawBack(false);
        }
        if (this.outputs != EmiStack.of(Blocks.AIR)) {
            holder.addSlot(this.getOutputs().get(0), 141, 54).large(false).drawBack(false);
        }
    }
}
