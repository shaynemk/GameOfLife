package shaynemk.gameoflife;

import net.minecraft.world.WorldType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import shaynemk.gameoflife.proxy.CommonProxy;
import shaynemk.gameoflife.handlers.RecipeHandler;
import shaynemk.gameoflife.world.biomes.InitBiomes;
import shaynemk.gameoflife.world.types.TestWorldType;

@Mod(modid = GameOfLife.MODID, name = GameOfLife.NAME, version = GameOfLife.VERSION, useMetadata = true)
public class GameOfLife {
    public static final String MODID = "gameoflife";
    public static final String NAME = "Game of Life";
    public static final String VERSION = "0.1";

    @SidedProxy(clientSide = "shaynemk.gameoflife.proxy.ClientProxy", serverSide = "shaynemk.gameoflife.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        InitBiomes.registerBiomes();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // clean the slate, and repopulate the world
        RecipeHandler.removeVanillaRecipes();

        // welcome the masochists
        logger.info("Welcome to the desparate Game Of Life.");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        WorldType TEST = new TestWorldType();
    }
}
