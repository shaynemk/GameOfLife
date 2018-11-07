package shaynemk.gameoflife.handlers;

import com.google.common.collect.Lists;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import shaynemk.gameoflife.recipes.DummyRecipe;

import java.util.ArrayList;

public class RecipeHandler {
    private static ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>) ForgeRegistries.RECIPES;
    private static ArrayList<IRecipe> recipeList = Lists.newArrayList(recipeRegistry.getValues());

    public static void registerRecipes() {

    }

    public static void removeVanillaRecipes() {
        //ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>) ForgeRegistries.RECIPES;
        //ArrayList<IRecipe> recipes = Lists.newArrayList(recipeRegistry.getValues());

        for (IRecipe r : recipeList) {
            /*ItemStack output = r.getRecipeOutput();
            if (output.getItem() == Item.getItemFromBlock(Blocks.PLANKS)) {
                delete(r);
            }*/
            delete(r);
        }
        registerRecipes();
    }

    private static void delete(IRecipe recipe) {
        recipeRegistry.remove(recipe.getRegistryName());
        recipeRegistry.register(DummyRecipe.from(recipe));
    }
}
