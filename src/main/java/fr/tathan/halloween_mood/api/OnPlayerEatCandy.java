package fr.tathan.halloween_mood.api;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ItemSteerable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class OnPlayerEatCandy extends PlayerEvent {

    public Level level;
    public Player player;
    public MobEffect effect;
    public ItemStack stack;

    /**
     * This event is called when a player eats a candy. It is executed twice
     * @param player
     * @param level
     * @param effect
     */
    public OnPlayerEatCandy(Player player, Level level, MobEffect effect, ItemStack stack) {
        super(player);
        this.level = level;
        this.player = player;
        this.stack = stack;
    }

    public Player getPlayer() {
        return player;
    }

    public Level getLevel() {
        return level;
    }

    public MobEffect getEffect() {
        return effect;
    }

    public ItemStack getStack() {
        return stack;
    }
}
