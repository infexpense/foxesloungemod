package com.fuyuvulpes.yoamod.world.item.weaponry;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;

public class BlowDartItem extends TieredItem implements Vanishable {
    public final Tier dartTier;

    public BlowDartItem(Tier tier, Properties pProperties) {
        super(tier,pProperties);
        this.dartTier =tier;
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player player, InteractionHand pUsedHand) {
        ItemStack stack = player.getItemInHand(pUsedHand);


        if (player.isCrouching() && (player.getItemInHand(InteractionHand.OFF_HAND).is(Items.LINGERING_POTION) || player.getItemInHand(InteractionHand.OFF_HAND).is(Items.SPLASH_POTION))){
            ItemStack potionStack = player.getItemInHand(InteractionHand.OFF_HAND);
            potionStack.shrink(1);
            this.setEffects(stack,PotionUtils.getPotion(potionStack));

            return InteractionResultHolder.success(stack);
        }
        ItemStack arrowStack = Items.ARROW.getDefaultInstance();
        ArrowItem arrowitem = (ArrowItem) arrowStack.getItem();


        if (!this.getEffects(stack).getEffects().isEmpty()){
            arrowStack = Items.TIPPED_ARROW.getDefaultInstance();
            PotionUtils.setPotion(arrowStack,this.getEffects(stack));
            arrowitem = (TippedArrowItem) arrowStack.getItem();

        }

        AbstractArrow abstractarrow = arrowitem.createArrow(pLevel, Items.ARROW.getDefaultInstance(), player);

        stack.hurtAndBreak(1, player, (pPlayer) -> {
            pPlayer.broadcastBreakEvent(player.getUsedItemHand());
        });
        abstractarrow.pickup = AbstractArrow.Pickup.DISALLOWED;
        abstractarrow.setBaseDamage(dartTier.getAttackDamageBonus() * 1.5);

        abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.5F, 0.2F);

        pLevel.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.SHULKER_SHOOT, SoundSource.PLAYERS, 1.0F, 5.0F / (pLevel.getRandom().nextFloat() * 0.3F + 0.5F));

        player.getCooldowns().addCooldown(stack.getItem(), (int) (400 / this.getTier().getSpeed()));
        if (!pLevel.isClientSide){
            pLevel.addFreshEntity(abstractarrow);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.success(stack);

    }


    public void setEffects(ItemStack stack, Potion effects) {
        PotionUtils.setPotion(stack,effects);
    }

    public Potion getEffects(ItemStack stack) {
       return PotionUtils.getPotion(stack);
    }
}
