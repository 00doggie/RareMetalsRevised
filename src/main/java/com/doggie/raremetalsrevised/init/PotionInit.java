package com.doggie.raremetalsrevised.init;

import com.doggie.raremetalsrevised.RareMetalsRevised;
import com.doggie.raremetalsrevised.effects.ExampleEffect;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PotionInit {

    public static final DeferredRegister<Effect> POTIONS = new DeferredRegister<>(ForgeRegistries.POTIONS,
            RareMetalsRevised.MOD_ID);

    public static final DeferredRegister<Potion> POTION_EFFECTS = new DeferredRegister<>(ForgeRegistries.POTION_TYPES,
            RareMetalsRevised.MOD_ID);

    public static final RegistryObject<Effect> EXAMPLE_EFFECT = POTIONS.register("example_effect",
            () -> new ExampleEffect(EffectType.BENEFICIAL, 37848743).addAttributesModifier(
                    SharedMonsterAttributes.ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", 1.0D,
                    AttributeModifier.Operation.ADDITION));

    public static final RegistryObject<Potion> EXAMPLE_POTION = POTION_EFFECTS.register("example_effect",
            () -> new Potion(new EffectInstance(EXAMPLE_EFFECT.get())));
}
