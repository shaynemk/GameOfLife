package shaynemk.gameoflife.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import shaynemk.gameoflife.tools.ToolFlintPickaxe;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        //event.getRegistry().register(new Lamp());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        //event.getRegistry().register(new ItemBlock(ModBlocks.lamp).setRegistryName(ModBlocks.lamp.getRegistryName()));
        //event.getRegistry().register(new ItemWrench());

        event.getRegistry().register(new ToolFlintPickaxe());
    }

    /*@SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<Recipe>)*/
}

