package fr.tathan.halloween_mood;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;
import fr.tathan.halloween_mood.common.config.CustomConfig;
import fr.tathan.halloween_mood.common.registries.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HalloweenMoodCommon {

    public static final String MOD_ID = "halloween_mood";
    public static final String MOD_NAME = "Halloween Mood";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    public static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
            .create();

    public static void init() {

        TagsRegistry.init();
        ParticleRegistry.init();
        CustomConfig.init();
        ItemsRegistry.init();
        GameruleRegistry.init();
        TabsRegistry.init();

    }

}
