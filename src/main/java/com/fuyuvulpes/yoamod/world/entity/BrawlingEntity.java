package com.fuyuvulpes.yoamod.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class BrawlingEntity extends BrawlerEntity{
    public BrawlingEntity(EntityType<? extends BrawlerEntity> entityType, Level level) {
        super(entityType, level);
        xpReward = 10;
    }

    @Override
    public boolean canDisableShield() {
        return false;
    }

    @Override
    public boolean isBaby() {
        return true;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 40.0)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.2F)
                .add(Attributes.ATTACK_KNOCKBACK, 2.0F)
                .add(Attributes.ATTACK_DAMAGE, 8.0)
                .add(Attributes.FOLLOW_RANGE,15.0F);
    }

}
