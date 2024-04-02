package com.fuyuvulpes.yoamod.core;

import com.fuyuvulpes.yoamod.YOAMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = YOAMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class YOACommonConfig
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue ARMED_SPIDER_DEBUFF = BUILDER
            .comment("Whether to apply Nausea, Darkness, and Weakness to Armed Spider attacks")
            .define("armedSpiderDebuff", true);

    private static final ModConfigSpec.IntValue SPELL_LIMIT = BUILDER
            .comment("How many spells should a player be able to have")
            .defineInRange("spellLimit", 3, 0, 40);

    private static final ModConfigSpec.IntValue STARTING_MANA = BUILDER
            .comment("The Starting Mana for a Player")
            .defineInRange("startingMana", 30, 0, 3000);

    public static final ModConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
            .comment("What you want the introduction message to be for the magic number")
            .define("magicNumberIntroduction", "The magic number is... ");

    // a list of strings that are treated as resource locations for items
    private static final ModConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
            .comment("A list of items to log on common setup.")
            .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), YOACommonConfig::validateItemName);

    public static final ModConfigSpec SPEC = BUILDER.build();
    public static boolean armedSpiderDebuff;
    public static int spellLimit;
    public static int startingMana;
    public static String magicNumberIntroduction;
    public static Set<Item> items;

    private static boolean validateItemName(final Object obj)
    {
        return obj instanceof final String itemName && BuiltInRegistries.ITEM.containsKey(new ResourceLocation(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        armedSpiderDebuff = ARMED_SPIDER_DEBUFF.get();
        spellLimit = SPELL_LIMIT.get();
        startingMana = STARTING_MANA.get();
        magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get();

        // convert the list of strings into a set of items
        items = ITEM_STRINGS.get().stream()
                .map(itemName -> BuiltInRegistries.ITEM.get(new ResourceLocation(itemName)))
                .collect(Collectors.toSet());
    }
}
