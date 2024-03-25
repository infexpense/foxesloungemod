package com.fuyuvulpes.yoamod.world.item;

import com.google.common.collect.Sets;
import net.neoforged.neoforge.common.ToolAction;
import net.neoforged.neoforge.common.ToolActions;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class YoaToolActions {

    public static final Set<ToolAction> WHIP_ACTIONS = of(ToolActions.DEFAULT_SWORD_ACTIONS, ToolActions.SHEARS_DISARM);
    public static final Set<ToolAction> SCYTHE_ACTIONS = of(ToolActions.DEFAULT_SWORD_ACTIONS, ToolActions.HOE_TILL,ToolActions.HOE_DIG);
    public static final Set<ToolAction> DAGGER_ACTIONS = of(ToolActions.DEFAULT_SWORD_ACTIONS, ToolActions.SHEARS_DISARM,ToolActions.SHEARS_CARVE);


    private static Set<ToolAction> of(ToolAction... actions) {
        return Stream.of(actions).collect(Collectors.toCollection(Sets::newIdentityHashSet));
    }
    private static Set<ToolAction> of(Set<ToolAction> actionSet,ToolAction... actions) {
        Set<ToolAction> stream = Stream.of(actions).collect(Collectors.toCollection(Sets::newIdentityHashSet));
        stream.addAll(actionSet);
        return stream;
    }
}
