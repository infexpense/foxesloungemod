package com.fuyuvulpes.yoamod.events;

import com.fuyuvulpes.yoamod.game.client.particle.BleedingParticle;
import com.fuyuvulpes.yoamod.registries.ParticleModReg;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.CherryParticle;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEvents {


    @SubscribeEvent
    public static void registerParticleEvent(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ParticleModReg.BLEEDING.get(), (pSprites) ->
                (pType, pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed) ->
                new BleedingParticle(pLevel,pX,pY,pZ,pSprites));
    }

}
