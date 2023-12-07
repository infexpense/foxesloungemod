package com.fuyuvulpes.yoamod.client.entities.renderers;

import com.fuyuvulpes.yoamod.custom.entity.block.ForgingTableBlockEntity;
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

public class ForgingTableRenderer implements BlockEntityRenderer<ForgingTableBlockEntity> {
    public static final Material MATERIAL = new Material(TextureAtlas.LOCATION_BLOCKS,new ResourceLocation(MODID,"textures/entity/forging_table.png"));
    private final ForgingTableModel model;

    public ForgingTableRenderer(BlockEntityRendererProvider.Context context){
        this.model = new ForgingTableModel(context.bakeLayer(ForgingTableModel.LAYER_LOCATION));
    }

    @Override
    public void render(ForgingTableBlockEntity p_112307_, float p_112308_, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        VertexConsumer vertexconsumer = MATERIAL.buffer(bufferSource, RenderType::entityCutoutNoCull);
        model.renderToBuffer(poseStack, vertexconsumer, packedLight, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
    }



    public static class ForgingTableModel extends Model{

        public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MODID, "forging_table"),"main");

        private final ModelPart root;

        public ForgingTableModel(ModelPart root) {
            super(RenderType::entityCutoutNoCull);
            this.root = root.getChild("root");
        }



        public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(62, 7).addBox(-1.0F, -10.0F, 4.0F, 12.0F, 10.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-16.0F, -13.0F, 0.0F, 15.0F, 13.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(54, 55).addBox(-14.0F, -15.0F, 1.0F, 11.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 38).addBox(-28.0F, -11.0F, 1.0F, 12.0F, 11.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(0, 29).addBox(-27.0F, -21.0F, 12.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 29).addBox(-19.0F, -21.0F, 12.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 29).addBox(-25.0F, -20.0F, 12.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(46, 0).addBox(-27.0F, -12.0F, 5.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(46, 0).addBox(-21.0F, -12.0F, 5.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(74, 0).addBox(-11.0F, -22.0F, 10.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(86, 0).addBox(-11.0F, -23.0F, 9.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(104, 0).addBox(1.0F, -3.0F, 2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(96, 0).addBox(7.0F, -3.0F, 2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = root.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(66, 0).addBox(0.0F, -12.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, -13.0F, 13.0F, 0.0F, 0.0F, 0.3927F));

        PartDefinition cube_r2 = root.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(66, 0).mirror().addBox(-2.0F, -12.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -13.0F, 13.0F, 0.0F, 0.0F, -0.3927F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
            root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);

        }
    }
}
