package com.fuyuvulpes.yoamod.world.item;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Vanishable;

import java.util.function.Predicate;

public abstract class YoaBow extends ProjectileWeaponItem implements Vanishable {

    public final int drawLimit;
    public final int baseRange;

    public YoaBow(Properties pProperties, int drawLimit, int baseRange) {
        super(pProperties);
        this.drawLimit = drawLimit;
        this.baseRange = baseRange;
    }
    public static float getPowerForTime(int pCharge) {
        float f = (float)pCharge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }


    @Override
    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }


    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.CUSTOM;
    }


    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }


    @Override
    public int getDefaultProjectileRange() {
        return baseRange;
    }

    public AbstractArrow customArrow(AbstractArrow arrow) {
        return arrow;
    }
}
