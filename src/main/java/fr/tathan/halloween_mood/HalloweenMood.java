package fr.tathan.halloween_mood;

import com.mojang.logging.LogUtils;
import fr.tathan.halloween_mood.configs.CommonConfig;
import fr.tathan.halloween_mood.registries.ItemsRegistry;
import fr.tathan.halloween_mood.registries.SoundsRegistry;
import fr.tathan.halloween_mood.registries.TabsRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::commonSetup);

        ItemsRegistry.ITEMS.register(bus);

        SoundsRegistry.SOUNDS.register(bus);





        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC, "halloween_mood-common.toml");

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
         * Change the sugar cane texture
         * Make the Moon less orange
         * REWORK "FEAR" SYSTEM
         * RANDOM CANDY
         * STRUCTURES (BigPumpkin)
         * MAKE A COMPAT WITH THE OTHER MODS (Like Beyond Earth)
         * TRADE WITH VILLAGERS FOR CANDIES ✅
         * Candies (Speed, Health) ✅
         * TRY ON SERVER ✅
         * Capabilities/command for HalloweenMood ✅
         */

    }
}
