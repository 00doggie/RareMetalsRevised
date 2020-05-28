package com.doggie.raremetalsrevised.tools;

import com.doggie.raremetalsrevised.materials.RhodiumMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class RhodiumSwordPotion extends SwordItem {


    public RhodiumSwordPotion(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    public class Boi extends ArmorItem {

        public Boi(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
            super(materialIn, slot, builder);
        }
    }

    @Override
    public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
    }

    public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {


        if (!(entity instanceof LivingEntity)) return;
        LivingEntity livingEntity = (LivingEntity) entity;


        if (livingEntity.getHeldItemMainhand().getItem()  == RhodiumMaterial.rhodium_sword




                && (livingEntity.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == RhodiumMaterial.rhodium_helmet
                && livingEntity.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == RhodiumMaterial.rhodium_chestplate
                && livingEntity.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == RhodiumMaterial.rhodium_leggings
                && livingEntity.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == RhodiumMaterial.rhodium_boots))


            ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, 60, 0, false, false));


    }
}
