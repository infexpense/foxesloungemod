package com.fuyuvulpes.yoamod.world.item.weaponry;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HolyRifleItem extends TieredItem implements Vanishable {
    public HolyRifleItem(Tier tier, Properties pProperties) {
        super(tier,pProperties);
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
