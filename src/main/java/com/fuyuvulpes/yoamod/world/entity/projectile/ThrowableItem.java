package com.fuyuvulpes.yoamod.world.entity.projectile;

import com.fuyuvulpes.yoamod.core.registries.YoaItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public abstract class ThrowableItem extends Projectile {
    protected int life;
    protected double baseDamage = 2.0F;
    protected double multiplier;
    protected ItemStack item;

    protected boolean bounces;
    protected boolean inGround;
    protected int inGroundTime;
    protected int lifeTime;
    protected int groundTimeMax;
    public ThrowableItem(float multiplier, int lifeTime,int groundTime,EntityType<? extends Projectile> pEntityType, Level pLevel, ItemStack item, Entity owner) {
        this(pEntityType, pLevel);
        this.setOwner(owner);
        double d0 = owner.getX();
        double d1 = owner.getY() + owner.getEyeHeight() - 0.1F;
        double d2 = owner.getZ();
        this.moveTo(d0, d1, d2, this.getYRot(), this.getXRot());

        if (item.getItem() instanceof TieredItem tieredItem) {
            this.baseDamage = tieredItem.getTier().getAttackDamageBonus();

        }
        this.item = item;
        this.inGround = false;
        this.lifeTime = lifeTime;
        this.groundTimeMax = groundTime;
        this.multiplier = multiplier + 1;
    }
    protected ThrowableItem(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.item = YoaItems.DIAMOND_CHAKRAM.toStack();
        this.lifeTime = 100;
        this.groundTimeMax = 10;
        this.multiplier = 1.0F;
    }

    public ItemStack getItem() {
        return item;
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
    protected void tickDespawn() {
        ++this.life;
        if (this.inGround && this.inGroundTime > groundTimeMax && life > lifeTime){
            this.discard();
        }
    }


    public double getConcreteDamage(){
        return multiplier * baseDamage;
    }


    @Nullable
    protected EntityHitResult findHitEntity(Vec3 pStartVec, Vec3 pEndVec) {
        return ProjectileUtil.getEntityHitResult(
                this.level(), this, pStartVec, pEndVec, this.getBoundingBox().expandTowards(this.getDeltaMovement()).inflate(1.0), this::canHitEntity
        );
    }


    public boolean isNoPhysics() {
        if (!this.level().isClientSide) {
            return this.noPhysics;
        } else {
            return false;
        }
    }
    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putDouble("damage", this.baseDamage);
        pCompound.putDouble("multiplier", this.multiplier);
        pCompound.putShort("life", (short)this.life);
        pCompound.putShort("lifeMax", (short)this.lifeTime);
        pCompound.putShort("groundMax", (short)this.groundTimeMax);
        pCompound.putShort("groundTime", (short)this.inGroundTime);

    }

    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.life = pCompound.getShort("life");
        this.lifeTime = pCompound.getShort("lifeMax");
        this.groundTimeMax = pCompound.getShort("groundMax");
        this.inGroundTime = pCompound.getShort("groundTime");
        if (pCompound.contains("damage", 99)) {
            this.baseDamage = pCompound.getDouble("damage");
        }if (pCompound.contains("multiplier", 99)) {
            this.multiplier = pCompound.getDouble("multiplier");
        }
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



    public ResourceLocation getTexture(){
        ResourceLocation location = new ResourceLocation(MODID, "textures/item/" + BuiltInRegistries.ITEM.getKey(item.getItem()).getPath() + ".png");
        return location;
    }
}
