package com.doggie.raremetalsrevised.armor;

import com.doggie.raremetalsrevised.materials.OsmiumMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class OsmiumArmorPotion extends ArmorItem {
    public OsmiumArmorPotion(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder);
    }


    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == OsmiumMaterial.osmium_helmet
                && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == OsmiumMaterial.osmium_chestplate
                && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == OsmiumMaterial.osmium_leggings
                && player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == OsmiumMaterial.osmium_boots


        ) {
            player.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, 60, 0, false, false));
            {
            }

            }
        }
    }



