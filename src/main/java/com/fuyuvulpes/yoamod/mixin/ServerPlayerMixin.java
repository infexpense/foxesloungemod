package com.fuyuvulpes.yoamod.mixin;

import com.fuyuvulpes.yoamod.game.player.IYOAPlayer;
import com.fuyuvulpes.yoamod.world.magic.mana.IMana;
import com.fuyuvulpes.yoamod.world.magic.mana.ManaHelper;
import com.mojang.authlib.GameProfile;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.fuyuvulpes.yoamod.world.magic.mana.ManaHandler.syncMana;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin extends Player implements IYOAPlayer {
    protected ServerPlayerMixin(Level $$0, BlockPos $$1, float $$2, GameProfile $$3)
    {
        super($$0, $$1, $$2, $$3);
    }

    @Inject(method="doTick", at=@At(value="TAIL"))
    public void onDoTick(CallbackInfo ci)
    {
        ServerPlayer player = (ServerPlayer)(Player)this;
        IMana mana = ManaHelper.getManaData(player);

        if (mana.getLastMana() != mana.getMana())
        {
            syncMana(player);
        }
    }

}
