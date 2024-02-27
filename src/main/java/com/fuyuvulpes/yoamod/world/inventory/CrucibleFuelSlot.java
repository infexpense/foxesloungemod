package com.fuyuvulpes.yoamod.world.inventory;

import com.fuyuvulpes.yoamod.game.client.screens.CrucibleMenu;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class CrucibleFuelSlot extends Slot {
    private final CrucibleMenu menu;
    public CrucibleFuelSlot(CrucibleMenu menu, Container pContainer, int pSlot, int pX, int pY) {
        super(pContainer, pSlot, pX, pY);
        this.menu = menu;
    }

    @Override
    public boolean mayPlace(ItemStack pStack) {
        return this.menu.isFuel(pStack);
    }

    @Override
    public int getMaxStackSize(ItemStack pStack) {
        return super.getMaxStackSize(pStack);
    }

}
