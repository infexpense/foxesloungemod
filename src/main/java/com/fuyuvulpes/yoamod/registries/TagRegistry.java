package com.fuyuvulpes.yoamod.registries;

import com.fuyuvulpes.yoamod.YOAMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
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
        public static final TagKey<Block> NEEDS_MAGNESIUM_TOOL = tag("needs_magnesium_tool");
        public static final TagKey<Block> NEEDS_BRASS_TOOL = tag("needs_brass_tool");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(YOAMod.MODID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(YOAMod.MODID, name));
        }
    }


}
