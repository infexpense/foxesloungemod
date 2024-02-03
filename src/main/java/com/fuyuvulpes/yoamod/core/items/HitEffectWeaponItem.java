package com.fuyuvulpes.yoamod.core.items;

import com.fuyuvulpes.yoamod.registries.ModEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.neoforged.fml.common.Mod;

public class HitEffectWeaponItem extends WeaponItem {

    public final MobEffect effect;
    public final float chance;
    public final Boolean canBleed;
    public final float bleedChance;



    public HitEffectWeaponItem(Tier tier, WeaponStat weapon, Properties properties, MobEffect effect, float chance, Boolean canBleed, float bleedChance) {
        super(tier, weapon, properties);
        this.effect = effect;
        this.chance = chance;
        this.canBleed = canBleed;
        this.bleedChance = bleedChance;
    }


    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, p_43296_ -> p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        if (canBleed && pAttacker.level().random.nextFloat() < bleedChance * 2){
            pTarget.addEffect(new MobEffectInstance(ModEffects.BLEEDING.get(),140,0,false,true));
        }
        if (effect != null && pAttacker.level().random.nextFloat() < chance * 2) {
            pTarget.addEffect(new MobEffectInstance(effect,40,0,false,false));
        }
        return true;
    }
}