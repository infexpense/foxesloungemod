package com.fuyuvulpes.yoamod.network;

import com.fuyuvulpes.yoamod.world.magic.mana.IMana;
import com.fuyuvulpes.yoamod.world.magic.mana.ManaHelper;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public record UpdateManaPacket(int currentMana, int maxMana) implements CustomPacketPayload{


    public static final ResourceLocation ID = new ResourceLocation(MODID, "mana");

    public UpdateManaPacket(final FriendlyByteBuf buffer) {
        this(buffer.readInt(),buffer.readInt());
    }
    @Override
    public void write(FriendlyByteBuf pBuffer) {
        pBuffer.writeInt(this.currentMana);
        pBuffer.writeFloat(this.maxMana);
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    public static void handle(final UpdateManaPacket message, final PlayPayloadContext ctx)
    {
        ctx.player().ifPresent(player -> {
            IMana iMana = ManaHelper.getManaData(player);
            iMana.setMana(message.currentMana);
            iMana.setMaxMana(message.maxMana);
        });
    }

}
