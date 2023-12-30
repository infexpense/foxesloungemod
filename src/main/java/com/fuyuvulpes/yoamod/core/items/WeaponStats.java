package com.fuyuvulpes.yoamod.core.items;

public enum WeaponStats implements WeaponStat{
    PLACEHOLDER("placeholder", 0, -0.0F, 0.0F),
    BELL("bell", 4, 0.0F, 3.0F),
    BLOW_DART("blow_dart", 2, 0.0F, 0.0F),
    BOOMERANG("boomerang", 5, 0.0F, 0.0F),
    CHAKRAM("chakram", 4, -3.2F, 0.0F),
    CLAWS("claws", 2, -1.6F, -0.5F),
    CLAYMORE("claymore", 7, -3.5F, 2F),
    DAGGER("dagger", 1, -1.6F, 0.0F),
    GREAT_AXE("great_axe", 9, -3.8F, 3.0F),
    HARPOON("harpoon", 5, -3.6F, 2.0F),
    HOLY_RIFLE("holy_rifle", 14, 0.0F, 0.0F),
    KATANA("katana", 2, -2.0F, 0.0F),
    LANCE("lance", 4, -3.0F, 4.0F),
    LONGBOW("longbow", 6, 0.0F, 0.0F),
    LYRE("lyre", 0, 0.0F, 0.0F),
    MAGICIAN_WAND("magician_wand", 0, 0.0F, 0.0F),
    RAPIER("rapier", 2, -1.8F, 0.0F),
    RUNIC_AXE("runic_axe", 9, -3.2F, 2.0F),
    RUNIC_BLADE("runic_blade", 3, -2.6F, 0.0F) ,
    RUNIC_BLASTER("runic_blaster",16, 0.0F, 0.0F) ,
    SCISSORS_SWORD("scissors_sword", 5, -3.0F, 1.5F) ,
    SINGLE_SCISSORS_SWORD("single_scissors_sword", 3, -2.0F, 1.0F) ,
    SCYTHE("scythe", 6, -3.0F, 2.0F),
    SHOTGUN_SHIELD("shotgun_shield", 12, 0.0F, 0.0F),
    SHURIKEN("shuriken", 4, 0.0F, 0.0F),
    SPELLCASTER_STAFF("spellcaster_staff", 0, 0.0F, 16.0F),
    TALISMAN("talisman", 0, 0.0F, 5.0F),
    THROWING_KNIFE("throwing_knife", 2, -2.0F, 0.0F),
    TOME("tome", 0, 0.0F, 32.0F),
    WAR_FAN("war_fan", 2, -2.0F, 0.0F),
    WHIP_SWORD("whip_sword", 3, -3.0F, 0.0F)
            ;

    private final String weaponId;
    private final int attackDmg;
    private final float attackSpeed;
    private final float range;

    private WeaponStats(String weaponId, int attackDmg, float attackSpeed, float range) {
        this.weaponId = weaponId;
        this.attackDmg = attackDmg;
        this.attackSpeed = attackSpeed;
        this.range = range;
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
}
