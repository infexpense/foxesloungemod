package com.fuyuvulpes.yoamod.mixin;

import com.fuyuvulpes.yoamod.game.player.IYOAPlayer;
import com.fuyuvulpes.yoamod.world.magic.mana.ManaData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity implements IYOAPlayer {

    @Unique
    private ManaData foxesloungemod$manaData = new ManaData();

    protected PlayerMixin(EntityType<? extends LivingEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Inject(method="readAdditionalSaveData", at=@At(value="TAIL"))
    public void onReadAdditionalSaveData(CompoundTag nbt, CallbackInfo ci)
    {
       // this.foxesloungemod$manaData.readAdditionalSaveData(nbt);
    }

    @Inject(method="addAdditionalSaveData", at=@At(value="TAIL"))
    public void onAddAdditionalSaveData(CompoundTag nbt, CallbackInfo ci)
    {
        //this.foxesloungemod$manaData.addAdditionalSaveData(nbt);
    }

}
