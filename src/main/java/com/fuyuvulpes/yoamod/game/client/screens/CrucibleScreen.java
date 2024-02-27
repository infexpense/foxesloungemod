package com.fuyuvulpes.yoamod.game.client.screens;


import com.fuyuvulpes.yoamod.YOAMod;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CrucibleScreen extends AbstractContainerScreen<CrucibleMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(YOAMod.MODID, "textures/gui/container/crucible.png");
    private static final ResourceLocation ARROW = new ResourceLocation(YOAMod.MODID, "textures/gui/sprites/container/crucible/arrow.png");
    private static final ResourceLocation FUEL = new ResourceLocation(YOAMod.MODID, "textures/gui/sprites/container/crucible/fuel.png");

    public CrucibleScreen(CrucibleMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(ARROW, x + 61, y + 24, 0, 0, menu.getScaledProgress(), 6);
        }
    }

    private void renderFuel(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isLit()) {
            guiGraphics.blit(FUEL, x + 81, y + 38, 0, 0, 13, menu.getScaledUsage());
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics,mouseX,mouseY,delta);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}