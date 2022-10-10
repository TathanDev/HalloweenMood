package fr.tathan.halloween_mood.items;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Candy extends Item {

    MobEffect effect;
    int duration;
    int amplifier;

    //Maybe add some @Nullable to the parameters
    public Candy(Item.Properties properties, MobEffect pEffect, int pDuration, int pAmplifier) {
        super(properties);
        this.effect = pEffect;
        this.duration = pDuration;
        this.amplifier = pAmplifier;

    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        pEntityLiving.addEffect(new MobEffectInstance(effect, duration, amplifier));


        return super.finishUsingItem(pStack, pLevel, pEntityLiving);

    }




}

