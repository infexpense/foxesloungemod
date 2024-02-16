package com.fuyuvulpes.yoamod.custom.item.weaponry;

import com.fuyuvulpes.yoamod.core.AttackAnim;
import com.fuyuvulpes.yoamod.core.AttackAnims;
import com.fuyuvulpes.yoamod.core.items.WeaponItem;
import com.fuyuvulpes.yoamod.core.items.WeaponStat;
import com.fuyuvulpes.yoamod.core.items.WeaponStats;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class DaggerItem extends WeaponItem {
    public DaggerItem(Tier tier, Properties properties) {
        super(tier, WeaponStats.DAGGER, properties);
    }

    @Override
    public AttackAnim getAttackAnimation(ItemStack itemStack) {
        return AttackAnims.SWING;
    }
}
