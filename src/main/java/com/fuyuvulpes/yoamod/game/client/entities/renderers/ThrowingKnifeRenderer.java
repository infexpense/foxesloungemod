package com.fuyuvulpes.yoamod.game.client.entities.renderers;

import com.fuyuvulpes.yoamod.game.client.entities.model.ChakramModel;
import com.fuyuvulpes.yoamod.game.client.entities.model.ThrowingKnifeModel;
import com.fuyuvulpes.yoamod.world.entity.projectile.ChakramEntity;
import com.fuyuvulpes.yoamod.world.entity.projectile.ThrowingKnifeEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class ThrowingKnifeRenderer<T extends ThrowingKnifeEntity> extends EntityRenderer<T> {

    private final ThrowingKnifeModel<T> model;


    public ThrowingKnifeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new ThrowingKnifeModel<>(pContext.bakeLayer(ThrowingKnifeModel.LAYER_LOCATION));

    }

    @Override
    public void render(T pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.scale(-1.0F, -1.0F, -1.0F);
        pPoseStack.translate(-1.5,-0.25,0);

        pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTick, pEntity.yRotO, pEntity.getYRot())));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTick, pEntity.xRotO, pEntity.getXRot()) + 90.0F));

        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(this.getTextureLocation(pEntity)));

        this.model.setupAnim(pEntity, pPartialTick, 0.0F, pEntity.tickCount + pPartialTick, 0.0F, 0.0F);

        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 0.15F);

        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);

    }

    @Override
    public ResourceLocation getTextureLocation(T pEntity) {
        return new ResourceLocation(MODID, "textures/entity/throwing_knife/"+ pEntity.getVariant().getName() + ".png");
    }
}
