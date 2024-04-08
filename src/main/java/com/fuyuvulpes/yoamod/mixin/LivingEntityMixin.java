package com.fuyuvulpes.yoamod.mixin;

import com.fuyuvulpes.yoamod.world.item.AttackAnims;
import com.fuyuvulpes.yoamod.world.item.WeaponItem;
import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @SuppressWarnings("unchecked")
    @Inject(method= "swing(Lnet/minecraft/world/InteractionHand;Z)V", at=@At(value="HEAD"))
    public void onSwing(InteractionHand pHand, boolean pUpdateSelf, CallbackInfo ci){
        LivingEntity living = (LivingEntity)(Object)this;
        if ( pHand == InteractionHand.MAIN_HAND
                && living instanceof Player player
                && player.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof WeaponItem item
                && player.level().isClientSide()
        ) {
            var swing = (ModifierLayer<IAnimation>)PlayerAnimationAccess
                    .getPlayerAssociatedData((AbstractClientPlayer) player)
                    .get(new ResourceLocation(MODID, "swing"));
            var stab = (ModifierLayer<IAnimation>)PlayerAnimationAccess
                    .getPlayerAssociatedData((AbstractClientPlayer) player)
                    .get(new ResourceLocation(MODID, "stab"));
            var slam = (ModifierLayer<IAnimation>)PlayerAnimationAccess
                    .getPlayerAssociatedData((AbstractClientPlayer) player)
                    .get(new ResourceLocation(MODID, "slam"));
            ItemStack stack = player.getItemInHand(pHand);

            switch((AttackAnims)item.getAttackAnimation(stack)){
                case SWING:
                    if (swing != null) {
                        swing.setAnimation(new KeyframeAnimationPlayer(
                                PlayerAnimationRegistry.getAnimation(
                                        new ResourceLocation(MODID, "swing"))));
                    }
                    break;
                case STAB:
                    if (stab != null) {
                        stab.setAnimation(new KeyframeAnimationPlayer(
                                PlayerAnimationRegistry.getAnimation(
                                        new ResourceLocation(MODID, "stab"))));
                    }
                    break;

                case SLAM:
                    if (slam != null) {
                        slam.setAnimation(new KeyframeAnimationPlayer(
                                PlayerAnimationRegistry.getAnimation(
                                        new ResourceLocation(MODID, "slam"))));
                    }
                    break;

            }



        }

    }


}
