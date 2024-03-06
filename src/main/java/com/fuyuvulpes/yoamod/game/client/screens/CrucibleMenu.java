package com.fuyuvulpes.yoamod.game.client.screens;

import com.fuyuvulpes.yoamod.core.registries.MenusModReg;
import com.fuyuvulpes.yoamod.core.registries.RecipesModReg;
import com.fuyuvulpes.yoamod.game.server.crafting.CrucibleRecipe;
import com.fuyuvulpes.yoamod.world.inventory.CrucibleFuelSlot;
import com.fuyuvulpes.yoamod.world.inventory.CrucibleResultSlot;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class CrucibleMenu extends AbstractContainerMenu {

    public static final int INGREDIENT_SLOTA = 0;
    public static final int INGREDIENT_SLOTB = 1;
    public static final int SUPPORT_SLOT = 2;
    public static final int FUEL_SLOT = 3;
    public static final int RESULT_SLOT = 4;
    public static final int SLOT_COUNT = 5;
    private static final int INV_SLOT_START = 3;
    private static final int INV_SLOT_END = 30;
    private static final int USE_ROW_SLOT_START = 30;
    private static final int USE_ROW_SLOT_END = 39;
    private final Container container;
    private final Level level;
    private final ContainerData data;
    private final RecipeType<? extends CrucibleRecipe> recipeType;

    public CrucibleMenu(int pContainerId, Inventory pPlayerInventory) {
        this(pContainerId, pPlayerInventory, new SimpleContainer(5), new SimpleContainerData(5));
    }


    public CrucibleMenu(int pId, Inventory inventory, Container pContainer, ContainerData data) {
        super(MenusModReg.CRUCIBLE_MENU.get(), pId);
        checkContainerSize(inventory, 5);
        this.level = inventory.player.level();
        this.data = data;
        this.container = pContainer;
        this.recipeType = RecipesModReg.CRUCIBLE_TYPE.get();

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);

        this.addSlot(new Slot(pContainer, 0, 23, 19));
        this.addSlot(new Slot(pContainer, 1, 41, 19));
        this.addSlot(new Slot(pContainer, 2, 32, 41));
        this.addSlot(new CrucibleFuelSlot(this,pContainer, 3, 80, 51));
        this.addSlot(new CrucibleResultSlot(inventory.player,pContainer, 4, 128, 19));


        addDataSlots(data);
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);  // Max Progress
        int progressArrowSize = 62; // This is the height in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public boolean isLit() {
        return data.get(0) > 0;
    }

    public int getScaledUsage() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);  // Max Progress
        int progressFuelSize = 10; // This is the height in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * progressFuelSize / maxProgress : 0;
    }



    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = SLOT_COUNT;  // must be the number of slots you have!
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


    @Override
    public boolean stillValid(Player pPlayer) {
        return this.container.stillValid(pPlayer);
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }


    public static boolean isFuel(ItemStack pStack) {
        return pStack.is(Items.LAVA_BUCKET) || pStack.getBurnTime(RecipesModReg.CRUCIBLE_TYPE.get()) > 1000;

    }

    protected boolean canSmelt(ItemStack pStack) {
        return this.level.getRecipeManager().getRecipeFor((RecipeType<CrucibleRecipe>)this.recipeType, new SimpleContainer(pStack), this.level).isPresent();
    }
}

