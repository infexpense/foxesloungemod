package com.fuyuvulpes.yoamod.world.item.weaponry;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class BlowDartItem extends Item implements Vanishable {
    public final Tier dartTier;

    public BlowDartItem(Tier tier, Properties pProperties) {
        super(pProperties.durability(tier.getUses()));
        this.dartTier =tier;
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player player, InteractionHand pUsedHand) {

        ItemStack stack = player.getItemInHand(pUsedHand);
        ArrowItem arrowitem = (ArrowItem)Items.ARROW;


        AbstractArrow abstractarrow = arrowitem.createArrow(pLevel, Items.ARROW.getDefaultInstance(), player);

        stack.hurtAndBreak(1, player, (pPlayer) -> {
            pPlayer.broadcastBreakEvent(player.getUsedItemHand());
        });
        abstractarrow.setBaseDamage(dartTier.getAttackDamageBonus() * 2.0);

        abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.5F, 0.2F);

        pLevel.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.SHULKER_SHOOT, SoundSource.PLAYERS, 1.0F, 0.4F / (pLevel.getRandom().nextFloat() * 0.3F + 0.5F));


        if (!pLevel.isClientSide){
            pLevel.addFreshEntity(abstractarrow);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.success(stack);
    }

}
