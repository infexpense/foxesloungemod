package com.fuyuvulpes.yoamod.data.generators;

import com.fuyuvulpes.yoamod.core.registries.YoaBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
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

        blockWithItem(YoaBlocks.CREAKSTONE);

        makeStoneSet(YoaBlocks.CREAKSTONE, YoaBlocks.CREAKSTONE, YoaBlocks.CREAKSTONE_STAIRS, YoaBlocks.CREAKSTONE_WALL, YoaBlocks.CREAKSTONE_SLAB);

        blockWithItem(YoaBlocks.CREAKSTONE_TILES);

        makeStoneSet(YoaBlocks.CREAKSTONE_TILES, YoaBlocks.CREAKSTONE_TILES, YoaBlocks.CREAKSTONE_TILES_STAIRS, YoaBlocks.CREAKSTONE_TILES_WALL, YoaBlocks.CREAKSTONE_TILES_SLAB);

        blockWithItem(YoaBlocks.CREAKSTONE_FRACTURE);
        blockWithItem(YoaBlocks.CRYSTALIC_REMNANTS);
        blockWithItem(YoaBlocks.RUNE_CRYSTAL_BLOCK);
        blockWithItem(YoaBlocks.CRYSTALIC_CREAKSTONE_TILES);

        makeStoneSet(YoaBlocks.CRYSTALIC_CREAKSTONE_TILES, YoaBlocks.CRYSTALIC_CREAKSTONE_TILES, YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_STAIRS, YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_WALL, YoaBlocks.CRYSTALIC_CREAKSTONE_TILES_SLAB);


        axisBlock((RotatedPillarBlock) YoaBlocks.CREAKS_GATE.get(),new ResourceLocation(MODID,"block/creakstone"), new ResourceLocation(MODID, "block/creaks_gate"));
        blockItem(YoaBlocks.CREAKS_GATE);

        blockWithItem(YoaBlocks.BLISSWOOD_PLANKS);
        logBlock((RotatedPillarBlock) YoaBlocks.BLISSWOOD_LOG.get());
        axisBlock((RotatedPillarBlock) YoaBlocks.BLISSWOOD_WOOD.get(),
                new ResourceLocation(MODID,"block/blisswood_log"),
                new ResourceLocation(MODID,"block/blisswood_log"));
        logBlock((RotatedPillarBlock) YoaBlocks.STRIPPED_BLISSWOOD_LOG.get());
        axisBlock((RotatedPillarBlock) YoaBlocks.STRIPPED_BLISSWOOD_WOOD.get(),
                new ResourceLocation(MODID,"block/stripped_blisswood_log"),
                new ResourceLocation(MODID,"block/stripped_blisswood_log"));
        makeStairs(YoaBlocks.BLISSWOOD_STAIRS, YoaBlocks.BLISSWOOD_PLANKS);
        makeSlab(YoaBlocks.BLISSWOOD_SLAB, YoaBlocks.BLISSWOOD_PLANKS, YoaBlocks.BLISSWOOD_PLANKS);
        makeFence(YoaBlocks.BLISSWOOD_FENCE, YoaBlocks.BLISSWOOD_PLANKS);
        fenceGateBlock(YoaBlocks.BLISSWOOD_FENCE_GATE.get(),
                new ResourceLocation(MODID,"block/blisswood_planks"));
        buttonBlock((ButtonBlock) YoaBlocks.BLISSWOOD_BUTTON.get(),
                new ResourceLocation(MODID,"block/blisswood_planks"));
        pressurePlateBlock(YoaBlocks.BLISSWOOD_PRESSURE_PLATE.get(),
                new ResourceLocation(MODID,"block/blisswood_planks"));
        signBlock((StandingSignBlock) YoaBlocks.BLISSWOOD_SIGN.get(),
                (WallSignBlock) YoaBlocks.BLISSWOOD_WALL_SIGN.get(),
                new ResourceLocation(MODID,"block/blisswood_planks"));
        plantBlock(YoaBlocks.BLISSWOOD_SAPLING.get(), YoaBlocks.POTTED_BLISSWOOD_SAPLING.get(),
                new ResourceLocation(MODID,"block/blisswood_sapling"));
        doorBlock(YoaBlocks.BLISSWOOD_DOOR.get(),
                new ResourceLocation(MODID,"block/blisswood_door_bottom"),
                new ResourceLocation(MODID,"block/blisswood_door_top"));
        trapdoorBlock(YoaBlocks.BLISSWOOD_TRAPDOOR.get(),
                new ResourceLocation(MODID,"block/blisswood_trapdoor"),
                true);
        blockItem(YoaBlocks.BLISSWOOD_LOG);
        blockItem(YoaBlocks.BLISSWOOD_WOOD);
        blockItem(YoaBlocks.STRIPPED_BLISSWOOD_LOG);
        blockItem(YoaBlocks.STRIPPED_BLISSWOOD_WOOD);
        blockItem(YoaBlocks.BLISSWOOD_FENCE_GATE);

        blockWithItem(YoaBlocks.CREAKSTONE_IRON_ORE);
        blockWithItem(YoaBlocks.CREAKSTONE_DIAMOND_ORE);
        blockWithItem(YoaBlocks.CREAKSTONE_TITANIUM_ORE);
        blockWithItem(YoaBlocks.SILVER_ORE);
        blockWithItem(YoaBlocks.DEEPSLATE_SILVER_ORE);
        blockWithItem(YoaBlocks.TITANIUM_ORE);
        blockWithItem(YoaBlocks.DEEPSLATE_TITANIUM_ORE);
        blockWithItem(YoaBlocks.BISMUTH_ORE);
        blockWithItem(YoaBlocks.DEEPSLATE_BISMUTH_ORE);
        blockWithItem(YoaBlocks.WITHERITE_ORE);
        blockWithItem(YoaBlocks.IOLITE_ORE);
        blockWithItem(YoaBlocks.ALEXANDRITE_ORE);
        blockWithItem(YoaBlocks.ADAMANTITE_ORE);

        blockWithItem(YoaBlocks.BRASS_BLOCK);
        blockWithItem(YoaBlocks.SILVER_BLOCK);
        blockWithItem(YoaBlocks.RAW_SILVER_BLOCK);
        blockWithItem(YoaBlocks.BRONZE_BLOCK);
        blockWithItem(YoaBlocks.STEEL_BLOCK);
        blockWithItem(YoaBlocks.BISMUTH_BLOCK);
        blockWithItem(YoaBlocks.RAW_BISMUTH_BLOCK);
        blockWithItem(YoaBlocks.TITANIUM_BLOCK);
        blockWithItem(YoaBlocks.RAW_TITANIUM_BLOCK);
        blockWithItem(YoaBlocks.WITHERITE_BLOCK);
        blockWithItem(YoaBlocks.IOLITE_BLOCK);
        blockWithItem(YoaBlocks.ALEXANDRITE_BLOCK);
        blockWithItem(YoaBlocks.ADAMANTITE_BLOCK);
        blockWithItem(YoaBlocks.RAW_ADAMANTITE_BLOCK);

        blockWithItem((YoaBlocks.HAUNTED_LAMP));

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
    private void makeFence(DeferredBlock<FenceBlock> deferredBlock, DeferredBlock<Block> texture){
        fenceBlock(((FenceBlock) deferredBlock.get()), blockTexture(texture.get()));

    }

    private<T extends Block> void blockItem(DeferredBlock<T> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), models().getExistingFile(new ResourceLocation(MODID,name(deferredBlock.get()))));

    }


    public void plantBlock(Block block,Block potBLock, ResourceLocation texture) {
        ModelFile sign = models().cross(name(block), texture);
        models().getBuilder(key(potBLock).getPath()).texture("plant",texture).parent(models().getExistingFile(new ResourceLocation("block/flower_pot_cross")));
        cross(block, sign);
    }

    public void cross(Block block, ResourceLocation texture) {
        ModelFile blockModel = models().cross(name(block), texture);
        cross(block, blockModel);

    }

    public void cross(Block block, ModelFile blockModel) {
        simpleBlock(block, blockModel);
    }



    private String name(Block block) {
        return key(block).getPath();
    }


    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }






}
