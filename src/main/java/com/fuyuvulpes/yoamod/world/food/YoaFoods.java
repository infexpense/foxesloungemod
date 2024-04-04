package com.fuyuvulpes.yoamod.world.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class YoaFoods {

    public static final FoodProperties ETHERFRUCTUS = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.3F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 120, 0), 0.4F)
            .fast()
            .build();

    public static final FoodProperties COOKED_BIG_MEAT = new FoodProperties.Builder().
            nutrition(16).
            saturationMod(2.0F).
            meat().
            build();

    public static final FoodProperties BIG_MEAT = new FoodProperties.Builder().
            nutrition(6)
            .saturationMod(0.7F)
            .meat()
            .build();

    public static final FoodProperties SLICED_COOKED_MEAT = new FoodProperties.Builder().
            nutrition(6).
            saturationMod(0.4F).
            meat().
            fast().
            build();

    public static final FoodProperties SLICED_MEAT = new FoodProperties.Builder().
            nutrition(3)
            .saturationMod(0.2F)
            .meat()
            .fast()
            .build();

    public static final FoodProperties HAMBURGER = new FoodProperties.Builder().
            nutrition(20)
            .saturationMod(4.0F)
            .meat()
            .build();


}
