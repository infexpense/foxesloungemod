package com.fuyuvulpes.yoamod.data.generators.advancement;

import com.fuyuvulpes.yoamod.core.registries.ItemsModReg;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class YoaCoreAdvancements implements AdvancementProvider.AdvancementGenerator{

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> consumer, ExistingFileHelper existingFileHelper) {

        var root = Advancement.Builder.advancement()
                .display(
                        ItemsModReg.RUNE_CRYSTAL.get(),
                        Component.translatable("advancement.yoamod.root"),
                        Component.translatable("advancement.yoamod.root.description"),
                        new ResourceLocation(MODID,"textures/gui/advancements/backgrounds/main.png"),
                        AdvancementType.TASK,
                        false /* showToast */,
                        false /* announceChat */,
                        false /* hidden */
                )
                .addCriterion("unlock_right_away", PlayerTrigger.TriggerInstance.tick())
                .save(consumer, new ResourceLocation(MODID,"main/root"),existingFileHelper);



    }
}
