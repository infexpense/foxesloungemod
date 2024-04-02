package com.fuyuvulpes.yoamod.world.magic.mana;

import com.fuyuvulpes.yoamod.core.YOACommonConfig;
import com.fuyuvulpes.yoamod.core.YoaRegistries;
import com.fuyuvulpes.yoamod.world.magic.Magic;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManaData implements IMana{

    public static final int DEFAULT_MANA = YOACommonConfig.startingMana;

    private List<Magic> magicList = new ArrayList<>();

    private float exhaustionLevel;
    private int maxMana = DEFAULT_MANA;
    private int mana = maxMana;
    private int tickTimer;
    private int lastMana = -99999999;
    private int spellCount = 0;

    public void addAdditionalSaveData(CompoundTag nbt) {
        nbt.putInt("maxMana", this.getMaxMana());
        nbt.putInt("currentMana", this.getMana());
        nbt.putInt("manaTickTimer", this.getTickTimer());
        nbt.putInt("knownSpells",this.getSpellCount());
        ListTag listtag = new ListTag();
        CompoundTag compoundtag = new CompoundTag();
        for (Magic magic : this.getSpells()){
            magic.save(compoundtag);
            listtag.add(compoundtag);

        }
        nbt.put("spellList", listtag);

    }

    public void readAdditionalSaveData(CompoundTag nbt)
    {
        if (nbt.contains("maxMana", 99)) {
            this.setMaxMana(nbt.getInt("maxMana"));
            this.setMana(nbt.getInt("currentMana"));
            this.setTickTimer(nbt.getInt("manaTickTimer"));
            this.setSpellCount(nbt.getInt("knownSpells"));
            List<Magic> spellList = new ArrayList<>();
            for (int s = this.spellCount; s > 0; s--){
                String id = nbt.getList("spellList",99).getCompound(s).getString("id");
                spellList.add(
                        YoaRegistries.MAGIC.get(new ResourceLocation(id))
                );

            }
            this.setSpellList(spellList);

        }
    }

    public void setSpellCount(int spellCount) {
        this.spellCount = spellCount;
    }

    public void tick(){
        this.tickTimer ++;
        if (this.tickTimer >= 30){
            tickTimer = 0;
            this.mana = Math.min(mana + 1,maxMana);
        }
    }
    public int getSpellCount() {
        return this.magicList.size();
    }

    @Override
    public List<Magic> getSpells() {
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
    public void setLastMana(int count) {
        this.lastMana = count;
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
        return this.mana < this.maxMana / 10;
    }

    @Override
    public void drainMana(int manaCount) {
        if (this.mana < manaCount){

        }else {
            this.mana = Math.max(this.mana - manaCount, 0);
        }
    }
}
