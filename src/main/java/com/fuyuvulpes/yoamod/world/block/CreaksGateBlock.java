package com.fuyuvulpes.yoamod.world.block;

import com.fuyuvulpes.yoamod.core.registries.YoaBlocks;
import com.fuyuvulpes.yoamod.mixin.ServerPlayerMixin;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.CriterionProgress;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.critereon.CriterionValidator;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.StatType;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;

import java.util.ArrayList;
import java.util.List;

public class CreaksGateBlock extends RotatedPillarBlock {
    public CreaksGateBlock(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if (pLevel.getBlockStates(new AABB(pPos.above().getCenter(), pPos.above(12).getCenter())).anyMatch(blockState -> blockState.is(YoaBlocks.CREAKS_GATE.get()))
                & isWorthy(pPlayer)
        ) {
            makePortal(pLevel, pPos);
            pLevel.playSound(null,pPos,SoundEvents.ENDERMAN_STARE, SoundSource.BLOCKS,2.0F,0.2F);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.FAIL;
        }
    }

    private boolean isWorthy(Player pPlayer) {
        ServerPlayer player = null;
        pPlayer.isLocalPlayer();
        if (!pPlayer.isLocalPlayer()){
            player = (ServerPlayer) pPlayer;
        }
        if (player == null){
            return false;
        }
        return player.getStats().getValue(Stats.ENTITY_KILLED.get(EntityType.WARDEN)) > 0
                || player.getStats().getValue(Stats.ENTITY_KILLED.get(EntityType.WITHER)) > 0
                || player.getStats().getValue(Stats.ENTITY_KILLED.get(EntityType.ENDER_DRAGON)) > 0;
    }

    private void makePortal(Level pLevel, BlockPos pPos) {
        BlockPos pos = pPos.above();
        List<BlockPos> posList = new ArrayList<>();
        posList.add(pos);
        for (int i = 0; i < 12; i++){
            if (pLevel.isStateAtPosition(pos, state -> state.is(YoaBlocks.CREAKS_GATE.get()))){
                i = 12;
            }else {
                posList.add(pos);
                pos = pos.above();

            }


        }
        posList.forEach(pos1 -> pLevel.setBlock(pos1,YoaBlocks.CREAKS_PORTAL.get().defaultBlockState(),3));
        pLevel.setBlock(pos,YoaBlocks.CREAKSTONE_FRACTURE.get().defaultBlockState(),3);
        pLevel.setBlock(pPos,YoaBlocks.CREAKSTONE_FRACTURE.get().defaultBlockState(),3);
    }
}
