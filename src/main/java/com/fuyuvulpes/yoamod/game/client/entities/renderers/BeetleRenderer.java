package com.fuyuvulpes.yoamod.game.client.entities.renderers;

import com.fuyuvulpes.yoamod.game.client.entities.model.BeetleModel;
import com.fuyuvulpes.yoamod.game.client.entities.model.OwlModel;
import com.fuyuvulpes.yoamod.world.entity.BeetleEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class BeetleRenderer extends MobRenderer<BeetleEntity, BeetleModel<BeetleEntity>> {

    private static final ResourceLocation BEETLE_TEXTURE = new ResourceLocation(MODID,"textures/entity/beetle.png");

    public BeetleRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BeetleModel<>(pContext.bakeLayer(BeetleModel.LAYER_LOCATION)), 0.6F);
    }

    @Override
    public ResourceLocation getTextureLocation(BeetleEntity pbeetle) {
        return BEETLE_TEXTURE;
    }
}
