package com.fuyuvulpes.yoamod.game.client.entities.model;

import com.fuyuvulpes.yoamod.world.entity.projectile.ChakramEntity;
import com.fuyuvulpes.yoamod.world.entity.projectile.ThrowingKnifeEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class ThrowingKnifeModel<T extends ThrowingKnifeEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MODID, "throwing_kife"), "main");
    private final ModelPart root;
    public ThrowingKnifeModel(ModelPart pRoot) {
        this.root = pRoot.getChild("root");
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(6, 11).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.5F, -1.0F));

        PartDefinition cube_r1 = root.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(2, 0).addBox(-4.0F, -0.5F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, 2).addBox(-3.0F, -0.5F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(-2.0F, -0.5F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 7).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r2 = root.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 10).addBox(1.0F, -1.0F, 1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.5F, 2.0F, 0.0F, -0.7854F, 0.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }
    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        this.root.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);

    }

    @Override
    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
    }


}
