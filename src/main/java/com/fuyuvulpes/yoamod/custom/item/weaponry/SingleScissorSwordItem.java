package com.fuyuvulpes.yoamod.custom.item.weaponry;

import com.fuyuvulpes.yoamod.core.AttackAnim;
import com.fuyuvulpes.yoamod.core.AttackAnims;
import com.fuyuvulpes.yoamod.core.items.WeaponItem;
import com.fuyuvulpes.yoamod.core.items.WeaponStats;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

import java.util.Random;

public class SingleScissorSwordItem extends WeaponItem {
    public SingleScissorSwordItem(Tier tier, Properties properties) {
        super(tier, WeaponStats.SINGLE_SCISSORS_SWORD, properties);
    }


    @Override
    public AttackAnim getAttackAnimation(ItemStack itemStack) {
        return new Random().nextFloat() > 0.62F ? AttackAnims.SWING : AttackAnims.STAB;
    }
}
