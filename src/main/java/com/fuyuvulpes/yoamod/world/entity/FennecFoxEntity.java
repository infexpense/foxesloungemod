package com.fuyuvulpes.yoamod.world.entity;

import com.fuyuvulpes.yoamod.core.registries.YoaEntityTypes;
import com.google.common.collect.Lists;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.event.entity.living.BabyEntitySpawnEvent;
import org.joml.Vector3f;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class FennecFoxEntity extends Animal {
    public final AnimationState pounce = new AnimationState();
    public final AnimationState jump = new AnimationState();
    public final AnimationState sleep = new AnimationState();
    private static final EntityDataAccessor<Integer> DATA_TYPE_ID;
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID;
    private static final int FLAG_SITTING = 1;
    public static final int FLAG_CROUCHING = 4;
    public static final int FLAG_INTERESTED = 8;
    public static final int FLAG_POUNCING = 16;
    private static final int FLAG_SLEEPING = 32;
    private static final int FLAG_FACEPLANTED = 64;
    private static final int FLAG_DEFENDING = 128;
    private static final EntityDataAccessor<Optional<UUID>> DATA_TRUSTED_ID_0;
    private static final EntityDataAccessor<Optional<UUID>> DATA_TRUSTED_ID_1;
    static final Predicate<ItemEntity> ALLOWED_ITEMS;
    private static final Predicate<Entity> TRUSTED_TARGET_SELECTOR;
    static final Predicate<Entity> STALKABLE_PREY;
    private static final Predicate<Entity> AVOID_PLAYERS;
    private static final int MIN_TICKS_BEFORE_EAT = 600;
    private Goal landTargetGoal;
    private Goal monsterTargetGoal;
    private Goal fishTargetGoal;
    private float interestedAngle;
    private float interestedAngleO;
    float crouchAmount;
    float crouchAmountO;
    private int ticksSinceEaten;

    public FennecFoxEntity(EntityType<? extends FennecFoxEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.lookControl = new FennecFoxEntity.FennecFoxLookControl();
        this.moveControl = new FennecFoxEntity.FennecFoxMoveControl();
        this.setPathfindingMalus(BlockPathTypes.DANGER_OTHER, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_OTHER, 0.0F);
        this.setCanPickUpLoot(true);
    }

    @Override
    public float getScale() {
        return this.isBaby() ? 0.8F : 1.0F;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_TRUSTED_ID_0, Optional.empty());
        this.entityData.define(DATA_TRUSTED_ID_1, Optional.empty());
        this.entityData.define(DATA_TYPE_ID, 0);
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }

    protected void registerGoals() {
        this.landTargetGoal = new NearestAttackableTargetGoal<>(this, Animal.class, 10, false, false, (p_28604_) -> {
            return p_28604_ instanceof Chicken || p_28604_ instanceof Rabbit || p_28604_ instanceof Spider || p_28604_ instanceof Silverfish;
        });
        this.monsterTargetGoal = new NearestAttackableTargetGoal<>(this, Monster.class, 10, false, false, (target) -> {
            return target instanceof Silverfish || target instanceof Spider;
        });
        this.fishTargetGoal = new NearestAttackableTargetGoal<>(this, AbstractFish.class, 20, false, false, (p_28600_) -> {
            return p_28600_ instanceof AbstractSchoolingFish;
        });

        this.goalSelector.addGoal(0, new FennecFoxEntity.FennecFoxFloatGoal());
        this.goalSelector.addGoal(0, new ClimbOnTopOfPowderSnowGoal(this, this.level()));
        this.goalSelector.addGoal(1, new FennecFoxEntity.FaceplantGoal());
        this.goalSelector.addGoal(1, new FennecFoxEntity.FennecFoxMeleeAttackGoal(1, true));
        this.goalSelector.addGoal(2, new FennecFoxEntity.FennecFoxPanicGoal(1.3F));
        this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.8F));

        this.goalSelector.addGoal(3, new FennecFoxEntity.FennecFoxBreedGoal(1.0));
        this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, Player.class, 16.0F, 1.6, 1.4, (p_308730_) -> {
            return AVOID_PLAYERS.test((Entity) p_308730_) && !this.trusts(((Entity) p_308730_).getUUID()) && !this.isDefending();
        }));
        this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, Wolf.class, 8.0F, 1.6, 1.4, (p_308731_) -> {
            return !((Wolf)p_308731_).isTame() && !this.isDefending();
        }));
        this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, PolarBear.class, 8.0F, 1.6, 1.4, (p_28585_) -> {
            return !this.isDefending();
        }));

        this.goalSelector.addGoal(5, new FennecFoxEntity.StalkPreyGoal());
        this.goalSelector.addGoal(6, new FennecFoxEntity.FennecFoxPounceGoal());
        this.goalSelector.addGoal(6, new FennecFoxEntity.SeekShelterGoal(1.25));
        this.goalSelector.addGoal(8, new FennecFoxEntity.FennecFoxFollowParentGoal(this, 1.25));
        this.goalSelector.addGoal(9, new FennecFoxEntity.FennecFoxStrollThroughVillageGoal(32, 200));
        this.goalSelector.addGoal(10, new FennecFoxEntity.FennecFoxEatBerriesGoal(1.2000000476837158, 12, 1));
        this.goalSelector.addGoal(11, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(11, new FennecFoxEntity.FennecFoxSearchForItemsGoal());
        this.goalSelector.addGoal(12, new FennecFoxEntity.FennecFoxLookAtPlayerGoal(this, Player.class, 24.0F));
        this.goalSelector.addGoal(12, new FennecFoxEntity.SleepGoal());
        this.goalSelector.addGoal(13, new FennecFoxEntity.PerchAndSearchGoal());

        this.targetSelector.addGoal(3, new FennecFoxEntity.DefendTrustedTargetGoal(LivingEntity.class, false, false, (p_308732_) -> {
            return TRUSTED_TARGET_SELECTOR.test(p_308732_) && !this.trusts(p_308732_.getUUID());
        }));
    }

    @Override
    public boolean addEffect(MobEffectInstance pEffectInstance, @org.jetbrains.annotations.Nullable Entity pEntity) {
        if (pEffectInstance.getEffect() == MobEffects.POISON){
            return false;
        }
        return super.addEffect(pEffectInstance, pEntity);
    }

    public SoundEvent getEatingSound(ItemStack pItemStack) {
        return SoundEvents.FOX_EAT;
    }

    public void aiStep() {
        if (!this.level().isClientSide && this.isAlive() && this.isEffectiveAi()) {
            ++this.ticksSinceEaten;
            ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
            if (this.canEat(itemstack)) {
                if (this.ticksSinceEaten > 600) {
                    ItemStack itemstack1 = itemstack.finishUsingItem(this.level(), this);
                    if (!itemstack1.isEmpty()) {
                        this.setItemSlot(EquipmentSlot.MAINHAND, itemstack1);
                    }

                    this.ticksSinceEaten = 0;
                } else if (this.ticksSinceEaten > 560 && this.random.nextFloat() < 0.1F) {
                    this.playSound(this.getEatingSound(itemstack), 1.0F, 1.0F);
                    this.level().broadcastEntityEvent(this, (byte)45);
                }
            }

            LivingEntity livingentity = this.getTarget();
            if (livingentity == null || !livingentity.isAlive()) {
                this.setIsCrouching(false);
                this.setIsInterested(false);
            }
        }

        if (this.isSleeping() || this.isImmobile()) {
            this.jumping = false;
            this.xxa = 0.0F;
            this.zza = 0.0F;
        }

        super.aiStep();
        if (this.isDefending() && this.random.nextFloat() < 0.05F) {
            this.playSound(SoundEvents.FOX_AGGRO, 1.0F, 1.0F);
        }

    }

    protected boolean isImmobile() {
        return this.isDeadOrDying();
    }

    private boolean canEat(ItemStack pStack) {
        return pStack.getItem().isEdible() && this.getTarget() == null && this.onGround() && !this.isSleeping();
    }

    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        if (pRandom.nextFloat() < 0.2F) {
            float f = pRandom.nextFloat();
            ItemStack itemstack;
            if (f < 0.05F) {
                itemstack = new ItemStack(Items.EMERALD);
            } else if (f < 0.2F) {
                itemstack = new ItemStack(Items.EGG);
            } else if (f < 0.4F) {
                itemstack = pRandom.nextBoolean() ? new ItemStack(Items.RABBIT_FOOT) : new ItemStack(Items.RABBIT_HIDE);
            } else if (f < 0.6F) {
                itemstack = new ItemStack(Items.WHEAT);
            } else if (f < 0.8F) {
                itemstack = new ItemStack(Items.LEATHER);
            } else {
                itemstack = new ItemStack(Items.FEATHER);
            }

            this.setItemSlot(EquipmentSlot.MAINHAND, itemstack);
        }

    }

    public void handleEntityEvent(byte pId) {
        if (pId == 45) {
            ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
            if (!itemstack.isEmpty()) {
                for(int i = 0; i < 8; ++i) {
                    Vec3 vec3 = (new Vec3(((double)this.random.nextFloat() - 0.5) * 0.1, Math.random() * 0.1 + 0.1, 0.0)).xRot(-this.getXRot() * 0.017453292F).yRot(-this.getYRot() * 0.017453292F);
                    this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, itemstack), this.getX() + this.getLookAngle().x / 2.0, this.getY(), this.getZ() + this.getLookAngle().z / 2.0, vec3.x, vec3.y + 0.05, vec3.z);
                }
            }
        } else {
            super.handleEntityEvent(pId);
        }

    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 16.0).add(Attributes.FOLLOW_RANGE, 32.0).add(Attributes.ATTACK_DAMAGE, 4.0);
    }

    @Nullable
    public FennecFoxEntity getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        FennecFoxEntity fennecFox = YoaEntityTypes.FENNEC_FOX_TYPE.get().create(pLevel);


        return fennecFox;
    }

    public static boolean canSpawn(EntityType<FennecFoxEntity> pFox, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        return Animal.checkAnimalSpawnRules(pFox,pLevel,pSpawnType,pPos,pRandom);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        boolean flag = false;
        if (pSpawnData instanceof FennecFoxEntity.FennecFoxGroupData fox$foxgroupdata) {
            if (fox$foxgroupdata.getGroupSize() >= 2) {
                flag = true;
            }
        } else {
            pSpawnData = new FennecFoxEntity.FennecFoxGroupData();
        }

        if (flag) {
            this.setAge(-24000);
        }

        if (pLevel instanceof ServerLevel) {
            this.setTargetGoals();
        }

        this.populateDefaultEquipmentSlots(pLevel.getRandom(), pDifficulty);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, (SpawnGroupData)pSpawnData, pDataTag);
    }

    private void setTargetGoals() {

            this.targetSelector.addGoal(1, this.landTargetGoal);
            this.targetSelector.addGoal(4, this.monsterTargetGoal);
            this.targetSelector.addGoal(2, this.fishTargetGoal);
        }

    protected void usePlayerItem(Player pPlayer, InteractionHand pHand, ItemStack pStack) {
        if (this.isFood(pStack)) {
            this.playSound(this.getEatingSound(pStack), 1.0F, 1.0F);
        }

        super.usePlayerItem(pPlayer, pHand, pStack);
    }


    List<UUID> getTrustedUUIDs() {
        List<UUID> list = Lists.newArrayList();
        list.add((UUID)((Optional)this.entityData.get(DATA_TRUSTED_ID_0)).orElse((Object)null));
        list.add((UUID)((Optional)this.entityData.get(DATA_TRUSTED_ID_1)).orElse((Object)null));
        return list;
    }

    void addTrustedUUID(@Nullable UUID pUuid) {
        if (((Optional)this.entityData.get(DATA_TRUSTED_ID_0)).isPresent()) {
            this.entityData.set(DATA_TRUSTED_ID_1, Optional.ofNullable(pUuid));
        } else {
            this.entityData.set(DATA_TRUSTED_ID_0, Optional.ofNullable(pUuid));
        }

    }

    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        List<UUID> list = this.getTrustedUUIDs();
        ListTag listtag = new ListTag();
        Iterator var4 = list.iterator();

        while(var4.hasNext()) {
            UUID uuid = (UUID)var4.next();
            if (uuid != null) {
                listtag.add(NbtUtils.createUUID(uuid));
            }
        }

        pCompound.put("Trusted", listtag);
        pCompound.putBoolean("Sleeping", this.isSleeping());
        pCompound.putBoolean("Sitting", this.isSitting());
        pCompound.putBoolean("Crouching", this.isCrouching());
    }

    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        Iterator var2 = pCompound.getList("Trusted", 11).iterator();

        while(var2.hasNext()) {
            Tag tag = (Tag)var2.next();
            this.addTrustedUUID(NbtUtils.loadUUID(tag));
        }

        this.setSleeping(pCompound.getBoolean("Sleeping"));
        this.setSitting(pCompound.getBoolean("Sitting"));
        this.setIsCrouching(pCompound.getBoolean("Crouching"));
        if (this.level() instanceof ServerLevel) {
            this.setTargetGoals();
        }

    }

    public boolean isSitting() {
        return this.getFlag(1);
    }

    public void setSitting(boolean pSitting) {
        this.setFlag(1, pSitting);
    }

    public boolean isFaceplanted() {
        return this.getFlag(64);
    }

    void setFaceplanted(boolean pFaceplanted) {
        this.setFlag(64, pFaceplanted);
    }

    boolean isDefending() {
        return this.getFlag(128);
    }

    void setDefending(boolean pDefending) {
        this.setFlag(128, pDefending);
    }

    public boolean isSleeping() {
        return this.getFlag(32);
    }

    void setSleeping(boolean pSleeping) {
        this.setFlag(32, pSleeping);
    }

    private void setFlag(int pFlagId, boolean pValue) {
        if (pValue) {
            this.entityData.set(DATA_FLAGS_ID, (byte)((Byte)this.entityData.get(DATA_FLAGS_ID) | pFlagId));
        } else {
            this.entityData.set(DATA_FLAGS_ID, (byte)((Byte)this.entityData.get(DATA_FLAGS_ID) & ~pFlagId));
        }

    }

    private boolean getFlag(int pFlagId) {
        return ((Byte)this.entityData.get(DATA_FLAGS_ID) & pFlagId) != 0;
    }

    public boolean canTakeItem(ItemStack pItemstack) {
        EquipmentSlot equipmentslot = Mob.getEquipmentSlotForItem(pItemstack);
        if (!this.getItemBySlot(equipmentslot).isEmpty()) {
            return false;
        } else {
            return equipmentslot == EquipmentSlot.MAINHAND && super.canTakeItem(pItemstack);
        }
    }

    public boolean canHoldItem(ItemStack pStack) {
        Item item = pStack.getItem();
        ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
        return itemstack.isEmpty() || this.ticksSinceEaten > 0 && item.isEdible() && !itemstack.getItem().isEdible();
    }

    private void spitOutItem(ItemStack pStack) {
        if (!pStack.isEmpty() && !this.level().isClientSide) {
            ItemEntity itementity = new ItemEntity(this.level(), this.getX() + this.getLookAngle().x, this.getY() + 1.0, this.getZ() + this.getLookAngle().z, pStack);
            itementity.setPickUpDelay(40);
            itementity.setThrower(this);
            this.playSound(SoundEvents.FOX_SPIT, 1.0F, 1.0F);
            this.level().addFreshEntity(itementity);
        }

    }

    private void dropItemStack(ItemStack pStack) {
        ItemEntity itementity = new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), pStack);
        this.level().addFreshEntity(itementity);
    }

    protected void pickUpItem(ItemEntity pItemEntity) {
        ItemStack itemstack = pItemEntity.getItem();
        if (this.canHoldItem(itemstack)) {
            int i = itemstack.getCount();
            if (i > 1) {
                this.dropItemStack(itemstack.split(i - 1));
            }

            this.spitOutItem(this.getItemBySlot(EquipmentSlot.MAINHAND));
            this.onItemPickup(pItemEntity);
            this.setItemSlot(EquipmentSlot.MAINHAND, itemstack.split(1));
            this.setGuaranteedDrop(EquipmentSlot.MAINHAND);
            this.take(pItemEntity, itemstack.getCount());
            pItemEntity.discard();
            this.ticksSinceEaten = 0;
        }

    }

    public void tick() {
        if (level().isClientSide()){
            this.sleep.animateWhen(this.isSleeping(),this.tickCount);
            this.jump.animateWhen(this.isJumping(), this.tickCount);
            this.pounce.animateWhen(this.isPouncing(), this.tickCount);
        }
        super.tick();
        if (this.isEffectiveAi()) {
            boolean flag = this.isInWater();
            if (flag || this.getTarget() != null || this.level().isThundering()) {
                this.wakeUp();
            }

            if (flag || this.isSleeping()) {
                this.setSitting(false);
            }

            if (this.isFaceplanted() && this.level().random.nextFloat() < 0.2F) {
                BlockPos blockpos = this.blockPosition();
                BlockState blockstate = this.level().getBlockState(blockpos);
                this.level().levelEvent(2001, blockpos, Block.getId(blockstate));
            }
        }

        this.interestedAngleO = this.interestedAngle;
        if (this.isInterested()) {
            this.interestedAngle += (1.0F - this.interestedAngle) * 0.4F;
        } else {
            this.interestedAngle += (0.0F - this.interestedAngle) * 0.4F;
        }

        this.crouchAmountO = this.crouchAmount;
        if (this.isCrouching()) {
            this.crouchAmount += 0.2F;
            if (this.crouchAmount > 3.0F) {
                this.crouchAmount = 3.0F;
            }
        } else {
            this.crouchAmount = 0.0F;
        }

    }

    public boolean isFood(ItemStack pStack) {
        return pStack.is(ItemTags.FOX_FOOD);
    }

    protected void onOffspringSpawnedFromEgg(Player pPlayer, Mob pChild) {
        ((FennecFoxEntity)pChild).addTrustedUUID(pPlayer.getUUID());
    }

    public boolean isPouncing() {
        return this.getFlag(16);
    }

    public void setIsPouncing(boolean pIsPouncing) {
        this.setFlag(16, pIsPouncing);
    }

    public boolean isJumping() {
        return this.jumping;
    }

    public boolean isFullyCrouched() {
        return this.crouchAmount == 3.0F;
    }

    public void setIsCrouching(boolean pIsCrouching) {
        this.setFlag(4, pIsCrouching);
    }

    public boolean isCrouching() {
        return this.getFlag(4);
    }

    public void setIsInterested(boolean pIsInterested) {
        this.setFlag(8, pIsInterested);
    }

    public boolean isInterested() {
        return this.getFlag(8);
    }

    public float getHeadRollAngle(float pPartialTick) {
        return Mth.lerp(pPartialTick, this.interestedAngleO, this.interestedAngle) * 0.11F * 3.1415927F;
    }

    public float getCrouchAmount(float pPartialTick) {
        return Mth.lerp(pPartialTick, this.crouchAmountO, this.crouchAmount);
    }

    public void setTarget(@Nullable LivingEntity pLivingEntity) {
        if (this.isDefending() && pLivingEntity == null) {
            this.setDefending(false);
        }

        super.setTarget(pLivingEntity);
    }

    protected int calculateFallDamage(float pDistance, float pDamageMultiplier) {
        return Mth.ceil((pDistance - 5.0F) * pDamageMultiplier);
    }

    void wakeUp() {
        this.setSleeping(false);
    }

    void clearStates() {
        this.setIsInterested(false);
        this.setIsCrouching(false);
        this.setSitting(false);
        this.setSleeping(false);
        this.setDefending(false);
        this.setFaceplanted(false);
    }

    boolean canMove() {
        return !this.isSleeping() && !this.isSitting() && !this.isFaceplanted();
    }

    public void playAmbientSound() {
        SoundEvent soundevent = this.getAmbientSound();
        if (soundevent == SoundEvents.FOX_SCREECH) {
            this.playSound(soundevent, 2.0F, this.getVoicePitch());
        } else {
            super.playAmbientSound();
        }

    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        if (this.isSleeping()) {
            return SoundEvents.FOX_SLEEP;
        } else {
            if (!this.level().isDay() && this.random.nextFloat() < 0.1F) {
                List<Player> list = this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(16.0, 16.0, 16.0), EntitySelector.NO_SPECTATORS);
                if (list.isEmpty()) {
                    return SoundEvents.FOX_SCREECH;
                }
            }

            return SoundEvents.FOX_AMBIENT;
        }
    }

    @Nullable
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.FOX_HURT;
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.FOX_DEATH;
    }

    boolean trusts(UUID pUuid) {
        return this.getTrustedUUIDs().contains(pUuid);
    }

    protected void dropAllDeathLoot(DamageSource pDamageSource) {
        super.dropAllDeathLoot(pDamageSource);
    }

    protected void dropEquipment() {
        super.dropEquipment();
        ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
        if (!itemstack.isEmpty()) {
            this.spawnAtLocation(itemstack);
            this.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
        }

    }

    protected Vector3f getPassengerAttachmentPoint(Entity pEntity, EntityDimensions pDimensions, float pScale) {
        return new Vector3f(0.0F, pDimensions.height + -0.0625F * pScale, -0.25F * pScale);
    }

    public static boolean isPathClear(FennecFoxEntity pFox, LivingEntity pLivingEntity) {
        double d0 = pLivingEntity.getZ() - pFox.getZ();
        double d1 = pLivingEntity.getX() - pFox.getX();
        double d2 = d0 / d1;
        boolean i = true;

        for(int j = 0; j < 6; ++j) {
            double d3 = d2 == 0.0 ? 0.0 : d0 * (double)((float)j / 6.0F);
            double d4 = d2 == 0.0 ? d1 * (double)((float)j / 6.0F) : d3 / d2;

            for(int k = 1; k < 4; ++k) {
                if (!pFox.level().getBlockState(BlockPos.containing(pFox.getX() + d4, pFox.getY() + (double)k, pFox.getZ() + d3)).canBeReplaced()) {
                    return false;
                }
            }
        }

        return true;
    }

    public Vec3 getLeashOffset() {
        return new Vec3(0.0, (double)(0.55F * this.getEyeHeight()), (double)(this.getBbWidth() * 0.4F));
    }

    static {
        DATA_TYPE_ID = SynchedEntityData.defineId(FennecFoxEntity.class, EntityDataSerializers.INT);
        DATA_FLAGS_ID = SynchedEntityData.defineId(FennecFoxEntity.class, EntityDataSerializers.BYTE);
        DATA_TRUSTED_ID_0 = SynchedEntityData.defineId(FennecFoxEntity.class, EntityDataSerializers.OPTIONAL_UUID);
        DATA_TRUSTED_ID_1 = SynchedEntityData.defineId(FennecFoxEntity.class, EntityDataSerializers.OPTIONAL_UUID);
        ALLOWED_ITEMS = (p_308733_) -> {
            return !p_308733_.hasPickUpDelay() && p_308733_.isAlive();
        };
        TRUSTED_TARGET_SELECTOR = (p_287481_) -> {
            if (!(p_287481_ instanceof LivingEntity livingentity)) {
                return false;
            } else {
                return livingentity.getLastHurtMob() != null && livingentity.getLastHurtMobTimestamp() < livingentity.tickCount + 600;
            }
        };
        STALKABLE_PREY = (p_28498_) -> {
            return p_28498_ instanceof Chicken || p_28498_ instanceof Rabbit || p_28498_ instanceof Silverfish || p_28498_ instanceof Spider;
        };
        AVOID_PLAYERS = (p_28463_) -> {
            return !p_28463_.isDiscrete() && EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(p_28463_);
        };
    }

    public class FennecFoxLookControl extends LookControl {
        public FennecFoxLookControl() {
            super(FennecFoxEntity.this);
        }

        public void tick() {
            if (!FennecFoxEntity.this.isSleeping()) {
                super.tick();
            }

        }

        protected boolean resetXRotOnTick() {
            return !FennecFoxEntity.this.isPouncing() && !FennecFoxEntity.this.isCrouching() && !FennecFoxEntity.this.isInterested() && !FennecFoxEntity.this.isFaceplanted();
        }
    }

    class FennecFoxMoveControl extends MoveControl {
        public FennecFoxMoveControl() {
            super(FennecFoxEntity.this);
        }

        public void tick() {
            if (FennecFoxEntity.this.canMove()) {
                super.tick();
            }

        }
    }

    class FennecFoxFloatGoal extends FloatGoal {
        public FennecFoxFloatGoal() {
            super(FennecFoxEntity.this);
        }

        public void start() {
            super.start();
            FennecFoxEntity.this.clearStates();
        }

        public boolean canUse() {
            return FennecFoxEntity.this.isInWater() && FennecFoxEntity.this.getFluidHeight(FluidTags.WATER) > 0.25 || FennecFoxEntity.this.isInLava() || FennecFoxEntity.this.isInFluidType((fluidType, height) -> {
                return FennecFoxEntity.this.canSwimInFluidType(fluidType) && height > 0.25;
            });
        }
    }

    class FaceplantGoal extends Goal {
        int countdown;

        public FaceplantGoal() {
            this.setFlags(EnumSet.of(Flag.LOOK, Flag.JUMP, Flag.MOVE));
        }

        public boolean canUse() {
            return FennecFoxEntity.this.isFaceplanted();
        }

        public boolean canContinueToUse() {
            return this.canUse() && this.countdown > 0;
        }

        public void start() {
            this.countdown = this.adjustedTickDelay(40);
        }

        public void stop() {
            FennecFoxEntity.this.setFaceplanted(false);
        }

        public void tick() {
            --this.countdown;
        }
    }

    class FennecFoxPanicGoal extends PanicGoal {
        public FennecFoxPanicGoal(double pSpeedModifier) {
            super(FennecFoxEntity.this, pSpeedModifier);
        }

        public boolean shouldPanic() {
            return !FennecFoxEntity.this.isDefending() && super.shouldPanic();
        }
    }

    class FennecFoxBreedGoal extends BreedGoal {
        public FennecFoxBreedGoal(double pSpeedModifier) {
            super(FennecFoxEntity.this, pSpeedModifier);
        }

        public void start() {
            ((FennecFoxEntity)this.animal).clearStates();
            ((FennecFoxEntity)this.partner).clearStates();
            super.start();
        }

        protected void breed() {
            ServerLevel serverlevel = (ServerLevel)this.level;
            FennecFoxEntity fox = (FennecFoxEntity)this.animal.getBreedOffspring(serverlevel, this.partner);
            BabyEntitySpawnEvent event = new BabyEntitySpawnEvent(this.animal, this.partner, fox);
            boolean cancelled = ((BabyEntitySpawnEvent) NeoForge.EVENT_BUS.post(event)).isCanceled();
            fox = (FennecFoxEntity)event.getChild();
            if (cancelled) {
                this.animal.setAge(6000);
                this.partner.setAge(6000);
                this.animal.resetLove();
                this.partner.resetLove();
            } else {
                if (fox != null) {
                    ServerPlayer serverplayer = this.animal.getLoveCause();
                    ServerPlayer serverplayer1 = this.partner.getLoveCause();
                    ServerPlayer serverplayer2 = serverplayer;
                    if (serverplayer != null) {
                        fox.addTrustedUUID(serverplayer.getUUID());
                    } else {
                        serverplayer2 = serverplayer1;
                    }

                    if (serverplayer1 != null && serverplayer != serverplayer1) {
                        fox.addTrustedUUID(serverplayer1.getUUID());
                    }

                    if (serverplayer2 != null) {
                        serverplayer2.awardStat(Stats.ANIMALS_BRED);
                        CriteriaTriggers.BRED_ANIMALS.trigger(serverplayer2, this.animal, this.partner, fox);
                    }

                    this.animal.setAge(6000);
                    this.partner.setAge(6000);
                    this.animal.resetLove();
                    this.partner.resetLove();
                    fox.setAge(-24000);
                    fox.moveTo(this.animal.getX(), this.animal.getY(), this.animal.getZ(), 0.0F, 0.0F);
                    serverlevel.addFreshEntityWithPassengers(fox);
                    this.level.broadcastEntityEvent(this.animal, (byte)18);
                    if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
                        this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), this.animal.getRandom().nextInt(7) + 1));
                    }
                }

            }
        }
    }

    class StalkPreyGoal extends Goal {
        public StalkPreyGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            if (FennecFoxEntity.this.isSleeping()) {
                return false;
            } else {
                LivingEntity livingentity = FennecFoxEntity.this.getTarget();
                return livingentity != null && livingentity.isAlive() && FennecFoxEntity.STALKABLE_PREY.test(livingentity) && FennecFoxEntity.this.distanceToSqr(livingentity) > 36.0 && !FennecFoxEntity.this.isCrouching() && !FennecFoxEntity.this.isInterested() && !FennecFoxEntity.this.jumping;
            }
        }

        public void start() {
            FennecFoxEntity.this.setSitting(false);
            FennecFoxEntity.this.setFaceplanted(false);
        }

        public void stop() {
            LivingEntity livingentity = FennecFoxEntity.this.getTarget();
            if (livingentity != null && FennecFoxEntity.isPathClear(FennecFoxEntity.this, livingentity)) {
                FennecFoxEntity.this.setIsInterested(true);
                FennecFoxEntity.this.setIsCrouching(true);
                FennecFoxEntity.this.getNavigation().stop();
                FennecFoxEntity.this.getLookControl().setLookAt(livingentity, (float) FennecFoxEntity.this.getMaxHeadYRot(), (float) FennecFoxEntity.this.getMaxHeadXRot());
            } else {
                FennecFoxEntity.this.setIsInterested(false);
                FennecFoxEntity.this.setIsCrouching(false);
            }

        }

        public void tick() {
            LivingEntity livingentity = FennecFoxEntity.this.getTarget();
            if (livingentity != null) {
                FennecFoxEntity.this.getLookControl().setLookAt(livingentity, (float) FennecFoxEntity.this.getMaxHeadYRot(), (float) FennecFoxEntity.this.getMaxHeadXRot());
                if (FennecFoxEntity.this.distanceToSqr(livingentity) <= 36.0) {
                    FennecFoxEntity.this.setIsInterested(true);
                    FennecFoxEntity.this.setIsCrouching(true);
                    FennecFoxEntity.this.getNavigation().stop();
                } else {
                    FennecFoxEntity.this.getNavigation().moveTo(livingentity, 1.5);
                }
            }

        }
    }

    public class FennecFoxPounceGoal extends JumpGoal {
        public FennecFoxPounceGoal() {
        }

        public boolean canUse() {
            if (!FennecFoxEntity.this.isFullyCrouched()) {
                return false;
            } else {
                LivingEntity livingentity = FennecFoxEntity.this.getTarget();
                if (livingentity != null && livingentity.isAlive()) {
                    if (livingentity.getMotionDirection() != livingentity.getDirection()) {
                        return false;
                    } else {
                        boolean flag = FennecFoxEntity.isPathClear(FennecFoxEntity.this, livingentity);
                        if (!flag) {
                            FennecFoxEntity.this.getNavigation().createPath(livingentity, 0);
                            FennecFoxEntity.this.setIsCrouching(false);
                            FennecFoxEntity.this.setIsInterested(false);
                        }

                        return flag;
                    }
                } else {
                    return false;
                }
            }
        }

        public boolean canContinueToUse() {
            LivingEntity livingentity = FennecFoxEntity.this.getTarget();
            if (livingentity != null && livingentity.isAlive()) {
                double d0 = FennecFoxEntity.this.getDeltaMovement().y;
                return (!(d0 * d0 < 0.05000000074505806) || !(Math.abs(FennecFoxEntity.this.getXRot()) < 15.0F) || !FennecFoxEntity.this.onGround()) && !FennecFoxEntity.this.isFaceplanted();
            } else {
                return false;
            }
        }

        public boolean isInterruptable() {
            return false;
        }

        public void start() {
            FennecFoxEntity.this.setJumping(true);
            FennecFoxEntity.this.setIsPouncing(true);
            FennecFoxEntity.this.setIsInterested(false);
            LivingEntity livingentity = FennecFoxEntity.this.getTarget();
            if (livingentity != null) {
                FennecFoxEntity.this.getLookControl().setLookAt(livingentity, 60.0F, 30.0F);
                Vec3 vec3 = (new Vec3(livingentity.getX() - FennecFoxEntity.this.getX(), livingentity.getY() - FennecFoxEntity.this.getY(), livingentity.getZ() - FennecFoxEntity.this.getZ())).normalize();
                FennecFoxEntity.this.setDeltaMovement(FennecFoxEntity.this.getDeltaMovement().add(vec3.x * 0.9, 0.9, vec3.z * 0.9));
            }

            FennecFoxEntity.this.getNavigation().stop();
        }

        public void stop() {
            FennecFoxEntity.this.setIsCrouching(false);
            FennecFoxEntity.this.crouchAmount = 0.0F;
            FennecFoxEntity.this.crouchAmountO = 0.0F;
            FennecFoxEntity.this.setIsInterested(false);
            FennecFoxEntity.this.setIsPouncing(false);
        }

        public void tick() {
            LivingEntity livingentity = FennecFoxEntity.this.getTarget();
            if (livingentity != null) {
                FennecFoxEntity.this.getLookControl().setLookAt(livingentity, 60.0F, 30.0F);
            }

            if (!FennecFoxEntity.this.isFaceplanted()) {
                Vec3 vec3 = FennecFoxEntity.this.getDeltaMovement();
                if (vec3.y * vec3.y < 0.029999999329447746 && FennecFoxEntity.this.getXRot() != 0.0F) {
                    FennecFoxEntity.this.setXRot(Mth.rotLerp(0.2F, FennecFoxEntity.this.getXRot(), 0.0F));
                } else {
                    double d0 = vec3.horizontalDistance();
                    double d1 = Math.signum(-vec3.y) * Math.acos(d0 / vec3.length()) * 180.0 / 3.1415927410125732;
                    FennecFoxEntity.this.setXRot((float)d1);
                }
            }

            if (livingentity != null && FennecFoxEntity.this.distanceTo(livingentity) <= 2.0F) {
                FennecFoxEntity.this.doHurtTarget(livingentity);
            } else if (FennecFoxEntity.this.getXRot() > 0.0F && FennecFoxEntity.this.onGround() && (float) FennecFoxEntity.this.getDeltaMovement().y != 0.0F && FennecFoxEntity.this.level().getBlockState(FennecFoxEntity.this.blockPosition()).is(Blocks.SNOW)) {
                FennecFoxEntity.this.setXRot(60.0F);
                FennecFoxEntity.this.setTarget((LivingEntity)null);
                FennecFoxEntity.this.setFaceplanted(true);
            }

        }
    }

    class SeekShelterGoal extends FleeSunGoal {
        private int interval = reducedTickDelay(100);

        public SeekShelterGoal(double pSpeedModifier) {
            super(FennecFoxEntity.this, pSpeedModifier);
        }

        public boolean canUse() {
            if (!FennecFoxEntity.this.isSleeping() && this.mob.getTarget() == null) {
                if (FennecFoxEntity.this.level().isThundering() && FennecFoxEntity.this.level().canSeeSky(this.mob.blockPosition())) {
                    return this.setWantedPos();
                } else if (this.interval > 0) {
                    --this.interval;
                    return false;
                } else {
                    this.interval = 100;
                    BlockPos blockpos = this.mob.blockPosition();
                    return FennecFoxEntity.this.level().isDay() && FennecFoxEntity.this.level().canSeeSky(blockpos) && !((ServerLevel) FennecFoxEntity.this.level()).isVillage(blockpos) && this.setWantedPos();
                }
            } else {
                return false;
            }
        }

        public void start() {
            FennecFoxEntity.this.clearStates();
            super.start();
        }
    }

    class FennecFoxMeleeAttackGoal extends MeleeAttackGoal {
        public FennecFoxMeleeAttackGoal(double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
            super(FennecFoxEntity.this, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        }

        protected void checkAndPerformAttack(LivingEntity pTarget) {
            if (this.canPerformAttack(pTarget)) {
                this.resetAttackCooldown();
                this.mob.doHurtTarget(pTarget);
                FennecFoxEntity.this.playSound(SoundEvents.FOX_BITE, 1.0F, 1.0F);
            }

        }

        public void start() {
            FennecFoxEntity.this.setIsInterested(false);
            super.start();
        }

        public boolean canUse() {
            return !FennecFoxEntity.this.isSitting() && !FennecFoxEntity.this.isSleeping() && FennecFoxEntity.this.isCrouching() && !FennecFoxEntity.this.isFaceplanted() && super.canUse();
        }
    }

    class SleepGoal extends FennecFoxEntity.FennecFoxBehaviorGoal {
        private static final int WAIT_TIME_BEFORE_SLEEP = reducedTickDelay(140);
        private int countdown;

        public SleepGoal() {
            super();
            this.countdown = FennecFoxEntity.this.random.nextInt(WAIT_TIME_BEFORE_SLEEP);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public boolean canUse() {
            if (FennecFoxEntity.this.xxa == 0.0F && FennecFoxEntity.this.yya == 0.0F && FennecFoxEntity.this.zza == 0.0F) {
                return this.canSleep() || FennecFoxEntity.this.isSleeping();
            } else {
                return false;
            }
        }

        public boolean canContinueToUse() {
            return this.canSleep();
        }

        private boolean canSleep() {
            if (this.countdown > 0) {
                --this.countdown;
                return false;
            } else {
                return FennecFoxEntity.this.level().isDay() && this.hasShelter() && !this.alertable() && !FennecFoxEntity.this.isInPowderSnow;
            }
        }

        public void stop() {
            this.countdown = FennecFoxEntity.this.random.nextInt(WAIT_TIME_BEFORE_SLEEP);
            FennecFoxEntity.this.clearStates();
        }

        public void start() {
            FennecFoxEntity.this.setSitting(false);
            FennecFoxEntity.this.setIsCrouching(false);
            FennecFoxEntity.this.setIsInterested(false);
            FennecFoxEntity.this.setJumping(false);
            FennecFoxEntity.this.setSleeping(true);
            FennecFoxEntity.this.getNavigation().stop();
            FennecFoxEntity.this.getMoveControl().setWantedPosition(FennecFoxEntity.this.getX(), FennecFoxEntity.this.getY(), FennecFoxEntity.this.getZ(), 0.0);
        }
    }

    class FennecFoxFollowParentGoal extends FollowParentGoal {
        private final FennecFoxEntity fox;

        public FennecFoxFollowParentGoal(FennecFoxEntity pFox, double pSpeedModifier) {
            super(pFox, pSpeedModifier);
            this.fox = pFox;
        }

        public boolean canUse() {
            return !this.fox.isDefending() && super.canUse();
        }

        public boolean canContinueToUse() {
            return !this.fox.isDefending() && super.canContinueToUse();
        }

        public void start() {
            this.fox.clearStates();
            super.start();
        }
    }

    class FennecFoxStrollThroughVillageGoal extends StrollThroughVillageGoal {
        public FennecFoxStrollThroughVillageGoal(int pUnused32, int pInterval) {
            super(FennecFoxEntity.this, pInterval);
        }

        public void start() {
            FennecFoxEntity.this.clearStates();
            super.start();
        }

        public boolean canUse() {
            return super.canUse() && this.canFennecFoxMove();
        }

        public boolean canContinueToUse() {
            return super.canContinueToUse() && this.canFennecFoxMove();
        }

        private boolean canFennecFoxMove() {
            return !FennecFoxEntity.this.isSleeping() && !FennecFoxEntity.this.isSitting() && !FennecFoxEntity.this.isDefending() && FennecFoxEntity.this.getTarget() == null;
        }
    }

    public class FennecFoxEatBerriesGoal extends MoveToBlockGoal {
        private static final int WAIT_TICKS = 40;
        protected int ticksWaited;

        public FennecFoxEatBerriesGoal(double pSpeedModifier, int pSearchRange, int pVerticalSearchRange) {
            super(FennecFoxEntity.this, pSpeedModifier, pSearchRange, pVerticalSearchRange);
        }

        public double acceptedDistance() {
            return 2.0;
        }

        public boolean shouldRecalculatePath() {
            return this.tryTicks % 100 == 0;
        }

        protected boolean isValidTarget(LevelReader pLevel, BlockPos pPos) {
            BlockState blockstate = pLevel.getBlockState(pPos);
            return blockstate.is(Blocks.SWEET_BERRY_BUSH) && (Integer)blockstate.getValue(SweetBerryBushBlock.AGE) >= 2 || CaveVines.hasGlowBerries(blockstate);
        }

        public void tick() {
            if (this.isReachedTarget()) {
                if (this.ticksWaited >= 40) {
                    this.onReachedTarget();
                } else {
                    ++this.ticksWaited;
                }
            } else if (!this.isReachedTarget() && FennecFoxEntity.this.random.nextFloat() < 0.05F) {
                FennecFoxEntity.this.playSound(SoundEvents.FOX_SNIFF, 1.0F, 1.0F);
            }

            super.tick();
        }

        protected void onReachedTarget() {
            if (EventHooks.getMobGriefingEvent(FennecFoxEntity.this.level(), FennecFoxEntity.this)) {
                BlockState blockstate = FennecFoxEntity.this.level().getBlockState(this.blockPos);
                if (blockstate.is(Blocks.SWEET_BERRY_BUSH)) {
                    this.pickSweetBerries(blockstate);
                } else if (CaveVines.hasGlowBerries(blockstate)) {
                    this.pickGlowBerry(blockstate);
                }
            }

        }

        private void pickGlowBerry(BlockState pState) {
            CaveVines.use(FennecFoxEntity.this, pState, FennecFoxEntity.this.level(), this.blockPos);
        }

        private void pickSweetBerries(BlockState pState) {
            int i = (Integer)pState.getValue(SweetBerryBushBlock.AGE);
            pState.setValue(SweetBerryBushBlock.AGE, 1);
            int j = 1 + FennecFoxEntity.this.level().random.nextInt(2) + (i == 3 ? 1 : 0);
            ItemStack itemstack = FennecFoxEntity.this.getItemBySlot(EquipmentSlot.MAINHAND);
            if (itemstack.isEmpty()) {
                FennecFoxEntity.this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.SWEET_BERRIES));
                --j;
            }

            if (j > 0) {
                Block.popResource(FennecFoxEntity.this.level(), this.blockPos, new ItemStack(Items.SWEET_BERRIES, j));
            }

            FennecFoxEntity.this.playSound(SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, 1.0F, 1.0F);
            FennecFoxEntity.this.level().setBlock(this.blockPos, (BlockState)pState.setValue(SweetBerryBushBlock.AGE, 1), 2);
            FennecFoxEntity.this.level().gameEvent(GameEvent.BLOCK_CHANGE, this.blockPos, GameEvent.Context.of(FennecFoxEntity.this));
        }

        public boolean canUse() {
            return !FennecFoxEntity.this.isSleeping() && super.canUse();
        }

        public void start() {
            this.ticksWaited = 0;
            FennecFoxEntity.this.setSitting(false);
            super.start();
        }
    }

    class FennecFoxSearchForItemsGoal extends Goal {
        public FennecFoxSearchForItemsGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            if (!FennecFoxEntity.this.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty()) {
                return false;
            } else if (FennecFoxEntity.this.getTarget() == null && FennecFoxEntity.this.getLastHurtByMob() == null) {
                if (!FennecFoxEntity.this.canMove()) {
                    return false;
                } else if (FennecFoxEntity.this.getRandom().nextInt(reducedTickDelay(10)) != 0) {
                    return false;
                } else {
                    List<ItemEntity> list = FennecFoxEntity.this.level().getEntitiesOfClass(ItemEntity.class, FennecFoxEntity.this.getBoundingBox().inflate(8.0, 8.0, 8.0), FennecFoxEntity.ALLOWED_ITEMS);
                    return !list.isEmpty() && FennecFoxEntity.this.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty();
                }
            } else {
                return false;
            }
        }

        public void tick() {
            List<ItemEntity> list = FennecFoxEntity.this.level().getEntitiesOfClass(ItemEntity.class, FennecFoxEntity.this.getBoundingBox().inflate(8.0, 8.0, 8.0), FennecFoxEntity.ALLOWED_ITEMS);
            ItemStack itemstack = FennecFoxEntity.this.getItemBySlot(EquipmentSlot.MAINHAND);
            if (itemstack.isEmpty() && !list.isEmpty()) {
                FennecFoxEntity.this.getNavigation().moveTo((Entity)list.get(0), 1.2000000476837158);
            }

        }

        public void start() {
            List<ItemEntity> list = FennecFoxEntity.this.level().getEntitiesOfClass(ItemEntity.class, FennecFoxEntity.this.getBoundingBox().inflate(8.0, 8.0, 8.0), FennecFoxEntity.ALLOWED_ITEMS);
            if (!list.isEmpty()) {
                FennecFoxEntity.this.getNavigation().moveTo((Entity)list.get(0), 1.2000000476837158);
            }

        }
    }

    class FennecFoxLookAtPlayerGoal extends LookAtPlayerGoal {
        public FennecFoxLookAtPlayerGoal(Mob pMob, Class<? extends LivingEntity> pLookAtType, float pLookDistance) {
            super(pMob, pLookAtType, pLookDistance);
        }

        public boolean canUse() {
            return super.canUse() && !FennecFoxEntity.this.isFaceplanted() && !FennecFoxEntity.this.isInterested();
        }

        public boolean canContinueToUse() {
            return super.canContinueToUse() && !FennecFoxEntity.this.isFaceplanted() && !FennecFoxEntity.this.isInterested();
        }
    }

    class PerchAndSearchGoal extends FennecFoxEntity.FennecFoxBehaviorGoal {
        private double relX;
        private double relZ;
        private int lookTime;
        private int looksRemaining;

        public PerchAndSearchGoal() {
            super();
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            return FennecFoxEntity.this.getLastHurtByMob() == null && FennecFoxEntity.this.getRandom().nextFloat() < 0.02F && !FennecFoxEntity.this.isSleeping() && FennecFoxEntity.this.getTarget() == null && FennecFoxEntity.this.getNavigation().isDone() && !this.alertable() && !FennecFoxEntity.this.isPouncing() && !FennecFoxEntity.this.isCrouching();
        }

        public boolean canContinueToUse() {
            return this.looksRemaining > 0;
        }

        public void start() {
            this.resetLook();
            this.looksRemaining = 2 + FennecFoxEntity.this.getRandom().nextInt(3);
            FennecFoxEntity.this.setSitting(true);
            FennecFoxEntity.this.getNavigation().stop();
        }

        public void stop() {
            FennecFoxEntity.this.setSitting(false);
        }

        public void tick() {
            --this.lookTime;
            if (this.lookTime <= 0) {
                --this.looksRemaining;
                this.resetLook();
            }

            FennecFoxEntity.this.getLookControl().setLookAt(FennecFoxEntity.this.getX() + this.relX, FennecFoxEntity.this.getEyeY(), FennecFoxEntity.this.getZ() + this.relZ, (float) FennecFoxEntity.this.getMaxHeadYRot(), (float) FennecFoxEntity.this.getMaxHeadXRot());
        }

        private void resetLook() {
            double d0 = 6.283185307179586 * FennecFoxEntity.this.getRandom().nextDouble();
            this.relX = Math.cos(d0);
            this.relZ = Math.sin(d0);
            this.lookTime = this.adjustedTickDelay(80 + FennecFoxEntity.this.getRandom().nextInt(20));
        }
    }

    class DefendTrustedTargetGoal extends NearestAttackableTargetGoal<LivingEntity> {
        @Nullable
        private LivingEntity trustedLastHurtBy;
        @Nullable
        private LivingEntity trustedLastHurt;
        private int timestamp;

        public DefendTrustedTargetGoal(Class<LivingEntity> pTargetType, boolean pMustSee, boolean pMustReach, @Nullable Predicate<LivingEntity> pPredicate) {
            super(FennecFoxEntity.this, pTargetType, 10, pMustSee, pMustReach, pPredicate);
        }

        public boolean canUse() {
            if (this.randomInterval > 0 && this.mob.getRandom().nextInt(this.randomInterval) != 0) {
                return false;
            } else {
                Iterator var1 = FennecFoxEntity.this.getTrustedUUIDs().iterator();

                while(var1.hasNext()) {
                    UUID uuid = (UUID)var1.next();
                    if (uuid != null && FennecFoxEntity.this.level() instanceof ServerLevel) {
                        Entity entity = ((ServerLevel) FennecFoxEntity.this.level()).getEntity(uuid);
                        if (entity instanceof LivingEntity) {
                            LivingEntity livingentity = (LivingEntity)entity;
                            this.trustedLastHurt = livingentity;
                            this.trustedLastHurtBy = livingentity.getLastHurtByMob();
                            int i = livingentity.getLastHurtByMobTimestamp();
                            return i != this.timestamp && this.canAttack(this.trustedLastHurtBy, this.targetConditions);
                        }
                    }
                }

                return false;
            }
        }

        public void start() {
            this.setTarget(this.trustedLastHurtBy);
            this.target = this.trustedLastHurtBy;
            if (this.trustedLastHurt != null) {
                this.timestamp = this.trustedLastHurt.getLastHurtByMobTimestamp();
            }

            FennecFoxEntity.this.playSound(SoundEvents.FOX_AGGRO, 1.0F, 1.0F);
            FennecFoxEntity.this.setDefending(true);
            FennecFoxEntity.this.wakeUp();
            super.start();
        }
    }


    public static class FennecFoxGroupData extends AgeableMob.AgeableMobGroupData {

        public FennecFoxGroupData() {
            super(false);
        }
    }

    abstract class FennecFoxBehaviorGoal extends Goal {
        private final TargetingConditions alertableTargeting;

        FennecFoxBehaviorGoal() {
            TargetingConditions var10001 = TargetingConditions.forCombat().range(12.0).ignoreLineOfSight();
            FennecFoxEntity var10004 = FennecFoxEntity.this;
            Objects.requireNonNull(var10004);
            this.alertableTargeting = var10001.selector(var10004.new FennecFoxAlertableEntitiesSelector());
        }

        protected boolean hasShelter() {
            BlockPos blockpos = BlockPos.containing(FennecFoxEntity.this.getX(), FennecFoxEntity.this.getBoundingBox().maxY, FennecFoxEntity.this.getZ());
            return !FennecFoxEntity.this.level().canSeeSky(blockpos) && FennecFoxEntity.this.getWalkTargetValue(blockpos) >= 0.0F;
        }

        protected boolean alertable() {
            return !FennecFoxEntity.this.level().getNearbyEntities(LivingEntity.class, this.alertableTargeting, FennecFoxEntity.this, FennecFoxEntity.this.getBoundingBox().inflate(12.0, 6.0, 12.0)).isEmpty();
        }
    }

    public class FennecFoxAlertableEntitiesSelector implements Predicate<LivingEntity> {
        public FennecFoxAlertableEntitiesSelector() {
        }

        public boolean test(LivingEntity pEntity) {
            if (pEntity instanceof FennecFoxEntity) {
                return false;
            } else if (!(pEntity instanceof Chicken) && !(pEntity instanceof Rabbit) && !(pEntity instanceof Monster)) {
                if (pEntity instanceof TamableAnimal) {
                    return !((TamableAnimal)pEntity).isTame();
                } else if (pEntity instanceof Player && (pEntity.isSpectator() || ((Player)pEntity).isCreative())) {
                    return false;
                } else if (FennecFoxEntity.this.trusts(pEntity.getUUID())) {
                    return false;
                } else {
                    return !pEntity.isSleeping() && !pEntity.isDiscrete();
                }
            } else {
                return true;
            }
        }
    }

}