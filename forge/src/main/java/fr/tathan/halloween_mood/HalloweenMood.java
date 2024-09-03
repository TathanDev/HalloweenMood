package fr.tathan.halloween_mood;

import fr.tathan.halloween_mood.common.world.village.VillageAdditions;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;

@Mod(HalloweenMoodCommon.MOD_ID)
public class HalloweenMood {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, HalloweenMoodCommon.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HalloweenMoodCommon.MOD_ID);


    public HalloweenMood() {

        HalloweenMoodCommon.LOG.info("Hello Forge world!");
        HalloweenMoodCommon.init();
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        CREATIVE_TAB.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    @Mod.EventBusSubscriber(modid = HalloweenMoodCommon.MOD_ID)
    public class Event {

        @SubscribeEvent
        public static void addNewVillageBuilding(final ServerAboutToStartEvent event) {
            Registry<StructureTemplatePool> templatePoolRegistry = event.getServer().registryAccess().registry(Registries.TEMPLATE_POOL).orElseThrow();
            Registry<StructureProcessorList> processorListRegistry = event.getServer().registryAccess().registry(Registries.PROCESSOR_LIST).orElseThrow();

            VillageAdditions.addNewVillage(templatePoolRegistry, processorListRegistry);
        }
    }
}