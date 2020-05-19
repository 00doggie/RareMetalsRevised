package com.doggie.raremetalsrevised.util;

import com.doggie.raremetalsrevised.RareMetalsRevised;

import com.doggie.raremetalsrevised.blocks.BlockItemBase;

import com.doggie.raremetalsrevised.blocks.RhodiumBlock;
import com.doggie.raremetalsrevised.blocks.RhodiumOre;
import com.doggie.raremetalsrevised.items.ItemBase;
import com.doggie.raremetalsrevised.items.armor.ItemCustomArmorRhodium;
import com.doggie.raremetalsrevised.lists.ArmorMaterialList;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

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
    public static final RegistryObject<Item> RHODIUM_ARMOR_REPAIR = ITEMS.register("rhodium_armor_repair", ItemBase::new);

    // Blocks
    public static final RegistryObject<Block> RHODIUM_BLOCK = BLOCKS.register("rhodium_block", RhodiumBlock::new);
    public static final RegistryObject<Block> RHODIUM_ORE = BLOCKS.register("rhodium_ore", ()-> new RhodiumOre(Block.Properties.from(Blocks.IRON_ORE)));

     //Block Items
    public static final RegistryObject<Item> RHODIUM_BLOCK_ITEM = ITEMS.register("rhodium_block", () -> new BlockItemBase(RHODIUM_BLOCK.get()));
    public static final RegistryObject<Item> RHODIUM_ORE_ITEM = ITEMS.register("rhodium_ore", () -> new BlockItemBase(RHODIUM_ORE.get()));
    //armor
    final Item rhodium_ingot;
    RHODIUM_ARMOR_REPAIR = RegistryHandler.ITEMS.register("rhodium_armor_repair", () -> {
        new Item(new Item.Properties().func_200916_a(RareMetalsRevised.MOD_ID));
        return rhodium_ingot;
    });

        final ItemCustomArmorRhodium itemCustomArmorRhodium;
       RHODIUM_HELMET = RegistryHandler.ITEMS.register("rhodium_helmet", () -> {
            new ItemCustomArmorRhodium((IArmorMaterial) ArmorMaterialList.RHODIUM_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().func_200916_a(RareMetalsRevised.MOD_ID));
            return itemCustomArmorRhodium;


        }
    }





