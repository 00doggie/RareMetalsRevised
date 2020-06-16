package com.doggie.raremetalsrevised.materials;


import com.doggie.raremetalsrevised.RareMetalsRevised;
//import com.doggie.raremetalsrevised.armor.osmiumArmorPotion;
//import com.doggie.raremetalsrevised.tools.osmiumSwordPotion;
import com.doggie.raremetalsrevised.armor.OsmiumArmorPotion;
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

/*import com.doggie.raremetalsrevised.tools.osmiumAxePotion;
import com.doggie.raremetalsrevised.tools.osmiumPickaxePotion;
import com.doggie.raremetalsrevised.tools.osmiumShovelPotion;

 */

@Mod.EventBusSubscriber(modid = RareMetalsRevised.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(RareMetalsRevised.MOD_ID)
public class OsmiumMaterial {


    public static final Item osmium_ingot = null;



    //tools

    public static final Item osmium_sword = null;
    public static final Item osmium_pickaxe = null;
    public static final Item osmium_shovel = null;
    public static final Item osmium_axe = null;


    //armor
    public static final Item osmium_helmet = null;
    public static final Item osmium_chestplate = null;
    public static final Item osmium_leggings = null;
    public static final Item osmium_boots = null;


    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {



        event.getRegistry().register(new SwordItem(OsmiumMaterial.OsmiumItemTier.OSMIUMTOOLS, 1, -2.4f, new Item.Properties().group(RareMetalsRevised.TAB))
                .setRegistryName("osmium_sword"));


        event.getRegistry().register(
                new PickaxeItem(OsmiumMaterial.OsmiumItemTier.OSMIUMTOOLS, -2, -2.8f, new Item.Properties().group(RareMetalsRevised.TAB))
                        .setRegistryName("osmium_pickaxe"));
        event.getRegistry().register(
                new ShovelItem(OsmiumMaterial.OsmiumItemTier.OSMIUMTOOLS, -2.5f, -3f, new Item.Properties().group(RareMetalsRevised.TAB))
                        .setRegistryName("osmium_shovel"));
        event.getRegistry().register(
                new AxeItem(OsmiumMaterial.OsmiumItemTier.OSMIUMTOOLS, -1.5f, -3.1f, new Item.Properties().group(RareMetalsRevised.TAB))
                        .setRegistryName("osmium_axe"));

        event.getRegistry().register(
                new HoeItem(OsmiumMaterial.OsmiumItemTier.OSMIUMTOOLS, -2.2f, new Item.Properties().group(RareMetalsRevised.TAB))
                        .setRegistryName("osmium_hoe"));


        event.getRegistry().register(new OsmiumArmorPotion(OsmiumMaterial.OsmiumItemTier.OsmiumArmormaterial.OSMIUMARMOR, EquipmentSlotType.HEAD,
                new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("osmium_helmet"));
        event.getRegistry().register(new OsmiumArmorPotion(OsmiumMaterial.OsmiumItemTier.OsmiumArmormaterial.OSMIUMARMOR, EquipmentSlotType.CHEST,
                new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("osmium_chestplate"));
        event.getRegistry().register(new OsmiumArmorPotion(OsmiumMaterial.OsmiumItemTier.OsmiumArmormaterial.OSMIUMARMOR, EquipmentSlotType.LEGS,
                new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("osmium_leggings"));
        event.getRegistry().register(new OsmiumArmorPotion(OsmiumMaterial.OsmiumItemTier.OsmiumArmormaterial.OSMIUMARMOR, EquipmentSlotType.FEET,
                new Item.Properties().group(RareMetalsRevised.TAB)).setRegistryName("osmium_boots"));


    }




    public enum OsmiumItemTier implements IItemTier {
        OSMIUMTOOLS(2, 100, 11F, 2.00F, 20, () -> {
            return Ingredient.fromItems(OsmiumMaterial.osmium_ingot);
        });



        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        OsmiumItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
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


        public enum OsmiumArmormaterial implements IArmorMaterial {
            OSMIUMARMOR(RareMetalsRevised.MOD_ID + ":osmium", 16, new int[]{2, 3, 5, 1}, 23, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> {
                return Ingredient.fromItems(OsmiumMaterial.osmium_ingot);


            });

            private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
            private final String name;
            private final int maxDamageFactor;
            private final int[] damageReductionAmountArray;
            private final int enchantability;
            private final SoundEvent soundEvent;
            private final float toughness;
            private final LazyValue<Ingredient> repairMaterial;

            private OsmiumArmormaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
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




