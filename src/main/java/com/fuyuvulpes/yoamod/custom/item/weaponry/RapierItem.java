package com.fuyuvulpes.yoamod.custom.item.weaponry;

import com.fuyuvulpes.yoamod.core.items.HitEffectWeaponItem;
import com.fuyuvulpes.yoamod.core.items.WeaponStats;
import net.minecraft.world.item.Tier;

public class RapierItem extends HitEffectWeaponItem {
    public RapierItem(Tier tier, Properties properties) {
        super(tier, WeaponStats.RAPIER, properties, null, 0, true, 0.62F);
    }


}
