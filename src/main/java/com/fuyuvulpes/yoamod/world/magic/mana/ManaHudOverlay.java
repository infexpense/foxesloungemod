package com.fuyuvulpes.yoamod.world.magic.mana;

import com.fuyuvulpes.yoamod.YOAMod;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.client.gui.overlay.IGuiOverlay;

public class ManaHudOverlay {
    private static final ResourceLocation MANA_ICON = YOAMod.makeTexture("gui/mana.png");
    private static final ResourceLocation EMPTY_ICON = YOAMod.makeTexture("gui/mana_empty.png");
    public static final IGuiOverlay MANA_OVERLAY = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        int x = screenWidth / 2;
        int y = screenHeight;

        IMana iMana = ManaHelper.getManaData(player);
        float manaFactor = ((float) iMana.getMana()) / ((float) iMana.getMaxMana());
        float manaCount = manaFactor * 10;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F,1.0F,1.0F,1.0F);
        RenderSystem.setShaderTexture(0,MANA_ICON);
        for (int i = 0; i < manaCount; i++) {
            guiGraphics.blit(MANA_ICON, 4 + (i % 2 == 0 ? 8 : 0), y - 16 - (i * 8), 0, 0, 12, 12, 12, 12);
        }

        RenderSystem.setShaderTexture(0,EMPTY_ICON);

        float manaLackCount = (1 - manaFactor) * 10;
        for (int i = 0; i < manaLackCount; i++) {
            guiGraphics.blit(EMPTY_ICON, 4 + (i % 2 == 0 ? 0 : 8), y - 88 + (i * 8), 0, 0, 12, 12, 12, 12);
        }
        Font font = minecraft.font;
        guiGraphics.drawString(font,iMana.getMana() + " / " + iMana.getMaxMana(),26,y - 12,5631663);
    };
}
