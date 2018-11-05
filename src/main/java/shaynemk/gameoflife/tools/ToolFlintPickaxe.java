package shaynemk.gameoflife.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import shaynemk.gameoflife.GameOfLife;
import shaynemk.gameoflife.misc.CreativeTab;

public class ToolFlintPickaxe extends ItemPickaxe {
    public ToolFlintPickaxe() {
        /** TODO
         *  create custom ToolMaterial.FLINT, weaker than STONE.
         */
        super(Item.ToolMaterial.STONE);
        init();
    }

    private void init() {
        setRegistryName("toolFlintPickaxe");
        setUnlocalizedName(GameOfLife.MODID + ".toolFlintPickaxe");
        setCreativeTab(CreativeTab.tabGameOfLife);
        setMaxStackSize(1);
        setMaxDamage(21); // durability desired + 1
        setHarvestLevel("pickaxe",1);
        setNoRepair();
    }
}
