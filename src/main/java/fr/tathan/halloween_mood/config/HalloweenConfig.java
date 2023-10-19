package fr.tathan.halloween_mood.config;

import fr.tathan.halloween_mood.HalloweenMood;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config.Gui.Background("minecraft:textures/block/pumpkin.png")
@Config(name = "halloween_mood")
public class HalloweenConfig implements ConfigData {

    public static boolean pumpkinOnHead;

    @Comment("Should the player have fear in the nether ?")
    public static boolean halloweenNether;
    @Comment("Should the player have fear in the End ?")
    public static boolean halloweenEnd;

    @Override
    public void validatePostLoad() throws ValidationException {
        HalloweenMood.LOGGER.debug("REGISTERING CONFIG");
    }
}
