package com.fuyuvulpes.yoamod.world.magic.mana;

import com.fuyuvulpes.yoamod.world.magic.Magic;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.List;

public interface IMana {
    List<Magic> getSpells(Player player);

    Magic getSpellAtIndex(int index);

    int getSpellCount(Player player);

    void addSpell(Player player, Magic spell);
    void setSpells(Player player, Magic... spells);
    void setSpellList(List<Magic> list);
    void removeSpell(int index);
    int getMaxMana();
    int getMana();

    int getLastMana();

    int getTickTimer();

    void setMaxMana(int manaCount);
    void setMana(int manaCount);

    void setTickTimer(int timer);

    void addMana(int manaCount);

    boolean isManaDeprived();

    boolean drainMana(int manaCount);

    boolean canRecharge(Level level, Player player);



}
