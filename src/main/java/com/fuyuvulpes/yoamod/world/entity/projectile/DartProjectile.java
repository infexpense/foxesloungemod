package com.fuyuvulpes.yoamod.world.entity.projectile;

import com.fuyuvulpes.yoamod.core.registries.YoaEntityTypes;
import com.fuyuvulpes.yoamod.core.registries.YoaKeys;
import com.fuyuvulpes.yoamod.world.item.weaponry.BlowDartItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class DartProjectile extends Projectile {
    private int life;
    private double baseDamage = 2.0F;
    private ItemStack item;

    protected boolean inGround;
    private int inGroundTime;

    public DartProjectile(Level pLevel, ItemStack item, Entity owner) {
        this(YoaEntityTypes.DART.get(), pLevel);
        this.setOwner(owner);
        double d0 = owner.getX();
        double d1 = owner.getY() + owner.getEyeHeight() - 0.1F;
        double d2 = owner.getZ();
        this.moveTo(d0, d1, d2, this.getYRot(), this.getXRot());

        if (item.getItem() instanceof BlowDartItem blowDartItem) {
            this.baseDamage = 1.3F * blowDartItem.getTier().getAttackDamageBonus();

        }
        this.item = item;
        this.inGround = false;
    }

    public DartProjectile(EntityType<? extends DartProjectile> pEntityType, Level level) {
        super(pEntityType, level);
        this.inGround = false;
    }

    @Override
    protected void defineSynchedData() {

    }
    @Override
    public void shoot(double pX, double pY, double pZ, float pVelocity, float pInaccuracy) {
        super.shoot(pX, pY, pZ, pVelocity, pInaccuracy);
        this.life = 0;

    }

    @Override
    public void lerpTo(double pX, double pY, double pZ, float pYRot, float pXRot, int pSteps) {
        this.setPos(pX, pY, pZ);
        this.setRot(pYRot, pXRot);
    }

    @Override
    public void lerpMotion(double pX, double pY, double pZ) {
        super.lerpMotion(pX, pY, pZ);
        this.life = 0;
    }

    @Override
    public void tick() {
        super.tick();
        boolean flag = this.isNoPhysics();
        Vec3 vec3 = this.getDeltaMovement();
        if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
            double d0 = vec3.horizontalDistance();
            this.setYRot((float)(Mth.atan2(vec3.x, vec3.z) * 180.0F / (float)Math.PI));
            this.setXRot((float)(Mth.atan2(vec3.y, d0) * 180.0F / (float)Math.PI));
            this.yRotO = this.getYRot();
            this.xRotO = this.getXRot();
        }

        BlockPos blockpos = this.blockPosition();
        BlockState blockstate = this.level().getBlockState(blockpos);
        if (!blockstate.isAir() && !flag) {
            VoxelShape voxelshape = blockstate.getCollisionShape(this.level(), blockpos);
            if (!voxelshape.isEmpty()) {
                Vec3 vec31 = this.position();

                for(AABB aabb : voxelshape.toAabbs()) {
                    if (aabb.move(blockpos).contains(vec31)) {
                        this.inGround = true;
                        break;
                    }
                }
            }
        }

        if (this.isInWaterOrRain() || blockstate.is(Blocks.POWDER_SNOW) || this.isInFluidType((fluidType, height) -> this.canFluidExtinguish(fluidType))) {
            this.clearFire();
        }

        if (this.inGround && !flag) {
           if (!this.level().isClientSide) {
               this.tickDespawn();
               ++this.inGroundTime;
            }
        } else {
            Vec3 vec32 = this.position();
            Vec3 vec33 = vec32.add(vec3);
            HitResult hitresult = this.level().clip(new ClipContext(vec32, vec33, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
            if (hitresult.getType() != HitResult.Type.MISS) {
                vec33 = hitresult.getLocation();
            }

            while(!this.isRemoved()) {
                EntityHitResult entityhitresult = this.findHitEntity(vec32, vec33);
                if (entityhitresult != null) {
                    hitresult = entityhitresult;
                }

                if (hitresult != null && hitresult.getType() == HitResult.Type.ENTITY) {
                    Entity entity = ((EntityHitResult)hitresult).getEntity();
                    Entity entity1 = this.getOwner();
                    if (entity instanceof Player && entity1 instanceof Player && !((Player)entity1).canHarmPlayer((Player)entity)) {
                        hitresult = null;
                        entityhitresult = null;
                    }
                }

                if (hitresult != null && hitresult.getType() != HitResult.Type.MISS && !flag) {
                    if (net.neoforged.neoforge.event.EventHooks.onProjectileImpact(this, hitresult))
                        break;
                    this.onHit(hitresult);
                    this.hasImpulse = true;
                }

                if (entityhitresult == null) {
                    break;
                }

                hitresult = null;
            }

            vec3 = this.getDeltaMovement();
            double d5 = vec3.x;
            double d6 = vec3.y;
            double d1 = vec3.z;

            double d7 = this.getX() + d5;
            double d2 = this.getY() + d6;
            double d3 = this.getZ() + d1;
            double d4 = vec3.horizontalDistance();
            if (flag) {
                this.setYRot((float)(Mth.atan2(-d5, -d1) * 180.0F / (float)Math.PI));
            } else {
                this.setYRot((float)(Mth.atan2(d5, d1) * 180.0F / (float)Math.PI));
            }

            this.setXRot((float)(Mth.atan2(d6, d4) * 180.0F / (float)Math.PI));
            this.setXRot(lerpRotation(this.xRotO, this.getXRot()));
            this.setYRot(lerpRotation(this.yRotO, this.getYRot()));
            float f = 0.99F;
            float f1 = 0.05F;
            if (this.isInWater()) {
                for(int j = 0; j < 4; ++j) {
                    float f2 = 0.25F;
                    this.level().addParticle(ParticleTypes.BUBBLE, d7 - d5 * 0.25, d2 - d6 * 0.25, d3 - d1 * 0.25, d5, d6, d1);
                }

                f = this.getWaterInertia();
            }

            this.setDeltaMovement(vec3.scale((double)f));
            if (!this.isNoGravity() && !flag) {
                Vec3 vec34 = this.getDeltaMovement();
                this.setDeltaMovement(vec34.x, vec34.y - 0.05F, vec34.z);
            }

            this.setPos(d7, d2, d3);
            this.checkInsideBlocks();
        }
    }

    private void tickDespawn() {
        ++this.life;
        if (this.inGround && this.inGroundTime > 10 && life > 100){
            this.discard();
        }
    }



    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        float f = (float)this.getDeltaMovement().length();
        int i = Mth.ceil(Mth.clamp((double)f * this.baseDamage, 0.0, 2.147483647E9));

        Entity entity1 = this.getOwner();
        DamageSource damagesource = this.damageSources().source(YoaKeys.PROJECTILE);
        if (entity1 instanceof LivingEntity) {
            ((LivingEntity)entity1).setLastHurtMob(entity);
        }

        if (entity instanceof LivingEntity livingB) {
            if (item != null && item.getItem() instanceof BlowDartItem dartItem && dartItem.getEffects(item).getEffects().stream().findFirst().isPresent()) {
                livingB.addEffect(new MobEffectInstance(dartItem.getEffects(item).getEffects().stream().findFirst().get()));
            }
        }


        boolean flag = entity.getType() == EntityType.ENDERMAN;
        int k = entity.getRemainingFireTicks();
        if (this.isOnFire() && !flag) {
            entity.setSecondsOnFire(5);
        }

        if (entity.hurt(damagesource, (float)i)) {
            if (flag) {
                return;
            }

            if (entity instanceof LivingEntity livingentity) {
                if (entity1 != null && livingentity != entity1 && livingentity instanceof Player && entity1 instanceof ServerPlayer && !this.isSilent()) {
                    ((ServerPlayer)entity1).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.ARROW_HIT_PLAYER, 0.0F));
                }
            }
            this.playSound(this.getDefaultHitGroundSoundEvent(), 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
            this.discard();
        } else {
            entity.setRemainingFireTicks(k);
            this.setDeltaMovement(this.getDeltaMovement().scale(-0.1));
            this.setYRot(this.getYRot() + 180.0F);
            this.yRotO += 180.0F;
            this.discard();
        }

    }




    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        Vec3 vec3 = pResult.getLocation().subtract(this.getX(), this.getY(), this.getZ());
        this.setDeltaMovement(vec3);
        Vec3 vec31 = vec3.normalize().scale(0.05F);
        this.setPosRaw(this.getX() - vec31.x, this.getY() - vec31.y, this.getZ() - vec31.z);
        this.playSound(this.getHitGroundSoundEvent(), 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
        this.inGround = true;
    }


    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.SHULKER_BULLET_HIT;
    }

    protected final SoundEvent getHitGroundSoundEvent() {
        return SoundEvents.SHULKER_BULLET_HURT;
    }


    @Nullable
    protected EntityHitResult findHitEntity(Vec3 pStartVec, Vec3 pEndVec) {
        return ProjectileUtil.getEntityHitResult(
                this.level(), this, pStartVec, pEndVec, this.getBoundingBox().expandTowards(this.getDeltaMovement()).inflate(1.0), this::canHitEntity
        );
    }



    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putDouble("damage", this.baseDamage);
        pCompound.putShort("life", (short)this.life);

    }

    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.life = pCompound.getShort("life");
        if (pCompound.contains("damage", 99)) {
            this.baseDamage = pCompound.getDouble("damage");
        }
    }
    public void setBaseDamage(double pBaseDamage) {
        this.baseDamage = pBaseDamage;
    }

    public double getBaseDamage() {
        return this.baseDamage;
    }
    @Override
    public boolean isAttackable() {
        return false;
    }

    @Override
    protected float getEyeHeight(Pose pPose, EntityDimensions pSize) {
        return 0.13F;
    }

    protected float getWaterInertia() {
        return 0.6F;
    }

    public void setNoPhysics(boolean pNoPhysics) {
        this.noPhysics = pNoPhysics;
    }

    public boolean isNoPhysics() {
        if (!this.level().isClientSide) {
            return this.noPhysics;
        } else {
            return false;
        }
    }
}
