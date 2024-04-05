package com.fuyuvulpes.yoamod.world.item.weaponry;

import com.fuyuvulpes.yoamod.world.entity.projectile.ChakramEntity;
import com.fuyuvulpes.yoamod.world.entity.projectile.ShurikenEntity;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class ShurikenItem extends TieredItem implements Vanishable {
    public ShurikenItem(Tier tier, Properties pProperties) {
        super(tier,pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player player, InteractionHand pUsedHand) {
        ItemStack stack = player.getItemInHand(pUsedHand);

        ShurikenEntity shuriken = new ShurikenEntity(pLevel,stack,player);

        stack.hurtAndBreak(1, player, (pPlayer) -> {
            pPlayer.broadcastBreakEvent(player.getUsedItemHand());
        });

        shuriken.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.3F, 0.2F);

        pLevel.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.PLAYERS, 0.4F, 5.0F / (pLevel.getRandom().nextFloat() * 0.3F + 0.5F));

        player.getCooldowns().addCooldown(stack.getItem(), (int) (140 / this.getTier().getSpeed()));

        pLevel.addFreshEntity(shuriken);

        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.success(stack);
    }

}
