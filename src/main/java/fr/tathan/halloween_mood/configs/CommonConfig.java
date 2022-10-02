package fr.tathan.halloween_mood.configs;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> HALLOWEEN_MOD;




    static {
        BUILDER.push("Halloween Mood Config");

        HALLOWEEN_MOD = BUILDER
                .comment("Do you want to enable the Halloween mod ?\nFeatures:\n- Always have a pumkin on your head\n- When it's night, you will be afraid...")
                .define("Halloween Mod", true);





        BUILDER.pop();
        SPEC = BUILDER.build();

    }


}
