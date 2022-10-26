package fr.tathan.halloween_mood;

import com.mojang.logging.LogUtils;

import fr.tathan.halloween_mood.pack.PackLoader;
import fr.tathan.halloween_mood.config.CommonConfig;
import fr.tathan.halloween_mood.registries.ItemsRegistry;
import fr.tathan.halloween_mood.registries.SoundsRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
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
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.CONFIG);
        
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::commonSetup);
        bus.addListener(this::discoverResourcePacks);

        ItemsRegistry.ITEMS.register(bus);

        SoundsRegistry.SOUNDS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);

        PackLoader.loadOnInitialStartup();
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    public void discoverResourcePacks(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            event.addRepositorySource(new PackLoader(ModList.get().getModFileById(MODID).getFile()));
        }
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
         * Add Witch House for differents biome
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
