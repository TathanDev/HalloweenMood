package fr.tathan.halloween_mood;

import fr.tathan.halloween_mood.config.HalloweenConfig;
import fr.tathan.halloween_mood.events.PlayerTickEvent;
import fr.tathan.halloween_mood.registries.GameruleRegistry;
import fr.tathan.halloween_mood.registries.ItemsRegistry;
import fr.tathan.halloween_mood.utils.EventMethods;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityEvent;
import net.minecraft.world.level.block.state.BlockState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HalloweenMood implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("halloween_mood");
	public static final String MODID = "halloween_mood";

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ItemsRegistry.init();
		GameruleRegistry.init();
		HalloweenConfig.init();
		EventMethods.initEvents();
	}

}