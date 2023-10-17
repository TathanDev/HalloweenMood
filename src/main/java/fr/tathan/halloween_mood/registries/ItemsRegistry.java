package fr.tathan.halloween_mood.registries;

import fr.tathan.halloween_mood.HalloweenMood;
import fr.tathan.halloween_mood.items.Candy;
import fr.tathan.halloween_mood.items.CandyBasket;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class ItemsRegistry {

    public static final Item  SPEED_CANDY = registerItem("speed_candy",
            new Candy(new FabricItemSettings().stacksTo(32).food(new FoodProperties.Builder().fast().nutrition(2).saturationMod(0.2F).build()), MobEffects.MOVEMENT_SPEED, 450, 0));

    public static final Item  HEALTH_CANDY = registerItem("health_candy",
            new Candy(new FabricItemSettings().stacksTo(32).food(new FoodProperties.Builder().fast().nutrition(2).saturationMod(0.2F).build()), MobEffects.REGENERATION, 450, 0));

    public static final Item  FIRE_RESISTANCE_CANDY = registerItem("fire_resistance_candy",
            new Candy(new FabricItemSettings().stacksTo(32).food(new FoodProperties.Builder().fast().nutrition(2).saturationMod(0.2F).build()), MobEffects.FIRE_RESISTANCE, 450, 0));

    public static final Item  WATER_BREATHING_CANDY = registerItem("water_breathing_candy",
            new Candy(new FabricItemSettings().stacksTo(32).food(new FoodProperties.Builder().fast().nutrition(2).saturationMod(0.2F).build()), MobEffects.WATER_BREATHING, 450, 0));

    public static final Item  NIGHT_VISION_CANDY = registerItem("night_vision_candy",
            new Candy(new FabricItemSettings().stacksTo(32).food(new FoodProperties.Builder().fast().nutrition(2).saturationMod(0.2F).build()), MobEffects.NIGHT_VISION, 450, 0));


    public static final Item  RANDOM_CANDY = registerItem("candies_basket",
            new CandyBasket(new FabricItemSettings().stacksTo(1).durability(1).defaultDurability(1)));




    public static Item registerItem(String key, Item item) {
        return registerItem(ResourceKey.create(BuiltInRegistries.ITEM.key(), new ResourceLocation(HalloweenMood.MODID, key)), item);
    }

    public static Item registerItem(ResourceKey<Item> key, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).registerBlocks(Item.BY_BLOCK, item);
        }

        return (Item)Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    public static void init(){

    }
}
