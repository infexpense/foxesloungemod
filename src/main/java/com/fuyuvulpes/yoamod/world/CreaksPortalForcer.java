package com.fuyuvulpes.yoamod.world;

import com.fuyuvulpes.yoamod.game.woldgen.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.util.ITeleporter;

import java.util.function.Function;

public class CreaksPortalForcer implements ITeleporter {

    protected final ServerLevel level;

    public CreaksPortalForcer(ServerLevel level) {
        this.level = level;
    }


    @Override
    public boolean playTeleportSound(ServerPlayer player, ServerLevel sourceWorld, ServerLevel destWorld) {
        return false;
    }
}
