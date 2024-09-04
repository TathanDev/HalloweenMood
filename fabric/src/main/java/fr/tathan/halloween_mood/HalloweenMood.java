package fr.tathan.halloween_mood;

import fr.tathan.halloween_mood.common.world.village.VillageAdditions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class HalloweenMood implements ModInitializer {

    @Override
    public void onInitialize() {

        HalloweenMoodCommon.LOG.info("Hello Fabric world!");
        HalloweenMoodCommon.init();

        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            Registry<StructureTemplatePool> templatePoolRegistry = server.registryAccess().registry(Registries.TEMPLATE_POOL).orElseThrow();
            Registry<StructureProcessorList> processorListRegistry = server.registryAccess().registry(Registries.PROCESSOR_LIST).orElseThrow();

            VillageAdditions.addNewVillage(templatePoolRegistry, processorListRegistry);

        });
    }
}