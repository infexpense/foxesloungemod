package com.fuyuvulpes.yoamod.compat.emi;

import com.fuyuvulpes.yoamod.game.server.crafting.HammeringStationRecipe;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.stream.Collectors;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class EmiHammeringStation<T extends HammeringStationRecipe> extends YoaEmiRecipes<T> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(MODID, "textures/gui/hammering_station.png");

    private final List<EmiIngredient> inputs;
    private final EmiStack outputs;

    public EmiHammeringStation(RecipeHolder<T> recipe) {
        super(YOAEmiCompat.HAMMERING_STATION, recipe, 176, 166);
        this.inputs = recipe.value().getIngredients().stream().map(EmiIngredient::of).collect(Collectors.toList());
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
        holder.addSlot(this.getInputs().get(0), 7, 7).large(true).drawBack(false);
        holder.addSlot(this.getInputs().get(1), 7, 27).large(true).drawBack(false);
        holder.addSlot(this.getInputs().get(2), 27, 7).large(true).drawBack(false);
        holder.addSlot(this.getInputs().get(3), 27, 27).large(true).drawBack(false);
        if (this.outputs != EmiStack.of(Blocks.AIR)) {
            holder.addSlot(this.getOutputs().get(0), 141, 54).large(true).drawBack(false);
        }
    }
}
