package com.fuyuvulpes.yoamod.custom.item.weaponry;

import com.fuyuvulpes.yoamod.core.AttackAnim;
import com.fuyuvulpes.yoamod.core.AttackAnims;
import com.fuyuvulpes.yoamod.core.items.HitEffectWeaponItem;
import com.fuyuvulpes.yoamod.core.items.WeaponItem;
import com.fuyuvulpes.yoamod.core.items.WeaponStats;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.phys.AABB;

public class WhipSwordItem extends HitEffectWeaponItem {
    public WhipSwordItem(Tier tier, Properties properties) {
        super(tier, WeaponStats.WHIP_SWORD, properties, 0.2F);
    }

    @Override
    public AttackAnim getAttackAnimation(ItemStack itemStack) {
        return AttackAnims.SWING;
    }

    @Override
    public AABB getSweepHitBox(ItemStack stack, Player player, Entity target) {
        return target.getBoundingBox().inflate(3.0D, 0.25D, 3.0D);
    }


}
