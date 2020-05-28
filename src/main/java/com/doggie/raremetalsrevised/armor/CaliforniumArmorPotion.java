
package com.doggie.raremetalsrevised.armor;

import com.doggie.raremetalsrevised.materials.CaliforniumMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class CaliforniumArmorPotion extends ArmorItem {
    public CaliforniumArmorPotion(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder);
    }


    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == CaliforniumMaterial.californium_helmet
                && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == CaliforniumMaterial.californium_chestplate
                && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == CaliforniumMaterial.californium_leggings
                && player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == CaliforniumMaterial.californium_boots


        ) {
            player.addPotionEffect(new EffectInstance(Effects.SPEED, 60, 1, false, false));
            {
            }

        }
    }
}




