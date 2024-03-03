package com.fuyuvulpes.yoamod.data.generators;

import com.fuyuvulpes.yoamod.core.registries.BlocksModReg;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class BlockStateGen extends BlockStateProvider {
    public BlockStateGen(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(BlocksModReg.CREAKSTONE);

        makeStoneSet(BlocksModReg.CREAKSTONE, BlocksModReg.CREAKSTONE, BlocksModReg.CREAKSTONE_STAIRS, BlocksModReg.CREAKSTONE_WALL, BlocksModReg.CREAKSTONE_SLAB);

        blockWithItem(BlocksModReg.CREAKSTONE_TILES);

        makeStoneSet(BlocksModReg.CREAKSTONE_TILES, BlocksModReg.CREAKSTONE_TILES, BlocksModReg.CREAKSTONE_TILES_STAIRS, BlocksModReg.CREAKSTONE_TILES_WALL, BlocksModReg.CREAKSTONE_TILES_SLAB);

        blockWithItem(BlocksModReg.CREAKSTONE_FRACTURE);
        blockWithItem(BlocksModReg.CRYSTALIC_REMNANTS);
        blockWithItem(BlocksModReg.RUNE_CRYSTAL_BLOCK);
        blockWithItem(BlocksModReg.CRYSTALIC_CREAKSTONE_TILES);

        makeStoneSet(BlocksModReg.CRYSTALIC_CREAKSTONE_TILES, BlocksModReg.CRYSTALIC_CREAKSTONE_TILES, BlocksModReg.CRYSTALIC_CREAKSTONE_TILES_STAIRS, BlocksModReg.CRYSTALIC_CREAKSTONE_TILES_WALL, BlocksModReg.CRYSTALIC_CREAKSTONE_TILES_SLAB);


        axisBlock((RotatedPillarBlock) BlocksModReg.CREAKS_GATE.get(),new ResourceLocation(MODID,"block/creakstone"), new ResourceLocation(MODID, "block/creaks_gate"));
        blockItem(BlocksModReg.CREAKS_GATE);


        blockWithItem(BlocksModReg.CREAKSTONE_IRON_ORE);
        blockWithItem(BlocksModReg.CREAKSTONE_DIAMOND_ORE);
        blockWithItem(BlocksModReg.CREAKSTONE_TITANIUM_ORE);
        blockWithItem(BlocksModReg.SILVER_ORE);
        blockWithItem(BlocksModReg.DEEPSLATE_SILVER_ORE);
        blockWithItem(BlocksModReg.TITANIUM_ORE);
        blockWithItem(BlocksModReg.DEEPSLATE_TITANIUM_ORE);
        blockWithItem(BlocksModReg.BISMUTH_ORE);
        blockWithItem(BlocksModReg.DEEPSLATE_BISMUTH_ORE);
        blockWithItem(BlocksModReg.WITHERITE_ORE);
        blockWithItem(BlocksModReg.IOLITE_ORE);
        blockWithItem(BlocksModReg.ALEXANDRITE_ORE);
        blockWithItem(BlocksModReg.ADAMANTITE_ORE);

        blockWithItem(BlocksModReg.BRASS_BLOCK);
        blockWithItem(BlocksModReg.SILVER_BLOCK);
        blockWithItem(BlocksModReg.RAW_SILVER_BLOCK);
        blockWithItem(BlocksModReg.BRONZE_BLOCK);
        blockWithItem(BlocksModReg.STEEL_BLOCK);
        blockWithItem(BlocksModReg.BISMUTH_BLOCK);
        blockWithItem(BlocksModReg.RAW_BISMUTH_BLOCK);
        blockWithItem(BlocksModReg.TITANIUM_BLOCK);
        blockWithItem(BlocksModReg.RAW_TITANIUM_BLOCK);
        blockWithItem(BlocksModReg.WITHERITE_BLOCK);
        blockWithItem(BlocksModReg.IOLITE_BLOCK);
        blockWithItem(BlocksModReg.ALEXANDRITE_BLOCK);
        blockWithItem(BlocksModReg.ADAMANTITE_BLOCK);
        blockWithItem(BlocksModReg.RAW_ADAMANTITE_BLOCK);

        blockWithItem((BlocksModReg.HAUNTED_LAMP));

    }



    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));

    }


    private void makeStoneSet(DeferredBlock<Block> texture,DeferredBlock<Block> sideTexture, DeferredBlock<Block> stairs, DeferredBlock<Block> wall, DeferredBlock<Block> slab){
        makeStairs(stairs,texture);
        makeSlab(slab,sideTexture,texture);
        makeWall(wall,texture);
    }

    private void makeStairs(DeferredBlock<Block> deferredBlock,DeferredBlock<Block> texture){
        stairsBlock(((StairBlock) deferredBlock.get()), blockTexture(texture.get()));
        simpleBlockItem(deferredBlock.get(), models().stairs(name(deferredBlock.get()), blockTexture(texture.get()), blockTexture(texture.get()), blockTexture(texture.get())));

    }

    private void makeSlab(DeferredBlock<Block> deferredBlock, DeferredBlock<Block> doubleSlab, DeferredBlock<Block> halfSlab){
        slabBlock(((SlabBlock) deferredBlock.get()), blockTexture(doubleSlab.get()), blockTexture(halfSlab.get()));
        simpleBlockItem(deferredBlock.get(), models().slab(name(deferredBlock.get()), blockTexture(doubleSlab.get()), blockTexture(halfSlab.get()), blockTexture(halfSlab.get())));

    }
    private void makeWall(DeferredBlock<Block> deferredBlock, DeferredBlock<Block> texture){
        wallBlock(((WallBlock) deferredBlock.get()), blockTexture(texture.get()));
        simpleBlockItem(deferredBlock.get(), models().wallInventory(name(deferredBlock.get()) + "_inventory", blockTexture(texture.get())));

    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), cubeAll(deferredBlock.get()));

    }

    private String name(Block block) {
        return key(block).getPath();
    }


    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }



}
