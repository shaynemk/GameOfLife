package shaynemk.gameoflife.world.biomes;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BiomeTest extends Biome {
    public BiomeTest() {
        super(new BiomeProperties("TestBiome").setBaseHeight(-0.5F).setHeightVariation(0.0F).setRainDisabled().setWaterColor(16711680));

        topBlock = Blocks.DIRT.getDefaultState();
        fillerBlock = Blocks.DIAMOND_ORE.getDefaultState();

        this.decorator.diamondGen = new WorldGenMinable(Blocks.PLANKS.getDefaultState(), 10);

        this.decorator.treesPerChunk = 2;

        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();

        this.spawnableCreatureList.add(new SpawnListEntry(EntityWither.class, 10, 1, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityDragon.class, 5, 1, 2));
    }
}
