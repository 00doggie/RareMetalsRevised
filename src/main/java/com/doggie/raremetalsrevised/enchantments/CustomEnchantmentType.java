package com.doggie.raremetalsrevised.enchantments;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShootableItem;

import java.util.function.Predicate;

public class CustomEnchantmentType {
    public static final EnchantmentType PICKAXE = addEnchantment("pickaxe", PickaxeItem.class::isInstance);

    public static final EnchantmentType AXE = addEnchantment("axe", AxeItem.class::isInstance);

    public static final EnchantmentType WEAPON_DIGGER;

    static {
        WEAPON_DIGGER = addEnchantment("weapon_digger", item -> (item instanceof net.minecraft.item.SwordItem || item instanceof net.minecraft.item.ToolItem));
    }

    public static final EnchantmentType SHOOTABLE = addEnchantment("shootable", ShootableItem.class::isInstance);

    private static EnchantmentType addEnchantment(String name, Predicate<Item> condition) {
        return EnchantmentType.create(name, condition);
    }
}

