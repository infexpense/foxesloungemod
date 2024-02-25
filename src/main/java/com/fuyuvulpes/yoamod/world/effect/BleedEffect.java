package com.fuyuvulpes.yoamod.world.effect;

import com.fuyuvulpes.yoamod.core.registries.ModKeys;
import com.fuyuvulpes.yoamod.core.registries.ParticleModReg;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class BleedEffect extends MobEffect {
    public BleedEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }


    @Override
    public void applyEffectTick(LivingEntity entity, int pAmplifier) {
        super.applyEffectTick(entity, pAmplifier);
        entity.hurt(entity.damageSources().source(ModKeys.BLEEDING), 1.3F * (pAmplifier + 1));

        Level level = entity.level();
        for (int i = 5 + (pAmplifier * 3); i > 0; i--){
            if (level.isClientSide){
                level.addParticle(ParticleModReg.BLEEDING.get(),entity.getX() - 0.5 + entity.level().getRandom().nextFloat() * 2,entity.getY() - 0.5 + entity.level().getRandom().nextFloat() * 2,entity.getZ() - 0.5 + entity.level().getRandom().nextFloat() * 2,level.random.nextFloat(),-0.2F,level.random.nextDouble());
            }
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        int i = 32 >> pAmplifier;
        if (i > 0) {
            return pDuration % i == 0;
        } else {
            return true;
        }
    }



}
