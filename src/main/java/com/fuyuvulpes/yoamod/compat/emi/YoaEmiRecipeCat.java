package com.fuyuvulpes.yoamod.compat.emi;

import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiRenderable;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class YoaEmiRecipeCat extends EmiRecipeCategory {

    public final String name;
    public final Component title;
    public YoaEmiRecipeCat(String id, ItemLike icon) {
        super(new ResourceLocation(MODID,id), EmiStack.of(icon));
        this.name = id;
        this.title = Component.translatable("gui.yoamod." + name);
    }

    @Override
    public Component getName() {
        return this.title;
    }
}
