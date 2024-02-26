package com.fuyuvulpes.yoamod.custom.item;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class ModSmithingTemplateItem extends SmithingTemplateItem {
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final Component INGREDIENTS_TITLE = Component.translatable(
                    Util.makeDescriptionId("item", new ResourceLocation("smithing_template.ingredients"))
            )
            .withStyle(TITLE_FORMAT);
    private static final Component ADAMANTITE_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("adamantite_upgrade")))
            .withStyle(TITLE_FORMAT);
    private static final Component ADAMANTITE_UPGRADE_APPLIES_TO = Component.translatable(
                    Util.makeDescriptionId("item", new ResourceLocation("smithing_template.adamantite_upgrade.applies_to"))
            )
            .withStyle(DESCRIPTION_FORMAT);
    private static final Component ADAMANTITE_UPGRADE_INGREDIENTS = Component.translatable(
                    Util.makeDescriptionId("item", new ResourceLocation("smithing_template.adamantite_upgrade.ingredients"))
            )
            .withStyle(DESCRIPTION_FORMAT);
    private static final Component ADAMANTITE_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", new ResourceLocation("smithing_template.adamantite_upgrade.base_slot_description"))
    );
    private static final Component ADAMANTITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", new ResourceLocation("smithing_template.adamantite_upgrade.additions_slot_description"))
    );

    private static final ResourceLocation EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = new ResourceLocation("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = new ResourceLocation("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_HOE = new ResourceLocation("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = new ResourceLocation("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = new ResourceLocation("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = new ResourceLocation("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = new ResourceLocation("item/empty_slot_pickaxe");
    private static final ResourceLocation EMPTY_SLOT_INGOT = new ResourceLocation("item/empty_slot_ingot");
    private final boolean isItemFoil;

    public ModSmithingTemplateItem(Component pAppliesTo, Component pIngredients, Component pUpdradeDescription, Component pBaseSlotDescription, Component pAdditionsSlotDescription, List<ResourceLocation> pBaseSlotEmptyIcons, List<ResourceLocation> pAdditonalSlotEmptyIcons,boolean isFoil) {
        super(pAppliesTo, pIngredients, pUpdradeDescription, pBaseSlotDescription, pAdditionsSlotDescription, pBaseSlotEmptyIcons, pAdditonalSlotEmptyIcons);
        this.isItemFoil = isFoil;
    }


    public static SmithingTemplateItem createAdamantiteUpgradeTemplate() {
        return new ModSmithingTemplateItem(
                ADAMANTITE_UPGRADE_APPLIES_TO,
                ADAMANTITE_UPGRADE_INGREDIENTS,
                ADAMANTITE_UPGRADE,
                ADAMANTITE_UPGRADE_BASE_SLOT_DESCRIPTION,
                ADAMANTITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createAdamantiteUpgradeIconList(),
                createAdamantiteUpgradeMaterialList(),
                true
        );
    }
    private static List<ResourceLocation> createAdamantiteUpgradeIconList() {
        return List.of(
                EMPTY_SLOT_HELMET,
                EMPTY_SLOT_SWORD,
                EMPTY_SLOT_CHESTPLATE,
                EMPTY_SLOT_PICKAXE,
                EMPTY_SLOT_LEGGINGS,
                EMPTY_SLOT_AXE,
                EMPTY_SLOT_BOOTS,
                EMPTY_SLOT_HOE,
                EMPTY_SLOT_SHOVEL
        );
    }
    private static List<ResourceLocation> createAdamantiteUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return this.isItemFoil || super.isFoil(pStack);
    }
}
