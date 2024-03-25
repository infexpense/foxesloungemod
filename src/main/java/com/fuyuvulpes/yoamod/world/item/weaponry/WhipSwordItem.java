package com.fuyuvulpes.yoamod.world.item.weaponry;

import com.fuyuvulpes.yoamod.world.item.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
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
        return super.hurtEnemy(pStack, pTarget, pAttacker);

    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        return super.onEntitySwing(stack, entity);
    }

    @Override
    public AABB getSweepHitBox(ItemStack stack, Player player, Entity target) {
        return target.getBoundingBox().expandTowards(player.getViewVector(0)).inflate(6.0D, 0.5D, 6.0D);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return YoaToolActions.WHIP_ACTIONS.contains(toolAction);
    }
}
