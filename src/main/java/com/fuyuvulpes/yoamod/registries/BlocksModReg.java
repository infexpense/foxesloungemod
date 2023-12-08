package com.fuyuvulpes.yoamod.registries;

import com.fuyuvulpes.yoamod.custom.block.AugmentingTableBlock;
import com.fuyuvulpes.yoamod.custom.block.HammeringStationBlock;
import com.fuyuvulpes.yoamod.custom.block.MeltingPotBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class BlocksModReg {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);


    public static final DeferredBlock<Block> HAMMERING_STATION = registerBlock("hammering_station", HammeringStationBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noOcclusion());

    public static final DeferredBlock<Block> AUGMENTING_STATION = registerBlock("augmenting_station", AugmentingTableBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noOcclusion());

    public static final DeferredBlock<Block> MELTING_POT = registerBlock("melting_pot", MeltingPotBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noOcclusion());










    private static  DeferredBlock<Block> registerBlock(String name, BlockBehaviour.Properties block){
        DeferredBlock<Block> toReturn = BLOCKS.registerBlock(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    } private static  DeferredBlock<Block> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends Block> func, BlockBehaviour.Properties block){
        DeferredBlock<Block> toReturn = BLOCKS.registerBlock(name,func,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> DeferredItem<BlockItem> registerBlockItem(String name, DeferredBlock<T> block){
        return ItemsModReg.ITEMS.registerBlockItem(name, block);
    }
    private static DeferredBlock<Block> registerCustomItemPropertiesBlock(String name, BlockBehaviour.Properties block, Item.Properties properties){
        DeferredBlock<Block>  toReturn = BLOCKS.registerBlock(name,block);
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
