package com.fuyuvulpes.yoamod.world.item.weaponry;

import com.fuyuvulpes.yoamod.world.entity.projectile.ChakramEntity;
import com.fuyuvulpes.yoamod.world.entity.projectile.HarpoonEntity;
import com.fuyuvulpes.yoamod.world.item.AttackAnim;
import com.fuyuvulpes.yoamod.world.item.AttackAnims;
import com.fuyuvulpes.yoamod.world.item.WeaponItem;
import com.fuyuvulpes.yoamod.world.item.WeaponStats;
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
import net.minecraft.world.level.Level;

public class HarpoonItem extends WeaponItem {
    public HarpoonItem(Tier tier, Properties properties) {
        super(tier, WeaponStats.HARPOON, properties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player player, InteractionHand pUsedHand) {
        ItemStack stack = player.getItemInHand(pUsedHand);

        HarpoonEntity harpoon = new HarpoonEntity(pLevel,stack,player);


        stack.hurtAndBreak(1, player, (pPlayer) -> {
            pPlayer.broadcastBreakEvent(player.getUsedItemHand());
        });

        harpoon.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.8F, 0.0F);

        pLevel.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 0.4F, 5.0F / (pLevel.getRandom().nextFloat() * 0.3F + 0.5F));

        player.getCooldowns().addCooldown(stack.getItem(), (int) (1000 / this.getTier().getSpeed()));

        pLevel.addFreshEntity(harpoon);
        if (!player.getAbilities().instabuild) {
            player.getInventory().removeItem(stack);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.success(stack);
    }

    @Override
    public AttackAnim getAttackAnimation(ItemStack itemStack) {
        return AttackAnims.STAB;
    }
}
