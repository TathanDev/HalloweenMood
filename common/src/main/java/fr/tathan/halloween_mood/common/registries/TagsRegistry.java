package fr.tathan.halloween_mood.common.registries;

import fr.tathan.halloween_mood.HalloweenMoodCommon;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagsRegistry {

    public static void init() {}

    public static final TagKey<Item> CANDIES_TAG = tagItem("candies");
    public static final TagKey<Item> AGAINST_FEAR = tagItem("against_fear");

    public static final TagKey<Block> NO_FALLING_LEAVES = tagBlock("no_falling_leaves");

    private static TagKey<Item> tagItem(String name)
    {
        return TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(HalloweenMoodCommon.MOD_ID, name));
    }

    private static TagKey<Block> tagBlock(String name)
    {
        return TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(HalloweenMoodCommon.MOD_ID, name));
    }
}
