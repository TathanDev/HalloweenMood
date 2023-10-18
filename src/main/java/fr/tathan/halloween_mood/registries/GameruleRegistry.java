package fr.tathan.halloween_mood.registries;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.level.GameRules;

public class GameruleRegistry {

    public static final GameRules.Key<GameRules.BooleanValue> IS_HALLOWEEN =
            GameRuleRegistry.register("isHalloween", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true));

    public static void init() {}
}
