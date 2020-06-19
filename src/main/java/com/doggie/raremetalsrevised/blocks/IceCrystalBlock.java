package com.doggie.raremetalsrevised.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;


public class IceCrystalBlock extends Block {

    public IceCrystalBlock() {

        super(Properties.create(Material.IRON)
                .hardnessAndResistance(6.0f, 7.0f)
                .sound(SoundType.METAL)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE));
    }

}