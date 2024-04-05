package com.fuyuvulpes.yoamod.game.client.entities.renderers;

import com.fuyuvulpes.yoamod.game.client.entities.model.DartModel;
import com.fuyuvulpes.yoamod.world.entity.projectile.DartProjectile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class DartRenderer<T extends DartProjectile> extends EntityRenderer<T> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/shulker/spark.png");
    private final DartModel<T> model;
    public DartRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new DartModel<>(pContext.bakeLayer(DartModel.LAYER_LOCATION));

    }

    @Override
    public ResourceLocation getTextureLocation(T pEntity) {
        return TEXTURE;
    }

    public void render(T pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();

        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(TEXTURE));
        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 0.15F);
        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

}
