package com.fuyuvulpes.yoamod.game.client.entities.renderers;

import com.fuyuvulpes.yoamod.game.client.entities.model.BrawlerModel;
import com.fuyuvulpes.yoamod.game.client.entities.model.PlaneModel;
import com.fuyuvulpes.yoamod.world.entity.BrawlerEntity;
import com.fuyuvulpes.yoamod.world.entity.vehicle.PlaneEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.LlamaSpitModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.LlamaSpit;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class PlaneRenderer extends EntityRenderer<PlaneEntity> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(MODID,"textures/entity/vehicles/plane.png");
    private final PlaneModel<PlaneEntity> model;

    public PlaneRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new PlaneModel<>(pContext.bakeLayer(PlaneModel.LAYER_LOCATION));

    }

    @Override
    public ResourceLocation getTextureLocation(PlaneEntity pEntity) {
        return TEXTURE;
    }

    @Override
    public void render(PlaneEntity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        this.model.setupAnim(pEntity, pPartialTick, 0.0F, pPartialTick, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(TEXTURE));
        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);


        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);

    }
}
