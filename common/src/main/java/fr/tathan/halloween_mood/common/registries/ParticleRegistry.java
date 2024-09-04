package fr.tathan.halloween_mood.common.registries;

import fr.tathan.halloween_mood.HalloweenMoodCommon;
import fr.tathan.halloween_mood.common.items.Candy;
import fr.tathan.halloween_mood.common.items.CandyBasket;
import fr.tathan.halloween_mood.platform.Services;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ParticleRegistry {

    private static final RegistrationProvider<ParticleType<?>> PARTICLE_TYPES = RegistrationProvider.get(Registries.PARTICLE_TYPE, HalloweenMoodCommon.MOD_ID);

    public static final Supplier<SimpleParticleType> FALLING_LEAVES = register("falling_leaves", false);

    public static void init() {

    }

    private static Supplier<SimpleParticleType> register(String name, boolean alwaysShow) {
        return PARTICLE_TYPES.register(name, () -> Services.PLATFORM.registerSimpleParticle(name, alwaysShow));
    }

}
