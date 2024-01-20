package com.fuyuvulpes.yoamod.registries;

import com.fuyuvulpes.yoamod.custom.block.*;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class BlocksModReg {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);


    public static final DeferredBlock<Block> HAMMERING_STATION = registerBlock("hammering_station", HammeringStationBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noOcclusion());

    public static final DeferredBlock<Block> AUGMENTING_STATION = registerBlock("augmenting_station", AugmentingTableBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noOcclusion());

    public static final DeferredBlock<Block> CRUCIBLE = registerBlock("crucible", CrucibleBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noOcclusion());

    public static final DeferredBlock<Block> CREAKSTONE = registerBlock("creakstone", () -> new Block(BlockBehaviour.Properties.of()
            .requiresCorrectToolForDrops()
            .strength(24.0F, 32.0F)
            .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> CREAKSTONE_FRACTURE = registerBlock("creakstone_fracture", () -> new DropExperienceBlock(UniformInt.of(5, 70),
            BlockBehaviour.Properties.ofLegacyCopy(BlocksModReg.CREAKSTONE.get()).noLootTable()));

    public static final DeferredBlock<Block> OVERGROWN_CREAKSTONE = registerBlock("overgrown_creakstone", () -> new Block(BlockBehaviour.Properties.ofLegacyCopy(BlocksModReg.CREAKSTONE.get())));

    public static final DeferredBlock<Block> CRYSTALIC_REMNANTS = registerBlock("crystalic_remnants", () -> new Block(BlockBehaviour.Properties.ofLegacyCopy(Blocks.AMETHYST_BLOCK).lightLevel((f) -> 14 ).strength(8.0F,12.0F)));


    public static final DeferredBlock<Block> RUNE_CRYSTAL_CLUSTER = registerBlock("rune_crystal_cluster", () -> new RuneCrystalClusterBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.AMETHYST_CLUSTER).lightLevel((f) -> 4 ).strength(2.0F,0.0F).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> RUNE_CRYSTAL_BLOCK = registerBlock("rune_crystal_block", () -> new Block(BlockBehaviour.Properties.ofLegacyCopy(Blocks.AMETHYST_BLOCK).lightLevel((f) -> 6 ).strength(6.0F,3.0F)));

    public static final DeferredBlock<Block> POINTED_CREAKSTONE = registerBlock("pointed_creakstone", () -> new PointedCreakstone(BlockBehaviour.Properties.ofLegacyCopy(Blocks.POINTED_DRIPSTONE).strength(4.0F,6.0F)));





    public static final DeferredBlock<Block> CREAKSTONE_IRON_ORE = registerBlock("creakstone_iron_ore", Block.Properties.ofLegacyCopy(Blocks.DEEPSLATE_IRON_ORE).strength(24.0F, 32.0F));

    public static final DeferredBlock<Block> CREAKSTONE_DIAMOND_ORE = registerBlock("creakstone_diamond_ore", Block.Properties.ofLegacyCopy(Blocks.DEEPSLATE_DIAMOND_ORE).strength(24.0F, 32.0F));



    public static final DeferredBlock<Block> SILVER_ORE = registerBlock("silver_ore", Block.Properties.ofLegacyCopy(Blocks.IRON_ORE).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore", Block.Properties.ofLegacyCopy(Blocks.DEEPSLATE_IRON_ORE));

    public static final DeferredBlock<Block> TITANIUM_ORE = registerBlock("titanium_ore", Block.Properties.ofLegacyCopy(Blocks.IRON_ORE).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore", Block.Properties.ofLegacyCopy(Blocks.DEEPSLATE_IRON_ORE));
    public static final DeferredBlock<Block> CREAKSTONE_TITANIUM_ORE = registerBlock("creakstone_titanium_ore", Block.Properties.ofLegacyCopy(Blocks.DEEPSLATE_IRON_ORE).strength(24.0F, 32.0F));

    public static final DeferredBlock<Block> BISMUTH_ORE = registerBlock("bismuth_ore", Block.Properties.ofLegacyCopy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> DEEPSLATE_BISMUTH_ORE = registerBlock("deepslate_bismuth_ore", Block.Properties.ofLegacyCopy(Blocks.DEEPSLATE_DIAMOND_ORE));

    public static final DeferredBlock<Block> WITHERITE_ORE = registerBlock("witherite_ore", () -> new DropExperienceBlock(UniformInt.of(4, 12),BlockBehaviour.Properties.ofLegacyCopy(Blocks.NETHER_QUARTZ_ORE)));

    public static final DeferredBlock<Block> IOLITE_ORE = registerBlock("iolite_ore", () -> new DropExperienceBlock(UniformInt.of(5, 30),BlockBehaviour.Properties.ofLegacyCopy(Blocks.END_STONE)));

    public static final DeferredBlock<Block> ALEXANDRITE_ORE = registerBlock("alexandrite_ore", () -> new DropExperienceBlock(UniformInt.of(10, 60),BlockBehaviour.Properties.ofLegacyCopy(BlocksModReg.CREAKSTONE.get())
            .strength(22.0F, 36.0F)
    ));

    public static final DeferredBlock<Block> ADAMANTITE_ORE = registerBlock("adamantite_ore", () -> new DropExperienceBlock(UniformInt.of(30, 200),BlockBehaviour.Properties.ofLegacyCopy(BlocksModReg.CREAKSTONE.get())
            .strength(30.0F, 42.0F)
    ));







    private static <I extends Block> DeferredBlock<Block> registerBlock(String name, Supplier<? extends I> block) {
        DeferredBlock<Block> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static  DeferredBlock<Block> registerBlock(String name, BlockBehaviour.Properties block){
        DeferredBlock<Block> toReturn = BLOCKS.registerSimpleBlock(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    } private static  DeferredBlock<Block> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends Block> func, BlockBehaviour.Properties block){
        DeferredBlock<Block> toReturn = BLOCKS.registerBlock(name,func,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> DeferredItem<BlockItem> registerBlockItem(String name, DeferredBlock<T> block){
        return ItemsModReg.ITEMS.registerSimpleBlockItem(name, block);
    }
    private static DeferredBlock<Block> registerCustomItemPropertiesBlock(String name, BlockBehaviour.Properties block, Item.Properties properties){
        DeferredBlock<Block>  toReturn = BLOCKS.registerSimpleBlock(name,block);
        registerCustomBlockItem(name, toReturn, properties);
        return toReturn;
    }
    private static <T extends Block> DeferredItem<BlockItem> registerCustomBlockItem(String name, DeferredBlock<T> block, Item.Properties properties){
        return ItemsModReg.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }



}
