package fr.tathan.halloween_mood.registries;

import fr.tathan.halloween_mood.HalloweenMood;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundsRegistry   {


        public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, HalloweenMood.MODID);

        /**
         * SOUNDS
         */
        public static final RegistryObject<SoundEvent> DEMONIC_LAUGH = SOUNDS.register("demonic_laugh", () -> new SoundEvent(new ResourceLocation(HalloweenMood.MODID, "demonic_laugh")));

}
