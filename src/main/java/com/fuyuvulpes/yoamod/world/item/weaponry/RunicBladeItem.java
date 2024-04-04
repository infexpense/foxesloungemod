package com.fuyuvulpes.yoamod.world.item.weaponry;

import com.fuyuvulpes.yoamod.world.item.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class RunicBladeItem extends WeaponItem implements IManaConsumingWeapon {
    public RunicBladeItem(Tier tier, Properties properties) {
        super(tier, WeaponStats.RUNIC_BLADE, properties);
    }

    @Override
    public AttackAnim getAttackAnimation(ItemStack itemStack) {
        return AttackAnims.SWING;
    }

    @Override
    public boolean hurtEnemy(ItemStack p_43278_, LivingEntity entity, LivingEntity attacker) {
        if (attacker instanceof Player player &&  canConsumeMana(player,10)){
            entity.hurt(attacker.damageSources().magic(),3 * this.getTier().getAttackDamageBonus());
            consumeMana(player,10);
            Level level = attacker.level();
            ((ServerLevel)level).sendParticles(ParticleTypes.SONIC_BOOM, entity.getX(), entity.getY() + (entity.getBbHeight() / 2), entity.getZ(), 1, 0.0, 0.0, 0.0, 0.3);
            level.playSound(null,entity.getOnPos().above(), SoundEvents.PLAYER_HURT_FREEZE, SoundSource.PLAYERS);
        }
        return super.hurtEnemy(p_43278_, entity, attacker);
    }
}
