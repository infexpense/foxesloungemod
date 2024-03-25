package com.fuyuvulpes.yoamod.world.entity.block;

import com.fuyuvulpes.yoamod.core.registries.YoaBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CreaksPortalBlockEntity extends BlockEntity {


    public CreaksPortalBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(YoaBlockEntities.CREAKS_PORTAL.get(), pPos, pBlockState);
    }


    public boolean shouldRenderFace(Direction pFace) {
        return Block.shouldRenderFace(this.getBlockState(), this.level, this.getBlockPos(), pFace, this.getBlockPos().relative(pFace));
    }

}
