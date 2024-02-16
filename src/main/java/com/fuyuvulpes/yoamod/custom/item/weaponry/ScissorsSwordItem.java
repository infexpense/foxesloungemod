package com.fuyuvulpes.yoamod.custom.item.weaponry;

import com.fuyuvulpes.yoamod.core.AttackAnim;
import com.fuyuvulpes.yoamod.core.AttackAnims;
import com.fuyuvulpes.yoamod.core.items.WeaponItem;
import com.fuyuvulpes.yoamod.core.items.WeaponStat;
import com.fuyuvulpes.yoamod.core.items.WeaponStats;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

import java.util.Random;

public class ScissorsSwordItem extends WeaponItem {
    public ScissorsSwordItem(Tier tier, Properties properties) {
        super(tier, WeaponStats.SCISSORS_SWORD, properties);
    }



    @Override
    public AttackAnim getAttackAnimation(ItemStack itemStack) {
        return new Random().nextFloat() > 0.5 ? AttackAnims.SWING : AttackAnims.STAB;
    }

}
