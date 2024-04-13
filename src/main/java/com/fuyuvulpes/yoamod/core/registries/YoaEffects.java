package com.fuyuvulpes.yoamod.core.registries;

import com.fuyuvulpes.yoamod.world.effect.BleedEffect;
import com.fuyuvulpes.yoamod.world.effect.FreezingEffect;
import com.fuyuvulpes.yoamod.world.effect.StunEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class YoaEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, MODID);

    public static final DeferredHolder<MobEffect,MobEffect> BLEEDING = MOB_EFFECTS.register("bleeding",
            () -> new BleedEffect(MobEffectCategory.HARMFUL,6229545));

    public static final DeferredHolder<MobEffect,MobEffect> STUNNED = MOB_EFFECTS.register("stun",
            () -> new StunEffect(MobEffectCategory.HARMFUL,5196096)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, "d2837724-8bf0-43c4-ae6c-7e9169602b37", 0.0F,
                    AttributeModifier.Operation.MULTIPLY_TOTAL));


    public static final DeferredHolder<MobEffect,MobEffect> FREEZING = MOB_EFFECTS.register("freeze",
            () -> new FreezingEffect(MobEffectCategory.HARMFUL,7857919)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, "538cc8a3-16ee-4f25-9a26-c6794c4bec81", 0.5F,
                    AttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(Attributes.ATTACK_SPEED, "484bfbff-7353-4880-874d-0c3f9528345b", 0.5F,
                    AttributeModifier.Operation.MULTIPLY_TOTAL));




    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }

}
