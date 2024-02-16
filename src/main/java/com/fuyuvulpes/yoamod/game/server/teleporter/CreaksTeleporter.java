package com.fuyuvulpes.yoamod.game.server.teleporter;

import com.fuyuvulpes.yoamod.custom.block.CreaksGateBlock;
import com.fuyuvulpes.yoamod.game.woldgen.ModDimensions;
import com.fuyuvulpes.yoamod.registries.BlocksModReg;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.util.ITeleporter;

import java.util.function.Function;

public class CreaksTeleporter implements ITeleporter {
    public static BlockPos thisPos;
    public static boolean insideDimension;

    public CreaksTeleporter(BlockPos pos, boolean insideDim) {
        thisPos = pos;
        insideDimension = insideDim;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destinationWorld,
                              float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(false);
        int y = 61;

        if (!insideDimension) {
            y = thisPos.getY();
        }

        BlockPos destinationPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());

        int tries = 0;
        while ((destinationWorld.getBlockState(destinationPos).getBlock() != Blocks.AIR) &&
                !destinationWorld.getBlockState(destinationPos).canBeReplaced(Fluids.WATER) &&
                (destinationWorld.getBlockState(destinationPos.above()).getBlock()  != Blocks.AIR) &&
                !destinationWorld.getBlockState(destinationPos.above()).canBeReplaced(Fluids.WATER) && (tries < 80)) {
            destinationPos = destinationPos.above(2);
            tries++;
        }

        if (insideDimension && entity instanceof ServerPlayer player){
            destinationPos = player.getRespawnPosition();
            if (destinationPos == null){
                destinationPos = new BlockPos(0,64,0);
            }

        }


        if (destinationWorld.dimension() == ModDimensions.THE_CREAKS_LEVEL_KEY) {


            for (BlockPos fillPos : BlockPos.betweenClosed(destinationPos.west(3).south(3), destinationPos.above(3).north(3).east(3))) {
                destinationWorld.setBlock(fillPos, Blocks.AIR.defaultBlockState(), 35);
            }
            for (BlockPos platformPos : BlockPos.betweenClosed(destinationPos.below().west(3).north(3), destinationPos.below().east(3).south(3))) {
                destinationWorld.setBlock(platformPos, Blocks.OBSIDIAN.defaultBlockState(), 3);


            }

            destinationWorld.setBlock(destinationPos.east(), Blocks.LANTERN.defaultBlockState(), 3);
        }

        entity.resetFallDistance();
        entity.invulnerableTime = 10;
        entity.setPos(destinationPos.getX(), destinationPos.getY() + 6, destinationPos.getZ());
        return entity;
    }
}
