package fr.tathan.halloween_mood.registries;

import fr.tathan.halloween_mood.HalloweenMood;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TabsRegistry {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HalloweenMood.MODID);

    public static final RegistryObject<CreativeModeTab> HALLOWEEN_TAB = CREATIVE_MODE_TABS.register("halloween_mood",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemsRegistry.FIRE_RESISTANCE_CANDY.get()))
                    .title(Component.literal("Halloween Mood"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ItemsRegistry.HEALTH_CANDY.get());
                        pOutput.accept(ItemsRegistry.FIRE_RESISTANCE_CANDY.get());
                        pOutput.accept(ItemsRegistry.NIGHT_VISION_CANDY.get());
                        pOutput.accept(ItemsRegistry.SPEED_CANDY.get());
                        pOutput.accept(ItemsRegistry.RANDOM_CANDY.get());
                        pOutput.accept(ItemsRegistry.WATER_BREATHING_CANDY.get());
                        pOutput.accept(ItemsRegistry.CANDIES_BOOK.get());

                    })
                    .build());


}