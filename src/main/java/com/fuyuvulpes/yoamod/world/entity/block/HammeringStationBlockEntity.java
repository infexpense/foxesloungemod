package com.fuyuvulpes.yoamod.world.entity.block;

import com.fuyuvulpes.yoamod.core.registries.BlockEntitiesModReg;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class HammeringStationBlockEntity extends BlockEntity implements MenuProvider {
    public HammeringStationBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(BlockEntitiesModReg.HAMMERING_STATION.get(), p_155229_, p_155230_);
    }

    @Override
    public Component getDisplayName() {
        return null;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return null;
    }
}
