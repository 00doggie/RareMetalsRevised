package com.doggie.raremetalsrevised.lists;

import com.doggie.raremetalsrevised.util.RegistryHandler;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmorMaterialList implements IArmorMaterial
{
   RHODIUM_ARMOR("rhodium_armor", 71, new int[] { 6, 9, 11, 6 }, 25, (Item) RegistryHandler.RHODIUM_INGOT.get(), "item.armor.equip", 2.5f),
    ;


    private static final int[] max_damage_array;
    private String name;
    private String equipSound;
    private int durability;
    private int enchantability;
    private Item repairItem;
    private int[] damageReductionAmounts;
    private float toughness;

    private ArmorMaterialList(final String name, final int durability, final int[] damageReductionAmounts, final int enchantability, final Item repairItem, final String equipSound, final float toughness) {
        this.name = name;
        this.equipSound = equipSound;
        this.durability = durability;
        this.enchantability = enchantability;
        this.repairItem = repairItem;
        this.damageReductionAmounts = damageReductionAmounts;
        this.toughness = toughness;
    }

    public int func_200902_b(final EquipmentSlotType slot) {
        return this.damageReductionAmounts[slot.func_188454_b()];
    }

    public int func_200896_a(final EquipmentSlotType slot) {
        return ArmorMaterialList.max_damage_array[slot.func_188454_b()] * this.durability;
    }

    public int func_200900_a() {
        return this.enchantability;
    }

    public String func_200897_d() {
        return "rmr:" + this.name;
    }

    public Ingredient func_200898_c() {
        return Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)this.repairItem });
    }

    public SoundEvent func_200899_b() {
        return new SoundEvent(new ResourceLocation(this.equipSound));
    }

    public float func_200901_e() {
        return this.toughness;
    }

    static {
        max_damage_array = new int[] { 13, 15, 16, 11 };
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return 0;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return null;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public float getToughness() {
        return 0;
    }
}
