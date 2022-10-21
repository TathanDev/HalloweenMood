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

    public static class Items {

        public static final TagKey<Item> CANDIES_TAG = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(HalloweenMood.MODID, "candies"));

    }

}
