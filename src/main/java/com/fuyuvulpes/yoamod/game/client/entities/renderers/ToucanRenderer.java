package com.fuyuvulpes.yoamod.game.client.entities.renderers;

import com.fuyuvulpes.yoamod.game.client.entities.model.ToucanModel;
import com.fuyuvulpes.yoamod.world.entity.ToucanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class ToucanRenderer extends MobRenderer<ToucanEntity, ToucanModel<ToucanEntity>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(MODID,"textures/entity/toucan.png");


    public ToucanRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ToucanModel<>(pContext.bakeLayer(ToucanModel.LAYER_LOCATION)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(ToucanEntity pToucan) {return TEXTURE;}
    }
