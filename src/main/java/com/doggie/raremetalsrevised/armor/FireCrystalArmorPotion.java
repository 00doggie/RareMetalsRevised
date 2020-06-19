package com.doggie.raremetalsrevised.armor;

import com.doggie.raremetalsrevised.effects.StonedEffect;
import com.doggie.raremetalsrevised.materials.FireCrystalMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class FireCrystalArmorPotion extends ArmorItem {
    public FireCrystalArmorPotion(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder);
    }


    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == FireCrystalMaterial.fire_crystal_helmet
                && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == FireCrystalMaterial.fire_crystal_chestplate
                && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == FireCrystalMaterial.fire_crystal_leggings
                && player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == FireCrystalMaterial.fire_crystal_boots


        ) {
            player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 60, 0, false, false));
            {
            }

        }
    }
}




