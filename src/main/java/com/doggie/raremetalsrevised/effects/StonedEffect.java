package com.doggie.raremetalsrevised.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;

import javax.xml.stream.Location;

public class StonedEffect extends StatusEffect {
    public static final Effect STONED = new StonedEffect();

    public StonedEffect() {
        super("stoned", EffectType.BENEFICIAL, 12858015);
    }



    public boolean func_76397_a(int duration, int amplifier) {
        return true;
    }

    public static void RegisterEffects(RegistryEvent.Register<Effect> event) {
        event.getRegistry().registerAll(
                new StonedEffect().setRegistryName("stoned"));

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

