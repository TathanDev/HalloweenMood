package fr.tathan.halloween_mood.items;

import fr.tathan.halloween_mood.registries.ItemsRegistry;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
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
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {


            Random rand = new Random();
            int random_candy = rand.nextInt(3);
            ItemStack surprise_candy = null;


            if(random_candy == 0) {

                surprise_candy = new ItemStack(ItemsRegistry.HEALTH_CANDY.get());
            }  else if (random_candy == 1){

                surprise_candy = new ItemStack(ItemsRegistry.SPEED_CANDY.get());

            }    else if (random_candy == 2){

                surprise_candy = new ItemStack(ItemsRegistry.FIRE_RESISTANCE_CANDY.get());

            }



            playerIn.addItem(surprise_candy);


        return new InteractionResultHolder<>(InteractionResult.SUCCESS, playerIn.getItemInHand(handIn));

    }
}

