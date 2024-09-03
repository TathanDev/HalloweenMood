package fr.tathan.halloween_mood.common.registries;

import fr.tathan.halloween_mood.HalloweenMoodCommon;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TagsRegistry {

    private static void init() {}

    public static final TagKey<Item> CANDIES_TAG = tag("candies");
    public static final TagKey<Item> AGAINST_FEAR = tag("against_fear");


    private static TagKey<Item> tag(String name)
    {
        return TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(HalloweenMoodCommon.MOD_ID, name));
    }
}
