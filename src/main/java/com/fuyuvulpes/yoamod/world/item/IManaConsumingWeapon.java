package com.fuyuvulpes.yoamod.world.item;

import com.fuyuvulpes.yoamod.game.player.IYOAPlayer;
import com.fuyuvulpes.yoamod.world.magic.mana.IMana;
import com.fuyuvulpes.yoamod.world.magic.mana.ManaHelper;
import net.minecraft.world.entity.player.Player;

public interface IManaConsumingWeapon {

    default boolean canConsumeMana(Player player, int count){
        IMana mana = ((IYOAPlayer)player).getManaData();
        return count <= mana.getMana();
    }

    default void consumeMana(Player player, int count){
        IMana iMana = ManaHelper.getManaData(player);
        iMana.drainMana(count);

    }
}
