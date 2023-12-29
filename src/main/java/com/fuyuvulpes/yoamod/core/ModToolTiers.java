package com.fuyuvulpes.yoamod.core;

import com.fuyuvulpes.yoamod.YOAMod;
import com.fuyuvulpes.yoamod.registries.ItemsModReg;
import com.fuyuvulpes.yoamod.registries.TagRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.TierSortingRegistry;

import java.util.List;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class ModToolTiers {

    public static final Tier BRONZE = TierSortingRegistry.registerTier(
            new SimpleTier(1,152,5.0F,1.2F,8, TagRegistry.Blocks.NEEDS_BRONZE_TOOL,() -> Ingredient.of(ItemsModReg.EXAMPLE_ITEM.get()))
            ,new ResourceLocation(MODID,"bronze"), List.of(Tiers.STONE),List.of());

    public static final Tier SILVER = TierSortingRegistry.registerTier(
            new SimpleTier(1,200,5.5F,1.6F,10, TagRegistry.Blocks.NEEDS_SILVER_TOOL,() -> Ingredient.of(ItemsModReg.EXAMPLE_ITEM.get()))
            ,new ResourceLocation(MODID,"silver"), List.of(ModToolTiers.BRONZE),List.of(Tiers.IRON));

    public static final Tier STEEL = TierSortingRegistry.registerTier(
            new SimpleTier(2,152,5.0F,1.2F,5, TagRegistry.Blocks.NEEDS_STEEL_TOOL,() -> Ingredient.of(ItemsModReg.EXAMPLE_ITEM.get()))
            ,new ResourceLocation(MODID,"steel"), List.of(Tiers.IRON),List.of());

    public static final Tier BISMUTH = TierSortingRegistry.registerTier(
            new SimpleTier(2,152,5.0F,1.2F,5, TagRegistry.Blocks.NEEDS_BISMUTH_TOOL,() -> Ingredient.of(ItemsModReg.EXAMPLE_ITEM.get()))
            ,new ResourceLocation(MODID,"bismuth"), List.of(ModToolTiers.STEEL),List.of(Tiers.DIAMOND));

    public static final Tier TITANIUM = TierSortingRegistry.registerTier(
            new SimpleTier(5,152,5.0F,1.2F,5, TagRegistry.Blocks.NEEDS_TITANIUM_TOOL,() -> Ingredient.of(ItemsModReg.EXAMPLE_ITEM.get()))
            ,new ResourceLocation(MODID,"titanium"), List.of(Tiers.NETHERITE),List.of());

    public static final Tier IOLITE = TierSortingRegistry.registerTier(
            new SimpleTier(6,152,5.0F,1.2F,5, TagRegistry.Blocks.NEEDS_IOLITE_TOOL,() -> Ingredient.of(ItemsModReg.EXAMPLE_ITEM.get()))
            ,new ResourceLocation(MODID,"iolite"), List.of(ModToolTiers.TITANIUM),List.of());

    public static final Tier ALEXANDRITE = TierSortingRegistry.registerTier(
            new SimpleTier(7,152,5.0F,1.2F,5, TagRegistry.Blocks.NEEDS_ALEXANDRITE_TOOL,() -> Ingredient.of(ItemsModReg.EXAMPLE_ITEM.get()))
            ,new ResourceLocation(MODID,"alexandrite"), List.of(ModToolTiers.IOLITE),List.of());

    public static final Tier ADAMANTITE = TierSortingRegistry.registerTier(
            new SimpleTier(8,152,5.0F,1.2F,5, TagRegistry.Blocks.NEEDS_ADAMANTITE_TOOL,() -> Ingredient.of(ItemsModReg.EXAMPLE_ITEM.get()))
            ,new ResourceLocation(MODID,"adamantite"), List.of(ModToolTiers.ALEXANDRITE),List.of());
}
