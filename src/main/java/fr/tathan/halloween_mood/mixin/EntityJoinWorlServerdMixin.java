package fr.tathan.halloween_mood.mixin;

import fr.tathan.halloween_mood.events.EntityJoinWorldEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerLevel.class)
public abstract class EntityJoinWorlServerdMixin {

    @Inject(method = "addPlayer", at = @At("HEAD"), cancellable = true)
    private void entityJoinWorld(ServerPlayer player, CallbackInfo info) {
        // Get the player instance
        ServerLevel level = (ServerLevel) (Object) this;
        InteractionResult result = EntityJoinWorldEvent.EVENT.invoker().joinWorld(player, level);

        if (result == InteractionResult.FAIL) {
            info.cancel();
        }
    }
}
