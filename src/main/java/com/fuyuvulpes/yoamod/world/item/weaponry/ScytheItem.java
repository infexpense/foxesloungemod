package com.fuyuvulpes.yoamod.world.item.weaponry;

import com.fuyuvulpes.yoamod.world.item.*;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.common.ToolAction;

public class ScytheItem extends HitEffectWeaponItem {
    public ScytheItem(Tier tier, Properties properties) {
        super(tier, WeaponStats.SCYTHE, properties, MobEffects.WITHER,0.1F);
    }


    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return YoaToolActions.SCYTHE_ACTIONS.contains(toolAction);
    }

    @Override
    public AttackAnim getAttackAnimation(ItemStack itemStack) {
        return AttackAnims.SWING;
    }
}
