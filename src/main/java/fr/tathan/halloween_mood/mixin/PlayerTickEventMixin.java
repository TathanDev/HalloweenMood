package fr.tathan.halloween_mood.mixin;

import fr.tathan.halloween_mood.events.PlayerTickEvent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class PlayerTickEventMixin {

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void onPlayerTick(CallbackInfo info) {
        // Get the player instance
        Player player = (Player)(Object)this;
        InteractionResult result = PlayerTickEvent.EVENT.invoker().interact(player);

        if(result == InteractionResult.FAIL) {
            info.cancel();
        }
    }
}
