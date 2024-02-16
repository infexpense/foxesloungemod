package com.fuyuvulpes.yoamod.custom.block;

import com.fuyuvulpes.yoamod.custom.item.ReturnTalismanItem;
import com.fuyuvulpes.yoamod.game.server.teleporter.CreaksTeleporter;
import com.fuyuvulpes.yoamod.game.woldgen.ModDimensions;
import com.fuyuvulpes.yoamod.registries.ItemsModReg;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CreaksGateBlock extends RotatedPillarBlock {
    public CreaksGateBlock(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pPlayer.canChangeDimensions()) {
            handlePortal(pPlayer, pPos);
            pPlayer.playSound(SoundEvents.ENDERMAN_STARE,0.7F,5.0F);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.CONSUME;
        }
    }

    private void handlePortal(Entity player, BlockPos pPos) {
        if (player.level() instanceof ServerLevel serverlevel) {
            MinecraftServer minecraftserver = serverlevel.getServer();
            ResourceKey<Level> resourcekey = ModDimensions.THE_CREAKS_LEVEL_KEY ;

            ServerLevel portalDimension = minecraftserver.getLevel(resourcekey);
            if (portalDimension != null && !player.isPassenger()) {
                player.changeDimension(portalDimension, new CreaksTeleporter(pPos, false));

                ReturnTalismanItem talismanItem = (ReturnTalismanItem) ItemsModReg.RETURN_TALISMAN.get();
                talismanItem.registerPortalCoordinates(pPos,new ItemStack(talismanItem));

                if (player instanceof Player player1) {
                    player1.addItem(new ItemStack(talismanItem));
                }
            }
        }
    }
}
