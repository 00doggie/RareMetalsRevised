package com.doggie.raremetalsrevised.armor;

import com.doggie.raremetalsrevised.materials.RhodiumMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class RhodiumArmorPotion extends ArmorItem {
    public RhodiumArmorPotion(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder);
    }


    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == RhodiumMaterial.rhodium_helmet
                && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == RhodiumMaterial.rhodium_chestplate
                && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == RhodiumMaterial.rhodium_leggings
                && player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == RhodiumMaterial.rhodium_boots


        ) {
            player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 60, 0, false, false));
            {
            }

            }
        }
    }



