package com.fuyuvulpes.yoamod.world.magic.mana;

import com.fuyuvulpes.yoamod.world.magic.Magic;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public interface IMana {
    void tick();
    List<Magic> getSpells();

    Magic getSpellAtIndex(int index);

    int getSpellCount(Player player);

    void addSpell(Player player, Magic spell);
    void setSpells(Player player, Magic... spells);
    void setSpellList(List<Magic> list);
    void removeSpell(int index);
    int getMaxMana();
    int getMana();

    int getLastMana();
    void setLastMana(int count);

    int getTickTimer();

    void setMaxMana(int manaCount);
    void setMana(int manaCount);


    void setTickTimer(int timer);

    void addMana(int manaCount);

    boolean isManaDeprived();

    void drainMana(int manaCount);

}
