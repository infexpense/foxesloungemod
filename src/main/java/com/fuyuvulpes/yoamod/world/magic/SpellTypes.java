package com.fuyuvulpes.yoamod.world.magic;

public enum SpellTypes implements SpellType{
    SINGLE_TARGET(0,true,false,false,true)

    ;



    private final int id;
    private final boolean requiresPosition;
    private final boolean targetsSelf;
    private final boolean targetsAllies;

    private final boolean targetsEnemy;
    private final boolean affectsArea;
    private final int effectArea;

    SpellTypes(int id, boolean requiresPosition, boolean targetsSelf, boolean targetsAllies, boolean targetsEnemy, int effectArea) {
        this.id = id;
        this.requiresPosition = requiresPosition;
        this.targetsSelf = targetsSelf;
        this.targetsAllies = targetsAllies;
        this.targetsEnemy = targetsEnemy;
        this.affectsArea = true;
        this.effectArea = effectArea;
    }
    SpellTypes(int id, boolean requiresPosition, boolean targetsSelf, boolean targetsAllies, boolean targetsEnemy) {
        this.id = id;
        this.requiresPosition = requiresPosition;
        this.targetsSelf = targetsSelf;
        this.targetsAllies = targetsAllies;
        this.targetsEnemy = targetsEnemy;
        this.affectsArea = false;
        this.effectArea = 0;
    }

    @Override
    public int id() {
        return this.id;
    }

    @Override
    public boolean requiresPosition() {
        return this.requiresPosition;
    }

    @Override
    public boolean targetsSelf() {
        return this.targetsSelf;
    }

    @Override
    public boolean targetsAllies() {
        return this.targetsAllies;
    }

    @Override
    public boolean targetsEnemy() {
        return this.targetsEnemy;
    }

    @Override
    public boolean affectsArea() {
        return this.affectsArea;
    }

    @Override
    public int effectArea() {
        return this.effectArea;
    }
}
