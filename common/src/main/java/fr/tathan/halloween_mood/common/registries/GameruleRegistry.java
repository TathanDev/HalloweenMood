package fr.tathan.halloween_mood.common.registries;

import net.minecraft.world.level.GameRules;

public class GameruleRegistry {

    public static GameRules.Key<GameRules.BooleanValue> HALLOWEEN_GAMERULE = GameRules.register("halloween_enable", GameRules.Category.MISC, GameRules.BooleanValue.create(true));

    public static void init() {}
}
