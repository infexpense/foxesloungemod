package com.fuyuvulpes.yoamod.game.client.entities.renderers;

import com.fuyuvulpes.yoamod.game.client.entities.model.FallenSamuraiModel;
import com.fuyuvulpes.yoamod.game.client.entities.model.YukiOnnaModel;
import com.fuyuvulpes.yoamod.world.entity.FallenSamurai;
import com.fuyuvulpes.yoamod.world.entity.YukiOnnaEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class YukiOnnaRenderer<T extends YukiOnnaEntity> extends MobRenderer<T, YukiOnnaModel<T>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(MODID,"textures/entity/yuki_onna.png");

    public YukiOnnaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new YukiOnnaModel<>(pContext.bakeLayer(YukiOnnaModel.LAYER_LOCATION)), 0.3F);
    }
    public ResourceLocation getTextureLocation(YukiOnnaEntity pEntity) {
        return TEXTURE;
    }
}
