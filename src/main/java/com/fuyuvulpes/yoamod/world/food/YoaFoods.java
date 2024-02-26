package com.fuyuvulpes.yoamod.world.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class YoaFoods {

    public static final FoodProperties ETHERFRUCTUS = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.3F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 120, 0), 0.4F)
            .build();


}
