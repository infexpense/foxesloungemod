package com.fuyuvulpes.yoamod.world.inventory;

import com.fuyuvulpes.yoamod.world.entity.block.CrucibleBlockEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class HammeringStationResultSlot extends Slot {

    private final Player player;
    private int removeCount;
    public  HammeringStationResultSlot(Player player, Container pContainer, int pSlot, int pX, int pY) {
        super(pContainer, pSlot, pX, pY);
        this.player = player;
    }

    @Override
    public boolean mayPlace(ItemStack pStack){return false;}

    @Override
    public ItemStack remove(int pAmount){
        if (this.hasItem()) {
            this.removeCount += Math.min(pAmount, this.getItem().getCount());
        }
        return super.remove(pAmount);
    }

    @Override
    public void onTake(Player pPlayer, ItemStack pStack) {
        this.checkTakeAchievements(pStack);
        super.onTake(pPlayer, pStack);
    }

    @Override
    protected void onQuickCraft(ItemStack pStack, int pAmount) {
        this.removeCount =+ pAmount;
        this.checkTakeAchievements(pStack);
    }

    @Override
    protected void checkTakeAchievements(ItemStack pStack) {
        pStack.onCraftedBy(this.player.level(), this.player, this.removeCount);
        Player playerx = this.player;
        if (playerx instanceof ServerPlayer serverplayer) {
            Container container = this.container;
            if (container instanceof CrucibleBlockEntity crucibleBlockEntity) {
                crucibleBlockEntity.awardUsedRecipesAndPopExperience(serverplayer);
            }
        }

        this.removeCount = 0;
    }
}
