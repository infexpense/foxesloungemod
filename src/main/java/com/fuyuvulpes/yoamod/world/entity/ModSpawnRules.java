package com.fuyuvulpes.yoamod.world.entity;

import com.fuyuvulpes.yoamod.game.woldgen.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ServerLevelAccessor;

import static net.minecraft.world.entity.Mob.checkMobSpawnRules;

public class ModSpawnRules {

    public static boolean slimeCreaksSpawnRules(
            EntityType<? extends Mob> pType, ServerLevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom
    ) {
        return pLevel.getDifficulty() != Difficulty.PEACEFUL
                && checkMobSpawnRules(pType, pLevel, pSpawnType, pPos, pRandom) && pLevel.getLevel().dimension() == ModDimensions.THE_CREAKS;

    }
}
