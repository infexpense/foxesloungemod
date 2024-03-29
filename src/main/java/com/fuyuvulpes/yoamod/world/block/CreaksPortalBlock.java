package com.fuyuvulpes.yoamod.world.block;

import com.fuyuvulpes.yoamod.game.woldgen.ModDimensions;
import com.fuyuvulpes.yoamod.world.CreaksPortalForcer;
import com.fuyuvulpes.yoamod.world.entity.block.CreaksPortalBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import org.jetbrains.annotations.Nullable;

public class CreaksPortalBlock extends BaseEntityBlock {
    public static final MapCodec<CreaksPortalBlock> CODEC = simpleCodec(CreaksPortalBlock::new);

    public CreaksPortalBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        pEntity.setPos(pPos.west().north().getCenter());
        pEntity.sendSystemMessage(Component.literal("Creaks Portal is still in the works!").withStyle(ChatFormatting.RED));
        System.out.println("CreaksPortalForcer is still in the works, and current teleporter causes a crash upon entering.");
        System.out.println("This feature will be fixed in the next Your Own Adventure Alpha version update.");

        if (pLevel instanceof ServerLevel
                && pEntity.canChangeDimensions()
                && Shapes.joinIsNotEmpty(
                Shapes.create(pEntity.getBoundingBox().move((double)(-pPos.getX()), (double)(-pPos.getY()), (double)(-pPos.getZ()))),
                pState.getShape(pLevel, pPos),
                BooleanOp.AND
        )) {
            ResourceKey<Level> resourcekey = pLevel.dimension() == ModDimensions.THE_CREAKS ? Level.OVERWORLD : ModDimensions.THE_CREAKS;
            ServerLevel serverlevel = ((ServerLevel)pLevel).getServer().getLevel(resourcekey);
            if (serverlevel == null) {
                return;
            }

            pEntity.changeDimension(serverlevel, new CreaksPortalForcer(serverlevel));
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CreaksPortalBlockEntity(pPos,pState);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader pLevel, BlockPos pPos, BlockState pState) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canBeReplaced(BlockState pState, Fluid pFluid) {
        return false;
    }
}
