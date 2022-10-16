package fr.tathan.halloween_mood.registries;

import fr.tathan.halloween_mood.HalloweenMood;
import fr.tathan.halloween_mood.items.CandiesBook;
import fr.tathan.halloween_mood.items.Candy;
import fr.tathan.halloween_mood.items.RandomCandy;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemsRegistry {


    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HalloweenMood.MODID);


    public static final RegistryObject<Item> SPEED_CANDY = ITEMS.register("speed_candy",
            () -> new Candy(new Item.Properties().tab(TabsRegistry.HALLOWEEN_TAB).stacksTo(1).food(new FoodProperties.Builder().fast().nutrition(2).saturationMod(0.2F).build()), MobEffects.MOVEMENT_SPEED, 450, 0));

    public static final RegistryObject<Item> HEALTH_CANDY = ITEMS.register("health_candy",
            () -> new Candy(new Item.Properties().tab(TabsRegistry.HALLOWEEN_TAB).stacksTo(1).food(new FoodProperties.Builder().fast().nutrition(2).saturationMod(0.2F).build()), MobEffects.HEALTH_BOOST, 450, 0));

    public static final RegistryObject<Item> FIRE_RESISTANCE_CANDY = ITEMS.register("fire_resistance_candy",
            () -> new Candy(new Item.Properties().tab(TabsRegistry.HALLOWEEN_TAB).stacksTo(1).food(new FoodProperties.Builder().fast().nutrition(2).saturationMod(0.2F).build()), MobEffects.FIRE_RESISTANCE, 450, 0));

    public static final RegistryObject<Item> WATER_BREATHING_CANDY = ITEMS.register("water_breathing_candy",
            () -> new Candy(new Item.Properties().tab(TabsRegistry.HALLOWEEN_TAB).stacksTo(1).food(new FoodProperties.Builder().fast().nutrition(2).saturationMod(0.2F).build()), MobEffects.WATER_BREATHING, 450, 0));

    /**
    public static final RegistryObject<Item> RANDOM_CANDY = ITEMS.register("random_candy",
            () -> new RandomCandy(new Item.Properties().tab(TabsRegistry.HALLOWEEN_TAB).stacksTo(16).durability(1)));
    */

    public static final RegistryObject<Item> CANDIES_BOOK = ITEMS.register("candies_book",
            () -> new CandiesBook(new Item.Properties().tab(TabsRegistry.HALLOWEEN_TAB).stacksTo(1)));


    /**
    public static final RegistryObject<Item> test = ITEMS.register("test",
            () -> new Candy(new Item.Properties().tab(TabsRegistry.HALLOWEEN_TAB).stacksTo(1).food(new FoodProperties.Builder().fast().nutrition(2).saturationMod(0.2F).build()), MobEffects.MOVEMENT_SPEED, 10000, 30));
    */



}
