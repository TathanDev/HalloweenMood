package fr.tathan.halloween_mood.registries;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;


public class TabsRegistry {

    public static final CreativeModeTab HALLOWEEN_TAB = new CreativeModeTab("halloween_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemsRegistry.SPEED_CANDY.get());
        }
    };



}
