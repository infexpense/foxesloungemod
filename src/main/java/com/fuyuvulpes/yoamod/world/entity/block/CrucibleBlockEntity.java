package com.fuyuvulpes.yoamod.world.entity.block;

import com.fuyuvulpes.yoamod.core.registries.BlockEntitiesModReg;
import com.fuyuvulpes.yoamod.core.registries.RecipesModReg;
import com.fuyuvulpes.yoamod.game.client.screens.CrucibleMenu;
import com.fuyuvulpes.yoamod.game.server.crafting.CrucibleRecipe;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class CrucibleBlockEntity extends BaseContainerBlockEntity implements MenuProvider, WorldlyContainer, RecipeCraftingHolder, StackedContentsCompatible {
    protected static final int[] SLOT_INPUT = new int[]{0,1,2};
    protected static final int SLOT_FUEL = 3;
    protected static final int SLOT_RESULT = 4;
    public static final int DATA_LIT_TIME = 0;
    private static final int[] SLOTS_FOR_UP = new int[]{0,1,2,3};
    private static final int[] SLOTS_FOR_DOWN = new int[]{4, 3};
    private static final int[] SLOTS_FOR_SIDES = new int[]{3};
    public static final int DATA_LIT_DURATION = 1;
    public static final int DATA_COOKING_PROGRESS = 2;
    public static final int DATA_COOKING_TOTAL_TIME = 3;
    public static final int NUM_DATA_VALUES = 4;
    public static final int BURN_TIME_STANDARD = 200;
    public static final int BURN_COOL_SPEED = 2;
    private final RecipeType<CrucibleRecipe> recipeType;
    protected NonNullList<ItemStack> items = NonNullList.withSize(5, ItemStack.EMPTY);
    int litTime;
    int litDuration;
    int cookingProgress;
    int cookingTotalTime;

    protected final ContainerData dataAccess = new ContainerData() {
        @Override
        public int get(int p_58431_) {
            switch(p_58431_) {
                case 0:
                    return CrucibleBlockEntity.this.litTime;
                case 1:
                    return CrucibleBlockEntity.this.litDuration;
                case 2:
                    return CrucibleBlockEntity.this.cookingProgress;
                case 3:
                    return CrucibleBlockEntity.this.cookingTotalTime;
                default:
                    return 0;
            }
        }

        @Override
        public void set(int p_58433_, int p_58434_) {
            switch(p_58433_) {
                case 0:
                    CrucibleBlockEntity.this.litTime = p_58434_;
                    break;
                case 1:
                    CrucibleBlockEntity.this.litDuration = p_58434_;
                    break;
                case 2:
                    CrucibleBlockEntity.this.cookingProgress = p_58434_;
                    break;
                case 3:
                    CrucibleBlockEntity.this.cookingTotalTime = p_58434_;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    };
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
    private final RecipeManager.CachedCheck<Container, ? extends AbstractCookingRecipe> quickCheck;



public CrucibleBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntitiesModReg.CRUCIBLE.get(), pPos, pBlockState);
        this.quickCheck = RecipeManager.createCheck(RecipesModReg.CRUCIBLE_TYPE.get());
        this.recipeType = RecipesModReg.CRUCIBLE_TYPE.get();
        }


    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.yoamod.crucible");
    }




    //PLEASE
    //MAKE THIS CRUCIBLE MENU!!!!!!!!!!!!!!!
    @Override
    protected AbstractContainerMenu createMenu(int pId, Inventory pPlayer) {
        return new CrucibleMenu(pId, pPlayer, this, this.dataAccess);
    }

    private boolean isLit() {
        return this.litTime > 0;
    }

    protected int getBurnDuration(ItemStack pFuel) {
        if (pFuel.isEmpty()) {
            return 0;
        } else {
            Item item = pFuel.getItem();
            return item.getDefaultInstance().is(Items.LAVA_BUCKET) ? 0 : 900;
        }
    }
    @Override
    public int[] getSlotsForFace(Direction pSide) {
        if (pSide == Direction.DOWN) {
            return SLOTS_FOR_DOWN;
        } else {
            return pSide == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
        }    }
    @Override
    public boolean canPlaceItemThroughFace(int pIndex, ItemStack pItemStack, @javax.annotation.Nullable Direction pDirection) {
        return this.canPlaceItem(pIndex, pItemStack);
    }

    @Override
    public boolean canTakeItemThroughFace(int pIndex, ItemStack pStack, Direction pDirection) {
        if (pDirection == Direction.DOWN && pIndex == 1) {
            return pStack.is(Items.WATER_BUCKET) || pStack.is(Items.BUCKET);
        } else {
            return true;
        }
    }

    @Override
    public int getContainerSize() {
        return this.items.size();
    }
    @Override
    public boolean isEmpty() {
        for(ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getItem(int pIndex) {
        return this.items.get(pIndex);
    }

    @Override
    public ItemStack removeItem(int pIndex, int pCount) {
        return ContainerHelper.removeItem(this.items, pIndex, pCount);
    }

    @Override
    public ItemStack removeItemNoUpdate(int pIndex) {
        return ContainerHelper.takeItem(this.items, pIndex);
    }

    @Override
    public void setItem(int pIndex, ItemStack pStack) {
        ItemStack itemstack = this.items.get(pIndex);
        boolean flag = !pStack.isEmpty() && ItemStack.isSameItemSameTags(itemstack, pStack);
        this.items.set(pIndex, pStack);
        if (pStack.getCount() > this.getMaxStackSize()) {
            pStack.setCount(this.getMaxStackSize());
        }

        if (pIndex == 0 && !flag) {
            this.cookingTotalTime = getTotalCookTime(this.level, this);
            this.cookingProgress = 0;
            this.setChanged();
        }
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return Container.stillValidBlockEntity(this, pPlayer);
    }

    @Override
    public boolean canPlaceItem(int pIndex, ItemStack pStack) {
        if (pIndex == 2) {
            return false;
        } else if (pIndex != 1) {
            return true;
        } else {
            ItemStack itemstack = this.items.get(1);
            return net.neoforged.neoforge.common.CommonHooks.getBurnTime(pStack, this.recipeType) > 0 || pStack.is(Items.BUCKET) && !itemstack.is(Items.BUCKET);
        }
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }



    @Override
    public void setRecipeUsed(@javax.annotation.Nullable RecipeHolder<?> pRecipe) {
        if (pRecipe != null) {
            ResourceLocation resourcelocation = pRecipe.id();
            this.recipesUsed.addTo(resourcelocation, 1);
        }
    }

    @javax.annotation.Nullable
    @Override
    public RecipeHolder<?> getRecipeUsed() {
        return null;
    }

    @Override
    public void awardUsedRecipes(Player pPlayer, List<ItemStack> pItems) {
    }



    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items);
        this.litTime = pTag.getInt("BurnTime");
        this.cookingProgress = pTag.getInt("CookTime");
        this.cookingTotalTime = pTag.getInt("CookTimeTotal");
        this.litDuration = this.getBurnDuration(this.items.get(3));
        CompoundTag compoundtag = pTag.getCompound("RecipesUsed");

        for(String s : compoundtag.getAllKeys()) {
            this.recipesUsed.put(new ResourceLocation(s), compoundtag.getInt(s));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.putInt("BurnTime", this.litTime);
        pTag.putInt("CookTime", this.cookingProgress);
        pTag.putInt("CookTimeTotal", this.cookingTotalTime);
        ContainerHelper.saveAllItems(pTag, this.items);
        CompoundTag compoundtag = new CompoundTag();
        this.recipesUsed.forEach((p_187449_, p_187450_) -> compoundtag.putInt(p_187449_.toString(), p_187450_));
        pTag.put("RecipesUsed", compoundtag);
    }

    @Override
    public void fillStackedContents(StackedContents pHelper) {
        for(ItemStack itemstack : this.items) {
            pHelper.accountStack(itemstack);
        }
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, CrucibleBlockEntity pBlockEntity) {
        boolean flag = pBlockEntity.isLit();
        boolean flag1 = false;
        if (pBlockEntity.isLit()) {
            --pBlockEntity.litTime;
        }

        ItemStack itemstack = pBlockEntity.items.get(3);
        boolean flag2 = !pBlockEntity.items.get(0).isEmpty() && !pBlockEntity.items.get(1).isEmpty();
        boolean flag3 = !itemstack.isEmpty();
        if (pBlockEntity.isLit() || flag3 && flag2) {
            RecipeHolder<?> recipeholder;
            if (flag2) {
                recipeholder = pBlockEntity.quickCheck.getRecipeFor(pBlockEntity, pLevel).orElse(null);
            } else {
                recipeholder = null;
            }

            int i = pBlockEntity.getMaxStackSize();
            if (!pBlockEntity.isLit() && pBlockEntity.canBurn(pLevel.registryAccess(), recipeholder, pBlockEntity.items, i)) {
                pBlockEntity.litTime = pBlockEntity.getBurnDuration(itemstack);
                pBlockEntity.litDuration = pBlockEntity.litTime;
                if (pBlockEntity.isLit()) {
                    flag1 = true;
                    if (itemstack.hasCraftingRemainingItem())
                        pBlockEntity.items.set(3, itemstack.getCraftingRemainingItem());
                    else
                    if (flag3) {
                        Item item = itemstack.getItem();
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            pBlockEntity.items.set(3, itemstack.getCraftingRemainingItem());
                        }
                    }
                }
            }

            if (pBlockEntity.isLit() && pBlockEntity.canBurn(pLevel.registryAccess(), recipeholder, pBlockEntity.items, i)) {
                ++pBlockEntity.cookingProgress;
                if (pBlockEntity.cookingProgress == pBlockEntity.cookingTotalTime) {
                    pBlockEntity.cookingProgress = 0;
                    pBlockEntity.cookingTotalTime = getTotalCookTime(pLevel, pBlockEntity);
                    if (pBlockEntity.burn(pLevel.registryAccess(), recipeholder, pBlockEntity.items, i)) {
                        pBlockEntity.setRecipeUsed(recipeholder);
                    }

                    flag1 = true;
                }
            } else {
                pBlockEntity.cookingProgress = 0;
            }
        } else if (!pBlockEntity.isLit() && pBlockEntity.cookingProgress > 0) {
            pBlockEntity.cookingProgress = Mth.clamp(pBlockEntity.cookingProgress - 2, 0, pBlockEntity.cookingTotalTime);
        }

        if (flag != pBlockEntity.isLit()) {
            flag1 = true;
            pState = pState.setValue(AbstractFurnaceBlock.LIT, Boolean.valueOf(pBlockEntity.isLit()));
            pLevel.setBlock(pPos, pState, 3);
        }

        if (flag1) {
            setChanged(pLevel, pPos, pState);
        }
    }

    private boolean canBurn(RegistryAccess pRecipe, @javax.annotation.Nullable RecipeHolder<?> pInventory, NonNullList<ItemStack> pMaxStackSize, int p_155008_) {
        if ((!pMaxStackSize.get(0).isEmpty() || !pMaxStackSize.get(1).isEmpty()) && pInventory != null) {
            ItemStack itemstack = ((RecipeHolder<net.minecraft.world.item.crafting.Recipe<WorldlyContainer>>) pInventory).value().assemble(this, pRecipe);
            if (itemstack.isEmpty()) {
                return false;
            } else {
                ItemStack itemstack1 = pMaxStackSize.get(2);
                if (itemstack1.isEmpty()) {
                    return true;
                } else if (!ItemStack.isSameItem(itemstack1, itemstack)) {
                    return false;
                } else if (itemstack1.getCount() + itemstack.getCount() <= p_155008_ && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) { // Forge fix: make furnace respect stack sizes in furnace recipes
                    return true;
                } else {
                    return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
                }
            }
        } else {
            return false;
        }
    }

    private boolean burn(RegistryAccess pRecipe, @javax.annotation.Nullable RecipeHolder<?> pInventory, NonNullList<ItemStack> pMaxStackSize, int p_267157_) {
        if (pInventory != null && this.canBurn(pRecipe, pInventory, pMaxStackSize, p_267157_)) {
            ItemStack itemstack = pMaxStackSize.get(0);
            ItemStack itemstack1 = pMaxStackSize.get(0);
            ItemStack itemstack2 = ((RecipeHolder<net.minecraft.world.item.crafting.Recipe<WorldlyContainer>>) pInventory).value().assemble(this, pRecipe);
            ItemStack itemstack3 = pMaxStackSize.get(4);
            if (itemstack3.isEmpty()) {
                pMaxStackSize.set(4, itemstack2.copy());
            } else if (itemstack3.is(itemstack2.getItem())) {
                itemstack3.grow(itemstack2.getCount());
            }


            itemstack.shrink(1);
            itemstack1.shrink(1);
            return true;
        } else {
            return false;
        }
    }



    private static int getTotalCookTime(Level pLevel, CrucibleBlockEntity pBlockEntity) {
        return pBlockEntity.quickCheck.getRecipeFor(pBlockEntity, pLevel).map(p_300840_ -> p_300840_.value().getCookingTime()).orElse(200);
    }

    public static boolean isFuel(ItemStack pStack) {
        return net.neoforged.neoforge.common.CommonHooks.getBurnTime(pStack, null) > 0;
    }


}
