package com.fuyuvulpes.yoamod.world.item;

import com.fuyuvulpes.yoamod.world.entity.vehicle.PlaneEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Predicate;

public class PlaneItem extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);

    public PlaneItem(Item.Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        HitResult hitresult = getPlayerPOVHitResult(pLevel, pPlayer, ClipContext.Fluid.ANY);
        if (hitresult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemstack);
        } else {
            Vec3 vec3 = pPlayer.getViewVector(1.0F);
            double d0 = 5.0;
            List<Entity> list = pLevel.getEntities(pPlayer, pPlayer.getBoundingBox().expandTowards(vec3.scale(5.0)).inflate(1.0), ENTITY_PREDICATE);
            if (!list.isEmpty()) {
                Vec3 vec31 = pPlayer.getEyePosition();

                for(Entity entity : list) {
                    AABB aabb = entity.getBoundingBox().inflate((double)entity.getPickRadius());
                    if (aabb.contains(vec31)) {
                        return InteractionResultHolder.pass(itemstack);
                    }
                }
            }

            if (hitresult.getType() == HitResult.Type.BLOCK) {
                PlaneEntity plane = this.getPlane(pLevel, hitresult, itemstack, pPlayer);
                plane.setYRot(pPlayer.getYRot());
                if (!pLevel.noCollision(plane, plane.getBoundingBox())) {
                    return InteractionResultHolder.fail(itemstack);
                } else {
                    if (!pLevel.isClientSide) {
                        pLevel.addFreshEntity(plane);
                        pLevel.gameEvent(pPlayer, GameEvent.ENTITY_PLACE, hitresult.getLocation());
                        if (!pPlayer.getAbilities().instabuild) {
                            itemstack.shrink(1);
                        }
                    }

                    pPlayer.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
                }
            } else {
                return InteractionResultHolder.pass(itemstack);
            }
        }
    }

    private PlaneEntity getPlane(Level p_220017_, HitResult p_220018_, ItemStack p_305852_, Player p_306127_) {
        Vec3 vec3 = p_220018_.getLocation();
        PlaneEntity plane = new PlaneEntity(p_220017_, vec3.x, vec3.y, vec3.z);
        if (p_220017_ instanceof ServerLevel serverlevel) {
            EntityType.<PlaneEntity>createDefaultStackConfig(serverlevel, p_305852_, p_306127_).accept(plane);
        }

        return plane;
    }
}
