package com.doggie.raremetalsrevised.world.gen;

import com.doggie.raremetalsrevised.init.BlockInit;
import com.doggie.raremetalsrevised.util.RegistryHandler;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {


    public static void generateOre() {
        for (Biome biome : ForgeRegistries.BIOMES) {

                ConfiguredPlacement customConfig = Placement.COUNT_RANGE
                        .configure(new CountRangeConfig(11, 5, 5, 25));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                        .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.RHODIUM_ORE.get().getDefaultState(), 8))
                        .withPlacement(customConfig));
            }
        }
    }
