package com.fuyuvulpes.yoamod.world.item;

import com.fuyuvulpes.yoamod.core.registries.ItemsModReg;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public enum ModArmorMats  implements ArmorMaterial {
    SILVER("silver", 12, new int[]{2, 4, 3, 1}, 4, SoundEvents.ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.of(ItemsModReg.WITHERITE.get())),
    WITHERITE("witherite", 41, new int[]{5,10,8,4}, 14, SoundEvents.ARMOR_EQUIP_GOLD, 2.0f, 0.05f, () -> Ingredient.of(ItemsModReg.SILVER_INGOT.get())),
    IOLITE("iolite", 60, new int[]{6,13,10,6}, 27, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0f, 0.0f, () -> Ingredient.of(ItemsModReg.IOLITE.get())),
    ALEXANDRITE("alexandrite", 78, new int[]{9,15,12,7}, 18, SoundEvents.ARMOR_EQUIP_DIAMOND, 4.0f, 0.05f, () -> Ingredient.of(ItemsModReg.ALEXANDRITE.get())),
    ADAMANTITE("adamantite", 106, new int[]{12,18,15,10}, 24, SoundEvents.ARMOR_EQUIP_NETHERITE, 5.0f, 0.2f, () -> Ingredient.of(ItemsModReg.ADAMANTITE_INGOT.get()))

;
    private final String name;
    private final int durabilityMultplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 15, 13};

    ModArmorMats(String name, int durabilityMultplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultplier = durabilityMultplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }
    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
