package com.fuyuvulpes.yoamod.game.client.entities.renderers;

import com.fuyuvulpes.yoamod.game.client.entities.model.PeacockModel;
import com.fuyuvulpes.yoamod.world.entity.vehicle.PeacockEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Parrot;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class PeacockRenderer extends MobRenderer<PeacockEntity, PeacockModel<PeacockEntity>> {
    private static final ResourceLocation PEACOCK_TEXTURE = new ResourceLocation(MODID,"textures/entity/peacock/peacock.png");
    private static final ResourceLocation PEAHEN_TEXTURE = new ResourceLocation(MODID,"textures/entity/owl.png");
    @Override
    public ResourceLocation getTextureLocation(PeacockEntity pEntity) {
        return getVariantTexture(pEntity.getVariant());
    }
    public PeacockRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PeacockModel<>(pContext.bakeLayer(PeacockModel.LAYER_LOCATION)), 0.4F);
    }

    public static ResourceLocation getVariantTexture(PeacockEntity.Type pType) {
        return switch(pType) {
            case PEACOCK -> PEACOCK_TEXTURE;
            case PEAHEN -> PEAHEN_TEXTURE;
        };
    }
}
