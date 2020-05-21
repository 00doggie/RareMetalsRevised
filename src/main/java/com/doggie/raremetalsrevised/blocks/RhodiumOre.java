package com.doggie.raremetalsrevised.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ToolType;

import java.util.Random;


public class RhodiumOre extends OreBlock {

    public RhodiumOre(Properties from) {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(4.0f, 5.0f)
                .sound(SoundType.STONE)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE));
    }



}
