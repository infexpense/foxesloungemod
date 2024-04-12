package com.fuyuvulpes.yoamod.world.magic;

public enum ElementTypes implements ElementType{
    BASIC("basic",0),
    WATER("water",1),
    FIRE("fire",2),
    EARTH("earth",3),
    WIND("wind",4),
    ICE("ice",5),
    LIGHTNING("lightning",6),
    DARK("dark",7),


    ;

    private final String spellName;
    private final int id;

    ElementTypes(String spellName, int id) {
        this.spellName = spellName;
        this.id = id;
    }

    @Override
    public String spellName() {
        return null;
    }


    @Override
    public int id() {
        return 0;
    }
}
