package com.fuyuvulpes.yoamod.world.item.weaponry;

import com.fuyuvulpes.yoamod.world.item.AttackAnim;
import com.fuyuvulpes.yoamod.world.item.AttackAnims;
import com.fuyuvulpes.yoamod.world.item.WeaponItem;
import com.fuyuvulpes.yoamod.world.item.WeaponStats;
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
