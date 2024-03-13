package com.fuyuvulpes.yoamod.core.registries;

import com.fuyuvulpes.yoamod.world.entity.block.CrucibleBlockEntity;
import com.fuyuvulpes.yoamod.world.entity.block.HammeringStationBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class YoaBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BL_ENTITY = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MODID);


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HammeringStationBlockEntity>> HAMMERING_STATION = BL_ENTITY.register("hammering_station",
            () -> BlockEntityType.Builder.of(HammeringStationBlockEntity::new, YoaBlocks.HAMMERING_STATION.get()).build(null));


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CrucibleBlockEntity>> CRUCIBLE = BL_ENTITY.register("crucible",
            () -> BlockEntityType.Builder.of(CrucibleBlockEntity::new, YoaBlocks.CRUCIBLE.get()).build(null));

    public static void register(IEventBus eventBus){
        BL_ENTITY.register(eventBus);
    }
}
