package shaynemk.gameoflife.items;

import net.minecraft.item.ItemPickaxe;
import shaynemk.gameoflife.GameOfLife;
import shaynemk.gameoflife.misc.CreativeTab;

public class ToolRoughStonePickaxe extends ItemPickaxe {
    public ToolRoughStonePickaxe(ToolMaterial material) {
        super(material);
        init();
    }

    private void init() {
        setRegistryName("toolRoughStonePickaxe");
        setUnlocalizedName(GameOfLife.MODID + ".toolRoughStonePickaxe");
        setCreativeTab(CreativeTab.tabGameOfLife);
        setMaxStackSize(1);
        setMaxDamage(21); // durability desired + 1
        setHarvestLevel("pickaxe",1);
        setNoRepair();
    }
}
