package com.fuyuvulpes.yoamod.game.client.entities.renderers;

import com.fuyuvulpes.yoamod.custom.entity.Blockling;
import com.fuyuvulpes.yoamod.game.client.entities.model.BlocklingModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class BlocklingRenderer extends MobRenderer<Blockling, BlocklingModel<Blockling>> {

    private static final ResourceLocation GRASS_TEXTURE = new ResourceLocation(MODID,"textures/entity/blockling/grass.png");
    private static final ResourceLocation COBBLESTONE_TEXTURE = new ResourceLocation(MODID,"textures/entity/blockling/cobblestone.png");
    private static final ResourceLocation WOOD_TEXTURE = new ResourceLocation(MODID,"textures/entity/blockling/wood.png");

    public BlocklingRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BlocklingModel<>(pContext.bakeLayer(BlocklingModel.LAYER_LOCATION)), 0.2F);
    }


    public ResourceLocation getTextureLocation(Blockling pEntity) {
        if (pEntity.getVariant() == Blockling.Type.COBBLESTONE) {
            return COBBLESTONE_TEXTURE;
        } else if (pEntity.getVariant() == Blockling.Type.WOOD) {
            return WOOD_TEXTURE;
        }else {
            return GRASS_TEXTURE;
        }
    }
}
