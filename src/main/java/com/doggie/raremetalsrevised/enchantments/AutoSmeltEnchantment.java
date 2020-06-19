package com.doggie.raremetalsrevised.enchantments;


import java.util.Random;

import com.doggie.raremetalsrevised.RareMetalsRevised;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.common.Mod;




import net.minecraft.inventory.EquipmentSlotType;

public class AutoSmeltEnchantment extends Enchantment {
    public AutoSmeltEnchantment(Enchantment.Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.DIGGER, slots);
    }

    public AutoSmeltEnchantment(net.minecraft.item.Rarity rare, EnchantmentType digger, EquipmentSlotType[] equipmentSlotTypes) {
        super(Rarity.RARE, digger,equipmentSlotTypes);
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 15;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    @Override
    public int getMaxLevel() {
        return 1;
    }

    /**
     * Determines if the enchantment passed can be applyied together with this enchantment.
     */
    @Override
    public boolean canApplyTogether(Enchantment ench) {
        return super.canApplyTogether(ench) && ench != Enchantments.FORTUNE;
    }
}

