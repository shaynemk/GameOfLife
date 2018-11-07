package shaynemk.gameoflife.misc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import shaynemk.gameoflife.items.ModItems;
import shaynemk.gameoflife.tools.ModTools;

public class CreativeTab {
    public static final CreativeTabs tabGameOfLife = (new CreativeTabs("Game of Life") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModTools.toolFlintPickaxe);
        }

        @Override
        public boolean hasSearchBar() {
            return true;
        }

        /**
         * returns tabIndex < 6
         */
        /*@Override
        public boolean isTabInFirstRow() {
            return true;
        }*/
    });
}
