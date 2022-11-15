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
        commandsNeedOp = builder.comment("Set this to true to let only ops enable or disable halloween difficulty. Useful for multiplayer servers.").define("CommandsNeedOp", true);
        pumpkinOnHead = builder.comment("Set this to true to set a pumpkin on the head of the player who is in Halloween Difficulty.").define("PumpkinOnHead", true);

        halloweenNether = builder.comment("Set this to true if you want to be 'afraid' in the nether.").define("HalloweenInNether", true);
        halloweenEnd = builder.comment("Set this to true if you want to be 'afraid' in the end.").define("HalloweenInEnd", true);
        maledictaIntegration = builder.comment("Set this to true if you want to have a little chance that when you eat a candy, one of your item became curse. Only work if Maledicta is installed").define("MaledictaIntegration", true);
        maledictaIntegrationPourcent = builder.comment("If Maledicta Integration is set to true, choose the pourcent of chance that a player have to get one of his items cursed when he eat a candy").defineInRange("MaledictaIntegrationPourcent",3, 1, 100);

    }
}
