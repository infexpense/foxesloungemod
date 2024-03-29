package com.fuyuvulpes.yoamod.game.client.entities.renderers;

import com.fuyuvulpes.yoamod.game.client.entities.model.FallenSamuraiModel;
import com.fuyuvulpes.yoamod.world.entity.FallenSamurai;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class FallenSamuraiRenderer<T extends FallenSamurai,M extends FallenSamuraiModel<T>> extends MobRenderer<T, FallenSamuraiModel<T>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MODID,"textures/entity/fallen_samurai.png");

    public FallenSamuraiRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new FallenSamuraiModel<>(pContext.bakeLayer(FallenSamuraiModel.LAYER_LOCATION)), 0.7F);
    }
    public ResourceLocation getTextureLocation(FallenSamurai pEntity) {
        return TEXTURE;
    }

}
