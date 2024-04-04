package com.fuyuvulpes.yoamod.world.entity;

import com.fuyuvulpes.yoamod.core.YOACommonConfig;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class ArmedSpider extends Spider {
    public ArmedSpider(EntityType<? extends Spider> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }



    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.2F));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this,1.3F,true));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[0]));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class,true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class,true));
    }


    @Override
    public boolean doHurtTarget(Entity pEntity) {
        if (super.doHurtTarget(pEntity)) {
            ((LivingEntity)pEntity).addEffect(new MobEffectInstance(MobEffects.POISON, 120, 2), this);
            if(YOACommonConfig.armedSpiderDebuff) {
                ((LivingEntity) pEntity).addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60, 0), this);
                ((LivingEntity) pEntity).addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60, 0), this);
                ((LivingEntity) pEntity).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 80, 0), this);
            }
            return true;
        } else {
            return false;
        }
    }
    @Override
    protected int calculateFallDamage(float pFallDistance, float pDamageMultiplier) {
        return 0;
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        return pSpawnData;
    }

    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return 1.3F;
    }



    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 130.0)
                .add(Attributes.MOVEMENT_SPEED, 0.45)
                .add(Attributes.JUMP_STRENGTH, 3.5F)
                .add(Attributes.ATTACK_DAMAGE, 18.0F)
                .add(Attributes.FOLLOW_RANGE,38.0F);
    }


}
