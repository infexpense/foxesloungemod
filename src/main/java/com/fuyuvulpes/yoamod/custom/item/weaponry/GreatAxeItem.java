package com.fuyuvulpes.yoamod.custom.item.weaponry;

import com.fuyuvulpes.yoamod.core.AttackAnim;
import com.fuyuvulpes.yoamod.core.AttackAnims;
import com.fuyuvulpes.yoamod.core.items.HitEffectWeaponItem;
import com.fuyuvulpes.yoamod.core.items.WeaponItem;
import com.fuyuvulpes.yoamod.core.items.WeaponStat;
import com.fuyuvulpes.yoamod.core.items.WeaponStats;
import com.fuyuvulpes.yoamod.registries.ModEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class GreatAxeItem extends HitEffectWeaponItem {
    public GreatAxeItem(Tier tier, Properties properties) {
        super(tier, WeaponStats.GREAT_AXE, properties, ModEffects.STUNNED.get(),0.2f);
    }


    @Override
    public AttackAnim getAttackAnimation(ItemStack itemStack) {
        return AttackAnims.SWING;
    }
}
