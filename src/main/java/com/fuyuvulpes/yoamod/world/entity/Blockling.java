package com.fuyuvulpes.yoamod.world.entity;

import com.fuyuvulpes.yoamod.core.registries.TagRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.neoforged.neoforge.common.NeoForgeMod;

import javax.annotation.Nullable;
import java.util.function.IntFunction;

public class Blockling extends PathfinderMob implements VariantHolder<Blockling.Type> {
    private static final EntityDataAccessor<Integer> DATA_BLOCK_ID = SynchedEntityData.defineId(Blockling.class, EntityDataSerializers.INT);

    public Blockling(EntityType<Blockling> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);

    }


    public void setVariant(Blockling.Type pVariant) {
        this.entityData.set(DATA_BLOCK_ID, pVariant.getId());
    }

    @Override
    public Type getVariant() {
        return Blockling.Type.byId(this.entityData.get(DATA_BLOCK_ID));
    }


    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_BLOCK_ID, 0);
    }



    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putString("Type", this.getVariant().getSerializedName());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setVariant(Blockling.Type.byName(pCompound.getString("Type")));
    }




    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 12.0)
                .add(NeoForgeMod.STEP_HEIGHT.value(),1.5F)
                .add(Attributes.MOVEMENT_SPEED, 0.5)
                .add(Attributes.FOLLOW_RANGE, 12.0F);
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(
            ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag
    ) {
        pSpawnData = super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
        BlockPos pos = this.blockPosition();
        Blockling.Type type = Blockling.Type.byPos(pos, pLevel.getLevel());
        this.setVariant(type);
        return pSpawnData;
    }



    public static boolean canSpawn(EntityType<Blockling> entityType, ServerLevelAccessor level, MobSpawnType type, BlockPos pos, RandomSource randomSource){
        return Mob.checkMobSpawnRules(entityType,level,type,pos,randomSource);
    }


    public static enum Type implements StringRepresentable {
        GRASS(0, "red"),
        COBBLESTONE(1, "cobblestone"),
        WOOD(2, "wood");

        public static final StringRepresentable.EnumCodec<Blockling.Type> CODEC = StringRepresentable.fromEnum(Blockling.Type::values);
        private static final IntFunction<Blockling.Type> BY_ID = ByIdMap.continuous(Blockling.Type::getId, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
        private final int id;
        private final String name;

        private Type(int pId, String pName) {
            this.id = pId;
            this.name = pName;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public int getId() {
            return this.id;
        }


        public static Blockling.Type byName(String pName) {
            return CODEC.byName(pName, GRASS);
        }

        public static Blockling.Type byId(int pIndex) {
            return BY_ID.apply(pIndex);
        }

        public static Blockling.Type byPos(BlockPos blockPos, Level level) {
            if (level.getBrightness(LightLayer.SKY,blockPos) > 8){
                if (level.getBiome(blockPos).is(TagRegistry.Biomes.BLOCKLING_WOOD)){
                    return WOOD;
                }
                if (level.getBiome(blockPos).is(TagRegistry.Biomes.BLOCKLING_GRASS)){
                    return GRASS;
                }
                if (level.getBiome(blockPos).is(TagRegistry.Biomes.BLOCKLING_COBBLESTONE)){
                    return COBBLESTONE;
                }
            }else if (level.getBrightness(LightLayer.SKY,blockPos) <= 8) {
                return COBBLESTONE;
            }

                return GRASS;
        }
    }


}