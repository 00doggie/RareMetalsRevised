package com.doggie.raremetalsrevised.materials;


import com.doggie.raremetalsrevised.RareMetalsRevised;
//import com.doggie.raremetalsrevised.armor.Ice_rystalArmormaterialPotion;
//import com.doggie.raremetalsrevised.tools.fire_crystalSwordPotion;
import com.doggie.raremetalsrevised.armor.FireCrystalArmorPotion;


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

/*import com.doggie.raremetalsrevised.tools.fire_crystalAxePotion;
import com.doggie.raremetalsrevised.tools.fire_crystalPickaxePotion;
import com.doggie.raremetalsrevised.tools.fire_crystalShovelPotion;

 */

@Mod.EventBusSubscriber(modid = RareMetalsRevised.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(RareMetalsRevised.MOD_ID)
public class IceCrystalMaterial {


    public static final Item ice_crystal = null;



    //tools

    public static final Item ice_crystal_sword = null;
    public static final Item ice_crystal_pickaxe = null;
    public static final Item ice_crystal_shovel = null;
    public static final Item ice_crystal_axe = null;


    //armor
    public static final Item ice_crystal_helmet = null;
    public static final Item ice_crystal_chestplate = null;
    public static final Item ice_crystal_leggings = null;
    public static final Item ice_crystal_boots = null;


    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {



        event.getRegistry().register(new SwordItem(IceCrystalMaterial.Ice_CrystalItemTier.ICE_CRYSTALTOOLS, 1, -2.4f, new Item.Properties().group(RareMetalsRevised.TAB))
                .setRegistryName("ice_crystal_sword"));


        event.getRegistry().register(
                new PickaxeItem(IceCrystalMaterial.Ice_CrystalItemTier.ICE_CRYSTALTOOLS, -2, -2.8f, new Item.Properties().group(RareMetalsRevised.TAB))
                        .setRegistryName("ice_crystal_pickaxe"));
        event.getRegistry().register(
                new ShovelItem(IceCrystalMaterial.Ice_CrystalItemTier.ICE_CRYSTALTOOLS, -2.5f, -3f, new Item.Properties().group(RareMetalsRevised.TAB))
                        .setRegistryName("ice_crystal_shovel"));
        event.getRegistry().register(
                new AxeItem(IceCrystalMaterial.Ice_CrystalItemTier.ICE_CRYSTALTOOLS, -1.5f, -3.1f, new Item.Properties().group(RareMetalsRevised.TAB))
                        .setRegistryName("ice_crystal_axe"));

        event.getRegistry().register(
                new HoeItem(IceCrystalMaterial.Ice_CrystalItemTier.ICE_CRYSTALTOOLS, -2.2f, new Item.Properties().group(RareMetalsRevised.TAB))
                        .setRegistryName("ice_crystal_hoe"));



        event.getRegistry().register(new FireCrystalArmorPotion(IceCrystalMaterial.Ice_CrystalItemTier.Ice_Crystal_Armormaterial.ICE_CRYSTALARMOR, EquipmentSlotType.HEAD,
                new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("ice_crystal_helmet"));
        event.getRegistry().register(new FireCrystalArmorPotion(IceCrystalMaterial.Ice_CrystalItemTier.Ice_Crystal_Armormaterial.ICE_CRYSTALARMOR, EquipmentSlotType.CHEST,
                new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("ice_rystal_chestplate"));
        event.getRegistry().register(new FireCrystalArmorPotion(IceCrystalMaterial.Ice_CrystalItemTier.Ice_Crystal_Armormaterial.ICE_CRYSTALARMOR, EquipmentSlotType.LEGS,
                new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("ice_crystal_leggings"));
        event.getRegistry().register(new FireCrystalArmorPotion(IceCrystalMaterial.Ice_CrystalItemTier.Ice_Crystal_Armormaterial.ICE_CRYSTALARMOR, EquipmentSlotType.FEET,
                new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("ice_crystal_boots"));


    }




    public enum Ice_CrystalItemTier implements IItemTier {
        ICE_CRYSTALTOOLS(3, 1666, 7F, 4.00F, 20, () -> {
            return Ingredient.fromItems(IceCrystalMaterial.ice_crystal);
        });



        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        Ice_CrystalItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
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


        public enum Ice_Crystal_Armormaterial implements IArmorMaterial {
            ICE_CRYSTALARMOR(RareMetalsRevised.MOD_ID + ":ice_crystal", 16, new int[]{3, 6, 8, 2}, 23, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F, () -> {
                return Ingredient.fromItems(IceCrystalMaterial.ice_crystal);


            });

            private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
            private final String name;
            private final int maxDamageFactor;
            private final int[] damageReductionAmountArray;
            private final int enchantability;
            private final SoundEvent soundEvent;
            private final float toughness;
            private final LazyValue<Ingredient> repairMaterial;

            private Ice_Crystal_Armormaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
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





