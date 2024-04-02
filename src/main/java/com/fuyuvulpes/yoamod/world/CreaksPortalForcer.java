package com.fuyuvulpes.yoamod.world;


import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.TicketType;
import net.minecraft.util.Mth;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.util.ITeleporter;


import org.apache.logging.log4j.core.jmx.Server;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class CreaksPortalForcer implements ITeleporter {

    protected final ServerLevel level;

    public CreaksPortalForcer(ServerLevel level) {
        this.level = level;
    }


    @Override
    public @Nullable PortalInfo getPortalInfo(Entity entity, ServerLevel destWorld, Function<ServerLevel, PortalInfo> defaultPortalInfo) {


        if (destWorld.dimension().equals(Level.OVERWORLD)){
            BlockPos pos = entity instanceof ServerPlayer player ? player.getRespawnPosition() : destWorld.getSharedSpawnPos();
            BlockPos pos1 = pos == null ? destWorld.getSharedSpawnPos().above() : pos.above();
            return new PortalInfo(pos1.getCenter(), Vec3.ZERO, entity.getYRot(), entity.getXRot());
        }

        return new PortalInfo(this.checkPositionsForInitialSpawn(destWorld, entity.blockPosition()).getCenter(), Vec3.ZERO, entity.getYRot(), entity.getXRot());
    }

    @Override
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {

        entity.fallDistance = 0;
        return repositionEntity.apply(false);
    }

    @Override
    public boolean playTeleportSound(ServerPlayer player, ServerLevel sourceWorld, ServerLevel destWorld) {
        return false;
    }

    private BlockPos checkPositionsForInitialSpawn(Level level, BlockPos origin) {
        if (!this.isSafe(level, origin)) {
            for (int i = 0; i <= 1000; i +=10) {
                for (Direction facing : Direction.Plane.HORIZONTAL) {
                    BlockPos offsetPosition = origin.offset(facing.getNormal().multiply(i));
                    if (this.isSafeAround(level, offsetPosition)) {
                        return offsetPosition;
                    }
                    for (int y = 0; y < 319; y++){
                        BlockPos newPos = offsetPosition.atY(y);
                        if (this.isSafeAround(level,newPos)){
                            return newPos;
                        }
                    }

                }
            }
            return origin;
        }
        return origin;
    }
    public boolean isSafeAround(Level level, BlockPos pos) {
        BlockPos belowPos = pos.below();
        if (!this.isSafe(level, belowPos)) {
            return false;
        }
        for (Direction facing : Direction.Plane.HORIZONTAL) {
            if (!this.isSafe(level, belowPos.relative(facing, 2))) {
                return false;
            }
        }
        return true;
    }

    private boolean isSafe(Level level, BlockPos pos) {
        return level.getWorldBorder().isWithinBounds(pos) && !level.getBlockState(pos).isAir() && level.getBlockState(pos.above()).isAir() && level.getBlockState(pos.above(2)).isAir();
    }
}
