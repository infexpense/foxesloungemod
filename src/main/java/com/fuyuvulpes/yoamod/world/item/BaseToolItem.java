package com.fuyuvulpes.yoamod.world.item;

import net.minecraft.world.item.*;

import java.util.UUID;

public class BaseToolItem extends TieredItem implements Vanishable {

    protected static final UUID BASE_ENTITY_REACH_UUID = UUID.fromString("4d110acd-e692-47af-a847-467bffa9f2c0");
    protected static final UUID BASE_ENTITY_GRAVITY_UUID = UUID.fromString("f3b17265-38b7-499f-b95c-8234a14366bd");
    protected static final UUID BASE_MOVEMENT_SPEED_UUID = UUID.fromString("4d10359a-d039-4e5c-a50f-ba38edb31fa0");

    private final Tier tier;


    public BaseToolItem(Tier tier, Properties properties) {
        super(tier,properties);
        this.tier = tier;
    }

    public Tier getTier() {
        return this.tier;
    }

    @Override
    public int getEnchantmentValue() {
        return this.tier.getEnchantmentValue();
    }

    @Override
    public boolean isValidRepairItem(ItemStack p_43311_, ItemStack p_43312_) {
        return this.tier.getRepairIngredient().test(p_43312_) || super.isValidRepairItem(p_43311_, p_43312_);
    }
}
