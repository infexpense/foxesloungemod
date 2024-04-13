package com.fuyuvulpes.yoamod.core.registries;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class YoaSounds {

    private static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, MODID);



    public static final DeferredHolder<SoundEvent,SoundEvent> YUKI_ONNA_AMBIENT = registerSoundEvents("yuki_onna_ambient");
    public static final DeferredHolder<SoundEvent,SoundEvent> YUKI_ONNA_HURT = registerSoundEvents("yuki_onna_hurt");
    public static final DeferredHolder<SoundEvent,SoundEvent> YUKI_ONNA_DEATH = registerSoundEvents("yuki_onna_death");

    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvents(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MODID,name)));
    }


    public static void register(IEventBus eventBus){SOUNDS.register(eventBus);
    }




}
