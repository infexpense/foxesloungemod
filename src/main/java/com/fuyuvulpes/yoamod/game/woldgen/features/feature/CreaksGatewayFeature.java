package com.fuyuvulpes.yoamod.game.woldgen.features.feature;

import com.fuyuvulpes.yoamod.core.registries.YoaBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class CreaksGatewayFeature extends Feature<NoneFeatureConfiguration> {
    public CreaksGatewayFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        BlockPos blockpos = pContext.origin();
        WorldGenLevel worldgenlevel = pContext.level();

        if (!worldgenlevel.getBlockState(blockpos).isAir()
                || !worldgenlevel.getBlockState(blockpos.above()).isAir()
                || !worldgenlevel.getBlockState(blockpos.below()).isAir()
                || BlockPos.betweenClosedStream(blockpos.below(12), blockpos.below(3)).anyMatch(blockPos -> worldgenlevel.getBlockState(blockPos).is(YoaBlocks.CREAKSTONE.get()))
        ){
            return false;

        }

        for(BlockPos blockpos1 : BlockPos.betweenClosed(blockpos.offset(-1, -3, -1), blockpos.offset(1, 3, 1))) {
            boolean flag = blockpos1.getX() == blockpos.getX();
            boolean flag1 = Math.abs(blockpos1.getY() - blockpos.getY()) < 2;
            boolean flag2 = blockpos1.getZ() == blockpos.getZ();
            boolean flag3 = Math.abs(blockpos1.getY() - blockpos.getY()) > 2;
            boolean flag4 = Math.abs(blockpos1.getY() - blockpos.getY()) >= 2;
            if (flag && flag1 && flag2) {
                BlockPos blockpos2 = blockpos1.immutable();
                this.setBlock(worldgenlevel, blockpos2, YoaBlocks.CREAKS_PORTAL.get().defaultBlockState());
            } else if (flag1 && !flag3) {
                this.setBlock(worldgenlevel, blockpos1, Blocks.AIR.defaultBlockState());
            } else if (flag4 && flag && flag2) {
                this.setBlock(worldgenlevel, blockpos1, Blocks.BEDROCK.defaultBlockState());
            } else if (flag2 && flag4) {
                this.setBlock(worldgenlevel, blockpos1, Blocks.BEDROCK.defaultBlockState());
            } else if (flag && flag4) {
                this.setBlock(worldgenlevel, blockpos1, Blocks.BEDROCK.defaultBlockState());
            } else {
                this.setBlock(worldgenlevel, blockpos1, Blocks.AIR.defaultBlockState());
            }
        }

        return true;
    }


}
