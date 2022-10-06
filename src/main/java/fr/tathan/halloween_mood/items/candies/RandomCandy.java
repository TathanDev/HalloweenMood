package fr.tathan.halloween_mood.items.candies;

import fr.tathan.halloween_mood.registries.ItemsRegistry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class RandomCandy extends Item {

    public RandomCandy(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {

        if (pEntityLiving instanceof Player player) {

            Random rand = new Random();
            int random_candy = rand.nextInt(4);
            ItemStack surprise_candy = null;


            if(random_candy == 0) {

                surprise_candy = new ItemStack(ItemsRegistry.HEALTH_CANDY.get());
            }  else if (random_candy == 1){

                surprise_candy = new ItemStack(ItemsRegistry.SPEED_CANDY.get());

            }    else if (random_candy == 2){

                surprise_candy = new ItemStack(ItemsRegistry.FIRE_RESISTANCE_CANDY.get());

            }



            player.addItem(surprise_candy);

        }



        return super.finishUsingItem(pStack, pLevel, pEntityLiving);

    }
}

