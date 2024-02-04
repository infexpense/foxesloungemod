package com.fuyuvulpes.yoamod.custom.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class StunEffect extends MobEffect {
    public StunEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int pAmplifier) {
        super.applyEffectTick(entity, pAmplifier);

        entity.setDeltaMovement(0,0,0);
        entity.setJumping(false);
        entity.setXRot(entity.getViewXRot(3));
        entity.setYRot(entity.getViewXRot(3));

    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }
}

