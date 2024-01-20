package com.fuyuvulpes.yoamod.custom.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CrucibleBlock extends BaseEntityBlock {
    public static final MapCodec<CrucibleBlock> CODEC = simpleCodec(CrucibleBlock::new);

    public static final VoxelShape SHAPE_COMMON = Block.box(0, 0, 3, 16, 14, 13);
    public static final VoxelShape SHAPE_NS = Block.box(0, 0, 3, 16, 14, 13);
    public static final VoxelShape SHAPE_WE = Block.box(3, 0, 0, 13, 14, 16);

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;

    public CrucibleBlock(Properties p_49224_) {
        super(p_49224_);
        this.registerDefaultState(
                this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.FALSE));

    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    public RenderShape getRenderShape(BlockState p_54559_) {
        return RenderShape.MODEL;
    }


    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return switch ((Direction) p_60555_.getValue(FACING)) {
            case EAST, WEST -> SHAPE_WE;
            case NORTH,SOUTH -> SHAPE_NS;
            default -> SHAPE_COMMON;
        };    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_54481_) {
        return this.defaultBlockState().setValue(FACING, p_54481_.getHorizontalDirection().getOpposite()).setValue(LIT, Boolean.FALSE);
    }


    @Override
    public BlockState rotate(BlockState p_54125_, Rotation p_54126_) {
        return p_54125_.setValue(FACING, p_54126_.rotate(p_54125_.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState p_54122_, Mirror p_54123_) {
        return p_54122_.rotate(p_54123_.getRotation(p_54122_.getValue(FACING)));
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return null;
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_54543_) {
        p_54543_.add(FACING).add(LIT);
    }
}
