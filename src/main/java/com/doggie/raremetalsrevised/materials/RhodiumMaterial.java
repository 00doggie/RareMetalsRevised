package com.doggie.raremetalsrevised.materials;



import com.doggie.raremetalsrevised.RareMetalsRevised;
import com.doggie.raremetalsrevised.armor.RhodiumArmorPotion;

/*import com.doggie.raremetalsrevised.tools.RhodiumAxePotion;
import com.doggie.raremetalsrevised.tools.RhodiumPickaxePotion;
import com.doggie.raremetalsrevised.tools.RhodiumShovelPotion;

 */
import com.doggie.raremetalsrevised.tools.RhodiumSwordPotion;
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
public class RhodiumMaterial {


    public static final Item rhodium_ingot = null;



    //tools

    public static final Item rhodium_sword = null;
    public static final Item rhodium_pickaxe = null;
    public static final Item rhodium_shovel = null;
    public static final Item rhodium_axe = null;


    //armor
    public static final Item rhodium_helmet = null;
    public static final Item rhodium_chestplate = null;
    public static final Item rhodium_leggings = null;
    public static final Item rhodium_boots = null;


    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {



        event.getRegistry().register(new RhodiumSwordPotion(com.doggie.raremetalsrevised.materials.RhodiumMaterial.RhodiumItemTier.RHODIUMTOOLS, 3, -2.4f, new Item.Properties().group(RareMetalsRevised.TAB))
                .setRegistryName("rhodium_sword"));


        event.getRegistry().register(
                new PickaxeItem(com.doggie.raremetalsrevised.materials.RhodiumMaterial.RhodiumItemTier.RHODIUMTOOLS, 1, -2.8f, new Item.Properties().group(RareMetalsRevised.TAB))
                        .setRegistryName("rhodium_pickaxe"));
        event.getRegistry().register(
                new ShovelItem(com.doggie.raremetalsrevised.materials.RhodiumMaterial.RhodiumItemTier.RHODIUMTOOLS, 1.5f, -3f, new Item.Properties().group(RareMetalsRevised.TAB))
                        .setRegistryName("rhodium_shovel"));
        event.getRegistry().register(
                new AxeItem(com.doggie.raremetalsrevised.materials.RhodiumMaterial.RhodiumItemTier.RHODIUMTOOLS, 5.0f, -3.1f, new Item.Properties().group(RareMetalsRevised.TAB))
                        .setRegistryName("rhodium_axe"));

        event.getRegistry().register(
                new HoeItem(com.doggie.raremetalsrevised.materials.RhodiumMaterial.RhodiumItemTier.RHODIUMTOOLS, -2.2f, new Item.Properties().group(RareMetalsRevised.TAB))
                        .setRegistryName("rhodium_hoe"));


        event.getRegistry().register(new RhodiumArmorPotion(com.doggie.raremetalsrevised.materials.RhodiumMaterial.RhodiumItemTier.RhodiumArmormaterial.RHODIUMARMOR, EquipmentSlotType.HEAD,
                new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("rhodium_helmet"));
        event.getRegistry().register(new RhodiumArmorPotion(com.doggie.raremetalsrevised.materials.RhodiumMaterial.RhodiumItemTier.RhodiumArmormaterial.RHODIUMARMOR, EquipmentSlotType.CHEST,
                new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("rhodium_chestplate"));
        event.getRegistry().register(new RhodiumArmorPotion(com.doggie.raremetalsrevised.materials.RhodiumMaterial.RhodiumItemTier.RhodiumArmormaterial.RHODIUMARMOR, EquipmentSlotType.LEGS,
                new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("rhodium_leggings"));
        event.getRegistry().register(new RhodiumArmorPotion(com.doggie.raremetalsrevised.materials.RhodiumMaterial.RhodiumItemTier.RhodiumArmormaterial.RHODIUMARMOR, EquipmentSlotType.FEET,
                new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("rhodium_boots"));


    }




    public enum RhodiumItemTier implements IItemTier {
        RHODIUMTOOLS(2, 450, 6.0F, 2.00F, 12, () -> {
            return Ingredient.fromItems(com.doggie.raremetalsrevised.materials.RhodiumMaterial.rhodium_ingot);
        });



        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        RhodiumItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
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


        public enum RhodiumArmormaterial implements IArmorMaterial {
            RHODIUMARMOR(RareMetalsRevised.MOD_ID + ":rhodium", 16, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, () -> {
                return Ingredient.fromItems(com.doggie.raremetalsrevised.materials.RhodiumMaterial.rhodium_ingot);


            });

            private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
            private final String name;
            private final int maxDamageFactor;
            private final int[] damageReductionAmountArray;
            private final int enchantability;
            private final SoundEvent soundEvent;
            private final float toughness;
            private final LazyValue<Ingredient> repairMaterial;

            private RhodiumArmormaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
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




