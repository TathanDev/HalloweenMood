package fr.tathan.halloween_mood.items;

import fr.tathan.halloween_mood.registries.ItemsRegistry;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class CandyBasket extends Item {

    public CandyBasket(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {

        ItemStack itemstack = playerIn.getItemInHand(handIn);
        itemstack.shrink(1);

        giveMeRandomCandy(3, playerIn);


        return new InteractionResultHolder<>(InteractionResult.SUCCESS, playerIn.getItemInHand(handIn));

    }

    public void giveMeRandomCandy(int numberOfTime, Player playerIn) {

        for (int i = 0; i <= numberOfTime; i++) {
            Random rand = new Random();
            int random_candy = rand.nextInt(4);
            ItemStack surprise_candy;

            if (random_candy == 0) {
                surprise_candy = new ItemStack(ItemsRegistry.HEALTH_CANDY.get());
            } else if (random_candy == 1) {
                surprise_candy = new ItemStack(ItemsRegistry.SPEED_CANDY.get());
            } else if (random_candy == 2) {
                surprise_candy = new ItemStack(ItemsRegistry.FIRE_RESISTANCE_CANDY.get());
            } else {
                surprise_candy = new ItemStack(ItemsRegistry.WATER_BREATHING_CANDY.get());
            }

            playerIn.addItem(surprise_candy);
        }

    }
}

