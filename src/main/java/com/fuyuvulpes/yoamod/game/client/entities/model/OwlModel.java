package com.fuyuvulpes.yoamod.game.client.entities.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class OwlModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "owlmodel"), "main");
	private final ModelPart main;

	public OwlModel(ModelPart root) {
		this.main = root.getChild("main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = main.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -4.0F, -3.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(23, 0).addBox(-0.5F, -2.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.5F, -2.0F));

		PartDefinition left_feather = head.addOrReplaceChild("left_feather", CubeListBuilder.create().texOffs(15, 0).addBox(0.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -4.0F, -2.0F));

		PartDefinition right_feather = head.addOrReplaceChild("right_feather", CubeListBuilder.create().texOffs(15, 0).mirror().addBox(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, -4.0F, -2.0F));

		PartDefinition body = main.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 9).addBox(-2.5F, -4.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, 0.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition left_wing = body.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(20, 9).addBox(0.0F, 0.0F, -3.0F, 1.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -4.0F, 0.5F));

		PartDefinition right_wing = body.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(20, 9).mirror().addBox(-1.0F, 0.0F, -3.0F, 1.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, -4.0F, 0.5F));

		PartDefinition left_foot = body.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(0, 22).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 2.5F, -2.5F, 0.9599F, 0.0F, 0.0F));

		PartDefinition right_foot = body.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 2.5F, -2.5F, 0.9599F, 0.0F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(32, 14).addBox(-3.5F, -0.5F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 2.5F, 0.48F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

    @Override
    public ModelPart root() {
        return this.root();
    }
}