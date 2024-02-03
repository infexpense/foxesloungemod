package com.fuyuvulpes.yoamod.core.items;

public enum WeaponStats implements WeaponStat{
    PLACEHOLDER("placeholder", 0, 0.0F, 0.0F, false, false),
    BELL("bell", 4, 0.0F, 3.0F, false, false),
    BLOW_DART("blow_dart", 2, 0.0F, 0.0F, false, false),
    BOOMERANG("boomerang", 5, 0.0F, 0.0F, false, false),
    CHAKRAM("chakram", 4, -3.0F, 1.0F, false, false),
    CLAWS("claws", 1, -0.6F, -0.5F, true, false),
    CLAYMORE("claymore", 7, -3.3F, 2F, false, true),
    DAGGER("dagger", 2, -1.6F, 0.0F, false, false),
    GREAT_AXE("great_axe", 10, -3.6F, 4.0F, false, true),
    HARPOON("harpoon", 5, -3.1F, 2.0F, false, true),
    HOLY_RIFLE("holy_rifle", 14, 0.0F, 0.0F, false, true),
    KATANA("katana", 2, -2.0F, 0.5F, false, false),
    LANCE("lance", 4, -2.8F, 4.0F, false, false),
    LONGBOW("longbow", 6, 0.0F, 0.0F, false, false),
    LYRE("lyre", 0, 0.0F, 0.0F, false, false),
    MAGICIAN_WAND("magician_wand", 0, 0.0F, 0.0F, false, false),
    RAPIER("rapier", 2, -1.8F, 0.0F, true, false),
    RUNIC_AXE("runic_axe", 9, -3.4F, 2.0F, false, true),
    RUNIC_BLADE("runic_blade", 3, -2.6F, 1.0F, false, false) ,
    RUNIC_BLASTER("runic_blaster",16, 0.0F, 0.0F, false, true) ,
    SCISSORS_SWORD("scissors_sword", 5, -3.2F, 2.5F, false, false) ,
    SINGLE_SCISSORS_SWORD("single_scissors_sword", 2, -1.5F, 1.0F, false, false) ,
    SCYTHE("scythe", 6, -3.0F, 2.0F, false, false),
    SHOTGUN_SHIELD("shotgun_shield", 12, 0.0F, 0.0F, false, true),
    SHURIKEN("shuriken", 4, 0.0F, 0.0F, true, false),
    SPELLCASTER_STAFF("spellcaster_staff", 0, 0.0F, 16.0F, false, false),
    TALISMAN("talisman", 0, 0.0F, 5.0F, false, false),
    THROWING_KNIFE("throwing_knife", 2, -2.0F, 0.0F, false, false),
    TOME("tome", 0, 0.0F, 32.0F, false, false),
    WAR_FAN("war_fan", 2, -2.0F, 0.5F, true, false),
    WHIP_SWORD("whip_sword", 3, -3.0F, 2.0F, false, false)
            ;

    private final String weaponId;
    private final int attackDmg;
    private final float attackSpeed;
    private final float range;
    private final boolean isAgile;
    private final boolean isHeavy;

    private WeaponStats(String weaponId, int attackDmg, float attackSpeed, float range, boolean isAgile, boolean isHeavy) {
        this.weaponId = weaponId;
        this.attackDmg = attackDmg;
        this.attackSpeed = attackSpeed;
        this.range = range;
        this.isAgile = isAgile;
        this.isHeavy = isHeavy;
    }


    @Override
    public String weaponId() {
        return this.weaponId;
    }

    @Override
    public int attackDmg() {
        return this.attackDmg;
    }

    @Override
    public float attackSpeed() {
        return this.attackSpeed;
    }

    @Override
    public float range() {
        return this.range;
    }

    @Override
    public boolean isAgile() {
        return this.isAgile;
    }

    @Override
    public boolean isHeavy() {
        return this.isHeavy;
    }
}
