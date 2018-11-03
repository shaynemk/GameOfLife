package shaynemk.gameoflife.events;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

@Mod.EventBusSubscriber
public class RegistryEvents {

    @SubscribeEvent()
    public void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        /*// get registry
        IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();

        // define items to get rid of
        ResourceLocation mStonePickaxe = new ResourceLocation("minecraft:stone_pickaxe");

        // remove recipes
        modRegistry.remove(mStonePickaxe);*/


    }
}
