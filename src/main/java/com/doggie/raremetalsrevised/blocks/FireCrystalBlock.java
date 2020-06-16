package com.doggie.raremetalsrevised.blocks;

import com.doggie.raremetalsrevised.RareMetalsRevised;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class FireCrystalBlock extends Block {

    public FireCrystalBlock() {

        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(6.0f, 7.0f)
                .sound(SoundType.METAL)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE));
    }

}