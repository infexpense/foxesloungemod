package com.fuyuvulpes.yoamod.world.item.weaponry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Vanishable;

public class SpellcasterStaffItem extends TieredItem implements Vanishable {
    public SpellcasterStaffItem(Tier tier, Properties pProperties) {
        super(tier,pProperties);
    }
}
