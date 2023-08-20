package fr.tathan.halloween_mood.registries;

import fr.tathan.halloween_mood.HalloweenMood;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HalloweenMood.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TabsRegistry {

    public static CreativeModeTab HALLOWEEN_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        HALLOWEEN_TAB = event.registerCreativeModeTab(new ResourceLocation(HalloweenMood.MODID, "tutorial_tab"),
                builder -> builder.icon(() -> new ItemStack(ItemsRegistry.HEALTH_CANDY.get()))
                        .title(Component.literal("Halloween Mood")));
    }



}
