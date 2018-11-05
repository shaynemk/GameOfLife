package shaynemk.gameoflife.recipes;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

/**
 * http://www.minecraftforge.net/forum/topic/61317-solved1122-how-to-remove-vanilla-recipes/?do=findComment&comment=286871
 */
public class DummyRecipe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {
    private final ItemStack output;

    public DummyRecipe(ItemStack output) {
        this.output = output;
    }

    public static IRecipe from(IRecipe oldRecipe)
    {
        return new DummyRecipe(oldRecipe.getRecipeOutput()).setRegistryName(oldRecipe.getRegistryName());
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     *
     * @param inv
     * @param worldIn
     */
    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        return false;
    }

    /**
     * Returns an Item that is the result of this recipe
     *
     * @param inv
     */
    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return ItemStack.EMPTY;
    }

    /**
     * Used to determine if this recipe can fit in a grid of the given width/height
     *
     * @param width
     * @param height
     */
    @Override
    public boolean canFit(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return output;
    }
}
