package com.fuyuvulpes.yoamod.core.registries;

import com.fuyuvulpes.yoamod.game.woldgen.tree.ModTreeGrowers;
import com.fuyuvulpes.yoamod.world.block.*;
import com.fuyuvulpes.yoamod.world.block.state.ModBlockSetType;
import com.fuyuvulpes.yoamod.world.block.state.ModWoodTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class YoaBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);


    public static final DeferredBlock<Block> HAMMERING_STATION = registerBlock("hammering_station", HammeringStationBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noOcclusion());

    public static final DeferredBlock<Block> CRUCIBLE = registerBlock("crucible", CrucibleBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noOcclusion()
            .sound(SoundType.NETHERITE_BLOCK)
            .lightLevel(litBlockEmission(15)));


    //BLISSWOOD

    public static final DeferredBlock<Block> BLISSWOOD_PLANKS = registerBlock(
            "blisswood_planks", () ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.SAND)
                                    .instrument(NoteBlockInstrument.BASS)
                                    .strength(2.0F, 3.0F)
                                    .sound(SoundType.WOOD)
                                    .ignitedByLava()
                    )
    );
    public static final DeferredBlock<Block> BLISSWOOD_SAPLING = registerBlock(
            "blisswood_sapling",() ->
                    new SaplingBlock(
                            ModTreeGrowers.BLISSWOOD,
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.PLANT)
                                    .noCollission()
                                    .randomTicks()
                                    .instabreak()
                                    .sound(SoundType.GRASS)
                                    .pushReaction(PushReaction.DESTROY)
                    )
    );
    public static final DeferredBlock<Block> BLISSWOOD_LOG = registerBlock("blisswood_log", () -> log(MapColor.SAND, MapColor.QUARTZ));
    public static final DeferredBlock<Block> STRIPPED_BLISSWOOD_LOG = registerBlock("stripped_blisswood_log",() ->  log(MapColor.SAND, MapColor.SAND));
    public static final DeferredBlock<Block> BLISSWOOD_WOOD = registerBlock(
            "blisswood_wood",() ->
                    new RotatedPillarBlock(
                            BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()
                    )
    );
    public static final DeferredBlock<Block> STRIPPED_BLISSWOOD_WOOD = registerBlock(
            "stripped_blisswood_wood",() ->
                    new RotatedPillarBlock(
                            BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()
                    )
    );
    public static final DeferredBlock<Block> BLISSWOOD_LEAVES = registerBlock("blisswood_leaves",() -> new BlisswoodLeavesBlock(leaves(SoundType.GRASS)));

    public static final DeferredBlock<Block> BLISSWOOD_SIGN = registerNoItemBlock(
            "blisswood_sign",() ->
                    new StandingSignBlock(
                            ModWoodTypes.BLISSWOOD,
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.SAND)
                                    .forceSolidOn()
                                    .instrument(NoteBlockInstrument.BASS)
                                    .noCollission()
                                    .strength(1.0F)
                                    .ignitedByLava()
                    )
    );
    public static final DeferredBlock<Block> BLISSWOOD_WALL_SIGN = registerNoItemBlock(
            "blisswood_wall_sign", () ->
                    new WallSignBlock(
                            ModWoodTypes.BLISSWOOD,
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.SAND)
                                    .forceSolidOn()
                                    .instrument(NoteBlockInstrument.BASS)
                                    .noCollission()
                                    .strength(1.0F)
                                    .dropsLike(BLISSWOOD_SIGN.get())
                                    .ignitedByLava()
                    )
    );

    public static final DeferredBlock<Block> BLISSWOOD_HANGING_SIGN = registerNoItemBlock(
            "blisswood_hanging_sign",() ->
                    new CeilingHangingSignBlock(
                            ModWoodTypes.BLISSWOOD,
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.SAND)
                                    .forceSolidOn()
                                    .instrument(NoteBlockInstrument.BASS)
                                    .noCollission()
                                    .strength(1.0F)
                                    .ignitedByLava()
                    )
    );

    public static final DeferredBlock<Block> BLISSWOOD_WALL_HANGING_SIGN = registerNoItemBlock(
            "blisswood_wall_hanging_sign",() ->
                    new WallHangingSignBlock(
                            ModWoodTypes.BLISSWOOD,
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.SAND)
                                    .forceSolidOn()
                                    .instrument(NoteBlockInstrument.BASS)
                                    .noCollission()
                                    .strength(1.0F)
                                    .dropsLike(BLISSWOOD_HANGING_SIGN.get())
                                    .ignitedByLava()
                    )
    );
    public static final DeferredBlock<PressurePlateBlock> BLISSWOOD_PRESSURE_PLATE = registerBlock(
            "blisswood_pressure_plate",() ->
                    new PressurePlateBlock(
                            ModBlockSetType.BLISSWOOD,
                            BlockBehaviour.Properties.of()
                                    .mapColor(BLISSWOOD_PLANKS.get().defaultMapColor())
                                    .forceSolidOn()
                                    .instrument(NoteBlockInstrument.BASS)
                                    .noCollission()
                                    .strength(0.5F)
                                    .ignitedByLava()
                                    .pushReaction(PushReaction.DESTROY)
                    )
    );
    public static final DeferredBlock<TrapDoorBlock> BLISSWOOD_TRAPDOOR = registerBlock(
            "blisswood_trapdoor",() ->
                    new TrapDoorBlock(
                            ModBlockSetType.BLISSWOOD,
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.SAND)
                                    .instrument(NoteBlockInstrument.BASS)
                                    .strength(3.0F)
                                    .noOcclusion()
                                    .isValidSpawn(YoaBlocks::never)
                                    .ignitedByLava()
                    )
    );

    public static final DeferredBlock<Block> BLISSWOOD_STAIRS = registerBlock("blisswood_stairs",() -> stair(BLISSWOOD_PLANKS.get()));
    public static final DeferredBlock<Block> POTTED_BLISSWOOD_SAPLING = registerBlock("potted_blisswood_sapling",() -> flowerPot(BLISSWOOD_SAPLING.get()));
    public static final DeferredBlock<Block> BLISSWOOD_BUTTON = registerBlock("blisswood_button",() -> woodenButton(ModBlockSetType.BLISSWOOD));
    public static final DeferredBlock<Block> BLISSWOOD_SLAB = registerBlock(
            "blisswood_slab",() ->
                    new SlabBlock(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.SAND)
                                    .instrument(NoteBlockInstrument.BASS)
                                    .strength(2.0F, 3.0F)
                                    .sound(SoundType.WOOD)
                                    .ignitedByLava()
                    )
    );
    public static final DeferredBlock<FenceGateBlock> BLISSWOOD_FENCE_GATE = registerBlock(
            "blisswood_fence_gate",() ->
                    new FenceGateBlock(
                            ModWoodTypes.BLISSWOOD,
                            BlockBehaviour.Properties.of()
                                    .mapColor(BLISSWOOD_PLANKS.get().defaultMapColor())
                                    .forceSolidOn()
                                    .instrument(NoteBlockInstrument.BASS)
                                    .strength(2.0F, 3.0F)
                                    .ignitedByLava()
                    )
    );
    public static final DeferredBlock<FenceBlock> BLISSWOOD_FENCE = registerBlock(
            "blisswood_fence",() ->
                    new FenceBlock(
                            BlockBehaviour.Properties.of()
                                    .mapColor(BLISSWOOD_PLANKS.get().defaultMapColor())
                                    .instrument(NoteBlockInstrument.BASS)
                                    .strength(2.0F, 3.0F)
                                    .ignitedByLava()
                                    .sound(SoundType.WOOD)
                    )
    );

    public static final DeferredBlock<DoorBlock> BLISSWOOD_DOOR = registerBlock(
            "blisswood_door",() ->
                    new DoorBlock(
                            ModBlockSetType.BLISSWOOD,
                            BlockBehaviour.Properties.of()
                                    .mapColor(BLISSWOOD_PLANKS.get().defaultMapColor())
                                    .instrument(NoteBlockInstrument.BASS)
                                    .strength(3.0F)
                                    .noOcclusion()
                                    .ignitedByLava()
                                    .pushReaction(PushReaction.DESTROY)
                    )
    );











    public static final DeferredBlock<Block> CREAKS_GATE = registerBlock("creaks_gate", () -> new CreaksGateBlock(BlockBehaviour.Properties.of()
            .strength(80.0F,1200F)
            .sound(SoundType.DEEPSLATE).noLootTable()));


    public static final DeferredBlock<Block> CREAKS_PORTAL = registerBlock("creaks_portal", () -> new CreaksPortalBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLACK)
            .noCollission()
            .lightLevel(p_187435_ -> 15)
            .strength(-1.0F, 3600000.0F)
            .noLootTable()
            .pushReaction(PushReaction.BLOCK)));



    public static final DeferredBlock<Block> CREAKSTONE = registerBlock("creakstone", () -> new Block(BlockBehaviour.Properties.of()
            .requiresCorrectToolForDrops()
            .strength(24.0F, 32.0F)
            .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> CREAKSTONE_STAIRS = registerBlock("creakstone_stairs", () -> new StairBlock(() -> YoaBlocks.CREAKSTONE.get().defaultBlockState(), (BlockBehaviour.Properties.ofFullCopy(YoaBlocks.CREAKSTONE.get()).requiresCorrectToolForDrops())));
    public static final DeferredBlock<Block> CREAKSTONE_SLAB = registerBlock("creakstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(YoaBlocks.CREAKSTONE.get()).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> CREAKSTONE_WALL = registerBlock("creakstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(YoaBlocks.CREAKSTONE.get()).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> CREAKSTONE_TILES = registerBlock("creakstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(YoaBlocks.CREAKSTONE.get()).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> CREAKSTONE_TILES_STAIRS = registerBlock("creakstone_tiles_stairs", () -> new StairBlock(() -> YoaBlocks.CREAKSTONE_TILES.get().defaultBlockState(), (BlockBehaviour.Properties.ofFullCopy(YoaBlocks.CREAKSTONE.get()).requiresCorrectToolForDrops())));
    public static final DeferredBlock<Block> CREAKSTONE_TILES_SLAB = registerBlock("creakstone_tiles_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(YoaBlocks.CREAKSTONE.get()).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> CREAKSTONE_TILES_WALL = registerBlock("creakstone_tiles_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(YoaBlocks.CREAKSTONE.get()).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> CRYSTALIC_CREAKSTONE_TILES = registerBlock("crystalic_creakstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(YoaBlocks.CREAKSTONE.get()).requiresCorrectToolForDrops()
            .lightLevel((f) -> 4 ).sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> CRYSTALIC_CREAKSTONE_TILES_STAIRS = registerBlock("crystalic_creakstone_tiles_stairs", () -> new StairBlock(() -> YoaBlocks.CRYSTALIC_CREAKSTONE_TILES.get().defaultBlockState(), (BlockBehaviour.Properties.ofFullCopy(YoaBlocks.CREAKSTONE.get()).requiresCorrectToolForDrops()
            .lightLevel((f) -> 4 ).sound(SoundType.AMETHYST))));
    public static final DeferredBlock<Block> CRYSTALIC_CREAKSTONE_TILES_SLAB = registerBlock("crystalic_creakstone_tiles_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(YoaBlocks.CREAKSTONE.get()).requiresCorrectToolForDrops()
            .lightLevel((f) -> 4 ).sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> CRYSTALIC_CREAKSTONE_TILES_WALL = registerBlock("crystalic_creakstone_tiles_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(YoaBlocks.CREAKSTONE.get()).requiresCorrectToolForDrops()
            .lightLevel((f) -> 4 ).sound(SoundType.AMETHYST)));


    public static final DeferredBlock<Block> CREAKSTONE_FRACTURE = registerBlock("creakstone_fracture", () -> new DropExperienceBlock(UniformInt.of(5, 70),
            BlockBehaviour.Properties.ofFullCopy(YoaBlocks.CREAKSTONE.get()).noLootTable()));

    public static final DeferredBlock<Block> OVERGROWN_CREAKSTONE = registerBlock("overgrown_creakstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(YoaBlocks.CREAKSTONE.get())));

    public static final DeferredBlock<Block> CRYSTALIC_REMNANTS = registerBlock("crystalic_remnants", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).lightLevel((f) -> 14 ).strength(8.0F,12.0F)));


    public static final DeferredBlock<Block> RUNE_CRYSTAL_CLUSTER = registerBlock("rune_crystal_cluster", () -> new RuneCrystalClusterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_CLUSTER).lightLevel((f) -> 4 ).strength(2.0F,0.0F).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> RUNE_CRYSTAL_BLOCK = registerBlock("rune_crystal_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).lightLevel((f) -> 6 ).strength(6.0F,3.0F)));

    public static final DeferredBlock<Block> POINTED_CREAKSTONE = registerBlock("pointed_creakstone", () -> new PointedCreakstone(BlockBehaviour.Properties.ofFullCopy(Blocks.POINTED_DRIPSTONE).strength(4.0F,6.0F)));



    public static final DeferredBlock<Block> ETHERFRLOS = registerBlock("etherflos", () -> new EtherflosBlock(BlockBehaviour.Properties.of().sound(SoundType.BAMBOO_SAPLING).instabreak().noCollission().noOcclusion().lightLevel(blockState -> blockState.getValue(BlockStateProperties.AGE_2) > 1 ? 0: 2)));


    public static final DeferredBlock<Block> CREAKSTONE_IRON_ORE = registerBlock("creakstone_iron_ore", Block.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE).strength(24.0F, 32.0F));

    public static final DeferredBlock<Block> CREAKSTONE_DIAMOND_ORE = registerBlock("creakstone_diamond_ore", Block.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE).strength(24.0F, 32.0F));




    public static final DeferredBlock<Block> SILVER_ORE = registerBlock("silver_ore", Block.Properties.ofFullCopy(Blocks.IRON_ORE).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore", Block.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE));

    public static final DeferredBlock<Block> TITANIUM_ORE = registerBlock("titanium_ore", Block.Properties.ofFullCopy(Blocks.IRON_ORE).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore", Block.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE));
    public static final DeferredBlock<Block> CREAKSTONE_TITANIUM_ORE = registerBlock("creakstone_titanium_ore", Block.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE).strength(24.0F, 32.0F));

    public static final DeferredBlock<Block> BISMUTH_ORE = registerBlock("bismuth_ore", Block.Properties.ofFullCopy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> DEEPSLATE_BISMUTH_ORE = registerBlock("deepslate_bismuth_ore", Block.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE));

    public static final DeferredBlock<Block> WITHERITE_ORE = registerBlock("witherite_ore", () -> new DropExperienceBlock(UniformInt.of(4, 12),BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE)));

    public static final DeferredBlock<Block> IOLITE_ORE = registerBlock("iolite_ore", () -> new DropExperienceBlock(UniformInt.of(5, 30),BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));

    public static final DeferredBlock<Block> ALEXANDRITE_ORE = registerBlock("alexandrite_ore", () -> new DropExperienceBlock(UniformInt.of(10, 60),BlockBehaviour.Properties.ofFullCopy(YoaBlocks.CREAKSTONE.get())
            .strength(22.0F, 36.0F)
    ));

    public static final DeferredBlock<Block> ADAMANTITE_ORE = registerBlock("adamantite_ore", () -> new DropExperienceBlock(UniformInt.of(30, 200),BlockBehaviour.Properties.ofFullCopy(YoaBlocks.CREAKSTONE.get())
            .strength(30.0F, 42.0F)
    ));

    public static final DeferredBlock<Block> BRASS_BLOCK = registerBlock("brass_block", Block.Properties.ofFullCopy(Blocks.COPPER_BLOCK).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> SILVER_BLOCK = registerBlock("silver_block", Block.Properties.ofFullCopy(Blocks.GOLD_BLOCK).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> RAW_SILVER_BLOCK = registerBlock("raw_silver_block", Block.Properties.ofFullCopy(Blocks.GOLD_BLOCK).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> BRONZE_BLOCK = registerBlock("bronze_block", Block.Properties.ofFullCopy(Blocks.GOLD_BLOCK).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> STEEL_BLOCK = registerBlock("steel_block", Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> BISMUTH_BLOCK = registerBlock("bismuth_block", Block.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> RAW_BISMUTH_BLOCK = registerBlock("raw_bismuth_block", Block.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> TITANIUM_BLOCK = registerBlock("titanium_block", Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> RAW_TITANIUM_BLOCK = registerBlock("raw_titanium_block", Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> WITHERITE_BLOCK = registerBlock("witherite_block", Block.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> IOLITE_BLOCK = registerBlock("iolite_block", Block.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block", Block.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> ADAMANTITE_BLOCK = registerBlock("adamantite_block", Block.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> RAW_ADAMANTITE_BLOCK = registerBlock("raw_adamantite_block", Block.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).requiresCorrectToolForDrops());

    public static final DeferredBlock<Block> HAUNTED_LAMP = registerBlock("haunted_lamp", Block.Properties.ofFullCopy(Blocks.GLOWSTONE).requiresCorrectToolForDrops());









    private static <I extends Block> DeferredBlock<I> registerBlock(String name, Supplier<? extends I> block) {
        DeferredBlock<I> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <I extends Block> DeferredBlock<Block> registerNoItemBlock(String name, Supplier<? extends I> block) {
        return BLOCKS.register(name, block);
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
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        YoaItems.ITEMS.registerSimpleBlockItem(name, block);
    }
    private static DeferredBlock<Block> registerCustomItemPropertiesBlock(String name, BlockBehaviour.Properties block, Item.Properties properties){
        DeferredBlock<Block>  toReturn = BLOCKS.registerSimpleBlock(name,block);
        registerCustomBlockItem(name, toReturn, properties);
        return toReturn;
    }
    private static <T extends Block> void registerCustomBlockItem(String name, DeferredBlock<T> block, Item.Properties properties){
        YoaItems.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
    }


    protected static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
        return blockState -> blockState.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
    }

    private static Block log(MapColor pTopMapColor, MapColor pSideMapColor) {
        return new RotatedPillarBlock(
                BlockBehaviour.Properties.of()
                        .mapColor(p_152624_ -> p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? pTopMapColor : pSideMapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F)
                        .sound(SoundType.WOOD)
                        .ignitedByLava()
        );
    }
    private static BlockBehaviour.Properties leaves(SoundType pSoundType) {
        return (
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.PLANT)
                        .strength(0.2F)
                        .randomTicks()
                        .sound(pSoundType)
                        .noOcclusion()
                        .isValidSpawn(YoaBlocks::ocelotOrParrot)
                        .isSuffocating(YoaBlocks::never)
                        .isViewBlocking(YoaBlocks::never)
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY)
                        .isRedstoneConductor(YoaBlocks::never)
        );
    }



    private static Block stair(Block pBaseBlock) {
        return new StairBlock(pBaseBlock.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(pBaseBlock));
    }

    private static Boolean never(BlockState p_50779_, BlockGetter p_50780_, BlockPos p_50781_, EntityType<?> p_50782_) {
        return false;
    }

    private static Boolean always(BlockState p_50810_, BlockGetter p_50811_, BlockPos p_50812_, EntityType<?> p_50813_) {
        return true;
    }


    private static boolean always(BlockState p_50775_, BlockGetter p_50776_, BlockPos p_50777_) {
        return true;
    }

    private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }

    private static Boolean ocelotOrParrot(BlockState p_50822_, BlockGetter p_50823_, BlockPos p_50824_, EntityType<?> p_50825_) {
        return p_50825_ == EntityType.OCELOT || p_50825_ == EntityType.PARROT;
    }


    private static Block woodenButton(BlockSetType pType) {
        return new ButtonBlock(pType, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

    private static Block flowerPot(Block pPotted) {
        return new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, () -> pPotted, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
    }


}
