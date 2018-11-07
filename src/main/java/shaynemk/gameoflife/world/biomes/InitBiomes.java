package shaynemk.gameoflife.world.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import shaynemk.gameoflife.GameOfLife;

public class InitBiomes {

    public static final Biome TEST = new BiomeTest();

    public static void registerBiomes() {
        initBiome(TEST, "Test", BiomeType.WARM, Type.RIVER);
    }

    private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types) {
        biome.setRegistryName(name);
        ForgeRegistries.BIOMES.register(biome);
        GameOfLife.logger.debug("Biome ('" + name + "') registered.");
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
        BiomeManager.addSpawnBiome(biome);
        GameOfLife.logger.debug("Biome ('" + name + "') added.");
        return biome;
    }
}
