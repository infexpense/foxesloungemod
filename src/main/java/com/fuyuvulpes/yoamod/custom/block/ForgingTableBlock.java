package com.fuyuvulpes.yoamod.custom.block;

import com.fuyuvulpes.yoamod.custom.entity.block.ForgingTableBlockEntity;
import com.fuyuvulpes.yoamod.registries.BlockEntitiesModReg;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class ForgingTableBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final VoxelShape SHAPE_NORTH = Shapes.or(Block.box(-11, 0, 0, 28, 13, 16), Block.box(3, 13, 11, 27, 23, 14));
    public static final VoxelShape SHAPE_EAST = Shapes.or(Block.box(0, 0, -11, 16, 13, 28), Block.box(2, 13, 3, 5, 23, 27));
    public static final VoxelShape SHAPE_SOUTH = Shapes.or(Block.box(-12, 0, 0, 27, 13, 16), Block.box(-11, 13, 2, 13, 23, 5));
    public static final VoxelShape SHAPE_WEST = Shapes.or(Block.box(0, 0, -12, 16, 13, 27), Block.box(11, 13, -11, 14, 23, 13));

    public ForgingTableBlock(Properties p_55926_) {
        super(p_55926_);
        this.registerDefaultState(
                this.stateDefinition.any().setValue(FACING, Direction.NORTH));

    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_54481_) {
        return this.defaultBlockState().setValue(FACING, p_54481_.getHorizontalDirection().getOpposite());
    }


    @Override
    public RenderShape getRenderShape(BlockState p_54559_) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return BlockEntitiesModReg.FORGING_TABLE.get().create(p_153215_,p_153216_);
    }

    @Override
    public boolean isPathfindable(BlockState p_60475_, BlockGetter p_60476_, BlockPos p_60477_, PathComputationType p_60478_) {
        return false;
    }

    @Override
    public VoxelShape getShape(BlockState p_54561_, BlockGetter p_54562_, BlockPos p_54563_, CollisionContext p_54564_) {
        switch((Direction)p_54561_.getValue(FACING)) {
            case NORTH:
                return SHAPE_NORTH;
            case SOUTH:
                return SHAPE_SOUTH;
            case EAST:
                return SHAPE_EAST;
            case WEST:
                return SHAPE_WEST;
            default:
                return SHAPE_NORTH;
        }
    }

    @Override
    public BlockState rotate(BlockState p_54125_, Rotation p_54126_) {
        return p_54125_.setValue(FACING, p_54126_.rotate(p_54125_.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState p_54122_, Mirror p_54123_) {
        return p_54122_.rotate(p_54123_.getRotation(p_54122_.getValue(FACING)));
    }
}
