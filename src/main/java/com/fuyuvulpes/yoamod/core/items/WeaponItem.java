package com.fuyuvulpes.yoamod.core.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.common.NeoForgeMod;

public class WeaponItem extends BaseToolItem{

    private final float attackDamage;
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    public WeaponItem(Tier tier, WeaponStat weapon, Properties properties) {
        super(tier,properties);
        this.attackDamage = (float)(weapon.attackDmg() * tier.getLevel()) + tier.getAttackDamageBonus();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION)
        );
        builder.put(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)weapon.attackSpeed(), AttributeModifier.Operation.ADDITION)
        );
        builder.put(
                NeoForgeMod.ENTITY_REACH.value(),
                new AttributeModifier(BASE_ENTITY_REACH_UUID, "Weapon modifier", (double)weapon.range(), AttributeModifier.Operation.ADDITION)
        );
        if (weapon.isAgile()){
            builder.put(
                    NeoForgeMod.ENTITY_GRAVITY.value(),
                    new AttributeModifier(BASE_ENTITY_GRAVITY_UUID, "Weapon modifier", -0.2D, AttributeModifier.Operation.MULTIPLY_BASE)

            );
            builder.put(
                    Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(BASE_MOVEMENT_SPEED_UUID, "Weapon modifier", 0.5D, AttributeModifier.Operation.MULTIPLY_TOTAL)
            );
        }
        else if (weapon.isHeavy()){
            builder.put(
                    Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(BASE_MOVEMENT_SPEED_UUID, "Weapon modifier", -0.2D, AttributeModifier.Operation.MULTIPLY_TOTAL)
            );
        }
        this.defaultModifiers = builder.build();
    }



    public float getDamage() {
        return this.attackDamage;
    }

    @Override
    public boolean hurtEnemy(ItemStack p_43278_, LivingEntity p_43279_, LivingEntity p_43280_) {
        p_43278_.hurtAndBreak(1, p_43280_, p_43296_ -> p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        return true;
    }



    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot p_43274_) {
        return p_43274_ == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(p_43274_);
    }


    @Override
    public boolean canPerformAction(ItemStack stack, net.neoforged.neoforge.common.ToolAction toolAction) {
        return net.neoforged.neoforge.common.ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
    }



}
