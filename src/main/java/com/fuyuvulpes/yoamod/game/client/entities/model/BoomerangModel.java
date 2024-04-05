package com.fuyuvulpes.yoamod.game.client.entities.model;

import com.fuyuvulpes.yoamod.world.entity.projectile.BoomerangEntity;
import com.fuyuvulpes.yoamod.world.entity.projectile.ChakramEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class BoomerangModel<T extends BoomerangEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MODID, "boomerang"), "main");
    private final ModelPart root;
    public BoomerangModel(ModelPart pRoot) {
        this.root = pRoot.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(-0.75F, 24.0F, 0.0F));

        PartDefinition cube_r1 = root.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(4, 1).addBox(-2.4F, -2.0F, -2.4F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r2 = root.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(-1.3F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.55F, -0.4F, 0.7F, 0.0F, 0.3491F, 0.0F));

        PartDefinition cube_r3 = root.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(3, 5).addBox(-0.8F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.05F, -0.4F, 0.7F, 0.0F, -0.3491F, 0.0F));

        PartDefinition cube_r4 = root.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(1, 9).mirror().addBox(-1.2F, -1.0F, -2.5F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));

        PartDefinition cube_r5 = root.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(1, 9).addBox(-3.8F, -1.0F, -2.5F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
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
