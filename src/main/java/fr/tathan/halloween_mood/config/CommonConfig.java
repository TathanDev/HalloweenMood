package fr.tathan.halloween_mood.config;

import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;

public class CommonConfig {

    public static final ForgeConfigSpec CONFIG;
    private static final ForgeConfigSpec.Builder CONFIG_BUILDER = new ForgeConfigSpec.Builder();

    static {
        init(CONFIG_BUILDER);
        CONFIG = CONFIG_BUILDER.build();
    }

    public static ForgeConfigSpec.BooleanValue commandsNeedOp;
    public static ForgeConfigSpec.BooleanValue pumpkinOnHead;
    public static ForgeConfigSpec.IntValue witchHouseWeight;

    public static ForgeConfigSpec.BooleanValue halloweenNether;
    public static ForgeConfigSpec.BooleanValue halloweenEnd;
    public static ForgeConfigSpec.ConfigValue<Integer> villagerLevelForTrades;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> tradersList;



    public static void init(ForgeConfigSpec.Builder builder) {
        builder.push("Miscellaneous");
        commandsNeedOp = builder.comment("Set this to true to let only ops enable or disable halloween difficulty. Useful for multiplayer servers.").define("CommandsNeedOp", true);
        pumpkinOnHead = builder.comment("Set this to true to set a pumpkin on the head of the player who is in Halloween Difficulty.").define("PumpkinOnHead", true);
        witchHouseWeight = builder.comment("Set this to the weight of the witch house in villages.").defineInRange("WitchHouseWeight", 250, 1, 1000);
        builder.pop();

        builder.push("Difficulty");
        halloweenNether = builder.comment("Set this to true if you want to be 'afraid' in the nether.").define("HalloweenInNether", true);
        halloweenEnd = builder.comment("Set this to true if you want to be 'afraid' in the end.").define("HalloweenInEnd", true);
        builder.pop();

        builder.push("Villager");
        tradersList = builder.comment("Which villagers should trade halloween loot").defineList("TradersList", Arrays.asList("weaponsmith", "toolsmith", "armorer", "butcher", "leatherworker", "cartographer", "fisherman", "cleric", "farmer", "fletcher", "librarian", "mason", "nitwit", "shepherd"), entry -> true);
        villagerLevelForTrades = builder.comment("Set this to the minimum level for trades with villagers.").defineInRange("VillagerLevelForTrades", 1, 1, 5);
        builder.pop();
    }
}
