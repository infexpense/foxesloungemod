package com.fuyuvulpes.yoamod.world.item.weaponry;

import com.fuyuvulpes.yoamod.world.item.*;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

import java.util.Random;

public class ScissorsSwordItem extends WeaponItem {
    public final ItemStack scissorStack;
    public ScissorsSwordItem(ItemStack scissor, Tier tier, Properties properties) {
        super(tier, WeaponStats.SCISSORS_SWORD, properties);
        this.scissorStack = scissor;
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        if (pPlayer.isCrouching()){
            ItemStack stack1 = this.scissorStack;
            pPlayer.addItem(stack1.copy());
            return InteractionResultHolder.success(stack1);
        }
        return InteractionResultHolder.fail(stack);}



    @Override
    public AttackAnim getAttackAnimation(ItemStack itemStack) {
        return new Random().nextFloat() > 0.5 ? AttackAnims.SWING : AttackAnims.STAB;
    }

}
