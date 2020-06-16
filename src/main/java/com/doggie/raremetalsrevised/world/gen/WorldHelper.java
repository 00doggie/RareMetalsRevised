package com.doggie.raremetalsrevised.world.gen;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class WorldHelper
{
    public static boolean biomeHasType(final Biome biome, final BiomeDictionary.Type... types) {
        for (final BiomeDictionary.Type type : types) {
            if (BiomeDictionary.hasType(biome, type)) {
                return true;
            }
        }
        return false;
    }
}
