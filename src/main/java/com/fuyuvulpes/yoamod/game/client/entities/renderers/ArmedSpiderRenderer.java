package com.fuyuvulpes.yoamod.game.client.entities.renderers;

import com.fuyuvulpes.yoamod.world.entity.ArmedSpider;
import com.fuyuvulpes.yoamod.game.client.entities.model.ArmedSpiderModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class ArmedSpiderRenderer  extends MobRenderer<ArmedSpider, ArmedSpiderModel<ArmedSpider>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(MODID,"textures/entity/armed_spider.png");


    public ArmedSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new ArmedSpiderModel<>(pContext.bakeLayer(ArmedSpiderModel.LAYER_LOCATION)), 2.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(ArmedSpider pEntity) {
        return TEXTURE;
    }

}
