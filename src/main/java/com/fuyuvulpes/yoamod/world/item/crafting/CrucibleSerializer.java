package com.fuyuvulpes.yoamod.world.item.crafting;

import com.fuyuvulpes.yoamod.game.server.crafting.CrucibleRecipe;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class CrucibleSerializer<T extends CrucibleRecipe> implements RecipeSerializer<T> {
    private final CrucibleRecipe.Factory<T> factory;
    private final Codec<T> codec;


    public CrucibleSerializer(CrucibleRecipe.Factory<T> factory) {
        this.factory = factory;
        this.codec = RecordCodecBuilder.create(
                instance -> instance.group(
                                ExtraCodecs.strictOptionalField(Codec.STRING, "group", "").forGetter(p_300832_ -> p_300832_.group),
                                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(p_300833_ -> p_300833_.ingredientA),
                                ExtraCodecs.strictOptionalField(Ingredient.CODEC,"secondingredient",Ingredient.EMPTY).forGetter(p_300833_ -> p_300833_.ingredientB),
                                ExtraCodecs.strictOptionalField(Ingredient.CODEC,"supportitem", Ingredient.EMPTY).forGetter(p_300833_ -> p_300833_.supportingItem),
                                net.neoforged.neoforge.common.crafting.CraftingHelper.smeltingResultCodec().fieldOf("result").forGetter(p_300827_ -> p_300827_.result),
                                Codec.FLOAT.fieldOf("experience").orElse(0.0F).forGetter(p_300826_ -> p_300826_.experience),
                                Codec.INT.fieldOf("time").forGetter(p_300834_ -> p_300834_.cookingTime)
                        )
                        .apply(instance, factory::create)
        );
    }
    @Override
    public Codec<T> codec() {
        return this.codec;
    }

    public T fromNetwork(FriendlyByteBuf pBuffer) {
        String s = pBuffer.readUtf();
        Ingredient ingredientA = Ingredient.fromNetwork(pBuffer);
        Ingredient ingredientB = Ingredient.fromNetwork(pBuffer);
        Ingredient supportItem = Ingredient.fromNetwork(pBuffer);
        ItemStack itemstack = pBuffer.readItem();
        float f = pBuffer.readFloat();
        int i = pBuffer.readVarInt();
        return this.factory.create(s, ingredientA,ingredientB,supportItem, itemstack, f, i);
    }

    public void toNetwork(FriendlyByteBuf pBuffer, T pRecipe) {
        pBuffer.writeUtf(pRecipe.group);
        pRecipe.ingredientA.toNetwork(pBuffer);
        pRecipe.ingredientB.toNetwork(pBuffer);
        pRecipe.supportingItem.toNetwork(pBuffer);
        pBuffer.writeItem(pRecipe.result);
        pBuffer.writeFloat(pRecipe.experience);
        pBuffer.writeVarInt(pRecipe.cookingTime);
    }
    public CrucibleRecipe create(
            String group, Ingredient ingredient, Ingredient secondingredient, Ingredient supportitem, ItemStack result, float experience, int time
    ) {
        return this.factory.create(group,ingredient,secondingredient,supportitem,result,experience,time);
    }
}
