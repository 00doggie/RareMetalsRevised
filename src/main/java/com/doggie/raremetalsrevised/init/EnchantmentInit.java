package com.doggie.raremetalsrevised.init;

import com.doggie.raremetalsrevised.RareMetalsRevised;

import com.doggie.raremetalsrevised.enchantments.AutoSmeltEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EnchantmentInit {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = new DeferredRegister<>(
            ForgeRegistries.ENCHANTMENTS, RareMetalsRevised.MOD_ID);

    public static final RegistryObject<Enchantment> AUTO_SMELT = ENCHANTMENTS.register("auto_smelt",
            () -> new AutoSmeltEnchantment(Rarity.RARE, EnchantmentType.DIGGER,
                    new EquipmentSlotType[] { EquipmentSlotType.MAINHAND }));
}