package com.fuyuvulpes.yoamod.game.client.entities.renderers;

import com.fuyuvulpes.yoamod.game.client.entities.model.PeafowlModel;
import com.fuyuvulpes.yoamod.world.entity.PeafowlEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class PeafowlRenderer extends MobRenderer<PeafowlEntity, PeafowlModel<PeafowlEntity>> {
    private static final ResourceLocation PEACOCK_TEXTURE = new ResourceLocation(MODID,"textures/entity/peafowl/peacock.png");
    private static final ResourceLocation PEAHEN_TEXTURE = new ResourceLocation(MODID,"textures/entity/peafowl/peahen.png");
    @Override
    public ResourceLocation getTextureLocation(PeafowlEntity pEntity) {
        return getVariantTexture(pEntity.getVariant());
    }
    public PeafowlRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PeafowlModel<>(pContext.bakeLayer(PeafowlModel.LAYER_LOCATION)), 0.4F);
    }

    public static ResourceLocation getVariantTexture(PeafowlEntity.Type pType) {
        return switch(pType) {
            case PEACOCK -> PEACOCK_TEXTURE;
            case PEAHEN -> PEAHEN_TEXTURE;
        };
    }
}
