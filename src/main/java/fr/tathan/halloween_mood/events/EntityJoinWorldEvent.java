package fr.tathan.halloween_mood.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;

public interface EntityJoinWorldEvent {
    Event<EntityJoinWorldEvent> EVENT = EventFactory.createArrayBacked(EntityJoinWorldEvent.class,
            (listeners) -> (player, level) -> {
        for (EntityJoinWorldEvent listener : listeners) {
            InteractionResult result = listener.joinWorld(player, level);

            if(result != InteractionResult.PASS) {
                return result;
            }
        }

        return InteractionResult.PASS;
    });

    InteractionResult joinWorld(Player player, ServerLevel level);
}

