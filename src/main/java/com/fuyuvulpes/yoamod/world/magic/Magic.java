package com.fuyuvulpes.yoamod.world.magic;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.flag.FeatureElement;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Magic implements FeatureElement {
    private final FeatureFlagSet requiredFeatures;
    private final int manaCost;
    private final ElementType elementType;
    private final SpellType spellType;

    private List<Entity> targets = new ArrayList<>();

    public Magic(Magic.Properties pProperties) {
        this.manaCost = pProperties.manaCost;
        this.elementType = pProperties.elementType;
        this.spellType = pProperties.spellType;
        this.requiredFeatures = pProperties.requiredFeatures;
    }

    public void castSpell(Entity caster, BlockPos pos, int maxRange, float castDuration, float powerMultiplier){
        targetInit(caster);
    }


    public void addTargets(Entity entity){
        this.targets.add(entity);
    }

    public void targetInit(Entity caster){
        if (spellType.targetsSelf()){
            targets.add(caster);
        }
        if (spellType.targetsAllies()){
            caster.level().players().forEach(player -> {
                if (player.isCloseEnough(caster, 32) && player.isAlliedTo(caster)){
                    targets.add(player);
                }
            });
        }
    }

    public List<Entity> getTargets() {
        return this.targets;
    }

    @Override
    public @NotNull FeatureFlagSet requiredFeatures() {
        return this.requiredFeatures;
    }

    public int getCost(){
        return this.manaCost;
    }

    public ElementType getElement(){
        return this.elementType;
    }

    public SpellType getType() {
        return this.spellType;
    }

    public static class Properties {

        int manaCost = 10;
        ElementType elementType = ElementTypes.BASIC;
        SpellType spellType = SpellTypes.SINGLE_TARGET;
        FeatureFlagSet requiredFeatures = FeatureFlags.VANILLA_SET;



        public Magic.Properties cost(int cost){
            this.manaCost = cost;
            return this;
        }
        public Magic.Properties element(ElementType element){
            this.elementType = element;
            return this;
        }
        public Magic.Properties spellType(SpellType spellType){
            this.spellType = spellType;
            return this;
        }
        public Magic.Properties requiredFeatures(FeatureFlag... pRequiredFeatures){
            this.requiredFeatures = FeatureFlags.REGISTRY.subset(pRequiredFeatures);
            return this;
        }
    }
}
