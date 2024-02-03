package com.fuyuvulpes.yoamod.core.items;

import com.fuyuvulpes.yoamod.core.AttackAnim;
import com.fuyuvulpes.yoamod.core.AttackAnimEnum;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.ToolAction;
import net.neoforged.neoforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class WeaponItem extends BaseToolItem{
    private final float attackDamage;
    private Multimap<Attribute, AttributeModifier> defaultModifiers;
    private final WeaponStat weapon;

    public WeaponItem(Tier tier, WeaponStat weapon, Properties properties) {
        super(tier,properties);
        this.attackDamage = (float)(weapon.attackDmg() * tier.getLevel()) + tier.getAttackDamageBonus();
        this.weapon = weapon;
    }



    public AttackAnim getAttackAnimation(ItemStack itemStack){
        return AttackAnimEnum.STAB;
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
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {


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
        defaultModifiers = builder.build();

        return slot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
    }



    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public boolean applyForgeHandTransform(PoseStack poseStack, LocalPlayer player, HumanoidArm arm, ItemStack item, float partialTick, float equipProcess, float swingProcess) {
                int i = arm == HumanoidArm.RIGHT ? 1 : -1;
                if (player.swinging) {
                    if (getAttackAnimation(item) == AttackAnimEnum.STAB) {
                        float stabPos = swingProcess <= 0.36 ? (float) Math.pow(7, swingProcess) : (float) (1 - Math.pow(swingProcess, 2));
                        poseStack.translate(0.1, -0.52, -0.52 - stabPos);
                        poseStack.mulPose(Axis.YP.rotationDegrees(110.0F));
                        poseStack.mulPose(Axis.XP.rotationDegrees(0.0F));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-90.0F));
                        poseStack.scale(1.5F, 1.5F, 1.5F);
                        return true;
                    } else if (getAttackAnimation(item) == AttackAnimEnum.SWING) {
                        float swing_pos = (1 - (2 * swingProcess)) * i;
                        float swing_angle = (-90 + (220 * (float) Math.pow(swingProcess, 2))) * i;
                        poseStack.translate(swing_pos, -0.52, -1.52);
                        poseStack.mulPose(Axis.YP.rotationDegrees(110.0F + swing_angle));
                        poseStack.mulPose(Axis.XP.rotationDegrees(arm == HumanoidArm.RIGHT ? 0.0F : 180.0F));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-90.0F));
                        poseStack.scale(1.5F, 1.5F, 1.5F);
                        return true;
                    } else if (getAttackAnimation(item) == AttackAnimEnum.SLAM) {
                        float slamPos = (1.50F - (1 * swingProcess));
                        float slamAngle = -30.0F + -50.0F * swingProcess;
                        poseStack.translate(i * 0.1, -0.52 + slamPos, -0.52);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0.0F));
                        poseStack.mulPose(Axis.XP.rotationDegrees(slamAngle));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(0.0F));
                    }
                }

                return false;
            }


        });
    }
}
