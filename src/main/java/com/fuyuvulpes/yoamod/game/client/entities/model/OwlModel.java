package com.fuyuvulpes.yoamod.game.client.entities.model;

import com.fuyuvulpes.yoamod.world.entity.OwlEntity;
import com.fuyuvulpes.yoamod.world.entity.ToucanEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class OwlModel<T extends Entity> extends HierarchicalModel<OwlEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "owlmodel"), "main");
	private final ModelParts parts;

	public OwlModel(ModelPart root) {

		ModelPart main = root.getChild("main");
		ModelPart body = main.getChild("body");
		ModelPart head = main.getChild("head");
		ModelPart left_wing = body.getChild("left_wing");
		ModelPart right_wing = body.getChild("right_wing");
		ModelPart tail = body.getChild("tail");
		ModelPart left_foot = body.getChild("left_foot");
		ModelPart right_foot = body.getChild("right_foot");

		this.parts = new OwlModel.ModelParts(main, body, head, left_wing, right_wing, tail, left_foot, right_foot);
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
	public void setupAnim(OwlEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.setupAnim(getState(entity), entity.tickCount, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.parts.main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.parts.main;
	}


	private void setupAnim(OwlModel.State pState, int pTickCount, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		double dtr =  Mth.DEG_TO_RAD;
		this.parts.head.xRot = (float) (pHeadPitch * (Math.PI / 180.0) + (9 * dtr));
		this.parts.head.yRot = (float) (pNetHeadYaw * (Math.PI / 180.0));
		this.parts.head.zRot = 0.0F;
		switch (pState) {
			case STANDING:
				ModelPart theLEG = this.parts.left_foot;
				theLEG.xRot = Mth.cos(pLimbSwing * 0.6662F) * 1.4F * pLimbSwingAmount;
				theLEG = this.parts.right_foot;
				theLEG.xRot = Mth.cos(pLimbSwing * 0.6662F + 3.1415927F) * 1.4F * pLimbSwingAmount;
				this.parts.left_wing.zRot = 0.0F;
				this.parts.right_wing.zRot = 0.0F;
				break;
			case FLYING:
				double m = (Math.sin(pAgeInTicks) * 90 + 45) * dtr;
				this.parts.left_wing.zRot = -0.5f * (float) m + 55.5f;
				this.parts.right_wing.zRot = 0.5f * (float) m - 55.5f;
				this.parts.left_foot.xRot = 0.0F;
				this.parts.right_foot.xRot = 0.0F;
				break;
			default:
				this.parts.left_wing.zRot = 0.0F;
				this.parts.right_wing.zRot = 0.0F;
		}

	}


	private static OwlModel.State getState(OwlEntity pOwl) {
			return pOwl.isFlying() ? OwlModel.State.FLYING : OwlModel.State.STANDING;
	}

	@OnlyIn(Dist.CLIENT)
	public static enum State {
		FLYING,
		STANDING;

		private State() {
		}
	}

	private record ModelParts(ModelPart main, ModelPart body, ModelPart head, ModelPart left_wing, ModelPart right_wing, ModelPart tail, ModelPart left_foot, ModelPart right_foot) {
	}
}