package com.fuyuvulpes.yoamod.world.item.weaponry;

import com.fuyuvulpes.yoamod.world.entity.projectile.ChakramEntity;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.level.Level;

public class ChakramItem extends TieredItem implements Vanishable {
    public ChakramItem(Tier tier, Properties pProperties) {
        super(tier,pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player player, InteractionHand pUsedHand) {
        ItemStack stack = player.getItemInHand(pUsedHand);

        ChakramEntity chakram = new ChakramEntity(pLevel,stack,player);
        if (pLevel instanceof ServerLevel ){
            double d0 = (double)(-Mth.sin(player.getYRot() * (float) (Math.PI / 180.0)));
            double d1 = (double)Mth.cos(player.getYRot() * (float) (Math.PI / 180.0));
            ((ServerLevel)pLevel).sendParticles(ParticleTypes.SWEEP_ATTACK, player.getX() + d0, player.getY(0.5), player.getZ() + d1, 0, d0, 0.0, d1, 0.0);
        }

        stack.hurtAndBreak(1, player, (pPlayer) -> {
            pPlayer.broadcastBreakEvent(player.getUsedItemHand());
        });

        chakram.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.0F, 0.2F);

        pLevel.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.PLAYERS, 0.4F, 5.0F / (pLevel.getRandom().nextFloat() * 0.3F + 0.5F));

        player.getCooldowns().addCooldown(stack.getItem(), (int) (500 / this.getTier().getSpeed()));

        pLevel.addFreshEntity(chakram);

        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.success(stack);
    }
}
