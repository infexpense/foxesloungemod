package com.fuyuvulpes.yoamod.world.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class BrawlerEntity extends Monster {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();

    public BrawlerEntity(EntityType<BrawlerEntity> entityType, Level level) {
        super(entityType, level);
        this.xpReward = 100;
    }


    @Override
    public boolean canDisableShield() {
        return true;
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0,new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.4f, false));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 64.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        //TARGETS
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 350.0)
                .add(Attributes.MOVEMENT_SPEED, 0.2F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.3F)
                .add(Attributes.ATTACK_KNOCKBACK, 4.0F)
                .add(Attributes.ATTACK_DAMAGE, 27.0)
                .add(Attributes.FOLLOW_RANGE,15.0F);
    }

    @Override
    public void tick() {
        if (level().isClientSide()){
            this.attackAnimationState.animateWhen(attackAnim > 0,this.tickCount);
            this.idleAnimationState.startIfStopped( this.tickCount);
        }

        super.tick();

    }

    public static boolean canSpawn(EntityType<BrawlerEntity> entityType, ServerLevelAccessor level, MobSpawnType type, BlockPos pos, RandomSource randomSource){
        return checkMonsterSpawnRules(entityType,level,type,pos,randomSource);
    }

}
