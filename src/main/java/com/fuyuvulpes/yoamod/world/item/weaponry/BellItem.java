package com.fuyuvulpes.yoamod.world.item.weaponry;

import com.fuyuvulpes.yoamod.world.item.IManaConsumingWeapon;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BellItem extends TieredItem implements Vanishable, IManaConsumingWeapon {
    public BellItem(Tier tier, Properties pProperties) {
        super(tier,pProperties);
    }



    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {
        if (!(pLivingEntity instanceof Player)){
            super.releaseUsing(pStack, pLevel, pLivingEntity, pTimeCharged);
            return;
        }
        float i = Math.min(this.getUseDuration(pStack) - pTimeCharged + 20 ,80);
        float power = 1 - ((80 - i) / 80);
        if(!canConsumeMana((Player) pLivingEntity, (int) (6 * power))){
            pLevel.playSound(null,pLivingEntity.getOnPos().above(), SoundEvents.BEACON_DEACTIVATE, SoundSource.PLAYERS,1.0F, 0.2F);
        }
        else {

            List<LivingEntity> list = pLevel.getEntitiesOfClass(LivingEntity.class, pLivingEntity.getBoundingBox().inflate(6.0F * power, 2.0F * power, 6.0F * power));
            List<LivingEntity> alliedTo = new ArrayList<>();

            list.remove(pLivingEntity);
            list.forEach(entity -> {
                if (entity.isAlliedTo(pLivingEntity) && !(entity instanceof Monster)) {
                    alliedTo.add(entity);
                    list.remove(entity);
                }
            });

            list.forEach(livingEntity -> {
                livingEntity.hurt(pLivingEntity.damageSources().magic(), Math.max(2.0F + 8.0F * power * this.getTier().getAttackDamageBonus() / 2, 1.0F + 2.0F * this.getTier().getAttackDamageBonus()));
                if (!livingEntity.level().isClientSide()) {
                    ((ServerLevel) livingEntity.level()).sendParticles(ParticleTypes.SONIC_BOOM, livingEntity.getX(), livingEntity.getY() + (livingEntity.getBbHeight() / 2), livingEntity.getZ(), 1, 0.0, 0.0, 0.0, 0.0);}

            });
            alliedTo.forEach(ally -> {
                ally.heal(2.0F * power * this.getTier().getAttackDamageBonus() / 2);
            });


            pLevel.playSound(null, pLivingEntity.getOnPos().above(), SoundEvents.BELL_RESONATE, SoundSource.PLAYERS, 2.0F, 0.2F);
            pLevel.playSound(null, pLivingEntity.getOnPos().above(), SoundEvents.BELL_BLOCK, SoundSource.PLAYERS, 3.0F, 0.5F);

            pStack.hurtAndBreak(1, pLivingEntity, (entity) -> {
                entity.broadcastBreakEvent(pLivingEntity.getUsedItemHand());
            });
            consumeMana((Player) pLivingEntity, (int) (6 * power));

            super.releaseUsing(pStack, pLevel, pLivingEntity, pTimeCharged);
        }
    }

    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if (pRemainingUseDuration % 30 == 0){
            pLevel.addParticle(ParticleTypes.ENCHANT,pLivingEntity.getX() + pLevel.random.nextFloat(),pLivingEntity.getY() + pLivingEntity.getBbHeight()/2,pLivingEntity.getX() + pLevel.random.nextFloat(),0.0F,0.5F,1.0F);
        }

        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
    }


    @Override
    public boolean canContinueUsing(ItemStack oldStack, ItemStack newStack) {
        return true;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BRUSH;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (pStack.getItem() instanceof BellItem bellItem) {
            pTooltipComponents.add(Component.translatable("yoamod.bell.damage_max").append(": " + (2.0F + 8.0F * bellItem.getTier().getAttackDamageBonus())).withStyle(ChatFormatting.GOLD));
            pTooltipComponents.add(Component.translatable("yoamod.bell.damage_min").append(": " + (1.0F + 2.0F * bellItem.getTier().getAttackDamageBonus())).withStyle(ChatFormatting.RED));
            pTooltipComponents.add(Component.translatable("yoamod.bell.healing").append(": " + (2.0F * bellItem.getTier().getAttackDamageBonus() / 2)).withStyle(ChatFormatting.GREEN));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

}
