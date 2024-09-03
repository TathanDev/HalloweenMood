package fr.tathan.halloween_mood.common.registries;

import fr.tathan.halloween_mood.common.items.Candy;
import fr.tathan.halloween_mood.common.items.CandyBasket;
import fr.tathan.halloween_mood.platform.Services;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class SoundsRegistry {

    public static final Supplier<Item> SPEED_CANDY = registerItem("speed_candy",
            () -> new Candy(new Item.Properties().stacksTo(32).food(new FoodProperties.Builder().fast().nutrition(2).build()), MobEffects.MOVEMENT_SPEED, 450, 0));

    public static final Supplier<Item> HEALTH_CANDY = registerItem("health_candy",
            () -> new Candy(new Item.Properties().stacksTo(32).food(new FoodProperties.Builder().fast().nutrition(2).build()), MobEffects.REGENERATION, 450, 0));

    public static final Supplier<Item> FIRE_RESISTANCE_CANDY = registerItem("fire_resistance_candy",
            () -> new Candy(new Item.Properties().stacksTo(32).food(new FoodProperties.Builder().fast().nutrition(2).build()), MobEffects.FIRE_RESISTANCE, 450, 0));

    public static final Supplier<Item> WATER_BREATHING_CANDY = registerItem("water_breathing_candy",
            () -> new Candy(new Item.Properties().stacksTo(32).food(new FoodProperties.Builder().fast().nutrition(2).build()), MobEffects.WATER_BREATHING, 450, 0));

    public static final Supplier<Item> NIGHT_VISION_CANDY = registerItem("night_vision_candy",
            () -> new Candy(new Item.Properties().stacksTo(32).food(new FoodProperties.Builder().fast().nutrition(2).build()), MobEffects.NIGHT_VISION, 450, 0));


    public static final Supplier<Item> RANDOM_CANDY = registerItem("candies_basket",
            () -> new CandyBasket(new Item.Properties().stacksTo(1).durability(1)));

    public static void init(){}


    public static Supplier<Item> registerItem(String id, Supplier<Item> item) {
        return Services.PLATFORM.registerItem(id, item);
    }
}
