package com.fuyuvulpes.yoamod.world.magic.mana;

import com.fuyuvulpes.yoamod.world.magic.ElementType;
import com.fuyuvulpes.yoamod.world.magic.Magic;
import com.fuyuvulpes.yoamod.world.magic.SpellType;
import net.minecraft.world.entity.player.Player;

public class ManaHelper {

    public boolean canCastSpell(Player player, SpellType spell, ElementType element, Magic magic){
        return Impl.INSTANCE.canCastSpell(player,spell,element,magic);
    }

    public static void setMaxMana(Player player, int mana){
        Impl.INSTANCE.setMaxMana(player,mana);
    }

    public static int getMaxMana(Player player){
        return Impl.INSTANCE.getMaxMana(player);
    }

    public static IMana getManaData(Player player){
        return Impl.INSTANCE.getManaData(player);
    }


    public static class Impl
    {
        public static IManaHelper INSTANCE = null;

        public interface IManaHelper {
            boolean canCastSpell(Player player, SpellType spell, ElementType element, Magic magic);
            void setMaxMana(Player player, int mana);
            int getMaxMana(Player player);
            IMana getManaData(Player player);


        }
    }


}
