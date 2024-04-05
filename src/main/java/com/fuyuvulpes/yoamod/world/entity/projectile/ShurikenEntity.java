package com.fuyuvulpes.yoamod.world.entity.projectile;

import com.fuyuvulpes.yoamod.core.registries.YoaEntityTypes;
import com.fuyuvulpes.yoamod.core.registries.YoaKeys;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ShurikenEntity extends ThrowableItem{
    private boolean canHitEntities = true;

    public ShurikenEntity(Level pLevel, ItemStack item, Entity owner) {
        super(0.7F, 100, 10, YoaEntityTypes.SHURIKEN.get(), pLevel, item, owner);
    }

    public ShurikenEntity(EntityType<? extends ShurikenEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }



    @Override
    public void tick() {
        super.tick();
        this.tickDespawn();
        boolean flag = this.isNoPhysics();
        Vec3 vec3 = this.getDeltaMovement();
        if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
            double d0 = vec3.horizontalDistance();
            this.setYRot((float) (Mth.atan2(vec3.x, vec3.z) * 180.0F / (float) Math.PI));
            this.setXRot((float) (Mth.atan2(vec3.y, d0) * 180.0F / (float) Math.PI));
            this.yRotO = this.getYRot();
            this.xRotO = this.getXRot();
        }

        BlockPos blockpos = this.blockPosition();
        BlockState blockstate = this.level().getBlockState(blockpos);
        if (!blockstate.isAir() && !flag) {
            VoxelShape voxelshape = blockstate.getCollisionShape(this.level(), blockpos);
            if (!voxelshape.isEmpty()) {
                Vec3 vec31 = this.position();

                for (AABB aabb : voxelshape.toAabbs()) {
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

        Vec3 vec32 = this.position();
        Vec3 vec33 = vec32.add(vec3);
        HitResult hitresult = this.level().clip(new ClipContext(vec32, vec33, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
        if (hitresult.getType() != HitResult.Type.MISS) {
            vec33 = hitresult.getLocation();
        }

        while (!this.isRemoved()) {
            EntityHitResult entityhitresult = this.findHitEntity(vec32, vec33);
            if (entityhitresult != null) {
                hitresult = entityhitresult;
            }

            if (hitresult != null && hitresult.getType() == HitResult.Type.ENTITY) {
                Entity entity = ((EntityHitResult) hitresult).getEntity();
                Entity entity1 = this.getOwner();
                if (entity instanceof Player && entity1 instanceof Player && !((Player) entity1).canHarmPlayer((Player) entity)) {
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
            this.setYRot((float) (Mth.atan2(-d5, -d1) * 180.0F / (float) Math.PI));
        } else {
            this.setYRot((float) (Mth.atan2(d5, d1) * 180.0F / (float) Math.PI));
        }

        this.setXRot((float) (Mth.atan2(d6, d4) * 180.0F / (float) Math.PI));
        this.setXRot(lerpRotation(this.xRotO, this.getXRot()));
        this.setYRot(lerpRotation(this.yRotO, this.getYRot()));
        float f = 0.99F;
        float f1 = 0.05F;
        if (this.isInWater()) {
            for (int j = 0; j < 4; ++j) {
                float f2 = 0.25F;
                this.level().addParticle(ParticleTypes.BUBBLE, d7 - d5 * 0.25, d2 - d6 * 0.25, d3 - d1 * 0.25, d5, d6, d1);
            }

            f = this.getWaterInertia();
        }


        this.setDeltaMovement(vec3.scale((double) f));
        if (!this.isNoGravity() && !flag) {
            Vec3 vec34 = this.getDeltaMovement();
            this.setDeltaMovement(vec34.x, vec34.y - 0.05F, vec34.z);
        }

        this.setPos(d7, d2, d3);
        this.checkInsideBlocks();
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();

        Entity entity1 = this.getOwner();
        DamageSource damagesource = this.damageSources().source(YoaKeys.PROJECTILE,(Entity)(entity1 == null ? this : entity1));
        if (entity1 instanceof LivingEntity) {

            ((LivingEntity) entity1).setLastHurtMob(entity);
        }

        boolean flag = entity.getType() == EntityType.ENDERMAN;
        if (this.isOnFire() && !flag) {
            entity.setSecondsOnFire(5);
        }
        if (flag) return;

        entity.hurt(damagesource, (float) Mth.ceil(Mth.clamp(this.getConcreteDamage(), 0.0, 1000)));


        this.playSound(this.getDefaultHitGroundSoundEvent(), 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
        this.canHitEntities = false;
        this.deflect();

    }


    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("can_hit", this.canHitEntities);

    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.canHitEntities = pCompound.getBoolean("can_hit");

    }

    @Override
    protected boolean canHitEntity(Entity pTarget) {

        return super.canHitEntity(pTarget) && this.canHitEntities;
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        Vec3 vec3 = pResult.getLocation();
        Vec3 vec31 = vec3.normalize().scale(0.05F);
        this.setPosRaw(this.getX() - vec31.x, this.getY() - vec31.y, this.getZ() - vec31.z);
        this.playSound(this.getHitGroundSoundEvent(), 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
        this.inGround = true;
    }

    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.METAL_HIT;
    }

    protected final SoundEvent getHitGroundSoundEvent() {
        return SoundEvents.METAL_HIT;
    }

}
