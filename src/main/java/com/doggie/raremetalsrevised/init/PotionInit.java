package com.doggie.raremetalsrevised.init;

import com.doggie.raremetalsrevised.RareMetalsRevised;
import com.doggie.raremetalsrevised.effects.StatusEffect;
import com.doggie.raremetalsrevised.effects.StonedEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.potion.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PotionInit {

    public static final DeferredRegister<Effect> POTIONS = new DeferredRegister<>(ForgeRegistries.POTIONS,
            RareMetalsRevised.MOD_ID);

    public static final DeferredRegister<Potion> POTION_EFFECTS = new DeferredRegister<>(ForgeRegistries.POTION_TYPES,
            RareMetalsRevised.MOD_ID);
    public class StonedEffect extends StatusEffect {
        public final Effect STONED = new com.doggie.raremetalsrevised.effects.StonedEffect();

        public StonedEffect() {
            super("stoned", EffectType.BENEFICIAL, 12858015);
        }



        public boolean func_76397_a(int duration, int amplifier) {
            return true;
        }

        public void RegisterEffects(RegistryEvent.Register<Effect> event) {
            event.getRegistry().registerAll(
                    new com.doggie.raremetalsrevised.effects.StonedEffect().setRegistryName("stoned"));

        }

        public void func_76394_a(LivingEntity entityLivingBaseIn, int amplifier) {
            entityLivingBaseIn.addPotionEffect(new EffectInstance(Effects.NAUSEA,60,0, false, false));
            if (entityLivingBaseIn instanceof MobEntity && entityLivingBaseIn.getRNG().nextInt(100) <= amplifier) {
                ((MobEntity)entityLivingBaseIn).setAttackTarget(null);
                ((MobEntity)entityLivingBaseIn).setAggroed(false);
            }
            if (entityLivingBaseIn.world.isRemote);
        }

        @OnlyIn(Dist.CLIENT)
        private void handleDistortion() {}
    }

}
