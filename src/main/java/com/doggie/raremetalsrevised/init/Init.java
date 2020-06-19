package com.doggie.raremetalsrevised.init;

import com.doggie.raremetalsrevised.RareMetalsRevised;


import com.doggie.raremetalsrevised.blocks.*;

import com.doggie.raremetalsrevised.enchantments.CustomEnchantmentType;

import com.doggie.raremetalsrevised.items.ItemBase;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Init {

        public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,
                RareMetalsRevised.MOD_ID);
        //Items
        public static final RegistryObject<Item> RHODIUM_INGOT = ITEMS.register("rhodium_ingot", ItemBase::new);
        public static final RegistryObject<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot", ItemBase::new);
        public static final RegistryObject<Item> CALIFORNIUM_INGOT = ITEMS.register("californium_ingot", ItemBase::new);
        public static final RegistryObject<Item> FIRE_CRYSTAL = ITEMS.register("fire_crystal", ItemBase::new);
        public static final RegistryObject<Item> ICE_CRYSTAL = ITEMS.register("ice_crystal", ItemBase::new);

        public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, RareMetalsRevised.MOD_ID);
        //Blocks


        public static final RegistryObject<Block> RHODIUM_BLOCK = BLOCKS.register("rhodium_block", RhodiumBlock::new);
        public static final RegistryObject<Block> OSMIUM_BLOCK = BLOCKS.register("osmium_block", OsmiumBlock::new);
        public static final RegistryObject<Block> RHODIUM_ORE = BLOCKS.register("rhodium_ore", () -> new RhodiumOre(Block.Properties.from(Blocks.IRON_ORE)));
        public static final RegistryObject<Block> OSMIUM_ORE = BLOCKS.register("osmium_ore", () -> new OsmiumOre(Block.Properties.from(Blocks.IRON_ORE)));

        public static final RegistryObject<Block> CALIFORNIUM_ORE = BLOCKS.register("californium_ore", () -> new CaliforniumOre(Block.Properties.from(Blocks.DIAMOND_ORE)));
        public static final RegistryObject<Block> CALIFORNIUM_BLOCK = BLOCKS.register("californium_block", CaliforniumBlock::new);
        public static final RegistryObject<Block> FIRE_CRYSTAL_BLOCK = BLOCKS.register("fire_crystal_block", FireCrystalBlock::new);
        public static final RegistryObject<Block> FIRE_STONE = BLOCKS.register("fire_stone", () -> new FireStone(Block.Properties.from(Blocks.IRON_ORE)));
        public static final RegistryObject<Block> ICE_STONE = BLOCKS.register("ice_stone", () -> new IceStone(Block.Properties.from(Blocks.IRON_ORE)));
        public static final RegistryObject<Block> ICE_CRYSTAL_BLOCK = BLOCKS.register("ice_crystal_block", IceCrystalBlock::new);
        //BlockItems
        public static final RegistryObject<Item> RHODIUM_BLOCK_ITEM = ITEMS.register("rhodium_block", () -> new BlockItemBase(RHODIUM_BLOCK.get()));
        public static final RegistryObject<Item> RHODIUM_ORE_ITEM = ITEMS.register("rhodium_ore", () -> new BlockItemBase(RHODIUM_ORE.get()));
        public static final RegistryObject<Item> FIRE_STONE_ITEM = ITEMS.register("fire_stone", () -> new BlockItemBase(FIRE_STONE.get()));
        public static final RegistryObject<Item> OSMIUM_ORE_ITEM = ITEMS.register("osmium_ore", () -> new BlockItemBase(OSMIUM_ORE.get()));
        public static final RegistryObject<Item> OSMIUM_BLOCK_ITEM = ITEMS.register("osmium_block", () -> new BlockItemBase(OSMIUM_BLOCK.get()));
        public static final RegistryObject<Item> CALIFORNIUM_ORE_ITEM = ITEMS.register("californium_ore", () -> new BlockItemBase(CALIFORNIUM_ORE.get()));
        public static final RegistryObject<Item> CALIFORNIUM_BLOCK_ITEM = ITEMS.register("californium_block", () -> new BlockItemBase(CALIFORNIUM_BLOCK.get()));
        public static final RegistryObject<Item> FIRE_CRYSTAL_BLOCK_ITEM = ITEMS.register("fire_crystal_block", () -> new BlockItemBase(FIRE_CRYSTAL_BLOCK.get()));
        public static final RegistryObject<Item> ICE_CRYSTAL_BLOCK_ITEM = ITEMS.register("ice_crystal_block", () -> new BlockItemBase(ICE_CRYSTAL_BLOCK.get()));
        public static final RegistryObject<Item> ICE_STONE_ITEM = ITEMS.register("ice_stone", () -> new BlockItemBase(ICE_STONE.get()));

        }
