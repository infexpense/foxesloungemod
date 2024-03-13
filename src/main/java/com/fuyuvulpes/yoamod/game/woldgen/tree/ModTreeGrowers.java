package com.fuyuvulpes.yoamod.game.woldgen.tree;

import com.fuyuvulpes.yoamod.game.woldgen.ModConfigFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower BLISSWOOD = new TreeGrower(
            "blisswood",
            0.0F,
            Optional.of(ModConfigFeatures.BLISSWOOD_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty()

    );
}
