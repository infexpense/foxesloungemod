package com.fuyuvulpes.yoamod.world.entity;

import com.fuyuvulpes.yoamod.core.registries.YoaEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowMobGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.ShoulderRidingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class Owl extends Animal {
    public Owl(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(1, new TemptGoal(this, 1.0f, Ingredient.of(Items.WHEAT_SEEDS), false));
        this.goalSelector.addGoal(3, new FollowMobGoal(this, 1.0, 3.0F, 7.0F));


        super.registerGoals();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return ShoulderRidingEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH,7)
                .add(Attributes.FLYING_SPEED, 0.4f)
                .add(Attributes.MOVEMENT_SPEED, 0.2f)
                .add(Attributes.FOLLOW_RANGE, 32f);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob ageableMob) {
        Owl owl = YoaEntityTypes.OWL_TYPE.get().create(pLevel);


        return owl;
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.WHEAT_SEEDS);
    }


    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return 0.3F;
    }

    public static boolean canSpawn(EntityType<Owl> entityType, ServerLevelAccessor level, MobSpawnType type, BlockPos pos, RandomSource randomSource){
        return Animal.checkAnimalSpawnRules(entityType,level,type,pos,randomSource);
    }

    @javax.annotation.Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @javax.annotation.Nullable SpawnGroupData pSpawnData, @javax.annotation.Nullable CompoundTag pDataTag) {
        return pSpawnData;
    }
}
