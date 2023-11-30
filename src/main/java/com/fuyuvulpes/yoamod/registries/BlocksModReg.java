package com.fuyuvulpes.yoamod.registries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class BlocksModReg {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);


    public static final DeferredBlock<Block> EXAMPLE_BLOCK = registerBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));










    private static  DeferredBlock<Block> registerBlock(String name, BlockBehaviour.Properties block){
        DeferredBlock<Block> toReturn = BLOCKS.registerBlock(name,block);
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
