package com.doggie.raremetalsrevised.items.armor;

import com.doggie.raremetalsrevised.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCustomArmorRhodium extends ArmorItem {
    public ItemCustomArmorRhodium(final IArmorMaterial materialIn, final EquipmentSlotType slots, final Item.Properties builder) {
        super(materialIn, slots, builder);
    }

    public void onArmorTick(final ItemStack stack, final World world, final PlayerEntity player) {
        final ItemStack head = player.func_184582_a(EquipmentSlotType.HEAD);
        final ItemStack chest = player.func_184582_a(EquipmentSlotType.CHEST);
        final ItemStack legs = player.func_184582_a(EquipmentSlotType.LEGS);
        final ItemStack feet = player.func_184582_a(EquipmentSlotType.FEET);
        if (head.func_77973_b() == RegistryHandler.RHODIUM_HELMET.get() && chest.func_77973_b() == RegistryHandler.RHODIUM_CHESTPLATE.get() && legs.func_77973_b() == RegistryHandler.RHODIUM_LEGGINGS.get() && feet.func_77973_b() == RegistryHandler.RHODIUM_BOOTS.get()) {


        }


        public boolean isBookEnchantable ( final ItemStack stack, final ItemStack book){
            return true;
        }
    }

        public boolean func_82789_a ( final ItemStack toRepair, final ItemStack repair){
            return repair.func_77973_b() == RegistryHandler.RHODIUM_ARMOR_REPAIR.get();
        }
    }
}
