package com.fuyuvulpes.yoamod.custom.item.weaponry;

import com.fuyuvulpes.yoamod.core.AttackAnim;
import com.fuyuvulpes.yoamod.core.AttackAnimEnum;
import com.fuyuvulpes.yoamod.core.items.WeaponItem;
import com.fuyuvulpes.yoamod.core.items.WeaponStats;
import com.fuyuvulpes.yoamod.registries.ModEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class WarFanItem extends WeaponItem {



    public WarFanItem(Tier tier, Properties properties) {
        super(tier, WeaponStats.WAR_FAN, properties);
    }


    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (isOpen(stack) && pAttacker.level().random.nextFloat() < 0.52){
            pTarget.addEffect(new MobEffectInstance(ModEffects.BLEEDING.get(),190,1,false,true));

        }else if (!isOpen(stack)){
            if (pAttacker.level().random.nextFloat() < 0.15) {
                pTarget.addEffect(new MobEffectInstance(ModEffects.BLEEDING.get(),60,0,false,true));

            }
            if (pAttacker.level().random.nextFloat() < 0.35){
                pTarget.addEffect(new MobEffectInstance(ModEffects.STUNNED.get(),30,0,false,false));
            }
        }

        return true;
    }

    @Override
    public AttackAnim getAttackAnimation(ItemStack itemStack) {
        return isOpen(itemStack) ? AttackAnimEnum.SWING : AttackAnimEnum.STAB;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
       ItemStack stack = pPlayer.getItemInHand(pUsedHand);

       if (stack.getItem() instanceof  WarFanItem ){
           pPlayer.playSound(SoundEvents.NETHERITE_BLOCK_BREAK);
           if (isOpen(stack)){
               close(stack);
           }
           else open(stack);
       }

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    public boolean isOpen(ItemStack warFanStack) {
        CompoundTag compoundtag = warFanStack.getTag();
        return compoundtag != null && compoundtag.getBoolean("Open");
    }

    public void close(ItemStack warFanStack) {
        CompoundTag compoundtag = warFanStack.getTag();
        if (compoundtag != null){
            compoundtag.putBoolean("Open",false);
        }else{
            CompoundTag tag = warFanStack.getOrCreateTag();
            tag.putBoolean("Open",false);
        }
    }


    public void open(ItemStack warFanStack) {
        CompoundTag compoundtag = warFanStack.getTag();
        if (compoundtag != null){
            compoundtag.putBoolean("Open",true);
        }else{
            CompoundTag tag = warFanStack.getOrCreateTag();
            tag.putBoolean("Open",true);
        }
    }

}
