package com.fuyuvulpes.yoamod.world.magic.mana;

import com.fuyuvulpes.yoamod.world.magic.Magic;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManaData implements IMana{

    public static final int DEFAULT_MANA = 1000;

    private List<Magic> magicList = new ArrayList<>();

    private float exhaustionLevel;
    private int maxMana = DEFAULT_MANA;
    private int mana = maxMana;
    private int tickTimer;
    private int lastMana = -99999999;

    public void addAdditionalSaveData(CompoundTag nbt) {
        nbt.putInt("maxMana", this.getMana());
        nbt.putInt("currentMana", this.getMana());
        nbt.putInt("manaTickTimer", this.getTickTimer());

    }

    public void readAdditionalSaveData(CompoundTag nbt)
    {
        if (nbt.contains("maxMana", 99)) {
            this.setMaxMana(nbt.getInt("maxMana"));
            this.setMana(nbt.getInt("currentMana"));
            this.setTickTimer(nbt.getInt("manaTickTimer"));

        }
    }


    @Override
    public List<Magic> getSpells(Player player) {
        return this.magicList;
    }

    @Override
    public Magic getSpellAtIndex(int index) {
        return this.magicList.get(index);
    }

    @Override
    public int getSpellCount(Player player) {
        return this.magicList.size();
    }

    @Override
    public void addSpell(Player player, Magic spell) {
        this.magicList.add(spell);
    }

    @Override
    public void setSpells(Player player, Magic... spells) {
        this.magicList = Arrays.stream(spells).toList();
    }

    @Override
    public void setSpellList(List<Magic> list) {
        this.magicList = list;
    }

    @Override
    public void removeSpell(int index) {
        this.magicList.remove(index);
    }

    @Override
    public int getMaxMana() {
        return this.maxMana;
    }

    @Override
    public int getMana() {
        return this.mana;
    }

    @Override
    public int getLastMana() {
        return this.lastMana;
    }

    @Override
    public int getTickTimer() {
        return this.tickTimer;
    }

    @Override
    public void setMaxMana(int manaCount) {
        this.maxMana = manaCount;
    }

    @Override
    public void setMana(int manaCount) {
        this.mana = manaCount;

    }

    @Override
    public void setTickTimer(int timer) {
        this.tickTimer = timer;
    }

    @Override
    public void addMana(int manaCount) {
        mana = Math.min(this.mana + manaCount,this.maxMana);
    }

    @Override
    public boolean isManaDeprived() {
        return this.mana < this.maxMana / 100;
    }

    @Override
    public boolean drainMana(int manaCount) {
        if (this.mana < manaCount){
            return false;
        }else {
            this.mana = Math.max(this.maxMana - manaCount, 0);
            return true;
        }
    }

    @Override
    public boolean canRecharge(Level level, Player player) {
        return this.tickTimer == 0;
    }
}
