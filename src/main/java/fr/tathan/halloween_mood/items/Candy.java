package fr.tathan.halloween_mood.items;

import fr.tathan.halloween_mood.api.OnPlayerEatCandy;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;

public class Candy extends Item {

    MobEffect effect;
    int duration;
    int amplifier;


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


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);

        MinecraftForge.EVENT_BUS.post(new OnPlayerEatCandy(pPlayer, pLevel, effect, itemstack));

        return InteractionResultHolder.consume(itemstack);
    }

}

