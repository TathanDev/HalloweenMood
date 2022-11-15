package fr.tathan.halloween_mood.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fr.tathan.halloween_mood.HalloweenMood;
import fr.tathan.halloween_mood.config.CommonConfig;
import fr.tathan.halloween_mood.difficulty.LevelDifficulty;
import fr.tathan.halloween_mood.difficulty.LevelDifficultyProvider;
import fr.tathan.halloween_mood.registries.SoundsRegistry;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.dimension.LevelStem;

import java.awt.*;

public class HalloweenSetDifficultyCommand {

    public HalloweenSetDifficultyCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        boolean everyoneCanRunCommand = !CommonConfig.commandsNeedOp.get();
        dispatcher.register(Commands.literal("halloween").then(Commands.literal("start").requires(c -> everyoneCanRunCommand || c.hasPermission(2)).executes((Command) -> {

            return startHalloween(Command.getSource());
        })));
    }

    private int startHalloween(CommandSourceStack source)  throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        ServerLevel level = source.getLevel();

        LevelDifficulty netherDifficulty = player.getServer().getLevel(Level.NETHER).getCapability(LevelDifficultyProvider.LEVEL_DIFFICULTY).orElseThrow(() -> new CommandSyntaxException(null, null));
        LevelDifficulty endDifficulty = player.getServer().getLevel(Level.END).getCapability(LevelDifficultyProvider.LEVEL_DIFFICULTY).orElseThrow(() -> new CommandSyntaxException(null, null));
        LevelDifficulty overworldDifficulty = player.getServer().getLevel(Level.OVERWORLD).getCapability(LevelDifficultyProvider.LEVEL_DIFFICULTY).orElseThrow(() -> new CommandSyntaxException(null, null));


        if (level == player.getServer().getLevel(Level.OVERWORLD)) {
            netherDifficulty.setHalloween();

            endDifficulty.setHalloween();

        } else if (level == player.getServer().getLevel(Level.NETHER)){

            overworldDifficulty.setHalloween();

            endDifficulty.setHalloween();

        } else if (level == player.getServer().getLevel(Level.END)) {

            overworldDifficulty.setHalloween();

            netherDifficulty.setHalloween();

        }

        LevelDifficulty levelDifficulty = level.getCapability(LevelDifficultyProvider.LEVEL_DIFFICULTY).orElseThrow(() -> new CommandSyntaxException(null, null));
        levelDifficulty.setHalloween();


        level.setThunderLevel(1.0F);


        ItemStack PUMPKIN = new ItemStack(Items.CARVED_PUMPKIN);

        if(CommonConfig.pumpkinOnHead.get()) {
            PUMPKIN.enchant(Enchantments.BINDING_CURSE, 1);
            player.setItemSlot(EquipmentSlot.HEAD, PUMPKIN);
        }


        if(level.getAllEntities() instanceof Player player1) {
            player.setItemSlot(EquipmentSlot.HEAD, PUMPKIN);

        }

        player.displayClientMessage(DIFFICULTY_TRUE, false);

        level.setDayTime(14000);



        return 0;
    }

    public static final Component DIFFICULTY_TRUE = tl(".difficulty.true");
    public static final Component DIFFICULTY_FALSE = tl("difficulty.false");


    public static Component tl(String text) {
        return Component.translatable("message." + HalloweenMood.MODID + text);
    }


}


