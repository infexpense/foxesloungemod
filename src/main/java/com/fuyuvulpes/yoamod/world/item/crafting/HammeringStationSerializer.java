package com.fuyuvulpes.yoamod.world.item.crafting;

import com.fuyuvulpes.yoamod.game.server.crafting.HammeringStationRecipe;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class HammeringStationSerializer<T extends HammeringStationRecipe> implements RecipeSerializer<T> {
    private final HammeringStationRecipe.Factory<T> factory;
    private final Codec<T> codec;

    public HammeringStationSerializer(HammeringStationRecipe.Factory<T> factory) {
        this.factory = factory;
        this.codec = RecordCodecBuilder.create(
                instance -> instance.group(
                        ExtraCodecs.strictOptionalField(Codec.STRING, "group", "").forGetter(p_300832_ -> p_300832_.group),
                        Ingredient.CODEC_NONEMPTY.fieldOf("ingA").forGetter(p_300833_ -> p_300833_.ingA),
                                ExtraCodecs.strictOptionalField(Ingredient.CODEC,"ingB",Ingredient.EMPTY).forGetter(p_300833_ -> p_300833_.ingB),
                                ExtraCodecs.strictOptionalField(Ingredient.CODEC,"ingC",Ingredient.EMPTY).forGetter(p_300833_ -> p_300833_.ingC),
                                ExtraCodecs.strictOptionalField(Ingredient.CODEC,"ingD",Ingredient.EMPTY).forGetter(p_300833_ -> p_300833_.ingD),
                        net.neoforged.neoforge.common.crafting.CraftingHelper.smeltingResultCodec().fieldOf("result").forGetter(p_300827_ -> p_300827_.result)
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
        Ingredient ingA = Ingredient.fromNetwork(pBuffer);
        Ingredient ingB = Ingredient.fromNetwork(pBuffer);
        Ingredient ingC = Ingredient.fromNetwork(pBuffer);
        Ingredient ingD = Ingredient.fromNetwork(pBuffer);
        ItemStack itemStack = pBuffer.readItem();

        return this.factory.create(s, ingA, ingB, ingC, ingD, itemStack);
    }


    public void toNetwork(FriendlyByteBuf pBuffer, T pRecipe) {
        pBuffer.writeUtf(pRecipe.group);
        pRecipe.ingA.toNetwork(pBuffer);
        pRecipe.ingB.toNetwork(pBuffer);
        pRecipe.ingC.toNetwork(pBuffer);
        pRecipe.ingD.toNetwork(pBuffer);
        pBuffer.writeItem(pRecipe.result);

    }

    public HammeringStationRecipe create(
            String group, Ingredient ingA, Ingredient ingB, Ingredient ingC, Ingredient ingD, ItemStack result) {
        return this.factory.create(group, ingA, ingB, ingC, ingD, result);
    }
}
