package com.doggie.raremetalsrevised.init;

import com.doggie.raremetalsrevised.RareMetalsRevised;
import com.doggie.raremetalsrevised.blocks.BlockItemBase;
import com.doggie.raremetalsrevised.blocks.RhodiumBlock;
import com.doggie.raremetalsrevised.blocks.RhodiumOre;
import com.doggie.raremetalsrevised.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;


public class BlockInit {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,
            RareMetalsRevised.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, RareMetalsRevised.MOD_ID);
    public static final RegistryObject<Block> RHODIUM_BLOCK = BLOCKS.register("rhodium_block", RhodiumBlock::new);
    public static final RegistryObject<Item> RHODIUM_BLOCK_ITEM = ITEMS.register("rhodium_block", () -> new BlockItemBase(RHODIUM_BLOCK.get()));





    public static final RegistryObject<Block> RHODIUM_ORE = BLOCKS.register("rhodium_ore", () -> new RhodiumOre(Block.Properties.from(Blocks.IRON_ORE)));
    public static final RegistryObject<Item> RHODIUM_ORE_ITEM = ITEMS.register("rhodium_ore", () -> new BlockItemBase(RHODIUM_ORE.get()));

}
