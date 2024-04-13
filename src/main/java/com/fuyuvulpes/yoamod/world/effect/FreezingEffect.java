package com.fuyuvulpes.yoamod.world.effect;

import com.fuyuvulpes.yoamod.core.registries.YoaParticles;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class FreezingEffect extends MobEffect {
    public FreezingEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }



    @Override
    public void applyEffectTick(LivingEntity entity, int pAmplifier) {
        super.applyEffectTick(entity, pAmplifier);
        entity.setIsInPowderSnow(true);
        if (entity.getTicksFrozen() < 120) {
            entity.setTicksFrozen(entity.getTicksFrozen() + 10);

        }
        Level level = entity.level();
        for (int i = 5 + (pAmplifier * 3); i > 0; i--){
            if (!level.isClientSide){
                ServerLevel serverLevel = (ServerLevel) level;
                serverLevel.sendParticles(ParticleTypes.SNOWFLAKE,entity.getX(),entity.getY() + (entity.getBbHeight() / 2) ,entity.getZ(),entity.getRandom().nextIntBetweenInclusive(2,4),
                        entity.getRandomX(0.5),entity.getRandomY(),entity.getRandomZ(0.5),0.01F);
            }
        }    }


    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }

}
