package com.doggie.raremetalsrevised.init;

import com.doggie.raremetalsrevised.RareMetalsRevised;
import com.doggie.raremetalsrevised.blocks.*;

import com.doggie.raremetalsrevised.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Init {

        public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,
                RareMetalsRevised.MOD_ID);
        //Items
        public static final RegistryObject<Item> RHODIUM_INGOT = ITEMS.register("rhodium_ingot", ItemBase::new);
        public static final RegistryObject<Item> CALIFORNIUM_INGOT = ITEMS.register("californium_ingot", ItemBase::new);

        public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, RareMetalsRevised.MOD_ID);
        //Blocks


        public static final RegistryObject<Block> RHODIUM_BLOCK = BLOCKS.register("rhodium_block", RhodiumBlock::new);
        public static final RegistryObject<Block> RHODIUM_ORE = BLOCKS.register("rhodium_ore", () -> new RhodiumOre(Block.Properties.from(Blocks.IRON_ORE)));
        public static final RegistryObject<Block> OSMIUM_ORE = BLOCKS.register("osmium_ore", () -> new OsmiumOre(Block.Properties.from(Blocks.IRON_ORE)));
        public static final RegistryObject<Block> CALIFORNIUM_ORE = BLOCKS.register("californium_ore", () -> new CaliforniumOre(Block.Properties.from(Blocks.DIAMOND_ORE)));
        public static final RegistryObject<Block> CALIFORNIUM_BLOCK = BLOCKS.register("californium_block", CaliforniumBlock::new);


        //BlockItems
        public static final RegistryObject<Item> RHODIUM_BLOCK_ITEM = ITEMS.register("rhodium_block", () -> new BlockItemBase(RHODIUM_BLOCK.get()));
        public static final RegistryObject<Item> RHODIUM_ORE_ITEM = ITEMS.register("rhodium_ore", () -> new BlockItemBase(RHODIUM_ORE.get()));
        public static final RegistryObject<Item> OSMIUM_ORE_ITEM = ITEMS.register("osmium_ore", () -> new BlockItemBase(OSMIUM_ORE.get()));
        public static final RegistryObject<Item> CALIFORNIUM_ORE_ITEM = ITEMS.register("californium_ore", () -> new BlockItemBase(CALIFORNIUM_ORE.get()));
        public static final RegistryObject<Item> CALIFORNIUM_BLOCK_ITEM = ITEMS.register("californium_block", () -> new BlockItemBase(CALIFORNIUM_BLOCK.get()));


}
