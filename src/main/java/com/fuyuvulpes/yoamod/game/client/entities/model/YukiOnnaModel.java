package com.fuyuvulpes.yoamod.game.client.entities.model;

import com.fuyuvulpes.yoamod.world.entity.YukiOnnaEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class YukiOnnaModel<T extends YukiOnnaEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MODID, "yuki_onna"), "main");
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart leftBang;
    private final ModelPart rightBang;
    private final ModelPart backHair;
    private final ModelPart leftArm;
    private final ModelPart rightArm;
    private final ModelPart robe;
    private final ModelPart fabricA;
    private final ModelPart fabricB;

    public YukiOnnaModel(ModelPart core) {
        this.root = core.getChild("root");
        this.head = this.root.getChild("head");
        this.leftBang = this.head.getChild("left_bang");
        this.rightBang = this.head.getChild("right_bang");
        this.backHair = this.head.getChild("back_hair");
        this.leftArm = this.root.getChild("left_arm");
        this.rightArm = this.root.getChild("right_arm");
        this.robe = this.root.getChild("robe_bottom");
        this.fabricA = this.root.getChild("fabric_a");
        this.fabricB = this.root.getChild("fabric_b");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 28.0F, 0.0F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -28.0F, 0.0F));

        PartDefinition right_bang = head.addOrReplaceChild("right_bang", CubeListBuilder.create().texOffs(64, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offset(-3.0F, -5.0F, -3.0F));

        PartDefinition left_bang = head.addOrReplaceChild("left_bang", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offset(3.0F, -5.0F, -3.0F));

        PartDefinition back_hair = head.addOrReplaceChild("back_hair", CubeListBuilder.create().texOffs(72, 0).addBox(-4.0F, 0.5F, -1.0F, 8.0F, 15.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.5F, 2.0F));

        PartDefinition right_arm = root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 32).addBox(-3.0F, 10.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(24, 28).addBox(-4.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -27.0F, 0.0F));

        PartDefinition left_arm = root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 32).mirror().addBox(0.0F, 10.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(24, 28).mirror().addBox(0.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -27.0F, 0.0F));

        PartDefinition torso = root.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(58, 16).addBox(2.0F, -3.5F, -3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-3.5F, -11.5F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(52, 21).addBox(0.0F, -9.5F, -2.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(52, 26).addBox(0.0F, -1.5F, -2.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 16).addBox(-4.0F, -6.5F, -2.5F, 9.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(24, 22).addBox(-4.0F, -2.5F, -2.5F, 9.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -16.5F, 0.0F));

        PartDefinition cube_r1 = torso.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(52, 16).mirror().addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -10.0F, -2.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r2 = torso.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(52, 16).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, -2.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition fabric_a = root.addOrReplaceChild("fabric_a", CubeListBuilder.create().texOffs(101, 0).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.25F, -18.0F, -2.0F));

        PartDefinition fabric_b = root.addOrReplaceChild("fabric_b", CubeListBuilder.create().texOffs(94, 0).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.75F, -18.0F, -2.5F));

        PartDefinition robe_bottom = root.addOrReplaceChild("robe_bottom", CubeListBuilder.create().texOffs(0, 33).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }


    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        boolean flag = pEntity.getFallFlyingTicks() > 4;
        this.head.yRot = pNetHeadYaw * (float) (Math.PI / 180.0);
        if (flag) {
            this.head.xRot = (float) (-Math.PI / 4);
        } else {
            this.head.xRot = pHeadPitch * (float) (Math.PI / 180.0);
        }

        float f = 1.0F;
        if (flag) {
            f = (float) pEntity.getDeltaMovement().lengthSqr();
            f /= 0.2F;
            f *= f * f;
        }

        if (f < 1.0F) {
            f = 1.0F;
        }

        this.leftBang.zRot = Mth.sin(pAgeInTicks * 0.1F) * 0.1F / f;
        this.rightBang.zRot = Mth.sin(pAgeInTicks * 0.1F) * 0.1F / f;

        this.rightArm.xRot = Mth.cos(pLimbSwing * 0.6662F + (float) Math.PI) * 2.0F * pLimbSwingAmount * 0.5F / f;
        this.leftArm.xRot = Mth.cos(pLimbSwing * 0.6662F) * 2.0F * pLimbSwingAmount * 0.5F / f;
        this.rightArm.zRot = 0.0F;
        this.leftArm.zRot = 0.0F;

        this.fabricA.zRot = ((Mth.sin(pAgeInTicks * 0.2F) + 1) * 0.4F / f / 2) * -1;
        this.fabricB.zRot = ((Mth.cos(pAgeInTicks * 0.2F) + 1) * 0.4F / f / 2) * -1;

        this.robe.xRot = (Mth.sin(pLimbSwing * 0.6662F) + 1) * 0.3F / 2 / f;
        this.backHair.xRot = (Mth.sin(pAgeInTicks * 0.1F + 2.62F) + 1) * 0.1F / 2 / f ;
        setupAttackAnimation();
    }


    protected void setupAttackAnimation() {
        if (!(this.attackTime <= 0.0F)) {
            float f;
            f = 1.0F - this.attackTime;
            f *= f;
            f *= f;
            f = 1.0F - f;
            float f1 = Mth.sin(f * (float) Math.PI);
            float f2 = Mth.sin(this.attackTime * (float) Math.PI) * -(this.head.xRot - 0.7F) * 0.75F;
            rightArm.xRot -= f1 * 1.2F + f2;
            leftArm.xRot -= f1 * 1.2F + f2;

            rightArm.zRot += Mth.sin(this.attackTime * (float) Math.PI) * -0.4F;
            leftArm.zRot += Mth.sin(this.attackTime * (float) Math.PI) * -0.4F;
        }
    }
}
