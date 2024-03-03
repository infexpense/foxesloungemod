package com.fuyuvulpes.yoamod.world.item.weaponry;

import com.fuyuvulpes.yoamod.world.item.AttackAnim;
import com.fuyuvulpes.yoamod.world.item.AttackAnims;
import com.fuyuvulpes.yoamod.world.item.WeaponItem;
import com.fuyuvulpes.yoamod.world.item.WeaponStats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;

public class ClawsItem extends WeaponItem {

    public Potion effects;

    public ClawsItem(Tier tier, Properties properties) {
        super(tier, WeaponStats.CLAWS, properties);
    }

    @Override
    public AttackAnim getAttackAnimation(ItemStack itemStack) {
        return AttackAnims.STAB;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player player, InteractionHand pUsedHand) {
        ItemStack stack = player.getItemInHand(pUsedHand);


        if (player.isCrouching() && (player.getItemInHand(InteractionHand.OFF_HAND).is(Items.LINGERING_POTION) || player.getItemInHand(InteractionHand.OFF_HAND).is(Items.SPLASH_POTION))) {
            ItemStack potionStack = player.getItemInHand(InteractionHand.OFF_HAND);
            potionStack.shrink(1);
            this.setEffects(stack,PotionUtils.getPotion(potionStack));

            return InteractionResultHolder.success(stack);
        }
        return InteractionResultHolder.fail(stack);
    }





    public void setEffects(ItemStack stack, Potion effects) {
        PotionUtils.setPotion(stack,effects);
    }

    public Potion getEffects(ItemStack stack) {
        return PotionUtils.getPotion(stack);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!this.getEffects(stack).getEffects().isEmpty()){
            target.addEffect(this.getEffects(stack).getEffects().stream().findFirst().get());
        }

        return super.hurtEnemy(stack, target, attacker);


    }
}
