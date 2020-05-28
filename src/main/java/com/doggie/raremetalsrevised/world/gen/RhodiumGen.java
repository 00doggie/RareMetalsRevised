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

public class RhodiumGen {


    public static void generateOre() {
        for (Biome biome : ForgeRegistries.BIOMES) {

                ConfiguredPlacement customConfig = Placement.COUNT_RANGE
                        .configure(new CountRangeConfig(9, 5, 0, 25));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                        .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Init.RHODIUM_ORE.get().getDefaultState(), 5))
                        .withPlacement(customConfig));

            }
        }
    }
