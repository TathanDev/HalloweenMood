package fr.tathan.halloween_mood.util;

import fr.tathan.halloween_mood.HalloweenMood;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTags {

    public static void init() {
        Items.init();
    }

    public static class Items {

        private static void init() {}

        public static final TagKey<Item> CANDIES_TAG = tag("candies");
        public static final TagKey<Item> AGAINST_FEAR = tag("against_fear");


        private static TagKey<Item> tag(String name)
        {
            return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(HalloweenMood.MODID, name));
        }
    }


}
