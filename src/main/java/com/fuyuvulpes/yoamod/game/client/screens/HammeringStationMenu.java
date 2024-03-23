package com.fuyuvulpes.yoamod.game.client.screens;

import com.fuyuvulpes.yoamod.core.registries.YoaBlocks;
import com.fuyuvulpes.yoamod.core.registries.YoaMenus;
import com.fuyuvulpes.yoamod.core.registries.YoaRecipes;
import com.fuyuvulpes.yoamod.game.server.crafting.HammeringStationRecipe;
import net.minecraft.core.NonNullList;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HammeringStationMenu extends AbstractContainerMenu {
        private final ContainerLevelAccess access;
        private final DataSlot selectedRecipeIndex = DataSlot.standalone();
        private final Level level;
        private List<RecipeHolder<HammeringStationRecipe>> recipes = new ArrayList<>();
        private ItemStack ingA = ItemStack.EMPTY;
        private ItemStack ingB = ItemStack.EMPTY;
        private ItemStack ingC = ItemStack.EMPTY;
        private ItemStack ingD = ItemStack.EMPTY;
        private long lastSoundTime;
        private final Slot inputA;
        private final Slot inputB;
        private final Slot inputC;
        private final Slot inputD;
        private final Slot resultSlot;
        private Runnable slotUpdateListener = () -> {};
        private final Container container = new SimpleContainer(5) {
            @Override
            public void setChanged() {
                super.setChanged();
                slotsChanged(this);
                slotUpdateListener.run();
            }
        };
        private final ResultContainer resultContainer = new ResultContainer();

        public HammeringStationMenu(int id, Inventory playerInventory) {
            this(id, playerInventory, ContainerLevelAccess.NULL);
        }

        public HammeringStationMenu(int id, Inventory playerInventory, final ContainerLevelAccess access) {
            super(YoaMenus.HAMMERING_STATION_MENU.get(), id);
            this.access = access;
            this.level = playerInventory.player.level();
            this.inputA = addSlot(new Slot(this.container, 0, 8, 8));
            this.inputB = addSlot(new Slot(this.container, 1, 28, 8));
            this.inputC = addSlot(new Slot(this.container, 2, 8, 28));
            this.inputD = addSlot(new Slot(this.container, 3, 28, 28));

            this.resultSlot = addSlot(new Slot(this.resultContainer, 4, 141, 54) {
                @Override
                public boolean mayPlace(ItemStack stack) {
                    return false;
                }

                @Override
                public void onTake(Player playerIn, ItemStack stack) {
                    stack.onCraftedBy(playerIn.level(), playerIn, stack.getCount());
                    resultContainer.awardUsedRecipes(playerIn, getRelevantItems());
                    ItemStack itemstack = inputA.remove(1);
                    if (!itemstack.isEmpty()) {
                        setupResultSlot();
                    }
                    access.execute((world, pos) -> {
                        long l = world.getGameTime();
                        if (lastSoundTime != l) {
                            world.playSound(null, pos, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1f, 1f);
                            lastSoundTime = l;
                        }
                    });
                    super.onTake(playerIn, stack);
                }

                private List<ItemStack> getRelevantItems() {
                    return List.of(inputA.getItem());
                }
            });
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 9; ++j) {
                    addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
                }
            }
            for (int k = 0; k < 9; ++k) {
                addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
            }
            addDataSlot(this.selectedRecipeIndex);
        }

        public int getSelectedRecipeIndex() {
            return this.selectedRecipeIndex.get();
        }

        public List<RecipeHolder<HammeringStationRecipe>> getRecipes() {
            return this.recipes;
        }

        public int getNumRecipes() {
            return this.recipes.size();
        }

        public boolean hasInputItem() {
            return this.inputA.hasItem() && this.inputB.hasItem() && this.inputC.hasItem() && this.inputD.hasItem() && !this.recipes.isEmpty();
        }

        @Override
        public boolean clickMenuButton(Player playerIn, int id) {
            if (isValidRecipeIndex(id)) {
                this.selectedRecipeIndex.set(id);
                setupResultSlot();
            }
            return true;
        }

        private boolean isValidRecipeIndex(int id) {
            return id >= 0 && id < this.recipes.size();
        }

        @Override
        public void slotsChanged(Container inventoryIn) {
            ItemStack stackA = this.inputA.getItem();
            ItemStack stackB = this.inputB.getItem();
            ItemStack stackC = this.inputC.getItem();
            ItemStack stackD = this.inputD.getItem();
            if (stackA.getItem() != this.ingA.getItem()) {
                this.ingA = stackA.copy();
                setupRecipeList(inventoryIn, stackA);
            }
            if (stackB.getItem() != this.ingB.getItem()) {
                this.ingB = stackB.copy();
                setupRecipeList(inventoryIn, stackA);
            }
            if (stackC.getItem() != this.ingC.getItem()) {
                this.ingC = stackC.copy();
                setupRecipeList(inventoryIn, stackC);
            }
            if (stackD.getItem() != this.ingD.getItem()) {
                this.ingD = stackD.copy();
                setupRecipeList(inventoryIn, stackD);
            }
        }

        private void setupRecipeList(Container inventoryIn, ItemStack stack) {
            this.recipes.clear();
            this.selectedRecipeIndex.set(-1);
            this.resultSlot.set(ItemStack.EMPTY);
            if (!stack.isEmpty()) {
                this.recipes = this.level.getRecipeManager().getRecipesFor(YoaRecipes.HAMMERING_STATION_TYPE.get(), inventoryIn, this.level);
            }
        }

        private void setupResultSlot() {
            if (!this.recipes.isEmpty() && isValidRecipeIndex(this.selectedRecipeIndex.get())) {
                RecipeHolder<HammeringStationRecipe> recipeHolder = this.recipes.get(this.selectedRecipeIndex.get());
                ItemStack stack = recipeHolder.value().assemble(this.container, this.level.registryAccess());
                if (stack.isItemEnabled(this.level.enabledFeatures())) {
                    this.resultContainer.setRecipeUsed(recipeHolder);
                    this.resultSlot.set(stack);
                } else {
                    this.resultSlot.set(ItemStack.EMPTY);
                }
            } else {
                this.resultSlot.set(ItemStack.EMPTY);
            }
            broadcastChanges();
        }

        @Override
        public MenuType<?> getType() {
            return YoaMenus.HAMMERING_STATION_MENU.get();
        }

        public void registerUpdateListener(Runnable runnable) {
            this.slotUpdateListener = runnable;
        }

        @Override
        public boolean canTakeItemForPickAll(ItemStack stack, Slot slotIn) {
            return slotIn.container != this.resultContainer && super.canTakeItemForPickAll(stack, slotIn);
        }


    @Override
    public boolean stillValid(Player pPlayer) {
        return this.container.stillValid(pPlayer);
    }

    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 5;  // must be the number of slots you have!
    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;

    }

    public void removed(Player pPlayer) {
        super.removed(pPlayer);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((p_40313_, p_40314_) -> {
            this.clearContainer(pPlayer, this.container);
        });
        }
    }