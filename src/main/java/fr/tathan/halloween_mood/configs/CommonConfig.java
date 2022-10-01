package fr.tathan.halloween_mood.configs;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> PUMPKIN_ON_JOIN;




    static {
        BUILDER.push("Halloween Mood Config");

        PUMPKIN_ON_JOIN = BUILDER.comment("Do you want to play with a pumpkin?").define("Pumpkin Mod", true);
        //CUSTOMEMENU = BUILDER.comment("Should the menu need to be change ?\nDefault = true (Boolean").define("Custom Screen", true);


        BUILDER.pop();
        SPEC = BUILDER.build();

    }


}
