package com.fuyuvulpes.yoamod.game.client.entities.model;

import com.fuyuvulpes.yoamod.world.entity.projectile.DartProjectile;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class DartModel <T extends DartProjectile> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MODID, "dart"), "main");
    private final ModelPart root;
    public DartModel(ModelPart pRoot) {
        this.root = pRoot;
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild(
                "main",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-4.0F, -4.0F, -1.0F, 8.0F, 8.0F, 2.0F)
                        .texOffs(0, 10)
                        .addBox(-1.0F, -4.0F, -4.0F, 2.0F, 8.0F, 8.0F)
                        .texOffs(20, 0)
                        .addBox(-4.0F, -1.0F, -4.0F, 8.0F, 2.0F, 8.0F),
                PartPose.ZERO
        );
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }


    @Override
    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

    }
}
