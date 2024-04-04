package com.fuyuvulpes.yoamod.world.magic.mana;

import com.fuyuvulpes.yoamod.game.player.IYOAPlayer;
import com.fuyuvulpes.yoamod.world.magic.ElementType;
import com.fuyuvulpes.yoamod.world.magic.Magic;
import com.fuyuvulpes.yoamod.world.magic.SpellType;
import net.minecraft.world.entity.player.Player;

public class ManaHelperImpl implements ManaHelper.Impl.IManaHelper{
    private IMana lastMana;

    @Override
    public boolean canCastSpell(Player player, SpellType spell, ElementType element, Magic magic) {
        return magic.getCost() < lastMana.getMana();
    }

    @Override
    public void setMaxMana(Player player, int mana) {
        IMana iMana = ((IYOAPlayer)player).getManaData();
        iMana.setMaxMana(mana);
        lastMana = iMana;
    }

    @Override
    public int getMaxMana(Player player) {
        return lastMana.getMaxMana();
    }

    @Override
    public IMana getManaData(Player player) {
        IMana mana = ((IYOAPlayer)player).getManaData();
        lastMana = mana;
        return mana;
    }
}
