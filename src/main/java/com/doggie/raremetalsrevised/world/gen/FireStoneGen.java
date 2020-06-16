package com.doggie.raremetalsrevised.world.gen;

import com.doggie.raremetalsrevised.init.Init;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.registries.ForgeRegistries;

public class FireStoneGen {


    public static void generateOre() {
        for (final Biome biome : ForgeRegistries.BIOMES) {
            if (WorldHelper.biomeHasType(biome, new BiomeDictionary.Type[]{BiomeDictionary.Type.NETHER})) {

                ConfiguredPlacement customConfig = Placement.COUNT_RANGE
                        .configure(new CountRangeConfig(2, 5, 0, 60));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                        .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Init.FIRE_STONE.get().getDefaultState(), 4))
                        .withPlacement(customConfig));

            }
        }
    }
}
