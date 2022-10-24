package fr.tathan.halloween_mood;

import com.mojang.logging.LogUtils;

import fr.tathan.halloween_mood.registries.ItemsRegistry;
import fr.tathan.halloween_mood.registries.SoundsRegistry;
import fr.tathan.halloween_mood.util.ModTags;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(HalloweenMood.MODID)
public class HalloweenMood {


    public static final String MODID = "halloween_mood";
    private static final Logger LOGGER = LogUtils.getLogger();

    public HalloweenMood()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::commonSetup);

        ItemsRegistry.ITEMS.register(bus);

        SoundsRegistry.SOUNDS.register(bus);





        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("Your server get Halloweened !");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("Hello " + Minecraft.getInstance().getUser().getName());
            LOGGER.info("Your client get Halloweened !");




        }

        /**
         *TODO
         * REWORK "FEAR" SYSTEM
         * FIX THE SERVER STARTING PROBLEM WITCH MIXIN
         * BETTER TEXTURES FOR CANDIES
         * MAKE CUSTOM HOUSES (Pumpkin, Witch Hat, etc...)
         * ----------------------Finished------------------------
         * TRADE WITH VILLAGERS FOR CANDIES ✅
         * MAKE A COMPAT WITH THE OTHER MODS (Patchouli, Tips, etc...) ✅
         * Candies (Speed, Health) ✅
         * TRY ON SERVER ✅
         * Fix Advancement Textures
         * Capabilities/command for HalloweenMood ✅
         * Change the sugar cane texture ✅
         * STRUCTURES (BigPumpkin) ✅
         * Make the Moon less orange ✅
         * NEW NAMES FOR CANDIES ✅
         * Add chests in the structures (with random items) ✅
         * CHANGES STRUCTURES (Str void, decorated houses, haunted houses...) ✅
         * Random Candies Item ✅
         */

    }
}
