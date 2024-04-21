package com.fuyuvulpes.yoamod.game.client.entities.model;

import com.fuyuvulpes.yoamod.world.entity.BeetleEntity;
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

public class BeetleModel<T extends Entity> extends HierarchicalModel<BeetleEntity> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "model"), "main");
    private final ModelParts parts;

    public BeetleModel(ModelPart root) {
        ModelPart main = root.getChild("main");
        ModelPart left_flap = main.getChild("left_flap");
        ModelPart right_flap = main.getChild("right_flap");
        ModelPart left_wing = main.getChild("left_wing");
        ModelPart right_wing = main.getChild("right_wing");
        ModelPart head = main.getChild("head");
        ModelPart left_antenna = head.getChild("left_antenna");
        ModelPart right_antenna = head.getChild("right_antenna");
        ModelPart front_left_leg = main.getChild("front_left_leg");
        ModelPart front_right_leg = main.getChild("front_right_leg");
        ModelPart middle_left_leg = main.getChild("middle_left_leg");
        ModelPart middle_right_leg = main.getChild("middle_right_leg");
        ModelPart back_left_leg = main.getChild("back_left_leg");
        ModelPart back_right_leg = main.getChild("back_right_leg");

        this.parts = new ModelParts(main,left_flap, right_flap, left_wing, right_wing, head, left_antenna, right_antenna, front_left_leg, front_right_leg, middle_left_leg, middle_right_leg, back_left_leg, back_right_leg);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(6, 5).addBox(-2.0F, -2.25F, -2.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 0.0F));

        PartDefinition left_flap = main.addOrReplaceChild("left_flap", CubeListBuilder.create().texOffs(5, 0).addBox(-1.8333F, -0.1667F, -0.1333F, 2.0F, 0.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(14, -5).addBox(0.1667F, -0.1667F, -0.1333F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(5, 0).addBox(-1.8333F, -0.1667F, 4.8667F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0333F, -2.2833F, -1.6667F));

        PartDefinition right_flap = main.addOrReplaceChild("right_flap", CubeListBuilder.create().texOffs(5, 0).mirror().addBox(-0.0667F, -0.0667F, -0.0333F, 2.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(14, -5).mirror().addBox(-0.0667F, -0.0667F, -0.0333F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(5, 0).mirror().addBox(-0.0667F, -0.0667F, 4.9667F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.1333F, -2.3833F, -1.7667F));

        PartDefinition left_wing = main.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(-4, 0).addBox(-2.0F, 0.2F, -0.2F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.1F, -2.45F, -0.7F));

        PartDefinition right_wing = main.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(-4, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.1F, -2.25F, -0.9F));

        PartDefinition head = main.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 5).addBox(-1.5F, -2.0F, -4.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition left_antenna = head.addOrReplaceChild("left_antenna", CubeListBuilder.create().texOffs(20, 3).addBox(-0.75F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.15F, -2.25F, -2.8F, 0.0F, 0.0F, 0.3491F));

        PartDefinition right_antenna = head.addOrReplaceChild("right_antenna", CubeListBuilder.create().texOffs(20, 3).mirror().addBox(-0.1F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.3F, -2.25F, -2.8F, 0.0F, 0.0F, -0.3491F));

        PartDefinition front_right_leg = main.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(4, 2).addBox(-1.9F, -1.0F, -1.9F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition front_left_leg = main.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(4, 2).mirror().addBox(0.9F, -1.0F, -1.9F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition middle_right_leg = main.addOrReplaceChild("middle_right_leg", CubeListBuilder.create().texOffs(4, 2).addBox(-1.9F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition middle_left_leg = main.addOrReplaceChild("middle_left_leg", CubeListBuilder.create().texOffs(4, 2).mirror().addBox(0.9F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition back_right_leg = main.addOrReplaceChild("back_right_leg", CubeListBuilder.create().texOffs(4, 2).addBox(-1.9F, -1.0F, 1.9F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition back_left_leg = main.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(4, 2).mirror().addBox(0.9F, -1.0F, 1.9F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 24, 24);
    }

    @Override
    public void setupAnim(BeetleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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

    private static BeetleModel.State getState(BeetleEntity pBeetle) {
        return pBeetle.isFlying() ? BeetleModel.State.FLYING : BeetleModel.State.STANDING;
        }

    private void setupAnim(BeetleModel.State pState, int pTickCount, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        double dtr =  Mth.DEG_TO_RAD;
        this.parts.head.xRot = 0.0F;
        this.parts.head.yRot = 0.0F;
        this.parts.head.zRot = 0.0F;
        switch (pState) {
            case FLYING:
                double m = (Math.sin(pAgeInTicks * 3.5) * 90 + 45) * dtr;
                this.parts.left_flap.zRot = -0.6F;
                this.parts.left_flap.yRot = 0.6F;
                this.parts.left_flap.xRot = 0.3F;
                this.parts.right_flap.zRot = 0.6F;
                this.parts.right_flap.yRot = -0.6F;
                this.parts.right_flap.xRot = 0.3F;
                this.parts.left_wing.zRot = 0.075f * (float) m - 0.29f;
                this.parts.left_wing.yRot = 0.01f * (float) m + 0.4f;
                this.parts.left_wing.xRot = -0.1f * (float) m + 0.25f;
                this.parts.right_wing.zRot = -0.075f * (float) m + 0.29f;
                this.parts.right_wing.yRot = -0.01f * (float) m - 0.4f;
                this.parts.right_wing.xRot = -0.1f * (float) m + 0.25f;
                break;
            default:
                this.parts.left_wing.zRot = 0.0F;
                this.parts.left_wing.yRot = 0.0F;
                this.parts.left_wing.xRot = 0.0F;
                this.parts.right_wing.zRot = 0.0F;
                this.parts.right_wing.yRot = 0.0F;
                this.parts.right_wing.xRot = 0.0F;
                this.parts.left_flap.zRot = 0.0F;
                this.parts.left_flap.yRot = 0.0F;
                this.parts.right_flap.zRot = 0.0F;
                this.parts.right_flap.yRot = 0.0F;
        }

    }

@OnlyIn(Dist.CLIENT)
public static enum State {
    FLYING,
    STANDING;

    private State() {
    }
}

    private record ModelParts(ModelPart main, ModelPart left_flap, ModelPart right_flap, ModelPart left_wing, ModelPart right_wing, ModelPart head, ModelPart left_antenna, ModelPart right_antenna, ModelPart front_left_leg, ModelPart front_right_leg, ModelPart middle_left_leg, ModelPart middle_right_leg, ModelPart back_left_leg, ModelPart back_right_leg){}
}