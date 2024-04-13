package com.fuyuvulpes.yoamod.world.entity;

import com.fuyuvulpes.yoamod.core.registries.YoaEffects;
import com.fuyuvulpes.yoamod.core.registries.YoaSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class YukiOnnaEntity extends Monster {

    protected boolean castingSpell;
    protected int castCooldown;


    public YukiOnnaEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new FlyingMoveControl(this, 40, true);

    }


    @Override
    protected void checkFallDamage(double pY, boolean pOnGround, BlockState pState, BlockPos pPos) {    }

    @Override
    public MobType getMobType() {
        return YoaMobTypes.SPIRIT;
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.castingSpell = pCompound.getBoolean("Casting");
        this.castCooldown = pCompound.getInt("Cooldown");
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("Casting", this.castingSpell);
        pCompound.putInt("Cooldown", this.castCooldown);
    }


    @Override
    protected PathNavigation createNavigation(Level pLevel) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, pLevel) {
            @Override
            public boolean isStableDestination(BlockPos blockPos) {
                return !this.level.getBlockState(blockPos.below().below()).isAir();
            }

        };
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }



    @Override
    protected SoundEvent getAmbientSound() {
        return YoaSounds.YUKI_ONNA_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return YoaSounds.YUKI_ONNA_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return YoaSounds.YUKI_ONNA_DEATH.get();
    }


    @Override
    public boolean canFreeze() {
        return false;
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        if (super.doHurtTarget(pEntity)) {
            pEntity.setTicksFrozen(pEntity.getTicksFrozen() + 50);
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0,new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0f, false));
        this.goalSelector.addGoal(4, new YukiOnnaSpell());
        this.goalSelector.addGoal(7, new YukiOnnaStrollGoal(this, 1.0));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 16.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        //TARGETS
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20.0)
                .add(Attributes.FLYING_SPEED, 0.3F)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_DAMAGE, 2.0)
                ;
    }




    public static boolean canSpawn(EntityType<YukiOnnaEntity> entityType, ServerLevelAccessor level, MobSpawnType type, BlockPos pos, RandomSource randomSource){
        return level.getDifficulty() != Difficulty.PEACEFUL
                && level.getBrightness(LightLayer.BLOCK,pos) < 5
                && level.dayTime() > 11834
                && level.dayTime() < 23460
                && (type == MobSpawnType.SPAWNER
                || level.getBlockState(pos).isValidSpawn(level, pos, entityType)
                || level.getBlockState(pos).is(Blocks.SNOW_BLOCK)
                || level.getBlockState(pos).is(Blocks.SNOW)
                || level.getBlockState(pos).is(Blocks.POWDER_SNOW));
    }

    @Override
    public void aiStep() {
        if (this.level().isClientSide && this.random.nextFloat() > 0.1F) {
            for(int i = 0; i < 2; ++i) {
                this.level().addParticle(ParticleTypes.SNOWFLAKE, this.getRandomX(0.5), this.getRandomY(), this.getRandomZ(0.5), 0.0, 0.0, 0.0);
            }
        }
        if (this.castCooldown > 0){
            castCooldown--;
        }
        super.aiStep();
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @org.jetbrains.annotations.Nullable SpawnGroupData pSpawnData, @org.jetbrains.annotations.Nullable CompoundTag pDataTag) {
        this.castCooldown = 20;
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }


    public boolean isCastingSpell() {
        return this.castingSpell;

    }

    public void setIsCastingSpell(boolean bool) {
        this.castingSpell = bool;
    }


    private class YukiOnnaStrollGoal extends RandomStrollGoal {

        public YukiOnnaStrollGoal(PathfinderMob pMob, double pSpeedModifier) {
            super(pMob, pSpeedModifier);
        }

        @Nullable
        @Override
        protected Vec3 getPosition() {
            Vec3 vec3 = this.mob.getViewVector(0.0F);

            int i = 8;
            Vec3 vec31 = HoverRandomPos.getPos(this.mob, 12, 5, vec3.x, vec3.z, (float) (Math.PI / 2), 4, 0);
            return vec31 != null ? vec31 : AirAndWaterRandomPos.getPos(this.mob, 8, 4, -12, vec3.x, vec3.z, (float) (Math.PI / 2));
        }
    }

    protected class YukiOnnaSpell extends Goal {
        protected int freezeDist;
        protected int countToIncrease;
        private int lifetime;

        @Override
        public boolean canUse() {
            LivingEntity livingentity = YukiOnnaEntity.this.getTarget();
            if (livingentity == null || !livingentity.isAlive()) {
                return false;
            } else if (YukiOnnaEntity.this.isCastingSpell()) {
                return false;
            } else {
                return YukiOnnaEntity.this.castCooldown <= 0;
            }
        }


        @Override
        public boolean canContinueToUse() {
            LivingEntity livingentity = YukiOnnaEntity.this.getTarget();
            return livingentity != null && livingentity.isAlive() && this.lifetime < 80;
        }
        @Override
        public void start() {
            super.start();
            lifetime = 0;
            YukiOnnaEntity.this.setIsCastingSpell(true);
            this.freezeDist = 0;

        }

        @Override
        public void stop() {
            super.stop();
            YukiOnnaEntity.this.setIsCastingSpell(false);
            YukiOnnaEntity.this.castCooldown = 400;
        }

        @Override
        public void tick() {
            YukiOnnaEntity.this.playSound(SoundEvents.BREEZE_IDLE_AIR, 0.3F, 1.0F);
            lifetime++;
            LivingEntity target = YukiOnnaEntity.this.getTarget();

            for (int n = 0; n < 10; n++){
                float fraction = (float) n / 10;
                Vec3 vec3 = YukiOnnaEntity.this.position().add(0,YukiOnnaEntity.this.getEyeHeight(),0).lerp(target.position().add(0,target.getEyeHeight(),0),fraction);
                createParticles(YukiOnnaEntity.this.level(),vec3.x,vec3.y,vec3.z);
            }

            if (freezeDist < YukiOnnaEntity.this.distanceTo(target)){
                countToIncrease++;
                if (countToIncrease > 10){
                    freezeDist++;
                }
                target.setTicksFrozen(target.getTicksFrozen() + 5);
            }else {
                YukiOnnaEntity.this.playSound(SoundEvents.BREEZE_IDLE_AIR, 1.0F, 0.5F);
                this.performSpellCasting();
            }


            if (YukiOnnaEntity.this.getTarget() != null) {
                YukiOnnaEntity.this.getLookControl()
                        .setLookAt(
                                YukiOnnaEntity.this.getTarget(), (float)YukiOnnaEntity.this.getMaxHeadYRot(), (float)YukiOnnaEntity.this.getMaxHeadXRot()
                        );
            }
        }



        protected void performSpellCasting() {
            YukiOnnaEntity.this.getTarget().setTicksFrozen(100);

            LivingEntity target = YukiOnnaEntity.this.getTarget();
            target.addEffect(new MobEffectInstance(YoaEffects.FREEZING.get(),120));
            lifetime += 20;
        }

        private void createParticles(Level level,double pX, double pY, double pZ) {
            if (!level.isClientSide()){
                ((ServerLevel)level).sendParticles(ParticleTypes.SNOWFLAKE,pX,pY,pZ,0,0.0D,0.0D,0.0D,0.0D);
            }
        }


        protected int getCastWarmupTime() {
            return 20;
        }


    }
}
