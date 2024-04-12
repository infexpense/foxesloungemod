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
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "peafowl"), "main");
	private final ModelParts parts;

	public PeafowlModel(ModelPart root) {

		ModelPart main = root.getChild("main");
		ModelPart body = main.getChild("body");
		ModelPart neck = body.getChild("neck");
		ModelPart cube = neck.getChild("cube");
		ModelPart head = neck.getChild("head");
		ModelPart beak = head.getChild("beak");
		ModelPart crest = head.getChild("crest");
		ModelPart left_wing = body.getChild("left_wing");
		ModelPart right_wing = body.getChild("right_wing");
		ModelPart left_leg = body.getChild("left_leg");
		ModelPart right_leg = body.getChild("right_leg");
		ModelPart tail = body.getChild("tail");
		ModelPart tail_feather1 = tail.getChild("tail_feather1");
		ModelPart tail_feather2 = tail.getChild("tail_feather2");
		ModelPart tail_feather3 = tail.getChild("tail_feather3");
		ModelPart tail_feather4 = tail.getChild("tail_feather4");
		ModelPart tail_feather5 = tail.getChild("tail_feather5");
		ModelPart feather1 = tail_feather1.getChild("feather1");
		ModelPart feather2 = tail_feather2.getChild("feather2");
		ModelPart feather3 = tail_feather3.getChild("feather3");
		ModelPart feather4 = tail_feather4.getChild("feather4");
		ModelPart feather5 = tail_feather5.getChild("feather5");

		this.parts = new ModelParts(main, body, neck, cube, head, beak, crest, left_wing, right_wing, left_leg, right_leg, tail, tail_feather1, tail_feather2, tail_feather3, tail_feather4, tail_feather5, feather1, feather2, feather3, feather4,feather5);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = main.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 15).addBox(-2.5F, -8.0F, -4.0F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(0.0F, -5.8078F, -1.8294F));

		PartDefinition cube = neck.addOrReplaceChild("cube", CubeListBuilder.create().texOffs(20, 12).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -2.0F, 0.2134F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(12, 0).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.1922F, -1.1706F));

		PartDefinition beak = head.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -12.0F, -8.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 3.0F));

		PartDefinition crest = head.addOrReplaceChild("crest", CubeListBuilder.create().texOffs(12, 4).addBox(0.0F, -14.3F, -3.8F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 3.0F));

		PartDefinition left_wing = body.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(0, 1).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -8.0F, -3.0F));

		PartDefinition right_wing = body.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, -8.0F, -3.0F));

		PartDefinition left_leg = body.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(2, 4).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -3.0F, -0.5F));

		PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(2, 4).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -3.0F, -0.5F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, 3.0F));

		PartDefinition tail_feather1 = tail.addOrReplaceChild("tail_feather1", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, -3.0F));

		PartDefinition feather1 = tail_feather1.addOrReplaceChild("feather1", CubeListBuilder.create().texOffs(26, 0).addBox(-2.5F, -12.1F, -1.9F, 3.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 3.0F, -2.0071F, 0.0F, 0.0F));

		PartDefinition tail_feather2 = tail.addOrReplaceChild("tail_feather2", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, -3.0F));

		PartDefinition feather2 = tail_feather2.addOrReplaceChild("feather2", CubeListBuilder.create().texOffs(26, 0).addBox(-2.0F, -12.3F, -1.7F, 3.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 3.0F, -2.0071F, 0.0F, 0.0F));

		PartDefinition tail_feather3 = tail.addOrReplaceChild("tail_feather3", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, -3.0F));

		PartDefinition feather3 = tail_feather3.addOrReplaceChild("feather3", CubeListBuilder.create().texOffs(26, 0).addBox(-1.5F, -12.5F, -1.5F, 3.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 3.0F, -2.0071F, 0.0F, 0.0F));

		PartDefinition tail_feather4 = tail.addOrReplaceChild("tail_feather4", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, -3.0F));

		PartDefinition feather4 = tail_feather4.addOrReplaceChild("feather4", CubeListBuilder.create().texOffs(26, 0).addBox(-1.0F, -12.3F, -1.7F, 3.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 3.0F, -2.0071F, 0.0F, 0.0F));

		PartDefinition tail_feather5 = tail.addOrReplaceChild("tail_feather5", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, -3.0F));

		PartDefinition feather5 = tail_feather5.addOrReplaceChild("feather5", CubeListBuilder.create().texOffs(26, 0).addBox(-0.5F, -12.1F, -1.9F, 3.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 3.0F, -2.0071F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.parts.main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	private record ModelParts(ModelPart main, ModelPart body, ModelPart head, ModelPart neck, ModelPart cube, ModelPart beak, ModelPart crest, ModelPart left_wing, ModelPart right_wing, ModelPart left_leg, ModelPart right_leg, ModelPart tail, ModelPart tail_feather1, ModelPart tail_feather2, ModelPart tail_feather3, ModelPart tail_feather4, ModelPart tail_feather5, ModelPart feather1, ModelPart feather2, ModelPart feather3, ModelPart feather4, ModelPart feather5) {
	}

	@Override
	public ModelPart root() {
		return this.parts.main;
	}
}