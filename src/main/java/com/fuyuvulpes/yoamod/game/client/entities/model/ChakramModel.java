package com.fuyuvulpes.yoamod.game.client.entities.model;

import com.fuyuvulpes.yoamod.world.entity.projectile.ChakramEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class ChakramModel <T extends ChakramEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MODID, "chakram"), "main");
    private final ModelPart root;
    public ChakramModel(ModelPart pRoot) {
        this.root = pRoot.getChild("root");
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(20, 12)
                .addBox(-6.0F, -1.0F, -6.0F, 12.0F, 0.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(-4.0F, -1.9F, 6.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 4).addBox(6.0F, -2.1F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -1.9F, -8.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(30, 0).addBox(-8.0F, -2.1F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 25.0F, 0.0F));

        PartDefinition cube_r1 = root.addOrReplaceChild("cube_r1", CubeListBuilder.create()
                .texOffs(43, 3).addBox(-8.4F, -2.0F, -3.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(20, 0).addBox(-4.0F, -1.9F, -8.4F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(6.4F, -2.1F, -4.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(-3.0F, -2.0F, 6.4F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1F, 0.0F, 0.0F, 0.7854F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }


    @Override
    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        root.yRot = pAgeInTicks * 20;
    }


}
