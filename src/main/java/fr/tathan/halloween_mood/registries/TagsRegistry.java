package fr.tathan.halloween_mood.registries;


import fr.tathan.halloween_mood.HalloweenMood;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TagsRegistry {

    public static final TagKey<Item> CANDIES_TAG = tag("candies");
    public static final TagKey<Item> AGAINST_FEAR = tag("against_fear");

    private static void init() {}


    private static TagKey<Item> tag(String name)
    {
        return TagKey.create(Registries.ITEM, new ResourceLocation(HalloweenMood.MODID, name));
    }
}
