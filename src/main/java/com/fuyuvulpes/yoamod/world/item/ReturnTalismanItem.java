package com.fuyuvulpes.yoamod.world.item;

import com.fuyuvulpes.yoamod.world.CreaksPortalForcer;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class ReturnTalismanItem extends Item {

    public ReturnTalismanItem(Properties pProperties) {
        super(pProperties.fireResistant().stacksTo(1).rarity(Rarity.EPIC));

    }
    public ReturnTalismanItem(BlockPos blockPos, ItemStack stack, Properties pProperties) {
        this(pProperties);
        registerPortalCoordinates(blockPos, stack);

    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }

    public void registerPortalCoordinates(BlockPos pos, ItemStack returnTalismanItem){
        CompoundTag tag = returnTalismanItem.getOrCreateTag();
        tag.putInt("XCoordinates", pos.getX());
        tag.putInt("YCoordinates", pos.getY());
        tag.putInt("ZCoordinates", pos.getZ());
    }

    public BlockPos getCoordinates(ItemStack stack){
        CompoundTag tag = stack.getOrCreateTag();
        BlockPos pos = new BlockPos(
                tag.getInt("XCoordinates"),
                tag.getInt("YCoordinates"),
                tag.getInt("ZCoordinates")
        );
        return pos;

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level plevel, Player player, InteractionHand pUsedHand) {
        ItemStack stack = player.getItemInHand(pUsedHand);
        BlockPos pPos = getCoordinates(stack);

        if (player.level() instanceof ServerLevel serverlevel) {
            MinecraftServer minecraftserver = serverlevel.getServer();
            ResourceKey<Level> resourcekey = Level.OVERWORLD;

            ServerLevel portalDimension = minecraftserver.getLevel(resourcekey);
            if (portalDimension != null && !player.isPassenger()) {
                player.changeDimension(portalDimension, new CreaksPortalForcer(pPos,true));
                stack.shrink(1);
            }
        }

        return InteractionResultHolder.success(stack);
    }
}
