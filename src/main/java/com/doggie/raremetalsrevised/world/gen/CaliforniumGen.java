package com.doggie.raremetalsrevised.world.gen;

import com.doggie.raremetalsrevised.init.Init;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class CaliforniumGen {
    public static void generateOre() {
        for (Biome biome : ForgeRegistries.BIOMES) {

            ConfiguredPlacement customConfig = Placement.COUNT_RANGE
                    .configure(new CountRangeConfig(1, 5, 0, 15));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Init.CALIFORNIUM_ORE.get().getDefaultState(), 4))
                    .withPlacement(customConfig));

        }
    }
}

