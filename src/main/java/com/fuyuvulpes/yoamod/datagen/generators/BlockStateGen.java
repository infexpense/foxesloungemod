package com.fuyuvulpes.yoamod.datagen.generators;

import com.fuyuvulpes.yoamod.registries.BlocksModReg;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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
        stairsBlock(((StairBlock) BlocksModReg.CREAKSTONE_STAIRS.get()), blockTexture(BlocksModReg.CREAKSTONE.get()));
        slabBlock(((SlabBlock) BlocksModReg.CREAKSTONE_SLAB.get()), blockTexture(BlocksModReg.CREAKSTONE.get()), blockTexture(BlocksModReg.CREAKSTONE.get()));
        wallBlock(((WallBlock) BlocksModReg.CREAKSTONE_WALL.get()), blockTexture(BlocksModReg.CREAKSTONE.get()));
        blockWithItem(BlocksModReg.CREAKSTONE_FRACTURE);
        blockWithItem(BlocksModReg.CRYSTALIC_REMNANTS);
        blockWithItem(BlocksModReg.RUNE_CRYSTAL_BLOCK);

        axisBlock((RotatedPillarBlock) BlocksModReg.CREAKS_GATE.get(),new ResourceLocation(MODID,"block/creakstone"), new ResourceLocation(MODID, "block/creaks_gate"));
        simpleBlockItem(BlocksModReg.CREAKS_GATE.get(), cubeAll(BlocksModReg.CREAKS_GATE.get()));


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

    }



    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));

    }


}
