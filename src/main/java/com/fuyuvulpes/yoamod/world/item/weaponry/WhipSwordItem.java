package com.fuyuvulpes.yoamod.world.item.weaponry;

import com.fuyuvulpes.yoamod.world.item.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.common.ToolAction;

public class WhipSwordItem extends HitEffectWeaponItem {
    public WhipSwordItem(Tier tier, Properties properties) {
        super(tier, WeaponStats.WHIP_SWORD, properties, 0.1F);
    }

    @Override
    public AttackAnim getAttackAnimation(ItemStack itemStack) {
        return AttackAnims.SWING;
    }


    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (!(pAttacker instanceof Player)){
            return super.hurtEnemy(pStack, pTarget, pAttacker);

        }
        for(LivingEntity livingentity : pAttacker.level()
                .getEntitiesOfClass(LivingEntity.class, pTarget.getBoundingBox().inflate(3.0D, 0.5D, 3.0D))) {
            double entityReachSq = Mth.square(12);
            if (livingentity != pAttacker
                    && livingentity != pTarget
                    && !pAttacker.isAlliedTo(livingentity)
                    && (!(livingentity instanceof ArmorStand) || !((ArmorStand)livingentity).isMarker())
                    && pAttacker.distanceToSqr(livingentity) < entityReachSq) {
                livingentity.knockback(
                        1.0F,
                        (double)Mth.sin(pAttacker.getYRot() * (float) (Math.PI / 180.0)),
                        (double)(-Mth.cos(pAttacker.getYRot() * (float) (Math.PI / 180.0)))
                );
                livingentity.hurt(pAttacker.damageSources().playerAttack((Player) pAttacker), pStack.getDamageValue());
                if (livingentity.level() instanceof ServerLevel){
                    ((ServerLevel)livingentity.level()).sendParticles(ParticleTypes.SWEEP_ATTACK, livingentity.getX(), livingentity.getY(0.5), livingentity.getZ() , 0, 0.0, 0.0, 0.0, 0.0);
                }

            }
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);

    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return YoaToolActions.WHIP_ACTIONS.contains(toolAction);
    }
}
