package com.fuyuvulpes.yoamod.core.registries;

import com.fuyuvulpes.yoamod.core.YoaRegistries;
import com.fuyuvulpes.yoamod.world.magic.Magic;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class YoaMagicAndSpells {

    public static final DeferredRegister<Magic> MAGIC = DeferredRegister.create(YoaRegistries.MAGIC, MODID);




    public static void register(IEventBus eventBus){
        MAGIC.register(eventBus);
    }

}
