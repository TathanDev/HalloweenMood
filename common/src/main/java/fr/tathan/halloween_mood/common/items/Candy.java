package fr.tathan.halloween_mood.common.items;

import net.minecraft.core.Holder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Candy extends Item {

    Holder<MobEffect> effect;
    int duration;
    int amplifier;


    public Candy(Properties properties, Holder<MobEffect> pEffect, int pDuration, int pAmplifier) {
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


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);

        return InteractionResultHolder.consume(itemstack);
    }

}

