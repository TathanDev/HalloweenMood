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
    public static ForgeConfigSpec.ConfigValue<Boolean> pumpkinOnHead;

    public static ForgeConfigSpec.ConfigValue<Boolean> halloweenNether;
    public static ForgeConfigSpec.ConfigValue<Boolean> halloweenEnd;
    public static ForgeConfigSpec.ConfigValue<Boolean> maledictaIntegration;
    public static ForgeConfigSpec.ConfigValue<Integer> maledictaIntegrationPourcent;




    public static void init(ForgeConfigSpec.Builder builder) {
        builder.push("Miscellaneous");
        commandsNeedOp = builder.comment("Set this to true to let only ops enable or disable halloween difficulty. Useful for multiplayer servers.").define("CommandsNeedOp", true);
        pumpkinOnHead = builder.comment("Set this to true to set a pumpkin on the head of the player who is in Halloween Difficulty.").define("PumpkinOnHead", true);
        builder.pop();

        builder.push("Difficulty");
        halloweenNether = builder.comment("Set this to true if you want to be 'afraid' in the nether.").define("HalloweenInNether", true);
        halloweenEnd = builder.comment("Set this to true if you want to be 'afraid' in the end.").define("HalloweenInEnd", true);

    }
}
