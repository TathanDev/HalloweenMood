package fr.tathan.halloween_mood.items.candies;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SpeedCandy extends Item {

    public SpeedCandy(Item.Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        pEntityLiving.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 450, 0));


        return super.finishUsingItem(pStack, pLevel, pEntityLiving);

    }
}

