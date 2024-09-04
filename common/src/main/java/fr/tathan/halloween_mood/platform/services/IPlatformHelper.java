package fr.tathan.halloween_mood.platform.services;

import fr.tathan.halloween_mood.HalloweenMoodCommon;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.nio.file.Path;
import java.util.function.Supplier;

public interface IPlatformHelper {

    /**
     * Gets the name of the current platform
     *
     * @return The name of the current platform.
     */
    String getPlatformName();

    /**
     * Checks if a mod with the given id is loaded.
     *
     * @param modId The mod to check if it is loaded.
     * @return True if the mod is loaded, false otherwise.
     */
    boolean isModLoaded(String modId);

    /**
     * Check if the game is currently in a development environment.
     *
     * @return True if in a development environment, false otherwise.
     */
    boolean isDevelopmentEnvironment();

    /**
     * Gets the name of the environment type as a string.
     *
     * @return The name of the environment type.
     */
    default String getEnvironmentName() {

        return isDevelopmentEnvironment() ? "development" : "production";
    }

    Path getConfigPath();


    /**
     *
     * @author HyperPigeon
     * This part of the code was made by HyperPigeon for MoreTotemsOfUndying under the MIT license
     */
    <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item);

    <T extends CreativeModeTab> Supplier<T> registerCreativeTab(String id, Supplier<T> tab);

    SimpleParticleType registerSimpleParticle(String id, boolean overTime);


    CreativeModeTab.Builder newCreativeTabBuilder();
}