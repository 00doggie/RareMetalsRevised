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

public class StatusEffect extends Effect {
    public StatusEffect(String name, EffectType type, int liquidColorIn) {
        super(type, liquidColorIn);
        setRegistryName("rmr", name);
    }



    public boolean hasEffect(LivingEntity entity) {
        return hasEffect(entity, this);
    }

    public boolean hasEffect(LivingEntity entity, Effect effect) {
        return (entity.getActivePotionEffect(effect) != null);
    }
}

