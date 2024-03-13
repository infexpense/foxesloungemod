package com.fuyuvulpes.yoamod.world.item.weaponry;

import com.fuyuvulpes.yoamod.world.item.AttackAnim;
import com.fuyuvulpes.yoamod.world.item.AttackAnims;
import com.fuyuvulpes.yoamod.world.item.HitEffectWeaponItem;
import com.fuyuvulpes.yoamod.world.item.WeaponStats;
import com.fuyuvulpes.yoamod.core.registries.YoaEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class GreatAxeItem extends HitEffectWeaponItem {
    public GreatAxeItem(Tier tier, Properties properties) {
        super(tier, WeaponStats.GREAT_AXE, properties, YoaEffects.STUNNED.get(),0.2f);
    }


    @Override
    public AttackAnim getAttackAnimation(ItemStack itemStack) {
        return AttackAnims.SWING;
    }
}
