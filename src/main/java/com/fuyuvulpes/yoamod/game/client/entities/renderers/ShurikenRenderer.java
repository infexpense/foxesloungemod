package com.fuyuvulpes.yoamod.game.client.entities.renderers;

import com.fuyuvulpes.yoamod.game.client.entities.model.BoomerangModel;
import com.fuyuvulpes.yoamod.game.client.entities.model.ShurikenModel;
import com.fuyuvulpes.yoamod.world.entity.projectile.BoomerangEntity;
import com.fuyuvulpes.yoamod.world.entity.projectile.ShurikenEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class ShurikenRenderer<T extends ShurikenEntity> extends EntityRenderer<T> {

    private final ShurikenModel<T> model;


    public ShurikenRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new ShurikenModel<>(pContext.bakeLayer(ShurikenModel.LAYER_LOCATION));

    }

    @Override
    public void render(T pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();

        pPoseStack.scale(-1.0F, -1.0F, 1.0F);
        pPoseStack.translate(0,-1.5,0);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(this.getTextureLocation(pEntity)));

        this.model.setupAnim(pEntity, pPartialTick, 0.0F, pEntity.tickCount + pPartialTick, 0.0F, 0.0F);

        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 0.15F);

        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);

    }

    @Override
    public ResourceLocation getTextureLocation(T pEntity) {
        return new ResourceLocation(MODID, "textures/entity/shuriken/"+ pEntity.getVariant().getName() + ".png");
    }
}
