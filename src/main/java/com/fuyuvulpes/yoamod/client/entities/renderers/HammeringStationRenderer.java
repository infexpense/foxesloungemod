package com.fuyuvulpes.yoamod.client.entities.renderers;

import com.fuyuvulpes.yoamod.custom.entity.block.HammeringStationBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class HammeringStationRenderer implements BlockEntityRenderer<HammeringStationBlockEntity> {

    public HammeringStationRenderer(BlockEntityRendererProvider.Context context){
    }

    @Override
    public void render(HammeringStationBlockEntity p_112307_, float p_112308_, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
    }


}
