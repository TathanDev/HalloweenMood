package fr.tathan.halloween_mood.mixin;

import fr.tathan.halloween_mood.common.particles.FallingLeavesParticle;
import fr.tathan.halloween_mood.common.registries.ParticleRegistry;
import net.minecraft.client.particle.CherryParticle;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ParticleEngine.class)
public abstract class ParticleEngineRegistryMixin implements PreparableReloadListener {

    @Shadow protected abstract <T extends ParticleOptions> void register(ParticleType<T> pParticleType, ParticleEngine.SpriteParticleRegistration<T> pParticleMetaFactory);

    public ParticleEngineRegistryMixin() {
        super();
    }

    @Inject(method = "registerProviders", at = @At(value = "RETURN"))
    public void animateTick(CallbackInfo ci) {
        this.register(ParticleRegistry.FALLING_LEAVES.get(), (ParticleEngine.SpriteParticleRegistration)((p_277215_) -> {
            return (p_277217_, p_277218_, p_277219_, p_277220_, p_277221_, p_277222_, p_277223_, p_277224_) -> {
                return new FallingLeavesParticle(p_277218_, p_277219_, p_277220_, p_277221_, p_277215_);
            };
        }));

    }
}
