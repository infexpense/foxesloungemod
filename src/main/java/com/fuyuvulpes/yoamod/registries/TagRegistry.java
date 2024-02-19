package com.fuyuvulpes.yoamod.registries;

import com.fuyuvulpes.yoamod.YOAMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;

public class TagRegistry {

    public static class Blocks {
        public static final TagKey<Block> NEEDS_BRONZE_TOOL = tag("needs_bronze_tool");
        public static final TagKey<Block> NEEDS_SILVER_TOOL = tag("needs_silver_tool");
        public static final TagKey<Block> NEEDS_STEEL_TOOL = tag("needs_steel_tool");
        public static final TagKey<Block> NEEDS_BISMUTH_TOOL = tag("needs_bismuth_tool");
        public static final TagKey<Block> NEEDS_TITANIUM_TOOL = tag("needs_titanium_tool");
        public static final TagKey<Block> NEEDS_WITHERITE_TOOL = tag("needs_witherite_tool");
        public static final TagKey<Block> NEEDS_IOLITE_TOOL = tag("needs_iolite_tool");
        public static final TagKey<Block> NEEDS_ALEXANDRITE_TOOL = tag("needs_alexandrite_tool");
        public static final TagKey<Block> NEEDS_ADAMANTITE_TOOL = tag("needs_adamantite_tool");
        public static final TagKey<Block> NEEDS_BRASS_TOOL = tag("needs_brass_tool");
        public static final TagKey<Block> NETHER_ORE_REPLACEABLES = tag("nether_ore_replaceables");
        public static final TagKey<Block> END_ORE_REPLACEABLES = tag("end_ore_replaceables");
        public static final TagKey<Block> CREAK_ORE_REPLACEABLES = tag("creak_ore_replaceables");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(YOAMod.MODID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(YOAMod.MODID, name));
        }
            }

    public static class Biomes {

        public static final TagKey<Biome> IS_THE_CREAK = tag("is_the_creak");
        public static final TagKey<Biome> BLOCKLING_GRASS = tag("blockling_grass");
        public static final TagKey<Biome> BLOCKLING_WOOD = tag("blockling_wood");
        public static final TagKey<Biome> BLOCKLING_COBBLESTONE = tag("blockling_cobblestone");


        private static TagKey<Biome> tag(String name) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(YOAMod.MODID, name));
        }
    }


}
