package com.fuyuvulpes.yoamod.game.client.entities.model;

import com.fuyuvulpes.yoamod.world.entity.vehicle.PlaneEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class PlaneModel<T extends PlaneEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MODID, "airplane"), "main");

    public final PlaneModel.ModelParts parts;
    public PlaneModel(ModelPart pRoot) {
        ModelPart root = pRoot.getChild("root");
        ModelPart propeller = root.getChild("propeller");
        ModelPart rigid = root.getChild("rigid");
        ModelPart wing = rigid.getChild("wing");
        ModelPart support_center = rigid.getChild("support_center");
        ModelPart support_left = rigid.getChild("supports_left");
        ModelPart support_right = rigid.getChild("supports_right");
        ModelPart body = rigid.getChild("body");
        ModelPart single_wheel = root.getChild("single_wheel");
        ModelPart double_wheel = root.getChild("double_wheels");
        ModelPart front_wheel = single_wheel.getChild("wheel");
        ModelPart left_wheel = double_wheel.getChild("wheel_left");
        ModelPart right_wheel = double_wheel.getChild("wheel_right");
        ModelPart left_stabilizer = root.getChild("left_stabilizer");
        ModelPart right_stabilizer = root.getChild("right_stabilizer");

        this.parts = new PlaneModel.ModelParts(root,propeller,rigid,wing,support_center,support_left,support_right,body,single_wheel,double_wheel,front_wheel,left_wheel,right_wheel,left_stabilizer,right_stabilizer);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition propeller = root.addOrReplaceChild("propeller", CubeListBuilder.create().texOffs(396, 0).addBox(-12.0F, -12.0F, 0.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -19.0F, -26.0F));

        PartDefinition rigid = root.addOrReplaceChild("rigid", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -1.0F));

        PartDefinition wing = rigid.addOrReplaceChild("wing", CubeListBuilder.create().texOffs(0, 40).addBox(7.0F, -15.0F, -18.0F, 71.0F, 4.0F, 36.0F, new CubeDeformation(0.0F))
                .texOffs(0, 40).mirror().addBox(-78.0F, -15.0F, -18.0F, 71.0F, 4.0F, 36.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(-78.0F, -45.0F, -18.0F, 155.0F, 4.0F, 36.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition support_center = rigid.addOrReplaceChild("support_center", CubeListBuilder.create().texOffs(383, 0).addBox(8.0F, -42.0F, 11.0F, 3.0F, 18.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(383, 0).addBox(8.0F, -42.0F, -13.0F, 3.0F, 18.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(383, 0).mirror().addBox(-11.0F, -42.0F, -13.0F, 3.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(383, 0).mirror().addBox(-11.0F, -42.0F, 11.0F, 3.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition supports_right = rigid.addOrReplaceChild("supports_right", CubeListBuilder.create().texOffs(383, 0).mirror().addBox(22.5F, -27.5F, 22.5F, 3.0F, 29.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(383, 0).mirror().addBox(-1.5F, -27.5F, 22.5F, 3.0F, 29.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(383, 0).mirror().addBox(22.5F, -27.5F, -1.5F, 3.0F, 29.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(383, 0).mirror().addBox(-1.5F, -27.5F, -1.5F, 3.0F, 29.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-57.5F, -14.5F, -11.5F));

        PartDefinition cube_r1 = supports_right.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(383, 0).mirror().addBox(-1.5F, -30.5F, -1.5F, 3.0F, 32.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(383, 0).mirror().addBox(-1.5F, -30.5F, 22.5F, 3.0F, 32.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

        PartDefinition supports_left = rigid.addOrReplaceChild("supports_left", CubeListBuilder.create().texOffs(383, 0).addBox(-25.5F, -27.5F, 22.5F, 3.0F, 29.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(383, 0).addBox(-1.5F, -27.5F, 22.5F, 3.0F, 29.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(383, 0).addBox(-25.5F, -27.5F, -1.5F, 3.0F, 29.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(383, 0).addBox(-1.5F, -27.5F, -1.5F, 3.0F, 29.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(57.5F, -14.5F, -11.5F));

        PartDefinition cube_r2 = supports_left.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(383, 0).addBox(-1.5F, -30.5F, -1.5F, 3.0F, 32.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(383, 0).addBox(-1.5F, -30.5F, 22.5F, 3.0F, 32.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

        PartDefinition body = rigid.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 80).mirror().addBox(7.0F, -11.0F, -16.0F, 3.0F, 16.0F, 32.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 80).addBox(-10.0F, -11.0F, -16.0F, 3.0F, 16.0F, 32.0F, new CubeDeformation(0.0F))
                .texOffs(0, 128).addBox(-8.0F, -11.0F, 16.0F, 16.0F, 13.0F, 34.0F, new CubeDeformation(0.0F))
                .texOffs(38, 90).addBox(-9.0F, -11.0F, -24.0F, 18.0F, 14.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(70, 91).mirror().addBox(-7.0F, 0.0F, -16.0F, 14.0F, 5.0F, 32.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(162, 102).addBox(-6.0F, -11.0F, 79.0F, 12.0F, 11.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(70, 117).addBox(-2.0F, -6.0F, -26.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -15.0F, 0.0F));

        PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(216, 91).addBox(-1.0F, -18.0F, -8.5F, 2.0F, 22.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 88.5F, -0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(66, 129).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, -8.5F, 50.0F, 0.0F, 0.0436F, 0.0F));

        PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(66, 129).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -8.5F, 50.0F, 0.0F, -0.0436F, 0.0F));

        PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(66, 129).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, -0.5F, 50.0F, 0.0873F, 0.0436F, 0.0F));

        PartDefinition cube_r7 = body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(66, 129).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -0.5F, 50.0F, 0.0873F, -0.0436F, 0.0F));

        PartDefinition single_wheel = root.addOrReplaceChild("single_wheel", CubeListBuilder.create(), PartPose.offset(-1.0F, -4.0F, -17.0F));

        PartDefinition cube_r8 = single_wheel.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(28, 40).mirror().addBox(-3.0F, -18.0F, -1.0F, 2.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(28, 40).addBox(1.0F, -18.0F, -1.0F, 2.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.1345F, 0.0F, 0.0F));

        PartDefinition wheel = single_wheel.addOrReplaceChild("wheel", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r9 = wheel.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -4.0F, -4.0F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition double_wheels = root.addOrReplaceChild("double_wheels", CubeListBuilder.create().texOffs(38, 86).addBox(-9.0F, 6.0F, -1.0F, 18.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 12.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r10 = double_wheels.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(20, 40).mirror().addBox(-2.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

        PartDefinition cube_r11 = double_wheels.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(20, 40).addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

        PartDefinition wheel_left = double_wheels.addOrReplaceChild("wheel_left", CubeListBuilder.create(), PartPose.offset(9.0F, 7.0F, 0.0F));

        PartDefinition cube_r12 = wheel_left.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 56).addBox(-1.0F, -4.0F, -4.0F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition wheel_right = double_wheels.addOrReplaceChild("wheel_right", CubeListBuilder.create(), PartPose.offset(-9.0F, 6.0F, 0.0F));

        PartDefinition cube_r13 = wheel_right.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 56).mirror().addBox(-1.0F, -3.0F, -4.0F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition left_stabilizer = root.addOrReplaceChild("left_stabilizer", CubeListBuilder.create().texOffs(250, 111).addBox(0.0F, -1.0F, -5.5F, 20.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -17.0F, 83.5F));

        PartDefinition right_stabilizer = root.addOrReplaceChild("right_stabilizer", CubeListBuilder.create().texOffs(250, 111).mirror().addBox(-20.0F, -1.0F, -5.5F, 20.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, -17.0F, 83.5F));

        return LayerDefinition.create(meshdefinition, 512, 256);
    }

    public record ModelParts(ModelPart root, ModelPart propeller, ModelPart rigid, ModelPart wing,
                              ModelPart support_center, ModelPart support_left, ModelPart support_right, ModelPart body,
                              ModelPart single_wheel, ModelPart double_wheel, ModelPart front_wheel,
                              ModelPart left_wheel, ModelPart right_wheel, ModelPart left_stabilizer,
                              ModelPart right_stabilizer) {

    }
    @Override
    public ModelPart root() {
        return parts.root;
    }

    @Override
    public void setupAnim(PlaneEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        //parts.root.xScale = -1;
        //parts.root.yRot = pEntity.getViewYRot(0);
        //parts.root.yScale = -1;
        //parts.root.y = 1.5F;
        //if (pEntity.getMotionDirection().isFacingAngle(pEntity.getVisualRotationYInDegrees())){
        //    parts.propeller.zRot = (float) (pEntity.getDeltaMovement().horizontalDistance() * pAgeInTicks);
        //}
    }
}
