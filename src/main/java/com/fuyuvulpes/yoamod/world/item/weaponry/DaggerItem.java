package com.fuyuvulpes.yoamod.world.item.weaponry;

import com.fuyuvulpes.yoamod.world.item.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.common.ToolAction;

public class DaggerItem extends WeaponItem {
    public DaggerItem(Tier tier, Properties properties) {
        super(tier, WeaponStats.DAGGER, properties);
    }

    @Override
    public AttackAnim getAttackAnimation(ItemStack itemStack) {
        return AttackAnims.SWING;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return YoaToolActions.DAGGER_ACTIONS.contains(toolAction);
    }


}
