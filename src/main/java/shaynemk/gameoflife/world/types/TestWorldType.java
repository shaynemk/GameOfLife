package shaynemk.gameoflife.world.types;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import shaynemk.gameoflife.world.biomes.InitBiomes;

public class TestWorldType extends WorldType {
    /**
     * Creates a new world type, the ID is hidden and should not be referenced by modders.
     * It will automatically expand the underlying workdType array if there are no IDs left.
     *
     * param name
     */
    public TestWorldType() {
        super("TestWorldType");
    }

    @Override
    public BiomeProvider getBiomeProvider(World world) {
        //return super.getBiomeProvider(world);
        return new BiomeProviderSingle(InitBiomes.TEST);
    }
}
