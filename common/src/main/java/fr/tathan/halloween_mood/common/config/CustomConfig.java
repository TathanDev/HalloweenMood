package fr.tathan.halloween_mood.common.config;

import com.google.gson.JsonObject;
import fr.tathan.halloween_mood.HalloweenMoodCommon;
import fr.tathan.halloween_mood.platform.Services;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CustomConfig {

    public static Map<String, ConfigEntry<?>> CONFIG = new HashMap<>();

    public static void init() {
        var needReload = loadConfigFile();
        addEntries();
        writeConfigFile("halloween-mood.json");

        if(needReload) {
            loadConfigFile();
        }
    }


    public static void addEntries() {

        addEntry("pumpkinOnHead", new ConfigEntry<>(true, "Set this to true to set a pumpkin on the head of the player who is in Halloween Difficulty"));
        addEntry("halloweenNether", new ConfigEntry<>(true, "Set this to true if you want to be 'afraid' in the nether."));
        addEntry("halloweenEnd ", new ConfigEntry<>(true, "Set this to true if you want to be 'afraid' in the end."));
        addEntry("witchHouseWeight ", new ConfigEntry<>(250, "Set this to the weight of the witch house in villages."));
        addEntry("fallingLeaves ", new ConfigEntry<>(true, "Set this to true if you want to have falling Leaves."));

    }

    public static void addEntry(String name, ConfigEntry<?> entry) {
        CONFIG.merge(name, entry, (a, b) -> new ConfigEntry<>(a.value(), b.description()));
    }

    public static void writeConfigFile(String path) {
        try {
            FileWriter file = new FileWriter(Services.PLATFORM.getConfigPath() + "/" + path);
            file.write(HalloweenMoodCommon.GSON.toJson(CONFIG));
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean loadConfigFile() {

        String path = Services.PLATFORM.getConfigPath() + "/halloween-mood.json";

        String jsonString;
        try {
            jsonString = readFileAsString(path);

            if(jsonString == null) return true;

            JsonObject jsonObject = HalloweenMoodCommon.GSON.fromJson(jsonString, JsonObject.class);

            jsonObject.getAsJsonObject().entrySet().forEach(entry -> {
                ConfigEntry<?> obj2 = HalloweenMoodCommon.GSON.fromJson(entry.getValue(), ConfigEntry.class);
                CONFIG.put(entry.getKey(), obj2);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String readFileAsString(String file) throws Exception {

        String fileContent;
        try  {
            fileContent = new String(Files.readAllBytes(Paths.get(file)));
        } catch (Exception e) {
            HalloweenMoodCommon.LOG.error("No config file. Creating it !");
            fileContent = new String(Files.readAllBytes(Paths.get(file)));

        }

        return fileContent;
    }

    public static Object getValue(String key) {
        return CONFIG.get(key).value();
    }
}