package com.doggie.raremetalsrevised.util;

import com.doggie.raremetalsrevised.RareMetalsRevised;

import com.doggie.raremetalsrevised.blocks.BlockItemBase;

import com.doggie.raremetalsrevised.blocks.RhodiumBlock;
import com.doggie.raremetalsrevised.blocks.RhodiumOre;
import com.doggie.raremetalsrevised.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.swing.*;
import java.util.function.Supplier;


public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, RareMetalsRevised.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, RareMetalsRevised.MOD_ID);

    public RegistryHandler() {
    }

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> RHODIUM_INGOT = ITEMS.register("rhodium_ingot", ItemBase::new);
    public static final RegistryObject<Item> RHODIUM_HELMET = ITEMS.register("rhodium_helmet", ItemBase::new);
    public static final RegistryObject<Item> RHODIUM_CHESTPLATE = ITEMS.register("rhodium_chestplate", ItemBase::new);
    public static final RegistryObject<Item> RHODIUM_LEGGINGS = ITEMS.register("rhodium_leggings", ItemBase::new);
    public static final RegistryObject<Item> RHODIUM_BOOTS = ITEMS.register("rhodium_boots", ItemBase::new);
    public static final Item rhodium_ingot = null;


    // Blocks
    public static final RegistryObject<Block> RHODIUM_BLOCK = BLOCKS.register("rhodium_block", RhodiumBlock::new);
    public static final RegistryObject<Block> RHODIUM_ORE = BLOCKS.register("rhodium_ore", () -> new RhodiumOre(Block.Properties.from(Blocks.IRON_ORE)));

    //Block Items
    public static final RegistryObject<Item> RHODIUM_BLOCK_ITEM = ITEMS.register("rhodium_block", () -> new BlockItemBase(RHODIUM_BLOCK.get()));
    public static final RegistryObject<Item> RHODIUM_ORE_ITEM = ITEMS.register("rhodium_ore", () -> new BlockItemBase(RHODIUM_ORE.get()));

    //tools
    public static final RegistryObject<Item> RHODIUM_SWORD = ITEMS.register("rhodium_sword", ItemBase::new);
    public static final RegistryObject<Item> RHODIUM_PICKAXE = ITEMS.register("rhodium_pickaxe", ItemBase::new);
    public static final RegistryObject<Item> RHODIUM_SHOVEL = ITEMS.register("rhodium_shovel", ItemBase::new);
    public static final RegistryObject<Item> RHODIUM_AXE = ITEMS.register("rhodium_axe", ItemBase::new);
    public static final RegistryObject<Item> RHODIUM_HOE = ITEMS.register("rhodium_hoe", ItemBase::new);
    public static final Item rhodium_sword = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new SwordItem(ModItemTier.EXAMPLE, 7, 5.0F, new Item.Properties().group(RareMetalsRevised.TAB))
                        .setRegistryName("rhodium_sword"));



    }

    public enum ModItemTier implements IItemTier {
        EXAMPLE(4, 1500, 15.0F, 7.0F, 240, () -> {
            return Ingredient.fromItems(RegistryHandler.rhodium_ingot);
        });
        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = new LazyValue<>(repairMaterial);
        }


        @Override
        public int getMaxUses() {
            return this.maxUses;
        }

        @Override
        public float getEfficiency() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }
    }
}






