package com.doggie.raremetalsrevised.materials;

import com.doggie.raremetalsrevised.RareMetalsRevised;
//import com.doggie.raremetalsrevised.armor.CaliforniumArmorPotion;

import com.doggie.raremetalsrevised.armor.CaliforniumArmorPotion;
import com.doggie.raremetalsrevised.tools.CaliforniumAxePotion;
import com.doggie.raremetalsrevised.tools.CaliforniumPickaxePotion;
import com.doggie.raremetalsrevised.tools.CaliforniumShovelPotion;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = RareMetalsRevised.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(RareMetalsRevised.MOD_ID)
public class CaliforniumMaterial {
    public static final Item californium_ingot = null;
    public static final Item californium_sword = null;
    public static final Item californium_axe = null;
    public static final Item californium_shovel = null;
    public static final Item californium_pickaxe = null;
    public static final Item californium_helmet = null;
    public static final Item californium_chestplate = null;
    public static final Item californium_leggings = null;
    public static final Item californium_boots = null;
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new SwordItem(CaliforniumItemTier.CALIFORNIUMTOOLS, 3, -2.4F, new Item.Properties().group(RareMetalsRevised.TAB))
                .setRegistryName("californium_sword"));
        event.getRegistry().register(
                new CaliforniumPickaxePotion(CaliforniumItemTier.CALIFORNIUMTOOLS, 1, -2.8f, new Item.Properties().group(RareMetalsRevised.TAB))
                        .setRegistryName("californium_pickaxe"));
        event.getRegistry().register(
                new CaliforniumShovelPotion(CaliforniumItemTier.CALIFORNIUMTOOLS, 1.5f, -3f, new Item.Properties().group(RareMetalsRevised.TAB))
                        .setRegistryName("californium_shovel"));
        event.getRegistry().register(
                new CaliforniumAxePotion(CaliforniumItemTier.CALIFORNIUMTOOLS, 5.0f, -3.1f, new Item.Properties().group(RareMetalsRevised.TAB))
                        .setRegistryName("californium_axe"));

        event.getRegistry().register(
                new HoeItem(CaliforniumItemTier.CALIFORNIUMTOOLS, -2.2f, new Item.Properties().group(RareMetalsRevised.TAB))
                        .setRegistryName("californium_hoe"));

        event.getRegistry().register(new CaliforniumArmorPotion(CaliforniumItemTier.CaliforniumArmorMaterial.CALIFORNIUMARMOR, EquipmentSlotType.HEAD,
                new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("californium_helmet"));
        event.getRegistry().register(new CaliforniumArmorPotion(CaliforniumItemTier.CaliforniumArmorMaterial.CALIFORNIUMARMOR, EquipmentSlotType.CHEST,
                new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("californium_chestplate"));
        event.getRegistry().register(new CaliforniumArmorPotion(CaliforniumItemTier.CaliforniumArmorMaterial.CALIFORNIUMARMOR, EquipmentSlotType.LEGS,
                new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("californium_leggings"));
        event.getRegistry().register(new CaliforniumArmorPotion(CaliforniumItemTier.CaliforniumArmorMaterial.CALIFORNIUMARMOR, EquipmentSlotType.FEET,
                new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("californium_boots"));


    }

    public enum CaliforniumItemTier implements IItemTier {
        CALIFORNIUMTOOLS(4, 2099, 8.0F, 6F, 18, () -> {
            return Ingredient.fromItems(CaliforniumMaterial.californium_ingot);
        });

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        CaliforniumItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = new LazyValue<>(repairMaterial);
        }


        @Override
        public int getMaxUses() {
            return this.maxUses;
        }

        @Override
        public float getEfficiency() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }

        // Armor


        public enum CaliforniumArmorMaterial implements IArmorMaterial {
           CALIFORNIUMARMOR(RareMetalsRevised.MOD_ID + ":californium", 35, new int[]{5, 8, 10, 5}, 18, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F, () -> {
                return Ingredient.fromItems(CaliforniumMaterial.californium_ingot);


               


            });

            private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
            private final String name;
            private final int maxDamageFactor;
            private final int[] damageReductionAmountArray;
            private final int enchantability;
            private final SoundEvent soundEvent;
            private final float toughness;
            private final LazyValue<Ingredient> repairMaterial;

            private CaliforniumArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
                                     int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn,
                                     Supplier<Ingredient> repairMaterialIn) {
                this.name = nameIn;
                this.maxDamageFactor = maxDamageFactorIn;
                this.damageReductionAmountArray = damageReductionAmountIn;
                this.enchantability = enchantabilityIn;
                this.soundEvent = soundEventIn;
                this.toughness = toughnessIn;
                this.repairMaterial = new LazyValue<>(repairMaterialIn);
            }

            @Override
            public int getDurability(EquipmentSlotType slotIn) {
                return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
            }

            @Override
            public int getDamageReductionAmount(EquipmentSlotType slotIn) {
                return this.damageReductionAmountArray[slotIn.getIndex()];
            }

            @Override
            public int getEnchantability() {
                return this.enchantability;
            }

            @Override
            public SoundEvent getSoundEvent() {
                return this.soundEvent;
            }

            @Override
            public Ingredient getRepairMaterial() {
                return this.repairMaterial.getValue();
            }

            @OnlyIn(Dist.CLIENT)
            @Override
            public String getName() {
                return this.name;
            }

            @Override
            public float getToughness() {
                return this.toughness;
            }
        }
    }
}



