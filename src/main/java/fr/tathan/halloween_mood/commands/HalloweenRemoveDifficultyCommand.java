package fr.tathan.halloween_mood.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fr.tathan.halloween_mood.HalloweenMood;
import fr.tathan.halloween_mood.difficulty.LevelDifficulty;
import fr.tathan.halloween_mood.difficulty.LevelDifficultyProvider;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;

public class HalloweenRemoveDifficultyCommand {

    public HalloweenRemoveDifficultyCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("halloween").then(Commands.literal("stop").executes((Command) -> {

            return stopHalloween(Command.getSource());
        })));
    }

    private int stopHalloween(CommandSourceStack source)  throws CommandSyntaxException {
        ServerPlayer player = source.getPlayer();
        ServerLevel level = source.getLevel();
        LevelDifficulty levelDifficulty = level.getCapability(LevelDifficultyProvider.LEVEL_DIFFICULTY).orElseThrow(() -> new CommandSyntaxException(null, null));
        levelDifficulty.removeHalloween();

        player.displayClientMessage(DIFFICULTY_FALSE, false);
        player.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
        level.setDayTime(1000);
        level.setThunderLevel(0.0F);





        return 0;
    }

    public static final Component DIFFICULTY_FALSE = tl(".difficulty.false");


    public static Component tl(String text) {
        return Component.translatable("message." + HalloweenMood.MODID + text);
    }

}


