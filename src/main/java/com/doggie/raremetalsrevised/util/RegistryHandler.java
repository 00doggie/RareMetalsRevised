package com.doggie.raremetalsrevised.util;

import com.doggie.raremetalsrevised.RareMetalsRevised;

import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.item.Food;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import java.util.Properties;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = RareMetalsRevised.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(RareMetalsRevised.MOD_ID)
public class RegistryHandler {


    public static final Item rhodium_ingot = null;


    //tools

    public static final Item rhodium_sword = null;
    //armor
    public static final Item rhodium_helmet = null;
    public static final Item rhodium_chestplate = null;
    public static final Item rhodium_leggings = null;
    public static final Item rhodium_boots = null;





        public static void registerItems(final RegistryEvent.Register<Item> event){


            event.getRegistry().register(new SwordItem(ModItemTier.RHODIUM, 3, -0.8F, new Item.Properties().group(RareMetalsRevised.TAB))
                    .setRegistryName("rhodium_sword"));
            event.getRegistry().register(
                    new PickaxeItem(ModItemTier.RHODIUM, 1, -1.6f, new Item.Properties().group(RareMetalsRevised.TAB))
                            .setRegistryName("rhodium_pickaxe"));
            event.getRegistry().register(
                    new ShovelItem(ModItemTier.RHODIUM, 1.5f, -2f, new Item.Properties().group(RareMetalsRevised.TAB))
                            .setRegistryName("rhodium_shovel"));
            event.getRegistry().register(
                    new AxeItem(ModItemTier.RHODIUM, 6.0f, -2.2f, new Item.Properties().group(RareMetalsRevised.TAB))
                            .setRegistryName("rhodium_axe"));

            event.getRegistry().register(
                    new HoeItem(ModItemTier.RHODIUM, -1.0f, new Item.Properties().group(RareMetalsRevised.TAB))
                            .setRegistryName("rhodium_hoe"));


            event.getRegistry().register(new ArmorItem(ModItemTier.ModArmorMaterial.TEST, EquipmentSlotType.HEAD,
                    new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("rhodium_helmet"));
            event.getRegistry().register(new ArmorItem(ModItemTier.ModArmorMaterial.TEST, EquipmentSlotType.CHEST,
                    new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("rhodium_chestplate"));
            event.getRegistry().register(new ArmorItem(ModItemTier.ModArmorMaterial.TEST, EquipmentSlotType.LEGS,
                    new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("rhodium_leggings"));
            event.getRegistry().register(new ArmorItem(ModItemTier.ModArmorMaterial.TEST, EquipmentSlotType.FEET,
                    new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("rhodium_boots"));




    }

    public enum ModItemTier implements IItemTier {
        RHODIUM(3, 450, 6.0F, 2.50F, 15, () -> {
            return Ingredient.fromItems(RegistryHandler.rhodium_ingot);
        });
        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
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


        public enum ModArmorMaterial implements IArmorMaterial {
            TEST(RareMetalsRevised.MOD_ID + ":rhodium", 16, new int[]{2, 5, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, () -> {
                return Ingredient.fromItems(RegistryHandler.rhodium_ingot);
            });
            private static final int[] MAX_DAMAGE_ARRAY = new int[]{14, 15, 16, 12};
            private final String name;
            private final int maxDamageFactor;
            private final int[] damageReductionAmountArray;
            private final int enchantability;
            private final SoundEvent soundEvent;
            private final float toughness;
            private final LazyValue<Ingredient> repairMaterial;

            private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
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








