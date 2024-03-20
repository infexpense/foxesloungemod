package com.fuyuvulpes.yoamod.world.item.weaponry;

import com.fuyuvulpes.yoamod.core.registries.YoaItems;
import com.fuyuvulpes.yoamod.world.item.AttackAnim;
import com.fuyuvulpes.yoamod.world.item.AttackAnims;
import com.fuyuvulpes.yoamod.world.item.WeaponItem;
import com.fuyuvulpes.yoamod.world.item.WeaponStats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;
import java.util.Random;

public class SingleScissorSwordItem extends WeaponItem {

    public SingleScissorSwordItem(Tier tier, Properties properties) {
        super(tier, WeaponStats.SINGLE_SCISSORS_SWORD, properties);

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack stack1 = pPlayer.getItemInHand(InteractionHand.OFF_HAND);
        if (pPlayer.isCrouching() && stack1 == stack){
            ItemStack stack2 = this.getMatchingScissorsItem((SingleScissorSwordItem)stack.getItem());
            stack1.setCount(0);
            return InteractionResultHolder.success(stack2);
        }
        return InteractionResultHolder.fail(stack);
    }

    private ItemStack getMatchingScissorsItem(SingleScissorSwordItem item) {
        ItemStack stack;
        List<DeferredHolder<Item, ? extends Item>> stackList = YoaItems.ITEMS.getEntries().stream().toList().stream().filter(itemDeferredHolder -> itemDeferredHolder.get() instanceof  ScissorsSwordItem item1 && item.getTier() == item1.getTier()).toList();
        stack = stackList.stream().findFirst().get().get().getDefaultInstance();

        return stack;
    }


    @Override
    public AttackAnim getAttackAnimation(ItemStack itemStack) {
        return new Random().nextFloat() > 0.62F ? AttackAnims.SWING : AttackAnims.STAB;
    }
}
