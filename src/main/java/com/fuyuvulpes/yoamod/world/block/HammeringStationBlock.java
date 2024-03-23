package com.fuyuvulpes.yoamod.world.block;

import com.fuyuvulpes.yoamod.core.registries.YoaBlockEntities;
import com.fuyuvulpes.yoamod.game.client.screens.HammeringStationMenu;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.StonecutterMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class HammeringStationBlock extends Block {
    public static final MapCodec<HammeringStationBlock> CODEC = simpleCodec(HammeringStationBlock::new);
    private static final Component TRANSLATION = Component.translatable("container.stonecutter");

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final VoxelShape SHAPE_COMMON = Block.box(0, 0, 0, 16, 13, 16);
    public HammeringStationBlock(Properties p_55926_) {
        super(p_55926_);
        this.registerDefaultState(
                this.stateDefinition.any().setValue(FACING, Direction.NORTH));

    }

    @Override
    protected MapCodec<HammeringStationBlock> codec() {
        return CODEC;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_54481_) {
        return this.defaultBlockState().setValue(FACING, p_54481_.getHorizontalDirection().getOpposite());
    }


    @Override
    public RenderShape getRenderShape(BlockState p_54559_) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            pPlayer.openMenu(pState.getMenuProvider(pLevel, pPos));
            return InteractionResult.CONSUME;
        }
    }

    @Override
    @Nullable
    public MenuProvider getMenuProvider(BlockState state, Level pLevel, BlockPos pPos) {
        return new SimpleMenuProvider((id, playerInventory, player) -> new HammeringStationMenu(id, playerInventory, ContainerLevelAccess.create(pLevel, pPos)), TRANSLATION);
    }


    @Override
    public boolean isPathfindable(BlockState p_60475_, BlockGetter p_60476_, BlockPos p_60477_, PathComputationType p_60478_) {
        return false;
    }

    @Override
    public VoxelShape getShape(BlockState p_54561_, BlockGetter p_54562_, BlockPos p_54563_, CollisionContext p_54564_) {
        return SHAPE_COMMON;
    }

    @Override
    public BlockState rotate(BlockState p_54125_, Rotation p_54126_) {
        return p_54125_.setValue(FACING, p_54126_.rotate(p_54125_.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState p_54122_, Mirror p_54123_) {
        return p_54122_.rotate(p_54123_.getRotation(p_54122_.getValue(FACING)));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_54543_) {
        p_54543_.add(FACING);
    }
}
