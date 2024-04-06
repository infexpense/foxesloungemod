package com.fuyuvulpes.yoamod.game.client.entities.model;

import com.fuyuvulpes.yoamod.world.entity.ToucanEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class ToucanModel<T extends Entity> extends HierarchicalModel<ToucanEntity> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "toucanmodel"), "main");
    private final ModelParts parts;

    public ToucanModel(ModelPart root) {

        ModelPart main = root.getChild("main");
        ModelPart body = main.getChild("body");
        ModelPart head = body.getChild("head");
        ModelPart beak_jaw = head.getChild("beak_jaw");
        ModelPart left_wing = body.getChild("left_wing");
        ModelPart right_wing = body.getChild("right_wing");
        ModelPart tail = body.getChild("tail");
        ModelPart left_leg = main.getChild("left_leg");
        ModelPart right_leg = main.getChild("right_leg");

        this.parts = new ModelParts(main, body, head, beak_jaw, left_wing, right_wing, tail, left_leg, right_leg);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(-0.25F, 24.0F, 0.0F));

        PartDefinition body = main.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 5).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -3.0F, 1.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 0).addBox(-0.5F, -3.0F, -5.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition beak_jaw = head.addOrReplaceChild("beak_jaw", CubeListBuilder.create().texOffs(18, 0).addBox(0.25F, 0.0F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.75F, -2.0F, -1.0F));

        PartDefinition left_wing = body.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(12, 5).addBox(0.0F, -1.0F, -3.0F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -1.5F, 1.5F));

        PartDefinition right_wing = body.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(12, 5).mirror().addBox(-1.0F, -1.0F, -3.0F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, -1.5F, 1.5F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 13).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 1.5F, 0.48F, 0.0F, 0.0F));

        PartDefinition left_leg = main.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(20, 8).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -2.0F, 0.5F));

        PartDefinition right_leg = main.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(20, 8).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, -2.0F, 0.5F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(ToucanEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setupAnim(getState(entity), entity.tickCount, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.parts.main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return this.parts.main;
    }

    public void renderOnShoulder(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pLimbSwing, float pLimbSwingAmount, float pNetHeadYaw, float pHeadPitch, int pTickCount) {
        this.setupAnim(ToucanModel.State.ON_SHOULDER, pTickCount, pLimbSwing, pLimbSwingAmount, 0.0F, pNetHeadYaw, pHeadPitch);
        this.parts.main.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
    }


    private void setupAnim(ToucanModel.State pState, int pTickCount, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        double dtr =  Mth.DEG_TO_RAD;
        this.parts.head.xRot = (float) (pHeadPitch * (Math.PI / 180.0) - (45 * dtr));
        this.parts.head.yRot = (float) (pNetHeadYaw * (Math.PI / 180.0));
        this.parts.head.zRot = 0.0F;
        switch (pState) {
            case SITTING:
                break;
            case STANDING:
                ModelPart theLEG = this.parts.left_leg;
                theLEG.xRot = Mth.cos(pLimbSwing * 0.6662F) * 1.4F * pLimbSwingAmount;
                theLEG = this.parts.right_leg;
                theLEG.xRot = Mth.cos(pLimbSwing * 0.6662F + 3.1415927F) * 1.4F * pLimbSwingAmount;
                this.parts.left_wing.zRot = 0.0F;
                this.parts.right_wing.zRot = 0.0F;
                break;
            case FLYING:
                double m = (Math.sin(pAgeInTicks) * 90 + 45) * dtr;
                this.parts.left_wing.zRot = -0.5f * (float) m + 55.5f;
                this.parts.right_wing.zRot = 0.5f * (float) m - 55.5f;
                this.parts.left_leg.xRot = 0.0F;
                this.parts.right_leg.xRot = 0.0F;
                break;
            case ON_SHOULDER:
            default:
                this.parts.left_wing.zRot = 0.0F;
                this.parts.right_wing.zRot = 0.0F;
        }

    }


    private static ToucanModel.State getState(ToucanEntity pToucan) {
        if (pToucan.isInSittingPose()) {
            return ToucanModel.State.SITTING;
        } else {
            return pToucan.isFlying() ? ToucanModel.State.FLYING : ToucanModel.State.STANDING;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static enum State {
        FLYING,
        STANDING,
        SITTING,
        ON_SHOULDER;

        private State() {
        }
    }

    private record ModelParts(ModelPart main, ModelPart body, ModelPart head, ModelPart beak_jaw, ModelPart left_wing, ModelPart right_wing, ModelPart tail, ModelPart left_leg, ModelPart right_leg) {
}
}
