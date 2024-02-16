package com.fuyuvulpes.yoamod.game.client.entities.renderers;

import com.fuyuvulpes.yoamod.custom.entity.BrawlerEntity;
import com.fuyuvulpes.yoamod.game.client.entities.model.BrawlerModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class BrawlerRenderer extends MobRenderer<BrawlerEntity, BrawlerModel<BrawlerEntity>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(MODID,"textures/entity/brawler.png");

    public BrawlerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new BrawlerModel<>(pContext.bakeLayer(BrawlerModel.LAYER_LOCATION)), 2.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(BrawlerEntity pEntity) {
        return TEXTURE;
    }
}
