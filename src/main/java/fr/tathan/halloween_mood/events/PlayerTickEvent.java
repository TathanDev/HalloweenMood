package fr.tathan.halloween_mood.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;

public interface PlayerTickEvent {
    Event<PlayerTickEvent> EVENT = EventFactory.createArrayBacked(PlayerTickEvent.class,
            (listeners) -> (player) -> {
        for (PlayerTickEvent listener : listeners) {
            InteractionResult result = listener.interact(player);

            if(result != InteractionResult.PASS) {
                return result;
            }
        }

        return InteractionResult.PASS;
    });

    InteractionResult interact(Player player);
}

