package com.fuyuvulpes.yoamod.game.client.entities.model;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.fuyuvulpes.yoamod.world.entity.PeafowlEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class PeafowlModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "peacock"), "main");
	private final ModelPart root;

	public PeafowlModel(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 15).addBox(-2.5F, -8.0F, -4.0F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(0.0F, -5.8078F, -1.8294F));

		PartDefinition cube_r1 = neck.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(20, 12).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -2.0F, 0.2134F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(12, 0).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.1922F, -1.1706F));

		PartDefinition beak = head.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -12.0F, -8.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 3.0F));

		PartDefinition crest = head.addOrReplaceChild("crest", CubeListBuilder.create().texOffs(12, 4).addBox(0.0F, -14.3F, -3.8F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 3.0F));

		PartDefinition left_wing = body.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(0, 1).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -8.0F, -3.0F));

		PartDefinition right_wing = body.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, -8.0F, -3.0F));

		PartDefinition left_leg = body.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(2, 4).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -3.0F, -0.5F));

		PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(2, 4).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -3.0F, -0.5F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, 3.0F));

		PartDefinition tail_feather1 = tail.addOrReplaceChild("tail_feather1", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, -3.0F));

		PartDefinition cube_r2 = tail_feather1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(26, 0).addBox(-2.5F, -12.1F, -1.9F, 3.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 3.0F, -2.0071F, 0.0F, 0.0F));

		PartDefinition tail_feather2 = tail.addOrReplaceChild("tail_feather2", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, -3.0F));

		PartDefinition cube_r3 = tail_feather2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(26, 0).addBox(-2.0F, -12.3F, -1.7F, 3.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 3.0F, -2.0071F, 0.0F, 0.0F));

		PartDefinition tail_feather3 = tail.addOrReplaceChild("tail_feather3", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, -3.0F));

		PartDefinition cube_r4 = tail_feather3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(26, 0).addBox(-1.5F, -12.5F, -1.5F, 3.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 3.0F, -2.0071F, 0.0F, 0.0F));

		PartDefinition tail_feather4 = tail.addOrReplaceChild("tail_feather4", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, -3.0F));

		PartDefinition cube_r5 = tail_feather4.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(26, 0).addBox(-1.0F, -12.3F, -1.7F, 3.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 3.0F, -2.0071F, 0.0F, 0.0F));

		PartDefinition tail_feather5 = tail.addOrReplaceChild("tail_feather5", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, -3.0F));

		PartDefinition cube_r6 = tail_feather5.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(26, 0).addBox(-0.5F, -12.1F, -1.9F, 3.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 3.0F, -2.0071F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return null;
	}
}