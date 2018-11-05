package shaynemk.gameoflife;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import shaynemk.gameoflife.proxy.CommonProxy;
import shaynemk.gameoflife.recipes.RecipeHandler;

@Mod(modid = GameOfLife.MODID, name = GameOfLife.NAME, version = GameOfLife.VERSION, useMetadata = true)
public class GameOfLife {
    public static final String MODID = "gameoflife";
    public static final String NAME = "Game of Life";
    public static final String VERSION = "0.1";

    @SidedProxy(clientSide = "shaynemk.gameoflife.proxy.ClientProxy", serverSide = "shaynemk.gameoflife.proxy.ServerProxy")
    public static CommonProxy proxy;

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // clean the slate, and repopulate the world
        RecipeHandler.removeVanillaRecipes();

        // welcome the masochists
        logger.info("Welcome to the desparate Game Of Life.");
    }
}
