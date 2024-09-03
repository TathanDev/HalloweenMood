package fr.tathan.halloween_mood;


import fr.tathan.halloween_mood.common.world.village.VillageAdditions;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(HalloweenMoodCommon.MOD_ID)
public class HalloweenMood {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, HalloweenMoodCommon.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HalloweenMoodCommon.MOD_ID);


    public HalloweenMood(IEventBus eventBus) {

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.
        HalloweenMoodCommon.LOG.info("Hello NeoForge world!");
        HalloweenMoodCommon.init();
        ITEMS.register(eventBus);
        CREATIVE_TAB.register(eventBus);
    }


    @EventBusSubscriber(modid = HalloweenMoodCommon.MOD_ID)
    public class Event {

        @SubscribeEvent
        public static void addNewVillageBuilding(final ServerAboutToStartEvent event) {
            Registry<StructureTemplatePool> templatePoolRegistry = event.getServer().registryAccess().registry(Registries.TEMPLATE_POOL).orElseThrow();
            Registry<StructureProcessorList> processorListRegistry = event.getServer().registryAccess().registry(Registries.PROCESSOR_LIST).orElseThrow();

            VillageAdditions.addNewVillage(templatePoolRegistry, processorListRegistry);
        }
    }
}