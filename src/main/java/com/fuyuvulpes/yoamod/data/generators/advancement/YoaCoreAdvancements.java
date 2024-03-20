package com.fuyuvulpes.yoamod.data.generators.advancement;

import com.fuyuvulpes.yoamod.core.registries.YoaBlocks;
import com.fuyuvulpes.yoamod.core.registries.YoaItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.advancements.critereon.RecipeCraftedTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class YoaCoreAdvancements implements AdvancementProvider.AdvancementGenerator{

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> consumer, ExistingFileHelper existingFileHelper) {

        var root = Advancement.Builder.advancement()
                .display(
                        YoaItems.RUNE_CRYSTAL.get(),
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

        var silver = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        (YoaItems.SILVER_INGOT.get()),
                        Component.translatable("advancement.yoamod.silver"),
                        Component.translatable("advancement.yoamod.silver.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("silver", InventoryChangeTrigger.TriggerInstance.hasItems(YoaItems.SILVER_INGOT.get()))
                .save(consumer, new ResourceLocation(MODID,"main/silver"),existingFileHelper);

        var crucible = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        YoaBlocks.CRUCIBLE.get(),
                        Component.translatable("advancement.yoamod.crucible"),
                        Component.translatable("advancement.yoamod.crucible.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("crucible", InventoryChangeTrigger.TriggerInstance.hasItems(YoaBlocks.CRUCIBLE.get()))
                .save(consumer, new ResourceLocation(MODID,"main/crucible"),existingFileHelper);

        var hammering_station = Advancement.Builder.advancement()
                .parent(crucible)
                .display(
                        YoaBlocks.HAMMERING_STATION.get(),
                        Component.translatable("advancement.yoamod.hammering_station"),
                        Component.translatable("advancement.yoamod.hammering_station.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("hammering_station", InventoryChangeTrigger.TriggerInstance.hasItems(YoaBlocks.HAMMERING_STATION.get()))
                .save(consumer, new ResourceLocation(MODID,"main/hammering_station"),existingFileHelper);


        var alloys = Advancement.Builder.advancement()
                .parent(crucible)
                .display(
                        YoaItems.MOLTEN_BRONZE.get(),
                        Component.translatable("advancement.yoamod.alloys"),
                        Component.translatable("advancement.yoamod.alloys.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                        )
                .requirements(AdvancementRequirements.Strategy.OR)
                .addCriterion("bronze",InventoryChangeTrigger.TriggerInstance.hasItems(YoaItems.BRONZE_INGOT.get()))
                .addCriterion("brass",InventoryChangeTrigger.TriggerInstance.hasItems(YoaItems.BRASS_INGOT.get()))
                .addCriterion("steel",InventoryChangeTrigger.TriggerInstance.hasItems(YoaItems.STEEL_INGOT.get()))
                .save(consumer, new ResourceLocation(MODID,"main/alloys"),existingFileHelper);


        var steel = Advancement.Builder.advancement()
                .parent(alloys)
                .display(
                        YoaItems.STEEL_INGOT.get(),
                        Component.translatable("advancement.yoamod.steel"),
                        Component.translatable("advancement.yoamod.steel.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("steel",InventoryChangeTrigger.TriggerInstance.hasItems(YoaItems.STEEL_INGOT.get()))
                .save(consumer, new ResourceLocation(MODID,"main/steel"),existingFileHelper);

        var titanium = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        YoaItems.TITANIUM_PICKAXE.get(),
                        Component.translatable("advancement.yoamod.titanium"),
                        Component.translatable("advancement.yoamod.titanium.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .requirements(AdvancementRequirements.Strategy.OR)
                .addCriterion("titanium_ingot",InventoryChangeTrigger.TriggerInstance.hasItems(YoaItems.TITANIUM_INGOT.get()))
                .addCriterion("raw_titanium",InventoryChangeTrigger.TriggerInstance.hasItems(YoaItems.RAW_TITANIUM.get()))
                .addCriterion("titanium_ore",InventoryChangeTrigger.TriggerInstance.hasItems(YoaBlocks.TITANIUM_ORE.get()))
                .addCriterion("deepslate_titanium_ore",InventoryChangeTrigger.TriggerInstance.hasItems(YoaBlocks.DEEPSLATE_TITANIUM_ORE.get()))
                .addCriterion("raw_titanium_block",InventoryChangeTrigger.TriggerInstance.hasItems(YoaBlocks.RAW_TITANIUM_BLOCK.get()))
                .addCriterion("titanium_block",InventoryChangeTrigger.TriggerInstance.hasItems(YoaBlocks.TITANIUM_BLOCK.get()))
                .save(consumer, new ResourceLocation(MODID,"main/titanium"),existingFileHelper);



/*
        var name = Advancement.Builder.advancement()
                .parent(crucible)
                .display(
                        YoaCLASS.NAME.get(),
                        Component.translatable("advancement.yoamod.name"),
                        Component.translatable("advancement.yoamod.name.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("name",InventoryChangeTrigger.TriggerInstance.hasItems(YoaCLASS.NAME.get()))
                .save(consumer, new ResourceLocation(MODID,"main/name"),existingFileHelper);
*/
    }
}
