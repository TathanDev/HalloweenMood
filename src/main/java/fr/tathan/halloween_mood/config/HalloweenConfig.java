package fr.tathan.halloween_mood.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

@Config(name = "halloween_mood")
@Config.Gui.Background("minecraft:textures/block/carved_pumpkin.png")
public class HalloweenConfig implements ConfigData {

    public static HalloweenConfig CONFIG;
    @ConfigEntry.Category("general")
    public static boolean commandsNeedOp;
    public static boolean pumpkinOnHead;

    public static boolean halloweenNether;
    public static boolean halloweenEnd;
    public static boolean maledictaIntegration;
    public static int maledictaIntegrationPourcent;

    public static void init() {
        AutoConfig.register(HalloweenConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(HalloweenConfig.class).getConfig();
    }


}
