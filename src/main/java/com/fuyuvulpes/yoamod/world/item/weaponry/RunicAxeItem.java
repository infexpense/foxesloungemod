package com.fuyuvulpes.yoamod.world.item.weaponry;

import com.fuyuvulpes.yoamod.world.item.AttackAnim;
import com.fuyuvulpes.yoamod.world.item.AttackAnims;
import com.fuyuvulpes.yoamod.world.item.WeaponItem;
import com.fuyuvulpes.yoamod.world.item.WeaponStats;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RunicAxeItem extends WeaponItem {
    public RunicAxeItem(Tier tier, Properties properties) {
        super(tier, WeaponStats.RUNIC_AXE, properties);
    }

    @Override
    public AttackAnim getAttackAnimation(ItemStack itemStack) {
        return AttackAnims.SLAM;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.literal("NOT FUNCTIONAL YET")
                .withStyle(ChatFormatting.RED)
                .withStyle(ChatFormatting.ITALIC)
                .withStyle(ChatFormatting.BOLD));

        pTooltipComponents.add(Component.literal("SORRY :(")
                .withStyle(ChatFormatting.RED)
                .withStyle(ChatFormatting.ITALIC)
                .withStyle(ChatFormatting.BOLD));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }


}
