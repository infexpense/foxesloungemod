package com.fuyuvulpes.yoamod.world.entity.projectile;

import com.fuyuvulpes.yoamod.core.registries.YoaItems;
import com.fuyuvulpes.yoamod.core.registries.YoaTags;
import com.fuyuvulpes.yoamod.world.entity.Blockling;
import com.fuyuvulpes.yoamod.world.item.ModToolTiers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

import java.util.UUID;
import java.util.function.IntFunction;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public abstract class ThrowableItem extends Projectile {
    protected static final EntityDataAccessor<String> TIER_ID = SynchedEntityData.defineId(ThrowableItem.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Byte> ID_FLAGS = SynchedEntityData.defineId(ThrowableItem.class, EntityDataSerializers.BYTE);

    UUID lastEntityUUID = null;


    protected int life;
    protected double baseDamage = 2.0F;
    protected double multiplier;
    protected ItemStack item;

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
            this.baseDamage = tieredItem.getTier().getAttackDamageBonus() + 1.0F;

            this.entityData.set(TIER_ID, Type.byTier(tieredItem.getTier()).getName());


        }
        this.item = item;
        this.inGround = false;
        this.lifeTime = lifeTime;
        this.groundTimeMax = groundTime;
        this.multiplier = multiplier;
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

    public ThrowableItem.Type getVariant() {
        return ThrowableItem.Type.byName(this.entityData.get(TIER_ID));
    }




    @Override
    protected void defineSynchedData() {
        this.entityData.define(ID_FLAGS, (byte)0);
        this.entityData.define(TIER_ID, "iron");
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
    protected boolean canHitEntity(Entity pTarget) {
        return super.canHitEntity(pTarget) && pTarget.getUUID() != lastEntityUUID && pTarget != this.getOwner();
    }

    protected void tickDespawn() {
        ++this.life;
        if (this.inGround && this.inGroundTime > groundTimeMax && life > lifeTime){
            this.discard();
        }
    }

    public void deflect() {
        float f = this.random.nextFloat() * 360.0F;
        this.setDeltaMovement(this.getDeltaMovement().yRot(f * (float) (Math.PI / 180.0)).scale(0.5));
        this.setYRot(this.getYRot() + f);
        this.yRotO += f;
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

    public void setNoPhysics(boolean pNoPhysics) {
        this.noPhysics = pNoPhysics;
        this.setFlag(2, pNoPhysics);
    }

    private void setFlag(int pId, boolean pValue) {
        byte b0 = this.entityData.get(ID_FLAGS);
        if (pValue) {
            this.entityData.set(ID_FLAGS, (byte)(b0 | pId));
        } else {
            this.entityData.set(ID_FLAGS, (byte)(b0 & ~pId));
        }
    }

    public boolean isNoPhysics() {
        if (!this.level().isClientSide) {
            return this.noPhysics;
        } else {
            return (this.entityData.get(ID_FLAGS) & 2) != 0;
        }
    }
    protected ItemStack getPickupItem() {
        return this.item.copy();
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

    @Override
    protected void onHitEntity(EntityHitResult pResult) {

        this.lastEntityUUID = pResult.getEntity().getUUID();
        super.onHitEntity(pResult);
    }

    public static enum Type implements StringRepresentable {
        BRONZE(0, "bronze"),
        GOLD(1, "gold"),
        SILVER(3, "silver"),
        IRON(4, "iron"),
        STEEL(5, "steel"),
        BISMUTH(6, "bismuth"),
        DIAMOND(7, "diamond"),
        NETHERITE(8, "netherite"),
        TITANIUM(9, "iolite"),
        IOLITE(10, "iolite"),
        ALEXANDRITE(11, "alexandrite"),
        ADAMANTITE(12, "adamantite"),
        STONE(13, "stone"),
        WOOD(14, "wood");

        public static final StringRepresentable.EnumCodec<ThrowableItem.Type> CODEC = StringRepresentable.fromEnum(ThrowableItem.Type::values);
        private final int id;
        private final String name;

        private Type(int pId, String pName) {
            this.id = pId;
            this.name = pName;
        }

        public static Type byTier(Tier tier) {
            if (tier == ModToolTiers.BRONZE){
                return SILVER;
            }else
            if (tier == ModToolTiers.SILVER){
                return SILVER;
            }else
            if (tier == ModToolTiers.STEEL){
                return STEEL;
            }else
            if (tier == ModToolTiers.BISMUTH){
                return BISMUTH;
            }else
            if (tier == ModToolTiers.TITANIUM){
                return TITANIUM;
            }else
            if (tier == ModToolTiers.IOLITE){
                return IOLITE;
            }else
            if (tier == ModToolTiers.ALEXANDRITE){
                return ALEXANDRITE;
            }else
            if (tier == ModToolTiers.ADAMANTITE) {
                return ADAMANTITE;
            }else
            if (tier == Tiers.WOOD) {
                return WOOD;
            }else
            if (tier == Tiers.STONE) {
                return STONE;
            }else
            if (tier == Tiers.IRON) {
                return IRON;
            }else
            if (tier == Tiers.GOLD) {
                return GOLD;
            }else
            if (tier == Tiers.DIAMOND) {
                return DIAMOND;
            }else
            if (tier == Tiers.NETHERITE) {
                return DIAMOND;
            }
            return IRON;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }


        public static ThrowableItem.Type byName(String pName) {
            return CODEC.byName(pName, IRON);
        }

    }
}
