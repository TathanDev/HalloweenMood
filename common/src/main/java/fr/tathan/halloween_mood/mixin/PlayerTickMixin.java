package fr.tathan.halloween_mood.mixin;

import fr.tathan.halloween_mood.common.config.CustomConfig;
import fr.tathan.halloween_mood.common.registries.GameruleRegistry;
import fr.tathan.halloween_mood.common.registries.TagsRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerTickMixin {

    @Inject(method = "tick", at = @At("RETURN"))
    private void postTick(CallbackInfo ci) {
        Player player = (Player) (Object) this;

        Level level = player.level();
        ItemStack mainHand = player.getMainHandItem();

        ItemStack offHand = player.getOffhandItem();

        if (level.getGameRules().getBoolean(GameruleRegistry.HALLOWEEN_GAMERULE)) {
            if (level.isNight()) {
                if (!player.isCreative() && !player.isSpectator())
                    if (player.getBlockStateOn().getLightEmission() <= 2) {
                        if (player.level().dimension().equals(Level.END) && !(boolean) CustomConfig.getValue("halloweenEnd")) {
                            return;
                        }
                        if (player.level().dimension().equals(Level.NETHER) && !(boolean) CustomConfig.getValue("halloweenNether")) {
                            return;
                        }
                        if (mainHand.is(TagsRegistry.AGAINST_FEAR) || offHand.is(TagsRegistry.AGAINST_FEAR)) {
                            return;
                        }

                        player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 45, 1));
                    }
            }

        }

    }

}
