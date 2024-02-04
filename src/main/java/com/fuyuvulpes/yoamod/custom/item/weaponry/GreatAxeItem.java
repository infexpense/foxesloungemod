package com.fuyuvulpes.yoamod.custom.item.weaponry;

import com.fuyuvulpes.yoamod.core.items.WeaponItem;
import com.fuyuvulpes.yoamod.core.items.WeaponStat;
import com.fuyuvulpes.yoamod.core.items.WeaponStats;
import net.minecraft.world.item.Tier;

public class GreatAxeItem extends WeaponItem {
    public GreatAxeItem(Tier tier, Properties properties) {
        super(tier, WeaponStats.GREAT_AXE, properties);
    }
}
