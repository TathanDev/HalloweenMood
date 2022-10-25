package fr.tathan.halloween_mood.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {

    public static final ForgeConfigSpec CONFIG;
    private static final ForgeConfigSpec.Builder CONFIG_BUILDER = new ForgeConfigSpec.Builder();

    static {
        init(CONFIG_BUILDER);
        CONFIG = CONFIG_BUILDER.build();
    }

    public static ForgeConfigSpec.ConfigValue<Boolean> commandsNeedOp;

    public static void init(ForgeConfigSpec.Builder builder) {
        commandsNeedOp = builder.comment("Set this to true to let only ops enable or disable halloween difficulty. Useful for multiplayer servers.").define("commands_need_op", false);
    }
}
