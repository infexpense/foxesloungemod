package com.fuyuvulpes.yoamod.world.entity.block;

import com.fuyuvulpes.yoamod.core.registries.BlockEntitiesModReg;
import com.fuyuvulpes.yoamod.core.registries.RecipesModReg;
import com.fuyuvulpes.yoamod.game.client.screens.HammeringStationMenu;
import com.fuyuvulpes.yoamod.game.server.crafting.HammeringStationRecipe;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class HammeringStationBlockEntity extends BaseContainerBlockEntity implements MenuProvider {

    private static final int[] INGREDIENT_SLOT = new int[]{0, 1, 2, 3};
    private static final int RESULT_SLOT = 4;
    private static final int[] SLOTS_FOR_UP = new int[]{0, 1, 2, 3};
    private static final int[] SLOTS_FOR_DOWN = new int[]{4, 3};
    private static final int[] SLOTS_FOR_SIDES = new int[]{3};
    private final RecipeType<HammeringStationRecipe> recipeType;
    protected NonNullList<ItemStack> items = NonNullList.withSize(5, ItemStack.EMPTY);

    protected final ContainerData dataAccess = new ContainerData() {
        @Override
        public int get(int p_58431_) {
                    return 0;
            }

        @Override
        public void set(int pIndex, int pValue) {

        }


        @Override
        public int getCount() {
            return 0;
        }
    };
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
    private final RecipeManager.CachedCheck<Container, ? extends HammeringStationRecipe> quickCheck;

    public HammeringStationBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(BlockEntitiesModReg.HAMMERING_STATION.get(), p_155229_, p_155230_);
        this.quickCheck = RecipeManager.createCheck(RecipesModReg.HAMMERING_STATION_TYPE.get());
        this.recipeType = RecipesModReg.HAMMERING_STATION_TYPE.get();
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.yoamod.hammering_station");
    }

    @Override
    protected AbstractContainerMenu createMenu(int pId, Inventory pPlayer) {
        return new HammeringStationMenu(pId, pPlayer, this, this.dataAccess);
    }

    @Override
    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getItem(int pSlot) {
        return this.items.get(pSlot);
    }

    @Override
    public ItemStack removeItem(int pSlot, int pAmount) {
        return ContainerHelper.removeItem(this.items, pSlot, pAmount);
    }

    @Override
    public ItemStack removeItemNoUpdate(int pSlot) {
        return ContainerHelper.takeItem(this.items, pSlot);
    }

    @Override
    public void setItem(int pSlot, ItemStack pStack) {

    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return Container.stillValidBlockEntity(this, pPlayer);
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items);
    }

    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        ContainerHelper.saveAllItems(pTag, this.items);
    }
}
