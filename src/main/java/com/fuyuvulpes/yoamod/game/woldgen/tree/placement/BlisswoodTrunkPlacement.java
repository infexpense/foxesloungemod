package com.fuyuvulpes.yoamod.game.woldgen.tree.placement;

import com.fuyuvulpes.yoamod.core.registries.YoaPlacers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class BlisswoodTrunkPlacement extends TrunkPlacer {

    public static final Codec<BlisswoodTrunkPlacement> CODEC = RecordCodecBuilder.create(placement ->
            trunkPlacerParts(placement).and(
                            BlockStateProvider.CODEC.fieldOf("wood_provider")
                                    .forGetter(trunkPlacement -> trunkPlacement.woodProvider
                            )
                    )
                    .apply(placement, BlisswoodTrunkPlacement::new));

    public final BlockStateProvider woodProvider;


    public BlisswoodTrunkPlacement(int pBaseHeight, int pHeightRandA, int pHeightRandB, BlockStateProvider woodProvider) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
        this.woodProvider = woodProvider;
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return YoaPlacers.BLISSWOOD_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {
        int height = (int)( (pFreeTreeHeight + pRandom.nextInt(heightRandA,heightRandB) * Math.max(pRandom.nextFloat() - 0.1, 0.4)) * 0.6);
        List<FoliagePlacer.FoliageAttachment> attachments = new ArrayList<>();

        BlockPos blockpos = pPos.below();

        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos, pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos.east(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos.south(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos.south().east(), pConfig);
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int i = 0; i <= pFreeTreeHeight; ++i) {
            this.placeLogIfFreeWithOffset(pLevel, pBlockSetter, pRandom, blockpos$mutableblockpos, pConfig, pPos, 0, i, 0);
            if (i < pFreeTreeHeight - 1) {
                this.placeLogIfFreeWithOffset(pLevel, pBlockSetter, pRandom, blockpos$mutableblockpos, pConfig, pPos, 1, i, 0);
                this.placeLogIfFreeWithOffset(pLevel, pBlockSetter, pRandom, blockpos$mutableblockpos, pConfig, pPos, 1, i, 1);
                this.placeLogIfFreeWithOffset(pLevel, pBlockSetter, pRandom, blockpos$mutableblockpos, pConfig, pPos, 0, i, 1);
            }
        }


        attachments.addAll(generateBranch(pLevel,pBlockSetter,pRandom, (int) (pFreeTreeHeight * 0.75),pPos.above(height-3),pConfig,1,0,true));
        attachments.addAll(generateBranch(pLevel,pBlockSetter,pRandom, (int) (pFreeTreeHeight * 0.75),pPos.above(height-3),pConfig,0,1,true));

        attachments.addAll(generateBranch(pLevel,pBlockSetter,pRandom, (int) (pFreeTreeHeight * 0.75),pPos.above(height-3),pConfig,-1,0,true));
        attachments.addAll(generateBranch(pLevel,pBlockSetter,pRandom, (int) (pFreeTreeHeight * 0.75),pPos.above(height-3),pConfig,0,-1,true));


        attachments.addAll(generateBranch(pLevel,pBlockSetter,pRandom,pFreeTreeHeight/3,pPos.above(pFreeTreeHeight),pConfig,1,0,false));
        attachments.addAll(generateBranch(pLevel,pBlockSetter,pRandom,pFreeTreeHeight/3,pPos.above(pFreeTreeHeight),pConfig,0,1,false));

        attachments.addAll(generateBranch(pLevel,pBlockSetter,pRandom,pFreeTreeHeight/3,pPos.above(pFreeTreeHeight),pConfig,-1,0,false));
        attachments.addAll(generateBranch(pLevel,pBlockSetter,pRandom,pFreeTreeHeight/3,pPos.above(pFreeTreeHeight),pConfig,0,-1,false));



        return attachments;
    }



    private List<FoliagePlacer.FoliageAttachment> generateBranch(
            LevelSimulatedReader pLevel,
            BiConsumer<BlockPos, BlockState> pBlockSetter,
            RandomSource pRandom,
            int length_base,
            BlockPos startpos,
            TreeConfiguration pConfig,
            int xDir,
            int zDir,
            boolean up
    ) {
        int length = (int) (length_base * UniformFloat.of(0.9F,1.2F).sample(pRandom));

        List<FoliagePlacer.FoliageAttachment> attachmentList = new ArrayList<>();

        BlockPos currentPos = startpos;


        for (int l = 0; l <= length;l++){
            if (currentPos.closerToCenterThan(startpos.getCenter(),40)){
                int ya = up ? 1 : -1;
                int y = pRandom.nextFloat() < 0.40 ? ya : 0;
                currentPos = currentPos.relative(Direction.getNearest(xDir,y,zDir));

                branchLog(pLevel,pBlockSetter,pRandom,currentPos,pConfig,true);
                if (pRandom.nextFloat() > 0.46F || l == length || l == 0){
                    attachmentList.add(new FoliagePlacer.FoliageAttachment(currentPos,0,true));
                }
                if (pRandom.nextFloat() > 0.60F){
                    attachmentList.addAll(smallBranch(pLevel,pBlockSetter,pRandom,UniformInt.of(4,13).sample(pRandom),currentPos,pConfig,xDir,zDir));
                }


            }
        }



        return attachmentList;
    }

    private void branchLog(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, BlockPos pos, TreeConfiguration pConfig,boolean thick_lock) {
        if (thick_lock){
            for (int n = 0; n < 2 ; n++){
                pBlockSetter.accept(pos,(BlockState)Function.identity().apply(this.woodProvider.getState(pRandom,pos)));
                pBlockSetter.accept(pos.offset(1,n,0),(BlockState)Function.identity().apply(this.woodProvider.getState(pRandom,pos.offset(1,n,0))));
                pBlockSetter.accept(pos.offset(1,n,1),(BlockState)Function.identity().apply(this.woodProvider.getState(pRandom,pos.offset(1,n,1))));
                pBlockSetter.accept(pos.offset(0,n,1),(BlockState)Function.identity().apply(this.woodProvider.getState(pRandom,pos.offset(0,n,1))));


            }

        }else {
            pBlockSetter.accept(pos,(BlockState)Function.identity().apply(this.woodProvider.getState(pRandom,pos)));
        }
    }

    private List<FoliagePlacer.FoliageAttachment> smallBranch(
            LevelSimulatedReader pLevel,
            BiConsumer<BlockPos, BlockState> pBlockSetter,
            RandomSource pRandom,
            int lenght_base,
            BlockPos startpos,
            TreeConfiguration pConfig,
            int xDir,
            int zDir) {
        Direction direction = pRandom.nextBoolean()?  Direction.getNearest(xDir,0,zDir).getClockWise() : Direction.getNearest(xDir,0,zDir).getCounterClockWise();


        List<FoliagePlacer.FoliageAttachment> attachmentList = new ArrayList<>();

        BlockPos currentPos = startpos;
        for (int l = 0; l <= lenght_base;l++){
            if (currentPos.closerToCenterThan(startpos.getCenter(),20)){
                int x = pRandom.nextBoolean() ? direction.getStepX() : 0;
                int y = pRandom.nextFloat() < 0.26 ? 1 : 0;
                int z = pRandom.nextBoolean() ? direction.getStepZ() : 0;
                currentPos = currentPos.relative(Direction.getNearest(x,y,z));
                branchLog(pLevel,pBlockSetter,pRandom,currentPos,pConfig,false);
                if (pRandom.nextFloat() > 0.32F || l == lenght_base){
                    attachmentList.add(new FoliagePlacer.FoliageAttachment(currentPos,0,false));
                }


            }
        }



        return attachmentList;
    }

    private void placeLogIfFreeWithOffset(
            LevelSimulatedReader pLevel,
            BiConsumer<BlockPos, BlockState> pBlockSetter,
            RandomSource pRandom,
            BlockPos.MutableBlockPos pPos,
            TreeConfiguration pConfig,
            BlockPos pOffsetPos,
            int pOffsetX,
            int pOffsetY,
            int pOffsetZ
    ) {
        pPos.setWithOffset(pOffsetPos, pOffsetX, pOffsetY, pOffsetZ);
        this.placeLogIfFree(pLevel, pBlockSetter, pRandom, pPos, pConfig);
    }

}
