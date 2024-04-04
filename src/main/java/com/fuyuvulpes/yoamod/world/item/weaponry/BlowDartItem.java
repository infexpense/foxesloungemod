package com.fuyuvulpes.yoamod.world.item.weaponry;

import com.fuyuvulpes.yoamod.world.entity.projectile.DartProjectile;
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
        this.dartTier = tier;
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


        DartProjectile dart = new DartProjectile(pLevel,stack,player);

        stack.hurtAndBreak(1, player, (pPlayer) -> {
            pPlayer.broadcastBreakEvent(player.getUsedItemHand());
        });

        dart.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.5F, 0.2F);

        pLevel.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.SHULKER_SHOOT, SoundSource.PLAYERS, 0.4F, 5.0F / (pLevel.getRandom().nextFloat() * 0.3F + 0.5F));

        player.getCooldowns().addCooldown(stack.getItem(), (int) (400 / this.getTier().getSpeed()));

        pLevel.addFreshEntity(dart);

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
