package fr.tathan.halloween_mood;

import fr.tathan.halloween_mood.registries.ItemsRegistry;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HalloweenMood implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("halloween_mood");
	public static final String MODID = "halloween_mood";

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ItemsRegistry.init();
	}
}