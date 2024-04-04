package com.fuyuvulpes.yoamod.world.magic.mana;

import com.fuyuvulpes.yoamod.network.UpdateManaPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.PacketDistributor;

public class ManaHandler {
    public static void onPlayerTick(Player player) {

        IMana data = ManaHelper.getManaData(player);
        if (data.getMana() < data.getMaxMana()){
            data.tick();
        }
    }


    public static void syncMana(ServerPlayer player)
    {
        IMana iMana = ManaHelper.getManaData(player);
        PacketDistributor.PLAYER.with(player).send(new UpdateManaPacket(iMana.getMana(), iMana.getMaxMana()));

        iMana.setMana(iMana.getMana());
    }

}
