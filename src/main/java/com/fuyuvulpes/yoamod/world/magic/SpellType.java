package com.fuyuvulpes.yoamod.world.magic;

public interface SpellType {

    int id();
    boolean requiresPosition();

    boolean targetsSelf();

    boolean targetsAllies();

    boolean targetsEnemy();

    boolean affectsArea();

    int effectArea();
}
