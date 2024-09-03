package fr.tathan.halloween_mood.common.registries;

import fr.tathan.halloween_mood.platform.Services;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class TabsRegistry {

    public static final Supplier<CreativeModeTab> HALLOWEEN_TAB = registerTab("halloween_mood",
            () -> Services.PLATFORM.newCreativeTabBuilder().icon(() -> new ItemStack(ItemsRegistry.FIRE_RESISTANCE_CANDY.get()))
                    .title(Component.literal("Halloween Mood"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ItemsRegistry.HEALTH_CANDY.get());
                        pOutput.accept(ItemsRegistry.FIRE_RESISTANCE_CANDY.get());
                        pOutput.accept(ItemsRegistry.NIGHT_VISION_CANDY.get());
                        pOutput.accept(ItemsRegistry.SPEED_CANDY.get());
                        pOutput.accept(ItemsRegistry.RANDOM_CANDY.get());
                        pOutput.accept(ItemsRegistry.WATER_BREATHING_CANDY.get());

                    })
                    .build());

    public static void init() {}

    public static Supplier<CreativeModeTab> registerTab(String id, Supplier<CreativeModeTab> item) {
        return Services.PLATFORM.registerCreativeTab(id, item);
    }
}
