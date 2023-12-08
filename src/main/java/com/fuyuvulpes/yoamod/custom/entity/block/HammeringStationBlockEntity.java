package com.fuyuvulpes.yoamod.custom.entity.block;

import com.fuyuvulpes.yoamod.registries.BlockEntitiesModReg;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class HammeringStationBlockEntity extends BlockEntity {
    public HammeringStationBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(BlockEntitiesModReg.HAMMERING_STATION.get(), p_155229_, p_155230_);
    }
}
