package com.fuyuvulpes.yoamod.game.client.entities.model;

import com.fuyuvulpes.yoamod.world.entity.ArmedSpider;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class ArmedSpiderModel<T extends ArmedSpider> extends HierarchicalModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MODID, "armed_spider"), "main");
    private final ArmedSpiderModel.ModelParts parts;

    public ArmedSpiderModel(ModelPart pRoot) {
        ModelPart root = pRoot.getChild("main");
        ModelPart body = root.getChild("body");
        ModelPart right_fangs = body.getChild("right_fang");
        ModelPart left_fangs = body.getChild("left_fang");
        ModelPart left_arm = body.getChild("left_arm");
        ModelPart left_arm_end = left_arm.getChild("left_arm_end");
        ModelPart right_arm = body.getChild("right_arm");
        ModelPart right_arm_end = right_arm.getChild("right_arm_end");
        ModelPart butt = root.getChild("butt");
        ModelPart left_legs = root.getChild("left_legs");
        ModelPart left_leg_a = left_legs.getChild("left_leg_a");
        ModelPart left_leg_a_mid = left_leg_a.getChild("left_leg_mid_a");
        ModelPart left_leg_b = left_legs.getChild("left_leg_b");
        ModelPart left_leg_b_mid = left_leg_b.getChild("left_leg_mid_b");
        ModelPart left_leg_c = left_legs.getChild("left_leg_c");
        ModelPart left_leg_c_mid = left_leg_c.getChild("left_leg_mid_c");
        ModelPart left_leg_d = left_legs.getChild("left_leg_d");
        ModelPart left_leg_d_mid = left_leg_d.getChild("left_leg_mid_d");
        ModelPart right_legs = root.getChild("right_legs");
        ModelPart right_leg_a = right_legs.getChild("right_leg_a");
        ModelPart right_leg_a_mid = right_leg_a.getChild("right_leg_mid_a");
        ModelPart right_leg_b = right_legs.getChild("right_leg_b");
        ModelPart right_leg_b_mid = right_leg_b.getChild("right_leg_mid_b");
        ModelPart right_leg_c = right_legs.getChild("right_leg_c");
        ModelPart right_leg_c_mid = right_leg_c.getChild("right_leg_mid_c");
        ModelPart right_leg_d = right_legs.getChild("right_leg_d");
        ModelPart right_leg_d_mid = right_leg_d.getChild("right_leg_mid_d");
        this.parts = new ArmedSpiderModel.ModelParts(root,body,right_fangs,left_fangs,
                left_arm,left_arm_end,right_arm,right_arm_end,butt,left_legs,left_leg_a,left_leg_a_mid,
                left_leg_b,left_leg_b_mid,left_leg_c,left_leg_c_mid,left_leg_d,left_leg_d_mid,
                right_legs,right_leg_a,right_leg_a_mid,right_leg_b,right_leg_b_mid,right_leg_c,right_leg_c_mid,right_leg_d,right_leg_d_mid);
    }
    @Override
    public ModelPart root() {
        return this.parts.root;
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = main.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 12).addBox(-7.0F, -6.0F, -7.0F, 14.0F, 6.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 32).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.0F, 0.0F));

        PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(56, 26).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -1.0F, -6.0F, -0.7854F, 0.0F, -0.5672F));

        PartDefinition right_arm_end = right_arm.addOrReplaceChild("right_arm_end", CubeListBuilder.create().texOffs(74, 26).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, 1.9199F, 0.0F, 0.0F));

        PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(56, 26).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -1.0F, -6.0F, -0.7854F, 0.0F, 0.5672F));

        PartDefinition left_arm_end = left_arm.addOrReplaceChild("left_arm_end", CubeListBuilder.create().texOffs(74, 26).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, 1.9199F, 0.0F, 0.0F));

        PartDefinition right_fang = body.addOrReplaceChild("right_fang", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-2.0F, -2.0F, -4.5F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -1.0F, -6.0F, 0.0F, 0.0F, -0.2182F));

        PartDefinition left_fang = body.addOrReplaceChild("left_fang", CubeListBuilder.create().texOffs(40, 0).addBox(-2.0F, -2.0F, -4.5F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.0F, -6.0F, 0.0F, 0.0F, 0.2182F));

        PartDefinition butt = main.addOrReplaceChild("butt", CubeListBuilder.create().texOffs(60, 8).addBox(-1.5F, -2.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(72, 0).addBox(-5.5F, -5.5F, 2.0F, 11.0F, 9.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -20.0F, 8.0F, 0.48F, 0.0F, 0.0F));

        PartDefinition left_legs = main.addOrReplaceChild("left_legs", CubeListBuilder.create(), PartPose.offset(0.0F, -18.0F, 0.0F));

        PartDefinition left_leg_a = left_legs.addOrReplaceChild("left_leg_a", CubeListBuilder.create().texOffs(0, 53).addBox(0.0F, -2.0F, -2.0F, 17.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -1.0F, -5.0F, 0.0F, 0.5236F, -0.1745F));

        PartDefinition left_leg_mid_a = left_leg_a.addOrReplaceChild("left_leg_mid_a", CubeListBuilder.create().texOffs(42, 53).addBox(0.0F, -2.0F, -2.0F, 30.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0472F));

        PartDefinition left_leg_b = left_legs.addOrReplaceChild("left_leg_b", CubeListBuilder.create().texOffs(0, 53).addBox(0.0F, -2.0F, -2.0F, 17.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -1.0F, -1.0F, 0.0F, 0.0873F, -0.1745F));

        PartDefinition left_leg_mid_b = left_leg_b.addOrReplaceChild("left_leg_mid_b", CubeListBuilder.create().texOffs(42, 53).addBox(0.0F, -2.0F, -2.0F, 30.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0472F));

        PartDefinition left_leg_c = left_legs.addOrReplaceChild("left_leg_c", CubeListBuilder.create().texOffs(0, 53).addBox(0.0F, -2.0F, -2.0F, 17.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -1.0F, 3.0F, 0.0F, -0.3054F, -0.1745F));

        PartDefinition left_leg_mid_c = left_leg_c.addOrReplaceChild("left_leg_mid_c", CubeListBuilder.create().texOffs(42, 53).addBox(0.0F, -2.0F, -2.0F, 30.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0472F));

        PartDefinition left_leg_d = left_legs.addOrReplaceChild("left_leg_d", CubeListBuilder.create().texOffs(0, 53).addBox(0.0F, -2.0F, -2.0F, 17.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -1.0F, 7.0F, 0.0F, -0.6981F, -0.1745F));

        PartDefinition left_leg_mid_d = left_leg_d.addOrReplaceChild("left_leg_mid_d", CubeListBuilder.create().texOffs(42, 53).addBox(0.0F, -2.0F, -2.0F, 30.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0472F));

        PartDefinition right_legs = main.addOrReplaceChild("right_legs", CubeListBuilder.create(), PartPose.offset(0.0F, -18.0F, 0.0F));

        PartDefinition right_leg_a = right_legs.addOrReplaceChild("right_leg_a", CubeListBuilder.create().texOffs(0, 53).mirror().addBox(-17.0F, -2.0F, -2.0F, 17.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -1.0F, -5.0F, 0.0F, -0.5236F, 0.1745F));

        PartDefinition right_leg_mid_a = right_leg_a.addOrReplaceChild("right_leg_mid_a", CubeListBuilder.create().texOffs(42, 53).mirror().addBox(-30.0F, -2.0F, -2.0F, 30.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-17.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0472F));

        PartDefinition right_leg_b = right_legs.addOrReplaceChild("right_leg_b", CubeListBuilder.create().texOffs(0, 53).mirror().addBox(-17.0F, -2.0F, -2.0F, 17.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -1.0F, -1.0F, 0.0F, -0.0873F, 0.1745F));

        PartDefinition right_leg_mid_b = right_leg_b.addOrReplaceChild("right_leg_mid_b", CubeListBuilder.create().texOffs(42, 53).mirror().addBox(-30.0F, -2.0F, -2.0F, 30.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-17.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0472F));

        PartDefinition right_leg_c = right_legs.addOrReplaceChild("right_leg_c", CubeListBuilder.create().texOffs(0, 53).mirror().addBox(-17.0F, -2.0F, -2.0F, 17.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -1.0F, 3.0F, 0.0F, 0.3054F, 0.1745F));

        PartDefinition right_leg_mid_c = right_leg_c.addOrReplaceChild("right_leg_mid_c", CubeListBuilder.create().texOffs(42, 53).mirror().addBox(-30.0F, -2.0F, -2.0F, 30.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-17.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0472F));

        PartDefinition right_leg_d = right_legs.addOrReplaceChild("right_leg_d", CubeListBuilder.create().texOffs(0, 53).mirror().addBox(-17.0F, -2.0F, -2.0F, 17.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -1.0F, 7.0F, 0.0F, 0.6981F, 0.1745F));

        PartDefinition right_leg_mid_d = right_leg_d.addOrReplaceChild("right_leg_mid_d", CubeListBuilder.create().texOffs(42, 53).mirror().addBox(-30.0F, -2.0F, -2.0F, 30.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-17.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0472F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }
    @Override
    public void setupAnim(T entity, float pLimbSwing, float pLimbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        parts.butt.xRot = (float) (Math.cos(ageInTicks / 10) * 0.02) + (27.5F * Mth.DEG_TO_RAD);
        parts.body.y = (float) (Math.sin(ageInTicks / 10) * 0.3) - 18.0F;
        float f3 = -(Mth.cos(pLimbSwing) * 0.4F) * pLimbSwingAmount;
        float f4 = -(Mth.cos(pLimbSwing + (float) Math.PI) * 0.4F) * pLimbSwingAmount;
        float f5 = -(Mth.cos(pLimbSwing + (float) (Math.PI / 2)) * 0.4F) * pLimbSwingAmount;
        float f6 = -(Mth.cos(pLimbSwing + (float) (Math.PI * 3.0 / 2.0)) * 0.4F) * pLimbSwingAmount;
        float f7 = Math.abs(Mth.sin(pLimbSwing) * 0.4F) * pLimbSwingAmount;
        float f8 = Math.abs(Mth.sin(pLimbSwing + (float) Math.PI) * 0.4F) * pLimbSwingAmount;
        float f9 = Math.abs(Mth.sin(pLimbSwing + (float) (Math.PI / 2)) * 0.4F) * pLimbSwingAmount;
        float f10 = Math.abs(Mth.sin(pLimbSwing + (float) (Math.PI * 3.0 / 2.0)) * 0.4F) * pLimbSwingAmount;
        parts.rightLegD.yRot = f3 + (40F * Mth.DEG_TO_RAD);
        parts.leftLegD.yRot = (f3) - (40F * Mth.DEG_TO_RAD);
        parts.rightLegC.yRot = f4 + (17.5F * Mth.DEG_TO_RAD);
        parts.leftLegC.yRot = (f4) - (17.5F * Mth.DEG_TO_RAD);
        parts.rightLegB.yRot = f5 - (5F * Mth.DEG_TO_RAD);
        parts.leftLegB.yRot = (f5) + (5F * Mth.DEG_TO_RAD);
        parts.rightLegA.yRot = f6 - (30F * Mth.DEG_TO_RAD);
        parts.leftLegA.yRot = (f6) + (30F * Mth.DEG_TO_RAD);
        parts.rightLegD.zRot = f7 + (10 * Mth.DEG_TO_RAD);
        parts.leftLegD.zRot = (f7) - (10 * Mth.DEG_TO_RAD);
        parts.rightLegC.zRot = f8 + (10 * Mth.DEG_TO_RAD);
        parts.leftLegC.zRot = (f8) - (10 * Mth.DEG_TO_RAD);
        parts.rightLegB.zRot = f9 + (10 * Mth.DEG_TO_RAD);
        parts.leftLegB.zRot = (f9) - (10 * Mth.DEG_TO_RAD);
        parts.rightLegA.zRot = f10 + (10 * Mth.DEG_TO_RAD);
        parts.leftLegA.zRot = (f10) - (10 * Mth.DEG_TO_RAD);
        parts.rightLegDMid.zRot = f7 - (60 * Mth.DEG_TO_RAD);
        parts.leftLegDMid.zRot = (f7) + (60 * Mth.DEG_TO_RAD);
        parts.rightLegCMid.zRot = f8 - (60 * Mth.DEG_TO_RAD);
        parts.leftLegCMid.zRot = (f8) + (60 * Mth.DEG_TO_RAD);
        parts.rightLegBMid.zRot = f9 - (60 * Mth.DEG_TO_RAD);
        parts.leftLegBMid.zRot = (f9) + (60 * Mth.DEG_TO_RAD);
        parts.rightLegAMid.zRot = f10 - (60 * Mth.DEG_TO_RAD);
        parts.leftLegAMid.zRot = (f10) + (60 * Mth.DEG_TO_RAD);

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.parts.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public record ModelParts(ModelPart root, ModelPart body, ModelPart rightFangs, ModelPart leftFangs,
                             ModelPart leftArm, ModelPart leftArmEnd, ModelPart rightArm, ModelPart rightArmEnd,
                             ModelPart butt, ModelPart leftLegs, ModelPart leftLegA, ModelPart leftLegAMid,
                             ModelPart leftLegB, ModelPart leftLegBMid, ModelPart leftLegC, ModelPart leftLegCMid,
                             ModelPart leftLegD, ModelPart leftLegDMid, ModelPart rightLegs, ModelPart rightLegA,
                             ModelPart rightLegAMid, ModelPart rightLegB, ModelPart rightLegBMid, ModelPart rightLegC,
                             ModelPart rightLegCMid, ModelPart rightLegD, ModelPart rightLegDMid) {
    }
}
