package fr.tathan.halloween_mood.registries;

import fr.tathan.halloween_mood.HalloweenMood;
import fr.tathan.halloween_mood.items.CandiesBook;
import fr.tathan.halloween_mood.items.candies.FireResistanceCandy;
import fr.tathan.halloween_mood.items.candies.HealthCandy;
import fr.tathan.halloween_mood.items.candies.RandomCandy;
import fr.tathan.halloween_mood.items.candies.SpeedCandy;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemsRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HalloweenMood.MODID);


    public static final RegistryObject<Item> SPEED_CANDY = ITEMS.register("speed_candy",
            () -> new SpeedCandy(new Item.Properties().tab(TabsRegistry.HALLOWEEN_TAB).food(new FoodProperties.Builder().fast().nutrition(2).saturationMod(0.2F).build()).stacksTo(16)));

    public static final RegistryObject<Item> HEALTH_CANDY = ITEMS.register("health_candy",
            () -> new HealthCandy(new Item.Properties().tab(TabsRegistry.HALLOWEEN_TAB).food(new FoodProperties.Builder().fast().nutrition(2).saturationMod(0.2F).build()).stacksTo(16)));

    public static final RegistryObject<Item> FIRE_RESISTANCE_CANDY = ITEMS.register("fire_resistance_candy",
            () -> new FireResistanceCandy(new Item.Properties().tab(TabsRegistry.HALLOWEEN_TAB).food(new FoodProperties.Builder().fast().nutrition(2).saturationMod(0.2F).build()).stacksTo(16)));


    public static final RegistryObject<Item> RANDOM_CANDY = ITEMS.register("random_candy",
            () -> new RandomCandy(new Item.Properties().tab(TabsRegistry.HALLOWEEN_TAB).stacksTo(16).durability(1)));

    public static final RegistryObject<Item> CANDIES_BOOK = ITEMS.register("candies_book",
            () -> new CandiesBook(new Item.Properties().tab(TabsRegistry.HALLOWEEN_TAB).stacksTo(1)));




}
